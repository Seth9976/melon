package vf;

import kotlin.jvm.internal.q;
import qf.b;

public final class f {
    public final b a;
    public final int b;

    public f(b b0, int v) {
        this.a = b0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        return q.b(this.a, ((f)object0).a) ? this.b == ((f)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v1 = 0; true; ++v1) {
            int v2 = this.b;
            if(v1 >= v2) {
                break;
            }
            stringBuilder0.append("kotlin/Array<");
        }
        stringBuilder0.append(this.a);
        for(int v = 0; v < v2; ++v) {
            stringBuilder0.append(">");
        }
        return stringBuilder0.toString();
    }
}

