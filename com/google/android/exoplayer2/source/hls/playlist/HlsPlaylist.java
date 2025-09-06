package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist implements FilterableManifest {
    public final String baseUri;
    public final boolean hasIndependentSegments;
    public final List tags;

    public HlsPlaylist(String s, List list0, boolean z) {
        this.baseUri = s;
        this.tags = Collections.unmodifiableList(list0);
        this.hasIndependentSegments = z;
    }
}

