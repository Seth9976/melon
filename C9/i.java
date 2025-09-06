package c9;

import android.content.Context;
import b3.z;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.NotificationLoginReq;
import com.iloen.melon.net.v4x.request.TmpManageIsCallReq;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import d5.n;
import ie.H;
import ie.r;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    public static final i a;
    public static final LogU b;
    public static final r c;
    public static final r d;

    static {
        i.a = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i.b = new LogU("TmpManageCallHelper");
        i.c = g.Q(new Vb.i(12));
        i.d = g.Q(new Vb.i(13));
    }

    public static final Object a(Context context0, c c0) {
        c9.c c1;
        if(c0 instanceof c9.c) {
            c1 = (c9.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new c9.c(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new c9.c(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = c1.w;
        a a0 = a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                LogU.debug$default(i.b, "fetchLoginPromotion()", null, false, 6, null);
                c1.r = context0;
                c1.B = 1;
                object0 = i.a.b(c1);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                context0 = c1.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        H h0 = H.a;
        if(((String)object0) == null) {
            return h0;
        }
        LogU.debug$default(i.b, "fetchLoginPromotion() bannedJSon : " + ((String)object0), null, false, 6, null);
        RequestBuilder.newInstance(new NotificationLoginReq(context0, ((String)object0))).tag("TmpManageCallHelper").listener(new d()).errorListener(new z(13)).request();  // 初始化器: Ljava/lang/Object;-><init>()V
        return h0;
    }

    public final Object b(c c0) {
        JSONArray jSONArray1;
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.D;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.D = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.w;
        a a0 = a.a;
        switch(e0.D) {
            case 0: {
                n.D(object0);
                JSONArray jSONArray0 = new JSONArray();
                f f0 = new f(jSONArray0, null);
                e0.r = jSONArray0;
                e0.D = 1;
                if(BuildersKt.withContext(Dispatchers.getIO(), f0, e0) == a0) {
                    return a0;
                }
                jSONArray1 = jSONArray0;
                break;
            }
            case 1: {
                jSONArray1 = e0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("bannings", jSONArray1);
            return jSONObject0.toString();
        }
        catch(Exception exception0) {
            LogU.Companion.d("TmpManageCallHelper", "bannedJSon : rootObject Err: " + exception0);
            return null;
        }
    }

    public static void c(Context context0, String s) {
        q.g(context0, "context");
        LogU.debug$default(i.b, "requestTmpManage() reason: " + s, null, false, 6, null);
        RequestBuilder.newInstance(new TmpManageIsCallReq(context0)).tag("TmpManageCallHelper").listener(new h(context0)).errorListener(new z(12)).request();
    }
}

