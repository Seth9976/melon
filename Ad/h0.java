package ad;

import Na.e;
import Na.f;
import androidx.lifecycle.f0;
import com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes.RESPONSE;
import com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes;
import com.iloen.melon.playback.Playable;
import com.melon.ui.t4;
import ie.H;
import java.util.ArrayList;
import je.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ne.a;
import oe.i;
import p8.s;
import we.n;

public final class h0 extends i implements n {
    public int r;
    public final q0 w;

    public h0(q0 q00, Continuation continuation0) {
        this.w = q00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ArrayList arrayList0;
        a a0 = a.a;
        q0 q00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(f0.h(q00), null, null, new g0(q00, null), 3, null);
                this.r = 1;
                object0 = deferred0.await(this);
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
        if(((f)object0) instanceof e) {
            RESPONSE chartTopDailySongChartListRes$RESPONSE0 = ((ChartTopDailySongChartListRes)((e)(((f)object0))).a).response;
            if(chartTopDailySongChartListRes$RESPONSE0 == null) {
                arrayList0 = w.a;
            }
            else {
                arrayList0 = chartTopDailySongChartListRes$RESPONSE0.chartList;
                if(arrayList0 == null) {
                    arrayList0 = w.a;
                }
            }
            s s0 = q00.k.b;
            ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, (s0 == null ? null : s0.c), null);
            q.d(arrayList1);
            q0.d(q00, arrayList1);
            return H.a;
        }
        q00.sendUiEvent(new t4(q00.m.a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        return H.a;
    }
}

