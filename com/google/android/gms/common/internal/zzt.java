package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzt extends zza implements IAccountAccessor {
    public zzt(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override  // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() {
        Parcel parcel0 = this.zzB(2, this.zza());
        Account account0 = (Account)zzc.zzb(parcel0, Account.CREATOR);
        parcel0.recycle();
        return account0;
    }
}

