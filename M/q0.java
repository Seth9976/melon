package M;

import N.a;
import androidx.compose.foundation.layout.LayoutWeightElement;
import r0.q;

public interface q0 {
    static q a(q q0, float f) {
        if(((double)f) <= 0.0) {
            a.a("invalid weight; must be greater than zero");
        }
        if(f > 3.402823E+38f) {
            f = 3.402823E+38f;
        }
        return q0.then(new LayoutWeightElement(f, true));
    }
}

