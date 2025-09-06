package z9;

import U4.x;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes.Response.GNRCODELIST;
import com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes.Response;
import com.iloen.melon.net.v4x.response.SettingGnrListExcGnrRes;
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
import oe.c;
import y8.b;

public final class f implements g {
    public final String a;
    public final LogU b;
    public final CoroutineDispatcher c;
    public final r d;

    public f(String s) {
        q.g(s, "memberKey");
        super();
        this.a = s;
        this.b = new LogU("ExcludedGenreSyncExecutor");
        this.c = Dispatchers.getIO();
        this.d = d3.g.Q(new b(9));
    }

    @Override  // z9.g
    public final String a(HttpResponse httpResponse0) {
        SettingGnrListExcGnrRes settingGnrListExcGnrRes0 = (SettingGnrListExcGnrRes)httpResponse0;
        return "";
    }

    @Override  // z9.g
    public final Object b(String s, M m0) {
        return H.a;
    }

    @Override  // z9.g
    public final void c(HttpResponse httpResponse0) {
        SettingGnrListExcGnrRes settingGnrListExcGnrRes0 = (SettingGnrListExcGnrRes)httpResponse0;
    }

    @Override  // z9.g
    public final Object d(HttpResponse httpResponse0, String s, M m0) {
        return this.g(((SettingGnrListExcGnrRes)httpResponse0), m0);
    }

    @Override  // z9.g
    public final String e(HttpResponse httpResponse0) {
        Response settingGnrListExcGnrRes$Response0 = ((SettingGnrListExcGnrRes)httpResponse0).response;
        return settingGnrListExcGnrRes$Response0 == null ? "" : settingGnrListExcGnrRes$Response0.menuId;
    }

    @Override  // z9.g
    public final Object f(String s, M m0) {
        e e0 = new e(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        return BuildersKt.withContext(this.c, e0, m0);
    }

    public final Object g(SettingGnrListExcGnrRes settingGnrListExcGnrRes0, c c0) {
        Iterator iterator1;
        ArrayList arrayList1;
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.G;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.G = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.D;
        a a0 = a.a;
        r r0 = this.d;
        String s = this.a;
        H h0 = H.a;
        switch(d0.G) {
            case 0: {
                n.D(object0);
                if(settingGnrListExcGnrRes0.response == null) {
                    return h0;
                }
                if(settingGnrListExcGnrRes0.isSuccessful(false)) {
                    w9.c c1 = (w9.c)r0.getValue();
                    d0.r = settingGnrListExcGnrRes0;
                    d0.G = 1;
                    if(c1.h(s, d0) == a0) {
                        return a0;
                    }
                }
                goto label_27;
            }
            case 1: {
                settingGnrListExcGnrRes0 = d0.r;
                n.D(object0);
            label_27:
                ArrayList arrayList0 = settingGnrListExcGnrRes0.response.gnrCodeList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    Iterator iterator0 = arrayList0.iterator();
                    q.f(iterator0, "iterator(...)");
                    arrayList1 = arrayList0;
                    iterator1 = iterator0;
                    goto label_37;
                }
                break;
            }
            case 2: {
                iterator1 = d0.B;
                arrayList1 = d0.w;
                n.D(object0);
            label_37:
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    y9.b b0 = new y9.b();
                    q.g(s, "<set-?>");
                    b0.j = s;
                    String s1 = ((GNRCODELIST)object1).gnrMenuSeq;
                    q.f(s1, "gnrMenuSeq");
                    b0.b = s1;
                    String s2 = ((GNRCODELIST)object1).gnrCode;
                    q.f(s2, "gnrCode");
                    b0.c = s2;
                    String s3 = ((GNRCODELIST)object1).gnrName;
                    q.f(s3, "gnrName");
                    b0.d = s3;
                    String s4 = ((GNRCODELIST)object1).gnrNameFull;
                    q.f(s4, "gnrNameFull");
                    b0.e = s4;
                    String s5 = ((GNRCODELIST)object1).gnrNameFull;
                    q.f(s5, "gnrNameFull");
                    b0.f = s5;
                    String s6 = ((GNRCODELIST)object1).bgImgUrl;
                    q.f(s6, "bgImgUrl");
                    b0.g = s6;
                    String s7 = ((GNRCODELIST)object1).bgColor;
                    q.f(s7, "bgColor");
                    b0.h = s7;
                    String s8 = ((GNRCODELIST)object1).fontColor;
                    q.f(s8, "fontColor");
                    b0.i = s8;
                    w9.c c2 = (w9.c)r0.getValue();
                    d0.r = null;
                    d0.w = arrayList1;
                    d0.B = iterator1;
                    d0.G = 2;
                    if(c2.d(b0, d0) != a0) {
                        continue;
                    }
                    return a0;
                }
                LogU.debug$default(this.b, x.e(arrayList1.size(), "onUpdateUserData() - user : "), null, false, 6, null);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

