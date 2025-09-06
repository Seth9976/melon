package com.google.android.gms.internal.measurement;

import H0.b;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public final class zzah implements zzao {
    private final Double zza;

    public zzah(Double double0) {
        if(double0 == null) {
            this.zza = NaN;
            return;
        }
        this.zza = double0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzah ? this.zza.equals(((zzah)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override
    public final String toString() {
        return this.zzc();
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        Double double0 = this.zza;
        if(Double.isNaN(((double)double0))) {
            return "NaN";
        }
        if(Double.isInfinite(((double)double0))) {
            return ((double)double0) > 0.0 ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimal0 = BigDecimal.valueOf(((double)double0));
        BigDecimal bigDecimal1 = bigDecimal0.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal0.stripTrailingZeros();
        DecimalFormat decimalFormat0 = new DecimalFormat("0E0");
        decimalFormat0.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat0.setMinimumFractionDigits((bigDecimal1.scale() <= 0 ? bigDecimal1.scale() : bigDecimal1.precision()) - 1);
        String s = decimalFormat0.format(bigDecimal1);
        int v = s.indexOf("E");
        if(v > 0) {
            int v1 = Integer.parseInt(s.substring(v + 1));
            return (v1 >= 0 || v1 <= -7) && (v1 < 0 || v1 >= 21) ? s.replace("E-", "e-").replace("E", "e+") : bigDecimal1.toPlainString();
        }
        return s;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        if(!"toString".equals(s)) {
            throw new IllegalArgumentException(b.j(this.zzc(), ".", s, " is not a function."));
        }
        return new zzas(this.zzc());
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(!Double.isNaN(((double)this.zza)) && ((double)this.zza) != 0.0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzah(this.zza);
    }
}

