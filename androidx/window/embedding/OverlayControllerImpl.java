package androidx.window.embedding;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.WindowMetrics;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityStack.Token;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.ActivityStackAttributes.Builder;
import androidx.window.extensions.embedding.ActivityStackAttributes;
import androidx.window.extensions.embedding.ActivityStackAttributesCalculatorParams;
import androidx.window.extensions.embedding.ParentContainerInfo;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter;
import androidx.window.layout.util.DensityCompatHelper;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import je.C;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@RequiresWindowSdkExtension(version = 8)
@Metadata(d1 = {"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u001B\u0010\u0012\u001A\u00020\u0011*\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014*\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001A\u00020\u0018*\u00020\u0015H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ9\u0010%\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\t2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010\"\u001A\u00020!H\u0001\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010)\u001A\u0004\u0018\u00010\u000E2\u0006\u0010&\u001A\u00020\tH\u0011\u00A2\u0006\u0004\b\'\u0010(J\u001F\u0010-\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020\t2\u0006\u0010*\u001A\u00020\u000EH\u0010\u00A2\u0006\u0004\b+\u0010,J-\u00102\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020\t2\u0006\u0010/\u001A\u00020.2\f\u00101\u001A\b\u0012\u0004\u0012\u00020\u001800H\u0016\u00A2\u0006\u0004\b2\u00103J\u001D\u00104\u001A\u00020\u000B2\f\u00101\u001A\b\u0012\u0004\u0012\u00020\u001800H\u0016\u00A2\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00106R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u00107R\u0014\u00109\u001A\u0002088\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010:RF\u0010>\u001A\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000E\u0018\u00010;2\u0014\u0010=\u001A\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000E\u0018\u00010;8@@@X\u0081\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010E\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0D8\u0002X\u0083\u0004\u00A2\u0006\u0006\n\u0004\bE\u0010FR \u0010H\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0G8\u0002X\u0083\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010IR \u0010J\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150G8\u0002X\u0083\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010IR2\u0010L\u001A \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001800\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140K0G8\u0002X\u0083\u0004\u00A2\u0006\u0006\n\u0004\bL\u0010I\u00A8\u0006M"}, d2 = {"Landroidx/window/embedding/OverlayControllerImpl;", "", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "embeddingExtension", "Landroidx/window/embedding/EmbeddingAdapter;", "adapter", "<init>", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;Landroidx/window/embedding/EmbeddingAdapter;)V", "", "", "lastOverlayTags", "Lie/H;", "cleanUpDismissedOverlayContainerRecords", "(Ljava/util/Set;)V", "Landroidx/window/embedding/OverlayAttributes;", "Landroidx/window/extensions/embedding/ParentContainerInfo;", "parentContainerInfo", "Landroidx/window/extensions/embedding/ActivityStackAttributes;", "toActivityStackAttributes", "(Landroidx/window/embedding/OverlayAttributes;Landroidx/window/extensions/embedding/ParentContainerInfo;)Landroidx/window/extensions/embedding/ActivityStackAttributes;", "", "Landroidx/window/extensions/embedding/ActivityStack;", "getOverlayContainers", "(Ljava/util/List;)Ljava/util/List;", "Landroidx/window/embedding/OverlayInfo;", "toOverlayInfo", "(Landroidx/window/extensions/embedding/ActivityStack;)Landroidx/window/embedding/OverlayInfo;", "tag", "initialOverlayAttrs", "Landroidx/window/layout/WindowMetrics;", "windowMetrics", "Landroid/content/res/Configuration;", "configuration", "Landroidx/window/layout/WindowLayoutInfo;", "windowLayoutInfo", "calculateOverlayAttributes$window_release", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;Landroidx/window/layout/WindowMetrics;Landroid/content/res/Configuration;Landroidx/window/layout/WindowLayoutInfo;)Landroidx/window/embedding/OverlayAttributes;", "calculateOverlayAttributes", "overlayTag", "getUpdatedOverlayAttributes$window_release", "(Ljava/lang/String;)Landroidx/window/embedding/OverlayAttributes;", "getUpdatedOverlayAttributes", "overlayAttributes", "updateOverlayAttributes$window_release", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "updateOverlayAttributes", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "overlayInfoCallback", "addOverlayInfoCallback", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Lb2/a;)V", "removeOverlayInfoCallback", "(Lb2/a;)V", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "Landroidx/window/embedding/EmbeddingAdapter;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlin/Function1;", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "value", "overlayAttributesCalculator", "Lwe/k;", "getOverlayAttributesCalculator$window_release", "()Lwe/k;", "setOverlayAttributesCalculator$window_release", "(Lwe/k;)V", "", "overlayTagToDefaultAttributesMap", "Ljava/util/Map;", "Landroid/util/ArrayMap;", "overlayTagToCurrentAttributesMap", "Landroid/util/ArrayMap;", "overlayTagToContainerMap", "Landroidx/window/extensions/core/util/function/Consumer;", "overlayInfoToActivityStackCallbackMap", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public class OverlayControllerImpl {
    @NotNull
    private final EmbeddingAdapter adapter;
    @NotNull
    private final ActivityEmbeddingComponent embeddingExtension;
    @NotNull
    private final ReentrantLock globalLock;
    @Nullable
    private k overlayAttributesCalculator;
    @NotNull
    private final ArrayMap overlayInfoToActivityStackCallbackMap;
    @NotNull
    private final ArrayMap overlayTagToContainerMap;
    @NotNull
    private final ArrayMap overlayTagToCurrentAttributesMap;
    @NotNull
    private final Map overlayTagToDefaultAttributesMap;

    public OverlayControllerImpl(@NotNull ActivityEmbeddingComponent activityEmbeddingComponent0, @NotNull EmbeddingAdapter embeddingAdapter0) {
        q.g(activityEmbeddingComponent0, "embeddingExtension");
        q.g(embeddingAdapter0, "adapter");
        super();
        this.embeddingExtension = activityEmbeddingComponent0;
        this.adapter = embeddingAdapter0;
        this.globalLock = new ReentrantLock();
        this.overlayTagToDefaultAttributesMap = new ArrayMap();
        this.overlayTagToCurrentAttributesMap = new ArrayMap();
        this.overlayTagToContainerMap = new ArrayMap();
        this.overlayInfoToActivityStackCallbackMap = new ArrayMap();
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(8);
        activityEmbeddingComponent0.setActivityStackAttributesCalculator(new i());  // 初始化器: Ljava/lang/Object;-><init>()V
        OverlayControllerActivityStackConsumer overlayControllerActivityStackConsumer0 = new OverlayControllerActivityStackConsumer(new k() {
            {
                OverlayControllerImpl.this = overlayControllerImpl0;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((List)object0));
                return H.a;
            }

            public final void invoke(List list0) {
                q.g(list0, "activityStacks");
                ReentrantLock reentrantLock0 = OverlayControllerImpl.this.globalLock;
                OverlayControllerImpl overlayControllerImpl0 = OverlayControllerImpl.this;
                reentrantLock0.lock();
                try {
                    Set set0 = overlayControllerImpl0.overlayTagToContainerMap.keySet();
                    q.f(set0, "<get-keys>(...)");
                    overlayControllerImpl0.overlayTagToContainerMap.clear();
                    ArrayMap arrayMap0 = overlayControllerImpl0.overlayTagToContainerMap;
                    Iterable iterable0 = overlayControllerImpl0.getOverlayContainers(list0);
                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                    for(Object object0: iterable0) {
                        String s = ((ActivityStack)object0).getTag();
                        q.d(s);
                        arrayList0.add(new m(s, ((ActivityStack)object0)));
                    }
                    C.W(arrayMap0, arrayList0);
                    overlayControllerImpl0.cleanUpDismissedOverlayContainerRecords(set0);
                }
                finally {
                    reentrantLock0.unlock();
                }
            }
        });
        activityEmbeddingComponent0.registerActivityStackCallback(new a(1), overlayControllerActivityStackConsumer0);
    }

    private static final ActivityStackAttributes _init_$lambda$3(OverlayControllerImpl overlayControllerImpl0, ActivityStackAttributesCalculatorParams activityStackAttributesCalculatorParams0) {
        overlayControllerImpl0.globalLock.lock();
        try {
            ParentContainerInfo parentContainerInfo0 = activityStackAttributesCalculatorParams0.getParentContainerInfo();
            q.f(parentContainerInfo0, "getParentContainerInfo(...)");
            DensityCompatHelper densityCompatHelper0 = DensityCompatHelper.Companion.getInstance();
            Configuration configuration0 = parentContainerInfo0.getConfiguration();
            q.f(configuration0, "getConfiguration(...)");
            WindowMetrics windowMetrics0 = parentContainerInfo0.getWindowMetrics();
            q.f(windowMetrics0, "getWindowMetrics(...)");
            float f = densityCompatHelper0.density(configuration0, windowMetrics0);
            WindowMetrics windowMetrics1 = parentContainerInfo0.getWindowMetrics();
            q.f(windowMetrics1, "getWindowMetrics(...)");
            androidx.window.layout.WindowMetrics windowMetrics2 = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(windowMetrics1, f);
            String s = activityStackAttributesCalculatorParams0.getActivityStackTag();
            q.f(s, "getActivityStackTag(...)");
            Bundle bundle0 = activityStackAttributesCalculatorParams0.getLaunchOptions();
            q.f(bundle0, "getLaunchOptions(...)");
            OverlayAttributes overlayAttributes0 = ActivityEmbeddingOptionsImpl.INSTANCE.getOverlayAttributes$window_release(bundle0);
            WindowMetrics windowMetrics3 = activityStackAttributesCalculatorParams0.getParentContainerInfo().getWindowMetrics();
            q.f(windowMetrics3, "getWindowMetrics(...)");
            androidx.window.layout.WindowMetrics windowMetrics4 = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(windowMetrics3, f);
            Configuration configuration1 = activityStackAttributesCalculatorParams0.getParentContainerInfo().getConfiguration();
            q.f(configuration1, "getConfiguration(...)");
            WindowLayoutInfo windowLayoutInfo0 = parentContainerInfo0.getWindowLayoutInfo();
            q.f(windowLayoutInfo0, "getWindowLayoutInfo(...)");
            OverlayAttributes overlayAttributes1 = overlayControllerImpl0.calculateOverlayAttributes$window_release(s, overlayAttributes0, windowMetrics4, configuration1, ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(windowMetrics2, windowLayoutInfo0));
            Bundle bundle1 = activityStackAttributesCalculatorParams0.getLaunchOptions();
            q.f(bundle1, "getLaunchOptions(...)");
            ActivityEmbeddingOptionsImpl.INSTANCE.putActivityStackAlignment$window_release(bundle1, overlayAttributes1.getBounds());
            return overlayControllerImpl0.toActivityStackAttributes(overlayAttributes1, parentContainerInfo0);
        }
        finally {
            overlayControllerImpl0.globalLock.unlock();
        }
    }

    public void addOverlayInfoCallback(@NotNull String s, @NotNull Executor executor0, @NotNull b2.a a0) {
        q.g(s, "overlayTag");
        q.g(executor0, "executor");
        q.g(a0, "overlayInfoCallback");
        this.globalLock.lock();
        try {
            androidx.window.embedding.k k0 = new androidx.window.embedding.k(s, this, a0);
            this.overlayInfoToActivityStackCallbackMap.put(a0, k0);
            this.embeddingExtension.registerActivityStackCallback(executor0, k0);
        }
        finally {
            this.globalLock.unlock();
        }
    }

    private static final void addOverlayInfoCallback$lambda$8$lambda$7(String s, OverlayControllerImpl overlayControllerImpl0, b2.a a0, List list0) {
        q.g(list0, "activityStacks");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(q.b(((ActivityStack)object0).getTag(), s)) {
                arrayList0.add(object0);
            }
        }
        if(arrayList0.size() > 1) {
            throw new IllegalStateException("There must be at most one overlay ActivityStack with " + s);
        }
        a0.accept((arrayList0.isEmpty() ? new OverlayInfo(s, null, null) : overlayControllerImpl0.toOverlayInfo(((ActivityStack)p.k0(arrayList0)))));
    }

    @NotNull
    public final OverlayAttributes calculateOverlayAttributes$window_release(@NotNull String s, @Nullable OverlayAttributes overlayAttributes0, @NotNull androidx.window.layout.WindowMetrics windowMetrics0, @NotNull Configuration configuration0, @NotNull androidx.window.layout.WindowLayoutInfo windowLayoutInfo0) {
        OverlayAttributes overlayAttributes2;
        q.g(s, "tag");
        q.g(windowMetrics0, "windowMetrics");
        q.g(configuration0, "configuration");
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        OverlayAttributes overlayAttributes1 = this.getUpdatedOverlayAttributes$window_release(s);
        if(overlayAttributes1 == null) {
            if(overlayAttributes0 == null) {
                throw new IllegalArgumentException("Can\'t retrieve overlay attributes from launch options");
            }
            overlayAttributes2 = overlayAttributes0;
        }
        else {
            overlayAttributes2 = overlayAttributes1;
        }
        k k0 = this.getOverlayAttributesCalculator$window_release();
        if(k0 != null) {
            OverlayAttributes overlayAttributes3 = (OverlayAttributes)k0.invoke(new OverlayAttributesCalculatorParams(windowMetrics0, configuration0, windowLayoutInfo0, s, overlayAttributes2));
            if(overlayAttributes3 != null) {
                overlayAttributes2 = overlayAttributes3;
            }
        }
        this.overlayTagToCurrentAttributesMap.put(s, overlayAttributes2);
        return overlayAttributes2;
    }

    private final void cleanUpDismissedOverlayContainerRecords(Set set0) {
        if(!set0.isEmpty()) {
            ArrayList arrayList0 = new ArrayList();
            Set set1 = this.overlayTagToContainerMap.keySet();
            q.f(set1, "<get-keys>(...)");
            for(Object object0: set0) {
                String s = (String)object0;
                if(!set1.contains(s) && this.embeddingExtension.getActivityStackToken(s) == null) {
                    arrayList0.add(s);
                }
            }
            for(Object object1: arrayList0) {
                this.overlayTagToDefaultAttributesMap.remove(((String)object1));
                this.overlayTagToCurrentAttributesMap.remove(((String)object1));
            }
        }
    }

    @Nullable
    public final k getOverlayAttributesCalculator$window_release() {
        this.globalLock.lock();
        k k0 = this.overlayAttributesCalculator;
        this.globalLock.unlock();
        return k0;
    }

    private final List getOverlayContainers(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(((ActivityStack)object0).getTag() != null) {
                arrayList0.add(object0);
            }
        }
        return p.P0(arrayList0);
    }

    @Nullable
    public OverlayAttributes getUpdatedOverlayAttributes$window_release(@NotNull String s) {
        q.g(s, "overlayTag");
        return (OverlayAttributes)this.overlayTagToDefaultAttributesMap.get(s);
    }

    public void removeOverlayInfoCallback(@NotNull b2.a a0) {
        q.g(a0, "overlayInfoCallback");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            Consumer consumer0 = (Consumer)this.overlayInfoToActivityStackCallbackMap.remove(a0);
            if(consumer0 != null) {
                this.embeddingExtension.unregisterActivityStackCallback(consumer0);
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void setOverlayAttributesCalculator$window_release(@Nullable k k0) {
        this.globalLock.lock();
        this.overlayAttributesCalculator = k0;
        this.globalLock.unlock();
    }

    private final ActivityStackAttributes toActivityStackAttributes(OverlayAttributes overlayAttributes0, ParentContainerInfo parentContainerInfo0) {
        ActivityStackAttributes.Builder activityStackAttributes$Builder0 = new ActivityStackAttributes.Builder();
        androidx.window.embedding.ParentContainerInfo parentContainerInfo1 = this.adapter.translate$window_release(parentContainerInfo0);
        ActivityStackAttributes activityStackAttributes0 = activityStackAttributes$Builder0.setRelativeBounds(EmbeddingBounds.Companion.translateEmbeddingBounds$window_release(overlayAttributes0.getBounds(), parentContainerInfo1).toRect()).setWindowAttributes(this.adapter.translateWindowAttributes$window_release()).build();
        q.f(activityStackAttributes0, "build(...)");
        return activityStackAttributes0;
    }

    private final OverlayInfo toOverlayInfo(ActivityStack activityStack0) {
        String s = activityStack0.getTag();
        q.d(s);
        String s1 = activityStack0.getTag();
        q.d(s1);
        return new OverlayInfo(s, ((OverlayAttributes)this.overlayTagToCurrentAttributesMap.get(s1)), this.adapter.translate$window_release(activityStack0));
    }

    public void updateOverlayAttributes$window_release(@NotNull String s, @NotNull OverlayAttributes overlayAttributes0) {
        ActivityStack.Token activityStack$Token0;
        q.g(s, "overlayTag");
        q.g(overlayAttributes0, "overlayAttributes");
        ReentrantLock reentrantLock0 = this.globalLock;
        reentrantLock0.lock();
        try {
            ActivityStack activityStack0 = (ActivityStack)this.overlayTagToContainerMap.get(s);
            if(activityStack0 != null) {
                activityStack$Token0 = activityStack0.getActivityStackToken();
                if(activityStack$Token0 == null) {
                    goto label_8;
                }
                goto label_10;
            }
        label_8:
            activityStack$Token0 = this.embeddingExtension.getActivityStackToken(s);
            if(activityStack$Token0 != null) {
            label_10:
                ParentContainerInfo parentContainerInfo0 = this.embeddingExtension.getParentContainerInfo(activityStack$Token0);
                q.d(parentContainerInfo0);
                ActivityStackAttributes activityStackAttributes0 = this.toActivityStackAttributes(overlayAttributes0, parentContainerInfo0);
                this.embeddingExtension.updateActivityStackAttributes(activityStack$Token0, activityStackAttributes0);
                this.overlayTagToDefaultAttributesMap.put(s, overlayAttributes0);
                this.overlayTagToCurrentAttributesMap.put(s, overlayAttributes0);
                goto label_20;
            }
            goto label_22;
        }
        catch(Throwable throwable0) {
        }
        reentrantLock0.unlock();
        throw throwable0;
    label_20:
        reentrantLock0.unlock();
        return;
    label_22:
        reentrantLock0.unlock();
    }
}

