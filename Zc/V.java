package zc;

import I.Z0;
import androidx.compose.foundation.Q0;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHDATA;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import e.k;
import ie.H;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class v extends i implements n {
    public final List B;
    public final a D;
    public final Q0 E;
    public final int G;
    public final Z I;
    public final b0 M;
    public final a0 N;
    public int r;
    public final List w;

    public v(List list0, List list1, a a0, Q0 q00, int v, Z z0, b0 b00, a0 a00, Continuation continuation0) {
        this.w = list0;
        this.B = list1;
        this.D = a0;
        this.E = q00;
        this.G = v;
        this.I = z0;
        this.M = b00;
        this.N = a00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v(this.w, this.B, this.D, this.E, this.G, this.I, this.M, this.N, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        a a0 = this.D;
        float f = a0.d;
        ne.a a1 = ne.a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ((I0)this.I).n(0.0f);
                this.M.setValue(Boolean.FALSE);
                List list0 = this.w;
                ListIterator listIterator0 = list0.listIterator(list0.size());
                while(listIterator0.hasPrevious()) {
                    object1 = listIterator0.previous();
                    String s = ((GRAPHDATA)object1).value;
                    Iterator iterator0 = list0.iterator();
                    if(!iterator0.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object object2 = iterator0.next();
                    String s1 = ((GRAPHDATA)object2).value;
                    while(iterator0.hasNext()) {
                        Object object3 = iterator0.next();
                        String s2 = ((GRAPHDATA)object3).value;
                        if(s1.compareTo(s2) < 0) {
                            s1 = s2;
                        }
                    }
                    if(!q.b(s, s1)) {
                        continue;
                    }
                    goto label_27;
                }
                object1 = null;
            label_27:
                int v = ((GRAPHDATA)object1) == null ? k.s(this.B) : ((GRAPHDATA)object1).xIndex;
                int v1 = ViewUtilsKt.dpToPx(a0.b);
                int v2 = ViewUtilsKt.dpToPx(f);
                int v3 = ViewUtilsKt.dpToPx(a0.e);
                int v4 = ViewUtilsKt.dpToPx(f / 2.0f);
                ((K0)this.N).n(v4 + (v3 * v + (v2 * v + v1)));
                int v5 = ((K0)this.N).m();
                this.r = 1;
                int v6 = this.E.g();
                return Z0.e(this.E, ((float)(v5 - this.G - v6)), this) == a1 ? a1 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

