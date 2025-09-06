package fc;

import H0.b;
import U4.x;
import ac.d;
import android.net.Uri;
import gc.G;
import kotlin.jvm.internal.q;

public final class a {
    public final int a;
    public final boolean b;
    public final String c;
    public final long d;
    public final long e;
    public final String f;
    public final String g;
    public final Uri h;
    public final G i;
    public final d j;

    public a(int v, boolean z, String s, long v1, long v2, String s1, String s2, Uri uri0, G g0, d d0) {
        q.g(s1, "title");
        q.g(s2, "artist");
        q.g(uri0, "thumbnailUri");
        super();
        this.a = v;
        this.b = z;
        this.c = s;
        this.d = v1;
        this.e = v2;
        this.f = s1;
        this.g = s2;
        this.h = uri0;
        this.i = g0;
        this.j = d0;
    }

    public a(boolean z, long v, long v1, String s, String s1, Uri uri0, int v2) {
        Uri uri2;
        if((v2 & 0x80) == 0) {
            uri2 = uri0;
        }
        else {
            Uri uri1 = Uri.EMPTY;
            q.f(uri1, "EMPTY");
            uri2 = uri1;
        }
        this(1, ((v2 & 2) == 0 ? z : false), "", ((v2 & 8) == 0 ? v : 0x8000000000000001L), ((v2 & 16) == 0 ? v1 : 0x8000000000000001L), ((v2 & 0x20) == 0 ? s : ""), ((v2 & 0x40) == 0 ? s1 : ""), uri2, null, ac.a.a);
    }

    public static a a(a a0, int v, boolean z, String s, long v1, long v2, String s1, String s2, Uri uri0, G g0, d d0, int v3) {
        if((v3 & 1) != 0) {
            v = a0.a;
        }
        if((v3 & 2) != 0) {
            z = a0.b;
        }
        String s3 = (v3 & 4) == 0 ? s : a0.c;
        String s4 = (v3 & 0x20) == 0 ? s1 : a0.f;
        String s5 = (v3 & 0x40) == 0 ? s2 : a0.g;
        Uri uri1 = (v3 & 0x80) == 0 ? uri0 : a0.h;
        d d1 = (v3 & 0x200) == 0 ? d0 : a0.j;
        a0.getClass();
        q.g(s3, "currentMediaId");
        q.g(s4, "title");
        q.g(s5, "artist");
        q.g(uri1, "thumbnailUri");
        q.g(d1, "abRangeRepeatState");
        return new a(v, z, s3, ((v3 & 8) == 0 ? v1 : a0.d), ((v3 & 16) == 0 ? v2 : a0.e), s4, s5, uri1, ((v3 & 0x100) == 0 ? g0 : a0.i), d1);
    }

    public final boolean b() {
        return this.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(this.a != ((a)object0).a) {
            return false;
        }
        if(this.b != ((a)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((a)object0).c)) {
            return false;
        }
        if(this.d != ((a)object0).d) {
            return false;
        }
        if(this.e != ((a)object0).e) {
            return false;
        }
        if(!q.b(this.f, ((a)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((a)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((a)object0).h)) {
            return false;
        }
        return q.b(this.i, ((a)object0).i) ? q.b(this.j, ((a)object0).j) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(A7.d.c(A7.d.c(x.b(A7.d.e(this.a * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
        int v1 = this.h.hashCode();
        return this.i == null ? this.j.hashCode() + (v1 + v) * 961 : this.j.hashCode() + ((v1 + v) * 0x1F + this.i.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PlaybackState(state=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isPlaying=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", currentMediaId=");
        b.t(this.d, this.c, ", positionMs=", stringBuilder0);
        com.iloen.melon.utils.a.s(this.e, ", durationMs=", ", title=", stringBuilder0);
        A7.d.u(stringBuilder0, this.f, ", artist=", this.g, ", thumbnailUri=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", renderer=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", abRangeRepeatState=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

