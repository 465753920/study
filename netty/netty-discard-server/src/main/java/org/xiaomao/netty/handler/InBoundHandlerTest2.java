package org.xiaomao.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InBoundHandlerTest2 extends ChannelInboundHandlerAdapter {
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ctx.write("b");
		ctx.flush();
        ctx.fireChannelRead(msg);
    }

}
