package p9;

import android.content.Context;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventResponseMessage.failMessage;
import com.iloen.melon.eventbus.EventResponseMessage.successMessage;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.PushSetMannerModeSyncReq;
import com.iloen.melon.net.v4x.request.PushSetReq.ParamInfo;
import com.iloen.melon.net.v4x.request.PushSetReq;
import com.iloen.melon.net.v4x.request.PushSetSyncReq;
import com.iloen.melon.push.fcm.FcmHelper;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import k8.Y;
import kotlin.coroutines.Continuation;
import x8.f;

public final class b extends f {
    public final Context a;
    public final ParamInfo b;
    public final int c;
    public final String d;

    public b(Context context0, ParamInfo pushSetReq$ParamInfo0, int v, String s) {
        this.a = context0;
        this.b = pushSetReq$ParamInfo0;
        this.c = v;
        this.d = s;
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        PushSetReq pushSetReq0;
        Void void0 = (Void)object0;
        String s = "";
        Context context0 = this.a;
        if(context0 != null) {
            int v = this.c;
            ParamInfo pushSetReq$ParamInfo0 = this.b;
            switch(v) {
                case 2: {
                    pushSetReq0 = new PushSetSyncReq(Y.a(MelonAppBase.Companion), pushSetReq$ParamInfo0, this.d);
                    break;
                }
                case 3: {
                    pushSetReq0 = new PushSetMannerModeSyncReq(Y.a(MelonAppBase.Companion), pushSetReq$ParamInfo0);
                    break;
                }
                default: {
                    pushSetReq0 = new PushSetReq(Y.a(MelonAppBase.Companion), pushSetReq$ParamInfo0);
                }
            }
            try {
                boolean z = true;
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                if(RequestBuilder.newInstance(pushSetReq0).tag("PushAlertReceiver").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0).isSuccessful()) {
                    EventBusHelper.post(new successMessage());
                    FcmHelper.INSTANCE.setRegRslt(context0, true);
                    z = false;
                }
                goto label_24;
            }
            catch(VolleyError volleyError0) {
            }
            LogU.Companion.w("PushAlertReceiver", "backgroundWork() AsyncTaskPushRegisterDevice VolleyError " + volleyError0.getMessage());
            String s1 = volleyError0.getMessage();
            if(s1 != null) {
                s = s1;
            }
        label_24:
            if(z) {
                FcmHelper.INSTANCE.setRegRslt(context0, false);
                EventBusHelper.post(new failMessage());
                if(v == 2 || v == 3) {
                    ToastManager.show(s);
                }
            }
        }
        return null;
    }
}

