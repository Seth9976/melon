package com.gaa.sdk.base;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import x1.a;

public final class b implements DialogInterface.OnClickListener {
    public final int a;
    public final GlobalStoreBaseActivity b;

    public b(GlobalStoreBaseActivity globalStoreBaseActivity0, int v) {
        this.a = v;
        this.b = globalStoreBaseActivity0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        GlobalStoreBaseActivity globalStoreBaseActivity0;
        switch(this.a) {
            case 0: {
                try {
                    globalStoreBaseActivity0 = this.b;
                    globalStoreBaseActivity0.registerDownloadReceiver();
                    a.O(globalStoreBaseActivity0, ((String)globalStoreBaseActivity0.mConnectionInfo.a.a));
                    globalStoreBaseActivity0.showDownloadProgress();
                }
                catch(Exception unused_ex) {
                    y5.a.Y("GlobalStoreBaseActivity", "Tried to download the store service but failed. It will be launched on the mobile web.");
                    globalStoreBaseActivity0.unregisterDownloadReceiver();
                    globalStoreBaseActivity0.dismissProgressDialog();
                    String s = (String)globalStoreBaseActivity0.mConnectionInfo.a.b;
                    try {
                        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s));
                        intent0.addCategory("android.intent.category.BROWSABLE");
                        intent0.addFlags(0x10000000);
                        globalStoreBaseActivity0.startActivity(intent0);
                    }
                    catch(ActivityNotFoundException activityNotFoundException0) {
                        Log.w("AppInstaller", "Not found the browser app.", activityNotFoundException0);
                        Toast.makeText(globalStoreBaseActivity0.getApplicationContext(), d.b(101, d.c()), 0).show();
                    }
                    globalStoreBaseActivity0.showRetryAlert();
                }
                return;
            }
            case 1: {
                this.b.sendResultReceiver(1006, null);
                this.b.finish();
                return;
            }
            default: {
                this.b.sendResultReceiver(1006, null);
                this.b.finish();
            }
        }
    }
}

