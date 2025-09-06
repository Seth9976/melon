package com.iloen.melon.utils.system;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.system.ToastManager$postToast$1", f = "ToastManager.kt", l = {0xBF, 0x83}, m = "invokeSuspend")
final class ToastManager.postToast.1 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public Object I;
    public final CharSequence M;
    public final int N;
    public Mutex r;
    public CharSequence w;

    public ToastManager.postToast.1(CharSequence charSequence0, int v, Continuation continuation0) {
        this.M = charSequence0;
        this.N = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new ToastManager.postToast.1(this.M, this.N, continuation0);
        continuation1.I = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((ToastManager.postToast.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v3;
        int v2;
        int v1;
        CharSequence charSequence0;
        Mutex mutex0;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.I;
        a a0 = a.a;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                mutex0 = ToastManager.c;
                this.I = coroutineScope0;
                this.r = mutex0;
                charSequence0 = this.M;
                this.w = charSequence0;
                int v = this.N;
                this.B = v;
                this.D = 0;
                this.G = 1;
                if(mutex0.lock(null, this) != a0) {
                    v1 = v;
                    v2 = 0;
                    v3 = 0;
                    goto label_34;
                }
                return a0;
            }
            case 1: {
                int v4 = this.D;
                v1 = this.B;
                charSequence0 = this.w;
                mutex0 = this.r;
                d5.n.D(object0);
                v2 = 0;
                v3 = v4;
                goto label_34;
            }
            case 2: {
                try {
                    int v5 = this.E;
                    v3 = this.D;
                    v1 = this.B;
                    charSequence0 = this.w;
                    mutex0 = this.r;
                    d5.n.D(object0);
                    v2 = v5;
                label_34:
                    while(CoroutineScopeKt.isActive(coroutineScope0) && ToastManager.access$getElapsedTime(ToastManager.INSTANCE) < 300L) {
                        this.I = coroutineScope0;
                        this.r = mutex0;
                        this.w = charSequence0;
                        this.B = v1;
                        this.D = v3;
                        this.E = v2;
                        this.G = 2;
                        if(DelayKt.delay(300L, this) != a0) {
                            continue;
                        }
                        return a0;
                    }
                    ToastManager.access$makeToast(ToastManager.INSTANCE, charSequence0, v1);
                    goto label_49;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex0.unlock(null);
        throw throwable0;
    label_49:
        mutex0.unlock(null);
        return H.a;
    }
}

