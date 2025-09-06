package oc;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.jvm.internal.q;

public final class Y implements a0 {
    public final PlaylistId a;
    public final List b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final Q g;
    public final long h;

    public Y(PlaylistId playlistId0, List list0, boolean z, boolean z1, int v, boolean z2, Q q0, long v1) {
        q.g(playlistId0, "playlistId");
        q.g(list0, "realAddPlayables");
        q.g(q0, "playlistState");
        super();
        this.a = playlistId0;
        this.b = list0;
        this.c = z;
        this.d = z1;
        this.e = v;
        this.f = z2;
        this.g = q0;
        this.h = v1;
    }

    @Override  // oc.a0
    public final Q a() {
        return this.g;
    }

    @Override  // oc.b0
    public final PlaylistId b() {
        return this.a;
    }
}

