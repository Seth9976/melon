package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import org.conscrypt.AllocatedBuffer;
import org.conscrypt.BufferAllocator;
import org.conscrypt.Conscrypt;
import org.conscrypt.HandshakeListener;

abstract class ConscryptAlpnSslEngine extends JdkSslEngine {
    static final class BufferAdapter extends AllocatedBuffer {
        private final ByteBuffer buffer;
        private final ByteBuf nettyBuffer;

        public BufferAdapter(ByteBuf byteBuf0) {
            this.nettyBuffer = byteBuf0;
            this.buffer = byteBuf0.nioBuffer(0, byteBuf0.capacity());
        }

        public ByteBuffer nioBuffer() {
            return this.buffer;
        }

        public AllocatedBuffer release() {
            this.nettyBuffer.release();
            return this;
        }

        public AllocatedBuffer retain() {
            this.nettyBuffer.retain();
            return this;
        }
    }

    static final class BufferAllocatorAdapter extends BufferAllocator {
        private final ByteBufAllocator alloc;

        public BufferAllocatorAdapter(ByteBufAllocator byteBufAllocator0) {
            this.alloc = byteBufAllocator0;
        }

        public AllocatedBuffer allocateDirectBuffer(int v) {
            return new BufferAdapter(this.alloc.directBuffer(v));
        }
    }

    static final class ClientEngine extends ConscryptAlpnSslEngine {
        private final ProtocolSelectionListener protocolListener;

        public ClientEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
            super(sSLEngine0, byteBufAllocator0, jdkApplicationProtocolNegotiator0.protocols(), null);
            Conscrypt.setHandshakeListener(sSLEngine0, new HandshakeListener() {
                public void onHandshakeFinished() {
                    ClientEngine.access$100(ClientEngine.this);
                }
            });
            this.protocolListener = (ProtocolSelectionListener)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator0.protocols()), "protocolListener");
        }

        public static void access$100(ClientEngine conscryptAlpnSslEngine$ClientEngine0) {
            conscryptAlpnSslEngine$ClientEngine0.selectProtocol();
        }

        private void selectProtocol() {
            String s = Conscrypt.getApplicationProtocol(this.getWrappedEngine());
            try {
                this.protocolListener.selected(s);
            }
            catch(Throwable throwable0) {
                throw SslUtils.toSSLHandshakeException(throwable0);
            }
        }
    }

    static final class ServerEngine extends ConscryptAlpnSslEngine {
        private final ProtocolSelector protocolSelector;

        public ServerEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
            super(sSLEngine0, byteBufAllocator0, jdkApplicationProtocolNegotiator0.protocols(), null);
            Conscrypt.setHandshakeListener(sSLEngine0, new HandshakeListener() {
                public void onHandshakeFinished() {
                    ServerEngine.this.selectProtocol();
                }
            });
            this.protocolSelector = (ProtocolSelector)ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator0.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator0.protocols())), "protocolSelector");
        }

        private void selectProtocol() {
            try {
                String s = Conscrypt.getApplicationProtocol(this.getWrappedEngine());
                List list0 = s == null ? Collections.EMPTY_LIST : Collections.singletonList(s);
                this.protocolSelector.select(list0);
                return;
            }
            catch(Throwable throwable0) {
            }
            throw SslUtils.toSSLHandshakeException(throwable0);
        }
    }

    private static final boolean USE_BUFFER_ALLOCATOR;

    static {
        ConscryptAlpnSslEngine.USE_BUFFER_ALLOCATOR = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.conscrypt.useBufferAllocator", true);
    }

    private ConscryptAlpnSslEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, List list0) {
        super(sSLEngine0);
        if(ConscryptAlpnSslEngine.USE_BUFFER_ALLOCATOR) {
            Conscrypt.setBufferAllocator(sSLEngine0, new BufferAllocatorAdapter(byteBufAllocator0));
        }
        Conscrypt.setApplicationProtocols(sSLEngine0, ((String[])list0.toArray(EmptyArrays.EMPTY_STRINGS)));
    }

    public ConscryptAlpnSslEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, List list0, io.netty.handler.ssl.ConscryptAlpnSslEngine.1 conscryptAlpnSslEngine$10) {
        this(sSLEngine0, byteBufAllocator0, list0);
    }

    public final int calculateOutNetBufSize(int v, int v1) {
        return this.calculateSpace(v, v1, 0x7FFFFFFFL);
    }

    public final int calculateRequiredOutBufSpace(int v, int v1) {
        return this.calculateSpace(v, v1, ((long)Conscrypt.maxEncryptedPacketLength()));
    }

    private int calculateSpace(int v, int v1, long v2) {
        return (int)Math.min(v2, ((long)v) + ((long)Conscrypt.maxSealOverhead(this.getWrappedEngine())) * ((long)v1));
    }

    public static ConscryptAlpnSslEngine newClientEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
        return new ClientEngine(sSLEngine0, byteBufAllocator0, jdkApplicationProtocolNegotiator0);
    }

    public static ConscryptAlpnSslEngine newServerEngine(SSLEngine sSLEngine0, ByteBufAllocator byteBufAllocator0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0) {
        return new ServerEngine(sSLEngine0, byteBufAllocator0, jdkApplicationProtocolNegotiator0);
    }

    public final SSLEngineResult unwrap(ByteBuffer[] arr_byteBuffer, ByteBuffer[] arr_byteBuffer1) {
        return Conscrypt.unwrap(this.getWrappedEngine(), arr_byteBuffer, arr_byteBuffer1);
    }

    class io.netty.handler.ssl.ConscryptAlpnSslEngine.1 {
    }

}

