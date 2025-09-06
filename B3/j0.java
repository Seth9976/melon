package b3;

import android.os.Bundle;
import e3.b;
import java.util.Arrays;

public final class j0 extends T {
    public final int b;
    public final float c;
    public static final String d;
    public static final String e;

    static {
        j0.d = "1";
        j0.e = "2";
    }

    public j0(int v) {
        b.d(v > 0, "maxStars must be a positive integer");
        this.b = v;
        this.c = -1.0f;
    }

    public j0(int v, float f) {
        boolean z = false;
        b.d(v > 0, "maxStars must be a positive integer");
        if(f >= 0.0f && f <= ((float)v)) {
            z = true;
        }
        b.d(z, "starRating is out of range [0, maxStars]");
        this.b = v;
        this.c = f;
    }

    @Override  // b3.T
    public final boolean b() {
        return this.c != -1.0f;
    }

    @Override  // b3.T
    public final Bundle c() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("0", 2);
        bundle0.putInt("1", this.b);
        bundle0.putFloat("2", this.c);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof j0 ? this.b == ((j0)object0).b && this.c == ((j0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }
}

