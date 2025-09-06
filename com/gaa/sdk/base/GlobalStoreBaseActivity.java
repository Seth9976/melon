package com.gaa.sdk.base;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

public class GlobalStoreBaseActivity extends Activity {
    public static final String ACTION_DOWNLOAD = "com.gaa.sdk.ACTION_DOWNLOAD";
    public static final String KEY_CONNECTION_INFO = "connection_info";
    public static final String KEY_RESULT_RECEIVER = "result_receiver";
    private final String a;
    private DownloadReceiver b;
    private ProgressDialog c;
    private d d;
    private final a e;
    protected ConnectionInfo mConnectionInfo;
    protected ResultReceiver mResultReceiver;

    public GlobalStoreBaseActivity() {
        this.a = "GlobalStoreBaseActivity";
        this.d = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new c(this);
    }

    public void dismissProgressDialog() {
        if(this.c != null && this.c.isShowing()) {
            this.c.dismiss();
        }
        this.c = null;
    }

    @Override  // android.app.Activity
    public void finish() {
        this.unregisterDownloadReceiver();
        this.overridePendingTransition(0, 0);
        super.finish();
    }

    @Override  // android.app.Activity
    public void onCreate(Bundle bundle0) {
        Parcelable parcelable0;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            Intent intent0 = this.getIntent();
            this.mResultReceiver = (ResultReceiver)intent0.getParcelableExtra("result_receiver");
            parcelable0 = intent0.getParcelableExtra("connection_info");
        }
        else {
            y5.a.X("GlobalStoreBaseActivity", "Launching module from savedInstanceState");
            this.mResultReceiver = (ResultReceiver)bundle0.getParcelable("result_receiver");
            parcelable0 = bundle0.getParcelable("connection_info");
        }
        this.mConnectionInfo = (ConnectionInfo)parcelable0;
    }

    @Override  // android.app.Activity
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putParcelable("result_receiver", this.mResultReceiver);
        bundle0.putParcelable("connection_info", this.mConnectionInfo);
    }

    public void registerDownloadReceiver() {
        this.unregisterDownloadReceiver();
        DownloadReceiver downloadReceiver0 = new DownloadReceiver();
        this.b = downloadReceiver0;
        downloadReceiver0.b = this.e;
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.onestore.downloader.action.ADDED");
        intentFilter0.addAction("com.onestore.downloader.action.PROGRESS");
        intentFilter0.addAction("com.onestore.downloader.action.STOPPED");
        intentFilter0.addAction("com.onestore.downloader.action.COMPLETE");
        intentFilter0.addAction("com.onestore.downloader.action.ERROR");
        intentFilter0.addAction("com.onestore.downloader.action.INSTALLED");
        intentFilter0.addAction("com.onestore.downloader.action.SEEDAPP_ERROR");
        intentFilter0.addAction("com.onestore.installer.action.INSTALL_SUCCESS");
        intentFilter0.addAction("com.onestore.installer.action.INSTALL_FAILED");
        intentFilter0.addAction("com.gaa.downloader.action.ADDED");
        intentFilter0.addAction("com.gaa.downloader.action.PROGRESS");
        intentFilter0.addAction("com.gaa.downloader.action.STOPPED");
        intentFilter0.addAction("com.gaa.downloader.action.COMPLETE");
        intentFilter0.addAction("com.gaa.downloader.action.ERROR");
        intentFilter0.addAction("com.gaa.installer.action.INSTALL_SUCCESS");
        intentFilter0.addAction("com.gaa.installer.action.INSTALL_FAILED");
        intentFilter0.addAction("com.gaa.downloader.action.SEEDAPP_ERROR");
        if(Build.VERSION.SDK_INT >= 33) {
            this.registerReceiver(downloadReceiver0, intentFilter0, 2);
            return;
        }
        this.registerReceiver(downloadReceiver0, intentFilter0);
    }

    public void sendResultReceiver(int v, Bundle bundle0) {
        ResultReceiver resultReceiver0 = this.mResultReceiver;
        if(resultReceiver0 != null) {
            resultReceiver0.send(v, bundle0);
        }
    }

    public void showDialogForUpdateOrInstall() {
        String s = this.d.a(102);
        String s1 = this.getString(0x104000A);
        String s2 = (String)this.mConnectionInfo.a.a;
        PackageInfo packageInfo0 = null;
        if(!TextUtils.isEmpty(s2)) {
            PackageManager packageManager0 = this.getPackageManager();
            try {
                packageInfo0 = packageManager0.getPackageInfo(s2, 0x80);
            }
            catch(Exception exception0) {
                Log.e("AppInstaller", "getPackageInfo", exception0);
            }
        }
        if(packageInfo0 != null) {
            s = this.d.a(103);
            s1 = this.d.a(100);
        }
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this, 0x103012E);
        alertDialog$Builder0.setMessage(s);
        alertDialog$Builder0.setPositiveButton(s1, new b(this, 0));
        alertDialog$Builder0.setNegativeButton(0x1040000, new b(this, 1));
        alertDialog$Builder0.setCancelable(false);
        alertDialog$Builder0.show();
    }

    public void showDownloadProgress() {
        if(this.c == null) {
            ProgressDialog progressDialog0 = new ProgressDialog(this);
            this.c = progressDialog0;
            progressDialog0.setProgress(0);
            this.c.setMax(100);
            this.c.setProgressStyle(1);
            this.c.setIndeterminate(false);
            this.c.setCancelable(false);
            this.c.setCanceledOnTouchOutside(false);
            this.c.setMessage(this.d.a(104));
        }
        this.c.show();
    }

    public void showRetryAlert() {
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this);
        alertDialog$Builder0.setMessage(this.d.a(106));
        alertDialog$Builder0.setPositiveButton(0x104000A, new b(this, 2));
        alertDialog$Builder0.setCancelable(false);
        alertDialog$Builder0.show();
    }

    public void unregisterDownloadReceiver() {
        DownloadReceiver downloadReceiver0 = this.b;
        if(downloadReceiver0 != null) {
            this.unregisterReceiver(downloadReceiver0);
            this.b = null;
        }
    }
}

