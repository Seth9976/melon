package com.google.android.gms.internal.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzk implements Iterator {
    private Object zza;
    private int zzb;

    public zzk() {
        this.zzb = 2;
    }

    @Override
    public final boolean hasNext() {
        zzt.zza(this.zzb != 4);
        int v = this.zzb - 1;
        if(this.zzb == 0) {
            throw null;
        }
        switch(v) {
            case 0: {
                return true;
            label_6:
                this.zzb = 4;
                this.zza = this.zza();
                if(this.zzb != 3) {
                    this.zzb = 1;
                    return true;
                }
                break;
            }
            case 2: {
                break;
            }
            default: {
                goto label_6;
            }
        }
        return false;
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.zzb = 2;
        Object object0 = this.zza;
        this.zza = null;
        return object0;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public abstract Object zza();

    public final Object zzb() {
        this.zzb = 3;
        return null;
    }
}

