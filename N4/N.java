package N4;

import android.view.View;
import c2.M;

public final class n {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;

    public n(View view0) {
        this.a = view0.getTranslationX();
        this.b = view0.getTranslationY();
        this.c = M.g(view0);
        this.d = view0.getScaleX();
        this.e = view0.getScaleY();
        this.f = view0.getRotationX();
        this.g = view0.getRotationY();
        this.h = view0.getRotation();
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof n ? ((n)object0).a == this.a && ((n)object0).b == this.b && ((n)object0).c == this.c && ((n)object0).d == this.d && ((n)object0).e == this.e && ((n)object0).f == this.f && ((n)object0).g == this.g && ((n)object0).h == this.h : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = Float.compare(this.a, 0.0f) == 0 ? 0 : Float.floatToIntBits(this.a);
        int v2 = this.b == 0.0f ? 0 : Float.floatToIntBits(this.b);
        int v3 = this.c == 0.0f ? 0 : Float.floatToIntBits(this.c);
        int v4 = this.d == 0.0f ? 0 : Float.floatToIntBits(this.d);
        int v5 = this.e == 0.0f ? 0 : Float.floatToIntBits(this.e);
        int v6 = this.f == 0.0f ? 0 : Float.floatToIntBits(this.f);
        int v7 = this.g == 0.0f ? 0 : Float.floatToIntBits(this.g);
        float f = this.h;
        if(f != 0.0f) {
            v = Float.floatToIntBits(f);
        }
        return ((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v;
    }
}

