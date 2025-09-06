package m8;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.SchemeAllowedUrlManager.Callback;
import com.iloen.melon.utils.SchemeAllowedUrlManager.SERVER_STATE;
import com.iloen.melon.utils.SchemeAllowedUrlManager;
import com.melon.ui.popup.b;

public final class u0 implements Callback {
    public final SchemeAllowedUrlManager a;
    public final String b;
    public final Activity c;
    public final String d;
    public final String e;
    public final String f;
    public final NameValuePairList g;

    public u0(SchemeAllowedUrlManager schemeAllowedUrlManager0, String s, Activity activity0, v0 v00, String s1, String s2, String s3, NameValuePairList nameValuePairList0) {
        this.a = schemeAllowedUrlManager0;
        this.b = s;
        this.c = activity0;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = nameValuePairList0;
    }

    @Override  // com.iloen.melon.utils.SchemeAllowedUrlManager$Callback
    public final void callback(SERVER_STATE schemeAllowedUrlManager$SERVER_STATE0) {
        l0 l00 = null;
        String s = this.b;
        boolean z = this.a.isAllowedUrl(s);
        Activity activity0 = this.c;
        if(!z) {
            AppCompatActivity appCompatActivity0 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
            if(appCompatActivity0 != null) {
                l00 = appCompatActivity0.getSupportFragmentManager();
            }
            b.d(b.a, l00, null, "잘못된 접근입니다.", false, false, false, null, null, null, null, null, 2040);
            return;
        }
        v0.r1(activity0, s, this.d, this.e, this.f, this.g);
    }
}

