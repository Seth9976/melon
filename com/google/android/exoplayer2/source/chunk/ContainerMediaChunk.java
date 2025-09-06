package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public class ContainerMediaChunk extends BaseMediaChunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER;
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final long sampleOffsetUs;

    static {
        ContainerMediaChunk.DUMMY_POSITION_HOLDER = new PositionHolder();
    }

    public ContainerMediaChunk(DataSource dataSource0, DataSpec dataSpec0, Format format0, int v, Object object0, long v1, long v2, long v3, long v4, long v5, int v6, long v7, ChunkExtractorWrapper chunkExtractorWrapper0) {
        super(dataSource0, dataSpec0, format0, v, object0, v1, v2, v3, v4, v5);
        this.chunkCount = v6;
        this.sampleOffsetUs = v7;
        this.extractorWrapper = chunkExtractorWrapper0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + ((long)this.chunkCount);
    }

    public TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput0) [...] // Inlined contents

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public final void load() {
        if(this.nextLoadPosition == 0L) {
            BaseMediaChunkOutput baseMediaChunkOutput0 = this.getOutput();
            baseMediaChunkOutput0.setSampleOffsetUs(this.sampleOffsetUs);
            ChunkExtractorWrapper chunkExtractorWrapper0 = this.extractorWrapper;
            long v = 0x8000000000000001L;
            long v1 = this.clippedStartTimeUs == 0x8000000000000001L ? 0x8000000000000001L : this.clippedStartTimeUs - this.sampleOffsetUs;
            long v2 = this.clippedEndTimeUs;
            if(v2 != 0x8000000000000001L) {
                v = v2 - this.sampleOffsetUs;
            }
            chunkExtractorWrapper0.init(baseMediaChunkOutput0, v1, v);
        }
        try {
            DataSpec dataSpec0 = this.dataSpec.subrange(this.nextLoadPosition);
            long v4 = this.dataSource.open(dataSpec0);
            DefaultExtractorInput defaultExtractorInput0 = new DefaultExtractorInput(this.dataSource, dataSpec0.absoluteStreamPosition, v4);
            try {
                Extractor extractor0 = this.extractorWrapper.extractor;
                boolean z = false;
                int v6;
                for(v6 = 0; v6 == 0 && !this.loadCanceled; v6 = extractor0.read(defaultExtractorInput0, ContainerMediaChunk.DUMMY_POSITION_HOLDER)) {
                }
                if(v6 != 1) {
                    z = true;
                }
                Assertions.checkState(z);
            }
            finally {
                this.nextLoadPosition = defaultExtractorInput0.getPosition() - this.dataSpec.absoluteStreamPosition;
            }
        }
        finally {
            Util.closeQuietly(this.dataSource);
        }
        this.loadCompleted = true;
    }
}

