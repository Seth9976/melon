package td;

import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import p8.e;
import q8.c;
import q8.d;
import q8.h;
import we.k;

public final class l0 implements k {
    public final int a;
    public final n0 b;
    public final Playable c;

    public l0(n0 n00, Playable playable0, int v) {
        this.a = v;
        this.b = n00;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((d)object0), "$this$tiaraEventLogBuilder");
            this.b.b(((d)object0), ActionKind.Like, this.c);
            ((h)((d)object0).b).a = this.b.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
            ((d)object0).b(new k0(this.b, 13));
            ((d)object0).e(new f0(15, this.c));
            c c0 = new c();
            c0.d(new e(5));
            ((LinkedHashMap)((d)object0).g).putAll(c0.a);
            return H.a;
        }
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        this.b.b(((d)object0), ActionKind.Like, this.c);
        ((h)((d)object0).b).a = this.b.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        ((d)object0).b(new k0(this.b, 0));
        ((d)object0).e(new f0(9, this.c));
        c c1 = new c();
        c1.d(new e(6));
        ((LinkedHashMap)((d)object0).g).putAll(c1.a);
        return H.a;
    }
}

