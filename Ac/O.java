package ac;

import A7.d;
import U4.x;
import android.net.Uri;
import k8.Y;
import kotlin.jvm.internal.q;

public final class o {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;
    public final int h;
    public final String i;
    public final Uri j;
    public final long k;

    public o(String s, String s1, String s2, String s3, boolean z, String s4, String s5, int v, String s6, Uri uri0, long v1) {
        q.g(s4, "localIp");
        q.g(uri0, "largeAlbumArtUri");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = z;
        this.f = s4;
        this.g = s5;
        this.h = v;
        this.i = s6;
        this.j = uri0;
        this.k = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o)) {
            return false;
        }
        if(!q.b(this.a, ((o)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((o)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((o)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((o)object0).d)) {
            return false;
        }
        if(this.e != ((o)object0).e) {
            return false;
        }
        if(!q.b(this.f, ((o)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((o)object0).g)) {
            return false;
        }
        if(this.h != ((o)object0).h) {
            return false;
        }
        if(!q.b(this.i, ((o)object0).i)) {
            return false;
        }
        return q.b(this.j, ((o)object0).j) ? this.k == ((o)object0).k : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.k) + (this.j.hashCode() + x.b(d.b(this.h, x.b(x.b(d.e(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F), 0x1F, this.i)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DlnaContentsInfo(id=", this.a, ", title=", this.b, ", artist=");
        d.u(stringBuilder0, this.c, ", album=", this.d, ", isOriginLocal=");
        Y.y(stringBuilder0, this.e, ", localIp=", this.f, ", metaType=");
        d.t(stringBuilder0, this.g, ", port=", this.h, ", creator=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", largeAlbumArtUri=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", duration=");
        return x.h(this.k, ")", stringBuilder0);
    }
}

