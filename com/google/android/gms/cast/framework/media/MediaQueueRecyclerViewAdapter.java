package com.google.android.gms.cast.framework.media;

import androidx.recyclerview.widget.j0;
import com.google.android.gms.cast.MediaQueueItem;

public abstract class MediaQueueRecyclerViewAdapter extends j0 {
    private final MediaQueue zza;
    private final Callback zzb;

    public MediaQueueRecyclerViewAdapter(MediaQueue mediaQueue0) {
        this.zza = mediaQueue0;
        zzr zzr0 = new zzr(this, null);
        this.zzb = zzr0;
        mediaQueue0.registerCallback(zzr0);
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    public MediaQueueItem getItem(int v) {
        return this.zza.getItemAtIndex(v);
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        return this.zza.getItemCount();
    }

    @Override  // androidx.recyclerview.widget.j0
    public long getItemId(int v) {
        return (long)this.zza.itemIdAtIndex(v);
    }

    public MediaQueue getMediaQueue() {
        return this.zza;
    }
}

