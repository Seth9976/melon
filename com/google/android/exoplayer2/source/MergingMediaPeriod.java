package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class MergingMediaPeriod implements Callback, MediaPeriod {
    private Callback callback;
    private final ArrayList childrenPendingPreparation;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    public final MediaPeriod[] periods;
    private final IdentityHashMap streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0, MediaPeriod[] arr_mediaPeriod) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory0;
        this.periods = arr_mediaPeriod;
        this.childrenPendingPreparation = new ArrayList();
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory0.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap();
        this.enabledPeriods = new MediaPeriod[0];
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean continueLoading(long v) {
        if(!this.childrenPendingPreparation.isEmpty()) {
            int v1 = this.childrenPendingPreparation.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((MediaPeriod)this.childrenPendingPreparation.get(v2)).continueLoading(v);
            }
            return false;
        }
        return this.compositeSequenceableLoader.continueLoading(v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long v, boolean z) {
        MediaPeriod[] arr_mediaPeriod = this.enabledPeriods;
        for(int v1 = 0; v1 < arr_mediaPeriod.length; ++v1) {
            arr_mediaPeriod[v1].discardBuffer(v, z);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        MediaPeriod[] arr_mediaPeriod = this.enabledPeriods;
        return arr_mediaPeriod.length <= 0 ? this.periods[0].getAdjustedSeekPositionUs(v, seekParameters0) : arr_mediaPeriod[0].getAdjustedSeekPositionUs(v, seekParameters0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray)Assertions.checkNotNull(this.trackGroups);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        MediaPeriod[] arr_mediaPeriod = this.periods;
        for(int v = 0; v < arr_mediaPeriod.length; ++v) {
            arr_mediaPeriod[v].maybeThrowPrepareError();
        }
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
        this.childrenPendingPreparation.remove(mediaPeriod0);
        if(!this.childrenPendingPreparation.isEmpty()) {
            return;
        }
        MediaPeriod[] arr_mediaPeriod = this.periods;
        int v1 = 0;
        for(int v = 0; v < arr_mediaPeriod.length; ++v) {
            v1 += arr_mediaPeriod[v].getTrackGroups().length;
        }
        TrackGroup[] arr_trackGroup = new TrackGroup[v1];
        MediaPeriod[] arr_mediaPeriod1 = this.periods;
        for(int v2 = 0; v2 < arr_mediaPeriod1.length; ++v2) {
            TrackGroupArray trackGroupArray0 = arr_mediaPeriod1[v2].getTrackGroups();
            int v4 = trackGroupArray0.length;
            int v5 = 0;
            for(int v3 = 0; v5 < v4; ++v3) {
                arr_trackGroup[v3] = trackGroupArray0.get(v5);
                ++v5;
            }
        }
        this.trackGroups = new TrackGroupArray(arr_trackGroup);
        ((Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(Callback mediaPeriod$Callback0, long v) {
        this.callback = mediaPeriod$Callback0;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        MediaPeriod[] arr_mediaPeriod = this.periods;
        for(int v1 = 0; v1 < arr_mediaPeriod.length; ++v1) {
            arr_mediaPeriod[v1].prepare(this, v);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        long v = this.periods[0].readDiscontinuity();
        for(int v1 = 1; true; ++v1) {
            MediaPeriod[] arr_mediaPeriod = this.periods;
            if(v1 >= arr_mediaPeriod.length) {
                break;
            }
            if(arr_mediaPeriod[v1].readDiscontinuity() != 0x8000000000000001L) {
                throw new IllegalStateException("Child reported discontinuity.");
            }
        }
        if(v != 0x8000000000000001L) {
            MediaPeriod[] arr_mediaPeriod1 = this.enabledPeriods;
            for(int v2 = 0; v2 < arr_mediaPeriod1.length; ++v2) {
                MediaPeriod mediaPeriod0 = arr_mediaPeriod1[v2];
                if(mediaPeriod0 != this.periods[0] && mediaPeriod0.seekToUs(v) != v) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            }
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void reevaluateBuffer(long v) {
        this.compositeSequenceableLoader.reevaluateBuffer(v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long v) {
        long v1 = this.enabledPeriods[0].seekToUs(v);
        for(int v2 = 1; true; ++v2) {
            MediaPeriod[] arr_mediaPeriod = this.enabledPeriods;
            if(v2 >= arr_mediaPeriod.length) {
                break;
            }
            if(arr_mediaPeriod[v2].seekToUs(v1) != v1) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return v1;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
        int[] arr_v = new int[arr_trackSelection.length];
        int[] arr_v1 = new int[arr_trackSelection.length];
        for(int v1 = 0; v1 < arr_trackSelection.length; ++v1) {
            SampleStream sampleStream0 = arr_sampleStream[v1];
            arr_v[v1] = sampleStream0 == null ? -1 : ((int)(((Integer)this.streamPeriodIndices.get(sampleStream0))));
            arr_v1[v1] = -1;
            TrackSelection trackSelection0 = arr_trackSelection[v1];
            if(trackSelection0 != null) {
                TrackGroup trackGroup0 = trackSelection0.getTrackGroup();
                for(int v2 = 0; true; ++v2) {
                    MediaPeriod[] arr_mediaPeriod = this.periods;
                    if(v2 >= arr_mediaPeriod.length) {
                        break;
                    }
                    if(arr_mediaPeriod[v2].getTrackGroups().indexOf(trackGroup0) != -1) {
                        arr_v1[v1] = v2;
                        break;
                    }
                }
            }
        }
        this.streamPeriodIndices.clear();
        SampleStream[] arr_sampleStream1 = new SampleStream[arr_trackSelection.length];
        SampleStream[] arr_sampleStream2 = new SampleStream[arr_trackSelection.length];
        TrackSelection[] arr_trackSelection1 = new TrackSelection[arr_trackSelection.length];
        ArrayList arrayList0 = new ArrayList(this.periods.length);
        long v3 = v;
        for(int v4 = 0; v4 < this.periods.length; v4 = v6 + 1) {
            for(int v5 = 0; true; ++v5) {
                TrackSelection trackSelection1 = null;
                if(v5 >= arr_trackSelection.length) {
                    break;
                }
                arr_sampleStream2[v5] = arr_v[v5] == v4 ? arr_sampleStream[v5] : null;
                if(arr_v1[v5] == v4) {
                    trackSelection1 = arr_trackSelection[v5];
                }
                arr_trackSelection1[v5] = trackSelection1;
            }
            int v6 = v4;
            long v7 = this.periods[v4].selectTracks(arr_trackSelection1, arr_z, arr_sampleStream2, arr_z1, v3);
            if(v6 == 0) {
                v3 = v7;
            }
            else if(v7 != v3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for(int v8 = 0; true; ++v8) {
                boolean z1 = true;
                if(v8 >= arr_trackSelection.length) {
                    break;
                }
                if(arr_v1[v8] == v6) {
                    SampleStream sampleStream1 = (SampleStream)Assertions.checkNotNull(arr_sampleStream2[v8]);
                    arr_sampleStream1[v8] = arr_sampleStream2[v8];
                    this.streamPeriodIndices.put(sampleStream1, v6);
                    z = true;
                }
                else if(arr_v[v8] == v6) {
                    if(arr_sampleStream2[v8] != null) {
                        z1 = false;
                    }
                    Assertions.checkState(z1);
                }
            }
            if(z) {
                arrayList0.add(this.periods[v6]);
            }
        }
        System.arraycopy(arr_sampleStream1, 0, arr_sampleStream, 0, arr_trackSelection.length);
        MediaPeriod[] arr_mediaPeriod1 = new MediaPeriod[arrayList0.size()];
        this.enabledPeriods = arr_mediaPeriod1;
        arrayList0.toArray(arr_mediaPeriod1);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return v3;
    }
}

