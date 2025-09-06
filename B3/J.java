package b3;

import android.os.Bundle;
import e3.b;
import java.util.Arrays;

public final class J extends T {
    public final float b;
    public static final String c;

    static {
        J.c = "1";
    }

    public J() {
        this.b = -1.0f;
    }

    public J(float f) {
        b.d(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.b = f;
    }

    @Override  // b3.T
    public final boolean b() {
        return this.b != -1.0f;
    }

    @Override  // b3.T
    public final Bundle c() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("0", 1);
        bundle0.putFloat("1", this.b);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof J ? this.b == ((J)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }
}

