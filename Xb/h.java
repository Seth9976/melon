package Xb;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.b;
import kotlin.jvm.internal.q;
import ob.z;
import pd.d;
import vd.O;

public final class h implements j {
    public final String a;
    public final String b;

    public h(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override  // Xb.j
    public final void a(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        String s = this.a;
        if(s.length() > 0) {
            ToastManager.show(s);
        }
    }

    @Override  // Xb.j
    public final void b(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        Activity activity0 = d0.getActivity();
        q.e(activity0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        b.m(((AppCompatActivity)activity0).getSupportFragmentManager(), O.c, this.a, this.b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        return q.b(this.a, ((h)object0).a) ? q.b(this.b, ((h)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "NoProductNoticeEvent(message=" + this.a + ", link=" + this.b + ")";
    }
}

