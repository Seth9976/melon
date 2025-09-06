package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;

public class MediaQueue {
    public static abstract class Callback {
        public void itemsInsertedInRange(int v, int v1) {
        }

        public void itemsReloaded() {
        }

        public void itemsRemovedAtIndexes(int[] arr_v) {
        }

        public void itemsReorderedAtIndexes(List list0, int v) {
        }

        public void itemsUpdatedAtIndexes(int[] arr_v) {
        }

        public void mediaQueueChanged() {
        }

        public void mediaQueueWillChange() {
        }
    }

    long zza;
    List zzb;
    final SparseIntArray zzc;
    LruCache zzd;
    final List zze;
    final Deque zzf;
    private final Logger zzg;
    private final RemoteMediaClient zzh;
    private final int zzi;
    private final Handler zzj;
    private final TimerTask zzk;
    private PendingResult zzl;
    private PendingResult zzm;
    private final Set zzn;

    public MediaQueue(RemoteMediaClient remoteMediaClient0, int v, int v1) {
        this.zzn = Collections.synchronizedSet(new HashSet());
        this.zzg = new Logger("MediaQueue");
        this.zzh = remoteMediaClient0;
        this.zzi = 20;
        this.zzb = new ArrayList();
        this.zzc = new SparseIntArray();
        this.zze = new ArrayList();
        this.zzf = new ArrayDeque(20);
        this.zzj = new zzet(Looper.getMainLooper());
        this.zzk = new zzm(this);
        remoteMediaClient0.registerCallback(new zzo(this));
        this.zzt(20);
        this.zza = this.zzp();
        this.zzo();
    }

    public PendingResult fetchMoreItemsRelativeToIndex(int v, int v1, int v2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(this.zza == 0L) {
            return RemoteMediaClient.zzf(2100, "No active media session");
        }
        int v3 = this.itemIdAtIndex(v);
        return v3 == 0 ? RemoteMediaClient.zzf(2001, "index out of bound") : this.zzh.zzh(v3, v1, v2);
    }

    public MediaQueueItem getItemAtIndex(int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.getItemAtIndex(v, true);
    }

    public MediaQueueItem getItemAtIndex(int v, boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(v >= 0 && v < this.zzb.size()) {
            Integer integer0 = (Integer)this.zzb.get(v);
            integer0.intValue();
            MediaQueueItem mediaQueueItem0 = (MediaQueueItem)this.zzd.get(integer0);
            if(mediaQueueItem0 == null && z) {
                Deque deque0 = this.zzf;
                if(!deque0.contains(integer0)) {
                    while(deque0.size() >= this.zzi) {
                        deque0.removeFirst();
                    }
                    deque0.add(integer0);
                    this.zzy();
                }
            }
            return mediaQueueItem0;
        }
        return null;
    }

