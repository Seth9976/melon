package m8;

import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.DialogClose;
import com.iloen.melon.utils.log.LogU;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public abstract class p0 {
    public static void a(BaseActivity baseActivity0, Uri uri0) {
        if(baseActivity0 != null) {
            String s = uri0.getPath();
            if(s != null) {
                switch(s) {
                    case "/expire": {
                        LogU.Companion.d("Token", "path : Expire.PATH");
                        r0 r00 = new r0();
                        r00.i1(uri0);
                        EventBusHelper.post(new DialogClose());
                        BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new q0(r00, baseActivity0, null), 3, null);
                        break;
                    }
                    case "/login/error": {
                        LogU.Companion.d("Token", "path : Login.Error.PATH");
                        String s1 = uri0.getQueryParameter("userId");
                        t0 t00 = new t0();
                        BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new s0(s1, t00, baseActivity0, null), 3, null);
                    }
                }
            }
        }
    }
}

