package l4;

import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import k8.Y;

public final class q extends J {
    public final Messenger a;
    public final int b;

    public q(String s, Intent intent0, Messenger messenger0, int v) {
        this.a = messenger0;
        this.b = v;
    }

    @Override  // l4.J
    public final void a(String s, Bundle bundle0) {
        int v = this.b;
        Messenger messenger0 = this.a;
        if(s != null) {
            q.c(messenger0, 4, v, bundle0, Y.b("error", s));
            return;
        }
        q.c(messenger0, 4, v, bundle0, null);
    }

    @Override  // l4.J
    public final void b(Bundle bundle0) {
        q.c(this.a, 3, this.b, bundle0, null);
    }

    public static void c(Messenger messenger0, int v, int v1, Bundle bundle0, Bundle bundle1) {
        Message message0 = Message.obtain();
        message0.what = v;
        message0.arg1 = v1;
        message0.arg2 = 0;
        message0.obj = bundle0;
        message0.setData(bundle1);
        try {
            messenger0.send(message0);
        }
        catch(DeadObjectException remoteException0) {
            Log.e("MR2ProviderService", "Could not send message to the client.", remoteException0);
        }
        catch(RemoteException unused_ex) {
        }
    }
}

