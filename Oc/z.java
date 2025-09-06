package oc;

import A7.d;
import U4.x;
import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.jvm.internal.q;

public final class Z implements a0 {
    public final PlaylistId a;
    public final List b;
    public final boolean c;
    public final Q d;
    public final long e;

    public Z(PlaylistId playlistId0, List list0, boolean z, Q q0, long v) {
        q.g(playlistId0, "playlistId");
        q.g(list0, "realAddPlayables");
        q.g(q0, "playlistState");
        super();
        this.a = playlistId0;
        this.b = list0;
        this.c = z;
        this.d = q0;
        this.e = v;
    }

    @Override  // oc.a0
    public final Q a() {
        return this.d;
    }

    @Override  // oc.b0
    public final PlaylistId b() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Z)) {
            return false;
        }
        if(this.a != ((Z)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((Z)object0).b)) {
            return false;
        }
        if(this.c != ((Z)object0).c) {
            return false;
        }
        return q.b(this.d, ((Z)object0).d) ? this.e == ((Z)object0).e : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.e) + (this.d.hashCode() + d.e(d.d(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SuccessJustAdd(playlistId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", realAddPlayables=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", changeCurrent=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", playlistState=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", timePositionMs=");
        return x.h(this.e, ")", stringBuilder0);
    }
}

