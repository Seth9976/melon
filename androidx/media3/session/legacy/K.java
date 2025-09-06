package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.util.Log;
import java.util.List;

public final class k extends u {
    public final n f;
    public final String g;
    public final Bundle h;
    public final Bundle i;
    public final MediaBrowserServiceCompat j;

    public k(MediaBrowserServiceCompat mediaBrowserServiceCompat0, String s, n n0, String s1, Bundle bundle0, Bundle bundle1) {
        this.j = mediaBrowserServiceCompat0;
        this.f = n0;
        this.g = s1;
        this.h = bundle0;
        this.i = bundle1;
        super(s);
    }

    @Override  // androidx.media3.session.legacy.u
    public final void d(Object object0) {
        List list0 = (List)object0;
        y y0 = this.f.e;
        String s = this.f.a;
        y0.getClass();
        IBinder iBinder0 = ((z)y0).a.getBinder();
        Object object1 = this.j.e.get(iBinder0);
        String s1 = this.g;
        if(object1 != this.f) {
            if(MediaBrowserServiceCompat.i) {
                Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + s + " id=" + s1);
            }
            return;
        }
        Bundle bundle0 = this.h;
        if((this.e & 1) != 0) {
            list0 = MediaBrowserServiceCompat.a(list0, bundle0);
        }
        try {
            ((z)y0).getClass();
            Bundle bundle1 = new Bundle();
            bundle1.putString("data_media_item_id", s1);
            bundle1.putBundle("data_options", bundle0);
            bundle1.putBundle("data_notify_children_changed_options", this.i);
            if(list0 != null) {
                bundle1.putParcelableArrayList("data_media_item_list", g.b(list0, MediaItem.CREATOR));
            }
            ((z)y0).b(3, bundle1);
        }
        catch(RemoteException unused_ex) {
            Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + s1 + " package=" + s);
        }
    }
}

