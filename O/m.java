package O;

import P.i;
import a0.f;
import androidx.compose.foundation.lazy.layout.v;
import androidx.compose.runtime.b0;
import java.util.List;
import kotlin.jvm.internal.r;
import we.a;
import we.k;

public final class m extends r implements a {
    public final int f;
    public final b0 g;

    public m(b0 b00, int v) {
        this.f = v;
        this.g = b00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return new j(((k)this.g.getValue()));
            }
            case 1: {
                return new i(((k)this.g.getValue()));
            }
            case 2: {
                b0 b00 = this.g;
                return b00 != null ? ((List)b00.getValue()) : null;
            }
            case 3: {
                Boolean boolean0 = (Boolean)this.g.getValue();
                boolean0.booleanValue();
                return boolean0;
            }
            case 4: {
                return (f)this.g.getValue();
            }
            default: {
                return (v)((a)this.g.getValue()).invoke();
            }
        }
    }
}

