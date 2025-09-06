package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import androidx.window.reflection.Predicate2;

public final class e implements Predicate2 {
    public final int a;
    public final SplitPlaceholderRule b;

    public e(SplitPlaceholderRule splitPlaceholderRule0, int v) {
        this.a = v;
        this.b = splitPlaceholderRule0;
        super();
    }

    @Override  // androidx.window.reflection.Predicate2
    public final boolean test(Object object0) {
        return this.a == 0 ? EmbeddingAdapter.translateSplitPlaceholderRule$lambda$11(this.b, ((Activity)object0)) : EmbeddingAdapter.translateSplitPlaceholderRule$lambda$13(this.b, ((Intent)object0));
    }
}

