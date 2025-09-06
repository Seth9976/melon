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
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.DuplexChannelConfig;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

@Deprecated
public class DefaultOioSocketChannelConfig extends DefaultSocketChannelConfig implements OioSocketChannelConfig {
    @Deprecated
    public DefaultOioSocketChannelConfig(SocketChannel socketChannel0, Socket socket0) {
        super(socketChannel0, socket0);
        this.setAllocator(new PreferHeapByteBufAllocator(this.getAllocator()));
    }

    public DefaultOioSocketChannelConfig(OioSocketChannel oioSocketChannel0, Socket socket0) {
        super(oioSocketChannel0, socket0);
        this.setAllocator(new PreferHeapByteBufAllocator(this.getAllocator()));
    }

    @Override  // io.netty.channel.DefaultChannelConfig
    public void autoReadCleared() {
        Channel channel0 = this.channel;
        if(channel0 instanceof OioSocketChannel) {
            ((OioSocketChannel)channel0).clearReadPending0();
        }
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        return channelOption0 == ChannelOption.SO_TIMEOUT ? this.getSoTimeout() : super.getOption(channelOption0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(super.getOptions(), new ChannelOption[]{ChannelOption.SO_TIMEOUT});
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public int getSoTimeout() {
        try {
            return this.javaSocket.getSoTimeout();
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        super.setAllocator(byteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAllowHalfClosure(boolean z) {
        return this.setAllowHalfClosure(z);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAllowHalfClosure(boolean z) {
        return this.setAllowHalfClosure(z);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setAllowHalfClosure(boolean z) {
        super.setAllowHalfClosure(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setConnectTimeoutMillis(int v) {
        super.setConnectTimeoutMillis(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setKeepAlive(boolean z) {
        return this.setKeepAlive(z);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setKeepAlive(boolean z) {
        super.setKeepAlive(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    @Deprecated
    public DuplexChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    @Deprecated
    public SocketChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    @Deprecated
    public OioSocketChannelConfig setMaxMessagesPerRead(int v) {
        super.setMaxMessagesPerRead(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        super.setMessageSizeEstimator(messageSizeEstimator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        this.validate(channelOption0, object0);
        if(channelOption0 == ChannelOption.SO_TIMEOUT) {
            this.setSoTimeout(((int)(((Integer)object0))));
            return true;
        }
        return super.setOption(channelOption0, object0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setPerformancePreferences(int v, int v1, int v2) {
        return this.setPerformancePreferences(v, v1, v2);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setPerformancePreferences(int v, int v1, int v2) {
        super.setPerformancePreferences(v, v1, v2);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReceiveBufferSize(int v) {
        return this.setReceiveBufferSize(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setReceiveBufferSize(int v) {
        super.setReceiveBufferSize(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        super.setRecvByteBufAllocator(recvByteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setReuseAddress(boolean z) {
        return this.setReuseAddress(z);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setReuseAddress(boolean z) {
        super.setReuseAddress(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSendBufferSize(int v) {
        return this.setSendBufferSize(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setSendBufferSize(int v) {
        super.setSendBufferSize(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setSoLinger(int v) {
        return this.setSoLinger(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setSoLinger(int v) {
        super.setSoLinger(v);
        return this;
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setSoTimeout(int v) {
        try {
            this.javaSocket.setSoTimeout(v);
            return this;
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTcpNoDelay(boolean z) {
        return this.setTcpNoDelay(z);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setTcpNoDelay(boolean z) {
        super.setTcpNoDelay(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setTrafficClass(int v) {
        return this.setTrafficClass(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setTrafficClass(int v) {
        super.setTrafficClass(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig
    public SocketChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setWriteBufferHighWaterMark(int v) {
        super.setWriteBufferHighWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig
    public SocketChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setWriteBufferLowWaterMark(int v) {
        super.setWriteBufferLowWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        super.setWriteBufferWaterMark(writeBufferWaterMark0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    public DuplexChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
    public SocketChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.oio.OioSocketChannelConfig
    public OioSocketChannelConfig setWriteSpinCount(int v) {
        super.setWriteSpinCount(v);
        return this;
    }
}

