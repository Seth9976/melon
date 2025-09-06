package Nb;

import H0.b;
import androidx.media3.session.d0;
import androidx.media3.session.r;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.androidauto.request.MyMusicHomeReq;
import com.iloen.melon.net.androidauto.response.MyMusicHomeRes.RESPONSE;
import com.iloen.melon.net.androidauto.response.MyMusicHomeRes.SLOTLIST;
import com.iloen.melon.net.androidauto.response.MyMusicHomeRes;
import com.iloen.melon.utils.StringUtils;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class t extends i implements n {
    public final h0 r;
    public final d0 w;

    public t(h0 h00, d0 d00, Continuation continuation0) {
        this.r = h00;
        this.w = d00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s5;
        String s3;
        String s1;
        ArrayList arrayList0 = b.m(object0);
        h0 h00 = this.r;
        MyMusicHomeReq myMusicHomeReq0 = new MyMusicHomeReq(h00.a);
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(myMusicHomeReq0).tag("MelonLibrarySessionCallback").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        MyMusicHomeRes myMusicHomeRes0 = httpResponse0 instanceof MyMusicHomeRes ? ((MyMusicHomeRes)httpResponse0) : null;
        if(myMusicHomeRes0 != null) {
            RESPONSE myMusicHomeRes$RESPONSE0 = myMusicHomeRes0.response;
            if(myMusicHomeRes$RESPONSE0 != null) {
                String s = myMusicHomeRes$RESPONSE0.menuId;
                if(s == null) {
                    s1 = "1000003107";
                }
                else {
                    if(s.length() == 0) {
                        s = "1000003107";
                    }
                    s1 = s;
                }
                Iterator iterator0 = myMusicHomeRes$RESPONSE0.slotList.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    SLOTLIST myMusicHomeRes$SLOTLIST0 = (SLOTLIST)object1;
                    q.d(myMusicHomeRes$SLOTLIST0);
                    String s2 = myMusicHomeRes$SLOTLIST0.apiKey;
                    if(s2 == null) {
                        s3 = "MADE_BY_ME";
                    }
                    else {
                        switch(s2) {
                            case "dj": {
                                s3 = "DJ";
                                break;
                            }
                            case "like": {
                                s3 = "LIKE";
                                break;
                            }
                            case "recent": {
                                s3 = "RECENT";
                            }
                        }
                    }
                    if(q.b(myMusicHomeRes$SLOTLIST0.apiType, "P")) {
                        String s4 = myMusicHomeRes$SLOTLIST0.title;
                        q.f(s4, "title");
                        s5 = f.b(new String[]{"[PLAY][DRAWER]", s1, s3, "", "", s4});
                    }
                    else {
                        s5 = f.b(new String[]{"[LIST][DRAWER]", s3, StringUtils.getEncodeUTF8(myMusicHomeRes$SLOTLIST0.apiUrl)});
                    }
                    String s6 = myMusicHomeRes$SLOTLIST0.title;
                    q.f(s6, "title");
                    arrayList0.add(f.a(s6, s5, q.b(myMusicHomeRes$SLOTLIST0.apiType, "P"), !q.b(myMusicHomeRes$SLOTLIST0.apiType, "P"), (q.b(myMusicHomeRes$SLOTLIST0.apiType, "P") ? 13 : 24), null, h0.a(h00, myMusicHomeRes$SLOTLIST0.imgUrl), 0x17E0));
                }
            }
        }
        return r.c(arrayList0, this.w);
    }
}

