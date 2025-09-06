package Fc;

import J8.C;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.ui.LyricHighlightUtils.Companion;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import kotlin.jvm.internal.q;

public final class j extends CustomTarget {
    public final C a;
    public final ViewComponentManager.FragmentContextWrapper b;

    public j(C c0, ViewComponentManager.FragmentContextWrapper viewComponentManager$FragmentContextWrapper0) {
        this.a = c0;
        this.b = viewComponentManager$FragmentContextWrapper0;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.CustomTarget
    public final void onLoadFailed(Drawable drawable0) {
        super.onLoadFailed(drawable0);
        this.a.c.setImageBitmap(null);
        q.f(this.a.d, "dim");
        this.a.d.setVisibility(8);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        q.g(((Bitmap)object0), "resource");
        Bitmap bitmap0 = Companion.drawPalette$default(LyricHighlightUtils.Companion, this.b, ((Bitmap)object0), false, false, 4, null);
        this.a.c.setImageBitmap(bitmap0);
        this.a.d.setVisibility(0);
    }
}

