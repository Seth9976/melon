package gd;

import Ac.b0;
import Pc.e;
import com.google.firebase.b;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import p8.f;
import we.n;

public final class d4 extends i implements n {
    public final f4 r;
    public final e w;

    public d4(f4 f40, e e0, Continuation continuation0) {
        this.r = f40;
        this.w = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d4(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((d4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        f4 f40 = this.r;
        StringProviderImpl stringProviderImpl0 = f40.b;
        int v = f40.h;
        int v1 = ((T3)this.w).b;
        H h0 = H.a;
        if(v != v1) {
            f40.h = v1;
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(f40.e());
            f40.updateUiState(new b0(19, arrayList0));
            k1.startFetch$default(f40, true, null, null, 6, null);
            f f0 = f40.f();
            if(f0 != null) {
                b.O(f0, f40.d(), null, stringProviderImpl0.a(0x7F130DF3), null, ((f40.h == 0 ? "ALL" : "POWERDJ").equals("ALL") ? stringProviderImpl0.a(0x7F1301D6) : stringProviderImpl0.a(0x7F130656)), 0, null, null, null, null, null, false, 0, 8170);  // string:tiara_common_layer1_gnb "GNB"
            }
        }
        return h0;
    }
}

