package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

public class DefaultSocketChannelConfig extends DefaultChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;
    protected final Socket javaSocket;

    public DefaultSocketChannelConfig(SocketChannel socketChannel0, Socket socket0) {
        super(socketChannel0);
        this.javaSocket = (Socket)ObjectUtil.checkNotNull(socket0, "javaSocket");
        if(PlatformDependent.canEnableTcpNoDelayByDefault()) {
            try {
                this.setTcpNoDelay(true);
            }
            catch(Exception unused_ex) {
            }
        }
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        if(channelOption0 == ChannelOption.SO_RCVBUF) {
            return this.getReceiveBufferSize();
        }
        if(channelOption0 == ChannelOption.SO_SNDBUF) {
            return this.getSendBufferSize();
        }
        if(channelOption0 == ChannelOption.TCP_NODELAY) {
            return Boolean.valueOf(this.isTcpNoDelay());
        }
        if(channelOption0 == ChannelOption.SO_KEEPALIVE) {
            return Boolean.valueOf(this.isKeepAlive());
        }
        if(channelOption0 == ChannelOption.SO_REUSEADDR) {
            return Boolean.valueOf(this.isReuseAddress());
        }
        if(channelOption0 == ChannelOption.SO_LINGER) {
            return this.getSoLinger();
        }
        if(channelOption0 == ChannelOption.IP_TOS) {
            return this.getTrafficClass();
        }
        return channelOption0 == ChannelOption.ALLOW_HALF_CLOSURE ? Boolean.valueOf(this.isAllowHalfClosure()) : super.getOption(channelOption0);
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(super.getOptions(), new ChannelOption[]{ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE});
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return this.javaSocket.getSoLinger();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return this.javaSocket.getKeepAlive();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return this.javaSocket.getTcpNoDelay();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        super.setAllocator(byteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAllowHalfClosure(boolean z) {
        return this.setAllowHalfClosure(z);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAllowHalfClosure(boolean z) {
        this.allowHalfClosure = z;
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setConnectTimeoutMillis(int v) {
        super.setConnectTimeoutMillis(v);
        return this;
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setKeepAlive(boolean z) {
        try {
            this.javaSocket.setKeepAlive(z);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    @Deprecated
    public DuplexChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    @Deprecated
    public SocketChannelConfig setMaxMessagesPerRead(int v) {
        super.setMaxMessagesPerRead(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
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
        if(channelOption0 == ChannelOption.SO_SNDBUF) {
            this.setSendBufferSize(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.TCP_NODELAY) {
            this.setTcpNoDelay(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.SO_KEEPALIVE) {
            this.setKeepAlive(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.SO_REUSEADDR) {
            this.setReuseAddress(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.SO_LINGER) {
            this.setSoLinger(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.IP_TOS) {
            this.setTrafficClass(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.ALLOW_HALF_CLOSURE) {
            this.setAllowHalfClosure(((Boolean)object0).booleanValue());
            return true;
        }
        return super.setOption(channelOption0, object0);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setPerformancePreferences(int v, int v1, int v2) {
        this.javaSocket.setPerformancePreferences(v, v1, v2);
        return this;
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReceiveBufferSize(int v) {
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

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        super.setRecvByteBufAllocator(recvByteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReuseAddress(boolean z) {
        try {
            this.javaSocket.setReuseAddress(z);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSendBufferSize(int v) {
        try {
            this.javaSocket.setSendBufferSize(v);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSoLinger(int v) {
        try {
            if(v < 0) {
                this.javaSocket.setSoLinger(false, 0);
                return this;
            }
            this.javaSocket.setSoLinger(true, v);
            return this;
        }
        catch(SocketException socketException0) {
        }
        throw new ChannelException(socketException0);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTcpNoDelay(boolean z) {
        try {
            this.javaSocket.setTcpNoDelay(z);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTrafficClass(int v) {
        try {
            this.javaSocket.setTrafficClass(v);
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

    public SocketChannelConfig setWriteBufferHighWaterMark(int v) {
        super.setWriteBufferHighWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    public SocketChannelConfig setWriteBufferLowWaterMark(int v) {
        super.setWriteBufferLowWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        super.setWriteBufferWaterMark(writeBufferWaterMark0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setWriteSpinCount(int v) {
        super.setWriteSpinCount(v);
        return this;
    }
}

