package A6;

import A3.l;
import Kc.g;
import M6.t;
import W5.e;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Builder;
import androidx.media3.session.t0;
import androidx.media3.session.y0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import e3.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;

public final class i implements t {
    public final int a;
    public boolean b;
    public int c;
    public final Object d;
    public final Object e;

    public i(int v, NotificationCompat.Builder notificationCompat$Builder0, e e0) {
        this.a = 2;
        super();
        this.c = v;
        this.d = notificationCompat$Builder0;
        this.e = e0;
    }

    public i(Parcel parcel0) {
        this.a = 1;
        q.g(parcel0, "parcel");
        super();
        int v = parcel0.readInt();
        long[] arr_v = new long[v];
        this.d = arr_v;
        parcel0.readLongArray(arr_v);
        Parcelable.Creator parcelable$Creator0 = RemoteViews.CREATOR;
        q.f(parcelable$Creator0, "CREATOR");
        RemoteViews[] arr_remoteViews = new RemoteViews[v];
        parcel0.readTypedArray(arr_remoteViews, parcelable$Creator0);
        boolean z = false;
        for(int v1 = 0; v1 < v; ++v1) {
            if(arr_remoteViews[v1] == null) {
                throw new IllegalArgumentException("null element found in " + arr_remoteViews + '.');
            }
        }
        this.e = arr_remoteViews;
        if(parcel0.readInt() == 1) {
            z = true;
        }
        this.b = z;
        this.c = parcel0.readInt();
    }

    public i(BottomSheetBehavior bottomSheetBehavior0) {
        this.a = 4;
        super();
        this.e = bottomSheetBehavior0;
        this.d = new E9.t(this, 20);
    }

    public i(SideSheetBehavior sideSheetBehavior0) {
        this.a = 0;
        super();
        this.e = sideSheetBehavior0;
        this.d = new l(this, 1);
    }

    public i(boolean z, int v, String s, Bundle bundle0) {
        this.a = 3;
        super();
        this.b = z;
        this.c = v;
        this.d = s;
        if(bundle0 == null) {
            bundle0 = Bundle.EMPTY;
        }
        this.e = bundle0;
    }

    public i(long[] arr_v, RemoteViews[] arr_remoteViews) {
        this.a = 1;
        super();
        this.d = arr_v;
        this.e = arr_remoteViews;
        this.b = false;
        this.c = 1;
        if(arr_v.length != arr_remoteViews.length) {
            throw new IllegalArgumentException("RemoteCollectionItems has different number of ids and views");
        }
        ArrayList arrayList0 = new ArrayList(arr_remoteViews.length);
        for(int v = 0; v < arr_remoteViews.length; ++v) {
            arrayList0.add(arr_remoteViews[v].getLayoutId());
        }
        int v1 = p.e0(arrayList0).size();
        if(v1 > 1) {
            throw new IllegalArgumentException(("View type count is set to 1, but the collection contains " + v1 + " different layout ids").toString());
        }
    }

    public void a(int v) {
        Object object0 = this.d;
        Object object1 = this.e;
        if(this.a != 0) {
            WeakReference weakReference0 = ((BottomSheetBehavior)object1).q0;
            if(weakReference0 != null && weakReference0.get() != null) {
                this.c = v;
                if(!this.b) {
                    ((View)((BottomSheetBehavior)object1).q0.get()).postOnAnimation(((E9.t)object0));
                    this.b = true;
                }
            }
            return;
        }
        WeakReference weakReference1 = ((SideSheetBehavior)object1).r;
        if(weakReference1 != null && weakReference1.get() != null) {
            this.c = v;
            if(!this.b) {
                ((View)((SideSheetBehavior)object1).r.get()).postOnAnimation(((l)object0));
                this.b = true;
            }
        }
    }

    @Override  // M6.t
    public void onFailure(Throwable throwable0) {
        if(!this.b) {
            b.D("NotificationProvider", "Failed to load bitmap: " + throwable0.getMessage());
        }
    }

    @Override  // M6.t
    public void onSuccess(Object object0) {
        NotificationCompat.Builder notificationCompat$Builder0 = (NotificationCompat.Builder)this.d;
        if(!this.b) {
            notificationCompat$Builder0.f(((Bitmap)object0));
            T3.e e0 = new T3.e(this.c, notificationCompat$Builder0.a());
            t0 t00 = (t0)((e)this.e).c;
            g g0 = new g(t00, ((e)this.e).b, ((y0)((e)this.e).d), e0, 4);
            t00.e.execute(g0);
        }
    }
}

