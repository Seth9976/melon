package gd;

import Ac.b0;
import Pc.e;
import com.google.firebase.b;
import com.melon.ui.k1;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import p8.f;
import we.n;

public final class e4 extends i implements n {
    public final f4 r;
    public final e w;

    public e4(f4 f40, e e0, Continuation continuation0) {
        this.r = f40;
        this.w = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e4(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Y3 y30 = (Y3)this.w;
        int v = y30.b;
        f4 f40 = this.r;
        f40.i = v;
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(f40.e());
        f40.updateUiState(new b0(19, arrayList0));
        k1.startFetch$default(f40, true, null, null, 6, null);
        f f0 = f40.f();
        if(f0 != null) {
            b.O(f0, f40.d(), null, f40.b.a(0x7F130ED4), null, ((String)y30.a.get(v)), 0, null, null, null, null, null, false, 0, 8170);  // string:tiara_melon_dj_layer1_list "리스트"
        }
        return H.a;
    }
}

