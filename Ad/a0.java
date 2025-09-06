package ad;

import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.preference.MusicTabPrefsHelper;
import ie.H;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class a0 extends i implements n {
    public int r;
    public final q0 w;

    public a0(q0 q00, Continuation continuation0) {
        this.w = q00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                S0 s00 = this.w.h;
                HashMap hashMap0 = MusicTabPrefsHelper.INSTANCE.getTopNotification();
                if(hashMap0 == null) {
                    s = null;
                }
                else {
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    for(Object object1: hashMap0.entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object1;
                        if(System.currentTimeMillis() < ((Number)map$Entry0.getValue()).longValue() + 86400000L) {
                            linkedHashMap0.put(map$Entry0.getKey(), map$Entry0.getValue());
                        }
                    }
                    Set set0 = linkedHashMap0.keySet();
                    s = set0 == null ? null : p.q0(set0, ",", null, null, null, 62);
                }
                if(s == null) {
                    s = "";
                }
                HashMap hashMap1 = MusicTabPrefsHelper.INSTANCE.getTopNotificationBadge();
                LinkedHashMap linkedHashMap1 = new LinkedHashMap();
                for(Object object2: hashMap1.entrySet()) {
                    Map.Entry map$Entry1 = (Map.Entry)object2;
                    if(System.currentTimeMillis() < ((Number)map$Entry1.getValue()).longValue() + 86400000L) {
                        linkedHashMap1.put(map$Entry1.getKey(), map$Entry1.getValue());
                    }
                }
                String s1 = p.q0(linkedHashMap1.keySet(), ",", null, null, null, 62);
                this.r = 1;
                Object object3 = s00.b0(s, s1, this);
                return object3 == a0 ? a0 : object3;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

