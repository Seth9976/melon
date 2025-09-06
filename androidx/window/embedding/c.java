package androidx.window.embedding;

import android.content.Context;
import android.view.WindowMetrics;
import androidx.window.reflection.Predicate2;

public final class c implements Predicate2 {
    public final int a;
    public final Context b;
    public final SplitRule c;

    public c(SplitRule splitRule0, Context context0, int v) {
        this.a = v;
        this.c = splitRule0;
        this.b = context0;
        super();
    }

    @Override  // androidx.window.reflection.Predicate2
    public final boolean test(Object object0) {
        switch(this.a) {
            case 0: {
                return EmbeddingAdapter.translateSplitPinRule$lambda$8(((SplitPinRule)this.c), this.b, ((WindowMetrics)object0));
            }
            case 1: {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$14(((SplitPlaceholderRule)this.c), this.b, ((WindowMetrics)object0));
            }
            default: {
                return EmbeddingAdapter.translateSplitPairRule$lambda$7(((SplitPairRule)this.c), this.b, ((WindowMetrics)object0));
            }
        }
    }
}

