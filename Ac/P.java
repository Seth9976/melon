package ac;

import A7.d;
import U4.x;
import com.iloen.melon.playback.playlist.PlaylistId;
import k8.Y;
import kotlin.jvm.internal.q;

public final class p {
    public final boolean a;
    public final PlaylistId b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public static final p j;

    static {
        p.j = new p(false, PlaylistId.EMPTY, false, "", "", "", "", "", "");
    }

    public p(boolean z, PlaylistId playlistId0, boolean z1, String s, String s1, String s2, String s3, String s4, String s5) {
        q.g(playlistId0, "playlistId");
        q.g(s2, "contsId");
        q.g(s3, "contsTypeCode");
        q.g(s4, "seedContsId");
        q.g(s5, "seedContsTypeCode");
        super();
        this.a = z;
        this.b = playlistId0;
        this.c = z1;
        this.d = s;
        this.e = s1;
        this.f = s2;
        this.g = s3;
        this.h = s4;
        this.i = s5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p)) {
            return false;
        }
        if(this.a != ((p)object0).a) {
            return false;
        }
        if(this.b != ((p)object0).b) {
            return false;
        }
        if(this.c != ((p)object0).c) {
            return false;
        }
        if(!q.b(this.d, ((p)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((p)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((p)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((p)object0).g)) {
            return false;
        }
        return q.b(this.h, ((p)object0).h) ? q.b(this.i, ((p)object0).i) : false;
    }

    @Override
    public final int hashCode() {
        return this.i.hashCode() + x.b(x.b(x.b(x.b(x.b(d.e((this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F) * 0x1F, 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EpPlayAnalytics(isUseSmartPlaylist=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", playlistId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isServerSyncPlaylist=");
        Y.y(stringBuilder0, this.c, ", smartListType=", this.d, ", listType=");
        d.u(stringBuilder0, this.e, ", contsId=", this.f, ", contsTypeCode=");
        d.u(stringBuilder0, this.g, ", seedContsId=", this.h, ", seedContsTypeCode=");
        return x.m(stringBuilder0, this.i, ")");
    }
}

