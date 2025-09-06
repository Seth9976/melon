package Xb;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.melon.ui.popup.b;
import kotlin.jvm.internal.q;
import ob.z;
import pd.d;
import vd.E;

public final class i implements j {
    public final String a;

    public i(String s) {
        this.a = s;
    }

    @Override  // Xb.j
    public final void a(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        this.c(d0);
    }

    @Override  // Xb.j
    public final void b(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        this.c(d0);
    }

    public final void c(d d0) {
        Activity activity0 = d0.getActivity();
        q.e(activity0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        b.d(b.a, ((AppCompatActivity)activity0).getSupportFragmentManager(), "재생 실패", this.a, false, true, false, null, E.b, null, null, null, 0x768);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? q.b(this.a, ((i)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "PlaybackErrorEvent(message=" + this.a + ")";
    }
}

