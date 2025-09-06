package androidx.mediarouter.app;

import B.a;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.w;
import l4.G;

public class d extends w {
    public final boolean a;
    public AppCompatDialog b;
    public G c;

    public d() {
        this.a = false;
        this.setCancelable(true);
    }

    public final void m() {
        if(this.c == null) {
            Bundle bundle0 = this.getArguments();
            if(bundle0 != null) {
                this.c = G.b(bundle0.getBundle("selector"));
            }
            if(this.c == null) {
                this.c = G.c;
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onConfigurationChanged(Configuration configuration0) {
        int v = -2;
        super.onConfigurationChanged(configuration0);
        AppCompatDialog appCompatDialog0 = this.b;
        if(appCompatDialog0 == null) {
            return;
        }
        if(this.a) {
            Context context0 = ((MediaRouteDynamicChooserDialog)appCompatDialog0).h;
            int v1 = context0.getResources().getBoolean(0x7F050009) ? a.z(context0) : -1;  // bool:is_tablet
            if(!context0.getResources().getBoolean(0x7F050009)) {  // bool:is_tablet
                v = -1;
            }
            ((MediaRouteDynamicChooserDialog)appCompatDialog0).getWindow().setLayout(v1, v);
            return;
        }
        ((MediaRouteChooserDialog)appCompatDialog0).getWindow().setLayout(a.z(((MediaRouteChooserDialog)appCompatDialog0).getContext()), -2);
    }

    @Override  // androidx.fragment.app.w
    public final Dialog onCreateDialog(Bundle bundle0) {
        if(this.a) {
            MediaRouteDynamicChooserDialog mediaRouteDynamicChooserDialog0 = new MediaRouteDynamicChooserDialog(this.getContext());
            this.b = mediaRouteDynamicChooserDialog0;
            this.m();
            mediaRouteDynamicChooserDialog0.e(this.c);
            return this.b;
        }
        MediaRouteChooserDialog mediaRouteChooserDialog0 = new MediaRouteChooserDialog(this.getContext());
        this.b = mediaRouteChooserDialog0;
        this.m();
        mediaRouteChooserDialog0.f(this.c);
        return this.b;
    }
}

