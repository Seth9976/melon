package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class InitializationChunk extends Chunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private long nextLoadPosition;
    private TrackOutputProvider trackOutputProvider;

    static {
        InitializationChunk.DUMMY_POSITION_HOLDER = new PositionHolder();
    }

    public InitializationChunk(DataSource dataSource0, DataSpec dataSpec0, Format format0, int v, Object object0, ChunkExtractorWrapper chunkExtractorWrapper0) {
        super(dataSource0, dataSpec0, 2, format0, v, object0, 0x8000000000000001L, 0x8000000000000001L);
        this.extractorWrapper = chunkExtractorWrapper0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public void init(TrackOutputProvider chunkExtractorWrapper$TrackOutputProvider0) {
        this.trackOutputProvider = chunkExtractorWrapper$TrackOutputProvider0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public void load() {
        if(this.nextLoadPosition == 0L) {
            this.extractorWrapper.init(this.trackOutputProvider, 0x8000000000000001L, 0x8000000000000001L);
        }
        try {
            DataSpec dataSpec0 = this.dataSpec.subrange(this.nextLoadPosition);
            long v1 = this.dataSource.open(dataSpec0);
            DefaultExtractorInput defaultExtractorInput0 = new DefaultExtractorInput(this.dataSource, dataSpec0.absoluteStreamPosition, v1);
            try {
                Extractor extractor0 = this.extractorWrapper.extractor;
                boolean z = false;
                int v3;
                for(v3 = 0; v3 == 0 && !this.loadCanceled; v3 = extractor0.read(defaultExtractorInput0, InitializationChunk.DUMMY_POSITION_HOLDER)) {
                }
                if(v3 != 1) {
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
    }
}

