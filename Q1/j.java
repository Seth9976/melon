package q1;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class j {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final int e;

    public j(int v, int v1, int v2, int v3, String s) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = s;
        this.e = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j)) {
            return false;
        }
        if(this.a != ((j)object0).a) {
            return false;
        }
        if(this.b != ((j)object0).b) {
            return false;
        }
        if(this.c != ((j)object0).c) {
            return false;
        }
        return q.b(this.d, ((j)object0).d) ? this.e == ((j)object0).e : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.c, d.b(this.b, this.a * 0x1F, 0x1F), 0x1F);
        return this.d == null ? this.e + v * 0x1F : this.e + (v + this.d.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SourceLocation(lineNumber=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", offset=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", length=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", sourceFile=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", packageHash=");
        return o.q(stringBuilder0, this.e, ')');
    }
}

