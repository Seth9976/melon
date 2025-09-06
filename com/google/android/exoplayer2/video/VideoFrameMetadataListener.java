package com.google.android.exoplayer2.video;

import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;

public interface VideoFrameMetadataListener {
    void onVideoFrameAboutToBeRendered(long arg1, long arg2, Format arg3, MediaFormat arg4);
}

