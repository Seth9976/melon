package td;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import q8.d;
import q8.h;
import we.n;

public final class n1 extends i implements n {
    public final t1 r;

    public n1(Continuation continuation0, t1 t10) {
        this.r = t10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n1(continuation0, this.r);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        t1 t10 = this.r;
        String s = t10.getCurrentPlayable() == null ? null : "";
        if(s != null && s.length() != 0) {
            n0 n00 = t10.f();
            Playable playable0 = (Playable)n00.b.invoke();
            d d0 = new d();  // 初始化器: LQb/h;-><init>()V
            n00.b(d0, ActionKind.ClickContent, playable0);
            ((h)d0.b).a = n00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d0.b(new k0(n00, 2));
            d0.e(new f0(5, playable0));
            ((Event)d0.p()).track();
            Navigator.INSTANCE.openLyricHighlight(s, "player");
        }
        return H.a;
    }
}

