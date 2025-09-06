package com.iloen.melon.utils;

import Md.f;
import Md.l;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.utils.log.LogU;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import k8.Y;

public class TimeExpiredCache {
    static class CacheEntry {
        public final long a;

        public CacheEntry() {
            this.a = System.currentTimeMillis();
        }
    }

    static final class TimeExpiredCacheHolder {
        public static final TimeExpiredCache a;

        static {
            TimeExpiredCacheHolder.a = new TimeExpiredCache();
        }
    }

    public final LinkedHashMap a;

    public TimeExpiredCache() {
        this.a = new LinkedHashMap();
    }

    public static void a(String s) {
        if(MelonContentUris.X.toString().equals(s)) {
            l.a(f.b);
            return;
        }
        if(MelonContentUris.Y.toString().equals(s)) {
            l.a(f.c);
            return;
        }
        if(MelonContentUris.b0.toString().equals(s)) {
            l.a(f.e);
            return;
        }
        if(MelonContentUris.Y0.toString().equals(s)) {
            l.a(f.h);
            return;
        }
        if(MelonContentUris.Z0.toString().equals(s)) {
            l.a(f.g);
            return;
        }
        if(MelonContentUris.j0.toString().equals(s)) {
            l.a(f.f);
            return;
        }
        if(MelonContentUris.i0.toString().equals(s)) {
            l.a(f.d);
            return;
        }
        if(MelonContentUris.X0.toString().equals(s)) {
            l.a(f.i);
        }
    }

    public void add(String s) {
        synchronized(this) {
            if(TextUtils.isEmpty(s)) {
                LogU.w("TimeExpiredCache", "add() invalid key");
                return;
            }
            this.remove(s);
            LogU.v("TimeExpiredCache", "add() key:" + s);
            CacheEntry timeExpiredCache$CacheEntry0 = new CacheEntry();
            this.a.put(s, timeExpiredCache$CacheEntry0);
        }
    }

    public final boolean b(String s) {
        synchronized(this) {
            LogU.v("TimeExpiredCache", "removeContain() " + s);
            Iterator iterator0 = this.a.keySet().iterator();
            while(iterator0.hasNext()) {
                try {
                    Object object0 = iterator0.next();
                    String s1 = (String)object0;
                    if(!s1.contains(s)) {
                        continue;
                    }
                    return this.remove(s1);
                }
                catch(ConcurrentModificationException concurrentModificationException0) {
                    LogU.w("TimeExpiredCache", "removeContain() " + concurrentModificationException0);
                }
            }
            return false;
        }
    }

    public void clear() {
        synchronized(this) {
            this.a.clear();
        }
    }

    public static TimeExpiredCache getInstance() {
        return TimeExpiredCacheHolder.a;
    }

    public boolean hasKey(String s) {
        Z.w("hasKey() key: ", s, "TimeExpiredCache");
        Iterator iterator0 = this.a.keySet().iterator();
        while(iterator0.hasNext()) {
            try {
                Object object0 = iterator0.next();
                LogU.d("TimeExpiredCache", "hasKey() cacheKey: " + ((String)object0));
                if(!((String)object0).contains(s)) {
                    continue;
                }
            }
            catch(ConcurrentModificationException unused_ex) {
                continue;
            }
            return true;
        }
        return false;
    }

    public boolean isExpired(String s, long v) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("TimeExpiredCache", "isExpired() invalid key");
            return true;
        }
        CacheEntry timeExpiredCache$CacheEntry0 = (CacheEntry)this.a.get(s);
        if(timeExpiredCache$CacheEntry0 == null) {
            LogU.w("TimeExpiredCache", "isExpired() invalid entry - key:" + s);
            return true;
        }
        StringBuilder stringBuilder0 = Y.o(timeExpiredCache$CacheEntry0.a, "isExpired() modifiedTimeMillis:", ", timeout: ");
        stringBuilder0.append(v);
        LogU.v("TimeExpiredCache", stringBuilder0.toString());
        if(System.currentTimeMillis() - timeExpiredCache$CacheEntry0.a <= v) {
            return false;
        }
        this.remove(s);
        return true;
    }

    public boolean remove(String s) {
        CacheEntry timeExpiredCache$CacheEntry0;
        synchronized(this) {
            if(TextUtils.isEmpty(s)) {
                LogU.w("TimeExpiredCache", "remove() invalid key");
                return false;
            }
            try {
                timeExpiredCache$CacheEntry0 = null;
                timeExpiredCache$CacheEntry0 = (CacheEntry)this.a.remove(s);
                LogU.v("TimeExpiredCache", "remove() " + s + " removed");
            }
            catch(UnsupportedOperationException unsupportedOperationException0) {
                LogU.w("TimeExpiredCache", "remove() " + unsupportedOperationException0);
            }
            return timeExpiredCache$CacheEntry0 != null;
        }
    }

    public void removeLike(String s) {
        synchronized(this) {
            LogU.v("TimeExpiredCache", "removeLike() " + s);
            TimeExpiredCache.a(s);
            if(TextUtils.isEmpty(s)) {
                LogU.w("TimeExpiredCache", "removeLike() invalid key");
                return;
            }
            while(this.b(s) && this.a.size() > 0) {
            }
        }
    }
}

