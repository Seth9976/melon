package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DefaultDatagramChannelConfig;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

final class DefaultOioDatagramChannelConfig extends DefaultDatagramChannelConfig implements OioDatagramChannelConfig {
    public DefaultOioDatagramChannelConfig(DatagramChannel datagramChannel0, DatagramSocket datagramSocket0) {
        super(datagramChannel0, datagramSocket0);
        this.setAllocator(new PreferHeapByteBufAllocator(this.getAllocator()));
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        return channelOption0 == ChannelOption.SO_TIMEOUT ? this.getSoTimeout() : super.getOption(channelOption0);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(super.getOptions(), new ChannelOption[]{ChannelOption.SO_TIMEOUT});
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public int getSoTimeout() {
        try {
            return this.javaSocket().getSoTimeout();
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        super.setAllocator(byteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setBroadcast(boolean z) {
        return this.setBroadcast(z);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setBroadcast(boolean z) {
        super.setBroadcast(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setConnectTimeoutMillis(int v) {
        super.setConnectTimeoutMillis(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setInterface(InetAddress inetAddress0) {
        return this.setInterface(inetAddress0);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setInterface(InetAddress inetAddress0) {
        super.setInterface(inetAddress0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z) {
        return this.setLoopbackModeDisabled(z);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setLoopbackModeDisabled(boolean z) {
        super.setLoopbackModeDisabled(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setMaxMessagesPerRead(int v) {
        super.setMaxMessagesPerRead(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        super.setMessageSizeEstimator(messageSizeEstimator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface0) {
        return this.setNetworkInterface(networkInterface0);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface0) {
        super.setNetworkInterface(networkInterface0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        this.validate(channelOption0, object0);
        if(channelOption0 == ChannelOption.SO_TIMEOUT) {
            this.setSoTimeout(((int)(((Integer)object0))));
            return true;
        }
        return super.setOption(channelOption0, object0);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReceiveBufferSize(int v) {
        return this.setReceiveBufferSize(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setReceiveBufferSize(int v) {
        super.setReceiveBufferSize(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        return this.setRecvByteBufAllocator(recvByteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        super.setRecvByteBufAllocator(recvByteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReuseAddress(boolean z) {
        return this.setReuseAddress(z);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setReuseAddress(boolean z) {
        super.setReuseAddress(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setSendBufferSize(int v) {
        return this.setSendBufferSize(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setSendBufferSize(int v) {
        super.setSendBufferSize(v);
        return this;
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setSoTimeout(int v) {
        try {
            this.javaSocket().setSoTimeout(v);
            return this;
        }
        catch(IOException iOException0) {
            throw new ChannelException(iOException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTimeToLive(int v) {
        return this.setTimeToLive(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setTimeToLive(int v) {
        super.setTimeToLive(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTrafficClass(int v) {
        return this.setTrafficClass(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setTrafficClass(int v) {
        super.setTrafficClass(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setWriteBufferHighWaterMark(int v) {
        return this.setWriteBufferHighWaterMark(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setWriteBufferHighWaterMark(int v) {
        super.setWriteBufferHighWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setWriteBufferLowWaterMark(int v) {
        super.setWriteBufferLowWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        super.setWriteBufferWaterMark(writeBufferWaterMark0);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig, io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.oio.OioDatagramChannelConfig
    public OioDatagramChannelConfig setWriteSpinCount(int v) {
        super.setWriteSpinCount(v);
        return this;
    }
}

