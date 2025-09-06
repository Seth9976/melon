package P5;

import java.util.Arrays;

public final class p extends B {
    public final byte[] a;
    public final byte[] b;

    public p(byte[] arr_b, byte[] arr_b1) {
        this.a = arr_b;
        this.b = arr_b1;
    }

    // 去混淆评级： 低(23)
    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return !(object0 instanceof B) || !Arrays.equals(this.a, (((B)object0) instanceof p ? ((p)(((B)object0))).a : ((p)(((B)object0))).a)) ? false : Arrays.equals(this.b, (((B)object0) instanceof p ? ((p)(((B)object0))).b : ((p)(((B)object0))).b));
    }

    @Override
    public final int hashCode() {
        return (Arrays.hashCode(this.a) ^ 1000003) * 1000003 ^ Arrays.hashCode(this.b);
    }

    @Override
    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.a) + ", encryptedBlob=" + Arrays.toString(this.b) + "}";
    }
}

