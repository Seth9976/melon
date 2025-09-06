package com.airbnb.lottie.compose;

import A0.f;
import C0.c;
import android.graphics.Canvas;
import android.graphics.Matrix;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import com.airbnb.lottie.AsyncUpdates;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieFeatureFlag;
import com.airbnb.lottie.RenderMode;
import e1.m;
import e1.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x0.e;
import ye.a;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0093\u0001\b\u0000\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\f\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0006\u0012\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001B\u001A\u00020\u001A*\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CR/\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u001D\u001A\u0004\u0018\u00010\u00028@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u00048@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R+\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00068@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b*\u0010\u001F\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R+\u0010\b\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00068@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b/\u0010\u001F\u001A\u0004\b0\u0010,\"\u0004\b1\u0010.R+\u0010\t\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00068@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b2\u0010\u001F\u001A\u0004\b3\u0010,\"\u0004\b4\u0010.R+\u0010\u000B\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\n8@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b5\u0010\u001F\u001A\u0004\b6\u00107\"\u0004\b8\u00109R+\u0010\f\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00068@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b:\u0010\u001F\u001A\u0004\b;\u0010,\"\u0004\b<\u0010.R/\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u001D\u001A\u0004\u0018\u00010\r8@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\b=\u0010\u001F\u001A\u0004\b>\u0010?\"\u0004\b@\u0010AR+\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00068@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\bB\u0010\u001F\u001A\u0004\bC\u0010,\"\u0004\bD\u0010.RG\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00112\u0014\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00118@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\bE\u0010\u001F\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR+\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u001D\u001A\u00020\u00158@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\bJ\u0010\u001F\u001A\u0004\bK\u0010L\"\u0004\bM\u0010NR+\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00068@@@X\u0080\u008E\u0002\u00A2\u0006\u0012\n\u0004\bO\u0010\u001F\u001A\u0004\bP\u0010,\"\u0004\bQ\u0010.R\u0018\u0010R\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001A\u00020T8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001A\u00020W8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u001A\u0010]\u001A\u00020Z8VX\u0096\u0004\u00F8\u0001\u0000\u00F8\u0001\u0001\u00A2\u0006\u0006\u001A\u0004\b[\u0010\\\u0082\u0002\u000B\n\u0005\b\u00A1\u001E0\u0001\n\u0002\b!\u00A8\u0006^"}, d2 = {"Lcom/airbnb/lottie/compose/LottiePainter;", "LC0/c;", "Lcom/airbnb/lottie/LottieComposition;", "composition", "", "progress", "", "outlineMasksAndMattes", "applyOpacityToLayers", "enableMergePaths", "Lcom/airbnb/lottie/RenderMode;", "renderMode", "maintainOriginalImageBounds", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "dynamicProperties", "clipToCompositionBounds", "clipTextToBoundingBox", "", "", "Landroid/graphics/Typeface;", "fontMap", "Lcom/airbnb/lottie/AsyncUpdates;", "asyncUpdates", "<init>", "(Lcom/airbnb/lottie/LottieComposition;FZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;)V", "LA0/f;", "Lie/H;", "onDraw", "(LA0/f;)V", "<set-?>", "composition$delegate", "Landroidx/compose/runtime/b0;", "getComposition$lottie_compose_release", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition$lottie_compose_release", "(Lcom/airbnb/lottie/LottieComposition;)V", "progress$delegate", "Landroidx/compose/runtime/Z;", "getProgress$lottie_compose_release", "()F", "setProgress$lottie_compose_release", "(F)V", "outlineMasksAndMattes$delegate", "getOutlineMasksAndMattes$lottie_compose_release", "()Z", "setOutlineMasksAndMattes$lottie_compose_release", "(Z)V", "applyOpacityToLayers$delegate", "getApplyOpacityToLayers$lottie_compose_release", "setApplyOpacityToLayers$lottie_compose_release", "enableMergePaths$delegate", "getEnableMergePaths$lottie_compose_release", "setEnableMergePaths$lottie_compose_release", "renderMode$delegate", "getRenderMode$lottie_compose_release", "()Lcom/airbnb/lottie/RenderMode;", "setRenderMode$lottie_compose_release", "(Lcom/airbnb/lottie/RenderMode;)V", "maintainOriginalImageBounds$delegate", "getMaintainOriginalImageBounds$lottie_compose_release", "setMaintainOriginalImageBounds$lottie_compose_release", "dynamicProperties$delegate", "getDynamicProperties$lottie_compose_release", "()Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "setDynamicProperties$lottie_compose_release", "(Lcom/airbnb/lottie/compose/LottieDynamicProperties;)V", "clipToCompositionBounds$delegate", "getClipToCompositionBounds$lottie_compose_release", "setClipToCompositionBounds$lottie_compose_release", "fontMap$delegate", "getFontMap$lottie_compose_release", "()Ljava/util/Map;", "setFontMap$lottie_compose_release", "(Ljava/util/Map;)V", "asyncUpdates$delegate", "getAsyncUpdates$lottie_compose_release", "()Lcom/airbnb/lottie/AsyncUpdates;", "setAsyncUpdates$lottie_compose_release", "(Lcom/airbnb/lottie/AsyncUpdates;)V", "clipTextToBoundingBox$delegate", "getClipTextToBoundingBox$lottie_compose_release", "setClipTextToBoundingBox$lottie_compose_release", "setDynamicProperties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "Lcom/airbnb/lottie/LottieDrawable;", "drawable", "Lcom/airbnb/lottie/LottieDrawable;", "Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/Matrix;", "Lx0/e;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottiePainter extends c {
    public static final int $stable = 8;
    @NotNull
    private final b0 applyOpacityToLayers$delegate;
    @NotNull
    private final b0 asyncUpdates$delegate;
    @NotNull
    private final b0 clipTextToBoundingBox$delegate;
    @NotNull
    private final b0 clipToCompositionBounds$delegate;
    @NotNull
    private final b0 composition$delegate;
    @NotNull
    private final LottieDrawable drawable;
    @NotNull
    private final b0 dynamicProperties$delegate;
    @NotNull
    private final b0 enableMergePaths$delegate;
    @NotNull
    private final b0 fontMap$delegate;
    @NotNull
    private final b0 maintainOriginalImageBounds$delegate;
    @NotNull
    private final Matrix matrix;
    @NotNull
    private final b0 outlineMasksAndMattes$delegate;
    @NotNull
    private final Z progress$delegate;
    @NotNull
    private final b0 renderMode$delegate;
    @Nullable
    private LottieDynamicProperties setDynamicProperties;

    public LottiePainter() {
        this(null, 0.0f, false, false, false, null, false, null, false, false, null, null, 0xFFF, null);
    }

    public LottiePainter(@Nullable LottieComposition lottieComposition0, float f, boolean z, boolean z1, boolean z2, @NotNull RenderMode renderMode0, boolean z3, @Nullable LottieDynamicProperties lottieDynamicProperties0, boolean z4, boolean z5, @Nullable Map map0, @NotNull AsyncUpdates asyncUpdates0) {
        q.g(renderMode0, "renderMode");
        q.g(asyncUpdates0, "asyncUpdates");
        super();
        this.composition$delegate = w.s(lottieComposition0);
        this.progress$delegate = w.o(f);
        this.outlineMasksAndMattes$delegate = w.s(Boolean.valueOf(z));
        this.applyOpacityToLayers$delegate = w.s(Boolean.valueOf(z1));
        this.enableMergePaths$delegate = w.s(Boolean.valueOf(z2));
        this.renderMode$delegate = w.s(renderMode0);
        this.maintainOriginalImageBounds$delegate = w.s(Boolean.valueOf(z3));
        this.dynamicProperties$delegate = w.s(lottieDynamicProperties0);
        this.clipToCompositionBounds$delegate = w.s(Boolean.valueOf(z4));
        this.fontMap$delegate = w.s(map0);
        this.asyncUpdates$delegate = w.s(asyncUpdates0);
        this.clipTextToBoundingBox$delegate = w.s(Boolean.valueOf(z5));
        this.drawable = new LottieDrawable();
        this.matrix = new Matrix();
    }

    public LottiePainter(LottieComposition lottieComposition0, float f, boolean z, boolean z1, boolean z2, RenderMode renderMode0, boolean z3, LottieDynamicProperties lottieDynamicProperties0, boolean z4, boolean z5, Map map0, AsyncUpdates asyncUpdates0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        Map map1 = null;
        if((v & 1) != 0) {
            lottieComposition0 = null;
        }
        if((v & 2) != 0) {
            f = 0.0f;
        }
        boolean z6 = false;
        RenderMode renderMode1 = (v & 0x20) == 0 ? renderMode0 : RenderMode.AUTOMATIC;
        if((v & 0x200) == 0) {
            z6 = z5;
        }
        if((v & 0x400) == 0) {
            map1 = map0;
        }
        this(lottieComposition0, f, ((v & 4) == 0 ? z : false), ((v & 8) == 0 ? z1 : false), ((v & 16) == 0 ? z2 : false), renderMode1, ((v & 0x40) == 0 ? z3 : false), ((v & 0x80) == 0 ? lottieDynamicProperties0 : null), ((v & 0x100) == 0 ? z4 : true), z6, map1, ((v & 0x800) == 0 ? asyncUpdates0 : AsyncUpdates.AUTOMATIC));
    }

    public final boolean getApplyOpacityToLayers$lottie_compose_release() {
        return ((Boolean)this.applyOpacityToLayers$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final AsyncUpdates getAsyncUpdates$lottie_compose_release() {
        return (AsyncUpdates)this.asyncUpdates$delegate.getValue();
    }

    public final boolean getClipTextToBoundingBox$lottie_compose_release() {
        return ((Boolean)this.clipTextToBoundingBox$delegate.getValue()).booleanValue();
    }

    public final boolean getClipToCompositionBounds$lottie_compose_release() {
        return ((Boolean)this.clipToCompositionBounds$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final LottieComposition getComposition$lottie_compose_release() {
        return (LottieComposition)this.composition$delegate.getValue();
    }

    @Nullable
    public final LottieDynamicProperties getDynamicProperties$lottie_compose_release() {
        return (LottieDynamicProperties)this.dynamicProperties$delegate.getValue();
    }

    public final boolean getEnableMergePaths$lottie_compose_release() {
        return ((Boolean)this.enableMergePaths$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final Map getFontMap$lottie_compose_release() {
        return (Map)this.fontMap$delegate.getValue();
    }

    @Override  // C0.c
    public long getIntrinsicSize-NH-jbRc() {
        LottieComposition lottieComposition0 = this.getComposition$lottie_compose_release();
        return lottieComposition0 == null ? 0x7FC000007FC00000L : m.i(lottieComposition0.getBounds().width(), lottieComposition0.getBounds().height());
    }

    public final boolean getMaintainOriginalImageBounds$lottie_compose_release() {
        return ((Boolean)this.maintainOriginalImageBounds$delegate.getValue()).booleanValue();
    }

    public final boolean getOutlineMasksAndMattes$lottie_compose_release() {
        return ((Boolean)this.outlineMasksAndMattes$delegate.getValue()).booleanValue();
    }

    public final float getProgress$lottie_compose_release() {
        return ((I0)this.progress$delegate).m();
    }

    @NotNull
    public final RenderMode getRenderMode$lottie_compose_release() {
        return (RenderMode)this.renderMode$delegate.getValue();
    }

    @Override  // C0.c
    public void onDraw(@NotNull f f0) {
        q.g(f0, "<this>");
        LottieComposition lottieComposition0 = this.getComposition$lottie_compose_release();
        if(lottieComposition0 == null) {
            return;
        }
        y0.q q0 = f0.a0().h();
        long v = m.i(lottieComposition0.getBounds().width(), lottieComposition0.getBounds().height());
        long v1 = n.c(a.V(e.d(f0.c())), a.V(e.b(f0.c())));
        this.matrix.reset();
        this.matrix.preScale(((float)(((int)(v1 >> 0x20)))) / e.d(v), ((float)(((int)(v1 & 0xFFFFFFFFL)))) / e.b(v));
        boolean z = this.getEnableMergePaths$lottie_compose_release();
        this.drawable.enableFeatureFlag(LottieFeatureFlag.MergePathsApi19, z);
        RenderMode renderMode0 = this.getRenderMode$lottie_compose_release();
        this.drawable.setRenderMode(renderMode0);
        AsyncUpdates asyncUpdates0 = this.getAsyncUpdates$lottie_compose_release();
        this.drawable.setAsyncUpdates(asyncUpdates0);
        this.drawable.setComposition(lottieComposition0);
        Map map0 = this.getFontMap$lottie_compose_release();
        this.drawable.setFontMap(map0);
        LottieDynamicProperties lottieDynamicProperties0 = this.getDynamicProperties$lottie_compose_release();
        LottieDynamicProperties lottieDynamicProperties1 = this.setDynamicProperties;
        if(lottieDynamicProperties0 != lottieDynamicProperties1) {
            if(lottieDynamicProperties1 != null) {
                lottieDynamicProperties1.removeFrom$lottie_compose_release(this.drawable);
            }
            LottieDynamicProperties lottieDynamicProperties2 = this.getDynamicProperties$lottie_compose_release();
            if(lottieDynamicProperties2 != null) {
                lottieDynamicProperties2.addTo$lottie_compose_release(this.drawable);
            }
            this.setDynamicProperties = this.getDynamicProperties$lottie_compose_release();
        }
        boolean z1 = this.getOutlineMasksAndMattes$lottie_compose_release();
        this.drawable.setOutlineMasksAndMattes(z1);
        boolean z2 = this.getApplyOpacityToLayers$lottie_compose_release();
        this.drawable.setApplyingOpacityToLayersEnabled(z2);
        boolean z3 = this.getMaintainOriginalImageBounds$lottie_compose_release();
        this.drawable.setMaintainOriginalImageBounds(z3);
        boolean z4 = this.getClipToCompositionBounds$lottie_compose_release();
        this.drawable.setClipToCompositionBounds(z4);
        boolean z5 = this.getClipTextToBoundingBox$lottie_compose_release();
        this.drawable.setClipTextToBoundingBox(z5);
        float f1 = this.getProgress$lottie_compose_release();
        this.drawable.setProgress(f1);
        int v2 = lottieComposition0.getBounds().width();
        int v3 = lottieComposition0.getBounds().height();
        this.drawable.setBounds(0, 0, v2, v3);
        Canvas canvas0 = y0.c.a(q0);
        this.drawable.draw(canvas0, this.matrix);
    }

    public final void setApplyOpacityToLayers$lottie_compose_release(boolean z) {
        this.applyOpacityToLayers$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setAsyncUpdates$lottie_compose_release(@NotNull AsyncUpdates asyncUpdates0) {
        q.g(asyncUpdates0, "<set-?>");
        this.asyncUpdates$delegate.setValue(asyncUpdates0);
    }

    public final void setClipTextToBoundingBox$lottie_compose_release(boolean z) {
        this.clipTextToBoundingBox$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setClipToCompositionBounds$lottie_compose_release(boolean z) {
        this.clipToCompositionBounds$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setComposition$lottie_compose_release(@Nullable LottieComposition lottieComposition0) {
        this.composition$delegate.setValue(lottieComposition0);
    }

    public final void setDynamicProperties$lottie_compose_release(@Nullable LottieDynamicProperties lottieDynamicProperties0) {
        this.dynamicProperties$delegate.setValue(lottieDynamicProperties0);
    }

    public final void setEnableMergePaths$lottie_compose_release(boolean z) {
        this.enableMergePaths$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setFontMap$lottie_compose_release(@Nullable Map map0) {
        this.fontMap$delegate.setValue(map0);
    }

    public final void setMaintainOriginalImageBounds$lottie_compose_release(boolean z) {
        this.maintainOriginalImageBounds$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setOutlineMasksAndMattes$lottie_compose_release(boolean z) {
        this.outlineMasksAndMattes$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setProgress$lottie_compose_release(float f) {
        ((I0)this.progress$delegate).n(f);
    }

    public final void setRenderMode$lottie_compose_release(@NotNull RenderMode renderMode0) {
        q.g(renderMode0, "<set-?>");
        this.renderMode$delegate.setValue(renderMode0);
    }
}

