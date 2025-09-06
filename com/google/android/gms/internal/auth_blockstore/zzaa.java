package com.google.android.gms.internal.auth_blockstore;

import android.content.Context;
import com.google.android.gms.auth.blockstore.BlockstoreClient;
import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.auth.blockstore.StoreBytesData;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

public final class zzaa extends GoogleApi implements BlockstoreClient {
    private static final ClientKey zza;
    private static final AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzaa.zza = api$ClientKey0;
        zzu zzu0 = new zzu();
        zzaa.zzb = zzu0;
        zzaa.zzc = new Api("Blockstore.API", zzu0, api$ClientKey0);
    }

    public zzaa(Context context0) {
        super(context0, zzaa.zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task deleteBytes(DeleteBytesRequest deleteBytesRequest0) {
        Preconditions.checkNotNull(deleteBytesRequest0, "DeleteBytesRequest cannot be null");
        return this.doWrite(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zzg}).run(new zzp(this, deleteBytesRequest0)).setAutoResolveMissingFeatures(false).setMethodKey(0x685).build());
    }

    @Override  // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task isEndToEndEncryptionAvailable() {
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zze}).run(new zzr(this)).setAutoResolveMissingFeatures(false).setMethodKey(0x673).build());
    }

    @Override  // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task retrieveBytes() {
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zza}).run(new zzt(this)).setAutoResolveMissingFeatures(false).setMethodKey(1570).build());
    }

    @Override  // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task retrieveBytes(RetrieveBytesRequest retrieveBytesRequest0) {
        Preconditions.checkNotNull(retrieveBytesRequest0, "RetrieveBytesRequest cannot be null");
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zzh}).run(new zzs(this, retrieveBytesRequest0)).setAutoResolveMissingFeatures(false).setMethodKey(0x684).build());
    }

    @Override  // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task storeBytes(StoreBytesData storeBytesData0) {
        return this.doWrite(TaskApiCall.builder().setFeatures(new Feature[]{zzab.zzd, zzab.zzf}).run(new zzq(this, storeBytesData0)).setMethodKey(0x66D).setAutoResolveMissingFeatures(false).build());
    }
}

