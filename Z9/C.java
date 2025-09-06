package z9;

import android.text.TextUtils;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.InformExcArtistRes.Response.ARTISTLIST;
import com.iloen.melon.net.v4x.response.InformExcArtistRes.Response;
import com.iloen.melon.net.v4x.response.InformExcArtistRes;
import com.iloen.melon.userstore.entity.ExcludedArtistEntity;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import y8.b;

public final class c implements g {
    public final String a;
    public final LogU b;
    public final CoroutineDispatcher c;
    public final r d;

    public c(String s) {
        q.g(s, "memberKey");
        super();
        this.a = s;
        this.b = new LogU("ExcludedArtistSyncExecutor");
        this.c = Dispatchers.getIO();
        this.d = d3.g.Q(new b(8));
    }

    @Override  // z9.g
    public final String a(HttpResponse httpResponse0) {
        Response informExcArtistRes$Response0 = ((InformExcArtistRes)httpResponse0).response;
        return informExcArtistRes$Response0 == null ? "" : informExcArtistRes$Response0.serverDateTime;
    }

    @Override  // z9.g
    public final Object b(String s, M m0) {
        if(s != null) {
            Object object0 = ((w9.c)this.d.getValue()).c(this.a, s, m0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // z9.g
    public final void c(HttpResponse httpResponse0) {
        InformExcArtistRes informExcArtistRes0 = (InformExcArtistRes)httpResponse0;
    }

    @Override  // z9.g
    public final Object d(HttpResponse httpResponse0, String s, M m0) {
        return this.g(((InformExcArtistRes)httpResponse0), s, m0);
    }

    @Override  // z9.g
    public final String e(HttpResponse httpResponse0) {
        Response informExcArtistRes$Response0 = ((InformExcArtistRes)httpResponse0).response;
        return informExcArtistRes$Response0 == null ? "" : informExcArtistRes$Response0.menuId;
    }

    @Override  // z9.g
    public final Object f(String s, M m0) {
        z9.b b0 = new z9.b(s, null);
        return BuildersKt.withContext(this.c, b0, m0);
    }

    public final Object g(InformExcArtistRes informExcArtistRes0, String s, oe.c c0) {
        String s1;
        Iterator iterator1;
        ArrayList arrayList1;
        z9.a a0;
        if(c0 instanceof z9.a) {
            a0 = (z9.a)c0;
            int v = a0.G;
            if((v & 0x80000000) == 0) {
                a0 = new z9.a(this, c0);
            }
            else {
                a0.G = v ^ 0x80000000;
            }
        }
        else {
            a0 = new z9.a(this, c0);
        }
        Object object0 = a0.D;
        a a1 = a.a;
        switch(a0.G) {
            case 0: {
                n.D(object0);
                if(informExcArtistRes0.response == null || TextUtils.isEmpty(s)) {
                    throw new IllegalArgumentException("Invalid params.");
                }
                ArrayList arrayList0 = informExcArtistRes0.response.artistList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    Iterator iterator0 = arrayList0.iterator();
                    q.f(iterator0, "iterator(...)");
                    arrayList1 = arrayList0;
                    iterator1 = iterator0;
                    s1 = s;
                    goto label_29;
                }
                break;
            }
            case 1: 
            case 2: {
                iterator1 = a0.B;
                arrayList1 = a0.w;
                String s2 = a0.r;
                n.D(object0);
                s1 = s2;
            label_29:
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    ARTISTLIST informExcArtistRes$Response$ARTISTLIST0 = (ARTISTLIST)object1;
                    ExcludedArtistEntity excludedArtistEntity0 = new ExcludedArtistEntity();
                    String s3 = this.a;
                    q.g(s3, "<set-?>");
                    excludedArtistEntity0.j = s3;
                    String s4 = informExcArtistRes$Response$ARTISTLIST0.artistId;
                    q.f(s4, "artistId");
                    excludedArtistEntity0.b = s4;
                    String s5 = informExcArtistRes$Response$ARTISTLIST0.artistName;
                    q.f(s5, "artistName");
                    excludedArtistEntity0.c = s5;
                    String s6 = informExcArtistRes$Response$ARTISTLIST0.artistImg;
                    q.f(s6, "artistImg");
                    excludedArtistEntity0.d = s6;
                    String s7 = informExcArtistRes$Response$ARTISTLIST0.excArtistSeq;
                    q.f(s7, "excArtistSeq");
                    excludedArtistEntity0.e = s7;
                    excludedArtistEntity0.f = "Y".equals(informExcArtistRes$Response$ARTISTLIST0.delYN);
                    String s8 = informExcArtistRes$Response$ARTISTLIST0.actGenre;
                    q.f(s8, "actGenre");
                    excludedArtistEntity0.g = s8;
                    String s9 = informExcArtistRes$Response$ARTISTLIST0.updtDate;
                    q.f(s9, "updtDate");
                    excludedArtistEntity0.h = s9;
                    excludedArtistEntity0.i = s1;
                    boolean z = "Y".equals(informExcArtistRes$Response$ARTISTLIST0.delYN);
                    r r0 = this.d;
                    if(z) {
                        w9.c c1 = (w9.c)r0.getValue();
                        String s10 = informExcArtistRes$Response$ARTISTLIST0.artistId;
                        q.f(s10, "artistId");
                        a0.r = s1;
                        a0.w = arrayList1;
                        a0.B = iterator1;
                        a0.G = 1;
                        if(c1.f(s3, s10, a0) != a1) {
                            continue;
                        }
                        return a1;
                    }
                    w9.c c2 = (w9.c)r0.getValue();
                    a0.r = s1;
                    a0.w = arrayList1;
                    a0.B = iterator1;
                    a0.G = 2;
                    if(c2.e(excludedArtistEntity0, a0) == a1) {
                        return a1;
                    }
                    if(false) {
                        break;
                    }
                }
                LogU.debug$default(this.b, H0.b.f(arrayList1.size(), "onUpdateUserData() - user : ", ", syncTime : ", s1), null, false, 6, null);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

