package com.google.android.gms.cast.framework.media;

import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.CastUtils;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class zzo extends Callback {
    final MediaQueue zza;

    public zzo(MediaQueue mediaQueue0) {
        this.zza = mediaQueue0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onStatusUpdated() {
        MediaQueue mediaQueue0 = this.zza;
        long v = mediaQueue0.zzp();
        if(v != mediaQueue0.zza) {
            mediaQueue0.zza = v;
            mediaQueue0.zzl();
            if(mediaQueue0.zza != 0L) {
                mediaQueue0.zzo();
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zzb(int[] arr_v) {
        MediaQueue mediaQueue0 = this.zza;
        List list0 = CastUtils.zzd(arr_v);
        if(mediaQueue0.zzb.equals(list0)) {
            return;
        }
        mediaQueue0.zzx();
        mediaQueue0.zzd.evictAll();
        mediaQueue0.zze.clear();
        mediaQueue0.zzb = list0;
        MediaQueue.zzk(mediaQueue0);
        mediaQueue0.zzv();
        mediaQueue0.zzu();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zzc(int[] arr_v, int v) {
        int v1;
        if(v == 0) {
            v1 = this.zza.zzb.size();
        }
        else {
            MediaQueue mediaQueue0 = this.zza;
            v1 = mediaQueue0.zzc.get(v, -1);
            if(v1 == -1) {
                mediaQueue0.zzo();
                return;
            }
        }
        this.zza.zzx();
        this.zza.zzb.addAll(v1, CastUtils.zzd(arr_v));
        MediaQueue.zzk(this.zza);
        MediaQueue.zze(this.zza, v1, arr_v.length);
        this.zza.zzu();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zzd(MediaQueueItem[] arr_mediaQueueItem) {
        HashSet hashSet0 = new HashSet();
        MediaQueue mediaQueue0 = this.zza;
        List list0 = mediaQueue0.zze;
        list0.clear();
        for(int v = 0; v < arr_mediaQueueItem.length; ++v) {
            MediaQueueItem mediaQueueItem0 = arr_mediaQueueItem[v];
            int v1 = mediaQueueItem0.getItemId();
            mediaQueue0.zzd.put(v1, mediaQueueItem0);
            int v2 = mediaQueue0.zzc.get(v1, -1);
            if(v2 == -1) {
                mediaQueue0.zzo();
                return;
            }
            hashSet0.add(v2);
        }
        for(Object object0: list0) {
            int v3 = mediaQueue0.zzc.get(((int)(((Integer)object0))), -1);
            if(v3 != -1) {
                hashSet0.add(v3);
            }
        }
        list0.clear();
        ArrayList arrayList0 = new ArrayList(hashSet0);
        Collections.sort(arrayList0);
        mediaQueue0.zzx();
        mediaQueue0.zzw(CastUtils.zzf(arrayList0));
        mediaQueue0.zzu();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zze(int[] arr_v) {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            MediaQueue mediaQueue0 = this.zza;
            mediaQueue0.zzd.remove(v1);
            SparseIntArray sparseIntArray0 = mediaQueue0.zzc;
            int v2 = sparseIntArray0.get(v1, -1);
            if(v2 == -1) {
                mediaQueue0.zzo();
                return;
            }
            sparseIntArray0.delete(v1);
            arrayList0.add(v2);
        }
        if(arrayList0.isEmpty()) {
            return;
        }
        Collections.sort(arrayList0);
        this.zza.zzx();
        this.zza.zzb.removeAll(CastUtils.zzd(arr_v));
        MediaQueue.zzk(this.zza);
        int[] arr_v1 = CastUtils.zzf(arrayList0);
        MediaQueue.zzf(this.zza, arr_v1);
        this.zza.zzu();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zzf(List list0, List list1, int v) {
        int v1;
        ArrayList arrayList0 = new ArrayList();
        if(v == 0) {
            v1 = this.zza.zzb.size();
        }
        else if(list1.isEmpty()) {
            this.zza.zzg.w("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]);
            v1 = -1;
        }
        else {
            SparseIntArray sparseIntArray0 = this.zza.zzc;
            v1 = sparseIntArray0.get(v, -1);
            if(v1 == -1) {
                v1 = sparseIntArray0.get(((int)(((Integer)list1.get(0)))), -1);
            }
        }
        for(Object object0: list1) {
            MediaQueue mediaQueue0 = this.zza;
            int v2 = mediaQueue0.zzc.get(((int)(((Integer)object0))), -1);
            if(v2 == -1) {
                mediaQueue0.zzo();
                return;
            }
            arrayList0.add(v2);
        }
        this.zza.zzx();
        this.zza.zzb = list0;
        MediaQueue.zzk(this.zza);
        MediaQueue.zzg(this.zza, arrayList0, v1);
        this.zza.zzu();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zzg(int[] arr_v) {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_v.length; v = a.d(v2, v, 1, arrayList0)) {
            int v1 = arr_v[v];
            MediaQueue mediaQueue0 = this.zza;
            mediaQueue0.zzd.remove(v1);
            int v2 = mediaQueue0.zzc.get(v1, -1);
            if(v2 == -1) {
                mediaQueue0.zzo();
                return;
            }
        }
        Collections.sort(arrayList0);
        this.zza.zzx();
        int[] arr_v1 = CastUtils.zzf(arrayList0);
        this.zza.zzw(arr_v1);
        this.zza.zzu();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zzh() {
        this.zza.zzo();
    }
}

