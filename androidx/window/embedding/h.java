package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import java.util.List;

public final class h implements Consumer2 {
    public final EmbeddingCallbackInterface a;
    public final EmbeddingCompat b;

    public h(EmbeddingCallbackInterface embeddingInterfaceCompat$EmbeddingCallbackInterface0, EmbeddingCompat embeddingCompat0) {
        this.a = embeddingInterfaceCompat$EmbeddingCallbackInterface0;
        this.b = embeddingCompat0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public final void accept(Object object0) {
        EmbeddingCompat.registerSplitInfoCallback$lambda$0(this.a, this.b, ((List)object0));
    }
}

