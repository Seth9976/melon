package v4;

import java.util.Arrays;
import java.util.Objects;

public final class a {
    public final byte[] a;
    public final String b;
    public final byte[] c;

    public a(byte[] arr_b, String s, byte[] arr_b1) {
        this.a = arr_b;
        this.b = s;
        this.c = arr_b1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a ? Arrays.equals(this.a, ((a)object0).a) && this.b.contentEquals(((a)object0).b) && Arrays.equals(this.c, ((a)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        Integer integer0 = Arrays.hashCode(this.a);
        Integer integer1 = Arrays.hashCode(this.c);
        return Objects.hash(new Object[]{integer0, this.b, integer1});
    }

    @Override
    public final String toString() {
        return "EncryptedTopic { " + ("EncryptedTopic=" + new String(this.a, Tf.a.a) + ", KeyIdentifier=" + this.b + ", EncapsulatedKey=" + new String(this.c, Tf.a.a) + " }");
    }
}

