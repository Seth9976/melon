package androidx.media3.session.legacy;

import X2.h;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

public final class o extends u {
    public final int f;
    public final Object g;

    public o(int v, Object object0, Object object1) {
        this.f = v;
        this.g = object1;
        super(object0);
    }

    @Override  // androidx.media3.session.legacy.u
    public void a() {
        switch(this.f) {
            case 0: {
                ((h)this.g).b.detach();
                return;
            }
            case 1: {
                ((h)this.g).b.detach();
                return;
            }
            default: {
                super.a();
            }
        }
    }

    @Override  // androidx.media3.session.legacy.u
    public void c() {
        if(this.f != 2) {
            super.c();
            return;
        }
        ((ResultReceiver)this.g).send(-1, null);
    }

    @Override  // androidx.media3.session.legacy.u
    public final void d(Object object0) {
        ArrayList arrayList0;
        switch(this.f) {
            case 0: {
                if(((List)object0) == null) {
                    arrayList0 = null;
                }
                else {
                    ArrayList arrayList1 = new ArrayList(((List)object0).size());
                    for(Object object1: ((List)object0)) {
                        Parcel parcel0 = Parcel.obtain();
                        ((MediaBrowserCompat.MediaItem)object1).writeToParcel(parcel0, 0);
                        arrayList1.add(parcel0);
                    }
                    arrayList0 = arrayList1;
                }
                ((h)this.g).a(arrayList0);
                return;
            }
            case 1: {
                h h0 = (h)this.g;
                if(((MediaBrowserCompat.MediaItem)object0) == null) {
                    h0.a(null);
                    return;
                }
                Parcel parcel1 = Parcel.obtain();
                ((MediaBrowserCompat.MediaItem)object0).writeToParcel(parcel1, 0);
                h0.a(parcel1);
                return;
            }
            default: {
                ((ResultReceiver)this.g).send(0, ((Bundle)object0));
            }
        }
    }
}

