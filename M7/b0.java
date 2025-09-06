package M7;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.g;
import androidx.room.h;
import androidx.room.p;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import me.i;
import o9.b;

public final class b0 implements ServiceConnection {
    public final int a;
    public final Object b;

    public b0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        h h0;
        Object object0 = this.b;
        if(this.a != 0) {
            q.g(componentName0, "name");
            q.g(iBinder0, "service");
            p p0 = (p)object0;
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if(iInterface0 == null || !(iInterface0 instanceof h)) {
                h0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
                h0.a = iBinder0;
            }
            else {
                h0 = (h)iInterface0;
            }
            try {
                p0.g = h0;
                p0.f = h0.X(p0.j, p0.a);
            }
            catch(RemoteException remoteException0) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", remoteException0);
            }
            return;
        }
        LinkedBlockingDeque linkedBlockingDeque0 = (LinkedBlockingDeque)((b)object0).c;
        Log.d("SessionLifecycleClient", "Connected to SessionLifecycleService. Queue size " + linkedBlockingDeque0.size());
        ((b)object0).b = new Messenger(iBinder0);
        ArrayList arrayList0 = new ArrayList();
        linkedBlockingDeque0.drainTo(arrayList0);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(((i)((b)object0).a)), null, null, new a0(((b)object0), arrayList0, null), 3, null);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        if(this.a != 0) {
            q.g(componentName0, "name");
            ((p)this.b).g = null;
            return;
        }
        Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
        ((b)this.b).b = null;
        ((b)this.b).getClass();
    }
}

