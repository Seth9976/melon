package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import g3.b;
import g3.g;
import g3.j;
import g3.v;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

public final class RawResourceDataSource extends b {
    public final Context e;
    public j f;
    public AssetFileDescriptor g;
    public FileInputStream h;
    public long i;
    public boolean j;

    public RawResourceDataSource(Context context0) {
        super(false);
        this.e = context0.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int v) {
        return Uri.parse(("rawresource:///" + v));
    }

    @Override  // g3.f
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
            throw new v(2000, iOException0, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
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
                throw new v(2000, iOException1, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
            finally {
                this.g = null;
                if(this.j) {
                    this.j = false;
                    this.b();
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
            throw new v(2000, iOException2, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        finally {
            this.g = null;
            if(this.j) {
                this.j = false;
                this.b();
            }
        }
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.f == null ? null : this.f.a;
    }

    @Override  // g3.f
    public final long p(j j0) {
        AssetFileDescriptor assetFileDescriptor0;
        int v3;
        Resources resources1;
        int v2;
        Resources resources0;
        this.f = j0;
        this.c();
        long v = j0.f;
        long v1 = j0.e;
        Uri uri0 = j0.a.normalizeScheme();
        boolean z = TextUtils.equals("rawresource", uri0.getScheme());
        Context context0 = this.e;
        if(z) {
            resources0 = context0.getResources();
            List list0 = uri0.getPathSegments();
            if(list0.size() == 1) {
                String s = (String)list0.get(0);
                try {
                    v2 = Integer.parseInt(s);
                    goto label_37;
                }
                catch(NumberFormatException unused_ex) {
                    throw new v(1004, null, "Resource identifier must be an integer.");  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
                }
            }
            throw new v(2000, null, "rawresource:// URI must have exactly one path element, found " + list0.size());  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        if(!TextUtils.equals("android.resource", uri0.getScheme())) {
            throw new v(1004, null, "Unsupported URI scheme (" + uri0.getScheme() + "). Only android.resource is supported.");  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        String s1 = uri0.getPath();
        s1.getClass();
        if(s1.startsWith("/")) {
            s1 = s1.substring(1);
        }
        String s2 = TextUtils.isEmpty(uri0.getHost()) ? "com.iloen.melon" : uri0.getHost();
        if(s2.equals("com.iloen.melon")) {
            resources1 = context0.getResources();
        }
        else {
            try {
                resources1 = context0.getPackageManager().getResourcesForApplication(s2);
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                throw new v(2005, packageManager$NameNotFoundException0, "Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.");  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
        }
        if(s1.matches("\\d+")) {
            try {
                v3 = Integer.parseInt(s1);
            }
            catch(NumberFormatException unused_ex) {
                throw new v(1004, null, "Resource identifier must be an integer.");  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
        }
        else {
            v3 = resources1.getIdentifier(s2 + ":" + s1, "raw", null);
            if(v3 == 0) {
                throw new v(2005, null, "Resource not found.");  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
        }
        v2 = v3;
        resources0 = resources1;
        try {
        label_37:
            assetFileDescriptor0 = resources0.openRawResourceFd(v2);
        }
        catch(Resources.NotFoundException resources$NotFoundException0) {
            throw new v(2005, resources$NotFoundException0, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        if(assetFileDescriptor0 == null) {
            throw new v(2000, null, "Resource is compressed: " + uri0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        this.g = assetFileDescriptor0;
        long v4 = assetFileDescriptor0.getLength();
        FileInputStream fileInputStream0 = new FileInputStream(this.g.getFileDescriptor());
        this.h = fileInputStream0;
        int v5 = Long.compare(v4, -1L);
        try {
            if(v5 != 0 && v1 > v4) {
                throw new v(2008, null, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
            long v7 = this.g.getStartOffset();
            long v8 = fileInputStream0.skip(v7 + v1) - v7;
            if(v8 != v1) {
                throw new v(2008, null, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
            if(v5 == 0) {
                FileChannel fileChannel0 = fileInputStream0.getChannel();
                if(fileChannel0.size() == 0L) {
                    this.i = -1L;
                }
                else {
                    long v9 = fileChannel0.size() - fileChannel0.position();
                    this.i = v9;
                    if(v9 < 0L) {
                        throw new v(2008, null, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
                    }
                }
            }
            else {
                long v10 = v4 - v8;
                this.i = v10;
                if(v10 < 0L) {
                    throw new g(2008);
                }
            }
            goto label_71;
        }
        catch(v v6) {
        }
        catch(IOException iOException0) {
            throw new v(2000, iOException0, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        throw v6;
    label_71:
        int v11 = Long.compare(v, -1L);
        if(v11 != 0) {
            this.i = this.i == -1L ? v : Math.min(this.i, v);
        }
        this.j = true;
        this.d(j0);
        return v11 == 0 ? this.i : v;
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        int v3;
        if(v1 == 0) {
            return 0;
        }
        long v2 = this.i;
        if(Long.compare(v2, 0L) != 0) {
            try {
                if(Long.compare(v2, -1L) != 0) {
                    v1 = (int)Math.min(v2, v1);
                }
                v3 = this.h.read(arr_b, v, v1);
            }
            catch(IOException iOException0) {
                throw new v(2000, iOException0, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
            if(v3 != -1) {
                long v4 = this.i;
                if(v4 != -1L) {
                    this.i = v4 - ((long)v3);
                }
                this.a(v3);
                return v3;
            }
            else if(this.i != -1L) {
                throw new v(2000, new EOFException(), "End of stream reached having not read sufficient data.");  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
            }
        }
        return -1;
    }
}

