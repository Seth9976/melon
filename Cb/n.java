package Cb;

import De.I;
import com.iloen.melon.custom.r1;
import com.melon.ui.o1;

public final class n implements r1 {
    public final int a;
    public final o1 b;

    public n(o1 o10, int v) {
        this.a = v;
        this.b = o10;
        super();
    }

    private final void a(boolean z) {
    }

    private final void b(boolean z) {
    }

    @Override  // com.iloen.melon.custom.r1
    public final void onToolBarAnimationEnd(boolean z) {
    }

    @Override  // com.iloen.melon.custom.r1
    public final void onToolBarAnimationStart(boolean z) {
        if(this.a != 0) {
            I.V(this.b, false, true);
            return;
        }
        I.V(this.b, true, true);
    }
}

