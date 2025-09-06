package rd;

import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import p8.e;
import q8.a;
import q8.c;
import q8.d;
import q8.f;
import q8.h;
import we.k;

public final class z0 implements k {
    public final int a;
    public final B0 b;
    public final Playable c;

    public z0(B0 b00, Playable playable0, int v) {
        this.a = v;
        this.b = b00;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s = "";
        H h0 = H.a;
        Playable playable0 = this.c;
        B0 b00 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((a)object0), "$this$click");
                String s1 = (String)b00.c.invoke(playable0);
                if(s1 != null) {
                    ((a)object0).h = s1;
                }
                String s2 = (String)b00.d.invoke(playable0);
                if(s2 != null) {
                    ((a)object0).i = s2;
                }
                return h0;
            }
            case 1: {
                q.g(((c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((c)object0).a;
                linkedHashMap0.put("menuid", "1000003234");
                String s3 = (String)b00.e.invoke();
                if(s3 != null) {
                    linkedHashMap0.put("recmd_key", s3);
                }
                String s4 = (String)b00.f.invoke(playable0);
                if(s4 != null) {
                    linkedHashMap0.put("recmd_offer_timestamp", s4);
                }
                return h0;
            }
            case 2: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                b00.b(((d)object0), ActionKind.PlayMusic, playable0);
                ((h)((d)object0).b).a = b00.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((d)object0).b(new w0(b00, 20));
                f f0 = (f)((d)object0).e;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f1.b(new e(8));
                    ((d)object0).e = f1;
                }
                else {
                    f0.b(new e(8));
                }
                LinkedHashMap linkedHashMap1 = (LinkedHashMap)((d)object0).g;
                c c1 = new c();
                String s5 = (String)b00.g.invoke();
                if(s5 != null) {
                    s = s5;
                }
                c1.a.put("focus_song_ordnum", s);
                linkedHashMap1.putAll(c1.a);
                return h0;
            }
            case 3: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                b00.b(((d)object0), ActionKind.Like, playable0);
                ((h)((d)object0).b).a = b00.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                ((d)object0).b(new w0(b00, 25));
                ((d)object0).e(new x0(13, playable0));
                c c2 = new c();
                c2.d(new e(5));
                ((LinkedHashMap)((d)object0).g).putAll(c2.a);
                return h0;
            }
            case 4: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                b00.b(((d)object0), ActionKind.ClickContent, playable0);
                ((h)((d)object0).b).a = b00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).b(new w0(b00, 6));
                ((d)object0).e(new m9.k(25, playable0));
                LinkedHashMap linkedHashMap2 = (LinkedHashMap)((d)object0).g;
                c c3 = new c();
                String s6 = (String)b00.g.invoke();
                if(s6 != null) {
                    s = s6;
                }
                c3.a.put("focus_song_ordnum", s);
                linkedHashMap2.putAll(c3.a);
                return h0;
            }
            default: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                b00.b(((d)object0), ActionKind.Like, playable0);
                ((h)((d)object0).b).a = b00.a(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                ((d)object0).b(new w0(b00, 2));
                ((d)object0).e(new m9.k(20, playable0));
                c c0 = new c();
                c0.d(new e(6));
                ((LinkedHashMap)((d)object0).g).putAll(c0.a);
                return h0;
            }
        }
    }
}

