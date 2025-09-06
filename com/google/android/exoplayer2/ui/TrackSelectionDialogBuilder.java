package com.google.android.exoplayer2.ui;

import Qd.a;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

public final class TrackSelectionDialogBuilder {
    public interface DialogCallback {
        void onTracksSelected(boolean arg1, List arg2);
    }

    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final DialogCallback callback;
    private final Context context;
    private boolean isDisabled;
    private final MappedTrackInfo mappedTrackInfo;
    private List overrides;
    private final int rendererIndex;
    private boolean showDisableOption;
    private final CharSequence title;
    private TrackNameProvider trackNameProvider;

    public TrackSelectionDialogBuilder(Context context0, CharSequence charSequence0, DefaultTrackSelector defaultTrackSelector0, int v) {
        this.context = context0;
        this.title = charSequence0;
        MappedTrackInfo mappingTrackSelector$MappedTrackInfo0 = (MappedTrackInfo)Assertions.checkNotNull(defaultTrackSelector0.getCurrentMappedTrackInfo());
        this.mappedTrackInfo = mappingTrackSelector$MappedTrackInfo0;
        this.rendererIndex = v;
        TrackGroupArray trackGroupArray0 = mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v);
        Parameters defaultTrackSelector$Parameters0 = defaultTrackSelector0.getParameters();
        this.isDisabled = defaultTrackSelector$Parameters0.getRendererDisabled(v);
        SelectionOverride defaultTrackSelector$SelectionOverride0 = defaultTrackSelector$Parameters0.getSelectionOverride(v, trackGroupArray0);
        this.overrides = defaultTrackSelector$SelectionOverride0 == null ? Collections.EMPTY_LIST : Collections.singletonList(defaultTrackSelector$SelectionOverride0);
        this.callback = new c(defaultTrackSelector0, defaultTrackSelector$Parameters0, v, trackGroupArray0, 0);
    }

    public TrackSelectionDialogBuilder(Context context0, CharSequence charSequence0, MappedTrackInfo mappingTrackSelector$MappedTrackInfo0, int v, DialogCallback trackSelectionDialogBuilder$DialogCallback0) {
        this.context = context0;
        this.title = charSequence0;
        this.mappedTrackInfo = mappingTrackSelector$MappedTrackInfo0;
        this.rendererIndex = v;
        this.callback = trackSelectionDialogBuilder$DialogCallback0;
        this.overrides = Collections.EMPTY_LIST;
    }

    public AlertDialog build() {
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this.context);
        View view0 = LayoutInflater.from(alertDialog$Builder0.getContext()).inflate(layout.exo_track_selection_dialog, null);
        View view1 = view0.findViewById(id.exo_track_selection_view);
        ((TrackSelectionView)view1).setAllowMultipleOverrides(this.allowMultipleOverrides);
        ((TrackSelectionView)view1).setAllowAdaptiveSelections(this.allowAdaptiveSelections);
        ((TrackSelectionView)view1).setShowDisableOption(this.showDisableOption);
        TrackNameProvider trackNameProvider0 = this.trackNameProvider;
        if(trackNameProvider0 != null) {
            ((TrackSelectionView)view1).setTrackNameProvider(trackNameProvider0);
        }
        ((TrackSelectionView)view1).init(this.mappedTrackInfo, this.rendererIndex, this.isDisabled, this.overrides, null);
        a a0 = new a(1, this, ((TrackSelectionView)view1));
        return alertDialog$Builder0.setTitle(this.title).setView(view0).setPositiveButton(0x104000A, a0).setNegativeButton(0x1040000, null).create();
    }

    private void lambda$build$1(TrackSelectionView trackSelectionView0, DialogInterface dialogInterface0, int v) {
        List list0 = trackSelectionView0.getOverrides();
        this.callback.onTracksSelected(trackSelectionView0.getIsDisabled(), list0);
    }

    private static void lambda$new$0(DefaultTrackSelector defaultTrackSelector0, Parameters defaultTrackSelector$Parameters0, int v, TrackGroupArray trackGroupArray0, boolean z, List list0) {
        defaultTrackSelector0.setParameters(TrackSelectionUtil.updateParametersWithOverride(defaultTrackSelector$Parameters0, v, trackGroupArray0, z, (list0.isEmpty() ? null : ((SelectionOverride)list0.get(0)))));
    }

    public TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z) {
        this.allowAdaptiveSelections = z;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z) {
        this.allowMultipleOverrides = z;
        return this;
    }

    public TrackSelectionDialogBuilder setIsDisabled(boolean z) {
        this.isDisabled = z;
        return this;
    }

    public TrackSelectionDialogBuilder setOverride(SelectionOverride defaultTrackSelector$SelectionOverride0) {
        return defaultTrackSelector$SelectionOverride0 == null ? this.setOverrides(Collections.EMPTY_LIST) : this.setOverrides(Collections.singletonList(defaultTrackSelector$SelectionOverride0));
    }

    public TrackSelectionDialogBuilder setOverrides(List list0) {
        this.overrides = list0;
        return this;
    }

    public TrackSelectionDialogBuilder setShowDisableOption(boolean z) {
        this.showDisableOption = z;
        return this;
    }

    public TrackSelectionDialogBuilder setTrackNameProvider(TrackNameProvider trackNameProvider0) {
        this.trackNameProvider = trackNameProvider0;
        return this;
    }
}

