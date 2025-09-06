package Nb;

import H0.b;
import androidx.media3.session.d0;
import androidx.media3.session.r;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.androidauto.request.HomeReq;
import com.iloen.melon.net.androidauto.response.HomeRes.RESPONSE;
import com.iloen.melon.net.androidauto.response.HomeRes.SLOTLIST;
import com.iloen.melon.net.androidauto.response.HomeRes;
import com.iloen.melon.utils.StringUtils;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class u extends i implements n {
    public final h0 r;
    public final d0 w;

    public u(h0 h00, d0 d00, Continuation continuation0) {
        this.r = h00;
        this.w = d00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        ArrayList arrayList0 = b.m(object0);
        h0 h00 = this.r;
        HomeReq homeReq0 = new HomeReq(h00.a);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(homeReq0).tag("MelonLibrarySessionCallback").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        HomeRes homeRes0 = httpResponse0 instanceof HomeRes ? ((HomeRes)httpResponse0) : null;
        if(homeRes0 != null) {
            RESPONSE homeRes$RESPONSE0 = homeRes0.response;
            if(homeRes$RESPONSE0 != null) {
                ArrayList arrayList1 = homeRes$RESPONSE0.slotList;
                if(arrayList1 != null) {
                    Iterator iterator0 = arrayList1.iterator();
                    q.f(iterator0, "iterator(...)");
                    while(iterator0.hasNext()) {
                        Object object1 = iterator0.next();
                        q.d(((SLOTLIST)object1));
                        String s = ((SLOTLIST)object1).apiType;
                        if(q.b(s, "C")) {
                            s1 = "[PLAY][HOME]";
                        }
                        else {
                            s1 = q.b(s, "M") ? "[LIST][MIXUP]" : "[LIST][HOME]";
                        }
                        String s2 = f.b(new String[]{s1, StringUtils.getEncodeUTF8(((SLOTLIST)object1).apiUrl)});
                        String s3 = ((SLOTLIST)object1).title;
                        q.f(s3, "title");
                        arrayList0.add(f.a(s3, s2, q.b(((SLOTLIST)object1).apiType, "C"), !q.b(((SLOTLIST)object1).apiType, "C"), (q.b(((SLOTLIST)object1).apiType, "C") ? 13 : 24), null, h0.a(h00, ((SLOTLIST)object1).imgUrl), 0x17E0));
                    }
                }
            }
        }
        return r.c(arrayList0, this.w);
    }
}

