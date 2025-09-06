package g3;

import A7.d;
import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class p extends b {
    public RandomAccessFile e;
    public Uri f;
    public long g;
    public boolean h;

    @Override  // g3.f
    public final void close() {
        try {
            this.f = null;
            RandomAccessFile randomAccessFile0 = this.e;
            if(randomAccessFile0 != null) {
                randomAccessFile0.close();
            }
        }
        catch(IOException iOException0) {
            throw new o(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        finally {
            this.e = null;
            if(this.h) {
                this.h = false;
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
        long v2;
        RandomAccessFile randomAccessFile0;
        Uri uri0 = j0.a;
        long v = j0.e;
        this.f = uri0;
        this.c();
        int v1 = 2006;
        try {
            String s = uri0.getPath();
            s.getClass();
            randomAccessFile0 = new RandomAccessFile(s, "r");
            this.e = randomAccessFile0;
        }
        catch(FileNotFoundException fileNotFoundException0) {
            if(TextUtils.isEmpty(uri0.getQuery()) && TextUtils.isEmpty(uri0.getFragment())) {
                if(!(fileNotFoundException0.getCause() instanceof ErrnoException) || ((ErrnoException)fileNotFoundException0.getCause()).errno != OsConstants.EACCES) {
                    v1 = 2005;
                }
                throw new o(v1, fileNotFoundException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
            }
            String s1 = uri0.getPath();
            String s2 = uri0.getQuery();
            String s3 = uri0.getFragment();
            StringBuilder stringBuilder0 = d.o("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing \'?\' or \'#\'? Use Uri.fromFile(new File(path)) to avoid this. path=", s1, ",query=", s2, ",fragment=");
            stringBuilder0.append(s3);
            throw new o(1004, fileNotFoundException0, stringBuilder0.toString());  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        catch(SecurityException securityException0) {
            throw new o(2006, securityException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        catch(RuntimeException runtimeException0) {
            throw new o(2000, runtimeException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        try {
            randomAccessFile0.seek(v);
            v2 = j0.f;
            if(v2 == -1L) {
                v2 = this.e.length() - v;
            }
        }
        catch(IOException iOException0) {
            throw new o(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        this.g = v2;
        if(v2 < 0L) {
            throw new o(2008, null, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;Ljava/lang/String;)V
        }
        this.h = true;
        this.d(j0);
        return this.g;
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        int v3;
        if(v1 == 0) {
            return 0;
        }
        long v2 = this.g;
        if(v2 == 0L) {
            return -1;
        }
        try {
            v3 = this.e.read(arr_b, v, ((int)Math.min(v2, v1)));
        }
        catch(IOException iOException0) {
            throw new o(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        if(v3 > 0) {
            this.g -= (long)v3;
            this.a(v3);
        }
        return v3;
    }
}

