package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Build;
import com.google.android.apps.common.proguard.SideEffectFree;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

@KeepForSdk
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;
    private static Boolean zzm;
    private static Boolean zzn;
    private static Boolean zzo;
    private static Boolean zzp;
    private static Boolean zzq;

    @SideEffectFree
    @KeepForSdk
    public static boolean isAuto(Context context0) {
        return DeviceProperties.zze(context0.getPackageManager());
    }

    @SideEffectFree
    @KeepForSdk
    public static boolean isBstar(Context context0) {
        boolean z = false;
        if(DeviceProperties.zzo == null) {
            if(context0.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z = true;
            }
            DeviceProperties.zzo = Boolean.valueOf(z);
        }
        return DeviceProperties.zzo.booleanValue();
    }

    @KeepForSdk
    public static boolean isFoldable(Context context0) {
        boolean z = false;
        if(DeviceProperties.zzd == null) {
            if(context0.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
                z = true;
            }
            DeviceProperties.zzd = Boolean.valueOf(z);
        }
        return DeviceProperties.zzd.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(Context context0) {
        if(DeviceProperties.zzh == null) {
            PackageManager packageManager0 = context0.getPackageManager();
            DeviceProperties.zzh = Boolean.valueOf(packageManager0.hasSystemFeature("com.google.android.feature.services_updater") && packageManager0.hasSystemFeature("cn.google.services"));
        }
        return DeviceProperties.zzh.booleanValue();
    }

    @KeepForSdk
    public static boolean isPhone(Context context0) {
        boolean z = true;
        if(DeviceProperties.zza == null) {
            if(!DeviceProperties.isFoldable(context0)) {
                if(DeviceProperties.isTablet(context0) || DeviceProperties.isWearable(context0) || DeviceProperties.zzd(context0)) {
                    z = false;
                }
                else {
                    if(DeviceProperties.zzk == null) {
                        DeviceProperties.zzk = Boolean.valueOf(context0.getPackageManager().hasSystemFeature("org.chromium.arc"));
                    }
                    if(DeviceProperties.zzk.booleanValue() || DeviceProperties.isAuto(context0) || DeviceProperties.isTv(context0)) {
                        z = false;
                    }
                    else {
                        if(DeviceProperties.zzn == null) {
                            DeviceProperties.zzn = Boolean.valueOf(context0.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                        }
                        if(DeviceProperties.zzn.booleanValue() || DeviceProperties.isBstar(context0) || DeviceProperties.isXr(context0)) {
                            z = false;
                        }
                        else {
                            if(DeviceProperties.zzq == null) {
                                DeviceProperties.zzq = Boolean.valueOf(context0.getPackageManager().hasSystemFeature("com.google.desktop.gms"));
                            }
                            if(DeviceProperties.zzq.booleanValue()) {
                                z = false;
                            }
                        }
                    }
                }
            }
            DeviceProperties.zza = Boolean.valueOf(z);
        }
        return DeviceProperties.zza.booleanValue();
    }

    @KeepForSdk
    public static boolean isPhoneGo(Context context0) {
        boolean z = false;
        if(context0 == null) {
            return false;
        }
        if(DeviceProperties.zzb == null) {
            if(DeviceProperties.isPhone(context0)) {
                if(DeviceProperties.zzi == null) {
                    ActivityManager activityManager0 = (ActivityManager)context0.getSystemService("activity");
                    if(activityManager0 != null) {
                        DeviceProperties.zzi = Boolean.valueOf(activityManager0.isLowRamDevice());
                    }
                }
                if(Objects.equal(DeviceProperties.zzi, Boolean.TRUE) && Build.VERSION.SDK_INT >= 27) {
                    z = true;
                }
            }
            DeviceProperties.zzb = Boolean.valueOf(z);
        }
        return DeviceProperties.zzb.booleanValue();
    }

    @KeepForSdk
    public static boolean isSevenInchTablet(Context context0) {
        return DeviceProperties.zza(context0.getResources());
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean isSidewinder(Context context0) {
        return DeviceProperties.zzc(context0);
    }

    @KeepForSdk
    public static boolean isTablet(Context context0) {
        return DeviceProperties.isTablet(context0.getResources());
    }

    @KeepForSdk
    public static boolean isTablet(Resources resources0) {
        boolean z = false;
        if(resources0 == null) {
            return false;
        }
        if(DeviceProperties.zzc == null) {
            if((resources0.getConfiguration().screenLayout & 15) > 3) {
                z = true;
            }
            else if(DeviceProperties.zza(resources0)) {
                z = true;
            }
            DeviceProperties.zzc = Boolean.valueOf(z);
        }
        return DeviceProperties.zzc.booleanValue();
    }

    @SideEffectFree
    @KeepForSdk
    public static boolean isTv(Context context0) {
        return DeviceProperties.zzf(context0.getPackageManager());
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    @SideEffectFree
    @KeepForSdk
    public static boolean isWearable(Context context0) {
        return DeviceProperties.zzb(context0.getPackageManager());
    }

    // 去混淆评级： 低(25)
    @TargetApi(26)
    @KeepForSdk
    public static boolean isWearableWithoutPlayStore(Context context0) {
        boolean z = !DeviceProperties.isWearable(context0);
        return DeviceProperties.zzc(context0);
    }

    @SideEffectFree
    @KeepForSdk
    public static boolean isXr(Context context0) {
        return DeviceProperties.zzg(context0.getPackageManager());
    }

    public static boolean zza(Resources resources0) {
        boolean z = false;
        if(resources0 == null) {
            return false;
        }
        if(DeviceProperties.zze == null) {
            Configuration configuration0 = resources0.getConfiguration();
            if((configuration0.screenLayout & 15) <= 3 && configuration0.smallestScreenWidthDp >= 600) {
                z = true;
            }
            DeviceProperties.zze = Boolean.valueOf(z);
        }
        return DeviceProperties.zze.booleanValue();
    }

    @TargetApi(20)
    @SideEffectFree
    public static boolean zzb(PackageManager packageManager0) {
        if(DeviceProperties.zzf == null) {
            DeviceProperties.zzf = Boolean.valueOf(packageManager0.hasSystemFeature("android.hardware.type.watch"));
        }
        return DeviceProperties.zzf.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzc(Context context0) {
        if(DeviceProperties.zzg == null) {
            DeviceProperties.zzg = Boolean.valueOf(context0.getPackageManager().hasSystemFeature("cn.google"));
        }
        return DeviceProperties.zzg.booleanValue();
    }

    public static boolean zzd(Context context0) {
        if(DeviceProperties.zzj == null) {
            DeviceProperties.zzj = Boolean.valueOf(context0.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return DeviceProperties.zzj.booleanValue();
    }

    @SideEffectFree
    public static boolean zze(PackageManager packageManager0) {
        boolean z = false;
        if(DeviceProperties.zzl == null) {
            if(packageManager0.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            DeviceProperties.zzl = Boolean.valueOf(z);
        }
        return DeviceProperties.zzl.booleanValue();
    }

    @SideEffectFree
    public static boolean zzf(PackageManager packageManager0) {
        boolean z = true;
        if(DeviceProperties.zzm == null) {
            if(!packageManager0.hasSystemFeature("com.google.android.tv") && !packageManager0.hasSystemFeature("android.hardware.type.television") && !packageManager0.hasSystemFeature("android.software.leanback") && !packageManager0.hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")) {
                z = false;
            }
            DeviceProperties.zzm = Boolean.valueOf(z);
        }
        return DeviceProperties.zzm.booleanValue();
    }

    @SideEffectFree
    public static boolean zzg(PackageManager packageManager0) {
        if(DeviceProperties.zzp == null) {
            DeviceProperties.zzp = Boolean.valueOf(packageManager0.hasSystemFeature("android.software.xr.api.spatial"));
        }
        return DeviceProperties.zzp.booleanValue();
    }
}

