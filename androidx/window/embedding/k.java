package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import b2.a;
import java.util.List;

public final class k implements Consumer2 {
    public final String a;
    public final OverlayControllerImpl b;
    public final a c;

    public k(String s, OverlayControllerImpl overlayControllerImpl0, a a0) {
        this.a = s;
        this.b = overlayControllerImpl0;
        this.c = a0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public final void accept(Object object0) {
        OverlayControllerImpl.addOverlayInfoCallback$lambda$8$lambda$7(this.a, this.b, this.c, ((List)object0));
    }
}

