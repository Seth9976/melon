package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.view.WindowMetrics;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.core.util.function.Predicate;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityRule.Builder;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack.Token;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.ActivityStackAttributes.Builder;
import androidx.window.extensions.embedding.ActivityStackAttributes;
import androidx.window.extensions.embedding.ActivityStackAttributesCalculatorParams;
import androidx.window.extensions.embedding.AnimationBackground.ColorBackground;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.DividerAttributes.Builder;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.EmbeddedActivityWindowInfo;
import androidx.window.extensions.embedding.ParentContainerInfo;
import androidx.window.extensions.embedding.SplitAttributes.Builder;
import androidx.window.extensions.embedding.SplitAttributes.SplitType.ExpandContainersSplitType;
import androidx.window.extensions.embedding.SplitAttributes.SplitType.HingeSplitType;
import androidx.window.extensions.embedding.SplitAttributes.SplitType.RatioSplitType;
import androidx.window.extensions.embedding.SplitAttributes.SplitType;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.extensions.embedding.SplitInfo.Token;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule.Builder;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule.Builder;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.SplitRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\bG\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001A\u00020\u0014H\u0002J\r\u0010\u0015\u001A\u00020\u0014H\u0001\u00A2\u0006\u0002\b\u0016J\r\u0010\u0017\u001A\u00020\u0014H\u0001\u00A2\u0006\u0002\b\u0018J\r\u0010\u0019\u001A\u00020\u0014H\u0001\u00A2\u0006\u0002\b\u001AJ\r\u0010\u001B\u001A\u00020\u0014H\u0001\u00A2\u0006\u0002\b\u001CJ\r\u0010\u001D\u001A\u00020\u0014H\u0001\u00A2\u0006\u0002\b\u001EJ\r\u0010\u001F\u001A\u00020\u0014H\u0001\u00A2\u0006\u0002\b J\b\u0010!\u001A\u00020\u0014H\u0002J\b\u0010\"\u001A\u00020\u0014H\u0002J\b\u0010#\u001A\u00020\u0014H\u0002J\b\u0010$\u001A\u00020\u0014H\u0002J\b\u0010%\u001A\u00020\u0014H\u0002J\b\u0010&\u001A\u00020\u0014H\u0002J\b\u0010\'\u001A\u00020\u0014H\u0002J\b\u0010(\u001A\u00020\u0014H\u0002J\b\u0010)\u001A\u00020\u0014H\u0002J\b\u0010*\u001A\u00020\u0014H\u0002J\b\u0010+\u001A\u00020\u0014H\u0002J\b\u0010,\u001A\u00020\u0014H\u0002J\b\u0010-\u001A\u00020\u0014H\u0002J\b\u0010.\u001A\u00020\u0014H\u0002J\b\u0010/\u001A\u00020\u0014H\u0002J\b\u00100\u001A\u00020\u0014H\u0002J\b\u00101\u001A\u00020\u0014H\u0002J\b\u00102\u001A\u00020\u0014H\u0002J\b\u00103\u001A\u00020\u0014H\u0002J\b\u00104\u001A\u00020\u0014H\u0002J\b\u00105\u001A\u00020\u0014H\u0002J\b\u00106\u001A\u00020\u0014H\u0002J\b\u00107\u001A\u00020\u0014H\u0002J\b\u00108\u001A\u00020\u0014H\u0002J\b\u00109\u001A\u00020\u0014H\u0002J\b\u0010:\u001A\u00020\u0014H\u0002J\b\u0010;\u001A\u00020\u0014H\u0002J\b\u0010<\u001A\u00020\u0014H\u0002J\b\u0010=\u001A\u00020\u0014H\u0002J\b\u0010>\u001A\u00020\u0014H\u0002J\b\u0010?\u001A\u00020\u0014H\u0002J\b\u0010@\u001A\u00020\u0014H\u0002J\b\u0010A\u001A\u00020\u0014H\u0002J\b\u0010B\u001A\u00020\u0014H\u0002J\b\u0010C\u001A\u00020\u0014H\u0002J\b\u0010D\u001A\u00020\u0014H\u0002J\b\u0010E\u001A\u00020\u0014H\u0002J\b\u0010F\u001A\u00020\u0014H\u0002J\b\u0010G\u001A\u00020\u0014H\u0002J\b\u0010H\u001A\u00020\u0014H\u0002J\b\u0010I\u001A\u00020\u0014H\u0002J\b\u0010J\u001A\u00020\u0014H\u0002J\b\u0010K\u001A\u00020\u0014H\u0002J\b\u0010L\u001A\u00020\u0014H\u0002J\b\u0010M\u001A\u00020\u0014H\u0002J\b\u0010N\u001A\u00020\u0014H\u0002J\b\u0010O\u001A\u00020\u0014H\u0002J\b\u0010P\u001A\u00020\u0014H\u0002J\b\u0010Q\u001A\u00020\u0014H\u0002J\b\u0010R\u001A\u00020\u0014H\u0002J\b\u0010S\u001A\u00020\u0014H\u0002J\b\u0010T\u001A\u00020\u0014H\u0002J\b\u0010U\u001A\u00020\u0014H\u0002J\b\u0010V\u001A\u00020\u0014H\u0002J\b\u0010W\u001A\u00020\u0014H\u0002J\b\u0010X\u001A\u00020\u0014H\u0002J\b\u0010Y\u001A\u00020\u0014H\u0002J\b\u0010Z\u001A\u00020\u0014H\u0002R\u0013\u0010\t\u001A\u0004\u0018\u00010\n8F\u00A2\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0018\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u000E8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u0006["}, d2 = {"Landroidx/window/embedding/SafeActivityEmbeddingComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;Landroidx/window/extensions/WindowExtensions;)V", "activityEmbeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "getActivityEmbeddingComponent", "()Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "activityEmbeddingComponentClass", "Ljava/lang/Class;", "getActivityEmbeddingComponentClass", "()Ljava/lang/Class;", "safeWindowExtensionsProvider", "Landroidx/window/SafeWindowExtensionsProvider;", "canUseActivityEmbeddingComponent", "", "hasValidVendorApiLevel1", "hasValidVendorApiLevel1$window_release", "hasValidVendorApiLevel2", "hasValidVendorApiLevel2$window_release", "hasValidVendorApiLevel3", "hasValidVendorApiLevel3$window_release", "hasValidVendorApiLevel5", "hasValidVendorApiLevel5$window_release", "hasValidVendorApiLevel6", "hasValidVendorApiLevel6$window_release", "isActivityEmbeddingComponentAccessible", "isActivityEmbeddingComponentAccessible$window_release", "isActivityEmbeddingComponentValid", "isActivityStackGetActivityStackTokenValid", "isActivityStackGetTagValid", "isClassActivityRuleBuilderLevel1Valid", "isClassActivityRuleBuilderLevel2Valid", "isClassActivityRuleValid", "isClassActivityStackAttributesBuilderValid", "isClassActivityStackAttributesCalculatorParamsValid", "isClassActivityStackAttributesValid", "isClassActivityStackTokenValid", "isClassAnimationBackgroundValid", "isClassDividerAttributesBuilderValid", "isClassDividerAttributesValid", "isClassEmbeddedActivityWindowInfoValid", "isClassEmbeddingRuleValid", "isClassParentContainerInfoValid", "isClassSplitAttributesCalculatorParamsValid", "isClassSplitAttributesValid", "isClassSplitInfoTokenValid", "isClassSplitInfoValid", "isClassSplitPairRuleBuilderLevel1Valid", "isClassSplitPairRuleBuilderLevel2Valid", "isClassSplitPairRuleValid", "isClassSplitPlaceholderRuleBuilderLevel1Valid", "isClassSplitPlaceholderRuleBuilderLevel2Valid", "isClassSplitPlaceholderRuleValid", "isClassSplitTypeValid", "isClassWindowAttributesValid", "isMethodClearActivityStackAttributesCalculatorValid", "isMethodClearEmbeddedActivityWindowInfoCallbackValid", "isMethodClearSplitInfoCallbackValid", "isMethodGetActivityStackTokenValid", "isMethodGetDefaultSplitAttributesValid", "isMethodGetDividerAttributesValid", "isMethodGetEmbeddedActivityWindowInfoValid", "isMethodGetFinishPrimaryWithPlaceholderValid", "isMethodGetLayoutDirectionValid", "isMethodGetParentContainerInfoValid", "isMethodGetSplitAttributesValid", "isMethodGetSplitInfoTokenValid", "isMethodGetSplitRatioValid", "isMethodInvalidateTopVisibleSplitAttributesValid", "isMethodIsActivityEmbeddedValid", "isMethodPinUnpinTopActivityStackValid", "isMethodRegisterActivityStackCallbackValid", "isMethodSetActivityStackAttributesCalculatorValid", "isMethodSetDividerAttributesValid", "isMethodSetEmbeddedActivityWindowInfoCallbackValid", "isMethodSetEmbeddingRulesValid", "isMethodSetSplitInfoCallbackJavaConsumerValid", "isMethodSetSplitInfoCallbackWindowConsumerValid", "isMethodSplitAttributesCalculatorValid", "isMethodSplitInfoGetTokenValid", "isMethodUnregisterActivityStackCallbackValid", "isMethodUpdateActivityStackAttributesValid", "isMethodUpdateSplitAttributesValid", "isMethodUpdateSplitAttributesWithTokenValid", "isOverlayFeatureValid", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SafeActivityEmbeddingComponentProvider {
    @NotNull
    private final ConsumerAdapter consumerAdapter;
    @NotNull
    private final ClassLoader loader;
    @NotNull
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;
    @NotNull
    private final WindowExtensions windowExtensions;

    public SafeActivityEmbeddingComponentProvider(@NotNull ClassLoader classLoader0, @NotNull ConsumerAdapter consumerAdapter0, @NotNull WindowExtensions windowExtensions0) {
        q.g(classLoader0, "loader");
        q.g(consumerAdapter0, "consumerAdapter");
        q.g(windowExtensions0, "windowExtensions");
        super();
        this.loader = classLoader0;
        this.consumerAdapter = consumerAdapter0;
        this.windowExtensions = windowExtensions0;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(classLoader0);
    }

    private final boolean canUseActivityEmbeddingComponent() {
        if(!this.isActivityEmbeddingComponentAccessible$window_release()) {
            return false;
        }
        int v = WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
        if(v == 1) {
            return this.hasValidVendorApiLevel1$window_release();
        }
        if(v == 2) {
            return this.hasValidVendorApiLevel2$window_release();
        }
        if(3 <= v && v < 5) {
            return this.hasValidVendorApiLevel3$window_release();
        }
        if(v == 5) {
            return this.hasValidVendorApiLevel5$window_release();
        }
        return 6 > v || v > 0x7FFFFFFF ? false : this.hasValidVendorApiLevel6$window_release();
    }

    @Nullable
    public final ActivityEmbeddingComponent getActivityEmbeddingComponent() {
        if(this.canUseActivityEmbeddingComponent()) {
            try {
                return this.windowExtensions.getActivityEmbeddingComponent();
            }
            catch(UnsupportedOperationException unused_ex) {
            }
        }
        return null;
    }

    private final Class getActivityEmbeddingComponentClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    // 去混淆评级： 中等(120)
    public final boolean hasValidVendorApiLevel1$window_release() {
        return this.isMethodSetEmbeddingRulesValid() && this.isMethodIsActivityEmbeddedValid() && this.isMethodSetSplitInfoCallbackJavaConsumerValid() && this.isMethodGetSplitRatioValid() && this.isMethodGetLayoutDirectionValid() && this.isClassActivityRuleValid() && this.isClassActivityRuleBuilderLevel1Valid() && this.isClassSplitInfoValid() && this.isClassSplitPairRuleValid() && this.isClassSplitPairRuleBuilderLevel1Valid() && this.isClassSplitPlaceholderRuleValid() && this.isClassSplitPlaceholderRuleBuilderLevel1Valid();
    }

    // 去混淆评级： 中等(140)
    public final boolean hasValidVendorApiLevel2$window_release() {
        return this.hasValidVendorApiLevel1$window_release() && this.isMethodSetSplitInfoCallbackWindowConsumerValid() && this.isMethodClearSplitInfoCallbackValid() && this.isMethodSplitAttributesCalculatorValid() && this.isMethodGetSplitAttributesValid() && this.isMethodGetFinishPrimaryWithPlaceholderValid() && this.isMethodGetDefaultSplitAttributesValid() && this.isClassActivityRuleBuilderLevel2Valid() && this.isClassEmbeddingRuleValid() && this.isClassSplitAttributesValid() && this.isClassSplitAttributesCalculatorParamsValid() && this.isClassSplitTypeValid() && this.isClassSplitPairRuleBuilderLevel2Valid() && this.isClassSplitPlaceholderRuleBuilderLevel2Valid();
    }

    // 去混淆评级： 低(40)
    public final boolean hasValidVendorApiLevel3$window_release() {
        return this.hasValidVendorApiLevel2$window_release() && this.isMethodInvalidateTopVisibleSplitAttributesValid() && this.isMethodUpdateSplitAttributesValid() && this.isMethodSplitInfoGetTokenValid();
    }

    // 去混淆评级： 中等(110)
    public final boolean hasValidVendorApiLevel5$window_release() {
        return this.hasValidVendorApiLevel3$window_release() && this.isActivityStackGetActivityStackTokenValid() && this.isMethodRegisterActivityStackCallbackValid() && this.isMethodUnregisterActivityStackCallbackValid() && this.isMethodPinUnpinTopActivityStackValid() && this.isMethodUpdateSplitAttributesWithTokenValid() && this.isMethodGetSplitInfoTokenValid() && this.isClassAnimationBackgroundValid() && this.isClassActivityStackTokenValid() && this.isClassWindowAttributesValid() && this.isClassSplitInfoTokenValid();
    }

    // 去混淆评级： 中等(90)
    public final boolean hasValidVendorApiLevel6$window_release() {
        return this.hasValidVendorApiLevel5$window_release() && this.isMethodGetEmbeddedActivityWindowInfoValid() && this.isMethodSetEmbeddedActivityWindowInfoCallbackValid() && this.isMethodClearEmbeddedActivityWindowInfoCallbackValid() && this.isMethodGetDividerAttributesValid() && this.isMethodSetDividerAttributesValid() && this.isClassEmbeddedActivityWindowInfoValid() && this.isClassDividerAttributesValid() && this.isClassDividerAttributesBuilderValid();
    }

    // 去混淆评级： 低(20)
    public final boolean isActivityEmbeddingComponentAccessible$window_release() {
        return this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release() && this.isActivityEmbeddingComponentValid();
    }

    private final boolean isActivityEmbeddingComponentValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getActivityEmbeddingComponent is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getActivityEmbeddingComponent", null);
                Class class0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass();
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, class0) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isActivityStackGetActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityStack#getActivityToken is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ActivityStack.class.getMethod("getActivityStackToken", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, ActivityStack.Token.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isActivityStackGetTagValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityStack#getTag is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ActivityStack.class.getMethod("getTag", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, String.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ActivityRule.Builder.class.getMethod("setShouldAlwaysExpand", Boolean.TYPE);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, ActivityRule.Builder.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Constructor constructor0 = ActivityRule.Builder.class.getDeclaredConstructor(Predicate.class, Predicate.class);
                Method method0 = ActivityRule.Builder.class.getMethod("setTag", String.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(constructor0);
                if(reflectionUtils0.isPublic$window_release(constructor0)) {
                    q.d(method0);
                    return !reflectionUtils0.isPublic$window_release(method0) || !reflectionUtils0.doesReturn$window_release(method0, ActivityRule.Builder.class) ? false : true;
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ActivityRule.class.getMethod("shouldAlwaysExpand", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, Boolean.TYPE) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityStackAttributesBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributes.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Constructor constructor0 = ActivityStackAttributes.Builder.class.getDeclaredConstructor(null);
                Method method0 = ActivityStackAttributes.Builder.class.getMethod("setRelativeBounds", Rect.class);
                Method method1 = ActivityStackAttributes.Builder.class.getMethod("setWindowAttributes", WindowAttributes.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(constructor0);
                if(reflectionUtils0.isPublic$window_release(constructor0)) {
                    q.d(method0);
                    if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, ActivityStackAttributes.Builder.class)) {
                        q.d(method1);
                        return !reflectionUtils0.isPublic$window_release(method1) || !reflectionUtils0.doesReturn$window_release(method1, ActivityStackAttributes.Builder.class) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityStackAttributesCalculatorParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributesCalculatorParams is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ActivityStackAttributesCalculatorParams.class.getMethod("getParentContainerInfo", null);
                Method method1 = ActivityStackAttributesCalculatorParams.class.getMethod("getActivityStackTag", null);
                Method method2 = ActivityStackAttributesCalculatorParams.class.getMethod("getLaunchOptions", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, ParentContainerInfo.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, String.class)) {
                        q.d(method2);
                        return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, Bundle.class) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityStackAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ActivityStackAttributes.class.getMethod("getRelativeBounds", null);
                Method method1 = ActivityStackAttributes.class.getMethod("getWindowAttributes", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, Rect.class)) {
                    q.d(method1);
                    return !reflectionUtils0.isPublic$window_release(method1) || !reflectionUtils0.doesReturn$window_release(method1, WindowAttributes.class) ? false : true;
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStack.Token is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = ActivityStack.Token.class;
                Method method0 = class0.getMethod("toBundle", null);
                Method method1 = class0.getMethod("readFromBundle", Bundle.class);
                Method method2 = class0.getMethod("createFromBinder", IBinder.class);
                Field field0 = class0.getDeclaredField("INVALID_ACTIVITY_STACK_TOKEN");
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, Bundle.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, class0)) {
                        q.d(method2);
                        if(reflectionUtils0.isPublic$window_release(method2) && reflectionUtils0.doesReturn$window_release(method2, class0)) {
                            q.d(field0);
                            return reflectionUtils0.isPublic$window_release(field0);
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassAnimationBackgroundValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationBackground is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = AnimationBackground.class;
                Class class1 = Integer.TYPE;
                Method method0 = class0.getMethod("createColorBackground", class1);
                Field field0 = class0.getDeclaredField("ANIMATION_BACKGROUND_DEFAULT");
                Method method1 = AnimationBackground.ColorBackground.class.getMethod("getColor", null);
                Method method2 = SplitAttributes.class.getMethod("getAnimationBackground", null);
                Method method3 = SplitAttributes.Builder.class.getMethod("setAnimationBackground", AnimationBackground.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, AnimationBackground.ColorBackground.class)) {
                    q.d(field0);
                    if(reflectionUtils0.isPublic$window_release(field0)) {
                        q.d(method1);
                        if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, class1)) {
                            q.d(method2);
                            if(reflectionUtils0.isPublic$window_release(method2) && reflectionUtils0.doesReturn$window_release(method2, class0)) {
                                q.d(method3);
                                return !reflectionUtils0.isPublic$window_release(method3) || !reflectionUtils0.doesReturn$window_release(method3, SplitAttributes.Builder.class) ? false : true;
                            }
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassDividerAttributesBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class DividerAttributes.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = Integer.TYPE;
                Constructor constructor0 = DividerAttributes.Builder.class.getDeclaredConstructor(class0);
                Constructor constructor1 = DividerAttributes.Builder.class.getDeclaredConstructor(DividerAttributes.class);
                Method method0 = DividerAttributes.Builder.class.getMethod("setWidthDp", class0);
                Class class1 = Float.TYPE;
                Method method1 = DividerAttributes.Builder.class.getMethod("setPrimaryMinRatio", class1);
                Method method2 = DividerAttributes.Builder.class.getMethod("setPrimaryMaxRatio", class1);
                Method method3 = DividerAttributes.Builder.class.getMethod("setDividerColor", class0);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(constructor0);
                if(reflectionUtils0.isPublic$window_release(constructor0)) {
                    q.d(constructor1);
                    if(reflectionUtils0.isPublic$window_release(constructor1)) {
                        q.d(method0);
                        if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, DividerAttributes.Builder.class)) {
                            q.d(method1);
                            if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, DividerAttributes.Builder.class)) {
                                q.d(method2);
                                if(reflectionUtils0.isPublic$window_release(method2) && reflectionUtils0.doesReturn$window_release(method2, DividerAttributes.Builder.class)) {
                                    q.d(method3);
                                    return !reflectionUtils0.isPublic$window_release(method3) || !reflectionUtils0.doesReturn$window_release(method3, DividerAttributes.Builder.class) ? false : true;
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class DividerAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = DividerAttributes.class.getMethod("getDividerType", null);
                Method method1 = DividerAttributes.class.getMethod("getWidthDp", null);
                Method method2 = DividerAttributes.class.getMethod("getPrimaryMinRatio", null);
                Method method3 = DividerAttributes.class.getMethod("getPrimaryMaxRatio", null);
                Method method4 = DividerAttributes.class.getMethod("getDividerColor", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0)) {
                    Class class0 = Integer.TYPE;
                    if(reflectionUtils0.doesReturn$window_release(method0, class0)) {
                        q.d(method1);
                        if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, class0)) {
                            q.d(method2);
                            if(reflectionUtils0.isPublic$window_release(method2)) {
                                Class class1 = Float.TYPE;
                                if(reflectionUtils0.doesReturn$window_release(method2, class1)) {
                                    q.d(method3);
                                    if(reflectionUtils0.isPublic$window_release(method3) && reflectionUtils0.doesReturn$window_release(method3, class1)) {
                                        q.d(method4);
                                        return !reflectionUtils0.isPublic$window_release(method4) || !reflectionUtils0.doesReturn$window_release(method4, class0) ? false : true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassEmbeddedActivityWindowInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class EmbeddedActivityWindowInfo is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = EmbeddedActivityWindowInfo.class.getMethod("getActivity", null);
                Method method1 = EmbeddedActivityWindowInfo.class.getMethod("isEmbedded", null);
                Method method2 = EmbeddedActivityWindowInfo.class.getMethod("getTaskBounds", null);
                Method method3 = EmbeddedActivityWindowInfo.class.getMethod("getActivityStackBounds", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, Activity.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, Boolean.TYPE)) {
                        q.d(method2);
                        if(reflectionUtils0.isPublic$window_release(method2)) {
                            Class class0 = Rect.class;
                            if(reflectionUtils0.doesReturn$window_release(method2, class0)) {
                                q.d(method3);
                                return !reflectionUtils0.isPublic$window_release(method3) || !reflectionUtils0.doesReturn$window_release(method3, class0) ? false : true;
                            }
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassEmbeddingRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class EmbeddingRule is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = EmbeddingRule.class.getMethod("getTag", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, String.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassParentContainerInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ParentContainerInfo is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = ParentContainerInfo.class.getMethod("getWindowMetrics", null);
                Method method1 = ParentContainerInfo.class.getMethod("getConfiguration", null);
                Method method2 = ParentContainerInfo.class.getMethod("getWindowLayoutInfo", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, WindowMetrics.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, Configuration.class)) {
                        q.d(method2);
                        return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, WindowLayoutInfo.class) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitAttributesCalculatorParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributesCalculatorParams is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitAttributesCalculatorParams.class.getMethod("getParentWindowMetrics", null);
                Method method1 = SplitAttributesCalculatorParams.class.getMethod("getParentConfiguration", null);
                Method method2 = SplitAttributesCalculatorParams.class.getMethod("getDefaultSplitAttributes", null);
                Method method3 = SplitAttributesCalculatorParams.class.getMethod("areDefaultConstraintsSatisfied", null);
                Method method4 = SplitAttributesCalculatorParams.class.getMethod("getParentWindowLayoutInfo", null);
                Method method5 = SplitAttributesCalculatorParams.class.getMethod("getSplitRuleTag", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, WindowMetrics.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, Configuration.class)) {
                        q.d(method2);
                        if(reflectionUtils0.isPublic$window_release(method2) && reflectionUtils0.doesReturn$window_release(method2, SplitAttributes.class)) {
                            q.d(method3);
                            if(reflectionUtils0.isPublic$window_release(method3) && reflectionUtils0.doesReturn$window_release(method3, Boolean.TYPE)) {
                                q.d(method4);
                                if(reflectionUtils0.isPublic$window_release(method4) && reflectionUtils0.doesReturn$window_release(method4, WindowLayoutInfo.class)) {
                                    q.d(method5);
                                    return !reflectionUtils0.isPublic$window_release(method5) || !reflectionUtils0.doesReturn$window_release(method5, String.class) ? false : true;
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitAttributes.class.getMethod("getLayoutDirection", null);
                Method method1 = SplitAttributes.class.getMethod("getSplitType", null);
                Method method2 = SplitAttributes.Builder.class.getMethod("setSplitType", SplitAttributes.SplitType.class);
                Class class0 = Integer.TYPE;
                Method method3 = SplitAttributes.Builder.class.getMethod("setLayoutDirection", class0);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, class0)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, SplitAttributes.SplitType.class)) {
                        q.d(method2);
                        if(reflectionUtils0.isPublic$window_release(method2)) {
                            q.d(method3);
                            return reflectionUtils0.isPublic$window_release(method3);
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitInfoTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo.Token is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitInfo.Token.class.getMethod("createFromBinder", IBinder.class);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SplitInfo.Token.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitInfo is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitInfo.class.getMethod("getPrimaryActivityStack", null);
                Method method1 = SplitInfo.class.getMethod("getSecondaryActivityStack", null);
                Method method2 = SplitInfo.class.getMethod("getSplitRatio", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, ActivityStack.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, ActivityStack.class)) {
                        q.d(method2);
                        return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, Float.TYPE) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitPairRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitPairRule.Builder.class.getMethod("setSplitRatio", Float.TYPE);
                Method method1 = SplitPairRule.Builder.class.getMethod("setLayoutDirection", Integer.TYPE);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, SplitPairRule.Builder.class)) {
                    q.d(method1);
                    return !reflectionUtils0.isPublic$window_release(method1) || !reflectionUtils0.doesReturn$window_release(method1, SplitPairRule.Builder.class) ? false : true;
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitPairRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Constructor constructor0 = SplitPairRule.Builder.class.getDeclaredConstructor(Predicate.class, Predicate.class, Predicate.class);
                Method method0 = SplitPairRule.Builder.class.getMethod("setDefaultSplitAttributes", SplitAttributes.class);
                Method method1 = SplitPairRule.Builder.class.getMethod("setTag", String.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(constructor0);
                if(reflectionUtils0.isPublic$window_release(constructor0)) {
                    q.d(method0);
                    if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, SplitPairRule.Builder.class)) {
                        q.d(method1);
                        return !reflectionUtils0.isPublic$window_release(method1) || !reflectionUtils0.doesReturn$window_release(method1, SplitPairRule.Builder.class) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitPairRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitPairRule.class.getMethod("getFinishPrimaryWithSecondary", null);
                Method method1 = SplitPairRule.class.getMethod("getFinishSecondaryWithPrimary", null);
                Method method2 = SplitPairRule.class.getMethod("shouldClearTop", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0)) {
                    Class class0 = Integer.TYPE;
                    if(reflectionUtils0.doesReturn$window_release(method0, class0)) {
                        q.d(method1);
                        if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, class0)) {
                            q.d(method2);
                            return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, Boolean.TYPE) ? false : true;
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitPlaceholderRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitPlaceholderRule.Builder.class.getMethod("setSplitRatio", Float.TYPE);
                Class class0 = Integer.TYPE;
                Method method1 = SplitPlaceholderRule.Builder.class.getMethod("setLayoutDirection", class0);
                Method method2 = SplitPlaceholderRule.Builder.class.getMethod("setSticky", Boolean.TYPE);
                Method method3 = SplitPlaceholderRule.Builder.class.getMethod("setFinishPrimaryWithSecondary", class0);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, SplitPlaceholderRule.Builder.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, SplitPlaceholderRule.Builder.class)) {
                        q.d(method2);
                        if(reflectionUtils0.isPublic$window_release(method2) && reflectionUtils0.doesReturn$window_release(method2, SplitPlaceholderRule.Builder.class)) {
                            q.d(method3);
                            return !reflectionUtils0.isPublic$window_release(method3) || !reflectionUtils0.doesReturn$window_release(method3, SplitPlaceholderRule.Builder.class) ? false : true;
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitPlaceholderRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule.Builder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Constructor constructor0 = SplitPlaceholderRule.Builder.class.getDeclaredConstructor(Intent.class, Predicate.class, Predicate.class, Predicate.class);
                Method method0 = SplitPlaceholderRule.Builder.class.getMethod("setDefaultSplitAttributes", SplitAttributes.class);
                Method method1 = SplitPlaceholderRule.Builder.class.getMethod("setFinishPrimaryWithPlaceholder", Integer.TYPE);
                Method method2 = SplitPlaceholderRule.Builder.class.getMethod("setTag", String.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(constructor0);
                if(reflectionUtils0.isPublic$window_release(constructor0)) {
                    q.d(method0);
                    if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, SplitPlaceholderRule.Builder.class)) {
                        q.d(method1);
                        if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, SplitPlaceholderRule.Builder.class)) {
                            q.d(method2);
                            return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, SplitPlaceholderRule.Builder.class) ? false : true;
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitPlaceholderRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitPlaceholderRule.class.getMethod("getPlaceholderIntent", null);
                Method method1 = SplitPlaceholderRule.class.getMethod("isSticky", null);
                Method method2 = SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithSecondary", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, Intent.class)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, Boolean.TYPE)) {
                        q.d(method2);
                        return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, Integer.TYPE) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassSplitTypeValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes.SplitType is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = Float.TYPE;
                Constructor constructor0 = SplitAttributes.SplitType.RatioSplitType.class.getDeclaredConstructor(class0);
                Method method0 = SplitAttributes.SplitType.RatioSplitType.class.getMethod("getRatio", null);
                Method method1 = SplitAttributes.SplitType.RatioSplitType.class.getMethod("splitEqually", null);
                Constructor constructor1 = SplitAttributes.SplitType.HingeSplitType.class.getDeclaredConstructor(SplitAttributes.SplitType.class);
                Method method2 = SplitAttributes.SplitType.HingeSplitType.class.getMethod("getFallbackSplitType", null);
                Constructor constructor2 = SplitAttributes.SplitType.ExpandContainersSplitType.class.getDeclaredConstructor(null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(constructor0);
                if(reflectionUtils0.isPublic$window_release(constructor0)) {
                    q.d(method0);
                    if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, class0)) {
                        q.d(constructor1);
                        if(reflectionUtils0.isPublic$window_release(constructor1)) {
                            q.d(method1);
                            if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, SplitAttributes.SplitType.RatioSplitType.class)) {
                                q.d(method2);
                                if(reflectionUtils0.isPublic$window_release(method2) && reflectionUtils0.doesReturn$window_release(method2, SplitAttributes.SplitType.class)) {
                                    q.d(constructor2);
                                    return reflectionUtils0.isPublic$window_release(constructor2);
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isClassWindowAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class WindowAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = WindowAttributes.class;
                Method method0 = class0.getMethod("getDimAreaBehavior", null);
                Method method1 = SplitAttributes.class.getMethod("getWindowAttributes", null);
                Method method2 = SplitAttributes.Builder.class.getMethod("setWindowAttributes", WindowAttributes.class);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0) && reflectionUtils0.doesReturn$window_release(method0, Integer.TYPE)) {
                    q.d(method1);
                    if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, class0)) {
                        q.d(method2);
                        return !reflectionUtils0.isPublic$window_release(method2) || !reflectionUtils0.doesReturn$window_release(method2, SplitAttributes.Builder.class) ? false : true;
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodClearActivityStackAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("clearActivityStackAttributesCalculator is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearActivityStackAttributesCalculator", null);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodClearEmbeddedActivityWindowInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearEmbeddedActivityWindowInfoCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearEmbeddedActivityWindowInfoCallback", null);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodClearSplitInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearSplitInfoCallback", null);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodGetActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("getActivityStackToken is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("getActivityStackToken", String.class);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, ActivityStack.Token.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodGetDefaultSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getDefaultSplitAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitRule.class.getMethod("getDefaultSplitAttributes", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SplitAttributes.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodGetDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#getDividerAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitAttributes.class.getMethod("getDividerAttributes", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, DividerAttributes.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodGetEmbeddedActivityWindowInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("getEmbeddedActivityWindowInfo", Activity.class);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, EmbeddedActivityWindowInfo.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodGetFinishPrimaryWithPlaceholderValid() {
        return ReflectionUtils.validateReflection$window_release("SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithPlaceholder", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, Integer.TYPE) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodGetLayoutDirectionValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getLayoutDirection is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitRule.class.getMethod("getLayoutDirection", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, Integer.TYPE) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodGetParentContainerInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#getParentContainerInfo is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("getParentContainerInfo", ActivityStack.Token.class);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, ParentContainerInfo.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodGetSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitInfo.class.getMethod("getSplitAttributes", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SplitAttributes.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodGetSplitInfoTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitInfoToken is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitInfo.class.getMethod("getSplitInfoToken", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SplitInfo.Token.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodGetSplitRatioValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getSplitRatio is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitRule.class.getMethod("getSplitRatio", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, Float.TYPE) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodInvalidateTopVisibleSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("#invalidateTopVisibleSplitAttributes is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("invalidateTopVisibleSplitAttributes", null);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodIsActivityEmbeddedValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("isActivityEmbedded", Activity.class);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, Boolean.TYPE) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodPinUnpinTopActivityStackValid() {
        return ReflectionUtils.validateReflection$window_release("#pin(unPin)TopActivityStack is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitPinRule.class.getMethod("isSticky", null);
                Class class0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass();
                Class class1 = Integer.TYPE;
                Method method1 = class0.getMethod("pinTopActivityStack", class1, SplitPinRule.class);
                Method method2 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("unpinTopActivityStack", class1);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0)) {
                    Class class2 = Boolean.TYPE;
                    if(reflectionUtils0.doesReturn$window_release(method0, class2)) {
                        q.d(method1);
                        if(reflectionUtils0.isPublic$window_release(method1) && reflectionUtils0.doesReturn$window_release(method1, class2)) {
                            q.d(method2);
                            return reflectionUtils0.isPublic$window_release(method2);
                        }
                    }
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodRegisterActivityStackCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("registerActivityStackCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("registerActivityStackCallback", Executor.class, Consumer.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSetActivityStackAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("setActivityStackAttributesCalculator is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setActivityStackAttributesCalculator", Function.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSetDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#setDividerAttributes is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitAttributes.Builder.class.getMethod("setDividerAttributes", DividerAttributes.class);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SplitAttributes.Builder.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodSetEmbeddedActivityWindowInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setEmbeddedActivityWindowInfoCallback", Executor.class, Consumer.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSetEmbeddingRulesValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setEmbeddingRules", Set.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSetSplitInfoCallbackJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Class class0 = SafeActivityEmbeddingComponentProvider.this.consumerAdapter.consumerClassOrNull$window_release();
                if(class0 == null) {
                    return false;
                }
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", class0);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSetSplitInfoCallbackWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", Consumer.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSplitAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitAttributesCalculator", Function.class);
                Method method1 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearSplitAttributesCalculator", null);
                ReflectionUtils reflectionUtils0 = ReflectionUtils.INSTANCE;
                q.d(method0);
                if(reflectionUtils0.isPublic$window_release(method0)) {
                    q.d(method1);
                    return reflectionUtils0.isPublic$window_release(method1);
                }
                return false;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodSplitInfoGetTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getToken is not valid", androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid.1.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid.1 extends r implements a {
            public static final androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid.1 INSTANCE;

            static {
                androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid.1.INSTANCE = new androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid.1();
            }

            public androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid.1() {
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SplitInfo.class.getMethod("getToken", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, IBinder.class) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    private final boolean isMethodUnregisterActivityStackCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("unregisterActivityStackCallback is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("unregisterActivityStackCallback", Consumer.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodUpdateActivityStackAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("updateActivityStackAttributes is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("updateActivityStackAttributes", ActivityStack.Token.class, ActivityStackAttributes.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodUpdateSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("#updateSplitAttributes is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("updateSplitAttributes", IBinder.class, SplitAttributes.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    private final boolean isMethodUpdateSplitAttributesWithTokenValid() {
        return ReflectionUtils.validateReflection$window_release("updateSplitAttributes is not valid", new a() {
            {
                SafeActivityEmbeddingComponentProvider.this = safeActivityEmbeddingComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("updateSplitAttributes", SplitInfo.Token.class, SplitAttributes.class);
                q.d(method0);
                return Boolean.valueOf(ReflectionUtils.INSTANCE.isPublic$window_release(method0));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    // 去混淆评级： 中等(100)
    private final boolean isOverlayFeatureValid() {
        return this.isActivityStackGetTagValid() && this.isMethodGetActivityStackTokenValid() && this.isClassParentContainerInfoValid() && this.isMethodGetParentContainerInfoValid() && this.isMethodSetActivityStackAttributesCalculatorValid() && this.isMethodClearActivityStackAttributesCalculatorValid() && this.isMethodUpdateActivityStackAttributesValid() && this.isClassActivityStackAttributesValid() && this.isClassActivityStackAttributesBuilderValid() && this.isClassActivityStackAttributesCalculatorParamsValid();
    }
}

