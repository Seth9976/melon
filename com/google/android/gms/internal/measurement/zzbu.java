package com.google.android.gms.internal.measurement;

import A7.d;
import b3.Z;
import k8.Y;

final class zzbu extends zzca {
    private final String zzc;
    private final int zzd;
    private final int zze;

    public zzbu(String s, boolean z, int v, zzbr zzbr0, zzbs zzbs0, int v1, byte[] arr_b) {
        this.zzc = s;
        this.zzd = v;
        this.zze = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof zzca) {
            String s = ((zzca)object0).zza();
            if(this.zzc.equals(s)) {
                ((zzca)object0).zzb();
                int v = this.zzd;
                int v1 = ((zzca)object0).zze();
                if(v == 0) {
                    throw null;
                }
                if(v == v1) {
                    ((zzca)object0).zzc();
                    ((zzca)object0).zzd();
                    int v2 = ((zzca)object0).zzf();
                    if(this.zze == 0) {
                        throw null;
                    }
                    return v2 == 1;
                }
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.zzc.hashCode();
        int v1 = this.zzd;
        if(v1 == 0 || this.zze == 0) {
            throw null;
        }
        return (((v ^ 1000003) * 1000003 ^ 0x4D5) * 1000003 ^ v1) * 0x22CD8CDB ^ 1;
    }

    @Override
    public final String toString() {
        String s1;
        String s = "null";
        switch(this.zzd) {
            case 1: {
                s1 = "ALL_CHECKS";
                break;
            }
            case 2: {
                s1 = "SKIP_COMPLIANCE_CHECK";
                break;
            }
            case 3: {
                s1 = "SKIP_SECURITY_CHECK";
                break;
            }
            case 4: {
                s1 = "NO_CHECKS";
                break;
            }
            default: {
                s1 = "null";
            }
        }
        if(this.zze == 1) {
            s = "READ_AND_WRITE";
        }
        StringBuilder stringBuilder0 = new StringBuilder(s.length() + Z.d(Z.e(73, this.zzc), 91, s1) + 1);
        d.u(stringBuilder0, "FileComplianceOptions{fileOwner=", this.zzc, ", hasDifferentDmaOwner=false, fileChecks=", s1);
        return Y.l(stringBuilder0, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", s, "}");
    }

    @Override  // com.google.android.gms.internal.measurement.zzca
    public final String zza() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.measurement.zzca
    public final boolean zzb() {
        return false;
    }

    @Override  // com.google.android.gms.internal.measurement.zzca
    public final zzbr zzc() {
        return null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzca
    public final zzbs zzd() {
        return null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzca
    public final int zze() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzca
    public final int zzf() {
        return this.zze;
    }
}

