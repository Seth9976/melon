package Nb;

import E9.h;
import Tf.o;
import android.net.Uri;
import androidx.media3.session.d0;
import androidx.media3.session.r;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.androidauto.request.MixupListReq;
import com.iloen.melon.net.androidauto.response.MixupListRes.LIST;
import com.iloen.melon.net.androidauto.response.MixupListRes.RESPONSE;
import com.iloen.melon.net.androidauto.response.MixupListRes;
import com.iloen.melon.utils.log.LogU;
import e.k;
import ie.H;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class x extends i implements n {
    public final d0 B;
    public final String r;
    public final h0 w;

    public x(String s, h0 h00, d0 d00, Continuation continuation0) {
        this.r = s;
        this.w = h00;
        this.B = d00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        d5.n.D(object0);
        String s = this.r;
        q.g(s, "mediaId");
        Pattern pattern0 = Pattern.compile("/");
        q.f(pattern0, "compile(...)");
        int v = 0;
        o.P0(0);
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            ArrayList arrayList0 = new ArrayList(10);
            do {
                v = androidx.appcompat.app.o.c(matcher0, s, v, arrayList0);
            }
            while(matcher0.find());
            androidx.appcompat.app.o.w(v, s, arrayList0);
            list0 = arrayList0;
        }
        else {
            list0 = k.z(s.toString());
        }
        ArrayList arrayList1 = h.W(list0);
        LogU.debug$default(f.a, "getApiUrlForMixup() splits: " + arrayList1, null, false, 6, null);
        String s1 = URLDecoder.decode(((String)list0.get(1)), "utf-8");
        q.f(s1, "decode(...)");
        ArrayList arrayList2 = new ArrayList();
        h0 h00 = this.w;
        MixupListReq mixupListReq0 = new MixupListReq(h00.a, s1);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(mixupListReq0).tag("MelonLibrarySessionCallback").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        MixupListRes mixupListRes0 = httpResponse0 instanceof MixupListRes ? ((MixupListRes)httpResponse0) : null;
        if(mixupListRes0 != null) {
            RESPONSE mixupListRes$RESPONSE0 = mixupListRes0.response;
            if(mixupListRes$RESPONSE0 != null) {
                String s2 = mixupListRes$RESPONSE0.menuId;
                String s3 = "1000003105";
                if(s2 != null) {
                    if(s2.length() == 0) {
                        s2 = "1000003105";
                    }
                    s3 = s2;
                }
                Iterator iterator0 = mixupListRes$RESPONSE0.list.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    q.d(((LIST)object1));
                    String s4 = ((LIST)object1).constId;
                    q.f(s4, "constId");
                    String s5 = ((LIST)object1).constTypeCode;
                    q.f(s5, "constTypeCode");
                    String s6 = ((LIST)object1).constName;
                    q.f(s6, "constName");
                    String s7 = f.b(new String[]{"[PLAY][MIXUP]", s3, s4, s5, s6});
                    String s8 = ((LIST)object1).constName;
                    q.f(s8, "constName");
                    Uri uri0 = h0.a(h00, ((LIST)object1).constImg);
                    arrayList2.add(f.a(s8, s7, true, false, 13, ((LIST)object1).subtitle, uri0, 6048));
                }
            }
        }
        return r.c(arrayList2, this.B);
    }
}

