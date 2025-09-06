package com.kakao.tiara;

import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.android.installreferrer.api.a;

final class TiaraInstallReferrer implements InstallReferrerStateListener {
    private static final int RETRY_LIMIT = 3;
    private static final String TAG = "TiaraInstallReferrer";
    private InstallReferrerClient referrerClient;
    private int retry_count;
    private TiaraTracker tracker;

    public TiaraInstallReferrer(TiaraTracker tiaraTracker0) {
        this.retry_count = 0;
        this.tracker = tiaraTracker0;
    }

    @Override  // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
        Logger.warn("TiaraInstallReferrer", "Install referrer service is disconnected.", new Object[0]);
        if(this.retry_count >= 3) {
            Logger.error("TiaraInstallReferrer", "failed to connect to install referrer service.", new Object[0]);
            this.referrerClient.a();
        }
        Logger.warn("TiaraInstallReferrer", "retry to connect to install referrer service.", new Object[0]);
        ++this.retry_count;
        this.referrerClient.c(this);
    }

    @Override  // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerSetupFinished(int v) {
        switch(v) {
            case 0: {
                Logger.info("TiaraInstallReferrer", "Install referrer service: OK", new Object[0]);
                if(this.setInstall(this.referrerClient)) {
                    this.tracker.trackAppInstall();
                }
                break;
            }
            case 1: {
                Logger.info("TiaraInstallReferrer", "Install referrer service: SERVICE_UNAVAILABLE", new Object[0]);
                break;
            }
            case 2: {
                Logger.info("TiaraInstallReferrer", "Install referrer service: FEATURE_NOT_SUPPORTED", new Object[0]);
            }
        }
        this.referrerClient.a();
    }

    private boolean setInstall(InstallReferrerClient installReferrerClient0) {
        try {
            ReferrerDetails referrerDetails0 = installReferrerClient0.b();
            TiaraManager.getInstance().setInstallFromReferrer(referrerDetails0.a.getString("install_referrer"), String.valueOf(referrerDetails0.a.getLong("referrer_click_timestamp_seconds")), String.valueOf(referrerDetails0.a.getLong("install_begin_timestamp_seconds")));
            return true;
        }
        catch(RemoteException unused_ex) {
            Logger.error("TiaraInstallReferrer", "failed to get InstallReferrer", new Object[0]);
            return false;
        }
    }

    public static void startConnection(Context context0, TiaraTracker tiaraTracker0) {
        try {
            TiaraInstallReferrer tiaraInstallReferrer0 = new TiaraInstallReferrer(tiaraTracker0);
            InstallReferrerClient installReferrerClient0 = new a(context0).a();
            tiaraInstallReferrer0.referrerClient = installReferrerClient0;
            installReferrerClient0.c(tiaraInstallReferrer0);
        }
        catch(Exception exception0) {
            Logger.error("TiaraInstallReferrer", exception0.toString(), new Object[0]);
        }
    }
}

