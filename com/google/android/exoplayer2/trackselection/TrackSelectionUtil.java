package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroupArray;

public final class TrackSelectionUtil {
    public interface AdaptiveTrackSelectionFactory {
        TrackSelection createAdaptiveTrackSelection(Definition arg1);
    }

    public static TrackSelection[] createTrackSelectionsForDefinitions(Definition[] arr_trackSelection$Definition, AdaptiveTrackSelectionFactory trackSelectionUtil$AdaptiveTrackSelectionFactory0) {
        TrackSelection[] arr_trackSelection = new TrackSelection[arr_trackSelection$Definition.length];
        boolean z = false;
        for(int v = 0; v < arr_trackSelection$Definition.length; ++v) {
            Definition trackSelection$Definition0 = arr_trackSelection$Definition[v];
            if(trackSelection$Definition0 != null) {
                int[] arr_v = trackSelection$Definition0.tracks;
                if(arr_v.length <= 1 || z) {
                    arr_trackSelection[v] = new FixedTrackSelection(trackSelection$Definition0.group, arr_v[0], trackSelection$Definition0.reason, trackSelection$Definition0.data);
                }
                else {
                    arr_trackSelection[v] = trackSelectionUtil$AdaptiveTrackSelectionFactory0.createAdaptiveTrackSelection(trackSelection$Definition0);
                    z = true;
                }
            }
        }
        return arr_trackSelection;
    }

    public static Parameters updateParametersWithOverride(Parameters defaultTrackSelector$Parameters0, int v, TrackGroupArray trackGroupArray0, boolean z, SelectionOverride defaultTrackSelector$SelectionOverride0) {
        ParametersBuilder defaultTrackSelector$ParametersBuilder0 = defaultTrackSelector$Parameters0.buildUpon().clearSelectionOverrides(v).setRendererDisabled(v, z);
        if(defaultTrackSelector$SelectionOverride0 != null) {
            defaultTrackSelector$ParametersBuilder0.setSelectionOverride(v, trackGroupArray0, defaultTrackSelector$SelectionOverride0);
        }
        return defaultTrackSelector$ParametersBuilder0.build();
    }
}

