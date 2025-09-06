package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.List;
import java.util.Locale;
import jeb.synthetic.TWR;

@Deprecated
public class OioDatagramChannel extends AbstractOioMessageChannel implements DatagramChannel {
    private static final String EXPECTED_TYPES;
    private static final ChannelMetadata METADATA;
    private final OioDatagramChannelConfig config;
    private static final InternalLogger logger;
    private final MulticastSocket socket;
    private final DatagramPacket tmpPacket;

    // 去混淆评级： 低(40)
    static {
        OioDatagramChannel.logger = InternalLoggerFactory.getInstance(OioDatagramChannel.class);
        OioDatagramChannel.METADATA = new ChannelMetadata(true);
        OioDatagramChannel.EXPECTED_TYPES = " (expected: DatagramPacket, AddressedEnvelope" + '<' + "ByteBuf" + ", " + "SocketAddress" + ">, " + "ByteBuf" + ')';
    }

    public OioDatagramChannel() {
        this(OioDatagramChannel.newSocket());
    }

    public OioDatagramChannel(MulticastSocket multicastSocket0) {
        super(null);
        this.tmpPacket = new DatagramPacket(EmptyArrays.EMPTY_BYTES, 0);
        try {
            try {
                multicastSocket0.setSoTimeout(1000);
                multicastSocket0.setBroadcast(false);
            }
            catch(SocketException socketException0) {
                throw new ChannelException("Failed to configure the datagram socket timeout.", socketException0);
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(multicastSocket0, throwable0);
            throw throwable0;
        }
        this.socket = multicastSocket0;
        this.config = new DefaultOioDatagramChannelConfig(this, multicastSocket0);
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, InetAddress inetAddress1) {
        return this.newFailedFuture(new UnsupportedOperationException());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        channelPromise0.setFailure(new UnsupportedOperationException());
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1) {
        return this.newFailedFuture(new UnsupportedOperationException());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        channelPromise0.setFailure(new UnsupportedOperationException());
        return channelPromise0;
    }

    private static void checkUnresolved(AddressedEnvelope addressedEnvelope0) {
        if(addressedEnvelope0.recipient() instanceof InetSocketAddress && ((InetSocketAddress)addressedEnvelope0.recipient()).isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config();
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public DatagramChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        this.socket.bind(socketAddress0);
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        this.socket.close();
    }

    @Override  // io.netty.channel.oio.AbstractOioChannel
    public void doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        if(socketAddress1 != null) {
            this.socket.bind(socketAddress1);
        }
        try {
            this.socket.connect(socketAddress0);
        }
        catch(Throwable throwable0) {
            try {
                this.socket.close();
            }
            catch(Throwable throwable1) {
                OioDatagramChannel.logger.warn("Failed to close a socket.", throwable1);
            }
            throw throwable0;
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        this.socket.disconnect();
    }

    @Override  // io.netty.channel.oio.AbstractOioMessageChannel
    public int doReadMessages(List list0) {
        Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
        ByteBuf byteBuf0 = this.config().getAllocator().heapBuffer(recvByteBufAllocator$Handle0.guess());
        try {
            this.tmpPacket.setAddress(null);
            byte[] arr_b = byteBuf0.array();
            int v = byteBuf0.arrayOffset();
            this.tmpPacket.setData(arr_b, v, byteBuf0.capacity());
            this.socket.receive(this.tmpPacket);
            InetSocketAddress inetSocketAddress0 = (InetSocketAddress)this.tmpPacket.getSocketAddress();
            recvByteBufAllocator$Handle0.lastBytesRead(this.tmpPacket.getLength());
            list0.add(new io.netty.channel.socket.DatagramPacket(byteBuf0.writerIndex(recvByteBufAllocator$Handle0.lastBytesRead()), this.localAddress(), inetSocketAddress0));
            return 1;
        }
        catch(SocketTimeoutException unused_ex) {
            byteBuf0.release();
            return 0;
        }
        catch(SocketException socketException0) {
            try {
                if(!socketException0.getMessage().toLowerCase(Locale.US).contains("socket closed")) {
                    throw socketException0;
                }
            }
            catch(Throwable throwable1) {
                byteBuf0.release();
                throw throwable1;
            }
            byteBuf0.release();
            return -1;
        }
        catch(Throwable throwable0) {
            try {
                PlatformDependent.throwException(throwable0);
                goto label_24;
            }
            catch(Throwable throwable1) {
            }
        }
        byteBuf0.release();
        throw throwable1;
    label_24:
        byteBuf0.release();
        return -1;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        ByteBuf byteBuf0;
        SocketAddress socketAddress0;
        Object object0;
        while((object0 = channelOutboundBuffer0.current()) != null) {
            if(object0 instanceof AddressedEnvelope) {
                socketAddress0 = ((AddressedEnvelope)object0).recipient();
                byteBuf0 = (ByteBuf)((AddressedEnvelope)object0).content();
            }
            else {
                byteBuf0 = (ByteBuf)object0;
                socketAddress0 = null;
            }
            int v = byteBuf0.readableBytes();
            try {
                if(socketAddress0 == null) {
                    if(!this.isConnected()) {
                        throw new NotYetConnectedException();
                    }
                    this.tmpPacket.setAddress(null);
                }
                else {
                    this.tmpPacket.setSocketAddress(socketAddress0);
                }
                if(byteBuf0.hasArray()) {
                    byte[] arr_b = byteBuf0.array();
                    int v1 = byteBuf0.arrayOffset();
                    int v2 = byteBuf0.readerIndex();
                    this.tmpPacket.setData(arr_b, v1 + v2, v);
                }
                else {
                    byte[] arr_b1 = ByteBufUtil.getBytes(byteBuf0, byteBuf0.readerIndex(), v);
                    this.tmpPacket.setData(arr_b1);
                }
                this.socket.send(this.tmpPacket);
                channelOutboundBuffer0.remove();
                continue;
            }
            catch(Exception exception0) {
            }
            channelOutboundBuffer0.remove(exception0);
        }
    }

    private void ensureBound() {
        if(!this.isActive()) {
            throw new IllegalStateException("io.netty.channel.socket.DatagramChannel must be bound to join a group.");
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object object0) {
        if(object0 instanceof io.netty.channel.socket.DatagramPacket) {
            OioDatagramChannel.checkUnresolved(((io.netty.channel.socket.DatagramPacket)object0));
            return object0;
        }
        if(object0 instanceof ByteBuf) {
            return object0;
        }
        if(object0 instanceof AddressedEnvelope) {
            OioDatagramChannel.checkUnresolved(((AddressedEnvelope)object0));
            if(((AddressedEnvelope)object0).content() instanceof ByteBuf) {
                return object0;
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(object0) + OioDatagramChannel.EXPECTED_TYPES);
    }

    // 去混淆评级： 低(40)
    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.isOpen() && (((Boolean)this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && this.isRegistered() || this.socket.isBound());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0) {
        return this.joinGroup(inetAddress0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0, ChannelPromise channelPromise0) {
        this.ensureBound();
        try {
            this.socket.joinGroup(inetAddress0);
            channelPromise0.setSuccess();
        }
        catch(IOException iOException0) {
            channelPromise0.setFailure(iOException0);
        }
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1) {
        return this.newFailedFuture(new UnsupportedOperationException());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        channelPromise0.setFailure(new UnsupportedOperationException());
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0) {
        return this.joinGroup(inetSocketAddress0, networkInterface0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0, ChannelPromise channelPromise0) {
        this.ensureBound();
        try {
            this.socket.joinGroup(inetSocketAddress0, networkInterface0);
            channelPromise0.setSuccess();
        }
        catch(IOException iOException0) {
            channelPromise0.setFailure(iOException0);
        }
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0) {
        return this.leaveGroup(inetAddress0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0, ChannelPromise channelPromise0) {
        try {
            this.socket.leaveGroup(inetAddress0);
            channelPromise0.setSuccess();
        }
        catch(IOException iOException0) {
            channelPromise0.setFailure(iOException0);
        }
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1) {
        return this.newFailedFuture(new UnsupportedOperationException());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        channelPromise0.setFailure(new UnsupportedOperationException());
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0) {
        return this.leaveGroup(inetSocketAddress0, networkInterface0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0, ChannelPromise channelPromise0) {
        try {
            this.socket.leaveGroup(inetSocketAddress0, networkInterface0);
            channelPromise0.setSuccess();
        }
        catch(IOException iOException0) {
            channelPromise0.setFailure(iOException0);
        }
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override  // io.netty.channel.Channel, io.netty.channel.AbstractChannel
    public SocketAddress localAddress() {
        return this.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return OioDatagramChannel.METADATA;
    }

    private static MulticastSocket newSocket() {
        try {
            return new MulticastSocket(null);
        }
        catch(Exception exception0) {
            throw new ChannelException("failed to create a new socket", exception0);
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress)super.remoteAddress();
    }

    @Override  // io.netty.channel.Channel, io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress() {
        return this.remoteAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }
}

