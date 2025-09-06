package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicReference;

public final class PcapWriteHandler extends ChannelDuplexHandler implements Closeable {
    public static final class Builder {
        private boolean captureZeroByte;
        private ChannelType channelType;
        private InetSocketAddress handlerAddr;
        private InetSocketAddress initiatorAddr;
        private boolean isServerPipeline;
        private boolean sharedOutputStream;
        private boolean writePcapGlobalHeader;

        private Builder() {
            this.writePcapGlobalHeader = true;
        }

        public Builder(io.netty.handler.pcap.PcapWriteHandler.1 pcapWriteHandler$10) {
        }

        public static boolean access$000(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.captureZeroByte;
        }

        public static boolean access$100(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.sharedOutputStream;
        }

        public static boolean access$200(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.writePcapGlobalHeader;
        }

        public static ChannelType access$300(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.channelType;
        }

        public static InetSocketAddress access$400(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.handlerAddr;
        }

        public static InetSocketAddress access$500(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.initiatorAddr;
        }

        public static boolean access$600(Builder pcapWriteHandler$Builder0) {
            return pcapWriteHandler$Builder0.isServerPipeline;
        }

        public PcapWriteHandler build(OutputStream outputStream0) {
            ObjectUtil.checkNotNull(outputStream0, "outputStream");
            return new PcapWriteHandler(this, outputStream0, null);
        }

        public Builder captureZeroByte(boolean z) {
            this.captureZeroByte = z;
            return this;
        }

        public Builder forceTcpChannel(InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, boolean z) {
            this.channelType = ChannelType.TCP;
            this.handlerAddr = (InetSocketAddress)ObjectUtil.checkNotNull(inetSocketAddress0, "serverAddress");
            this.initiatorAddr = (InetSocketAddress)ObjectUtil.checkNotNull(inetSocketAddress1, "clientAddress");
            this.isServerPipeline = z;
            return this;
        }

        public Builder forceUdpChannel(InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1) {
            this.channelType = ChannelType.UDP;
            this.handlerAddr = (InetSocketAddress)ObjectUtil.checkNotNull(inetSocketAddress1, "remoteAddress");
            this.initiatorAddr = (InetSocketAddress)ObjectUtil.checkNotNull(inetSocketAddress0, "localAddress");
            return this;
        }

        public Builder sharedOutputStream(boolean z) {
            this.sharedOutputStream = z;
            return this;
        }

        public Builder writePcapGlobalHeader(boolean z) {
            this.writePcapGlobalHeader = z;
            return this;
        }
    }

    static enum ChannelType {
        TCP,
        UDP;

    }

    static final class WildcardAddressHolder {
        static final InetAddress wildcard4;
        static final InetAddress wildcard6;

        static {
            try {
                WildcardAddressHolder.wildcard4 = InetAddress.getByAddress(new byte[4]);
                WildcardAddressHolder.wildcard6 = InetAddress.getByAddress(new byte[16]);
            }
            catch(UnknownHostException unknownHostException0) {
                throw new AssertionError(unknownHostException0);
            }
        }
    }

    private final boolean captureZeroByte;
    private ChannelType channelType;
    private InetSocketAddress handlerAddr;
    private InetSocketAddress initiatorAddr;
    private boolean isServerPipeline;
    private final InternalLogger logger;
    private final OutputStream outputStream;
    private PcapWriter pCapWriter;
    private int receiveSegmentNumber;
    private int sendSegmentNumber;
    private final boolean sharedOutputStream;
    private final AtomicReference state;
    private final boolean writePcapGlobalHeader;

