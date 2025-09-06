package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.w;
import l4.G;

public class r extends w {
    public final boolean a;
    public AppCompatDialog b;
    public G c;

    public r() {
        this.a = false;
        this.setCancelable(true);
    }

    @Override  // androidx.fragment.app.I
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        AppCompatDialog appCompatDialog0 = this.b;
        if(appCompatDialog0 != null) {
            if(this.a) {
                ((MediaRouteDynamicControllerDialog)appCompatDialog0).h();
                return;
            }
            ((MediaRouteControllerDialog)appCompatDialog0).p();
        }
    }

    @Override  // androidx.fragment.app.w
    public final Dialog onCreateDialog(Bundle bundle0) {
        if(this.a) {
            MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog0 = new MediaRouteDynamicControllerDialog(this.getContext());
            this.b = mediaRouteDynamicControllerDialog0;
            mediaRouteDynamicControllerDialog0.g(this.c);
            return this.b;
        }
        this.b = new MediaRouteControllerDialog(this.getContext());
        return this.b;
    }

    @Override  // androidx.fragment.app.w
    public final void onStop() {
        super.onStop();
        AppCompatDialog appCompatDialog0 = this.b;
        if(appCompatDialog0 != null && !this.a) {
            ((MediaRouteControllerDialog)appCompatDialog0).g(false);
        }
    }
}

