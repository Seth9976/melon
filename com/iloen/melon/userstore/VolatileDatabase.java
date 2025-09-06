package com.iloen.melon.userstore;

import androidx.room.H;
import kotlin.Metadata;
import w9.f;
import w9.g;
import w9.h;
import x9.a;
import x9.b;
import x9.c;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/userstore/VolatileDatabase;", "Landroidx/room/H;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class VolatileDatabase extends H {
    public static final h a;
    public static final f b;
    public static final g c;

    static {
        VolatileDatabase.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        VolatileDatabase.b = new f(2, 3);  // 初始化器: LB4/a;-><init>(II)V
        VolatileDatabase.c = new g(3, 4);  // 初始化器: LB4/a;-><init>(II)V
    }

    public abstract a b();

    public abstract b c();

    public abstract c d();
}

