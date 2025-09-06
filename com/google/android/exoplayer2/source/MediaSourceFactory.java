package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import java.util.List;

public interface MediaSourceFactory {
    MediaSource createMediaSource(Uri arg1);

    int[] getSupportedTypes();

    MediaSourceFactory setDrmSessionManager(DrmSessionManager arg1);

    default MediaSourceFactory setStreamKeys(List list0) {
        return this;
    }
}

