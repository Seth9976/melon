package q1;

import A7.d;
import H0.b;
import kotlin.jvm.internal.q;

public final class f {
    public final String a;
    public final Object b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final boolean g;

    public f(String s, Object object0, boolean z, boolean z1, boolean z2, String s1, boolean z3) {
        this.a = s;
        this.b = object0;
        this.c = z;
        this.d = z1;
        this.e = z2;
        this.f = s1;
        this.g = z3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        if(!q.b(this.a, ((f)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((f)object0).b)) {
            return false;
        }
        if(this.c != ((f)object0).c) {
            return false;
        }
        if(this.d != ((f)object0).d) {
            return false;
        }
        if(this.e != ((f)object0).e) {
            return false;
        }
        return q.b(this.f, ((f)object0).f) ? this.g == ((f)object0).g : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
        String s = this.f;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.g) + (v1 + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ParameterInformation(name=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", value=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", fromDefault=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", static=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", compared=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", inlineClass=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", stable=");
        return b.k(stringBuilder0, this.g, ')');
    }
}

