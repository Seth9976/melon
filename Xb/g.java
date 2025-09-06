package Xb;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.b;
import kotlin.jvm.internal.q;
import ob.z;
import pd.d;
import vd.O;

public final class g implements j {
    public final String a;

    public g(String s) {
        this.a = s;
    }

    @Override  // Xb.j
    public final void a(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        String s = this.a;
        if(s.length() > 0) {
            ToastManager.show(s);
            return;
        }
        ToastManager.show(0x7F130617);  // string:melon_logout_show_content_no_auth_toast "전곡 듣기는 로그인 후 이용권 권한에 따라 이용하실 수 있습니다."
    }

    @Override  // Xb.j
    public final void b(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        Activity activity0 = d0.getActivity();
        q.e(activity0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        b.m(((AppCompatActivity)activity0).getSupportFragmentManager(), O.b, this.a, "");
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g ? q.b(this.a, ((g)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NoLoginNoticeEvent(message=" + this.a + ")";
    }
}

