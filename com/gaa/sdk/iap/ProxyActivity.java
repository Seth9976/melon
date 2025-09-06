package com.gaa.sdk.iap;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.gaa.sdk.base.GlobalStoreBaseActivity;
import y5.a;

public class ProxyActivity extends GlobalStoreBaseActivity {
    private final String a;

    public ProxyActivity() {
        this.a = "ProxyActivity";
    }

    private void a(Intent intent0) {
        int v;
        PendingIntent pendingIntent0;
        a.X("ProxyActivity", "Launching payment module purchase flow");
        if(this.getIntent().hasExtra("purchaseIntent")) {
            a.X("ProxyActivity", "module: purchase intent");
            pendingIntent0 = (PendingIntent)intent0.getParcelableExtra("purchaseIntent");
        }
        else if(this.getIntent().hasExtra("subsManagementIntent")) {
            a.X("ProxyActivity", "module: subscription management intent");
            pendingIntent0 = (PendingIntent)intent0.getParcelableExtra("purchaseIntent");
        }
        else if(this.getIntent().hasExtra("loginIntent")) {
            a.X("ProxyActivity", "module: login intent");
            pendingIntent0 = (PendingIntent)intent0.getParcelableExtra("loginIntent");
        }
        else {
            pendingIntent0 = null;
        }
        try {
            this.startIntentSenderForResult(pendingIntent0.getIntentSender(), 100, new Intent(), 0, 0, 0);
            return;
        }
        catch(IntentSender.SendIntentException | NullPointerException intentSender$SendIntentException0) {
            a.Y("ProxyActivity", "Got exception while trying to start a purchase flow: " + intentSender$SendIntentException0);
            v = 6;
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            a.Y("ProxyActivity", "Got exception while trying to start a purchase flow: " + activityNotFoundException0);
            v = 11;
        }
        this.sendResultReceiver(v, null);
        this.finish();
    }

    @Override  // android.app.Activity
    public void onActivityResult(int v, int v1, Intent intent0) {
        int v2;
        super.onActivityResult(v, v1, intent0);
        if(v == 100) {
            if(intent0 == null) {
                a.Y("IapHelper", "Got null intent!");
                v2 = 6;
            }
            else {
                v2 = B.a.f(intent0.getExtras(), "ProxyActivity");
            }
            if(v2 != 0) {
                a.Y("ProxyActivity", "Activity finished with resultCode " + v1 + " and billing\'s responseCode: " + v2);
            }
            if(!this.isFinishing()) {
                this.sendResultReceiver(v2, (intent0 == null ? null : intent0.getExtras()));
            }
        }
        else {
            a.Y("ProxyActivity", "Got onActivityResult with wrong requestCode: " + v + "; skipping...");
        }
        this.finish();
    }

    @Override  // com.gaa.sdk.base.GlobalStoreBaseActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if("com.gaa.sdk.ACTION_DOWNLOAD".equals(this.getIntent().getAction())) {
            this.showDialogForUpdateOrInstall();
            return;
        }
        if(bundle0 == null) {
            Intent intent0 = this.getIntent();
            this.mResultReceiver = (ResultReceiver)intent0.getParcelableExtra("result_receiver");
            this.a(intent0);
            return;
        }
        a.X("ProxyActivity", "Launching payment module purchase flow from savedInstanceState");
        this.mResultReceiver = (ResultReceiver)bundle0.getParcelable("result_receiver");
    }
}

