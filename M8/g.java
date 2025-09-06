package m8;

import A7.d;
import A8.M;
import Ma.m;
import Qb.z;
import Tf.v;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.f0;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.eventbus.EventAlarm;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaybackScheme;
import com.iloen.melon.eventbus.EventWebView.KakaoEmoticonPopup;
import com.iloen.melon.eventbus.EventWebViewClose.CloseView;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.mymusic.MyMusicTabFragment;
import com.iloen.melon.fragments.settings.SettingLaboratoryFragment;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.fragments.settings.SettingPushFragment;
import com.iloen.melon.fragments.settings.SettingSongFragment;
import com.iloen.melon.fragments.settings.SettingStopTimerFragment;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment;
import com.iloen.melon.fragments.shortform.TrendShortFormFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.task.request.TaskSaveImage;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.system.ToastManager;
import d5.w;
import e.k;
import e1.G;
import e1.u;
import e1.x;
import e2.a;
import gd.I0;
import gd.X1;
import gd.c1;
import gd.p2;
import gd.u1;
import gd.w0;
import h7.u0;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import jd.e3;
import je.D;
import je.n;
import je.p;
import k8.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import o8.e;
import r8.f;
import va.Y;
import va.e0;
import va.o;

public final class g {
    public final BaseActivity a;

    public g(BaseActivity baseActivity0) {
        this.a = baseActivity0;
    }

