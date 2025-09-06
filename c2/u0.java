package c2;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

public class u0 extends t0 {
    public u0(B0 b00, WindowInsets windowInsets0) {
        super(b00, windowInsets0);
    }

    public u0(B0 b00, u0 u00) {
        super(b00, u00);
    }

    @Override  // c2.y0
    public B0 a() {
        return B0.h(null, this.c.consumeDisplayCutout());
    }

    @Override  // c2.s0
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u0 ? Objects.equals(this.c, ((u0)object0).c) && Objects.equals(this.g, ((u0)object0).g) && s0.C(this.h, ((u0)object0).h) : false;
    }

    @Override  // c2.y0
    public j f() {
        DisplayCutout displayCutout0 = this.c.getDisplayCutout();
        return displayCutout0 == null ? null : new j(displayCutout0);
    }

    @Override  // c2.y0
    public int hashCode() {
        return this.c.hashCode();
    }
}

