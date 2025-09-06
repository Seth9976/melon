package rd;

import com.iloen.melon.playback.playlist.PlaylistId;
import kotlin.jvm.internal.q;

public final class t0 extends v0 {
    public final PlaylistId a;

    public t0(PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        super();
        this.a = playlistId0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t0 ? this.a == ((t0)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "InvalidPlaylistId(playlistId=" + this.a + ")";
    }
}

