package b;

import android.content.Context;
import androidx.activity.ComponentActivity;
import d.b;

public final class e implements b {
    public final ComponentActivity a;

    public e(ComponentActivity componentActivity0) {
        this.a = componentActivity0;
    }

    @Override  // d.b
    public final void onContextAvailable(Context context0) {
        ComponentActivity._init_$lambda$5(this.a, context0);
    }
}

