package gd;

import A7.d;
import Ac.m4;
import U4.x;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;

public final class u6 extends m4 {
    public final String a;
    public final String b;
    public final o6 c;
    public final String d;
    public final String e;
    public final boolean f;
    public final List g;
    public final MutableStateFlow h;

    public u6(String s, String s1, o6 o60, String s2, String s3, boolean z, List list0, MutableStateFlow mutableStateFlow0) {
        q.g(s2, "playlistCount");
        q.g(mutableStateFlow0, "alphaFlow");
        super();
        this.a = s;
        this.b = s1;
        this.c = o60;
        this.d = s2;
        this.e = s3;
        this.f = z;
        this.g = list0;
        this.h = mutableStateFlow0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u6)) {
            return false;
        }
        if(!q.b(this.a, ((u6)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((u6)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((u6)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((u6)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((u6)object0).e)) {
            return false;
        }
        if(this.f != ((u6)object0).f) {
            return false;
        }
        return q.b(this.g, ((u6)object0).g) ? q.b(this.h, ((u6)object0).h) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = x.b(((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F, 0x1F, this.d);
        String s = this.e;
        if(s != null) {
            v = s.hashCode();
        }
        return this.h.hashCode() + d.d(d.e((v1 + v) * 0x1F, 0x1F, this.f), 0x1F, this.g);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Success(title=", this.a, ", imageUrl=", this.b, ", bannerInfo=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", playlistCount=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", genreCode=");
        Y.x(stringBuilder0, this.e, ", isLike=", this.f, ", tagList=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", alphaFlow=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

