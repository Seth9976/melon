package androidx.window.embedding;

import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.reflection.JFunction2;
import we.k;

public final class d implements JFunction2 {
    public final EmbeddingAdapter a;
    public final k b;

    public d(EmbeddingAdapter embeddingAdapter0, k k0) {
        this.a = embeddingAdapter0;
        this.b = k0;
    }

    @Override  // androidx.window.reflection.JFunction2
    public final Object apply(Object object0) {
        return EmbeddingAdapter.translateSplitAttributesCalculator$lambda$1(this.a, this.b, ((SplitAttributesCalculatorParams)object0));
    }
}

