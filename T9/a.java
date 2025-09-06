package t9;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import pc.t;
import we.n;

public final class a extends i implements n {
    public final d B;
    public final String r;
    public final Activity w;

    public a(String s, Activity activity0, d d0, Continuation continuation0) {
        this.r = s;
        this.w = activity0;
        this.B = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((a)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Intent intent0 = new Intent("android.intent.action.SEND");
        intent0.setType("text/plain");
        intent0.putExtra("android.intent.extra.TEXT", this.r);
        intent0.setPackage("com.facebook.katana");
        try {
            Activity activity0 = this.w;
            if(activity0 != null) {
                activity0.startActivity(intent0);
            }
            t.E(this.B, this.B.b);
            return H.a;
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
        }
        LogU.Companion.w("Facebook", "shareForFacebook() - " + activityNotFoundException0);
        ToastManager.show(0x7F13106A);  // string:toast_message_facebook_need_install "페이스북이 설치되어 있지 않습니다."
        return H.a;
    }
}

