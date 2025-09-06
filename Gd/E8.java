package gd;

import A7.d;
import U4.x;
import k8.Y;
import kotlin.jvm.internal.q;

public final class e8 extends i8 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;

    public e8(String s, String s1, String s2, boolean z, String s3) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
        this.e = s3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e8)) {
            return false;
        }
        if(!q.b(this.a, ((e8)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((e8)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((e8)object0).c)) {
            return false;
        }
        return this.d == ((e8)object0).d ? q.b(this.e, ((e8)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e((((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F, 0x1F, this.d);
        String s = this.e;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("TagThumbnailItem(imageUrl=", this.a, ", tagSeq=", this.b, ", tagName=");
        Y.x(stringBuilder0, this.c, ", isLeft=", this.d, ", boardTitle=");
        return x.m(stringBuilder0, this.e, ")");
    }
}

