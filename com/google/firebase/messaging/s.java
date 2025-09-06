package com.google.firebase.messaging;

import F7.d;
import F7.e;
import d5.m;
import java.util.HashMap;
import u7.g;

public abstract class s {
    public static final m a;

    static {
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        hashMap0.put(s.class, c.a);
        hashMap1.remove(s.class);
        hashMap0.put(e.class, (/* 缺少Lambda参数 */, b this) -> ((r7.e)object1).a(b.b, ((e)object0).a));
        hashMap1.remove(e.class);
        hashMap0.put(d.class, a.a);
        hashMap1.remove(d.class);
        HashMap hashMap2 = new HashMap(hashMap0);
        s.a = new m(21, new HashMap(hashMap1), hashMap2, g.a);
    }
}

