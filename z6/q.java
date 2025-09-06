package z6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import y6.a;

public final class q extends w {
    public final ArrayList c;
    public final Matrix d;

    public q(ArrayList arrayList0, Matrix matrix0) {
        this.c = arrayList0;
        this.d = matrix0;
        super();
    }

    @Override  // z6.w
    public final void a(Matrix matrix0, a a0, int v, Canvas canvas0) {
        for(Object object0: this.c) {
            ((w)object0).a(this.d, a0, v, canvas0);
        }
    }
}

