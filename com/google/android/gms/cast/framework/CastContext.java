package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.google.android.gms.cast.CredentialsData;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzaf;
import com.google.android.gms.internal.cast.zzag;
import com.google.android.gms.internal.cast.zzai;
import com.google.android.gms.internal.cast.zzay;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzbn;
import com.google.android.gms.internal.cast.zzdq;
import com.google.android.gms.internal.cast.zzdv;
import com.google.android.gms.internal.cast.zzvu;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import l4.G;
import l4.Q;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class CastContext {
    public static final String OPTIONS_PROVIDER_CLASS_NAME_KEY = "com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME";
    final zzaf zza;
    private static final Logger zzb;
    private static final Object zzc;
    private static volatile CastContext zzd;
    private final Context zze;
    private final zzaj zzf;
    private final SessionManager zzg;
    private final zzac zzh;
    private final PrecacheManager zzi;
    private final MediaNotificationManager zzj;
    private final CastOptions zzk;
    private final zzn zzl;
    private final zzbf zzm;
    private final zzay zzn;
    private final List zzo;
    private final zzbn zzp;
    private zzai zzq;
    private CastReasonCodes zzr;

    static {
        CastContext.zzb = new Logger("CastContext");
        CastContext.zzc = new Object();
    }

    private CastContext(Context context0, CastOptions castOptions0, List list0, zzbf zzbf0, zzn zzn0) {
        com.google.android.gms.cast.framework.zzay zzay1;
        zzaq zzaq0;
        zzaj zzaj0;
        this.zze = context0;
        this.zzk = castOptions0;
        this.zzm = zzbf0;
        this.zzl = zzn0;
        this.zzo = list0;
        zzay zzay0 = new zzay(context0);
        this.zzn = zzay0;
        zzbn zzbn0 = zzbf0.zzn();
        this.zzp = zzbn0;
        this.zzi();
        Map map0 = this.zzh();
        castOptions0.zzb(new zzl(1));
        try {
            zzaj0 = zzag.zza(context0, castOptions0, zzbf0, map0);
            this.zzf = zzaj0;
        }
        catch(RemoteException remoteException0) {
            throw new IllegalStateException("Failed to call newCastContextImpl", remoteException0);
        }
        try {
            zzaq0 = zzaj0.zzf();
        }
        catch(RemoteException remoteException1) {
            throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", remoteException1);
        }
        this.zzh = new zzac(zzaq0);
        try {
            zzay1 = zzaj0.zzg();
        }
        catch(RemoteException remoteException2) {
            throw new IllegalStateException("Failed to call getSessionManagerImpl", remoteException2);
        }
        SessionManager sessionManager0 = new SessionManager(zzay1, context0);
        this.zzg = sessionManager0;
        this.zzj = new MediaNotificationManager(sessionManager0);
        this.zzi = new PrecacheManager(castOptions0, sessionManager0, zzn0);
        if(zzbn0 != null) {
            zzbn0.zzj(sessionManager0);
        }
        zzdv zzdv0 = new zzdv(context0, zzvu.zza(Executors.newFixedThreadPool(3)));
        new Logger("BaseNetUtils");
        zzdv0.zza();
        zzaf zzaf0 = new zzaf();
        this.zza = zzaf0;
        try {
            zzaj0.zzh(zzaf0);
        }
        catch(RemoteException remoteException3) {
            throw new IllegalStateException("Failed to call addAppVisibilityListener", remoteException3);
        }
        zzaf0.zze(zzay0.zza);
        if(!castOptions0.zza().isEmpty()) {
            String s = "Setting Route Discovery for appIds: " + castOptions0.zza();
            CastContext.zzb.i(s, new Object[0]);
            zzay0.zza(castOptions0.zza());
        }
        zzn0.zza(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS"}).addOnSuccessListener(new zzg(this));
        zzn0.doRead(TaskApiCall.builder().run(new zzh(zzn0, new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"})).setFeatures(new Feature[]{zzav.zzh}).setAutoResolveMissingFeatures(false).setMethodKey(0x20EB).build()).addOnSuccessListener(new com.google.android.gms.cast.framework.zzh(this));
    }

    @Deprecated
    public void addAppVisibilityListener(AppVisibilityListener appVisibilityListener0) {
    }

    public void addCastStateListener(CastStateListener castStateListener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(castStateListener0);
        this.zzg.zzc(castStateListener0);
    }

    public void addSessionTransferCallback(SessionTransferCallback sessionTransferCallback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback0);
        this.zzm.zzr(sessionTransferCallback0);
    }

    public CastOptions getCastOptions() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public int getCastReasonCodeForCastStatusCode(int v) {
        CastReasonCodes castReasonCodes0 = this.zzr;
        if(castReasonCodes0 == null) {
            CastContext.zzb.w("castReasonCodes hasn\'t been initialized yet", new Object[0]);
            return 0;
        }
        return castReasonCodes0.zza(v);
    }

    public int getCastState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg.zza();
    }

    public MediaNotificationManager getMediaNotificationManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public G getMergedSelector() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return G.b(this.zzf.zze());
        }
        catch(RemoteException remoteException0) {
            CastContext.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getMergedSelectorAsBundle", "zzaj"});
            return null;
        }
    }

    public PrecacheManager getPrecacheManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    public SessionManager getSessionManager() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzg;
    }

    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return CastContext.zzd;
    }

    public static CastContext getSharedInstance(Context context0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(CastContext.zzd == null) {
            synchronized(CastContext.zzc) {
                if(CastContext.zzd == null) {
                    Context context1 = context0.getApplicationContext();
                    OptionsProvider optionsProvider0 = CastContext.zzg(context1);
                    CastOptions castOptions0 = optionsProvider0.getCastOptions(context1);
                    zzn zzn0 = new zzn(context1);
                    zzbf zzbf0 = new zzbf(context1, Q.d(context1), castOptions0, zzn0);
                    try {
                        CastContext.zzd = new CastContext(context1, castOptions0, optionsProvider0.getAdditionalSessionProviders(context1), zzbf0, zzn0);
                    }
                    catch(ModuleUnavailableException moduleUnavailableException0) {
                        throw new RuntimeException(moduleUnavailableException0);
                    }
                }
            }
            return CastContext.zzd;
        }
        return CastContext.zzd;
    }

    public static Task getSharedInstance(Context context0, Executor executor0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(CastContext.zzd == null) {
            Context context1 = context0.getApplicationContext();
            OptionsProvider optionsProvider0 = CastContext.zzg(context1);
            CastOptions castOptions0 = optionsProvider0.getCastOptions(context1);
            zzn zzn0 = new zzn(context1);
            return Tasks.call(executor0, new zzi(context1, castOptions0, optionsProvider0, new zzbf(context1, Q.d(context1), castOptions0, zzn0), zzn0));
        }
        return Tasks.forResult(CastContext.zzd);
    }

    @Deprecated
    public boolean isAppVisible() {
        return false;
    }

    @Deprecated
    public boolean onDispatchVolumeKeyEventBeforeJellyBean(KeyEvent keyEvent0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return false;
    }

    @Deprecated
    public void removeAppVisibilityListener(AppVisibilityListener appVisibilityListener0) {
    }

    public void removeCastStateListener(CastStateListener castStateListener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if(castStateListener0 == null) {
            return;
        }
        this.zzg.zzd(castStateListener0);
    }

    public void removeSessionTransferCallback(SessionTransferCallback sessionTransferCallback0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback0);
        this.zzm.zzs(sessionTransferCallback0);
    }

    public void setLaunchCredentialsData(CredentialsData credentialsData0) {
        Builder launchOptions$Builder0 = new Builder(this.zzk.getLaunchOptions());
        launchOptions$Builder0.setCredentialsData(credentialsData0);
        this.zzk.zzc(launchOptions$Builder0.build());
        this.zzi();
    }

    public void setReceiverApplicationId(String s) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        CastOptions castOptions0 = this.zzk;
        if(TextUtils.equals(s, castOptions0.getReceiverApplicationId())) {
            return;
        }
        castOptions0.zzd(s);
        this.zzi();
        Map map0 = this.zzh();
        try {
            this.zzf.zzi(s, map0);
        }
        catch(RemoteException remoteException0) {
            CastContext.zzb.d(remoteException0, "Unable to call %s on %s.", new Object[]{"setReceiverApplicationId", "zzaj"});
        }
        zzo zzo0 = new zzo();
        zzo0.zza(this.getCastReasonCodeForCastStatusCode(0x977));
        zzo0.zzb(0x977);
        zzq zzq0 = zzo0.zzc();
        zzdq.zza(this.zze, this.zzk, this.zza).zzi(zzq0);
        CastButtonFactory.zze(this.zze);
    }

    public static int zza(int v) {
        return CastContext.zzd == null ? 0 : CastContext.zzd.getCastReasonCodeForCastStatusCode(v);
    }

    public static CastContext zzb(Context context0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return CastContext.getSharedInstance(context0);
        }
        catch(RuntimeException runtimeException0) {
            CastContext.zzb.e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", new Object[]{runtimeException0});
            return null;
        }
    }

    public static CastContext zzc(Context context0, CastOptions castOptions0, OptionsProvider optionsProvider0, zzbf zzbf0, zzn zzn0) {
        synchronized(CastContext.zzc) {
            if(CastContext.zzd == null) {
                CastContext.zzd = new CastContext(context0, castOptions0, optionsProvider0.getAdditionalSessionProviders(context0), zzbf0, zzn0);
            }
        }
        return CastContext.zzd;
    }

    @ShowFirstParty
    public final zzac zzd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    public static void zze(CastContext castContext0, Bundle bundle0) {
        castContext0.zzr = new CastReasonCodes(bundle0);
    }

    public static void zzf(CastContext castContext0, Bundle bundle0) {
        if(!com.google.android.gms.internal.cast.zzh.zza) {
            return;
        }
        com.google.android.gms.internal.cast.zzh.zza(castContext0.zze, castContext0.zzl, castContext0.zzg, castContext0.zzp, castContext0.zza).zzc(bundle0);
    }

    private static OptionsProvider zzg(Context context0) {
        try {
            Bundle bundle0 = Wrappers.packageManager(context0).getApplicationInfo("com.iloen.melon", 0x80).metaData;
            if(bundle0 == null) {
                CastContext.zzb.e("Bundle is null", new Object[0]);
            }
            String s = bundle0.getString("com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
            if(s == null) {
                throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
            }
            return (OptionsProvider)Class.forName(s).asSubclass(OptionsProvider.class).getDeclaredConstructor(null).newInstance(null);
        }
        catch(PackageManager.NameNotFoundException | ClassNotFoundException | NullPointerException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException exception0) {
            throw new IllegalStateException("Failed to initialize CastContext.", exception0);
        }
    }

    private final Map zzh() {
        Map map0 = new HashMap();
        zzai zzai0 = this.zzq;
        if(zzai0 != null) {
            ((HashMap)map0).put(zzai0.getCategory(), zzai0.zza());
        }
        List list0 = this.zzo;
        if(list0 != null) {
            for(Object object0: list0) {
                Preconditions.checkNotNull(((SessionProvider)object0), "Additional SessionProvider must not be null.");
                String s = Preconditions.checkNotEmpty(((SessionProvider)object0).getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!((HashMap)map0).containsKey(s), "SessionProvider for category " + s + " already added");
                ((HashMap)map0).put(s, ((SessionProvider)object0).zza());
            }
        }
        return map0;
    }

    @RequiresNonNull({"castOptions", "mediaRouter", "appContext"})
    private final void zzi() {
        CastOptions castOptions0 = this.zzk;
        if(!TextUtils.isEmpty(castOptions0.getReceiverApplicationId())) {
            this.zzq = new zzai(this.zze, castOptions0, this.zzm);
            return;
        }
        this.zzq = null;
    }
}

