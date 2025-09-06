package com.gaa.sdk.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DownloadReceiver extends BroadcastReceiver {
    public final String a;
    public a b;

    public DownloadReceiver() {
        this.a = "DownloadReceiver";
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s = intent0.getAction();
        String s1 = this.a;
        y5.a.X(s1, "onReceive: action=" + s);
        if("com.onestore.installer.action.INSTALL_SUCCESS".equals(s) || "com.onestore.downloader.action.INSTALLED".equals(s) || "com.gaa.installer.action.INSTALL_SUCCESS".equals(s)) {
            a a4 = this.b;
            if(a4 != null) {
                ((c)a4).a.dismissProgressDialog();
                ((c)a4).a.sendResultReceiver(0, null);
                ((c)a4).a.finish();
                this.b = null;
            }
        }
        else if("com.onestore.downloader.action.COMPLETE".equals(s) || "com.gaa.downloader.action.COMPLETE".equals(s)) {
            a a3 = this.b;
            if(a3 != null) {
                GlobalStoreBaseActivity globalStoreBaseActivity1 = ((c)a3).a;
                if(globalStoreBaseActivity1.c != null) {
                    globalStoreBaseActivity1.c.setIndeterminate(true);
                    globalStoreBaseActivity1.c.setMessage(globalStoreBaseActivity1.d.a(105));
                }
            }
        }
        else if("com.onestore.downloader.action.PROGRESS".equals(s) || "com.gaa.downloader.action.PROGRESS".equals(s)) {
            int v1 = intent0.getIntExtra("percent", 0);
            a a2 = this.b;
            if(a2 != null) {
                GlobalStoreBaseActivity globalStoreBaseActivity0 = ((c)a2).a;
                if(globalStoreBaseActivity0.c != null) {
                    globalStoreBaseActivity0.c.setProgress(v1);
                }
            }
        }
        else if("com.onestore.downloader.action.ERROR".equals(s) || "com.onestore.installer.action.INSTALL_FAILED".equals(s) || "com.gaa.downloader.action.ERROR".equals(s) || "com.gaa.installer.action.INSTALL_FAILED".equals(s)) {
            a a1 = this.b;
            if(a1 != null) {
                ((c)a1).a.dismissProgressDialog();
                ((c)a1).a.sendResultReceiver(1006, null);
                ((c)a1).a.finish();
                this.b = null;
            }
        }
        else if("com.onestore.downloader.action.SEEDAPP_ERROR".equals(s) || "com.gaa.downloader.action.SEEDAPP_ERROR".equals(s)) {
            int v = intent0.getIntExtra("errorCode", 4);
            y5.a.X(s1, "SEEDAPP_ERROR: " + v);
            a a0 = this.b;
            if(a0 != null) {
                if(v == 2) {
                    ((c)a0).a.dismissProgressDialog();
                    ((c)a0).a.sendResultReceiver(0, null);
                }
                else {
                    ((c)a0).a.dismissProgressDialog();
                    ((c)a0).a.sendResultReceiver(1006, null);
                }
                ((c)a0).a.finish();
                this.b = null;
            }
        }
    }
}

