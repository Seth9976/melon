package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class MaskingMediaPeriod implements Callback, MediaPeriod {
    public interface PrepareErrorListener {
        void onPrepareError(MediaPeriodId arg1, IOException arg2);
    }

    private final Allocator allocator;
    private Callback callback;
    public final MediaPeriodId id;
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs;
    private long preparePositionUs;

    public MaskingMediaPeriod(MediaSource mediaSource0, MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        this.id = mediaSource$MediaPeriodId0;
        this.allocator = allocator0;
        this.mediaSource = mediaSource0;
        this.preparePositionUs = v;
        this.preparePositionOverrideUs = 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean continueLoading(long v) {
        return this.mediaPeriod != null && this.mediaPeriod.continueLoading(v);
    }

    public void createPeriod(MediaPeriodId mediaSource$MediaPeriodId0) {
        long v = this.getPreparePositionWithOverride(this.preparePositionUs);
        MediaPeriod mediaPeriod0 = this.mediaSource.createPeriod(mediaSource$MediaPeriodId0, this.allocator, v);
        this.mediaPeriod = mediaPeriod0;
        if(this.callback != null) {
            mediaPeriod0.prepare(this, v);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long v, boolean z) {
        this.mediaPeriod.discardBuffer(v, z);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        return ((MediaPeriod)Util.castNonNull(this.mediaPeriod)).getAdjustedSeekPositionUs(v, seekParameters0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        return this.mediaPeriod.getBufferedPositionUs();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getNextLoadPositionUs() {
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public long getPreparePositionUs() {
        return this.preparePositionUs;
    }

    private long getPreparePositionWithOverride(long v) {
        return this.preparePositionOverrideUs == 0x8000000000000001L ? v : this.preparePositionOverrideUs;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean isLoading() {
        return this.mediaPeriod != null && this.mediaPeriod.isLoading();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        try {
            MediaPeriod mediaPeriod0 = this.mediaPeriod;
            if(mediaPeriod0 != null) {
                mediaPeriod0.maybeThrowPrepareError();
                return;
            }
            this.mediaSource.maybeThrowSourceInfoRefreshError();
        }
        catch(IOException iOException0) {
            PrepareErrorListener maskingMediaPeriod$PrepareErrorListener0 = this.listener;
            if(maskingMediaPeriod$PrepareErrorListener0 == null) {
                throw iOException0;
            }
            if(!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                maskingMediaPeriod$PrepareErrorListener0.onPrepareError(this.id, iOException0);
            }
        }
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod0) {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader$Callback
    public void onContinueLoadingRequested(SequenceableLoader sequenceableLoader0) {
        this.onContinueLoadingRequested(((MediaPeriod)sequenceableLoader0));
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod$Callback
    public void onPrepared(MediaPeriod mediaPeriod0) {
        this.callback.onPrepared(this);
    }

    public void overridePreparePositionUs(long v) {
        this.preparePositionOverrideUs = v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(Callback mediaPeriod$Callback0, long v) {
        this.callback = mediaPeriod$Callback0;
        MediaPeriod mediaPeriod0 = this.mediaPeriod;
        if(mediaPeriod0 != null) {
            mediaPeriod0.prepare(this, this.getPreparePositionWithOverride(this.preparePositionUs));
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return this.mediaPeriod.readDiscontinuity();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void reevaluateBuffer(long v) {
        this.mediaPeriod.reevaluateBuffer(v);
    }

    public void releasePeriod() {
        MediaPeriod mediaPeriod0 = this.mediaPeriod;
        if(mediaPeriod0 != null) {
            this.mediaSource.releasePeriod(mediaPeriod0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long v) {
        return this.mediaPeriod.seekToUs(v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
        long v1 = this.preparePositionOverrideUs;
        if(v1 != 0x8000000000000001L && v == this.preparePositionUs) {
            this.preparePositionOverrideUs = 0x8000000000000001L;
            return this.mediaPeriod.selectTracks(arr_trackSelection, arr_z, arr_sampleStream, arr_z1, v1);
        }
        return this.mediaPeriod.selectTracks(arr_trackSelection, arr_z, arr_sampleStream, arr_z1, v);
    }

    public void setPrepareErrorListener(PrepareErrorListener maskingMediaPeriod$PrepareErrorListener0) {
        this.listener = maskingMediaPeriod$PrepareErrorListener0;
    }
}

