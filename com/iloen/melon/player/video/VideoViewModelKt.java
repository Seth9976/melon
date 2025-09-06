package com.iloen.melon.player.video;

import androidx.window.layout.FoldingFeature.State;
import androidx.window.layout.FoldingFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isHalfOpened", "", "Lcom/iloen/melon/player/video/VideoViewModel$FoldingFeatureAndScreenLayout;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class VideoViewModelKt {
    public static final boolean isHalfOpened(@Nullable FoldingFeatureAndScreenLayout videoViewModel$FoldingFeatureAndScreenLayout0) {
        if(videoViewModel$FoldingFeatureAndScreenLayout0 != null) {
            FoldingFeature foldingFeature0 = videoViewModel$FoldingFeatureAndScreenLayout0.getFoldingFeature();
            return q.b((foldingFeature0 == null ? null : foldingFeature0.getState()), State.HALF_OPENED);
        }
        return false;
    }
}

