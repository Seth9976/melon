package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

public final class ClippingMediaPeriod implements Callback, MediaPeriod {
    final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream0) {
            this.childStream = sampleStream0;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
            this.childStream.maybeThrowError();
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
            if(ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if(this.sentEos) {
                decoderInputBuffer0.setFlags(4);
                return -4;
            }
            int v = this.childStream.readData(formatHolder0, decoderInputBuffer0, z);
            if(v == -5) {
                Format format0 = (Format)Assertions.checkNotNull(formatHolder0.format);
                int v1 = format0.encoderDelay;
                if(v1 != 0 || format0.encoderPadding != 0) {
                    ClippingMediaPeriod clippingMediaPeriod0 = ClippingMediaPeriod.this;
                    int v2 = 0;
                    if(Long.compare(clippingMediaPeriod0.startUs, 0L) != 0) {
                        v1 = 0;
                    }
                    if(clippingMediaPeriod0.endUs == 0x8000000000000000L) {
                        v2 = format0.encoderPadding;
                    }
                    formatHolder0.format = format0.copyWithGaplessInfo(v1, v2);
                }
                return -5;
            }
            long v3 = ClippingMediaPeriod.this.endUs;
            if(v3 != 0x8000000000000000L && (v == -4 && decoderInputBuffer0.timeUs >= v3 || v == -3 && ClippingMediaPeriod.this.getBufferedPositionUs() == 0x8000000000000000L && !decoderInputBuffer0.waitingForKeys)) {
                decoderInputBuffer0.clear();
                decoderInputBuffer0.setFlags(4);
                this.sentEos = true;
                return -4;
            }
            return v;
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long v) {
            return ClippingMediaPeriod.this.isPendingInitialDiscontinuity() ? -3 : this.childStream.skipData(v);
        }
    }

    private Callback callback;
    long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams;
    long startUs;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod0, boolean z, long v, long v1) {
        this.mediaPeriod = mediaPeriod0;
        this.sampleStreams = new ClippingSampleStream[0];
        this.pendingInitialDiscontinuityPositionUs = z ? v : 0x8000000000000001L;
        this.startUs = v;
        this.endUs = v1;
    }

    private SeekParameters clipSeekParameters(long v, SeekParameters seekParameters0) {
        long v1 = Util.constrainValue(seekParameters0.toleranceBeforeUs, 0L, v - this.startUs);
        long v2 = Util.constrainValue(seekParameters0.toleranceAfterUs, 0L, (this.endUs == 0x8000000000000000L ? 0x7FFFFFFFFFFFFFFFL : this.endUs - v));
        return v1 != seekParameters0.toleranceBeforeUs || v2 != seekParameters0.toleranceAfterUs ? new SeekParameters(v1, v2) : seekParameters0;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean continueLoading(long v) {
        return this.mediaPeriod.continueLoading(v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long v, boolean z) {
        this.mediaPeriod.discardBuffer(v, z);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        long v1 = this.startUs;
        if(v == v1) {
            return v1;
        }
        SeekParameters seekParameters1 = this.clipSeekParameters(v, seekParameters0);
        return this.mediaPeriod.getAdjustedSeekPositionUs(v, seekParameters1);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        long v = this.mediaPeriod.getBufferedPositionUs();
        return v == 0x8000000000000000L || this.endUs != 0x8000000000000000L && v >= this.endUs ? 0x8000000000000000L : v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getNextLoadPositionUs() {
        long v = this.mediaPeriod.getNextLoadPositionUs();
        return v == 0x8000000000000000L || this.endUs != 0x8000000000000000L && v >= this.endUs ? 0x8000000000000000L : v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    public boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod0) {
        ((Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader$Callback
    public void onContinueLoadingRequested(SequenceableLoader sequenceableLoader0) {
        this.onContinueLoadingRequested(((MediaPeriod)sequenceableLoader0));
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod$Callback
    public void onPrepared(MediaPeriod mediaPeriod0) {
        ((Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(Callback mediaPeriod$Callback0, long v) {
        this.callback = mediaPeriod$Callback0;
        this.mediaPeriod.prepare(this, v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if(this.isPendingInitialDiscontinuity()) {
            long v = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = 0x8000000000000001L;
            long v1 = this.readDiscontinuity();
            return v1 == 0x8000000000000001L ? v : v1;
        }
        boolean z = false;
        long v2 = this.mediaPeriod.readDiscontinuity();
        if(v2 == 0x8000000000000001L) {
            return 0x8000000000000001L;
        }
        Assertions.checkState(Long.compare(v2, this.startUs) >= 0);
        if(this.endUs == 0x8000000000000000L || v2 <= this.endUs) {
            z = true;
        }
        Assertions.checkState(z);
        return v2;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void reevaluateBuffer(long v) {
        this.mediaPeriod.reevaluateBuffer(v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long v) {
        this.pendingInitialDiscontinuityPositionUs = 0x8000000000000001L;
        ClippingSampleStream[] arr_clippingMediaPeriod$ClippingSampleStream = this.sampleStreams;
        boolean z = false;
        for(int v1 = 0; v1 < arr_clippingMediaPeriod$ClippingSampleStream.length; ++v1) {
            ClippingSampleStream clippingMediaPeriod$ClippingSampleStream0 = arr_clippingMediaPeriod$ClippingSampleStream[v1];
            if(clippingMediaPeriod$ClippingSampleStream0 != null) {
                clippingMediaPeriod$ClippingSampleStream0.clearSentEos();
            }
        }
        long v2 = this.mediaPeriod.seekToUs(v);
        if(v2 == v || v2 >= this.startUs && (this.endUs == 0x8000000000000000L || v2 <= this.endUs)) {
            z = true;
        }
        Assertions.checkState(z);
        return v2;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
        this.sampleStreams = new ClippingSampleStream[arr_sampleStream.length];
        SampleStream[] arr_sampleStream1 = new SampleStream[arr_sampleStream.length];
        for(int v2 = 0; true; ++v2) {
            SampleStream sampleStream0 = null;
            if(v2 >= arr_sampleStream.length) {
                break;
            }
            ClippingSampleStream[] arr_clippingMediaPeriod$ClippingSampleStream = this.sampleStreams;
            ClippingSampleStream clippingMediaPeriod$ClippingSampleStream0 = (ClippingSampleStream)arr_sampleStream[v2];
            arr_clippingMediaPeriod$ClippingSampleStream[v2] = clippingMediaPeriod$ClippingSampleStream0;
            if(clippingMediaPeriod$ClippingSampleStream0 != null) {
                sampleStream0 = clippingMediaPeriod$ClippingSampleStream0.childStream;
            }
            arr_sampleStream1[v2] = sampleStream0;
        }
        long v3 = this.mediaPeriod.selectTracks(arr_trackSelection, arr_z, arr_sampleStream1, arr_z1, v);
        this.pendingInitialDiscontinuityPositionUs = !this.isPendingInitialDiscontinuity() || (v != this.startUs || !ClippingMediaPeriod.shouldKeepInitialDiscontinuity(this.startUs, arr_trackSelection)) ? 0x8000000000000001L : v3;
        Assertions.checkState(v3 == v || v3 >= this.startUs && (this.endUs == 0x8000000000000000L || v3 <= this.endUs));
        for(int v1 = 0; v1 < arr_sampleStream.length; ++v1) {
            SampleStream sampleStream1 = arr_sampleStream1[v1];
            if(sampleStream1 == null) {
                this.sampleStreams[v1] = null;
            }
            else {
                ClippingSampleStream[] arr_clippingMediaPeriod$ClippingSampleStream1 = this.sampleStreams;
                ClippingSampleStream clippingMediaPeriod$ClippingSampleStream1 = arr_clippingMediaPeriod$ClippingSampleStream1[v1];
                if(clippingMediaPeriod$ClippingSampleStream1 == null || clippingMediaPeriod$ClippingSampleStream1.childStream != sampleStream1) {
                    arr_clippingMediaPeriod$ClippingSampleStream1[v1] = new ClippingSampleStream(this, sampleStream1);
                }
            }
            arr_sampleStream[v1] = this.sampleStreams[v1];
        }
        return v3;
    }

    private static boolean shouldKeepInitialDiscontinuity(long v, TrackSelection[] arr_trackSelection) {
        if(Long.compare(v, 0L) != 0) {
            for(int v1 = 0; v1 < arr_trackSelection.length; ++v1) {
                TrackSelection trackSelection0 = arr_trackSelection[v1];
                if(trackSelection0 != null && !MimeTypes.isAudio(trackSelection0.getSelectedFormat().sampleMimeType)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateClipping(long v, long v1) {
        this.startUs = v;
        this.endUs = v1;
    }
}

