package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DefaultServerSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannelConfig;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

@Deprecated
public class DefaultOioServerSocketChannelConfig extends DefaultServerSocketChannelConfig implements OioServerSocketChannelConfig {
    @Deprecated
    public DefaultOioServerSocketChannelConfig(ServerSocketChannel serverSocketChannel0, ServerSocket serverSocket0) {
        super(serverSocketChannel0, serverSocket0);
        this.setAllocator(new PreferHeapByteBufAllocator(this.getAllocator()));
    }

    public DefaultOioServerSocketChannelConfig(OioServerSocketChannel oioServerSocketChannel0, ServerSocket serverSocket0) {
        super(oioServerSocketChannel0, serverSocket0);
        this.setAllocator(new PreferHeapByteBufAllocator(this.getAllocator()));
    }

    @Override  // io.netty.channel.DefaultChannelConfig
    public void autoReadCleared() {
        Channel channel0 = this.channel;
        if(channel0 instanceof OioServerSocketChannel) {
            ((OioServerSocketChannel)channel0).clearReadPending0();
        }
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        return channelOption0 == ChannelOption.SO_TIMEOUT ? this.getSoTimeout() : super.getOption(channelOption0);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(super.getOptions(), new ChannelOption[]{ChannelOption.SO_TIMEOUT});
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public int getSoTimeout() {
        try {
            return this.javaSocket.getSoTimeout();
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        super.setAllocator(byteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setBacklog(int v) {
        return this.setBacklog(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setBacklog(int v) {
        super.setBacklog(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setConnectTimeoutMillis(int v) {
        super.setConnectTimeoutMillis(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    @Deprecated
    public ServerSocketChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    @Deprecated
    public OioServerSocketChannelConfig setMaxMessagesPerRead(int v) {
        super.setMaxMessagesPerRead(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        super.setMessageSizeEstimator(messageSizeEstimator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        this.validate(channelOption0, object0);
        if(channelOption0 == ChannelOption.SO_TIMEOUT) {
            this.setSoTimeout(((int)(((Integer)object0))));
            return true;
        }
        return super.setOption(channelOption0, object0);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setPerformancePreferences(int v, int v1, int v2) {
        return this.setPerformancePreferences(v, v1, v2);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setPerformancePreferences(int v, int v1, int v2) {
        super.setPerformancePreferences(v, v1, v2);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setReceiveBufferSize(int v) {
        return this.setReceiveBufferSize(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setReceiveBufferSize(int v) {
        super.setReceiveBufferSize(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        super.setRecvByteBufAllocator(recvByteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setReuseAddress(boolean z) {
        return this.setReuseAddress(z);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setReuseAddress(boolean z) {
        super.setReuseAddress(z);
        return this;
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setSoTimeout(int v) {
        try {
            this.javaSocket.setSoTimeout(v);
            return this;
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setWriteBufferHighWaterMark(int v) {
        super.setWriteBufferHighWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setWriteBufferLowWaterMark(int v) {
        super.setWriteBufferLowWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        super.setWriteBufferWaterMark(writeBufferWaterMark0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.oio.OioServerSocketChannelConfig
    public OioServerSocketChannelConfig setWriteSpinCount(int v) {
        super.setWriteSpinCount(v);
        return this;
    }
}

