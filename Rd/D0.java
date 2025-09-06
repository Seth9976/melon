package rd;

import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import p8.e;
import q8.c;
import q8.d;
import q8.f;
import q8.h;
import we.k;

public final class d0 implements k {
    public final int a;
    public final e0 b;
    public final Playable c;

    public d0(e0 e00, Playable playable0, int v) {
        this.a = v;
        this.b = e00;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Playable playable0 = this.c;
        e0 e00 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((c)object0).a;
                linkedHashMap0.put("menuid", "1000003236");
                String s = (String)e00.c.invoke();
                if(s != null) {
                    linkedHashMap0.put("recmd_key", s);
                }
                String s1 = (String)e00.d.invoke(playable0);
                if(s1 != null) {
                    linkedHashMap0.put("recmd_offer_timestamp", s1);
                }
                return h0;
            }
            case 1: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                e00.b(((d)object0), ActionKind.PlayVideo, playable0);
                ((h)((d)object0).b).a = e00.a(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
                ((d)object0).b(new c0(e00, 4));
                f f0 = (f)((d)object0).e;
                if(f0 != null) {
                    f0.b(new e(7));
                    return h0;
                }
                f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                f1.b(new e(7));
                ((d)object0).e = f1;
                return h0;
            }
            case 2: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                e00.b(((d)object0), ActionKind.PlayMusic, playable0);
                ((h)((d)object0).b).a = e00.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((d)object0).b(new c0(e00, 11));
                ((d)object0).e(new m9.k(15, playable0));
                c c1 = new c();
                c1.b(new m9.d(6));
                ((LinkedHashMap)((d)object0).g).putAll(c1.a);
                return h0;
            }
            case 3: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                e00.b(((d)object0), ActionKind.Like, playable0);
                ((h)((d)object0).b).a = e00.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                ((d)object0).b(new c0(e00, 10));
                ((d)object0).e(new m9.k(13, playable0));
                c c2 = new c();
                c2.d(new e(5));
                ((LinkedHashMap)((d)object0).g).putAll(c2.a);
                return h0;
            }
            default: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                e00.b(((d)object0), ActionKind.Like, playable0);
                ((h)((d)object0).b).a = e00.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                ((d)object0).b(new c0(e00, 0));
                ((d)object0).e(new m9.k(8, playable0));
                c c0 = new c();
                c0.d(new e(6));
                ((LinkedHashMap)((d)object0).g).putAll(c0.a);
                return h0;
            }
        }
    }
}

