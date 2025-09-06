package i.n.i.b.a.s.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class xi extends Kb {
    public final ContentResolver e;
    public Uri f;
    public AssetFileDescriptor g;
    public FileInputStream h;
    public long i;
    public boolean j;

    public xi(Context context0) {
        super(false);
        this.e = context0.getContentResolver();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        long v;
        try {
            Uri uri0 = w20.b;
            v = w20.g;
            long v1 = w20.f;
            this.f = uri0;
            this.c(w20);
            AssetFileDescriptor assetFileDescriptor0 = this.e.openAssetFileDescriptor(uri0, "r");
            this.g = assetFileDescriptor0;
            if(assetFileDescriptor0 == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + uri0);
            }
            long v2 = assetFileDescriptor0.getLength();
            FileInputStream fileInputStream0 = new FileInputStream(assetFileDescriptor0.getFileDescriptor());
            this.h = fileInputStream0;
            int v3 = Long.compare(v2, -1L);
            if(v3 != 0 && v1 > v2) {
                throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
            }
            long v4 = assetFileDescriptor0.getStartOffset();
            long v5 = fileInputStream0.skip(v4 + v1) - v4;
            if(v5 != v1) {
                throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
            }
            if(v3 == 0) {
                FileChannel fileChannel0 = fileInputStream0.getChannel();
                long v6 = fileChannel0.size();
                if(v6 == 0L) {
                    this.i = -1L;
                }
                else {
                    long v7 = v6 - fileChannel0.position();
                    this.i = v7;
                    if(v7 < 0L) {
                        throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
                    }
                }
            }
            else {
                long v8 = v2 - v5;
                this.i = v8;
                if(v8 < 0L) {
                    throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
                }
            }
        }
        catch(IOException iOException0) {
            throw new Ed(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        int v9 = Long.compare(v, -1L);
        if(v9 != 0) {
            this.i = this.i == -1L ? v : Math.min(this.i, v);
        }
        this.j = true;
        this.d(w20);
        return v9 == 0 ? this.i : v;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.f;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        try {
            try {
                this.f = null;
                FileInputStream fileInputStream0 = this.h;
                if(fileInputStream0 != null) {
                    fileInputStream0.close();
                }
                goto label_24;
            }
            catch(IOException iOException0) {
            }
            throw new Ed(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(Throwable throwable0) {
            try {
                this.h = null;
                AssetFileDescriptor assetFileDescriptor0 = this.g;
                if(assetFileDescriptor0 != null) {
                    assetFileDescriptor0.close();
                }
            }
            catch(IOException iOException1) {
                throw new Ed(iOException1);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
            finally {
                this.g = null;
                if(this.j) {
                    this.j = false;
                    this.h();
                }
            }
            throw throwable0;
        }
        try {
        label_24:
            this.h = null;
            AssetFileDescriptor assetFileDescriptor1 = this.g;
            if(assetFileDescriptor1 != null) {
                assetFileDescriptor1.close();
            }
        }
        catch(IOException iOException2) {
            throw new Ed(iOException2);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        finally {
            this.g = null;
            if(this.j) {
                this.j = false;
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
        long v2 = this.i;
        if(Long.compare(v2, 0L) == 0) {
            return -1;
        }
        try {
            if(v2 != -1L) {
                v1 = (int)Math.min(v2, v1);
            }
            v3 = this.h.read(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            throw new Ed(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        if(v3 == -1) {
            return -1;
        }
        long v4 = this.i;
        if(v4 != -1L) {
            this.i = v4 - ((long)v3);
        }
        this.g(v3);
        return v3;
    }
}

