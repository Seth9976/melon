package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.google.android.gms.cast.MediaQueueItem;

public abstract class MediaQueueArrayAdapter extends ArrayAdapter {
    private final MediaQueue zza;
    private final Callback zzb;

    public MediaQueueArrayAdapter(MediaQueue mediaQueue0, Context context0, int v) {
        super(context0, v);
        this.zza = mediaQueue0;
        zzp zzp0 = new zzp(this, null);
        this.zzb = zzp0;
        mediaQueue0.registerCallback(zzp0);
    }

    @Override  // android.widget.BaseAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public void dispose() {
        this.zza.unregisterCallback(this.zzb);
    }

    @Override  // android.widget.ArrayAdapter
    public int getCount() {
        return this.zza.getItemCount();
    }

    public MediaQueueItem getItem(int v) {
        return this.zza.getItemAtIndex(v);
    }

    @Override  // android.widget.ArrayAdapter
    public final Object getItem(int v) {
        return this.getItem(v);
    }

    @Override  // android.widget.ArrayAdapter
    public long getItemId(int v) {
        return (long)this.zza.itemIdAtIndex(v);
    }

    public MediaQueue getMediaQueue() {
        return this.zza;
    }

    @Override  // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override  // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.zza.getItemCount() == 0;
    }

    @Override  // android.widget.BaseAdapter
    public boolean isEnabled(int v) {
        return this.zza.getItemAtIndex(v, false) != null;
    }
}

