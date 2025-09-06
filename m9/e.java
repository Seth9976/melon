package m9;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import pc.a;
import pc.c;
import q8.d;
import q8.f;
import q8.h;
import we.k;

public final class e implements k {
    public final int a;
    public final MixUpPlaylistTiaraLogHelper b;
    public final c c;
    public final Playable d;
    public final List e;
    public final Playable f;

    public e(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, c c0, List list0, Playable playable1, int v) {
        this.a = v;
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.d = playable0;
        this.c = c0;
        this.e = list0;
        this.f = playable1;
        super();
    }

    public e(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, c c0, Playable playable0, List list0, Playable playable1) {
        this.a = 1;
        super();
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.c = c0;
        this.d = playable0;
        this.e = list0;
        this.f = playable1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        d d0 = (d)object0;
        switch(this.a) {
            case 0: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper1 = this.b;
                mixUpPlaylistTiaraLogHelper1.c(d0);
                d0.b(new b(mixUpPlaylistTiaraLogHelper1, 17));
                Playable playable1 = this.d;
                mixUpPlaylistTiaraLogHelper1.e(d0, playable1);
                ((h)d0.b).a = mixUpPlaylistTiaraLogHelper1.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                c c1 = this.c;
                if(c1 instanceof a) {
                    f f2 = (f)d0.f;
                    if(f2 == null) {
                        f f3 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f3.a = ((a)c1).c;
                        f3.b = ((a)c1).d;
                        d0.f = f3;
                    }
                    else {
                        f2.a = ((a)c1).c;
                        f2.b = ((a)c1).d;
                    }
                }
                d0.e(new Fc.a(this.e, 9));
                d0.d(new m9.f(mixUpPlaylistTiaraLogHelper1, playable1, this.f, 3));
                return H.a;
            }
            case 1: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper2 = this.b;
                mixUpPlaylistTiaraLogHelper2.c(d0);
                Playable playable2 = this.d;
                d0.b(new m9.a(mixUpPlaylistTiaraLogHelper2, playable2, 15));
                ((h)d0.b).a = mixUpPlaylistTiaraLogHelper2.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                c c2 = this.c;
                if(c2 instanceof a) {
                    f f4 = (f)d0.f;
                    if(f4 == null) {
                        f f5 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f5.a = ((a)c2).c;
                        f5.b = ((a)c2).d;
                        d0.f = f5;
                    }
                    else {
                        f4.a = ((a)c2).c;
                        f4.b = ((a)c2).d;
                    }
                }
                d0.e(new Fc.a(this.e, 10));
                d0.d(new m9.f(mixUpPlaylistTiaraLogHelper2, playable2, this.f, 4));
                return H.a;
            }
            default: {
                q.g(d0, "$this$tiaraEventLogBuilder");
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = this.b;
                mixUpPlaylistTiaraLogHelper0.c(d0);
                d0.b(new b(mixUpPlaylistTiaraLogHelper0, 8));
                Playable playable0 = this.d;
                mixUpPlaylistTiaraLogHelper0.e(d0, playable0);
                ((h)d0.b).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                c c0 = this.c;
                if(c0 instanceof a) {
                    f f0 = (f)d0.f;
                    if(f0 == null) {
                        f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f1.a = ((a)c0).c;
                        f1.b = ((a)c0).d;
                        d0.f = f1;
                    }
                    else {
                        f0.a = ((a)c0).c;
                        f0.b = ((a)c0).d;
                    }
                }
                d0.e(new Fc.a(this.e, 8));
                d0.d(new m9.f(mixUpPlaylistTiaraLogHelper0, playable0, this.f, 1));
                return H.a;
            }
        }
    }
}

