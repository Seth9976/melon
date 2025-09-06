package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class e5 {
    public final int[] a;
    public final int b;
    public static final e5 c;
    public static final e5 d;
    public static final e5 e;

    static {
        e5.c = new e5(new int[]{2}, 8);
        e5.d = new e5(new int[]{2, 7, 8}, 8);
        e5.e = new e5(new int[]{2, 5, 6}, 8);
    }

    public e5(int[] arr_v, int v) {
        if(arr_v == null) {
            this.a = new int[0];
        }
        else {
            int[] arr_v1 = Arrays.copyOf(arr_v, arr_v.length);
            this.a = arr_v1;
            Arrays.sort(arr_v1);
        }
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e5 ? Arrays.equals(this.a, ((e5)object0).a) && this.b == ((e5)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.a) * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.a) + "]";
    }
}