    public int getItemCount() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzb.size();
    }

    public int[] getItemIds() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return CastUtils.zzf(this.zzb);
    }

    public int indexOfItemWithId(int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzc.get(v, -1);
    }

    public int itemIdAtIndex(int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return v < 0 || v >= this.zzb.size() ? 0 : ((int)(((Integer)this.zzb.get(v))));
    }

    public void registerCallback(Callback mediaQueue$Callback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.add(mediaQueue$Callback0);
    }

    public void setCacheCapacity(int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        LruCache lruCache0 = this.zzd;
        ArrayList arrayList0 = new ArrayList();
        this.zzt(v);
        int v1 = lruCache0.size();
        for(Object object0: lruCache0.snapshot().entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(v1 > v) {
                int v2 = (int)(((Integer)map$Entry0.getKey()));
                int v3 = this.zzc.get(v2, -1);
                if(v3 != -1) {
                    arrayList0.add(v3);
                }
            }
            else {
                this.zzd.put(((Integer)map$Entry0.getKey()), ((MediaQueueItem)map$Entry0.getValue()));
            }
            --v1;
        }
        if(arrayList0.isEmpty()) {
            return;
        }
        Collections.sort(arrayList0);
        this.zzx();
        this.zzw(CastUtils.zzf(arrayList0));
        this.zzu();
    }

    public void unregisterCallback(Callback mediaQueue$Callback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.remove(mediaQueue$Callback0);
    }

    public static void zze(MediaQueue mediaQueue0, int v, int v1) {
        Set set0 = mediaQueue0.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).itemsInsertedInRange(v, v1);
            }
        }
    }

    public static void zzf(MediaQueue mediaQueue0, int[] arr_v) {
        Set set0 = mediaQueue0.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).itemsRemovedAtIndexes(arr_v);
            }
        }
    }

    public static void zzg(MediaQueue mediaQueue0, List list0, int v) {
        Set set0 = mediaQueue0.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).itemsReorderedAtIndexes(list0, v);
            }
        }
    }

    public static void zzj(MediaQueue mediaQueue0) {
        Deque deque0 = mediaQueue0.zzf;
        if(!deque0.isEmpty() && mediaQueue0.zzl == null && mediaQueue0.zza != 0L) {
            int[] arr_v = CastUtils.zzf(deque0);
            PendingResult pendingResult0 = mediaQueue0.zzh.zzj(arr_v);
            mediaQueue0.zzl = pendingResult0;
            pendingResult0.setResultCallback(new zzl(mediaQueue0));
            deque0.clear();
        }
    }

    public static void zzk(MediaQueue mediaQueue0) {
        SparseIntArray sparseIntArray0 = mediaQueue0.zzc;
        sparseIntArray0.clear();
        for(int v = 0; v < mediaQueue0.zzb.size(); ++v) {
            sparseIntArray0.put(((int)(((Integer)mediaQueue0.zzb.get(v)))), v);
        }
    }

    public final void zzl() {
        this.zzx();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.evictAll();
        this.zze.clear();
        this.zzq();
        this.zzf.clear();
        this.zzr();
        this.zzs();
        this.zzv();
        this.zzu();
    }

    public final void zzm(MediaChannelResult remoteMediaClient$MediaChannelResult0) {
        Status status0 = remoteMediaClient$MediaChannelResult0.getStatus();
        int v = status0.getStatusCode();
        if(v != 0) {
            this.zzg.w("Error fetching queue item ids, statusCode=" + v + ", statusMessage=" + status0.getStatusMessage(), new Object[0]);
        }
        this.zzm = null;
        if(!this.zzf.isEmpty()) {
            this.zzy();
        }
    }

    public final void zzn(MediaChannelResult remoteMediaClient$MediaChannelResult0) {
        Status status0 = remoteMediaClient$MediaChannelResult0.getStatus();
        int v = status0.getStatusCode();
        if(v != 0) {
            this.zzg.w("Error fetching queue items, statusCode=" + v + ", statusMessage=" + status0.getStatusMessage(), new Object[0]);
        }
        this.zzl = null;
        if(!this.zzf.isEmpty()) {
            this.zzy();
        }
    }

    public final void zzo() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(this.zza != 0L && this.zzm == null) {
            this.zzr();
            this.zzs();
            PendingResult pendingResult0 = this.zzh.zzi();
            this.zzm = pendingResult0;
            pendingResult0.setResultCallback(new zzk(this));
        }
    }

    private final long zzp() {
        MediaStatus mediaStatus0 = this.zzh.getMediaStatus();
        return mediaStatus0 == null || mediaStatus0.zzd() ? 0L : mediaStatus0.zzb();
    }

    private final void zzq() {
        this.zzj.removeCallbacks(this.zzk);
    }

    private final void zzr() {
        PendingResult pendingResult0 = this.zzm;
        if(pendingResult0 != null) {
            pendingResult0.cancel();
            this.zzm = null;
        }
    }

    private final void zzs() {
        PendingResult pendingResult0 = this.zzl;
        if(pendingResult0 != null) {
            pendingResult0.cancel();
            this.zzl = null;
        }
    }

    private final void zzt(int v) {
        this.zzd = new zzn(this, v);
    }

    private final void zzu() {
        Set set0 = this.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).mediaQueueChanged();
            }
        }
    }

    private final void zzv() {
        Set set0 = this.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).itemsReloaded();
            }
        }
    }

    private final void zzw(int[] arr_v) {
        Set set0 = this.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).itemsUpdatedAtIndexes(arr_v);
            }
        }
    }

    private final void zzx() {
        Set set0 = this.zzn;
        synchronized(set0) {
            for(Object object0: set0) {
                ((Callback)object0).mediaQueueWillChange();
            }
        }
    }

    private final void zzy() {
        this.zzq();
        this.zzj.postDelayed(this.zzk, 500L);
    }
}

