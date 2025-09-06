package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.window.layout.WindowLayoutInfo;
import b2.a;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001B\u0010\r\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u001B\u0010\u000F\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0001¢\u0006\u0004\b\u000F\u0010\u000EJ\r\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0083\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001A\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u00010\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Landroidx/window/layout/adapter/extensions/MulticastConsumer;", "Lb2/a;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "value", "Lie/H;", "accept", "(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", "Landroidx/window/layout/WindowLayoutInfo;", "listener", "addListener", "(Lb2/a;)V", "removeListener", "", "isEmpty", "()Z", "Landroid/content/Context;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "lastKnownValue", "Landroidx/window/layout/WindowLayoutInfo;", "", "registeredListeners", "Ljava/util/Set;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class MulticastConsumer implements a {
    @NotNull
    private final Context context;
    @NotNull
    private final ReentrantLock globalLock;
    @Nullable
    private WindowLayoutInfo lastKnownValue;
    @NotNull
    private final Set registeredListeners;

    public MulticastConsumer(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.context = context0;
        this.globalLock = new ReentrantLock();
        this.registeredListeners = new LinkedHashSet();
    }

    public void accept(@NotNull androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo0) {
        q.g(windowLayoutInfo0, "value");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            WindowLayoutInfo windowLayoutInfo1 = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.context, windowLayoutInfo0);
            this.lastKnownValue = windowLayoutInfo1;
            for(Object object0: this.registeredListeners) {
                ((a)object0).accept(windowLayoutInfo1);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // b2.a
    public void accept(Object object0) {
        this.accept(((androidx.window.extensions.layout.WindowLayoutInfo)object0));
    }

    public final void addListener(@NotNull a a0) {
        q.g(a0, "listener");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            WindowLayoutInfo windowLayoutInfo0 = this.lastKnownValue;
            if(windowLayoutInfo0 != null) {
                a0.accept(windowLayoutInfo0);
            }
            this.registeredListeners.add(a0);
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final boolean isEmpty() {
        return this.registeredListeners.isEmpty();
    }

    public final void removeListener(@NotNull a a0) {
        q.g(a0, "listener");
        this.globalLock.lock();
        try {
            this.registeredListeners.remove(a0);
        }
        finally {
            this.globalLock.unlock();
        }
    }
}

