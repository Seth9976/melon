package u6;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import e1.n;

public abstract class a {
    public final TimeInterpolator a;
    public final View b;
    public final int c;
    public final int d;
    public final int e;
    public b.a f;

    public a(View view0) {
        this.b = view0;
        Context context0 = view0.getContext();
        this.a = n.C(context0, 0x7F040469, new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));  // attr:motionEasingStandardDecelerateInterpolator
        this.c = n.B(context0, 0x7F040458, 300);  // attr:motionDurationMedium2
        this.d = n.B(context0, 0x7F04045D, 150);  // attr:motionDurationShort3
        this.e = n.B(context0, 0x7F04045C, 100);  // attr:motionDurationShort2
    }

    public final b.a a() {
        if(this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        b.a a0 = this.f;
        this.f = null;
        return a0;
    }
}

