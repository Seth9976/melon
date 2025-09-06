package com.google.android.gms.internal.measurement;

final class zzlj extends zzll {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzlj(byte[] arr_b, int v, int v1) {
        super(null);
        if((arr_b.length - v1 | v1) < 0) {
            throw new IllegalArgumentException("Array range is invalid. Buffer.length=" + arr_b.length + ", offset=0, length=" + v1);
        }
        this.zzc = arr_b;
        this.zze = 0;
        this.zzd = v1;
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zza(int v, int v1) {
        this.zzr(v << 3 | v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzb(int v, int v1) {
        this.zzr(v << 3);
        this.zzq(v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzc(int v, int v1) {
        this.zzr(v << 3);
        this.zzr(v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzd(int v, int v1) {
        this.zzr(v << 3 | 5);
        this.zzs(v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zze(int v, long v1) {
        this.zzr(v << 3);
        this.zzt(v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzf(int v, long v1) {
        this.zzr(v << 3 | 1);
        this.zzu(v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzg(int v, boolean z) {
        this.zzr(v << 3);
        this.zzp(((byte)z));
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzh(int v, String s) {
        this.zzr(v << 3 | 2);
        this.zzx(s);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzi(int v, zzlg zzlg0) {
        this.zzr(v << 3 | 2);
        this.zzj(zzlg0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzj(zzlg zzlg0) {
        this.zzr(zzlg0.zzc());
        zzlg0.zzf(this);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzk(byte[] arr_b, int v, int v1) {
        this.zzr(v1);
        this.zzv(arr_b, 0, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzl(int v, zznl zznl0, zznw zznw0) {
        this.zzr(v << 3 | 2);
        this.zzr(((zzkr)zznl0).zzcd(zznw0));
        zznw0.zzf(zznl0, this.zza);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzm(int v, zznl zznl0) {
        this.zzr(11);
        this.zzc(2, v);
        this.zzr(26);
        this.zzo(zznl0);
        this.zzr(12);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzn(int v, zzlg zzlg0) {
        this.zzr(11);
        this.zzc(2, v);
        this.zzi(3, zzlg0);
        this.zzr(12);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzo(zznl zznl0) {
        this.zzr(zznl0.zzcn());
        zznl0.zzcB(this);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzp(byte b) {
        int v;
        try {
            v = this.zze;
            this.zzc[v] = b;
            this.zze = v + 1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzlk(((long)(v + 1)), ((long)this.zzd), 1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzq(int v) {
        if(v >= 0) {
            this.zzr(v);
            return;
        }
        this.zzt(((long)v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzr(int v) {
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
            throw new zzlk(((long)v2), ((long)this.zzd), 1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzs(int v) {
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
            throw new zzlk(((long)v1), ((long)this.zzd), 4, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzt(long v) {
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
        throw new zzlk(((long)v2), ((long)this.zzd), 1, indexOutOfBoundsException1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzu(long v) {
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
            throw new zzlk(((long)v1), ((long)this.zzd), 8, indexOutOfBoundsException0);
        }
    }

    public final void zzv(byte[] arr_b, int v, int v1) {
        try {
            System.arraycopy(arr_b, 0, this.zzc, this.zze, v1);
            this.zze += v1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzlk(((long)this.zze), ((long)this.zzd), v1, indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzw(byte[] arr_b, int v, int v1) {
        this.zzv(arr_b, 0, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final void zzx(String s) {
        int v;
        try {
            v = this.zze;
            int v1 = zzll.zzz(s.length());
            if(v1 == zzll.zzz(s.length() * 3)) {
                int v2 = v + v1;
                this.zze = v2;
                int v3 = zzor.zzc(s, this.zzc, v2, this.zzd - v2);
                this.zze = v;
                this.zzr(v3 - v - v1);
                this.zze = v3;
                return;
            }
            this.zzr(zzor.zzb(s));
            this.zze = zzor.zzc(s, this.zzc, this.zze, this.zzd - this.zze);
            return;
        }
        catch(zzoq zzoq0) {
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzlk(indexOutOfBoundsException0);
        }
        this.zze = v;
        this.zzF(s, zzoq0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzll
    public final int zzy() {
        return this.zzd - this.zze;
    }
}

