package T4;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.webkit.WebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i extends c {
    public final Pattern d;

    public i() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.d = Pattern.compile("\\A\\d+");
    }

    @Override  // T4.c
    public final boolean a() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override  // T4.c
    public final boolean b() {
        boolean z = super.b();
        if(z && Build.VERSION.SDK_INT < 29) {
            PackageInfo packageInfo0 = WebView.getCurrentWebViewPackage();
            if(packageInfo0 == null) {
                return false;
            }
            Matcher matcher0 = this.d.matcher(packageInfo0.versionName);
            return matcher0.find() && Integer.parseInt(packageInfo0.versionName.substring(matcher0.start(), matcher0.end())) >= 105;
        }
        return z;
    }
}

