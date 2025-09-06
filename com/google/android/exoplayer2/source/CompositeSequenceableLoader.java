package com.google.android.exoplayer2.source;

public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] arr_sequenceableLoader) {
        this.loaders = arr_sequenceableLoader;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long v) {
        boolean z = false;
        do {
            long v1 = this.getNextLoadPositionUs();
            if(v1 == 0x8000000000000000L) {
                return z;
            }
            SequenceableLoader[] arr_sequenceableLoader = this.loaders;
            boolean z1 = false;
            for(int v2 = 0; v2 < arr_sequenceableLoader.length; ++v2) {
                SequenceableLoader sequenceableLoader0 = arr_sequenceableLoader[v2];
                long v3 = sequenceableLoader0.getNextLoadPositionUs();
                if(v3 == v1 || v3 != 0x8000000000000000L && v3 <= v) {
                    z1 |= sequenceableLoader0.continueLoading(v);
                }
            }
            z |= z1;
        }
        while(z1);
        return z;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        SequenceableLoader[] arr_sequenceableLoader = this.loaders;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(int v = 0; v < arr_sequenceableLoader.length; ++v) {
            long v2 = arr_sequenceableLoader[v].getBufferedPositionUs();
            if(v2 != 0x8000000000000000L) {
                v1 = Math.min(v1, v2);
            }
        }
        return v1 == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000000L : v1;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        SequenceableLoader[] arr_sequenceableLoader = this.loaders;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(int v = 0; v < arr_sequenceableLoader.length; ++v) {
            long v2 = arr_sequenceableLoader[v].getNextLoadPositionUs();
            if(v2 != 0x8000000000000000L) {
                v1 = Math.min(v1, v2);
            }
        }
        return v1 == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000000L : v1;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        SequenceableLoader[] arr_sequenceableLoader = this.loaders;
        for(int v = 0; v < arr_sequenceableLoader.length; ++v) {
            if(arr_sequenceableLoader[v].isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long v) {
        SequenceableLoader[] arr_sequenceableLoader = this.loaders;
        for(int v1 = 0; v1 < arr_sequenceableLoader.length; ++v1) {
            arr_sequenceableLoader[v1].reevaluateBuffer(v);
        }
    }
}

