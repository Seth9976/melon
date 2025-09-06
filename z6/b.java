package z6;

import android.graphics.RectF;
import java.util.Arrays;

public final class b implements d {
    public final d a;
    public final float b;

    public b(float f, d d0) {
        while(d0 instanceof b) {
            d0 = ((b)d0).a;
            f += ((b)d0).b;
        }
        this.a = d0;
        this.b = f;
    }

    @Override  // z6.d
    public final float a(RectF rectF0) {
        return Math.max(0.0f, this.a.a(rectF0) + this.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? this.a.equals(((b)object0).a) && this.b == ((b)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }
}

