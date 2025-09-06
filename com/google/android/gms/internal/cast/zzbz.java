package com.google.android.gms.internal.cast;

public final class zzbz {
    private final String zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final long zze;
    private long zzf;

    public zzbz(zzby zzby0) {
        this.zza = zzby0.zza;
        this.zzb = zzby0.zzb;
        this.zzc = zzby0.zzc;
        this.zzd = zzby0.zzd;
        this.zze = zzby0.zze;
    }

    public final zzqg zza() {
        zzqf zzqf0 = zzqg.zza();
        int v = 11;
        switch(this.zza) {
            case "activeTracks": {
                break;
            }
            case "launch": {
                v = 22;
                break;
            }
            case "load": {
                v = 2;
                break;
            }
            case "mute": {
                v = 8;
                break;
            }
            case "pause": {
                v = 4;
                break;
            }
            case "play": {
                v = 3;
                break;
            }
            case "queueFetchItemIds": {
                v = 17;
                break;
            }
            case "queueFetchItemRange": {
                v = 18;
                break;
            }
            case "queueFetchItems": {
                v = 19;
                break;
            }
            case "queueInsert": {
                v = 13;
                break;
            }
            case "queueRemove": {
                v = 15;
                break;
            }
            case "queueReorder": {
                v = 16;
                break;
            }
            case "queueUpdate": {
                v = 14;
                break;
            }
            case "seek": {
                v = 6;
                break;
            }
            case "setPlaybackDevices": {
                v = 23;
                break;
            }
            case "setPlaybackRate": {
                v = 20;
                break;
            }
            case "skipAd": {
                v = 21;
                break;
            }
            case "status": {
                v = 10;
                break;
            }
            case "stop": {
                v = 5;
                break;
            }
            case "trackStyle": {
                v = 12;
                break;
            }
            case "volume": {
                v = 7;
                break;
            }
            case "volume-mute": {
                v = 9;
                break;
            }
            default: {
                v = 1;
            }
        }
        zzqf0.zze(v);
        zzqf0.zzb(((int)this.zzb));
        zzqf0.zzd(this.zzc);
        zzqf0.zzc(((int)(this.zzd - this.zzf)));
        zzqf0.zza(((int)(this.zze - this.zzf)));
        return (zzqg)zzqf0.zzr();
    }

    public final void zzb(long v) {
        this.zzf = v;
    }
}

