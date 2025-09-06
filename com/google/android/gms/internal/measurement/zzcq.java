package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

public abstract class zzcq extends zzbm implements zzcr {
    public zzcq() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcr asInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterface0 instanceof zzcr ? ((zzcr)iInterface0) : new zzcp(iBinder0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        zzcu zzcu0 = null;
        switch(v) {
            case 1: {
                IObjectWrapper iObjectWrapper0 = Stub.asInterface(parcel0.readStrongBinder());
                zzdd zzdd0 = (zzdd)zzbn.zzb(parcel0, zzdd.CREATOR);
                long v2 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.initialize(iObjectWrapper0, zzdd0, v2);
                break;
            }
            case 2: {
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                Parcelable parcelable0 = zzbn.zzb(parcel0, Bundle.CREATOR);
                boolean z = zzbn.zza(parcel0);
                boolean z1 = zzbn.zza(parcel0);
                long v3 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.logEvent(s, s1, ((Bundle)parcelable0), z, z1, v3);
                break;
            }
            case 3: {
                String s2 = parcel0.readString();
                String s3 = parcel0.readString();
                Bundle bundle0 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                IBinder iBinder0 = parcel0.readStrongBinder();
                if(iBinder0 != null) {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface0 instanceof zzcu ? ((zzcu)iInterface0) : new zzcs(iBinder0);
                }
                long v4 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.logEventAndBundle(s2, s3, bundle0, zzcu0, v4);
                break;
            }
            case 4: {
                String s4 = parcel0.readString();
                String s5 = parcel0.readString();
                IObjectWrapper iObjectWrapper1 = Stub.asInterface(parcel0.readStrongBinder());
                boolean z2 = zzbn.zza(parcel0);
                long v5 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setUserProperty(s4, s5, iObjectWrapper1, z2, v5);
                break;
            }
            case 5: {
                String s6 = parcel0.readString();
                String s7 = parcel0.readString();
                boolean z3 = zzbn.zza(parcel0);
                IBinder iBinder1 = parcel0.readStrongBinder();
                if(iBinder1 != null) {
                    IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface1 instanceof zzcu ? ((zzcu)iInterface1) : new zzcs(iBinder1);
                }
                zzbn.zzf(parcel0);
                this.getUserProperties(s6, s7, z3, zzcu0);
                break;
            }
            case 6: {
                String s8 = parcel0.readString();
                IBinder iBinder2 = parcel0.readStrongBinder();
                if(iBinder2 != null) {
                    IInterface iInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface2 instanceof zzcu ? ((zzcu)iInterface2) : new zzcs(iBinder2);
                }
                zzbn.zzf(parcel0);
                this.getMaxUserProperties(s8, zzcu0);
                break;
            }
            case 7: {
                String s9 = parcel0.readString();
                long v6 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setUserId(s9, v6);
                break;
            }
            case 8: {
                Bundle bundle1 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                long v7 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setConditionalUserProperty(bundle1, v7);
                break;
            }
            case 9: {
                String s10 = parcel0.readString();
                String s11 = parcel0.readString();
                Bundle bundle2 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                zzbn.zzf(parcel0);
                this.clearConditionalUserProperty(s10, s11, bundle2);
                break;
            }
            case 10: {
                String s12 = parcel0.readString();
                String s13 = parcel0.readString();
                IBinder iBinder3 = parcel0.readStrongBinder();
                if(iBinder3 != null) {
                    IInterface iInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface3 instanceof zzcu ? ((zzcu)iInterface3) : new zzcs(iBinder3);
                }
                zzbn.zzf(parcel0);
                this.getConditionalUserProperties(s12, s13, zzcu0);
                break;
            }
            case 11: {
                boolean z4 = zzbn.zza(parcel0);
                long v8 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setMeasurementEnabled(z4, v8);
                break;
            }
            case 12: {
                long v9 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.resetAnalyticsData(v9);
                break;
            }
            case 13: {
                long v10 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setMinimumSessionDuration(v10);
                break;
            }
            case 14: {
                long v11 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setSessionTimeoutDuration(v11);
                break;
            }
            case 15: {
                IObjectWrapper iObjectWrapper2 = Stub.asInterface(parcel0.readStrongBinder());
                String s14 = parcel0.readString();
                String s15 = parcel0.readString();
                long v12 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setCurrentScreen(iObjectWrapper2, s14, s15, v12);
                break;
            }
            case 16: {
                IBinder iBinder4 = parcel0.readStrongBinder();
                if(iBinder4 != null) {
                    IInterface iInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface4 instanceof zzcu ? ((zzcu)iInterface4) : new zzcs(iBinder4);
                }
                zzbn.zzf(parcel0);
                this.getCurrentScreenName(zzcu0);
                break;
            }
            case 17: {
                IBinder iBinder5 = parcel0.readStrongBinder();
                if(iBinder5 != null) {
                    IInterface iInterface5 = iBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface5 instanceof zzcu ? ((zzcu)iInterface5) : new zzcs(iBinder5);
                }
                zzbn.zzf(parcel0);
                this.getCurrentScreenClass(zzcu0);
                break;
            }
            case 18: {
                IBinder iBinder6 = parcel0.readStrongBinder();
                if(iBinder6 != null) {
                    IInterface iInterface6 = iBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzcu0 = iInterface6 instanceof zzdc ? ((zzdc)iInterface6) : new zzdb(iBinder6);
                }
                zzbn.zzf(parcel0);
                this.setInstanceIdProvider(((zzdc)zzcu0));
                break;
            }
            case 19: {
                IBinder iBinder7 = parcel0.readStrongBinder();
                if(iBinder7 != null) {
                    IInterface iInterface7 = iBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface7 instanceof zzcu ? ((zzcu)iInterface7) : new zzcs(iBinder7);
                }
                zzbn.zzf(parcel0);
                this.getCachedAppInstanceId(zzcu0);
                break;
            }
            case 20: {
                IBinder iBinder8 = parcel0.readStrongBinder();
                if(iBinder8 != null) {
                    IInterface iInterface8 = iBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface8 instanceof zzcu ? ((zzcu)iInterface8) : new zzcs(iBinder8);
                }
                zzbn.zzf(parcel0);
                this.getAppInstanceId(zzcu0);
                break;
            }
            case 21: {
                IBinder iBinder9 = parcel0.readStrongBinder();
                if(iBinder9 != null) {
                    IInterface iInterface9 = iBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface9 instanceof zzcu ? ((zzcu)iInterface9) : new zzcs(iBinder9);
                }
                zzbn.zzf(parcel0);
                this.getGmpAppId(zzcu0);
                break;
            }
            case 22: {
                IBinder iBinder10 = parcel0.readStrongBinder();
                if(iBinder10 != null) {
                    IInterface iInterface10 = iBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface10 instanceof zzcu ? ((zzcu)iInterface10) : new zzcs(iBinder10);
                }
                zzbn.zzf(parcel0);
                this.generateEventId(zzcu0);
                break;
            }
            case 23: {
                String s16 = parcel0.readString();
                long v13 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.beginAdUnitExposure(s16, v13);
                break;
            }
            case 24: {
                String s17 = parcel0.readString();
                long v14 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.endAdUnitExposure(s17, v14);
                break;
            }
            case 25: {
                IObjectWrapper iObjectWrapper3 = Stub.asInterface(parcel0.readStrongBinder());
                long v15 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityStarted(iObjectWrapper3, v15);
                break;
            }
            case 26: {
                IObjectWrapper iObjectWrapper4 = Stub.asInterface(parcel0.readStrongBinder());
                long v16 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityStopped(iObjectWrapper4, v16);
                break;
            }
            case 27: {
                IObjectWrapper iObjectWrapper5 = Stub.asInterface(parcel0.readStrongBinder());
                Bundle bundle3 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                long v17 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityCreated(iObjectWrapper5, bundle3, v17);
                break;
            }
            case 28: {
                IObjectWrapper iObjectWrapper6 = Stub.asInterface(parcel0.readStrongBinder());
                long v18 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityDestroyed(iObjectWrapper6, v18);
                break;
            }
            case 29: {
                IObjectWrapper iObjectWrapper7 = Stub.asInterface(parcel0.readStrongBinder());
                long v19 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityPaused(iObjectWrapper7, v19);
                break;
            }
            case 30: {
                IObjectWrapper iObjectWrapper8 = Stub.asInterface(parcel0.readStrongBinder());
                long v20 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityResumed(iObjectWrapper8, v20);
                break;
            }
            case 0x1F: {
                IObjectWrapper iObjectWrapper9 = Stub.asInterface(parcel0.readStrongBinder());
                IBinder iBinder11 = parcel0.readStrongBinder();
                if(iBinder11 != null) {
                    IInterface iInterface11 = iBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface11 instanceof zzcu ? ((zzcu)iInterface11) : new zzcs(iBinder11);
                }
                long v21 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivitySaveInstanceState(iObjectWrapper9, zzcu0, v21);
                break;
            }
            case 0x20: {
                Bundle bundle4 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                IBinder iBinder12 = parcel0.readStrongBinder();
                if(iBinder12 != null) {
                    IInterface iInterface12 = iBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface12 instanceof zzcu ? ((zzcu)iInterface12) : new zzcs(iBinder12);
                }
                long v22 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.performAction(bundle4, zzcu0, v22);
                break;
            }
            case 33: {
                int v23 = parcel0.readInt();
                String s18 = parcel0.readString();
                IObjectWrapper iObjectWrapper10 = Stub.asInterface(parcel0.readStrongBinder());
                IObjectWrapper iObjectWrapper11 = Stub.asInterface(parcel0.readStrongBinder());
                IObjectWrapper iObjectWrapper12 = Stub.asInterface(parcel0.readStrongBinder());
                zzbn.zzf(parcel0);
                this.logHealthData(v23, s18, iObjectWrapper10, iObjectWrapper11, iObjectWrapper12);
                break;
            }
            case 34: {
                IBinder iBinder13 = parcel0.readStrongBinder();
                if(iBinder13 != null) {
                    IInterface iInterface13 = iBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcu0 = iInterface13 instanceof zzda ? ((zzda)iInterface13) : new zzcy(iBinder13);
                }
                zzbn.zzf(parcel0);
                this.setEventInterceptor(((zzda)zzcu0));
                break;
            }
            case 35: {
                IBinder iBinder14 = parcel0.readStrongBinder();
                if(iBinder14 != null) {
                    IInterface iInterface14 = iBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcu0 = iInterface14 instanceof zzda ? ((zzda)iInterface14) : new zzcy(iBinder14);
                }
                zzbn.zzf(parcel0);
                this.registerOnMeasurementEventListener(((zzda)zzcu0));
                break;
            }
            case 36: {
                IBinder iBinder15 = parcel0.readStrongBinder();
                if(iBinder15 != null) {
                    IInterface iInterface15 = iBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzcu0 = iInterface15 instanceof zzda ? ((zzda)iInterface15) : new zzcy(iBinder15);
                }
                zzbn.zzf(parcel0);
                this.unregisterOnMeasurementEventListener(((zzda)zzcu0));
                break;
            }
            case 37: {
                HashMap hashMap0 = zzbn.zze(parcel0);
                zzbn.zzf(parcel0);
                this.initForTests(hashMap0);
                break;
            }
            case 38: {
                IBinder iBinder16 = parcel0.readStrongBinder();
                if(iBinder16 != null) {
                    IInterface iInterface16 = iBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface16 instanceof zzcu ? ((zzcu)iInterface16) : new zzcs(iBinder16);
                }
                int v24 = parcel0.readInt();
                zzbn.zzf(parcel0);
                this.getTestFlag(zzcu0, v24);
                break;
            }
            case 39: {
                boolean z5 = zzbn.zza(parcel0);
                zzbn.zzf(parcel0);
                this.setDataCollectionEnabled(z5);
                break;
            }
            case 40: {
                IBinder iBinder17 = parcel0.readStrongBinder();
                if(iBinder17 != null) {
                    IInterface iInterface17 = iBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface17 instanceof zzcu ? ((zzcu)iInterface17) : new zzcs(iBinder17);
                }
                zzbn.zzf(parcel0);
                this.isDataCollectionEnabled(zzcu0);
                break;
            }
            case 42: {
                Bundle bundle5 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                zzbn.zzf(parcel0);
                this.setDefaultEventParameters(bundle5);
                break;
            }
            case 43: {
                long v25 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.clearMeasurementEnabled(v25);
                break;
            }
            case 44: {
                Bundle bundle6 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                long v26 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setConsent(bundle6, v26);
                break;
            }
            case 45: {
                Bundle bundle7 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                long v27 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setConsentThirdParty(bundle7, v27);
                break;
            }
            case 46: {
                IBinder iBinder18 = parcel0.readStrongBinder();
                if(iBinder18 != null) {
                    IInterface iInterface18 = iBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface18 instanceof zzcu ? ((zzcu)iInterface18) : new zzcs(iBinder18);
                }
                zzbn.zzf(parcel0);
                this.getSessionId(zzcu0);
                break;
            }
            case 0x30: {
                Intent intent0 = (Intent)zzbn.zzb(parcel0, Intent.CREATOR);
                zzbn.zzf(parcel0);
                this.setSgtmDebugInfo(intent0);
                break;
            }
            case 50: {
                zzdf zzdf0 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                String s19 = parcel0.readString();
                String s20 = parcel0.readString();
                long v28 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.setCurrentScreenByScionActivityInfo(zzdf0, s19, s20, v28);
                break;
            }
            case 51: {
                zzdf zzdf1 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                long v29 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityStartedByScionActivityInfo(zzdf1, v29);
                break;
            }
            case 52: {
                zzdf zzdf2 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                long v30 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityStoppedByScionActivityInfo(zzdf2, v30);
                break;
            }
            case 53: {
                zzdf zzdf3 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                Bundle bundle8 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                long v31 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityCreatedByScionActivityInfo(zzdf3, bundle8, v31);
                break;
            }
            case 54: {
                zzdf zzdf4 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                long v32 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityDestroyedByScionActivityInfo(zzdf4, v32);
                break;
            }
            case 55: {
                zzdf zzdf5 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                long v33 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityPausedByScionActivityInfo(zzdf5, v33);
                break;
            }
            case 56: {
                zzdf zzdf6 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                long v34 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivityResumedByScionActivityInfo(zzdf6, v34);
                break;
            }
            case 57: {
                zzdf zzdf7 = (zzdf)zzbn.zzb(parcel0, zzdf.CREATOR);
                IBinder iBinder19 = parcel0.readStrongBinder();
                if(iBinder19 != null) {
                    IInterface iInterface19 = iBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzcu0 = iInterface19 instanceof zzcu ? ((zzcu)iInterface19) : new zzcs(iBinder19);
                }
                long v35 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.onActivitySaveInstanceStateByScionActivityInfo(zzdf7, zzcu0, v35);
                break;
            }
            case 58: {
                IBinder iBinder20 = parcel0.readStrongBinder();
                if(iBinder20 != null) {
                    IInterface iInterface20 = iBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    zzcu0 = iInterface20 instanceof zzcx ? ((zzcx)iInterface20) : new zzcv(iBinder20);
                }
                zzbn.zzf(parcel0);
                this.retrieveAndUploadBatches(((zzcx)zzcu0));
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

