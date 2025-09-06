package Nb;

import E9.h;
import Tf.o;
import android.net.Uri;
import androidx.media3.session.d0;
import androidx.media3.session.r;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.androidauto.request.MyMusicPlaylistReq;
import com.iloen.melon.net.androidauto.response.ListRes.LIST;
import com.iloen.melon.net.androidauto.response.ListRes.RESPONSE;
import com.iloen.melon.net.androidauto.response.ListRes;
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

public final class v extends i implements n {
    public final d0 B;
    public final String r;
    public final h0 w;

    public v(String s, h0 h00, d0 d00, Continuation continuation0) {
        this.r = s;
        this.w = h00;
        this.B = d00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s4;
        List list1;
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
            int v1 = 0;
            do {
                v1 = androidx.appcompat.app.o.c(matcher0, s, v1, arrayList0);
            }
            while(matcher0.find());
            androidx.appcompat.app.o.w(v1, s, arrayList0);
            list0 = arrayList0;
        }
        else {
            list0 = k.z(s.toString());
        }
        LogU logU0 = f.a;
        LogU.debug$default(logU0, "getApiUrlForDrawer() splits: " + h.W(list0), null, false, 6, null);
        String s1 = (String)list0.get(1);
        Pattern pattern1 = Pattern.compile("/");
        q.f(pattern1, "compile(...)");
        o.P0(0);
        Matcher matcher1 = pattern1.matcher(s);
        if(matcher1.find()) {
            ArrayList arrayList1 = new ArrayList(10);
            do {
                v = androidx.appcompat.app.o.c(matcher1, s, v, arrayList1);
            }
            while(matcher1.find());
            androidx.appcompat.app.o.w(v, s, arrayList1);
            list1 = arrayList1;
        }
        else {
            list1 = k.z(s.toString());
        }
        LogU.debug$default(logU0, "getApiUrlForDrawer() splits: " + h.W(list1), null, false, 6, null);
        String s2 = URLDecoder.decode(((String)list1.get(2)), "utf-8");
        q.f(s2, "decode(...)");
        ArrayList arrayList2 = new ArrayList();
        h0 h00 = this.w;
        MyMusicPlaylistReq myMusicPlaylistReq0 = new MyMusicPlaylistReq(h00.a, s2);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(myMusicPlaylistReq0).tag("MelonLibrarySessionCallback").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        ListRes listRes0 = httpResponse0 instanceof ListRes ? ((ListRes)httpResponse0) : null;
        if(listRes0 != null) {
            RESPONSE listRes$RESPONSE0 = listRes0.response;
            if(listRes$RESPONSE0 != null && listRes$RESPONSE0.list != null) {
                String s3 = listRes$RESPONSE0.menuId;
                if(s3 == null) {
                    s4 = "1000003107";
                }
                else {
                    if(s3.length() == 0) {
                        s3 = "1000003107";
                    }
                    s4 = s3;
                }
                Iterator iterator0 = listRes$RESPONSE0.list.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    q.d(((LIST)object1));
                    q.g(s1, "landingFrom");
                    String s5 = ((LIST)object1).constId;
                    q.f(s5, "constId");
                    String s6 = ((LIST)object1).constTypeCode;
                    q.f(s6, "constTypeCode");
                    String s7 = ((LIST)object1).title;
                    q.f(s7, "title");
                    String s8 = f.b(new String[]{"[PLAY][DRAWER]", s4, s1, s5, s6, s7});
                    String s9 = ((LIST)object1).title;
                    q.f(s9, "title");
                    Uri uri0 = h0.a(h00, ((LIST)object1).imgUrl);
                    arrayList2.add(f.a(s9, s8, true, false, 13, ((LIST)object1).subtitle, uri0, 6048));
                }
            }
        }
        return r.c(arrayList2, this.B);
    }
}

