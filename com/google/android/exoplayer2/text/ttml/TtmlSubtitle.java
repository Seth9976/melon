package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class TtmlSubtitle implements Subtitle {
    private final long[] eventTimesUs;
    private final Map globalStyles;
    private final Map imageMap;
    private final Map regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlNode0, Map map0, Map map1, Map map2) {
        this.root = ttmlNode0;
        this.regionMap = map1;
        this.imageMap = map2;
        this.globalStyles = map0 == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map0);
        this.eventTimesUs = ttmlNode0.getEventTimesUs();
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        return this.root.getCues(v, this.globalStyles, this.regionMap, this.imageMap);
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        return this.eventTimesUs[v];
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    public Map getGlobalStyles() {
        return this.globalStyles;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        int v1 = Util.binarySearchCeil(this.eventTimesUs, v, false, false);
        return v1 >= this.eventTimesUs.length ? -1 : v1;
    }

    public TtmlNode getRoot() {
        return this.root;
    }
}

