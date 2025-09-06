package g3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.datasource.AssetDataSource;
import androidx.media3.datasource.ContentDataSource;
import androidx.media3.datasource.RawResourceDataSource;
import e3.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public final class k implements f {
    public final Context a;
    public final ArrayList b;
    public final f c;
    public p d;
    public AssetDataSource e;
    public ContentDataSource f;
    public f g;
    public z h;
    public d i;
    public RawResourceDataSource j;
    public f k;

    public k(Context context0, f f0) {
        this.a = context0.getApplicationContext();
        f0.getClass();
        this.c = f0;
        this.b = new ArrayList();
    }

    public final void a(f f0) {
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.b;
            if(v >= arrayList0.size()) {
                break;
            }
            f0.r(((x)arrayList0.get(v)));
        }
    }

    public static void b(f f0, x x0) {
        if(f0 != null) {
            f0.r(x0);
        }
    }

    @Override  // g3.f
    public final void close() {
        f f0 = this.k;
        if(f0 != null) {
            try {
                f0.close();
                this.k = null;
            }
            catch(Throwable throwable0) {
                this.k = null;
                throw throwable0;
            }
        }
    }

    @Override  // g3.f
    public final Map getResponseHeaders() {
        return this.k == null ? Collections.EMPTY_MAP : this.k.getResponseHeaders();
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.k == null ? null : this.k.getUri();
    }

    @Override  // g3.f
    public final long p(j j0) {
        b.j(this.k == null);
        Uri uri0 = j0.a;
        String s = uri0.getScheme();
        String s1 = uri0.getScheme();
        boolean z = TextUtils.isEmpty(s1);
        Context context0 = this.a;
        if(!z && !"file".equals(s1)) {
            if("asset".equals(s)) {
                if(this.e == null) {
                    AssetDataSource assetDataSource0 = new AssetDataSource(context0);
                    this.e = assetDataSource0;
                    this.a(assetDataSource0);
                }
                this.k = this.e;
                return this.k.p(j0);
            }
            if("content".equals(s)) {
                if(this.f == null) {
                    ContentDataSource contentDataSource0 = new ContentDataSource(context0);
                    this.f = contentDataSource0;
                    this.a(contentDataSource0);
                }
                this.k = this.f;
                return this.k.p(j0);
            }
            f f0 = this.c;
            if("rtmp".equals(s)) {
                if(this.g == null) {
                    try {
                        f f1 = (f)Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.g = f1;
                        this.a(f1);
                    }
                    catch(ClassNotFoundException unused_ex) {
                        b.D("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    }
                    catch(Exception exception0) {
                        throw new RuntimeException("Error instantiating RTMP extension", exception0);
                    }
                    if(this.g == null) {
                        this.g = f0;
                    }
                }
                this.k = this.g;
                return this.k.p(j0);
            }
            if("udp".equals(s)) {
                if(this.h == null) {
                    z z1 = new z();
                    this.h = z1;
                    this.a(z1);
                }
                this.k = this.h;
                return this.k.p(j0);
            }
            if("data".equals(s)) {
                if(this.i == null) {
                    d d0 = new d(false);  // 初始化器: Lg3/b;-><init>(Z)V
                    this.i = d0;
                    this.a(d0);
                }
                this.k = this.i;
                return this.k.p(j0);
            }
            if(!"rawresource".equals(s) && !"android.resource".equals(s)) {
                this.k = f0;
                return this.k.p(j0);
            }
            if(this.j == null) {
                RawResourceDataSource rawResourceDataSource0 = new RawResourceDataSource(context0);
                this.j = rawResourceDataSource0;
                this.a(rawResourceDataSource0);
            }
            this.k = this.j;
            return this.k.p(j0);
        }
        String s2 = uri0.getPath();
        if(s2 != null && s2.startsWith("/android_asset/")) {
            if(this.e == null) {
                AssetDataSource assetDataSource1 = new AssetDataSource(context0);
                this.e = assetDataSource1;
                this.a(assetDataSource1);
            }
            this.k = this.e;
            return this.k.p(j0);
        }
        if(this.d == null) {
            p p0 = new p(false);  // 初始化器: Lg3/b;-><init>(Z)V
            this.d = p0;
            this.a(p0);
        }
        this.k = this.d;
        return this.k.p(j0);
    }

    @Override  // g3.f
    public final void r(x x0) {
        x0.getClass();
        this.c.r(x0);
        this.b.add(x0);
        k.b(this.d, x0);
        k.b(this.e, x0);
        k.b(this.f, x0);
        k.b(this.g, x0);
        k.b(this.h, x0);
        k.b(this.i, x0);
        k.b(this.j, x0);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        f f0 = this.k;
        f0.getClass();
        return f0.read(arr_b, v, v1);
    }
}

