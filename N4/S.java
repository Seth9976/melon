package N4;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;

public final class s implements S {
    public final View a;
    public final ArrayList b;

    public s(View view0, ArrayList arrayList0) {
        this.a = view0;
        this.b = arrayList0;
    }

    @Override  // N4.S
    public final void a() {
    }

    @Override  // N4.S
    public final void d() {
    }

    @Override  // N4.S
    public final void e(Transition transition0) {
        transition0.A(this);
        transition0.a(this);
    }

    @Override  // N4.S
    public final void f(Transition transition0) {
        transition0.A(this);
        this.a.setVisibility(8);
        ArrayList arrayList0 = this.b;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((View)arrayList0.get(v1)).setVisibility(0);
        }
    }

    @Override  // N4.S
    public final void g(Transition transition0) {
    }
}

