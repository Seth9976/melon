package com.google.android.gms.internal.play_billing;

final class zzbv extends zzby {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzbv(byte[] arr_b, int v, int v1) {
        super(null);
        if((arr_b.length - v1 | v1) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", ((int)arr_b.length), 0, v1));
        }
        this.zzb = arr_b;
        this.zzd = 0;
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzb(byte b) {
        try {
            int v = this.zzd;
            this.zzd = v + 1;
            this.zzb[v] = b;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    public final void zzc(byte[] arr_b, int v, int v1) {
        try {
            System.arraycopy(arr_b, 0, this.zzb, this.zzd, v1);
            this.zzd += v1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, v1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzd(int v, boolean z) {
        this.zzq(v << 3);
        this.zzb(((byte)z));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zze(int v, zzbq zzbq0) {
        this.zzq(v << 3 | 2);
        this.zzq(zzbq0.zzd());
        zzbq0.zzh(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzf(int v, int v1) {
        this.zzq(v << 3 | 5);
        this.zzg(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzg(int v) {
        try {
            int v1 = this.zzd;
            this.zzd = v1 + 1;
            this.zzb[v1] = (byte)(v & 0xFF);
            this.zzd = v1 + 2;
            this.zzb[v1 + 1] = (byte)(v >> 8 & 0xFF);
            this.zzd = v1 + 3;
            this.zzb[v1 + 2] = (byte)(v >> 16 & 0xFF);
            this.zzd = v1 + 4;
            this.zzb[v1 + 3] = (byte)(v >> 24 & 0xFF);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzh(int v, long v1) {
        this.zzq(v << 3 | 1);
        this.zzi(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzi(long v) {
        try {
            int v1 = this.zzd;
            this.zzd = v1 + 1;
            this.zzb[v1] = (byte)(((int)v) & 0xFF);
            this.zzd = v1 + 2;
            this.zzb[v1 + 1] = (byte)(((int)(v >> 8)) & 0xFF);
            this.zzd = v1 + 3;
            this.zzb[v1 + 2] = (byte)(((int)(v >> 16)) & 0xFF);
            this.zzd = v1 + 4;
            this.zzb[v1 + 3] = (byte)(((int)(v >> 24)) & 0xFF);
            this.zzd = v1 + 5;
            this.zzb[v1 + 4] = (byte)(((int)(v >> 0x20)) & 0xFF);
            this.zzd = v1 + 6;
            this.zzb[v1 + 5] = (byte)(((int)(v >> 40)) & 0xFF);
            this.zzd = v1 + 7;
            this.zzb[v1 + 6] = (byte)(((int)(v >> 0x30)) & 0xFF);
            this.zzd = v1 + 8;
            this.zzb[v1 + 7] = (byte)(((int)(v >> 56)) & 0xFF);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzj(int v, int v1) {
        this.zzq(v << 3);
        this.zzk(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzk(int v) {
        if(v >= 0) {
            this.zzq(v);
            return;
        }
        this.zzs(((long)v));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzl(byte[] arr_b, int v, int v1) {
        this.zzc(arr_b, 0, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzm(int v, String s) {
        this.zzq(v << 3 | 2);
        this.zzn(s);
    }

    public final void zzn(String s) {
        int v;
        try {
            v = this.zzd;
            int v1 = zzby.zzw(s.length());
            if(v1 == zzby.zzw(s.length() * 3)) {
                int v2 = v + v1;
                this.zzd = v2;
                int v3 = zzfu.zzb(s, this.zzb, v2, this.zzc - v2);
                this.zzd = v;
                this.zzq(v3 - v - v1);
                this.zzd = v3;
                return;
            }
            this.zzq(zzfu.zzc(s));
            this.zzd = zzfu.zzb(s, this.zzb, this.zzd, this.zzc - this.zzd);
            return;
        }
        catch(zzft zzft0) {
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzbw(indexOutOfBoundsException0);
        }
        this.zzd = v;
        this.zzA(s, zzft0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzo(int v, int v1) {
        this.zzq(v << 3 | v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzp(int v, int v1) {
        this.zzq(v << 3);
        this.zzq(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzq(int v) {
        try {
            while(true) {
                if((v & 0xFFFFFF80) == 0) {
                    int v1 = this.zzd;
                    this.zzd = v1 + 1;
                    this.zzb[v1] = (byte)v;
                    return;
                }
                int v2 = this.zzd;
                this.zzd = v2 + 1;
                this.zzb[v2] = (byte)((v | 0x80) & 0xFF);
                v >>>= 7;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
        }
        throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzr(int v, long v1) {
        this.zzq(v << 3);
        this.zzs(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzby
    public final void zzs(long v) {
        try {
            while(true) {
                if((v & 0xFFFFFFFFFFFFFF80L) == 0L) {
                    int v1 = this.zzd;
                    this.zzd = v1 + 1;
                    this.zzb[v1] = (byte)(((int)v));
                    return;
                }
                int v2 = this.zzd;
                this.zzd = v2 + 1;
                this.zzb[v2] = (byte)((((int)v) | 0x80) & 0xFF);
                v >>>= 7;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
        }
        throw new zzbw(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
    }
}

