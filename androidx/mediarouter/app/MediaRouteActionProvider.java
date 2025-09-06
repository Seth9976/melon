package androidx.mediarouter.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.core.view.ActionProvider;
import l4.G;
import l4.Q;

public class MediaRouteActionProvider extends ActionProvider {
    public G d;
    public final s e;
    public MediaRouteButton f;

    public MediaRouteActionProvider(Context context0) {
        super(context0);
        this.d = G.c;
        this.e = s.a;
        Q.d(context0);
    }

    @Override  // androidx.core.view.ActionProvider
    public final View c() {
        if(this.f != null) {
            Log.e("MRActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don\'t reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
        }
        MediaRouteButton mediaRouteButton0 = new MediaRouteButton(this.a);
        this.f = mediaRouteButton0;
        mediaRouteButton0.setCheatSheetEnabled(true);
        this.f.setRouteSelector(this.d);
        this.f.setDialogFactory(this.e);
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return this.f;
    }

    @Override  // androidx.core.view.ActionProvider
    public final boolean e() {
        return this.f == null ? false : this.f.c();
    }
}

