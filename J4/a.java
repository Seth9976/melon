package J4;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    public final boolean a;
    public final File b;
    public final Lock c;
    public FileChannel d;
    public static final HashMap e;

    static {
        a.e = new HashMap();
    }

    public a(String s, File file0, boolean z) {
        ReentrantLock reentrantLock0;
        this.a = z;
        this.b = file0 == null ? null : new File(file0, s + ".lck");
        HashMap hashMap0 = a.e;
        synchronized(hashMap0) {
            reentrantLock0 = hashMap0.get(s);
            if(reentrantLock0 == null) {
                reentrantLock0 = new ReentrantLock();
                hashMap0.put(s, reentrantLock0);
            }
        }
        this.c = reentrantLock0;
    }

    public final void a(boolean z) {
        this.c.lock();
        if(z) {
            try {
                File file0 = this.b;
                if(file0 == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File file1 = file0.getParentFile();
                if(file1 != null) {
                    file1.mkdirs();
                }
                FileChannel fileChannel0 = new FileOutputStream(file0).getChannel();
                fileChannel0.lock();
                this.d = fileChannel0;
                return;
            }
            catch(IOException iOException0) {
            }
            this.d = null;
            Log.w("SupportSQLiteLock", "Unable to grab file lock.", iOException0);
        }
    }

    public final void b() {
        FileChannel fileChannel0 = this.d;
        if(fileChannel0 != null) {
            try {
                fileChannel0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        this.c.unlock();
    }
}

