package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import b2.a;
import ie.H;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0012\u001A\u00020\u000F2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0017¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001A\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001B0\u001A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR&\u0010\u001E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\b0\u001A8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001D¨\u0006\u001F"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi2;", "Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi1;", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "component", "Landroidx/window/core/ConsumerAdapter;", "adapter", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "Lie/H;", "registerLayoutChangeCallback", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Lb2/a;)V", "unregisterLayoutChangeCallback", "(Lb2/a;)V", "", "hasRegisteredListeners", "()Z", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "Landroidx/window/layout/adapter/extensions/MulticastConsumerApi2;", "contextToListeners", "Ljava/util/Map;", "listenerToContext", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public class ExtensionWindowBackendApi2 extends ExtensionWindowBackendApi1 {
    @NotNull
    private final Map contextToListeners;
    @NotNull
    private final ReentrantLock globalLock;
    @NotNull
    private final Map listenerToContext;

    public ExtensionWindowBackendApi2(@NotNull WindowLayoutComponent windowLayoutComponent0, @NotNull ConsumerAdapter consumerAdapter0) {
        q.g(windowLayoutComponent0, "component");
        q.g(consumerAdapter0, "adapter");
        super(windowLayoutComponent0, consumerAdapter0);
        this.globalLock = new ReentrantLock();
        this.contextToListeners = new LinkedHashMap();
        this.listenerToContext = new LinkedHashMap();
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1
    public boolean hasRegisteredListeners() {
        return !this.contextToListeners.isEmpty() || !this.listenerToContext.isEmpty();
    }

    @Override  // androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1
    public void registerLayoutChangeCallback(@NotNull Context context0, @NotNull Executor executor0, @NotNull a a0) {
        H h0;
        q.g(context0, "context");
        q.g(executor0, "executor");
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            MulticastConsumerApi2 multicastConsumerApi20 = (MulticastConsumerApi2)this.contextToListeners.get(context0);
            if(multicastConsumerApi20 == null) {
                h0 = null;
            }
            else {
                multicastConsumerApi20.addListener(a0);
                this.listenerToContext.put(a0, context0);
                h0 = H.a;
            }
            if(h0 == null) {
                MulticastConsumerApi2 multicastConsumerApi21 = new MulticastConsumerApi2(context0);
                this.contextToListeners.put(context0, multicastConsumerApi21);
                this.listenerToContext.put(a0, context0);
                multicastConsumerApi21.addListener(a0);
                this.getComponent().addWindowLayoutInfoListener(context0, multicastConsumerApi21);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1
    public void unregisterLayoutChangeCallback(@NotNull a a0) {
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            Context context0 = (Context)this.listenerToContext.get(a0);
            if(context0 == null) {
                return;
            }
            MulticastConsumerApi2 multicastConsumerApi20 = (MulticastConsumerApi2)this.contextToListeners.get(context0);
            if(multicastConsumerApi20 == null) {
                return;
            }
            multicastConsumerApi20.removeListener(a0);
            this.listenerToContext.remove(a0);
            if(multicastConsumerApi20.isEmpty()) {
                this.contextToListeners.remove(context0);
                this.getComponent().removeWindowLayoutInfoListener(multicastConsumerApi20);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }
}

