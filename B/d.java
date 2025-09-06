package b;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;

public final class d implements B {
    public final int a;
    public final ComponentActivity b;

    public d(ComponentActivity componentActivity0, int v) {
        this.a = v;
        this.b = componentActivity0;
        super();
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        if(this.a != 0) {
            ComponentActivity._init_$lambda$3(this.b, d0, r0);
            return;
        }
        ComponentActivity._init_$lambda$2(this.b, d0, r0);
    }
}

