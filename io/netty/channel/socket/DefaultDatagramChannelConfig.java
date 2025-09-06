package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Map;

public class DefaultDatagramChannelConfig extends DefaultChannelConfig implements DatagramChannelConfig {
    private volatile boolean activeOnOpen;
    private final DatagramSocket javaSocket;
    private static final InternalLogger logger;

    static {
        DefaultDatagramChannelConfig.logger = InternalLoggerFactory.getInstance(DefaultDatagramChannelConfig.class);
    }

    public DefaultDatagramChannelConfig(DatagramChannel datagramChannel0, DatagramSocket datagramSocket0) {
        super(datagramChannel0, new FixedRecvByteBufAllocator(0x800));
        this.javaSocket = (DatagramSocket)ObjectUtil.checkNotNull(datagramSocket0, "javaSocket");
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public InetAddress getInterface() {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                return ((MulticastSocket)datagramSocket0).getInterface();
            }
            catch(SocketException socketException0) {
                throw new ChannelException(socketException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                return ((MulticastSocket)datagramSocket0).getNetworkInterface();
            }
            catch(SocketException socketException0) {
                throw new ChannelException(socketException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        if(channelOption0 == ChannelOption.SO_BROADCAST) {
            return Boolean.valueOf(this.isBroadcast());
        }
        if(channelOption0 == ChannelOption.SO_RCVBUF) {
            return this.getReceiveBufferSize();
        }
        if(channelOption0 == ChannelOption.SO_SNDBUF) {
            return this.getSendBufferSize();
        }
        if(channelOption0 == ChannelOption.SO_REUSEADDR) {
            return Boolean.valueOf(this.isReuseAddress());
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_LOOP_DISABLED) {
            return Boolean.valueOf(this.isLoopbackModeDisabled());
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_ADDR) {
            return this.getInterface();
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_IF) {
            return this.getNetworkInterface();
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_TTL) {
            return this.getTimeToLive();
        }
        if(channelOption0 == ChannelOption.IP_TOS) {
            return this.getTrafficClass();
        }
        return channelOption0 == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION ? Boolean.valueOf(this.activeOnOpen) : super.getOption(channelOption0);
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map getOptions() {
        return this.getOptions(super.getOptions(), new ChannelOption[]{ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION});
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public int getTimeToLive() {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                return ((MulticastSocket)datagramSocket0).getTimeToLive();
            }
            catch(IOException iOException0) {
                throw new ChannelException(iOException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public boolean isBroadcast() {
        try {
            return this.javaSocket.getBroadcast();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                return ((MulticastSocket)datagramSocket0).getLoopbackMode();
            }
            catch(SocketException socketException0) {
                throw new ChannelException(socketException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    public final DatagramSocket javaSocket() {
        return this.javaSocket;
    }

    private void setActiveOnOpen(boolean z) {
        if(this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = z;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        return this.setAllocator(byteBufAllocator0);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator0) {
        super.setAllocator(byteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoClose(boolean z) {
        return this.setAutoClose(z);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setAutoClose(boolean z) {
        super.setAutoClose(z);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setBroadcast(boolean z) {
        try {
            if(z && !this.javaSocket.getLocalAddress().isAnyLocalAddress()) {
                DefaultDatagramChannelConfig.logger.warn("A non-root user can\'t receive a broadcast packet if the socket is not bound to a wildcard address; setting the SO_BROADCAST flag anyway as requested on the socket which is bound to " + this.javaSocket.getLocalSocketAddress() + '.');
            }
            this.javaSocket.setBroadcast(z);
            return this;
        }
        catch(SocketException socketException0) {
        }
        throw new ChannelException(socketException0);
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setConnectTimeoutMillis(int v) {
        return this.setConnectTimeoutMillis(v);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setConnectTimeoutMillis(int v) {
        super.setConnectTimeoutMillis(v);
        return this;
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setInterface(InetAddress inetAddress0) {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                ((MulticastSocket)datagramSocket0).setInterface(inetAddress0);
                return this;
            }
            catch(SocketException socketException0) {
                throw new ChannelException(socketException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z) {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                ((MulticastSocket)datagramSocket0).setLoopbackMode(z);
                return this;
            }
            catch(SocketException socketException0) {
                throw new ChannelException(socketException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public ChannelConfig setMaxMessagesPerRead(int v) {
        return this.setMaxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    @Deprecated
    public DatagramChannelConfig setMaxMessagesPerRead(int v) {
        super.setMaxMessagesPerRead(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig
    public ChannelConfig setMaxMessagesPerWrite(int v) {
        return this.setMaxMessagesPerWrite(v);
    }

    public DatagramChannelConfig setMaxMessagesPerWrite(int v) {
        super.setMaxMessagesPerWrite(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        return this.setMessageSizeEstimator(messageSizeEstimator0);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator0) {
        super.setMessageSizeEstimator(messageSizeEstimator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface0) {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                ((MulticastSocket)datagramSocket0).setNetworkInterface(networkInterface0);
                return this;
            }
            catch(SocketException socketException0) {
                throw new ChannelException(socketException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        this.validate(channelOption0, object0);
        if(channelOption0 == ChannelOption.SO_BROADCAST) {
            this.setBroadcast(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.SO_RCVBUF) {
            this.setReceiveBufferSize(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.SO_SNDBUF) {
            this.setSendBufferSize(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.SO_REUSEADDR) {
            this.setReuseAddress(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_LOOP_DISABLED) {
            this.setLoopbackModeDisabled(((Boolean)object0).booleanValue());
            return true;
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_ADDR) {
            this.setInterface(((InetAddress)object0));
            return true;
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_IF) {
            this.setNetworkInterface(((NetworkInterface)object0));
            return true;
        }
        if(channelOption0 == ChannelOption.IP_MULTICAST_TTL) {
            this.setTimeToLive(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.IP_TOS) {
            this.setTrafficClass(((int)(((Integer)object0))));
            return true;
        }
        if(channelOption0 == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            this.setActiveOnOpen(((Boolean)object0).booleanValue());
            return true;
        }
        return super.setOption(channelOption0, object0);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReceiveBufferSize(int v) {
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

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator0) {
        super.setRecvByteBufAllocator(recvByteBufAllocator0);
        return this;
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReuseAddress(boolean z) {
        try {
            this.javaSocket.setReuseAddress(z);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setSendBufferSize(int v) {
        try {
            this.javaSocket.setSendBufferSize(v);
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTimeToLive(int v) {
        DatagramSocket datagramSocket0 = this.javaSocket;
        if(datagramSocket0 instanceof MulticastSocket) {
            try {
                ((MulticastSocket)datagramSocket0).setTimeToLive(v);
                return this;
            }
            catch(IOException iOException0) {
                throw new ChannelException(iOException0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTrafficClass(int v) {
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

    public DatagramChannelConfig setWriteBufferHighWaterMark(int v) {
        super.setWriteBufferHighWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferLowWaterMark(int v) {
        return this.setWriteBufferLowWaterMark(v);
    }

    public DatagramChannelConfig setWriteBufferLowWaterMark(int v) {
        super.setWriteBufferLowWaterMark(v);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        return this.setWriteBufferWaterMark(writeBufferWaterMark0);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark0) {
        super.setWriteBufferWaterMark(writeBufferWaterMark0);
        return this;
    }

    @Override  // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public ChannelConfig setWriteSpinCount(int v) {
        return this.setWriteSpinCount(v);
    }

    @Override  // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setWriteSpinCount(int v) {
        super.setWriteSpinCount(v);
        return this;
    }
}

