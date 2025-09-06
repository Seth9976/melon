package td;

import Pb.p;
import com.melon.playback.command.SetABRangeRepeatResult.SetRangeAResult.FailureDisabledStreamCache;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.r4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m1 extends i implements n {
    public int r;
    public final t1 w;

    public m1(Continuation continuation0, t1 t10) {
        this.w = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m1(continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        t1 t10 = this.w;
        StringProviderImpl stringProviderImpl0 = t10.b;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = t10.d.G(this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((p)object0) instanceof FailureDisabledStreamCache) {
            t10.sendUiEvent(new r4(stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F1300CA), null, new L0(t10, 7), null, null, 108));  // string:alert_dlg_title_info "안내"
        }
        return H.a;
    }
}

