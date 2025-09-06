package com.google.firebase.messaging;

import H0.b;
import r7.c;
import r7.d;
import u7.e;

public final class a implements d {
    public static final a a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;

    static {
        a.a = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        u7.a a0 = new u7.a(1);
        a.b = new c("projectNumber", b.o(b.n(e.class, a0)));
        u7.a a1 = new u7.a(2);
        a.c = new c("messageId", b.o(b.n(e.class, a1)));
        u7.a a2 = new u7.a(3);
        a.d = new c("instanceId", b.o(b.n(e.class, a2)));
        u7.a a3 = new u7.a(4);
        a.e = new c("messageType", b.o(b.n(e.class, a3)));
        u7.a a4 = new u7.a(5);
        a.f = new c("sdkPlatform", b.o(b.n(e.class, a4)));
        u7.a a5 = new u7.a(6);
        a.g = new c("packageName", b.o(b.n(e.class, a5)));
        u7.a a6 = new u7.a(7);
        a.h = new c("collapseKey", b.o(b.n(e.class, a6)));
        u7.a a7 = new u7.a(8);
        a.i = new c("priority", b.o(b.n(e.class, a7)));
        u7.a a8 = new u7.a(9);
        a.j = new c("ttl", b.o(b.n(e.class, a8)));
        u7.a a9 = new u7.a(10);
        a.k = new c("topic", b.o(b.n(e.class, a9)));
        u7.a a10 = new u7.a(11);
        a.l = new c("bulkId", b.o(b.n(e.class, a10)));
        u7.a a11 = new u7.a(12);
        a.m = new c("event", b.o(b.n(e.class, a11)));
        u7.a a12 = new u7.a(13);
        a.n = new c("analyticsLabel", b.o(b.n(e.class, a12)));
        u7.a a13 = new u7.a(14);
        a.o = new c("campaignId", b.o(b.n(e.class, a13)));
        u7.a a14 = new u7.a(15);
        a.p = new c("composerLabel", b.o(b.n(e.class, a14)));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).e(a.b, ((F7.d)object0).a);
        ((r7.e)object1).a(a.c, ((F7.d)object0).b);
        ((r7.e)object1).a(a.d, ((F7.d)object0).c);
        ((r7.e)object1).a(a.e, ((F7.d)object0).d);
        ((r7.e)object1).a(a.f, F7.c.b);
        ((r7.e)object1).a(a.g, ((F7.d)object0).e);
        ((r7.e)object1).a(a.h, ((F7.d)object0).f);
        ((r7.e)object1).f(a.i, ((F7.d)object0).g);
        ((r7.e)object1).f(a.j, ((F7.d)object0).h);
        ((r7.e)object1).a(a.k, ((F7.d)object0).i);
        ((r7.e)object1).e(a.l, 0L);
        ((r7.e)object1).a(a.m, F7.a.b);
        ((r7.e)object1).a(a.n, ((F7.d)object0).j);
        ((r7.e)object1).e(a.o, 0L);
        ((r7.e)object1).a(a.p, ((F7.d)object0).k);
    }
}

