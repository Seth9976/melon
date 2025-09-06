package Xb;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.melon.ui.popup.b;
import kotlin.jvm.internal.q;
import ob.z;
import pd.d;
import vd.E;

public final class f implements j {
    public final String a;

    public f(String s) {
        this.a = s;
    }

    @Override  // Xb.j
    public final void a(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        this.c(d0, z0);
    }

    @Override  // Xb.j
    public final void b(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        this.c(d0, z0);
    }

    public final void c(d d0, z z0) {
        Activity activity0 = d0.getActivity();
        q.e(activity0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Nc.f f0 = new Nc.f(z0, 23);
        b.x(((AppCompatActivity)activity0).getSupportFragmentManager(), "중복 스트리밍 알림", this.a, false, true, null, null, f0, null, null, E.b, 0x6E8);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? q.b(this.a, ((f)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "MultiStreamingEvent(message=" + this.a + ")";
    }
}

