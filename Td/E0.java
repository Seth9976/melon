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
import rd.x0;
import we.k;

public final class e0 implements k {
    public final int a;
    public final g0 b;
    public final Playable c;

    public e0(g0 g00, Playable playable0, int v) {
        this.a = v;
        this.b = g00;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                this.b.b(((d)object0), ActionKind.Like, this.c);
                ((h)((d)object0).b).a = this.b.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                ((d)object0).b(new d0(this.b, 0));
                ((d)object0).e(new x0(23, this.c));
                c c1 = new c();
                c1.d(new e(6));
                ((LinkedHashMap)((d)object0).g).putAll(c1.a);
                return H.a;
            }
            case 1: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                this.b.b(((d)object0), ActionKind.PlayMusic, this.c);
                ((h)((d)object0).b).a = this.b.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((d)object0).b(new d0(this.b, 3));
                ((d)object0).e(new x0(20, this.c));
                c c2 = new c();
                c2.b(new m9.d(6));
                ((LinkedHashMap)((d)object0).g).putAll(c2.a);
                return H.a;
            }
            default: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                this.b.b(((d)object0), ActionKind.Like, this.c);
                ((h)((d)object0).b).a = this.b.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                ((d)object0).b(new d0(this.b, 8));
                ((d)object0).e(new x0(26, this.c));
                c c0 = new c();
                c0.d(new e(5));
                ((LinkedHashMap)((d)object0).g).putAll(c0.a);
                return H.a;
            }
        }
    }
}

