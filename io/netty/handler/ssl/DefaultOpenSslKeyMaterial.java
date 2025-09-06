package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import java.security.cert.X509Certificate;

final class DefaultOpenSslKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
    static final boolean $assertionsDisabled;
    private long chain;
    private final ResourceLeakTracker leak;
    private static final ResourceLeakDetector leakDetector;
    private long privateKey;
    private final X509Certificate[] x509CertificateChain;

    static {
        DefaultOpenSslKeyMaterial.leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DefaultOpenSslKeyMaterial.class);
    }

    public DefaultOpenSslKeyMaterial(long v, long v1, X509Certificate[] arr_x509Certificate) {
        this.chain = v;
        this.privateKey = v1;
        this.x509CertificateChain = arr_x509Certificate;
        this.leak = DefaultOpenSslKeyMaterial.leakDetector.track(this);
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
        return this.chain;
    }

    @Override  // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        SSL.freeX509Chain(this.chain);
        this.chain = 0L;
        SSL.freePrivateKey(this.privateKey);
        this.privateKey = 0L;
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.close(this);
        }
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
    public long privateKeyAddress() {
        if(this.refCnt() <= 0) {
            throw new IllegalReferenceCountException();
        }
        return this.privateKey;
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.handler.ssl.OpenSslKeyMaterial
    public boolean release() {
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.record();
        }
        return super.release();
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.handler.ssl.OpenSslKeyMaterial
    public boolean release(int v) {
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.record();
        }
        return super.release(v);
    }

    public DefaultOpenSslKeyMaterial retain() {
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.record();
        }
        super.retain();
        return this;
    }

    public DefaultOpenSslKeyMaterial retain(int v) {
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.record();
        }
        super.retain(v);
        return this;
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
    public OpenSslKeyMaterial retain() {
        return this.retain();
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
    public OpenSslKeyMaterial retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    public DefaultOpenSslKeyMaterial touch() {
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.record();
        }
        super.touch();
        return this;
    }

    public DefaultOpenSslKeyMaterial touch(Object object0) {
        ResourceLeakTracker resourceLeakTracker0 = this.leak;
        if(resourceLeakTracker0 != null) {
            resourceLeakTracker0.record(object0);
        }
        return this;
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
    public OpenSslKeyMaterial touch() {
        return this.touch();
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterial
    public OpenSslKeyMaterial touch(Object object0) {
        return this.touch(object0);
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

