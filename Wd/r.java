package wd;

import E9.h;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.utils.Navigator;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class r extends i implements n {
    public final t r;

    public r(t t0, Continuation continuation0) {
        this.r = t0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ArrayList arrayList1;
        d5.n.D(object0);
        t t0 = this.r;
        List list0 = t0.f;
        t0.a.getClass();
        if(list0 == null) {
            arrayList1 = null;
        }
        else {
            ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
            Iterator iterator0 = list0.iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
                arrayList0.add("");
            }
            arrayList1 = h.W(arrayList0);
        }
        Navigator.open(PlaylistMakeFragment.newInstance(null, "M20002", arrayList1, "", null, false, null, t0.g));
        return H.a;
    }
}

