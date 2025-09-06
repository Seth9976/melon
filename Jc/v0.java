package Jc;

import Hc.w;
import J8.h2;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolderForMelonBase;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.viewable.ViewableCheck.Builder;
import kotlin.jvm.internal.q;
import y5.a;

public final class v0 extends ViewableCheckViewHolderForMelonBase {
    public final h2 a;
    public static final int b;

    public v0(h2 h20, w w0) {
        q.f(h20.a, "getRoot(...)");
        super(h20.a);
        this.a = h20;
        int v = a.B(this).getResources().getDimensionPixelSize(0x7F07045E);  // dimen:thumb_width_song
        ViewUtils.setDefaultImage(h20.h.c, v);
        h20.a.addOnAttachStateChangeListener(this);
        this.setOnImpLogListener(w0);
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    public final void addAndStartViewableCheck(View view0, int v, we.a a0) {
        if(this.hasViewableCheck(v)) {
            this.removeAllViewableCheck();
        }
        if(view0 != null && a0 != null) {
            Builder viewableCheck$Builder0 = new Builder(view0);
            viewableCheck$Builder0.setCallback(a0);
            viewableCheck$Builder0.setIgnoreIntersectionChecker(false);
            this.addViewableCheck(v, viewableCheck$Builder0.build());
            if(q.b(this.isForegroundFragment(), Boolean.TRUE)) {
                this.viewableCheckStart(v);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    public final I getCurrentFragment() {
        return null;
    }
}

