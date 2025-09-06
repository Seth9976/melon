package D4;

import Tf.p;
import d5.f;
import java.util.Locale;
import kotlin.jvm.internal.q;

public final class o {
    public final String a;
    public final String b;
    public final boolean c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;

    public o(int v, String s, String s1, String s2, boolean z, int v1) {
        q.g(s, "name");
        int v2;
        q.g(s1, "type");
        super();
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = v;
        this.e = s2;
        this.f = v1;
        String s3 = s1.toUpperCase(Locale.ROOT);
        q.f(s3, "toUpperCase(...)");
        if(Tf.o.v0(s3, "INT", false)) {
            v2 = 3;
        }
        else if(Tf.o.v0(s3, "CHAR", false) || Tf.o.v0(s3, "CLOB", false) || Tf.o.v0(s3, "TEXT", false)) {
            v2 = 2;
        }
        else if(Tf.o.v0(s3, "BLOB", false)) {
            v2 = 5;
        }
        else if(Tf.o.v0(s3, "REAL", false) || Tf.o.v0(s3, "FLOA", false) || Tf.o.v0(s3, "DOUB", false)) {
            v2 = 4;
        }
        else {
            v2 = 1;
        }
        this.g = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof o) {
                int v = ((o)object0).f;
                if((this.d <= 0 ? 0 : 1) == (((o)object0).d <= 0 ? 0 : 1) && q.b(this.a, ((o)object0).a) && this.c == ((o)object0).c) {
                    String s = ((o)object0).e;
                    int v1 = this.f;
                    String s1 = this.e;
                    if((v1 != 1 || v != 2 || s1 == null || f.u(s1, s)) && (v1 != 2 || v != 1 || s == null || f.u(s, s1))) {
                        if(v1 != 0 && v1 == v) {
                            if(s1 != null) {
                                return f.u(s1, s) ? this.g == ((o)object0).g : false;
                            }
                            return s == null ? this.g == ((o)object0).g : false;
                        }
                        return this.g == ((o)object0).g;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = (this.a.hashCode() * 0x1F + this.g) * 0x1F;
        return this.c ? (v + 0x4CF) * 0x1F + this.d : (v + 0x4D5) * 0x1F + this.d;
    }

    @Override
    public final String toString() {
        return p.a0(p.d0(("\n            |Column {\n            |   name = \'" + this.a + "\',\n            |   type = \'" + this.b + "\',\n            |   affinity = \'" + this.g + "\',\n            |   notNull = \'" + this.c + "\',\n            |   primaryKeyPosition = \'" + this.d + "\',\n            |   defaultValue = \'" + (this.e == null ? "undefined" : this.e) + "\'\n            |}\n        ")), "    ");
    }
}

