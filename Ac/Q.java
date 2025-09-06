package ac;

import android.net.Uri;
import b3.E;

public final class q {
    public final E a;
    public final Uri b;
    public final v c;
    public final z d;
    public final j e;
    public static final q f;

    static {
        Uri uri0 = Uri.EMPTY;
        kotlin.jvm.internal.q.f(uri0, "EMPTY");
        kotlin.jvm.internal.q.f(E.g, "EMPTY");
        q.f = new q(E.g, uri0, s.a, z.e, j.f);
    }

    public q(E e0, Uri uri0, v v0, z z0, int v1) {
        if((v1 & 2) != 0) {
            uri0 = Uri.EMPTY;
            kotlin.jvm.internal.q.f(uri0, "EMPTY");
        }
        if((v1 & 4) != 0) {
            v0 = s.a;
        }
        if((v1 & 8) != 0) {
            z0 = z.e;
        }
        this(e0, uri0, v0, z0, j.f);
    }

    public q(E e0, Uri uri0, v v0, z z0, j j0) {
        kotlin.jvm.internal.q.g(e0, "mediaItem");
        kotlin.jvm.internal.q.g(uri0, "uri");
        kotlin.jvm.internal.q.g(v0, "source");
        kotlin.jvm.internal.q.g(z0, "analytics");
        kotlin.jvm.internal.q.g(j0, "audioEffect");
        super();
        this.a = e0;
        this.b = uri0;
        this.c = v0;
        this.d = z0;
        this.e = j0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.a, ((q)object0).a)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.b, ((q)object0).b)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.c, ((q)object0).c)) {
            return false;
        }
        return kotlin.jvm.internal.q.b(this.d, ((q)object0).d) ? kotlin.jvm.internal.q.b(this.e, ((q)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + (this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "MediaItemSource(mediaItem=" + this.a + ", uri=" + this.b + ", source=" + this.c + ", analytics=" + this.d + ", audioEffect=" + this.e + ")";
    }
}

