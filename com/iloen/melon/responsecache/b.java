package com.iloen.melon.responsecache;

import android.content.ContentValues;
import com.google.gson.n;

public abstract class b {
    public static final n a;

    static {
        b.a = new n();
    }

    public static ContentValues a(String s, Object object0, boolean z, long v) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("key", s);
        contentValues0.put("cache_type", 0);
        contentValues0.put("contents", (object0 == null ? "" : b.a.k(object0)));
        contentValues0.put("has_more", Boolean.valueOf(z));
        contentValues0.put("timestamp", v);
        return contentValues0;
    }
}

