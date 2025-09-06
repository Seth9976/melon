package rd;

import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import q8.d;
import q8.h;
import we.n;

public final class w1 extends i implements n {
    public boolean r;
    public final K1 w;

    public w1(K1 k10, Continuation continuation0) {
        this.w = k10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new w1(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((w1)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        K1 k10 = this.w;
        if(z) {
            B0 b00 = k10.h();
            Playable playable0 = (Playable)b00.b.invoke();
            d d0 = new d();  // 初始化器: LQb/h;-><init>()V
            b00.b(d0, ActionKind.ClickContent, playable0);
            ((h)d0.b).a = b00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d0.b(new w0(b00, 17));
            d0.e(new x0(5, playable0));
            ((Event)d0.p()).track();
            return H.a;
        }
        B0 b01 = k10.h();
        Playable playable1 = (Playable)b01.b.invoke();
        d d1 = new d();  // 初始化器: LQb/h;-><init>()V
        b01.b(d1, ActionKind.ClickContent, playable1);
        ((h)d1.b).a = b01.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        d1.b(new w0(b01, 16));
        d1.e(new x0(3, playable1));
        ((Event)d1.p()).track();
        return H.a;
    }
}

