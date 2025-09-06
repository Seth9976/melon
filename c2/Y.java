package c2;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

public final class y implements z {
    public final ScrollFeedbackProvider a;

    public y(NestedScrollView nestedScrollView0) {
        this.a = ScrollFeedbackProvider.createProvider(nestedScrollView0);
    }

    @Override  // c2.z
    public final void onScrollLimit(int v, int v1, int v2, boolean z) {
        this.a.onScrollLimit(v, v1, v2, z);
    }

    @Override  // c2.z
    public final void onScrollProgress(int v, int v1, int v2, int v3) {
        this.a.onScrollProgress(v, v1, v2, v3);
    }
}

