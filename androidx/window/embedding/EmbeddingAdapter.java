package androidx.window.embedding;

import De.d;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.Bounds;
import androidx.window.core.PredicateAdapter;
import androidx.window.extensions.embedding.ActivityRule.Builder;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.AnimationBackground.ColorBackground;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.DividerAttributes.Builder;
import androidx.window.extensions.embedding.EmbeddingRule;
import androidx.window.extensions.embedding.SplitAttributes.Builder;
import androidx.window.extensions.embedding.SplitAttributes.SplitType.ExpandContainersSplitType;
import androidx.window.extensions.embedding.SplitAttributes.SplitType.HingeSplitType;
import androidx.window.extensions.embedding.SplitAttributes.SplitType.RatioSplitType;
import androidx.window.extensions.embedding.SplitAttributes.SplitType;
import androidx.window.extensions.embedding.SplitInfo.Token;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule.Builder;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule.Builder;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule.Builder;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.reflection.JFunction2;
import ie.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import je.n;
import je.p;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u008E\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 r2\u00020\u0001:\u0004rstuB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\n\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010J#\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00062\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u0006H\u0000\u00A2\u0006\u0004\b\u000F\u0010\u000BJ\u0017\u0010\n\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u0012H\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0015J\u0017\u0010\n\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u0016H\u0001\u00A2\u0006\u0004\b\u000F\u0010\u0019J-\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u00120\u001D2\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00140\u001A\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010\n\u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b\n\u0010\"J\u001D\u0010(\u001A\u00020\'2\u0006\u0010$\u001A\u00020#2\u0006\u0010&\u001A\u00020%\u00A2\u0006\u0004\b(\u0010)J\u0015\u0010*\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010/\u001A\u00020,H\u0000\u00A2\u0006\u0004\b-\u0010.J\u0015\u00103\u001A\u0002022\u0006\u00101\u001A\u000200\u00A2\u0006\u0004\b3\u00104J)\u0010\n\u001A\b\u0012\u0004\u0012\u000208052\u0006\u0010$\u001A\u00020#2\f\u00107\u001A\b\u0012\u0004\u0012\u00020605\u00A2\u0006\u0004\b\n\u00109J\u0019\u0010=\u001A\u0004\u0018\u00010<2\u0006\u0010;\u001A\u00020:H\u0007\u00A2\u0006\u0004\b=\u0010>J\u0019\u0010=\u001A\u00020:2\b\u0010?\u001A\u0004\u0018\u00010<H\u0007\u00A2\u0006\u0004\b=\u0010@J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010A\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\n\u0010BJ+\u0010H\u001A\u00020G2\u0006\u0010$\u001A\u00020#2\u0006\u0010D\u001A\u00020C2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030EH\u0002\u00A2\u0006\u0004\bH\u0010IJ\u0017\u0010M\u001A\u00020L2\u0006\u0010K\u001A\u00020JH\u0002\u00A2\u0006\u0004\bM\u0010NJ+\u0010Q\u001A\u00020P2\u0006\u0010$\u001A\u00020#2\u0006\u0010D\u001A\u00020O2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030EH\u0002\u00A2\u0006\u0004\bQ\u0010RJ#\u0010U\u001A\u00020T2\u0006\u0010D\u001A\u00020S2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030EH\u0002\u00A2\u0006\u0004\bU\u0010VJ\u0017\u0010Z\u001A\u00020Y2\u0006\u0010X\u001A\u00020WH\u0002\u00A2\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010\\R\u0018\u0010^\u001A\u00060]R\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001A\u00060`R\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001A\u00060cR\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bd\u0010eR*\u0010g\u001A\u0004\u0018\u00010f8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0004\bg\u0010h\u0012\u0004\bm\u0010n\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010q\u001A\u0002028BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bo\u0010p\u00A8\u0006v"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "Landroidx/window/core/PredicateAdapter;", "predicateAdapter", "<init>", "(Landroidx/window/core/PredicateAdapter;)V", "", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfoList", "Landroidx/window/embedding/SplitInfo;", "translate", "(Ljava/util/List;)Ljava/util/List;", "Landroidx/window/extensions/embedding/ActivityStack;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "translate$window_release", "(Landroidx/window/extensions/embedding/ActivityStack;)Landroidx/window/embedding/ActivityStack;", "activityStacks", "Landroidx/window/extensions/embedding/SplitAttributes;", "splitAttributes", "Landroidx/window/embedding/SplitAttributes;", "(Landroidx/window/extensions/embedding/SplitAttributes;)Landroidx/window/embedding/SplitAttributes;", "Landroidx/window/extensions/embedding/ParentContainerInfo;", "parentContainerInfo", "Landroidx/window/embedding/ParentContainerInfo;", "(Landroidx/window/extensions/embedding/ParentContainerInfo;)Landroidx/window/embedding/ParentContainerInfo;", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "calculator", "Landroidx/window/reflection/JFunction2;", "Landroidx/window/extensions/embedding/SplitAttributesCalculatorParams;", "translateSplitAttributesCalculator", "(Lwe/k;)Landroidx/window/reflection/JFunction2;", "params", "(Landroidx/window/extensions/embedding/SplitAttributesCalculatorParams;)Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroid/content/Context;", "context", "Landroidx/window/embedding/SplitPinRule;", "splitPinRule", "Landroidx/window/extensions/embedding/SplitPinRule;", "translateSplitPinRule", "(Landroid/content/Context;Landroidx/window/embedding/SplitPinRule;)Landroidx/window/extensions/embedding/SplitPinRule;", "translateSplitAttributes", "(Landroidx/window/embedding/SplitAttributes;)Landroidx/window/extensions/embedding/SplitAttributes;", "Landroidx/window/extensions/embedding/WindowAttributes;", "translateWindowAttributes$window_release", "()Landroidx/window/extensions/embedding/WindowAttributes;", "translateWindowAttributes", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "behavior", "", "translateFinishBehavior", "(Landroidx/window/embedding/SplitRule$FinishBehavior;)I", "", "Landroidx/window/embedding/EmbeddingRule;", "rules", "Landroidx/window/extensions/embedding/EmbeddingRule;", "(Landroid/content/Context;Ljava/util/Set;)Ljava/util/Set;", "Landroidx/window/embedding/DividerAttributes;", "dividerAttributes", "Landroidx/window/extensions/embedding/DividerAttributes;", "translateDividerAttributes", "(Landroidx/window/embedding/DividerAttributes;)Landroidx/window/extensions/embedding/DividerAttributes;", "oemDividerAttributes", "(Landroidx/window/extensions/embedding/DividerAttributes;)Landroidx/window/embedding/DividerAttributes;", "splitInfo", "(Landroidx/window/extensions/embedding/SplitInfo;)Landroidx/window/embedding/SplitInfo;", "Landroidx/window/embedding/SplitPairRule;", "rule", "Ljava/lang/Class;", "predicateClass", "Landroidx/window/extensions/embedding/SplitPairRule;", "translateSplitPairRule", "(Landroid/content/Context;Landroidx/window/embedding/SplitPairRule;Ljava/lang/Class;)Landroidx/window/extensions/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitAttributes$SplitType;", "splitType", "Landroidx/window/extensions/embedding/SplitAttributes$SplitType;", "translateSplitType", "(Landroidx/window/embedding/SplitAttributes$SplitType;)Landroidx/window/extensions/embedding/SplitAttributes$SplitType;", "Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "translateSplitPlaceholderRule", "(Landroid/content/Context;Landroidx/window/embedding/SplitPlaceholderRule;Ljava/lang/Class;)Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/ActivityRule;", "Landroidx/window/extensions/embedding/ActivityRule;", "translateActivityRule", "(Landroidx/window/embedding/ActivityRule;Ljava/lang/Class;)Landroidx/window/extensions/embedding/ActivityRule;", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "animationBackground", "Landroidx/window/extensions/embedding/AnimationBackground;", "translateAnimationBackground", "(Landroidx/window/embedding/EmbeddingAnimationBackground;)Landroidx/window/extensions/embedding/AnimationBackground;", "Landroidx/window/core/PredicateAdapter;", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "api1Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "api2Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "api3Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "Landroidx/window/embedding/EmbeddingConfiguration;", "embeddingConfiguration", "Landroidx/window/embedding/EmbeddingConfiguration;", "getEmbeddingConfiguration", "()Landroidx/window/embedding/EmbeddingConfiguration;", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "getEmbeddingConfiguration$annotations", "()V", "getExtensionVersion", "()I", "extensionVersion", "Companion", "VendorApiLevel1Impl", "VendorApiLevel2Impl", "VendorApiLevel3Impl", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddingAdapter {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$Companion;", "", "()V", "INVALID_SPLIT_INFO_TOKEN", "Landroid/os/Binder;", "getINVALID_SPLIT_INFO_TOKEN", "()Landroid/os/Binder;", "TAG", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Binder getINVALID_SPLIT_INFO_TOKEN() {
            return EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN;
        }
    }

    @Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\t\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000E\u001A\u00020\u00012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0003\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0010\u001A\u00020\u00012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0003\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u001B\u0010\t\u001A\u00020\u0011*\u00020\u00112\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\t\u0010\u0012J#\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0013\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0013\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001D\u0010\u001E\u001A\u00020\u00012\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u000BH\u0003\u00A2\u0006\u0004\b\u001E\u0010\u000FJ\u001D\u0010\u001F\u001A\u00020\u00012\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u000BH\u0003\u00A2\u0006\u0004\b\u001F\u0010\u000FJ\u001F\u0010$\u001A\u00020\u00012\u0006\u0010!\u001A\u00020 2\u0006\u0010#\u001A\u00020\"H\u0003\u00A2\u0006\u0004\b$\u0010%J\u0015\u0010(\u001A\u00020\u00072\u0006\u0010\'\u001A\u00020&\u00A2\u0006\u0004\b(\u0010)J!\u0010/\u001A\u00020.2\u0006\u0010+\u001A\u00020*2\n\u0010-\u001A\u0006\u0012\u0002\b\u00030,\u00A2\u0006\u0004\b/\u00100J)\u00103\u001A\u0002022\u0006\u0010!\u001A\u00020 2\u0006\u0010+\u001A\u0002012\n\u0010-\u001A\u0006\u0012\u0002\b\u00030,\u00A2\u0006\u0004\b3\u00104J)\u00107\u001A\u0002062\u0006\u0010!\u001A\u00020 2\u0006\u0010+\u001A\u0002052\n\u0010-\u001A\u0006\u0012\u0002\b\u00030,\u00A2\u0006\u0004\b7\u00108J\u0015\u0010:\u001A\u0002092\u0006\u0010\'\u001A\u00020&\u00A2\u0006\u0004\b:\u0010;J\u0015\u0010:\u001A\u00020>2\u0006\u0010=\u001A\u00020<\u00A2\u0006\u0004\b:\u0010?R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010@\u001A\u0004\bA\u0010B\u00A8\u0006C"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "", "Landroidx/window/core/PredicateAdapter;", "predicateAdapter", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/PredicateAdapter;)V", "Landroidx/window/extensions/embedding/SplitPlaceholderRule$Builder;", "Landroidx/window/embedding/SplitAttributes;", "defaultAttrs", "setDefaultSplitAttributesCompat", "(Landroidx/window/extensions/embedding/SplitPlaceholderRule$Builder;Landroidx/window/embedding/SplitAttributes;)Landroidx/window/extensions/embedding/SplitPlaceholderRule$Builder;", "", "Landroidx/window/embedding/SplitPairFilter;", "splitPairFilters", "translateActivityPairPredicates", "(Ljava/util/Set;)Ljava/lang/Object;", "translateActivityIntentPredicates", "Landroidx/window/extensions/embedding/SplitPairRule$Builder;", "(Landroidx/window/extensions/embedding/SplitPairRule$Builder;Landroidx/window/embedding/SplitAttributes;)Landroidx/window/extensions/embedding/SplitPairRule$Builder;", "attrs", "Lie/m;", "", "", "translateSplitAttributesCompatInternal", "(Landroidx/window/embedding/SplitAttributes;)Lie/m;", "", "isSplitAttributesSupported", "(Landroidx/window/embedding/SplitAttributes;)Z", "Landroidx/window/embedding/ActivityFilter;", "activityFilters", "translateActivityPredicates", "translateIntentPredicates", "Landroid/content/Context;", "context", "Landroidx/window/embedding/SplitRule;", "splitRule", "translateParentMetricsPredicate", "(Landroid/content/Context;Landroidx/window/embedding/SplitRule;)Ljava/lang/Object;", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfo", "getSplitAttributesCompat", "(Landroidx/window/extensions/embedding/SplitInfo;)Landroidx/window/embedding/SplitAttributes;", "Landroidx/window/embedding/ActivityRule;", "rule", "Ljava/lang/Class;", "predicateClass", "Landroidx/window/extensions/embedding/ActivityRule;", "translateActivityRuleCompat", "(Landroidx/window/embedding/ActivityRule;Ljava/lang/Class;)Landroidx/window/extensions/embedding/ActivityRule;", "Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "translateSplitPlaceholderRuleCompat", "(Landroid/content/Context;Landroidx/window/embedding/SplitPlaceholderRule;Ljava/lang/Class;)Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/extensions/embedding/SplitPairRule;", "translateSplitPairRuleCompat", "(Landroid/content/Context;Landroidx/window/embedding/SplitPairRule;Ljava/lang/Class;)Landroidx/window/extensions/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitInfo;", "translateCompat", "(Landroidx/window/extensions/embedding/SplitInfo;)Landroidx/window/embedding/SplitInfo;", "Landroidx/window/extensions/embedding/ActivityStack;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "(Landroidx/window/extensions/embedding/ActivityStack;)Landroidx/window/embedding/ActivityStack;", "Landroidx/window/core/PredicateAdapter;", "getPredicateAdapter", "()Landroidx/window/core/PredicateAdapter;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    final class VendorApiLevel1Impl {
        @NotNull
        private final PredicateAdapter predicateAdapter;

        public VendorApiLevel1Impl(@NotNull PredicateAdapter predicateAdapter0) {
            q.g(predicateAdapter0, "predicateAdapter");
            EmbeddingAdapter.this = embeddingAdapter0;
            super();
            this.predicateAdapter = predicateAdapter0;
        }

        @NotNull
        public final PredicateAdapter getPredicateAdapter() {
            return this.predicateAdapter;
        }

        @NotNull
        public final SplitAttributes getSplitAttributesCompat(@NotNull SplitInfo splitInfo0) {
            q.g(splitInfo0, "splitInfo");
            Builder splitAttributes$Builder0 = new Builder();
            float f = splitInfo0.getSplitRatio();
            return splitAttributes$Builder0.setSplitType(SplitType.Companion.buildSplitTypeFromValue$window_release(f)).setLayoutDirection(LayoutDirection.LOCALE).build();
        }

        private final boolean isSplitAttributesSupported(SplitAttributes splitAttributes0) {
            double f = (double)splitAttributes0.getSplitType().getValue$window_release();
            return 0.0 <= f && f <= 1.0 && splitAttributes0.getSplitType().getValue$window_release() != 1.0f && n.Q(new LayoutDirection[]{LayoutDirection.LEFT_TO_RIGHT, LayoutDirection.RIGHT_TO_LEFT, LayoutDirection.LOCALE}, splitAttributes0.getLayoutDirection());
        }

        private final SplitPairRule.Builder setDefaultSplitAttributesCompat(SplitPairRule.Builder splitPairRule$Builder0, SplitAttributes splitAttributes0) {
            m m0 = this.translateSplitAttributesCompatInternal(splitAttributes0);
            splitPairRule$Builder0.setSplitRatio(((Number)m0.a).floatValue());
            splitPairRule$Builder0.setLayoutDirection(((Number)m0.b).intValue());
            return splitPairRule$Builder0;
        }

        private final SplitPlaceholderRule.Builder setDefaultSplitAttributesCompat(SplitPlaceholderRule.Builder splitPlaceholderRule$Builder0, SplitAttributes splitAttributes0) {
            m m0 = this.translateSplitAttributesCompatInternal(splitAttributes0);
            splitPlaceholderRule$Builder0.setSplitRatio(((Number)m0.a).floatValue());
            splitPlaceholderRule$Builder0.setLayoutDirection(((Number)m0.b).intValue());
            return splitPlaceholderRule$Builder0;
        }

        @SuppressLint({"NewApi"})
        private final Object translateActivityIntentPredicates(Set set0) {
            d d0 = I.a.b(Activity.class);
            d d1 = I.a.b(Intent.class);
            androidx.window.embedding.EmbeddingAdapter.VendorApiLevel1Impl.translateActivityIntentPredicates.1 embeddingAdapter$VendorApiLevel1Impl$translateActivityIntentPredicates$10 = new we.n() {
                final Set $splitPairFilters;

                {
                    this.$splitPairFilters = set0;
                    super(2);
                }

                public final Boolean invoke(Activity activity0, Intent intent0) {
                    q.g(activity0, "first");
                    q.g(intent0, "second");
                    Iterable iterable0 = this.$splitPairFilters;
                    if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                        for(Object object0: iterable0) {
                            if(((SplitPairFilter)object0).matchesActivityIntentPair(activity0, intent0)) {
                                return true;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    return false;
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((Activity)object0), ((Intent)object1));
                }
            };
            return this.predicateAdapter.buildPairPredicate(d0, d1, embeddingAdapter$VendorApiLevel1Impl$translateActivityIntentPredicates$10);
        }

        @SuppressLint({"NewApi"})
        private final Object translateActivityPairPredicates(Set set0) {
            d d0 = I.a.b(Activity.class);
            d d1 = I.a.b(Activity.class);
            androidx.window.embedding.EmbeddingAdapter.VendorApiLevel1Impl.translateActivityPairPredicates.1 embeddingAdapter$VendorApiLevel1Impl$translateActivityPairPredicates$10 = new we.n() {
                final Set $splitPairFilters;

                {
                    this.$splitPairFilters = set0;
                    super(2);
                }

                public final Boolean invoke(Activity activity0, Activity activity1) {
                    q.g(activity0, "first");
                    q.g(activity1, "second");
                    Iterable iterable0 = this.$splitPairFilters;
                    if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                        for(Object object0: iterable0) {
                            if(((SplitPairFilter)object0).matchesActivityPair(activity0, activity1)) {
                                return true;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    return false;
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((Activity)object0), ((Activity)object1));
                }
            };
            return this.predicateAdapter.buildPairPredicate(d0, d1, embeddingAdapter$VendorApiLevel1Impl$translateActivityPairPredicates$10);
        }

        @SuppressLint({"NewApi"})
        private final Object translateActivityPredicates(Set set0) {
            d d0 = I.a.b(Activity.class);
            androidx.window.embedding.EmbeddingAdapter.VendorApiLevel1Impl.translateActivityPredicates.1 embeddingAdapter$VendorApiLevel1Impl$translateActivityPredicates$10 = new k() {
                final Set $activityFilters;

                {
                    this.$activityFilters = set0;
                    super(1);
                }

                public final Boolean invoke(Activity activity0) {
                    q.g(activity0, "activity");
                    Iterable iterable0 = this.$activityFilters;
                    if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                        for(Object object0: iterable0) {
                            if(((ActivityFilter)object0).matchesActivity(activity0)) {
                                return true;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    return false;
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((Activity)object0));
                }
            };
            return this.predicateAdapter.buildPredicate(d0, embeddingAdapter$VendorApiLevel1Impl$translateActivityPredicates$10);
        }

        @NotNull
        public final ActivityRule translateActivityRuleCompat(@NotNull androidx.window.embedding.ActivityRule activityRule0, @NotNull Class class0) {
            q.g(activityRule0, "rule");
            q.g(class0, "predicateClass");
            ActivityRule activityRule1 = ((ActivityRule.Builder)ActivityRule.Builder.class.getConstructor(class0, class0).newInstance(this.translateActivityPredicates(activityRule0.getFilters()), this.translateIntentPredicates(activityRule0.getFilters()))).setShouldAlwaysExpand(activityRule0.getAlwaysExpand()).build();
            q.f(activityRule1, "build(...)");
            return activityRule1;
        }

        @NotNull
        public final ActivityStack translateCompat(@NotNull androidx.window.extensions.embedding.ActivityStack activityStack0) {
            q.g(activityStack0, "activityStack");
            List list0 = activityStack0.getActivities();
            q.f(list0, "getActivities(...)");
            return new ActivityStack(list0, activityStack0.isEmpty());
        }

        @NotNull
        public final androidx.window.embedding.SplitInfo translateCompat(@NotNull SplitInfo splitInfo0) {
            q.g(splitInfo0, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack activityStack0 = splitInfo0.getPrimaryActivityStack();
            q.f(activityStack0, "getPrimaryActivityStack(...)");
            ActivityStack activityStack1 = this.translateCompat(activityStack0);
            androidx.window.extensions.embedding.ActivityStack activityStack2 = splitInfo0.getSecondaryActivityStack();
            q.f(activityStack2, "getSecondaryActivityStack(...)");
            return new androidx.window.embedding.SplitInfo(activityStack1, this.translateCompat(activityStack2), this.getSplitAttributesCompat(splitInfo0));
        }

        @SuppressLint({"NewApi"})
        private final Object translateIntentPredicates(Set set0) {
            d d0 = I.a.b(Intent.class);
            androidx.window.embedding.EmbeddingAdapter.VendorApiLevel1Impl.translateIntentPredicates.1 embeddingAdapter$VendorApiLevel1Impl$translateIntentPredicates$10 = new k() {
                final Set $activityFilters;

                {
                    this.$activityFilters = set0;
                    super(1);
                }

                public final Boolean invoke(Intent intent0) {
                    q.g(intent0, "intent");
                    Iterable iterable0 = this.$activityFilters;
                    if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                        for(Object object0: iterable0) {
                            if(((ActivityFilter)object0).matchesIntent(intent0)) {
                                return true;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    return false;
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((Intent)object0));
                }
            };
            return this.predicateAdapter.buildPredicate(d0, embeddingAdapter$VendorApiLevel1Impl$translateIntentPredicates$10);
        }

        @SuppressLint({"NewApi"})
        private final Object translateParentMetricsPredicate(Context context0, SplitRule splitRule0) {
            d d0 = I.a.b(WindowMetrics.class);
            androidx.window.embedding.EmbeddingAdapter.VendorApiLevel1Impl.translateParentMetricsPredicate.1 embeddingAdapter$VendorApiLevel1Impl$translateParentMetricsPredicate$10 = new k(context0) {
                final Context $context;
                final SplitRule $splitRule;

                {
                    this.$splitRule = splitRule0;
                    this.$context = context0;
                    super(1);
                }

                public final Boolean invoke(WindowMetrics windowMetrics0) {
                    q.g(windowMetrics0, "windowMetrics");
                    return Boolean.valueOf(this.$splitRule.checkParentMetrics$window_release(this.$context, windowMetrics0));
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((WindowMetrics)object0));
                }
            };
            return this.predicateAdapter.buildPredicate(d0, embeddingAdapter$VendorApiLevel1Impl$translateParentMetricsPredicate$10);
        }

        private final m translateSplitAttributesCompatInternal(SplitAttributes splitAttributes0) {
            if(!this.isSplitAttributesSupported(splitAttributes0)) {
                return new m(0.0f, 3);
            }
            Float float0 = splitAttributes0.getSplitType().getValue$window_release();
            LayoutDirection splitAttributes$LayoutDirection0 = splitAttributes0.getLayoutDirection();
            if(!q.b(splitAttributes$LayoutDirection0, LayoutDirection.LOCALE)) {
                if(q.b(splitAttributes$LayoutDirection0, LayoutDirection.LEFT_TO_RIGHT)) {
                    return new m(float0, 0);
                }
                if(!q.b(splitAttributes$LayoutDirection0, LayoutDirection.RIGHT_TO_LEFT)) {
                    throw new IllegalStateException("Unsupported layout direction must be covered in @isSplitAttributesSupported!");
                }
                return new m(float0, 1);
            }
            return new m(float0, 3);
        }

        @NotNull
        public final SplitPairRule translateSplitPairRuleCompat(@NotNull Context context0, @NotNull androidx.window.embedding.SplitPairRule splitPairRule0, @NotNull Class class0) {
            q.g(context0, "context");
            q.g(splitPairRule0, "rule");
            q.g(class0, "predicateClass");
            Object object0 = SplitPairRule.Builder.class.getConstructor(class0, class0, class0).newInstance(this.translateActivityPairPredicates(splitPairRule0.getFilters()), this.translateActivityIntentPredicates(splitPairRule0.getFilters()), this.translateParentMetricsPredicate(context0, splitPairRule0));
            q.f(object0, "newInstance(...)");
            SplitPairRule splitPairRule1 = this.setDefaultSplitAttributesCompat(((SplitPairRule.Builder)object0), splitPairRule0.getDefaultSplitAttributes()).setShouldClearTop(splitPairRule0.getClearTop()).setFinishPrimaryWithSecondary(EmbeddingAdapter.this.translateFinishBehavior(splitPairRule0.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(EmbeddingAdapter.this.translateFinishBehavior(splitPairRule0.getFinishSecondaryWithPrimary())).build();
            q.f(splitPairRule1, "build(...)");
            return splitPairRule1;
        }

        @NotNull
        public final SplitPlaceholderRule translateSplitPlaceholderRuleCompat(@NotNull Context context0, @NotNull androidx.window.embedding.SplitPlaceholderRule splitPlaceholderRule0, @NotNull Class class0) {
            q.g(context0, "context");
            q.g(splitPlaceholderRule0, "rule");
            q.g(class0, "predicateClass");
            SplitPlaceholderRule.Builder splitPlaceholderRule$Builder0 = ((SplitPlaceholderRule.Builder)SplitPlaceholderRule.Builder.class.getConstructor(Intent.class, class0, class0, class0).newInstance(splitPlaceholderRule0.getPlaceholderIntent(), this.translateActivityPredicates(splitPlaceholderRule0.getFilters()), this.translateIntentPredicates(splitPlaceholderRule0.getFilters()), this.translateParentMetricsPredicate(context0, splitPlaceholderRule0))).setSticky(splitPlaceholderRule0.isSticky()).setFinishPrimaryWithSecondary(EmbeddingAdapter.this.translateFinishBehavior(splitPlaceholderRule0.getFinishPrimaryWithPlaceholder()));
            q.f(splitPlaceholderRule$Builder0, "setFinishPrimaryWithSecondary(...)");
            SplitPlaceholderRule splitPlaceholderRule1 = this.setDefaultSplitAttributesCompat(splitPlaceholderRule$Builder0, splitPlaceholderRule0.getDefaultSplitAttributes()).build();
            q.f(splitPlaceholderRule1, "build(...)");
            return splitPlaceholderRule1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    final class VendorApiLevel2Impl {
        @NotNull
        public final androidx.window.embedding.SplitInfo translateCompat(@NotNull SplitInfo splitInfo0) {
            q.g(splitInfo0, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack activityStack0 = splitInfo0.getPrimaryActivityStack();
            q.f(activityStack0, "getPrimaryActivityStack(...)");
            ActivityStack activityStack1 = EmbeddingAdapter.this.api1Impl.translateCompat(activityStack0);
            androidx.window.extensions.embedding.ActivityStack activityStack2 = splitInfo0.getSecondaryActivityStack();
            q.f(activityStack2, "getSecondaryActivityStack(...)");
            ActivityStack activityStack3 = EmbeddingAdapter.this.api1Impl.translateCompat(activityStack2);
            androidx.window.extensions.embedding.SplitAttributes splitAttributes0 = splitInfo0.getSplitAttributes();
            q.f(splitAttributes0, "getSplitAttributes(...)");
            return new androidx.window.embedding.SplitInfo(activityStack1, activityStack3, EmbeddingAdapter.this.translate$window_release(splitAttributes0));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    final class VendorApiLevel3Impl {
        @NotNull
        public final androidx.window.embedding.SplitInfo translateCompat(@NotNull SplitInfo splitInfo0) {
            q.g(splitInfo0, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack activityStack0 = splitInfo0.getPrimaryActivityStack();
            q.f(activityStack0, "getPrimaryActivityStack(...)");
            ActivityStack activityStack1 = EmbeddingAdapter.this.api1Impl.translateCompat(activityStack0);
            androidx.window.extensions.embedding.ActivityStack activityStack2 = splitInfo0.getSecondaryActivityStack();
            q.f(activityStack2, "getSecondaryActivityStack(...)");
            ActivityStack activityStack3 = EmbeddingAdapter.this.api1Impl.translateCompat(activityStack2);
            androidx.window.extensions.embedding.SplitAttributes splitAttributes0 = splitInfo0.getSplitAttributes();
            q.f(splitAttributes0, "getSplitAttributes(...)");
            SplitAttributes splitAttributes1 = EmbeddingAdapter.this.translate$window_release(splitAttributes0);
            IBinder iBinder0 = splitInfo0.getToken();
            q.f(iBinder0, "getToken(...)");
            return new androidx.window.embedding.SplitInfo(activityStack1, activityStack3, splitAttributes1, iBinder0);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Binder INVALID_SPLIT_INFO_TOKEN;
    @Nullable
    private static final String TAG;
    @NotNull
    private final VendorApiLevel1Impl api1Impl;
    @NotNull
    private final VendorApiLevel2Impl api2Impl;
    @NotNull
    private final VendorApiLevel3Impl api3Impl;
    @Nullable
    private EmbeddingConfiguration embeddingConfiguration;
    @NotNull
    private final PredicateAdapter predicateAdapter;

    static {
        EmbeddingAdapter.Companion = new Companion(null);
        EmbeddingAdapter.TAG = I.a.b(EmbeddingAdapter.class).m();
        EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN = new Binder();
    }

    public EmbeddingAdapter(@NotNull PredicateAdapter predicateAdapter0) {
        q.g(predicateAdapter0, "predicateAdapter");
        super();
        this.predicateAdapter = predicateAdapter0;
        this.api1Impl = new VendorApiLevel1Impl(this, predicateAdapter0);
        this.api2Impl = new VendorApiLevel2Impl(this);
        this.api3Impl = new VendorApiLevel3Impl(this);
    }

    @Nullable
    public final EmbeddingConfiguration getEmbeddingConfiguration() {
        return this.embeddingConfiguration;
    }

    public static void getEmbeddingConfiguration$annotations() {
    }

    private final int getExtensionVersion() {
        return WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
    }

    public final void setEmbeddingConfiguration(@Nullable EmbeddingConfiguration embeddingConfiguration0) {
        this.embeddingConfiguration = embeddingConfiguration0;
    }

    private final androidx.window.embedding.SplitInfo translate(SplitInfo splitInfo0) {
        int v = this.getExtensionVersion();
        if(v == 1) {
            return this.api1Impl.translateCompat(splitInfo0);
        }
        if(v == 2) {
            return this.api2Impl.translateCompat(splitInfo0);
        }
        if(3 <= v && v < 5) {
            return this.api3Impl.translateCompat(splitInfo0);
        }
        androidx.window.extensions.embedding.ActivityStack activityStack0 = splitInfo0.getPrimaryActivityStack();
        q.f(activityStack0, "getPrimaryActivityStack(...)");
        ActivityStack activityStack1 = this.translate$window_release(activityStack0);
        androidx.window.extensions.embedding.ActivityStack activityStack2 = splitInfo0.getSecondaryActivityStack();
        q.f(activityStack2, "getSecondaryActivityStack(...)");
        ActivityStack activityStack3 = this.translate$window_release(activityStack2);
        androidx.window.extensions.embedding.SplitAttributes splitAttributes0 = splitInfo0.getSplitAttributes();
        q.f(splitAttributes0, "getSplitAttributes(...)");
        SplitAttributes splitAttributes1 = this.translate$window_release(splitAttributes0);
        SplitInfo.Token splitInfo$Token0 = splitInfo0.getSplitInfoToken();
        q.f(splitInfo$Token0, "getSplitInfoToken(...)");
        return new androidx.window.embedding.SplitInfo(activityStack1, activityStack3, splitAttributes1, splitInfo$Token0);
    }

    @SuppressLint({"NewApi"})
    @NotNull
    public final SplitAttributesCalculatorParams translate(@NotNull androidx.window.extensions.embedding.SplitAttributesCalculatorParams splitAttributesCalculatorParams0) {
        q.g(splitAttributesCalculatorParams0, "params");
        WindowMetrics windowMetrics0 = splitAttributesCalculatorParams0.getParentWindowMetrics();
        q.f(windowMetrics0, "getParentWindowMetrics(...)");
        Configuration configuration0 = splitAttributesCalculatorParams0.getParentConfiguration();
        q.f(configuration0, "getParentConfiguration(...)");
        WindowLayoutInfo windowLayoutInfo0 = splitAttributesCalculatorParams0.getParentWindowLayoutInfo();
        q.f(windowLayoutInfo0, "getParentWindowLayoutInfo(...)");
        androidx.window.extensions.embedding.SplitAttributes splitAttributes0 = splitAttributesCalculatorParams0.getDefaultSplitAttributes();
        q.f(splitAttributes0, "getDefaultSplitAttributes(...)");
        boolean z = splitAttributesCalculatorParams0.areDefaultConstraintsSatisfied();
        String s = splitAttributesCalculatorParams0.getSplitRuleTag();
        float f = DensityCompatHelper.Companion.getInstance().density(configuration0, windowMetrics0);
        androidx.window.layout.WindowMetrics windowMetrics1 = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(windowMetrics0, f);
        return new SplitAttributesCalculatorParams(windowMetrics1, configuration0, ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(windowMetrics1, windowLayoutInfo0), this.translate$window_release(splitAttributes0), z, s);
    }

    @NotNull
    public final List translate(@NotNull List list0) {
        q.g(list0, "splitInfoList");
        List list1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            list1.add(this.translate(((SplitInfo)object0)));
        }
        return list1;
    }

    @NotNull
    public final Set translate(@NotNull Context context0, @NotNull Set set0) {
        EmbeddingRule embeddingRule1;
        q.g(context0, "context");
        q.g(set0, "rules");
        Class class0 = this.predicateAdapter.predicateClassOrNull$window_release();
        if(class0 == null) {
            return y.a;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, set0));
        for(Object object0: set0) {
            androidx.window.embedding.EmbeddingRule embeddingRule0 = (androidx.window.embedding.EmbeddingRule)object0;
            if(embeddingRule0 instanceof androidx.window.embedding.SplitPairRule) {
                embeddingRule1 = (EmbeddingRule)this.translateSplitPairRule(context0, ((androidx.window.embedding.SplitPairRule)embeddingRule0), class0);
            }
            else if(embeddingRule0 instanceof androidx.window.embedding.SplitPlaceholderRule) {
                embeddingRule1 = (EmbeddingRule)this.translateSplitPlaceholderRule(context0, ((androidx.window.embedding.SplitPlaceholderRule)embeddingRule0), class0);
            }
            else {
                if(!(embeddingRule0 instanceof androidx.window.embedding.ActivityRule)) {
                    throw new IllegalArgumentException("Unsupported rule type");
                }
                embeddingRule1 = (EmbeddingRule)this.translateActivityRule(((androidx.window.embedding.ActivityRule)embeddingRule0), class0);
            }
            arrayList0.add(embeddingRule1);
        }
        return p.T0(arrayList0);
    }

    @NotNull
    public final ActivityStack translate$window_release(@NotNull androidx.window.extensions.embedding.ActivityStack activityStack0) {
        q.g(activityStack0, "activityStack");
        int v = this.getExtensionVersion();
        if(1 <= v && v < 5) {
            return this.api1Impl.translateCompat(activityStack0);
        }
        List list0 = activityStack0.getActivities();
        q.f(list0, "getActivities(...)");
        return new ActivityStack(list0, activityStack0.isEmpty(), activityStack0.getActivityStackToken());
    }

    @SuppressLint({"NewApi"})
    @RequiresWindowSdkExtension(version = 8)
    @NotNull
    public final ParentContainerInfo translate$window_release(@NotNull androidx.window.extensions.embedding.ParentContainerInfo parentContainerInfo0) {
        q.g(parentContainerInfo0, "parentContainerInfo");
        Configuration configuration0 = parentContainerInfo0.getConfiguration();
        q.f(configuration0, "getConfiguration(...)");
        DensityCompatHelper densityCompatHelper0 = DensityCompatHelper.Companion.getInstance();
        Configuration configuration1 = parentContainerInfo0.getConfiguration();
        q.f(configuration1, "getConfiguration(...)");
        WindowMetrics windowMetrics0 = parentContainerInfo0.getWindowMetrics();
        q.f(windowMetrics0, "getWindowMetrics(...)");
        float f = densityCompatHelper0.density(configuration1, windowMetrics0);
        WindowMetrics windowMetrics1 = parentContainerInfo0.getWindowMetrics();
        q.f(windowMetrics1, "getWindowMetrics(...)");
        androidx.window.layout.WindowMetrics windowMetrics2 = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(windowMetrics1, f);
        Bounds bounds0 = new Bounds(windowMetrics2.getBounds());
        WindowLayoutInfo windowLayoutInfo0 = parentContainerInfo0.getWindowLayoutInfo();
        q.f(windowLayoutInfo0, "getWindowLayoutInfo(...)");
        return new ParentContainerInfo(bounds0, ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(windowMetrics2, windowLayoutInfo0), configuration0, f);
    }

    @NotNull
    public final SplitAttributes translate$window_release(@NotNull androidx.window.extensions.embedding.SplitAttributes splitAttributes0) {
        EmbeddingAnimationParams embeddingAnimationParams0;
        LayoutDirection splitAttributes$LayoutDirection0;
        SplitType splitAttributes$SplitType1;
        q.g(splitAttributes0, "splitAttributes");
        Builder splitAttributes$Builder0 = new Builder();
        SplitAttributes.SplitType splitAttributes$SplitType0 = splitAttributes0.getSplitType();
        q.f(splitAttributes$SplitType0, "getSplitType(...)");
        if(splitAttributes$SplitType0 instanceof SplitAttributes.SplitType.HingeSplitType) {
            splitAttributes$SplitType1 = SplitType.SPLIT_TYPE_HINGE;
        }
        else if(splitAttributes$SplitType0 instanceof SplitAttributes.SplitType.ExpandContainersSplitType) {
            splitAttributes$SplitType1 = SplitType.SPLIT_TYPE_EXPAND;
        }
        else if(splitAttributes$SplitType0 instanceof SplitAttributes.SplitType.RatioSplitType) {
            float f = ((SplitAttributes.SplitType.RatioSplitType)splitAttributes$SplitType0).getRatio();
            splitAttributes$SplitType1 = SplitType.Companion.ratio(f);
        }
        else {
            throw new IllegalArgumentException("Unknown split type: " + splitAttributes$SplitType0);
        }
        Builder splitAttributes$Builder1 = splitAttributes$Builder0.setSplitType(splitAttributes$SplitType1);
        int v = splitAttributes0.getLayoutDirection();
        switch(v) {
            case 0: {
                splitAttributes$LayoutDirection0 = LayoutDirection.LEFT_TO_RIGHT;
                break;
            }
            case 1: {
                splitAttributes$LayoutDirection0 = LayoutDirection.RIGHT_TO_LEFT;
                break;
            }
            case 3: {
                splitAttributes$LayoutDirection0 = LayoutDirection.LOCALE;
                break;
            }
            case 4: {
                splitAttributes$LayoutDirection0 = LayoutDirection.TOP_TO_BOTTOM;
                break;
            }
            case 5: {
                splitAttributes$LayoutDirection0 = LayoutDirection.BOTTOM_TO_TOP;
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown layout direction: " + v);
            }
        }
        Builder splitAttributes$Builder2 = splitAttributes$Builder1.setLayoutDirection(splitAttributes$LayoutDirection0);
        if(this.getExtensionVersion() >= 5) {
            AnimationBackground animationBackground0 = splitAttributes0.getAnimationBackground();
            q.f(animationBackground0, "getAnimationBackground(...)");
            if(animationBackground0 instanceof AnimationBackground.ColorBackground) {
                androidx.window.embedding.EmbeddingAnimationParams.Builder embeddingAnimationParams$Builder0 = new androidx.window.embedding.EmbeddingAnimationParams.Builder();
                int v1 = ((AnimationBackground.ColorBackground)animationBackground0).getColor();
                embeddingAnimationParams0 = embeddingAnimationParams$Builder0.setAnimationBackground(EmbeddingAnimationBackground.Companion.createColorBackground(v1)).build();
            }
            else {
                embeddingAnimationParams0 = new androidx.window.embedding.EmbeddingAnimationParams.Builder().build();
            }
            splitAttributes$Builder2.setAnimationParams(embeddingAnimationParams0);
        }
        if(this.getExtensionVersion() >= 6) {
            splitAttributes$Builder2.setDividerAttributes(this.translateDividerAttributes(splitAttributes0.getDividerAttributes()));
        }
        return splitAttributes$Builder2.build();
    }

    @NotNull
    public final List translate$window_release(@NotNull List list0) {
        q.g(list0, "activityStacks");
        List list1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            list1.add(this.translate$window_release(((androidx.window.extensions.embedding.ActivityStack)object0)));
        }
        return list1;
    }

    private final ActivityRule translateActivityRule(androidx.window.embedding.ActivityRule activityRule0, Class class0) {
        if(this.getExtensionVersion() < 2) {
            return this.api1Impl.translateActivityRuleCompat(activityRule0, class0);
        }
        ActivityRule.Builder activityRule$Builder0 = new ActivityRule.Builder(new g(activityRule0, 0), new g(activityRule0, 1)).setShouldAlwaysExpand(activityRule0.getAlwaysExpand());
        q.f(activityRule$Builder0, "setShouldAlwaysExpand(...)");
        String s = activityRule0.getTag();
        if(s != null) {
            activityRule$Builder0.setTag(s);
        }
        ActivityRule activityRule1 = activityRule$Builder0.build();
        q.f(activityRule1, "build(...)");
        return activityRule1;
    }

    private static final boolean translateActivityRule$lambda$16(androidx.window.embedding.ActivityRule activityRule0, Activity activity0) {
        q.g(activity0, "activity");
        Iterable iterable0 = activityRule0.getFilters();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(((ActivityFilter)object0).matchesActivity(activity0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private static final boolean translateActivityRule$lambda$18(androidx.window.embedding.ActivityRule activityRule0, Intent intent0) {
        q.g(intent0, "intent");
        Iterable iterable0 = activityRule0.getFilters();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(((ActivityFilter)object0).matchesIntent(intent0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private final AnimationBackground translateAnimationBackground(EmbeddingAnimationBackground embeddingAnimationBackground0) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        if(embeddingAnimationBackground0 instanceof ColorBackground) {
            AnimationBackground.ColorBackground animationBackground$ColorBackground0 = AnimationBackground.createColorBackground(((ColorBackground)embeddingAnimationBackground0).getColor());
            q.d(animationBackground$ColorBackground0);
            return (AnimationBackground)animationBackground$ColorBackground0;
        }
        AnimationBackground animationBackground0 = AnimationBackground.ANIMATION_BACKGROUND_DEFAULT;
        q.d(animationBackground0);
        return animationBackground0;
    }

    @RequiresWindowSdkExtension(version = 6)
    @NotNull
    public final DividerAttributes translateDividerAttributes(@Nullable androidx.window.extensions.embedding.DividerAttributes dividerAttributes0) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        if(dividerAttributes0 == null) {
            return DividerAttributes.NO_DIVIDER;
        }
        switch(dividerAttributes0.getDividerType()) {
            case 1: {
                return new androidx.window.embedding.DividerAttributes.FixedDividerAttributes.Builder().setWidthDp(dividerAttributes0.getWidthDp()).setColor(dividerAttributes0.getDividerColor()).build();
            }
            case 2: {
                androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder dividerAttributes$DraggableDividerAttributes$Builder0 = new androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder().setWidthDp(dividerAttributes0.getWidthDp()).setColor(dividerAttributes0.getDividerColor());
                return dividerAttributes0.getPrimaryMinRatio() != -1.0f || dividerAttributes0.getPrimaryMaxRatio() != -1.0f ? dividerAttributes$DraggableDividerAttributes$Builder0.setDragRange(new SplitRatioDragRange(dividerAttributes0.getPrimaryMinRatio(), dividerAttributes0.getPrimaryMaxRatio())).build() : dividerAttributes$DraggableDividerAttributes$Builder0.setDragRange(DragRange.DRAG_RANGE_SYSTEM_DEFAULT).build();
            }
            default: {
                Log.w(EmbeddingAdapter.TAG, "Unknown divider type " + dividerAttributes0 + ".dividerType, default to fixed divider type");
                return new androidx.window.embedding.DividerAttributes.FixedDividerAttributes.Builder().setWidthDp(dividerAttributes0.getWidthDp()).setColor(dividerAttributes0.getDividerColor()).build();
            }
        }
    }

    @RequiresWindowSdkExtension(version = 6)
    @Nullable
    public final androidx.window.extensions.embedding.DividerAttributes translateDividerAttributes(@NotNull DividerAttributes dividerAttributes0) {
        int v;
        q.g(dividerAttributes0, "dividerAttributes");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        if(dividerAttributes0 == DividerAttributes.NO_DIVIDER) {
            return null;
        }
        if(dividerAttributes0 instanceof FixedDividerAttributes) {
            v = 1;
        }
        else if(dividerAttributes0 instanceof DraggableDividerAttributes) {
            v = 2;
        }
        else {
            throw new IllegalArgumentException("Unknown divider attributes " + dividerAttributes0);
        }
        DividerAttributes.Builder dividerAttributes$Builder0 = new DividerAttributes.Builder(v).setDividerColor(dividerAttributes0.getColor()).setWidthDp(dividerAttributes0.getWidthDp());
        q.f(dividerAttributes$Builder0, "setWidthDp(...)");
        if(dividerAttributes0 instanceof DraggableDividerAttributes && ((DraggableDividerAttributes)dividerAttributes0).getDragRange() instanceof SplitRatioDragRange) {
            dividerAttributes$Builder0.setPrimaryMinRatio(((SplitRatioDragRange)((DraggableDividerAttributes)dividerAttributes0).getDragRange()).getMinRatio()).setPrimaryMaxRatio(((SplitRatioDragRange)((DraggableDividerAttributes)dividerAttributes0).getDragRange()).getMaxRatio());
        }
        if(this.getExtensionVersion() == 7 && dividerAttributes0.getWidthDp() == 0) {
            dividerAttributes$Builder0.setWidthDp(1);
        }
        return dividerAttributes$Builder0.build();
    }

    public final int translateFinishBehavior(@NotNull FinishBehavior splitRule$FinishBehavior0) {
        q.g(splitRule$FinishBehavior0, "behavior");
        if(splitRule$FinishBehavior0.equals(FinishBehavior.NEVER)) {
            return 0;
        }
        if(splitRule$FinishBehavior0.equals(FinishBehavior.ALWAYS)) {
            return 1;
        }
        if(!splitRule$FinishBehavior0.equals(FinishBehavior.ADJACENT)) {
            throw new IllegalArgumentException("Unknown finish behavior:" + splitRule$FinishBehavior0);
        }
        return 2;
    }

    @NotNull
    public final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributes(@NotNull SplitAttributes splitAttributes0) {
        int v;
        q.g(splitAttributes0, "splitAttributes");
        if(this.getExtensionVersion() < 2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        SplitAttributes.Builder splitAttributes$Builder0 = new SplitAttributes.Builder().setSplitType(this.translateSplitType(splitAttributes0.getSplitType()));
        LayoutDirection splitAttributes$LayoutDirection0 = splitAttributes0.getLayoutDirection();
        if(q.b(splitAttributes$LayoutDirection0, LayoutDirection.LOCALE)) {
            v = 3;
        }
        else {
            if(q.b(splitAttributes$LayoutDirection0, LayoutDirection.LEFT_TO_RIGHT)) {
                v = 0;
                goto label_18;
            }
            if(q.b(splitAttributes$LayoutDirection0, LayoutDirection.RIGHT_TO_LEFT)) {
                v = 1;
                goto label_18;
            }
            if(q.b(splitAttributes$LayoutDirection0, LayoutDirection.TOP_TO_BOTTOM)) {
                v = 4;
            }
            else if(q.b(splitAttributes$LayoutDirection0, LayoutDirection.BOTTOM_TO_TOP)) {
                v = 5;
            }
            else {
                throw new IllegalArgumentException("Unsupported layoutDirection:" + splitAttributes0 + ".layoutDirection");
            }
        }
    label_18:
        SplitAttributes.Builder splitAttributes$Builder1 = splitAttributes$Builder0.setLayoutDirection(v);
        q.f(splitAttributes$Builder1, "setLayoutDirection(...)");
        if(this.getExtensionVersion() >= 5) {
            splitAttributes$Builder1.setWindowAttributes(this.translateWindowAttributes$window_release()).setAnimationBackground(this.translateAnimationBackground(splitAttributes0.getAnimationParams().getAnimationBackground()));
        }
        if(this.getExtensionVersion() >= 6) {
            splitAttributes$Builder1.setDividerAttributes(this.translateDividerAttributes(splitAttributes0.getDividerAttributes()));
        }
        androidx.window.extensions.embedding.SplitAttributes splitAttributes1 = splitAttributes$Builder1.build();
        q.f(splitAttributes1, "build(...)");
        return splitAttributes1;
    }

    @NotNull
    public final JFunction2 translateSplitAttributesCalculator(@NotNull k k0) {
        q.g(k0, "calculator");
        return new androidx.window.embedding.d(this, k0);
    }

    private static final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributesCalculator$lambda$1(EmbeddingAdapter embeddingAdapter0, k k0, androidx.window.extensions.embedding.SplitAttributesCalculatorParams splitAttributesCalculatorParams0) {
        q.g(splitAttributesCalculatorParams0, "oemParams");
        return embeddingAdapter0.translateSplitAttributes(((SplitAttributes)k0.invoke(embeddingAdapter0.translate(splitAttributesCalculatorParams0))));
    }

    private final SplitPairRule translateSplitPairRule(Context context0, androidx.window.embedding.SplitPairRule splitPairRule0, Class class0) {
        if(this.getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPairRuleCompat(context0, splitPairRule0, class0);
        }
        f f0 = new f(splitPairRule0, 0);
        f f1 = new f(splitPairRule0, 1);
        c c0 = new c(splitPairRule0, context0, 2);
        String s = splitPairRule0.getTag();
        SplitPairRule.Builder splitPairRule$Builder0 = new SplitPairRule.Builder(f0, f1, c0).setDefaultSplitAttributes(this.translateSplitAttributes(splitPairRule0.getDefaultSplitAttributes())).setFinishPrimaryWithSecondary(this.translateFinishBehavior(splitPairRule0.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(this.translateFinishBehavior(splitPairRule0.getFinishSecondaryWithPrimary())).setShouldClearTop(splitPairRule0.getClearTop());
        q.f(splitPairRule$Builder0, "setShouldClearTop(...)");
        if(s != null) {
            splitPairRule$Builder0.setTag(s);
        }
        SplitPairRule splitPairRule1 = splitPairRule$Builder0.build();
        q.f(splitPairRule1, "build(...)");
        return splitPairRule1;
    }

    private static final boolean translateSplitPairRule$lambda$4(androidx.window.embedding.SplitPairRule splitPairRule0, Pair pair0) {
        q.g(pair0, "activitiesPair");
        Iterable iterable0 = splitPairRule0.getFilters();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            Object object1 = pair0.first;
            q.f(object1, "first");
            Object object2 = pair0.second;
            q.f(object2, "second");
            if(((SplitPairFilter)object0).matchesActivityPair(((Activity)object1), ((Activity)object2))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private static final boolean translateSplitPairRule$lambda$6(androidx.window.embedding.SplitPairRule splitPairRule0, Pair pair0) {
        q.g(pair0, "activityIntentPair");
        Iterable iterable0 = splitPairRule0.getFilters();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            Object object1 = pair0.first;
            q.f(object1, "first");
            Object object2 = pair0.second;
            q.f(object2, "second");
            if(((SplitPairFilter)object0).matchesActivityIntentPair(((Activity)object1), ((Intent)object2))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private static final boolean translateSplitPairRule$lambda$7(androidx.window.embedding.SplitPairRule splitPairRule0, Context context0, WindowMetrics windowMetrics0) {
        q.g(windowMetrics0, "windowMetrics");
        return splitPairRule0.checkParentMetrics$window_release(context0, windowMetrics0);
    }

    @NotNull
    public final SplitPinRule translateSplitPinRule(@NotNull Context context0, @NotNull androidx.window.embedding.SplitPinRule splitPinRule0) {
        q.g(context0, "context");
        q.g(splitPinRule0, "splitPinRule");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        c c0 = new c(splitPinRule0, context0, 0);
        SplitPinRule.Builder splitPinRule$Builder0 = new SplitPinRule.Builder(this.translateSplitAttributes(splitPinRule0.getDefaultSplitAttributes()), c0);
        splitPinRule$Builder0.setSticky(splitPinRule0.isSticky());
        String s = splitPinRule0.getTag();
        if(s != null) {
            splitPinRule$Builder0.setTag(s);
        }
        SplitPinRule splitPinRule1 = splitPinRule$Builder0.build();
        q.f(splitPinRule1, "build(...)");
        return splitPinRule1;
    }

    private static final boolean translateSplitPinRule$lambda$8(androidx.window.embedding.SplitPinRule splitPinRule0, Context context0, WindowMetrics windowMetrics0) {
        q.g(windowMetrics0, "windowMetrics");
        return splitPinRule0.checkParentMetrics$window_release(context0, windowMetrics0);
    }

    private final SplitPlaceholderRule translateSplitPlaceholderRule(Context context0, androidx.window.embedding.SplitPlaceholderRule splitPlaceholderRule0, Class class0) {
        if(this.getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPlaceholderRuleCompat(context0, splitPlaceholderRule0, class0);
        }
        e e0 = new e(splitPlaceholderRule0, 0);
        e e1 = new e(splitPlaceholderRule0, 1);
        c c0 = new c(splitPlaceholderRule0, context0, 1);
        String s = splitPlaceholderRule0.getTag();
        SplitPlaceholderRule.Builder splitPlaceholderRule$Builder0 = new SplitPlaceholderRule.Builder(splitPlaceholderRule0.getPlaceholderIntent(), e0, e1, c0).setSticky(splitPlaceholderRule0.isSticky()).setDefaultSplitAttributes(this.translateSplitAttributes(splitPlaceholderRule0.getDefaultSplitAttributes())).setFinishPrimaryWithPlaceholder(this.translateFinishBehavior(splitPlaceholderRule0.getFinishPrimaryWithPlaceholder()));
        q.f(splitPlaceholderRule$Builder0, "setFinishPrimaryWithPlaceholder(...)");
        if(s != null) {
            splitPlaceholderRule$Builder0.setTag(s);
        }
        SplitPlaceholderRule splitPlaceholderRule1 = splitPlaceholderRule$Builder0.build();
        q.f(splitPlaceholderRule1, "build(...)");
        return splitPlaceholderRule1;
    }

    private static final boolean translateSplitPlaceholderRule$lambda$11(androidx.window.embedding.SplitPlaceholderRule splitPlaceholderRule0, Activity activity0) {
        q.g(activity0, "activity");
        Iterable iterable0 = splitPlaceholderRule0.getFilters();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(((ActivityFilter)object0).matchesActivity(activity0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private static final boolean translateSplitPlaceholderRule$lambda$13(androidx.window.embedding.SplitPlaceholderRule splitPlaceholderRule0, Intent intent0) {
        q.g(intent0, "intent");
        Iterable iterable0 = splitPlaceholderRule0.getFilters();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return false;
        }
        for(Object object0: iterable0) {
            if(((ActivityFilter)object0).matchesIntent(intent0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private static final boolean translateSplitPlaceholderRule$lambda$14(androidx.window.embedding.SplitPlaceholderRule splitPlaceholderRule0, Context context0, WindowMetrics windowMetrics0) {
        q.g(windowMetrics0, "windowMetrics");
        return splitPlaceholderRule0.checkParentMetrics$window_release(context0, windowMetrics0);
    }

    private final SplitAttributes.SplitType translateSplitType(SplitType splitAttributes$SplitType0) {
        if(this.getExtensionVersion() < 2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if(q.b(splitAttributes$SplitType0, SplitType.SPLIT_TYPE_HINGE)) {
            return (SplitAttributes.SplitType)new SplitAttributes.SplitType.HingeSplitType(this.translateSplitType(SplitType.SPLIT_TYPE_EQUAL));
        }
        if(q.b(splitAttributes$SplitType0, SplitType.SPLIT_TYPE_EXPAND)) {
            return (SplitAttributes.SplitType)new SplitAttributes.SplitType.ExpandContainersSplitType();
        }
        float f = splitAttributes$SplitType0.getValue$window_release();
        if(((double)f) <= 0.0 || ((double)f) >= 1.0) {
            throw new IllegalArgumentException("Unsupported SplitType: " + splitAttributes$SplitType0 + " with value: " + splitAttributes$SplitType0.getValue$window_release());
        }
        return (SplitAttributes.SplitType)new SplitAttributes.SplitType.RatioSplitType(f);
    }

    @NotNull
    public final WindowAttributes translateWindowAttributes$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        return q.b((this.embeddingConfiguration == null ? null : this.embeddingConfiguration.getDimAreaBehavior()), DimAreaBehavior.ON_ACTIVITY_STACK) ? new WindowAttributes(1) : new WindowAttributes(2);
    }
}

