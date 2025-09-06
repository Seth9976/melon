package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.net.ssl.X509KeyManager;

final class OpenSslCachingKeyMaterialProvider extends OpenSslKeyMaterialProvider {
    private final ConcurrentMap cache;
    private volatile boolean full;
    private final int maxCachedEntries;

    public OpenSslCachingKeyMaterialProvider(X509KeyManager x509KeyManager0, String s, int v) {
        super(x509KeyManager0, s);
        this.cache = new ConcurrentHashMap();
        this.maxCachedEntries = v;
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterialProvider
    public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator0, String s) {
        OpenSslKeyMaterial openSslKeyMaterial0 = (OpenSslKeyMaterial)this.cache.get(s);
        if(openSslKeyMaterial0 == null) {
            openSslKeyMaterial0 = super.chooseKeyMaterial(byteBufAllocator0, s);
            if(openSslKeyMaterial0 == null) {
                return null;
            }
            if(this.full) {
                return openSslKeyMaterial0;
            }
            if(this.cache.size() > this.maxCachedEntries) {
                this.full = true;
                return openSslKeyMaterial0;
            }
            OpenSslKeyMaterial openSslKeyMaterial1 = (OpenSslKeyMaterial)this.cache.putIfAbsent(s, openSslKeyMaterial0);
            if(openSslKeyMaterial1 != null) {
                openSslKeyMaterial0.release();
                openSslKeyMaterial0 = openSslKeyMaterial1;
            }
        }
        return openSslKeyMaterial0.retain();
    }

    @Override  // io.netty.handler.ssl.OpenSslKeyMaterialProvider
    public void destroy() {
        do {
            Iterator iterator0 = this.cache.values().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                ((OpenSslKeyMaterial)object0).release();
                iterator0.remove();
            }
        }
        while(!this.cache.isEmpty());
    }
}

