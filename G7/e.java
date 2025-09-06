package g7;

import android.util.Log;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public final class e {
    public final HashMap a;
    public final int b;
    public final int c;

    public e(int v) {
        this.a = new HashMap();
        this.b = 0x40;
        this.c = v;
    }

    public static String a(int v, String s) {
        if(s != null) {
            s = s.trim();
            return s.length() <= v ? s : s.substring(0, v);
        }
        return null;
    }

    public final boolean b(String s, String s1) {
        boolean z;
        synchronized(this) {
            String s2 = e.a(this.c, s);
            if(this.a.size() >= this.b && !this.a.containsKey(s2)) {
                Log.w("FirebaseCrashlytics", "Ignored entry \"" + s + "\" when adding custom keys. Maximum allowable: " + this.b, null);
                return false;
            }
            String s3 = e.a(this.c, s1);
            String s4 = (String)this.a.get(s2);
            if(s4 != null) {
                z = s4.equals(s3);
            }
            else if(s3 == null) {
                z = true;
            }
            else {
                z = false;
            }
            if(z) {
                return false;
            }
            HashMap hashMap0 = this.a;
            if(s1 == null) {
                s3 = "";
            }
            hashMap0.put(s2, s3);
            return true;
        }
    }

    public final void c(Map map0) {
        synchronized(this) {
            int v1 = 0;
            for(Object object0: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                String s = (String)map$Entry0.getKey();
                if(s == null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                String s1 = e.a(this.c, s);
                if(this.a.size() >= this.b && !this.a.containsKey(s1)) {
                    ++v1;
                }
                else {
                    String s2 = (String)map$Entry0.getValue();
                    this.a.put(s1, (s2 == null ? "" : e.a(this.c, s2)));
                }
            }
            if(v1 > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + v1 + " entries when adding custom keys. Maximum allowable: " + this.b, null);
            }
        }
    }
}

