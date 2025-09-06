package f9;

import J0.h;
import android.text.TextUtils;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.mcache.error.OtherError;
import com.iloen.melon.mcache.error.StorageError.PathError;
import com.iloen.melon.mcache.error.StreamIOError.CloseError;
import com.iloen.melon.mcache.error.StreamIOError.OpenError;
import com.iloen.melon.mcache.util.CacheTrackingLog;
import ea.c;
import h9.f;
import hg.a;
import hg.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public final class g {
    public d a;
    public c b;
    public String c;
    public long d;

    public static long a(String s) {
        long v = f.e(g.d(s, 0));
        long v1 = f.e(g.d(s, 1));
        return v <= 0L || v1 <= 0L ? 0L : v1;
    }

    public final h b(String s, String s1) {
        synchronized(this) {
            try {
                h h0 = this.a.h(s);
                if(h0 != null) {
                    h0.m(s1);
                    return h0;
                }
                return null;
            }
            catch(Exception exception0) {
                throw new OpenError("CacheFileControler", "Failed to write the Cache meta[cacheFileName = " + s + ", hCode = " + s1 + "]: " + exception0.getMessage());
            }
        }
    }

    public final a c(String s, String s1, h h0, boolean z) {
        synchronized(this) {
            try {
                return h0.k(1, z);
            }
            catch(IOException iOException0) {
                throw new OpenError("CacheFileControler", "Failed to open the Cache OutputStream[cid=" + s + ", hCode=" + s1 + "]: " + iOException0.getMessage());
            }
        }
    }

    public static String d(String s, int v) {
        return q.b + "/" + s + "." + v;
    }

    public static boolean e(long v, String s) {
        long v1 = f.e(g.d(s, 1));
        boolean z = false;
        if(Long.compare(v1, 0L) > 0 && v1 != v) {
            File file0 = new File(g.d(s, 0));
            boolean z1 = false;
            if(file0.exists()) {
                try {
                    z1 = file0.delete();
                }
                catch(Exception unused_ex) {
                }
            }
            File file1 = new File(g.d(s, 1));
            if(file1.exists()) {
                try {
                    z = file1.delete();
                }
                catch(Exception unused_ex) {
                }
            }
            f.b("CacheFileControler", "deleteIfExistAbnormalFile() - isMetaFileDeleted: " + z1 + ", isMusicFileDeleted: " + z);
            return true;
        }
        return false;
    }

    public final InputStream f(String s, String s1) {
        try {
            hg.c c0 = this.a.i(s, true);
            if(c0 == null) {
                return null;
            }
            if(s1.equals(c0.h())) {
                return ((InputStream[])c0.b)[1];
            }
            this.a.A(s);
            CacheTrackingLog.i(("Cache deleted: " + s + "[cause: file meta changed]"));
            return null;
        }
        catch(Exception exception0) {
            StringBuilder stringBuilder0 = A7.d.o("Failed to read the Cache[cid=", s, ", hCode=", s1, "]: %s");
            stringBuilder0.append(exception0.getMessage());
            throw new OpenError("CacheFileControler", stringBuilder0.toString());
        }
    }

    public final void g() {
        d d0 = this.a;
        if(d0 != null) {
            try {
                try {
                    d0.close();
                    this.a = null;
                }
                catch(IOException iOException0) {
                    throw new CloseError("CacheFileControler", "Failed to close the Cache: " + iOException0.getMessage());
                }
            }
            catch(Throwable throwable0) {
                this.a = null;
                throw throwable0;
            }
        }
    }

    public final void h(long v, String s) {
        String s1;
        synchronized(this) {
            f.b("CacheFileControler", "load() - cachePath: " + s + ", cacheSize: " + v);
            try {
                File file0 = new File(s);
                if(!file0.exists() && !file0.mkdirs()) {
                    new PathError("CacheFileControler", s + " folder is not created.");
                }
                try {
                    s1 = file0.getCanonicalPath();
                }
                catch(IOException unused_ex) {
                    new PathError("CacheFileControler", "System could not get the canonical path for " + s);
                    s1 = null;
                }
                this.a = d.n(new File(s1), v);
                f.b("CacheFileControler", "load() - New DiskLruCache Open Success.[Size: " + v + "]");
            }
            catch(Exception exception0) {
                new OtherError("CacheFileControler", "load() - " + exception0.toString());
            }
        }
    }

    public final void i(String s) {
        if(!TextUtils.isEmpty(s)) {
            if(this.b == null) {
                this.b = new c(this);
            }
            c c0 = this.b;
            c0.getClass();
            f.b("CacheFileControler", "registerErrorInfo() - cid: " + s);
            HashMap hashMap0 = (HashMap)c0.b;
            if(hashMap0.containsKey(s)) {
                int v = (int)(((Integer)hashMap0.get(s)));
                f.b("CacheFileControler", "registerErrorInfo() - errorCnt: " + (v + 1));
                if(v + 1 >= 3) {
                    try {
                        if(((g)c0.c).a.A(s)) {
                            hashMap0.remove(s);
                            return;
                        }
                    }
                    catch(Exception exception0) {
                        f.j("CacheFileControler", "ErrorFileManager - register() " + exception0.toString());
                    }
                    return;
                }
                hashMap0.put(s, ((int)(v + 1)));
                return;
            }
            f.b("CacheFileControler", "registerErrorInfo() - errorCnt: 1");
            hashMap0.put(s, 1);
            return;
        }
        try {
        }
        catch(Exception exception0) {
            f.j("CacheFileControler", "ErrorFileManager - register() " + exception0.toString());
        }
    }

    public final boolean j() {
        synchronized(this) {
            String s = q.b;
            long v1 = q.a;
            if(!TextUtils.isEmpty(s) && v1 >= 1L) {
                if(this.a == null) {
                    try {
                        this.h(v1, s);
                        f.b("CacheFileControler", "isLoaded() - New LRU Controler is allocated.");
                    }
                    catch(MCacheError mCacheError0) {
                        f.b("CacheFileControler", "Load Failed - " + mCacheError0.toString());
                        return false;
                    }
                }
                else if(!s.equalsIgnoreCase(this.c) || v1 != this.d) {
                    f.f("CacheFileControler", "isLoaded() - Cache option is changed.");
                    try {
                    label_18:
                        this.a.close();
                    }
                    catch(Exception unused_ex) {
                        f.j("CacheFileControler", "isLoaded() - Old LRU close failed.");
                    }
                    try {
                        this.h(v1, s);
                        f.f("CacheFileControler", "isLoaded() - LRU Controler is changed.");
                    }
                    catch(Exception exception0) {
                        f.j("CacheFileControler", "isLoaded() - " + exception0.toString());
                        return false;
                    }
                }
                else if(!this.a.b.exists()) {
                    f.f("CacheFileControler", "isLoaded() - journal file is not exist.");
                    goto label_18;
                }
                this.c = s;
                this.d = v1;
                return true;
            }
            f.j("CacheFileControler", "isLoaded() - Cache Option is invalid.[path: " + s + ", size: " + v1 + "]");
            return false;
        }
    }
}

