package rd;

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

public final class t1 extends i implements n {
    public final K1 r;

    public t1(K1 k10, Continuation continuation0) {
        this.r = k10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t1(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        K1 k10 = this.r;
        String s = k10.getCurrentPlayable() == null ? null : "";
        if(s != null && s.length() != 0) {
            B0 b00 = k10.h();
            Playable playable0 = (Playable)b00.b.invoke();
            d d0 = new d();  // 初始化器: LQb/h;-><init>()V
            b00.b(d0, ActionKind.ClickContent, playable0);
            ((h)d0.b).a = b00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d0.b(new w0(b00, 11));
            d0.e(new x0(4, playable0));
            ((Event)d0.p()).track();
            Navigator.INSTANCE.openLyricHighlight(s, "player");
        }
        return H.a;
    }
}

