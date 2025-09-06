package td;

import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import q8.d;
import q8.h;
import we.n;

public final class g1 extends i implements n {
    public boolean r;
    public final t1 w;

    public g1(Continuation continuation0, t1 t10) {
        this.w = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g1(continuation0, this.w);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((g1)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        t1 t10 = this.w;
        if(z) {
            n0 n00 = t10.f();
            Playable playable0 = (Playable)n00.b.invoke();
            d d0 = new d();  // 初始化器: LQb/h;-><init>()V
            n00.b(d0, ActionKind.ClickContent, playable0);
            ((h)d0.b).a = n00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d0.b(new k0(n00, 22));
            d0.e(new f0(26, playable0));
            ((Event)d0.p()).track();
            return H.a;
        }
        n0 n01 = t10.f();
        Playable playable1 = (Playable)n01.b.invoke();
        d d1 = new d();  // 初始化器: LQb/h;-><init>()V
        n01.b(d1, ActionKind.ClickContent, playable1);
        ((h)d1.b).a = n01.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        d1.b(new k0(n01, 6));
        d1.e(new f0(10, playable1));
        ((Event)d1.p()).track();
        return H.a;
    }
}

