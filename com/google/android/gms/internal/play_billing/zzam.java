package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzam extends zzaf implements Set {
    @CheckForNull
    private transient zzai zza;

    @Override
    public final boolean equals(@CheckForNull Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof Set) {
            Set set0 = (Set)object0;
            try {
                return this.size() != set0.size() || !this.containsAll(set0) ? false : true;
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return zzau.zza(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public Iterator iterator() {
        return this.zze();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public zzai zzd() {
        zzai zzai0 = this.zza;
        if(zzai0 == null) {
            zzai0 = this.zzh();
            this.zza = zzai0;
        }
        return zzai0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public abstract zzav zze();

    public zzai zzh() {
        Object[] arr_object = this.toArray();
        return zzai.zzi(arr_object, arr_object.length);
    }
}

