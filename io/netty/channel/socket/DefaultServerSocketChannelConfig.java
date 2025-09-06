package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.ServerChannelRecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Map;

public class DefaultServerSocketChannelConfig extends DefaultChannelConfig implements ServerSocketChannelConfig {
    private volatile int backlog;
    protected final ServerSocket javaSocket;

    public DefaultServerSocketChannelConfig(ServerSocketChannel serverSocketChannel0, ServerSocket serverSocket0) {
        super(serverSocketChannel0, new ServerChannelRecvByteBufAllocator());
        this.backlog = NetUtil.SOMAXCONN;
        this.javaSocket = (ServerSocket)ObjectUtil.checkNotNull(serverSocket0, "javaSocket");
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public int getBacklog() {
        return this.backlog;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        if(channelOption0 == ChannelOption.SO_RCVBUF) {
            return this.getReceiveBufferSize();
        }
        if(channelOption0 == ChannelOption.SO_REUSEADDR) {
            return Boolean.valueOf(this.isReuseAddress());
        }
        return channelOption0 == ChannelOption.SO_BACKLOG ? this.getBacklog() : super.getOption(channelOption0);
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(super.getOptions(), new ChannelOption[]{ChannelOption.SO_RCVBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_BACKLOG});
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        super.setAllocator(byteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setBacklog(int v) {
        ObjectUtil.checkPositiveOrZero(v, "backlog");
        this.backlog = v;
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setConnectTimeoutMillis(int v) {
        super.setConnectTimeoutMillis(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    @Deprecated
    public ServerSocketChannelConfig setMaxMessagesPerRead(int v) {
        super.setMaxMessagesPerRead(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        super.setMessageSizeEstimator(messageSizeEstimator0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        this.validate(channelOption0, object0);
        if(channelOption0 == ChannelOption.SO_RCVBUF) {
            this.setReceiveBufferSize(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.SO_REUSEADDR) {
            this.setReuseAddress(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.SO_BACKLOG) {
            this.setBacklog(((int)(((Integer)object0))));
            return true;
        }
        return super.setOption(channelOption0, object0);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setPerformancePreferences(int v, int v1, int v2) {
        this.javaSocket.setPerformancePreferences(v, v1, v2);
        return this;
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setReceiveBufferSize(int v) {
        try {
            this.javaSocket.setReceiveBufferSize(v);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        super.setRecvByteBufAllocator(recvByteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setReuseAddress(boolean z) {
        try {
            this.javaSocket.setReuseAddress(z);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteBufferHighWaterMark(int v) {
        super.setWriteBufferHighWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteBufferLowWaterMark(int v) {
        super.setWriteBufferLowWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        super.setWriteBufferWaterMark(writeBufferWaterMark0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.ServerSocketChannelConfig
    public ServerSocketChannelConfig setWriteSpinCount(int v) {
        super.setWriteSpinCount(v);
        return this;
    }
}

