package com.google.android.exoplayer2.source.ads;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public interface AdsLoader {
    public interface AdViewProvider {
        View[] getAdOverlayViews();

        ViewGroup getAdViewGroup();
    }

    public interface EventListener {
        default void onAdClicked() {
        }

        default void onAdLoadError(AdLoadException adsMediaSource$AdLoadException0, DataSpec dataSpec0) {
        }

        default void onAdPlaybackState(AdPlaybackState adPlaybackState0) {
        }

        default void onAdTapped() {
        }
    }

    void handlePrepareError(int arg1, int arg2, IOException arg3);

    void release();

    void setPlayer(Player arg1);

    void setSupportedContentTypes(int[] arg1);

    void start(EventListener arg1, AdViewProvider arg2);

    void stop();
}

