package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import g3.b;
import g3.c;
import g3.j;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends b {
    public final ContentResolver e;
    public Uri f;
    public AssetFileDescriptor g;
    public FileInputStream h;
    public long i;
    public boolean j;

    public ContentDataSource(Context context0) {
        super(false);
        this.e = context0.getContentResolver();
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
            throw new c(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
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
                throw new c(2000, iOException1);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
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
            throw new c(2000, iOException2);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
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
        return this.f;
    }

    @Override  // g3.f
    public final long p(j j0) {
        int v10;
        IOException iOException1;
        AssetFileDescriptor assetFileDescriptor0;
        Uri uri0;
        long v;
        try {
            v = j0.f;
            long v1 = j0.e;
            uri0 = j0.a.normalizeScheme();
            this.f = uri0;
            this.c();
            boolean z = "content".equals(uri0.getScheme());
            ContentResolver contentResolver0 = this.e;
            if(z) {
                Bundle bundle0 = new Bundle();
                bundle0.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor0 = contentResolver0.openTypedAssetFileDescriptor(uri0, "*/*", bundle0);
            }
            else {
                assetFileDescriptor0 = contentResolver0.openAssetFileDescriptor(uri0, "r");
            }
            this.g = assetFileDescriptor0;
            if(assetFileDescriptor0 != null) {
                long v2 = assetFileDescriptor0.getLength();
                FileInputStream fileInputStream0 = new FileInputStream(assetFileDescriptor0.getFileDescriptor());
                this.h = fileInputStream0;
                int v3 = Long.compare(v2, -1L);
                if(v3 != 0 && v1 > v2) {
                    throw new c(2008, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
                }
                long v4 = assetFileDescriptor0.getStartOffset();
                long v5 = fileInputStream0.skip(v4 + v1) - v4;
                if(v5 != v1) {
                    throw new c(2008, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
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
                            throw new c(2008, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
                        }
                    }
                }
                else {
                    long v8 = v2 - v5;
                    this.i = v8;
                    if(v8 < 0L) {
                        throw new c(2008, null);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
                    }
                }
                goto label_39;
            }
            goto label_45;
        }
        catch(c c0) {
            throw c0;
        }
        catch(IOException iOException0) {
            v10 = 2000;
            goto label_55;
        }
    label_39:
        int v9 = Long.compare(v, -1L);
        if(v9 != 0) {
            this.i = this.i == -1L ? v : Math.min(this.i, v);
        }
        this.j = true;
        this.d(j0);
        return v9 == 0 ? this.i : v;
        try {
        label_45:
            iOException1 = new IOException("Could not open file descriptor for: " + uri0);
            v10 = 2000;
        }
        catch(c c0) {
            throw c0;
        }
        catch(IOException iOException0) {
            v10 = 2000;
            goto label_55;
        }
        try {
            throw new c(2000, iOException1);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        catch(c c0) {
            try {
                throw c0;
            }
            catch(c c0) {
            }
            catch(IOException iOException0) {
                v10 = 2000;
                goto label_55;
            }
            throw c0;
        }
        catch(IOException iOException0) {
        }
    label_55:
        if(iOException0 instanceof FileNotFoundException) {
            v10 = 2005;
        }
        throw new c(v10, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
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
                if(v2 != -1L) {
                    v1 = (int)Math.min(v2, v1);
                }
                v3 = this.h.read(arr_b, v, v1);
            }
            catch(IOException iOException0) {
                throw new c(2000, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
            }
            if(v3 != -1) {
                long v4 = this.i;
                if(v4 != -1L) {
                    this.i = v4 - ((long)v3);
                }
                this.a(v3);
                return v3;
            }
        }
        return -1;
    }
}

