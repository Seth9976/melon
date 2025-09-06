package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.res.Configuration;

public final class a implements b2.a {
    public final SidecarCompat a;
    public final Activity b;

    public a(SidecarCompat sidecarCompat0, Activity activity0) {
        this.a = sidecarCompat0;
        this.b = activity0;
    }

    @Override  // b2.a
    public final void accept(Object object0) {
        SidecarCompat.registerConfigurationChangeListener$lambda$0(this.a, this.b, ((Configuration)object0));
    }
}

