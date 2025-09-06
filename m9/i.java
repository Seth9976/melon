package m9;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import ie.H;
import kotlin.jvm.internal.q;
import od.a;
import pc.c;
import q8.b;
import q8.d;
import q8.f;
import q8.h;
import we.k;

public final class i implements k {
    public final MixUpPlaylistTiaraLogHelper a;
    public final Playable b;
    public final c c;
    public final Playable d;
    public final String e;
    public final String f;
    public final a g;
    public final a h;

    public i(MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0, Playable playable0, c c0, Playable playable1, String s, String s1, a a0, a a1) {
        this.a = mixUpPlaylistTiaraLogHelper0;
        this.b = playable0;
        this.c = c0;
        this.d = playable1;
        this.e = s;
        this.f = s1;
        this.g = a0;
        this.h = a1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = this.a;
        mixUpPlaylistTiaraLogHelper0.c(((d)object0));
        ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        b b0 = (b)((d)object0).c;
        if(b0 == null) {
            b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b1.a(new m9.d(11));
            ((d)object0).c = b1;
        }
        else {
            b0.a(new m9.d(11));
        }
        ((d)object0).b(new j(mixUpPlaylistTiaraLogHelper0, this.e, 2));
        Playable playable0 = this.b;
        mixUpPlaylistTiaraLogHelper0.e(((d)object0), playable0);
        c c0 = this.c;
        if(c0 instanceof pc.a) {
            f f0 = (f)((d)object0).f;
            if(f0 == null) {
                f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                f1.a = ((pc.a)c0).c;
                f1.b = ((pc.a)c0).d;
                ((d)object0).f = f1;
            }
            else {
                f0.a = ((pc.a)c0).c;
                f0.b = ((pc.a)c0).d;
            }
        }
        ((d)object0).e(new m9.c(19, playable0));
        mixUpPlaylistTiaraLogHelper0.f(((d)object0), playable0);
        mixUpPlaylistTiaraLogHelper0.d(((d)object0), this.d);
        ((d)object0).d(new com.iloen.melon.player.playlist.mixup.composables.c(this.f, this.g, this.h, 25));
        return H.a;
    }
}

