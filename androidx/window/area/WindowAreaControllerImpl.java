package androidx.window.area;

import A3.l;
import android.app.Activity;
import android.os.Binder;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.area.adapter.WindowAreaAdapter;
import androidx.window.core.BuildConfig;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.ExtensionsUtil;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.reflection.Consumer2;
import ie.H;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Executor;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.n;

@RequiresWindowSdkExtension(version = 3)
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0001\u0018\u0000 A2\u00020\u0001:\u0003ABCB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010!\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b!\u0010\"J\'\u0010%\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010$\u001A\u00020#H\u0002\u00A2\u0006\u0004\b%\u0010&J/\u0010)\u001A\u00020\b2\u0006\u0010(\u001A\u00020\'2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b)\u0010*J/\u0010+\u001A\u00020\b2\u0006\u0010(\u001A\u00020\'2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010-R\u001C\u0010/\u001A\b\u0012\u0004\u0012\u00020\u00060.8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00105R0\u0010:\u001A\u001E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u001607j\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0016`98\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R \u0010@\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160=0<8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b>\u0010?\u00A8\u0006D"}, d2 = {"Landroidx/window/area/WindowAreaControllerImpl;", "Landroidx/window/area/WindowAreaController;", "Landroidx/window/extensions/area/WindowAreaComponent;", "windowAreaComponent", "<init>", "(Landroidx/window/extensions/area/WindowAreaComponent;)V", "", "status", "Lie/H;", "updateRearDisplayAvailability", "(I)V", "Landroidx/window/extensions/area/ExtensionWindowAreaStatus;", "extensionWindowAreaStatus", "updateRearDisplayPresentationAvailability", "(Landroidx/window/extensions/area/ExtensionWindowAreaStatus;)V", "Landroidx/window/area/WindowAreaCapability$Operation;", "operation", "Landroidx/window/area/WindowAreaCapability$Status;", "Landroidx/window/layout/WindowMetrics;", "metrics", "updateRearDisplayWindowArea", "(Landroidx/window/area/WindowAreaCapability$Operation;Landroidx/window/area/WindowAreaCapability$Status;Landroidx/window/layout/WindowMetrics;)V", "Landroidx/window/area/WindowAreaInfo;", "windowAreaInfo", "", "shouldRemoveWindowAreaInfo", "(Landroidx/window/area/WindowAreaInfo;)Z", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/window/area/WindowAreaSessionCallback;", "windowAreaSessionCallback", "startRearDisplayMode", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;)V", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "windowAreaPresentationSessionCallback", "startRearDisplayPresentationMode", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;)V", "Landroid/os/Binder;", "token", "transferActivityToWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;)V", "presentContentOnWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;)V", "Landroidx/window/extensions/area/WindowAreaComponent;", "Landroidx/window/reflection/Consumer2;", "rearDisplaySessionConsumer", "Landroidx/window/reflection/Consumer2;", "currentRearDisplayModeStatus", "Landroidx/window/area/WindowAreaCapability$Status;", "currentRearDisplayPresentationStatus", "activeWindowAreaSession", "Z", "presentationSessionActive", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "currentWindowAreaInfoMap", "Ljava/util/HashMap;", "Lkotlinx/coroutines/flow/Flow;", "", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "windowAreaInfos", "Companion", "RearDisplayPresentationSessionConsumer", "RearDisplaySessionConsumer", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowAreaControllerImpl extends WindowAreaController {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/window/area/WindowAreaControllerImpl$Companion;", "", "()V", "REAR_DISPLAY_BINDER_DESCRIPTOR", "", "TAG", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000FR\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0016\u0010\u0012\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/window/area/WindowAreaControllerImpl$RearDisplayPresentationSessionConsumer;", "Landroidx/window/reflection/Consumer2;", "", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "windowAreaPresentationSessionCallback", "Landroidx/window/extensions/area/WindowAreaComponent;", "windowAreaComponent", "<init>", "(Landroidx/window/area/WindowAreaControllerImpl;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;Landroidx/window/extensions/area/WindowAreaComponent;)V", "value", "Lie/H;", "accept", "(I)V", "Ljava/util/concurrent/Executor;", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "Landroidx/window/extensions/area/WindowAreaComponent;", "lastReportedSessionStatus", "I", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public final class RearDisplayPresentationSessionConsumer implements Consumer2 {
        @NotNull
        private final Executor executor;
        private int lastReportedSessionStatus;
        @NotNull
        private final WindowAreaComponent windowAreaComponent;
        @NotNull
        private final WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback;

        public RearDisplayPresentationSessionConsumer(@NotNull Executor executor0, @NotNull WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback0, @NotNull WindowAreaComponent windowAreaComponent0) {
            q.g(executor0, "executor");
            q.g(windowAreaPresentationSessionCallback0, "windowAreaPresentationSessionCallback");
            q.g(windowAreaComponent0, "windowAreaComponent");
            WindowAreaControllerImpl.this = windowAreaControllerImpl0;
            super();
            this.executor = executor0;
            this.windowAreaPresentationSessionCallback = windowAreaPresentationSessionCallback0;
            this.windowAreaComponent = windowAreaComponent0;
        }

        // 检测为 Lambda 实现
        public static void a(int v, int v1, RearDisplayPresentationSessionConsumer windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0, WindowAreaControllerImpl windowAreaControllerImpl0) [...]

        public void accept(int v) {
            int v1 = this.lastReportedSessionStatus;
            this.lastReportedSessionStatus = v;
            a a0 = () -> RearDisplayPresentationSessionConsumer.accept$lambda$0(v, v1, this, WindowAreaControllerImpl.this);
            this.executor.execute(a0);
        }

        @Override  // androidx.window.reflection.Consumer2
        public void accept(Object object0) {
            this.accept(((Number)object0).intValue());
        }

        private static final void accept$lambda$0(int v, int v1, RearDisplayPresentationSessionConsumer windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0, WindowAreaControllerImpl windowAreaControllerImpl0) {
            if(v != 0) {
                switch(v) {
                    case 1: {
                        if(v1 == 2) {
                            windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0.windowAreaPresentationSessionCallback.onContainerVisibilityChanged(false);
                            return;
                        }
                        ExtensionWindowAreaPresentation extensionWindowAreaPresentation0 = windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0.windowAreaComponent.getRearDisplayPresentation();
                        q.d(extensionWindowAreaPresentation0);
                        int v2 = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
                        RearDisplayPresentationSessionPresenterImpl rearDisplayPresentationSessionPresenterImpl0 = new RearDisplayPresentationSessionPresenterImpl(windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0.windowAreaComponent, extensionWindowAreaPresentation0, v2);
                        windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0.windowAreaPresentationSessionCallback.onSessionStarted(rearDisplayPresentationSessionPresenterImpl0);
                        return;
                    }
                    case 2: {
                        windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0.windowAreaPresentationSessionCallback.onContainerVisibilityChanged(true);
                        return;
                    }
                    default: {
                        Log.e(WindowAreaControllerImpl.TAG, "Invalid session state value received: " + v);
                        return;
                    }
                }
            }
            windowAreaControllerImpl0.presentationSessionActive = false;
            windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0.windowAreaPresentationSessionCallback.onSessionEnded(null);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/window/area/WindowAreaControllerImpl$RearDisplaySessionConsumer;", "Landroidx/window/reflection/Consumer2;", "", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/window/area/WindowAreaSessionCallback;", "appCallback", "Landroidx/window/extensions/area/WindowAreaComponent;", "extensionsComponent", "<init>", "(Landroidx/window/area/WindowAreaControllerImpl;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;Landroidx/window/extensions/area/WindowAreaComponent;)V", "Lie/H;", "onSessionStarted", "()V", "onSessionFinished", "value", "accept", "(I)V", "Ljava/util/concurrent/Executor;", "Landroidx/window/area/WindowAreaSessionCallback;", "Landroidx/window/extensions/area/WindowAreaComponent;", "Landroidx/window/area/WindowAreaSession;", "session", "Landroidx/window/area/WindowAreaSession;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public final class RearDisplaySessionConsumer implements Consumer2 {
        @NotNull
        private final WindowAreaSessionCallback appCallback;
        @NotNull
        private final Executor executor;
        @NotNull
        private final WindowAreaComponent extensionsComponent;
        @Nullable
        private WindowAreaSession session;

        public RearDisplaySessionConsumer(@NotNull Executor executor0, @NotNull WindowAreaSessionCallback windowAreaSessionCallback0, @NotNull WindowAreaComponent windowAreaComponent0) {
            q.g(executor0, "executor");
            q.g(windowAreaSessionCallback0, "appCallback");
            q.g(windowAreaComponent0, "extensionsComponent");
            WindowAreaControllerImpl.this = windowAreaControllerImpl0;
            super();
            this.executor = executor0;
            this.appCallback = windowAreaSessionCallback0;
            this.extensionsComponent = windowAreaComponent0;
        }

        // 检测为 Lambda 实现
        public static void a(RearDisplaySessionConsumer windowAreaControllerImpl$RearDisplaySessionConsumer0, RearDisplaySessionImpl rearDisplaySessionImpl0) [...]

        public void accept(int v) {
            switch(v) {
                case 0: {
                    this.onSessionFinished();
                    return;
                }
                case 1: {
                    this.onSessionStarted();
                    return;
                }
                default: {
                    if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.STRICT) {
                        e.f(v, "Received an unknown session status value: ", WindowAreaControllerImpl.TAG);
                    }
                    this.onSessionFinished();
                }
            }
        }

        @Override  // androidx.window.reflection.Consumer2
        public void accept(Object object0) {
            this.accept(((Number)object0).intValue());
        }

        private final void onSessionFinished() {
            WindowAreaControllerImpl.this.activeWindowAreaSession = false;
            this.session = null;
            l l0 = new l(this, 24);
            this.executor.execute(l0);
        }

        private static final void onSessionFinished$lambda$2(RearDisplaySessionConsumer windowAreaControllerImpl$RearDisplaySessionConsumer0) {
            windowAreaControllerImpl$RearDisplaySessionConsumer0.appCallback.onSessionEnded(null);
        }

        private final void onSessionStarted() {
            RearDisplaySessionImpl rearDisplaySessionImpl0 = new RearDisplaySessionImpl(this.extensionsComponent);
            this.session = rearDisplaySessionImpl0;
            b b0 = () -> RearDisplaySessionConsumer.onSessionStarted$lambda$1$lambda$0(this, rearDisplaySessionImpl0);
            this.executor.execute(b0);
        }

        private static final void onSessionStarted$lambda$1$lambda$0(RearDisplaySessionConsumer windowAreaControllerImpl$RearDisplaySessionConsumer0, WindowAreaSession windowAreaSession0) {
            windowAreaControllerImpl$RearDisplaySessionConsumer0.appCallback.onSessionStarted(windowAreaSession0);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String REAR_DISPLAY_BINDER_DESCRIPTOR = "WINDOW_AREA_REAR_DISPLAY";
    @Nullable
    private static final String TAG;
    private boolean activeWindowAreaSession;
    @NotNull
    private Status currentRearDisplayModeStatus;
    @NotNull
    private Status currentRearDisplayPresentationStatus;
    @NotNull
    private final HashMap currentWindowAreaInfoMap;
    private boolean presentationSessionActive;
    private Consumer2 rearDisplaySessionConsumer;
    @NotNull
    private final WindowAreaComponent windowAreaComponent;

    static {
        WindowAreaControllerImpl.Companion = new Companion(null);
        WindowAreaControllerImpl.TAG = I.a.b(WindowAreaControllerImpl.class).m();
    }

    public WindowAreaControllerImpl(@NotNull WindowAreaComponent windowAreaComponent0) {
        q.g(windowAreaComponent0, "windowAreaComponent");
        super();
        this.windowAreaComponent = windowAreaComponent0;
        this.currentRearDisplayModeStatus = Status.Companion.getWINDOW_AREA_STATUS_UNKNOWN$window_release();
        this.currentRearDisplayPresentationStatus = Status.Companion.getWINDOW_AREA_STATUS_UNKNOWN$window_release();
        this.currentWindowAreaInfoMap = new HashMap();
    }

    @Override  // androidx.window.area.WindowAreaController
    @NotNull
    public Flow getWindowAreaInfos() {
        return FlowKt.callbackFlow(new n(null) {
            private Object L$0;
            int label;

            {
                WindowAreaControllerImpl.this = windowAreaControllerImpl0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new androidx.window.area.WindowAreaControllerImpl.windowAreaInfos.1(WindowAreaControllerImpl.this, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((androidx.window.area.WindowAreaControllerImpl.windowAreaInfos.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ProducerScope producerScope0 = (ProducerScope)this.L$0;
                        c c0 = new c(WindowAreaControllerImpl.this, producerScope0);
                        d d0 = new d(WindowAreaControllerImpl.this, producerScope0);
                        WindowAreaControllerImpl.this.windowAreaComponent.addRearDisplayStatusListener(c0);
                        WindowAreaControllerImpl.this.windowAreaComponent.addRearDisplayPresentationStatusListener(d0);
                        androidx.window.area.WindowAreaControllerImpl.windowAreaInfos.1.1 windowAreaControllerImpl$windowAreaInfos$1$10 = new we.a(c0, d0) {
                            final Consumer2 $rearDisplayListener;
                            final Consumer2 $rearDisplayPresentationListener;

                            {
                                WindowAreaControllerImpl.this = windowAreaControllerImpl0;
                                this.$rearDisplayListener = consumer20;
                                this.$rearDisplayPresentationListener = consumer21;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                WindowAreaControllerImpl.this.windowAreaComponent.removeRearDisplayStatusListener(this.$rearDisplayListener);
                                WindowAreaControllerImpl.this.windowAreaComponent.removeRearDisplayPresentationStatusListener(this.$rearDisplayPresentationListener);
                            }
                        };
                        this.label = 1;
                        return ProduceKt.awaitClose(producerScope0, windowAreaControllerImpl$windowAreaInfos$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }

            private static final void invokeSuspend$lambda$0(WindowAreaControllerImpl windowAreaControllerImpl0, ProducerScope producerScope0, int v) {
                windowAreaControllerImpl0.updateRearDisplayAvailability(v);
                SendChannel sendChannel0 = producerScope0.getChannel();
                Collection collection0 = windowAreaControllerImpl0.currentWindowAreaInfoMap.values();
                q.f(collection0, "<get-values>(...)");
                sendChannel0.trySend-JP2dKIU(p.P0(collection0));
            }

            private static final void invokeSuspend$lambda$1(WindowAreaControllerImpl windowAreaControllerImpl0, ProducerScope producerScope0, ExtensionWindowAreaStatus extensionWindowAreaStatus0) {
                windowAreaControllerImpl0.updateRearDisplayPresentationAvailability(extensionWindowAreaStatus0);
                SendChannel sendChannel0 = producerScope0.getChannel();
                Collection collection0 = windowAreaControllerImpl0.currentWindowAreaInfoMap.values();
                q.f(collection0, "<get-values>(...)");
                sendChannel0.trySend-JP2dKIU(p.P0(collection0));
            }
        });
    }

    @Override  // androidx.window.area.WindowAreaController
    public void presentContentOnWindowArea(@NotNull Binder binder0, @NotNull Activity activity0, @NotNull Executor executor0, @NotNull WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback0) {
        q.g(binder0, "token");
        q.g(activity0, "activity");
        q.g(executor0, "executor");
        q.g(windowAreaPresentationSessionCallback0, "windowAreaPresentationSessionCallback");
        if(!q.b(binder0.getInterfaceDescriptor(), "WINDOW_AREA_REAR_DISPLAY")) {
            executor0.execute(new l(windowAreaPresentationSessionCallback0, 22));
            return;
        }
        if(q.b(this.currentRearDisplayPresentationStatus, Status.Companion.getWINDOW_AREA_STATUS_UNKNOWN$window_release())) {
            Log.d(WindowAreaControllerImpl.TAG, "Force updating currentRearDisplayPresentationStatus");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executor0)), null, null, new n(activity0, executor0, windowAreaPresentationSessionCallback0, null) {
                final Activity $activity;
                final Executor $executor;
                final WindowAreaPresentationSessionCallback $windowAreaPresentationSessionCallback;
                int label;

                {
                    WindowAreaControllerImpl.this = windowAreaControllerImpl0;
                    this.$activity = activity0;
                    this.$executor = executor0;
                    this.$windowAreaPresentationSessionCallback = windowAreaPresentationSessionCallback0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new androidx.window.area.WindowAreaControllerImpl.presentContentOnWindowArea.2(WindowAreaControllerImpl.this, this.$activity, this.$executor, this.$windowAreaPresentationSessionCallback, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((androidx.window.area.WindowAreaControllerImpl.presentContentOnWindowArea.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = WindowAreaControllerImpl.this.getWindowAreaInfos();
                            this.label = 1;
                            if(FlowKt.first(flow0, this) == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            d5.n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    WindowAreaControllerImpl.this.startRearDisplayPresentationMode(this.$activity, this.$executor, this.$windowAreaPresentationSessionCallback);
                    return H.a;
                }
            }, 3, null);
            return;
        }
        this.startRearDisplayPresentationMode(activity0, executor0, windowAreaPresentationSessionCallback0);
    }

    private static final void presentContentOnWindowArea$lambda$2(WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback0) {
        windowAreaPresentationSessionCallback0.onSessionEnded(new IllegalArgumentException("Invalid WindowAreaInfo token"));
    }

    private final boolean shouldRemoveWindowAreaInfo(WindowAreaInfo windowAreaInfo0) {
        for(Object object0: windowAreaInfo0.getCapabilityMap$window_release().values()) {
            q.f(object0, "next(...)");
            if(!q.b(((WindowAreaCapability)object0).getStatus(), Status.WINDOW_AREA_STATUS_UNSUPPORTED)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    private final void startRearDisplayMode(Activity activity0, Executor executor0, WindowAreaSessionCallback windowAreaSessionCallback0) {
        if(q.b(this.currentRearDisplayModeStatus, Status.WINDOW_AREA_STATUS_ACTIVE)) {
            windowAreaSessionCallback0.onSessionEnded(new IllegalStateException("The WindowArea feature is currently active, WindowAreaInfo#getActiveSessioncan be used to get an instance of the current active session"));
            return;
        }
        if(!q.b(this.currentRearDisplayModeStatus, Status.WINDOW_AREA_STATUS_AVAILABLE)) {
            windowAreaSessionCallback0.onSessionEnded(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
            return;
        }
        this.activeWindowAreaSession = true;
        RearDisplaySessionConsumer windowAreaControllerImpl$RearDisplaySessionConsumer0 = new RearDisplaySessionConsumer(this, executor0, windowAreaSessionCallback0, this.windowAreaComponent);
        this.rearDisplaySessionConsumer = windowAreaControllerImpl$RearDisplaySessionConsumer0;
        this.windowAreaComponent.startRearDisplaySession(activity0, windowAreaControllerImpl$RearDisplaySessionConsumer0);
    }

    private final void startRearDisplayPresentationMode(Activity activity0, Executor executor0, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback0) {
        if(!q.b(this.currentRearDisplayPresentationStatus, Status.WINDOW_AREA_STATUS_AVAILABLE)) {
            windowAreaPresentationSessionCallback0.onSessionEnded(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
            return;
        }
        this.presentationSessionActive = true;
        RearDisplayPresentationSessionConsumer windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0 = new RearDisplayPresentationSessionConsumer(this, executor0, windowAreaPresentationSessionCallback0, this.windowAreaComponent);
        this.windowAreaComponent.startRearDisplayPresentationSession(activity0, windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0);
    }

    @Override  // androidx.window.area.WindowAreaController
    public void transferActivityToWindowArea(@NotNull Binder binder0, @NotNull Activity activity0, @NotNull Executor executor0, @NotNull WindowAreaSessionCallback windowAreaSessionCallback0) {
        q.g(binder0, "token");
        q.g(activity0, "activity");
        q.g(executor0, "executor");
        q.g(windowAreaSessionCallback0, "windowAreaSessionCallback");
        if(!q.b(binder0.getInterfaceDescriptor(), "WINDOW_AREA_REAR_DISPLAY")) {
            executor0.execute(new l(windowAreaSessionCallback0, 23));
            return;
        }
        if(q.b(this.currentRearDisplayModeStatus, Status.Companion.getWINDOW_AREA_STATUS_UNKNOWN$window_release())) {
            Log.d(WindowAreaControllerImpl.TAG, "Force updating currentRearDisplayModeStatus");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executor0)), null, null, new n(activity0, executor0, windowAreaSessionCallback0, null) {
                final Activity $activity;
                final Executor $executor;
                final WindowAreaSessionCallback $windowAreaSessionCallback;
                int label;

                {
                    WindowAreaControllerImpl.this = windowAreaControllerImpl0;
                    this.$activity = activity0;
                    this.$executor = executor0;
                    this.$windowAreaSessionCallback = windowAreaSessionCallback0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new androidx.window.area.WindowAreaControllerImpl.transferActivityToWindowArea.2(WindowAreaControllerImpl.this, this.$activity, this.$executor, this.$windowAreaSessionCallback, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((androidx.window.area.WindowAreaControllerImpl.transferActivityToWindowArea.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = WindowAreaControllerImpl.this.getWindowAreaInfos();
                            this.label = 1;
                            if(FlowKt.first(flow0, this) == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            d5.n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    WindowAreaControllerImpl.this.startRearDisplayMode(this.$activity, this.$executor, this.$windowAreaSessionCallback);
                    return H.a;
                }
            }, 3, null);
            return;
        }
        this.startRearDisplayMode(activity0, executor0, windowAreaSessionCallback0);
    }

    private static final void transferActivityToWindowArea$lambda$1(WindowAreaSessionCallback windowAreaSessionCallback0) {
        windowAreaSessionCallback0.onSessionEnded(new IllegalArgumentException("Invalid WindowAreaInfo token"));
    }

    private final void updateRearDisplayAvailability(int v) {
        DisplayMetrics displayMetrics0 = this.windowAreaComponent.getRearDisplayMetrics();
        q.f(displayMetrics0, "getRearDisplayMetrics(...)");
        WindowMetrics windowMetrics0 = WindowMetricsCalculator.Companion.fromDisplayMetrics$window_release(displayMetrics0);
        Status windowAreaCapability$Status0 = WindowAreaAdapter.translate$window_release$default(WindowAreaAdapter.INSTANCE, v, this.activeWindowAreaSession, 0, 4, null);
        this.currentRearDisplayModeStatus = windowAreaCapability$Status0;
        this.updateRearDisplayWindowArea(Operation.OPERATION_TRANSFER_ACTIVITY_TO_AREA, windowAreaCapability$Status0, windowMetrics0);
    }

    private final void updateRearDisplayPresentationAvailability(ExtensionWindowAreaStatus extensionWindowAreaStatus0) {
        int v = extensionWindowAreaStatus0.getWindowAreaStatus();
        this.currentRearDisplayPresentationStatus = WindowAreaAdapter.translate$window_release$default(WindowAreaAdapter.INSTANCE, v, this.presentationSessionActive, 0, 4, null);
        DisplayMetrics displayMetrics0 = extensionWindowAreaStatus0.getWindowAreaDisplayMetrics();
        q.f(displayMetrics0, "getWindowAreaDisplayMetrics(...)");
        WindowMetrics windowMetrics0 = WindowMetricsCalculator.Companion.fromDisplayMetrics$window_release(displayMetrics0);
        this.updateRearDisplayWindowArea(Operation.OPERATION_PRESENT_ON_AREA, this.currentRearDisplayPresentationStatus, windowMetrics0);
    }

    private final void updateRearDisplayWindowArea(Operation windowAreaCapability$Operation0, Status windowAreaCapability$Status0, WindowMetrics windowMetrics0) {
        WindowAreaInfo windowAreaInfo0 = (WindowAreaInfo)this.currentWindowAreaInfoMap.get("WINDOW_AREA_REAR_DISPLAY");
        if(q.b(windowAreaCapability$Status0, Status.WINDOW_AREA_STATUS_UNSUPPORTED)) {
            if(windowAreaInfo0 != null) {
                if(this.shouldRemoveWindowAreaInfo(windowAreaInfo0)) {
                    this.currentWindowAreaInfoMap.remove("WINDOW_AREA_REAR_DISPLAY");
                    return;
                }
                windowAreaInfo0.getCapabilityMap$window_release().put(windowAreaCapability$Operation0, new WindowAreaCapability(windowAreaCapability$Operation0, windowAreaCapability$Status0));
            }
            return;
        }
        if(windowAreaInfo0 == null) {
            Binder binder0 = Qc.l.g();
            windowAreaInfo0 = new WindowAreaInfo(windowMetrics0, Type.TYPE_REAR_FACING, binder0, this.windowAreaComponent);
        }
        windowAreaInfo0.getCapabilityMap$window_release().put(windowAreaCapability$Operation0, new WindowAreaCapability(windowAreaCapability$Operation0, windowAreaCapability$Status0));
        windowAreaInfo0.setMetrics(windowMetrics0);
        this.currentWindowAreaInfoMap.put("WINDOW_AREA_REAR_DISPLAY", windowAreaInfo0);
    }
}

