package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

final class zzv implements Iterable {
    final CharSequence zza;
    final zzy zzb;

    public zzv(zzy zzy0, CharSequence charSequence0) {
        this.zza = charSequence0;
        Objects.requireNonNull(zzy0);
        this.zzb = zzy0;
        super();
    }

    @Override
    public final Iterator iterator() {
        return this.zzb.zze(this.zza);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append('[');
        Iterator iterator0 = this.iterator();
        try {
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                stringBuilder0.append(zzr.zza(object0, ", "));
                while(iterator0.hasNext()) {
                    stringBuilder0.append(", ");
                    Object object1 = iterator0.next();
                    stringBuilder0.append(zzr.zza(object1, ", "));
                }
            }
        }
        catch(IOException iOException0) {
            throw new AssertionError(iOException0);
        }
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }
}

