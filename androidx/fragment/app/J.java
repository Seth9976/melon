package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.q;

public abstract class j {
    public final L0 a;

    public j(L0 l00) {
        q.g(l00, "operation");
        super();
        this.a = l00;
    }

    public final boolean a() {
        int v = 4;
        L0 l00 = this.a;
        View view0 = l00.c.mView;
        if(view0 == null) {
            v = 0;
        }
        else if(Float.compare(view0.getAlpha(), 0.0f) != 0 || view0.getVisibility() != 0) {
            int v1 = view0.getVisibility();
            switch(v1) {
                case 0: {
                    return 2 == l00.a;
                }
                case 4: {
                    break;
                }
                case 8: {
                    return 3 == l00.a || l00.a != 2;
                }
                default: {
                    throw new IllegalArgumentException("Unknown visibility " + v1);
                }
            }
        }
        return v == l00.a || v != 2 && l00.a != 2;
    }
}

