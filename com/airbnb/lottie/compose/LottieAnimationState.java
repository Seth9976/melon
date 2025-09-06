package com.airbnb.lottie.compose;

import androidx.compose.runtime.b1;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0014\u0010\u0004\u001A\u00020\u00038&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001A\u00020\u00028&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001A\u00020\t8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\t8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0014\u0010\u0010\u001A\u00020\u00038&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0005R\u0016\u0010\u0014\u001A\u0004\u0018\u00010\u00118&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\u00028&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0018\u001A\u00020\u00038&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0005R\u0016\u0010\u001C\u001A\u0004\u0018\u00010\u00198&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010 \u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010!\u001A\u00020\u00038&X¦\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0005¨\u0006\""}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimationState;", "Landroidx/compose/runtime/b1;", "", "", "isPlaying", "()Z", "getProgress", "()F", "progress", "", "getIteration", "()I", "iteration", "getIterations", "iterations", "getReverseOnRepeat", "reverseOnRepeat", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "getClipSpec", "()Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "getSpeed", "speed", "getUseCompositionFrameRate", "useCompositionFrameRate", "Lcom/airbnb/lottie/LottieComposition;", "getComposition", "()Lcom/airbnb/lottie/LottieComposition;", "composition", "", "getLastFrameNanos", "()J", "lastFrameNanos", "isAtEnd", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface LottieAnimationState extends b1 {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static long getLastFrameNanos(@NotNull LottieAnimationState lottieAnimationState0) [...] // Inlined contents
    }

    @Nullable
    LottieClipSpec getClipSpec();

    @Nullable
    LottieComposition getComposition();

    int getIteration();

    int getIterations();

    long getLastFrameNanos();

    float getProgress();

    boolean getReverseOnRepeat();

    float getSpeed();

    boolean getUseCompositionFrameRate();

    @Override  // androidx.compose.runtime.b1
    Object getValue();

    boolean isAtEnd();

    boolean isPlaying();
}

