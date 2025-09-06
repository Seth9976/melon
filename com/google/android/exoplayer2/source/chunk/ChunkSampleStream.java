package com.google.android.exoplayer2.source.chunk;

import android.net.Uri;
import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.iloen.melon.utils.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ChunkSampleStream implements SampleStream, SequenceableLoader, Callback, ReleaseCallback {
    public final class EmbeddedSampleStream implements SampleStream {
        private final int index;
        private boolean notifiedDownstreamFormat;
        public final ChunkSampleStream parent;
        private final SampleQueue sampleQueue;

        public EmbeddedSampleStream(ChunkSampleStream chunkSampleStream1, SampleQueue sampleQueue0, int v) {
            this.parent = chunkSampleStream1;
            this.sampleQueue = sampleQueue0;
            this.index = v;
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !ChunkSampleStream.this.isPendingReset() && this.sampleQueue.isReady(ChunkSampleStream.this.loadingFinished);
        }

        private void maybeNotifyDownstreamFormat() {
            if(!this.notifiedDownstreamFormat) {
                ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, null, ChunkSampleStream.this.lastSeekPositionUs);
                this.notifiedDownstreamFormat = true;
            }
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
            if(ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            this.maybeNotifyDownstreamFormat();
            return this.sampleQueue.read(formatHolder0, decoderInputBuffer0, z, ChunkSampleStream.this.loadingFinished, ChunkSampleStream.this.decodeOnlyUntilPositionUs);
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long v) {
            if(ChunkSampleStream.this.isPendingReset()) {
                return 0;
            }
            this.maybeNotifyDownstreamFormat();
            return !ChunkSampleStream.this.loadingFinished || v <= this.sampleQueue.getLargestQueuedTimestampUs() ? this.sampleQueue.advanceTo(v) : this.sampleQueue.advanceToEnd();
        }
    }

    public interface com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback {
        void onSampleStreamReleased(ChunkSampleStream arg1);
    }

    private static final String TAG = "ChunkSampleStream";
    private final com.google.android.exoplayer2.source.SequenceableLoader.Callback callback;
    private final BaseMediaChunkOutput chunkOutput;
    private final ChunkSource chunkSource;
    long decodeOnlyUntilPositionUs;
    private final SampleQueue[] embeddedSampleQueues;
    private final Format[] embeddedTrackFormats;
    private final int[] embeddedTrackTypes;
    private final boolean[] embeddedTracksSelected;
    private final EventDispatcher eventDispatcher;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    boolean loadingFinished;
    private final ArrayList mediaChunks;
    private final ChunkHolder nextChunkHolder;
    private int nextNotifyPrimaryFormatMediaChunkIndex;
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List readOnlyMediaChunks;
    private com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback releaseCallback;

    public ChunkSampleStream(int v, int[] arr_v, Format[] arr_format, ChunkSource chunkSource0, com.google.android.exoplayer2.source.SequenceableLoader.Callback sequenceableLoader$Callback0, Allocator allocator0, long v1, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, EventDispatcher mediaSourceEventListener$EventDispatcher0) {
        this.primaryTrackType = v;
        this.embeddedTrackTypes = arr_v;
        this.embeddedTrackFormats = arr_format;
        this.chunkSource = chunkSource0;
        this.callback = sequenceableLoader$Callback0;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.loader = new Loader("Loader:ChunkSampleStream");
        this.nextChunkHolder = new ChunkHolder();
        ArrayList arrayList0 = new ArrayList();
        this.mediaChunks = arrayList0;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList0);
        int v3 = arr_v == null ? 0 : arr_v.length;
        this.embeddedSampleQueues = new SampleQueue[v3];
        this.embeddedTracksSelected = new boolean[v3];
        int[] arr_v1 = new int[v3 + 1];
        SampleQueue[] arr_sampleQueue = new SampleQueue[v3 + 1];
        SampleQueue sampleQueue0 = new SampleQueue(allocator0, ((Looper)Assertions.checkNotNull(Looper.myLooper())), drmSessionManager0);
        this.primarySampleQueue = sampleQueue0;
        arr_v1[0] = v;
        arr_sampleQueue[0] = sampleQueue0;
        for(int v2 = 0; v2 < v3; ++v2) {
            SampleQueue sampleQueue1 = new SampleQueue(allocator0, ((Looper)Assertions.checkNotNull(Looper.myLooper())), DrmSessionManager.getDummyDrmSessionManager());
            this.embeddedSampleQueues[v2] = sampleQueue1;
            arr_sampleQueue[v2 + 1] = sampleQueue1;
            arr_v1[v2 + 1] = arr_v[v2];
        }
        this.chunkOutput = new BaseMediaChunkOutput(arr_v1, arr_sampleQueue);
        this.pendingResetPositionUs = v1;
        this.lastSeekPositionUs = v1;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long v) {
        long v1;
        List list0;
        if(!this.loadingFinished && !this.loader.isLoading() && !this.loader.hasFatalError()) {
            boolean z = this.isPendingReset();
            if(z) {
                list0 = Collections.EMPTY_LIST;
                v1 = this.pendingResetPositionUs;
            }
            else {
                list0 = this.readOnlyMediaChunks;
                v1 = this.getLastMediaChunk().endTimeUs;
            }
            this.chunkSource.getNextChunk(v, v1, list0, this.nextChunkHolder);
            boolean z1 = this.nextChunkHolder.endOfStream;
            Chunk chunk0 = this.nextChunkHolder.chunk;
            this.nextChunkHolder.clear();
            if(z1) {
                this.pendingResetPositionUs = 0x8000000000000001L;
                this.loadingFinished = true;
                return true;
            }
            if(chunk0 == null) {
                return false;
            }
            if(this.isMediaChunk(chunk0)) {
                if(z) {
                    this.decodeOnlyUntilPositionUs = ((BaseMediaChunk)chunk0).startTimeUs == this.pendingResetPositionUs ? 0L : this.pendingResetPositionUs;
                    this.pendingResetPositionUs = 0x8000000000000001L;
                }
                ((BaseMediaChunk)chunk0).init(this.chunkOutput);
                this.mediaChunks.add(((BaseMediaChunk)chunk0));
            }
            else if(chunk0 instanceof InitializationChunk) {
                ((InitializationChunk)chunk0).init(this.chunkOutput);
            }
            int v2 = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk0.type);
            long v3 = this.loader.startLoading(chunk0, this, v2);
            this.eventDispatcher.loadStarted(chunk0.dataSpec, chunk0.type, this.primaryTrackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v3);
            return true;
        }
        return false;
    }

    public void discardBuffer(long v, boolean z) {
        if(this.isPendingReset()) {
            return;
        }
        this.primarySampleQueue.discardTo(v, z, true);
        int v1 = this.primarySampleQueue.getFirstIndex();
        if(v1 > this.primarySampleQueue.getFirstIndex()) {
            long v2 = this.primarySampleQueue.getFirstTimestampUs();
            for(int v3 = 0; true; ++v3) {
                SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
                if(v3 >= arr_sampleQueue.length) {
                    break;
                }
                arr_sampleQueue[v3].discardTo(v2, z, this.embeddedTracksSelected[v3]);
            }
        }
        this.discardDownstreamMediaChunks(v1);
    }

    private void discardDownstreamMediaChunks(int v) {
        int v1 = Math.min(this.primarySampleIndexToMediaChunkIndex(v, 0), this.nextNotifyPrimaryFormatMediaChunkIndex);
        if(v1 > 0) {
            Util.removeRange(this.mediaChunks, 0, v1);
            this.nextNotifyPrimaryFormatMediaChunkIndex -= v1;
        }
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int v) {
        BaseMediaChunk baseMediaChunk0 = (BaseMediaChunk)this.mediaChunks.get(v);
        Util.removeRange(this.mediaChunks, v, this.mediaChunks.size());
        this.nextNotifyPrimaryFormatMediaChunkIndex = Math.max(this.nextNotifyPrimaryFormatMediaChunkIndex, this.mediaChunks.size());
        int v1 = 0;
        int v2 = baseMediaChunk0.getFirstSampleIndex(0);
        this.primarySampleQueue.discardUpstreamSamples(v2);
        while(true) {
            SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
            if(v1 >= arr_sampleQueue.length) {
                break;
            }
            SampleQueue sampleQueue0 = arr_sampleQueue[v1];
            ++v1;
            sampleQueue0.discardUpstreamSamples(baseMediaChunk0.getFirstSampleIndex(v1));
        }
        return baseMediaChunk0;
    }

    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        return this.chunkSource.getAdjustedSeekPositionUs(v, seekParameters0);
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if(this.loadingFinished) {
            return 0x8000000000000000L;
        }
        if(this.isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long v = this.lastSeekPositionUs;
        BaseMediaChunk baseMediaChunk0 = this.getLastMediaChunk();
        if(!baseMediaChunk0.isLoadCompleted()) {
            baseMediaChunk0 = this.mediaChunks.size() <= 1 ? null : ((BaseMediaChunk)a.i(2, this.mediaChunks));
        }
        if(baseMediaChunk0 != null) {
            v = Math.max(v, baseMediaChunk0.endTimeUs);
        }
        return Math.max(v, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public ChunkSource getChunkSource() {
        return this.chunkSource;
    }

    private BaseMediaChunk getLastMediaChunk() {
        return (BaseMediaChunk)a.i(1, this.mediaChunks);
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if(this.isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        return this.loadingFinished ? 0x8000000000000000L : this.getLastMediaChunk().endTimeUs;
    }

    private boolean haveReadFromMediaChunk(int v) {
        BaseMediaChunk baseMediaChunk0 = (BaseMediaChunk)this.mediaChunks.get(v);
        int v1 = baseMediaChunk0.getFirstSampleIndex(0);
        if(this.primarySampleQueue.getReadIndex() > v1) {
            return true;
        }
        int v2 = 0;
        while(true) {
            SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
            if(v2 >= arr_sampleQueue.length) {
                break;
            }
            int v3 = arr_sampleQueue[v2].getReadIndex();
            ++v2;
            if(v3 > baseMediaChunk0.getFirstSampleIndex(v2)) {
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.loader.isLoading();
    }

    private boolean isMediaChunk(Chunk chunk0) {
        return chunk0 instanceof BaseMediaChunk;
    }

    public boolean isPendingReset() {
        return this.pendingResetPositionUs != 0x8000000000000001L;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return !this.isPendingReset() && this.primarySampleQueue.isReady(this.loadingFinished);
    }

    private void maybeNotifyPrimaryTrackFormatChanged() {
        int v = this.primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), this.nextNotifyPrimaryFormatMediaChunkIndex - 1);
        int v1;
        while((v1 = this.nextNotifyPrimaryFormatMediaChunkIndex) <= v) {
            this.nextNotifyPrimaryFormatMediaChunkIndex = v1 + 1;
            this.maybeNotifyPrimaryTrackFormatChanged(v1);
        }
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int v) {
        BaseMediaChunk baseMediaChunk0 = (BaseMediaChunk)this.mediaChunks.get(v);
        Format format0 = baseMediaChunk0.trackFormat;
        if(!format0.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format0, baseMediaChunk0.trackSelectionReason, baseMediaChunk0.trackSelectionData, baseMediaChunk0.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format0;
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() {
        this.loader.maybeThrowError();
        this.primarySampleQueue.maybeThrowError();
        if(!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    public void onLoadCanceled(Chunk chunk0, long v, long v1, boolean z) {
        Uri uri0 = chunk0.getUri();
        Map map0 = chunk0.getResponseHeaders();
        long v2 = chunk0.bytesLoaded();
        this.eventDispatcher.loadCanceled(chunk0.dataSpec, uri0, map0, chunk0.type, this.primaryTrackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v, v1, v2);
        if(!z) {
            this.primarySampleQueue.reset();
            SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
            for(int v3 = 0; v3 < arr_sampleQueue.length; ++v3) {
                arr_sampleQueue[v3].reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCanceled(Loadable loader$Loadable0, long v, long v1, boolean z) {
        this.onLoadCanceled(((Chunk)loader$Loadable0), v, v1, z);
    }

    public void onLoadCompleted(Chunk chunk0, long v, long v1) {
        this.chunkSource.onChunkLoadCompleted(chunk0);
        Uri uri0 = chunk0.getUri();
        Map map0 = chunk0.getResponseHeaders();
        long v2 = chunk0.bytesLoaded();
        this.eventDispatcher.loadCompleted(chunk0.dataSpec, uri0, map0, chunk0.type, this.primaryTrackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v, v1, v2);
        this.callback.onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCompleted(Loadable loader$Loadable0, long v, long v1) {
        this.onLoadCompleted(((Chunk)loader$Loadable0), v, v1);
    }

    public LoadErrorAction onLoadError(Chunk chunk0, long v, long v1, IOException iOException0, int v2) {
        LoadErrorAction loader$LoadErrorAction0;
        long v3 = chunk0.bytesLoaded();
        boolean z = this.isMediaChunk(chunk0);
        int v4 = this.mediaChunks.size();
        boolean z1 = true;
        boolean z2 = Long.compare(v3, 0L) == 0 || !z || !this.haveReadFromMediaChunk(v4 - 1);
        long v5 = z2 ? this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(chunk0.type, v1, iOException0, v2) : 0x8000000000000001L;
        if(!this.chunkSource.onChunkLoadError(chunk0, z2, iOException0, v5)) {
            loader$LoadErrorAction0 = null;
        }
        else if(z2) {
            loader$LoadErrorAction0 = Loader.DONT_RETRY;
            if(z) {
                if(this.discardUpstreamMediaChunksFromIndex(v4 - 1) != chunk0) {
                    z1 = false;
                }
                Assertions.checkState(z1);
                if(this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
        }
        else {
            Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            loader$LoadErrorAction0 = null;
        }
        if(loader$LoadErrorAction0 == null) {
            long v6 = this.loadErrorHandlingPolicy.getRetryDelayMsFor(chunk0.type, v1, iOException0, v2);
            loader$LoadErrorAction0 = v6 == 0x8000000000000001L ? Loader.DONT_RETRY_FATAL : Loader.createRetryAction(false, v6);
        }
        boolean z3 = loader$LoadErrorAction0.isRetry();
        Uri uri0 = chunk0.getUri();
        Map map0 = chunk0.getResponseHeaders();
        this.eventDispatcher.loadError(chunk0.dataSpec, uri0, map0, chunk0.type, this.primaryTrackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v, v1, v3, iOException0, !z3);
        if(!z3) {
            this.callback.onContinueLoadingRequested(this);
        }
        return loader$LoadErrorAction0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public LoadErrorAction onLoadError(Loadable loader$Loadable0, long v, long v1, IOException iOException0, int v2) {
        return this.onLoadError(((Chunk)loader$Loadable0), v, v1, iOException0, v2);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$ReleaseCallback
    public void onLoaderReleased() {
        this.primarySampleQueue.release();
        SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
        for(int v = 0; v < arr_sampleQueue.length; ++v) {
            arr_sampleQueue[v].release();
        }
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback chunkSampleStream$ReleaseCallback0 = this.releaseCallback;
        if(chunkSampleStream$ReleaseCallback0 != null) {
            chunkSampleStream$ReleaseCallback0.onSampleStreamReleased(this);
        }
    }

    private int primarySampleIndexToMediaChunkIndex(int v, int v1) {
        while(true) {
            ++v1;
            if(v1 >= this.mediaChunks.size()) {
                break;
            }
            if(((BaseMediaChunk)this.mediaChunks.get(v1)).getFirstSampleIndex(0) > v) {
                return v1 - 1;
            }
        }
        return this.mediaChunks.size() - 1;
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
        if(this.isPendingReset()) {
            return -3;
        }
        this.maybeNotifyPrimaryTrackFormatChanged();
        return this.primarySampleQueue.read(formatHolder0, decoderInputBuffer0, z, this.loadingFinished, this.decodeOnlyUntilPositionUs);
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long v) {
        if(!this.loader.isLoading() && !this.loader.hasFatalError() && !this.isPendingReset()) {
            int v1 = this.mediaChunks.size();
            int v2 = this.chunkSource.getPreferredQueueSize(v, this.readOnlyMediaChunks);
            if(v1 > v2) {
                while(true) {
                    if(v2 >= v1) {
                        v2 = v1;
                        break;
                    }
                    if(!this.haveReadFromMediaChunk(v2)) {
                        break;
                    }
                    ++v2;
                }
                if(v2 != v1) {
                    long v3 = this.getLastMediaChunk().endTimeUs;
                    BaseMediaChunk baseMediaChunk0 = this.discardUpstreamMediaChunksFromIndex(v2);
                    if(this.mediaChunks.isEmpty()) {
                        this.pendingResetPositionUs = this.lastSeekPositionUs;
                    }
                    this.loadingFinished = false;
                    this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, baseMediaChunk0.startTimeUs, v3);
                }
            }
        }
    }

    public void release() {
        this.release(null);
    }

    public void release(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback chunkSampleStream$ReleaseCallback0) {
        this.releaseCallback = chunkSampleStream$ReleaseCallback0;
        this.primarySampleQueue.preRelease();
        SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
        for(int v = 0; v < arr_sampleQueue.length; ++v) {
            arr_sampleQueue[v].preRelease();
        }
        this.loader.release(this);
    }

    public void seekToUs(long v) {
        boolean z;
        BaseMediaChunk baseMediaChunk0;
        this.lastSeekPositionUs = v;
        if(this.isPendingReset()) {
            this.pendingResetPositionUs = v;
            return;
        }
        int v1 = 0;
        int v2 = 0;
        while(true) {
            if(v2 < this.mediaChunks.size()) {
                baseMediaChunk0 = (BaseMediaChunk)this.mediaChunks.get(v2);
                int v3 = Long.compare(baseMediaChunk0.startTimeUs, v);
                if(v3 == 0 && baseMediaChunk0.clippedStartTimeUs == 0x8000000000000001L) {
                    break;
                }
                if(v3 <= 0) {
                    ++v2;
                    continue;
                }
            }
            baseMediaChunk0 = null;
            break;
        }
        if(baseMediaChunk0 == null) {
            boolean z1 = v < this.getNextLoadPositionUs();
            z = this.primarySampleQueue.seekTo(v, z1);
            this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
        }
        else {
            int v4 = baseMediaChunk0.getFirstSampleIndex(0);
            z = this.primarySampleQueue.seekTo(v4);
            this.decodeOnlyUntilPositionUs = 0L;
        }
        if(z) {
            this.nextNotifyPrimaryFormatMediaChunkIndex = this.primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), 0);
            SampleQueue[] arr_sampleQueue = this.embeddedSampleQueues;
            while(v1 < arr_sampleQueue.length) {
                arr_sampleQueue[v1].seekTo(v, true);
                ++v1;
            }
            return;
        }
        this.pendingResetPositionUs = v;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        this.nextNotifyPrimaryFormatMediaChunkIndex = 0;
        if(this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.loader.clearFatalError();
        this.primarySampleQueue.reset();
        SampleQueue[] arr_sampleQueue1 = this.embeddedSampleQueues;
        while(v1 < arr_sampleQueue1.length) {
            arr_sampleQueue1[v1].reset();
            ++v1;
        }
    }

    public EmbeddedSampleStream selectEmbeddedTrack(long v, int v1) {
        for(int v2 = 0; v2 < this.embeddedSampleQueues.length; ++v2) {
            if(this.embeddedTrackTypes[v2] == v1) {
                Assertions.checkState(!this.embeddedTracksSelected[v2]);
                this.embeddedTracksSelected[v2] = true;
                this.embeddedSampleQueues[v2].seekTo(v, true);
                return new EmbeddedSampleStream(this, this, this.embeddedSampleQueues[v2], v2);
            }
        }
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long v) {
        if(this.isPendingReset()) {
            return 0;
        }
        int v1 = !this.loadingFinished || v <= this.primarySampleQueue.getLargestQueuedTimestampUs() ? this.primarySampleQueue.advanceTo(v) : this.primarySampleQueue.advanceToEnd();
        this.maybeNotifyPrimaryTrackFormatChanged();
        return v1;
    }
}

