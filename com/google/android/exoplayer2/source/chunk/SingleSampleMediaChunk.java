package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;

public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final Format sampleFormat;
    private final int trackType;

    public SingleSampleMediaChunk(DataSource dataSource0, DataSpec dataSpec0, Format format0, int v, Object object0, long v1, long v2, long v3, int v4, Format format1) {
        super(dataSource0, dataSpec0, format0, v, object0, v1, v2, 0x8000000000000001L, 0x8000000000000001L, v3);
        this.trackType = v4;
        this.sampleFormat = format1;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public void cancelLoad() {
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public void load() {
        BaseMediaChunkOutput baseMediaChunkOutput0 = this.getOutput();
        baseMediaChunkOutput0.setSampleOffsetUs(0L);
        TrackOutput trackOutput0 = baseMediaChunkOutput0.track(0, this.trackType);
        trackOutput0.format(this.sampleFormat);
        try {
            DataSpec dataSpec0 = this.dataSpec.subrange(this.nextLoadPosition);
            long v2 = this.dataSource.open(dataSpec0);
            if(v2 != -1L) {
                v2 += this.nextLoadPosition;
            }
            DefaultExtractorInput defaultExtractorInput0 = new DefaultExtractorInput(this.dataSource, this.nextLoadPosition, v2);
            for(int v = 0; v != -1; v = trackOutput0.sampleData(defaultExtractorInput0, 0x7FFFFFFF, true)) {
                this.nextLoadPosition += (long)v;
            }
            trackOutput0.sampleMetadata(this.startTimeUs, 1, ((int)this.nextLoadPosition), 0, null);
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
        this.loadCompleted = true;
    }
}