    private PcapWriteHandler(Builder pcapWriteHandler$Builder0, OutputStream outputStream0) {
        this.logger = InternalLoggerFactory.getInstance(PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.state = new AtomicReference(State.INIT);
        this.outputStream = outputStream0;
        this.captureZeroByte = Builder.access$000(pcapWriteHandler$Builder0);
        this.sharedOutputStream = Builder.access$100(pcapWriteHandler$Builder0);
        this.writePcapGlobalHeader = Builder.access$200(pcapWriteHandler$Builder0);
        this.channelType = Builder.access$300(pcapWriteHandler$Builder0);
        this.handlerAddr = Builder.access$400(pcapWriteHandler$Builder0);
        this.initiatorAddr = Builder.access$500(pcapWriteHandler$Builder0);
        this.isServerPipeline = Builder.access$600(pcapWriteHandler$Builder0);
    }

    public PcapWriteHandler(Builder pcapWriteHandler$Builder0, OutputStream outputStream0, io.netty.handler.pcap.PcapWriteHandler.1 pcapWriteHandler$10) {
        this(pcapWriteHandler$Builder0, outputStream0);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream0) {
        this(outputStream0, false, true);
    }

    @Deprecated
    public PcapWriteHandler(OutputStream outputStream0, boolean z, boolean z1) {
        this.logger = InternalLoggerFactory.getInstance(PcapWriteHandler.class);
        this.sendSegmentNumber = 1;
        this.receiveSegmentNumber = 1;
        this.state = new AtomicReference(State.INIT);
        this.outputStream = (OutputStream)ObjectUtil.checkNotNull(outputStream0, "OutputStream");
        this.captureZeroByte = z;
        this.writePcapGlobalHeader = z1;
        this.sharedOutputStream = false;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        this.initializeIfNecessary(channelHandlerContext0);
        super.channelActive(channelHandlerContext0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(this.state.get() == State.INIT) {
            this.initializeIfNecessary(channelHandlerContext0);
        }
        if(this.state.get() == State.WRITING) {
            ChannelType pcapWriteHandler$ChannelType0 = this.channelType;
            if(pcapWriteHandler$ChannelType0 == ChannelType.TCP) {
                this.handleTCP(channelHandlerContext0, object0, false);
            }
            else if(pcapWriteHandler$ChannelType0 == ChannelType.UDP) {
                this.handleUDP(channelHandlerContext0, object0);
            }
            else {
                this.logDiscard();
            }
        }
        super.channelRead(channelHandlerContext0, object0);
    }

    @Override
    public void close() {
        if(this.state.get() == State.CLOSED) {
            this.logger.debug("PcapWriterHandler is already closed");
            return;
        }
        this.pCapWriter.close();
        this.markClosed();
        this.logger.debug("PcapWriterHandler is now closed");
    }

    private void completeTCPWrite(InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, ByteBuf byteBuf0, ByteBufAllocator byteBufAllocator0, ChannelHandlerContext channelHandlerContext0) {
        ByteBuf byteBuf1 = byteBufAllocator0.buffer();
        ByteBuf byteBuf2 = byteBufAllocator0.buffer();
        ByteBuf byteBuf3 = byteBufAllocator0.buffer();
        try {
            if(inetSocketAddress0.getAddress() instanceof Inet4Address && inetSocketAddress1.getAddress() instanceof Inet4Address) {
                IPPacket.writeTCPv4(byteBuf1, byteBuf0, NetUtil.ipv4AddressToInt(((Inet4Address)inetSocketAddress0.getAddress())), NetUtil.ipv4AddressToInt(((Inet4Address)inetSocketAddress1.getAddress())));
                EthernetPacket.writeIPv4(byteBuf2, byteBuf1);
                this.pCapWriter.writePacket(byteBuf3, byteBuf2);
            }
            else if(!(inetSocketAddress0.getAddress() instanceof Inet6Address) || !(inetSocketAddress1.getAddress() instanceof Inet6Address)) {
                InetAddress inetAddress0 = inetSocketAddress0.getAddress();
                InetAddress inetAddress1 = inetSocketAddress1.getAddress();
                this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetAddress0, inetAddress1);
            }
            else {
                IPPacket.writeTCPv6(byteBuf1, byteBuf0, inetSocketAddress0.getAddress().getAddress(), inetSocketAddress1.getAddress().getAddress());
                EthernetPacket.writeIPv6(byteBuf2, byteBuf1);
                this.pCapWriter.writePacket(byteBuf3, byteBuf2);
            }
        }
        catch(IOException iOException0) {
            this.logger.error("Caught Exception While Writing Packet into Pcap", iOException0);
            channelHandlerContext0.fireExceptionCaught(iOException0);
        }
        finally {
            byteBuf1.release();
            byteBuf2.release();
            byteBuf3.release();
        }
    }

    private void completeUDPWrite(InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, ByteBuf byteBuf0, ByteBufAllocator byteBufAllocator0, ChannelHandlerContext channelHandlerContext0) {
        ByteBuf byteBuf1 = byteBufAllocator0.buffer();
        ByteBuf byteBuf2 = byteBufAllocator0.buffer();
        ByteBuf byteBuf3 = byteBufAllocator0.buffer();
        try {
            if(inetSocketAddress0.getAddress() instanceof Inet4Address && inetSocketAddress1.getAddress() instanceof Inet4Address) {
                IPPacket.writeUDPv4(byteBuf1, byteBuf0, NetUtil.ipv4AddressToInt(((Inet4Address)inetSocketAddress0.getAddress())), NetUtil.ipv4AddressToInt(((Inet4Address)inetSocketAddress1.getAddress())));
                EthernetPacket.writeIPv4(byteBuf2, byteBuf1);
                this.pCapWriter.writePacket(byteBuf3, byteBuf2);
            }
            else if(!(inetSocketAddress0.getAddress() instanceof Inet6Address) || !(inetSocketAddress1.getAddress() instanceof Inet6Address)) {
                InetAddress inetAddress0 = inetSocketAddress0.getAddress();
                InetAddress inetAddress1 = inetSocketAddress1.getAddress();
                this.logger.error("Source and Destination IP Address versions are not same. Source Address: {}, Destination Address: {}", inetAddress0, inetAddress1);
            }
            else {
                IPPacket.writeUDPv6(byteBuf1, byteBuf0, inetSocketAddress0.getAddress().getAddress(), inetSocketAddress1.getAddress().getAddress());
                EthernetPacket.writeIPv6(byteBuf2, byteBuf1);
                this.pCapWriter.writePacket(byteBuf3, byteBuf2);
            }
        }
        catch(IOException iOException0) {
            this.logger.error("Caught Exception While Writing Packet into Pcap", iOException0);
            channelHandlerContext0.fireExceptionCaught(iOException0);
        }
        finally {
            byteBuf1.release();
            byteBuf2.release();
            byteBuf3.release();
        }
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        if(this.channelType == ChannelType.TCP) {
            ByteBuf byteBuf0 = channelHandlerContext0.alloc().buffer();
            try {
                TCPPacket.writePacket(byteBuf0, null, this.sendSegmentNumber, this.receiveSegmentNumber, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), new TCPFlag[]{TCPFlag.RST, TCPFlag.ACK});
                this.completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBuf0, channelHandlerContext0.alloc(), channelHandlerContext0);
            }
            finally {
                byteBuf0.release();
            }
            this.logger.debug("Sent Fake TCP RST to close connection");
        }
        this.close();
        channelHandlerContext0.fireExceptionCaught(throwable0);
    }

    private static InetSocketAddress getLocalAddress(Channel channel0, InetSocketAddress inetSocketAddress0) {
        InetSocketAddress inetSocketAddress1 = (InetSocketAddress)channel0.localAddress();
        if(inetSocketAddress0 != null && inetSocketAddress1.getAddress().isAnyLocalAddress()) {
            if(inetSocketAddress1.getAddress() instanceof Inet4Address && inetSocketAddress0.getAddress() instanceof Inet6Address) {
                int v = inetSocketAddress1.getPort();
                return new InetSocketAddress(WildcardAddressHolder.wildcard6, v);
            }
            if(inetSocketAddress1.getAddress() instanceof Inet6Address && inetSocketAddress0.getAddress() instanceof Inet4Address) {
                int v1 = inetSocketAddress1.getPort();
                return new InetSocketAddress(WildcardAddressHolder.wildcard4, v1);
            }
        }
        return inetSocketAddress1;
    }

    private void handleTCP(ChannelHandlerContext channelHandlerContext0, Object object0, boolean z) {
        int v16;
        int v15;
        int v14;
        int v13;
        TCPFlag tCPPacket$TCPFlag1;
        int v12;
        int v11;
        int v10;
        int v9;
        InetSocketAddress inetSocketAddress3;
        InetSocketAddress inetSocketAddress2;
        ByteBuf byteBuf4;
        int v8;
        int v7;
        int v6;
        int v5;
        ByteBuf byteBuf3;
        ByteBuf byteBuf2;
        TCPFlag tCPPacket$TCPFlag0;
        int v4;
        int v3;
        int v2;
        int v1;
        InetSocketAddress inetSocketAddress1;
        InetSocketAddress inetSocketAddress0;
        if(object0 instanceof ByteBuf) {
            if(((ByteBuf)object0).readableBytes() == 0 && !this.captureZeroByte) {
                this.logger.debug("Discarding Zero Byte TCP Packet. isWriteOperation {}", Boolean.valueOf(z));
                return;
            }
            ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
            ByteBuf byteBuf0 = ((ByteBuf)object0).duplicate();
            ByteBuf byteBuf1 = byteBufAllocator0.buffer();
            int v = byteBuf0.readableBytes();
            if(z) {
                try {
                    if(this.isServerPipeline) {
                        inetSocketAddress0 = this.handlerAddr;
                        inetSocketAddress1 = this.initiatorAddr;
                    }
                    else {
                        inetSocketAddress0 = this.initiatorAddr;
                        inetSocketAddress1 = this.handlerAddr;
                    }
                    v1 = this.sendSegmentNumber;
                    v2 = this.receiveSegmentNumber;
                    v3 = inetSocketAddress0.getPort();
                    v4 = inetSocketAddress1.getPort();
                    tCPPacket$TCPFlag0 = TCPFlag.ACK;
                    byteBuf2 = byteBuf1;
                }
                catch(Throwable throwable0) {
                    byteBuf3 = byteBuf1;
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    TCPPacket.writePacket(byteBuf2, byteBuf0, v1, v2, v3, v4, new TCPFlag[]{tCPPacket$TCPFlag0});
                    byteBuf1 = byteBuf2;
                }
                catch(Throwable throwable0) {
                    goto label_54;
                }
                try {
                    this.completeTCPWrite(inetSocketAddress0, inetSocketAddress1, byteBuf1, byteBufAllocator0, channelHandlerContext0);
                    byteBuf3 = byteBuf1;
                }
                catch(Throwable throwable0) {
                    byteBuf3 = byteBuf1;
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    this.logTCP(true, v, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress0, inetSocketAddress1, false);
                    v5 = this.sendSegmentNumber + v;
                    this.sendSegmentNumber = v5;
                    v6 = this.receiveSegmentNumber;
                    v7 = inetSocketAddress1.getPort();
                    v8 = inetSocketAddress0.getPort();
                    byteBuf4 = byteBuf3;
                }
                catch(Throwable throwable0) {
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    TCPPacket.writePacket(byteBuf4, null, v6, v5, v7, v8, new TCPFlag[]{tCPPacket$TCPFlag0});
                    byteBuf1 = byteBuf4;
                }
                catch(Throwable throwable0) {
                    goto label_69;
                }
                try {
                    this.completeTCPWrite(inetSocketAddress1, inetSocketAddress0, byteBuf1, byteBufAllocator0, channelHandlerContext0);
                    byteBuf3 = byteBuf1;
                }
                catch(Throwable throwable0) {
                    byteBuf3 = byteBuf1;
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    this.logTCP(true, v, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress1, inetSocketAddress0, true);
                    goto label_82;
                label_38:
                    if(this.isServerPipeline) {
                        inetSocketAddress2 = this.initiatorAddr;
                        inetSocketAddress3 = this.handlerAddr;
                    }
                    else {
                        inetSocketAddress2 = this.handlerAddr;
                        inetSocketAddress3 = this.initiatorAddr;
                    }
                    v9 = this.receiveSegmentNumber;
                    goto label_45;
                }
                catch(Throwable throwable0) {
                    byteBuf3.release();
                    throw throwable0;
                }
            }
            else {
                goto label_38;
                try {
                label_45:
                    v10 = this.sendSegmentNumber;
                    v11 = inetSocketAddress2.getPort();
                    v12 = inetSocketAddress3.getPort();
                    tCPPacket$TCPFlag1 = TCPFlag.ACK;
                    byteBuf2 = byteBuf1;
                }
                catch(Throwable throwable0) {
                    byteBuf3 = byteBuf1;
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    TCPPacket.writePacket(byteBuf2, byteBuf0, v9, v10, v11, v12, new TCPFlag[]{tCPPacket$TCPFlag1});
                    byteBuf1 = byteBuf2;
                }
                catch(Throwable throwable0) {
                    try {
                    label_54:
                        byteBuf3 = byteBuf2;
                    }
                    catch(Throwable throwable0) {
                    }
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    this.completeTCPWrite(inetSocketAddress2, inetSocketAddress3, byteBuf1, byteBufAllocator0, channelHandlerContext0);
                    byteBuf3 = byteBuf1;
                }
                catch(Throwable throwable0) {
                    byteBuf3 = byteBuf1;
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    this.logTCP(false, v, this.receiveSegmentNumber, this.sendSegmentNumber, inetSocketAddress2, inetSocketAddress3, false);
                    v13 = this.receiveSegmentNumber + v;
                    this.receiveSegmentNumber = v13;
                    v14 = this.sendSegmentNumber;
                    v15 = inetSocketAddress3.getPort();
                    v16 = inetSocketAddress2.getPort();
                    byteBuf4 = byteBuf3;
                }
                catch(Throwable throwable0) {
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    TCPPacket.writePacket(byteBuf4, null, v14, v13, v15, v16, new TCPFlag[]{tCPPacket$TCPFlag1});
                    byteBuf1 = byteBuf4;
                }
                catch(Throwable throwable0) {
                    try {
                    label_69:
                        byteBuf3 = byteBuf4;
                    }
                    catch(Throwable throwable0) {
                    }
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    this.completeTCPWrite(inetSocketAddress3, inetSocketAddress2, byteBuf1, byteBufAllocator0, channelHandlerContext0);
                    byteBuf3 = byteBuf1;
                }
                catch(Throwable throwable0) {
                    byteBuf3 = byteBuf1;
                    byteBuf3.release();
                    throw throwable0;
                }
                try {
                    this.logTCP(false, v, this.sendSegmentNumber, this.receiveSegmentNumber, inetSocketAddress3, inetSocketAddress2, true);
                    goto label_82;
                }
                catch(Throwable throwable0) {
                }
                byteBuf3.release();
                throw throwable0;
            }
        label_82:
            byteBuf3.release();
            return;
        }
        this.logger.debug("Discarding Pcap Write for TCP Object: {}", object0);
    }

    private void handleUDP(ChannelHandlerContext channelHandlerContext0, Object object0) {
        ByteBufAllocator byteBufAllocator0;
        Throwable throwable2;
        InetSocketAddress inetSocketAddress1;
        InetSocketAddress inetSocketAddress0;
        DatagramPacket datagramPacket0;
        ByteBuf byteBuf0 = channelHandlerContext0.alloc().buffer();
        if(object0 instanceof DatagramPacket) {
            try {
                if(((ByteBuf)((DatagramPacket)object0).content()).readableBytes() == 0) {
                    goto label_3;
                }
                goto label_7;
            }
            catch(Throwable throwable0) {
                throwable2 = throwable0;
                byteBuf0.release();
                throw throwable2;
            }
            try {
            label_3:
                if(!this.captureZeroByte) {
                    this.logger.debug("Discarding Zero Byte UDP Packet");
                    goto label_5;
                }
                goto label_7;
            }
            catch(Throwable throwable1) {
                throwable2 = throwable1;
                byteBuf0.release();
                throw throwable2;
            }
        label_5:
            byteBuf0.release();
            return;
            try {
            label_7:
                datagramPacket0 = ((DatagramPacket)object0).duplicate();
                inetSocketAddress0 = (InetSocketAddress)datagramPacket0.sender();
                inetSocketAddress1 = (InetSocketAddress)datagramPacket0.recipient();
                if(inetSocketAddress0 == null) {
                    goto label_11;
                }
                goto label_16;
            }
            catch(Throwable throwable0) {
                throwable2 = throwable0;
                byteBuf0.release();
                throw throwable2;
            }
            try {
            label_11:
                inetSocketAddress0 = PcapWriteHandler.getLocalAddress(channelHandlerContext0.channel(), inetSocketAddress1);
            }
            catch(Throwable throwable1) {
                throwable2 = throwable1;
                byteBuf0.release();
                throw throwable2;
            }
            try {
            label_16:
                Object[] arr_object = {((ByteBuf)datagramPacket0.content()).readableBytes(), inetSocketAddress0, inetSocketAddress1};
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", arr_object);
                UDPPacket.writePacket(byteBuf0, ((ByteBuf)datagramPacket0.content()), inetSocketAddress0.getPort(), inetSocketAddress1.getPort());
                byteBufAllocator0 = channelHandlerContext0.alloc();
            }
            catch(Throwable throwable0) {
                throwable2 = throwable0;
                byteBuf0.release();
                throw throwable2;
            }
            try {
                this.completeUDPWrite(inetSocketAddress0, inetSocketAddress1, byteBuf0, byteBufAllocator0, channelHandlerContext0);
            }
            catch(Throwable throwable3) {
                throwable2 = throwable3;
                byteBuf0.release();
                throw throwable2;
            }
        }
        else {
            try {
                if(!(object0 instanceof ByteBuf)) {
                    goto label_45;
                }
                else if(channelHandlerContext0.channel() instanceof DatagramChannel) {
                    goto label_27;
                }
                else {
                    goto label_28;
                }
                goto label_51;
            }
            catch(Throwable throwable4) {
                throwable2 = throwable4;
                byteBuf0.release();
                throw throwable2;
            }
            try {
            label_27:
                if(((DatagramChannel)channelHandlerContext0.channel()).isConnected()) {
                    goto label_28;
                }
                else {
                    goto label_43;
                }
                goto label_51;
            }
            catch(Throwable throwable0) {
                throwable2 = throwable0;
                byteBuf0.release();
                throw throwable2;
            }
            try {
            label_28:
                if(((ByteBuf)object0).readableBytes() == 0) {
                    goto label_29;
                }
                goto label_37;
            }
            catch(Throwable throwable4) {
                throwable2 = throwable4;
                byteBuf0.release();
                throw throwable2;
            }
            try {
            label_29:
                if(!this.captureZeroByte) {
                    this.logger.debug("Discarding Zero Byte UDP Packet");
                    goto label_35;
                }
                goto label_37;
            }
            catch(Throwable throwable0) {
                throwable2 = throwable0;
                byteBuf0.release();
                throw throwable2;
            }
        label_35:
            byteBuf0.release();
            return;
            try {
            label_37:
                ByteBuf byteBuf1 = ((ByteBuf)object0).duplicate();
                Object[] arr_object1 = {byteBuf1.readableBytes(), this.initiatorAddr, this.handlerAddr};
                this.logger.debug("Writing UDP Data of {} Bytes, Src Addr {}, Dst Addr {}", arr_object1);
                UDPPacket.writePacket(byteBuf0, byteBuf1, this.initiatorAddr.getPort(), this.handlerAddr.getPort());
                this.completeUDPWrite(this.initiatorAddr, this.handlerAddr, byteBuf0, channelHandlerContext0.alloc(), channelHandlerContext0);
                goto label_51;
            label_43:
                this.logger.debug("Discarding Pcap Write for UDP Object: {}", object0);
                goto label_51;
            label_45:
                this.logger.debug("Discarding Pcap Write for UDP Object: {}", object0);
                goto label_51;
            }
            catch(Throwable throwable4) {
                throwable2 = throwable4;
            }
            byteBuf0.release();
            throw throwable2;
        }
    label_51:
        byteBuf0.release();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        int v11;
        int v10;
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        int v4;
        ByteBuf byteBuf1;
        TCPFlag tCPPacket$TCPFlag1;
        TCPFlag tCPPacket$TCPFlag0;
        int v3;
        int v2;
        int v1;
        int v;
        if(this.channelType == ChannelType.TCP) {
            this.logger.debug("Starting Fake TCP FIN+ACK Flow to close connection");
            ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
            ByteBuf byteBuf0 = byteBufAllocator0.buffer();
            try {
                v = this.sendSegmentNumber;
                v1 = this.receiveSegmentNumber;
                v2 = this.initiatorAddr.getPort();
                v3 = this.handlerAddr.getPort();
                tCPPacket$TCPFlag0 = TCPFlag.FIN;
                tCPPacket$TCPFlag1 = TCPFlag.ACK;
                byteBuf1 = byteBuf0;
            }
            catch(Throwable throwable0) {
                byteBuf0.release();
                throw throwable0;
            }
            try {
                TCPPacket.writePacket(byteBuf1, null, v, v1, v2, v3, new TCPFlag[]{tCPPacket$TCPFlag0, tCPPacket$TCPFlag1});
            }
            catch(Throwable throwable0) {
                byteBuf0 = byteBuf1;
                byteBuf0.release();
                throw throwable0;
            }
            try {
                this.completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBuf0, byteBufAllocator0, channelHandlerContext0);
                v4 = this.receiveSegmentNumber;
                v5 = this.sendSegmentNumber;
                v6 = this.handlerAddr.getPort();
                v7 = this.initiatorAddr.getPort();
                byteBuf1 = byteBuf0;
            }
            catch(Throwable throwable0) {
                byteBuf0.release();
                throw throwable0;
            }
            try {
                TCPPacket.writePacket(byteBuf1, null, v4, v5, v6, v7, new TCPFlag[]{tCPPacket$TCPFlag0, tCPPacket$TCPFlag1});
            }
            catch(Throwable throwable0) {
                byteBuf0 = byteBuf1;
                byteBuf0.release();
                throw throwable0;
            }
            try {
                this.completeTCPWrite(this.handlerAddr, this.initiatorAddr, byteBuf0, byteBufAllocator0, channelHandlerContext0);
                v8 = this.sendSegmentNumber + 1;
                v9 = this.receiveSegmentNumber + 1;
                v10 = this.initiatorAddr.getPort();
                v11 = this.handlerAddr.getPort();
                byteBuf1 = byteBuf0;
            }
            catch(Throwable throwable0) {
                byteBuf0.release();
                throw throwable0;
            }
            try {
                TCPPacket.writePacket(byteBuf1, null, v8, v9, v10, v11, new TCPFlag[]{tCPPacket$TCPFlag1});
            }
            catch(Throwable throwable0) {
                byteBuf0 = byteBuf1;
                byteBuf0.release();
                throw throwable0;
            }
            try {
                this.completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBuf0, byteBufAllocator0, channelHandlerContext0);
            }
            catch(Throwable throwable0) {
                byteBuf0.release();
                throw throwable0;
            }
            byteBuf0.release();
            this.logger.debug("Finished Fake TCP FIN+ACK Flow to close connection");
        }
        this.close();
        super.handlerRemoved(channelHandlerContext0);
    }

    private void initializeIfNecessary(ChannelHandlerContext channelHandlerContext0) {
        ByteBufAllocator byteBufAllocator1;
        InetSocketAddress inetSocketAddress3;
        InetSocketAddress inetSocketAddress2;
        ByteBufAllocator byteBufAllocator0;
        InetSocketAddress inetSocketAddress1;
        InetSocketAddress inetSocketAddress0;
        TCPFlag tCPPacket$TCPFlag0;
        ByteBuf byteBuf2;
        ByteBuf byteBuf1;
        if(this.state.get() != State.INIT) {
            return;
        }
        this.pCapWriter = new PcapWriter(this);
        if(this.channelType == null) {
            if(channelHandlerContext0.channel() instanceof SocketChannel) {
                this.channelType = ChannelType.TCP;
                if(channelHandlerContext0.channel().parent() instanceof ServerSocketChannel) {
                    this.isServerPipeline = true;
                    this.initiatorAddr = (InetSocketAddress)channelHandlerContext0.channel().remoteAddress();
                    this.handlerAddr = PcapWriteHandler.getLocalAddress(channelHandlerContext0.channel(), this.initiatorAddr);
                }
                else {
                    this.isServerPipeline = false;
                    this.handlerAddr = (InetSocketAddress)channelHandlerContext0.channel().remoteAddress();
                    this.initiatorAddr = PcapWriteHandler.getLocalAddress(channelHandlerContext0.channel(), this.handlerAddr);
                }
            }
            else if(channelHandlerContext0.channel() instanceof DatagramChannel) {
                this.channelType = ChannelType.UDP;
                if(((DatagramChannel)channelHandlerContext0.channel()).isConnected()) {
                    this.handlerAddr = (InetSocketAddress)channelHandlerContext0.channel().remoteAddress();
                    this.initiatorAddr = PcapWriteHandler.getLocalAddress(channelHandlerContext0.channel(), this.handlerAddr);
                }
            }
        }
        if(this.channelType == ChannelType.TCP) {
            this.logger.debug("Initiating Fake TCP 3-Way Handshake");
            ByteBuf byteBuf0 = channelHandlerContext0.alloc().buffer();
            try {
                TCPPacket.writePacket(byteBuf0, null, 0, 0, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), new TCPFlag[]{TCPFlag.SYN});
                byteBuf1 = byteBuf0;
                this.completeTCPWrite(this.initiatorAddr, this.handlerAddr, byteBuf1, channelHandlerContext0.alloc(), channelHandlerContext0);
                byteBuf2 = byteBuf1;
            }
            catch(Throwable throwable0) {
                byteBuf1.release();
                throw throwable0;
            }
            try {
                int v = this.handlerAddr.getPort();
                int v1 = this.initiatorAddr.getPort();
                tCPPacket$TCPFlag0 = TCPFlag.ACK;
                TCPPacket.writePacket(byteBuf2, null, 0, 1, v, v1, new TCPFlag[]{TCPFlag.SYN, tCPPacket$TCPFlag0});
                inetSocketAddress0 = this.handlerAddr;
                inetSocketAddress1 = this.initiatorAddr;
                byteBufAllocator0 = channelHandlerContext0.alloc();
                byteBuf1 = byteBuf2;
            }
            catch(Throwable throwable0) {
                byteBuf1 = byteBuf2;
                byteBuf1.release();
                throw throwable0;
            }
            try {
                this.completeTCPWrite(inetSocketAddress0, inetSocketAddress1, byteBuf1, byteBufAllocator0, channelHandlerContext0);
                byteBuf2 = byteBuf1;
            }
            catch(Throwable throwable0) {
                byteBuf1.release();
                throw throwable0;
            }
            try {
                TCPPacket.writePacket(byteBuf2, null, 1, 1, this.initiatorAddr.getPort(), this.handlerAddr.getPort(), new TCPFlag[]{tCPPacket$TCPFlag0});
                inetSocketAddress2 = this.initiatorAddr;
                inetSocketAddress3 = this.handlerAddr;
                byteBufAllocator1 = channelHandlerContext0.alloc();
                byteBuf1 = byteBuf2;
            }
            catch(Throwable throwable0) {
                byteBuf1 = byteBuf2;
                byteBuf1.release();
                throw throwable0;
            }
            try {
                this.completeTCPWrite(inetSocketAddress2, inetSocketAddress3, byteBuf1, byteBufAllocator1, channelHandlerContext0);
            }
            catch(Throwable throwable0) {
                byteBuf1.release();
                throw throwable0;
            }
            byteBuf1.release();
            this.logger.debug("Finished Fake TCP 3-Way Handshake");
        }
        this.state.set(State.WRITING);
    }

    public boolean isWriting() {
        return this.state.get() == State.WRITING;
    }

    private void logDiscard() {
        this.logger.warn("Discarding pcap write because channel type is unknown. The channel this handler is registered on is not a SocketChannel or DatagramChannel, so the inference does not work. Please call forceTcpChannel or forceUdpChannel before registering the handler.");
    }

    private void logTCP(boolean z, int v, int v1, int v2, InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, boolean z1) {
        if(this.logger.isDebugEnabled()) {
            if(z1) {
                this.logger.debug("Writing TCP ACK, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", new Object[]{Boolean.valueOf(z), v1, v2, inetSocketAddress1, inetSocketAddress0});
                return;
            }
            this.logger.debug("Writing TCP Data of {} Bytes, isWriteOperation {}, Segment Number {}, Ack Number {}, Src Addr {}, Dst Addr {}", new Object[]{v, Boolean.valueOf(z), v1, v2, inetSocketAddress0, inetSocketAddress1});
        }
    }

    public void markClosed() {
        Object object0 = this.state.get();
        State state0 = State.CLOSED;
        if(object0 != state0) {
            this.state.set(state0);
        }
    }

    public OutputStream outputStream() {
        return this.outputStream;
    }

    public PcapWriter pCapWriter() {
        return this.pCapWriter;
    }

    public void pause() {
        AtomicReference atomicReference0 = this.state;
        State state0 = State.WRITING;
        State state1 = State.PAUSED;
        do {
            if(atomicReference0.compareAndSet(state0, state1)) {
                return;
            }
        }
        while(atomicReference0.get() == state0);
        throw new IllegalStateException("State must be \'STARTED\' to pause but current state is: " + this.state);
    }

    public void resume() {
        AtomicReference atomicReference0 = this.state;
        State state0 = State.PAUSED;
        State state1 = State.WRITING;
        do {
            if(atomicReference0.compareAndSet(state0, state1)) {
                return;
            }
        }
        while(atomicReference0.get() == state0);
        throw new IllegalStateException("State must be \'PAUSED\' to resume but current state is: " + this.state);
    }

    public boolean sharedOutputStream() {
        return this.sharedOutputStream;
    }

    public State state() {
        return (State)this.state.get();
    }

    @Override
    public String toString() {
        return "PcapWriteHandler{captureZeroByte=" + this.captureZeroByte + ", writePcapGlobalHeader=" + this.writePcapGlobalHeader + ", sharedOutputStream=" + this.sharedOutputStream + ", sendSegmentNumber=" + this.sendSegmentNumber + ", receiveSegmentNumber=" + this.receiveSegmentNumber + ", channelType=" + this.channelType + ", initiatorAddr=" + this.initiatorAddr + ", handlerAddr=" + this.handlerAddr + ", isServerPipeline=" + this.isServerPipeline + ", state=" + this.state + '}';
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        if(this.state.get() == State.INIT) {
            this.initializeIfNecessary(channelHandlerContext0);
        }
        if(this.state.get() == State.WRITING) {
            ChannelType pcapWriteHandler$ChannelType0 = this.channelType;
            if(pcapWriteHandler$ChannelType0 == ChannelType.TCP) {
                this.handleTCP(channelHandlerContext0, object0, true);
            }
            else if(pcapWriteHandler$ChannelType0 == ChannelType.UDP) {
                this.handleUDP(channelHandlerContext0, object0);
            }
            else {
                this.logDiscard();
            }
        }
        super.write(channelHandlerContext0, object0, channelPromise0);
    }

    public static void writeGlobalHeader(OutputStream outputStream0) {
        PcapHeaders.writeGlobalHeader(outputStream0);
    }

    class io.netty.handler.pcap.PcapWriteHandler.1 {
    }

}

