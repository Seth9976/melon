package androidx.car.app.notification;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.car.app.IStartCarApp.Stub;
import androidx.car.app.IStartCarApp;
import androidx.car.app.utils.g;
import java.util.Objects;
import vc.a;

public class CarAppNotificationBroadcastReceiver extends BroadcastReceiver {
    public static final int a;

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        IBinder iBinder0;
        ComponentName componentName0 = (ComponentName)intent0.getParcelableExtra("androidx.car.app.notification.COMPONENT_EXTRA_KEY");
        intent0.removeExtra("androidx.car.app.notification.COMPONENT_EXTRA_KEY");
        intent0.setComponent(componentName0);
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 == null) {
            iBinder0 = null;
        }
        else {
            iBinder0 = bundle0.getBinder("androidx.car.app.extra.START_CAR_APP_BINDER_KEY");
            bundle0.remove("androidx.car.app.extra.START_CAR_APP_BINDER_KEY");
        }
        if(iBinder0 == null) {
            Log.e("CarApp.NBR", "Notification intent missing expected extra: " + intent0);
            return;
        }
        IStartCarApp iStartCarApp0 = Stub.asInterface(iBinder0);
        Objects.requireNonNull(iStartCarApp0);
        g.d("startCarApp from notification", new a(iStartCarApp0, intent0));
    }
}

