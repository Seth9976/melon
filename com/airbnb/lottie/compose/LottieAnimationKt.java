package com.airbnb.lottie.compose;

import A0.f;
import N0.j;
import N0.k;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.AsyncUpdates;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.model.Marker;
import e1.m;
import ie.H;
import ie.d;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.e;
import r0.n;
import r0.q;
import we.a;
import y0.c;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u00CD\u0001\u0010\u001F\u001A\u00020\u001E2\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u00072\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0015\u001A\u00020\u00072\b\b\u0002\u0010\u0016\u001A\u00020\u00072\u0016\b\u0002\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\b\u0002\u0010\u001C\u001A\u00020\u001B2\b\b\u0002\u0010\u001D\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\u001F\u0010 \u001A\u00A7\u0001\u0010\u001F\u001A\u00020\u001E2\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u00072\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0015\u001A\u00020\u00072\b\b\u0002\u0010\u001D\u001A\u00020\u00072\b\b\u0002\u0010\u001C\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b\u001F\u0010!\u001A\u00FD\u0001\u0010\u001F\u001A\u00020\u001E2\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\"\u001A\u00020\u00072\b\b\u0002\u0010#\u001A\u00020\u00072\n\b\u0002\u0010%\u001A\u0004\u0018\u00010$2\b\b\u0002\u0010&\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020\'2\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010)\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\u00072\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0015\u001A\u00020\u00072\b\b\u0002\u0010\u0016\u001A\u00020\u00072\u0016\b\u0002\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\b\u0002\u0010\u001D\u001A\u00020\u00072\b\b\u0002\u0010\u001C\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b\u001F\u0010*\u001A\u00C3\u0001\u0010\u001F\u001A\u00020\u001E2\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u00072\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u00072\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0015\u001A\u00020\u00072\b\b\u0002\u0010\u0016\u001A\u00020\u00072\u0016\b\u0002\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\b\u0002\u0010\u001C\u001A\u00020\u001B2\b\b\u0002\u0010\u001D\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\u001F\u0010+\u001A\u001F\u00102\u001A\u00020/*\u00020,2\u0006\u0010.\u001A\u00020-H\u0082\u0002\u00F8\u0001\u0000\u00A2\u0006\u0004\b0\u00101\u0082\u0002\u0007\n\u0005\b\u00A1\u001E0\u0001\u00A8\u00064\u00B2\u0006\u0010\u00103\u001A\u0004\u0018\u00010\u000F8\n@\nX\u008A\u008E\u0002\u00B2\u0006\f\u0010\u0004\u001A\u00020\u00038\nX\u008A\u0084\u0002"}, d2 = {"Lcom/airbnb/lottie/LottieComposition;", "composition", "Lkotlin/Function0;", "", "progress", "Lr0/q;", "modifier", "", "outlineMasksAndMattes", "applyOpacityToLayers", "applyShadowToLayers", "enableMergePaths", "Lcom/airbnb/lottie/RenderMode;", "renderMode", "maintainOriginalImageBounds", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "dynamicProperties", "Lr0/e;", "alignment", "LN0/k;", "contentScale", "clipToCompositionBounds", "clipTextToBoundingBox", "", "", "Landroid/graphics/Typeface;", "fontMap", "Lcom/airbnb/lottie/AsyncUpdates;", "asyncUpdates", "safeMode", "Lie/H;", "LottieAnimation", "(Lcom/airbnb/lottie/LottieComposition;Lwe/a;Lr0/q;ZZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Lr0/e;LN0/k;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;ZLandroidx/compose/runtime/l;III)V", "(Lcom/airbnb/lottie/LottieComposition;FLr0/q;ZZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Lr0/e;LN0/k;ZZLcom/airbnb/lottie/AsyncUpdates;Landroidx/compose/runtime/l;III)V", "isPlaying", "restartOnPlay", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "speed", "", "iterations", "reverseOnRepeat", "(Lcom/airbnb/lottie/LottieComposition;Lr0/q;ZZLcom/airbnb/lottie/compose/LottieClipSpec;FIZZZZLcom/airbnb/lottie/RenderMode;ZZLcom/airbnb/lottie/compose/LottieDynamicProperties;Lr0/e;LN0/k;ZZLjava/util/Map;ZLcom/airbnb/lottie/AsyncUpdates;Landroidx/compose/runtime/l;IIII)V", "(Lcom/airbnb/lottie/LottieComposition;Lwe/a;Lr0/q;ZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;Lr0/e;LN0/k;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;ZLandroidx/compose/runtime/l;III)V", "Lx0/e;", "LN0/e0;", "scale", "Lr1/l;", "times-UQTWf7w", "(JJ)J", "times", "setDynamicProperties", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottieAnimationKt {
    @d
    public static final void LottieAnimation(@Nullable LottieComposition lottieComposition0, float f, @Nullable q q0, boolean z, boolean z1, boolean z2, boolean z3, @Nullable RenderMode renderMode0, boolean z4, @Nullable LottieDynamicProperties lottieDynamicProperties0, @Nullable e e0, @Nullable k k0, boolean z5, boolean z6, @Nullable AsyncUpdates asyncUpdates0, @Nullable l l0, int v, int v1, int v2) {
        ((p)l0).c0(1170781710);
        q q1 = (v2 & 4) == 0 ? q0 : n.a;
        boolean z7 = (v2 & 8) == 0 ? z : false;
        boolean z8 = (v2 & 16) == 0 ? z1 : false;
        boolean z9 = (v2 & 0x20) == 0 ? z2 : true;
        boolean z10 = (v2 & 0x40) == 0 ? z3 : false;
        RenderMode renderMode1 = (v2 & 0x80) == 0 ? renderMode0 : RenderMode.AUTOMATIC;
        boolean z11 = (v2 & 0x100) == 0 ? z4 : false;
        LottieDynamicProperties lottieDynamicProperties1 = (v2 & 0x200) == 0 ? lottieDynamicProperties0 : null;
        e e1 = (v2 & 0x400) == 0 ? e0 : r0.d.e;
        k k1 = (v2 & 0x800) == 0 ? k0 : j.c;
        boolean z12 = (v2 & 0x1000) == 0 ? z5 : true;
        boolean z13 = (v2 & 0x2000) == 0 ? z6 : false;
        AsyncUpdates asyncUpdates1 = (v2 & 0x4000) == 0 ? asyncUpdates0 : AsyncUpdates.AUTOMATIC;
        ((p)l0).b0(0xB09407F);
        boolean z14 = (v & 0x70 ^ 0x30) > 0x20 && ((p)l0).d(f) || (v & 0x30) == 0x20;
        com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.4.1 lottieAnimationKt$LottieAnimation$4$10 = ((p)l0).N();
        if(z14 || lottieAnimationKt$LottieAnimation$4$10 == androidx.compose.runtime.k.a) {
            lottieAnimationKt$LottieAnimation$4$10 = new a(f) {
                final float $progress;

                {
                    this.$progress = f;
                    super(0);
                }

                @NotNull
                public final Float invoke() {
                    return this.$progress;
                }

                @Override  // we.a
                public Object invoke() {
                    return this.invoke();
                }
            };
            ((p)l0).l0(lottieAnimationKt$LottieAnimation$4$10);
        }
        ((p)l0).p(false);
        LottieAnimationKt.LottieAnimation(lottieComposition0, lottieAnimationKt$LottieAnimation$4$10, q1, z7, z8, z9, z10, renderMode1, z11, lottieDynamicProperties1, e1, k1, z12, false, null, asyncUpdates1, z13, ((p)l0), v & 0x1C00 | (v & 0x380 | 0x40000008) | 0xE000 & v | v & 0x70000 | v & 0x380000 | v & 0x1C00000 | v & 0xE000000, v1 & 0x3FE | v1 << 3 & 0x70000 | v1 << 9 & 0x380000, 0x6000);
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new we.n(lottieComposition0, f, q1, z7, z8, z9, z10, renderMode1, z11, lottieDynamicProperties1, e1, k1, z12, z13, asyncUpdates1, v, v1, v2) {
                final int $$changed;
                final int $$changed1;
                final int $$default;
                final e $alignment;
                final boolean $applyOpacityToLayers;
                final boolean $applyShadowToLayers;
                final AsyncUpdates $asyncUpdates;
                final boolean $clipToCompositionBounds;
                final LottieComposition $composition;
                final k $contentScale;
                final LottieDynamicProperties $dynamicProperties;
                final boolean $enableMergePaths;
                final boolean $maintainOriginalImageBounds;
                final q $modifier;
                final boolean $outlineMasksAndMattes;
                final float $progress;
                final RenderMode $renderMode;
                final boolean $safeMode;

                {
                    this.$composition = lottieComposition0;
                    this.$progress = f;
                    this.$modifier = q0;
                    this.$outlineMasksAndMattes = z;
                    this.$applyOpacityToLayers = z1;
                    this.$applyShadowToLayers = z2;
                    this.$enableMergePaths = z3;
                    this.$renderMode = renderMode0;
                    this.$maintainOriginalImageBounds = z4;
                    this.$dynamicProperties = lottieDynamicProperties0;
                    this.$alignment = e0;
                    this.$contentScale = k0;
                    this.$clipToCompositionBounds = z5;
                    this.$safeMode = z6;
                    this.$asyncUpdates = asyncUpdates0;
                    this.$$changed = v;
                    this.$$changed1 = v1;
                    this.$$default = v2;
                    super(2);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    this.invoke(((l)object0), ((Number)object1).intValue());
                    return H.a;
                }

                public final void invoke(@Nullable l l0, int v) {
                    LottieAnimationKt.LottieAnimation(this.$composition, this.$progress, this.$modifier, this.$outlineMasksAndMattes, this.$applyOpacityToLayers, this.$applyShadowToLayers, this.$enableMergePaths, this.$renderMode, this.$maintainOriginalImageBounds, this.$dynamicProperties, this.$alignment, this.$contentScale, this.$clipToCompositionBounds, this.$safeMode, this.$asyncUpdates, l0, (this.$$changed | 1) & -920350135 | ((0x24924924 & (this.$$changed | 1)) >> 1 | 306783378 & (this.$$changed | 1)) | (306783378 & (this.$$changed | 1)) << 1 & (0x24924924 & (this.$$changed | 1)), this.$$changed1 & -920350135 | ((0x24924924 & this.$$changed1) >> 1 | 306783378 & this.$$changed1) | (306783378 & this.$$changed1) << 1 & (0x24924924 & this.$$changed1), this.$$default);
                }
            };
        }
    }

    public static final void LottieAnimation(@Nullable LottieComposition lottieComposition0, @Nullable q q0, boolean z, boolean z1, @Nullable LottieClipSpec lottieClipSpec0, float f, int v, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable RenderMode renderMode0, boolean z6, boolean z7, @Nullable LottieDynamicProperties lottieDynamicProperties0, @Nullable e e0, @Nullable k k0, boolean z8, boolean z9, @Nullable Map map0, boolean z10, @Nullable AsyncUpdates asyncUpdates0, @Nullable l l0, int v1, int v2, int v3, int v4) {
        ((p)l0).c0(0x4F5919ED);
        q q1 = (v4 & 2) == 0 ? q0 : n.a;
        boolean z11 = (v4 & 4) == 0 ? z : true;
        boolean z12 = (v4 & 8) == 0 ? z1 : true;
        LottieClipSpec lottieClipSpec1 = (v4 & 16) == 0 ? lottieClipSpec0 : null;
        float f1 = (v4 & 0x20) == 0 ? f : 1.0f;
        int v5 = (v4 & 0x40) == 0 ? v : 1;
        boolean z13 = (v4 & 0x80) == 0 ? z2 : false;
        boolean z14 = (v4 & 0x100) == 0 ? z3 : false;
        boolean z15 = (v4 & 0x200) == 0 ? z4 : true;
        boolean z16 = (v4 & 0x400) == 0 ? z5 : false;
        RenderMode renderMode1 = (v4 & 0x800) == 0 ? renderMode0 : RenderMode.AUTOMATIC;
        boolean z17 = (v4 & 0x1000) == 0 ? z6 : false;
        boolean z18 = (v4 & 0x2000) == 0 ? z7 : false;
        LottieDynamicProperties lottieDynamicProperties1 = (v4 & 0x4000) == 0 ? lottieDynamicProperties0 : null;
        e e1 = (v4 & 0x8000) == 0 ? e0 : r0.d.e;
        k k1 = (v4 & 0x10000) == 0 ? k0 : j.c;
        boolean z19 = (v4 & 0x20000) == 0 ? z8 : true;
        boolean z20 = (v4 & 0x40000) == 0 ? z9 : false;
        Map map1 = (v4 & 0x80000) == 0 ? map0 : null;
        boolean z21 = (v4 & 0x100000) == 0 ? z10 : false;
        AsyncUpdates asyncUpdates1 = (v4 & 0x200000) == 0 ? asyncUpdates0 : AsyncUpdates.AUTOMATIC;
        LottieAnimationState lottieAnimationState0 = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(lottieComposition0, z11, z12, z17, lottieClipSpec1, f1, v5, null, false, false, ((p)l0), v1 >> 3 & 0x70 | 8 | v1 >> 3 & 0x380 | v2 << 3 & 0x1C00 | v1 & 0xE000 | v1 & 0x70000 | v1 & 0x380000, 0x380);
        ((p)l0).b0(0xB094889);
        boolean z22 = ((p)l0).g(lottieAnimationState0);
        com.airbnb.lottie.compose.LottieAnimationKt.LottieAnimation.6.1 lottieAnimationKt$LottieAnimation$6$10 = ((p)l0).N();
        if(z22 || lottieAnimationKt$LottieAnimation$6$10 == androidx.compose.runtime.k.a) {
            lottieAnimationKt$LottieAnimation$6$10 = new a(lottieAnimationState0) {
                final LottieAnimationState $progress$delegate;

                {
                    this.$progress$delegate = lottieAnimationState0;
                    super(0);
                }

                @NotNull
                public final Float invoke() {
                    return LottieAnimationKt.access$LottieAnimation$lambda$6(this.$progress$delegate);
                }

                @Override  // we.a
                public Object invoke() {
                    return this.invoke();
                }
            };
            ((p)l0).l0(lottieAnimationKt$LottieAnimation$6$10);
        }
        ((p)l0).p(false);
        LottieAnimationKt.LottieAnimation(lottieComposition0, lottieAnimationKt$LottieAnimation$6$10, q1, z13, z14, z15, z16, renderMode1, z18, lottieDynamicProperties1, e1, k1, z19, z20, map1, asyncUpdates1, z21, ((p)l0), v1 << 3 & 0x380 | 0x40000008 | v1 >> 12 & 0x1C00 | v1 >> 12 & 0xE000 | v1 >> 12 & 0x70000 | v2 << 18 & 0x380000 | v2 << 18 & 0x1C00000 | v2 << 15 & 0xE000000, v2 >> 15 & 14 | 0x8000 | v2 >> 15 & 0x70 | v2 >> 15 & 0x380 | v2 >> 15 & 0x1C00 | v3 << 12 & 0x70000 | v3 << 18 & 0x380000, 0);
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new we.n(lottieComposition0, q1, z11, z12, lottieClipSpec1, f1, v5, z13, z14, z15, z16, renderMode1, z17, z18, lottieDynamicProperties1, e1, k1, z19, z20, map1, z21, asyncUpdates1, v1, v2, v3, v4) {
                final int $$changed;
                final int $$changed1;
                final int $$changed2;
                final int $$default;
                final e $alignment;
                final boolean $applyOpacityToLayers;
                final boolean $applyShadowToLayers;
                final AsyncUpdates $asyncUpdates;
                final LottieClipSpec $clipSpec;
                final boolean $clipTextToBoundingBox;
                final boolean $clipToCompositionBounds;
                final LottieComposition $composition;
                final k $contentScale;
                final LottieDynamicProperties $dynamicProperties;
                final boolean $enableMergePaths;
                final Map $fontMap;
                final boolean $isPlaying;
                final int $iterations;
                final boolean $maintainOriginalImageBounds;
                final q $modifier;
                final boolean $outlineMasksAndMattes;
                final RenderMode $renderMode;
                final boolean $restartOnPlay;
                final boolean $reverseOnRepeat;
                final boolean $safeMode;
                final float $speed;

                {
                    this.$composition = lottieComposition0;
                    this.$modifier = q0;
                    this.$isPlaying = z;
                    this.$restartOnPlay = z1;
                    this.$clipSpec = lottieClipSpec0;
                    this.$speed = f;
                    this.$iterations = v;
                    this.$outlineMasksAndMattes = z2;
                    this.$applyOpacityToLayers = z3;
                    this.$applyShadowToLayers = z4;
                    this.$enableMergePaths = z5;
                    this.$renderMode = renderMode0;
                    this.$reverseOnRepeat = z6;
                    this.$maintainOriginalImageBounds = z7;
                    this.$dynamicProperties = lottieDynamicProperties0;
                    this.$alignment = e0;
                    this.$contentScale = k0;
                    this.$clipToCompositionBounds = z8;
                    this.$clipTextToBoundingBox = z9;
                    this.$fontMap = map0;
                    this.$safeMode = z10;
                    this.$asyncUpdates = asyncUpdates0;
                    this.$$changed = v1;
                    this.$$changed1 = v2;
                    this.$$changed2 = v3;
                    this.$$default = v4;
                    super(2);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    this.invoke(((l)object0), ((Number)object1).intValue());
                    return H.a;
                }

                public final void invoke(@Nullable l l0, int v) {
                    LottieAnimationKt.LottieAnimation(this.$composition, this.$modifier, this.$isPlaying, this.$restartOnPlay, this.$clipSpec, this.$speed, this.$iterations, this.$outlineMasksAndMattes, this.$applyOpacityToLayers, this.$applyShadowToLayers, this.$enableMergePaths, this.$renderMode, this.$reverseOnRepeat, this.$maintainOriginalImageBounds, this.$dynamicProperties, this.$alignment, this.$contentScale, this.$clipToCompositionBounds, this.$clipTextToBoundingBox, this.$fontMap, this.$safeMode, this.$asyncUpdates, l0, (this.$$changed | 1) & -920350135 | ((0x24924924 & (this.$$changed | 1)) >> 1 | 306783378 & (this.$$changed | 1)) | (306783378 & (this.$$changed | 1)) << 1 & (0x24924924 & (this.$$changed | 1)), this.$$changed1 & -920350135 | ((0x24924924 & this.$$changed1) >> 1 | 306783378 & this.$$changed1) | (306783378 & this.$$changed1) << 1 & (0x24924924 & this.$$changed1), this.$$changed2 & -920350135 | ((0x24924924 & this.$$changed2) >> 1 | 306783378 & this.$$changed2) | (306783378 & this.$$changed2) << 1 & (0x24924924 & this.$$changed2), this.$$default);
                }
            };
        }
    }

    @d
    public static final void LottieAnimation(LottieComposition lottieComposition0, a a0, q q0, boolean z, boolean z1, boolean z2, RenderMode renderMode0, boolean z3, LottieDynamicProperties lottieDynamicProperties0, e e0, k k0, boolean z4, boolean z5, Map map0, AsyncUpdates asyncUpdates0, boolean z6, l l0, int v, int v1, int v2) {
        kotlin.jvm.internal.q.g(a0, "progress");
        ((p)l0).c0(0xD7CF696A);
        q q1 = (v2 & 4) == 0 ? q0 : n.a;
        boolean z7 = (v2 & 8) == 0 ? z : false;
        boolean z8 = (v2 & 16) == 0 ? z1 : false;
        boolean z9 = (v2 & 0x20) == 0 ? z2 : false;
        RenderMode renderMode1 = (v2 & 0x40) == 0 ? renderMode0 : RenderMode.AUTOMATIC;
        boolean z10 = (v2 & 0x80) == 0 ? z3 : false;
        LottieDynamicProperties lottieDynamicProperties1 = (v2 & 0x100) == 0 ? lottieDynamicProperties0 : null;
        e e1 = (v2 & 0x200) == 0 ? e0 : r0.d.e;
        k k1 = (v2 & 0x400) == 0 ? k0 : j.c;
        boolean z11 = (v2 & 0x800) == 0 ? z4 : true;
        boolean z12 = (v2 & 0x1000) == 0 ? z5 : false;
        Map map1 = (v2 & 0x2000) == 0 ? map0 : null;
        AsyncUpdates asyncUpdates1 = (v2 & 0x4000) == 0 ? asyncUpdates0 : AsyncUpdates.AUTOMATIC;
        boolean z13 = (v2 & 0x8000) == 0 ? z6 : false;
        LottieAnimationKt.LottieAnimation(lottieComposition0, a0, q1, z7, z8, false, z9, renderMode1, z10, lottieDynamicProperties1, e1, k1, z11, z12, map1, asyncUpdates1, z13, ((p)l0), v & 0x380 | (v & 0x70 | 0x40030008) | v & 0x1C00 | 0xE000 & v | v << 3 & 0x380000 | v << 3 & 0x1C00000 | v << 3 & 0xE000000, v1 << 3 & 0x380 | (v >> 27 & 14 | 0x8000 | v1 << 3 & 0x70) | v1 << 3 & 0x1C00 | 0x70000 & v1 << 3 | v1 << 3 & 0x380000, 0);
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new we.n(lottieComposition0, a0, q1, z7, z8, z9, renderMode1, z10, lottieDynamicProperties1, e1, k1, z11, z12, map1, asyncUpdates1, z13, v, v1, v2) {
                final int $$changed;
                final int $$changed1;
                final int $$default;
                final e $alignment;
                final boolean $applyOpacityToLayers;
                final AsyncUpdates $asyncUpdates;
                final boolean $clipTextToBoundingBox;
                final boolean $clipToCompositionBounds;
                final LottieComposition $composition;
                final k $contentScale;
                final LottieDynamicProperties $dynamicProperties;
                final boolean $enableMergePaths;
                final Map $fontMap;
                final boolean $maintainOriginalImageBounds;
                final q $modifier;
                final boolean $outlineMasksAndMattes;
                final a $progress;
                final RenderMode $renderMode;
                final boolean $safeMode;

                {
                    this.$composition = lottieComposition0;
                    this.$progress = a0;
                    this.$modifier = q0;
                    this.$outlineMasksAndMattes = z;
                    this.$applyOpacityToLayers = z1;
                    this.$enableMergePaths = z2;
                    this.$renderMode = renderMode0;
                    this.$maintainOriginalImageBounds = z3;
                    this.$dynamicProperties = lottieDynamicProperties0;
                    this.$alignment = e0;
                    this.$contentScale = k0;
                    this.$clipToCompositionBounds = z4;
                    this.$clipTextToBoundingBox = z5;
                    this.$fontMap = map0;
                    this.$asyncUpdates = asyncUpdates0;
                    this.$safeMode = z6;
                    this.$$changed = v;
                    this.$$changed1 = v1;
                    this.$$default = v2;
                    super(2);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    this.invoke(((l)object0), ((Number)object1).intValue());
                    return H.a;
                }

                public final void invoke(@Nullable l l0, int v) {
                    LottieAnimationKt.LottieAnimation(this.$composition, this.$progress, this.$modifier, this.$outlineMasksAndMattes, this.$applyOpacityToLayers, this.$enableMergePaths, this.$renderMode, this.$maintainOriginalImageBounds, this.$dynamicProperties, this.$alignment, this.$contentScale, this.$clipToCompositionBounds, this.$clipTextToBoundingBox, this.$fontMap, this.$asyncUpdates, this.$safeMode, l0, (this.$$changed | 1) & -920350135 | ((0x24924924 & (this.$$changed | 1)) >> 1 | 306783378 & (this.$$changed | 1)) | (306783378 & (this.$$changed | 1)) << 1 & (0x24924924 & (this.$$changed | 1)), this.$$changed1 & -920350135 | ((0x24924924 & this.$$changed1) >> 1 | 306783378 & this.$$changed1) | (306783378 & this.$$changed1) << 1 & (0x24924924 & this.$$changed1), this.$$default);
                }
            };
        }
    }

    public static final void LottieAnimation(@Nullable LottieComposition lottieComposition0, @NotNull a a0, @Nullable q q0, boolean z, boolean z1, boolean z2, boolean z3, @Nullable RenderMode renderMode0, boolean z4, @Nullable LottieDynamicProperties lottieDynamicProperties0, @Nullable e e0, @Nullable k k0, boolean z5, boolean z6, @Nullable Map map0, @Nullable AsyncUpdates asyncUpdates0, boolean z7, @Nullable l l0, int v, int v1, int v2) {
        kotlin.jvm.internal.q.g(a0, "progress");
        ((p)l0).c0(382909894);
        q q1 = (v2 & 4) == 0 ? q0 : n.a;
        boolean z8 = (v2 & 8) == 0 ? z : false;
        boolean z9 = (v2 & 16) == 0 ? z1 : false;
        boolean z10 = (v2 & 0x20) == 0 ? z2 : true;
        boolean z11 = (v2 & 0x40) == 0 ? z3 : false;
        RenderMode renderMode1 = (v2 & 0x80) == 0 ? renderMode0 : RenderMode.AUTOMATIC;
        boolean z12 = (v2 & 0x100) == 0 ? z4 : false;
        LottieDynamicProperties lottieDynamicProperties1 = (v2 & 0x200) == 0 ? lottieDynamicProperties0 : null;
        e e1 = (v2 & 0x400) == 0 ? e0 : r0.d.e;
        k k1 = (v2 & 0x800) == 0 ? k0 : j.c;
        boolean z13 = (v2 & 0x1000) == 0 ? z5 : true;
        boolean z14 = (v2 & 0x2000) == 0 ? z6 : false;
        Map map1 = (v2 & 0x4000) == 0 ? map0 : null;
        AsyncUpdates asyncUpdates1 = (v2 & 0x8000) == 0 ? asyncUpdates0 : AsyncUpdates.AUTOMATIC;
        boolean z15 = (v2 & 0x10000) == 0 ? z7 : false;
        ((p)l0).b0(0xB0932B9);
        LottieDrawable lottieDrawable0 = ((p)l0).N();
        V v3 = androidx.compose.runtime.k.a;
        if(lottieDrawable0 == v3) {
            lottieDrawable0 = new LottieDrawable();
            ((p)l0).l0(lottieDrawable0);
        }
        ((p)l0).p(false);
        ((p)l0).b0(0xB0932E8);
        Matrix matrix0 = ((p)l0).N();
        if(matrix0 == v3) {
            matrix0 = new Matrix();
            ((p)l0).l0(matrix0);
        }
        ((p)l0).p(false);
        ((p)l0).b0(0xB093338);
        boolean z16 = ((p)l0).g(lottieComposition0);
        b0 b00 = ((p)l0).N();
        if(z16 || b00 == v3) {
            b00 = w.s(null);
            ((p)l0).l0(b00);
        }
        ((p)l0).p(false);
        ((p)l0).b0(0xB09336C);
        if(lottieComposition0 == null || lottieComposition0.getDuration() == 0.0f) {
            M.p.a(q1, ((p)l0), v >> 6 & 14);
            ((p)l0).p(false);
            n0 n01 = ((p)l0).t();
            if(n01 != null) {
                n01.d = new we.n(lottieComposition0, a0, q1, z8, z9, z10, z11, renderMode1, z12, lottieDynamicProperties1, e1, k1, z13, z14, map1, asyncUpdates1, z15, v, v1, v2) {
                    final int $$changed;
                    final int $$changed1;
                    final int $$default;
                    final e $alignment;
                    final boolean $applyOpacityToLayers;
                    final boolean $applyShadowToLayers;
                    final AsyncUpdates $asyncUpdates;
                    final boolean $clipTextToBoundingBox;
                    final boolean $clipToCompositionBounds;
                    final LottieComposition $composition;
                    final k $contentScale;
                    final LottieDynamicProperties $dynamicProperties;
                    final boolean $enableMergePaths;
                    final Map $fontMap;
                    final boolean $maintainOriginalImageBounds;
                    final q $modifier;
                    final boolean $outlineMasksAndMattes;
                    final a $progress;
                    final RenderMode $renderMode;
                    final boolean $safeMode;

                    {
                        this.$composition = lottieComposition0;
                        this.$progress = a0;
                        this.$modifier = q0;
                        this.$outlineMasksAndMattes = z;
                        this.$applyOpacityToLayers = z1;
                        this.$applyShadowToLayers = z2;
                        this.$enableMergePaths = z3;
                        this.$renderMode = renderMode0;
                        this.$maintainOriginalImageBounds = z4;
                        this.$dynamicProperties = lottieDynamicProperties0;
                        this.$alignment = e0;
                        this.$contentScale = k0;
                        this.$clipToCompositionBounds = z5;
                        this.$clipTextToBoundingBox = z6;
                        this.$fontMap = map0;
                        this.$asyncUpdates = asyncUpdates0;
                        this.$safeMode = z7;
                        this.$$changed = v;
                        this.$$changed1 = v1;
                        this.$$default = v2;
                        super(2);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        this.invoke(((l)object0), ((Number)object1).intValue());
                        return H.a;
                    }

                    public final void invoke(@Nullable l l0, int v) {
                        LottieAnimationKt.LottieAnimation(this.$composition, this.$progress, this.$modifier, this.$outlineMasksAndMattes, this.$applyOpacityToLayers, this.$applyShadowToLayers, this.$enableMergePaths, this.$renderMode, this.$maintainOriginalImageBounds, this.$dynamicProperties, this.$alignment, this.$contentScale, this.$clipToCompositionBounds, this.$clipTextToBoundingBox, this.$fontMap, this.$asyncUpdates, this.$safeMode, l0, (this.$$changed | 1) & -920350135 | ((0x24924924 & (this.$$changed | 1)) >> 1 | 306783378 & (this.$$changed | 1)) | (306783378 & (this.$$changed | 1)) << 1 & (0x24924924 & (this.$$changed | 1)), this.$$changed1 & -920350135 | ((0x24924924 & this.$$changed1) >> 1 | 306783378 & this.$$changed1) | (306783378 & this.$$changed1) << 1 & (0x24924924 & this.$$changed1), this.$$default);
                    }
                };
            }
        }
        else {
            ((p)l0).p(false);
            Rect rect0 = lottieComposition0.getBounds();
            Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
            androidx.compose.foundation.q.b(LottieAnimationSizeNodeKt.lottieSize(q1, rect0.width(), rect0.height()), new we.k(rect0, k1, e1, matrix0, lottieDrawable0, z11, z15, renderMode1, asyncUpdates1, lottieComposition0, map1, lottieDynamicProperties1, z8, z9, z10, z12, z13, z14, context0, a0, b00) {
                final e $alignment;
                final boolean $applyOpacityToLayers;
                final boolean $applyShadowToLayers;
                final AsyncUpdates $asyncUpdates;
                final Rect $bounds;
                final boolean $clipTextToBoundingBox;
                final boolean $clipToCompositionBounds;
                final LottieComposition $composition;
                final k $contentScale;
                final Context $context;
                final LottieDrawable $drawable;
                final LottieDynamicProperties $dynamicProperties;
                final boolean $enableMergePaths;
                final Map $fontMap;
                final boolean $maintainOriginalImageBounds;
                final Matrix $matrix;
                final boolean $outlineMasksAndMattes;
                final a $progress;
                final RenderMode $renderMode;
                final boolean $safeMode;
                final b0 $setDynamicProperties$delegate;

                {
                    this.$bounds = rect0;
                    this.$contentScale = k0;
                    this.$alignment = e0;
                    this.$matrix = matrix0;
                    this.$drawable = lottieDrawable0;
                    this.$enableMergePaths = z;
                    this.$safeMode = z1;
                    this.$renderMode = renderMode0;
                    this.$asyncUpdates = asyncUpdates0;
                    this.$composition = lottieComposition0;
                    this.$fontMap = map0;
                    this.$dynamicProperties = lottieDynamicProperties0;
                    this.$outlineMasksAndMattes = z2;
                    this.$applyOpacityToLayers = z3;
                    this.$applyShadowToLayers = z4;
                    this.$maintainOriginalImageBounds = z5;
                    this.$clipToCompositionBounds = z6;
                    this.$clipTextToBoundingBox = z7;
                    this.$context = context0;
                    this.$progress = a0;
                    this.$setDynamicProperties$delegate = b00;
                    super(1);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((f)object0));
                    return H.a;
                }

                public final void invoke(@NotNull f f0) {
                    kotlin.jvm.internal.q.g(f0, "$this$Canvas");
                    Matrix matrix0 = this.$matrix;
                    LottieDrawable lottieDrawable0 = this.$drawable;
                    Rect rect0 = this.$bounds;
                    boolean z = this.$maintainOriginalImageBounds;
                    boolean z1 = this.$clipToCompositionBounds;
                    boolean z2 = this.$clipTextToBoundingBox;
                    Context context0 = this.$context;
                    a a0 = this.$progress;
                    b0 b00 = this.$setDynamicProperties$delegate;
                    y0.q q0 = f0.a0().h();
                    long v = m.i(rect0.width(), rect0.height());
                    long v1 = e1.n.c(ye.a.V(x0.e.d(f0.c())), ye.a.V(x0.e.b(f0.c())));
                    long v2 = f0.c();
                    long v3 = this.$contentScale.a(v, v2);
                    long v4 = LottieAnimationKt.access$times-UQTWf7w(v, v3);
                    r1.m m0 = f0.getLayoutDirection();
                    boolean z3 = this.$outlineMasksAndMattes;
                    boolean z4 = this.$applyOpacityToLayers;
                    LottieDynamicProperties lottieDynamicProperties0 = this.$dynamicProperties;
                    boolean z5 = this.$applyShadowToLayers;
                    long v5 = this.$alignment.a(v4, v1, m0);
                    matrix0.reset();
                    matrix0.preTranslate(((float)(((int)(v5 >> 0x20)))), ((float)(((int)(v5 & 0xFFFFFFFFL)))));
                    matrix0.preScale(Float.intBitsToFloat(((int)(v3 >> 0x20))), Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))));
                    lottieDrawable0.enableFeatureFlag(LottieFeatureFlag.MergePathsApi19, this.$enableMergePaths);
                    lottieDrawable0.setSafeMode(this.$safeMode);
                    lottieDrawable0.setRenderMode(this.$renderMode);
                    lottieDrawable0.setAsyncUpdates(this.$asyncUpdates);
                    lottieDrawable0.setComposition(this.$composition);
                    lottieDrawable0.setFontMap(this.$fontMap);
                    if(lottieDynamicProperties0 != LottieAnimationKt.access$LottieAnimation$lambda$3(b00)) {
                        LottieDynamicProperties lottieDynamicProperties1 = LottieAnimationKt.access$LottieAnimation$lambda$3(b00);
                        if(lottieDynamicProperties1 != null) {
                            lottieDynamicProperties1.removeFrom$lottie_compose_release(lottieDrawable0);
                        }
                        if(lottieDynamicProperties0 != null) {
                            lottieDynamicProperties0.addTo$lottie_compose_release(lottieDrawable0);
                        }
                        LottieAnimationKt.access$LottieAnimation$lambda$4(b00, lottieDynamicProperties0);
                    }
                    lottieDrawable0.setOutlineMasksAndMattes(z3);
                    lottieDrawable0.setApplyingOpacityToLayersEnabled(z4);
                    lottieDrawable0.setApplyingShadowToLayersEnabled(z5);
                    lottieDrawable0.setMaintainOriginalImageBounds(z);
                    lottieDrawable0.setClipToCompositionBounds(z1);
                    lottieDrawable0.setClipTextToBoundingBox(z2);
                    Marker marker0 = lottieDrawable0.getMarkerForAnimationsDisabled();
                    if(lottieDrawable0.animationsEnabled(context0) || marker0 == null) {
                        lottieDrawable0.setProgress(((Number)a0.invoke()).floatValue());
                    }
                    else {
                        lottieDrawable0.setProgress(marker0.startFrame);
                    }
                    lottieDrawable0.setBounds(0, 0, rect0.width(), rect0.height());
                    lottieDrawable0.draw(c.a(q0), matrix0);
                }
            }, ((p)l0), 0);
            n0 n00 = ((p)l0).t();
            if(n00 != null) {
                n00.d = new we.n(lottieComposition0, a0, q1, z8, z9, z10, z11, renderMode1, z12, lottieDynamicProperties1, e1, k1, z13, z14, map1, asyncUpdates1, z15, v, v1, v2) {
                    final int $$changed;
                    final int $$changed1;
                    final int $$default;
                    final e $alignment;
                    final boolean $applyOpacityToLayers;
                    final boolean $applyShadowToLayers;
                    final AsyncUpdates $asyncUpdates;
                    final boolean $clipTextToBoundingBox;
                    final boolean $clipToCompositionBounds;
                    final LottieComposition $composition;
                    final k $contentScale;
                    final LottieDynamicProperties $dynamicProperties;
                    final boolean $enableMergePaths;
                    final Map $fontMap;
                    final boolean $maintainOriginalImageBounds;
                    final q $modifier;
                    final boolean $outlineMasksAndMattes;
                    final a $progress;
                    final RenderMode $renderMode;
                    final boolean $safeMode;

                    {
                        this.$composition = lottieComposition0;
                        this.$progress = a0;
                        this.$modifier = q0;
                        this.$outlineMasksAndMattes = z;
                        this.$applyOpacityToLayers = z1;
                        this.$applyShadowToLayers = z2;
                        this.$enableMergePaths = z3;
                        this.$renderMode = renderMode0;
                        this.$maintainOriginalImageBounds = z4;
                        this.$dynamicProperties = lottieDynamicProperties0;
                        this.$alignment = e0;
                        this.$contentScale = k0;
                        this.$clipToCompositionBounds = z5;
                        this.$clipTextToBoundingBox = z6;
                        this.$fontMap = map0;
                        this.$asyncUpdates = asyncUpdates0;
                        this.$safeMode = z7;
                        this.$$changed = v;
                        this.$$changed1 = v1;
                        this.$$default = v2;
                        super(2);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        this.invoke(((l)object0), ((Number)object1).intValue());
                        return H.a;
                    }

                    public final void invoke(@Nullable l l0, int v) {
                        LottieAnimationKt.LottieAnimation(this.$composition, this.$progress, this.$modifier, this.$outlineMasksAndMattes, this.$applyOpacityToLayers, this.$applyShadowToLayers, this.$enableMergePaths, this.$renderMode, this.$maintainOriginalImageBounds, this.$dynamicProperties, this.$alignment, this.$contentScale, this.$clipToCompositionBounds, this.$clipTextToBoundingBox, this.$fontMap, this.$asyncUpdates, this.$safeMode, l0, (this.$$changed | 1) & -920350135 | ((0x24924924 & (this.$$changed | 1)) >> 1 | 306783378 & (this.$$changed | 1)) | (306783378 & (this.$$changed | 1)) << 1 & (0x24924924 & (this.$$changed | 1)), this.$$changed1 & -920350135 | ((0x24924924 & this.$$changed1) >> 1 | 306783378 & this.$$changed1) | (306783378 & this.$$changed1) << 1 & (0x24924924 & this.$$changed1), this.$$default);
                    }
                };
            }
        }
    }

    private static final LottieDynamicProperties LottieAnimation$lambda$3(b0 b00) {
        return (LottieDynamicProperties)b00.getValue();
    }

    private static final void LottieAnimation$lambda$4(b0 b00, LottieDynamicProperties lottieDynamicProperties0) {
        b00.setValue(lottieDynamicProperties0);
    }

    private static final float LottieAnimation$lambda$6(LottieAnimationState lottieAnimationState0) {
        return ((Number)lottieAnimationState0.getValue()).floatValue();
    }

    public static final LottieDynamicProperties access$LottieAnimation$lambda$3(b0 b00) {
        return LottieAnimationKt.LottieAnimation$lambda$3(b00);
    }

    public static final void access$LottieAnimation$lambda$4(b0 b00, LottieDynamicProperties lottieDynamicProperties0) {
        LottieAnimationKt.LottieAnimation$lambda$4(b00, lottieDynamicProperties0);
    }

    public static final float access$LottieAnimation$lambda$6(LottieAnimationState lottieAnimationState0) {
        return LottieAnimationKt.LottieAnimation$lambda$6(lottieAnimationState0);
    }

    public static final long access$times-UQTWf7w(long v, long v1) {
        return LottieAnimationKt.times-UQTWf7w(v, v1);
    }

    private static final long times-UQTWf7w(long v, long v1) {
        return ((long)(((int)(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) * x0.e.b(v))))) & 0xFFFFFFFFL | ((long)(((int)(Float.intBitsToFloat(((int)(v1 >> 0x20))) * x0.e.d(v))))) << 0x20;
    }
}

