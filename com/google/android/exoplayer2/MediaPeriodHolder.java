package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    private final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    private MediaPeriodHolder next;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    private TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] arr_rendererCapabilities, long v, TrackSelector trackSelector0, Allocator allocator0, MediaSource mediaSource0, MediaPeriodInfo mediaPeriodInfo0, TrackSelectorResult trackSelectorResult0) {
        this.rendererCapabilities = arr_rendererCapabilities;
        this.rendererPositionOffsetUs = v;
        this.trackSelector = trackSelector0;
        this.mediaSource = mediaSource0;
        this.uid = mediaPeriodInfo0.id.periodUid;
        this.info = mediaPeriodInfo0;
        this.trackGroups = TrackGroupArray.EMPTY;
        this.trackSelectorResult = trackSelectorResult0;
        this.sampleStreams = new SampleStream[arr_rendererCapabilities.length];
        this.mayRetainStreamFlags = new boolean[arr_rendererCapabilities.length];
        this.mediaPeriod = MediaPeriodHolder.createMediaPeriod(mediaPeriodInfo0.id, mediaSource0, allocator0, mediaPeriodInfo0.startPositionUs, mediaPeriodInfo0.endPositionUs);
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult0, long v, boolean z) {
        return this.applyTrackSelection(trackSelectorResult0, v, z, new boolean[this.rendererCapabilities.length]);
    }

    public long applyTrackSelection(TrackSelectorResult trackSelectorResult0, long v, boolean z, boolean[] arr_z) {
        for(int v1 = 0; true; ++v1) {
            boolean z1 = true;
            if(v1 >= trackSelectorResult0.length) {
                break;
            }
            boolean[] arr_z1 = this.mayRetainStreamFlags;
            if(z || !trackSelectorResult0.isEquivalent(this.trackSelectorResult, v1)) {
                z1 = false;
            }
            arr_z1[v1] = z1;
        }
        this.disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.disableTrackSelectionsInResult();
        this.trackSelectorResult = trackSelectorResult0;
        this.enableTrackSelectionsInResult();
        TrackSelectionArray trackSelectionArray0 = trackSelectorResult0.selections;
        TrackSelection[] arr_trackSelection = trackSelectionArray0.getAll();
        long v2 = this.mediaPeriod.selectTracks(arr_trackSelection, this.mayRetainStreamFlags, this.sampleStreams, arr_z, v);
        this.associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        for(int v3 = 0; true; ++v3) {
            SampleStream[] arr_sampleStream = this.sampleStreams;
            if(v3 >= arr_sampleStream.length) {
                break;
            }
            if(arr_sampleStream[v3] == null) {
                Assertions.checkState(trackSelectionArray0.get(v3) == null);
            }
            else {
                Assertions.checkState(trackSelectorResult0.isRendererEnabled(v3));
                if(this.rendererCapabilities[v3].getTrackType() != 6) {
                    this.hasEnabledTracks = true;
                }
            }
        }
        return v2;
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] arr_sampleStream) {
        for(int v = 0; true; ++v) {
            RendererCapabilities[] arr_rendererCapabilities = this.rendererCapabilities;
            if(v >= arr_rendererCapabilities.length) {
                break;
            }
            if(arr_rendererCapabilities[v].getTrackType() == 6 && this.trackSelectorResult.isRendererEnabled(v)) {
                arr_sampleStream[v] = new EmptySampleStream();
            }
        }
    }

    public void continueLoading(long v) {
        Assertions.checkState(this.isLoadingMediaPeriod());
        long v1 = this.toPeriodTime(v);
        this.mediaPeriod.continueLoading(v1);
    }

    private static MediaPeriod createMediaPeriod(MediaPeriodId mediaSource$MediaPeriodId0, MediaSource mediaSource0, Allocator allocator0, long v, long v1) {
        MediaPeriod mediaPeriod0 = mediaSource0.createPeriod(mediaSource$MediaPeriodId0, allocator0, v);
        return v1 != 0x8000000000000001L && v1 != 0x8000000000000000L ? new ClippingMediaPeriod(mediaPeriod0, true, 0L, v1) : mediaPeriod0;
    }

    private void disableTrackSelectionsInResult() {
        if(this.isLoadingMediaPeriod()) {
            for(int v = 0; true; ++v) {
                TrackSelectorResult trackSelectorResult0 = this.trackSelectorResult;
                if(v >= trackSelectorResult0.length) {
                    break;
                }
                boolean z = trackSelectorResult0.isRendererEnabled(v);
                TrackSelection trackSelection0 = this.trackSelectorResult.selections.get(v);
                if(z && trackSelection0 != null) {
                    trackSelection0.disable();
                }
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] arr_sampleStream) {
        for(int v = 0; true; ++v) {
            RendererCapabilities[] arr_rendererCapabilities = this.rendererCapabilities;
            if(v >= arr_rendererCapabilities.length) {
                break;
            }
            if(arr_rendererCapabilities[v].getTrackType() == 6) {
                arr_sampleStream[v] = null;
            }
        }
    }

    private void enableTrackSelectionsInResult() {
        if(this.isLoadingMediaPeriod()) {
            for(int v = 0; true; ++v) {
                TrackSelectorResult trackSelectorResult0 = this.trackSelectorResult;
                if(v >= trackSelectorResult0.length) {
                    break;
                }
                boolean z = trackSelectorResult0.isRendererEnabled(v);
                TrackSelection trackSelection0 = this.trackSelectorResult.selections.get(v);
                if(z && trackSelection0 != null) {
                    trackSelection0.enable();
                }
            }
        }
    }

    public long getBufferedPositionUs() {
        if(!this.prepared) {
            return this.info.startPositionUs;
        }
        long v = this.hasEnabledTracks ? this.mediaPeriod.getBufferedPositionUs() : 0x8000000000000000L;
        return v == 0x8000000000000000L ? this.info.durationUs : v;
    }

    public MediaPeriodHolder getNext() {
        return this.next;
    }

    public long getNextLoadPositionUs() {
        return this.prepared ? this.mediaPeriod.getNextLoadPositionUs() : 0L;
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public long getStartPositionRendererTime() {
        return this.info.startPositionUs + this.rendererPositionOffsetUs;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public TrackSelectorResult getTrackSelectorResult() {
        return this.trackSelectorResult;
    }

    public void handlePrepared(float f, Timeline timeline0) {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        long v = this.applyTrackSelection(this.selectTracks(f, timeline0), this.info.startPositionUs, false);
        this.rendererPositionOffsetUs = this.info.startPositionUs - v + this.rendererPositionOffsetUs;
        this.info = this.info.copyWithStartPositionUs(v);
    }

    // 去混淆评级： 低(20)
    public boolean isFullyBuffered() {
        return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == 0x8000000000000000L);
    }

    private boolean isLoadingMediaPeriod() {
        return this.next == null;
    }

    public void reevaluateBuffer(long v) {
        Assertions.checkState(this.isLoadingMediaPeriod());
        if(this.prepared) {
            long v1 = this.toPeriodTime(v);
            this.mediaPeriod.reevaluateBuffer(v1);
        }
    }

    public void release() {
        this.disableTrackSelectionsInResult();
        MediaPeriodHolder.releaseMediaPeriod(this.info.endPositionUs, this.mediaSource, this.mediaPeriod);
    }

    private static void releaseMediaPeriod(long v, MediaSource mediaSource0, MediaPeriod mediaPeriod0) {
        try {
            if(v != 0x8000000000000001L && v != 0x8000000000000000L) {
                mediaSource0.releasePeriod(((ClippingMediaPeriod)mediaPeriod0).mediaPeriod);
                return;
            }
            mediaSource0.releasePeriod(mediaPeriod0);
        }
        catch(RuntimeException runtimeException0) {
            Log.e("MediaPeriodHolder", "Period release failed.", runtimeException0);
        }
    }

    public TrackSelectorResult selectTracks(float f, Timeline timeline0) {
        TrackSelectorResult trackSelectorResult0 = this.trackSelector.selectTracks(this.rendererCapabilities, this.getTrackGroups(), this.info.id, timeline0);
        TrackSelection[] arr_trackSelection = trackSelectorResult0.selections.getAll();
        for(int v = 0; v < arr_trackSelection.length; ++v) {
            TrackSelection trackSelection0 = arr_trackSelection[v];
            if(trackSelection0 != null) {
                trackSelection0.onPlaybackSpeed(f);
            }
        }
        return trackSelectorResult0;
    }

    public void setNext(MediaPeriodHolder mediaPeriodHolder0) {
        if(mediaPeriodHolder0 == this.next) {
            return;
        }
        this.disableTrackSelectionsInResult();
        this.next = mediaPeriodHolder0;
        this.enableTrackSelectionsInResult();
    }

    public void setRendererOffset(long v) {
        this.rendererPositionOffsetUs = v;
    }

    public long toPeriodTime(long v) {
        return v - this.getRendererOffset();
    }

    public long toRendererTime(long v) {
        return v + this.getRendererOffset();
    }
}

