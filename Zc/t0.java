package Zc;

import Ac.b0;
import Cc.K2;
import Cc.L2;
import Cc.U0;
import Cc.V0;
import Cc.W0;
import Cc.Y0;
import Cc.Z0;
import Cc.a1;
import Dc.i;
import Na.d;
import Na.f;
import Sc.b;
import Vc.C;
import android.content.Context;
import androidx.lifecycle.f0;
import com.iloen.melon.LoginUser;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.BuyingGoodsFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.response.InformArtistRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.iloen.melon.utils.preference.MusicTabPrefsHelper;
import com.iloen.melon.utils.ui.NewUpdateNotiUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.InfoCommerceAndBtnVer6Res.BUTTON;
import com.melon.net.res.InfoCommerceAndBtnVer6Res.CashInfo;
import com.melon.net.res.InfoCommerceAndBtnVer6Res.ProductInfo;
import com.melon.net.res.InfoCommerceAndBtnVer6Res.Response;
import com.melon.net.res.InfoCommerceAndBtnVer6Res;
import com.melon.net.res.MainMenuTabBannerRes.Response.Banner;
import com.melon.net.res.MainMenuTabBannerRes;
import com.melon.net.res.NavigationMenuBenefitRes.MenuItem;
import com.melon.net.res.NavigationMenuBenefitRes;
import com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu;
import com.melon.net.res.NavigationMenuListRes.RESPONSE;
import com.melon.net.res.NavigationMenuListRes;
import com.melon.net.res.RedDotInfo;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import d3.g;
import d5.n;
import e1.m;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import je.p;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import oe.c;
import p8.s;
import va.e0;
import va.e;
import x9.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t¨\u0006\n"}, d2 = {"LZc/t0;", "LSc/b;", "Zc/W", "Zc/Y", "Zc/U", "Zc/S", "Zc/V", "Zc/Z", "Zc/T", "Zc/X", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class t0 extends b {
    public final Context g;
    public final a h;
    public final k i;
    public final StringProviderImpl j;
    public final CoroutineDispatcher k;
    public final LogU l;
    public final r m;
    public s n;
    public String o;
    public final LinkedHashMap p;
    public final LinkedHashSet q;
    public static final int r;

    public t0(Context context0, a a0, k k0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        q.g(context0, "context");
        q.g(k0, "loginUseCase");
        super();
        this.g = context0;
        this.h = a0;
        this.i = k0;
        this.j = stringProviderImpl0;
        this.k = coroutineDispatcher0;
        LogU logU0 = new LogU("TabMenuViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.l = logU0;
        this.m = g.Q(new M(this, 4));
        this.o = "";
        this.p = new LinkedHashMap();
        this.q = new LinkedHashSet();
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new P(this, null), 3, null);
    }

    public static final Object d(t0 t00, c c0) {
        Y y0;
        List list1;
        q0 q00;
        if(c0 instanceof q0) {
            q00 = (q0)c0;
            int v = q00.E;
            if((v & 0x80000000) == 0) {
                q00 = new q0(t00, c0);
            }
            else {
                q00.E = v ^ 0x80000000;
            }
        }
        else {
            q00 = new q0(t00, c0);
        }
        Object object0 = q00.B;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(q00.E) {
            case 0: {
                n.D(object0);
                D d0 = t00.g();
                List list0 = d0 == null ? null : d0.a;
                if(list0 != null && !list0.isEmpty()) {
                    Object object1 = null;
                    for(Object object2: list0) {
                        if(((Y)object2).a == 10) {
                            object1 = object2;
                            break;
                        }
                    }
                    Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(f0.h(t00), null, null, new s0(t00, null), 3, null);
                    q00.r = list0;
                    q00.w = (Y)object1;
                    q00.E = 1;
                    Object object3 = deferred0.await(q00);
                    if(object3 == a0) {
                        return a0;
                    }
                    list1 = list0;
                    object0 = object3;
                    y0 = (Y)object1;
                    goto label_38;
                }
                break;
            }
            case 1: {
                y0 = q00.w;
                list1 = q00.r;
                n.D(object0);
            label_38:
                ArrayList arrayList0 = p.Q0(list1);
                if(y0 == null) {
                    int v1 = 0;
                    Iterator iterator1 = list1.iterator();
                    while(true) {
                        if(!iterator1.hasNext()) {
                            v1 = -1;
                            break;
                        }
                        Object object4 = iterator1.next();
                        if(((Y)object4).a == 4) {
                            break;
                        }
                        ++v1;
                    }
                    arrayList0.add(v1 + 1, new Y(10, new V(((List)object0))));
                    goto label_58;
                }
                else {
                    int v2 = list1.indexOf(y0);
                    if(v2 >= 0) {
                        if(((List)object0).isEmpty()) {
                            arrayList0.remove(v2);
                        }
                        else {
                            V v3 = new V(((List)object0));
                            arrayList0.set(v2, new Y(y0.a, v3));
                        }
                    label_58:
                        if(t00.g() != null) {
                            t00.updateUiState(new L(t00, arrayList0, 1));
                        }
                    }
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    public final S e() {
        q.f("이용권구매", "getString(...)");
        Q q0 = new Q(false, "이용권구매", 0x7F0803AB, new M(this, 0));  // drawable:ic_5tab_menu_pass
        q.f("이벤트", "getString(...)");
        Q q1 = new Q(false, "이벤트", 0x7F0803A3, new M(this, 1));  // drawable:ic_5tab_menu_event
        q.f("고객센터", "getString(...)");
        Q q2 = new Q(false, "고객센터", 0x7F0803A1, new M(this, 2));  // drawable:ic_5tab_menu_customer
        q.f("공지사항", "getString(...)");
        return new S(e.k.C(new Q[]{q0, q1, q2, new Q(true, "공지사항", 0x7F0803AA, new M(this, 3))}));  // drawable:ic_5tab_menu_notice
    }

    public final U f(String s, String s1, String s2, boolean z) {
        return new U(z, s, s1, s2, new M(this, 6));
    }

    public final D g() {
        Object object0 = this.getUiState().getValue();
        return object0 instanceof D ? ((D)object0) : null;
    }

    public final void h(String s, String s1, String s2, RedDotInfo redDotInfo0, String s3) {
        String s5;
        int v = -1;
        String s4 = "";
        if(q.b(s, "melonapp://musicdna/monthlylog?logMonth=")) {
            Calendar calendar0 = Calendar.getInstance();
            calendar0.add(2, -1);
            Date date0 = calendar0.getTime();
            s5 = e.b("melonapp://musicdna/monthlylog?logMonth=", new SimpleDateFormat("yyyyMM", Locale.getDefault()).format(date0));
        }
        else {
            s5 = "";
        }
        if(s5.length() == 0) {
            s5 = s;
        }
        int v1 = 0;
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.a = s2;
        melonLinkInfo0.b = s1;
        melonLinkInfo0.c = s5;
        MelonLinkExecutor.open(melonLinkInfo0);
        List list0 = null;
        String s6 = redDotInfo0 == null ? null : "";
        if(s6 != null) {
            s4 = s6;
        }
        if(s4.length() > 0) {
            q.d(redDotInfo0);
            MusicTabPrefsHelper.INSTANCE.putCommerceRedDot(redDotInfo0);
            D d0 = this.g();
            if(d0 != null) {
                list0 = d0.a;
            }
            if(list0 != null && !list0.isEmpty()) {
                for(Object object0: list0) {
                    Y y0 = (Y)object0;
                    if(y0.a == 6) {
                        q.e(y0.b, "null cannot be cast to non-null type com.melon.ui.main.menu.TabMenuViewModel.MenuData");
                        if(q.b(((T)y0.b).a, s3)) {
                            v = v1;
                            break;
                        }
                    }
                    ++v1;
                }
                if(v >= 0) {
                    Y y1 = (Y)list0.get(v);
                    Object object1 = ((Y)list0.get(v)).b;
                    q.e(object1, "null cannot be cast to non-null type com.melon.ui.main.menu.TabMenuViewModel.MenuData");
                    q.g(((T)object1).a, "menuSeq");
                    q.g(((T)object1).d, "name");
                    q.g(((T)object1).f, "scheme");
                    q.g(((T)object1).g, "linkType");
                    q.g(((T)object1).h, "linkUrl");
                    q.g(((T)object1).i, "copy");
                    q.g(((T)object1).j, "loginYn");
                    T t0 = new T(((T)object1).a, ((T)object1).b, ((T)object1).c, ((T)object1).d, false, ((T)object1).f, ((T)object1).g, ((T)object1).h, ((T)object1).i, ((T)object1).j, ((T)object1).k, ((T)object1).l);
                    Y y2 = new Y(y1.a, t0);
                    ArrayList arrayList0 = p.Q0(list0);
                    arrayList0.set(v, y2);
                    if(this.g() != null) {
                        this.updateUiState(new L(this, arrayList0, 0));
                    }
                }
            }
        }
    }

    public final boolean i() {
        return ((e0)this.i).m();
    }

    public static void j(t0 t00, ActionKind actionKind0, String s, String s1, String s2, String s3, String s4, String s5, int v) {
        if((v & 1) != 0) {
            actionKind0 = null;
        }
        String s6 = (v & 0x80) == 0 ? s5 : "";
        t00.getClass();
        q.g(s, "layer1");
        q.g(s2, "copy");
        q.g(s6, "metaName");
        s s7 = t00.n;
        if(s7 != null) {
            m.F(new K((v & 16) == 0, t00, actionKind0, s7, ((v & 4) == 0 ? s1 : ""), s, s2, ((v & 0x20) == 0 ? s3 : ""), ((v & 0x40) == 0 ? s4 : ""), s6)).track();
        }
    }

    public final Object k(f f0, InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res0, NavigationMenuBenefitRes navigationMenuBenefitRes0, MainMenuTabBannerRes mainMenuTabBannerRes0, U u0, V v0, c c0) {
        ArrayList arrayList17;
        ArrayList arrayList16;
        ArrayList arrayList10;
        NavigationMenuBenefitRes navigationMenuBenefitRes1;
        List list2;
        ArrayList arrayList9;
        int v9;
        NavigationMenuListRes navigationMenuListRes1;
        int v6;
        ArrayList arrayList5;
        ArrayList arrayList4;
        ArrayList arrayList3;
        List list0;
        L2 l20;
        ArrayList arrayList2;
        ne.a a1;
        String s7;
        ArrayList arrayList1;
        String s5;
        String s4;
        String s3;
        String s2;
        String s1;
        NavigationMenuListRes navigationMenuListRes0;
        n0 n00;
        if(c0 instanceof n0) {
            n00 = (n0)c0;
            int v1 = n00.N;
            if((v1 & 0x80000000) == 0) {
                n00 = new n0(this, c0);
            }
            else {
                n00.N = v1 ^ 0x80000000;
            }
        }
        else {
            n00 = new n0(this, c0);
        }
        Object object0 = n00.I;
        ne.a a0 = ne.a.a;
        LinkedHashSet linkedHashSet0 = this.q;
        switch(n00.N) {
            case 0: {
                n.D(object0);
                k k0 = this.i;
                if(!(f0 instanceof Na.e)) {
                    goto label_200;
                }
                navigationMenuListRes0 = (NavigationMenuListRes)((Na.e)f0).a;
                this.performLogging(navigationMenuListRes0, new Q0.n(0, 1, t0.class, this, "isFragmentVisible", "isFragmentVisible()Z"));
                RESPONSE navigationMenuListRes$RESPONSE0 = navigationMenuListRes0.getResponse();
                RESPONSE navigationMenuListRes$RESPONSE1 = navigationMenuListRes0.getResponse();
                RESPONSE navigationMenuListRes$RESPONSE2 = navigationMenuListRes0.getResponse();
                this.n = new s((navigationMenuListRes$RESPONSE0 == null ? null : navigationMenuListRes$RESPONSE0.section), (navigationMenuListRes$RESPONSE1 == null ? null : navigationMenuListRes$RESPONSE1.page), (navigationMenuListRes$RESPONSE2 == null ? null : navigationMenuListRes$RESPONSE2.menuId), null);
                E e0 = (E)this.m.getValue();
                e0.b = this.n;
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(new Y(0, u0));
                Response infoCommerceAndBtnVer6Res$Response0 = infoCommerceAndBtnVer6Res0 == null ? null : infoCommerceAndBtnVer6Res0.getResponse();
                if(infoCommerceAndBtnVer6Res$Response0 == null) {
                    arrayList2 = arrayList0;
                    a1 = a0;
                    l20 = new L2(new M(this, 5));
                }
                else {
                    ProductInfo infoCommerceAndBtnVer6Res$ProductInfo0 = infoCommerceAndBtnVer6Res$Response0.getProductInfo();
                    CashInfo infoCommerceAndBtnVer6Res$CashInfo0 = infoCommerceAndBtnVer6Res$Response0.getCashInfo();
                    if(infoCommerceAndBtnVer6Res$ProductInfo0 == null) {
                        s1 = "";
                    }
                    else {
                        String s = infoCommerceAndBtnVer6Res$ProductInfo0.getProductName();
                        s1 = s == null ? "" : s;
                    }
                    int v2 = infoCommerceAndBtnVer6Res$ProductInfo0 == null ? 0 : infoCommerceAndBtnVer6Res$ProductInfo0.getProductCount();
                    if(infoCommerceAndBtnVer6Res$ProductInfo0 == null) {
                        s2 = "";
                    }
                    else {
                        BUTTON infoCommerceAndBtnVer6Res$BUTTON0 = infoCommerceAndBtnVer6Res$ProductInfo0.getButton();
                        if(infoCommerceAndBtnVer6Res$BUTTON0 == null) {
                            s2 = "";
                        }
                        else {
                            s2 = infoCommerceAndBtnVer6Res$BUTTON0.linktype;
                            if(s2 == null) {
                                s2 = "";
                            }
                        }
                    }
                    if(infoCommerceAndBtnVer6Res$ProductInfo0 == null) {
                        s3 = "";
                    }
                    else {
                        BUTTON infoCommerceAndBtnVer6Res$BUTTON1 = infoCommerceAndBtnVer6Res$ProductInfo0.getButton();
                        if(infoCommerceAndBtnVer6Res$BUTTON1 == null) {
                            s3 = "";
                        }
                        else {
                            s3 = infoCommerceAndBtnVer6Res$BUTTON1.linkurl;
                            if(s3 == null) {
                                s3 = "";
                            }
                        }
                    }
                    if(infoCommerceAndBtnVer6Res$ProductInfo0 == null) {
                        s4 = "";
                    }
                    else {
                        BUTTON infoCommerceAndBtnVer6Res$BUTTON2 = infoCommerceAndBtnVer6Res$ProductInfo0.getButton();
                        if(infoCommerceAndBtnVer6Res$BUTTON2 == null) {
                            s4 = "";
                        }
                        else {
                            s4 = infoCommerceAndBtnVer6Res$BUTTON2.getLinkTypeToBuyInfo();
                            if(s4 == null) {
                                s4 = "";
                            }
                        }
                    }
                    if(infoCommerceAndBtnVer6Res$ProductInfo0 == null) {
                        s5 = "";
                    }
                    else {
                        BUTTON infoCommerceAndBtnVer6Res$BUTTON3 = infoCommerceAndBtnVer6Res$ProductInfo0.getButton();
                        if(infoCommerceAndBtnVer6Res$BUTTON3 == null) {
                            s5 = "";
                        }
                        else {
                            s5 = infoCommerceAndBtnVer6Res$BUTTON3.getLinkUrlToBuyInfo();
                            if(s5 == null) {
                                s5 = "";
                            }
                        }
                    }
                    String s6 = infoCommerceAndBtnVer6Res$Response0.getUserGrade();
                    Y0 y00 = Y0.c;
                    if(s6 == null) {
                    label_89:
                        arrayList1 = arrayList0;
                        s7 = s5;
                        H0.b.w("from() Invalid params: ", s6, LogU.Companion, "Grade");
                    }
                    else {
                        switch(s6) {
                            case "GOLD": {
                                y00 = U0.c;
                                break;
                            }
                            case "GREEN": {
                                y00 = V0.c;
                                break;
                            }
                            case "MVIP": {
                                y00 = W0.c;
                                break;
                            }
                            case "NORMAL": {
                                break;
                            }
                            case "SILVER": {
                                y00 = Z0.c;
                                break;
                            }
                            case "VIP": {
                                y00 = a1.c;
                                break;
                            }
                            default: {
                                goto label_89;
                            }
                        }
                        arrayList1 = arrayList0;
                        s7 = s5;
                    }
                    a1 = a0;
                    arrayList2 = arrayList1;
                    l20 = new K2(y00, s1, v2, infoCommerceAndBtnVer6Res$CashInfo0, (infoCommerceAndBtnVer6Res$CashInfo0 == null ? 0 : infoCommerceAndBtnVer6Res$CashInfo0.getCash()), new i(29, this, infoCommerceAndBtnVer6Res$Response0), new C(v2, s4, s2, s7, s3, this), new N(0, this, infoCommerceAndBtnVer6Res$CashInfo0));
                }
                arrayList2.add(new Y(1, l20));
                if(mainMenuTabBannerRes0 == null) {
                    list0 = null;
                }
                else {
                    com.melon.net.res.MainMenuTabBannerRes.Response mainMenuTabBannerRes$Response0 = mainMenuTabBannerRes0.getResponse();
                    list0 = mainMenuTabBannerRes$Response0 == null ? null : mainMenuTabBannerRes$Response0.getBannerList();
                }
                if(list0 != null && !list0.isEmpty()) {
                    arrayList2.add(new Y(2, ((Banner)list0.get(0))));
                }
                arrayList2.add(new Y(3, this.e()));
                arrayList2.add(new Y(4, null));
                RESPONSE navigationMenuListRes$RESPONSE3 = navigationMenuListRes0.getResponse();
                arrayList3 = navigationMenuListRes$RESPONSE3 == null ? null : navigationMenuListRes$RESPONSE3.getList();
                linkedHashSet0.clear();
                if(arrayList3 != null) {
                    int v3 = 0;
                    for(Object object1: arrayList3) {
                        if(v3 >= 0) {
                            if(q.b(((Menu)object1).getGroupType(), "GIFT")) {
                                if(navigationMenuBenefitRes0 == null) {
                                    arrayList4 = null;
                                }
                                else {
                                    com.melon.net.res.NavigationMenuBenefitRes.Response navigationMenuBenefitRes$Response0 = navigationMenuBenefitRes0.getResponse();
                                    if(navigationMenuBenefitRes$Response0 != null) {
                                        arrayList4 = navigationMenuBenefitRes$Response0.getMenuList();
                                    }
                                }
                                if(arrayList4 != null && !arrayList4.isEmpty()) {
                                    if(navigationMenuBenefitRes0 == null) {
                                        arrayList5 = null;
                                    }
                                    else {
                                        com.melon.net.res.NavigationMenuBenefitRes.Response navigationMenuBenefitRes$Response1 = navigationMenuBenefitRes0.getResponse();
                                        if(navigationMenuBenefitRes$Response1 != null) {
                                            arrayList5 = navigationMenuBenefitRes$Response1.getMenuList();
                                        }
                                    }
                                    q.d(arrayList5);
                                    int v4 = 0;
                                    for(Object object2: arrayList5) {
                                        if(v4 >= 0) {
                                            String s8 = ((MenuItem)object2).getSeq();
                                            if(s8 == null) {
                                                s8 = "";
                                            }
                                            linkedHashSet0.add(s8);
                                            ++v4;
                                            continue;
                                        }
                                        e.k.O();
                                        throw null;
                                    }
                                }
                            }
                            else {
                                ArrayList arrayList6 = ((Menu)object1).getMenuList();
                                if(arrayList6 != null) {
                                    int v5 = 0;
                                    for(Object object3: arrayList6) {
                                        if(v5 >= 0) {
                                            String s9 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object3).getSeq();
                                            if(s9 == null) {
                                                s9 = "";
                                            }
                                            linkedHashSet0.add(s9);
                                            ++v5;
                                            continue;
                                        }
                                        e.k.O();
                                        throw null;
                                    }
                                }
                            }
                            ++v3;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                }
                List list1 = v0 == null ? null : v0.a;
                if(list1 == null || list1.isEmpty()) {
                    navigationMenuBenefitRes1 = navigationMenuBenefitRes0;
                    break;
                label_200:
                    if(!(f0 instanceof d)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    boolean z = this.i();
                    if(!z) {
                        v6 = 0x7F130AB8;  // string:tab_menu_button_login "로그인"
                    }
                    else if(u.F(((e0)k0).j())) {
                        v6 = 0x7F130AB7;  // string:tab_menu_button_artist "내 채널"
                    }
                    else {
                        v6 = 0x7F130AB9;  // string:tab_menu_button_profile "내 프로필"
                    }
                    ArrayList arrayList11 = new ArrayList();
                    arrayList11.add(new Y(0, this.f("-", "", ResourceUtilsKt.getString(v6, new Object[0]), z)));
                    arrayList11.add(new Y(3, this.e()));
                    arrayList11.add(new Y(4, null));
                    MelonAppBase.Companion.getClass();
                    InputStream inputStream0 = t.a().getContext().getResources().openRawResource(0x7F120002);  // raw:default_tab_menu
                    q.f(inputStream0, "openRawResource(...)");
                    try {
                        Object object5 = new com.google.gson.n().c(a.a.J(new InputStreamReader(inputStream0)), NavigationMenuListRes.class);
                        q.f(object5, "fromJson(...)");
                        navigationMenuListRes1 = (NavigationMenuListRes)object5;
                    }
                    catch(Throwable throwable0) {
                        d8.d.l(inputStream0, throwable0);
                        throw throwable0;
                    }
                    inputStream0.close();
                    RESPONSE navigationMenuListRes$RESPONSE4 = navigationMenuListRes1.getResponse();
                    ArrayList arrayList12 = navigationMenuListRes$RESPONSE4 == null ? null : navigationMenuListRes$RESPONSE4.getList();
                    if(arrayList12 != null) {
                        int v7 = 0;
                        for(Object object6: arrayList12) {
                            if(v7 >= 0) {
                                String s10 = ((Menu)object6).getMenuGroup();
                                if(s10 == null) {
                                    s10 = "";
                                }
                                arrayList11.add(new Y(5, new Z(s10, v7 == 0)));
                                ArrayList arrayList13 = ((Menu)object6).getMenuList();
                                if(arrayList13 != null) {
                                    int v8 = 0;
                                    for(Object object7: arrayList13) {
                                        if(v8 >= 0) {
                                            String s11 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object7).getImgUrl();
                                            if(s11 == null) {
                                                s11 = "";
                                            }
                                            switch(s11) {
                                                case "ic_5tab_menu_chart": {
                                                    v9 = 0x7F0803A0;  // drawable:ic_5tab_menu_chart
                                                    break;
                                                }
                                                case "ic_5tab_menu_dna": {
                                                    v9 = 0x7F0803A2;  // drawable:ic_5tab_menu_dna
                                                    break;
                                                }
                                                case "ic_5tab_menu_genre": {
                                                    v9 = 0x7F0803A4;  // drawable:ic_5tab_menu_genre
                                                    break;
                                                }
                                                case "ic_5tab_menu_melondj": {
                                                    v9 = 0x7F0803A6;  // drawable:ic_5tab_menu_melondj
                                                    break;
                                                }
                                                case "ic_5tab_menu_melontv": {
                                                    v9 = 0x7F0803A7;  // drawable:ic_5tab_menu_melontv
                                                    break;
                                                }
                                                case "ic_5tab_menu_mixmaker": {
                                                    v9 = 0x7F0803A8;  // drawable:ic_5tab_menu_mixmaker
                                                    break;
                                                }
                                                case "ic_5tab_menu_newrelease": {
                                                    v9 = 0x7F0803A9;  // drawable:ic_5tab_menu_newrelease
                                                    break;
                                                }
                                                case "ic_5tab_menu_shortmusic": {
                                                    v9 = 0x7F0803AC;  // drawable:ic_5tab_menu_shortmusic
                                                    break;
                                                }
                                                case "ic_5tab_menu_station": {
                                                    v9 = 0x7F0803AD;  // drawable:ic_5tab_menu_station
                                                    break;
                                                }
                                                default: {
                                                    v9 = 0x7F0803A5;  // drawable:ic_5tab_menu_log
                                                }
                                            }
                                            String s12 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object7).getTitle();
                                            String s13 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object7).getCopy();
                                            boolean z1 = q.b("N", "Y");
                                            String s14 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object7).scheme;
                                            String s15 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object7).linktype;
                                            String s16 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object7).linkurl;
                                            arrayList11.add(new Y(6, new T(null, new Integer(v9), new Integer(v9), (s12 == null ? "" : s12), z1, (s14 == null ? "" : s14), (s15 == null ? "" : s15), (s16 == null ? "" : s16), (s13 == null ? "" : s13), "N", v8, 0x401)));
                                            ++v8;
                                            continue;
                                        }
                                        e.k.O();
                                        throw null;
                                    }
                                }
                                ++v7;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                    }
                    arrayList11.add(new Y(9, null));
                    this.updateUiState(new b0(11, arrayList11));
                    return H.a;
                }
                else {
                    ArrayList arrayList7 = new ArrayList(je.q.Q(10, list1));
                    Iterator iterator3 = list1.iterator();
                    while(iterator3.hasNext()) {
                        iterator3.next();
                        arrayList7.add("");
                    }
                    ArrayList arrayList8 = new ArrayList();
                    for(Object object4: arrayList7) {
                        if(!linkedHashSet0.contains(((String)object4))) {
                            arrayList8.add(object4);
                        }
                    }
                    o0 o00 = new o0(this, arrayList8, u.v(((e0)k0).j()), null);
                    n00.r = navigationMenuBenefitRes0;
                    n00.w = v0;
                    n00.B = navigationMenuListRes0;
                    n00.D = arrayList2;
                    n00.E = arrayList3;
                    n00.G = list1;
                    n00.N = 1;
                    if(BuildersKt.withContext(Dispatchers.getIO(), o00, n00) == a1) {
                        return a1;
                    }
                    arrayList9 = arrayList3;
                    list2 = list1;
                    navigationMenuBenefitRes1 = navigationMenuBenefitRes0;
                    arrayList10 = arrayList2;
                    goto label_295;
                }
                break;
            }
            case 1: {
                list2 = n00.G;
                ArrayList arrayList14 = n00.E;
                arrayList10 = n00.D;
                NavigationMenuListRes navigationMenuListRes2 = n00.B;
                V v10 = n00.w;
                navigationMenuBenefitRes1 = n00.r;
                n.D(object0);
                arrayList9 = arrayList14;
                navigationMenuListRes0 = navigationMenuListRes2;
                v0 = v10;
            label_295:
                ArrayList arrayList15 = new ArrayList();
                for(Object object8: list2) {
                    if(linkedHashSet0.contains("")) {
                        arrayList15.add(object8);
                    }
                }
                if(!arrayList15.isEmpty()) {
                    v0.getClass();
                    arrayList10.add(new Y(10, new V(arrayList15)));
                }
                arrayList3 = arrayList9;
                arrayList2 = arrayList10;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(arrayList3 != null) {
            int v11 = 0;
            for(Object object9: arrayList3) {
                if(v11 >= 0) {
                    Menu navigationMenuListRes$RESPONSE$Menu0 = (Menu)object9;
                    boolean z2 = q.b(navigationMenuListRes$RESPONSE$Menu0.getGroupType(), "GIFT");
                    LinkedHashMap linkedHashMap0 = this.p;
                    if(z2) {
                        if(navigationMenuBenefitRes1 == null) {
                            arrayList16 = null;
                        }
                        else {
                            com.melon.net.res.NavigationMenuBenefitRes.Response navigationMenuBenefitRes$Response2 = navigationMenuBenefitRes1.getResponse();
                            if(navigationMenuBenefitRes$Response2 != null) {
                                arrayList16 = navigationMenuBenefitRes$Response2.getMenuList();
                            }
                        }
                        if(arrayList16 != null && !arrayList16.isEmpty()) {
                            if(navigationMenuBenefitRes1 == null) {
                                arrayList17 = null;
                            }
                            else {
                                com.melon.net.res.NavigationMenuBenefitRes.Response navigationMenuBenefitRes$Response3 = navigationMenuBenefitRes1.getResponse();
                                if(navigationMenuBenefitRes$Response3 != null) {
                                    arrayList17 = navigationMenuBenefitRes$Response3.getMenuList();
                                }
                            }
                            q.d(arrayList17);
                            arrayList2.add(new Y(5, new Z((navigationMenuListRes$RESPONSE$Menu0.getMenuGroup() == null ? "" : navigationMenuListRes$RESPONSE$Menu0.getMenuGroup()), v11 == 0)));
                            int v12 = 0;
                            for(Object object10: arrayList17) {
                                if(v12 >= 0) {
                                    String s17 = ((MenuItem)object10).getSeq();
                                    boolean z3 = q.b("N", "Y");
                                    String s18 = ((MenuItem)object10).scheme;
                                    String s19 = ((MenuItem)object10).linktype;
                                    String s20 = ((MenuItem)object10).linkurl;
                                    T t0 = new T((s17 == null ? "" : s17), "", "", "", z3, (s18 == null ? "" : s18), (s19 == null ? "" : s19), (s20 == null ? "" : s20), "", "N", ((MenuItem)object10).getRedDotInfo(), v12);
                                    t0.m = navigationMenuListRes$RESPONSE$Menu0.getLayer1() == null ? "" : navigationMenuListRes$RESPONSE$Menu0.getLayer1();
                                    arrayList2.add(new Y(6, t0));
                                    String s21 = ((MenuItem)object10).getSeq();
                                    if(s21 == null) {
                                        s21 = "";
                                    }
                                    String s22 = ((MenuItem)object10).getSeq();
                                    String s23 = ((MenuItem)object10).scheme;
                                    String s24 = ((MenuItem)object10).linktype;
                                    String s25 = ((MenuItem)object10).linkurl;
                                    linkedHashMap0.put(s21, new W((s22 == null ? "" : s22), "", "", (s23 == null ? "" : s23), (s24 == null ? "" : s24), (s25 == null ? "" : s25), ((MenuItem)object10).getRedDotInfo()));
                                    ++v12;
                                    continue;
                                }
                                e.k.O();
                                throw null;
                            }
                        }
                        if(navigationMenuBenefitRes1 != null) {
                            com.melon.net.res.NavigationMenuBenefitRes.Response navigationMenuBenefitRes$Response4 = navigationMenuBenefitRes1.getResponse();
                            if(navigationMenuBenefitRes$Response4 != null) {
                                ArrayList arrayList18 = navigationMenuBenefitRes$Response4.getExpiredRedDotIds();
                                if(arrayList18 != null) {
                                    MusicTabPrefsHelper.INSTANCE.removeCommerceRedDot(arrayList18);
                                }
                            }
                        }
                    }
                    else {
                        arrayList2.add(new Y(5, new Z((navigationMenuListRes$RESPONSE$Menu0.getMenuGroup() == null ? "" : navigationMenuListRes$RESPONSE$Menu0.getMenuGroup()), v11 == 0)));
                        ArrayList arrayList19 = navigationMenuListRes$RESPONSE$Menu0.getMenuList();
                        if(arrayList19 != null) {
                            int v13 = 0;
                            for(Object object11: arrayList19) {
                                if(v13 >= 0) {
                                    String s26 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getSeq();
                                    String s27 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getDarkImgUrl();
                                    String s28 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getImgUrl();
                                    String s29 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getTitle();
                                    String s30 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getCopy();
                                    boolean z4 = q.b("N", "Y");
                                    String s31 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).scheme;
                                    String s32 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).linktype;
                                    String s33 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).linkurl;
                                    T t1 = new T((s26 == null ? "" : s26), s27, s28, (s29 == null ? "" : s29), z4, (s31 == null ? "" : s31), (s32 == null ? "" : s32), (s33 == null ? "" : s33), (s30 == null ? "" : s30), "N", v13, 0x400);
                                    t1.m = navigationMenuListRes$RESPONSE$Menu0.getLayer1() == null ? "" : navigationMenuListRes$RESPONSE$Menu0.getLayer1();
                                    arrayList2.add(new Y(6, t1));
                                    String s34 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getSeq();
                                    if(s34 == null) {
                                        s34 = "";
                                    }
                                    String s35 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getSeq();
                                    String s36 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getCopy();
                                    String s37 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).getTitle();
                                    String s38 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).scheme;
                                    String s39 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).linktype;
                                    String s40 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object11).linkurl;
                                    linkedHashMap0.put(s34, new W((s35 == null ? "" : s35), (s36 == null ? "" : s36), (s37 == null ? "" : s37), (s38 == null ? "" : s38), (s39 == null ? "" : s39), (s40 == null ? "" : s40), null));
                                    ++v13;
                                    continue;
                                }
                                e.k.O();
                                throw null;
                            }
                        }
                    }
                    ++v11;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        arrayList2.add(new Y(7, null));
        RESPONSE navigationMenuListRes$RESPONSE5 = navigationMenuListRes0.getResponse();
        ArrayList arrayList20 = navigationMenuListRes$RESPONSE5 == null ? null : navigationMenuListRes$RESPONSE5.getSnsList();
        if(arrayList20 != null && !arrayList20.isEmpty()) {
            Menu navigationMenuListRes$RESPONSE$Menu1 = (Menu)arrayList20.get(0);
            ArrayList arrayList21 = new ArrayList();
            ArrayList arrayList22 = navigationMenuListRes$RESPONSE$Menu1.getMenuList();
            if(arrayList22 != null) {
                int v14 = 0;
                for(Object object12: arrayList22) {
                    if(v14 >= 0) {
                        String s41 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).getDarkImgUrl();
                        String s42 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).getImgUrl();
                        String s43 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).getTitle();
                        String s44 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).getCopy();
                        boolean z5 = q.b("N", "Y");
                        String s45 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).scheme;
                        String s46 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).linktype;
                        String s47 = ((com.melon.net.res.NavigationMenuListRes.RESPONSE.Menu.MenuItem)object12).linkurl;
                        T t2 = new T(null, s41, s42, (s43 == null ? "" : s43), z5, (s45 == null ? "" : s45), (s46 == null ? "" : s46), (s47 == null ? "" : s47), (s44 == null ? "" : s44), "N", 0, 0xC01);
                        t2.m = navigationMenuListRes$RESPONSE$Menu1.getLayer1() == null ? "" : navigationMenuListRes$RESPONSE$Menu1.getLayer1();
                        arrayList21.add(t2);
                        ++v14;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
            }
            String s48 = navigationMenuListRes$RESPONSE$Menu1.getMenuGroup();
            arrayList2.add(new Y(8, new X((s48 == null ? "" : s48), arrayList21)));
        }
        this.updateUiState(new Fc.a(arrayList2, 1));
        return H.a;
    }

    public final void l(String s) {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new p0(this, s, null), 2, null);
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        t0 t03;
        int v38;
        f f13;
        Object object28;
        f f12;
        String s27;
        String s26;
        String s24;
        MainMenuTabBannerRes mainMenuTabBannerRes3;
        f f10;
        String s19;
        InformArtistRes informArtistRes1;
        NavigationMenuBenefitRes navigationMenuBenefitRes7;
        L0 l04;
        List list17;
        MainMenuTabBannerRes mainMenuTabBannerRes2;
        NavigationMenuBenefitRes navigationMenuBenefitRes6;
        Object object27;
        int v32;
        NavigationMenuBenefitRes navigationMenuBenefitRes4;
        int v29;
        InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res5;
        int v28;
        Object object25;
        Object object24;
        NavigationMenuBenefitRes navigationMenuBenefitRes3;
        Object object23;
        InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res4;
        f f8;
        Object object22;
        InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res3;
        Deferred deferred43;
        Object object21;
        Deferred deferred41;
        Object object20;
        L0 l03;
        f f7;
        Deferred deferred38;
        Deferred deferred37;
        int v21;
        List list12;
        Deferred deferred36;
        Object object19;
        Object object18;
        List list11;
        L0 l02;
        String s18;
        Object object17;
        f f5;
        Object object15;
        String s16;
        String s15;
        InformArtistRes informArtistRes0;
        NavigationMenuBenefitRes navigationMenuBenefitRes2;
        MainMenuTabBannerRes mainMenuTabBannerRes1;
        f f3;
        List list9;
        Object object14;
        MainMenuTabBannerRes mainMenuTabBannerRes0;
        InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res1;
        Object object12;
        NavigationMenuBenefitRes navigationMenuBenefitRes0;
        List list7;
        Deferred deferred24;
        Object object10;
        InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res0;
        Deferred deferred21;
        List list5;
        Deferred deferred20;
        Object object8;
        f f0;
        Deferred deferred19;
        Deferred deferred18;
        int v11;
        Deferred deferred17;
        Object object6;
        List list4;
        int v4;
        int v3;
        t0 t00;
        Object object2;
        Deferred deferred6;
        int v2;
        int v1;
        Object object1;
        Deferred deferred4;
        Deferred deferred3;
        Deferred deferred2;
        Deferred deferred1;
        int v8;
        int v7;
        L0 l01;
        t0 t01;
        Deferred deferred15;
        int v6;
        int v5;
        Object object4;
        Deferred deferred13;
        Deferred deferred12;
        Deferred deferred10;
        Deferred deferred8;
        String s1;
        L0 l00;
        Zc.b0 b00;
        if(continuation0 instanceof Zc.b0) {
            b00 = (Zc.b0)continuation0;
            int v = b00.b0;
            if((v & 0x80000000) == 0) {
                b00 = new Zc.b0(this, ((c)continuation0));
            }
            else {
                b00.b0 = v ^ 0x80000000;
            }
        }
        else {
            b00 = new Zc.b0(this, ((c)continuation0));
        }
        Object object0 = b00.Y;
        ne.a a0 = ne.a.a;
        k k0 = this.i;
        String s = "";
        switch(b00.b0) {
            case 0: {
                n.D(object0);
                l00 = this.getProgressUpdater();
                s1 = "TabMenuViewModel";
                String s2 = "N";
                if(l00 != null) {
                    l00.a("TabMenuViewModel true", true);
                    try {
                        if(this.i()) {
                            va.Z z1 = new va.Z(((e0)k0), null);
                            BuildersKt__Builders_commonKt.launch$default(((e0)k0).i, null, null, z1, 3, null);
                            String s7 = MelonSettingInfo.isUseSpatialStreaming() ? "Y" : "N";
                            String s8 = MediaCodecInfoCompat.isAc4Supported() ? "Y" : "N";
                            Collection collection2 = MusicTabPrefsHelper.INSTANCE.getCommerceRedDot().values();
                            q.f(collection2, "<get-values>(...)");
                            List list2 = p.P0(collection2);
                            kotlin.jvm.internal.H h2 = new kotlin.jvm.internal.H();
                            h2.a = "";
                            if(!list2.isEmpty()) {
                                String s9 = new com.google.gson.n().k(list2);
                                q.f(s9, "toJson(...)");
                                h2.a = s9;
                            }
                            Deferred deferred7 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new k0(this, null), 3, null);
                            deferred8 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new h0(this, s7, s8, null), 3, null);
                            Deferred deferred9 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new Zc.f0(this, null), 3, null);
                            deferred10 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new d0(this, h2, null), 3, null);
                            Deferred deferred11 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new c0(this, null), 3, null);
                            b00.r = l00;
                            b00.w = "TabMenuViewModel";
                            b00.B = deferred8;
                            b00.D = deferred9;
                            b00.E = deferred10;
                            b00.G = deferred11;
                            b00.W = 0;
                            b00.X = 0;
                            b00.b0 = 11;
                            Object object3 = deferred7.await(b00);
                            if(object3 == a0) {
                                return a0;
                            }
                            deferred12 = deferred9;
                            deferred13 = deferred11;
                            object4 = object3;
                            v5 = 0;
                            v6 = 0;
                            goto label_433;
                        }
                        else {
                            String s10 = MelonSettingInfo.isUseSpatialStreaming() ? "Y" : "N";
                            String s11 = MediaCodecInfoCompat.isAc4Supported() ? "Y" : "N";
                            Collection collection3 = MusicTabPrefsHelper.INSTANCE.getCommerceRedDot().values();
                            q.f(collection3, "<get-values>(...)");
                            List list3 = p.P0(collection3);
                            kotlin.jvm.internal.H h3 = new kotlin.jvm.internal.H();
                            h3.a = "";
                            if(!list3.isEmpty()) {
                                String s12 = new com.google.gson.n().k(list3);
                                q.f(s12, "toJson(...)");
                                h3.a = s12;
                            }
                            Deferred deferred14 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new i0(this, s10, s11, null), 3, null);
                            deferred15 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new Zc.e0(this, h3, null), 3, null);
                            b00.r = l00;
                            b00.w = "TabMenuViewModel";
                            b00.B = deferred15;
                            b00.D = this;
                            b00.W = 0;
                            b00.X = 0;
                            b00.b0 = 18;
                            object0 = deferred14.await(b00);
                            if(object0 != a0) {
                                goto label_140;
                            }
                            return a0;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                        k8.Y.v(s1, " false", l00, false);
                        throw throwable0;
                    }
                label_140:
                    t01 = this;
                    l01 = l00;
                    v7 = 0;
                    v8 = 0;
                    goto label_734;
                }
                else if(this.i()) {
                    va.Z z0 = new va.Z(((e0)k0), null);
                    BuildersKt__Builders_commonKt.launch$default(((e0)k0).i, null, null, z0, 3, null);
                    String s3 = MelonSettingInfo.isUseSpatialStreaming() ? "Y" : "N";
                    if(MediaCodecInfoCompat.isAc4Supported()) {
                        s2 = "Y";
                    }
                    Collection collection0 = MusicTabPrefsHelper.INSTANCE.getCommerceRedDot().values();
                    q.f(collection0, "<get-values>(...)");
                    List list0 = p.P0(collection0);
                    kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();
                    h0.a = "";
                    if(!list0.isEmpty()) {
                        String s4 = new com.google.gson.n().k(list0);
                        q.f(s4, "toJson(...)");
                        h0.a = s4;
                    }
                    Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new k0(this, null), 3, null);
                    deferred1 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new h0(this, s3, s2, null), 3, null);
                    deferred2 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new Zc.f0(this, null), 3, null);
                    deferred3 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new d0(this, h0, null), 3, null);
                    deferred4 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new c0(this, null), 3, null);
                    b00.r = null;
                    b00.w = null;
                    b00.B = deferred1;
                    b00.D = deferred2;
                    b00.E = deferred3;
                    b00.G = deferred4;
                    b00.W = 0;
                    b00.X = 0;
                    b00.b0 = 1;
                    object1 = deferred0.await(b00);
                    if(object1 == a0) {
                        return a0;
                    }
                    v1 = 0;
                    v2 = 0;
                    goto label_156;
                }
                else {
                    String s5 = MelonSettingInfo.isUseSpatialStreaming() ? "Y" : "N";
                    if(MediaCodecInfoCompat.isAc4Supported()) {
                        s2 = "Y";
                    }
                    Collection collection1 = MusicTabPrefsHelper.INSTANCE.getCommerceRedDot().values();
                    q.f(collection1, "<get-values>(...)");
                    List list1 = p.P0(collection1);
                    kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();
                    h1.a = "";
                    if(!list1.isEmpty()) {
                        String s6 = new com.google.gson.n().k(list1);
                        q.f(s6, "toJson(...)");
                        h1.a = s6;
                    }
                    Deferred deferred5 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new i0(this, s5, s2, null), 3, null);
                    deferred6 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new Zc.e0(this, h1, null), 3, null);
                    b00.r = null;
                    b00.w = null;
                    b00.B = deferred6;
                    b00.D = this;
                    b00.W = 0;
                    b00.X = 0;
                    b00.b0 = 8;
                    object2 = deferred5.await(b00);
                    if(object2 == a0) {
                        return a0;
                    }
                    t00 = this;
                    v3 = 0;
                    v4 = 0;
                    goto label_382;
                }
                break;
            }
            case 1: {
                int v9 = b00.X;
                int v10 = b00.W;
                deferred4 = b00.G;
                deferred3 = (Deferred)b00.E;
                Deferred deferred16 = (Deferred)b00.D;
                deferred1 = b00.B;
                n.D(object0);
                v1 = v10;
                deferred2 = deferred16;
                v2 = v9;
                object1 = object0;
            label_156:
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = deferred2;
                b00.E = deferred3;
                b00.G = deferred4;
                b00.I = (List)object1;
                b00.W = v1;
                b00.X = v2;
                b00.b0 = 2;
                Object object5 = deferred1.await(b00);
                if(object5 == a0) {
                    return a0;
                }
                list4 = (List)object1;
                object6 = object5;
                deferred17 = deferred2;
                v11 = v1;
                deferred18 = deferred3;
                deferred19 = deferred4;
                goto label_184;
            }
            case 2: {
                int v12 = b00.X;
                v11 = b00.W;
                list4 = b00.I;
                deferred19 = b00.G;
                deferred18 = (Deferred)b00.E;
                deferred17 = (Deferred)b00.D;
                n.D(object0);
                v2 = v12;
                object6 = object0;
            label_184:
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = null;
                b00.E = deferred18;
                b00.G = deferred19;
                b00.I = list4;
                b00.M = (f)object6;
                b00.W = v11;
                b00.X = v2;
                b00.b0 = 3;
                Object object7 = deferred17.await(b00);
                if(object7 == a0) {
                    return a0;
                }
                f0 = (f)object6;
                object8 = object7;
                deferred20 = deferred18;
                list5 = list4;
                deferred21 = deferred19;
                goto label_216;
            }
            case 3: {
                int v13 = b00.X;
                v11 = b00.W;
                f f1 = b00.M;
                List list6 = b00.I;
                Deferred deferred22 = b00.G;
                deferred20 = (Deferred)b00.E;
                Deferred deferred23 = (Deferred)b00.D;
                n.D(object0);
                f0 = f1;
                deferred21 = deferred22;
                list5 = list6;
                v2 = v13;
                object8 = object0;
            label_216:
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = null;
                b00.E = null;
                b00.G = deferred21;
                b00.I = list5;
                b00.M = f0;
                b00.N = (InfoCommerceAndBtnVer6Res)object8;
                b00.W = v11;
                b00.X = v2;
                b00.b0 = 4;
                Object object9 = deferred20.await(b00);
                if(object9 == a0) {
                    return a0;
                }
                infoCommerceAndBtnVer6Res0 = (InfoCommerceAndBtnVer6Res)object8;
                object10 = object9;
                deferred24 = deferred21;
                goto label_245;
            }
            case 4: {
                int v14 = b00.X;
                v11 = b00.W;
                infoCommerceAndBtnVer6Res0 = b00.N;
                f0 = b00.M;
                list5 = b00.I;
                deferred24 = b00.G;
                Deferred deferred25 = (Deferred)b00.E;
                Deferred deferred26 = (Deferred)b00.D;
                n.D(object0);
                v2 = v14;
                object10 = object0;
            label_245:
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = null;
                b00.E = null;
                b00.G = null;
                b00.I = list5;
                b00.M = f0;
                b00.N = infoCommerceAndBtnVer6Res0;
                b00.S = (NavigationMenuBenefitRes)object10;
                b00.W = v11;
                b00.X = v2;
                b00.b0 = 5;
                Object object11 = deferred24.await(b00);
                if(object11 == a0) {
                    return a0;
                }
                list7 = list5;
                navigationMenuBenefitRes0 = (NavigationMenuBenefitRes)object10;
                object12 = object11;
                infoCommerceAndBtnVer6Res1 = infoCommerceAndBtnVer6Res0;
                goto label_280;
            }
            case 5: {
                int v15 = b00.X;
                v11 = b00.W;
                NavigationMenuBenefitRes navigationMenuBenefitRes1 = b00.S;
                InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res2 = b00.N;
                f f2 = b00.M;
                List list8 = b00.I;
                Deferred deferred27 = (Deferred)b00.E;
                Deferred deferred28 = (Deferred)b00.D;
                n.D(object0);
                v2 = v15;
                list7 = list8;
                object12 = object0;
                infoCommerceAndBtnVer6Res1 = infoCommerceAndBtnVer6Res2;
                f0 = f2;
                navigationMenuBenefitRes0 = navigationMenuBenefitRes1;
            label_280:
                LoginUser loginUser0 = ((e0)k0).j();
                if(u.F(((e0)k0).j())) {
                    Deferred deferred29 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new g0(this, loginUser0, null), 3, null);
                    b00.r = null;
                    b00.w = null;
                    b00.B = null;
                    b00.D = null;
                    b00.E = null;
                    b00.G = null;
                    b00.I = list7;
                    b00.M = f0;
                    b00.N = infoCommerceAndBtnVer6Res1;
                    b00.S = navigationMenuBenefitRes0;
                    b00.T = (MainMenuTabBannerRes)object12;
                    b00.V = loginUser0;
                    b00.W = v11;
                    b00.X = v2;
                    b00.b0 = 6;
                    Object object13 = deferred29.await(b00);
                    if(object13 == a0) {
                        return a0;
                    }
                    mainMenuTabBannerRes0 = (MainMenuTabBannerRes)object12;
                    object14 = object13;
                    list9 = list7;
                    f3 = f0;
                    goto label_323;
                }
                else {
                    mainMenuTabBannerRes1 = (MainMenuTabBannerRes)object12;
                    navigationMenuBenefitRes2 = navigationMenuBenefitRes0;
                    informArtistRes0 = null;
                }
                goto label_328;
            }
            case 6: {
                int v16 = b00.X;
                v11 = b00.W;
                mainMenuTabBannerRes0 = b00.T;
                navigationMenuBenefitRes0 = b00.S;
                infoCommerceAndBtnVer6Res1 = b00.N;
                f f4 = b00.M;
                List list10 = b00.I;
                Deferred deferred30 = (Deferred)b00.E;
                Deferred deferred31 = (Deferred)b00.D;
                n.D(object0);
                list9 = list10;
                f3 = f4;
                v2 = v16;
                object14 = object0;
            label_323:
                informArtistRes0 = (InformArtistRes)object14;
                navigationMenuBenefitRes2 = navigationMenuBenefitRes0;
                mainMenuTabBannerRes1 = mainMenuTabBannerRes0;
                f0 = f3;
                list7 = list9;
            label_328:
                String s13 = "";
                if(Cb.i.l(informArtistRes0)) {
                    q.d(informArtistRes0);
                    com.iloen.melon.net.v4x.response.InformArtistRes.RESPONSE informArtistRes$RESPONSE0 = informArtistRes0.response;
                    if(informArtistRes$RESPONSE0 != null) {
                        String s14 = informArtistRes$RESPONSE0.artistImg;
                        if(s14 != null) {
                            s13 = s14;
                        }
                    }
                    if(informArtistRes$RESPONSE0 == null) {
                        s15 = "";
                    }
                    else {
                        s15 = informArtistRes$RESPONSE0.artistName;
                        if(s15 == null) {
                            s15 = "";
                        }
                    }
                    s16 = s15 + " " + "채널";
                    if(informArtistRes$RESPONSE0 != null) {
                        String s17 = informArtistRes$RESPONSE0.artistName;
                        if(s17 != null) {
                            s = s17;
                        }
                    }
                    this.o = s;
                }
                else {
                    s16 = "";
                }
                q.d(s16);
                q.d(s13);
                U u0 = this.f(s16, s13, "", true);
                V v17 = new V(list7);
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = null;
                b00.E = null;
                b00.G = null;
                b00.I = null;
                b00.M = null;
                b00.N = null;
                b00.S = null;
                b00.T = null;
                b00.V = null;
                b00.W = v11;
                b00.X = v2;
                b00.b0 = 7;
                if(this.k(f0, infoCommerceAndBtnVer6Res1, navigationMenuBenefitRes2, mainMenuTabBannerRes1, u0, v17, b00) == a0) {
                    return a0;
                }
                break;
            }
            case 7: {
                object15 = object0;
                Deferred deferred32 = (Deferred)b00.E;
                Deferred deferred33 = (Deferred)b00.D;
                n.D(object15);
                return H.a;
            }
            case 8: {
                int v18 = b00.X;
                v3 = b00.W;
                t00 = (t0)b00.D;
                deferred6 = b00.B;
                n.D(object0);
                v4 = v18;
                object2 = object0;
            label_382:
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = t00;
                b00.E = (f)object2;
                b00.W = v3;
                b00.X = v4;
                b00.b0 = 9;
                Object object16 = deferred6.await(b00);
                if(object16 == a0) {
                    return a0;
                }
                f5 = (f)object2;
                object17 = object16;
                goto label_404;
            }
            case 9: {
                int v19 = b00.X;
                v3 = b00.W;
                f f6 = (f)b00.E;
                t0 t02 = (t0)b00.D;
                n.D(object0);
                f5 = f6;
                t00 = t02;
                v4 = v19;
                object17 = object0;
            label_404:
                U u1 = this.f("", "", "", false);
                b00.r = null;
                b00.w = null;
                b00.B = null;
                b00.D = null;
                b00.E = null;
                b00.W = v3;
                b00.X = v4;
                b00.b0 = 10;
                if(t00.k(f5, null, ((NavigationMenuBenefitRes)object17), null, u1, null, b00) == a0) {
                    return a0;
                }
                break;
            }
            case 10: {
                object15 = object0;
                n.D(object15);
                return H.a;
            }
            case 11: {
                v5 = b00.X;
                int v20 = b00.W;
                deferred13 = b00.G;
                Deferred deferred34 = (Deferred)b00.E;
                Deferred deferred35 = (Deferred)b00.D;
                deferred8 = b00.B;
                s18 = b00.w;
                l02 = b00.r;
                try {
                    n.D(object0);
                    v6 = v20;
                    s1 = s18;
                    deferred12 = deferred35;
                    deferred10 = deferred34;
                    l00 = l02;
                    object4 = object0;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l02;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_433:
                    list11 = (List)object4;
                    b00.r = l00;
                    b00.w = s1;
                    b00.B = null;
                    b00.D = deferred12;
                    b00.E = deferred10;
                    b00.G = deferred13;
                    b00.I = list11;
                    b00.W = v6;
                    b00.X = v5;
                    b00.b0 = 12;
                    object18 = deferred8.await(b00);
                    if(object18 != a0) {
                        goto label_446;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            label_446:
                object19 = object18;
                deferred36 = deferred12;
                list12 = list11;
                s18 = s1;
                v21 = v5;
                deferred37 = deferred10;
                deferred38 = deferred13;
                goto label_470;
            }
            case 12: {
                int v22 = b00.X;
                int v23 = b00.W;
                List list13 = b00.I;
                Deferred deferred39 = b00.G;
                Deferred deferred40 = (Deferred)b00.E;
                deferred36 = (Deferred)b00.D;
                s18 = b00.w;
                l02 = b00.r;
                try {
                    n.D(object0);
                    v21 = v22;
                    deferred37 = deferred40;
                    deferred38 = deferred39;
                    l00 = l02;
                    v6 = v23;
                    list12 = list13;
                    object19 = object0;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l02;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_470:
                    f7 = (f)object19;
                    b00.r = l00;
                    b00.w = s18;
                    l03 = l00;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                    b00.B = null;
                    b00.D = null;
                    b00.E = deferred37;
                    b00.G = deferred38;
                    b00.I = list12;
                    b00.M = f7;
                    b00.W = v6;
                    b00.X = v21;
                    b00.b0 = 13;
                    object20 = deferred36.await(b00);
                    if(object20 != a0) {
                        deferred41 = deferred37;
                        object21 = object20;
                        l00 = l03;
                        goto label_504;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l03;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                deferred41 = deferred37;
                object21 = object20;
                l00 = l03;
                goto label_504;
            }
            case 13: {
                int v24 = b00.X;
                int v25 = b00.W;
                f7 = b00.M;
                List list14 = b00.I;
                deferred38 = b00.G;
                deferred41 = (Deferred)b00.E;
                Deferred deferred42 = (Deferred)b00.D;
                s18 = b00.w;
                l02 = b00.r;
                try {
                    n.D(object0);
                    list12 = list14;
                    l00 = l02;
                    object21 = object0;
                    v6 = v25;
                    v21 = v24;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l02;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_504:
                    deferred43 = deferred38;
                    infoCommerceAndBtnVer6Res3 = (InfoCommerceAndBtnVer6Res)object21;
                    b00.r = l00;
                    b00.w = s18;
                    l03 = l00;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                    b00.B = null;
                    b00.D = null;
                    b00.E = null;
                    b00.G = deferred43;
                    b00.I = list12;
                    b00.M = f7;
                    b00.N = infoCommerceAndBtnVer6Res3;
                    b00.W = v6;
                    b00.X = v21;
                    b00.b0 = 14;
                    object22 = deferred41.await(b00);
                    if(object22 != a0) {
                        goto label_521;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l03;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            label_521:
                f8 = f7;
                infoCommerceAndBtnVer6Res4 = infoCommerceAndBtnVer6Res3;
                object23 = object22;
                l00 = l03;
                goto label_544;
            }
            case 14: {
                int v26 = b00.X;
                int v27 = b00.W;
                infoCommerceAndBtnVer6Res4 = b00.N;
                f f9 = b00.M;
                List list15 = b00.I;
                Deferred deferred44 = b00.G;
                Deferred deferred45 = (Deferred)b00.E;
                Deferred deferred46 = (Deferred)b00.D;
                s18 = b00.w;
                l02 = b00.r;
                try {
                    n.D(object0);
                    list12 = list15;
                    object23 = object0;
                    f8 = f9;
                    l00 = l02;
                    v6 = v27;
                    v21 = v26;
                    deferred43 = deferred44;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l02;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_544:
                    navigationMenuBenefitRes3 = (NavigationMenuBenefitRes)object23;
                    b00.r = l00;
                    b00.w = s18;
                    l03 = l00;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                    b00.B = null;
                    b00.D = null;
                    b00.E = null;
                    b00.G = null;
                    b00.I = list12;
                    b00.M = f8;
                    b00.N = infoCommerceAndBtnVer6Res4;
                    b00.S = navigationMenuBenefitRes3;
                    b00.W = v6;
                    b00.X = v21;
                    b00.b0 = 15;
                    object24 = deferred43.await(b00);
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l03;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                if(object24 != a0) {
                    object25 = object24;
                    v28 = v6;
                    l00 = l03;
                    infoCommerceAndBtnVer6Res5 = infoCommerceAndBtnVer6Res4;
                    v29 = v21;
                    s1 = s18;
                    navigationMenuBenefitRes4 = navigationMenuBenefitRes3;
                    goto label_602;
                }
                return a0;
            }
            case 15: {
                int v30 = b00.X;
                int v31 = b00.W;
                NavigationMenuBenefitRes navigationMenuBenefitRes5 = b00.S;
                InfoCommerceAndBtnVer6Res infoCommerceAndBtnVer6Res6 = b00.N;
                f8 = b00.M;
                List list16 = b00.I;
                Deferred deferred47 = (Deferred)b00.E;
                Deferred deferred48 = (Deferred)b00.D;
                s18 = b00.w;
                l02 = b00.r;
                try {
                    n.D(object0);
                    v29 = v30;
                    v28 = v31;
                    s1 = s18;
                    navigationMenuBenefitRes4 = navigationMenuBenefitRes5;
                    infoCommerceAndBtnVer6Res5 = infoCommerceAndBtnVer6Res6;
                    l00 = l02;
                    list12 = list16;
                    object25 = object0;
                }
                catch(Throwable throwable0) {
                    s1 = s18;
                    l00 = l02;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_602:
                    LoginUser loginUser1 = ((e0)k0).j();
                    if(u.F(((e0)k0).j())) {
                        Deferred deferred49 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new g0(this, loginUser1, null), 3, null);
                        b00.r = l00;
                        b00.w = s1;
                        b00.B = null;
                        b00.D = null;
                        b00.E = null;
                        b00.G = null;
                        b00.I = list12;
                        b00.M = f8;
                        b00.N = infoCommerceAndBtnVer6Res5;
                        b00.S = navigationMenuBenefitRes4;
                        b00.T = (MainMenuTabBannerRes)object25;
                        b00.V = loginUser1;
                        b00.W = v28;
                        b00.X = v29;
                        b00.b0 = 16;
                        Object object26 = deferred49.await(b00);
                        if(object26 != a0) {
                            v32 = v28;
                            object27 = object26;
                            navigationMenuBenefitRes6 = navigationMenuBenefitRes4;
                            mainMenuTabBannerRes2 = (MainMenuTabBannerRes)object25;
                            list17 = list12;
                            goto label_659;
                        }
                    }
                    else {
                        l04 = l00;
                        navigationMenuBenefitRes7 = navigationMenuBenefitRes4;
                        informArtistRes1 = null;
                        s19 = s1;
                        f10 = f8;
                        mainMenuTabBannerRes3 = (MainMenuTabBannerRes)object25;
                        list17 = list12;
                        goto label_666;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 16: {
                int v33 = b00.X;
                int v34 = b00.W;
                MainMenuTabBannerRes mainMenuTabBannerRes4 = b00.T;
                NavigationMenuBenefitRes navigationMenuBenefitRes8 = b00.S;
                infoCommerceAndBtnVer6Res5 = b00.N;
                f f11 = b00.M;
                List list18 = b00.I;
                Deferred deferred50 = (Deferred)b00.E;
                Deferred deferred51 = (Deferred)b00.D;
                String s20 = b00.w;
                L0 l05 = b00.r;
                try {
                    l00 = l05;
                    s1 = s20;
                    n.D(object0);
                    navigationMenuBenefitRes6 = navigationMenuBenefitRes8;
                    v32 = v34;
                    mainMenuTabBannerRes2 = mainMenuTabBannerRes4;
                    f8 = f11;
                    list17 = list18;
                    v29 = v33;
                    l00 = l05;
                    object27 = object0;
                    s1 = s20;
                label_659:
                    informArtistRes1 = (InformArtistRes)object27;
                    v28 = v32;
                    s19 = s1;
                    f10 = f8;
                    mainMenuTabBannerRes3 = mainMenuTabBannerRes2;
                    l04 = l00;
                    navigationMenuBenefitRes7 = navigationMenuBenefitRes6;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_666:
                    String s21 = "";
                    String s22 = "";
                    if(Cb.i.l(informArtistRes1)) {
                        q.d(informArtistRes1);
                        com.iloen.melon.net.v4x.response.InformArtistRes.RESPONSE informArtistRes$RESPONSE1 = informArtistRes1.response;
                        if(informArtistRes$RESPONSE1 != null) {
                            String s23 = informArtistRes$RESPONSE1.artistImg;
                            if(s23 != null) {
                                s21 = s23;
                            }
                        }
                        if(informArtistRes$RESPONSE1 == null) {
                            s24 = "";
                        }
                        else {
                            s24 = informArtistRes$RESPONSE1.artistName;
                            if(s24 == null) {
                                s24 = "";
                            }
                        }
                        s22 = s24 + " " + "채널";
                        if(informArtistRes$RESPONSE1 == null) {
                            s26 = "";
                        }
                        else {
                            String s25 = informArtistRes$RESPONSE1.artistName;
                            s26 = s25 == null ? "" : s25;
                        }
                        this.o = s26;
                    }
                    q.d(s22);
                    q.d(s21);
                    U u2 = this.f(s22, s21, "", true);
                    V v35 = new V(list17);
                    b00.r = l04;
                    b00.w = s19;
                    b00.B = null;
                    b00.D = null;
                    b00.E = null;
                    b00.G = null;
                    b00.I = null;
                    b00.M = null;
                    b00.N = null;
                    b00.S = null;
                    b00.T = null;
                    b00.V = null;
                    b00.W = v28;
                    b00.X = v29;
                    b00.b0 = 17;
                    if(this.k(f10, infoCommerceAndBtnVer6Res5, navigationMenuBenefitRes7, mainMenuTabBannerRes3, u2, v35, b00) != a0) {
                        s1 = s19;
                        l00 = l04;
                        goto label_795;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    s1 = s19;
                    l00 = l04;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                s1 = s19;
                l00 = l04;
                goto label_795;
            }
            case 17: {
                Deferred deferred52 = (Deferred)b00.E;
                Deferred deferred53 = (Deferred)b00.D;
                s1 = b00.w;
                l00 = b00.r;
                try {
                    n.D(object0);
                    goto label_795;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 18: {
                int v36 = b00.X;
                int v37 = b00.W;
                t01 = (t0)b00.D;
                deferred15 = b00.B;
                s27 = b00.w;
                l01 = b00.r;
                try {
                    n.D(object0);
                    v8 = v36;
                    v7 = v37;
                    s1 = s27;
                }
                catch(Throwable throwable0) {
                    s1 = s27;
                    l00 = l01;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_734:
                    f12 = (f)object0;
                    b00.r = l01;
                    b00.w = s1;
                    b00.B = null;
                    b00.D = t01;
                    b00.E = f12;
                    b00.W = v7;
                    b00.X = v8;
                    b00.b0 = 19;
                    object28 = deferred15.await(b00);
                }
                catch(Throwable throwable0) {
                    l00 = l01;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                if(object28 != a0) {
                    f13 = f12;
                    object0 = object28;
                    v38 = v7;
                    t03 = t01;
                    goto label_770;
                }
                try {
                    return a0;
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            }
            case 19: {
                int v39 = b00.X;
                v38 = b00.W;
                f13 = (f)b00.E;
                t0 t04 = (t0)b00.D;
                s27 = b00.w;
                l01 = b00.r;
                try {
                    n.D(object0);
                    v8 = v39;
                    t03 = t04;
                    s1 = s27;
                }
                catch(Throwable throwable0) {
                    s1 = s27;
                    l00 = l01;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                try {
                label_770:
                    l04 = l01;
                    U u3 = this.f("", "", "", false);
                    b00.r = l04;
                    b00.w = s1;
                    b00.B = null;
                    b00.D = null;
                    b00.E = null;
                    b00.W = v38;
                    b00.X = v8;
                    b00.b0 = 20;
                    if(t03.k(f13, null, ((NavigationMenuBenefitRes)object0), null, u3, null, b00) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    l00 = l04;
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
                l00 = l04;
                goto label_795;
            }
            case 20: {
                try {
                    s1 = b00.w;
                    l00 = b00.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                    k8.Y.v(s1, " false", l00, false);
                    throw throwable0;
                }
            label_795:
                k8.Y.v(s1, " false", l00, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        StringProviderImpl stringProviderImpl0 = this.j;
        if(e0 instanceof Zc.m) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = ((Zc.m)e0).b;
            melonLinkInfo0.b = ((Zc.m)e0).a;
            melonLinkInfo0.c = ((Zc.m)e0).c;
            MelonLinkExecutor.open(melonLinkInfo0);
            String s = stringProviderImpl0.a(0x7F13101C);  // string:tiara_tab_menu_layer1_benefit_banner "혜택배너"
            String s1 = stringProviderImpl0.a(0x7F131011);  // string:tiara_tab_menu_click_copy_banner "배너"
            String s2 = stringProviderImpl0.a(0x7F130EF3);  // string:tiara_meta_type_banner "배너"
            t0.j(this, null, s, null, ((Zc.m)e0).e + s1, ((Zc.m)e0).d, s2, null, 0x85);
            return;
        }
        if(e0 instanceof Zc.r) {
            MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
            melonLinkInfo1.a = ((Zc.r)e0).b;
            melonLinkInfo1.b = ((Zc.r)e0).a;
            melonLinkInfo1.c = ((Zc.r)e0).c;
            MelonLinkExecutor.open(melonLinkInfo1);
            String s3 = stringProviderImpl0.a(0x7F13101C);  // string:tiara_tab_menu_layer1_benefit_banner "혜택배너"
            String s4 = stringProviderImpl0.a(0x7F131012);  // string:tiara_tab_menu_click_copy_banner_detail "상세배너"
            String s5 = stringProviderImpl0.a(0x7F130EF3);  // string:tiara_meta_type_banner "배너"
            t0.j(this, null, s3, null, ((Zc.r)e0).e + s4, ((Zc.r)e0).d, s5, null, 0x85);
            return;
        }
        Context context0 = this.g;
        if(e0 instanceof Zc.i) {
            String s6 = ((Zc.i)e0).c;
            String s7 = ((Zc.i)e0).b;
            switch(((Zc.i)e0).a) {
                case 0: {
                    if(!NetUtils.showNetworkPopupOrToast(context0, false)) {
                        return;
                    }
                    Navigator.open(BuyingGoodsFragment.Companion.newInstance());
                    t0.j(this, null, s7, null, s6, null, null, null, 0xF5);
                    return;
                }
                case 1: {
                    Navigator.openUrl(A8.M.c0, OpenType.DefaultWebViewWithMiniPlayer);
                    t0.j(this, null, s7, null, s6, null, null, null, 0xF5);
                    return;
                }
                case 2: {
                    Navigator.INSTANCE.openMelonSupportMain();
                    t0.j(this, null, s7, null, s6, null, null, null, 0xF5);
                    return;
                }
                case 3: {
                    Navigator.INSTANCE.openNoticePage(null);
                    NewUpdateNotiUtils.setHasNewUpdate("B001", false);
                    t0.j(this, null, s7, null, s6, null, null, null, 0xF5);
                    return;
                }
                default: {
                    return;
                }
            }
        }
        G g0 = G.a;
        if(e0 instanceof o) {
            T t0 = ((o)e0).a;
            String s8 = t0.a;
            if(q.b(t0.j, "Y")) {
                if(this.i()) {
                    this.h(t0.f, t0.h, t0.g, t0.k, t0.a);
                    this.l(s8);
                    t0.j(this, null, t0.m, null, t0.i, null, null, null, 0xF5);
                    return;
                }
                this.sendUiEvent(g0);
                return;
            }
            this.h(t0.f, t0.h, t0.g, t0.k, t0.a);
            this.l(s8);
            t0.j(this, null, t0.m, null, t0.i, null, null, null, 0xF5);
            return;
        }
        if(e0 instanceof Zc.t) {
            MelonLinkInfo melonLinkInfo2 = new MelonLinkInfo();
            melonLinkInfo2.a = ((Zc.t)e0).a.g;
            melonLinkInfo2.b = ((Zc.t)e0).a.h;
            melonLinkInfo2.c = ((Zc.t)e0).a.f;
            MelonLinkExecutor.open(melonLinkInfo2);
            t0.j(this, null, ((Zc.t)e0).a.m, null, ((Zc.t)e0).a.i, null, null, null, 0xF5);
            return;
        }
        if(e0 instanceof Zc.p) {
            q.f("프로필", "getString(...)");
            e0 e00 = (e0)this.i;
            if(this.i()) {
                boolean z = u.F(e00.j());
                String s9 = u.v(e00.j());
                q.d("");
                this.sendUiEvent(new I("", s9, z));
                if(z) {
                    q.f("아티스트채널", "getString(...)");
                    ActionKind actionKind0 = ActionKind.ClickContent;
                    String s10 = k8.Y.i(ContsTypeCode.ARTIST, "code(...)");
                    if(s10 == null) {
                        s10 = "";
                    }
                    t0.j(this, actionKind0, "프로필", null, "아티스트채널", "", s10, this.o, 4);
                    return;
                }
                q.f("내프로필", "getString(...)");
                t0.j(this, null, "프로필", null, "내프로필", null, null, null, 0xF5);
                return;
            }
            this.sendUiEvent(g0);
            q.f("로그인", "getString(...)");
            t0.j(this, null, "프로필", null, "로그인", null, null, null, 0xF5);
            return;
        }
        if(e0 instanceof Zc.q) {
            this.sendUiEvent(F.a);
            q.f("프로필", "getString(...)");
            t0.j(this, null, "프로필", "이용권", l1.m("이용권", "getString(...)", context0, 0x7F130D85, "getString(...)"), null, null, null, 0xF1);  // string:tiara_click_copy_purchase_ticket_not_login "이용권구매(비로그인)"
            return;
        }
        if(e0 instanceof l) {
            this.sendUiEvent(Zc.H.a);
            q.f("프로필", "getString(...)");
            q.f("등급", "getString(...)");
            t0.j(this, null, "프로필", null, "등급", null, null, null, 0xF5);
            return;
        }
        if(e0 instanceof Zc.k) {
            MelonLinkInfo melonLinkInfo3 = new MelonLinkInfo();
            melonLinkInfo3.a = ((Zc.k)e0).a;
            melonLinkInfo3.b = ((Zc.k)e0).b;
            MelonLinkExecutor.open(melonLinkInfo3);
            q.f("프로필", "getString(...)");
            String s11 = l1.m("이용권", "getString(...)", context0, 0x7F131019, "getString(...)");  // string:tiara_tab_menu_click_copy_not_have_goods "이용권(미보유)"
            if(((Zc.k)e0).c) {
                s11 = "이용권(보유)";
                q.f("이용권(보유)", "getString(...)");
            }
            t0.j(this, null, "프로필", "이용권", s11, null, null, null, 0xF1);
            return;
        }
        if(e0 instanceof Zc.n) {
            MelonLinkInfo melonLinkInfo4 = new MelonLinkInfo();
            melonLinkInfo4.a = ((Zc.n)e0).a;
            melonLinkInfo4.b = ((Zc.n)e0).b;
            MelonLinkExecutor.open(melonLinkInfo4);
            q.f("프로필", "getString(...)");
            t0.j(this, null, "프로필", "멜론캐시", l1.m("멜론캐시", "getString(...)", context0, 0x7F131016, "getString(...)"), null, null, null, 0xF1);  // string:tiara_tab_menu_click_copy_melon_cash "멜론캐시"
            return;
        }
        if(e0 instanceof Zc.s) {
            W w0 = ((Zc.s)e0).a;
            if(w0 == null) {
                return;
            }
            this.h(w0.d, w0.f, w0.e, w0.g, w0.a);
            this.l(w0.a);
            String s12 = stringProviderImpl0.a(0x7F13101F);  // string:tiara_tab_menu_layer1_recent_menu "최근본메뉴"
            LogU.debug$default(this.l, "ClickShortcutMenu: layer1 " + s12 + ", copy " + w0.b, null, false, 6, null);
            t0.j(this, null, s12, null, w0.b, null, null, null, 0xF5);
            return;
        }
        if(e0 instanceof j) {
            String s13 = ((j)e0).a;
            if(s13 == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new l0(this, s13, null), 2, null);
            return;
        }
        super.onUserEvent(e0);
    }
}

