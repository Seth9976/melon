package c9;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventLoginDialog.AppUpdate;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.AndroidAppCheckReq;
import com.iloen.melon.net.v4x.response.AndroidAppCheckRes.Response;
import com.iloen.melon.net.v4x.response.AndroidAppCheckRes;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import x8.f;

public final class b extends f {
    public static void a(AndroidAppCheckRes androidAppCheckRes0) {
        Response androidAppCheckRes$Response0 = androidAppCheckRes0.response;
        AppVersionInfo appVersionInfo0 = new AppVersionInfo();
        String s = androidAppCheckRes$Response0.chkflag;
        q.f(s, "chkflag");
        appVersionInfo0.a = s;
        String s1 = androidAppCheckRes$Response0.dpVersion;
        q.f(s1, "dpVersion");
        appVersionInfo0.b = s1;
        String s2 = androidAppCheckRes$Response0.url1;
        q.f(s2, "url1");
        appVersionInfo0.d = s2;
        String s3 = androidAppCheckRes$Response0.url2;
        q.f(s3, "url2");
        appVersionInfo0.e = s3;
        String s4 = androidAppCheckRes$Response0.url3;
        q.f(s4, "url3");
        appVersionInfo0.f = s4;
        String s5 = androidAppCheckRes$Response0.message;
        q.f(s5, "message");
        appVersionInfo0.c = s5;
        q.f(androidAppCheckRes$Response0.notiflag, "notiflag");
        MelonSettingInfo.setAppVersionInfo(appVersionInfo0);
        if(androidAppCheckRes$Response0.notiflag != null && "2".equals(androidAppCheckRes$Response0.notiflag)) {
            EventBusHelper.post(new AppUpdate());
        }
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        Void void0 = (Void)object0;
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        try {
            MelonAppBase.Companion.getClass();
            HttpResponse httpResponse0 = RequestBuilder.newInstance(new AndroidAppCheckReq(t.a().getContext())).tag("TaskMelOnUpgrade").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
            q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.AndroidAppCheckRes");
            LogU.Companion.i("TaskMelOnUpgrade", "backgroundWork() version:" + ((AndroidAppCheckRes)httpResponse0));
            if(((AndroidAppCheckRes)httpResponse0).isSuccessful() && ((AndroidAppCheckRes)httpResponse0).response != null) {
                b.a(((AndroidAppCheckRes)httpResponse0));
            }
        }
        catch(VolleyError unused_ex) {
        }
        return H.a;
    }
}

