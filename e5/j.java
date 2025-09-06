package e5;

import U4.w;
import android.content.ComponentName;
import android.content.Context;

public abstract class j {
    public static final String a;

    static {
        j.a = "WM-PackageManagerHelper";
    }

    public static void a(Context context0, Class class0, boolean z) {
        String s = "disabled";
        try {
            int v = context0.getPackageManager().getComponentEnabledSetting(new ComponentName(context0, class0.getName()));
            if(z == (v != 0 && v == 1)) {
                w.e().a("WM-PackageManagerHelper", "Skipping component enablement for " + class0.getName());
                return;
            }
            context0.getPackageManager().setComponentEnabledSetting(new ComponentName(context0, class0.getName()), (z ? 1 : 2), 1);
            w.e().a("WM-PackageManagerHelper", class0.getName() + " " + (z ? "enabled" : "disabled"));
            return;
        }
        catch(Exception exception0) {
        }
        w w0 = w.e();
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(class0.getName());
        stringBuilder0.append("could not be ");
        if(z) {
            s = "enabled";
        }
        stringBuilder0.append(s);
        w0.b("WM-PackageManagerHelper", stringBuilder0.toString(), exception0);
    }
}

