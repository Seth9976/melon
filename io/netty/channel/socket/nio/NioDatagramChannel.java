package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.RecvByteBufAllocator.ExtendedHandle;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.MembershipKey;
import java.nio.channels.SelectableChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class NioDatagramChannel extends AbstractNioMessageChannel implements DatagramChannel {
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER;
    private static final String EXPECTED_TYPES;
    private static final ChannelMetadata METADATA;
    private final DatagramChannelConfig config;
    private Map memberships;

    // 去混淆评级： 低(40)
    static {
        NioDatagramChannel.METADATA = new ChannelMetadata(true, 16);
        NioDatagramChannel.DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
        NioDatagramChannel.EXPECTED_TYPES = " (expected: DatagramPacket, AddressedEnvelope" + '<' + "ByteBuf" + ", " + "SocketAddress" + ">, " + "ByteBuf" + ')';
    }

    public NioDatagramChannel() {
        this(NioDatagramChannel.newSocket(NioDatagramChannel.DEFAULT_SELECTOR_PROVIDER));
    }

    public NioDatagramChannel(InternetProtocolFamily internetProtocolFamily0) {
        this(NioDatagramChannel.newSocket(NioDatagramChannel.DEFAULT_SELECTOR_PROVIDER, internetProtocolFamily0));
    }

    public NioDatagramChannel(java.nio.channels.DatagramChannel datagramChannel0) {
        super(null, datagramChannel0, 1);
        this.config = new NioDatagramChannelConfig(this, datagramChannel0);
    }

    public NioDatagramChannel(SelectorProvider selectorProvider0) {
        this(NioDatagramChannel.newSocket(selectorProvider0));
    }

    public NioDatagramChannel(SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        this(NioDatagramChannel.newSocket(selectorProvider0, internetProtocolFamily0));
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, InetAddress inetAddress1) {
        return this.block(inetAddress0, inetAddress1, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        try {
            return this.block(inetAddress0, NetworkInterface.getByInetAddress(this.localAddress().getAddress()), inetAddress1, channelPromise0);
        }
        catch(SocketException socketException0) {
            channelPromise0.setFailure(socketException0);
            return channelPromise0;
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1) {
        return this.block(inetAddress0, networkInterface0, inetAddress1, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public ChannelFuture block(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        NioDatagramChannel.checkJavaVersion();
        ObjectUtil.checkNotNull(inetAddress0, "multicastAddress");
        ObjectUtil.checkNotNull(inetAddress1, "sourceToBlock");
        ObjectUtil.checkNotNull(networkInterface0, "networkInterface");
        synchronized(this) {
            Map map0 = this.memberships;
            if(map0 != null) {
                for(Object object0: ((List)map0.get(inetAddress0))) {
                    MembershipKey membershipKey0 = (MembershipKey)object0;
                    if(networkInterface0.equals(membershipKey0.networkInterface())) {
                        try {
                            membershipKey0.block(inetAddress1);
                        }
                        catch(IOException iOException0) {
                            channelPromise0.setFailure(iOException0);
                        }
                    }
                }
            }
        }
        channelPromise0.setSuccess();
        return channelPromise0;
    }

    private static void checkJavaVersion() {
        if(PlatformDependent.javaVersion() < 7) {
            throw new UnsupportedOperationException("Only supported on java 7+.");
        }
    }

    private static void checkUnresolved(AddressedEnvelope addressedEnvelope0) {
        if(addressedEnvelope0.recipient() instanceof InetSocketAddress && ((InetSocketAddress)addressedEnvelope0.recipient()).isUnresolved()) {
            throw new UnresolvedAddressException();
        }
    }

    public void clearReadPending0() {
        this.clearReadPending();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public boolean closeOnReadError(Throwable throwable0) {
        return throwable0 instanceof SocketException ? false : super.closeOnReadError(throwable0);
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config();
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public DatagramChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public boolean continueOnWriteError() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public boolean continueReading(Handle recvByteBufAllocator$Handle0) {
        return recvByteBufAllocator$Handle0 instanceof ExtendedHandle ? ((ExtendedHandle)recvByteBufAllocator$Handle0).continueReading(UncheckedBooleanSupplier.TRUE_SUPPLIER) : recvByteBufAllocator$Handle0.continueReading();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        this.doBind0(socketAddress0);
    }

    private void doBind0(SocketAddress socketAddress0) {
        if(PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(this.javaChannel(), socketAddress0);
            return;
        }
        this.javaChannel().socket().bind(socketAddress0);
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doClose() {
        this.javaChannel().close();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public boolean doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        if(socketAddress1 != null) {
            this.doBind0(socketAddress1);
        }
        try {
            this.javaChannel().connect(socketAddress0);
            return true;
        }
        catch(Throwable throwable0) {
            this.doClose();
            throw throwable0;
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        this.javaChannel().disconnect();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doFinishConnect() {
        throw new Error();
    }

    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public int doReadMessages(List list0) {
        java.nio.channels.DatagramChannel datagramChannel0 = this.javaChannel();
        Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
        ByteBuf byteBuf0 = recvByteBufAllocator$Handle0.allocate(this.config().getAllocator());
        recvByteBufAllocator$Handle0.attemptedBytesRead(byteBuf0.writableBytes());
        try {
            ByteBuffer byteBuffer0 = byteBuf0.internalNioBuffer(byteBuf0.writerIndex(), byteBuf0.writableBytes());
            int v1 = byteBuffer0.position();
            InetSocketAddress inetSocketAddress0 = (InetSocketAddress)datagramChannel0.receive(byteBuffer0);
            if(inetSocketAddress0 != null) {
                recvByteBufAllocator$Handle0.lastBytesRead(byteBuffer0.position() - v1);
                list0.add(new DatagramPacket(byteBuf0.writerIndex(byteBuf0.writerIndex() + recvByteBufAllocator$Handle0.lastBytesRead()), this.localAddress(), inetSocketAddress0));
                return 1;
            }
            return 0;
        }
        catch(Throwable throwable0) {
            PlatformDependent.throwException(throwable0);
            return -1;
        }
        finally {
            byteBuf0.release();
        }
    }

    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public boolean doWriteMessage(Object object0, ChannelOutboundBuffer channelOutboundBuffer0) {
        ByteBuf byteBuf0;
        SocketAddress socketAddress0;
        if(object0 instanceof AddressedEnvelope) {
            socketAddress0 = ((AddressedEnvelope)object0).recipient();
            byteBuf0 = (ByteBuf)((AddressedEnvelope)object0).content();
        }
        else {
            byteBuf0 = (ByteBuf)object0;
            socketAddress0 = null;
        }
        int v = byteBuf0.readableBytes();
        if(v == 0) {
            return true;
        }
        ByteBuffer byteBuffer0 = byteBuf0.nioBufferCount() == 1 ? byteBuf0.internalNioBuffer(byteBuf0.readerIndex(), v) : byteBuf0.nioBuffer(byteBuf0.readerIndex(), v);
        return (socketAddress0 == null ? this.javaChannel().write(byteBuffer0) : this.javaChannel().send(byteBuffer0, socketAddress0)) > 0;
    }

    @Override  // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object object0) {
        if(object0 instanceof DatagramPacket) {
            NioDatagramChannel.checkUnresolved(((DatagramPacket)object0));
            ByteBuf byteBuf0 = (ByteBuf)((DatagramPacket)object0).content();
            return NioDatagramChannel.isSingleDirectBuffer(byteBuf0) ? ((DatagramPacket)object0) : new DatagramPacket(this.newDirectBuffer(((DatagramPacket)object0), byteBuf0), ((InetSocketAddress)((DatagramPacket)object0).recipient()));
        }
        if(object0 instanceof ByteBuf) {
            return NioDatagramChannel.isSingleDirectBuffer(((ByteBuf)object0)) ? ((ByteBuf)object0) : this.newDirectBuffer(((ByteBuf)object0));
        }
        if(object0 instanceof AddressedEnvelope) {
            NioDatagramChannel.checkUnresolved(((AddressedEnvelope)object0));
            if(((AddressedEnvelope)object0).content() instanceof ByteBuf) {
                ByteBuf byteBuf1 = (ByteBuf)((AddressedEnvelope)object0).content();
                return NioDatagramChannel.isSingleDirectBuffer(byteBuf1) ? ((AddressedEnvelope)object0) : new DefaultAddressedEnvelope(this.newDirectBuffer(((AddressedEnvelope)object0), byteBuf1), ((AddressedEnvelope)object0).recipient());
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(object0) + NioDatagramChannel.EXPECTED_TYPES);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.DatagramChannel datagramChannel0 = this.javaChannel();
        return datagramChannel0.isOpen() && (((Boolean)this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && this.isRegistered() || datagramChannel0.socket().isBound());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.javaChannel().isConnected();
    }

    private static boolean isSingleDirectBuffer(ByteBuf byteBuf0) {
        return byteBuf0.isDirect() && byteBuf0.nioBufferCount() == 1;
    }

    public java.nio.channels.DatagramChannel javaChannel() {
        return (java.nio.channels.DatagramChannel)super.javaChannel();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public SelectableChannel javaChannel() {
        return this.javaChannel();
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0) {
        return this.joinGroup(inetAddress0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0, ChannelPromise channelPromise0) {
        try {
            NetworkInterface networkInterface0 = this.config.getNetworkInterface();
            if(networkInterface0 == null) {
                networkInterface0 = NetworkInterface.getByInetAddress(this.localAddress().getAddress());
            }
            return this.joinGroup(inetAddress0, networkInterface0, null, channelPromise0);
        }
        catch(SocketException socketException0) {
        }
        channelPromise0.setFailure(socketException0);
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1) {
        return this.joinGroup(inetAddress0, networkInterface0, inetAddress1, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public ChannelFuture joinGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        List list0;
        NioDatagramChannel.checkJavaVersion();
        ObjectUtil.checkNotNull(inetAddress0, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface0, "networkInterface");
        try {
            MembershipKey membershipKey0 = inetAddress1 == null ? this.javaChannel().join(inetAddress0, networkInterface0) : this.javaChannel().join(inetAddress0, networkInterface0, inetAddress1);
            synchronized(this) {
                Map map0 = this.memberships;
                if(map0 == null) {
                    this.memberships = new HashMap();
                    list0 = null;
                }
                else {
                    list0 = (List)map0.get(inetAddress0);
                }
                if(list0 == null) {
                    list0 = new ArrayList();
                    this.memberships.put(inetAddress0, list0);
                }
                list0.add(membershipKey0);
            }
            channelPromise0.setSuccess();
            return channelPromise0;
        }
        catch(Throwable throwable0) {
        }
        channelPromise0.setFailure(throwable0);
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0) {
        return this.joinGroup(inetSocketAddress0, networkInterface0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0, ChannelPromise channelPromise0) {
        return this.joinGroup(inetSocketAddress0.getAddress(), networkInterface0, null, channelPromise0);
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0) {
        return this.leaveGroup(inetAddress0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0, ChannelPromise channelPromise0) {
        try {
            return this.leaveGroup(inetAddress0, NetworkInterface.getByInetAddress(this.localAddress().getAddress()), null, channelPromise0);
        }
        catch(SocketException socketException0) {
            channelPromise0.setFailure(socketException0);
            return channelPromise0;
        }
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1) {
        return this.leaveGroup(inetAddress0, networkInterface0, inetAddress1, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public ChannelFuture leaveGroup(InetAddress inetAddress0, NetworkInterface networkInterface0, InetAddress inetAddress1, ChannelPromise channelPromise0) {
        NioDatagramChannel.checkJavaVersion();
        ObjectUtil.checkNotNull(inetAddress0, "multicastAddress");
        ObjectUtil.checkNotNull(networkInterface0, "networkInterface");
        synchronized(this) {
            Map map0 = this.memberships;
            if(map0 != null) {
                List list0 = (List)map0.get(inetAddress0);
                if(list0 != null) {
                    Iterator iterator0 = list0.iterator();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        MembershipKey membershipKey0 = (MembershipKey)object0;
                        if(networkInterface0.equals(membershipKey0.networkInterface()) && (inetAddress1 == null && membershipKey0.sourceAddress() == null || inetAddress1 != null && inetAddress1.equals(membershipKey0.sourceAddress()))) {
                            membershipKey0.drop();
                            iterator0.remove();
                        }
                    }
                    if(list0.isEmpty()) {
                        this.memberships.remove(inetAddress0);
                    }
                }
            }
        }
        channelPromise0.setSuccess();
        return channelPromise0;
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0) {
        return this.leaveGroup(inetSocketAddress0, networkInterface0, this.newPromise());
    }

    @Override  // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress0, NetworkInterface networkInterface0, ChannelPromise channelPromise0) {
        return this.leaveGroup(inetSocketAddress0.getAddress(), networkInterface0, null, channelPromise0);
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
        return this.javaChannel().socket().getLocalSocketAddress();
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return NioDatagramChannel.METADATA;
    }

    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider selectorProvider0) {
        try {
            return selectorProvider0.openDatagramChannel();
        }
        catch(IOException iOException0) {
            throw new ChannelException("Failed to open a socket.", iOException0);
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        if(internetProtocolFamily0 == null) {
            return NioDatagramChannel.newSocket(selectorProvider0);
        }
        NioDatagramChannel.checkJavaVersion();
        try {
            return selectorProvider0.openDatagramChannel(ProtocolFamilyConverter.convert(internetProtocolFamily0));
        }
        catch(IOException iOException0) {
            throw new ChannelException("Failed to open a socket.", iOException0);
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
        return this.javaChannel().socket().getRemoteSocketAddress();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    @Deprecated
    public void setReadPending(boolean z) {
        super.setReadPending(z);
    }
}

