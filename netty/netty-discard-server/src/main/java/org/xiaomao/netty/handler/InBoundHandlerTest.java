package org.xiaomao.netty.handler;

import java.util.concurrent.TimeUnit;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.ScheduledFuture;

public class InBoundHandlerTest extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		// start a counting task, alert every five seconds
		ScheduledFuture<?> future = ctx.channel().eventLoop().scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("5 seconds past!");
			}
		}, 3, 5, TimeUnit.SECONDS);

		ctx.fireChannelActive();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		System.out.println("Server received: " + msg);
		ctx.write(Unpooled.copiedBuffer("Ack", CharsetUtil.UTF_8));
		ctx.flush();
		ctx.fireChannelRead(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		// System.out.println("read complete");
		ctx.fireChannelReadComplete();
		// ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
	}

}
