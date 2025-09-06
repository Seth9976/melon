package bb;

import H8.q;
import I7.c;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import ie.H;
import java.util.ArrayList;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import oe.i;
import we.n;

public final class a extends i implements n {
    public Object B;
    public final q D;
    public final String E;
    public final String G;
    public final String I;
    public UserActionsRes r;
    public int w;

    public a(q q0, String s, String s1, String s2, Continuation continuation0) {
        this.D = q0;
        this.E = s;
        this.G = s1;
        this.I = s2;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        ArrayList arrayList1;
        UserActionsRes userActionsRes0;
        FlowCollector flowCollector0 = (FlowCollector)this.B;
        ne.a a0 = ne.a.a;
        String s = this.I;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = flowCollector0;
                this.w = 1;
                object0 = ((c)this.D.d).H(this.E, this.G, s, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_14;
            }
            case 1: {
                d5.n.D(object0);
            label_14:
                userActionsRes0 = (UserActionsRes)object0;
                h h0 = new h((userActionsRes0 == null ? null : userActionsRes0.notification), false);
                this.B = flowCollector0;
                this.r = userActionsRes0;
                this.w = 2;
                if(flowCollector0.emit(h0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                userActionsRes0 = this.r;
                d5.n.D(object0);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(userActionsRes0 == null) {
            arrayList1 = null;
        }
        else {
            Response userActionsRes$Response0 = userActionsRes0.response;
            if(userActionsRes$Response0 == null) {
                arrayList1 = null;
            }
            else {
                ArrayList arrayList0 = userActionsRes$Response0.relationList;
                if(arrayList0 == null) {
                    arrayList1 = null;
                }
                else {
                    arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                    for(Object object1: arrayList0) {
                        RelationList userActionsRes$Response$RelationList0 = (RelationList)object1;
                        switch(s) {
                            case "bravo": {
                                s1 = userActionsRes$Response$RelationList0.fields.bravo;
                                break;
                            }
                            case "fan": {
                                s1 = userActionsRes$Response$RelationList0.fields.fan;
                                break;
                            }
                            case "friend": {
                                s1 = userActionsRes$Response$RelationList0.fields.friend;
                                break;
                            }
                            case "like": {
                                s1 = userActionsRes$Response$RelationList0.fields.like;
                                break;
                            }
                            case "temperature": {
                                s1 = userActionsRes$Response$RelationList0.fields.temperature;
                                break;
                            }
                            default: {
                                s1 = null;
                            }
                        }
                        String s2 = userActionsRes$Response$RelationList0.contentsTypeId;
                        kotlin.jvm.internal.q.f(s2, "contentsTypeId");
                        arrayList1.add(new g(s2, ProtocolUtils.parseBoolean(s1)));
                    }
                }
            }
        }
        if(arrayList1 == null) {
            arrayList1 = w.a;
        }
        m m0 = new m(arrayList1);
        this.B = null;
        this.r = null;
        this.w = 3;
        return flowCollector0.emit(m0, this) == a0 ? a0 : H.a;
    }
}

