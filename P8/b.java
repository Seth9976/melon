package p8;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.ListCommCodeInfoReq;
import ie.r;
import java.util.HashMap;
import k8.Y;
import kotlin.jvm.internal.q;

public abstract class b {
    public static String a(String s) {
        q.g(s, "key");
        r r0 = d.a;
        HashMap hashMap0 = (HashMap)r0.getValue();
        if(hashMap0 != null && !hashMap0.isEmpty()) {
            c c0 = (c)((HashMap)r0.getValue()).get(s);
            return c0 == null ? "" : c0.a;
        }
        b.b();
        return null;
    }

    public static void b() {
        RequestBuilder.newInstance(new ListCommCodeInfoReq(Y.a(MelonAppBase.Companion))).listener(new i3.d(23)).errorListener(new i3.d(24)).request();
    }
}

