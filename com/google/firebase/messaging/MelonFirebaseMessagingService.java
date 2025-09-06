package com.google.firebase.messaging;

import android.content.Intent;
import android.text.TextUtils;
import com.iloen.melon.push.PushAlertReceiver;
import com.iloen.melon.push.fcm.FcmHelper;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/firebase/messaging/MelonFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonFirebaseMessagingService extends FirebaseMessagingService {
    @Override  // com.google.firebase.messaging.FirebaseMessagingService
    public final void d(RemoteMessage remoteMessage0) {
        try {
            Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.i("MelonFirebaseMessagingService", "onMessageReceived() onMessage");
            Intent intent0 = new Intent(this.getApplicationContext(), PushAlertReceiver.class);
            intent0.setAction("com.iloen.android.push.intent.RECEIVE");
            intent0.addCategory("com.iloen.melon");
            String s = (String)remoteMessage0.getData().get("message");
            if(s != null && s.length() != 0) {
                logU$Companion0.i("MelonFirebaseMessagingService", "onMessageReceived() msgBody: " + s);
                JSONObject jSONObject0 = new JSONObject(s);
                Iterator iterator0 = jSONObject0.keys();
                q.f(iterator0, "keys(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    String s1 = jSONObject0.getString(((String)object0));
                    LogU.Companion.i("MelonFirebaseMessagingService", "onMessageReceived() [" + ((String)object0) + "]: " + s1);
                    intent0.putExtra(((String)object0), s1);
                }
                this.sendBroadcast(intent0);
                return;
            }
            logU$Companion0.w("MelonFirebaseMessagingService", "onMessageReceived() msgBody is null");
            return;
        }
        catch(Exception exception0) {
        }
        catch(Error error0) {
            error0.printStackTrace();
            return;
        }
        exception0.printStackTrace();
    }

    @Override  // com.google.firebase.messaging.FirebaseMessagingService
    public final void e(String s) {
        q.g(s, "refreshedToken");
        LogU.Companion.d("MelonFirebaseMessagingService", "Refreshed token: " + s);
        if(!TextUtils.isEmpty(s)) {
            FcmHelper.sendRegistrationToServer(this, s);
        }
    }
}

