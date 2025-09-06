package Q5;

import N5.c;
import java.util.Arrays;

public final class n {
    public final c a;
    public final byte[] b;

    public n(c c0, byte[] arr_b) {
        if(c0 == null) {
            throw new NullPointerException("encoding is null");
        }
        if(arr_b == null) {
            throw new NullPointerException("bytes is null");
        }
        this.a = c0;
        this.b = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n)) {
            return false;
        }
        return this.a.equals(((n)object0).a) ? Arrays.equals(this.b, ((n)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.b);
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ v;
    }

    @Override
    public final String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}

