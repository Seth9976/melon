package androidx.window.embedding;

import androidx.window.extensions.embedding.EmbeddedActivityWindowInfo;
import androidx.window.reflection.Consumer2;

public final class b implements Consumer2 {
    public final ActivityWindowInfoCallbackController a;

    public b(ActivityWindowInfoCallbackController activityWindowInfoCallbackController0) {
        this.a = activityWindowInfoCallbackController0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public final void accept(Object object0) {
        ActivityWindowInfoCallbackController._init_$lambda$1(this.a, ((EmbeddedActivityWindowInfo)object0));
    }
}

