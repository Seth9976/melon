package zd;

import A7.d;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class e extends m {
    public final String a;
    public final String b;
    public final boolean c;

    public e(String s, String s1, boolean z) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = s1;
        this.c = z;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.X);
        arrayList0.add((this.c ? x.m0 : x.n0));
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        if(!q.b(this.a, ((e)object0).a)) {
            return false;
        }
        return q.b(this.b, ((e)object0).b) ? this.c == ((e)object0).c : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 27;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? Boolean.hashCode(this.c) + v * 961 : Boolean.hashCode(this.c) + (v * 0x1F + this.b.hashCode()) * 0x1F;
    }

    @Override  // zd.Q
    public final String r() {
        return this.a;
    }

    @Override  // zd.m
    public final Object s() {
        return this.b;
    }

    @Override  // zd.m
    public final l t() {
        return l.d;
    }

    @Override
    public final String toString() {
        return o.s(d.o("ArtistChannelBottomSheetType(title=", this.a, ", artistImageUrl=", this.b, ", isExcludedArtist="), this.c, ")");
    }
}

