package td;

import com.iloen.melon.playback.playlist.PlaylistId;
import kotlin.jvm.internal.q;

public final class i0 extends j0 {
    public final PlaylistId a;

    public i0(PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
        super();
        this.a = playlistId0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i0 ? this.a == ((i0)object0).a : false;
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

