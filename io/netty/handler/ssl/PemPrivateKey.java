package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.security.PrivateKey;

public final class PemPrivateKey extends AbstractReferenceCounted implements PemEncoded, PrivateKey {
    private static final byte[] BEGIN_PRIVATE_KEY = null;
    private static final byte[] END_PRIVATE_KEY = null;
    private static final String PKCS8_FORMAT = "PKCS#8";
    private final ByteBuf content;
    private static final long serialVersionUID = 0x6EB79C9D9BA22F38L;

    static {
        PemPrivateKey.BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n".getBytes(CharsetUtil.US_ASCII);
        PemPrivateKey.END_PRIVATE_KEY = "\n-----END PRIVATE KEY-----\n".getBytes(CharsetUtil.US_ASCII);
    }

    private PemPrivateKey(ByteBuf byteBuf0) {
        this.content = (ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "content");
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int v = this.refCnt();
        if(v <= 0) {
            throw new IllegalReferenceCountException(v);
        }
        return this.content;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return this.copy();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded copy() {
        return this.copy();
    }

    public PemPrivateKey copy() {
        return this.replace(this.content.copy());
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        SslUtils.zerooutAndRelease(this.content);
    }

    @Override  // javax.security.auth.Destroyable
    public void destroy() {
        this.release(this.refCnt());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return this.duplicate();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded duplicate() {
        return this.duplicate();
    }

    public PemPrivateKey duplicate() {
        return this.replace(this.content.duplicate());
    }

    @Override
    public String getAlgorithm() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getFormat() {
        return "PKCS#8";
    }

    @Override  // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.refCnt() == 0;
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    public PemPrivateKey replace(ByteBuf byteBuf0) {
        return new PemPrivateKey(byteBuf0);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded retain() {
        return this.retain();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded retain(int v) {
        return this.retain(v);
    }

    public PemPrivateKey retain() {
        return (PemPrivateKey)super.retain();
    }

    public PemPrivateKey retain(int v) {
        return (PemPrivateKey)super.retain(v);
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return this.retainedDuplicate();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded retainedDuplicate() {
        return this.retainedDuplicate();
    }

    public PemPrivateKey retainedDuplicate() {
        return this.replace(this.content.retainedDuplicate());
    }

    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator0, boolean z, PrivateKey privateKey0) {
        if(privateKey0 instanceof PemEncoded) {
            return ((PemEncoded)privateKey0).retain();
        }
        byte[] arr_b = privateKey0.getEncoded();
        if(arr_b == null) {
            throw new IllegalArgumentException(privateKey0.getClass().getName() + " does not support encoding");
        }
        return PemPrivateKey.toPEM(byteBufAllocator0, z, arr_b);
    }

    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator0, boolean z, byte[] arr_b) {
        ByteBuf byteBuf0 = Unpooled.wrappedBuffer(arr_b);
        try {
            ByteBuf byteBuf1 = SslUtils.toBase64(byteBufAllocator0, byteBuf0);
            try {
                int v2 = byteBuf1.readableBytes();
                int v3 = PemPrivateKey.BEGIN_PRIVATE_KEY.length + v2 + PemPrivateKey.END_PRIVATE_KEY.length;
                ByteBuf byteBuf2 = z ? byteBufAllocator0.directBuffer(v3) : byteBufAllocator0.buffer(v3);
                try {
                    byteBuf2.writeBytes(PemPrivateKey.BEGIN_PRIVATE_KEY);
                    byteBuf2.writeBytes(byteBuf1);
                    byteBuf2.writeBytes(PemPrivateKey.END_PRIVATE_KEY);
                    return new PemValue(byteBuf2, true);
                }
                catch(Throwable throwable0) {
                    SslUtils.zerooutAndRelease(byteBuf2);
                    throw throwable0;
                }
            }
            finally {
                SslUtils.zerooutAndRelease(byteBuf1);
            }
        }
        finally {
            SslUtils.zerooutAndRelease(byteBuf0);
        }
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded touch() {
        return this.touch();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded touch(Object object0) {
        return this.touch(object0);
    }

    public PemPrivateKey touch() {
        this.content.touch();
        return this;
    }

    public PemPrivateKey touch(Object object0) {
        this.content.touch(object0);
        return this;
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    public static PemPrivateKey valueOf(ByteBuf byteBuf0) {
        return new PemPrivateKey(byteBuf0);
    }

    public static PemPrivateKey valueOf(byte[] arr_b) {
        return PemPrivateKey.valueOf(Unpooled.wrappedBuffer(arr_b));
    }
}

