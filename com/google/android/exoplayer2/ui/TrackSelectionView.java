package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class TrackSelectionView extends LinearLayout {
    class ComponentListener implements View.OnClickListener {
        private ComponentListener() {
        }

        public ComponentListener(com.google.android.exoplayer2.ui.TrackSelectionView.1 trackSelectionView$10) {
        }

        @Override  // android.view.View$OnClickListener
        public void onClick(View view0) {
            TrackSelectionView.this.onClick(view0);
        }
    }

    public interface TrackSelectionListener {
        void onTrackSelectionChanged(boolean arg1, List arg2);
    }

    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final ComponentListener componentListener;
    private final CheckedTextView defaultView;
    private final CheckedTextView disableView;
    private final LayoutInflater inflater;
    private boolean isDisabled;
    private TrackSelectionListener listener;
    private MappedTrackInfo mappedTrackInfo;
    private final SparseArray overrides;
    private int rendererIndex;
    private final int selectableItemBackgroundResourceId;
    private TrackGroupArray trackGroups;
    private TrackNameProvider trackNameProvider;
    private CheckedTextView[][] trackViews;

    public TrackSelectionView(Context context0) {
        this(context0, null);
    }

    public TrackSelectionView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public TrackSelectionView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.setOrientation(1);
        this.overrides = new SparseArray();
        this.setSaveFromParentEnabled(false);
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(new int[]{0x101030E});
        int v1 = typedArray0.getResourceId(0, 0);
        this.selectableItemBackgroundResourceId = v1;
        typedArray0.recycle();
        LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
        this.inflater = layoutInflater0;
        ComponentListener trackSelectionView$ComponentListener0 = (View view0) -> {
            if(view0 == TrackSelectionView.this.disableView) {
                TrackSelectionView.this.onDisableViewClicked();
            }
            else if(view0 == TrackSelectionView.this.defaultView) {
                TrackSelectionView.this.onDefaultViewClicked();
            }
            else {
                TrackSelectionView.this.onTrackViewClicked(view0);
            }
            TrackSelectionView.this.updateViewStates();
            TrackSelectionListener trackSelectionView$TrackSelectionListener0 = TrackSelectionView.this.listener;
            if(trackSelectionView$TrackSelectionListener0 != null) {
                trackSelectionView$TrackSelectionListener0.onTrackSelectionChanged(TrackSelectionView.this.getIsDisabled(), TrackSelectionView.this.getOverrides());
            }
        };
        this.componentListener = trackSelectionView$ComponentListener0;
        this.trackNameProvider = new DefaultTrackNameProvider(this.getResources());
        this.trackGroups = TrackGroupArray.EMPTY;
        CheckedTextView checkedTextView0 = (CheckedTextView)layoutInflater0.inflate(0x109000F, this, false);
        this.disableView = checkedTextView0;
        checkedTextView0.setBackgroundResource(v1);
        checkedTextView0.setText(string.exo_track_selection_none);
        checkedTextView0.setEnabled(false);
        checkedTextView0.setFocusable(true);
        checkedTextView0.setOnClickListener(trackSelectionView$ComponentListener0);
        checkedTextView0.setVisibility(8);
        this.addView(checkedTextView0);
        this.addView(layoutInflater0.inflate(layout.exo_list_divider, this, false));
        CheckedTextView checkedTextView1 = (CheckedTextView)layoutInflater0.inflate(0x109000F, this, false);
        this.defaultView = checkedTextView1;
        checkedTextView1.setBackgroundResource(v1);
        checkedTextView1.setText(string.exo_track_selection_auto);
        checkedTextView1.setEnabled(false);
        checkedTextView1.setFocusable(true);
        checkedTextView1.setOnClickListener(trackSelectionView$ComponentListener0);
        this.addView(checkedTextView1);
    }

    public boolean getIsDisabled() {
        return this.isDisabled;
    }

    public List getOverrides() {
        List list0 = new ArrayList(this.overrides.size());
        for(int v = 0; v < this.overrides.size(); ++v) {
            ((ArrayList)list0).add(((SelectionOverride)this.overrides.valueAt(v)));
        }
        return list0;
    }

    private static int[] getTracksAdding(int[] arr_v, int v) {
        int[] arr_v1 = Arrays.copyOf(arr_v, arr_v.length + 1);
        arr_v1[arr_v1.length - 1] = v;
        return arr_v1;
    }

    private static int[] getTracksRemoving(int[] arr_v, int v) {
        int[] arr_v1 = new int[arr_v.length - 1];
        int v2 = 0;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v3 = arr_v[v1];
            if(v3 != v) {
                arr_v1[v2] = v3;
                ++v2;
            }
        }
        return arr_v1;
    }

    public void init(MappedTrackInfo mappingTrackSelector$MappedTrackInfo0, int v, boolean z, List list0, TrackSelectionListener trackSelectionView$TrackSelectionListener0) {
        this.mappedTrackInfo = mappingTrackSelector$MappedTrackInfo0;
        this.rendererIndex = v;
        this.isDisabled = z;
        this.listener = trackSelectionView$TrackSelectionListener0;
        int v1 = this.allowMultipleOverrides ? list0.size() : Math.min(list0.size(), 1);
        for(int v2 = 0; v2 < v1; ++v2) {
            SelectionOverride defaultTrackSelector$SelectionOverride0 = (SelectionOverride)list0.get(v2);
            this.overrides.put(defaultTrackSelector$SelectionOverride0.groupIndex, defaultTrackSelector$SelectionOverride0);
        }
        this.updateViews();
    }

    // 检测为 Lambda 实现
    private void onClick(View view0) [...]

    private void onDefaultViewClicked() {
        this.isDisabled = false;
        this.overrides.clear();
    }

    private void onDisableViewClicked() {
        this.isDisabled = true;
        this.overrides.clear();
    }

    private void onTrackViewClicked(View view0) {
        boolean z = false;
        this.isDisabled = false;
        Pair pair0 = (Pair)view0.getTag();
        int v = (int)(((Integer)pair0.first));
        int v1 = (int)(((Integer)pair0.second));
        SelectionOverride defaultTrackSelector$SelectionOverride0 = (SelectionOverride)this.overrides.get(v);
        Assertions.checkNotNull(this.mappedTrackInfo);
        if(defaultTrackSelector$SelectionOverride0 == null) {
            if(!this.allowMultipleOverrides && this.overrides.size() > 0) {
                this.overrides.clear();
            }
            SelectionOverride defaultTrackSelector$SelectionOverride1 = new SelectionOverride(v, new int[]{v1});
            this.overrides.put(v, defaultTrackSelector$SelectionOverride1);
            return;
        }
        int v2 = defaultTrackSelector$SelectionOverride0.length;
        int[] arr_v = defaultTrackSelector$SelectionOverride0.tracks;
        boolean z1 = ((CheckedTextView)view0).isChecked();
        boolean z2 = this.shouldEnableAdaptiveSelection(v);
        if(z2 || this.shouldEnableMultiGroupSelection()) {
            z = true;
        }
        if(z1 && z) {
            if(v2 == 1) {
                this.overrides.remove(v);
                return;
            }
            SelectionOverride defaultTrackSelector$SelectionOverride2 = new SelectionOverride(v, TrackSelectionView.getTracksRemoving(arr_v, v1));
            this.overrides.put(v, defaultTrackSelector$SelectionOverride2);
            return;
        }
        if(!z1) {
            if(z2) {
                SelectionOverride defaultTrackSelector$SelectionOverride3 = new SelectionOverride(v, TrackSelectionView.getTracksAdding(arr_v, v1));
                this.overrides.put(v, defaultTrackSelector$SelectionOverride3);
                return;
            }
            SelectionOverride defaultTrackSelector$SelectionOverride4 = new SelectionOverride(v, new int[]{v1});
            this.overrides.put(v, defaultTrackSelector$SelectionOverride4);
        }
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if(this.allowAdaptiveSelections != z) {
            this.allowAdaptiveSelections = z;
            this.updateViews();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if(this.allowMultipleOverrides != z) {
            this.allowMultipleOverrides = z;
            if(!z && this.overrides.size() > 1) {
                for(int v = this.overrides.size() - 1; v > 0; --v) {
                    this.overrides.remove(v);
                }
            }
            this.updateViews();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.disableView.setVisibility((z ? 0 : 8));
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider0) {
        this.trackNameProvider = (TrackNameProvider)Assertions.checkNotNull(trackNameProvider0);
        this.updateViews();
    }

    @RequiresNonNull({"mappedTrackInfo"})
    private boolean shouldEnableAdaptiveSelection(int v) {
        return this.allowAdaptiveSelections && this.trackGroups.get(v).length > 1 && this.mappedTrackInfo.getAdaptiveSupport(this.rendererIndex, v, false) != 0;
    }

    private boolean shouldEnableMultiGroupSelection() {
        return this.allowMultipleOverrides && this.trackGroups.length > 1;
    }

    private void updateViewStates() {
        this.disableView.setChecked(this.isDisabled);
        this.defaultView.setChecked(!this.isDisabled && this.overrides.size() == 0);
        for(int v = 0; v < this.trackViews.length; ++v) {
            SelectionOverride defaultTrackSelector$SelectionOverride0 = (SelectionOverride)this.overrides.get(v);
            for(int v1 = 0; true; ++v1) {
                CheckedTextView[] arr_checkedTextView = this.trackViews[v];
                if(v1 >= arr_checkedTextView.length) {
                    break;
                }
                arr_checkedTextView[v1].setChecked(defaultTrackSelector$SelectionOverride0 != null && defaultTrackSelector$SelectionOverride0.containsTrack(v1));
            }
        }
    }

    private void updateViews() {
        for(int v = this.getChildCount() - 1; v >= 3; --v) {
            this.removeViewAt(v);
        }
        if(this.mappedTrackInfo == null) {
            this.disableView.setEnabled(false);
            this.defaultView.setEnabled(false);
            return;
        }
        this.disableView.setEnabled(true);
        this.defaultView.setEnabled(true);
        TrackGroupArray trackGroupArray0 = this.mappedTrackInfo.getTrackGroups(this.rendererIndex);
        this.trackGroups = trackGroupArray0;
        this.trackViews = new CheckedTextView[trackGroupArray0.length][];
        boolean z = this.shouldEnableMultiGroupSelection();
        for(int v1 = 0; true; ++v1) {
            TrackGroupArray trackGroupArray1 = this.trackGroups;
            if(v1 >= trackGroupArray1.length) {
                break;
            }
            TrackGroup trackGroup0 = trackGroupArray1.get(v1);
            boolean z1 = this.shouldEnableAdaptiveSelection(v1);
            this.trackViews[v1] = new CheckedTextView[trackGroup0.length];
            for(int v2 = 0; v2 < trackGroup0.length; ++v2) {
                if(v2 == 0) {
                    this.addView(this.inflater.inflate(layout.exo_list_divider, this, false));
                }
                CheckedTextView checkedTextView0 = (CheckedTextView)this.inflater.inflate((z1 || z ? 0x1090010 : 0x109000F), this, false);
                checkedTextView0.setBackgroundResource(this.selectableItemBackgroundResourceId);
                checkedTextView0.setText(this.trackNameProvider.getTrackName(trackGroup0.getFormat(v2)));
                if(this.mappedTrackInfo.getTrackSupport(this.rendererIndex, v1, v2) == 4) {
                    checkedTextView0.setFocusable(true);
                    checkedTextView0.setTag(Pair.create(v1, v2));
                    checkedTextView0.setOnClickListener(this.componentListener);
                }
                else {
                    checkedTextView0.setFocusable(false);
                    checkedTextView0.setEnabled(false);
                }
                this.trackViews[v1][v2] = checkedTextView0;
                this.addView(checkedTextView0);
            }
        }
        this.updateViewStates();
    }

    class com.google.android.exoplayer2.ui.TrackSelectionView.1 {
    }

}

