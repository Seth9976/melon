package com.google.android.gms.cast.framework.media;

import java.util.List;

final class zzp extends Callback {
    final MediaQueueArrayAdapter zza;

    public zzp(MediaQueueArrayAdapter mediaQueueArrayAdapter0, zzq zzq0) {
        this.zza = mediaQueueArrayAdapter0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsInsertedInRange(int v, int v1) {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsRemovedAtIndexes(int[] arr_v) {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsReorderedAtIndexes(List list0, int v) {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void itemsUpdatedAtIndexes(int[] arr_v) {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void mediaQueueChanged() {
        this.zza.notifyDataSetChanged();
    }

    @Override  // com.google.android.gms.cast.framework.media.MediaQueue$Callback
    public final void mediaQueueWillChange() {
    }
}