    public final boolean a(Uri uri0) {
        Set set0 = NetUtils.getQueryParameterNames(uri0);
        if(set0 != null && !set0.isEmpty() && set0.contains("memberKey")) {
            String s = uri0.getQueryParameter("memberKey");
            boolean z = ((e0)o.a()).m();
            if(s != null && !"0".equals(s)) {
                if(s.length() > 0) {
                    if(!z) {
                        Navigator.openLoginView(f.i);
                        return true;
                    }
                    else if(!s.equals(u.v(((e0)o.a()).j()))) {
                        BaseActivity baseActivity0 = this.a;
                        if(baseActivity0 != null) {
                            BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new m8.f(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        }
                        return true;
                    }
                }
            }
            else if(!z) {
                Navigator.openLoginView(f.i);
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        AppUtils.getVersionName(this.a);
        AppVersionInfo appVersionInfo0 = MelonSettingInfo.getAppVersionInfo();
        String s = null;
        if(!q.b((appVersionInfo0 == null ? null : appVersionInfo0.a), "1")) {
            if(appVersionInfo0 != null) {
                s = appVersionInfo0.a;
            }
            return q.b(s, "2") ? 0 : 1;
        }
        return 0;
    }

    public final void c(Uri uri0) {
        int v9;
        int v7;
        int v6;
        int v5;
        Uri uri1;
        if(!q.b(uri0.getScheme(), "https") || !q.b(uri0.getAuthority(), "m2.melon.com")) {
            uri1 = uri0;
        }
        else {
            String s = uri0.getPath();
            if(s == null || !Tf.o.v0(s, "link", false)) {
                uri1 = uri0;
            }
            else {
                String s1 = uri0.toString();
                q.f(s1, "toString(...)");
                uri1 = Uri.parse(v.p0(s1, "https://m2.melon.com/link/", "melonapp://"));
            }
        }
        String s2 = uri1.getScheme();
        String s3 = uri1.getAuthority();
        String s4 = uri1.getPath();
        Set set0 = uri1.getQueryParameterNames();
        q.f(set0, "getQueryParameterNames(...)");
        int v = D.N(je.q.Q(10, set0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        for(Object object0: set0) {
            linkedHashMap0.put(object0, uri1.getQueryParameter(((String)object0)));
        }
        Companion logU$Companion0 = LogU.Companion;
        StringBuilder stringBuilder0 = new StringBuilder("processDeeplink() : uri = ");
        stringBuilder0.append(uri0);
        stringBuilder0.append(" \nreplacedUri : ");
        stringBuilder0.append(uri1);
        stringBuilder0.append(" \nscheme : ");
        d.u(stringBuilder0, s2, " \nauthority : ", s3, " \npath : ");
        stringBuilder0.append(s4);
        stringBuilder0.append(" \nquery : ");
        stringBuilder0.append(linkedHashMap0);
        logU$Companion0.d("DeeplinkManager.kt", stringBuilder0.toString());
        if(this.a(uri1)) {
            logU$Companion0.w("DeeplinkManager.kt", "checkMemberKeyFromOtherApp() : INVALID_MEMBER_KEY");
            return;
        }
        f.d(uri0);
        DevLog.Companion.get("AutoPlay").put("DeeplinkManager.kt > processDeeplink() uri : " + uri0);
        MelonAppBase.Companion.getClass();
        q.f("kakao5c2982b2ec377339ee67d3686f4813ac", "getString(...)");
        boolean z = "kakao5c2982b2ec377339ee67d3686f4813ac".equals(s2);
        BaseActivity baseActivity0 = this.a;
        if(z) {
            if(!q.b(s3, "kakaolink") || baseActivity0 == null) {
                return;
            }
            String s5 = uri1.getPath();
            if(s5 == null || s5.hashCode() != 0 || !s5.equals("")) {
                return;
            }
            String s6 = uri1.getQueryParameter("targeturl");
            if(s6 == null) {
                return;
            }
            try {
                logU$Companion0.d("KakaoLink.kt", "targetUrl : " + s6);
                baseActivity0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URLDecoder.decode(s6, "utf-8"))));
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                unsupportedEncodingException0.printStackTrace();
            }
            return;
        }
        if(s3 != null) {
            switch(s3) {
                case "alarm": {
                    String s21 = uri1.getPath();
                    if(s21 == null || s21.hashCode() != 606485877 || !s21.equals("/shortcut")) {
                        return;
                    }
                    MelonFragmentManager.getInstance().open(SettingMusicAlarmListFragment.Companion.newInstance());
                    return;
                }
                case "apphome": 
                case "back": 
                case "exit": 
                case "home": 
                case "launch": {
                    d3.g.H(baseActivity0, uri1);
                    return;
                }
                case "artist": {
                    a.B(uri1);
                    return;
                }
                case "audiofocus": {
                    if(baseActivity0 == null) {
                        return;
                    }
                    String s33 = uri1.getPath();
                    if(s33 == null || s33.hashCode() != 1403400064 || !s33.equals("/request")) {
                        return;
                    }
                    t.a().setLoanedAudioFocus(true);
                    Context context0 = baseActivity0.getApplicationContext();
                    q.d(context0);
                    ((z)((k8.o)(((m)b.B(context0, m.class)))).t.get()).r();
                    return;
                }
                case "authority": {
                    String s30 = uri1.getPath();
                    if(s30 == null || s30.hashCode() != 0 || !s30.equals("")) {
                        return;
                    }
                    String[] arr_s = {uri1.getQueryParameter("type"), uri1.getQueryParameter("accept")};
                    for(int v1 = 0; v1 < 2; ++v1) {
                        if(arr_s[v1] == null) {
                            return;
                        }
                    }
                    ArrayList arrayList0 = n.g0(arr_s);
                    String s31 = (String)arrayList0.get(0);
                    String s32 = (String)arrayList0.get(1);
                    q.g(s31, "authType");
                    q.g(s32, "authAccept");
                    if(!"foruweather".equals(s31)) {
                        return;
                    }
                    EventBusHelper.post(new CloseView());
                    return;
                }
                case "cashfriends": {
                    d5.n.u(uri1);
                    return;
                }
                case "charts": {
                    d5.t.g(uri1);
                    return;
                }
                case "commentlist": {
                    String s55 = uri1.getPath();
                    if(s55 == null || s55.hashCode() != 0 || !s55.equals("")) {
                        return;
                    }
                    String s56 = uri1.getQueryParameter("channelSeq");
                    String s57 = uri1.getQueryParameter("cid");
                    boolean z4 = ProtocolUtils.parseBoolean(uri1.getQueryParameter("hasParentLink"));
                    Navigator.INSTANCE.openCommentRenewalVersion(s56, s57, z4);
                    return;
                }
                case "connected": {
                    String s14 = uri1.getPath();
                    if(s14 == null || s14.hashCode() != 0x497058D6 || !s14.equals("/smartplaylist/activate")) {
                        return;
                    }
                    c c0 = new c(0);
                    if(!q.b(uri1.getQueryParameter("status"), "on") || baseActivity0 == null) {
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), Dispatchers.getMain(), null, new m8.b(c0, null), 2, null);
                    return;
                }
                case "cookies": {
                    w.y(uri1);
                    return;
                }
                case "details": {
                    h.a(uri1);
                    return;
                }
                case "djbrand": {
                    String s34 = uri1.getPath();
                    if(s34 == null) {
                        return;
                    }
                    switch(s34) {
                        case "": {
                            String s35 = u0.y(uri1, "brandkey");
                            if(s35 == null) {
                                return;
                            }
                            Navigator.INSTANCE.openMelonDjPartnerInfo(s35);
                            return;
                        }
                        case "/detail": {
                            Set set1 = uri1.getQueryParameterNames();
                            q.f(set1, "getQueryParameterNames(...)");
                            int v2 = D.N(je.q.Q(10, set1));
                            LinkedHashMap linkedHashMap1 = new LinkedHashMap((v2 >= 16 ? v2 : 16));
                            for(Object object1: set1) {
                                linkedHashMap1.put(object1, uri1.getQueryParameter(((String)object1)));
                            }
                            String[] arr_s1 = {((String)linkedHashMap1.get("type")), ((String)linkedHashMap1.get("brandkey")), ((String)linkedHashMap1.get("brandname"))};
                            for(int v3 = 0; v3 < 3; ++v3) {
                                if(arr_s1[v3] == null) {
                                    return;
                                }
                            }
                            ArrayList arrayList1 = n.g0(arr_s1);
                            String s36 = (String)arrayList1.get(0);
                            String s37 = (String)arrayList1.get(1);
                            String s38 = (String)arrayList1.get(2);
                            switch(s36) {
                                case "djplaylist": {
                                    q.g(s37, "brandDjKey");
                                    q.g(s38, "topMemberNm");
                                    I0 i00 = new I0();
                                    Bundle bundle5 = new Bundle();
                                    bundle5.putString("argBrandDjKey", s37);
                                    bundle5.putString("argTopMemberNm", s38);
                                    i00.setArguments(bundle5);
                                    Navigator.INSTANCE.open(i00);
                                    return;
                                }
                                case "follower": {
                                    Navigator.open(MyMusicTabFragment.Companion.newInstance(s37, s38, 0));
                                    return;
                                }
                                case "info": {
                                    Navigator.INSTANCE.openMelonDjPartnerInfo(s37);
                                    return;
                                }
                                case "magazine": {
                                    q.g(s37, "brandDjKey");
                                    q.g(s38, "djTitle");
                                    w0 w00 = new w0();
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("argBrandDjKey", s37);
                                    bundle3.putString("argBrandTitle", s38);
                                    w00.setArguments(bundle3);
                                    Navigator.INSTANCE.open(w00);
                                    return;
                                }
                                case "recmartist": {
                                    q.g(s37, "brandDjKey");
                                    q.g(s38, "djTitle");
                                    c1 c10 = new c1();
                                    Bundle bundle1 = new Bundle();
                                    bundle1.putString("argBrandDjKey", s37);
                                    bundle1.putString("argBrandTitle", s38);
                                    c10.setArguments(bundle1);
                                    Navigator.INSTANCE.open(c10);
                                    return;
                                }
                                case "recmsong": {
                                    q.g(s37, "brandDjKey");
                                    u1 u10 = new u1();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("argBrandDjKey", s37);
                                    bundle2.putString("argBrandDjNickname", s38);
                                    u10.setArguments(bundle2);
                                    Navigator.INSTANCE.open(u10);
                                    return;
                                }
                                case "station": {
                                    q.g(s37, "brandDjKey");
                                    q.g(s38, "djTitle");
                                    X1 x10 = new X1();
                                    Bundle bundle0 = new Bundle();
                                    bundle0.putString("argBrandDjKey", s37);
                                    bundle0.putString("argBrandTitle", s38);
                                    x10.setArguments(bundle0);
                                    Navigator.INSTANCE.open(x10);
                                    return;
                                }
                                case "video": {
                                    q.g(s37, "brandDjKey");
                                    q.g(s38, "djTitle");
                                    p2 p20 = new p2();
                                    Bundle bundle4 = new Bundle();
                                    bundle4.putString("argBrandDjKey", s37);
                                    bundle4.putString("argBrandTitle", s38);
                                    p20.setArguments(bundle4);
                                    Navigator.INSTANCE.open(p20);
                                    return;
                                }
                                default: {
                                    Navigator.openUserMain(s37);
                                    return;
                                }
                            }
                        }
                        default: {
                            return;
                        }
                    }
                }
                case "djmelgun": {
                    String s29 = uri1.getPath();
                    if(s29 == null || s29.hashCode() != 0 || !s29.equals("")) {
                        return;
                    }
                    Navigator.openMelGunsCollection();
                    return;
                }
                case "download": {
                    String s7 = uri1.getPath();
                    if(s7 != null) {
                        switch(s7) {
                            case "": {
                                O8.a a0 = new O8.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                a0.a = uri1.getQueryParameter("ukey");
                                uri1.getQueryParameter("uid");
                                a0.b = uri1.getQueryParameter("menuid");
                                a0.c = uri1.getQueryParameter("product");
                                uri1.getQueryParameter("prodCd");
                                a0.d = uri1.getQueryParameter("ctype");
                                a0.e = uri1.getQueryParameter("cid");
                                a0.f = uri1.getQueryParameter("drm");
                                a0.g = uri1.getQueryParameter("bitrate");
                                a0.h = uri1.getQueryParameter("giftid");
                                uri1.getQueryParameter("returl");
                                O8.d.f(a0);
                                return;
                            }
                            case "/photo": {
                                String s8 = u0.y(uri1, "url");
                                if(s8 != null) {
                                    List list0 = k.z(s8);
                                    TaskSaveImage taskSaveImage0 = new TaskSaveImage();
                                    taskSaveImage0.setParams(list0);
                                    taskSaveImage0.execute(null);
                                    return;
                                }
                                break;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                    return;
                }
                case "foru": {
                    de.c.r(uri1);
                    return;
                }
                case "friend": {
                    df.d.n(baseActivity0, uri1);
                    return;
                }
                case "genre": {
                    df.v.u(baseActivity0, uri1);
                    return;
                }
                case "giftbox": {
                    k.o(baseActivity0, uri1);
                    return;
                }
                case "goods": {
                    String s22 = uri1.getPath();
                    if(s22 == null || s22.hashCode() != 0 || !s22.equals("")) {
                        return;
                    }
                    boolean z1 = uri1.getBooleanQueryParameter("hasFlac", false);
                    if(!((e0)o.a()).m()) {
                        return;
                    }
                    e0 e00 = (e0)o.a();
                    Y y0 = new Y(e00, z1, null);
                    BuildersKt__Builders_commonKt.launch$default(e00.i, null, null, y0, 3, null);
                    return;
                }
                case "kakao": {
                    e1.b.v(baseActivity0, uri1);
                    return;
                }
                case "kakaoemoticon": {
                    String s15 = uri1.getPath();
                    if(s15 == null || s15.hashCode() != 0 || !s15.equals("")) {
                        return;
                    }
                    EventBusHelper.post(new KakaoEmoticonPopup());
                    return;
                }
                case "like": {
                    e1.m.n(baseActivity0, uri1);
                    return;
                }
                case "live": {
                    String s18 = uri1.getPath();
                    if(s18 == null || s18.hashCode() != 0x2CADBE3 || !s18.equals("/play")) {
                        return;
                    }
                    String s19 = uri1.getQueryParameter("id");
                    String s20 = uri1.getQueryParameter("menuid");
                    if(s20 == null || s20.length() == 0) {
                        s20 = "1000002967";
                    }
                    if(s19 == null) {
                        return;
                    }
                    Navigator.openLive$default(s19, s20, false, null, 8, null);
                    return;
                }
                case "login": {
                    e1.n.n(baseActivity0, uri1);
                    return;
                }
                case "logout": {
                    u.r(baseActivity0, uri1);
                    return;
                }
                case "main": {
                    x.C(uri1);
                    return;
                }
                case "melondj": {
                    G.m(uri1);
                    return;
                }
                case "melontv": {
                    a.C(uri1);
                    return;
                }
                case "musicdna": {
                    d3.g.I(uri1);
                    return;
                }
                case "musicwave": {
                    d5.n.v(baseActivity0, uri1);
                    return;
                }
                case "mycomment": {
                    String s40 = uri1.getPath();
                    if(s40 == null || s40.hashCode() != 0 || !s40.equals("")) {
                        return;
                    }
                    String s41 = uri1.getQueryParameter("type");
                    if(s41 == null) {
                        return;
                    }
                    if(s41.equals("comment")) {
                        Navigator.open(MyMusicTabFragment.Companion.newInstance("mycomment", 0));
                        return;
                    }
                    if(s41.equals("reply")) {
                        Navigator.open(MyMusicTabFragment.Companion.newInstance("mycomment", 1));
                        return;
                    }
                    Navigator.open(MyMusicTabFragment.Companion.newInstance("mycomment", 0));
                    return;
                }
                case "mymusic": {
                    d5.t.h(uri1);
                    return;
                }
                case "new": {
                    String s16 = uri1.getPath();
                    if(s16 == null || s16.hashCode() != 0x55BD43A0 || !s16.equals("/album")) {
                        return;
                    }
                    String s17 = uri1.getQueryParameter("type");
                    Navigator.INSTANCE.openNewAlbum(s17);
                    return;
                }
                case "play": {
                    w.x(baseActivity0, uri1);
                    return;
                }
                case "player": {
                    d8.d.s(baseActivity0, uri1);
                    return;
                }
                case "playexternal": {
                    String s39 = uri1.getPath();
                    if(s39 == null || s39.hashCode() != 0 || !s39.equals("")) {
                        return;
                    }
                    EventBusHelper.post(new EventPlaybackScheme(uri1));
                    return;
                }
                case "recordandsearch": {
                    uri1.getQueryParameter("menuid");
                    String s9 = uri1.getPath();
                    if(s9 == null) {
                        return;
                    }
                    switch(s9) {
                        case "": {
                            Navigator.openSoundSearch();
                            return;
                        }
                        case "/shortcut": {
                            d3.g.a0("5", "S22", "E1");
                            Navigator.openSoundSearch();
                            return;
                        }
                        default: {
                            return;
                        }
                    }
                }
                case "search": {
                    String s10 = uri1.getPath();
                    if(s10 == null || s10.hashCode() != 0 || !s10.equals("")) {
                        return;
                    }
                    String s11 = uri1.getQueryParameter("keyword");
                    String s12 = uri1.getQueryParameter("tab");
                    String s13 = uri1.getQueryParameter("order");
                    if(s11 != null && s11.length() != 0) {
                        Navigator.openSearchKeyword(s11, s12, s13);
                        return;
                    }
                    Fd.D d0 = new Fd.D();
                    Navigator.INSTANCE.open(d0);
                    return;
                }
                case "setting": {
                    String s42 = uri1.getPath();
                    if(s42 == null) {
                        return;
                    }
                    BaseActivity baseActivity1 = this.a;
                    switch(s42.hashCode()) {
                        case 0xA25B0D1C: {
                            if(!s42.equals("/push/set")) {
                                return;
                            }
                            String s43 = uri1.getQueryParameter("mode");
                            pe.b b0 = m0.b;
                            if(b0 == null || !b0.isEmpty()) {
                                for(Object object2: b0) {
                                    if(v.j0(((m0)object2).name(), s43, true)) {
                                        break;
                                    }
                                }
                            }
                            String s44 = uri1.getQueryParameter("status");
                            pe.b b1 = n0.b;
                            if(b1 == null || !b1.isEmpty()) {
                                for(Object object3: b1) {
                                    if(v.j0(((n0)object3).name(), s44, true)) {
                                        break;
                                    }
                                }
                            }
                            Boolean boolean0 = s44 == null ? null : Boolean.valueOf(s44.equalsIgnoreCase("ON"));
                            if(s43 == null || boolean0 == null) {
                                return;
                            }
                            boolean z2 = boolean0.booleanValue();
                            if(!NetUtils.isConnected()) {
                                ToastManager.show(0x7F1303F3);  // string:error_unstable_network "네트워크 연결이 원활하지 않습니다.\n잠시 후 다시 시도해주세요."
                                return;
                            }
                            String s45 = s43.toUpperCase(Locale.ROOT);
                            q.f(s45, "toUpperCase(...)");
                            if(s45.equals("INFO")) {
                                MelonSettingInfo.setUsePushAlert(z2);
                                return;
                            }
                            if(!s45.equals("MARKETING")) {
                                return;
                            }
                            MelonSettingInfo.setUseMarketingPushAlert(z2);
                            return;
                        }
                        case 0xB319F129: {
                            if(!s42.equals("/songbitrate")) {
                                return;
                            }
                            Navigator.open(SettingSongFragment.newInstance());
                            return;
                        }
                        case 0xF928D21A: {
                            if(!s42.equals("/optimization/battery") || SystemSettingUtils.isIgnoringBatteryOptimizations(baseActivity1)) {
                                return;
                            }
                            SystemSettingUtils.openBatteryOptimizationsInSetting(baseActivity1);
                            return;
                        }
                        case 0: {
                            if(!s42.equals("")) {
                                return;
                            }
                            Navigator.open(SettingMainFragment.Companion.newInstance());
                            return;
                        }
                        case 1507070: {
                            if(!s42.equals("/lab")) {
                                return;
                            }
                            Navigator.open(SettingLaboratoryFragment.Companion.newInstance());
                            return;
                        }
                        case 0x2CAFFC9: {
                            if(!s42.equals("/push")) {
                                return;
                            }
                            Navigator.open(SettingPushFragment.newInstance());
                            return;
                        }
                        case 0x3062BC65: {
                            if(!s42.equals("/alarm/voice")) {
                                return;
                            }
                            Navigator.INSTANCE.openVoiceAlarm();
                            return;
                        }
                        case 1002992948: {
                            if(!s42.equals("/stoptimer")) {
                                return;
                            }
                            String s46 = uri1.getQueryParameter("mode");
                            String s47 = uri1.getQueryParameter("time");
                            boolean z3 = uri1.getBooleanQueryParameter("open", false);
                            if(baseActivity1 == null) {
                                logU$Companion0.w("setting/stoptimer", "context is null!!");
                                return;
                            }
                            if("ON".equalsIgnoreCase(s46)) {
                                int v4 = ProtocolUtils.parseInt(s47, -1);
                                if(v4 > 0) {
                                    o8.c.g(baseActivity1, v4, true);
                                }
                            }
                            else if("OFF".equalsIgnoreCase(s46)) {
                                o8.c.g(baseActivity1, -1, false);
                            }
                            if(!z3) {
                                return;
                            }
                            Navigator.open(SettingStopTimerFragment.Companion.newInstance());
                            return;
                        }
                        case 0x55BD3F82: {
                            if(!s42.equals("/alarm") || !com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, baseActivity1, null, null, 6, null)) {
                                return;
                            }
                            String s48 = uri1.getQueryParameter("mode");
                            String s49 = uri1.getQueryParameter("hour");
                            String s50 = uri1.getQueryParameter("minute");
                            String s51 = uri1.getQueryParameter("dayofweek");
                            String s52 = uri1.getQueryParameter("volume");
                            if(s48 == null || s48.length() == 0) {
                                return;
                            }
                            GregorianCalendar gregorianCalendar0 = new GregorianCalendar();
                            if(s49 == null) {
                                v5 = gregorianCalendar0.get(11);
                            }
                            else {
                                v5 = ProtocolUtils.parseInt(s49, 1);
                                if(v5 < 1) {
                                    v5 = 1;
                                }
                                if(v5 > 24) {
                                    v5 = 24;
                                }
                            }
                            if(s50 == null) {
                                v6 = gregorianCalendar0.get(12);
                            }
                            else {
                                v6 = ProtocolUtils.parseInt(s50, 0);
                                if(v6 < 0) {
                                    v6 = 0;
                                }
                                if(v6 > 59) {
                                    v6 = 59;
                                }
                            }
                            if(s51 == null) {
                                v7 = gregorianCalendar0.get(7) - 1;
                            }
                            else {
                                v7 = ProtocolUtils.parseInt(s51, 0);
                                if(v7 < 0) {
                                    v7 = 0;
                                }
                                if(v7 > 6) {
                                    v7 = 6;
                                }
                            }
                            int v8 = ProtocolUtils.parseInt(s52, 7);
                            if(v8 < 0) {
                                v8 = 0;
                            }
                            o8.d d1 = new o8.d(v5, v6, (v8 <= 15 ? v8 : 15), 0, null, 0x1FF1);
                            MusicAlarmPrefsHelper musicAlarmPrefsHelper0 = MusicAlarmPrefsHelper.INSTANCE;
                            if(musicAlarmPrefsHelper0.getAlarmList().isEmpty()) {
                                v9 = 1;
                            }
                            else {
                                Iterator iterator4 = musicAlarmPrefsHelper0.getAlarmList().iterator();
                                if(!iterator4.hasNext()) {
                                    throw new NoSuchElementException();
                                }
                                Object object4 = iterator4.next();
                                Integer integer0 = ((o8.d)object4).a;
                                while(iterator4.hasNext()) {
                                    Object object5 = iterator4.next();
                                    Integer integer1 = ((o8.d)object5).a;
                                    if(integer0.compareTo(integer1) < 0) {
                                        integer0 = integer1;
                                    }
                                }
                                v9 = integer0.intValue() + 1;
                            }
                            d1.a = v9;
                            d1.f[v7] = true;
                            d1.h = true;
                            String s53 = s48.toUpperCase(Locale.ROOT);
                            q.f(s53, "toUpperCase(...)");
                            switch(s53.hashCode()) {
                                case -2015466310: {
                                    if(s53.equals("MODIFY")) {
                                        MusicAlarmPrefsHelper musicAlarmPrefsHelper1 = MusicAlarmPrefsHelper.INSTANCE;
                                        o8.d d2 = (o8.d)p.m0(musicAlarmPrefsHelper1.getAlarmList());
                                        if(d2 != null) {
                                            if(s49 != null) {
                                                d2.b = d1.b;
                                            }
                                            if(s50 != null) {
                                                d2.c = d1.c;
                                            }
                                            if(s51 != null) {
                                                boolean[] arr_z = d1.f;
                                                q.g(arr_z, "<set-?>");
                                                d2.f = arr_z;
                                            }
                                            if(s52 != null) {
                                                d2.d = d1.d;
                                            }
                                            if((s49 != null || s50 != null || s51 != null || s52 != null) && o8.c.f(e.d(d2), d2.a, false)) {
                                                musicAlarmPrefsHelper1.updateAlarm(d2);
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 0x9DF: {
                                    if(s53.equals("ON")) {
                                        MusicAlarmPrefsHelper musicAlarmPrefsHelper2 = MusicAlarmPrefsHelper.INSTANCE;
                                        o8.d d3 = (o8.d)p.m0(musicAlarmPrefsHelper2.getAlarmList());
                                        if(d3 != null) {
                                            d3.e = true;
                                            if(o8.c.f(e.d(d3), d3.a, true)) {
                                                musicAlarmPrefsHelper2.updateAlarm(d3);
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 0xFC81: {
                                    if(s53.equals("ADD") && o8.c.f(e.d(d1), d1.a, true)) {
                                        MusicAlarmPrefsHelper.INSTANCE.addAlarm(d1);
                                    }
                                    break;
                                }
                                case 0x1314F: {
                                    if(s53.equals("OFF")) {
                                        MusicAlarmPrefsHelper musicAlarmPrefsHelper3 = MusicAlarmPrefsHelper.INSTANCE;
                                        o8.d d4 = (o8.d)p.m0(musicAlarmPrefsHelper3.getAlarmList());
                                        if(d4 != null) {
                                            d4.e = false;
                                            o8.c.b(d4.a);
                                            musicAlarmPrefsHelper3.updateAlarm(d4);
                                        }
                                    }
                                    break;
                                }
                                case 0x251E4A: {
                                    if(s53.equals("OPEN")) {
                                        Navigator.INSTANCE.openMusicAlarmList();
                                    }
                                    break;
                                }
                                case 0x3B7AB20: {
                                    if(s53.equals("ALLON")) {
                                        for(Object object6: MusicAlarmPrefsHelper.INSTANCE.getAlarmList()) {
                                            o8.d d5 = (o8.d)object6;
                                            d5.e = true;
                                            if(o8.c.f(e.d(d5), d5.a, false)) {
                                                MusicAlarmPrefsHelper.INSTANCE.updateAlarm(d5);
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 0x733DB82E: {
                                    if(s53.equals("ALLOFF")) {
                                        for(Object object7: MusicAlarmPrefsHelper.INSTANCE.getAlarmList()) {
                                            ((o8.d)object7).e = false;
                                            o8.c.b(((o8.d)object7).a);
                                            MusicAlarmPrefsHelper.INSTANCE.updateAlarm(((o8.d)object7));
                                        }
                                    }
                                    break;
                                }
                                case 0x77F979AB: {
                                    if(s53.equals("DELETE")) {
                                        MusicAlarmPrefsHelper musicAlarmPrefsHelper4 = MusicAlarmPrefsHelper.INSTANCE;
                                        if(!musicAlarmPrefsHelper4.getAlarmList().isEmpty()) {
                                            List list1 = musicAlarmPrefsHelper4.getAlarmList().subList(0, 1);
                                            q.g(list1, "musicAlarmList");
                                            for(Object object8: list1) {
                                                o8.c.b(((o8.d)object8).a);
                                            }
                                            musicAlarmPrefsHelper4.removeAlarm(list1);
                                        }
                                    }
                                }
                            }
                            EventBusHelper.post(new EventAlarm());
                            return;
                        }
                        case 0x5CEF6A05: {
                            if(!s42.equals("/melonlogin")) {
                                return;
                            }
                            String s54 = uri1.getQueryParameter("returnUri");
                            Navigator.openLoginView((TextUtils.isEmpty(s54) ? f.i : Uri.parse(s54)));
                            return;
                        }
                        case 0x771F9D49: {
                            if(!s42.equals("/myinfo")) {
                                return;
                            }
                            l0 l00 = new l0();  // 初始化器: Ljava/lang/Object;-><init>()V
                            l00.i1(uri1);
                            if(!((e0)o.a()).m()) {
                                Navigator.openLoginView(l00.c1());
                                return;
                            }
                            Navigator.openUrl(M.R, OpenType.FirstDepth);
                            return;
                        }
                        case 2103173539: {
                            if(!s42.equals("/melonlogin/manager")) {
                                return;
                            }
                            if(!((e0)o.a()).m()) {
                                Navigator.openLoginView(f.i);
                                return;
                            }
                            q.g(f.i, "returnUri");
                            Gd.u u0 = new Gd.u();
                            Bundle bundle6 = new Bundle();
                            bundle6.putParcelable("returnUri", f.i);
                            u0.setArguments(bundle6);
                            Navigator.INSTANCE.open(u0);
                            return;
                        }
                        default: {
                            return;
                        }
                    }
                }
                case "station": {
                    de.c.s(uri1);
                    return;
                }
                case "streamingcard": {
                    String s27 = uri1.getPath();
                    if(s27 == null || s27.hashCode() != 0 || !s27.equals("")) {
                        return;
                    }
                    String s28 = uri1.getQueryParameter("cid");
                    if(s28 == null) {
                        return;
                    }
                    Navigator.INSTANCE.openStreamingCard(s28);
                    return;
                }
                case "tiara": {
                    if(baseActivity0 == null) {
                        return;
                    }
                    String s23 = uri1.getPath();
                    if(s23 == null || s23.hashCode() != -1096569838 || !s23.equals("/updatemyinfo")) {
                        return;
                    }
                    String s24 = u.v(((e0)(((mb.k)p8.q.e.getValue()))).j());
                    if(!u.o(s24)) {
                        return;
                    }
                    p8.m m0 = new p8.m(s24, null);
                    BuildersKt__Builders_commonKt.launch$default(p8.q.b, null, null, m0, 3, null);
                    return;
                }
                case "token": {
                    p0.a(baseActivity0, uri1);
                    return;
                }
                case "trend": {
                    String s25 = uri1.getPath();
                    if(s25 == null || s25.hashCode() != 0x60A2B7F1 || !s25.equals("/shortform")) {
                        return;
                    }
                    String s26 = uri1.getQueryParameter("slotId");
                    Navigator.open(TrendShortFormFragment.Companion.newInstance(s26));
                    return;
                }
                case "webview": {
                    df.d.o(baseActivity0, uri1, true);
                    return;
                }
            }
        }
        if(this.b()) {
            return;
        }
        this.d();
    }

    public final void d() {
        LogU.Companion.e("DeeplinkManager.kt", "showVersionUpdatePopup() - activity is null");
        String s = null;
        BaseActivity baseActivity0 = this.a;
        androidx.fragment.app.l0 l00 = baseActivity0 == null ? null : baseActivity0.getSupportFragmentManager();
        if(baseActivity0 != null) {
            s = "현재 버전에서 지원하지 않는 기능입니다. 앱 업데이트 후 사용해주세요.";
        }
        com.melon.ui.popup.b.x(l00, (baseActivity0 == null ? null : "안내"), s, false, false, null, null, new e3(this, 11), null, null, null, 0xEF8);
    }
}

