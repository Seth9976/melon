package I7;

import H7.g;
import H7.h;
import V6.c;
import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import y7.b;
import z7.d;

public final class j {
    public final d a;
    public final b b;
    public final Executor c;
    public final Clock d;
    public final Random e;
    public final I7.d f;
    public final ConfigFetchHttpClient g;
    public final p h;
    public final Map i;
    public static final long j;
    public static final int[] k;

    static {
        j.j = TimeUnit.HOURS.toSeconds(12L);
        j.k = new int[]{2, 4, 8, 16, 0x20, 0x40, 0x80, 0x100};
    }

    public j(d d0, b b0, Executor executor0, Clock clock0, Random random0, I7.d d1, ConfigFetchHttpClient configFetchHttpClient0, p p0, HashMap hashMap0) {
        this.a = d0;
        this.b = b0;
        this.c = executor0;
        this.d = clock0;
        this.e = random0;
        this.f = d1;
        this.g = configFetchHttpClient0;
        this.h = p0;
        this.i = hashMap0;
    }

    public final i a(String s, String s1, Date date0, HashMap hashMap0) {
        String s4;
        try {
            HttpURLConnection httpURLConnection0 = this.g.b();
            ConfigFetchHttpClient configFetchHttpClient0 = this.g;
            HashMap hashMap1 = this.d();
            Long long0 = null;
            String s2 = this.h.a.getString("last_fetch_etag", null);
            V6.b b0 = (V6.b)this.b.get();
            if(b0 != null) {
                long0 = (Long)((c)b0).a.getUserProperties(null, null, true).get("_fot");
            }
            i i0 = configFetchHttpClient0.fetch(httpURLConnection0, s, s1, hashMap1, s2, hashMap0, long0, date0, this.h.b());
            f f0 = i0.b;
            if(f0 != null) {
                synchronized(this.h.b) {
                    this.h.a.edit().putLong("last_template_version", f0.f).apply();
                }
            }
            String s3 = i0.c;
            if(s3 != null) {
                synchronized(this.h.b) {
                    this.h.a.edit().putString("last_fetch_etag", s3).apply();
                }
            }
            this.h.d(0, p.f);
            return i0;
        }
        catch(h h0) {
            p p0 = this.h;
            if(h0.a == 429 || h0.a == 502 || h0.a == 503 || h0.a == 504) {
                int v2 = p0.a().a + 1;
                long v3 = TimeUnit.MINUTES.toMillis(((long)j.k[Math.min(v2, j.k.length) - 1]));
                long v4 = v3 / 2L + ((long)this.e.nextInt(((int)v3)));
                p0.d(v2, new Date(date0.getTime() + v4));
            }
            o o0 = p0.a();
            int v5 = h0.a;
            if(o0.a <= 1) {
                switch(v5) {
                    case 401: {
                        s4 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
                        throw new h(h0.a, "Fetch failed: " + s4, h0);
                    }
                    case 403: {
                        s4 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
                        throw new h(h0.a, "Fetch failed: " + s4, h0);
                    }
                    case 429: {
                        break;
                    }
                    default: {
                        if(v5 == 500) {
                            s4 = "There was an internal server error.";
                        }
                        else if(v5 != 502 && v5 != 503 && v5 != 504) {
                            s4 = "The server returned an unexpected error.";
                        }
                        else {
                            s4 = "The server is unavailable. Please try again later.";
                        }
                        throw new h(h0.a, "Fetch failed: " + s4, h0);
                    }
                }
            }
            o0.b.getTime();
            throw new g("Fetch was throttled.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
        }
    }

    public final Task b(Task task0, long v, HashMap hashMap0) {
        boolean z1;
        Date date0 = new Date(this.d.currentTimeMillis());
        boolean z = task0.isSuccessful();
        Date date1 = null;
        p p0 = this.h;
        if(z) {
            Date date2 = new Date(p0.a.getLong("last_fetch_time_in_millis", -1L));
            if(date2.equals(p.e)) {
                z1 = false;
            }
            else {
                long v1 = date2.getTime();
                z1 = date0.before(new Date(TimeUnit.SECONDS.toMillis(v) + v1));
            }
            if(z1) {
                return Tasks.forResult(new i(2, null, null));
            }
        }
        Date date3 = p0.a().b;
        if(date0.before(date3)) {
            date1 = date3;
        }
        Executor executor0 = this.c;
        if(date1 != null) {
            long v2 = date1.getTime();
            long v3 = date0.getTime();
            String s = DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(v2 - v3));
            date1.getTime();
            return Tasks.forException(new g("Fetch is throttled. Please wait before calling fetch again: " + s)).continueWithTask(executor0, new B9.g(8, this, date0));  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
        }
        Task task1 = ((z7.c)this.a).c();
        Task task2 = ((z7.c)this.a).d();
        return Tasks.whenAllComplete(new Task[]{task1, task2}).continueWithTask(executor0, new I7.h(this, task1, task2, date0, hashMap0)).continueWithTask(executor0, new B9.g(8, this, date0));
    }

    public final Task c(int v) {
        HashMap hashMap0 = new HashMap(this.i);
        hashMap0.put("X-Firebase-RC-Fetch-Type", "REALTIME/" + v);
        Task task0 = this.f.b();
        B9.g g0 = new B9.g(7, this, hashMap0);
        return task0.continueWithTask(this.c, g0);
    }

    public final HashMap d() {
        HashMap hashMap0 = new HashMap();
        V6.b b0 = (V6.b)this.b.get();
        if(b0 != null) {
            for(Object object0: ((c)b0).a.getUserProperties(null, null, false).entrySet()) {
                hashMap0.put(((String)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue().toString());
            }
        }
        return hashMap0;
    }
}

