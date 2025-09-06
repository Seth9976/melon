package m9;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import e1.m;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import od.a;
import pc.c;
import q8.b;
import q8.d;
import q8.f;
import we.k;

public final class h implements k {
    public final int a;
    public final MixUpPlaylistTiaraLogHelper b;
    public final Playable c;
    public final c d;
    public final String e;
    public final a f;

    public h(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, c c0, String s, a a0, int v) {
        this.a = v;
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.c = playable0;
        this.d = c0;
        this.e = s;
        this.f = a0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        d d0 = (d)object0;
        switch(this.a) {
            case 0: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper1 = this.b;
                mixUpPlaylistTiaraLogHelper1.c(d0);
                ((q8.h)d0.b).a = mixUpPlaylistTiaraLogHelper1.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                b b2 = (b)d0.c;
                if(b2 == null) {
                    b b3 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b3.a(new m9.d(9));
                    d0.c = b3;
                }
                else {
                    b2.a(new m9.d(9));
                }
                d0.b(new j(mixUpPlaylistTiaraLogHelper1, this.e, 3));
                Playable playable1 = this.c;
                mixUpPlaylistTiaraLogHelper1.e(d0, playable1);
                c c2 = this.d;
                if(c2 instanceof pc.a) {
                    f f2 = (f)d0.f;
                    if(f2 == null) {
                        f f3 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f3.a = ((pc.a)c2).c;
                        f3.b = ((pc.a)c2).d;
                        d0.f = f3;
                    }
                    else {
                        f2.a = ((pc.a)c2).c;
                        f2.b = ((pc.a)c2).d;
                    }
                }
                d0.e(new m9.c(22, playable1));
                mixUpPlaylistTiaraLogHelper1.f(d0, playable1);
                LinkedHashMap linkedHashMap1 = (LinkedHashMap)d0.g;
                q8.c c3 = new q8.c();
                String s1 = this.f == null ? null : m.G(this.f);
                if(s1 == null) {
                    s1 = "";
                }
                c3.a.put("Rangecode", s1);
                linkedHashMap1.putAll(c3.a);
                return H.a;
            }
            case 1: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper2 = this.b;
                mixUpPlaylistTiaraLogHelper2.c(d0);
                ((q8.h)d0.b).a = mixUpPlaylistTiaraLogHelper2.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                b b4 = (b)d0.c;
                if(b4 == null) {
                    b b5 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b5.a(new m9.d(17));
                    d0.c = b5;
                }
                else {
                    b4.a(new m9.d(17));
                }
                d0.b(new j(mixUpPlaylistTiaraLogHelper2, this.e, 1));
                Playable playable2 = this.c;
                mixUpPlaylistTiaraLogHelper2.e(d0, playable2);
                c c4 = this.d;
                if(c4 instanceof pc.a) {
                    f f4 = (f)d0.f;
                    if(f4 == null) {
                        f f5 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f5.a = ((pc.a)c4).c;
                        f5.b = ((pc.a)c4).d;
                        d0.f = f5;
                    }
                    else {
                        f4.a = ((pc.a)c4).c;
                        f4.b = ((pc.a)c4).d;
                    }
                }
                d0.e(new m9.c(14, playable2));
                d0.d(new com.iloen.melon.player.playlist.mixup.composables.c(mixUpPlaylistTiaraLogHelper2, playable2, this.f, 24));
                return H.a;
            }
            case 2: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper3 = this.b;
                mixUpPlaylistTiaraLogHelper3.c(d0);
                ((q8.h)d0.b).a = mixUpPlaylistTiaraLogHelper3.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                b b6 = (b)d0.c;
                if(b6 == null) {
                    b b7 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b7.a(new m9.d(21));
                    d0.c = b7;
                }
                else {
                    b6.a(new m9.d(21));
                }
                d0.b(new j(mixUpPlaylistTiaraLogHelper3, this.e, 0));
                Playable playable3 = this.c;
                mixUpPlaylistTiaraLogHelper3.e(d0, playable3);
                c c5 = this.d;
                if(c5 instanceof pc.a) {
                    f f6 = (f)d0.f;
                    if(f6 == null) {
                        f f7 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f7.a = ((pc.a)c5).c;
                        f7.b = ((pc.a)c5).d;
                        d0.f = f7;
                    }
                    else {
                        f6.a = ((pc.a)c5).c;
                        f6.b = ((pc.a)c5).d;
                    }
                }
                d0.e(new m9.c(10, playable3));
                mixUpPlaylistTiaraLogHelper3.f(d0, playable3);
                LinkedHashMap linkedHashMap2 = (LinkedHashMap)d0.g;
                q8.c c6 = new q8.c();
                String s2 = this.f == null ? null : m.G(this.f);
                if(s2 == null) {
                    s2 = "";
                }
                c6.a.put("Rangecode", s2);
                linkedHashMap2.putAll(c6.a);
                return H.a;
            }
            default: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = this.b;
                mixUpPlaylistTiaraLogHelper0.c(d0);
                ((q8.h)d0.b).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                b b0 = (b)d0.c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b1.a(new m9.d(18));
                    d0.c = b1;
                }
                else {
                    b0.a(new m9.d(18));
                }
                d0.b(new j(mixUpPlaylistTiaraLogHelper0, this.e, 4));
                Playable playable0 = this.c;
                mixUpPlaylistTiaraLogHelper0.e(d0, playable0);
                c c0 = this.d;
                if(c0 instanceof pc.a) {
                    f f0 = (f)d0.f;
                    if(f0 == null) {
                        f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f1.a = ((pc.a)c0).c;
                        f1.b = ((pc.a)c0).d;
                        d0.f = f1;
                    }
                    else {
                        f0.a = ((pc.a)c0).c;
                        f0.b = ((pc.a)c0).d;
                    }
                }
                d0.e(new m9.c(24, playable0));
                mixUpPlaylistTiaraLogHelper0.f(d0, playable0);
                LinkedHashMap linkedHashMap0 = (LinkedHashMap)d0.g;
                q8.c c1 = new q8.c();
                String s = this.f == null ? null : m.G(this.f);
                if(s == null) {
                    s = "";
                }
                c1.a.put("Rangecode", s);
                linkedHashMap0.putAll(c1.a);
                return H.a;
            }
        }
    }
}

