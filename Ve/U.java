package Ve;

import kotlin.jvm.internal.q;

public final class u extends M {
    public final String a;
    public final int b;
    public final String c;

    public u(String s, int v) {
        q.g(s, "className");
        super();
        this.a = s;
        this.b = v;
        if(v <= 0) {
            throw new IllegalArgumentException("ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.");
        }
        StringBuilder stringBuilder0 = new StringBuilder("ArrayKClassValue(");
        for(int v2 = 0; v2 < v; ++v2) {
            stringBuilder0.append("kotlin/Array<");
        }
        stringBuilder0.append(this.a);
        int v3 = this.b;
        for(int v1 = 0; v1 < v3; ++v1) {
            stringBuilder0.append(">");
        }
        stringBuilder0.append(")");
        this.c = stringBuilder0.toString();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        return q.b(this.a, ((u)object0).a) ? this.b == ((u)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return this.c;
    }
}

