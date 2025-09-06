package pb;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import e.k;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class o extends i implements n {
    public final ArrayList B;
    public final ArrayList r;
    public final String w;

    public o(ArrayList arrayList0, String s, ArrayList arrayList1, Continuation continuation0) {
        this.r = arrayList0;
        this.w = s;
        this.B = arrayList1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        boolean z = StorageUtils.isScopedStorage();
        int v = 0;
        ArrayList arrayList0 = this.B;
        String s = this.w;
        ArrayList arrayList1 = this.r;
        if(z) {
            for(Object object1: arrayList1) {
                if(v >= 0) {
                    if(((Playable)object1).isOriginLocal() && StorageUtils.equalsUri(s, "")) {
                        arrayList0.add(new Integer(v));
                    }
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
        }
        else {
            for(Object object2: arrayList1) {
                if(v >= 0) {
                    if(((Playable)object2).isOriginLocal() && StorageUtils.equalsUri(s, "")) {
                        arrayList0.add(new Integer(v));
                    }
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
        }
        return H.a;
    }
}

