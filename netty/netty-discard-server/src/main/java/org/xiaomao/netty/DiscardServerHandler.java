package org.xiaomao.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		// Discard the received data silently.
		// ((ByteBuf) msg).release(); // (3)
		ByteBuf in = (ByteBuf) msg;
		try {
			while (in.isReadable()) { // (1)
				char c = (char) in.readByte();
				System.out.print(c);
				// System.out.flush();
				ctx.write(c);
				ctx.flush();
			}
		} finally {
			ReferenceCountUtil.release(msg); // (2)
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}

}
