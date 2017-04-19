/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.xiaomao.netty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handler implementation for the echo client. It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

	public static final byte[] bHeader = new byte[] { 0x00, 0x00, (byte) 0xFF }; // 指令头
	public static final byte[] bFooter = new byte[] { 0x00 }; // 指令结束

	private byte[] cmdCode;
	private byte[] cmdData;

	// 心跳指令
	// 0x00,0x00,0xFF,0x01,0x00,0x09,0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x00,0x52,0x00,
	// 请求固件包
	// 0x00,0x00,0xFF,0x9F,0x00,0x08,0x00,0x01,0x00,0x00,0x00,0x00,0x00,0x00,0xD8,0x00,
	// 请求安卓固件包
	// 0x00,0x00,0xFF,0x9F,0x00,0x08,0x30,0x31,0x30,0x30,0x30,0x30,0x30,0x30,0xD8,0x00,

	/**
	 * Creates a client-side handler.
	 */
	public EchoClientHandler() {
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		byte[] cmd = readCmd();
		ByteBuf buf = Unpooled.buffer(cmd.length);
		for (int i = 0; i < buf.capacity(); i++) {
			buf.writeByte((cmd[i]));
		}
		ctx.writeAndFlush(buf);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		if (cmdCode[0] == (byte) 0xA0) {
			// 读取返回的数据
			ByteBuf msgBuf = (ByteBuf) msg;
			msgBuf.readerIndex(18);
			byte[] dst = new byte[msgBuf.readableBytes() - 2];
			msgBuf.readBytes(dst);
			System.out.println(dst);

			// The name of the file to open.
			String dir = "D:\\temp\\";
			String file = dir + "file1.txt";

			try {
				// 设置append为true，保证文件不会被重写
				FileOutputStream outStream = new FileOutputStream(file, true);
				outStream.write(dst);
				outStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 读取新命令
		byte[] cmd = readCmd();
		ByteBuf buf = Unpooled.buffer(cmd.length);
		for (int i = 0; i < buf.capacity(); i++) {
			buf.writeByte((cmd[i]));
		}
		ctx.write(buf);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		// channelActive(ctx);
		ctx.close();
	}

	public byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 5];
		for (int i = 0; i < len; i += 5) {
			data[i / 5] = (byte) ((Character.digit(s.charAt(i + 2), 16) << 4) + Character.digit(s.charAt(i + 3), 16));
		}
		return data;
	}

	public byte[] readBytesArr() {
		try {
			InputStream is = System.in;
			InputStreamReader read = new InputStreamReader(is, "utf-8");

			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			lineTxt = bufferedReader.readLine();
			// read.close();
			// is.close();
			byte[] byteArr = hexStringToByteArray(lineTxt);
			return byteArr;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public byte[] readCmd() {
		System.out.println("请输入命令码：");
		cmdCode = readBytesArr();
		System.out.println("请输入命令数据：");
		cmdData = readBytesArr();
		byte[] cmd = combineCommand(cmdCode[0], cmdData);
		return cmd;
	}

	/**
	 * 组合指令
	 */
	public static byte[] combineCommand(byte code, byte[] data) {
		return combineCommand(code, int2bytes2(data.length), data);
	}

	private static byte[] combineCommand(byte code, byte[] datalen, byte[] data) {
		byte checkCode = calCheckCode(code, datalen, data);
		byte[] result = new byte[bHeader.length + bFooter.length + 1 + datalen.length + data.length + 1];

		System.arraycopy(bHeader, 0, result, 0, bHeader.length); // 指令头
		result[bHeader.length] = code; // 指令代码
		System.arraycopy(datalen, 0, result, bHeader.length + 1, datalen.length); // 数据域长度
		System.arraycopy(data, 0, result, bHeader.length + datalen.length + 1, data.length); // 数据域
		result[bHeader.length + datalen.length + data.length + 1] = checkCode; // 校验码
		System.arraycopy(bFooter, 0, result, bHeader.length + datalen.length + data.length + 2, bFooter.length); // 结束符

		return result;
	}

	/**
	 * 计算校验码
	 */
	private static byte calCheckCode(byte bcode, byte[] bdatalen, byte[] bdata) {
		int result = bcode;
		if (bdatalen != null) {
			for (byte b : bdatalen) {
				result += b;
			}
		}
		if (bdata != null) {
			for (byte b : bdata) {
				result += b;
			}
		}
		return (byte) (256 - result % 256);
	}

	/**
	 * 将int转为两个字节的bytes
	 */
	public static byte[] int2bytes2(int n) {
		byte[] ab = new byte[2];
		ab[0] = (byte) ((0xff00 & n) >> 8);
		ab[1] = (byte) (0xff & n);
		return ab;
	}
}
