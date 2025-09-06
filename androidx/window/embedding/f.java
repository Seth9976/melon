package androidx.window.embedding;

import android.util.Pair;
import androidx.window.reflection.Predicate2;

public final class f implements Predicate2 {
    public final int a;
    public final SplitPairRule b;

    public f(SplitPairRule splitPairRule0, int v) {
        this.a = v;
        this.b = splitPairRule0;
        super();
    }

    @Override  // androidx.window.reflection.Predicate2
    public final boolean test(Object object0) {
        return this.a == 0 ? EmbeddingAdapter.translateSplitPairRule$lambda$4(this.b, ((Pair)object0)) : EmbeddingAdapter.translateSplitPairRule$lambda$6(this.b, ((Pair)object0));
    }
}

