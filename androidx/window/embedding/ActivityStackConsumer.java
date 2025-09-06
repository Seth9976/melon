package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000ER\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000F¨\u0006\u0010"}, d2 = {"Landroidx/window/embedding/ActivityStackConsumer;", "Landroidx/window/reflection/Consumer2;", "", "Landroidx/window/extensions/embedding/ActivityStack;", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "callback", "Landroidx/window/embedding/EmbeddingAdapter;", "adapter", "<init>", "(Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;Landroidx/window/embedding/EmbeddingAdapter;)V", "value", "Lie/H;", "accept", "(Ljava/util/List;)V", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "Landroidx/window/embedding/EmbeddingAdapter;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityStackConsumer implements Consumer2 {
    @NotNull
    private final EmbeddingAdapter adapter;
    @NotNull
    private final EmbeddingCallbackInterface callback;

    public ActivityStackConsumer(@NotNull EmbeddingCallbackInterface embeddingInterfaceCompat$EmbeddingCallbackInterface0, @NotNull EmbeddingAdapter embeddingAdapter0) {
        q.g(embeddingInterfaceCompat$EmbeddingCallbackInterface0, "callback");
        q.g(embeddingAdapter0, "adapter");
        super();
        this.callback = embeddingInterfaceCompat$EmbeddingCallbackInterface0;
        this.adapter = embeddingAdapter0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public void accept(Object object0) {
        this.accept(((List)object0));
    }

    public void accept(@NotNull List list0) {
        q.g(list0, "value");
        List list1 = this.adapter.translate$window_release(list0);
        this.callback.onActivityStackChanged(list1);
    }
}

