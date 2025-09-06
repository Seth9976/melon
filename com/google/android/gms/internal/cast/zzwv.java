package com.google.android.gms.internal.cast;

import java.util.List;

final class zzwv implements zzzt {
    private final zzwu zza;

    private zzwv(zzwu zzwu0) {
        this.zza = zzwu0;
        zzwu0.zza = this;
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzA(int v, int v1) {
        this.zza.zzs(v, v1 >> 0x1F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzB(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxj) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxj)list0).size(); ++v2) {
                    int v4 = ((zzxj)list0).zze(v2);
                    v3 += zzwu.zzz(v4 >> 0x1F ^ v4 + v4);
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxj)list0).size()) {
                    int v5 = ((zzxj)list0).zze(v1);
                    zzwu0.zzt(v5 >> 0x1F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxj)list0).size()) {
                int v6 = ((zzxj)list0).zze(v1);
                this.zza.zzs(v, v6 >> 0x1F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                int v9 = (int)(((Integer)list0.get(v7)));
                v8 += zzwu.zzz(v9 >> 0x1F ^ v9 + v9);
            }
            zzwu1.zzt(v8);
            while(v1 < list0.size()) {
                int v10 = (int)(((Integer)list0.get(v1)));
                zzwu1.zzt(v10 >> 0x1F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v11 = (int)(((Integer)list0.get(v1)));
            this.zza.zzs(v, v11 >> 0x1F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzC(int v, long v1) {
        this.zza.zzu(v, v1 >> 0x3F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzD(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzya) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzya)list0).size(); ++v2) {
                    long v4 = ((zzya)list0).zze(v2);
                    v3 += zzwu.zzA(v4 >> 0x3F ^ v4 + v4);
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzya)list0).size()) {
                    long v5 = ((zzya)list0).zze(v1);
                    zzwu0.zzv(v5 >> 0x3F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzya)list0).size()) {
                long v6 = ((zzya)list0).zze(v1);
                this.zza.zzu(v, v6 >> 0x3F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                long v9 = (long)(((Long)list0.get(v7)));
                v8 += zzwu.zzA(v9 >> 0x3F ^ v9 + v9);
            }
            zzwu1.zzt(v8);
            while(v1 < list0.size()) {
                long v10 = (long)(((Long)list0.get(v1)));
                zzwu1.zzv(v10 >> 0x3F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v11 = (long)(((Long)list0.get(v1)));
            this.zza.zzu(v, v11 >> 0x3F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzE(int v, String s) {
        this.zza.zzp(v, s);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzF(int v, List list0) {
        int v1 = 0;
        if(list0 instanceof zzxx) {
            while(v1 < list0.size()) {
                Object object0 = ((zzxx)list0).zza();
                if(object0 instanceof String) {
                    this.zza.zzp(v, ((String)object0));
                }
                else {
                    this.zza.zze(v, ((zzwn)object0));
                }
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            String s = (String)list0.get(v1);
            this.zza.zzp(v, s);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzG(int v, int v1) {
        this.zza.zzs(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzH(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxj) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxj)list0).size(); ++v2) {
                    v3 += zzwu.zzz(((zzxj)list0).zze(v2));
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxj)list0).size()) {
                    zzwu0.zzt(((zzxj)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxj)list0).size()) {
                int v4 = ((zzxj)list0).zze(v1);
                this.zza.zzs(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzwu.zzz(((int)(((Integer)list0.get(v5)))));
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzt(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzs(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzI(int v, long v1) {
        this.zza.zzu(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzJ(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzya) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzya)list0).size(); ++v2) {
                    v3 += zzwu.zzA(((zzya)list0).zze(v2));
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzya)list0).size()) {
                    zzwu0.zzv(((zzya)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzya)list0).size()) {
                long v4 = ((zzya)list0).zze(v1);
                this.zza.zzu(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzwu.zzA(((long)(((Long)list0.get(v5)))));
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzv(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zzu(v, v7);
            ++v1;
        }
    }

    public static zzwv zza(zzwu zzwu0) {
        zzwv zzwv0 = zzwu0.zza;
        return zzwv0 == null ? new zzwv(zzwu0) : zzwv0;
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzb(int v, boolean z) {
        this.zza.zzd(v, z);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzc(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzwe) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzwe)list0).size(); ++v2) {
                    ((zzwe)list0).zze(v2);
                    ++v3;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzwe)list0).size()) {
                    zzwu0.zzb(((byte)((zzwe)list0).zze(v1)));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzwe)list0).size()) {
                boolean z1 = ((zzwe)list0).zze(v1);
                this.zza.zzd(v, z1);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v5 = 0;
            for(int v4 = 0; v4 < list0.size(); ++v4) {
                ((Boolean)list0.get(v4)).getClass();
                ++v5;
            }
            zzwu1.zzt(v5);
            while(v1 < list0.size()) {
                zzwu1.zzb(((byte)((Boolean)list0.get(v1)).booleanValue()));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            boolean z2 = ((Boolean)list0.get(v1)).booleanValue();
            this.zza.zzd(v, z2);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzd(int v, zzwn zzwn0) {
        this.zza.zze(v, zzwn0);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zze(int v, List list0) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            zzwn zzwn0 = (zzwn)list0.get(v1);
            this.zza.zze(v, zzwn0);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzf(int v, double f) {
        this.zza.zzh(v, Double.doubleToRawLongBits(f));
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzg(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzww) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzww)list0).size(); ++v2) {
                    ((zzww)list0).zze(v2);
                    v3 += 8;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzww)list0).size()) {
                    zzwu0.zzi(Double.doubleToRawLongBits(((zzww)list0).zze(v1)));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzww)list0).size()) {
                long v4 = Double.doubleToRawLongBits(((zzww)list0).zze(v1));
                this.zza.zzh(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Double)list0.get(v5)).getClass();
                v6 += 8;
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzi(Double.doubleToRawLongBits(((double)(((Double)list0.get(v1))))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = Double.doubleToRawLongBits(((double)(((Double)list0.get(v1)))));
            this.zza.zzh(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzh(int v, int v1) {
        this.zza.zzj(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzi(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxj) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxj)list0).size(); ++v2) {
                    v3 += zzwu.zzA(((zzxj)list0).zze(v2));
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxj)list0).size()) {
                    zzwu0.zzk(((zzxj)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxj)list0).size()) {
                int v4 = ((zzxj)list0).zze(v1);
                this.zza.zzj(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzwu.zzA(((int)(((Integer)list0.get(v5)))));
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzk(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzj(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzj(int v, int v1) {
        this.zza.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzk(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxj) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxj)list0).size(); ++v2) {
                    ((zzxj)list0).zze(v2);
                    v3 += 4;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxj)list0).size()) {
                    zzwu0.zzg(((zzxj)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxj)list0).size()) {
                int v4 = ((zzxj)list0).zze(v1);
                this.zza.zzf(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Integer)list0.get(v5)).getClass();
                v6 += 4;
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzg(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzf(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzl(int v, long v1) {
        this.zza.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzm(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzya) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzya)list0).size(); ++v2) {
                    ((zzya)list0).zze(v2);
                    v3 += 8;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzya)list0).size()) {
                    zzwu0.zzi(((zzya)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzya)list0).size()) {
                long v4 = ((zzya)list0).zze(v1);
                this.zza.zzh(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Long)list0.get(v5)).getClass();
                v6 += 8;
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzi(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zzh(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzn(int v, float f) {
        this.zza.zzf(v, Float.floatToRawIntBits(f));
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzo(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxd) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxd)list0).size(); ++v2) {
                    ((zzxd)list0).zze(v2);
                    v3 += 4;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxd)list0).size()) {
                    zzwu0.zzg(Float.floatToRawIntBits(((zzxd)list0).zze(v1)));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxd)list0).size()) {
                int v4 = Float.floatToRawIntBits(((zzxd)list0).zze(v1));
                this.zza.zzf(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Float)list0.get(v5)).getClass();
                v6 += 4;
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzg(Float.floatToRawIntBits(((float)(((Float)list0.get(v1))))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = Float.floatToRawIntBits(((float)(((Float)list0.get(v1)))));
            this.zza.zzf(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzp(int v, Object object0, zzyv zzyv0) {
        this.zza.zzr(v, 3);
        zzyv0.zzf(((zzyl)object0), this.zza.zza);
        this.zza.zzr(v, 4);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzq(int v, int v1) {
        this.zza.zzj(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzr(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxj) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxj)list0).size(); ++v2) {
                    v3 += zzwu.zzA(((zzxj)list0).zze(v2));
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxj)list0).size()) {
                    zzwu0.zzk(((zzxj)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxj)list0).size()) {
                int v4 = ((zzxj)list0).zze(v1);
                this.zza.zzj(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzwu.zzA(((int)(((Integer)list0.get(v5)))));
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzk(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzj(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzs(int v, long v1) {
        this.zza.zzu(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzt(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzya) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzya)list0).size(); ++v2) {
                    v3 += zzwu.zzA(((zzya)list0).zze(v2));
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzya)list0).size()) {
                    zzwu0.zzv(((zzya)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzya)list0).size()) {
                long v4 = ((zzya)list0).zze(v1);
                this.zza.zzu(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzwu.zzA(((long)(((Long)list0.get(v5)))));
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzv(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zzu(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzu(int v, Object object0, zzyv zzyv0) {
        this.zza.zzm(v, ((zzyl)object0), zzyv0);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzv(int v, Object object0) {
        if(object0 instanceof zzwn) {
            this.zza.zzo(v, ((zzwn)object0));
            return;
        }
        this.zza.zzn(v, ((zzyl)object0));
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzw(int v, int v1) {
        this.zza.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzx(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzxj) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzxj)list0).size(); ++v2) {
                    ((zzxj)list0).zze(v2);
                    v3 += 4;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzxj)list0).size()) {
                    zzwu0.zzg(((zzxj)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzxj)list0).size()) {
                int v4 = ((zzxj)list0).zze(v1);
                this.zza.zzf(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Integer)list0.get(v5)).getClass();
                v6 += 4;
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzg(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzf(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzy(int v, long v1) {
        this.zza.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzzt
    public final void zzz(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzya) {
            if(z) {
                zzwu zzwu0 = this.zza;
                zzwu0.zzr(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzya)list0).size(); ++v2) {
                    ((zzya)list0).zze(v2);
                    v3 += 8;
                }
                zzwu0.zzt(v3);
                while(v1 < ((zzya)list0).size()) {
                    zzwu0.zzi(((zzya)list0).zze(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzya)list0).size()) {
                long v4 = ((zzya)list0).zze(v1);
                this.zza.zzh(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzwu zzwu1 = this.zza;
            zzwu1.zzr(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Long)list0.get(v5)).getClass();
                v6 += 8;
            }
            zzwu1.zzt(v6);
            while(v1 < list0.size()) {
                zzwu1.zzi(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zzh(v, v7);
            ++v1;
        }
    }
}

