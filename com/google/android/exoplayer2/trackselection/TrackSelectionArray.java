package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class TrackSelectionArray {
    private int hashCode;
    public final int length;
    private final TrackSelection[] trackSelections;

    public TrackSelectionArray(TrackSelection[] arr_trackSelection) {
        this.trackSelections = arr_trackSelection;
        this.length = arr_trackSelection.length;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return TrackSelectionArray.class == class0 ? Arrays.equals(this.trackSelections, ((TrackSelectionArray)object0).trackSelections) : false;
        }
        return false;
    }

    public TrackSelection get(int v) {
        return this.trackSelections[v];
    }

    public TrackSelection[] getAll() {
        return (TrackSelection[])this.trackSelections.clone();
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackSelections) + 0x20F;
        }
        return this.hashCode;
    }
}

