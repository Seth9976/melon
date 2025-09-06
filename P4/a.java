package p4;

import k8.Y;

public final class a {
    public final String a;
    public final int b;

    public a(String s, int v) {
        this.a = s;
        this.b = v;
        if(v != 1 && v != 2) {
            throw new IllegalArgumentException("Scope undefined.");
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a && this.a.equals(((a)object0).a) && this.b == ((a)object0).b;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return this.b == 1 ? Y.l(new StringBuilder("AppSetId: id="), this.a, ", scope=", "SCOPE_APP") : Y.l(new StringBuilder("AppSetId: id="), this.a, ", scope=", "SCOPE_DEVELOPER");
    }
}

