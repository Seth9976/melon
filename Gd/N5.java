package gd;

import Pc.e;
import androidx.lifecycle.f0;
import com.melon.ui.K4;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.q4;
import ed.w0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import oe.i;
import we.n;

public final class n5 extends i implements n {
    public final p5 r;
    public final e w;

    public n5(p5 p50, e e0, Continuation continuation0) {
        this.r = p50;
        this.w = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n5(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n5)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        p5 p50 = this.r;
        StringProviderImpl stringProviderImpl0 = p50.b;
        K4 k40 = (K4)p50.getUiState().getValue();
        H h0 = H.a;
        if(p50.c != null && p50.c.response != null && k40 instanceof j5) {
            e e0 = this.w;
            if(((j5)k40).g) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(p50), Dispatchers.getDefault(), null, new o5(p50, ((l5)e0).a, true, null), 2, null);
                return h0;
            }
            p50.sendUiEvent(new q4(12, stringProviderImpl0.a(0x7F130660), stringProviderImpl0.a(0x7F130664), null, new w0(10, p50, e0)));  // string:melondj_service_term_condition_title "멜론DJ 서비스 이용 동의"
            return h0;
        }
        p50.sendUiEvent(i5.a);
        return h0;
    }
}

