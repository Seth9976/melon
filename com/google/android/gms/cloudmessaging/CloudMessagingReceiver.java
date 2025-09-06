package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.BroadcastReceiver.PendingResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    public static final class IntentActionKeys {
        public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";

    }

    public static final class IntentKeys {
        public static final String PENDING_INTENT = "pending_intent";
        public static final String WRAPPED_INTENT = "wrapped_intent";

    }

    private static SoftReference zza;
    private static SoftReference zzb;

    public Executor getBroadcastExecutor() {
        synchronized(CloudMessagingReceiver.class) {
            SoftReference softReference0 = CloudMessagingReceiver.zza;
            Executor executor0 = softReference0 == null ? null : ((ExecutorService)softReference0.get());
            if(executor0 == null) {
                executor0 = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory("firebase-iid-executor")));
                CloudMessagingReceiver.zza = new SoftReference(executor0);
            }
            return executor0;
        }
    }

    public abstract int onMessageReceive(Context arg1, CloudMessage arg2);

    public void onNotificationDismissed(Context context0, Bundle bundle0) {
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(intent0 == null) {
            return;
        }
        boolean z = this.isOrderedBroadcast();
        BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.goAsync();
        this.getBroadcastExecutor().execute(new zzh(this, intent0, context0, z, broadcastReceiver$PendingResult0));
    }

    public final void zza(Intent intent0, Context context0, boolean z, BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0) {
        int v1;
        try {
            Parcelable parcelable0 = intent0.getParcelableExtra("wrapped_intent");
            Executor executor0 = null;
            Intent intent1 = parcelable0 instanceof Intent ? ((Intent)parcelable0) : null;
            if(intent1 != null) {
                v1 = this.zzb(context0, intent1);
            }
            else if(intent0.getExtras() == null) {
                v1 = 500;
            }
            else {
                CloudMessage cloudMessage0 = new CloudMessage(intent0);
                CountDownLatch countDownLatch0 = new CountDownLatch(1);
                synchronized(CloudMessagingReceiver.class) {
                    SoftReference softReference0 = CloudMessagingReceiver.zzb;
                    if(softReference0 != null) {
                        executor0 = (Executor)softReference0.get();
                    }
                    if(executor0 == null) {
                        NamedThreadFactory namedThreadFactory0 = new NamedThreadFactory("pscm-ack-executor");
                        ThreadPoolExecutor threadPoolExecutor0 = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), namedThreadFactory0);
                        threadPoolExecutor0.allowCoreThreadTimeOut(true);
                        executor0 = Executors.unconfigurableExecutorService(threadPoolExecutor0);
                        CloudMessagingReceiver.zzb = new SoftReference(executor0);
                    }
                }
                executor0.execute(new zzg(context0, cloudMessage0, countDownLatch0));
                int v2 = this.onMessageReceive(context0, cloudMessage0);
                try {
                    if(!countDownLatch0.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                        Log.w("CloudMessagingReceiver", "Message ack timed out");
                    }
                }
                catch(InterruptedException interruptedException0) {
                    Log.w("CloudMessagingReceiver", "Message ack failed: " + interruptedException0.toString());
                }
                v1 = v2;
            }
            if(z && broadcastReceiver$PendingResult0 != null) {
                broadcastReceiver$PendingResult0.setResultCode(v1);
            }
        }
        finally {
            if(broadcastReceiver$PendingResult0 != null) {
                broadcastReceiver$PendingResult0.finish();
            }
        }
    }

    private final int zzb(Context context0, Intent intent0) {
        PendingIntent pendingIntent0 = (PendingIntent)intent0.getParcelableExtra("pending_intent");
        if(pendingIntent0 != null) {
            try {
                pendingIntent0.send();
            }
            catch(PendingIntent.CanceledException unused_ex) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        else {
            bundle0.remove("pending_intent");
        }
        if(Objects.equals(intent0.getAction(), "com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            this.onNotificationDismissed(context0, bundle0);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }
}

