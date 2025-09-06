package E9;

import java.io.IOException;

public interface f {
    void onDownstreamFormatChanged(a arg1, c arg2);

    void onDroppedVideoFrames(a arg1, int arg2, long arg3);

    void onIsPlayingChanged(a arg1, boolean arg2);

    void onLoadCanceled(a arg1, b arg2, c arg3);

    void onLoadCompleted(a arg1, b arg2, c arg3);

    void onLoadError(a arg1, b arg2, c arg3, IOException arg4, int arg5, boolean arg6);

    void onLoadStarted(a arg1, b arg2, c arg3);

    void onPlayWhenReadyChanged(a arg1, boolean arg2, int arg3);

    void onPlaybackStateChanged(a arg1, int arg2);

    void onPlayerError(a arg1, int arg2, Exception arg3);

    void onPositionDiscontinuity(a arg1, d arg2, d arg3, int arg4);

    void onVideoSizeChanged(a arg1, e arg2);
}

