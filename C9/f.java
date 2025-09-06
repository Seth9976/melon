package c9;

import Ra.d;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.entity.BannerPopupEntity;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import org.json.JSONArray;
import org.json.JSONObject;
import va.e0;
import va.o;
import we.n;

public final class f extends i implements n {
    public int r;
    public final JSONArray w;

    public f(JSONArray jSONArray0, Continuation continuation0) {
        this.w = jSONArray0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = u.v(((e0)o.a()).j());
                d d0 = (d)c9.i.c.getValue();
                this.r = 1;
                object0 = d0.b(s, "PROMOTION", this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        for(Object object1: ((Iterable)object0)) {
            BannerPopupEntity bannerPopupEntity0 = (BannerPopupEntity)object1;
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put("id", "");
                jSONObject0.put("query", new JSONObject(""));
                LogU.debug$default(c9.i.b, "fetchLoginPromotion() promId : , query : ", null, false, 6, null);
            }
            catch(Exception exception0) {
                LogU.Companion.d("TmpManageCallHelper", "bannedJSon Err: " + exception0);
                continue;
            }
            this.w.put(jSONObject0);
        }
        return H.a;
    }
}

