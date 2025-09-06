package oc;

import A7.d;
import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.jvm.internal.q;

public final class X implements a0 {
    public final PlaylistId a;
    public final List b;
    public final Q c;
    public final long d;

    public X(PlaylistId playlistId0, List list0, Q q0, long v) {
        q.g(playlistId0, "playlistId");
        q.g(list0, "realAddPlayables");
        q.g(q0, "playlistState");
        super();
        this.a = playlistId0;
        this.b = list0;
        this.c = q0;
        this.d = v;
    }

    @Override  // oc.a0
    public final Q a() {
        return this.c;
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
        if(!(object0 instanceof X)) {
            return false;
        }
        if(this.a != ((X)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((X)object0).b)) {
            return false;
        }
        return q.b(this.c, ((X)object0).c) ? this.d == ((X)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.d) + (this.c.hashCode() + d.d(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClearAndAdd(playlistId=" + this.a + ", realAddPlayables=" + this.b + ", playlistState=" + this.c + ", timePositionMs=" + this.d + ")";
    }
}

