package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final TrackSelectionArray selections;

    public TrackSelectorResult(RendererConfiguration[] arr_rendererConfiguration, TrackSelection[] arr_trackSelection, Object object0) {
        this.rendererConfigurations = arr_rendererConfiguration;
        this.selections = new TrackSelectionArray(arr_trackSelection);
        this.info = object0;
        this.length = arr_rendererConfiguration.length;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult0) {
        if(trackSelectorResult0 != null && trackSelectorResult0.selections.length == this.selections.length) {
            for(int v = 0; v < this.selections.length; ++v) {
                if(!this.isEquivalent(trackSelectorResult0, v)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // 去混淆评级： 低(30)
    public boolean isEquivalent(TrackSelectorResult trackSelectorResult0, int v) {
        return trackSelectorResult0 == null ? false : Util.areEqual(this.rendererConfigurations[v], trackSelectorResult0.rendererConfigurations[v]) && Util.areEqual(this.selections.get(v), trackSelectorResult0.selections.get(v));
    }

    public boolean isRendererEnabled(int v) {
        return this.rendererConfigurations[v] != null;
    }
}

