package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzac implements Iterator {
    final Iterator zza;
    final Iterator zzb;

    public zzac(zzae zzae0, Iterator iterator0, Iterator iterator1) {
        this.zza = iterator0;
        this.zzb = iterator1;
        Objects.requireNonNull(zzae0);
        super();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean hasNext() {
        return this.zza.hasNext() ? true : this.zzb.hasNext();
    }

    @Override
    public final Object next() {
        Iterator iterator0 = this.zza;
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            return new zzas(((Integer)object0).toString());
        }
        Iterator iterator1 = this.zzb;
        if(!iterator1.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object1 = iterator1.next();
        return new zzas(((String)object1));
    }
}

