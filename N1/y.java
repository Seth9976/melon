package N1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class y implements ServiceConnection, Handler.Callback {
    public final Context a;
    public final Handler b;
    public final HashMap c;
    public HashSet d;

    public y(Context context0) {
        this.c = new HashMap();
        this.d = new HashSet();
        this.a = context0;
        HandlerThread handlerThread0 = new HandlerThread("NotificationManagerCompat");
        handlerThread0.start();
        this.b = new Handler(handlerThread0.getLooper(), this);
    }

    public final void a(x x0) {
        boolean z;
        ComponentName componentName0 = x0.a;
        if(Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + componentName0 + ", " + x0.d.size() + " queued tasks");
        }
        ArrayDeque arrayDeque0 = x0.d;
        if(!arrayDeque0.isEmpty()) {
            if(x0.b) {
                z = true;
            }
            else {
                Intent intent0 = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName0);
                Context context0 = this.a;
                boolean z1 = context0.bindService(intent0, this, 33);
                x0.b = z1;
                if(z1) {
                    x0.e = 0;
                }
                else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName0);
                    context0.unbindService(this);
                }
                z = x0.b;
            }
            if(!z || x0.c == null) {
                this.b(x0);
                return;
            }
            v v0;
            while((v0 = (v)arrayDeque0.peek()) != null) {
                try {
                    if(Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + v0);
                    }
                    x0.c.notify(v0.a, v0.b, null, v0.c);
                    arrayDeque0.remove();
                    continue;
                }
                catch(DeadObjectException unused_ex) {
                }
                catch(RemoteException remoteException0) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName0, remoteException0);
                    break;
                }
                if(!Log.isLoggable("NotifManCompat", 3)) {
                    break;
                }
                Log.d("NotifManCompat", "Remote service has died: " + componentName0);
                break;
            }
            if(!arrayDeque0.isEmpty()) {
                this.b(x0);
            }
        }
    }

    public final void b(x x0) {
        ComponentName componentName0 = x0.a;
        ArrayDeque arrayDeque0 = x0.d;
        Handler handler0 = this.b;
        if(handler0.hasMessages(3, componentName0)) {
            return;
        }
        int v = x0.e;
        x0.e = v + 1;
        if(v + 1 > 6) {
            Log.w("NotifManCompat", "Giving up on delivering " + arrayDeque0.size() + " tasks to " + componentName0 + " after " + x0.e + " retries");
            arrayDeque0.clear();
            return;
        }
        int v1 = (1 << v) * 1000;
        if(Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + v1 + " ms");
        }
        handler0.sendMessageDelayed(handler0.obtainMessage(3, componentName0), ((long)v1));
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        HashSet hashSet1;
        switch(message0.what) {
            case 0: {
                v v0 = (v)message0.obj;
                String s = Settings.Secure.getString(this.a.getContentResolver(), "enabled_notification_listeners");
                synchronized(z.c) {
                    if(s != null && !s.equals(z.d)) {
                        String[] arr_s = s.split(":", -1);
                        HashSet hashSet0 = new HashSet(arr_s.length);
                        for(int v2 = 0; v2 < arr_s.length; ++v2) {
                            ComponentName componentName0 = ComponentName.unflattenFromString(arr_s[v2]);
                            if(componentName0 != null) {
                                hashSet0.add(componentName0.getPackageName());
                            }
                        }
                        z.e = hashSet0;
                        z.d = s;
                    }
                    hashSet1 = z.e;
                }
                if(!hashSet1.equals(this.d)) {
                    this.d = hashSet1;
                    List list0 = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet hashSet2 = new HashSet();
                    for(Object object1: list0) {
                        ResolveInfo resolveInfo0 = (ResolveInfo)object1;
                        if(hashSet1.contains(resolveInfo0.serviceInfo.packageName)) {
                            ComponentName componentName1 = new ComponentName(resolveInfo0.serviceInfo.packageName, resolveInfo0.serviceInfo.name);
                            if(resolveInfo0.serviceInfo.permission == null) {
                                hashSet2.add(componentName1);
                            }
                            else {
                                Log.w("NotifManCompat", "Permission present on component " + componentName1 + ", not adding listener record.");
                            }
                        }
                    }
                    for(Object object2: hashSet2) {
                        ComponentName componentName2 = (ComponentName)object2;
                        if(!this.c.containsKey(componentName2)) {
                            if(Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                            }
                            x x0 = new x(componentName2);
                            this.c.put(componentName2, x0);
                        }
                    }
                    Iterator iterator2 = this.c.entrySet().iterator();
                    while(iterator2.hasNext()) {
                        Object object3 = iterator2.next();
                        Map.Entry map$Entry0 = (Map.Entry)object3;
                        if(!hashSet2.contains(map$Entry0.getKey())) {
                            if(Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Removing listener record for " + map$Entry0.getKey());
                            }
                            x x1 = (x)map$Entry0.getValue();
                            if(x1.b) {
                                this.a.unbindService(this);
                                x1.b = false;
                            }
                            x1.c = null;
                            iterator2.remove();
                        }
                    }
                }
                for(Object object4: this.c.values()) {
                    ((x)object4).d.add(v0);
                    this.a(((x)object4));
                }
                return true;
            }
            case 1: {
                ComponentName componentName3 = ((w)message0.obj).a;
                IBinder iBinder0 = ((w)message0.obj).b;
                x x2 = (x)this.c.get(componentName3);
                if(x2 != null) {
                    x2.c = Stub.asInterface(iBinder0);
                    x2.e = 0;
                    this.a(x2);
                    return true;
                }
                break;
            }
            case 2: {
                x x3 = (x)this.c.get(((ComponentName)message0.obj));
                if(x3 != null) {
                    if(x3.b) {
                        this.a.unbindService(this);
                        x3.b = false;
                    }
                    x3.c = null;
                    return true;
                }
                break;
            }
            case 3: {
                x x4 = (x)this.c.get(((ComponentName)message0.obj));
                if(x4 != null) {
                    this.a(x4);
                    return true;
                }
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        if(Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName0);
        }
        w w0 = new w(componentName0, iBinder0);
        this.b.obtainMessage(1, w0).sendToTarget();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        if(Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName0);
        }
        this.b.obtainMessage(2, componentName0).sendToTarget();
    }
}

