package androidx.mediarouter.app;

import android.view.View.OnClickListener;
import android.view.View;
import l4.Q;

public final class y implements View.OnClickListener {
    public final int a;
    public final MediaRouteDynamicControllerDialog b;

    public y(MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog0, int v) {
        this.a = v;
        this.b = mediaRouteDynamicControllerDialog0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog0 = this.b;
            if(mediaRouteDynamicControllerDialog0.i.g()) {
                mediaRouteDynamicControllerDialog0.f.getClass();
                Q.l(2);
            }
            mediaRouteDynamicControllerDialog0.dismiss();
            return;
        }
        this.b.dismiss();
    }
}

