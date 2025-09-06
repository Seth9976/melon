package com.google.android.gms.cast.framework.media;

import java.util.List;

final class zzr extends Callback {
    final MediaQueueRecyclerViewAdapter zza;

    public zzr(MediaQueueRecyclerViewAdapter mediaQueueRecyclerViewAdapter0, zzs zzs0) {
        this.zza = mediaQueueRecyclerViewAdapter0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsInsertedInRange(int v, int v1) {
        this.zza.notifyItemRangeInserted(v, v1);
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsRemovedAtIndexes(int[] arr_v) {
        if(arr_v.length <= 1) {
            for(int v = 0; v < arr_v.length; ++v) {
                this.zza.notifyItemRemoved(arr_v[v]);
            }
            return;
        }
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsReorderedAtIndexes(List list0, int v) {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsUpdatedAtIndexes(int[] arr_v) {
        for(int v = 0; v < arr_v.length; ++v) {
            this.zza.notifyItemChanged(arr_v[v]);
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void mediaQueueChanged() {
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void mediaQueueWillChange() {
    }
}

