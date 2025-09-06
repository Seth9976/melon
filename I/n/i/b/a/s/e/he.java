package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class he {
    public final int a;
    public final byte[] b;
    public final int c;
    public final int d;

    public he(int v, byte[] arr_b, int v1, int v2) {
        this.a = v;
        this.b = arr_b;
        this.c = v1;
        this.d = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return he.class == class0 && this.a == ((he)object0).a && this.c == ((he)object0).c && this.d == ((he)object0).d && Arrays.equals(this.b, ((he)object0).b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((Arrays.hashCode(this.b) + this.a * 0x1F) * 0x1F + this.c) * 0x1F + this.d;
    }
}

