package b;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

public abstract class n {
    @NotNull
    private final CopyOnWriteArrayList cancellables;
    @Nullable
    private a enabledChangedCallback;
    private boolean isEnabled;

    public n(boolean z) {
        this.isEnabled = z;
        this.cancellables = new CopyOnWriteArrayList();
    }

    public final void addCancellable(@NotNull b b0) {
        q.g(b0, "cancellable");
        this.cancellables.add(b0);
    }

    @Nullable
    public final a getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(@NotNull b.a a0) {
        q.g(a0, "backEvent");
    }

    public void handleOnBackStarted(@NotNull b.a a0) {
        q.g(a0, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        for(Object object0: this.cancellables) {
            ((b)object0).cancel();
        }
    }

    public final void removeCancellable(@NotNull b b0) {
        q.g(b0, "cancellable");
        this.cancellables.remove(b0);
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        a a0 = this.enabledChangedCallback;
        if(a0 != null) {
            a0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(@Nullable a a0) {
        this.enabledChangedCallback = a0;
    }
}

