package com.iloen.melon.mcache;

import A7.d;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.mcache.error.CodecErrorDebugLog;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.mcache.error.NetworkError.HostError;
import com.iloen.melon.mcache.error.ParamError.IllegalArgumentError;
import com.iloen.melon.mcache.util.MCacheLogListener;
import f9.e;
import f9.g;
import f9.h;
import f9.n;
import h9.c;
import h9.f;
import java.util.concurrent.TimeUnit;

public class MelonStreamCacheManager {
    public String a;
    public h b;
    public CodecErrorDebugLog codecErrorDebugLog;

    public void checkUserAgent(String s) {
        synchronized(this) {
            if("none_user_agent".equals(this.a)) {
                this.a = s;
                return;
            }
            if(this.a.equals(s)) {
                return;
            }
        }
        throw new MCacheError("Invalid user-agent:  " + s);
    }

    public CodecErrorDebugLog codecErrorReport(Uri uri0) {
        if(!this.b.b(uri0)) {
            return new CodecErrorDebugLog();
        }
        try {
            n n0 = new n();
            n0.l(uri0, 0L, "");
            String s = c.b((n0.q() + "&" + n0.h() + "&" + n0.E()));
            g.e(0L, s);
            this.codecErrorDebugLog.setDeletedFileName(s);
        }
        catch(Exception exception0) {
            f.d("MelonStreamCacheManager", exception0.getMessage());
        }
        return this.codecErrorDebugLog;
    }

    public String convertProxyUri(String s, String s1) {
        int v3;
        String s2;
        h h0 = this.b;
        if(TextUtils.isEmpty(h0.c)) {
            throw new HostError("CacheServer", "Could not get host address.");
        }
        if(!TextUtils.isEmpty(s)) {
            if(s.startsWith("mcache://")) {
                int v1 = s.indexOf("/smartstream") >= 0 ? s.indexOf("/smartstream") : s.indexOf("/prestream");
                if(v1 < 0) {
                    v1 = s.indexOf("/prestream");
                }
                if(v1 < 0) {
                    throw new IllegalArgumentError("CacheServer", "Can not support the path.\n" + s);
                }
                String s3 = s.substring(9, v1);
                int v2 = s3.indexOf(58);
                if(v2 > 0) {
                    v3 = Integer.parseInt(s3.substring(v2 + 1));
                    s3 = s3.substring(0, v2);
                }
                else {
                    v3 = 80;
                }
                StringBuilder stringBuilder1 = new StringBuilder(s.length() + 0x40);
                stringBuilder1.append("http://");
                stringBuilder1.append(h0.c);
                stringBuilder1.append(s.substring(v1));
                stringBuilder1.append("&_host=");
                d.t(stringBuilder1, s3, "&_port=", v3, "&_c=");
                stringBuilder1.append(s1);
                s2 = stringBuilder1.toString();
            label_33:
                f.b("MelonStreamCacheManager", "Converted Proxy Uri - " + s2);
                synchronized(this) {
                    this.a = "none_user_agent";
                }
                return s2;
            }
            else if(s.startsWith("file://")) {
                int v = s.indexOf("file://");
                if(v < 0) {
                    throw new IllegalArgumentError("CacheServer", "Can not support the path.\n" + s);
                }
                StringBuilder stringBuilder0 = new StringBuilder(s.length() + 0x40);
                stringBuilder0.append("http://");
                d.u(stringBuilder0, h0.c, "/localstream&localPath=", s.substring(v + 7), "&_c=");
                stringBuilder0.append(s1);
                s2 = stringBuilder0.toString();
                goto label_33;
            }
        }
        throw new IllegalArgumentError("CacheServer", s.substring(0, s.indexOf("://")) + " not supported protocol.");
    }

    public MCacheConnectionInfo getConnectionInfo() {
        return MCacheConnectionInfo.getInstance();
    }

    public static MelonStreamCacheManager getInstance() {
        return e.a;
    }

    public boolean isMelonStreamCacheUri(Uri uri0) {
        return this.b.b(uri0);
    }

    public boolean isRunning() {
        synchronized(this) {
            h h0 = this.b;
            boolean z = h0.a.get();
            if(z && h0.b.getCount() > 0L) {
                try {
                    f.b("CacheServer", "isRunning() - Waiting to start server.");
                    h0.b.await(100L, TimeUnit.MILLISECONDS);
                    z = true;
                }
                catch(InterruptedException unused_ex) {
                }
            }
            f.b("MelonStreamCacheManager", "isRunning() " + z);
            return z;
        }
    }

    public void reloadCachgingOption() {
        PropertyLoader.load();
    }

    public void setLogListener(MCacheLogListener mCacheLogListener0) {
        f.b.b = mCacheLogListener0;
    }

    public void startCaching() {
        synchronized(this) {
            if(!this.isRunning()) {
                PropertyLoader.load();
                try {
                    this.b.c();
                    f.f("MelonStreamCacheManager", "startCaching() - Server starting is completed.");
                    return;
                }
                catch(MCacheError mCacheError0) {
                    f.j("MelonStreamCacheManager", "Can\'t start cache server. - " + mCacheError0.toString());
                    this.b.a();
                    throw mCacheError0;
                }
            }
            f.f("MelonStreamCacheManager", "startCaching() - Server is already running.");
        }
    }

    public void stopCaching() {
        synchronized(this) {
            f.f("MelonStreamCacheManager", "stopCaching()");
            this.b.a();
        }
    }
}

