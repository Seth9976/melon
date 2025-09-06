package i.n.i.b.a.s.e;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public final class si extends Kb {
    public final AssetManager e;
    public Uri f;
    public InputStream g;
    public long h;
    public boolean i;

    public si(Context context0) {
        super(false);
        this.e = context0.getAssets();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        try {
            long v = w20.f;
            this.f = w20.b;
            String s = w20.b.getPath();
            s.getClass();
            if(s.startsWith("/android_asset/")) {
                s = s.substring(15);
            }
            else if(s.startsWith("/")) {
                s = s.substring(1);
            }
            this.c(w20);
            InputStream inputStream0 = this.e.open(s, 1);
            this.g = inputStream0;
            if(inputStream0.skip(v) < v) {
                throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
            }
            long v1 = w20.g;
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
        }
        catch(IOException iOException0) {
            throw new Ba(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        this.i = true;
        this.d(w20);
        return this.h;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.f;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        try {
            this.f = null;
            InputStream inputStream0 = this.g;
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
        catch(IOException iOException0) {
            throw new Ba(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        finally {
            this.g = null;
            if(this.i) {
                this.i = false;
                this.h();
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        int v3;
        if(v1 == 0) {
            return 0;
        }
        long v2 = this.h;
        if(Long.compare(v2, 0L) == 0) {
            return -1;
        }
        try {
            if(v2 != -1L) {
                v1 = (int)Math.min(v2, v1);
            }
            v3 = this.g.read(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            throw new Ba(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        if(v3 == -1) {
            return -1;
        }
        long v4 = this.h;
        if(v4 != -1L) {
            this.h = v4 - ((long)v3);
        }
        this.g(v3);
        return v3;
    }
}

