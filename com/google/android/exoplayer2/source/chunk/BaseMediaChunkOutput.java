package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Log;

public final class BaseMediaChunkOutput implements TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] arr_v, SampleQueue[] arr_sampleQueue) {
        this.trackTypes = arr_v;
        this.sampleQueues = arr_sampleQueue;
    }

    public int[] getWriteIndices() {
        int[] arr_v = new int[this.sampleQueues.length];
        for(int v = 0; true; ++v) {
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            if(v >= arr_sampleQueue.length) {
                break;
            }
            SampleQueue sampleQueue0 = arr_sampleQueue[v];
            if(sampleQueue0 != null) {
                arr_v[v] = sampleQueue0.getWriteIndex();
            }
        }
        return arr_v;
    }

    public void setSampleOffsetUs(long v) {
        SampleQueue[] arr_sampleQueue = this.sampleQueues;
        for(int v1 = 0; v1 < arr_sampleQueue.length; ++v1) {
            SampleQueue sampleQueue0 = arr_sampleQueue[v1];
            if(sampleQueue0 != null) {
                sampleQueue0.setSampleOffsetUs(v);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper$TrackOutputProvider
    public TrackOutput track(int v, int v1) {
        for(int v2 = 0; true; ++v2) {
            int[] arr_v = this.trackTypes;
            if(v2 >= arr_v.length) {
                break;
            }
            if(v1 == arr_v[v2]) {
                return this.sampleQueues[v2];
            }
        }
        Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + v1);
        return new DummyTrackOutput();
    }
}

