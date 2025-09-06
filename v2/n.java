package v2;

import P.z;
import Q1.c;
import Z1.d;
import Z1.i;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import com.google.android.exoplayer2.util.e;
import e1.F;
import i.n.i.b.a.s.e.u9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class n implements g {
    public final Context a;
    public final d b;
    public final F c;
    public final Object d;
    public Handler e;
    public ThreadPoolExecutor f;
    public ThreadPoolExecutor g;
    public df.d h;

    public n(Context context0, d d0) {
        this.d = new Object();
        c.o(context0, "Context cannot be null");
        this.a = context0.getApplicationContext();
        this.b = d0;
        this.c = o.d;
    }

    @Override  // v2.g
    public final void a(df.d d0) {
        synchronized(this.d) {
            this.h = d0;
        }
        synchronized(this.d) {
            if(this.h == null) {
                return;
            }
            if(this.f == null) {
                e e0 = new e("emojiCompat", 3);
                ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), e0);
                threadPoolExecutor0.allowCoreThreadTimeOut(true);
                this.g = threadPoolExecutor0;
                this.f = threadPoolExecutor0;
            }
            this.f.execute(new u9(this, 20));
        }
    }

    public final void b() {
        synchronized(this.d) {
            this.h = null;
            Handler handler0 = this.e;
            if(handler0 != null) {
                handler0.removeCallbacks(null);
            }
            this.e = null;
            ThreadPoolExecutor threadPoolExecutor0 = this.g;
            if(threadPoolExecutor0 != null) {
                threadPoolExecutor0.shutdown();
            }
            this.f = null;
            this.g = null;
        }
    }

    public final i c() {
        int v;
        z z0;
        try {
            this.c.getClass();
            ArrayList arrayList0 = new ArrayList(1);
            Objects.requireNonNull(this.b);
            arrayList0.add(this.b);
            List list0 = Collections.unmodifiableList(arrayList0);
            z0 = Z1.c.a(this.a, list0);
            v = z0.a;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            throw new RuntimeException("provider not found", packageManager$NameNotFoundException0);
        }
        if(v != 0) {
            throw new RuntimeException("fetchFonts failed (" + v + ")");
        }
        i[] arr_i = (i[])z0.b.get(0);
        if(arr_i == null || arr_i.length == 0) {
            throw new RuntimeException("fetchFonts failed (empty result)");
        }
        return arr_i[0];
    }
}

