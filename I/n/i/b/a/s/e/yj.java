package i.n.i.b.a.s.e;

import U4.x;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class yj extends Kb {
    public final Resources e;
    public final String f;
    public Uri g;
    public AssetFileDescriptor h;
    public FileInputStream i;
    public long j;
    public boolean k;

    public yj(Context context0) {
        super(false);
        this.e = context0.getResources();
        this.f = "com.iloen.melon";
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        AssetFileDescriptor assetFileDescriptor0;
        int v2;
        Uri uri0 = w20.b;
        long v = w20.g;
        long v1 = w20.f;
        this.g = uri0;
        boolean z = TextUtils.equals("rawresource", uri0.getScheme());
        Resources resources0 = this.e;
        if(z) {
            try {
            label_21:
                String s3 = uri0.getLastPathSegment();
                s3.getClass();
                v2 = Integer.parseInt(s3);
            }
            catch(NumberFormatException unused_ex) {
                throw new Zd("Resource identifier must be an integer.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
        }
        else if(TextUtils.equals("android.resource", uri0.getScheme()) && uri0.getPathSegments().size() == 1) {
            String s = uri0.getLastPathSegment();
            s.getClass();
            if(s.matches("\\d+")) {
                goto label_21;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            if(!TextUtils.equals("android.resource", uri0.getScheme())) {
                throw new Zd("URI must either use scheme rawresource or android.resource");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            String s1 = uri0.getPath();
            s1.getClass();
            if(s1.startsWith("/")) {
                s1 = s1.substring(1);
            }
            String s2 = uri0.getHost();
            v2 = resources0.getIdentifier(x.m(new StringBuilder(), (TextUtils.isEmpty(s2) ? "" : s2 + ":"), s1), "raw", this.f);
            if(v2 == 0) {
                throw new Zd("Resource not found.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
        }
        this.c(w20);
        try {
            assetFileDescriptor0 = resources0.openRawResourceFd(v2);
            this.h = assetFileDescriptor0;
        }
        catch(Resources.NotFoundException resources$NotFoundException0) {
            throw new Zd(resources$NotFoundException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        if(assetFileDescriptor0 == null) {
            throw new Zd("Resource is compressed: " + uri0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        long v3 = assetFileDescriptor0.getLength();
        FileInputStream fileInputStream0 = new FileInputStream(assetFileDescriptor0.getFileDescriptor());
        this.i = fileInputStream0;
        int v4 = Long.compare(v3, -1L);
        try {
            if(v4 != 0 && v1 > v3) {
                throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
            }
            long v5 = assetFileDescriptor0.getStartOffset();
            long v6 = fileInputStream0.skip(v5 + v1) - v5;
            if(v6 != v1) {
                throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
            }
            if(v4 == 0) {
                FileChannel fileChannel0 = fileInputStream0.getChannel();
                if(fileChannel0.size() == 0L) {
                    this.j = -1L;
                }
                else {
                    long v7 = fileChannel0.size() - fileChannel0.position();
                    this.j = v7;
                    if(v7 < 0L) {
                        throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
                    }
                }
            }
            else {
                long v8 = v3 - v6;
                this.j = v8;
                if(v8 < 0L) {
                    throw new y1();  // 初始化器: Ljava/io/IOException;-><init>()V
                }
            }
        }
        catch(IOException iOException0) {
            throw new Zd(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        int v9 = Long.compare(v, -1L);
        if(v9 != 0) {
            this.j = this.j == -1L ? v : Math.min(this.j, v);
        }
        this.k = true;
        this.d(w20);
        return v9 == 0 ? this.j : v;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.g;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        try {
            try {
                this.g = null;
                FileInputStream fileInputStream0 = this.i;
                if(fileInputStream0 != null) {
                    fileInputStream0.close();
                }
                goto label_24;
            }
            catch(IOException iOException0) {
            }
            throw new Zd(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(Throwable throwable0) {
            try {
                this.i = null;
                AssetFileDescriptor assetFileDescriptor0 = this.h;
                if(assetFileDescriptor0 != null) {
                    assetFileDescriptor0.close();
                }
            }
            catch(IOException iOException1) {
                throw new Zd(iOException1);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
            finally {
                this.h = null;
                if(this.k) {
                    this.k = false;
                    this.h();
                }
            }
            throw throwable0;
        }
        try {
        label_24:
            this.i = null;
            AssetFileDescriptor assetFileDescriptor1 = this.h;
            if(assetFileDescriptor1 != null) {
                assetFileDescriptor1.close();
            }
        }
        catch(IOException iOException2) {
            throw new Zd(iOException2);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        finally {
            this.h = null;
            if(this.k) {
                this.k = false;
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
        long v2 = this.j;
        if(Long.compare(v2, 0L) != 0) {
            try {
                if(v2 != -1L) {
                    v1 = (int)Math.min(v2, v1);
                }
                v3 = this.i.read(arr_b, v, v1);
            }
            catch(IOException iOException0) {
                throw new Zd(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
            if(v3 != -1) {
                long v4 = this.j;
                if(v4 != -1L) {
                    this.j = v4 - ((long)v3);
                }
                this.g(v3);
                return v3;
            }
            else if(this.j != -1L) {
                throw new Zd(new EOFException());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
        }
        return -1;
    }
}

