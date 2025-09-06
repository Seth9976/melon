package k8;

import Q1.c;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.Response.Listener;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.response.SearchIntentListRes.Response;
import com.iloen.melon.net.v4x.response.SearchIntentListRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import i.n.i.b.a.s.e.u9;
import kotlin.jvm.internal.q;

public final class p0 implements Listener {
    public final MusicBrowserActivity a;

    public p0(MusicBrowserActivity musicBrowserActivity0) {
        this.a = musicBrowserActivity0;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        q.g(((SearchIntentListRes)object0), "res");
        if(((SearchIntentListRes)object0).isSuccessful()) {
            Response searchIntentListRes$Response0 = ((SearchIntentListRes)object0).response;
            if(searchIntentListRes$Response0 != null) {
                if(!TextUtils.isEmpty(searchIntentListRes$Response0.playAppScheme)) {
                    Intent intent0 = new Intent();
                    c.Y(intent0, "android.intent.action.VIEW", false);
                    intent0.setData(Uri.parse(searchIntentListRes$Response0.playAppScheme));
                    intent0.addFlags(0x10000000);
                    MelonAppBase.Companion.getClass();
                    t.a().getContext().startActivity(intent0);
                }
                if(!TextUtils.isEmpty(searchIntentListRes$Response0.landAppScheme)) {
                    u9 u90 = new u9(searchIntentListRes$Response0, 12);
                    this.a.handler.postDelayed(u90, 500L);
                }
            }
            return;
        }
        Notification httpResponse$Notification0 = ((SearchIntentListRes)object0).notification;
        LogU.Companion.w("MusicBrowserActivity", "onResponse() res.isSuccessful(): false, error: " + (httpResponse$Notification0 == null ? "null" : httpResponse$Notification0.message));
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }
}

