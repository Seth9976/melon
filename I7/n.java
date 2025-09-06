package I7;

import E9.t;
import I.t0;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.e;
import com.google.firebase.g;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import z7.d;

public final class n {
    public final LinkedHashSet a;
    public boolean b;
    public int c;
    public boolean d;
    public boolean e;
    public HttpURLConnection f;
    public t0 g;
    public final ScheduledExecutorService h;
    public final j i;
    public final e j;
    public final d k;
    public final I7.d l;
    public final Context m;
    public final String n;
    public final Random o;
    public final Clock p;
    public final p q;
    public final Object r;
    public static final int[] s;
    public static final Pattern t;

    static {
        n.s = new int[]{2, 4, 8, 16, 0x20, 0x40, 0x80, 0x100};
        n.t = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    }

    public n(e e0, d d0, j j0, I7.d d1, Context context0, LinkedHashSet linkedHashSet0, p p0, ScheduledExecutorService scheduledExecutorService0) {
        this.a = linkedHashSet0;
        this.b = false;
        this.h = scheduledExecutorService0;
        this.o = new Random();
        this.c = Math.max(8 - p0.c().a, 1);
        this.p = DefaultClock.getInstance();
        this.j = e0;
        this.i = j0;
        this.k = d0;
        this.l = d1;
        this.m = context0;
        this.n = "firebase";
        this.q = p0;
        this.d = false;
        this.e = false;
        this.r = new Object();
    }

    public final boolean a() {
        synchronized(this) {
            return !this.a.isEmpty() && !this.b && !this.d && !this.e;
        }
    }

    public final void b(InputStream inputStream0, InputStream inputStream1) {
        HttpURLConnection httpURLConnection0 = this.f;
        if(httpURLConnection0 != null && !this.e) {
            httpURLConnection0.disconnect();
        }
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException iOException0) {
                Log.d("FirebaseRemoteConfig", "Error closing connection stream.", iOException0);
            }
        }
        if(inputStream1 != null) {
            try {
                inputStream1.close();
            }
            catch(IOException iOException1) {
                Log.d("FirebaseRemoteConfig", "Error closing connection stream.", iOException1);
            }
        }
    }

    public final String c(String s) {
        this.j.a();
        Matcher matcher0 = n.t.matcher(this.j.c.b);
        return matcher0.matches() ? "https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/" + matcher0.group(1) + "/namespaces/" + s + ":streamFetchInvalidations" : "https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/" + null + "/namespaces/" + s + ":streamFetchInvalidations";
    }

    public static boolean d(int v) {
        return v == 408 || v == 429 || v == 502 || v == 503 || v == 504;
    }

    public final void e(long v) {
        synchronized(this) {
            if(!this.a()) {
                return;
            }
            int v2 = this.c;
            if(v2 > 0) {
                this.c = v2 - 1;
                t t0 = new t(this, 2);
                this.h.schedule(t0, v, TimeUnit.MILLISECONDS);
            }
            else if(!this.e) {
                new H7.e("Unable to connect to the server. Check your connection and try again.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
                this.g();
            }
        }
    }

    public static String f(InputStream inputStream0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0));
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuilder0.append(s);
            }
            return stringBuilder0.toString();
        }
        catch(IOException unused_ex) {
            return stringBuilder0.length() == 0 ? "Unable to connect to the server, access is forbidden. HTTP status code: 403" : stringBuilder0.toString();
        }
    }

    public final void g() {
        synchronized(this) {
            for(Object object0: this.a) {
                ((m)object0).a();
            }
        }
    }

    public final void h() {
        synchronized(this) {
            Date date0 = new Date(this.p.currentTimeMillis());
            this.e(Math.max(0L, this.q.c().b.getTime() - date0.getTime()));
        }
    }

    public final void i(HttpURLConnection httpURLConnection0, String s, String s1) {
        String s3;
        httpURLConnection0.setRequestMethod("POST");
        httpURLConnection0.setRequestProperty("X-Goog-Firebase-Installations-Auth", s1);
        e e0 = this.j;
        e0.a();
        g g0 = e0.c;
        httpURLConnection0.setRequestProperty("X-Goog-Api-Key", g0.a);
        httpURLConnection0.setRequestProperty("X-Android-Package", "com.iloen.melon");
        String s2 = null;
        try {
            byte[] arr_b = AndroidUtilsLight.getPackageCertificateHashBytes(this.m, "com.iloen.melon");
            if(arr_b == null) {
                Log.e("FirebaseRemoteConfig", "Could not get fingerprint hash for package: com.iloen.melon");
                goto label_15;
            }
            else {
                s3 = Hex.bytesToStringUppercase(arr_b, false);
            }
            goto label_16;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        label_14:
            Log.i("FirebaseRemoteConfig", "No such package: com.iloen.melon");
        }
        try {
        label_15:
            s3 = null;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            goto label_14;
        }
    label_16:
        httpURLConnection0.setRequestProperty("X-Android-Cert", s3);
        httpURLConnection0.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection0.setRequestProperty("X-Accept-Response-Streaming", "true");
        httpURLConnection0.setRequestProperty("Content-Type", "application/json");
        httpURLConnection0.setRequestProperty("Accept", "application/json");
        HashMap hashMap0 = new HashMap();
        e0.a();
        Matcher matcher0 = n.t.matcher(g0.b);
        if(matcher0.matches()) {
            s2 = matcher0.group(1);
        }
        hashMap0.put("project", s2);
        hashMap0.put("namespace", this.n);
        hashMap0.put("lastKnownVersionNumber", Long.toString(this.i.h.a.getLong("last_template_version", 0L)));
        e0.a();
        hashMap0.put("appId", g0.b);
        hashMap0.put("sdkVersion", "22.1.2");
        hashMap0.put("appInstanceId", s);
        byte[] arr_b1 = new JSONObject(hashMap0).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream0 = new BufferedOutputStream(httpURLConnection0.getOutputStream());
        bufferedOutputStream0.write(arr_b1);
        bufferedOutputStream0.flush();
        bufferedOutputStream0.close();
    }

    public final t0 j(HttpURLConnection httpURLConnection0) {
        synchronized(this) {
            m m0 = new m(this);
            return new t0(httpURLConnection0, this.i, this.l, this.a, m0, this.h);
        }
    }

    public final void k(Date date0) {
        int v = this.q.c().a + 1;
        long v1 = TimeUnit.MINUTES.toMillis(((long)n.s[(v >= 8 ? 8 : v) - 1]));
        long v2 = v1 / 2L + ((long)this.o.nextInt(((int)v1)));
        this.q.e(v, new Date(date0.getTime() + v2));
    }
}

