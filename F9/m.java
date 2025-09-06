package f9;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public final class m extends ChannelInitializer {
    @Override  // io.netty.channel.ChannelInitializer
    public final void initChannel(Channel channel0) {
        ((SocketChannel)channel0).pipeline().addLast(new ChannelHandler[]{new p(), new l()});  // 初始化器: Lio/netty/handler/stream/ChunkedWriteHandler;-><init>()V
    }
}

