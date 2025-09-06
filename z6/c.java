package z6;

import android.graphics.RectF;
import java.util.Arrays;

public final class c implements d {
    public final float a;

    public c(float f) {
        this.a = f;
    }

    @Override  // z6.d
    public final float a(RectF rectF0) {
        float f = Math.min(rectF0.width() / 2.0f, rectF0.height() / 2.0f);
        return Math.min(this.a, f);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? this.a == ((c)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }
}

