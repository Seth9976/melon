package androidx.mediarouter.media;

import Bb.e;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.appcompat.app.d;
import com.iloen.melon.utils.a;
import df.B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l4.C;
import l4.F;
import l4.Q;
import l4.f;
import l4.u;

public abstract class MediaRouteProviderService extends Service {
    public final Messenger a;
    public final e b;
    public final f c;
    public MediaRouteProvider d;
    public final F e;
    public static final int f;

    static {
        Log.isLoggable("MediaRouteProviderSrv", 3);
    }

    public MediaRouteProviderService() {
        this.a = new Messenger(new d(this));
        this.b = new e(this, 18);
        this.e = Build.VERSION.SDK_INT >= 30 ? new C(this) : new F(this);
        this.e.getClass();
        this.c = new f(this.e, 1);
    }

    public static Bundle a(B b0, int v) {
        if(b0 == null) {
            return null;
        }
        List list0 = b0.b;
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(list0);
        boolean z = b0.c;
        arrayList0.clear();
        if(v < 4) {
            z = false;
        }
        for(Object object0: list0) {
            u u0 = (u)object0;
            if(v >= u0.a.getInt("minClientVersion", 1) && v <= u0.a.getInt("maxClientVersion", 0x7FFFFFFF)) {
                if(arrayList0.contains(u0)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                arrayList0.add(u0);
            }
        }
        List list1 = arrayList0.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(arrayList0));
        Bundle bundle0 = new Bundle();
        if(!list1.isEmpty()) {
            int v2 = list1.size();
            ArrayList arrayList1 = new ArrayList(v2);
            for(int v1 = 0; v1 < v2; ++v1) {
                arrayList1.add(((u)list1.get(v1)).a);
            }
            bundle0.putParcelableArrayList("routes", arrayList1);
        }
        bundle0.putBoolean("supportsDynamicGroupRoute", z);
        return bundle0;
    }

    @Override  // android.app.Service
    public final void attachBaseContext(Context context0) {
        super.attachBaseContext(context0);
        this.e.a(context0);
    }

    public final void b() {
        if(this.d == null) {
            MediaRouteProvider mediaRouteProvider0 = this.c();
            if(mediaRouteProvider0 != null) {
                String s = ((ComponentName)mediaRouteProvider0.b.b).getPackageName();
                if(s.equals("com.iloen.melon")) {
                    this.d = mediaRouteProvider0;
                    Q.b();
                    mediaRouteProvider0.d = this.c;
                    return;
                }
                StringBuilder stringBuilder0 = a.n("onCreateMediaRouteProvider() returned a provider whose package name does not match the package name of the service.  A media route provider service can only export its own media route providers.  Provider package name: ", s, ".  Service package name: ");
                stringBuilder0.append("com.iloen.melon");
                stringBuilder0.append(".");
                throw new IllegalStateException(stringBuilder0.toString());
            }
        }
    }

    public abstract MediaRouteProvider c();

    public static void d(Messenger messenger0, int v) {
        if(v != 0) {
            MediaRouteProviderService.e(messenger0, 1, v, 0, null, null);
        }
    }

    public static void e(Messenger messenger0, int v, int v1, int v2, Bundle bundle0, Bundle bundle1) {
        Message message0 = Message.obtain();
        message0.what = v;
        message0.arg1 = v1;
        message0.arg2 = v2;
        message0.obj = bundle0;
        message0.setData(bundle1);
        try {
            messenger0.send(message0);
        }
        catch(DeadObjectException remoteException0) {
            Log.e("MediaRouteProviderSrv", "Could not send message to " + ("Client connection " + messenger0.getBinder().toString()), remoteException0);
        }
        catch(RemoteException unused_ex) {
        }
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.e.f(intent0);
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        MediaRouteProvider mediaRouteProvider0 = this.d;
        if(mediaRouteProvider0 != null) {
            Q.b();
            mediaRouteProvider0.d = null;
        }
        synchronized(this.e.g) {
            this.e.f.clear();
        }
        super.onDestroy();
    }
}

