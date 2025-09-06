package kc;

import H0.b;
import U4.x;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import kotlin.jvm.internal.q;

public final class g3 extends i3 {
    public final String a;
    public final DrawerPlaylistInfo b;
    public final String c;
    public final long d;

    public g3(String s, DrawerPlaylistInfo drawerPlaylistInfo0, String s1, long v) {
        q.g(s, "pcId");
        q.g(s1, "cid");
        super();
        this.a = s;
        this.b = drawerPlaylistInfo0;
        this.c = s1;
        this.d = v;
    }

    @Override  // kc.i3
    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final DrawerPlaylistInfo c() {
        return this.b;
    }

    public final long d() {
        return this.d;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g3)) {
            return false;
        }
        if(!q.b(this.a, ((g3)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((g3)object0).b)) {
            return false;
        }
        return q.b(this.c, ((g3)object0).c) ? this.d == ((g3)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.d) + x.b((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DrawerPlaylist(pcId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", drawerPlaylistInfo=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", cid=");
        b.t(this.d, this.c, ", playedTime=", stringBuilder0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

