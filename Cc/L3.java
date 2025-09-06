package Cc;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.G;
import kotlin.jvm.internal.q;

public final class l3 implements G {
    public final View a;
    public final int b;

    public l3(View view0, int v) {
        this.a = view0;
        this.b = v;
    }

    @Override  // androidx.compose.runtime.G
    public final void dispose() {
        Context context0 = this.a.getContext();
        q.f(context0, "getContext(...)");
        if(!m3.a(context0).isChangingConfigurations()) {
            m3.a.delete(this.b);
        }
    }
}

