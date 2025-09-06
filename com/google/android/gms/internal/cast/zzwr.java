package com.google.android.gms.internal.cast;

final class zzwr extends zzwu {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzwr(byte[] arr_b, int v, int v1) {
        super(null);
        if((arr_b.length - v1 | v1) < 0) {
            throw new IllegalArgumentException("Array range is invalid. Buffer.length=" + arr_b.length + ", offset=0, length=" + v1);
        }
        this.zzc = arr_b;
        this.zze = 0;
        this.zzd = v1;
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzb(byte b) {
        int v;
        try {
            v = this.zze;
            this.zzc[v] = b;
            this.zze = v + 1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(((long)(v + 1)), ((long)this.zzd), 1, indexOutOfBoundsException0);
        }
    }

    public final void zzc(byte[] arr_b, int v, int v1) {
        try {
            System.arraycopy(arr_b, 0, this.zzc, this.zze, v1);
            this.zze += v1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(((long)this.zze), ((long)this.zzd), v1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzd(int v, boolean z) {
        this.zzt(v << 3);
        this.zzb(((byte)z));
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zze(int v, zzwn zzwn0) {
        this.zzt(v << 3 | 2);
        this.zzt(zzwn0.zzd());
        zzwn0.zzg(this);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzf(int v, int v1) {
        this.zzt(v << 3 | 5);
        this.zzg(v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzg(int v) {
        int v1;
        try {
            v1 = this.zze;
            this.zzc[v1] = (byte)v;
            this.zzc[v1 + 1] = (byte)(v >> 8);
            this.zzc[v1 + 2] = (byte)(v >> 16);
            this.zzc[v1 + 3] = (byte)(v >> 24);
            this.zze = v1 + 4;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(((long)v1), ((long)this.zzd), 4, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzh(int v, long v1) {
        this.zzt(v << 3 | 1);
        this.zzi(v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzi(long v) {
        int v1;
        try {
            v1 = this.zze;
            this.zzc[v1] = (byte)(((int)v));
            this.zzc[v1 + 1] = (byte)(((int)(v >> 8)));
            this.zzc[v1 + 2] = (byte)(((int)(v >> 16)));
            this.zzc[v1 + 3] = (byte)(((int)(v >> 24)));
            this.zzc[v1 + 4] = (byte)(((int)(v >> 0x20)));
            this.zzc[v1 + 5] = (byte)(((int)(v >> 40)));
            this.zzc[v1 + 6] = (byte)(((int)(v >> 0x30)));
            this.zzc[v1 + 7] = (byte)(((int)(v >> 56)));
            this.zze = v1 + 8;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(((long)v1), ((long)this.zzd), 8, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzj(int v, int v1) {
        this.zzt(v << 3);
        this.zzk(v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzk(int v) {
        if(v >= 0) {
            this.zzt(v);
            return;
        }
        this.zzv(((long)v));
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzl(byte[] arr_b, int v, int v1) {
        this.zzc(arr_b, 0, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzm(int v, zzyl zzyl0, zzyv zzyv0) {
        this.zzt(v << 3 | 2);
        this.zzt(((zzwa)zzyl0).zzr(zzyv0));
        zzyv0.zzf(zzyl0, this.zza);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzn(int v, zzyl zzyl0) {
        this.zzt(11);
        this.zzs(2, v);
        this.zzt(26);
        this.zzt(zzyl0.zzw());
        zzyl0.zzO(this);
        this.zzt(12);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzo(int v, zzwn zzwn0) {
        this.zzt(11);
        this.zzs(2, v);
        this.zze(3, zzwn0);
        this.zzt(12);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzp(int v, String s) {
        this.zzt(v << 3 | 2);
        this.zzq(s);
    }

    public final void zzq(String s) {
        int v;
        try {
            v = this.zze;
            int v1 = zzwu.zzz(s.length());
            if(v1 == zzwu.zzz(s.length() * 3)) {
                int v2 = v + v1;
                this.zze = v2;
                int v3 = zzzq.zza(s, this.zzc, v2, this.zzd - v2);
                this.zze = v;
                this.zzt(v3 - v - v1);
                this.zze = v3;
                return;
            }
            this.zzt(zzzq.zzb(s));
            this.zze = zzzq.zza(s, this.zzc, this.zze, this.zzd - this.zze);
            return;
        }
        catch(zzzp zzzp0) {
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(indexOutOfBoundsException0);
        }
        this.zze = v;
        this.zzC(s, zzzp0);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzr(int v, int v1) {
        this.zzt(v << 3 | v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzs(int v, int v1) {
        this.zzt(v << 3);
        this.zzt(v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzt(int v) {
        int v2;
        int v1 = this.zze;
        try {
            while(true) {
                if((v & 0xFFFFFF80) == 0) {
                    v2 = v1 + 1;
                    this.zzc[v1] = (byte)v;
                    this.zze = v2;
                    return;
                }
                v2 = v1 + 1;
                this.zzc[v1] = (byte)(v | 0x80);
                v >>>= 7;
                v1 = v2;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(((long)v2), ((long)this.zzd), 1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzu(int v, long v1) {
        this.zzt(v << 3);
        this.zzv(v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzwu
    public final void zzv(long v) {
        int v2;
        IndexOutOfBoundsException indexOutOfBoundsException1;
        for(int v1 = this.zze; true; ++v1) {
            if((v & 0xFFFFFFFFFFFFFF80L) == 0L) {
                try {
                    this.zzc[v1] = (byte)(((int)v));
                    this.zze = v1 + 1;
                    return;
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                    indexOutOfBoundsException1 = indexOutOfBoundsException0;
                    v2 = v1 + 1;
                    break;
                }
            }
            try {
                this.zzc[v1] = (byte)(((int)v) | 0x80);
                v >>>= 7;
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException2) {
                indexOutOfBoundsException1 = indexOutOfBoundsException2;
                v2 = v1 + 1;
                break;
            }
        }
        throw new zzws(((long)v2), ((long)this.zzd), 1, indexOutOfBoundsException1);
    }
}

