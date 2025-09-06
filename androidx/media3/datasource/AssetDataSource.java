package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import g3.a;
import g3.b;
import g3.j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends b {
    public final AssetManager e;
    public Uri f;
    public InputStream g;
    public long h;
    public boolean i;

    public AssetDataSource(Context context0) {
        super(false);
        this.e = context0.getAssets();
    }

    @Override  // g3.f
    public final void close() {
        try {
            this.f = null;
            InputStream inputStream0 = this.g;
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
        catch(IOException iOException0) {
            throw new a(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        finally {
            this.g = null;
            if(this.i) {
                this.i = false;
                this.b();
            }
        }
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.f;
    }

    @Override  // g3.f
    public final long p(j j0) {
        try {
            long v = j0.e;
            this.f = j0.a;
            String s = j0.a.getPath();
            s.getClass();
            if(s.startsWith("/android_asset/")) {
                s = s.substring(15);
            }
            else if(s.startsWith("/")) {
                s = s.substring(1);
            }
            this.c();
            InputStream inputStream0 = this.e.open(s, 1);
            this.g = inputStream0;
            if(inputStream0.skip(v) < v) {
                throw new a(2008, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
            }
            long v1 = j0.f;
            if(v1 == -1L) {
                long v2 = (long)this.g.available();
                this.h = v2;
                if(v2 == 0x7FFFFFFFL) {
                    this.h = -1L;
                }
            }
            else {
                this.h = v1;
            }
            goto label_28;
        }
        catch(a a0) {
        }
        catch(IOException iOException0) {
            throw new a((iOException0 instanceof FileNotFoundException ? 2005 : 2000), iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        throw a0;
    label_28:
        this.i = true;
        this.d(j0);
        return this.h;
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        int v3;
        if(v1 == 0) {
            return 0;
        }
        long v2 = this.h;
        if(Long.compare(v2, 0L) != 0) {
            try {
                if(v2 != -1L) {
                    v1 = (int)Math.min(v2, v1);
                }
                v3 = this.g.read(arr_b, v, v1);
            }
            catch(IOException iOException0) {
                throw new a(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
            }
            if(v3 != -1) {
                long v4 = this.h;
                if(v4 != -1L) {
                    this.h = v4 - ((long)v3);
                }
                this.a(v3);
                return v3;
            }
        }
        return -1;
    }
}

