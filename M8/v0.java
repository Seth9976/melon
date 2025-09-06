package m8;

import Bf.a;
import android.app.Activity;
import androidx.fragment.app.I;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import k8.Y;

public final class v0 extends a {
    @Override  // Bf.a
    public final String W0() {
        return "webview";
    }

    @Override  // Bf.a
    public final String Z0() {
        return "";
    }

    public static void r1(Activity activity0, String s, String s1, String s2, String s3, NameValuePairList nameValuePairList0) {
        if(!(activity0 instanceof BaseActivity)) {
            return;
        }
        Y.w("WebView > type: ", s1, LogU.Companion, "WebView.kt");
        if("B".equalsIgnoreCase(s2) || "Y".equalsIgnoreCase(s2)) {
            I i0 = ((BaseActivity)activity0).getCurrentFragment();
            MelonWebViewFragment melonWebViewFragment0 = i0 instanceof MelonWebViewFragment ? ((MelonWebViewFragment)i0) : null;
            if(melonWebViewFragment0 != null) {
                melonWebViewFragment0.navigateBack();
            }
        }
        if(s1 != null) {
            int v = 1;
            switch(s1) {
                case "BA": {
                    if(s3 != null) {
                        v = true ^ "GET".equals(s3);
                    }
                    Navigator.openUrl(null, s, OpenType.FullScreenBlank, nameValuePairList0, ((boolean)v));
                    return;
                }
                case "CA": {
                    Navigator.openUrl(s, OpenType.FullScreen, nameValuePairList0);
                    return;
                }
                case "activity": {
                    Navigator.openUrl(s, OpenType.FullScreenWithMiniPlayer, nameValuePairList0);
                    return;
                }
            }
        }
        if(s1 == null) {
            s1 = "IA";
        }
        MelonLinkExecutor.open(s1, s);
    }
}

