package m9;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import ie.H;
import kotlin.jvm.internal.q;
import pc.a;
import pc.c;
import q8.d;
import q8.f;
import q8.h;
import we.k;

public final class g implements k {
    public final int a;
    public final MixUpPlaylistTiaraLogHelper b;
    public final Playable c;
    public final c d;

    public g(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, c c0, int v) {
        this.a = v;
        this.b = mixUpPlaylistTiaraLogHelper0;
        this.c = playable0;
        this.d = c0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((d)object0), "$this$tiaraEventLogBuilder");
            MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = this.b;
            mixUpPlaylistTiaraLogHelper0.c(((d)object0));
            ((d)object0).b(new b(mixUpPlaylistTiaraLogHelper0, 16));
            Playable playable0 = this.c;
            mixUpPlaylistTiaraLogHelper0.e(((d)object0), playable0);
            ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            c c0 = this.d;
            if(c0 instanceof a) {
                f f0 = (f)((d)object0).f;
                if(f0 == null) {
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f1.a = ((a)c0).c;
                    f1.b = ((a)c0).d;
                    ((d)object0).f = f1;
                }
                else {
                    f0.a = ((a)c0).c;
                    f0.b = ((a)c0).d;
                }
            }
            mixUpPlaylistTiaraLogHelper0.d(((d)object0), playable0);
            return H.a;
        }
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper1 = this.b;
        mixUpPlaylistTiaraLogHelper1.c(((d)object0));
        ((d)object0).b(new b(mixUpPlaylistTiaraLogHelper1, 6));
        Playable playable1 = this.c;
        mixUpPlaylistTiaraLogHelper1.e(((d)object0), playable1);
        ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper1.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
        c c1 = this.d;
        if(c1 instanceof a) {
            f f2 = (f)((d)object0).f;
            if(f2 == null) {
                f f3 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                f3.a = ((a)c1).c;
                f3.b = ((a)c1).d;
                ((d)object0).f = f3;
            }
            else {
                f2.a = ((a)c1).c;
                f2.b = ((a)c1).d;
            }
        }
        mixUpPlaylistTiaraLogHelper1.d(((d)object0), playable1);
        return H.a;
    }
}

