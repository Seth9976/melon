package l4;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public final class l extends z {
    public final String a;
    public final k b;

    public l(String s, k k0) {
        this.a = s;
        this.b = k0;
    }

    @Override  // l4.z
    public final void g(int v) {
        String s = this.a;
        if(s != null) {
            k k0 = this.b;
            if(k0 != null) {
                Messenger messenger0 = k0.h;
                if(k0.g != null && !k0.g.isReleased() && messenger0 != null) {
                    int v1 = k0.l.getAndIncrement();
                    Message message0 = Message.obtain();
                    message0.what = 7;
                    message0.arg1 = v1;
                    Bundle bundle0 = new Bundle();
                    bundle0.putInt("volume", v);
                    bundle0.putString("routeId", s);
                    message0.setData(bundle0);
                    message0.replyTo = k0.i;
                    try {
                        messenger0.send(message0);
                        return;
                    }
                    catch(DeadObjectException remoteException0) {
                    }
                    catch(RemoteException unused_ex) {
                        return;
                    }
                    Log.e("MR2Provider", "Could not send control request to service.", remoteException0);
                }
            }
        }
    }

    @Override  // l4.z
    public final void j(int v) {
        String s = this.a;
        if(s != null) {
            k k0 = this.b;
            if(k0 != null) {
                Messenger messenger0 = k0.h;
                if(k0.g != null && !k0.g.isReleased() && messenger0 != null) {
                    int v1 = k0.l.getAndIncrement();
                    Message message0 = Message.obtain();
                    message0.what = 8;
                    message0.arg1 = v1;
                    Bundle bundle0 = new Bundle();
                    bundle0.putInt("volume", v);
                    bundle0.putString("routeId", s);
                    message0.setData(bundle0);
                    message0.replyTo = k0.i;
                    try {
                        messenger0.send(message0);
                        return;
                    }
                    catch(DeadObjectException remoteException0) {
                    }
                    catch(RemoteException unused_ex) {
                        return;
                    }
                    Log.e("MR2Provider", "Could not send control request to service.", remoteException0);
                }
            }
        }
    }
}

