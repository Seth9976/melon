package com.airbnb.lottie.compose;

import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.airbnb.lottie.AsyncUpdates;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.RenderMode;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x0.e;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0099\u0001\u0010\u0016\u001A\u00020\u00152\n\b\u0002\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u00042\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\r\u001A\u00020\u00042\b\b\u0002\u0010\u000E\u001A\u00020\u00042\u0016\b\u0002\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u001F\u0010\u001E\u001A\u00020\u001B*\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0019H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b\u001C\u0010\u001D\u0082\u0002\u0007\n\u0005\b¡\u001E0\u0001¨\u0006\u001F"}, d2 = {"Lcom/airbnb/lottie/LottieComposition;", "composition", "", "progress", "", "outlineMasksAndMattes", "applyOpacityToLayers", "enableMergePaths", "Lcom/airbnb/lottie/RenderMode;", "renderMode", "maintainOriginalImageBounds", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "dynamicProperties", "clipToCompositionBounds", "clipTextToBoundingBox", "", "", "Landroid/graphics/Typeface;", "fontMap", "Lcom/airbnb/lottie/AsyncUpdates;", "asyncUpdates", "Lcom/airbnb/lottie/compose/LottiePainter;", "rememberLottiePainter", "(Lcom/airbnb/lottie/LottieComposition;FZZZLcom/airbnb/lottie/RenderMode;ZLcom/airbnb/lottie/compose/LottieDynamicProperties;ZZLjava/util/Map;Lcom/airbnb/lottie/AsyncUpdates;Landroidx/compose/runtime/l;III)Lcom/airbnb/lottie/compose/LottiePainter;", "Lx0/e;", "LN0/e0;", "scale", "Lr1/l;", "times-UQTWf7w", "(JJ)J", "times", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class LottiePainterKt {
    @NotNull
    public static final LottiePainter rememberLottiePainter(@Nullable LottieComposition lottieComposition0, float f, boolean z, boolean z1, boolean z2, @Nullable RenderMode renderMode0, boolean z3, @Nullable LottieDynamicProperties lottieDynamicProperties0, boolean z4, boolean z5, @Nullable Map map0, @Nullable AsyncUpdates asyncUpdates0, @Nullable l l0, int v, int v1, int v2) {
        ((p)l0).b0(-1760390310);
        Map map1 = null;
        RenderMode renderMode1 = (v2 & 0x20) == 0 ? renderMode0 : RenderMode.AUTOMATIC;
        if((v2 & 0x400) == 0) {
            map1 = map0;
        }
        AsyncUpdates asyncUpdates1 = (v2 & 0x800) == 0 ? asyncUpdates0 : AsyncUpdates.AUTOMATIC;
        ((p)l0).b0(0x50DFCDF0);
        LottiePainter lottiePainter0 = ((p)l0).N();
        if(lottiePainter0 == k.a) {
            lottiePainter0 = new LottiePainter(null, 0.0f, false, false, false, null, false, null, false, false, null, null, 0xFFF, null);
            ((p)l0).l0(lottiePainter0);
        }
        ((p)l0).p(false);
        lottiePainter0.setComposition$lottie_compose_release(((v2 & 1) == 0 ? lottieComposition0 : null));
        lottiePainter0.setProgress$lottie_compose_release(((v2 & 2) == 0 ? f : 0.0f));
        lottiePainter0.setOutlineMasksAndMattes$lottie_compose_release(((v2 & 4) == 0 ? z : false));
        lottiePainter0.setApplyOpacityToLayers$lottie_compose_release(((v2 & 8) == 0 ? z1 : false));
        lottiePainter0.setEnableMergePaths$lottie_compose_release(((v2 & 16) == 0 ? z2 : false));
        lottiePainter0.setRenderMode$lottie_compose_release(renderMode1);
        lottiePainter0.setMaintainOriginalImageBounds$lottie_compose_release(((v2 & 0x40) == 0 ? z3 : false));
        lottiePainter0.setDynamicProperties$lottie_compose_release(((v2 & 0x80) == 0 ? lottieDynamicProperties0 : null));
        lottiePainter0.setClipToCompositionBounds$lottie_compose_release(((v2 & 0x100) == 0 ? z4 : true));
        lottiePainter0.setClipTextToBoundingBox$lottie_compose_release(((v2 & 0x200) == 0 ? z5 : false));
        lottiePainter0.setFontMap$lottie_compose_release(map1);
        lottiePainter0.setAsyncUpdates$lottie_compose_release(asyncUpdates1);
        ((p)l0).p(false);
        return lottiePainter0;
    }

    private static final long times-UQTWf7w(long v, long v1) {
        return ((long)(((int)(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) * e.b(v))))) & 0xFFFFFFFFL | ((long)(((int)(Float.intBitsToFloat(((int)(v1 >> 0x20))) * e.d(v))))) << 0x20;
    }
}

