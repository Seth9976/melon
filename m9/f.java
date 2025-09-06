package m9;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import q8.b;
import q8.d;
import q8.h;
import we.k;

public final class f implements k {
    public final int a;
    public final MixUpPlaylistTiaraLogHelper b;
    public final Playable c;
    public final Playable d;

    public f(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, Playable playable1, int v) {
        this.a = v;
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.c = playable0;
        this.d = playable1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = this.b;
                mixUpPlaylistTiaraLogHelper0.c(((d)object0));
                b b0 = (b)((d)object0).c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b1.a(new m9.d(24));
                    ((d)object0).c = b1;
                }
                else {
                    b0.a(new m9.d(24));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper0, 14));
                mixUpPlaylistTiaraLogHelper0.e(((d)object0), this.c);
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((d)object0).e(new c(23, this.c));
                ((d)object0).d(new f(mixUpPlaylistTiaraLogHelper0, this.c, this.d, 2));
                return H.a;
            }
            case 1: {
                k k1 = this.b.i;
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap1 = ((q8.c)object0).a;
                String s5 = (String)this.b.h.invoke();
                if(s5 != null) {
                    linkedHashMap1.put("recmd_key", s5);
                }
                String s6 = (String)k1.invoke(this.c);
                String s7 = "";
                if(s6 == null) {
                    s6 = "";
                }
                linkedHashMap1.put("recmd_offer_timestamp", s6);
                Playable playable1 = this.d;
                String s8 = playable1 == null ? null : "";
                if(s8 == null) {
                    s8 = "";
                }
                linkedHashMap1.put("focus_song_id", s8);
                String s9 = (String)k1.invoke(playable1);
                if(s9 != null) {
                    s7 = s9;
                }
                linkedHashMap1.put("focus_song_timestamp", s7);
                return H.a;
            }
            case 2: {
                k k2 = this.b.i;
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap2 = ((q8.c)object0).a;
                String s10 = (String)this.b.h.invoke();
                if(s10 != null) {
                    linkedHashMap2.put("recmd_key", s10);
                }
                String s11 = (String)k2.invoke(this.c);
                String s12 = "";
                if(s11 == null) {
                    s11 = "";
                }
                linkedHashMap2.put("recmd_offer_timestamp", s11);
                Playable playable2 = this.d;
                String s13 = playable2 == null ? null : "";
                if(s13 == null) {
                    s13 = "";
                }
                linkedHashMap2.put("focus_song_id", s13);
                String s14 = (String)k2.invoke(playable2);
                if(s14 != null) {
                    s12 = s14;
                }
                linkedHashMap2.put("focus_song_timestamp", s12);
                linkedHashMap2.put("mixup", "1000003099");
                return H.a;
            }
            case 3: {
                k k3 = this.b.i;
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap3 = ((q8.c)object0).a;
                String s15 = (String)this.b.h.invoke();
                if(s15 != null) {
                    linkedHashMap3.put("recmd_key", s15);
                }
                String s16 = (String)k3.invoke(this.c);
                String s17 = "";
                if(s16 == null) {
                    s16 = "";
                }
                linkedHashMap3.put("recmd_offer_timestamp", s16);
                Playable playable3 = this.d;
                String s18 = playable3 == null ? null : "";
                if(s18 == null) {
                    s18 = "";
                }
                linkedHashMap3.put("focus_song_id", s18);
                String s19 = (String)k3.invoke(playable3);
                if(s19 != null) {
                    s17 = s19;
                }
                linkedHashMap3.put("focus_song_timestamp", s17);
                return H.a;
            }
            default: {
                k k0 = this.b.i;
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((q8.c)object0).a;
                String s = (String)this.b.h.invoke();
                if(s != null) {
                    linkedHashMap0.put("recmd_key", s);
                }
                String s1 = (String)k0.invoke(this.c);
                String s2 = "";
                if(s1 == null) {
                    s1 = "";
                }
                linkedHashMap0.put("recmd_offer_timestamp", s1);
                Playable playable0 = this.d;
                String s3 = playable0 == null ? null : "";
                if(s3 == null) {
                    s3 = "";
                }
                linkedHashMap0.put("focus_song_id", s3);
                String s4 = (String)k0.invoke(playable0);
                if(s4 != null) {
                    s2 = s4;
                }
                linkedHashMap0.put("focus_song_timestamp", s2);
                return H.a;
            }
        }
    }
}

