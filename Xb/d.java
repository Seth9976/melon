package Xb;

import android.app.Activity;
import com.iloen.melon.popup.PopupHelper;
import d5.w;
import kotlin.jvm.internal.q;
import ob.z;

public final class d implements j {
    public final String a;
    public final String b;

    public d(String s, String s1) {
        q.g(s, "mediaId");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override  // Xb.j
    public final void a(pd.d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
    }

    @Override  // Xb.j
    public final void b(pd.d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        w.v(d0);
        Activity activity0 = d0.getActivity();
        a a0 = new a(0);
        PopupHelper.showAlertPopup(activity0, "안내", this.b, a0).setOnDismissListener(new b(d0, this));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "DeletedTrackZeroEvent(mediaId=" + this.a + ", message=" + this.b + ")";
    }
}

