package com.google.android.gms.cast.framework.media;

import android.util.LruCache;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.Preconditions;

final class zzn extends LruCache {
    final MediaQueue zza;

    public zzn(MediaQueue mediaQueue0, int v) {
        this.zza = mediaQueue0;
        super(v);
    }

    @Override  // android.util.LruCache
    public final void entryRemoved(boolean z, Object object0, Object object1, Object object2) {
        MediaQueueItem mediaQueueItem0 = (MediaQueueItem)object1;
        MediaQueueItem mediaQueueItem1 = (MediaQueueItem)object2;
        if(!z) {
            return;
        }
        Preconditions.checkNotNull(this.zza.zze);
        this.zza.zze.add(((Integer)object0));
    }
}

