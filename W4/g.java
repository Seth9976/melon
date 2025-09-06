package w4;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import w1.o;

public abstract class g {
    public static final o a;
    public static final Object b;
    public static f c;

    static {
        g.a = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.b = new Object();
        g.c = null;
    }

    public static long a(Context context0) {
        PackageManager packageManager0 = context0.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT < 33 ? packageManager0.getPackageInfo("com.iloen.melon", 0).lastUpdateTime : d.a(packageManager0, context0).lastUpdateTime;
    }

    public static f b() {
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.c = f0;
        g.a.i(f0);
        return g.c;
    }

    public static void c(Context context0, boolean z) {
        e e0;
        File file2;
        long v3;
        long v2;
        boolean z1;
        int v;
        Object object0;
        if(z || g.c == null) {
            object0 = g.b;
            synchronized(object0) {
                if(!z && g.c != null) {
                    return;
                }
                goto label_6;
            }
            return;
            try {
            label_6:
                v = 0;
                try(AssetFileDescriptor assetFileDescriptor0 = context0.getAssets().openFd("dexopt/baseline.prof")) {
                    z1 = assetFileDescriptor0.getLength() <= 0L ? false : true;
                }
                goto label_16;
            }
            catch(IOException unused_ex) {
            }
            catch(Throwable throwable0) {
                throw throwable0;
            }
            z1 = false;
        label_16:
            if(Build.VERSION.SDK_INT >= 28 && Build.VERSION.SDK_INT != 30) {
                File file0 = new File(new File("/data/misc/profiles/ref/", "com.iloen.melon"), "primary.prof");
                long v1 = file0.length();
                boolean z2 = file0.exists() && v1 > 0L;
                File file1 = new File(new File("/data/misc/profiles/cur/0/", "com.iloen.melon"), "primary.prof");
                v2 = file1.length();
                boolean z3 = !file1.exists() || v2 <= 0L ? false : true;
                try {
                    v3 = g.a(context0);
                    goto label_31;
                }
                catch(PackageManager.NameNotFoundException unused_ex) {
                }
                g.b();
                return;
            }
            g.b();
            return;
        label_31:
            file2 = new File(context0.getFilesDir(), "profileInstalled");
            if(file2.exists()) {
                try {
                    e0 = e.a(file2);
                    goto label_40;
                }
                catch(IOException unused_ex) {
                }
                g.b();
                return;
            }
            else {
                e0 = null;
            }
        label_40:
            if(e0 == null || e0.c != v3) {
            label_45:
                if(!z1) {
                    v = 0x50000;
                }
                else if(z2) {
                    v = 1;
                }
                else if(z3) {
                    v = 2;
                }
            }
            else {
                int v4 = e0.b;
                if(v4 != 2) {
                    v = v4;
                    goto label_53;
                }
                goto label_45;
            }
        label_53:
            if(z && z3 && v != 1) {
                v = 2;
            }
            if(e0 != null && e0.b == 2 && v == 1 && v1 < e0.d) {
                v = 3;
            }
            e e1 = new e(1, v, v3, v2);
            if(e0 == null || !e0.equals(e1)) {
                try {
                    e1.b(file2);
                }
                catch(IOException unused_ex) {
                }
            }
            g.b();
        }
    }
}

