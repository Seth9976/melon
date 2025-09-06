package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import androidx.window.reflection.Predicate2;

public final class g implements Predicate2 {
    public final int a;
    public final ActivityRule b;

    public g(ActivityRule activityRule0, int v) {
        this.a = v;
        this.b = activityRule0;
        super();
    }

    @Override  // androidx.window.reflection.Predicate2
    public final boolean test(Object object0) {
        return this.a == 0 ? EmbeddingAdapter.translateActivityRule$lambda$16(this.b, ((Activity)object0)) : EmbeddingAdapter.translateActivityRule$lambda$18(this.b, ((Intent)object0));
    }
}

