package com.melon.ui.playermusic;

import Cc.n3;
import android.content.Context;
import ie.H;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class h extends i implements n {
    public int B;
    public final Album D;
    public final n3 E;
    public final Context G;
    public final boolean I;
    public final boolean M;
    public List r;
    public int w;

    public h(Album bgType$Album0, n3 n30, Context context0, boolean z, boolean z1, Continuation continuation0) {
        this.D = bgType$Album0;
        this.E = n30;
        this.G = context0;
        this.I = z;
        this.M = z1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list1;
        int v;
        a a0 = a.a;
        Context context0 = this.G;
        n3 n30 = this.E;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                List list0 = this.D.c;
                v = 0;
                n30.a(context0, ((String)p.n0(0, list0)));
                if(list0.size() >= 2 && this.I && this.M) {
                    list1 = list0;
                    goto label_18;
                }
                return H.a;
            }
            case 1: {
                v = this.w;
                list1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            v = (v + 1) % list1.size();
            n30.a(context0, ((String)p.n0(v, list1)));
        label_18:
            this.r = list1;
            this.w = v;
            this.B = 1;
        }
        while(DelayKt.delay(10000L, this) != a0);
        return a0;
    }
}

