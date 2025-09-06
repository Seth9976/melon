package androidx.media3.session.legacy;

import X2.h;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

public final class q extends u {
    public final h f;
    public final Bundle g;

    public q(s s0, String s1, h h0, Bundle bundle0) {
        this.f = h0;
        this.g = bundle0;
        super(s1);
    }

    @Override  // androidx.media3.session.legacy.u
    public final void a() {
        this.f.b.detach();
    }

    @Override  // androidx.media3.session.legacy.u
    public final void d(Object object0) {
        List list0 = (List)object0;
        h h0 = this.f;
        if(list0 == null) {
            h0.a(null);
            return;
        }
        if((this.e & 1) != 0) {
            list0 = MediaBrowserServiceCompat.a(list0, this.g);
        }
        ArrayList arrayList0 = new ArrayList((list0 == null ? 0 : list0.size()));
        if(list0 != null) {
            for(Object object1: list0) {
                Parcel parcel0 = Parcel.obtain();
                ((MediaBrowserCompat.MediaItem)object1).writeToParcel(parcel0, 0);
                arrayList0.add(parcel0);
            }
        }
        h0.a(arrayList0);
    }
}

