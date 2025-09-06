package androidx.window.embedding;

import androidx.window.reflection.Consumer2;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B!\u0012\u0018\u0010\u0006\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\n\u001A\u00020\u00052\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000BR&\u0010\u0006\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\r"}, d2 = {"Landroidx/window/embedding/OverlayControllerActivityStackConsumer;", "Landroidx/window/reflection/Consumer2;", "", "Landroidx/window/extensions/embedding/ActivityStack;", "Lkotlin/Function1;", "Lie/H;", "block", "<init>", "(Lwe/k;)V", "value", "accept", "(Ljava/util/List;)V", "Lwe/k;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class OverlayControllerActivityStackConsumer implements Consumer2 {
    @NotNull
    private final k block;

    public OverlayControllerActivityStackConsumer(@NotNull k k0) {
        q.g(k0, "block");
        super();
        this.block = k0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public void accept(Object object0) {
        this.accept(((List)object0));
    }

    public void accept(@NotNull List list0) {
        q.g(list0, "value");
        this.block.invoke(list0);
    }
}

