package m8;

import Q1.c;
import Tf.v;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.log.LogU;
import k8.t;

public final class a extends Bf.a {
    @Override  // Bf.a
    public final String W0() {
        return "home";
    }

    @Override  // Bf.a
    public final String Z0() {
        return "";
    }

    public static void r1(String s) {
        if(!v.r0(s, "http://", false) && !v.r0(s, "https://", false)) {
            if(v.r0(s, "melonapp", false)) {
                try {
                    Intent intent0 = new Intent();
                    c.Y(intent0, "android.intent.action.VIEW", false);
                    intent0.setData(Uri.parse(s));
                    intent0.addFlags(0x10000000);
                    MelonAppBase.Companion.getClass();
                    t.a().getContext().startActivity(intent0);
                    return;
                }
                catch(ActivityNotFoundException activityNotFoundException0) {
                    LogU.Companion.e("Home.kt", activityNotFoundException0.toString());
                }
            }
            return;
        }
        MelonLinkExecutor.open(s);
    }
}

