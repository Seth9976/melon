package O5;

import P5.A;
import P5.B;
import P5.C;
import P5.D;
import P5.E;
import P5.F;
import P5.G;
import P5.I;
import P5.b;
import P5.e;
import P5.f;
import P5.g;
import P5.i;
import P5.j;
import P5.k;
import P5.l;
import P5.m;
import P5.n;
import P5.o;
import P5.p;
import P5.q;
import P5.r;
import P5.s;
import P5.v;
import P5.w;
import P5.y;
import R5.h;
import Z5.a;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import pc.t;
import t7.d;

public final class c implements h {
    public final t a;
    public final ConnectivityManager b;
    public final Context c;
    public final URL d;
    public final a e;
    public final a f;
    public final int g;

    public c(Context context0, a a0, a a1) {
        d d0 = new d();
        d0.a(w.class, P5.c.a);
        d0.a(m.class, P5.c.a);
        d0.a(F.class, j.a);
        d0.a(P5.t.class, j.a);
        d0.a(y.class, P5.d.a);
        d0.a(n.class, P5.d.a);
        d0.a(P5.a.class, b.a);
        d0.a(l.class, b.a);
        d0.a(E.class, i.a);
        d0.a(s.class, i.a);
        d0.a(A.class, e.a);
        d0.a(o.class, e.a);
        d0.a(D.class, P5.h.a);
        d0.a(r.class, P5.h.a);
        d0.a(C.class, g.a);
        d0.a(q.class, g.a);
        d0.a(I.class, k.a);
        d0.a(v.class, k.a);
        d0.a(B.class, f.a);
        d0.a(p.class, f.a);
        d0.d = true;
        this.a = new t(d0, 15);
        this.c = context0;
        this.b = (ConnectivityManager)context0.getSystemService("connectivity");
        this.d = c.b("https://firebaselogging.googleapis.com/v0cc/log/batch?format=json_proto3");
        this.e = a1;
        this.f = a0;
        this.g = 130000;
    }

    public final Q5.i a(Q5.i i0) {
        int v4;
        NetworkInfo networkInfo0 = this.b.getActiveNetworkInfo();
        Q5.h h0 = i0.c();
        int v = Build.VERSION.SDK_INT;
        HashMap hashMap0 = (HashMap)h0.h;
        if(hashMap0 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap0.put("sdk-version", String.valueOf(v));
        h0.a("model", Build.MODEL);
        h0.a("hardware", Build.HARDWARE);
        h0.a("device", Build.DEVICE);
        h0.a("product", Build.PRODUCT);
        h0.a("os-uild", Build.ID);
        h0.a("manufacturer", Build.MANUFACTURER);
        h0.a("fingerprint", "google/sunfish/sunfish:13/TQ2A.230405.003/9719927:user/release-keys");
        Calendar.getInstance();
        int v1 = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis());
        HashMap hashMap1 = (HashMap)h0.h;
        if(hashMap1 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap1.put("tz-offset", String.valueOf(v1 / 1000));
        int v2 = -1;
        int v3 = networkInfo0 == null ? -1 : networkInfo0.getType();
        HashMap hashMap2 = (HashMap)h0.h;
        if(hashMap2 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap2.put("net-type", String.valueOf(v3));
        if(networkInfo0 == null) {
            v4 = 0;
        }
        else {
            v4 = networkInfo0.getSubtype();
            if(v4 == -1) {
                v4 = 100;
            }
            else if(((G)G.a.get(v4)) == null) {
                v4 = 0;
            }
        }
        HashMap hashMap3 = (HashMap)h0.h;
        if(hashMap3 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap3.put("mobile-subtype", String.valueOf(v4));
        h0.a("country", Locale.getDefault().getCountry());
        h0.a("locale", Locale.getDefault().getLanguage());
        Context context0 = this.c;
        String s = ((TelephonyManager)context0.getSystemService("phone")).getSimOperator();
        if(s == null) {
            s = "";
        }
        h0.a("mcc_mnc", s);
        try {
            v2 = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionCode;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Q1.c.u(packageManager$NameNotFoundException0, "CctTransportBackend", "Unable to find version code for package");
        }
        h0.a("application_build", Integer.toString(v2));
        return h0.b();
    }

    public static URL b(String s) {
        try {
            return new URL(s);
        }
        catch(MalformedURLException malformedURLException0) {
            throw new IllegalArgumentException("Invalid url: " + s, malformedURLException0);
        }
    }
}

