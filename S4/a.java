package S4;

import I7.c;
import T4.h;
import T4.l;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public abstract class a {
    public static c a(WebSettings webSettings0) {
        try {
            InvocationHandler invocationHandler0 = ((WebkitToCompatConverterBoundaryInterface)l.a.b).convertSettings(webSettings0);
            return new c(((WebSettingsBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebSettingsBoundaryInterface.class, invocationHandler0)), 24);
        }
        catch(ClassCastException classCastException0) {
            if(Build.VERSION.SDK_INT != 30 || !"android.webkit.WebSettingsWrapper".equals(webSettings0.getClass().getCanonicalName())) {
                throw classCastException0;
            }
            Log.e("WebSettingsCompat", "Error converting WebSettings to Chrome implementation. All AndroidX method calls on this WebSettings instance will be no-op calls. See https://crbug.com/388824130 for more info.", classCastException0);
            return new h(null, 24);  // 初始化器: LI7/c;-><init>(Ljava/lang/Object;I)V
        }
    }
}

