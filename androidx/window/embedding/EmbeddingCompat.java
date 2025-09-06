package androidx.window.embedding;

import De.d;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.BuildConfig;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityStack.Token;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.extensions.embedding.SplitInfo.Token;
import androidx.window.extensions.embedding.SplitInfo;
import b2.a;
import ie.H;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u00D2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 l2\u00020\u0001:\u0001lB;\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001A\u00020\u0012*\u00020\u0002H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001D\u0010\u001C\u001A\u00020\u00122\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0014J\u0017\u0010\"\u001A\u00020!2\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010(\u001A\u00020!2\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&H\u0017\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001A\u00020\u00122\u0006\u0010%\u001A\u00020$H\u0017\u00A2\u0006\u0004\b*\u0010+J#\u00100\u001A\u00020\u00122\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0017\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\u0012H\u0017\u00A2\u0006\u0004\b2\u0010\u0016J\u001D\u00105\u001A\u00020\u00122\f\u00104\u001A\b\u0012\u0004\u0012\u0002030\u0019H\u0017\u00A2\u0006\u0004\b5\u0010\u001DJ\u0017\u00108\u001A\u00020\u00122\u0006\u00107\u001A\u000206H\u0017\u00A2\u0006\u0004\b8\u00109J\u000F\u0010\u0017\u001A\u00020\u0012H\u0017\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u001F\u0010=\u001A\u00020\u00122\u0006\u0010;\u001A\u00020:2\u0006\u0010<\u001A\u00020.H\u0017\u00A2\u0006\u0004\b=\u0010>J\u001F\u0010B\u001A\u00020?2\u0006\u0010@\u001A\u00020?2\u0006\u0010A\u001A\u000203H\u0017\u00A2\u0006\u0004\bB\u0010CJ\u001F\u0010F\u001A\u00020?2\u0006\u0010@\u001A\u00020?2\u0006\u0010E\u001A\u00020DH\u0017\u00A2\u0006\u0004\bF\u0010GJ#\u0010J\u001A\u00020\u00122\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0,H\u0017\u00A2\u0006\u0004\bJ\u00101J\u000F\u0010K\u001A\u00020\u0012H\u0017\u00A2\u0006\u0004\bK\u0010\u0016J\u001F\u0010O\u001A\u00020\u00122\u0006\u0010M\u001A\u00020L2\u0006\u0010N\u001A\u00020IH\u0017\u00A2\u0006\u0004\bO\u0010PJ-\u0010V\u001A\u00020\u00122\u0006\u0010M\u001A\u00020L2\u0006\u0010R\u001A\u00020Q2\f\u0010U\u001A\b\u0012\u0004\u0012\u00020T0SH\u0017\u00A2\u0006\u0004\bV\u0010WJ\u001D\u0010X\u001A\u00020\u00122\f\u0010U\u001A\b\u0012\u0004\u0012\u00020T0SH\u0017\u00A2\u0006\u0004\bX\u0010YJ%\u0010\\\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u001F2\f\u0010[\u001A\b\u0012\u0004\u0012\u00020Z0SH\u0017\u00A2\u0006\u0004\b\\\u0010]J\u001D\u0010^\u001A\u00020\u00122\f\u0010[\u001A\b\u0012\u0004\u0012\u00020Z0SH\u0017\u00A2\u0006\u0004\b^\u0010YR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010_R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010`R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010aR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010bR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0001X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u000B\u0010c\u001A\u0004\bd\u0010eR\u0016\u0010\r\u001A\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010fR\u0014\u0010h\u001A\u00020g8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bj\u0010k\u00A8\u0006m"}, d2 = {"Landroidx/window/embedding/EmbeddingCompat;", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "embeddingExtension", "Landroidx/window/embedding/EmbeddingAdapter;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "consumerAdapter", "Landroid/content/Context;", "applicationContext", "Landroidx/window/embedding/OverlayControllerImpl;", "overlayController", "Landroidx/window/embedding/ActivityWindowInfoCallbackController;", "activityWindowInfoCallbackController", "<init>", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/ConsumerAdapter;Landroid/content/Context;Landroidx/window/embedding/OverlayControllerImpl;Landroidx/window/embedding/ActivityWindowInfoCallbackController;)V", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "embeddingCallback", "Lie/H;", "registerSplitInfoCallback", "(Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;)V", "setDefaultSplitAttributeCalculatorIfNeeded", "()V", "invalidateVisibleActivityStacks", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;)V", "", "Landroidx/window/embedding/EmbeddingRule;", "rules", "setRules", "(Ljava/util/Set;)V", "setEmbeddingCallback", "Landroid/app/Activity;", "activity", "", "isActivityEmbedded", "(Landroid/app/Activity;)Z", "", "taskId", "Landroidx/window/embedding/SplitPinRule;", "splitPinRule", "pinTopActivityStack", "(ILandroidx/window/embedding/SplitPinRule;)Z", "unpinTopActivityStack", "(I)V", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "calculator", "setSplitAttributesCalculator", "(Lwe/k;)V", "clearSplitAttributesCalculator", "Landroidx/window/embedding/ActivityStack;", "activityStacks", "finishActivityStacks", "Landroidx/window/embedding/EmbeddingConfiguration;", "embeddingConfig", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "splitAttributes", "updateSplitAttributes", "(Landroidx/window/embedding/SplitInfo;Landroidx/window/embedding/SplitAttributes;)V", "Landroid/os/Bundle;", "options", "activityStack", "setLaunchingActivityStack", "(Landroid/os/Bundle;Landroidx/window/embedding/ActivityStack;)Landroid/os/Bundle;", "Landroidx/window/embedding/OverlayCreateParams;", "overlayCreateParams", "setOverlayCreateParams", "(Landroid/os/Bundle;Landroidx/window/embedding/OverlayCreateParams;)Landroid/os/Bundle;", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "setOverlayAttributesCalculator", "clearOverlayAttributesCalculator", "", "overlayTag", "overlayAttributes", "updateOverlayAttributes", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/embedding/OverlayInfo;", "overlayInfoCallback", "addOverlayInfoCallback", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Lb2/a;)V", "removeOverlayInfoCallback", "(Lb2/a;)V", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "callback", "addEmbeddedActivityWindowInfoCallbackForActivity", "(Landroid/app/Activity;Lb2/a;)V", "removeEmbeddedActivityWindowInfoCallbackForActivity", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "Landroidx/window/embedding/EmbeddingAdapter;", "Landroidx/window/core/ConsumerAdapter;", "Landroid/content/Context;", "Landroidx/window/embedding/OverlayControllerImpl;", "getOverlayController$window_release", "()Landroidx/window/embedding/OverlayControllerImpl;", "Landroidx/window/embedding/ActivityWindowInfoCallbackController;", "Landroidx/window/WindowSdkExtensions;", "windowSdkExtensions", "Landroidx/window/WindowSdkExtensions;", "isCustomSplitAttributeCalculatorSet", "Z", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddingCompat implements EmbeddingInterfaceCompat {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001A\u00020\bJ\b\u0010\t\u001A\u00020\bH\u0002J\u0006\u0010\n\u001A\u00020\u0004R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/EmbeddingCompat$Companion;", "", "()V", "DEBUG", "", "TAG", "", "embeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "emptyActivityEmbeddingProxy", "isEmbeddingAvailable", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ActivityEmbeddingComponent embeddingComponent() {
            if(this.isEmbeddingAvailable()) {
                ClassLoader classLoader0 = EmbeddingCompat.class.getClassLoader();
                if(classLoader0 != null) {
                    ConsumerAdapter consumerAdapter0 = new ConsumerAdapter(classLoader0);
                    WindowExtensions windowExtensions0 = WindowExtensionsProvider.getWindowExtensions();
                    q.f(windowExtensions0, "getWindowExtensions(...)");
                    ActivityEmbeddingComponent activityEmbeddingComponent0 = new SafeActivityEmbeddingComponentProvider(classLoader0, consumerAdapter0, windowExtensions0).getActivityEmbeddingComponent();
                    return activityEmbeddingComponent0 == null ? this.emptyActivityEmbeddingProxy() : activityEmbeddingComponent0;
                }
                return this.emptyActivityEmbeddingProxy();
            }
            return this.emptyActivityEmbeddingProxy();
        }

        private final ActivityEmbeddingComponent emptyActivityEmbeddingProxy() {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            Object object0 = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, j0);
            q.e(object0, "null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
            return (ActivityEmbeddingComponent)object0;
        }

        private static final H emptyActivityEmbeddingProxy$lambda$2(Object object0, Method method0, Object[] arr_object) {
            return H.a;
        }

        public final boolean isEmbeddingAvailable() {
            try {
                ClassLoader classLoader0 = EmbeddingCompat.class.getClassLoader();
                if(classLoader0 == null) {
                    return false;
                }
                ConsumerAdapter consumerAdapter0 = new ConsumerAdapter(classLoader0);
                WindowExtensions windowExtensions0 = WindowExtensionsProvider.getWindowExtensions();
                q.f(windowExtensions0, "getWindowExtensions(...)");
                return new SafeActivityEmbeddingComponentProvider(classLoader0, consumerAdapter0, windowExtensions0).getActivityEmbeddingComponent() == null ? false : true;
            }
            catch(NoClassDefFoundError unused_ex) {
                Log.d("EmbeddingCompat", "Embedding extension version not found");
                return false;
            }
            catch(UnsupportedOperationException unused_ex) {
                Log.d("EmbeddingCompat", "Stub Extension");
                return false;
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final boolean DEBUG = true;
    @NotNull
    private static final String TAG = "EmbeddingCompat";
    @Nullable
    private final ActivityWindowInfoCallbackController activityWindowInfoCallbackController;
    @NotNull
    private final EmbeddingAdapter adapter;
    @NotNull
    private final Context applicationContext;
    @NotNull
    private final ConsumerAdapter consumerAdapter;
    @NotNull
    private final ActivityEmbeddingComponent embeddingExtension;
    private boolean isCustomSplitAttributeCalculatorSet;
    @Nullable
    private final OverlayControllerImpl overlayController;
    @NotNull
    private final WindowSdkExtensions windowSdkExtensions;

    static {
        EmbeddingCompat.Companion = new Companion(null);
    }

    public EmbeddingCompat(@NotNull ActivityEmbeddingComponent activityEmbeddingComponent0, @NotNull EmbeddingAdapter embeddingAdapter0, @NotNull ConsumerAdapter consumerAdapter0, @NotNull Context context0, @Nullable OverlayControllerImpl overlayControllerImpl0, @Nullable ActivityWindowInfoCallbackController activityWindowInfoCallbackController0) {
        q.g(activityEmbeddingComponent0, "embeddingExtension");
        q.g(embeddingAdapter0, "adapter");
        q.g(consumerAdapter0, "consumerAdapter");
        q.g(context0, "applicationContext");
        super();
        this.embeddingExtension = activityEmbeddingComponent0;
        this.adapter = embeddingAdapter0;
        this.consumerAdapter = consumerAdapter0;
        this.applicationContext = context0;
        this.overlayController = overlayControllerImpl0;
        this.activityWindowInfoCallbackController = activityWindowInfoCallbackController0;
        this.windowSdkExtensions = WindowSdkExtensions.Companion.getInstance();
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 6)
    public void addEmbeddedActivityWindowInfoCallbackForActivity(@NotNull Activity activity0, @NotNull a a0) {
        q.g(activity0, "activity");
        q.g(a0, "callback");
        ActivityWindowInfoCallbackController activityWindowInfoCallbackController0 = this.activityWindowInfoCallbackController;
        if(activityWindowInfoCallbackController0 != null) {
            activityWindowInfoCallbackController0.addCallback(activity0, a0);
            return;
        }
        Log.w("EmbeddingCompat", "EmbeddedActivityWindowInfo is not supported on device less than version 6");
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 8)
    public void addOverlayInfoCallback(@NotNull String s, @NotNull Executor executor0, @NotNull a a0) {
        q.g(s, "overlayTag");
        q.g(executor0, "executor");
        q.g(a0, "overlayInfoCallback");
        OverlayControllerImpl overlayControllerImpl0 = this.overlayController;
        if(overlayControllerImpl0 != null) {
            overlayControllerImpl0.addOverlayInfoCallback(s, executor0, a0);
            return;
        }
        Log.w("EmbeddingCompat", "overlayInfo is not supported on device less than version 5");
        a0.accept(new OverlayInfo(s, null, null));
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 8)
    public void clearOverlayAttributesCalculator() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(8);
        q.d(this.overlayController);
        this.overlayController.setOverlayAttributesCalculator$window_release(null);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 2)
    public void clearSplitAttributesCalculator() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(2);
        this.embeddingExtension.clearSplitAttributesCalculator();
        this.isCustomSplitAttributeCalculatorSet = false;
        this.setDefaultSplitAttributeCalculatorIfNeeded();
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 5)
    public void finishActivityStacks(@NotNull Set set0) {
        q.g(set0, "activityStacks");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        ActivityEmbeddingComponent activityEmbeddingComponent0 = this.embeddingExtension;
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(Object object0: set0) {
            linkedHashSet0.add(((ActivityStack)object0).getToken$window_release());
        }
        activityEmbeddingComponent0.finishActivityStacksWithTokens(linkedHashSet0);
    }

    @Nullable
    public final OverlayControllerImpl getOverlayController$window_release() {
        return this.overlayController;
    }

    private final void invalidateVisibleActivityStacks(ActivityEmbeddingComponent activityEmbeddingComponent0) {
        activityEmbeddingComponent0.invalidateTopVisibleSplitAttributes();
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 3)
    public void invalidateVisibleActivityStacks() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(3);
        this.invalidateVisibleActivityStacks(this.embeddingExtension);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    public boolean isActivityEmbedded(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.embeddingExtension.isActivityEmbedded(activity0);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 5)
    public boolean pinTopActivityStack(int v, @NotNull SplitPinRule splitPinRule0) {
        q.g(splitPinRule0, "splitPinRule");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        androidx.window.extensions.embedding.SplitPinRule splitPinRule1 = this.adapter.translateSplitPinRule(this.applicationContext, splitPinRule0);
        return this.embeddingExtension.pinTopActivityStack(v, splitPinRule1);
    }

    private final void registerSplitInfoCallback(EmbeddingCallbackInterface embeddingInterfaceCompat$EmbeddingCallbackInterface0) {
        h h0 = new h(embeddingInterfaceCompat$EmbeddingCallbackInterface0, this);
        this.embeddingExtension.setSplitInfoCallback(h0);
    }

    private static final void registerSplitInfoCallback$lambda$0(EmbeddingCallbackInterface embeddingInterfaceCompat$EmbeddingCallbackInterface0, EmbeddingCompat embeddingCompat0, List list0) {
        q.g(list0, "splitInfoList");
        embeddingInterfaceCompat$EmbeddingCallbackInterface0.onSplitInfoChanged(embeddingCompat0.adapter.translate(list0));
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 6)
    public void removeEmbeddedActivityWindowInfoCallbackForActivity(@NotNull a a0) {
        q.g(a0, "callback");
        ActivityWindowInfoCallbackController activityWindowInfoCallbackController0 = this.activityWindowInfoCallbackController;
        if(activityWindowInfoCallbackController0 != null) {
            activityWindowInfoCallbackController0.removeCallback(a0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 8)
    public void removeOverlayInfoCallback(@NotNull a a0) {
        q.g(a0, "overlayInfoCallback");
        OverlayControllerImpl overlayControllerImpl0 = this.overlayController;
        if(overlayControllerImpl0 != null) {
            overlayControllerImpl0.removeOverlayInfoCallback(a0);
        }
    }

    private final void setDefaultSplitAttributeCalculatorIfNeeded() {
        if(this.windowSdkExtensions.getExtensionVersion() >= 5 && !this.isCustomSplitAttributeCalculatorSet && this.adapter.getEmbeddingConfiguration() != null) {
            i i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.embeddingExtension.setSplitAttributesCalculator(i0);
        }
    }

    private static final SplitAttributes setDefaultSplitAttributeCalculatorIfNeeded$lambda$2(EmbeddingCompat embeddingCompat0, SplitAttributesCalculatorParams splitAttributesCalculatorParams0) {
        if(splitAttributesCalculatorParams0.areDefaultConstraintsSatisfied()) {
            SplitAttributes splitAttributes0 = splitAttributesCalculatorParams0.getDefaultSplitAttributes();
            q.f(splitAttributes0, "getDefaultSplitAttributes(...)");
            androidx.window.embedding.SplitAttributes splitAttributes1 = embeddingCompat0.adapter.translate$window_release(splitAttributes0);
            return embeddingCompat0.adapter.translateSplitAttributes(splitAttributes1);
        }
        androidx.window.embedding.SplitAttributes splitAttributes2 = new Builder().setSplitType(SplitType.SPLIT_TYPE_EXPAND).build();
        return embeddingCompat0.adapter.translateSplitAttributes(splitAttributes2);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setEmbeddingCallback(@NotNull EmbeddingCallbackInterface embeddingInterfaceCompat$EmbeddingCallbackInterface0) {
        q.g(embeddingInterfaceCompat$EmbeddingCallbackInterface0, "embeddingCallback");
        int v = this.windowSdkExtensions.getExtensionVersion();
        if(v == 1) {
            d d0 = I.a.b(List.class);
            androidx.window.embedding.EmbeddingCompat.setEmbeddingCallback.1 embeddingCompat$setEmbeddingCallback$10 = new k(this) {
                final EmbeddingCallbackInterface $embeddingCallback;

                {
                    this.$embeddingCallback = embeddingInterfaceCompat$EmbeddingCallbackInterface0;
                    EmbeddingCompat.this = embeddingCompat0;
                    super(1);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((List)object0));
                    return H.a;
                }

                public final void invoke(List list0) {
                    q.g(list0, "values");
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object0: list0) {
                        if(object0 instanceof SplitInfo) {
                            arrayList0.add(object0);
                        }
                    }
                    List list1 = EmbeddingCompat.this.adapter.translate(arrayList0);
                    this.$embeddingCallback.onSplitInfoChanged(list1);
                }
            };
            this.consumerAdapter.addConsumer(this.embeddingExtension, d0, "setSplitInfoCallback", embeddingCompat$setEmbeddingCallback$10);
            return;
        }
        if(2 <= v && v < 5) {
            this.registerSplitInfoCallback(embeddingInterfaceCompat$EmbeddingCallbackInterface0);
            return;
        }
        if(5 <= v && v <= 0x7FFFFFFF) {
            this.registerSplitInfoCallback(embeddingInterfaceCompat$EmbeddingCallbackInterface0);
            l.a a0 = new l.a(1);
            ActivityStackConsumer activityStackConsumer0 = new ActivityStackConsumer(embeddingInterfaceCompat$EmbeddingCallbackInterface0, this.adapter);
            this.embeddingExtension.registerActivityStackCallback(a0, activityStackConsumer0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 5)
    public void setEmbeddingConfiguration(@NotNull EmbeddingConfiguration embeddingConfiguration0) {
        q.g(embeddingConfiguration0, "embeddingConfig");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        this.adapter.setEmbeddingConfiguration(embeddingConfiguration0);
        this.setDefaultSplitAttributeCalculatorIfNeeded();
        this.embeddingExtension.invalidateTopVisibleSplitAttributes();
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    public Bundle setLaunchingActivityStack(@NotNull Bundle bundle0, @NotNull ActivityStack activityStack0) {
        q.g(bundle0, "options");
        q.g(activityStack0, "activityStack");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        ActivityStack.Token activityStack$Token0 = activityStack0.getToken$window_release();
        ActivityEmbeddingOptionsImpl.INSTANCE.setActivityStackToken$window_release(bundle0, activityStack$Token0);
        return bundle0;
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 8)
    public void setOverlayAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        this.windowSdkExtensions.requireExtensionVersion$window_release(8);
        q.d(this.overlayController);
        this.overlayController.setOverlayAttributesCalculator$window_release(k0);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 8)
    @NotNull
    public Bundle setOverlayCreateParams(@NotNull Bundle bundle0, @NotNull OverlayCreateParams overlayCreateParams0) {
        q.g(bundle0, "options");
        q.g(overlayCreateParams0, "overlayCreateParams");
        ActivityEmbeddingOptionsImpl.INSTANCE.setOverlayCreateParams$window_release(bundle0, overlayCreateParams0);
        return bundle0;
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setRules(@NotNull Set set0) {
        q.g(set0, "rules");
        for(Object object0: set0) {
            if(((EmbeddingRule)object0) instanceof SplitRule) {
                if(q.b(SplitController.Companion.getInstance(this.applicationContext).getSplitSupportStatus(), SplitSupportStatus.SPLIT_AVAILABLE)) {
                    break;
                }
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.w("EmbeddingCompat", "Cannot set SplitRule because ActivityEmbedding Split is not supported or PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED is not set.");
                }
                return;
            }
            if(false) {
                break;
            }
        }
        Set set1 = this.adapter.translate(this.applicationContext, set0);
        this.embeddingExtension.setEmbeddingRules(set1);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 2)
    public void setSplitAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        this.windowSdkExtensions.requireExtensionVersion$window_release(2);
        Function function0 = this.adapter.translateSplitAttributesCalculator(k0);
        this.embeddingExtension.setSplitAttributesCalculator(function0);
        this.isCustomSplitAttributeCalculatorSet = true;
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 5)
    public void unpinTopActivityStack(int v) {
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        this.embeddingExtension.unpinTopActivityStack(v);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 8)
    public void updateOverlayAttributes(@NotNull String s, @NotNull OverlayAttributes overlayAttributes0) {
        q.g(s, "overlayTag");
        q.g(overlayAttributes0, "overlayAttributes");
        this.windowSdkExtensions.requireExtensionVersion$window_release(8);
        q.d(this.overlayController);
        this.overlayController.updateOverlayAttributes$window_release(s, overlayAttributes0);
    }

    @Override  // androidx.window.embedding.EmbeddingInterfaceCompat
    @RequiresWindowSdkExtension(version = 3)
    public void updateSplitAttributes(@NotNull androidx.window.embedding.SplitInfo splitInfo0, @NotNull androidx.window.embedding.SplitAttributes splitAttributes0) {
        q.g(splitInfo0, "splitInfo");
        q.g(splitAttributes0, "splitAttributes");
        this.windowSdkExtensions.requireExtensionVersion$window_release(3);
        if(this.windowSdkExtensions.getExtensionVersion() >= 5) {
            SplitInfo.Token splitInfo$Token0 = splitInfo0.getToken$window_release();
            SplitAttributes splitAttributes1 = this.adapter.translateSplitAttributes(splitAttributes0);
            this.embeddingExtension.updateSplitAttributes(splitInfo$Token0, splitAttributes1);
            return;
        }
        IBinder iBinder0 = splitInfo0.getBinder$window_release();
        SplitAttributes splitAttributes2 = this.adapter.translateSplitAttributes(splitAttributes0);
        this.embeddingExtension.updateSplitAttributes(iBinder0, splitAttributes2);
    }
}

