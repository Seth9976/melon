package b3;

import android.os.Bundle;
import java.util.Arrays;

public final class p extends T {
    public final boolean b;
    public final boolean c;
    public static final String d;
    public static final String e;

    static {
        p.d = "1";
        p.e = "2";
    }

    public p() {
        this.b = false;
        this.c = false;
    }

    public p(boolean z) {
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
        bundle0.putInt("0", 0);
        bundle0.putBoolean("1", this.b);
        bundle0.putBoolean("2", this.c);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof p && this.c == ((p)object0).c && this.b == ((p)object0).b;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.b), Boolean.valueOf(this.c)});
    }
}

