package e7;

import A1.g;
import android.util.Log;
import b7.a;
import b7.c;
import com.iloen.melon.custom.S0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class q implements Thread.UncaughtExceptionHandler {
    public final S0 a;
    public final g b;
    public final Thread.UncaughtExceptionHandler c;
    public final a d;
    public final AtomicBoolean e;

    public q(S0 s00, g g0, Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0, a a0) {
        this.a = s00;
        this.b = g0;
        this.c = thread$UncaughtExceptionHandler0;
        this.e = new AtomicBoolean(false);
        this.d = a0;
    }

    public final boolean a(Thread thread0, Throwable throwable0) {
        if(thread0 == null) {
            Log.e("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; null thread", null);
            return false;
        }
        if(throwable0 == null) {
            Log.e("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; null throwable", null);
            return false;
        }
        if(this.d.b()) {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; native crash exists for session.", null);
            }
            return false;
        }
        return true;
    }

    @Override
    public final void uncaughtException(Thread thread0, Throwable throwable0) {
        c c0;
        Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = this.c;
        AtomicBoolean atomicBoolean0 = this.e;
        atomicBoolean0.set(true);
        try {
            try {
                if(this.a(thread0, throwable0)) {
                    this.a.h0(this.b, thread0, throwable0);
                }
                else if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Uncaught exception will not be recorded by Crashlytics.", null);
                }
                goto label_33;
            }
            catch(Exception exception0) {
            }
            c0 = c.a;
            if(c0.a(6)) {
                Log.e("FirebaseCrashlytics", "An error occurred in the uncaught exception handler", exception0);
            }
        }
        catch(Throwable throwable1) {
            goto label_23;
        }
        if(thread$UncaughtExceptionHandler0 == null) {
            c0.b("Completed exception processing, but no default exception handler.");
            System.exit(1);
        }
        else {
            c0.b("Completed exception processing. Invoking default exception handler.");
            thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        }
        atomicBoolean0.set(false);
        return;
    label_23:
        if(thread$UncaughtExceptionHandler0 == null) {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Completed exception processing, but no default exception handler.", null);
            }
            System.exit(1);
        }
        else {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Completed exception processing. Invoking default exception handler.", null);
            }
            thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        }
        atomicBoolean0.set(false);
        throw throwable1;
    label_33:
        if(thread$UncaughtExceptionHandler0 == null) {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Completed exception processing, but no default exception handler.", null);
            }
            System.exit(1);
        }
        else {
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Completed exception processing. Invoking default exception handler.", null);
            }
            thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        }
        atomicBoolean0.set(false);
    }
}

