package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public abstract class Chunk implements Loadable {
    protected final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    public final long endTimeUs;
    public final long startTimeUs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int type;

    public Chunk(DataSource dataSource0, DataSpec dataSpec0, int v, Format format0, int v1, Object object0, long v2, long v3) {
        this.dataSource = new StatsDataSource(dataSource0);
        this.dataSpec = (DataSpec)Assertions.checkNotNull(dataSpec0);
        this.type = v;
        this.trackFormat = format0;
        this.trackSelectionReason = v1;
        this.trackSelectionData = object0;
        this.startTimeUs = v2;
        this.endTimeUs = v3;
    }

    public final long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    public final long getDurationUs() {
        return this.endTimeUs - this.startTimeUs;
    }

    public final Map getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    public final Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }
}

