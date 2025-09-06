package b3;

import android.os.Bundle;
import java.util.Arrays;

public final class k0 extends T {
    public final boolean b;
    public final boolean c;
    public static final String d;
    public static final String e;

    static {
        k0.d = "1";
        k0.e = "2";
    }

    public k0() {
        this.b = false;
        this.c = false;
    }

    public k0(boolean z) {
        this.b = true;
        this.c = z;
    }

    @Override  // b3.T
    public final boolean b() {
        return this.b;
    }

    @Override  // b3.T
    public final Bundle c() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("0", 3);
        bundle0.putBoolean(k0.d, this.b);
        bundle0.putBoolean(k0.e, this.c);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof k0 && this.c == ((k0)object0).c && this.b == ((k0)object0).b;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.b), Boolean.valueOf(this.c)});
    }
}

