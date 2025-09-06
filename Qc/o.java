package qc;

import com.iloen.melon.playback.playlist.LocalContentPlaylistHelper;
import com.iloen.melon.playback.playlist.PlaylistId;
import e1.b;
import java.util.List;
import oc.Q;
import sc.P0;

public final class o extends LocalContentPlaylistHelper {
    public final int a;
    public final Object b;

    public o(Object object0, PlaylistId playlistId0, int v) {
        this.a = v;
        this.b = object0;
        super(playlistId0);
    }

    @Override  // com.iloen.melon.playback.playlist.LocalContentPlaylistHelper
    public final List getPlayableList() {
        return this.a == 0 ? b.B(((Q)((n0)this.b).g.getValue())) : b.B(((Q)((P0)this.b).l.getValue()));
    }
}

