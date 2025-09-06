package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

public final class SilenceMediaSource extends BaseMediaSource {
    public static final class Factory {
        private long durationUs;
        private Object tag;

        public SilenceMediaSource createMediaSource() {
            return new SilenceMediaSource(this.durationUs, this.tag, null);
        }

        public Factory setDurationUs(long v) {
            this.durationUs = v;
            return this;
        }

        public Factory setTag(Object object0) {
            this.tag = object0;
            return this;
        }
    }

    static final class SilenceMediaPeriod implements MediaPeriod {
        private static final TrackGroupArray TRACKS;
        private final long durationUs;
        private final ArrayList sampleStreams;

        static {
            SilenceMediaPeriod.TRACKS = new TrackGroupArray(new TrackGroup[]{new TrackGroup(new Format[]{SilenceMediaSource.FORMAT})});
        }

        public SilenceMediaPeriod(long v) {
            this.durationUs = v;
            this.sampleStreams = new ArrayList();
        }

        private long constrainSeekPosition(long v) {
            return Util.constrainValue(v, 0L, this.durationUs);
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public boolean continueLoading(long v) {
            return false;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long v, boolean z) {
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
            return this.constrainSeekPosition(v);
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public long getBufferedPositionUs() {
            return 0x8000000000000000L;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public long getNextLoadPositionUs() {
            return 0x8000000000000000L;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray getTrackGroups() {
            return SilenceMediaPeriod.TRACKS;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public boolean isLoading() {
            return false;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() {
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public void prepare(Callback mediaPeriod$Callback0, long v) {
            mediaPeriod$Callback0.onPrepared(this);
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            return 0x8000000000000001L;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public void reevaluateBuffer(long v) {
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long v) {
            long v1 = this.constrainSeekPosition(v);
            for(int v2 = 0; v2 < this.sampleStreams.size(); ++v2) {
                ((SilenceSampleStream)this.sampleStreams.get(v2)).seekTo(v1);
            }
            return v1;
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
            long v1 = this.constrainSeekPosition(v);
            for(int v2 = 0; v2 < arr_trackSelection.length; ++v2) {
                SampleStream sampleStream0 = arr_sampleStream[v2];
                if(sampleStream0 != null && (arr_trackSelection[v2] == null || !arr_z[v2])) {
                    this.sampleStreams.remove(sampleStream0);
                    arr_sampleStream[v2] = null;
                }
                if(arr_sampleStream[v2] == null && arr_trackSelection[v2] != null) {
                    SilenceSampleStream silenceMediaSource$SilenceSampleStream0 = new SilenceSampleStream(this.durationUs);
                    silenceMediaSource$SilenceSampleStream0.seekTo(v1);
                    this.sampleStreams.add(silenceMediaSource$SilenceSampleStream0);
                    arr_sampleStream[v2] = silenceMediaSource$SilenceSampleStream0;
                    arr_z1[v2] = true;
                }
            }
            return v1;
        }
    }

    static final class SilenceSampleStream implements SampleStream {
        private final long durationBytes;
        private long positionBytes;
        private boolean sentFormat;

        public SilenceSampleStream(long v) {
            this.durationBytes = SilenceMediaSource.getAudioByteCount(v);
            this.seekTo(0L);
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return true;
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
            if(this.sentFormat && !z) {
                long v = this.durationBytes - this.positionBytes;
                if(Long.compare(v, 0L) == 0) {
                    decoderInputBuffer0.addFlag(4);
                    return -4;
                }
                int v1 = (int)Math.min(SilenceMediaSource.SILENCE_SAMPLE.length, v);
                decoderInputBuffer0.ensureSpaceForWrite(v1);
                decoderInputBuffer0.data.put(SilenceMediaSource.SILENCE_SAMPLE, 0, v1);
                decoderInputBuffer0.timeUs = SilenceMediaSource.getAudioPositionUs(this.positionBytes);
                decoderInputBuffer0.addFlag(1);
                this.positionBytes += (long)v1;
                return -4;
            }
            formatHolder0.format = SilenceMediaSource.FORMAT;
            this.sentFormat = true;
            return -5;
        }

        public void seekTo(long v) {
            this.positionBytes = Util.constrainValue(SilenceMediaSource.getAudioByteCount(v), 0L, this.durationBytes);
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long v) {
            long v1 = this.positionBytes;
            this.seekTo(v);
            return (int)((this.positionBytes - v1) / 0x1000L);
        }
    }

    private static final int CHANNEL_COUNT = 2;
    private static final int ENCODING = 2;
    private static final Format FORMAT = null;
    private static final int SAMPLE_RATE_HZ = 44100;
    private static final byte[] SILENCE_SAMPLE;
    private final long durationUs;
    private final Object tag;

    static {
        SilenceMediaSource.FORMAT = Format.createAudioSampleFormat(null, "audio/raw", null, -1, -1, 2, 44100, 2, null, null, 0, null);
        SilenceMediaSource.SILENCE_SAMPLE = new byte[Util.getPcmFrameSize(2, 2) * 0x400];
    }

    public SilenceMediaSource(long v) {
        this(v, null);
    }

    private SilenceMediaSource(long v, Object object0) {
        Assertions.checkArgument(v >= 0L);
        this.durationUs = v;
        this.tag = object0;
    }

    public SilenceMediaSource(long v, Object object0, com.google.android.exoplayer2.source.SilenceMediaSource.1 silenceMediaSource$10) {
        this(v, object0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        return new SilenceMediaPeriod(this.durationUs);
    }

    private static long getAudioByteCount(long v) {
        return ((long)Util.getPcmFrameSize(2, 2)) * (v * 44100L / 1000000L);
    }

    private static long getAudioPositionUs(long v) {
        return v / ((long)Util.getPcmFrameSize(2, 2)) * 1000000L / 44100L;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        this.refreshSourceInfo(new SinglePeriodTimeline(this.durationUs, true, false, false, null, this.tag));
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    class com.google.android.exoplayer2.source.SilenceMediaSource.1 {
    }

}

