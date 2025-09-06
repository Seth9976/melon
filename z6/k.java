package z6;

import android.graphics.RectF;
import java.util.Arrays;

public final class k implements d {
    public final float a;

    public k(float f) {
        this.a = f;
    }

    @Override  // z6.d
    public final float a(RectF rectF0) {
        return Math.min(rectF0.width(), rectF0.height()) * this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k ? this.a == ((k)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }
}

