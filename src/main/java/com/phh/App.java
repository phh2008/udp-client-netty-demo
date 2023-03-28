package com.phh;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class App {

    public static void main(String[] args) throws InterruptedException {
        String port = "6315";
        if (args.length > 0) {
            port = args[0];
        }
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new UdpClientHandler());
        System.out.println("port:" + port);
        bootstrap.bind(Integer.parseInt(port));
    }

}
