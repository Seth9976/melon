package com.iloen.melon.analytics;

import android.content.Context;
import d5.n;
import ie.p;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import p8.B;
import p8.C;
import p8.D;
import p8.E;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/analytics/MelonTiaraUserInfoRemoteDataSourceImpl;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTiaraUserInfoRemoteDataSourceImpl {
    public final Context a;

    @Inject
    public MelonTiaraUserInfoRemoteDataSourceImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
    }

    public final Object a(c c0) {
        B b0;
        if(c0 instanceof B) {
            b0 = (B)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new B(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new B(this, c0);
        }
        Object object0 = b0.r;
        a a0 = a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                C c1 = new C(this, null);
                b0.B = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), c1, b0);
                return object0 == a0 ? a0 : ((p)object0).a;
            }
            case 1: {
                n.D(object0);
                return ((p)object0).a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object b(c c0) {
        D d0;
        if(c0 instanceof D) {
            d0 = (D)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new D(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new D(this, c0);
        }
        Object object0 = d0.r;
        a a0 = a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                E e0 = new E(this, null);
                d0.B = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), e0, d0);
                return object0 == a0 ? a0 : ((p)object0).a;
            }
            case 1: {
                n.D(object0);
                return ((p)object0).a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

