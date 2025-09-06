package com.google.android.gms.internal.auth-api-phone;

import android.content.Context;
import com.google.android.gms.auth.api.phone.IncomingCallRetrieverClient;
import com.google.android.gms.auth.api.phone.IncomingCallRetrieverRequest;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public final class zzp extends GoogleApi implements IncomingCallRetrieverClient {
    public static final int zza;
    @NotNull
    private static final Logger zzb;

    static {
        zzp.zzb = new Logger("MissedCallRetriever", new String[0]);
    }

    public zzp(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0, zzr.zza(), ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.auth.api.phone.IncomingCallRetrieverClient
    @NotNull
    public final Task startIncomingCallRetriever(@NotNull IncomingCallRetrieverRequest incomingCallRetrieverRequest0) {
        q.g(incomingCallRetrieverRequest0, "incomingCallRetrieverRequest");
        zzp.zzb.i("InternalMissedCallRetrieverClient#startMissedCallRetriever invoked", new Object[0]);
        Task task0 = this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zzal.zze}).run(new zzn(incomingCallRetrieverRequest0)).setMethodKey(0x6B3).build());
        q.f(task0, "doRead(...)");
        return task0;
    }
}

