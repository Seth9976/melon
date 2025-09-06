package com.kakaoent.leonplayer.core.event;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Landroid/graphics/Bitmap;", "image", "Lie/H;", "onPosterImageLoaded", "(Landroid/graphics/Bitmap;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface PosterImageEventListener extends LeonPlayerEventListener {
    void onPosterImageLoaded(@Nullable Bitmap arg1);
}

