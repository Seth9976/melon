package b;

import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.ComponentActivity;
import androidx.activity.result.IntentSenderRequest;
import androidx.media3.exoplayer.V;
import e.h;
import f.a;
import f.b;
import kotlin.jvm.internal.q;

public final class j extends h {
    public final ComponentActivity h;

    public j(ComponentActivity componentActivity0) {
        this.h = componentActivity0;
        super();
    }

    @Override  // e.h
    public final void b(int v, b b0, Object object0) {
        Bundle bundle1;
        q.g(b0, "contract");
        ComponentActivity componentActivity0 = this.h;
        a a0 = b0.getSynchronousResult(componentActivity0, object0);
        if(a0 != null) {
            new Handler(Looper.getMainLooper()).post(new V(this, v, a0, 2));
            return;
        }
        Intent intent0 = b0.createIntent(componentActivity0, object0);
        if(intent0.getExtras() != null) {
            Bundle bundle0 = intent0.getExtras();
            q.d(bundle0);
            if(bundle0.getClassLoader() == null) {
                intent0.setExtrasClassLoader(componentActivity0.getClassLoader());
            }
        }
        if(intent0.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle1 = intent0.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intent0.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        }
        else {
            bundle1 = null;
        }
        if("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intent0.getAction())) {
            String[] arr_s = intent0.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if(arr_s == null) {
                arr_s = new String[0];
            }
            N1.b.a(componentActivity0, arr_s, v);
            return;
        }
        if("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intent0.getAction())) {
            IntentSenderRequest intentSenderRequest0 = (IntentSenderRequest)intent0.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                q.d(intentSenderRequest0);
                componentActivity0.startIntentSenderForResult(intentSenderRequest0.a, v, intentSenderRequest0.b, intentSenderRequest0.c, intentSenderRequest0.d, 0, bundle1);
            }
            catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                new Handler(Looper.getMainLooper()).post(new V(this, v, intentSender$SendIntentException0, 3));
            }
            return;
        }
        componentActivity0.startActivityForResult(intent0, v, bundle1);
    }
}

