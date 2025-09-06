package oc;

import com.iloen.melon.playback.playlist.PlaylistId;
import kotlin.jvm.internal.q;

public final class W implements b0 {
    public final PlaylistId a;

    public W(PlaylistId playlistId0, String s) {
        q.g(playlistId0, "playlistId");
        super();
        this.a = playlistId0;
    }

    @Override  // oc.b0
    public final PlaylistId b() {
        return this.a;
    }
}

