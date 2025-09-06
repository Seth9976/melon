package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.reflection.Consumer2;
import b2.a;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresWindowSdkExtension(version = 2)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\u000E\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0010\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\u0004\b\u0010\u0010\u000FJ\r\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00010\u001A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Landroidx/window/layout/adapter/extensions/MulticastConsumerApi2;", "Lb2/a;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "Landroidx/window/reflection/Consumer2;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "value", "Lie/H;", "accept", "(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", "Landroidx/window/layout/WindowLayoutInfo;", "listener", "addListener", "(Lb2/a;)V", "removeListener", "", "isEmpty", "()Z", "Landroid/content/Context;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "lastKnownValue", "Landroidx/window/layout/WindowLayoutInfo;", "", "registeredListeners", "Ljava/util/Set;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class MulticastConsumerApi2 implements Consumer2, a {
    @NotNull
    private final Context context;
    @NotNull
    private final ReentrantLock globalLock;
    @Nullable
    private WindowLayoutInfo lastKnownValue;
    @NotNull
    private final Set registeredListeners;

    public MulticastConsumerApi2(@NotNull Context context0) {
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

    @Override  // b2.a, androidx.window.reflection.Consumer2
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

