package gd;

import com.iloen.melon.custom.L0;
import com.melon.ui.f1;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j6 extends i implements n {
    public int B;
    public final n6 D;
    public L0 r;
    public String w;

    public j6(n6 n60, Continuation continuation0) {
        this.D = n60;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j6(this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j6)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s;
        L0 l00;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                n6 n60 = this.D;
                l00 = n60.getProgressUpdater();
                if(l00 != null) {
                    goto label_14;
                }
                this.r = null;
                this.w = null;
                this.B = 1;
                if(n60.c(new f1(null), this) == a0) {
                    return a0;
                label_14:
                    l00.a("MelonDjTagHubBottomViewModel true", true);
                    try {
                        this.r = l00;
                        this.w = "MelonDjTagHubBottomViewModel";
                        this.B = 2;
                        if(n60.c(new f1(null), this) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        s = "MelonDjTagHubBottomViewModel";
                        Y.v(s, " false", l00, false);
                        throw throwable0;
                    }
                    Y.v("MelonDjTagHubBottomViewModel", " false", l00, false);
                    return H.a;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            case 2: {
                try {
                    s = this.w;
                    l00 = this.r;
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
                Y.v(s, " false", l00, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

