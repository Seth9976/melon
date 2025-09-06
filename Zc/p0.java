package Zc;

import com.iloen.melon.userstore.entity.TabMenuShortcutEntity;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import va.e0;
import we.n;
import x9.a;

public final class p0 extends i implements n {
    public int B;
    public final String D;
    public final t0 E;
    public String r;
    public int w;

    public p0(t0 t00, String s, Continuation continuation0) {
        this.D = s;
        this.E = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p0(this.E, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        String s;
        t0 t00 = this.E;
        a a0 = t00.h;
        ne.a a1 = ne.a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                String s1 = this.D;
                if(s1.length() > 0 && t00.i()) {
                    s = u.v(((e0)t00.i).j());
                    TabMenuShortcutEntity tabMenuShortcutEntity0 = new TabMenuShortcutEntity();
                    tabMenuShortcutEntity0.setMenuSeq(s1);
                    tabMenuShortcutEntity0.setMemberKey(s);
                    tabMenuShortcutEntity0.setTimestamp(System.currentTimeMillis());
                    this.r = s;
                    this.B = 1;
                    if(a0.B(tabMenuShortcutEntity0, this) == a1) {
                        return a1;
                    }
                label_28:
                    this.r = s;
                    this.B = 2;
                    object0 = a0.A(s, this);
                    if(object0 == a1) {
                        return a1;
                    }
                label_32:
                    v1 = ((Number)object0).intValue();
                    if(v1 > 3) {
                        this.r = null;
                        this.w = v1;
                        this.B = 3;
                        if(a0.o(s, this) != a1) {
                            goto label_38;
                        }
                        return a1;
                    }
                label_38:
                    this.r = null;
                    this.w = v1;
                    this.B = 4;
                    if(t0.d(t00, this) == a1) {
                        return a1;
                    }
                }
                break;
            }
            case 1: {
                s = this.r;
                d5.n.D(object0);
                goto label_28;
            }
            case 2: {
                s = this.r;
                d5.n.D(object0);
                goto label_32;
            }
            case 3: {
                int v = this.w;
                d5.n.D(object0);
                v1 = v;
                goto label_38;
            }
            case 4: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

