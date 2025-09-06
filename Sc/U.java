package sc;

import com.iloen.melon.utils.log.LogU;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import je.p;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class u extends i implements n {
    public final int B;
    public final int D;
    public final ArrayList E;
    public final boolean G;
    public int r;
    public final P0 w;

    public u(P0 p00, int v, int v1, ArrayList arrayList0, boolean z, Continuation continuation0) {
        this.w = p00;
        this.B = v;
        this.D = v1;
        this.E = arrayList0;
        this.G = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        a a0 = a.a;
        ArrayList arrayList0 = this.E;
        P0 p00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                t t0 = new t(p00, this.B, this.D, arrayList0, null);
                this.r = 1;
                object1 = p00.e0(t0, this);
                if(object1 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object1 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        f1 f10 = p00.d;
        if(this.G) {
            ArrayList arrayList1 = b.B(((g1)object1));
            f10.getClass();
            V0 v00 = new V0(f10, p.P0(arrayList1), null);
            BuildersKt__Builders_commonKt.launch$default(f10.c, null, null, v00, 3, null);
            S2 s20 = (S2)p00.e;
            s20.getClass();
            ArrayList arrayList2 = new ArrayList(q.Q(10, arrayList0));
            Iterator iterator0 = arrayList0.iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
                arrayList2.add("");
            }
            int v = this.D;
            String s = "Move " + arrayList2 + " to position " + v;
            l1 l10 = S2.u();
            if(l10 == null) {
                LogU.error$default(s20.a, s + " - userData is null", null, false, 6, null);
            }
            else {
                ArrayList arrayList3 = new ArrayList(q.Q(10, arrayList0));
                Iterator iterator1 = arrayList0.iterator();
                while(iterator1.hasNext()) {
                    iterator1.next();
                    arrayList3.add("");
                }
                b2 b20 = new b2(v, s, arrayList3, l10, s20);
                X1 x10 = new X1(s20, s, null);
                BuildersKt__Builders_commonKt.launch$default(s20.c, null, null, x10, 3, null);
                s20.d.enqueue(b20);
            }
            f10.e(b.y(((g1)object1)), "move");
        }
        return object1;
    }
}

