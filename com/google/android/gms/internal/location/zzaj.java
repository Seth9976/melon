package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zza;
import com.google.android.gms.location.zzb;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.Task;

public final class zzaj extends GoogleApi implements ActivityRecognitionClient {
    static final ClientKey zza;
    public static final Api zzb;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzaj.zza = api$ClientKey0;
        zzaj.zzb = new Api("ActivityRecognition.API", new zzag(), api$ClientKey0);
    }

    public zzaj(Activity activity0) {
        super(activity0, zzaj.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public zzaj(Context context0) {
        super(context0, zzaj.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.location.ActivityRecognitionClient
    public final Task removeActivityTransitionUpdates(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzam(pendingIntent0)).setMethodKey(2406).build());
    }

    @Override  // com.google.android.gms.location.ActivityRecognitionClient
    public final Task removeActivityUpdates(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzak(pendingIntent0)).setMethodKey(2402).build());
    }

    @Override  // com.google.android.gms.location.ActivityRecognitionClient
    public final Task removeSleepSegmentUpdates(PendingIntent pendingIntent0) {
        return this.doWrite(TaskApiCall.builder().run(new zzan(pendingIntent0)).setMethodKey(0x96B).build());
    }

    @Override  // com.google.android.gms.location.ActivityRecognitionClient
    public final Task requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest0, PendingIntent pendingIntent0) {
        activityTransitionRequest0.zza(this.getContextAttributionTag());
        return this.doWrite(TaskApiCall.builder().run(new zzal(activityTransitionRequest0, pendingIntent0)).setMethodKey(2405).build());
    }

    @Override  // com.google.android.gms.location.ActivityRecognitionClient
    public final Task requestActivityUpdates(long v, PendingIntent pendingIntent0) {
        zza zza0 = new zza();
        zza0.zza(v);
        zzb zzb0 = zza0.zzb();
        zzb0.zza(this.getContextAttributionTag());
        return this.doWrite(TaskApiCall.builder().run(new zzap(zzb0, pendingIntent0)).setMethodKey(2401).build());
    }

    @Override  // com.google.android.gms.location.ActivityRecognitionClient
    public final Task requestSleepSegmentUpdates(PendingIntent pendingIntent0, SleepSegmentRequest sleepSegmentRequest0) {
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent must be specified.");
        return this.doRead(TaskApiCall.builder().run(new zzao(this, pendingIntent0, sleepSegmentRequest0)).setFeatures(new Feature[]{zzo.zzb}).setMethodKey(2410).build());
    }
}

