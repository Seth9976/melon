package com.google.firebase.iid;

import Q1.c;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import java.util.concurrent.ExecutionException;

public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    @Override  // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public final int onMessageReceive(Context context0, CloudMessage cloudMessage0) {
        try {
            return (int)(((Integer)Tasks.await(new FcmBroadcastProcessor(context0).b(cloudMessage0.getIntent()))));
        }
        catch(ExecutionException | InterruptedException executionException0) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", executionException0);
            return 500;
        }
    }

    @Override  // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    public final void onNotificationDismissed(Context context0, Bundle bundle0) {
        Intent intent0 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(bundle0);
        if(c.T(intent0)) {
            c.K(intent0.getExtras(), "_nd");
        }
    }
}

