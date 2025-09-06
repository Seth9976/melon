package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public final class PemX509Certificate extends X509Certificate implements PemEncoded {
    private static final byte[] BEGIN_CERT;
    private static final byte[] END_CERT;
    private final ByteBuf content;

    static {
        PemX509Certificate.BEGIN_CERT = new byte[]{45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 0x20, 67, 69, 82, 84, 73, 70, 73, 67, 65, 84, 69, 45, 45, 45, 45, 45, 10};
        PemX509Certificate.END_CERT = new byte[]{10, 45, 45, 45, 45, 45, 69, 78, 68, 0x20, 67, 69, 82, 84, 73, 70, 73, 67, 65, 84, 69, 45, 45, 45, 45, 45, 10};
    }

    private PemX509Certificate(ByteBuf byteBuf0) {
        this.content = (ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "content");
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator0, boolean z, PemEncoded pemEncoded0, int v, ByteBuf byteBuf0) {
        ByteBuf byteBuf1 = pemEncoded0.content();
        if(byteBuf0 == null) {
            byteBuf0 = PemX509Certificate.newBuffer(byteBufAllocator0, z, byteBuf1.readableBytes() * v);
        }
        byteBuf0.writeBytes(byteBuf1.slice());
        return byteBuf0;
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator0, boolean z, X509Certificate x509Certificate0, int v, ByteBuf byteBuf0) {
        ByteBuf byteBuf1 = Unpooled.wrappedBuffer(x509Certificate0.getEncoded());
        try {
            ByteBuf byteBuf2 = SslUtils.toBase64(byteBufAllocator0, byteBuf1);
            try {
                if(byteBuf0 == null) {
                    int v2 = byteBuf2.readableBytes();
                    byteBuf0 = PemX509Certificate.newBuffer(byteBufAllocator0, z, (PemX509Certificate.BEGIN_CERT.length + v2 + PemX509Certificate.END_CERT.length) * v);
                }
                byteBuf0.writeBytes(PemX509Certificate.BEGIN_CERT);
                byteBuf0.writeBytes(byteBuf2);
                byteBuf0.writeBytes(PemX509Certificate.END_CERT);
            }
            catch(Throwable throwable0) {
                byteBuf2.release();
                throw throwable0;
            }
            byteBuf2.release();
            return byteBuf0;
        }
        finally {
            byteBuf1.release();
        }
    }

    @Override
    public void checkValidity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void checkValidity(Date date0) {
        throw new UnsupportedOperationException();
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

    public PemX509Certificate copy() {
        return this.replace(this.content.copy());
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return this.duplicate();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded duplicate() {
        return this.duplicate();
    }

    public PemX509Certificate duplicate() {
        return this.replace(this.content.duplicate());
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof PemX509Certificate ? this.content.equals(((PemX509Certificate)object0).content) : false;
    }

    @Override
    public int getBasicConstraints() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set getCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getExtensionValue(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Principal getIssuerDN() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean[] getIssuerUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean[] getKeyUsage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set getNonCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date getNotAfter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Date getNotBefore() {
        throw new UnsupportedOperationException();
    }

    @Override
    public PublicKey getPublicKey() {
        throw new UnsupportedOperationException();
    }

    @Override
    public BigInteger getSerialNumber() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSigAlgName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getSigAlgOID() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getSigAlgParams() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getSignature() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Principal getSubjectDN() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean[] getSubjectUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getTBSCertificate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasUnsupportedCriticalExtension() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return false;
    }

    // 去混淆评级： 低(20)
    private static ByteBuf newBuffer(ByteBufAllocator byteBufAllocator0, boolean z, int v) {
        return z ? byteBufAllocator0.directBuffer(v) : byteBufAllocator0.buffer(v);
    }

    @Override  // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return this.content.release(v);
    }

    @Override  // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    @Override  // io.netty.handler.ssl.PemEncoded
    public PemEncoded replace(ByteBuf byteBuf0) {
        return this.replace(byteBuf0);
    }

    public PemX509Certificate replace(ByteBuf byteBuf0) {
        return new PemX509Certificate(byteBuf0);
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

    public PemX509Certificate retain() {
        this.content.retain();
        return this;
    }

    public PemX509Certificate retain(int v) {
        this.content.retain(v);
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.ReferenceCounted
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

    public PemX509Certificate retainedDuplicate() {
        return this.replace(this.content.retainedDuplicate());
    }

    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator0, boolean z, X509Certificate[] arr_x509Certificate) {
        ByteBuf byteBuf0;
        ObjectUtil.checkNonEmpty(arr_x509Certificate, "chain");
        if(arr_x509Certificate.length == 1) {
            X509Certificate x509Certificate0 = arr_x509Certificate[0];
            if(x509Certificate0 instanceof PemEncoded) {
                return ((PemEncoded)x509Certificate0).retain();
            }
        }
        try {
            byteBuf0 = null;
            for(int v = 0; v < arr_x509Certificate.length; ++v) {
                X509Certificate x509Certificate1 = arr_x509Certificate[v];
                if(x509Certificate1 == null) {
                    throw new IllegalArgumentException("Null element in chain: " + Arrays.toString(arr_x509Certificate));
                }
                byteBuf0 = x509Certificate1 instanceof PemEncoded ? PemX509Certificate.append(byteBufAllocator0, z, ((PemEncoded)x509Certificate1), arr_x509Certificate.length, byteBuf0) : PemX509Certificate.append(byteBufAllocator0, z, x509Certificate1, arr_x509Certificate.length, byteBuf0);
            }
            return new PemValue(byteBuf0, false);
        label_16:
            if(byteBuf0 == null) {
                throw throwable0;
            }
        }
        catch(Throwable throwable0) {
            goto label_16;
        }
        byteBuf0.release();
        throw throwable0;
    }

    @Override
    public String toString() {
        return this.content.toString(CharsetUtil.UTF_8);
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

    public PemX509Certificate touch() {
        this.content.touch();
        return this;
    }

    public PemX509Certificate touch(Object object0) {
        this.content.touch(object0);
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    public static PemX509Certificate valueOf(ByteBuf byteBuf0) {
        return new PemX509Certificate(byteBuf0);
    }

    public static PemX509Certificate valueOf(byte[] arr_b) {
        return PemX509Certificate.valueOf(Unpooled.wrappedBuffer(arr_b));
    }

    @Override
    public void verify(PublicKey publicKey0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void verify(PublicKey publicKey0, String s) {
        throw new UnsupportedOperationException();
    }
}

