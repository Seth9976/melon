package v2;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import e1.F;

public final class b extends F {
    @Override  // e1.F
    public final Signature[] s(PackageManager packageManager0, String s) {
        return packageManager0.getPackageInfo(s, 0x40).signatures;
    }
}

