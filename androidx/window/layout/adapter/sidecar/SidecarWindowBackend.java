package androidx.window.layout.adapter.sidecar;

import A3.m;
import android.app.Activity;
import android.content.Context;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import b2.a;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u0013\b\u0007\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0006H\u0003¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u00102\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u0017\u001A\u00020\u000B2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u0005R&\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001F\u0010 \u0012\u0004\b#\u0010$\u001A\u0004\b!\u0010\"R\u001A\u0010)\u001A\b\u0012\u0004\u0012\u00020&0%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006-"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;", "Landroidx/window/layout/adapter/WindowBackend;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "windowExtension", "<init>", "(Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;)V", "Landroid/app/Activity;", "activity", "", "isActivityRegistered", "(Landroid/app/Activity;)Z", "Lie/H;", "callbackRemovedForActivity", "(Landroid/app/Activity;)V", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "registerLayoutChangeCallback", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Lb2/a;)V", "unregisterLayoutChangeCallback", "(Lb2/a;)V", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "getWindowExtension", "()Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "setWindowExtension", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "windowLayoutChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getWindowLayoutChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getWindowLayoutChangeCallbacks$annotations", "()V", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "supportedPostures", "Companion", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SidecarWindowBackend implements WindowBackend {
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0003R\u0014\u0010\u0013\u001A\u00020\u000E8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;", "getInstance", "(Landroid/content/Context;)Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "initAndVerifyExtension", "(Landroid/content/Context;)Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "Landroidx/window/core/Version;", "sidecarVersion", "", "isSidecarVersionSupported", "(Landroidx/window/core/Version;)Z", "Lie/H;", "resetInstance", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "globalInstance", "Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SidecarWindowBackend getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            if(SidecarWindowBackend.globalInstance == null) {
                ReentrantLock reentrantLock0 = SidecarWindowBackend.globalLock;
                reentrantLock0.lock();
                try {
                    if(SidecarWindowBackend.globalInstance == null) {
                        SidecarWindowBackend.globalInstance = new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(context0));
                    }
                }
                finally {
                    reentrantLock0.unlock();
                }
            }
            SidecarWindowBackend sidecarWindowBackend0 = SidecarWindowBackend.globalInstance;
            q.d(sidecarWindowBackend0);
            return sidecarWindowBackend0;
        }

        @Nullable
        public final ExtensionInterfaceCompat initAndVerifyExtension(@NotNull Context context0) {
            q.g(context0, "context");
            try {
                if(!this.isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion())) {
                    return null;
                }
                ExtensionInterfaceCompat extensionInterfaceCompat0 = new SidecarCompat(context0);
                return !extensionInterfaceCompat0.validateExtensionInterface() ? null : extensionInterfaceCompat0;
            }
            catch(Throwable unused_ex) {
            }
            return null;
        }

        public final boolean isSidecarVersionSupported(@Nullable Version version0) {
            return version0 == null ? false : version0.compareTo(Version.Companion.getVERSION_0_1()) >= 0;
        }

        public final void resetInstance() {
            SidecarWindowBackend.globalInstance = null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend;)V", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "newLayout", "Lie/H;", "onWindowLayoutChanged", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public final class ExtensionListenerImpl implements ExtensionCallbackInterface {
        @Override  // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat$ExtensionCallbackInterface
        public void onWindowLayoutChanged(@NotNull Activity activity0, @NotNull WindowLayoutInfo windowLayoutInfo0) {
            q.g(activity0, "activity");
            q.g(windowLayoutInfo0, "newLayout");
            for(Object object0: SidecarWindowBackend.this.getWindowLayoutChangeCallbacks()) {
                WindowLayoutChangeCallbackWrapper sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0 = (WindowLayoutChangeCallbackWrapper)object0;
                if(q.b(sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0.getActivity(), activity0)) {
                    sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0.accept(windowLayoutInfo0);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0007¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001A\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u000E¨\u0006\u001B"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Lb2/a;)V", "newLayoutInfo", "Lie/H;", "accept", "(Landroidx/window/layout/WindowLayoutInfo;)V", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Ljava/util/concurrent/Executor;", "Lb2/a;", "getCallback", "()Lb2/a;", "lastInfo", "Landroidx/window/layout/WindowLayoutInfo;", "getLastInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "setLastInfo", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class WindowLayoutChangeCallbackWrapper {
        @NotNull
        private final Activity activity;
        @NotNull
        private final a callback;
        @NotNull
        private final Executor executor;
        @Nullable
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(@NotNull Activity activity0, @NotNull Executor executor0, @NotNull a a0) {
            q.g(activity0, "activity");
            q.g(executor0, "executor");
            q.g(a0, "callback");
            super();
            this.activity = activity0;
            this.executor = executor0;
            this.callback = a0;
        }

        public final void accept(@NotNull WindowLayoutInfo windowLayoutInfo0) {
            q.g(windowLayoutInfo0, "newLayoutInfo");
            this.lastInfo = windowLayoutInfo0;
            m m0 = new m(29, this, windowLayoutInfo0);
            this.executor.execute(m0);
        }

        private static final void accept$lambda$0(WindowLayoutChangeCallbackWrapper sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0, WindowLayoutInfo windowLayoutInfo0) {
            sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0.callback.accept(windowLayoutInfo0);
        }

        @NotNull
        public final Activity getActivity() {
            return this.activity;
        }

        @NotNull
        public final a getCallback() {
            return this.callback;
        }

        @Nullable
        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(@Nullable WindowLayoutInfo windowLayoutInfo0) {
            this.lastInfo = windowLayoutInfo0;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final boolean DEBUG = false;
    @NotNull
    private static final String TAG = "WindowServer";
    @Nullable
    private static volatile SidecarWindowBackend globalInstance;
    @NotNull
    private static final ReentrantLock globalLock;
    @Nullable
    private ExtensionInterfaceCompat windowExtension;
    @NotNull
    private final CopyOnWriteArrayList windowLayoutChangeCallbacks;

    static {
        SidecarWindowBackend.Companion = new Companion(null);
        SidecarWindowBackend.globalLock = new ReentrantLock();
    }

    public SidecarWindowBackend(@Nullable ExtensionInterfaceCompat extensionInterfaceCompat0) {
        this.windowExtension = extensionInterfaceCompat0;
        this.windowLayoutChangeCallbacks = new CopyOnWriteArrayList();
        ExtensionInterfaceCompat extensionInterfaceCompat1 = this.windowExtension;
        if(extensionInterfaceCompat1 != null) {
            extensionInterfaceCompat1.setExtensionCallback(new ExtensionListenerImpl(this));
        }
    }

    private final void callbackRemovedForActivity(Activity activity0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.windowLayoutChangeCallbacks;
        if(copyOnWriteArrayList0 == null || !copyOnWriteArrayList0.isEmpty()) {
            for(Object object0: copyOnWriteArrayList0) {
                if(q.b(((WindowLayoutChangeCallbackWrapper)object0).getActivity(), activity0)) {
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat0 = this.windowExtension;
        if(extensionInterfaceCompat0 != null) {
            extensionInterfaceCompat0.onWindowLayoutChangeListenerRemoved(activity0);
        }
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    @NotNull
    public List getSupportedPostures() {
        throw new UnsupportedOperationException("Must be called from extensions.");
    }

    @Nullable
    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    @NotNull
    public final CopyOnWriteArrayList getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    public static void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity activity0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.windowLayoutChangeCallbacks;
        if(copyOnWriteArrayList0 != null && copyOnWriteArrayList0.isEmpty()) {
            return false;
        }
        for(Object object0: copyOnWriteArrayList0) {
            if(q.b(((WindowLayoutChangeCallbackWrapper)object0).getActivity(), activity0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void registerLayoutChangeCallback(@NotNull Context context0, @NotNull Executor executor0, @NotNull a a0) {
        q.g(context0, "context");
        q.g(executor0, "executor");
        q.g(a0, "callback");
        H h0 = null;
        Activity activity0 = context0 instanceof Activity ? ((Activity)context0) : null;
        w w0 = w.a;
        if(activity0 != null) {
            ReentrantLock reentrantLock0 = SidecarWindowBackend.globalLock;
            reentrantLock0.lock();
            try {
                ExtensionInterfaceCompat extensionInterfaceCompat0 = this.windowExtension;
                if(extensionInterfaceCompat0 == null) {
                    a0.accept(new WindowLayoutInfo(w0));
                    return;
                }
                boolean z = this.isActivityRegistered(activity0);
                WindowLayoutChangeCallbackWrapper sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0 = new WindowLayoutChangeCallbackWrapper(activity0, executor0, a0);
                this.windowLayoutChangeCallbacks.add(sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0);
                if(z) {
                    Object object0 = null;
                    for(Object object1: this.windowLayoutChangeCallbacks) {
                        if(activity0.equals(((WindowLayoutChangeCallbackWrapper)object1).getActivity())) {
                            object0 = object1;
                            break;
                        }
                    }
                    if(((WindowLayoutChangeCallbackWrapper)object0) != null) {
                        h0 = ((WindowLayoutChangeCallbackWrapper)object0).getLastInfo();
                    }
                    if(h0 != null) {
                        sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0.accept(((WindowLayoutInfo)h0));
                    }
                }
                else {
                    extensionInterfaceCompat0.onWindowLayoutChangeListenerAdded(activity0);
                }
            }
            finally {
                reentrantLock0.unlock();
            }
            h0 = H.a;
        }
        if(h0 == null) {
            a0.accept(new WindowLayoutInfo(w0));
        }
    }

    public final void setWindowExtension(@Nullable ExtensionInterfaceCompat extensionInterfaceCompat0) {
        this.windowExtension = extensionInterfaceCompat0;
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void unregisterLayoutChangeCallback(@NotNull a a0) {
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = SidecarWindowBackend.globalLock;
        __monitor_enter(reentrantLock0);
        try {
            if(this.windowExtension != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: this.windowLayoutChangeCallbacks) {
                    WindowLayoutChangeCallbackWrapper sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0 = (WindowLayoutChangeCallbackWrapper)object0;
                    if(sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0.getCallback() == a0) {
                        arrayList0.add(sidecarWindowBackend$WindowLayoutChangeCallbackWrapper0);
                    }
                }
                this.windowLayoutChangeCallbacks.removeAll(arrayList0);
                Iterator iterator1 = arrayList0.iterator();
                while(true) {
                    if(!iterator1.hasNext()) {
                        goto label_21;
                    }
                    Object object1 = iterator1.next();
                    this.callbackRemovedForActivity(((WindowLayoutChangeCallbackWrapper)object1).getActivity());
                }
            }
            goto label_23;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(reentrantLock0);
        throw throwable0;
    label_21:
        __monitor_exit(reentrantLock0);
        return;
    label_23:
        __monitor_exit(reentrantLock0);
    }
}

