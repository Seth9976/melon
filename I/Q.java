package I;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import we.k;

public final class q implements F0 {
    public final r a;

    public q(r r0) {
        this.a = r0;
    }

    @Override  // I.F0
    public final float a(float f) {
        if(Float.isNaN(f)) {
            return 0.0f;
        }
        float f1 = ((Number)((k)this.a.a).invoke(f)).floatValue();
        boolean z = false;
        ((O0)this.a.e).setValue(Boolean.valueOf(Float.compare(f1, 0.0f) > 0));
        b0 b00 = this.a.f;
        if(f1 < 0.0f) {
            z = true;
        }
        ((O0)b00).setValue(Boolean.valueOf(z));
        return f1;
    }
}

