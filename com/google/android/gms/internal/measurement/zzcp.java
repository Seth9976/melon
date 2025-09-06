package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzcp extends zzbl implements zzcr {
    public zzcp(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void beginAdUnitExposure(String s, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeLong(v);
        this.zzc(23, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void clearConditionalUserProperty(String s, String s1, Bundle bundle0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzbn.zzc(parcel0, bundle0);
        this.zzc(9, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void clearMeasurementEnabled(long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void endAdUnitExposure(String s, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeLong(v);
        this.zzc(24, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void generateEventId(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(22, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getAppInstanceId(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(20, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getCachedAppInstanceId(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(19, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getConditionalUserProperties(String s, String s1, zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(10, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getCurrentScreenClass(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(17, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getCurrentScreenName(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(16, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getGmpAppId(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(21, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getMaxUserProperties(String s, zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(6, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getSessionId(zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(46, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getTestFlag(zzcu zzcu0, int v) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcu0);
        parcel0.writeInt(v);
        this.zzc(38, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void getUserProperties(String s, String s1, boolean z, zzcu zzcu0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeInt(((int)z));
        zzbn.zzd(parcel0, zzcu0);
        this.zzc(5, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void initForTests(Map map0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void initialize(IObjectWrapper iObjectWrapper0, zzdd zzdd0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, iObjectWrapper0);
        zzbn.zzc(parcel0, zzdd0);
        parcel0.writeLong(v);
        this.zzc(1, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void isDataCollectionEnabled(zzcu zzcu0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void logEvent(String s, String s1, Bundle bundle0, boolean z, boolean z1, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzbn.zzc(parcel0, bundle0);
        parcel0.writeInt(((int)z));
        parcel0.writeInt(((int)z1));
        parcel0.writeLong(v);
        this.zzc(2, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void logEventAndBundle(String s, String s1, Bundle bundle0, zzcu zzcu0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void logHealthData(int v, String s, IObjectWrapper iObjectWrapper0, IObjectWrapper iObjectWrapper1, IObjectWrapper iObjectWrapper2) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(5);
        parcel0.writeString(s);
        zzbn.zzd(parcel0, iObjectWrapper0);
        zzbn.zzd(parcel0, iObjectWrapper1);
        zzbn.zzd(parcel0, iObjectWrapper2);
        this.zzc(33, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreated(IObjectWrapper iObjectWrapper0, Bundle bundle0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreatedByScionActivityInfo(zzdf zzdf0, Bundle bundle0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        zzbn.zzc(parcel0, bundle0);
        parcel0.writeLong(v);
        this.zzc(53, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyedByScionActivityInfo(zzdf zzdf0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        parcel0.writeLong(v);
        this.zzc(54, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPaused(IObjectWrapper iObjectWrapper0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPausedByScionActivityInfo(zzdf zzdf0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        parcel0.writeLong(v);
        this.zzc(55, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumed(IObjectWrapper iObjectWrapper0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumedByScionActivityInfo(zzdf zzdf0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        parcel0.writeLong(v);
        this.zzc(56, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper0, zzcu zzcu0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdf0, zzcu zzcu0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        zzbn.zzd(parcel0, zzcu0);
        parcel0.writeLong(v);
        this.zzc(57, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStarted(IObjectWrapper iObjectWrapper0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStartedByScionActivityInfo(zzdf zzdf0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        parcel0.writeLong(v);
        this.zzc(51, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStopped(IObjectWrapper iObjectWrapper0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStoppedByScionActivityInfo(zzdf zzdf0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        parcel0.writeLong(v);
        this.zzc(52, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void performAction(Bundle bundle0, zzcu zzcu0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        zzbn.zzd(parcel0, zzcu0);
        parcel0.writeLong(v);
        this.zzc(0x20, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void registerOnMeasurementEventListener(zzda zzda0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzda0);
        this.zzc(35, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void resetAnalyticsData(long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeLong(v);
        this.zzc(12, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void retrieveAndUploadBatches(zzcx zzcx0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzcx0);
        this.zzc(58, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setConditionalUserProperty(Bundle bundle0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        parcel0.writeLong(v);
        this.zzc(8, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setConsent(Bundle bundle0, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setConsentThirdParty(Bundle bundle0, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        parcel0.writeLong(v);
        this.zzc(45, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper0, String s, String s1, long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreenByScionActivityInfo(zzdf zzdf0, String s, String s1, long v) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, zzdf0);
        parcel0.writeString(s);
        parcel0.writeString(s1);
        parcel0.writeLong(v);
        this.zzc(50, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setDataCollectionEnabled(boolean z) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        this.zzc(39, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setDefaultEventParameters(Bundle bundle0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        this.zzc(42, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setEventInterceptor(zzda zzda0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzda0);
        this.zzc(34, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setInstanceIdProvider(zzdc zzdc0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setMeasurementEnabled(boolean z, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(((int)z));
        parcel0.writeLong(v);
        this.zzc(11, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setMinimumSessionDuration(long v) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setSessionTimeoutDuration(long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeLong(v);
        this.zzc(14, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setSgtmDebugInfo(Intent intent0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, intent0);
        this.zzc(0x30, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setUserId(String s, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeLong(v);
        this.zzc(7, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void setUserProperty(String s, String s1, IObjectWrapper iObjectWrapper0, boolean z, long v) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        parcel0.writeString(s1);
        zzbn.zzd(parcel0, iObjectWrapper0);
        parcel0.writeInt(((int)z));
        parcel0.writeLong(v);
        this.zzc(4, parcel0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public final void unregisterOnMeasurementEventListener(zzda zzda0) {
        Parcel parcel0 = this.zza();
        zzbn.zzd(parcel0, zzda0);
        this.zzc(36, parcel0);
    }
}

