package com.google.android.gms.internal.auth_blockstore;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.auth.blockstore.StoreBytesData;

public final class zzg extends zza implements IInterface {
    public zzg(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.auth.blockstore.internal.IBlockstoreService");
    }

    public final void zza(zzi zzi0, DeleteBytesRequest deleteBytesRequest0) {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zzc(parcel0, zzi0);
        zzc.zzb(parcel0, deleteBytesRequest0);
        this.transactAndReadExceptionReturnVoid(13, parcel0);
    }

    public final void zzb(zzk zzk0) {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zzc(parcel0, zzk0);
        this.transactAndReadExceptionReturnVoid(11, parcel0);
    }

    public final void zzc(zzm zzm0) {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zzc(parcel0, zzm0);
        this.transactAndReadExceptionReturnVoid(2, parcel0);
    }

    public final void zzd(zzm zzm0, RetrieveBytesRequest retrieveBytesRequest0) {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zzc(parcel0, zzm0);
        zzc.zzb(parcel0, retrieveBytesRequest0);
        this.transactAndReadExceptionReturnVoid(12, parcel0);
    }

    public final void zze(zzo zzo0, StoreBytesData storeBytesData0) {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zzc(parcel0, zzo0);
        zzc.zzb(parcel0, storeBytesData0);
        this.transactAndReadExceptionReturnVoid(10, parcel0);
    }
}

