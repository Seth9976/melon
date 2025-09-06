package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

final class OpenSslPrivateKey extends AbstractReferenceCounted implements PrivateKey {
    final class OpenSslPrivateKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
        long certificateChain;
        private final X509Certificate[] x509CertificateChain;

        public OpenSslPrivateKeyMaterial(long v, X509Certificate[] arr_x509Certificate) {
            this.certificateChain = v;
            if(arr_x509Certificate == null) {
                arr_x509Certificate = EmptyArrays.EMPTY_X509_CERTIFICATES;
            }
            this.x509CertificateChain = arr_x509Certificate;
            openSslPrivateKey0.retain();
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public X509Certificate[] certificateChain() {
            return (X509Certificate[])this.x509CertificateChain.clone();
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public long certificateChainAddress() {
            if(this.refCnt() <= 0) {
                throw new IllegalReferenceCountException();
            }
            return this.certificateChain;
        }

        @Override  // io.netty.util.AbstractReferenceCounted
        public void deallocate() {
            this.releaseChain();
            OpenSslPrivateKey.this.release();
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public long privateKeyAddress() {
            if(this.refCnt() <= 0) {
                throw new IllegalReferenceCountException();
            }
            return OpenSslPrivateKey.this.privateKeyAddress();
        }

        private void releaseChain() {
            SSL.freeX509Chain(this.certificateChain);
            this.certificateChain = 0L;
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public OpenSslKeyMaterial retain() {
            super.retain();
            return this;
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public OpenSslKeyMaterial retain(int v) {
            super.retain(v);
            return this;
        }

        @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ReferenceCounted retain() {
            return this.retain();
        }

        @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
        public ReferenceCounted retain(int v) {
            return this.retain(v);
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public OpenSslKeyMaterial touch() {
            OpenSslPrivateKey.this.touch();
            return this;
        }

        @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
        public OpenSslKeyMaterial touch(Object object0) {
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
    }

    private long privateKeyAddress;

    public OpenSslPrivateKey(long v) {
        this.privateKeyAddress = v;
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        SSL.freePrivateKey(this.privateKeyAddress);
        this.privateKeyAddress = 0L;
    }

    @Override  // javax.security.auth.Destroyable
    public void destroy() {
        this.release(this.refCnt());
    }

    @Override
    public String getAlgorithm() {
        return "unknown";
    }

    @Override
    public byte[] getEncoded() {
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override  // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.refCnt() == 0;
    }

    public OpenSslKeyMaterial newKeyMaterial(long v, X509Certificate[] arr_x509Certificate) {
        return new OpenSslPrivateKeyMaterial(this, v, arr_x509Certificate);
    }

    private long privateKeyAddress() {
        if(this.refCnt() <= 0) {
            throw new IllegalReferenceCountException();
        }
        return this.privateKeyAddress;
    }

    public OpenSslPrivateKey retain() {
        super.retain();
        return this;
    }

    public OpenSslPrivateKey retain(int v) {
        super.retain(v);
        return this;
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    public OpenSslPrivateKey touch() {
        super.touch();
        return this;
    }

    public OpenSslPrivateKey touch(Object object0) [...] // Inlined contents

    @Override  // io.netty.util.AbstractReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this;
    }
}

