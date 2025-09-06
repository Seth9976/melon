package Q;

import I.d;
import P4.a;
import androidx.compose.runtime.O0;

public final class o implements d {
    public final K b;
    public final d c;

    public o(K k0, d d0) {
        this.b = k0;
        this.c = d0;
    }

    @Override  // I.d
    public final float a(float f, float f1, float f2) {
        float f3 = this.c.a(f, f1, f2);
        boolean z = false;
        if(Float.compare(f, 0.0f) <= 0) {
            if(f + f1 <= 0.0f) {
                z = true;
            }
        }
        else if(f + f1 > f2) {
            z = true;
        }
        K k0 = this.b;
        if(Float.compare(Math.abs(f3), 0.0f) != 0 && z) {
            float f4;
            for(f4 = ((float)k0.f) * -1.0f; f3 > 0.0f && f4 < f3; f4 += (float)k0.n()) {
            }
            while(f3 < 0.0f && f4 > f3) {
                f4 -= (float)k0.n();
            }
            return f4;
        }
        if(((double)Math.abs(k0.f)) < 0.000001) {
            return 0.0f;
        }
        float f5 = ((float)k0.f) * -1.0f;
        return a.i((((Boolean)((O0)k0.H).getValue()).booleanValue() ? f5 + ((float)k0.n()) : ((float)k0.f) * -1.0f), -f2, f2);
    }
}

