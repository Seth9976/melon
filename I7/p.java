package I7;

import android.content.SharedPreferences;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class p {
    public final SharedPreferences a;
    public final Object b;
    public final Object c;
    public final Object d;
    public static final Date e;
    public static final Date f;

    static {
        p.e = new Date(-1L);
        p.f = new Date(-1L);
    }

    public p(SharedPreferences sharedPreferences0) {
        this.a = sharedPreferences0;
        this.b = new Object();
        this.c = new Object();
        this.d = new Object();
    }

    public final o a() {
        synchronized(this.c) {
            int v1 = this.a.getInt("num_failed_fetches", 0);
            Date date0 = new Date(this.a.getLong("backoff_end_time_in_millis", -1L));
            o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
            o0.a = v1;
            o0.b = date0;
            return o0;
        }
    }

    public final HashMap b() {
        String s = this.a.getString("customSignals", "{}");
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            HashMap hashMap0 = new HashMap();
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                hashMap0.put(((String)object0), jSONObject0.optString(((String)object0)));
            }
            return hashMap0;
        }
        catch(JSONException unused_ex) {
            return new HashMap();
        }
    }

    public final o c() {
        synchronized(this.d) {
            int v1 = this.a.getInt("num_failed_realtime_streams", 0);
            Date date0 = new Date(this.a.getLong("realtime_backoff_end_time_in_millis", -1L));
            o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
            o0.a = v1;
            o0.b = date0;
            return o0;
        }
    }

    public final void d(int v, Date date0) {
        synchronized(this.c) {
            this.a.edit().putInt("num_failed_fetches", v).putLong("backoff_end_time_in_millis", date0.getTime()).apply();
        }
    }

    public final void e(int v, Date date0) {
        synchronized(this.d) {
            this.a.edit().putInt("num_failed_realtime_streams", v).putLong("realtime_backoff_end_time_in_millis", date0.getTime()).apply();
        }
    }
}

