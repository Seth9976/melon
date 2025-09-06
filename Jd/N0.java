package jd;

import com.iloen.melon.net.v6x.response.EventPopupUiModel;
import com.iloen.melon.utils.datastore.MusicWaveDataStoreKt;
import ie.H;
import kb.s;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.e;
import we.n;

public final class n0 extends i implements n {
    public final M0 B;
    public final EventPopupUiModel D;
    public String r;
    public int w;

    public n0(M0 m00, EventPopupUiModel eventPopupUiModel0, Continuation continuation0) {
        this.B = m00;
        this.D = eventPopupUiModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n0(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        M0 m00 = this.B;
        s s0 = m00.c;
        a a0 = a.a;
        H h0 = H.a;
        EventPopupUiModel eventPopupUiModel0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                s1 = e.c(m00.g().a, "_", eventPopupUiModel0.getEventId());
                this.r = s1;
                this.w = 1;
                object0 = s0.a.b.e(s1, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_16;
            }
            case 1: {
                s1 = this.r;
                d5.n.D(object0);
            label_16:
                if(!((Boolean)object0).booleanValue()) {
                    this.r = null;
                    this.w = 2;
                    H h1 = MusicWaveDataStoreKt.getMusicWaveDataStore(s0.a.b.a).a(new ta.i(s1, null), this);
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 != a0) {
                        h1 = h0;
                    }
                    if(h1 == a0) {
                        return a0;
                    }
                    m00.sendUiEvent(new E(eventPopupUiModel0));
                    return h0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                m00.sendUiEvent(new E(eventPopupUiModel0));
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

