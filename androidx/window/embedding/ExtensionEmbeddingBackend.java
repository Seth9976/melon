package androidx.window.embedding;

import A3.m;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager.Property;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.g;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.BuildConfig;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.PredicateAdapter;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import b2.a;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u00D4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0000\u0018\u0000 y2\u00020\u0001:\u0005zy{|}B\u001B\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0017\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\u000E\u001A\u00020\r2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0017\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\tH\u0017\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\tH\u0017\u00A2\u0006\u0004\b\u0013\u0010\u0012J3\u0010\u001C\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0012\u0010\u001B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001A0\u00190\u0018H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ#\u0010\u001F\u001A\u00020\r2\u0012\u0010\u001E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001A0\u00190\u0018H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020!2\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010(\u001A\u00020!2\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&H\u0017\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001A\u00020\r2\u0006\u0010%\u001A\u00020$H\u0017\u00A2\u0006\u0004\b*\u0010+J#\u00100\u001A\u00020\r2\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0017\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\rH\u0017\u00A2\u0006\u0004\b2\u00103J\u0019\u00105\u001A\u0004\u0018\u0001042\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b5\u00106J\u001F\u0010:\u001A\u0002072\u0006\u00108\u001A\u0002072\u0006\u00109\u001A\u000204H\u0017\u00A2\u0006\u0004\b:\u0010;J\u001F\u0010>\u001A\u0002072\u0006\u00108\u001A\u0002072\u0006\u0010=\u001A\u00020<H\u0017\u00A2\u0006\u0004\b>\u0010?J\u001D\u0010A\u001A\u00020\r2\f\u0010@\u001A\b\u0012\u0004\u0012\u0002040\bH\u0017\u00A2\u0006\u0004\bA\u0010\u000FJ\u0017\u0010D\u001A\u00020\r2\u0006\u0010C\u001A\u00020BH\u0017\u00A2\u0006\u0004\bD\u0010EJ\u000F\u0010F\u001A\u00020\rH\u0017\u00A2\u0006\u0004\bF\u00103J\u001F\u0010I\u001A\u00020\r2\u0006\u0010G\u001A\u00020\u001A2\u0006\u0010H\u001A\u00020.H\u0017\u00A2\u0006\u0004\bI\u0010JJ#\u0010M\u001A\u00020\r2\u0012\u0010/\u001A\u000E\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0,H\u0017\u00A2\u0006\u0004\bM\u00101J\u000F\u0010N\u001A\u00020\rH\u0017\u00A2\u0006\u0004\bN\u00103J\u001F\u0010R\u001A\u00020\r2\u0006\u0010P\u001A\u00020O2\u0006\u0010Q\u001A\u00020LH\u0017\u00A2\u0006\u0004\bR\u0010SJ-\u0010V\u001A\u00020\r2\u0006\u0010P\u001A\u00020O2\u0006\u0010\u0017\u001A\u00020\u00162\f\u0010U\u001A\b\u0012\u0004\u0012\u00020T0\u0018H\u0017\u00A2\u0006\u0004\bV\u0010WJ\u001D\u0010X\u001A\u00020\r2\f\u0010U\u001A\b\u0012\u0004\u0012\u00020T0\u0018H\u0017\u00A2\u0006\u0004\bX\u0010 J%\u0010Z\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00142\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020Y0\u0018H\u0017\u00A2\u0006\u0004\bZ\u0010[J\u001D\u0010\\\u001A\u00020\r2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020Y0\u0018H\u0017\u00A2\u0006\u0004\b\\\u0010 J\u000F\u0010]\u001A\u00020!H\u0002\u00A2\u0006\u0004\b]\u0010^J\u0019\u0010_\u001A\u0004\u0018\u0001042\u0006\u0010\u0015\u001A\u00020\u0014H\u0003\u00A2\u0006\u0004\b_\u00106R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010`R$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u0005\u0010a\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR&\u0010h\u001A\b\u0012\u0004\u0012\u00020g0f8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\bh\u0010i\u0012\u0004\bl\u00103\u001A\u0004\bj\u0010kR\u0018\u0010n\u001A\u00060mR\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001A\u00020p8\u0002X\u0083\u0004\u00A2\u0006\u0006\n\u0004\bq\u0010rR\u001B\u0010x\u001A\u00020s8VX\u0096\u0084\u0002\u00A2\u0006\f\n\u0004\bt\u0010u\u001A\u0004\bv\u0010w\u00A8\u0006~"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend;", "Landroidx/window/embedding/EmbeddingBackend;", "Landroid/content/Context;", "applicationContext", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "embeddingExtension", "<init>", "(Landroid/content/Context;Landroidx/window/embedding/EmbeddingInterfaceCompat;)V", "", "Landroidx/window/embedding/EmbeddingRule;", "getRules", "()Ljava/util/Set;", "rules", "Lie/H;", "setRules", "(Ljava/util/Set;)V", "rule", "addRule", "(Landroidx/window/embedding/EmbeddingRule;)V", "removeRule", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "", "Landroidx/window/embedding/SplitInfo;", "callback", "addSplitListenerForActivity", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Lb2/a;)V", "consumer", "removeSplitListenerForActivity", "(Lb2/a;)V", "", "isActivityEmbedded", "(Landroid/app/Activity;)Z", "", "taskId", "Landroidx/window/embedding/SplitPinRule;", "splitPinRule", "pinTopActivityStack", "(ILandroidx/window/embedding/SplitPinRule;)Z", "unpinTopActivityStack", "(I)V", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "calculator", "setSplitAttributesCalculator", "(Lwe/k;)V", "clearSplitAttributesCalculator", "()V", "Landroidx/window/embedding/ActivityStack;", "getActivityStack", "(Landroid/app/Activity;)Landroidx/window/embedding/ActivityStack;", "Landroid/os/Bundle;", "options", "activityStack", "setLaunchingActivityStack", "(Landroid/os/Bundle;Landroidx/window/embedding/ActivityStack;)Landroid/os/Bundle;", "Landroidx/window/embedding/OverlayCreateParams;", "overlayCreateParams", "setOverlayCreateParams", "(Landroid/os/Bundle;Landroidx/window/embedding/OverlayCreateParams;)Landroid/os/Bundle;", "activityStacks", "finishActivityStacks", "Landroidx/window/embedding/EmbeddingConfiguration;", "embeddingConfig", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "invalidateVisibleActivityStacks", "splitInfo", "splitAttributes", "updateSplitAttributes", "(Landroidx/window/embedding/SplitInfo;Landroidx/window/embedding/SplitAttributes;)V", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "setOverlayAttributesCalculator", "clearOverlayAttributesCalculator", "", "overlayTag", "overlayAttributes", "updateOverlayAttributes", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "Landroidx/window/embedding/OverlayInfo;", "overlayInfoCallback", "addOverlayInfoCallback", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Lb2/a;)V", "removeOverlayInfoCallback", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "addEmbeddedActivityWindowInfoCallbackForActivity", "(Landroid/app/Activity;Lb2/a;)V", "removeEmbeddedActivityWindowInfoCallbackForActivity", "areExtensionsAvailable", "()Z", "getActivityStackFromSplitInfoList", "Landroid/content/Context;", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "getEmbeddingExtension", "()Landroidx/window/embedding/EmbeddingInterfaceCompat;", "setEmbeddingExtension", "(Landroidx/window/embedding/EmbeddingInterfaceCompat;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "splitChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getSplitChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getSplitChangeCallbacks$annotations", "Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "embeddingCallback", "Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Landroidx/window/embedding/ExtensionEmbeddingBackend$RuleTracker;", "ruleTracker", "Landroidx/window/embedding/ExtensionEmbeddingBackend$RuleTracker;", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "splitSupportStatus$delegate", "Lie/j;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "splitSupportStatus", "Companion", "Api31Impl", "EmbeddingCallbackImpl", "RuleTracker", "SplitListenerWrapper", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$Api31Impl;", "", "()V", "isSplitPropertyEnabled", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class Api31Impl {
        @NotNull
        public static final Api31Impl INSTANCE;

        static {
            Api31Impl.INSTANCE = new Api31Impl();
        }

        @NotNull
        public final SplitSupportStatus isSplitPropertyEnabled(@NotNull Context context0) {
            PackageManager.Property packageManager$Property0;
            q.g(context0, "context");
            try {
                packageManager$Property0 = context0.getPackageManager().getProperty("android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED", "com.iloen.melon");
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.w("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must be set and enabled in AndroidManifest.xml to use splits APIs.");
                }
                return SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED;
            }
            catch(Exception exception0) {
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.e("EmbeddingBackend", "PackageManager.getProperty is not supported", exception0);
                }
                return SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED;
            }
            q.d(packageManager$Property0);
            if(!packageManager$Property0.isBoolean()) {
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.w("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must have a boolean value");
                }
                return SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED;
            }
            return packageManager$Property0.getBoolean() ? SplitSupportStatus.SPLIT_AVAILABLE : SplitSupportStatus.SPLIT_UNAVAILABLE;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u0012\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\fH\u0002J\u0017\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$Companion;", "", "()V", "TAG", "", "globalInstance", "Landroidx/window/embedding/ExtensionEmbeddingBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", "Landroidx/window/embedding/EmbeddingBackend;", "context", "Landroid/content/Context;", "initAndVerifyEmbeddingExtension", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "applicationContext", "isExtensionVersionSupported", "", "extensionVersion", "", "(Ljava/lang/Integer;)Z", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final EmbeddingBackend getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            if(ExtensionEmbeddingBackend.globalInstance == null) {
                ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
                reentrantLock0.lock();
                try {
                    if(ExtensionEmbeddingBackend.globalInstance == null) {
                        Context context1 = context0.getApplicationContext();
                        q.d(context1);
                        ExtensionEmbeddingBackend.globalInstance = new ExtensionEmbeddingBackend(context1, ExtensionEmbeddingBackend.Companion.initAndVerifyEmbeddingExtension(context1));
                    }
                }
                finally {
                    reentrantLock0.unlock();
                }
            }
            EmbeddingBackend embeddingBackend0 = ExtensionEmbeddingBackend.globalInstance;
            q.d(embeddingBackend0);
            return embeddingBackend0;
        }

        private final EmbeddingInterfaceCompat initAndVerifyEmbeddingExtension(Context context0) {
            int v = WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
            EmbeddingInterfaceCompat embeddingInterfaceCompat0 = null;
            if(this.isExtensionVersionSupported(v)) {
                try {
                    androidx.window.embedding.EmbeddingCompat.Companion embeddingCompat$Companion0 = EmbeddingCompat.Companion;
                    if(embeddingCompat$Companion0.isEmbeddingAvailable()) {
                        ClassLoader classLoader0 = EmbeddingBackend.class.getClassLoader();
                        if(classLoader0 != null) {
                            ActivityEmbeddingComponent activityEmbeddingComponent0 = embeddingCompat$Companion0.embeddingComponent();
                            EmbeddingAdapter embeddingAdapter0 = new EmbeddingAdapter(new PredicateAdapter(classLoader0));
                            embeddingInterfaceCompat0 = new EmbeddingCompat(activityEmbeddingComponent0, embeddingAdapter0, new ConsumerAdapter(classLoader0), context0, (v < 8 ? null : new OverlayControllerImpl(activityEmbeddingComponent0, embeddingAdapter0)), (v < 6 ? null : new ActivityWindowInfoCallbackController(activityEmbeddingComponent0)));
                        }
                    }
                }
                catch(Throwable throwable0) {
                    Log.d("EmbeddingBackend", "Failed to load embedding extension: " + throwable0);
                }
            }
            if(embeddingInterfaceCompat0 == null) {
                Log.d("EmbeddingBackend", "No supported embedding extension found");
            }
            return embeddingInterfaceCompat0;
        }

        public final boolean isExtensionVersionSupported(@Nullable Integer integer0) {
            return integer0 == null ? false : ((int)integer0) >= 1;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u00072\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\u0004H\u0016¢\u0006\u0004\b\f\u0010\tR(\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\tR(\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\n0\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u000E\u001A\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "<init>", "(Landroidx/window/embedding/ExtensionEmbeddingBackend;)V", "", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Lie/H;", "onSplitInfoChanged", "(Ljava/util/List;)V", "Landroidx/window/embedding/ActivityStack;", "activityStacks", "onActivityStackChanged", "lastInfo", "Ljava/util/List;", "getLastInfo", "()Ljava/util/List;", "setLastInfo", "lastActivityStacks", "getLastActivityStacks", "setLastActivityStacks", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public final class EmbeddingCallbackImpl implements EmbeddingCallbackInterface {
        @NotNull
        private List lastActivityStacks;
        @NotNull
        private List lastInfo;

        public EmbeddingCallbackImpl() {
            this.lastInfo = w.a;
            this.lastActivityStacks = w.a;
        }

        @NotNull
        public final List getLastActivityStacks() {
            return this.lastActivityStacks;
        }

        @NotNull
        public final List getLastInfo() {
            return this.lastInfo;
        }

        @Override  // androidx.window.embedding.EmbeddingInterfaceCompat$EmbeddingCallbackInterface
        public void onActivityStackChanged(@NotNull List list0) {
            q.g(list0, "activityStacks");
            this.lastActivityStacks = list0;
        }

        @Override  // androidx.window.embedding.EmbeddingInterfaceCompat$EmbeddingCallbackInterface
        public void onSplitInfoChanged(@NotNull List list0) {
            q.g(list0, "splitInfo");
            this.lastInfo = list0;
            for(Object object0: ExtensionEmbeddingBackend.this.getSplitChangeCallbacks()) {
                ((SplitListenerWrapper)object0).accept(list0);
            }
        }

        public final void setLastActivityStacks(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.lastActivityStacks = list0;
        }

        public final void setLastInfo(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.lastInfo = list0;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\u001F\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001D\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R0\u0010\u001C\u001A\u001E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00050\u0019j\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u0005`\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$RuleTracker;", "", "<init>", "()V", "", "Landroidx/window/embedding/EmbeddingRule;", "rules", "Lie/H;", "setRules", "(Ljava/util/Set;)V", "clearRules", "rule", "", "throwOnDuplicateTag", "addOrUpdateRule", "(Landroidx/window/embedding/EmbeddingRule;Z)V", "removeRule", "(Landroidx/window/embedding/EmbeddingRule;)V", "contains", "(Landroidx/window/embedding/EmbeddingRule;)Z", "Landroidx/collection/g;", "splitRules", "Landroidx/collection/g;", "getSplitRules", "()Landroidx/collection/g;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "tagRuleMap", "Ljava/util/HashMap;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class RuleTracker {
        @NotNull
        private final g splitRules;
        @NotNull
        private final HashMap tagRuleMap;

        public RuleTracker() {
            this.splitRules = new g(0);
            this.tagRuleMap = new HashMap();
        }

        public final void addOrUpdateRule(@NotNull EmbeddingRule embeddingRule0, boolean z) {
            q.g(embeddingRule0, "rule");
            if(this.splitRules.contains(embeddingRule0)) {
                return;
            }
            String s = embeddingRule0.getTag();
            if(s == null) {
                this.splitRules.add(embeddingRule0);
                return;
            }
            if(this.tagRuleMap.containsKey(s)) {
                if(z) {
                    throw new IllegalArgumentException("Duplicated tag: " + s + ". Tag must be unique among all registered rules");
                }
                EmbeddingRule embeddingRule1 = (EmbeddingRule)this.tagRuleMap.get(s);
                N.a(this.splitRules).remove(embeddingRule1);
                this.tagRuleMap.put(s, embeddingRule0);
                this.splitRules.add(embeddingRule0);
                return;
            }
            this.tagRuleMap.put(s, embeddingRule0);
            this.splitRules.add(embeddingRule0);
        }

        public static void addOrUpdateRule$default(RuleTracker extensionEmbeddingBackend$RuleTracker0, EmbeddingRule embeddingRule0, boolean z, int v, Object object0) {
            if((v & 2) != 0) {
                z = false;
            }
            extensionEmbeddingBackend$RuleTracker0.addOrUpdateRule(embeddingRule0, z);
        }

        public final void clearRules() {
            this.splitRules.clear();
            this.tagRuleMap.clear();
        }

        public final boolean contains(@NotNull EmbeddingRule embeddingRule0) {
            q.g(embeddingRule0, "rule");
            return this.splitRules.contains(embeddingRule0);
        }

        @NotNull
        public final g getSplitRules() {
            return this.splitRules;
        }

        public final void removeRule(@NotNull EmbeddingRule embeddingRule0) {
            q.g(embeddingRule0, "rule");
            if(this.splitRules.contains(embeddingRule0)) {
                this.splitRules.remove(embeddingRule0);
                if(embeddingRule0.getTag() != null) {
                    this.tagRuleMap.remove(embeddingRule0.getTag());
                }
            }
        }

        public final void setRules(@NotNull Set set0) {
            q.g(set0, "rules");
            this.clearRules();
            for(Object object0: set0) {
                this.addOrUpdateRule(((EmbeddingRule)object0), true);
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0012\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\u000E\u001A\u00020\r2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R#\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u001E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "", "Landroidx/window/embedding/SplitInfo;", "callback", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Lb2/a;)V", "splitInfoList", "Lie/H;", "accept", "(Ljava/util/List;)V", "Landroid/app/Activity;", "Ljava/util/concurrent/Executor;", "Lb2/a;", "getCallback", "()Lb2/a;", "lastValue", "Ljava/util/List;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class SplitListenerWrapper {
        @NotNull
        private final Activity activity;
        @NotNull
        private final a callback;
        @NotNull
        private final Executor executor;
        @Nullable
        private List lastValue;

        public SplitListenerWrapper(@NotNull Activity activity0, @NotNull Executor executor0, @NotNull a a0) {
            q.g(activity0, "activity");
            q.g(executor0, "executor");
            q.g(a0, "callback");
            super();
            this.activity = activity0;
            this.executor = executor0;
            this.callback = a0;
        }

        public final void accept(@NotNull List list0) {
            q.g(list0, "splitInfoList");
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                if(((SplitInfo)object0).contains(this.activity)) {
                    arrayList0.add(object0);
                }
            }
            if(arrayList0.equals(this.lastValue)) {
                return;
            }
            this.lastValue = arrayList0;
            m m0 = new m(28, this, arrayList0);
            this.executor.execute(m0);
        }

        private static final void accept$lambda$1(SplitListenerWrapper extensionEmbeddingBackend$SplitListenerWrapper0, List list0) {
            extensionEmbeddingBackend$SplitListenerWrapper0.callback.accept(list0);
        }

        @NotNull
        public final a getCallback() {
            return this.callback;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "EmbeddingBackend";
    @NotNull
    private final Context applicationContext;
    @NotNull
    private final EmbeddingCallbackImpl embeddingCallback;
    @Nullable
    private EmbeddingInterfaceCompat embeddingExtension;
    @Nullable
    private static volatile ExtensionEmbeddingBackend globalInstance;
    @NotNull
    private static final ReentrantLock globalLock;
    @NotNull
    private final RuleTracker ruleTracker;
    @NotNull
    private final CopyOnWriteArrayList splitChangeCallbacks;
    @NotNull
    private final j splitSupportStatus$delegate;

    static {
        ExtensionEmbeddingBackend.Companion = new Companion(null);
        ExtensionEmbeddingBackend.globalLock = new ReentrantLock();
    }

    public ExtensionEmbeddingBackend(@NotNull Context context0, @Nullable EmbeddingInterfaceCompat embeddingInterfaceCompat0) {
        q.g(context0, "applicationContext");
        super();
        this.applicationContext = context0;
        this.embeddingExtension = embeddingInterfaceCompat0;
        EmbeddingCallbackImpl extensionEmbeddingBackend$EmbeddingCallbackImpl0 = new EmbeddingCallbackImpl(this);
        this.embeddingCallback = extensionEmbeddingBackend$EmbeddingCallbackImpl0;
        this.splitChangeCallbacks = new CopyOnWriteArrayList();
        EmbeddingInterfaceCompat embeddingInterfaceCompat1 = this.embeddingExtension;
        if(embeddingInterfaceCompat1 != null) {
            embeddingInterfaceCompat1.setEmbeddingCallback(extensionEmbeddingBackend$EmbeddingCallbackImpl0);
        }
        this.ruleTracker = new RuleTracker();
        this.splitSupportStatus$delegate = d3.g.Q(new we.a() {
            {
                ExtensionEmbeddingBackend.this = extensionEmbeddingBackend0;
                super(0);
            }

            public final SplitSupportStatus invoke() {
                if(!ExtensionEmbeddingBackend.access$areExtensionsAvailable(ExtensionEmbeddingBackend.this)) {
                    return SplitSupportStatus.SPLIT_UNAVAILABLE;
                }
                return Build.VERSION.SDK_INT < 0x1F ? SplitSupportStatus.SPLIT_AVAILABLE : Api31Impl.INSTANCE.isSplitPropertyEnabled(ExtensionEmbeddingBackend.this.applicationContext);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    public static final boolean access$areExtensionsAvailable(ExtensionEmbeddingBackend extensionEmbeddingBackend0) {
        return extensionEmbeddingBackend0.areExtensionsAvailable();
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 6)
    public void addEmbeddedActivityWindowInfoCallbackForActivity(@NotNull Activity activity0, @NotNull a a0) {
        q.g(activity0, "activity");
        q.g(a0, "callback");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.addEmbeddedActivityWindowInfoCallbackForActivity(activity0, a0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 8)
    public void addOverlayInfoCallback(@NotNull String s, @NotNull Executor executor0, @NotNull a a0) {
        H h0;
        q.g(s, "overlayTag");
        q.g(executor0, "executor");
        q.g(a0, "overlayInfoCallback");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 == null) {
            h0 = null;
        }
        else {
            embeddingInterfaceCompat0.addOverlayInfoCallback(s, executor0, a0);
            h0 = H.a;
        }
        if(h0 == null) {
            a0.accept(new OverlayInfo(s, null, null));
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    public void addRule(@NotNull EmbeddingRule embeddingRule0) {
        q.g(embeddingRule0, "rule");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            if(!this.ruleTracker.contains(embeddingRule0)) {
                RuleTracker.addOrUpdateRule$default(this.ruleTracker, embeddingRule0, false, 2, null);
                EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
                if(embeddingInterfaceCompat0 != null) {
                    embeddingInterfaceCompat0.setRules(this.getRules());
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    public void addSplitListenerForActivity(@NotNull Activity activity0, @NotNull Executor executor0, @NotNull a a0) {
        q.g(activity0, "activity");
        q.g(executor0, "executor");
        q.g(a0, "callback");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            if(this.embeddingExtension == null) {
                Log.v("EmbeddingBackend", "Extension not loaded, skipping callback registration.");
                a0.accept(w.a);
                return;
            }
            SplitListenerWrapper extensionEmbeddingBackend$SplitListenerWrapper0 = new SplitListenerWrapper(activity0, executor0, a0);
            this.splitChangeCallbacks.add(extensionEmbeddingBackend$SplitListenerWrapper0);
            extensionEmbeddingBackend$SplitListenerWrapper0.accept(this.embeddingCallback.getLastInfo());
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    private final boolean areExtensionsAvailable() {
        return this.embeddingExtension != null;
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 8)
    public void clearOverlayAttributesCalculator() {
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.clearOverlayAttributesCalculator();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 2)
    public void clearSplitAttributesCalculator() {
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
            if(embeddingInterfaceCompat0 != null) {
                embeddingInterfaceCompat0.clearSplitAttributesCalculator();
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 5)
    public void finishActivityStacks(@NotNull Set set0) {
        q.g(set0, "activityStacks");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.finishActivityStacks(set0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @Nullable
    public ActivityStack getActivityStack(@NotNull Activity activity0) {
        Object object0 = null;
        q.g(activity0, "activity");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            for(Object object1: this.embeddingCallback.getLastActivityStacks()) {
                if(((ActivityStack)object1).contains(activity0)) {
                    object0 = object1;
                    break;
                }
            }
            ActivityStack activityStack0 = (ActivityStack)object0;
            if(activityStack0 == null) {
                activityStack0 = this.getActivityStackFromSplitInfoList(activity0);
            }
            return activityStack0;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    private final ActivityStack getActivityStackFromSplitInfoList(Activity activity0) {
        for(Object object0: this.embeddingCallback.getLastInfo()) {
            SplitInfo splitInfo0 = (SplitInfo)object0;
            if(splitInfo0.contains(activity0)) {
                if(splitInfo0.getPrimaryActivityStack().contains(activity0)) {
                    return splitInfo0.getPrimaryActivityStack();
                }
                if(splitInfo0.getSecondaryActivityStack().contains(activity0)) {
                    return splitInfo0.getSecondaryActivityStack();
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    @Nullable
    public final EmbeddingInterfaceCompat getEmbeddingExtension() {
        return this.embeddingExtension;
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @NotNull
    public Set getRules() {
        ExtensionEmbeddingBackend.globalLock.lock();
        try {
            return p.T0(this.ruleTracker.getSplitRules());
        }
        finally {
            ExtensionEmbeddingBackend.globalLock.unlock();
        }
    }

    @NotNull
    public final CopyOnWriteArrayList getSplitChangeCallbacks() {
        return this.splitChangeCallbacks;
    }

    public static void getSplitChangeCallbacks$annotations() {
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @NotNull
    public SplitSupportStatus getSplitSupportStatus() {
        return (SplitSupportStatus)this.splitSupportStatus$delegate.getValue();
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 3)
    public void invalidateVisibleActivityStacks() {
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.invalidateVisibleActivityStacks();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    public boolean isActivityEmbedded(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.embeddingExtension == null ? false : this.embeddingExtension.isActivityEmbedded(activity0);
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 5)
    public boolean pinTopActivityStack(int v, @NotNull SplitPinRule splitPinRule0) {
        q.g(splitPinRule0, "splitPinRule");
        return this.embeddingExtension == null ? false : this.embeddingExtension.pinTopActivityStack(v, splitPinRule0);
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 6)
    public void removeEmbeddedActivityWindowInfoCallbackForActivity(@NotNull a a0) {
        q.g(a0, "callback");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.removeEmbeddedActivityWindowInfoCallbackForActivity(a0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 8)
    public void removeOverlayInfoCallback(@NotNull a a0) {
        q.g(a0, "overlayInfoCallback");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.removeOverlayInfoCallback(a0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    public void removeRule(@NotNull EmbeddingRule embeddingRule0) {
        q.g(embeddingRule0, "rule");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            if(this.ruleTracker.contains(embeddingRule0)) {
                this.ruleTracker.removeRule(embeddingRule0);
                EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
                if(embeddingInterfaceCompat0 != null) {
                    embeddingInterfaceCompat0.setRules(this.getRules());
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    public void removeSplitListenerForActivity(@NotNull a a0) {
        q.g(a0, "consumer");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            for(Object object0: this.splitChangeCallbacks) {
                SplitListenerWrapper extensionEmbeddingBackend$SplitListenerWrapper0 = (SplitListenerWrapper)object0;
                if(q.b(extensionEmbeddingBackend$SplitListenerWrapper0.getCallback(), a0)) {
                    this.splitChangeCallbacks.remove(extensionEmbeddingBackend$SplitListenerWrapper0);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 5)
    public void setEmbeddingConfiguration(@NotNull EmbeddingConfiguration embeddingConfiguration0) {
        q.g(embeddingConfiguration0, "embeddingConfig");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.setEmbeddingConfiguration(embeddingConfiguration0);
        }
    }

    public final void setEmbeddingExtension(@Nullable EmbeddingInterfaceCompat embeddingInterfaceCompat0) {
        this.embeddingExtension = embeddingInterfaceCompat0;
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 5)
    @NotNull
    public Bundle setLaunchingActivityStack(@NotNull Bundle bundle0, @NotNull ActivityStack activityStack0) {
        q.g(bundle0, "options");
        q.g(activityStack0, "activityStack");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            Bundle bundle1 = embeddingInterfaceCompat0.setLaunchingActivityStack(bundle0, activityStack0);
            return bundle1 == null ? bundle0 : bundle1;
        }
        return bundle0;
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 8)
    public void setOverlayAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.setOverlayAttributesCalculator(k0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 8)
    @NotNull
    public Bundle setOverlayCreateParams(@NotNull Bundle bundle0, @NotNull OverlayCreateParams overlayCreateParams0) {
        q.g(bundle0, "options");
        q.g(overlayCreateParams0, "overlayCreateParams");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            Bundle bundle1 = embeddingInterfaceCompat0.setOverlayCreateParams(bundle0, overlayCreateParams0);
            return bundle1 == null ? bundle0 : bundle1;
        }
        return bundle0;
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    public void setRules(@NotNull Set set0) {
        q.g(set0, "rules");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            this.ruleTracker.setRules(set0);
            EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
            if(embeddingInterfaceCompat0 != null) {
                embeddingInterfaceCompat0.setRules(this.getRules());
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 2)
    public void setSplitAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        ReentrantLock reentrantLock0 = ExtensionEmbeddingBackend.globalLock;
        reentrantLock0.lock();
        try {
            EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
            if(embeddingInterfaceCompat0 != null) {
                embeddingInterfaceCompat0.setSplitAttributesCalculator(k0);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 5)
    public void unpinTopActivityStack(int v) {
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.unpinTopActivityStack(v);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 8)
    public void updateOverlayAttributes(@NotNull String s, @NotNull OverlayAttributes overlayAttributes0) {
        q.g(s, "overlayTag");
        q.g(overlayAttributes0, "overlayAttributes");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.updateOverlayAttributes(s, overlayAttributes0);
        }
    }

    @Override  // androidx.window.embedding.EmbeddingBackend
    @RequiresWindowSdkExtension(version = 3)
    public void updateSplitAttributes(@NotNull SplitInfo splitInfo0, @NotNull SplitAttributes splitAttributes0) {
        q.g(splitInfo0, "splitInfo");
        q.g(splitAttributes0, "splitAttributes");
        EmbeddingInterfaceCompat embeddingInterfaceCompat0 = this.embeddingExtension;
        if(embeddingInterfaceCompat0 != null) {
            embeddingInterfaceCompat0.updateSplitAttributes(splitInfo0, splitAttributes0);
        }
    }
}

