package androidx.car.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.f0;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Map;

public class CarAppPermissionActivity extends ComponentActivity {
    private void lambda$requestPermissions$0(IOnRequestPermissionsListener iOnRequestPermissionsListener0, Map map0) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Boolean boolean0 = (Boolean)map$Entry0.getValue();
            if(boolean0 != null && boolean0.booleanValue()) {
                arrayList0.add(((String)map$Entry0.getKey()));
            }
            else {
                arrayList1.add(((String)map$Entry0.getKey()));
            }
        }
        try {
            iOnRequestPermissionsListener0.onRequestPermissionsResult(((String[])arrayList0.toArray(new String[0])), ((String[])arrayList1.toArray(new String[0])));
        }
        catch(RemoteException remoteException0) {
            Log.e("CarApp", "CarAppService dead when accepting/rejecting permissions", remoteException0);
        }
        this.finish();
    }

    private void maybeSetCustomBackground() {
        Bundle bundle0;
        try {
            bundle0 = this.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80).metaData;
            if(bundle0 == null) {
                goto label_4;
            }
            else {
                goto label_2;
            }
            goto label_5;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return;
        }
    label_2:
        int v = bundle0.getInt("androidx.car.app.theme");
        goto label_5;
    label_4:
        v = 0;
    label_5:
        Context context0 = this.createConfigurationContext(this.getResources().getConfiguration());
        if(v != 0) {
            context0.setTheme(v);
        }
        int v1 = context0.getResources().getIdentifier("carPermissionActivityLayout", "attr", "com.iloen.melon");
        if(v1 != 0) {
            int v2 = context0.getTheme().obtainStyledAttributes(new int[]{v1}).getResourceId(0, 0);
            if(v2 != 0) {
                this.setContentView(v2);
            }
        }
    }

    @Override  // androidx.activity.ComponentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.maybeSetCustomBackground();
        this.processInternal(this.getIntent());
    }

    private void processInternal(Intent intent0) {
        if(intent0 != null && "androidx.car.app.action.REQUEST_PERMISSIONS".equals(intent0.getAction())) {
            this.requestPermissions(intent0);
            return;
        }
        Log.e("CarApp", "Unexpected intent action for CarAppPermissionActivity: " + (intent0 == null ? "null Intent" : intent0.getAction()));
        this.finish();
    }

    private void requestPermissions(Intent intent0) {
        Bundle bundle0 = intent0.getExtras();
        IOnRequestPermissionsListener iOnRequestPermissionsListener0 = Stub.asInterface(bundle0.getBinder("androidx.car.app.action.EXTRA_ON_REQUEST_PERMISSIONS_RESULT_LISTENER_KEY"));
        String[] arr_s = bundle0.getStringArray("androidx.car.app.action.EXTRA_PERMISSIONS_KEY");
        if(iOnRequestPermissionsListener0 != null && arr_s != null) {
            this.registerForActivityResult(new f0(1), new b(2, this, iOnRequestPermissionsListener0)).b(arr_s);
            return;
        }
        Log.e("CarApp", "Intent to request permissions is missing the callback binder");
        this.finish();
    }
}

