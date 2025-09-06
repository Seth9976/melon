package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

final class zzlm implements zzou {
    private final zzll zza;

    private zzlm(zzll zzll0) {
        this.zza = zzll0;
        zzll0.zza = this;
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzA(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmz) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmz)list0).size(); ++v2) {
                    ((zzmz)list0).zzc(v2);
                    v3 += 8;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmz)list0).size()) {
                    zzll0.zzu(((zzmz)list0).zzc(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmz)list0).size()) {
                long v4 = ((zzmz)list0).zzc(v1);
                this.zza.zzf(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Long)list0.get(v5)).getClass();
                v6 += 8;
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzu(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zzf(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzB(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzlx) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzlx)list0).size(); ++v2) {
                    ((zzlx)list0).zze(v2);
                    v3 += 4;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzlx)list0).size()) {
                    zzll0.zzs(Float.floatToRawIntBits(((zzlx)list0).zze(v1)));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzlx)list0).size()) {
                int v4 = Float.floatToRawIntBits(((zzlx)list0).zze(v1));
                this.zza.zzd(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Float)list0.get(v5)).getClass();
                v6 += 4;
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzs(Float.floatToRawIntBits(((float)(((Float)list0.get(v1))))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = Float.floatToRawIntBits(((float)(((Float)list0.get(v1)))));
            this.zza.zzd(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzC(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzln) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzln)list0).size(); ++v2) {
                    ((zzln)list0).zze(v2);
                    v3 += 8;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzln)list0).size()) {
                    zzll0.zzu(Double.doubleToRawLongBits(((zzln)list0).zze(v1)));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzln)list0).size()) {
                long v4 = Double.doubleToRawLongBits(((zzln)list0).zze(v1));
                this.zza.zzf(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Double)list0.get(v5)).getClass();
                v6 += 8;
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzu(Double.doubleToRawLongBits(((double)(((Double)list0.get(v1))))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = Double.doubleToRawLongBits(((double)(((Double)list0.get(v1)))));
            this.zza.zzf(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzD(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmf) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmf)list0).size(); ++v2) {
                    v3 += zzll.zzA(((zzmf)list0).zzf(v2));
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmf)list0).size()) {
                    zzll0.zzq(((zzmf)list0).zzf(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmf)list0).size()) {
                int v4 = ((zzmf)list0).zzf(v1);
                this.zza.zzb(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzll.zzA(((int)(((Integer)list0.get(v5)))));
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzq(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzb(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzE(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzkx) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzkx)list0).size(); ++v2) {
                    ((zzkx)list0).zze(v2);
                    ++v3;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzkx)list0).size()) {
                    zzll0.zzp(((byte)((zzkx)list0).zze(v1)));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzkx)list0).size()) {
                boolean z1 = ((zzkx)list0).zze(v1);
                this.zza.zzg(v, z1);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v5 = 0;
            for(int v4 = 0; v4 < list0.size(); ++v4) {
                ((Boolean)list0.get(v4)).getClass();
                ++v5;
            }
            zzll1.zzr(v5);
            while(v1 < list0.size()) {
                zzll1.zzp(((byte)((Boolean)list0.get(v1)).booleanValue()));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            boolean z2 = ((Boolean)list0.get(v1)).booleanValue();
            this.zza.zzg(v, z2);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzF(int v, List list0) {
        int v1 = 0;
        if(list0 instanceof zzmw) {
            while(v1 < list0.size()) {
                Object object0 = ((zzmw)list0).zzc();
                if(object0 instanceof String) {
                    this.zza.zzh(v, ((String)object0));
                }
                else {
                    this.zza.zzi(v, ((zzlg)object0));
                }
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            String s = (String)list0.get(v1);
            this.zza.zzh(v, s);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzG(int v, List list0) {
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            zzlg zzlg0 = (zzlg)list0.get(v1);
            this.zza.zzi(v, zzlg0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzH(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmf) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmf)list0).size(); ++v2) {
                    v3 += zzll.zzz(((zzmf)list0).zzf(v2));
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmf)list0).size()) {
                    zzll0.zzr(((zzmf)list0).zzf(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmf)list0).size()) {
                int v4 = ((zzmf)list0).zzf(v1);
                this.zza.zzc(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzll.zzz(((int)(((Integer)list0.get(v5)))));
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzr(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzc(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzI(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmf) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmf)list0).size(); ++v2) {
                    ((zzmf)list0).zzf(v2);
                    v3 += 4;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmf)list0).size()) {
                    zzll0.zzs(((zzmf)list0).zzf(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmf)list0).size()) {
                int v4 = ((zzmf)list0).zzf(v1);
                this.zza.zzd(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Integer)list0.get(v5)).getClass();
                v6 += 4;
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzs(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzd(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzJ(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmz) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmz)list0).size(); ++v2) {
                    ((zzmz)list0).zzc(v2);
                    v3 += 8;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmz)list0).size()) {
                    zzll0.zzu(((zzmz)list0).zzc(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmz)list0).size()) {
                long v4 = ((zzmz)list0).zzc(v1);
                this.zza.zzf(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Long)list0.get(v5)).getClass();
                v6 += 8;
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzu(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zzf(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzK(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmf) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmf)list0).size(); ++v2) {
                    int v4 = ((zzmf)list0).zzf(v2);
                    v3 += zzll.zzz(v4 >> 0x1F ^ v4 + v4);
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmf)list0).size()) {
                    int v5 = ((zzmf)list0).zzf(v1);
                    zzll0.zzr(v5 >> 0x1F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmf)list0).size()) {
                int v6 = ((zzmf)list0).zzf(v1);
                this.zza.zzc(v, v6 >> 0x1F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                int v9 = (int)(((Integer)list0.get(v7)));
                v8 += zzll.zzz(v9 >> 0x1F ^ v9 + v9);
            }
            zzll1.zzr(v8);
            while(v1 < list0.size()) {
                int v10 = (int)(((Integer)list0.get(v1)));
                zzll1.zzr(v10 >> 0x1F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v11 = (int)(((Integer)list0.get(v1)));
            this.zza.zzc(v, v11 >> 0x1F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzL(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmz) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmz)list0).size(); ++v2) {
                    long v4 = ((zzmz)list0).zzc(v2);
                    v3 += zzll.zzA(v4 >> 0x3F ^ v4 + v4);
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmz)list0).size()) {
                    long v5 = ((zzmz)list0).zzc(v1);
                    zzll0.zzt(v5 >> 0x3F ^ v5 + v5);
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmz)list0).size()) {
                long v6 = ((zzmz)list0).zzc(v1);
                this.zza.zze(v, v6 >> 0x3F ^ v6 + v6);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v8 = 0;
            for(int v7 = 0; v7 < list0.size(); ++v7) {
                long v9 = (long)(((Long)list0.get(v7)));
                v8 += zzll.zzA(v9 >> 0x3F ^ v9 + v9);
            }
            zzll1.zzr(v8);
            while(v1 < list0.size()) {
                long v10 = (long)(((Long)list0.get(v1)));
                zzll1.zzt(v10 >> 0x3F ^ v10 + v10);
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v11 = (long)(((Long)list0.get(v1)));
            this.zza.zze(v, v11 >> 0x3F ^ v11 + v11);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzM(int v, zznd zznd0, Map map0) {
        for(Object object0: map0.entrySet()) {
            this.zza.zza(v, 2);
            int v1 = zzne.zzc(zznd0, ((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
            this.zza.zzr(v1);
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            zzne.zzb(this.zza, zznd0, object1, object2);
        }
    }

    public static zzlm zza(zzll zzll0) {
        zzlm zzlm0 = zzll0.zza;
        return zzlm0 == null ? new zzlm(zzll0) : zzlm0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzb(int v, int v1) {
        this.zza.zzd(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzc(int v, long v1) {
        this.zza.zze(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzd(int v, long v1) {
        this.zza.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zze(int v, float f) {
        this.zza.zzd(v, Float.floatToRawIntBits(f));
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzf(int v, double f) {
        this.zza.zzf(v, Double.doubleToRawLongBits(f));
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzg(int v, int v1) {
        this.zza.zzb(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzh(int v, long v1) {
        this.zza.zze(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzi(int v, int v1) {
        this.zza.zzb(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzj(int v, long v1) {
        this.zza.zzf(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzk(int v, int v1) {
        this.zza.zzd(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzl(int v, boolean z) {
        this.zza.zzg(v, z);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzm(int v, String s) {
        this.zza.zzh(v, s);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzn(int v, zzlg zzlg0) {
        this.zza.zzi(v, zzlg0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzo(int v, int v1) {
        this.zza.zzc(v, v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzp(int v, int v1) {
        this.zza.zzc(v, v1 >> 0x1F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzq(int v, long v1) {
        this.zza.zze(v, v1 >> 0x3F ^ v1 + v1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzr(int v, Object object0, zznw zznw0) {
        this.zza.zzl(v, ((zznl)object0), zznw0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzs(int v, Object object0, zznw zznw0) {
        this.zza.zza(v, 3);
        zznw0.zzf(((zznl)object0), this.zza.zza);
        this.zza.zza(v, 4);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzt(int v) {
        this.zza.zza(v, 3);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzu(int v) {
        this.zza.zza(v, 4);
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzv(int v, Object object0) {
        if(object0 instanceof zzlg) {
            this.zza.zzn(v, ((zzlg)object0));
            return;
        }
        this.zza.zzm(v, ((zznl)object0));
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzw(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmf) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmf)list0).size(); ++v2) {
                    v3 += zzll.zzA(((zzmf)list0).zzf(v2));
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmf)list0).size()) {
                    zzll0.zzq(((zzmf)list0).zzf(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmf)list0).size()) {
                int v4 = ((zzmf)list0).zzf(v1);
                this.zza.zzb(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzll.zzA(((int)(((Integer)list0.get(v5)))));
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzq(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzb(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzx(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmf) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmf)list0).size(); ++v2) {
                    ((zzmf)list0).zzf(v2);
                    v3 += 4;
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmf)list0).size()) {
                    zzll0.zzs(((zzmf)list0).zzf(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmf)list0).size()) {
                int v4 = ((zzmf)list0).zzf(v1);
                this.zza.zzd(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                ((Integer)list0.get(v5)).getClass();
                v6 += 4;
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzs(((int)(((Integer)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            int v7 = (int)(((Integer)list0.get(v1)));
            this.zza.zzd(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzy(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmz) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmz)list0).size(); ++v2) {
                    v3 += zzll.zzA(((zzmz)list0).zzc(v2));
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmz)list0).size()) {
                    zzll0.zzt(((zzmz)list0).zzc(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmz)list0).size()) {
                long v4 = ((zzmz)list0).zzc(v1);
                this.zza.zze(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzll.zzA(((long)(((Long)list0.get(v5)))));
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzt(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zze(v, v7);
            ++v1;
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzou
    public final void zzz(int v, List list0, boolean z) {
        int v1 = 0;
        if(list0 instanceof zzmz) {
            if(z) {
                zzll zzll0 = this.zza;
                zzll0.zza(v, 2);
                int v3 = 0;
                for(int v2 = 0; v2 < ((zzmz)list0).size(); ++v2) {
                    v3 += zzll.zzA(((zzmz)list0).zzc(v2));
                }
                zzll0.zzr(v3);
                while(v1 < ((zzmz)list0).size()) {
                    zzll0.zzt(((zzmz)list0).zzc(v1));
                    ++v1;
                }
                return;
            }
            while(v1 < ((zzmz)list0).size()) {
                long v4 = ((zzmz)list0).zzc(v1);
                this.zza.zze(v, v4);
                ++v1;
            }
            return;
        }
        if(z) {
            zzll zzll1 = this.zza;
            zzll1.zza(v, 2);
            int v6 = 0;
            for(int v5 = 0; v5 < list0.size(); ++v5) {
                v6 += zzll.zzA(((long)(((Long)list0.get(v5)))));
            }
            zzll1.zzr(v6);
            while(v1 < list0.size()) {
                zzll1.zzt(((long)(((Long)list0.get(v1)))));
                ++v1;
            }
            return;
        }
        while(v1 < list0.size()) {
            long v7 = (long)(((Long)list0.get(v1)));
            this.zza.zze(v, v7);
            ++v1;
        }
    }
}

