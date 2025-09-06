package androidx.window.layout.adapter.extensions;

import De.d;
import android.app.Activity;
import android.content.Context;
import androidx.window.core.ConsumerAdapter.Subscription;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import b2.a;
import ie.H;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0012\u001A\u00020\u000F2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0017¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR \u0010 \u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001F0\u001E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010\"\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\b0\u001E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R \u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020#0\u001E8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010!R\u001A\u0010)\u001A\b\u0012\u0004\u0012\u00020&0%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006*"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi1;", "Landroidx/window/layout/adapter/WindowBackend;", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "component", "Landroidx/window/core/ConsumerAdapter;", "consumerAdapter", "<init>", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "Lie/H;", "registerLayoutChangeCallback", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Lb2/a;)V", "unregisterLayoutChangeCallback", "(Lb2/a;)V", "", "hasRegisteredListeners", "()Z", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "getComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "Landroidx/window/core/ConsumerAdapter;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "Landroidx/window/layout/adapter/extensions/MulticastConsumer;", "contextToListeners", "Ljava/util/Map;", "listenerToContext", "Landroidx/window/core/ConsumerAdapter$Subscription;", "consumerToToken", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "supportedPostures", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public class ExtensionWindowBackendApi1 implements WindowBackend {
    @NotNull
    private final WindowLayoutComponent component;
    @NotNull
    private final ConsumerAdapter consumerAdapter;
    @NotNull
    private final Map consumerToToken;
    @NotNull
    private final Map contextToListeners;
    @NotNull
    private final ReentrantLock globalLock;
    @NotNull
    private final Map listenerToContext;

    public ExtensionWindowBackendApi1(@NotNull WindowLayoutComponent windowLayoutComponent0, @NotNull ConsumerAdapter consumerAdapter0) {
        q.g(windowLayoutComponent0, "component");
        q.g(consumerAdapter0, "consumerAdapter");
        super();
        this.component = windowLayoutComponent0;
        this.consumerAdapter = consumerAdapter0;
        this.globalLock = new ReentrantLock();
        this.contextToListeners = new LinkedHashMap();
        this.listenerToContext = new LinkedHashMap();
        this.consumerToToken = new LinkedHashMap();
    }

    @NotNull
    public final WindowLayoutComponent getComponent() {
        return this.component;
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    @NotNull
    public List getSupportedPostures() {
        throw new UnsupportedOperationException("Extensions version must be at least 6");
    }

    // 去混淆评级： 低(30)
    @Override  // androidx.window.layout.adapter.WindowBackend
    public boolean hasRegisteredListeners() {
        return !this.contextToListeners.isEmpty() || !this.listenerToContext.isEmpty() || !this.consumerToToken.isEmpty();
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void registerLayoutChangeCallback(@NotNull Context context0, @NotNull Executor executor0, @NotNull a a0) {
        H h0;
        q.g(context0, "context");
        q.g(executor0, "executor");
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            MulticastConsumer multicastConsumer0 = (MulticastConsumer)this.contextToListeners.get(context0);
            if(multicastConsumer0 == null) {
                h0 = null;
            }
            else {
                multicastConsumer0.addListener(a0);
                this.listenerToContext.put(a0, context0);
                h0 = H.a;
            }
            if(h0 == null) {
                MulticastConsumer multicastConsumer1 = new MulticastConsumer(context0);
                this.contextToListeners.put(context0, multicastConsumer1);
                this.listenerToContext.put(a0, context0);
                multicastConsumer1.addListener(a0);
                if(context0 instanceof Activity) {
                    d d0 = I.a.b(WindowLayoutInfo.class);
                    androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1.registerLayoutChangeCallback.1.2.disposableToken.1 extensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$10 = new k() {
                        {
                            super(1, 0, MulticastConsumer.class, object0, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V");
                        }

                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((WindowLayoutInfo)object0));
                            return H.a;
                        }

                        public final void invoke(WindowLayoutInfo windowLayoutInfo0) {
                            q.g(windowLayoutInfo0, "p0");
                            ((MulticastConsumer)this.receiver).accept(windowLayoutInfo0);
                        }
                    };
                    Subscription consumerAdapter$Subscription0 = this.consumerAdapter.createSubscription(this.component, d0, "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", ((Activity)context0), extensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$10);
                    this.consumerToToken.put(multicastConsumer1, consumerAdapter$Subscription0);
                    return;
                }
                multicastConsumer1.accept(new WindowLayoutInfo(w.a));
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void unregisterLayoutChangeCallback(@NotNull a a0) {
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            Context context0 = (Context)this.listenerToContext.get(a0);
            if(context0 == null) {
                return;
            }
            MulticastConsumer multicastConsumer0 = (MulticastConsumer)this.contextToListeners.get(context0);
            if(multicastConsumer0 == null) {
                return;
            }
            multicastConsumer0.removeListener(a0);
            this.listenerToContext.remove(a0);
            if(multicastConsumer0.isEmpty()) {
                this.contextToListeners.remove(context0);
                Subscription consumerAdapter$Subscription0 = (Subscription)this.consumerToToken.remove(multicastConsumer0);
                if(consumerAdapter$Subscription0 != null) {
                    consumerAdapter$Subscription0.dispose();
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }
}

