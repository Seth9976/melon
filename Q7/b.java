package Q7;

import android.util.Log;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import org.json.JSONException;
import org.json.JSONObject;
import we.n;

public final class b extends i implements n {
    public int B;
    public Object D;
    public final d E;
    public H r;
    public H w;

    public b(d d0, Continuation continuation0) {
        this.E = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b(this.E, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((JSONObject)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ie.H h12;
        H h6;
        H h5;
        Boolean boolean0;
        H h2;
        a a0 = a.a;
        ie.H h0 = ie.H.a;
        d d0 = this.E;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                JSONObject jSONObject0 = (JSONObject)this.D;
                Log.d("SessionConfigFetcher", "Fetched settings: " + jSONObject0);
                H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                h2 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                H h3 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                if(jSONObject0.has("app_quality")) {
                    Object object1 = jSONObject0.get("app_quality");
                    q.e(object1, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject1 = (JSONObject)object1;
                    try {
                        boolean0 = jSONObject1.has("sessions_enabled") ? ((Boolean)jSONObject1.get("sessions_enabled")) : null;
                    }
                    catch(JSONException jSONException0) {
                        boolean0 = null;
                        goto label_33;
                    }
                    try {
                        if(jSONObject1.has("sampling_rate")) {
                            h1.a = (Double)jSONObject1.get("sampling_rate");
                        }
                        if(jSONObject1.has("session_timeout_seconds")) {
                            h2.a = (Integer)jSONObject1.get("session_timeout_seconds");
                        }
                        if(jSONObject1.has("cache_duration")) {
                            h3.a = (Integer)jSONObject1.get("cache_duration");
                        }
                        goto label_36;
                    }
                    catch(JSONException jSONException0) {
                    }
                label_33:
                    Log.e("SessionConfigFetcher", "Error parsing the configs remotely fetched: ", jSONException0);
                }
                else {
                    boolean0 = null;
                }
            label_36:
                if(boolean0 == null) {
                    h6 = h1;
                    h5 = h3;
                }
                else {
                    m m0 = d0.e();
                    this.D = h1;
                    this.r = h2;
                    this.w = h3;
                    this.B = 1;
                    ie.H h4 = m0.c(m.c, boolean0, this);
                    if(h4 != a.a) {
                        h4 = h0;
                    }
                    if(h4 == a0) {
                        return a0;
                    }
                    h5 = h3;
                    h6 = h1;
                }
                goto label_58;
            }
            case 1: {
                h5 = this.w;
                H h7 = this.r;
                H h8 = (H)this.D;
                d5.n.D(object0);
                h2 = h7;
                h6 = h8;
            label_58:
                if(((Integer)h2.a) != null) {
                    m m1 = d0.e();
                    this.D = h6;
                    this.r = h5;
                    this.w = null;
                    this.B = 2;
                    ie.H h9 = m1.c(m.e, ((Integer)h2.a), this);
                    if(h9 != a.a) {
                        h9 = h0;
                    }
                    if(h9 == a0) {
                        return a0;
                    }
                }
                goto label_72;
            }
            case 2: {
                h5 = this.r;
                h6 = (H)this.D;
                d5.n.D(object0);
            label_72:
                if(((Double)h6.a) != null) {
                    m m2 = d0.e();
                    this.D = h5;
                    this.r = null;
                    this.w = null;
                    this.B = 3;
                    ie.H h10 = m2.c(m.d, ((Double)h6.a), this);
                    if(h10 != a.a) {
                        h10 = h0;
                    }
                    if(h10 == a0) {
                        return a0;
                    }
                }
                goto label_85;
            }
            case 3: {
                h5 = (H)this.D;
                d5.n.D(object0);
            label_85:
                if(((Integer)h5.a) == null) {
                    h12 = null;
                }
                else {
                    m m3 = d0.e();
                    this.D = null;
                    this.r = null;
                    this.w = null;
                    this.B = 4;
                    ie.H h11 = m3.c(m.f, ((Integer)h5.a), this);
                    if(h11 != a.a) {
                        h11 = h0;
                    }
                    if(h11 == a0) {
                        return a0;
                    }
                    h12 = h0;
                }
                goto label_101;
            }
            case 4: {
                d5.n.D(object0);
                h12 = h0;
            label_101:
                if(h12 == null) {
                    m m4 = d0.e();
                    this.D = null;
                    this.r = null;
                    this.w = null;
                    this.B = 5;
                    ie.H h13 = m4.c(m.f, new Integer(86400), this);
                    if(h13 != a.a) {
                        h13 = h0;
                    }
                    if(h13 == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 5: {
                d5.n.D(object0);
                break;
            }
            case 6: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        m m5 = d0.e();
        this.D = null;
        this.r = null;
        this.w = null;
        this.B = 6;
        ie.H h14 = m5.c(m.g, new Long(System.currentTimeMillis()), this);
        if(h14 != a.a) {
            h14 = h0;
        }
        return h14 == a0 ? a0 : h0;
    }
}

