package yc;

import com.melon.net.res.common.SongInfoBase;
import ie.H;
import kotlin.jvm.internal.q;
import q8.f;
import we.k;

public final class w implements k {
    public final int a;
    public final SongInfoBase b;

    public w(SongInfoBase songInfoBase0, int v) {
        this.a = v;
        this.b = songInfoBase0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        SongInfoBase songInfoBase0 = this.b;
        if(this.a != 0) {
            q.g(((f)object0), "$this$eventMeta");
            ((f)object0).a = songInfoBase0.songId;
            ((f)object0).b = "";
            ((f)object0).c = songInfoBase0.songName;
            return h0;
        }
        q.g(((f)object0), "$this$eventMeta");
        ((f)object0).a = songInfoBase0.songId;
        ((f)object0).b = "";
        ((f)object0).c = songInfoBase0.songName;
        return h0;
    }
}

