package androidx.window.layout.adapter.sidecar;

import P1.f;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface.SidecarCallback;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 -2\u00020\u0001:\u0004-./0B\u001B\b\u0007\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\f\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u000FJ\u001D\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001D\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u000FJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0017\u00A2\u0006\u0004\b\u001F\u0010 R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0007\u00A2\u0006\f\n\u0004\b\u0003\u0010!\u001A\u0004\b\"\u0010#R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010$R \u0010&\u001A\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000B0%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010\'R&\u0010*\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010\'R\u0018\u0010\u0012\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0012\u0010,\u00A8\u00061"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarCompat;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat;", "Landroidx/window/sidecar/SidecarInterface;", "sidecar", "Landroidx/window/layout/adapter/sidecar/SidecarAdapter;", "sidecarAdapter", "<init>", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/adapter/sidecar/SidecarAdapter;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Landroid/app/Activity;", "activity", "Lie/H;", "registerConfigurationChangeListener", "(Landroid/app/Activity;)V", "unregisterComponentCallback", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "extensionCallback", "setExtensionCallback", "(Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "Landroidx/window/layout/WindowLayoutInfo;", "getWindowLayoutInfo", "(Landroid/app/Activity;)Landroidx/window/layout/WindowLayoutInfo;", "onWindowLayoutChangeListenerAdded", "Landroid/os/IBinder;", "windowToken", "register", "(Landroid/os/IBinder;Landroid/app/Activity;)V", "onWindowLayoutChangeListenerRemoved", "", "validateExtensionInterface", "()Z", "Landroidx/window/sidecar/SidecarInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "Landroidx/window/layout/adapter/sidecar/SidecarAdapter;", "", "windowListenerRegisteredContexts", "Ljava/util/Map;", "Lb2/a;", "Landroid/content/res/Configuration;", "componentCallbackMap", "Landroidx/window/layout/adapter/sidecar/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/adapter/sidecar/SidecarCompat$DistinctElementCallback;", "Companion", "DistinctElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SidecarCompat implements ExtensionInterfaceCompat {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\u0017\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarCompat$Companion;", "", "()V", "TAG", "", "sidecarVersion", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "getActivityWindowToken", "Landroid/os/IBinder;", "activity", "Landroid/app/Activity;", "getActivityWindowToken$window_release", "getSidecarCompat", "Landroidx/window/sidecar/SidecarInterface;", "context", "Landroid/content/Context;", "getSidecarCompat$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final IBinder getActivityWindowToken$window_release(@Nullable Activity activity0) {
            if(activity0 != null) {
                Window window0 = activity0.getWindow();
                if(window0 != null) {
                    WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                    return windowManager$LayoutParams0 == null ? null : windowManager$LayoutParams0.token;
                }
            }
            return null;
        }

        @Nullable
        public final SidecarInterface getSidecarCompat$window_release(@NotNull Context context0) {
            q.g(context0, "context");
            return SidecarProvider.getSidecarImpl(context0.getApplicationContext());
        }

        @Nullable
        public final Version getSidecarVersion() {
            try {
                String s = SidecarProvider.getApiVersion();
                return TextUtils.isEmpty(s) ? null : Version.Companion.parse(s);
            }
            catch(NoClassDefFoundError | UnsupportedOperationException unused_ex) {
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\f\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "<init>", "(Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "newLayout", "Lie/H;", "onWindowLayoutChanged", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V", "clearWindowLayoutInfo", "(Landroid/app/Activity;)V", "Landroidx/window/layout/adapter/sidecar/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/WeakHashMap;", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class DistinctElementCallback implements ExtensionCallbackInterface {
        @NotNull
        private final WeakHashMap activityWindowLayoutInfo;
        @NotNull
        private final ExtensionCallbackInterface callbackInterface;
        @NotNull
        private final ReentrantLock globalLock;

        public DistinctElementCallback(@NotNull ExtensionCallbackInterface extensionInterfaceCompat$ExtensionCallbackInterface0) {
            q.g(extensionInterfaceCompat$ExtensionCallbackInterface0, "callbackInterface");
            super();
            this.callbackInterface = extensionInterfaceCompat$ExtensionCallbackInterface0;
            this.globalLock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap();
        }

        public final void clearWindowLayoutInfo(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            this.globalLock.lock();
            try {
                this.activityWindowLayoutInfo.put(activity0, null);
            }
            finally {
                this.globalLock.unlock();
            }
        }

        @Override  // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat$ExtensionCallbackInterface
        public void onWindowLayoutChanged(@NotNull Activity activity0, @NotNull WindowLayoutInfo windowLayoutInfo0) {
            q.g(activity0, "activity");
            q.g(windowLayoutInfo0, "newLayout");
            ReentrantLock reentrantLock0 = this.globalLock;
            reentrantLock0.lock();
            try {
                if(windowLayoutInfo0.equals(((WindowLayoutInfo)this.activityWindowLayoutInfo.get(activity0)))) {
                    return;
                }
                WindowLayoutInfo windowLayoutInfo1 = (WindowLayoutInfo)this.activityWindowLayoutInfo.put(activity0, windowLayoutInfo0);
            }
            finally {
                reentrantLock0.unlock();
            }
            this.callbackInterface.onWindowLayoutChanged(activity0, windowLayoutInfo0);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000ER\"\u0010\u0011\u001A\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u00040\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/window/layout/adapter/sidecar/SidecarCompat;", "sidecarCompat", "Landroid/app/Activity;", "activity", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarCompat;Landroid/app/Activity;)V", "Landroid/view/View;", "view", "Lie/H;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "Landroidx/window/layout/adapter/sidecar/SidecarCompat;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        @NotNull
        private final WeakReference activityWeakReference;
        @NotNull
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(@NotNull SidecarCompat sidecarCompat0, @NotNull Activity activity0) {
            q.g(sidecarCompat0, "sidecarCompat");
            q.g(activity0, "activity");
            super();
            this.sidecarCompat = sidecarCompat0;
            this.activityWeakReference = new WeakReference(activity0);
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view0) {
            q.g(view0, "view");
            view0.removeOnAttachStateChangeListener(this);
            Activity activity0 = (Activity)this.activityWeakReference.get();
            IBinder iBinder0 = SidecarCompat.Companion.getActivityWindowToken$window_release(activity0);
            if(activity0 == null || iBinder0 == null) {
                return;
            }
            this.sidecarCompat.register(iBinder0, activity0);
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view0) {
            q.g(view0, "view");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "<init>", "(Landroidx/window/layout/adapter/sidecar/SidecarCompat;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "Lie/H;", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "windowToken", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public void onDeviceStateChanged(@NotNull SidecarDeviceState sidecarDeviceState0) {
            q.g(sidecarDeviceState0, "newDeviceState");
            Iterable iterable0 = SidecarCompat.this.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat0 = SidecarCompat.this;
            for(Object object0: iterable0) {
                Activity activity0 = (Activity)object0;
                IBinder iBinder0 = SidecarCompat.Companion.getActivityWindowToken$window_release(activity0);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo0 = null;
                if(iBinder0 != null) {
                    SidecarInterface sidecarInterface0 = sidecarCompat0.getSidecar();
                    if(sidecarInterface0 != null) {
                        sidecarWindowLayoutInfo0 = sidecarInterface0.getWindowLayoutInfo(iBinder0);
                    }
                }
                DistinctElementCallback sidecarCompat$DistinctElementCallback0 = sidecarCompat0.extensionCallback;
                if(sidecarCompat$DistinctElementCallback0 != null) {
                    sidecarCompat$DistinctElementCallback0.onWindowLayoutChanged(activity0, sidecarCompat0.sidecarAdapter.translate(sidecarWindowLayoutInfo0, sidecarDeviceState0));
                }
            }
        }

        public void onWindowLayoutChanged(@NotNull IBinder iBinder0, @NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo0) {
            SidecarDeviceState sidecarDeviceState0;
            q.g(iBinder0, "windowToken");
            q.g(sidecarWindowLayoutInfo0, "newLayout");
            Activity activity0 = (Activity)SidecarCompat.this.windowListenerRegisteredContexts.get(iBinder0);
            if(activity0 == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter0 = SidecarCompat.this.sidecarAdapter;
            SidecarInterface sidecarInterface0 = SidecarCompat.this.getSidecar();
            if(sidecarInterface0 == null) {
                sidecarDeviceState0 = new SidecarDeviceState();
            }
            else {
                sidecarDeviceState0 = sidecarInterface0.getDeviceState();
                if(sidecarDeviceState0 == null) {
                    sidecarDeviceState0 = new SidecarDeviceState();
                }
            }
            WindowLayoutInfo windowLayoutInfo0 = sidecarAdapter0.translate(sidecarWindowLayoutInfo0, sidecarDeviceState0);
            DistinctElementCallback sidecarCompat$DistinctElementCallback0 = SidecarCompat.this.extensionCallback;
            if(sidecarCompat$DistinctElementCallback0 != null) {
                sidecarCompat$DistinctElementCallback0.onWindowLayoutChanged(activity0, windowLayoutInfo0);
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SidecarCompat";
    @NotNull
    private final Map componentCallbackMap;
    @Nullable
    private DistinctElementCallback extensionCallback;
    @Nullable
    private final SidecarInterface sidecar;
    @NotNull
    private final SidecarAdapter sidecarAdapter;
    @NotNull
    private final Map windowListenerRegisteredContexts;

    static {
        SidecarCompat.Companion = new Companion(null);
    }

    public SidecarCompat(@NotNull Context context0) {
        q.g(context0, "context");
        this(SidecarCompat.Companion.getSidecarCompat$window_release(context0), new SidecarAdapter(null, 1, null));
    }

    public SidecarCompat(@Nullable SidecarInterface sidecarInterface0, @NotNull SidecarAdapter sidecarAdapter0) {
        q.g(sidecarAdapter0, "sidecarAdapter");
        super();
        this.sidecar = sidecarInterface0;
        this.sidecarAdapter = sidecarAdapter0;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    @Nullable
    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    @NotNull
    public final WindowLayoutInfo getWindowLayoutInfo(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        IBinder iBinder0 = SidecarCompat.Companion.getActivityWindowToken$window_release(activity0);
        if(iBinder0 == null) {
            return new WindowLayoutInfo(w.a);
        }
        SidecarWindowLayoutInfo sidecarWindowLayoutInfo0 = this.sidecar == null ? null : this.sidecar.getWindowLayoutInfo(iBinder0);
        SidecarAdapter sidecarAdapter0 = this.sidecarAdapter;
        SidecarInterface sidecarInterface0 = this.sidecar;
        if(sidecarInterface0 != null) {
            SidecarDeviceState sidecarDeviceState0 = sidecarInterface0.getDeviceState();
            return sidecarDeviceState0 == null ? sidecarAdapter0.translate(sidecarWindowLayoutInfo0, new SidecarDeviceState()) : sidecarAdapter0.translate(sidecarWindowLayoutInfo0, sidecarDeviceState0);
        }
        return sidecarAdapter0.translate(sidecarWindowLayoutInfo0, new SidecarDeviceState());
    }

    @Override  // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        IBinder iBinder0 = SidecarCompat.Companion.getActivityWindowToken$window_release(activity0);
        if(iBinder0 != null) {
            this.register(iBinder0, activity0);
            return;
        }
        FirstAttachAdapter sidecarCompat$FirstAttachAdapter0 = new FirstAttachAdapter(this, activity0);
        activity0.getWindow().getDecorView().addOnAttachStateChangeListener(sidecarCompat$FirstAttachAdapter0);
    }

    @Override  // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        IBinder iBinder0 = SidecarCompat.Companion.getActivityWindowToken$window_release(activity0);
        if(iBinder0 != null) {
            SidecarInterface sidecarInterface0 = this.sidecar;
            if(sidecarInterface0 != null) {
                sidecarInterface0.onWindowLayoutChangeListenerRemoved(iBinder0);
            }
            this.unregisterComponentCallback(activity0);
            DistinctElementCallback sidecarCompat$DistinctElementCallback0 = this.extensionCallback;
            if(sidecarCompat$DistinctElementCallback0 != null) {
                sidecarCompat$DistinctElementCallback0.clearWindowLayoutInfo(activity0);
            }
            this.windowListenerRegisteredContexts.remove(iBinder0);
            if(this.windowListenerRegisteredContexts.size() == 1) {
                SidecarInterface sidecarInterface1 = this.sidecar;
                if(sidecarInterface1 != null) {
                    sidecarInterface1.onDeviceStateListenersChanged(true);
                }
            }
        }
    }

    public final void register(@NotNull IBinder iBinder0, @NotNull Activity activity0) {
        q.g(iBinder0, "windowToken");
        q.g(activity0, "activity");
        this.windowListenerRegisteredContexts.put(iBinder0, activity0);
        SidecarInterface sidecarInterface0 = this.sidecar;
        if(sidecarInterface0 != null) {
            sidecarInterface0.onWindowLayoutChangeListenerAdded(iBinder0);
        }
        if(this.windowListenerRegisteredContexts.size() == 1) {
            SidecarInterface sidecarInterface1 = this.sidecar;
            if(sidecarInterface1 != null) {
                sidecarInterface1.onDeviceStateListenersChanged(false);
            }
        }
        DistinctElementCallback sidecarCompat$DistinctElementCallback0 = this.extensionCallback;
        if(sidecarCompat$DistinctElementCallback0 != null) {
            sidecarCompat$DistinctElementCallback0.onWindowLayoutChanged(activity0, this.getWindowLayoutInfo(activity0));
        }
        this.registerConfigurationChangeListener(activity0);
    }

    private final void registerConfigurationChangeListener(Activity activity0) {
        if(this.componentCallbackMap.get(activity0) == null && activity0 instanceof f) {
            a a0 = (Configuration configuration0) -> {
                DistinctElementCallback sidecarCompat$DistinctElementCallback0 = this.extensionCallback;
                if(sidecarCompat$DistinctElementCallback0 != null) {
                    sidecarCompat$DistinctElementCallback0.onWindowLayoutChanged(activity0, this.getWindowLayoutInfo(activity0));
                }
            };
            this.componentCallbackMap.put(activity0, a0);
            ((f)activity0).addOnConfigurationChangedListener(a0);
        }
    }

    // 检测为 Lambda 实现
    private static final void registerConfigurationChangeListener$lambda$0(SidecarCompat sidecarCompat0, Activity activity0, Configuration configuration0) [...]

    @Override  // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void setExtensionCallback(@NotNull ExtensionCallbackInterface extensionInterfaceCompat$ExtensionCallbackInterface0) {
        q.g(extensionInterfaceCompat$ExtensionCallbackInterface0, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionInterfaceCompat$ExtensionCallbackInterface0);
        SidecarInterface sidecarInterface0 = this.sidecar;
        if(sidecarInterface0 != null) {
            SidecarInterface.SidecarCallback sidecarInterface$SidecarCallback0 = new TranslatingCallback(this);
            sidecarInterface0.setSidecarCallback(new DistinctElementSidecarCallback(this.sidecarAdapter, sidecarInterface$SidecarCallback0));
        }
    }

    private final void unregisterComponentCallback(Activity activity0) {
        b2.a a0 = (b2.a)this.componentCallbackMap.get(activity0);
        if(a0 == null) {
            return;
        }
        if(activity0 instanceof f) {
            ((f)activity0).removeOnConfigurationChangedListener(a0);
        }
        this.componentCallbackMap.remove(activity0);
    }

    @Override  // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    @SuppressLint({"BanUncheckedReflection"})
    public boolean validateExtensionInterface() {
        Method method3;
        Method method2;
        Method method1;
        Method method0;
        try {
            SidecarInterface sidecarInterface0 = this.sidecar;
            if(sidecarInterface0 == null) {
                method0 = null;
            }
            else {
                Class class0 = sidecarInterface0.getClass();
                method0 = class0 == null ? null : class0.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            }
            Class class1 = method0 == null ? null : method0.getReturnType();
            Class class2 = Void.TYPE;
            if(q.b(class1, class2)) {
                SidecarInterface sidecarInterface1 = this.sidecar;
                if(sidecarInterface1 != null) {
                    sidecarInterface1.getDeviceState();
                }
                SidecarInterface sidecarInterface2 = this.sidecar;
                if(sidecarInterface2 != null) {
                    sidecarInterface2.onDeviceStateListenersChanged(true);
                }
                SidecarInterface sidecarInterface3 = this.sidecar;
                Class class3 = IBinder.class;
                if(sidecarInterface3 == null) {
                    method1 = null;
                }
                else {
                    Class class4 = sidecarInterface3.getClass();
                    method1 = class4 == null ? null : class4.getMethod("getWindowLayoutInfo", class3);
                }
                if(q.b((method1 == null ? null : method1.getReturnType()), SidecarWindowLayoutInfo.class)) {
                    SidecarInterface sidecarInterface4 = this.sidecar;
                    if(sidecarInterface4 == null) {
                        method2 = null;
                    }
                    else {
                        Class class5 = sidecarInterface4.getClass();
                        method2 = class5 == null ? null : class5.getMethod("onWindowLayoutChangeListenerAdded", class3);
                    }
                    if(q.b((method2 == null ? null : method2.getReturnType()), class2)) {
                        SidecarInterface sidecarInterface5 = this.sidecar;
                        if(sidecarInterface5 == null) {
                            method3 = null;
                        }
                        else {
                            Class class6 = sidecarInterface5.getClass();
                            method3 = class6 == null ? null : class6.getMethod("onWindowLayoutChangeListenerRemoved", class3);
                        }
                        if(q.b((method3 == null ? null : method3.getReturnType()), class2)) {
                            new SidecarDeviceState().posture = 3;
                            SidecarDisplayFeature sidecarDisplayFeature0 = new SidecarDisplayFeature();
                            Rect rect0 = sidecarDisplayFeature0.getRect();
                            q.f(rect0, "getRect(...)");
                            sidecarDisplayFeature0.setRect(rect0);
                            sidecarDisplayFeature0.getType();
                            sidecarDisplayFeature0.setType(1);
                            new SidecarWindowLayoutInfo();
                            return true;
                        }
                    }
                }
            }
        }
        catch(Throwable unused_ex) {
        }
        return false;
    }
}

