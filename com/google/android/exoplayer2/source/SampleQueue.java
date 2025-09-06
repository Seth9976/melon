package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession.DrmSessionException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public class SampleQueue implements TrackOutput {
    static final class SampleExtrasHolder {
        public CryptoData cryptoData;
        public long offset;
        public int size;

    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format arg1);
    }

    static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private int absoluteFirstIndex;
    private int capacity;
    private CryptoData[] cryptoDatas;
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionManager drmSessionManager;
    private final SampleExtrasHolder extrasHolder;
    private int[] flags;
    private Format[] formats;
    private boolean isLastSampleQueued;
    private long largestDiscardedTimestampUs;
    private long largestQueuedTimestampUs;
    private int length;
    private long[] offsets;
    private boolean pendingSplice;
    private boolean pendingUpstreamFormatAdjustment;
    private final Looper playbackLooper;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private int[] sizes;
    private int[] sourceIds;
    private long[] timesUs;
    private Format unadjustedUpstreamFormat;
    private Format upstreamCommittedFormat;
    private Format upstreamFormat;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private boolean upstreamFormatRequired;
    private boolean upstreamKeyframeRequired;
    private int upstreamSourceId;

    public SampleQueue(Allocator allocator0, Looper looper0, DrmSessionManager drmSessionManager0) {
        this.sampleDataQueue = new SampleDataQueue(allocator0);
        this.playbackLooper = looper0;
        this.drmSessionManager = drmSessionManager0;
        this.extrasHolder = new SampleExtrasHolder();
        this.capacity = 1000;
        this.sourceIds = new int[1000];
        this.offsets = new long[1000];
        this.timesUs = new long[1000];
        this.flags = new int[1000];
        this.sizes = new int[1000];
        this.cryptoDatas = new CryptoData[1000];
        this.formats = new Format[1000];
        this.largestDiscardedTimestampUs = 0x8000000000000000L;
        this.largestQueuedTimestampUs = 0x8000000000000000L;
        this.upstreamFormatRequired = true;
        this.upstreamKeyframeRequired = true;
    }

    public final int advanceTo(long v) {
        synchronized(this) {
            int v2 = this.getRelativeIndex(this.readPosition);
            if(this.hasNextSample() && v >= this.timesUs[v2]) {
                int v3 = this.findSampleBefore(v2, this.length - this.readPosition, v, true);
                if(v3 == -1) {
                    return 0;
                }
                this.readPosition += v3;
                return v3;
            }
            return 0;
        }
    }

    public final int advanceToEnd() {
        int v;
        synchronized(this) {
            v = this.length - this.readPosition;
            this.readPosition = this.length;
        }
        return v;
    }

    private boolean attemptSplice(long v) {
        boolean z = false;
        synchronized(this) {
            if(this.length == 0) {
                if(v > this.largestDiscardedTimestampUs) {
                    z = true;
                }
                return z;
            }
            if(Math.max(this.largestDiscardedTimestampUs, this.getLargestTimestamp(this.readPosition)) >= v) {
                return false;
            }
            int v2 = this.length;
            int v3 = this.getRelativeIndex(v2 - 1);
            while(v2 > this.readPosition && this.timesUs[v3] >= v) {
                --v2;
                if(v3 - 1 == -1) {
                    v3 = this.capacity - 1;
                }
                else {
                    --v3;
                }
            }
            this.discardUpstreamSampleMetadata(this.absoluteFirstIndex + v2);
            return true;
        }
    }

    private void commitSample(long v, int v1, long v2, int v3, CryptoData trackOutput$CryptoData0) {
        synchronized(this) {
            if(this.upstreamKeyframeRequired) {
                if((v1 & 1) == 0) {
                    return;
                }
                this.upstreamKeyframeRequired = false;
            }
            Assertions.checkState(!this.upstreamFormatRequired);
            this.isLastSampleQueued = (0x20000000 & v1) != 0;
            this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, v);
            int v5 = this.getRelativeIndex(this.length);
            this.timesUs[v5] = v;
            long[] arr_v = this.offsets;
            arr_v[v5] = v2;
            this.sizes[v5] = v3;
            this.flags[v5] = v1;
            this.cryptoDatas[v5] = trackOutput$CryptoData0;
            Format format0 = this.upstreamFormat;
            this.formats[v5] = format0;
            this.sourceIds[v5] = this.upstreamSourceId;
            this.upstreamCommittedFormat = format0;
            int v6 = this.length + 1;
            this.length = v6;
            int v7 = this.capacity;
            if(v6 == v7) {
                int[] arr_v1 = new int[v7 + 1000];
                long[] arr_v2 = new long[v7 + 1000];
                long[] arr_v3 = new long[v7 + 1000];
                int[] arr_v4 = new int[v7 + 1000];
                int[] arr_v5 = new int[v7 + 1000];
                CryptoData[] arr_trackOutput$CryptoData = new CryptoData[v7 + 1000];
                Format[] arr_format = new Format[v7 + 1000];
                int v8 = v7 - this.relativeFirstIndex;
                System.arraycopy(arr_v, this.relativeFirstIndex, arr_v2, 0, v8);
                System.arraycopy(this.timesUs, this.relativeFirstIndex, arr_v3, 0, v8);
                System.arraycopy(this.flags, this.relativeFirstIndex, arr_v4, 0, v8);
                System.arraycopy(this.sizes, this.relativeFirstIndex, arr_v5, 0, v8);
                System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, arr_trackOutput$CryptoData, 0, v8);
                System.arraycopy(this.formats, this.relativeFirstIndex, arr_format, 0, v8);
                System.arraycopy(this.sourceIds, this.relativeFirstIndex, arr_v1, 0, v8);
                int v9 = this.relativeFirstIndex;
                System.arraycopy(this.offsets, 0, arr_v2, v8, v9);
                System.arraycopy(this.timesUs, 0, arr_v3, v8, v9);
                System.arraycopy(this.flags, 0, arr_v4, v8, v9);
                System.arraycopy(this.sizes, 0, arr_v5, v8, v9);
                System.arraycopy(this.cryptoDatas, 0, arr_trackOutput$CryptoData, v8, v9);
                System.arraycopy(this.formats, 0, arr_format, v8, v9);
                System.arraycopy(this.sourceIds, 0, arr_v1, v8, v9);
                this.offsets = arr_v2;
                this.timesUs = arr_v3;
                this.flags = arr_v4;
                this.sizes = arr_v5;
                this.cryptoDatas = arr_trackOutput$CryptoData;
                this.formats = arr_format;
                this.sourceIds = arr_v1;
                this.relativeFirstIndex = 0;
                this.capacity = v7 + 1000;
            }
        }
    }

    private long discardSampleMetadataTo(long v, boolean z, boolean z1) {
        synchronized(this) {
            int v2 = this.length;
            if(v2 != 0) {
                int v3 = this.relativeFirstIndex;
                if(v >= this.timesUs[v3]) {
                    if(z1) {
                        int v4 = this.readPosition;
                        if(v4 != v2) {
                            v2 = v4 + 1;
                        }
                    }
                    int v5 = this.findSampleBefore(v3, v2, v, z);
                    return v5 == -1 ? -1L : this.discardSamples(v5);
                }
            }
            return -1L;
        }
    }

    private long discardSampleMetadataToEnd() {
        synchronized(this) {
            int v1 = this.length;
            return v1 == 0 ? -1L : this.discardSamples(v1);
        }
    }

    public long discardSampleMetadataToRead() {
        synchronized(this) {
            int v1 = this.readPosition;
            return v1 == 0 ? -1L : this.discardSamples(v1);
        }
    }

    private long discardSamples(int v) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, this.getLargestTimestamp(v));
        int v1 = this.length - v;
        this.length = v1;
        this.absoluteFirstIndex += v;
        int v2 = this.relativeFirstIndex + v;
        this.relativeFirstIndex = v2;
        int v3 = this.capacity;
        if(v2 >= v3) {
            this.relativeFirstIndex = v2 - v3;
        }
        int v4 = this.readPosition - v;
        this.readPosition = v4;
        if(v4 < 0) {
            this.readPosition = 0;
        }
        if(v1 == 0) {
            int v5 = this.relativeFirstIndex;
            if(v5 != 0) {
                v3 = v5;
            }
            return this.offsets[v3 - 1] + ((long)this.sizes[v3 - 1]);
        }
        return this.offsets[this.relativeFirstIndex];
    }

    public final void discardTo(long v, boolean z, boolean z1) {
        long v1 = this.discardSampleMetadataTo(v, z, z1);
        this.sampleDataQueue.discardDownstreamTo(v1);
    }

    public final void discardToEnd() {
        long v = this.discardSampleMetadataToEnd();
        this.sampleDataQueue.discardDownstreamTo(v);
    }

    public final void discardToRead() {
        long v = this.discardSampleMetadataToRead();
        this.sampleDataQueue.discardDownstreamTo(v);
    }

    private long discardUpstreamSampleMetadata(int v) {
        int v1 = this.getWriteIndex() - v;
        boolean z = false;
        Assertions.checkArgument(v1 >= 0 && v1 <= this.length - this.readPosition);
        int v2 = this.length - v1;
        this.length = v2;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, this.getLargestTimestamp(v2));
        if(v1 == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        int v3 = this.length;
        if(v3 != 0) {
            int v4 = this.getRelativeIndex(v3 - 1);
            return this.offsets[v4] + ((long)this.sizes[v4]);
        }
        return 0L;
    }

    public final void discardUpstreamSamples(int v) {
        long v1 = this.discardUpstreamSampleMetadata(v);
        this.sampleDataQueue.discardUpstreamSampleBytes(v1);
    }

    private int findSampleBefore(int v, int v1, long v2, boolean z) {
        int v3 = -1;
        for(int v4 = 0; v4 < v1 && this.timesUs[v] <= v2; ++v4) {
            if(!z || (this.flags[v] & 1) != 0) {
                v3 = v4;
            }
            ++v;
            v = v == this.capacity ? 0 : v + 1;
        }
        return v3;
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(Format format0) {
        Format format1 = this.getAdjustedUpstreamFormat(format0);
        this.pendingUpstreamFormatAdjustment = false;
        this.unadjustedUpstreamFormat = format0;
        boolean z = this.setUpstreamFormat(format1);
        UpstreamFormatChangedListener sampleQueue$UpstreamFormatChangedListener0 = this.upstreamFormatChangeListener;
        if(sampleQueue$UpstreamFormatChangedListener0 != null && z) {
            sampleQueue$UpstreamFormatChangedListener0.onUpstreamFormatChanged(format1);
        }
    }

    public Format getAdjustedUpstreamFormat(Format format0) {
        long v = this.sampleOffsetUs;
        if(v != 0L) {
            return format0.subsampleOffsetUs == 0x7FFFFFFFFFFFFFFFL ? format0 : format0.copyWithSubsampleOffsetUs(format0.subsampleOffsetUs + v);
        }
        return format0;
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final long getFirstTimestampUs() {
        synchronized(this) {
            return this.length == 0 ? 0x8000000000000000L : this.timesUs[this.relativeFirstIndex];
        }
    }

    public final long getLargestQueuedTimestampUs() {
        synchronized(this) {
        }
        return this.largestQueuedTimestampUs;
    }

    private long getLargestTimestamp(int v) {
        long v1 = 0x8000000000000000L;
        if(v == 0) {
            return 0x8000000000000000L;
        }
        int v2 = this.getRelativeIndex(v - 1);
        for(int v3 = 0; v3 < v; ++v3) {
            v1 = Math.max(v1, this.timesUs[v2]);
            if((this.flags[v2] & 1) != 0) {
                return v1;
            }
            --v2;
            v2 = v2 == -1 ? this.capacity - 1 : v2 - 1;
        }
        return v1;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    private int getRelativeIndex(int v) {
        int v1 = this.relativeFirstIndex + v;
        return v1 >= this.capacity ? v1 - this.capacity : v1;
    }

    public final Format getUpstreamFormat() {
        synchronized(this) {
        }
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.pendingUpstreamFormatAdjustment = true;
    }

    public final boolean isLastSampleQueued() {
        synchronized(this) {
        }
        return this.isLastSampleQueued;
    }

    public boolean isReady(boolean z) {
        boolean z1 = true;
        synchronized(this) {
            if(!this.hasNextSample()) {
                if(!z && !this.isLastSampleQueued && (this.upstreamFormat == null || this.upstreamFormat == this.downstreamFormat)) {
                    z1 = false;
                }
                return z1;
            }
            int v1 = this.getRelativeIndex(this.readPosition);
            return this.formats[v1] != this.downstreamFormat ? true : this.mayReadSample(v1);
        }
    }

    // 去混淆评级： 低(30)
    private boolean mayReadSample(int v) {
        return this.drmSessionManager == DrmSessionManager.DUMMY ? true : this.currentDrmSession == null || this.currentDrmSession.getState() == 4 || (this.flags[v] & 0x40000000) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys();
    }

    public void maybeThrowError() {
        if(this.currentDrmSession != null && this.currentDrmSession.getState() == 1) {
            throw (DrmSessionException)Assertions.checkNotNull(this.currentDrmSession.getError());
        }
    }

    private void onFormatResult(Format format0, FormatHolder formatHolder0) {
        DrmSession drmSession1;
        formatHolder0.format = format0;
        boolean z = this.downstreamFormat == null;
        DrmInitData drmInitData0 = z ? null : this.downstreamFormat.drmInitData;
        this.downstreamFormat = format0;
        if(this.drmSessionManager != DrmSessionManager.DUMMY) {
            DrmInitData drmInitData1 = format0.drmInitData;
            formatHolder0.includesDrmSession = true;
            formatHolder0.drmSession = this.currentDrmSession;
            if(z || !Util.areEqual(drmInitData0, drmInitData1)) {
                DrmSession drmSession0 = this.currentDrmSession;
                if(drmInitData1 == null) {
                    int v = MimeTypes.getTrackType(format0.sampleMimeType);
                    drmSession1 = this.drmSessionManager.acquirePlaceholderSession(this.playbackLooper, v);
                }
                else {
                    drmSession1 = this.drmSessionManager.acquireSession(this.playbackLooper, drmInitData1);
                }
                this.currentDrmSession = drmSession1;
                formatHolder0.drmSession = drmSession1;
                if(drmSession0 != null) {
                    drmSession0.release();
                }
            }
        }
    }

    public final int peekSourceId() {
        synchronized(this) {
            return this.hasNextSample() ? this.sourceIds[this.getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
        }
    }

    public void preRelease() {
        this.discardToEnd();
        this.releaseDrmSessionReferences();
    }

    public int read(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z, boolean z1, long v) {
        int v1 = this.readSampleMetadata(formatHolder0, decoderInputBuffer0, z, z1, v, this.extrasHolder);
        if(v1 == -4 && !decoderInputBuffer0.isEndOfStream() && !decoderInputBuffer0.isFlagsOnly()) {
            this.sampleDataQueue.readToBuffer(decoderInputBuffer0, this.extrasHolder);
        }
        return v1;
    }

    private int readSampleMetadata(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z, boolean z1, long v, SampleExtrasHolder sampleQueue$SampleExtrasHolder0) {
        synchronized(this) {
            decoderInputBuffer0.waitingForKeys = false;
            int v2 = -1;
            while(true) {
                boolean z2 = this.hasNextSample();
                if(!z2) {
                    break;
                }
                v2 = this.getRelativeIndex(this.readPosition);
                if(this.timesUs[v2] >= v || !MimeTypes.allSamplesAreSyncSamples(this.formats[v2].sampleMimeType)) {
                    break;
                }
                ++this.readPosition;
            }
            if(!z2) {
                if(!z1 && !this.isLastSampleQueued) {
                    Format format0 = this.upstreamFormat;
                    if(format0 != null && (z || format0 != this.downstreamFormat)) {
                        this.onFormatResult(((Format)Assertions.checkNotNull(format0)), formatHolder0);
                        return -5;
                    }
                    return -3;
                }
                decoderInputBuffer0.setFlags(4);
                return -4;
            }
            if(!z && this.formats[v2] == this.downstreamFormat) {
                if(!this.mayReadSample(v2)) {
                    decoderInputBuffer0.waitingForKeys = true;
                    return -3;
                }
                decoderInputBuffer0.setFlags(this.flags[v2]);
                long v3 = this.timesUs[v2];
                decoderInputBuffer0.timeUs = v3;
                if(v3 < v) {
                    decoderInputBuffer0.addFlag(0x80000000);
                }
                if(decoderInputBuffer0.isFlagsOnly()) {
                    return -4;
                }
                sampleQueue$SampleExtrasHolder0.size = this.sizes[v2];
                sampleQueue$SampleExtrasHolder0.offset = this.offsets[v2];
                sampleQueue$SampleExtrasHolder0.cryptoData = this.cryptoDatas[v2];
                ++this.readPosition;
                return -4;
            }
            this.onFormatResult(this.formats[v2], formatHolder0);
            return -5;
        }
    }

    public void release() {
        this.reset(true);
        this.releaseDrmSessionReferences();
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession0 = this.currentDrmSession;
        if(drmSession0 != null) {
            drmSession0.release();
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    public final void reset() {
        this.reset(false);
    }

    public void reset(boolean z) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = 0x8000000000000000L;
        this.largestQueuedTimestampUs = 0x8000000000000000L;
        this.isLastSampleQueued = false;
        this.upstreamCommittedFormat = null;
        if(z) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    private void rewind() {
        synchronized(this) {
            this.readPosition = 0;
            this.sampleDataQueue.rewind();
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(ExtractorInput extractorInput0, int v, boolean z) {
        return this.sampleDataQueue.sampleData(extractorInput0, v, z);
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray0, int v) {
        this.sampleDataQueue.sampleData(parsableByteArray0, v);
    }

    @Override  // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleMetadata(long v, int v1, int v2, int v3, CryptoData trackOutput$CryptoData0) {
        if(this.pendingUpstreamFormatAdjustment) {
            this.format(this.unadjustedUpstreamFormat);
        }
        long v4 = this.sampleOffsetUs + v;
        if(this.pendingSplice) {
            if((v1 & 1) != 0 && this.attemptSplice(v4)) {
                this.pendingSplice = false;
                this.commitSample(v4, v1, this.sampleDataQueue.getTotalBytesWritten() - ((long)v2) - ((long)v3), v2, trackOutput$CryptoData0);
                return;
            }
            return;
        }
        this.commitSample(v4, v1, this.sampleDataQueue.getTotalBytesWritten() - ((long)v2) - ((long)v3), v2, trackOutput$CryptoData0);
    }

    public final boolean seekTo(int v) {
        synchronized(this) {
            this.rewind();
            int v2 = this.absoluteFirstIndex;
            if(v >= v2 && v <= this.length + v2) {
                this.readPosition = v - v2;
                return true;
            }
            return false;
        }
    }

    public final boolean seekTo(long v, boolean z) {
        synchronized(this) {
            this.rewind();
            int v2 = this.getRelativeIndex(this.readPosition);
            if(this.hasNextSample() && v >= this.timesUs[v2] && (v <= this.largestQueuedTimestampUs || z)) {
                int v3 = this.findSampleBefore(v2, this.length - this.readPosition, v, true);
                if(v3 == -1) {
                    return false;
                }
                this.readPosition += v3;
                return true;
            }
            return false;
        }
    }

    public final void setSampleOffsetUs(long v) {
        if(this.sampleOffsetUs != v) {
            this.sampleOffsetUs = v;
            this.invalidateUpstreamFormatAdjustment();
        }
    }

    private boolean setUpstreamFormat(Format format0) {
        synchronized(this) {
            if(format0 == null) {
                this.upstreamFormatRequired = true;
                return false;
            }
            this.upstreamFormatRequired = false;
            if(Util.areEqual(format0, this.upstreamFormat)) {
                return false;
            }
            if(Util.areEqual(format0, this.upstreamCommittedFormat)) {
                this.upstreamFormat = this.upstreamCommittedFormat;
                return true;
            }
            this.upstreamFormat = format0;
            return true;
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener sampleQueue$UpstreamFormatChangedListener0) {
        this.upstreamFormatChangeListener = sampleQueue$UpstreamFormatChangedListener0;
    }

    public final void sourceId(int v) {
        this.upstreamSourceId = v;
    }

    public final void splice() {
        this.pendingSplice = true;
    }
}

