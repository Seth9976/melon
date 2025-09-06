package e7;

import B3.q;
import G1.f;
import Ic.h;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import f7.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import z7.a;
import z7.d;

public final class u {
    public final q a;
    public final Context b;
    public final String c;
    public final d d;
    public final f e;
    public b f;
    public static final Pattern g;
    public static final String h;

    static {
        u.g = Pattern.compile("[^\\p{Alnum}]");
        u.h = "\\Q/\\E";
    }

    public u(Context context0, String s, d d0, f f0) {
        if(context0 == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if(s == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.b = context0;
        this.c = s;
        this.d = d0;
        this.e = f0;
        this.a = new q(5);
    }

    public final String a(SharedPreferences sharedPreferences0, String s) {
        synchronized(this) {
            if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Created new Crashlytics installation ID: 064cc9efee5243d3950bf8b7890a63ba for FID: " + s, null);
            }
            sharedPreferences0.edit().putString("crashlytics.installation.id", "064cc9efee5243d3950bf8b7890a63ba").putString("firebase.installation.id", s).apply();
            return "064cc9efee5243d3950bf8b7890a63ba";
        }
    }

    public final t b(boolean z) {
        String s;
        if(!((Boolean)new h(0, f7.d.d, c.class, "isNotMainThread", "isNotMainThread()Z", 0, 18).invoke()).booleanValue() && Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Must not be called on a main thread, was called on jeb-dexdec-sb-st-1634" + '.', null);
        }
        d d0 = this.d;
        if(z) {
            try {
                s = ((a)Tasks.await(((z7.c)d0).d(), 10000L, TimeUnit.MILLISECONDS)).a;
            }
            catch(Exception exception0) {
                Log.w("FirebaseCrashlytics", "Error getting Firebase authentication token.", exception0);
                s = null;
            }
        }
        else {
            s = null;
        }
        try {
            return new t(((String)Tasks.await(((z7.c)d0).c(), 10000L, TimeUnit.MILLISECONDS)), s);
        }
        catch(Exception exception1) {
            Log.w("FirebaseCrashlytics", "Error getting Firebase installation id.", exception1);
            return new t(null, s);
        }
    }

    public final b c() {
        synchronized(this) {
            if(this.f != null && (this.f.b != null || !this.e.f())) {
                return this.f;
            }
            b7.c c0 = b7.c.a;
            c0.e("Determining Crashlytics installation ID...");
            SharedPreferences sharedPreferences0 = this.b.getSharedPreferences("com.google.firebase.crashlytics", 0);
            String s = sharedPreferences0.getString("firebase.installation.id", null);
            c0.e("Cached Firebase Installation ID: " + s);
            if(this.e.f()) {
                t t0 = this.b(false);
                c0.e("Fetched Firebase Installation ID: " + t0.a);
                if(t0.a == null) {
                    t0 = new t((s == null ? "SYN_c1dfcd7d-62e0-49ab-bfbe-344e5d8c4ff7" : s), null);
                }
                this.f = Objects.equals(t0.a, s) ? new b(sharedPreferences0.getString("crashlytics.installation.id", null), t0.a, t0.b) : new b(this.a(sharedPreferences0, t0.a), t0.a, t0.b);
            }
            else if(s == null || !s.startsWith("SYN_")) {
                this.f = new b(this.a(sharedPreferences0, "SYN_374603bc-3453-4b0c-a35a-1772c14c52f7"), null, null);
            }
            else {
                this.f = new b(sharedPreferences0.getString("crashlytics.installation.id", null), null, null);
            }
            c0.e("Install IDs: " + this.f);
            return this.f;
        }
    }

    public final String d() {
        q q0 = this.a;
        Context context0 = this.b;
        synchronized(q0) {
            if(q0.b == null) {
                String s = context0.getPackageManager().getInstallerPackageName("com.iloen.melon");
                if(s == null) {
                    s = "";
                }
                q0.b = s;
            }
            return "".equals(q0.b) ? null : q0.b;
        }
    }
}

