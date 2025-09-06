package com.google.android.gms.internal.play_billing;

import java.util.List;

final class zzbz implements zzfx {
    private final zzby zza;

    private zzbz(zzby zzby0) {
        this.zza = zzby0;
        zzby0.zza = this;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzA(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzdr) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzdr)list0).size(); ++v2) {
                    ((zzdr)list0).zze(v2);
                    v3 += 8;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzdr)list0).size()) {
                    long v4 = ((zzdr)list0).zze(v1);
                    this.zza.zzi(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzdr)list0).size()) {
                long v5 = ((zzdr)list0).zze(v1);
                this.zza.zzh(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Long)list0.get(v6)).getClass();
                v7 += 8;
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                long v8 = (long)(((Long)list0.get(v1)));
                this.zza.zzi(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v9 = (long)(((Long)list0.get(v1)));
            this.zza.zzh(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzB(int v, int v1) {
        this.zza.zzp(v, v1 >> 0x1F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzC(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzct) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzct)list0).size(); ++v2) {
                    int v4 = ((zzct)list0).zze(v2);
                    v3 += zzby.zzw(v4 >> 0x1F ^ v4 + v4);
                }
                this.zza.zzq(v3);
                while(v1 < ((zzct)list0).size()) {
                    int v5 = ((zzct)list0).zze(v1);
                    this.zza.zzq(v5 >> 0x1F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzct)list0).size()) {
                int v6 = ((zzct)list0).zze(v1);
                this.zza.zzp(v, v6 >> 0x1F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                int v9 = (int)(((Integer)list0.get(v7)));
                v8 += zzby.zzw(v9 >> 0x1F ^ v9 + v9);
            }
            this.zza.zzq(v8);
            while(v1 < list0.size()) {
                int v10 = (int)(((Integer)list0.get(v1)));
                this.zza.zzq(v10 >> 0x1F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v11 = (int)(((Integer)list0.get(v1)));
            this.zza.zzp(v, v11 >> 0x1F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzD(int v, long v1) {
        this.zza.zzr(v, v1 >> 0x3F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzE(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzdr) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzdr)list0).size(); ++v2) {
                    long v4 = ((zzdr)list0).zze(v2);
                    v3 += zzby.zzx(v4 >> 0x3F ^ v4 + v4);
                }
                this.zza.zzq(v3);
                while(v1 < ((zzdr)list0).size()) {
                    long v5 = ((zzdr)list0).zze(v1);
                    this.zza.zzs(v5 >> 0x3F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzdr)list0).size()) {
                long v6 = ((zzdr)list0).zze(v1);
                this.zza.zzr(v, v6 >> 0x3F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                long v9 = (long)(((Long)list0.get(v7)));
                v8 += zzby.zzx(v9 >> 0x3F ^ v9 + v9);
            }
            this.zza.zzq(v8);
            while(v1 < list0.size()) {
                long v10 = (long)(((Long)list0.get(v1)));
                this.zza.zzs(v10 >> 0x3F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v11 = (long)(((Long)list0.get(v1)));
            this.zza.zzr(v, v11 >> 0x3F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    @Deprecated
    public final void zzF(int v) {
        this.zza.zzo(v, 3);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzG(int v, String s) {
        this.zza.zzm(v, s);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzH(int v, List list0) {
        int v1 = 0;
        if(list0 instanceof zzdk) {
            while(v1 < list0.size()) {
                Object object0 = ((zzdk)list0).zzf(v1);
                if(object0 instanceof String) {
                    this.zza.zzm(v, ((String)object0));
                }
                else {
                    this.zza.zze(v, ((zzbq)object0));
                }
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            String s = (String)list0.get(v1);
            this.zza.zzm(v, s);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzI(int v, int v1) {
        this.zza.zzp(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzJ(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzct) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzct)list0).size(); ++v2) {
                    v3 += zzby.zzw(((zzct)list0).zze(v2));
                }
                this.zza.zzq(v3);
                while(v1 < ((zzct)list0).size()) {
                    int v4 = ((zzct)list0).zze(v1);
                    this.zza.zzq(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzct)list0).size()) {
                int v5 = ((zzct)list0).zze(v1);
                this.zza.zzp(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += zzby.zzw(((int)(((Integer)list0.get(v6)))));
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.zza.zzq(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.zza.zzp(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzK(int v, long v1) {
        this.zza.zzr(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzL(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzdr) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzdr)list0).size(); ++v2) {
                    v3 += zzby.zzx(((zzdr)list0).zze(v2));
                }
                this.zza.zzq(v3);
                while(v1 < ((zzdr)list0).size()) {
                    long v4 = ((zzdr)list0).zze(v1);
                    this.zza.zzs(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzdr)list0).size()) {
                long v5 = ((zzdr)list0).zze(v1);
                this.zza.zzr(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += zzby.zzx(((long)(((Long)list0.get(v6)))));
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                long v8 = (long)(((Long)list0.get(v1)));
                this.zza.zzs(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v9 = (long)(((Long)list0.get(v1)));
            this.zza.zzr(v, v9);
            ++v1;
        }
    }

    public static zzbz zza(zzby zzby0) {
        zzbz zzbz0 = zzby0.zza;
        return zzbz0 == null ? new zzbz(zzby0) : zzbz0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzb(int v, boolean z) {
        this.zza.zzd(v, z);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzc(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzbe) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzbe)list0).size(); ++v2) {
                    ((zzbe)list0).zzf(v2);
                    ++v3;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzbe)list0).size()) {
                    boolean z1 = ((zzbe)list0).zzf(v1);
                    this.zza.zzb(((byte)z1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzbe)list0).size()) {
                boolean z2 = ((zzbe)list0).zzf(v1);
                this.zza.zzd(v, z2);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v5 = 0;
            for(int v4 = 0; v4 < list0.size(); ++v4) {
                ((Boolean)list0.get(v4)).getClass();
                ++v5;
            }
            this.zza.zzq(v5);
            while(v1 < list0.size()) {
                boolean z3 = ((Boolean)list0.get(v1)).booleanValue();
                this.zza.zzb(((byte)z3));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            boolean z4 = ((Boolean)list0.get(v1)).booleanValue();
            this.zza.zzd(v, z4);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzd(int v, zzbq zzbq0) {
        this.zza.zze(v, zzbq0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zze(int v, List list0) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            zzbq zzbq0 = (zzbq)list0.get(v1);
            this.zza.zze(v, zzbq0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzf(int v, double f) {
        this.zza.zzh(v, Double.doubleToRawLongBits(f));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzg(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzca) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzca)list0).size(); ++v2) {
                    ((zzca)list0).zze(v2);
                    v3 += 8;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzca)list0).size()) {
                    long v4 = Double.doubleToRawLongBits(((zzca)list0).zze(v1));
                    this.zza.zzi(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzca)list0).size()) {
                long v5 = Double.doubleToRawLongBits(((zzca)list0).zze(v1));
                this.zza.zzh(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Double)list0.get(v6)).getClass();
                v7 += 8;
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                long v8 = Double.doubleToRawLongBits(((double)(((Double)list0.get(v1)))));
                this.zza.zzi(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v9 = Double.doubleToRawLongBits(((double)(((Double)list0.get(v1)))));
            this.zza.zzh(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    @Deprecated
    public final void zzh(int v) {
        this.zza.zzo(v, 4);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzi(int v, int v1) {
        this.zza.zzj(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzj(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzct) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzct)list0).size(); ++v2) {
                    v3 += zzby.zzx(((zzct)list0).zze(v2));
                }
                this.zza.zzq(v3);
                while(v1 < ((zzct)list0).size()) {
                    int v4 = ((zzct)list0).zze(v1);
                    this.zza.zzk(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzct)list0).size()) {
                int v5 = ((zzct)list0).zze(v1);
                this.zza.zzj(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += zzby.zzx(((int)(((Integer)list0.get(v6)))));
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.zza.zzk(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.zza.zzj(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzk(int v, int v1) {
        this.zza.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzl(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzct) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzct)list0).size(); ++v2) {
                    ((zzct)list0).zze(v2);
                    v3 += 4;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzct)list0).size()) {
                    int v4 = ((zzct)list0).zze(v1);
                    this.zza.zzg(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzct)list0).size()) {
                int v5 = ((zzct)list0).zze(v1);
                this.zza.zzf(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Integer)list0.get(v6)).getClass();
                v7 += 4;
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.zza.zzg(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.zza.zzf(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzm(int v, long v1) {
        this.zza.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzn(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzdr) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzdr)list0).size(); ++v2) {
                    ((zzdr)list0).zze(v2);
                    v3 += 8;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzdr)list0).size()) {
                    long v4 = ((zzdr)list0).zze(v1);
                    this.zza.zzi(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzdr)list0).size()) {
                long v5 = ((zzdr)list0).zze(v1);
                this.zza.zzh(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Long)list0.get(v6)).getClass();
                v7 += 8;
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                long v8 = (long)(((Long)list0.get(v1)));
                this.zza.zzi(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v9 = (long)(((Long)list0.get(v1)));
            this.zza.zzh(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzo(int v, float f) {
        this.zza.zzf(v, Float.floatToRawIntBits(f));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzp(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzck) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzck)list0).size(); ++v2) {
                    ((zzck)list0).zze(v2);
                    v3 += 4;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzck)list0).size()) {
                    int v4 = Float.floatToRawIntBits(((zzck)list0).zze(v1));
                    this.zza.zzg(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzck)list0).size()) {
                int v5 = Float.floatToRawIntBits(((zzck)list0).zze(v1));
                this.zza.zzf(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Float)list0.get(v6)).getClass();
                v7 += 4;
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                int v8 = Float.floatToRawIntBits(((float)(((Float)list0.get(v1)))));
                this.zza.zzg(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = Float.floatToRawIntBits(((float)(((Float)list0.get(v1)))));
            this.zza.zzf(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzq(int v, Object object0, zzeo zzeo0) {
        this.zza.zzo(v, 3);
        zzeo0.zzi(((zzec)object0), this.zza.zza);
        this.zza.zzo(v, 4);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzr(int v, int v1) {
        this.zza.zzj(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzs(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzct) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzct)list0).size(); ++v2) {
                    v3 += zzby.zzx(((zzct)list0).zze(v2));
                }
                this.zza.zzq(v3);
                while(v1 < ((zzct)list0).size()) {
                    int v4 = ((zzct)list0).zze(v1);
                    this.zza.zzk(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzct)list0).size()) {
                int v5 = ((zzct)list0).zze(v1);
                this.zza.zzj(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += zzby.zzx(((int)(((Integer)list0.get(v6)))));
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.zza.zzk(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.zza.zzj(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzt(int v, long v1) {
        this.zza.zzr(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzu(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzdr) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzdr)list0).size(); ++v2) {
                    v3 += zzby.zzx(((zzdr)list0).zze(v2));
                }
                this.zza.zzq(v3);
                while(v1 < ((zzdr)list0).size()) {
                    long v4 = ((zzdr)list0).zze(v1);
                    this.zza.zzs(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzdr)list0).size()) {
                long v5 = ((zzdr)list0).zze(v1);
                this.zza.zzr(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                v7 += zzby.zzx(((long)(((Long)list0.get(v6)))));
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                long v8 = (long)(((Long)list0.get(v1)));
                this.zza.zzs(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v9 = (long)(((Long)list0.get(v1)));
            this.zza.zzr(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzv(int v, Object object0, zzeo zzeo0) {
        ((zzbv)this.zza).zzq(v << 3 | 2);
        int v1 = ((zzay)(((zzec)object0))).zza(zzeo0);
        ((zzbv)this.zza).zzq(v1);
        zzeo0.zzi(((zzec)object0), ((zzbv)this.zza).zza);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzw(int v, Object object0) {
        if(object0 instanceof zzbq) {
            ((zzbv)this.zza).zzq(11);
            ((zzbv)this.zza).zzp(2, v);
            ((zzbv)this.zza).zze(3, ((zzbq)object0));
            ((zzbv)this.zza).zzq(12);
            return;
        }
        ((zzbv)this.zza).zzq(11);
        ((zzbv)this.zza).zzp(2, v);
        ((zzbv)this.zza).zzq(26);
        int v1 = ((zzec)object0).zzf();
        ((zzbv)this.zza).zzq(v1);
        ((zzec)object0).zze(this.zza);
        ((zzbv)this.zza).zzq(12);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzx(int v, int v1) {
        this.zza.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzy(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzct) {
            if(z) {
                this.zza.zzo(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzct)list0).size(); ++v2) {
                    ((zzct)list0).zze(v2);
                    v3 += 4;
                }
                this.zza.zzq(v3);
                while(v1 < ((zzct)list0).size()) {
                    int v4 = ((zzct)list0).zze(v1);
                    this.zza.zzg(v4);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzct)list0).size()) {
                int v5 = ((zzct)list0).zze(v1);
                this.zza.zzf(v, v5);
                ++v1;
            }
            return;
        }
        if(z) {
            this.zza.zzo(v, 2);
            int v7 = 0;
            for(int v6 = 0; v6 < list0.size(); ++v6) {
                ((Integer)list0.get(v6)).getClass();
                v7 += 4;
            }
            this.zza.zzq(v7);
            while(v1 < list0.size()) {
                int v8 = (int)(((Integer)list0.get(v1)));
                this.zza.zzg(v8);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v9 = (int)(((Integer)list0.get(v1)));
            this.zza.zzf(v, v9);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfx
    public final void zzz(int v, long v1) {
        this.zza.zzh(v, v1);
    }
}

