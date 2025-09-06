package l4;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.app.d;

public final class c0 implements IBinder.DeathRecipient {
    public final Messenger a;
    public final d b;
    public final Messenger c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final SparseArray h;
    public final i0 i;

    public c0(i0 i00, Messenger messenger0) {
        this.i = i00;
        this.d = 1;
        this.e = 1;
        this.h = new SparseArray();
        this.a = messenger0;
        d d0 = new d(this);
        this.b = d0;
        this.c = new Messenger(d0);
    }

    public final void a(int v) {
        int v1 = this.d;
        this.d = v1 + 1;
        this.b(5, v1, v, null, null);
    }

    public final boolean b(int v, int v1, int v2, Object object0, Bundle bundle0) {
        Message message0 = Message.obtain();
        message0.what = v;
        message0.arg1 = v1;
        message0.arg2 = v2;
        message0.obj = object0;
        message0.setData(bundle0);
        message0.replyTo = this.c;
        try {
            this.a.send(message0);
            return true;
        }
        catch(DeadObjectException remoteException0) {
            if(v != 2) {
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", remoteException0);
            }
        }
        catch(RemoteException unused_ex) {
        }
        return false;
    }

    @Override  // android.os.IBinder$DeathRecipient
    public final void binderDied() {
        b0 b00 = new b0(this, 1);
        this.i.j.post(b00);
    }

    public final void c(int v, int v1) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("volume", v1);
        int v2 = this.d;
        this.d = v2 + 1;
        this.b(7, v2, v, null, bundle0);
    }

    public final void d(int v, int v1) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("volume", v1);
        int v2 = this.d;
        this.d = v2 + 1;
        this.b(8, v2, v, null, bundle0);
    }
}

