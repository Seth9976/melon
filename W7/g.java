package w7;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public final class g {
    public final SharedPreferences a;

    public g(Context context0, String s) {
        this.a = context0.getSharedPreferences("FirebaseHeartBeat" + s, 0);
    }

    public final void a() {
        synchronized(this) {
            long v1 = this.a.getLong("fire-count", 0L);
            String s = "";
            String s1 = null;
            for(Object object0: this.a.getAll().entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getValue() instanceof Set) {
                    for(Object object1: ((Set)map$Entry0.getValue())) {
                        String s2 = (String)object1;
                        if(s1 == null || s1.compareTo(s2) > 0) {
                            s = (String)map$Entry0.getKey();
                            s1 = s2;
                        }
                    }
                }
            }
            HashSet hashSet0 = new HashSet();
            HashSet hashSet1 = new HashSet(this.a.getStringSet(s, hashSet0));
            hashSet1.remove(s1);
            this.a.edit().putStringSet(s, hashSet1).putLong("fire-count", v1 - 1L).commit();
        }
    }

    public final void b() {
        synchronized(this) {
            SharedPreferences.Editor sharedPreferences$Editor0 = this.a.edit();
            int v1 = 0;
            for(Object object0: this.a.getAll().entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getValue() instanceof Set) {
                    Set set0 = (Set)map$Entry0.getValue();
                    String s = (String)map$Entry0.getKey();
                    if(set0.contains("2025-09-06")) {
                        HashSet hashSet0 = new HashSet();
                        hashSet0.add("2025-09-06");
                        ++v1;
                        sharedPreferences$Editor0.putStringSet(s, hashSet0);
                    }
                    else {
                        sharedPreferences$Editor0.remove(s);
                    }
                }
            }
            if(v1 == 0) {
                sharedPreferences$Editor0.remove("fire-count");
            }
            else {
                sharedPreferences$Editor0.putLong("fire-count", ((long)v1));
            }
            sharedPreferences$Editor0.commit();
        }
    }

    public final ArrayList c() {
        ArrayList arrayList0;
        synchronized(this) {
            arrayList0 = new ArrayList();
            for(Object object0: this.a.getAll().entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getValue() instanceof Set) {
                    HashSet hashSet0 = new HashSet(((Set)map$Entry0.getValue()));
                    hashSet0.remove("2025-09-06");
                    if(!hashSet0.isEmpty()) {
                        arrayList0.add(new a(((String)map$Entry0.getKey()), new ArrayList(hashSet0)));
                    }
                }
            }
            synchronized(this) {
                this.a.edit().putLong("fire-global", System.currentTimeMillis()).commit();
            }
        }
        return arrayList0;
    }

    public final String d(long v) [...] // 潜在的解密器

    public final String e(String s) {
        synchronized(this) {
            for(Object object0: this.a.getAll().entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(map$Entry0.getValue() instanceof Set) {
                    for(Object object1: ((Set)map$Entry0.getValue())) {
                        if(s.equals(((String)object1))) {
                            return (String)map$Entry0.getKey();
                        }
                        if(false) {
                            break;
                        }
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return null;
        }
    }

    public final void f(String s) {
        synchronized(this) {
            String s1 = this.e(s);
            if(s1 == null) {
                return;
            }
            HashSet hashSet0 = new HashSet();
            HashSet hashSet1 = new HashSet(this.a.getStringSet(s1, hashSet0));
            hashSet1.remove(s);
            if(hashSet1.isEmpty()) {
                this.a.edit().remove(s1).commit();
            }
            else {
                this.a.edit().putStringSet(s1, hashSet1).commit();
            }
        }
    }

    public final boolean g(long v) {
        synchronized(this) {
            if(this.a.contains("fire-global")) {
                long v2 = this.a.getLong("fire-global", -1L);
                synchronized(this) {
                    boolean z = this.d(v2).equals(this.d(v));
                }
                if(!z) {
                    this.a.edit().putLong("fire-global", v).commit();
                    return true;
                }
                return false;
            }
            this.a.edit().putLong("fire-global", v).commit();
            return true;
        }
    }

    public final void h(long v, String s) {
        synchronized(this) {
            String s1 = this.d(v);
            if(this.a.getString("last-used-date", "").equals(s1)) {
                String s2 = this.e(s1);
                if(s2 == null) {
                    return;
                }
                if(s2.equals(s)) {
                    return;
                }
                this.i(s, s1);
                return;
            }
            long v2 = this.a.getLong("fire-count", 0L);
            if(v2 + 1L == 30L) {
                this.a();
                v2 = this.a.getLong("fire-count", 0L);
            }
            HashSet hashSet0 = new HashSet();
            HashSet hashSet1 = new HashSet(this.a.getStringSet(s, hashSet0));
            hashSet1.add(s1);
            this.a.edit().putStringSet(s, hashSet1).putLong("fire-count", v2 + 1L).putString("last-used-date", s1).commit();
        }
    }

    public final void i(String s, String s1) {
        synchronized(this) {
            this.f(s1);
            HashSet hashSet0 = new HashSet();
            HashSet hashSet1 = new HashSet(this.a.getStringSet(s, hashSet0));
            hashSet1.add(s1);
            this.a.edit().putStringSet(s, hashSet1).commit();
        }
    }
}

