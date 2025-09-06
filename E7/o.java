package e7;

import E9.g;
import G1.f;
import W.p;
import a7.a;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.b;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.e;
import f7.d;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class o {
    public final Context a;
    public final f b;
    public final p c;
    public final long d;
    public g e;
    public g f;
    public k g;
    public final u h;
    public final FileStore i;
    public final a j;
    public final a k;
    public final h l;
    public final b7.a m;
    public final b n;
    public final d o;

    public o(e e0, u u0, b7.a a0, f f0, a a1, a a2, FileStore fileStore0, h h0, b b0, d d0) {
        this.b = f0;
        e0.a();
        this.a = e0.a;
        this.h = u0;
        this.m = a0;
        this.j = a1;
        this.k = a2;
        this.i = fileStore0;
        this.l = h0;
        this.n = b0;
        this.o = d0;
        this.d = System.currentTimeMillis();
        this.c = new p(8);
    }

    public final void a(A1.g g0) {
        d.a();
        d.a();
        this.e.c();
        if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Initialization marker file was created.", null);
        }
        try {
            try {
                n n0 = new n(this);
                this.j.t(n0);
                this.g.g();
                if(!g0.d().b.a) {
                    if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Collection of crash reports disabled in Crashlytics settings.", null);
                    }
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if(!this.g.d(g0)) {
                    Log.w("FirebaseCrashlytics", "Previous sessions could not be finalized.", null);
                }
                this.g.h(((TaskCompletionSource)((AtomicReference)g0.i).get()).getTask());
                goto label_24;
            }
            catch(Exception exception0) {
            }
            Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", exception0);
        }
        catch(Throwable throwable0) {
            this.c();
            throw throwable0;
        }
        this.c();
        return;
    label_24:
        this.c();
    }

    public final void b(A1.g g0) {
        l l0 = new l(this, g0, 1);
        Future future0 = this.o.a.a.submit(l0);
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.", null);
        }
        try {
            future0.get(3L, TimeUnit.SECONDS);
        }
        catch(InterruptedException interruptedException0) {
            Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", interruptedException0);
            Thread.currentThread().interrupt();
        }
        catch(ExecutionException executionException0) {
            Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during initialization.", executionException0);
        }
        catch(TimeoutException timeoutException0) {
            Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", timeoutException0);
        }
    }

    public final void c() {
        d.a();
        try {
            g g0 = this.e;
            FileStore fileStore0 = (FileStore)g0.b;
            String s = (String)g0.a;
            fileStore0.getClass();
            if(!new File(fileStore0.c, s).delete()) {
                Log.w("FirebaseCrashlytics", "Initialization marker file was not properly removed.", null);
            }
        }
        catch(Exception exception0) {
            Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", exception0);
        }
    }
}

