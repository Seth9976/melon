package m9;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import gd.r5;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import q8.b;
import q8.d;
import q8.f;
import q8.h;
import we.k;

public final class a implements k {
    public final int a;
    public final MixUpPlaylistTiaraLogHelper b;
    public final Playable c;

    public a(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, int v) {
        this.a = v;
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper1 = this.b;
                Playable playable1 = this.c;
                mixUpPlaylistTiaraLogHelper1.b(((d)object0), playable1);
                b b0 = (b)((d)object0).c;
                if(b0 == null) {
                    b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b1.a(new m9.d(16));
                    ((d)object0).c = b1;
                }
                else {
                    b0.a(new m9.d(16));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper1, 9));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper1.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(11, playable1));
                ((d)object0).e(new c(12, playable1));
                return H.a;
            }
            case 1: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper2 = this.b;
                Playable playable2 = this.c;
                mixUpPlaylistTiaraLogHelper2.b(((d)object0), playable2);
                b b2 = (b)((d)object0).c;
                if(b2 == null) {
                    b b3 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b3.a(new m9.d(7));
                    ((d)object0).c = b3;
                }
                else {
                    b2.a(new m9.d(7));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper2, 7));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper2.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(8, playable2));
                ((d)object0).e(new c(9, playable2));
                return H.a;
            }
            case 2: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper3 = this.b;
                Playable playable3 = this.c;
                mixUpPlaylistTiaraLogHelper3.b(((d)object0), playable3);
                b b4 = (b)((d)object0).c;
                if(b4 == null) {
                    b b5 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b5.a(new m9.d(14));
                    ((d)object0).c = b5;
                }
                else {
                    b4.a(new m9.d(14));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper3, 11));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper3.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(15, playable3));
                ((d)object0).e(new c(16, playable3));
                return H.a;
            }
            case 3: {
                q.g(((q8.a)object0), "$this$click");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper4 = this.b;
                Playable playable4 = this.c;
                String s2 = (String)mixUpPlaylistTiaraLogHelper4.f.invoke(playable4);
                if(s2 != null) {
                    ((q8.a)object0).h = s2;
                }
                String s3 = (String)mixUpPlaylistTiaraLogHelper4.g.invoke(playable4);
                if(s3 != null) {
                    ((q8.a)object0).i = s3;
                }
                return H.a;
            }
            case 4: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper5 = this.b;
                Playable playable5 = this.c;
                mixUpPlaylistTiaraLogHelper5.b(((d)object0), playable5);
                b b6 = (b)((d)object0).c;
                if(b6 == null) {
                    b b7 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b7.a(new m9.d(13));
                    ((d)object0).c = b7;
                }
                else {
                    b6.a(new m9.d(13));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper5, 20));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper5.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(29, playable5));
                ((d)object0).e(new m9.k(0, playable5));
                return H.a;
            }
            case 5: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper6 = this.b;
                mixUpPlaylistTiaraLogHelper6.c(((d)object0));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper6.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                b b8 = (b)((d)object0).c;
                if(b8 == null) {
                    b b9 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b9.a(new r5(29));
                    ((d)object0).c = b9;
                }
                else {
                    b8.a(new r5(29));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper6, 3));
                mixUpPlaylistTiaraLogHelper6.e(((d)object0), this.c);
                mixUpPlaylistTiaraLogHelper6.f(((d)object0), this.c);
                mixUpPlaylistTiaraLogHelper6.d(((d)object0), this.c);
                return H.a;
            }
            case 6: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper7 = this.b;
                Playable playable6 = this.c;
                mixUpPlaylistTiaraLogHelper7.b(((d)object0), playable6);
                b b10 = (b)((d)object0).c;
                if(b10 == null) {
                    b b11 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b11.a(new m9.d(22));
                    ((d)object0).c = b11;
                }
                else {
                    b10.a(new m9.d(22));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper7, 5));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper7.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(6, playable6));
                ((d)object0).e(new c(7, playable6));
                return H.a;
            }
            case 7: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper8 = this.b;
                Playable playable7 = this.c;
                mixUpPlaylistTiaraLogHelper8.b(((d)object0), playable7);
                b b12 = (b)((d)object0).c;
                if(b12 == null) {
                    b b13 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b13.a(new m9.d(1));
                    ((d)object0).c = b13;
                }
                else {
                    b12.a(new m9.d(1));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper8, 2));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper8.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(2, playable7));
                ((d)object0).e(new c(3, playable7));
                return H.a;
            }
            case 8: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper9 = this.b;
                Playable playable8 = this.c;
                mixUpPlaylistTiaraLogHelper9.b(((d)object0), playable8);
                b b14 = (b)((d)object0).c;
                if(b14 == null) {
                    b b15 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b15.a(new m9.d(0));
                    ((d)object0).c = b15;
                }
                else {
                    b14.a(new m9.d(0));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper9, 0));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper9.a(0x7F130DCC);  // string:tiara_common_action_name_play_video "영상재생"
                ((d)object0).k(new c(0, playable8));
                f f0 = (f)((d)object0).e;
                if(f0 != null) {
                    f0.b(new r5(28));
                    return H.a;
                }
                f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                f1.b(new r5(28));
                ((d)object0).e = f1;
                return H.a;
            }
            case 9: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper10 = this.b;
                Playable playable9 = this.c;
                mixUpPlaylistTiaraLogHelper10.b(((d)object0), playable9);
                b b16 = (b)((d)object0).c;
                if(b16 == null) {
                    b b17 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b17.a(new m9.d(8));
                    ((d)object0).c = b17;
                }
                else {
                    b16.a(new m9.d(8));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper10, 12));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper10.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(17, playable9));
                ((d)object0).e(new c(18, playable9));
                return H.a;
            }
            case 10: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper11 = this.b;
                Playable playable10 = this.c;
                mixUpPlaylistTiaraLogHelper11.b(((d)object0), playable10);
                b b18 = (b)((d)object0).c;
                if(b18 == null) {
                    b b19 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b19.a(new m9.d(4));
                    ((d)object0).c = b19;
                }
                else {
                    b18.a(new m9.d(4));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper11, 21));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper11.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((d)object0).k(new m9.k(1, playable10));
                ((d)object0).e(new m9.k(2, playable10));
                q8.c c0 = new q8.c();
                c0.b(new m9.d(6));
                ((LinkedHashMap)((d)object0).g).putAll(c0.a);
                return H.a;
            }
            case 11: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper12 = this.b;
                Playable playable11 = this.c;
                mixUpPlaylistTiaraLogHelper12.b(((d)object0), playable11);
                b b20 = (b)((d)object0).c;
                if(b20 == null) {
                    b b21 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b21.a(new m9.d(5));
                    ((d)object0).c = b21;
                }
                else {
                    b20.a(new m9.d(5));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper12, 18));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper12.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(25, playable11));
                ((d)object0).e(new c(26, playable11));
                return H.a;
            }
            case 12: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper13 = this.b;
                Playable playable12 = this.c;
                mixUpPlaylistTiaraLogHelper13.b(((d)object0), playable12);
                b b22 = (b)((d)object0).c;
                if(b22 == null) {
                    b b23 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b23.a(new m9.d(3));
                    ((d)object0).c = b23;
                }
                else {
                    b22.a(new m9.d(3));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper13, 19));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper13.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(27, playable12));
                ((d)object0).e(new c(28, playable12));
                return H.a;
            }
            case 13: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper14 = this.b;
                Playable playable13 = this.c;
                mixUpPlaylistTiaraLogHelper14.b(((d)object0), playable13);
                b b24 = (b)((d)object0).c;
                if(b24 == null) {
                    b b25 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b25.a(new m9.d(12));
                    ((d)object0).c = b25;
                }
                else {
                    b24.a(new m9.d(12));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper14, 4));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper14.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((d)object0).k(new c(4, playable13));
                ((d)object0).e(new c(5, playable13));
                return H.a;
            }
            case 14: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper15 = this.b;
                mixUpPlaylistTiaraLogHelper15.c(((d)object0));
                b b26 = (b)((d)object0).c;
                if(b26 == null) {
                    b b27 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b27.a(new m9.d(20));
                    ((d)object0).c = b27;
                }
                else {
                    b26.a(new m9.d(20));
                }
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper15.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper15, 1));
                Playable playable14 = this.c;
                mixUpPlaylistTiaraLogHelper15.e(((d)object0), playable14);
                f f2 = (f)((d)object0).e;
                if(f2 == null) {
                    f f3 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f3.b(new m9.d(19));
                    ((d)object0).e = f3;
                }
                else {
                    f2.b(new m9.d(19));
                }
                mixUpPlaylistTiaraLogHelper15.f(((d)object0), playable14);
                mixUpPlaylistTiaraLogHelper15.d(((d)object0), playable14);
                return H.a;
            }
            default: {
                q.g(((q8.a)object0), "$this$click");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = this.b;
                ((q8.a)object0).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130FAC);  // string:tiara_playlist_toolbar_layer1 "선택기능버튼"
                ((q8.a)object0).g = mixUpPlaylistTiaraLogHelper0.a(0x7F130E5B);  // string:tiara_delete "삭제"
                Playable playable0 = this.c;
                String s = (String)mixUpPlaylistTiaraLogHelper0.f.invoke(playable0);
                if(s != null) {
                    ((q8.a)object0).h = s;
                }
                String s1 = (String)mixUpPlaylistTiaraLogHelper0.g.invoke(playable0);
                if(s1 != null) {
                    ((q8.a)object0).i = s1;
                }
                return H.a;
            }
        }
    }
}

