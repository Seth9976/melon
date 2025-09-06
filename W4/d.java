package w4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.PackageInfoFlags;
import android.content.pm.PackageManager;

public abstract class d {
    public static PackageInfo a(PackageManager packageManager0, Context context0) {
        return packageManager0.getPackageInfo("com.iloen.melon", PackageManager.PackageInfoFlags.of(0L));
    }
}

