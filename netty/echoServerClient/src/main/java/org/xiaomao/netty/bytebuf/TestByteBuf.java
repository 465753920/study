package org.xiaomao.netty.bytebuf;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class TestByteBuf {

	@Test
	public void test1() {
		ByteBuf bf = Unpooled.buffer();
		bf.writeBytes(new byte[] { 'a', 'b', 'c', 'd' });
		byte[] dst = new byte[bf.readableBytes()];
		bf.getBytes(bf.readerIndex(), dst, 0, bf.readableBytes());
		for (byte b : dst) {
			System.out.println((char) b);
		}
	}

}
