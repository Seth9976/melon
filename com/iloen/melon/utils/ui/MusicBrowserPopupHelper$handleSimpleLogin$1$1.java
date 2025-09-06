package com.iloen.melon.utils.ui;

import Ma.g;
import android.accounts.Account;
import com.iloen.melon.MelonAppBase;
import ie.H;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import mb.k;
import mb.o;
import ne.a;
import oe.e;
import oe.i;
import va.e0;
import va.q1;
import va.t1;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$handleSimpleLogin$1$1", f = "MusicBrowserPopupHelper.kt", l = {423, 424}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.handleSimpleLogin.1.1 extends i implements n {
    public int r;
    public final String w;

    public MusicBrowserPopupHelper.handleSimpleLogin.1.1(String s, Continuation continuation0) {
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.handleSimpleLogin.1.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.handleSimpleLogin.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        String s = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o o0 = ((k8.o)(((g)Y.f(MelonAppBase.Companion, g.class)))).m();
                this.r = 1;
                t1 t10 = o0.a.a;
                Account account0 = t10.b(s);
                if(account0 == null) {
                    object0 = null;
                }
                else {
                    q1 q10 = new q1(t10, account0, null);
                    object0 = BuildersKt.withContext(t10.a, q10, this);
                }
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s1 = (String)object0;
        k k0 = va.o.a();
        if(s1 == null) {
            s1 = "";
        }
        this.r = 2;
        return ((e0)k0).y(s, s1, this) == a0 ? a0 : H.a;
    }
}

