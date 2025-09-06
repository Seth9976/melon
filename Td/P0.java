package td;

import A7.d;
import U4.x;
import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;
import pb.r;

public final class p0 implements K4 {
    public final PlaylistId a;
    public final Playable b;
    public final String c;
    public final String d;
    public final Uri e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final r l;

    public p0(PlaylistId playlistId0, Playable playable0, String s, String s1, Uri uri0, boolean z, boolean z1, boolean z2, int v, boolean z3, boolean z4, r r0) {
        q.g(playlistId0, "playlistId");
        super();
        this.a = playlistId0;
        this.b = playable0;
        this.c = s;
        this.d = s1;
        this.e = uri0;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = v;
        this.j = z3;
        this.k = z4;
        this.l = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p0)) {
            return false;
        }
        if(this.a != ((p0)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((p0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((p0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((p0)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((p0)object0).e)) {
            return false;
        }
        if(this.f != ((p0)object0).f) {
            return false;
        }
        if(this.g != ((p0)object0).g) {
            return false;
        }
        if(this.h != ((p0)object0).h) {
            return false;
        }
        if(this.i != ((p0)object0).i) {
            return false;
        }
        if(this.j != ((p0)object0).j) {
            return false;
        }
        return this.k == ((p0)object0).k ? this.l == ((p0)object0).l : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.l.hashCode() + d.e(d.e(d.b(this.i, d.e(d.e(d.e((this.e.hashCode() + x.b(x.b(v * 961, 0x1F, this.c), 0x1F, this.d)) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F), 0x1F, this.j), 0x1F, this.k) : this.l.hashCode() + d.e(d.e(d.b(this.i, d.e(d.e(d.e((this.e.hashCode() + x.b(x.b((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c), 0x1F, this.d)) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F), 0x1F, this.j), 0x1F, this.k);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MusicPlayerUiState(playlistId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", currentPlayable=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", title=");
        d.u(stringBuilder0, this.c, ", artist=", this.d, ", thumbnailUri=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isMelonSong=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", hasSongId=");
        x.y(stringBuilder0, this.g, ", isLike=", this.h, ", likeCount=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", isSpecialContentType=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", isLocalSong=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", soundType=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

