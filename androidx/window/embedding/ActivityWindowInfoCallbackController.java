package androidx.window.embedding;

import android.app.Activity;
import android.graphics.Rect;
import android.util.ArrayMap;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import b2.a;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresWindowSdkExtension(version = 6)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\b\u0011\u0018\u00002\u00020\u0001:\u0001&B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u001B\u0010\u000E\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u0010H\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001A\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00100\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR>\u0010\u001E\u001A\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0012\u00060\u001DR\u00020\u00000\u001C8\u0000@\u0000X\u0081\u000E¢\u0006\u0018\n\u0004\b\u001E\u0010\u001F\u0012\u0004\b$\u0010%\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006\'"}, d2 = {"Landroidx/window/embedding/ActivityWindowInfoCallbackController;", "", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "embeddingExtension", "<init>", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;)V", "Landroid/app/Activity;", "activity", "Lb2/a;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "callback", "Lie/H;", "addCallback", "(Landroid/app/Activity;Lb2/a;)V", "removeCallback", "(Lb2/a;)V", "Landroidx/window/extensions/embedding/EmbeddedActivityWindowInfo;", "info", "translate$window_release", "(Landroidx/window/extensions/embedding/EmbeddedActivityWindowInfo;)Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "translate", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/window/extensions/core/util/function/Consumer;", "extensionsCallback", "Landroidx/window/extensions/core/util/function/Consumer;", "", "Landroidx/window/embedding/ActivityWindowInfoCallbackController$CallbackWrapper;", "callbacks", "Ljava/util/Map;", "getCallbacks$window_release", "()Ljava/util/Map;", "setCallbacks$window_release", "(Ljava/util/Map;)V", "getCallbacks$window_release$annotations", "()V", "CallbackWrapper", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public class ActivityWindowInfoCallbackController {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0081\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Landroidx/window/embedding/ActivityWindowInfoCallbackController$CallbackWrapper;", "", "Landroid/app/Activity;", "activity", "Lb2/a;", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "callback", "<init>", "(Landroidx/window/embedding/ActivityWindowInfoCallbackController;Landroid/app/Activity;Lb2/a;)V", "newInfo", "", "shouldReportInfo", "(Landroidx/window/embedding/EmbeddedActivityWindowInfo;)Z", "Landroidx/window/extensions/embedding/EmbeddedActivityWindowInfo;", "extensionsActivityWindowInfo", "Lie/H;", "accept", "(Landroidx/window/extensions/embedding/EmbeddedActivityWindowInfo;)V", "Landroid/app/Activity;", "Lb2/a;", "getCallback", "()Lb2/a;", "lastReportedInfo", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "getLastReportedInfo", "()Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "setLastReportedInfo", "(Landroidx/window/embedding/EmbeddedActivityWindowInfo;)V", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public final class CallbackWrapper {
        @NotNull
        private final Activity activity;
        @NotNull
        private final a callback;
        @Nullable
        private EmbeddedActivityWindowInfo lastReportedInfo;

        public CallbackWrapper(@NotNull Activity activity0, @NotNull a a0) {
            q.g(activity0, "activity");
            q.g(a0, "callback");
            ActivityWindowInfoCallbackController.this = activityWindowInfoCallbackController0;
            super();
            this.activity = activity0;
            this.callback = a0;
        }

        public final void accept(@NotNull androidx.window.extensions.embedding.EmbeddedActivityWindowInfo embeddedActivityWindowInfo0) {
            q.g(embeddedActivityWindowInfo0, "extensionsActivityWindowInfo");
            Activity activity0 = embeddedActivityWindowInfo0.getActivity();
            q.f(activity0, "getActivity(...)");
            if(q.b(this.activity, activity0)) {
                EmbeddedActivityWindowInfo embeddedActivityWindowInfo1 = ActivityWindowInfoCallbackController.this.translate$window_release(embeddedActivityWindowInfo0);
                if(this.shouldReportInfo(embeddedActivityWindowInfo1)) {
                    this.lastReportedInfo = embeddedActivityWindowInfo1;
                    this.callback.accept(embeddedActivityWindowInfo1);
                }
            }
        }

        @NotNull
        public final a getCallback() {
            return this.callback;
        }

        @Nullable
        public final EmbeddedActivityWindowInfo getLastReportedInfo() {
            return this.lastReportedInfo;
        }

        public final void setLastReportedInfo(@Nullable EmbeddedActivityWindowInfo embeddedActivityWindowInfo0) {
            this.lastReportedInfo = embeddedActivityWindowInfo0;
        }

        private final boolean shouldReportInfo(EmbeddedActivityWindowInfo embeddedActivityWindowInfo0) {
            EmbeddedActivityWindowInfo embeddedActivityWindowInfo1 = this.lastReportedInfo;
            if(embeddedActivityWindowInfo1 != null) {
                if(embeddedActivityWindowInfo1.isEmbedded() != embeddedActivityWindowInfo0.isEmbedded()) {
                    return true;
                }
                return embeddedActivityWindowInfo0.isEmbedded() ? !embeddedActivityWindowInfo1.equals(embeddedActivityWindowInfo0) : false;
            }
            return embeddedActivityWindowInfo0.isEmbedded();
        }
    }

    @NotNull
    private Map callbacks;
    @NotNull
    private final ActivityEmbeddingComponent embeddingExtension;
    @NotNull
    private final Consumer extensionsCallback;
    @NotNull
    private final ReentrantLock globalLock;

    public ActivityWindowInfoCallbackController(@NotNull ActivityEmbeddingComponent activityEmbeddingComponent0) {
        q.g(activityEmbeddingComponent0, "embeddingExtension");
        super();
        this.embeddingExtension = activityEmbeddingComponent0;
        this.globalLock = new ReentrantLock();
        this.callbacks = new ArrayMap();
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        this.extensionsCallback = new b(this);
    }

    private static final void _init_$lambda$1(ActivityWindowInfoCallbackController activityWindowInfoCallbackController0, androidx.window.extensions.embedding.EmbeddedActivityWindowInfo embeddedActivityWindowInfo0) {
        q.g(embeddedActivityWindowInfo0, "info");
        ReentrantLock reentrantLock0 = activityWindowInfoCallbackController0.globalLock;
        reentrantLock0.lock();
        try {
            for(Object object0: activityWindowInfoCallbackController0.callbacks.values()) {
                ((CallbackWrapper)object0).accept(embeddedActivityWindowInfo0);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void addCallback(@NotNull Activity activity0, @NotNull a a0) {
        q.g(activity0, "activity");
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            if(this.callbacks.isEmpty()) {
                l.a a1 = new l.a(1);
                this.embeddingExtension.setEmbeddedActivityWindowInfoCallback(a1, this.extensionsCallback);
            }
            CallbackWrapper activityWindowInfoCallbackController$CallbackWrapper0 = new CallbackWrapper(this, activity0, a0);
            this.callbacks.put(a0, activityWindowInfoCallbackController$CallbackWrapper0);
            androidx.window.extensions.embedding.EmbeddedActivityWindowInfo embeddedActivityWindowInfo0 = this.embeddingExtension.getEmbeddedActivityWindowInfo(activity0);
            if(embeddedActivityWindowInfo0 != null) {
                activityWindowInfoCallbackController$CallbackWrapper0.accept(embeddedActivityWindowInfo0);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @NotNull
    public final Map getCallbacks$window_release() {
        return this.callbacks;
    }

    public static void getCallbacks$window_release$annotations() {
    }

    public final void removeCallback(@NotNull a a0) {
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            if(this.callbacks.remove(a0) == null) {
                return;
            }
            if(this.callbacks.isEmpty()) {
                this.embeddingExtension.clearEmbeddedActivityWindowInfoCallback();
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void setCallbacks$window_release(@NotNull Map map0) {
        q.g(map0, "<set-?>");
        this.callbacks = map0;
    }

    @NotNull
    public EmbeddedActivityWindowInfo translate$window_release(@NotNull androidx.window.extensions.embedding.EmbeddedActivityWindowInfo embeddedActivityWindowInfo0) {
        q.g(embeddedActivityWindowInfo0, "info");
        Rect rect0 = new Rect(embeddedActivityWindowInfo0.getTaskBounds());
        Rect rect1 = new Rect(embeddedActivityWindowInfo0.getActivityStackBounds());
        rect1.offset(-rect0.left, -rect0.top);
        return new EmbeddedActivityWindowInfo(embeddedActivityWindowInfo0.isEmbedded(), rect0, rect1);
    }
}

