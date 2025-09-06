package jd;

import Na.f;
import com.iloen.melon.custom.L0;
import ie.H;
import k8.Y;
import kb.D;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class u2 extends i implements n {
    public w2 B;
    public int D;
    public final w2 E;
    public L0 r;
    public String w;

    public u2(w2 w20, Continuation continuation0) {
        this.E = w20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u2(this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s5;
        Throwable throwable1;
        L0 l01;
        Object object1;
        w2 w20 = this.E;
        D d0 = w20.a;
        a a0 = a.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                L0 l00 = w20.getProgressUpdater();
                String s = "";
                if(l00 == null) {
                    String s1 = w20.e == null ? "" : w20.e;
                    String s2 = w20.f;
                    if(s2 != null) {
                        s = s2;
                    }
                    this.r = null;
                    this.w = null;
                    this.B = w20;
                    this.D = 1;
                    object0 = d0.j(s1, s, "1757130017", this);
                    if(object0 == a0) {
                        return a0;
                    }
                    w2.b(w20, ((f)object0));
                    return H.a;
                }
                l00.a("MusicWaveImageViewerViewModel true", true);
                try {
                    String s3 = w20.e == null ? "" : w20.e;
                    String s4 = w20.f;
                    if(s4 != null) {
                        s = s4;
                    }
                    this.r = l00;
                    this.w = "MusicWaveImageViewerViewModel";
                    this.B = w20;
                    this.D = 2;
                    object1 = d0.j(s3, s, "1757130017", this);
                }
                catch(Throwable throwable0) {
                    l01 = l00;
                    throwable1 = throwable0;
                    s5 = "MusicWaveImageViewerViewModel";
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                l01 = l00;
                object0 = object1;
                s5 = "MusicWaveImageViewerViewModel";
                goto label_50;
            }
            case 1: {
                w20 = this.B;
                d5.n.D(object0);
                w2.b(w20, ((f)object0));
                return H.a;
            }
            case 2: {
                try {
                    w20 = this.B;
                    s5 = this.w;
                    l01 = this.r;
                    d5.n.D(object0);
                label_50:
                    w2.b(w20, ((f)object0));
                    goto label_55;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Y.v(s5, " false", l01, false);
        throw throwable1;
    label_55:
        Y.v(s5, " false", l01, false);
        return H.a;
    }
}

