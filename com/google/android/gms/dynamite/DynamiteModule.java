package com.google.android.gms.dynamite;

import T4.d;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import jeb.synthetic.FIN;

@KeepForSdk
public final class DynamiteModule {
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;

    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        public LoadingException(String s, Throwable throwable0, byte[] arr_b) {
            super(s, throwable0);
        }

        public LoadingException(String s, byte[] arr_b) {
            super(s);
        }
    }

    public interface VersionPolicy {
        @KeepForSdk
        public interface IVersions {
            int zza(Context arg1, String arg2, boolean arg3);

            int zzb(Context arg1, String arg2);
        }

        @KeepForSdk
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion;
            @KeepForSdk
            public int remoteVersion;
            @KeepForSdk
            public int selection;

            public SelectionResult() {
                this.localVersion = 0;
                this.remoteVersion = 0;
                this.selection = 0;
            }
        }

        @KeepForSdk
        SelectionResult selectModule(Context arg1, String arg2, IVersions arg3);
    }

    @KeepForSdk
    public static final int LOCAL = -1;
    @KeepForSdk
    public static final int NONE = 0;
    @KeepForSdk
    public static final int NO_SELECTION = 0;
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = null;
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = null;
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = null;
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = null;
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = null;
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = null;
    @KeepForSdk
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = null;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg;
    private static final ThreadLocal zzh;
    private static final IVersions zzi;
    private final Context zzj;
    private static zzo zzk;
    private static zzp zzl;

    static {
        DynamiteModule.zzg = new ThreadLocal();
        DynamiteModule.zzh = new zzd();
        DynamiteModule.zzi = new zze();
        DynamiteModule.PREFER_REMOTE = new zzf();
        DynamiteModule.PREFER_LOCAL = new zzg();
        DynamiteModule.PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
        DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
        DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
        DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
        DynamiteModule.zza = new zzl();
    }

    private DynamiteModule(Context context0) {
        Preconditions.checkNotNull(context0);
        this.zzj = context0;
    }

    @KeepForSdk
    public static int getLocalVersion(Context context0, String s) {
        try {
            Class class0 = context0.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + s + ".ModuleDescriptor");
            Field field0 = class0.getDeclaredField("MODULE_ID");
            Field field1 = class0.getDeclaredField("MODULE_VERSION");
            if(!Objects.equal(field0.get(null), s)) {
                Log.e("DynamiteModule", "Module descriptor id \'" + field0.get(null) + "\' didn\'t match expected id \'" + s + "\'");
                return 0;
            }
            return field1.getInt(null);
        }
        catch(ClassNotFoundException unused_ex) {
        }
        catch(Exception exception0) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: " + exception0.getMessage());
            return 0;
        }
        Log.w("DynamiteModule", "Local module descriptor class for " + s + " not found.");
        return 0;
    }

    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context0, String s) {
        return DynamiteModule.zza(context0, s, false);
    }

    @KeepForSdk
    public IBinder instantiate(String s) {
        try {
            return (IBinder)this.zzj.getClassLoader().loadClass(s).newInstance();
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException classNotFoundException0) {
            throw new LoadingException("Failed to instantiate module class: " + s, classNotFoundException0, null);
        }
    }

    @KeepForSdk
    public static DynamiteModule load(Context context0, VersionPolicy dynamiteModule$VersionPolicy0, String s) {
        zzp zzp0;
        DynamiteModule dynamiteModule1;
        IObjectWrapper iObjectWrapper0;
        IObjectWrapper iObjectWrapper1;
        int v2;
        DynamiteModule dynamiteModule0;
        SelectionResult dynamiteModule$VersionPolicy$SelectionResult0;
        Context context1 = context0.getApplicationContext();
        if(context1 == null) {
            throw new LoadingException("null application Context", null);
        }
        ThreadLocal threadLocal0 = DynamiteModule.zzg;
        zzm zzm0 = (zzm)threadLocal0.get();
        zzm zzm1 = new zzm(null);
        threadLocal0.set(zzm1);
        ThreadLocal threadLocal1 = DynamiteModule.zzh;
        Object object0 = threadLocal1.get();
        long v = (long)(((Long)object0));
        try {
            threadLocal1.set(SystemClock.uptimeMillis());
            dynamiteModule$VersionPolicy$SelectionResult0 = dynamiteModule$VersionPolicy0.selectModule(context0, s, DynamiteModule.zzi);
            Log.i("DynamiteModule", "Considering local module " + s + ":" + dynamiteModule$VersionPolicy$SelectionResult0.localVersion + " and remote module " + s + ":" + dynamiteModule$VersionPolicy$SelectionResult0.remoteVersion);
            int v1 = dynamiteModule$VersionPolicy$SelectionResult0.selection;
            if(v1 == 0) {
                throw new LoadingException("No acceptable module " + s + " found. Local version is " + dynamiteModule$VersionPolicy$SelectionResult0.localVersion + " and remote version is " + dynamiteModule$VersionPolicy$SelectionResult0.remoteVersion + ".", null);
            }
            if(v1 == -1) {
                if(dynamiteModule$VersionPolicy$SelectionResult0.localVersion == 0) {
                    throw new LoadingException("No acceptable module " + s + " found. Local version is " + dynamiteModule$VersionPolicy$SelectionResult0.localVersion + " and remote version is " + dynamiteModule$VersionPolicy$SelectionResult0.remoteVersion + ".", null);
                }
                v1 = -1;
            }
            if(v1 == 1 && dynamiteModule$VersionPolicy$SelectionResult0.remoteVersion == 0) {
                throw new LoadingException("No acceptable module " + s + " found. Local version is " + dynamiteModule$VersionPolicy$SelectionResult0.localVersion + " and remote version is " + dynamiteModule$VersionPolicy$SelectionResult0.remoteVersion + ".", null);
            }
            switch(v1) {
                case -1: {
                    dynamiteModule0 = DynamiteModule.zze(context1, s);
                    break;
                }
                case 1: {
                    goto label_31;
                }
                default: {
                    throw new LoadingException("VersionPolicy returned invalid code:" + v1, null);
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_113;
        }
        if(v == 0L) {
            threadLocal1.remove();
        }
        else {
            threadLocal1.set(((Long)object0));
        }
        Cursor cursor0 = zzm1.zza;
        if(cursor0 != null) {
            cursor0.close();
        }
        threadLocal0.set(zzm0);
        return dynamiteModule0;
        try {
        label_31:
            v2 = dynamiteModule$VersionPolicy$SelectionResult0.remoteVersion;
        }
        catch(Throwable throwable0) {
            goto label_113;
        }
        try {
            synchronized(DynamiteModule.class) {
                if(!DynamiteModule.zzb(context0)) {
                    throw new LoadingException("Remote loading disabled", null);
                }
                Boolean boolean0 = DynamiteModule.zzb;
            }
            if(boolean0 == null) {
                throw new LoadingException("Failed to determine which loading route to use.", null);
            }
            if(boolean0.booleanValue()) {
                Log.i("DynamiteModule", "Selected remote version of " + s + ", version >= " + v2);
                synchronized(DynamiteModule.class) {
                    zzp0 = DynamiteModule.zzl;
                }
                if(zzp0 == null) {
                    throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                }
                zzm zzm3 = (zzm)threadLocal0.get();
                if(zzm3 == null || zzm3.zza == null) {
                    throw new LoadingException("No result cursor", null);
                }
                Context context2 = context0.getApplicationContext();
                Cursor cursor1 = zzm3.zza;
                ObjectWrapper.wrap(null);
                synchronized(DynamiteModule.class) {
                    boolean z = DynamiteModule.zze >= 2;
                }
                if(z) {
                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                    iObjectWrapper1 = zzp0.zzf(ObjectWrapper.wrap(context2), s, v2, ObjectWrapper.wrap(cursor1));
                }
                else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                    iObjectWrapper1 = zzp0.zze(ObjectWrapper.wrap(context2), s, v2, ObjectWrapper.wrap(cursor1));
                }
                Context context3 = (Context)ObjectWrapper.unwrap(iObjectWrapper1);
                if(context3 == null) {
                    throw new LoadingException("Failed to get module context", null);
                }
                dynamiteModule1 = new DynamiteModule(context3);
            }
            else {
                Log.i("DynamiteModule", "Selected remote version of " + s + ", version >= " + v2);
                zzo zzo0 = DynamiteModule.zzg(context0);
                if(zzo0 == null) {
                    throw new LoadingException("Failed to create IDynamiteLoader.", null);
                }
                int v4 = zzo0.zzi();
                if(v4 >= 3) {
                    zzm zzm2 = (zzm)threadLocal0.get();
                    if(zzm2 == null) {
                        throw new LoadingException("No cached result cursor holder", null);
                    }
                    iObjectWrapper0 = zzo0.zzk(ObjectWrapper.wrap(context0), s, v2, ObjectWrapper.wrap(zzm2.zza));
                }
                else if(v4 == 2) {
                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                    iObjectWrapper0 = zzo0.zzg(ObjectWrapper.wrap(context0), s, v2);
                }
                else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                    iObjectWrapper0 = zzo0.zze(ObjectWrapper.wrap(context0), s, v2);
                }
                Object object1 = ObjectWrapper.unwrap(iObjectWrapper0);
                if(object1 == null) {
                    throw new LoadingException("Failed to load remote module.", null);
                }
                dynamiteModule1 = new DynamiteModule(((Context)object1));
            }
            goto label_122;
        }
        catch(RemoteException remoteException0) {
        }
        catch(LoadingException dynamiteModule$LoadingException0) {
            throw dynamiteModule$LoadingException0;
        }
        catch(Throwable throwable1) {
            goto label_104;
        }
        try {
            try {
                throw new LoadingException("Failed to load remote module.", remoteException0, null);
            label_104:
                CrashUtils.addDynamiteErrorToDropBox(context0, throwable1);
                throw new LoadingException("Failed to load remote module.", throwable1, null);
            }
            catch(LoadingException dynamiteModule$LoadingException1) {
            }
            Log.w("DynamiteModule", "Failed to load remote module: " + dynamiteModule$LoadingException1.getMessage());
            if(dynamiteModule$VersionPolicy$SelectionResult0.localVersion == 0 || dynamiteModule$VersionPolicy0.selectModule(context0, s, new zzn(dynamiteModule$VersionPolicy$SelectionResult0.localVersion, 0)).selection != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", dynamiteModule$LoadingException1, null);
            }
            dynamiteModule1 = DynamiteModule.zze(context1, s);
            goto label_122;
        label_113:
            if(v == 0L) {
                goto label_114;
            }
            else {
                goto label_116;
            }
            goto label_117;
        }
        catch(Throwable throwable0) {
            goto label_113;
        }
    label_114:
        DynamiteModule.zzh.remove();
        goto label_117;
    label_116:
        DynamiteModule.zzh.set(((Long)object0));
    label_117:
        Cursor cursor2 = zzm1.zza;
        if(cursor2 != null) {
            cursor2.close();
        }
        DynamiteModule.zzg.set(zzm0);
        throw throwable0;
    label_122:
        if(v == 0L) {
            DynamiteModule.zzh.remove();
        }
        else {
            DynamiteModule.zzh.set(((Long)object0));
        }
        Cursor cursor3 = zzm1.zza;
        if(cursor3 != null) {
            cursor3.close();
        }
        DynamiteModule.zzg.set(zzm0);
        return dynamiteModule1;
    }

    public static int zza(Context context0, String s, boolean z) {
        int v3;
        RemoteException remoteException1;
        Cursor cursor2;
        zzo zzo0;
        int v1;
        ClassLoader classLoader0;
        int v;
        Class class1;
        Field field0;
        Boolean boolean0;
        Cursor cursor0;
        Class class0;
        try {
            class0 = DynamiteModule.class;
            __monitor_enter(class0);
        }
        catch(Throwable throwable0) {
            goto label_118;
        }
        try {
            cursor0 = null;
            boolean0 = DynamiteModule.zzb;
            if(boolean0 == null) {
                try {
                    field0 = context0.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader").getDeclaredField("sClassLoader");
                    class1 = field0.getDeclaringClass();
                    __monitor_enter(class1);
                    v = FIN.finallyOpen$NT();
                    classLoader0 = (ClassLoader)field0.get(null);
                    if(classLoader0 == ClassLoader.getSystemClassLoader()) {
                        boolean0 = Boolean.FALSE;
                    }
                    else if(classLoader0 == null) {
                        if(!DynamiteModule.zzb(context0)) {
                            FIN.finallyExec$NT(v);
                            goto label_16;
                        }
                        goto label_18;
                    }
                    else {
                        goto label_49;
                    }
                    goto label_51;
                }
                catch(ClassNotFoundException | IllegalAccessException | NoSuchFieldException classNotFoundException0) {
                    goto label_54;
                }
            }
            goto label_61;
        }
        catch(Throwable throwable1) {
            goto label_59;
        }
        try {
        label_16:
            __monitor_exit(class0);
            return 0;
        }
        catch(Throwable throwable0) {
            goto label_118;
        }
        try {
        label_18:
            if(DynamiteModule.zzd || Boolean.TRUE.equals(null)) {
                field0.set(null, ClassLoader.getSystemClassLoader());
                boolean0 = Boolean.FALSE;
                goto label_51;
            }
            try {
                v1 = DynamiteModule.zzc(context0, s, z, true);
                if(DynamiteModule.zzc != null && !DynamiteModule.zzc.isEmpty()) {
                    ClassLoader classLoader1 = zzb.zza();
                    if(classLoader1 == null) {
                        if(Build.VERSION.SDK_INT >= 29) {
                            String s1 = DynamiteModule.zzc;
                            Preconditions.checkNotNull(s1);
                            classLoader1 = d.c(ClassLoader.getSystemClassLoader(), s1);
                        }
                        else {
                            String s2 = DynamiteModule.zzc;
                            Preconditions.checkNotNull(s2);
                            classLoader1 = new zzc(s2, ClassLoader.getSystemClassLoader());
                        }
                    }
                    DynamiteModule.zzf(classLoader1);
                    field0.set(null, classLoader1);
                    DynamiteModule.zzb = Boolean.TRUE;
                    goto label_41;
                }
                goto label_46;
            }
            catch(LoadingException unused_ex) {
                field0.set(null, ClassLoader.getSystemClassLoader());
                boolean0 = Boolean.FALSE;
                goto label_51;
            }
        label_41:
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class1);
            FIN.finallyCodeEnd$NT(v);
        }
        catch(ClassNotFoundException | IllegalAccessException | NoSuchFieldException classNotFoundException0) {
            goto label_54;
        }
        catch(Throwable throwable1) {
            goto label_59;
        }
        try {
            __monitor_exit(class0);
            return v1;
        }
        catch(Throwable throwable0) {
            goto label_118;
        }
        try {
        label_46:
            FIN.finallyExec$NT(v);
        }
        catch(ClassNotFoundException | IllegalAccessException | NoSuchFieldException classNotFoundException0) {
            goto label_54;
        }
        catch(Throwable throwable1) {
            goto label_59;
        }
        try {
            __monitor_exit(class0);
            return v1;
        }
        catch(Throwable throwable0) {
            goto label_118;
        }
        try {
            try {
                try {
                label_49:
                    DynamiteModule.zzf(classLoader0);
                }
                catch(LoadingException unused_ex) {
                }
                boolean0 = Boolean.TRUE;
            label_51:
                FIN.finallyExec$NT(v);
            }
            catch(ClassNotFoundException | IllegalAccessException | NoSuchFieldException classNotFoundException0) {
            label_54:
                Log.w("DynamiteModule", "Failed to load module via V2: " + classNotFoundException0.toString());
                boolean0 = Boolean.FALSE;
            }
            DynamiteModule.zzb = boolean0;
            goto label_61;
        }
        catch(Throwable throwable1) {
            try {
            label_59:
                __monitor_exit(class0);
                throw throwable1;
            label_61:
                __monitor_exit(class0);
                if(!boolean0.booleanValue()) {
                    zzo0 = DynamiteModule.zzg(context0);
                    if(zzo0 != null) {
                        goto label_65;
                    }
                    return 0;
                }
                goto label_113;
            }
            catch(Throwable throwable0) {
                goto label_118;
            }
        }
        try {
        label_65:
            int v2 = zzo0.zzi();
            if(v2 < 3) {
                if(v2 == 2) {
                    Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                    return zzo0.zzh(ObjectWrapper.wrap(context0), s, z);
                }
                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                return zzo0.zzf(ObjectWrapper.wrap(context0), s, z);
            }
            zzm zzm0 = (zzm)DynamiteModule.zzg.get();
            if(zzm0 != null) {
                Cursor cursor1 = zzm0.zza;
                if(cursor1 != null) {
                    return cursor1.getInt(0);
                }
            }
            cursor2 = (Cursor)ObjectWrapper.unwrap(zzo0.zzj(ObjectWrapper.wrap(context0), s, z, ((long)(((Long)DynamiteModule.zzh.get())))));
            if(cursor2 != null) {
                goto label_83;
            label_81:
                remoteException1 = remoteException0;
                goto label_95;
            }
            goto label_90;
        }
        catch(RemoteException remoteException0) {
            goto label_81;
        }
        catch(Throwable throwable2) {
            goto label_99;
        }
        try {
        label_83:
            if(cursor2.moveToFirst()) {
                v3 = cursor2.getInt(0);
                if(v3 <= 0 || !DynamiteModule.zzd(cursor2)) {
                    goto label_86;
                }
                goto label_87;
            }
            goto label_90;
        }
        catch(RemoteException remoteException2) {
            goto label_93;
        }
        catch(Throwable throwable3) {
            goto label_104;
        }
    label_86:
        cursor0 = cursor2;
    label_87:
        if(cursor0 != null) {
            try {
                cursor0.close();
            }
            catch(Throwable throwable0) {
                goto label_118;
            }
        }
        return v3;
        try {
        label_90:
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            goto label_109;
        }
        catch(RemoteException remoteException2) {
        }
        catch(Throwable throwable3) {
            goto label_104;
        }
    label_93:
        remoteException1 = remoteException2;
        cursor0 = cursor2;
        try {
        label_95:
            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + remoteException1.getMessage());
            if(cursor0 != null) {
                goto label_101;
            }
            return 0;
        }
        catch(Throwable throwable2) {
            try {
            label_99:
                Throwable throwable4 = throwable2;
                goto label_106;
            label_101:
                cursor0.close();
                return 0;
            label_104:
                throwable4 = throwable3;
                cursor0 = cursor2;
            label_106:
                if(cursor0 != null) {
                    cursor0.close();
                }
                throw throwable4;
            label_109:
                if(cursor2 != null) {
                    cursor2.close();
                    return 0;
                }
                return 0;
                try {
                label_113:
                    return DynamiteModule.zzc(context0, s, z, false);
                }
                catch(LoadingException dynamiteModule$LoadingException0) {
                    Log.w("DynamiteModule", "Failed to retrieve remote module version: " + dynamiteModule$LoadingException0.getMessage());
                    return 0;
                }
            }
            catch(Throwable throwable0) {
            }
        }
    label_118:
        CrashUtils.addDynamiteErrorToDropBox(context0, throwable0);
        throw throwable0;
    }

    private static boolean zzb(Context context0) {
        boolean z = false;
        if(Boolean.TRUE.equals(null)) {
            return true;
        }
        if(Boolean.TRUE.equals(DynamiteModule.zzf)) {
            return true;
        }
        if(DynamiteModule.zzf == null) {
            ProviderInfo providerInfo0 = context0.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0x10000000);
            if(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context0, 10000000) == 0 && providerInfo0 != null && "com.google.android.gms".equals(providerInfo0.packageName)) {
                z = true;
            }
            DynamiteModule.zzf = Boolean.valueOf(z);
            if(z && (providerInfo0.applicationInfo != null && (providerInfo0.applicationInfo.flags & 0x81) == 0)) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                DynamiteModule.zzd = true;
            }
        }
        if(!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static int zzc(Context context0, String s, boolean z, boolean z1) {
        int v6;
        Throwable throwable1;
        Exception exception1;
        Cursor cursor2;
        boolean z3;
        boolean z2;
        Cursor cursor0 = null;
        try {
            long v = (long)(((Long)DynamiteModule.zzh.get()));
            String s1 = "api_force_staging";
            z2 = true;
            if(!z) {
                s1 = "api";
            }
            z3 = false;
            Uri uri0 = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(s1).appendPath(s).appendQueryParameter("requestStartUptime", String.valueOf(v)).build();
            ContentProviderClient contentProviderClient0 = context0.getContentResolver().acquireUnstableContentProviderClient(uri0);
            if(contentProviderClient0 != null) {
                try(Cursor cursor1 = contentProviderClient0.query(uri0, null, null, null, null)) {
                    if(cursor1 != null) {
                        int v2 = cursor1.getCount();
                        int v3 = cursor1.getColumnCount();
                        cursor2 = new MatrixCursor(cursor1.getColumnNames(), v2);
                        int v4 = 0;
                    alab1:
                        while(true) {
                            if(v4 >= v2) {
                                goto label_55;
                            }
                            if(!cursor1.moveToPosition(v4)) {
                                break;
                            }
                            Object[] arr_object = new Object[v3];
                            for(int v5 = 0; true; ++v5) {
                                if(v5 >= v3) {
                                    break;
                                }
                                switch(cursor1.getType(v5)) {
                                    case 0: {
                                        arr_object[v5] = null;
                                        break;
                                    }
                                    case 1: {
                                        arr_object[v5] = cursor1.getLong(v5);
                                        break;
                                    }
                                    case 2: {
                                        arr_object[v5] = cursor1.getDouble(v5);
                                        break;
                                    }
                                    case 3: {
                                        arr_object[v5] = cursor1.getString(v5);
                                        break;
                                    }
                                    case 4: {
                                        arr_object[v5] = cursor1.getBlob(v5);
                                        break;
                                    }
                                    default: {
                                        break alab1;
                                    }
                                }
                            }
                            ((MatrixCursor)cursor2).addRow(arr_object);
                            ++v4;
                        }
                        goto label_57;
                    label_55:
                        goto label_69;
                    }
                }
                catch(RemoteException unused_ex) {
                }
                finally {
                    contentProviderClient0.release();
                }
            }
        }
        catch(Exception exception0) {
            exception1 = exception0;
            cursor2 = null;
            goto label_97;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_103;
        }
    label_57:
        cursor2 = null;
        try {
            try {
            label_69:
                if(cursor2 == null || !cursor2.moveToFirst()) {
                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                    throw new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
                }
                v6 = cursor2.getInt(0);
                if(v6 > 0) {
                    Class class0 = DynamiteModule.class;
                    synchronized(class0) {
                        DynamiteModule.zzc = cursor2.getString(2);
                        int v7 = cursor2.getColumnIndex("loaderVersion");
                        if(v7 >= 0) {
                            DynamiteModule.zze = cursor2.getInt(v7);
                        }
                        int v8 = cursor2.getColumnIndex("disableStandaloneDynamiteLoader2");
                        if(v8 >= 0) {
                            if(cursor2.getInt(v8) == 0) {
                                z2 = false;
                            }
                            DynamiteModule.zzd = z2;
                            z3 = z2;
                        }
                    }
                    if(DynamiteModule.zzd(cursor2)) {
                        cursor2 = null;
                    }
                }
                if(z1 && z3) {
                    throw new LoadingException("forcing fallback to container DynamiteLoader impl", null);
                }
                goto label_106;
            }
            catch(Exception exception2) {
                exception1 = exception2;
            }
        label_97:
            if(!(exception1 instanceof LoadingException)) {
                throw new LoadingException("V2 version check failed: " + exception1.getMessage(), exception1, null);
            }
            throw exception1;
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            cursor0 = cursor2;
        }
    label_103:
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_106:
        if(cursor2 != null) {
            cursor2.close();
        }
        return v6;
    }

    private static boolean zzd(Cursor cursor0) {
        zzm zzm0 = (zzm)DynamiteModule.zzg.get();
        if(zzm0 != null && zzm0.zza == null) {
            zzm0.zza = cursor0;
            return true;
        }
        return false;
    }

    private static DynamiteModule zze(Context context0, String s) {
        Log.i("DynamiteModule", "Selected local version of " + s);
        return new DynamiteModule(context0);
    }

    private static void zzf(ClassLoader classLoader0) {
        zzp zzp0;
        try {
            IBinder iBinder0 = (IBinder)classLoader0.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if(iBinder0 == null) {
                zzp0 = null;
            }
            else {
                IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzp0 = iInterface0 instanceof zzp ? ((zzp)iInterface0) : new zzp(iBinder0);
            }
            DynamiteModule.zzl = zzp0;
            return;
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException classNotFoundException0) {
        }
        throw new LoadingException("Failed to instantiate dynamite loader", classNotFoundException0, null);
    }

    private static zzo zzg(Context context0) {
        zzo zzo1;
        synchronized(DynamiteModule.class) {
            zzo zzo0 = DynamiteModule.zzk;
            if(zzo0 != null) {
                return zzo0;
            }
            try {
                IBinder iBinder0 = (IBinder)context0.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if(iBinder0 == null) {
                    zzo1 = null;
                }
                else {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzo1 = iInterface0 instanceof zzo ? ((zzo)iInterface0) : new zzo(iBinder0);
                }
                if(zzo1 != null) {
                    DynamiteModule.zzk = zzo1;
                    return zzo1;
                }
            }
            catch(Exception exception0) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + exception0.getMessage());
            }
            return null;
        }
    }
}

