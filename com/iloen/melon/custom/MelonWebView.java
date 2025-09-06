package com.iloen.melon.custom;

import A7.d;
import Ma.e;
import R8.t;
import U4.x;
import Y8.b;
import Y8.h;
import Z8.c;
import Z8.g;
import Z8.j;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.app.z;
import b3.Z;
import co.ab180.airbridge.Airbridge;
import com.android.billingclient.api.Purchase;
import com.android.volley.toolbox.RequestFuture;
import com.gaa.sdk.iap.k;
import com.gaa.sdk.iap.l;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.gson.n;
import com.google.gson.v;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.Error;
import com.iloen.melon.eventbus.EventWebView.Load;
import com.iloen.melon.eventbus.EventWebView.PagerPagingEnabled;
import com.iloen.melon.eventbus.EventWebView.WebViewChromeSslCertIssueAlert;
import com.iloen.melon.iap.google.GoogleIapOwnedPurchase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicDjPlaylistListReq;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistListReq;
import com.iloen.melon.net.v4x.request.PlaylistListBaseReq.Params;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistListRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.billing.BillingUtils;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.AdIdManager;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.utils.system.DeviceData;
import e1.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import je.q;
import je.w;
import k8.Y;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import va.e0;
import va.o;
import x1.a;

public class MelonWebView extends WebView {
    class MelonJavaScriptInterface {
        public final MelonWebView a;

        public static void a(MelonJavaScriptInterface melonWebView$MelonJavaScriptInterface0, String s) {
            LogU.d("MelonWebView", "DRM KEY REGISTERED - VMIN: " + s);
            MelonSettingInfo.setVirtualMin(s);
            ((e0)o.a()).A(true);
            new t(0).execute(null);
        }

        @JavascriptInterface
        public void print(String s, String s1) {
        }

        @JavascriptInterface
        public String requestCommand(String s, String s1, String s2, String s3) {
            List list2;
            ArrayList arrayList0;
            StringBuilder stringBuilder0 = d.o("requestCommand() cmd:", s, " ,param1:", s1, " ,param2:");
            stringBuilder0.append(s2);
            stringBuilder0.append(" ,param3:");
            stringBuilder0.append(s3);
            LogU.d("MelonWebView", stringBuilder0.toString());
            if(!TextUtils.isEmpty(s)) {
                List list0 = null;
                MelonWebView melonWebView0 = this.a;
                if(!s.equals("Query")) {
                    goto label_145;
                }
                if(s1 != null) {
                    if(s1.equals("mKey")) {
                        return u.v(((e0)o.a()).j());
                    }
                    if(s1.equals("deviceInfo")) {
                        return Build.MANUFACTURER + " - " + Build.MODEL + " - " + Build.VERSION.RELEASE;
                    }
                    if(s1.equals("appVer")) {
                        try {
                            Context context0 = melonWebView0.getContext();
                            return context0 == null ? "" : context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName;
                        }
                        catch(Exception exception0) {
                            LogU.e("MelonWebView", exception0.toString());
                            return "";
                        }
                    }
                    if(s1.equals("phoneNo")) {
                        String s4 = melonWebView0.l.e();
                        return s4.equals("88888888888") ? "" : s4;
                    }
                    if(s1.equals("isForceDark")) {
                        return "N";
                    }
                    if(s1.equals("searchHistory")) {
                        if(s2.equals("set")) {
                            MelonPrefs.getInstance().setString("searchHistory", s3);
                            return "";
                        }
                        return s2.equals("get") ? MelonPrefs.getInstance().getString("searchHistory", "") : "";
                    }
                    if(s1.equals("visitHistory")) {
                        if(s2.equals("set")) {
                            MelonPrefs.getInstance().setString("searchVisitHistory", s3);
                            return "";
                        }
                        return s2.equals("get") ? MelonPrefs.getInstance().getString("searchVisitHistory", "") : "";
                    }
                    if(s1.equals("getBillingType")) {
                        return BillingUtils.getBillingType();
                    }
                    if(s1.equals("getPurchaseList")) {
                        boolean z = BillingUtils.getBillingType().equals("GOOGLE");
                        w w0 = w.a;
                        if(z) {
                            h h0 = melonWebView0.j;
                            List list1 = h0.c == null ? null : ((List)h0.c.getValue());
                            SingleLiveEvent singleLiveEvent0 = h0.b;
                            if(singleLiveEvent0 != null) {
                                list0 = (List)singleLiveEvent0.getValue();
                            }
                            if(list1 == null) {
                                arrayList0 = w0;
                            }
                            else {
                                arrayList0 = new ArrayList(q.Q(10, list1));
                                for(Object object0: list1) {
                                    String s5 = ((Purchase)object0).getOriginalJson();
                                    kotlin.jvm.internal.q.f(s5, "getOriginalJson(...)");
                                    arrayList0.add(s5);
                                }
                            }
                            if(list0 != null) {
                                w0 = new ArrayList(q.Q(10, list0));
                                for(Object object1: list0) {
                                    String s6 = ((Purchase)object1).getOriginalJson();
                                    kotlin.jvm.internal.q.f(s6, "getOriginalJson(...)");
                                    ((ArrayList)w0).add(s6);
                                }
                            }
                            GoogleIapOwnedPurchase googleIapOwnedPurchase0 = new GoogleIapOwnedPurchase(arrayList0, w0);
                            String s7 = new com.google.gson.o().a().k(googleIapOwnedPurchase0);
                            LogU.Companion.d("GoogleIapUtilities", "convertPurchaseListToJsonStr() result:" + s7);
                            kotlin.jvm.internal.q.d(s7);
                            LogU.Companion.d("GoogleIapViewModel", "getOwnedPurchasesJson() ownedPurchasesJson:" + s7);
                            return s7;
                        }
                        if(BillingUtils.getBillingType().equals("ONE_STORE")) {
                            g g0 = melonWebView0.k.a;
                            if(g0 == null) {
                                list2 = null;
                            }
                            else {
                                SingleLiveEvent singleLiveEvent1 = g0.d;
                                list2 = singleLiveEvent1 == null ? null : ((List)singleLiveEvent1.getValue());
                            }
                            if(list2 != null) {
                                w0 = new ArrayList(q.Q(10, list2));
                                for(Object object2: list2) {
                                    ((ArrayList)w0).add(j.a(((k)object2), null));
                                }
                            }
                            String s8 = new com.google.gson.o().a().k(w0);
                            LogU.Companion.d("OneStoreIapUtilities", "convertPurchaseListToJsonStr() result:" + s8);
                            String s9 = s8.toString();
                            Y.w("getOwnedPurchasesJson() ownedPurchasesJson:", s9, LogU.Companion, "OneStoreIapViewModel");
                            return s9;
                        }
                    }
                    else if(s1.equals("restorePurchase")) {
                        if(BillingUtils.getBillingType().equals("GOOGLE")) {
                            h h1 = melonWebView0.j;
                            h1.getClass();
                            Companion logU$Companion0 = LogU.Companion;
                            logU$Companion0.d("GoogleIapViewModel", "restore()");
                            Y8.d d0 = h1.a;
                            if(d0 != null) {
                                logU$Companion0.d("BillingClientLifecycle", "restorePurchases()");
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new b(d0, null), 3, null);
                                return "";
                            }
                        }
                        else if(BillingUtils.getBillingType().equals("ONE_STORE")) {
                            g g1 = melonWebView0.k.a;
                            if(g1 != null) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new c(g1, null), 3, null);
                                return "";
                            }
                        }
                    }
                    else if(s1.equals("restoreCheck")) {
                        if(BillingUtils.getBillingType().equals("GOOGLE")) {
                            h h2 = melonWebView0.j;
                            h2.getClass();
                            Companion logU$Companion1 = LogU.Companion;
                            logU$Companion1.d("GoogleIapViewModel", "checkRestore()");
                            if(h2.a != null && (h2.a.b != null && h2.a.b.isReady())) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Y8.g(h2, null), 3, null);
                                return "";
                            }
                            logU$Companion1.e("GoogleIapViewModel", "checkRestore() billing client is not available ");
                            return "";
                        }
                        if(BillingUtils.getBillingType().equals("ONE_STORE")) {
                            g g2 = melonWebView0.k.a;
                            if(g2 != null) {
                                LogU.Companion.d("OneStoreIapClientLifecycle", "restoreCheck()");
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Z8.d(g2, null), 3, null);
                                return "";
                            }
                        }
                    }
                    else {
                        if(s1.equals("treviGetVersionInfo")) {
                            com.google.gson.t t0 = new com.google.gson.t();
                            t0.e("appVersion", "6.18.1.1");
                            t0.e("templateVersion", "");
                            return "{\"appVersion\":\"6.18.1.1\",\"templateVersion\":\"\"}";
                        }
                        if(s1.equals("treviGetUserInfo")) {
                            Info advertisingIdClient$Info0 = AdIdManager.INSTANCE.getAdId();
                            if(advertisingIdClient$Info0 != null) {
                                list0 = advertisingIdClient$Info0.getId();
                            }
                            com.google.gson.t t1 = new com.google.gson.t();
                            t1.e("deviceOs", "ANDROID");
                            t1.e("ifa", ((String)list0));
                            t1.e("userId", u.v(((e0)o.a()).j()));
                            t1.e("network", "wifi");
                            t1.e("appId", "");
                            return new n().j(t1);
                        }
                        if(s1.equals("treviGetAdIdTrackingInfo")) {
                            Info advertisingIdClient$Info1 = AdIdManager.INSTANCE.getAdId();
                            com.google.gson.t t2 = new com.google.gson.t();
                            t2.d("isLimitAdTrackingEnabled", new v(Boolean.valueOf((advertisingIdClient$Info1 == null ? true : advertisingIdClient$Info1.isLimitAdTrackingEnabled()))));
                            return new n().j(t2);
                        label_145:
                            v0 v00 = new v0(this, s, s1, s2, s3);
                            melonWebView0.m.post(v00);
                            return "";
                        }
                    }
                }
            }
            try {
            }
            catch(Exception exception0) {
                LogU.e("MelonWebView", exception0.toString());
            }
            return "";
        }

        @JavascriptInterface
        public void showHTML(int v, String s) {
            Z.w("showHTML html : ", s, "MelonWebView");
            Message message0 = this.a.m.obtainMessage(v);
            message0.obj = s;
            this.a.m.sendMessage(message0);
        }

        @JavascriptInterface
        public void showPopup(JSONObject jSONObject0, ArrayList arrayList0, String[] arr_s, String s, String s1) {
            String s27;
            String s24;
            String s23;
            String s17;
            String s8;
            String s41;
            String s40;
            LogU.i("MelonWebView", "showPopup() - " + s);
            if(s != null) {
                Context context0 = this.a.getContext();
                if(context0 != null) {
                    if(s.equals("genre")) {
                        JSONArray jSONArray0 = jSONObject0.getJSONArray(s);
                        int v = jSONArray0.length();
                        String[] arr_s1 = new String[v];
                        String[] arr_s2 = new String[v];
                        for(int v1 = 0; v1 < v; ++v1) {
                            arr_s1[v1] = jSONArray0.getJSONObject(v1).getString("id");
                            arr_s2[v1] = jSONArray0.getJSONObject(v1).getString("name");
                        }
                        Intent intent0 = new Intent();
                        Q1.c.Y(intent0, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                        intent0.putExtra("alertdialogtype", 2);
                        intent0.putExtra("titlekey", s1);
                        intent0.putExtra("key_ids", arr_s1);
                        intent0.putExtra("key_names", arr_s2);
                        context0.sendBroadcast(intent0);
                        return;
                    }
                    if(s.equals("cate")) {
                        JSONArray jSONArray1 = jSONObject0.getJSONArray("cateList");
                        int v2 = jSONArray1.length();
                        String[] arr_s3 = new String[v2];
                        String[] arr_s4 = new String[v2];
                        for(int v3 = 0; v3 < v2; ++v3) {
                            arr_s3[v3] = jSONArray1.getJSONObject(v3).getString("id");
                            arr_s4[v3] = jSONArray1.getJSONObject(v3).getString("name");
                        }
                        String s2 = jSONObject0.getString("selTitle");
                        Intent intent1 = new Intent();
                        Q1.c.Y(intent1, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                        intent1.putExtra("alertdialogtype", 12);
                        intent1.putExtra("titlekey", s2);
                        intent1.putExtra("key_ids", arr_s3);
                        intent1.putExtra("key_names", arr_s4);
                        context0.sendBroadcast(intent1);
                        return;
                    }
                    if(s.equals("songLongTap") || s.equals("mvLongTap")) {
                        String s30 = jSONObject0.getString("ID");
                        String s31 = jSONObject0.getString("MENUID");
                        String s32 = jSONObject0.getString("TITLE");
                        String s33 = jSONObject0.getString("ALBUMID");
                        String s34 = jSONObject0.getString("ARTISTID");
                        String s35 = jSONObject0.getString("ARTISTNAME");
                        String s36 = jSONObject0.getString("ADULTFLG");
                        String s37 = jSONObject0.getString("ISMV");
                        String s38 = jSONObject0.optString("ISBRANDJS", "false");
                        String s39 = jSONObject0.optString("BRANDKEY", "");
                        try {
                            s40 = "false";
                            s40 = jSONObject0.getString("ISSERVICE");
                            s41 = "";
                        }
                        catch(JSONException unused_ex) {
                        }
                        try {
                            s41 = jSONObject0.getString("THUMBNAIL");
                        }
                        catch(JSONException unused_ex) {
                        }
                        Intent intent8 = new Intent();
                        Q1.c.Y(intent8, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                        intent8.putExtra("alertdialogtype", 6);
                        intent8.putExtra("longtap_menuid", s31);
                        intent8.putExtra("longtap_title", s32);
                        intent8.putExtra("longtap_album_id", s33);
                        intent8.putExtra("longtap_artist_id", s34);
                        intent8.putExtra("longtap_artist_name", s35);
                        intent8.putExtra("longtap_adultflg", s36);
                        intent8.putExtra("longtap_is_mv", s37);
                        intent8.putExtra("longtap_thumbnail", s41);
                        if(s.equals("songLongTap")) {
                            intent8.putExtra("longtabtype", "song");
                            intent8.putExtra("longtap_id", s30);
                        }
                        else {
                            intent8.putExtra("longtabtype", "mv");
                            intent8.putExtra("longtap_mv_id", s30);
                            intent8.putExtra("longtap_mv_songid", jSONObject0.getString("SONGID"));
                            intent8.putExtra("longtap_mv_isbrandjs", s38);
                            intent8.putExtra("longtap_mv_brandkey", s39);
                        }
                        intent8.putExtra("longtap_isservice", s40);
                        context0.sendBroadcast(intent8);
                    }
                    else {
                        if(s.equals("albumLongTap")) {
                            String s3 = jSONObject0.getString("ID");
                            String s4 = jSONObject0.getString("MENUID");
                            String s5 = jSONObject0.getString("TITLE");
                            String s6 = jSONObject0.getString("ARTISTID");
                            String s7 = jSONObject0.getString("ARTISTNAME");
                            try {
                                s8 = "";
                                s8 = jSONObject0.getString("THUMBNAIL");
                            }
                            catch(JSONException unused_ex) {
                            }
                            Intent intent2 = new Intent();
                            Q1.c.Y(intent2, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                            intent2.putExtra("alertdialogtype", 6);
                            intent2.putExtra("longtabtype", "album");
                            intent2.putExtra("longtap_menuid", s4);
                            intent2.putExtra("longtap_title", s5);
                            intent2.putExtra("longtap_album_id", s3);
                            intent2.putExtra("longtap_artist_id", s6);
                            intent2.putExtra("longtap_artist_name", s7);
                            intent2.putExtra("longtap_thumbnail", s8);
                            context0.sendBroadcast(intent2);
                            return;
                        }
                        if(s.equals("flacLongTap")) {
                            String s9 = jSONObject0.getString("ID");
                            String s10 = jSONObject0.getString("MENUID");
                            String s11 = jSONObject0.getString("TITLE");
                            String s12 = jSONObject0.getString("ALBUMID");
                            String s13 = jSONObject0.getString("ARTISTID");
                            String s14 = jSONObject0.getString("ARTISTNAME");
                            String s15 = jSONObject0.getString("ADULTFLG");
                            String s16 = jSONObject0.getString("PRODSCLASCODE");
                            try {
                                s17 = "";
                                s17 = jSONObject0.getString("THUMBNAIL");
                            }
                            catch(JSONException unused_ex) {
                            }
                            Intent intent3 = new Intent();
                            Q1.c.Y(intent3, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                            intent3.putExtra("alertdialogtype", 6);
                            intent3.putExtra("longtabtype", "flac");
                            intent3.putExtra("longtap_menuid", s10);
                            intent3.putExtra("longtap_title", s11);
                            intent3.putExtra("longtap_id", s9);
                            intent3.putExtra("longtap_album_id", s12);
                            intent3.putExtra("longtap_artist_id", s13);
                            intent3.putExtra("longtap_artist_name", s14);
                            intent3.putExtra("longtap_adultflg", s15);
                            intent3.putExtra("longtap_prodsclascode", s16);
                            intent3.putExtra("longtap_thumbnail", s17);
                            context0.sendBroadcast(intent3);
                            return;
                        }
                        if(s.equals("djplylst")) {
                            String s18 = jSONObject0.getString("PLYLSTSEQ");
                            String s19 = jSONObject0.getString("MENUID");
                            String s20 = jSONObject0.getString("TITLE");
                            String s21 = jSONObject0.getString("OWNERMEMBERKEY");
                            String s22 = jSONObject0.getString("WITHDRAWYN");
                            try {
                                s23 = "";
                                s23 = jSONObject0.getString("OWNERNICKNAME");
                                s24 = "";
                            }
                            catch(JSONException unused_ex) {
                            }
                            try {
                                s24 = jSONObject0.getString("THUMBNAIL");
                            }
                            catch(JSONException unused_ex) {
                            }
                            Intent intent4 = new Intent();
                            Q1.c.Y(intent4, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                            intent4.putExtra("alertdialogtype", 18);
                            intent4.putExtra("longtap_menuid", s19);
                            intent4.putExtra("longtap_title", s20);
                            intent4.putExtra("longtap_plylst_seq", s18);
                            intent4.putExtra("longtap_owner_member_key", s21);
                            intent4.putExtra("longtap_owner_nickname", s23);
                            intent4.putExtra("longtap_withdrawyn", s22);
                            intent4.putExtra("longtap_thumbnail", s24);
                            context0.sendBroadcast(intent4);
                            return;
                        }
                        if(s.equals("myAlbum")) {
                            if(arrayList0 != null) {
                                int v4 = arrayList0.size();
                                String[] arr_s5 = new String[v4];
                                String[] arr_s6 = new String[v4];
                                for(int v5 = 0; v5 < v4; ++v5) {
                                    ArrayList arrayList1 = (ArrayList)arrayList0.get(v5);
                                    String s25 = arrayList1.get(0).toString();
                                    String s26 = arrayList1.get(1).toString();
                                    LogU.d("MelonWebView", "showPopup(myAlbum) " + s25 + ", " + s26);
                                    arr_s5[v5] = s25;
                                    arr_s6[v5] = s26;
                                }
                                try {
                                    s27 = "";
                                    s27 = jSONObject0.getString("THUMBNAIL");
                                }
                                catch(JSONException unused_ex) {
                                }
                                Intent intent5 = new Intent();
                                Q1.c.Y(intent5, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                                intent5.putExtra("alertdialogtype", 3);
                                intent5.putExtra("key_title", arr_s5);
                                intent5.putExtra("key_id", arr_s6);
                                intent5.putExtra("myalbum_songid", arr_s);
                                intent5.putExtra("longtap_thumbnail", s27);
                                context0.sendBroadcast(intent5);
                            }
                        }
                        else if(s.equals("addToDjList")) {
                            if(arrayList0 != null) {
                                int v6 = arrayList0.size();
                                String[] arr_s7 = new String[v6];
                                String[] arr_s8 = new String[v6];
                                for(int v7 = 0; v7 < v6; ++v7) {
                                    ArrayList arrayList2 = (ArrayList)arrayList0.get(v7);
                                    String s28 = arrayList2.get(0).toString();
                                    String s29 = arrayList2.get(1).toString();
                                    LogU.d("MelonWebView", "showPopup(addToDjList) " + s28 + ", " + s29);
                                    arr_s7[v7] = s28;
                                    arr_s8[v7] = s29;
                                }
                                Intent intent6 = new Intent();
                                Q1.c.Y(intent6, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                                intent6.putExtra("alertdialogtype", 16);
                                intent6.putExtra("key_title", arr_s7);
                                intent6.putExtra("key_id", arr_s8);
                                intent6.putExtra("djlist_songid", arr_s);
                                context0.sendBroadcast(intent6);
                            }
                        }
                        else if(s.equals("ArtistSNS") || s.equals("AlbumSNS") || s.equals("SongSNS")) {
                            LogU.d("MelonWebView", "sns_popup_intent_" + s);
                            Intent intent7 = new Intent();
                            Q1.c.Y(intent7, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                            intent7.putExtra("alertdialogtype", 4);
                            intent7.putExtra("sns_share", arr_s);
                            intent7.putExtra("sns_type", s);
                            context0.sendBroadcast(intent7);
                        }
                    }
                }
            }
        }
    }

    class MelonWebChromeClient extends WebChromeClient {
        public final Activity a;
        public View b;
        public FrameLayout c;
        public final FrameLayout.LayoutParams d;
        public WebChromeClient.CustomViewCallback e;
        public final MelonWebView f;

        public MelonWebChromeClient(Activity activity0) {
            this.a = activity0;
            this.d = new FrameLayout.LayoutParams(-1, -1);
        }

        public final void a(boolean z) {
            Window window0 = this.a.getWindow();
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            if(z) {
                windowManager$LayoutParams0.flags |= 0x400;
                View view0 = this.b;
                if(view0 != null) {
                    view0.setSystemUiVisibility(2050);
                }
            }
            else {
                windowManager$LayoutParams0.flags &= 0xFFFFFBFF;
                View view1 = this.b;
                if(view1 != null) {
                    view1.setSystemUiVisibility(0);
                }
            }
            window0.setAttributes(windowManager$LayoutParams0);
        }

        @Override  // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage0) {
            return super.onConsoleMessage(consoleMessage0);
        }

        @Override  // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if(this.b != null) {
                this.a(false);
                ((FrameLayout)this.a.getWindow().getDecorView()).removeView(this.c);
                this.c = null;
                this.b = null;
                this.e.onCustomViewHidden();
                MelonWebViewListener melonWebViewListener0 = MelonWebView.this.w;
                if(melonWebViewListener0 != null) {
                    melonWebViewListener0.restoreScreenRotation();
                }
            }
        }

        @Override  // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView0, String s, String s1, JsResult jsResult0) {
            LogU.v("MelonWebChromeClient", "onJsAlert() url:" + s + ", message:" + s1);
            MelonWebView.I.put(jsResult0.hashCode(), jsResult0);
            MelonWebView.G = jsResult0;
            int v = jsResult0.hashCode();
            MelonWebView melonWebView0 = MelonWebView.this;
            MelonWebViewListener melonWebViewListener0 = melonWebView0.w;
            if(melonWebViewListener0 != null) {
                melonWebViewListener0.requestCommand("onJsAlert", s1, String.valueOf(v), null);
            }
            melonWebView0.a.showProgress(false);
            return true;
        }

        @Override  // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView0, String s, String s1, JsResult jsResult0) {
            LogU.v("MelonWebChromeClient", "onJsConfirm() url:" + s + ", message:" + s1);
            MelonWebView.I.put(jsResult0.hashCode(), jsResult0);
            MelonWebView.G = jsResult0;
            int v = jsResult0.hashCode();
            MelonWebView melonWebView0 = MelonWebView.this;
            MelonWebViewListener melonWebViewListener0 = melonWebView0.w;
            if(melonWebViewListener0 != null) {
                melonWebViewListener0.requestCommand("onJsConfirm", s1, String.valueOf(v), null);
            }
            melonWebView0.a.showProgress(false);
            return true;
        }

        @Override  // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView0, int v) {
            super.onProgressChanged(webView0, v);
            if(v >= 60) {
                MelonWebView melonWebView0 = MelonWebView.this;
                MelonWebViewInterface melonWebViewInterface0 = melonWebView0.a;
                if(melonWebViewInterface0 != null) {
                    melonWebView0.c = false;
                    melonWebViewInterface0.showProgress(false);
                }
                melonWebView0.d = true;
            }
        }

        @Override  // android.webkit.WebChromeClient
        public void onShowCustomView(View view0, WebChromeClient.CustomViewCallback webChromeClient$CustomViewCallback0) {
            Activity activity0 = this.a;
            if(activity0 == null) {
                return;
            }
            if(this.b != null) {
                webChromeClient$CustomViewCallback0.onCustomViewHidden();
                return;
            }
            FrameLayout frameLayout0 = (FrameLayout)activity0.getWindow().getDecorView();
            FrameLayout frameLayout1 = new FrameLayout(activity0);
            this.c = frameLayout1;
            frameLayout1.addView(view0, this.d);
            frameLayout0.addView(this.c, this.d);
            this.b = view0;
            this.e = webChromeClient$CustomViewCallback0;
            this.a(true);
            ViewUtils.setOrientation(activity0, 13);
        }

        @Override  // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView0, ValueCallback valueCallback0, WebChromeClient.FileChooserParams webChromeClient$FileChooserParams0) {
            LogU.d("MelonWebChromeClient", "onShowFileChooser() Android 5.0+");
            MelonWebViewListener melonWebViewListener0 = MelonWebView.this.w;
            return melonWebViewListener0 == null ? false : melonWebViewListener0.showFileChooser(webView0, valueCallback0, webChromeClient$FileChooserParams0);
        }
    }

    public I1 B;
    public boolean D;
    public final z E;
    public static JsResult G;
    public static final Hashtable I;
    public MelonWebViewInterface a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public l f;
    public SmsRetrieverClient g;
    public boolean h;
    public MelonWebChromeClient i;
    public h j;
    public Z8.k k;
    public DeviceData l;
    public final a0 m;
    public boolean n;
    public String o;
    public String r;
    public MelonWebViewListener w;

    static {
        MelonWebView.G = null;
        MelonWebView.I = new Hashtable();
    }

    public MelonWebView(Context context0) {
        super(context0);
        this.a = null;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = new a0(this, 1);
        this.n = false;
        this.o = null;
        this.r = null;
        this.E = new z(this, 3);
    }

    public MelonWebView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = null;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = new a0(this, 1);
        this.n = false;
        this.o = null;
        this.r = null;
        this.E = new z(this, 3);
    }

    public MelonWebView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = null;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = new a0(this, 1);
        this.n = false;
        this.o = null;
        this.r = null;
        this.E = new z(this, 3);
    }

    public static ArrayList a(Context context0, String s) {
        LogU.d("MelonWebView", "fetchPersonalPlaylist() type:" + s);
        if("M20001".equals(s)) {
            RequestFuture requestFuture0 = RequestFuture.newFuture();
            Params playlistListBaseReq$Params0 = new Params();
            playlistListBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
            playlistListBaseReq$Params0.plylstTypeCode = s;
            try {
                MyMusicPlaylistListRes myMusicPlaylistListRes0 = (MyMusicPlaylistListRes)RequestBuilder.newInstance(new MyMusicPlaylistListReq(context0, playlistListBaseReq$Params0)).tag("MelonWebView").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                ArrayList arrayList0 = new ArrayList();
                if(myMusicPlaylistListRes0 != null && myMusicPlaylistListRes0.isSuccessful()) {
                    ArrayList arrayList1 = myMusicPlaylistListRes0.response == null ? null : myMusicPlaylistListRes0.response.playlistlist;
                    if(arrayList1 != null) {
                        for(Object object0: arrayList1) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(((PLAYLISTLIST)object0).plylsttitle);
                            arrayList2.add(((PLAYLISTLIST)object0).plylstseq);
                            arrayList0.add(arrayList2);
                        }
                    }
                }
                return arrayList0;
            }
            catch(Exception exception0) {
            }
            Z.v(exception0, new StringBuilder("fetchPersonalPlaylist() "), "MelonWebView");
            return null;
        }
        RequestFuture requestFuture1 = RequestFuture.newFuture();
        com.iloen.melon.net.v4x.request.DjPlaylistListBaseReq.Params djPlaylistListBaseReq$Params0 = new com.iloen.melon.net.v4x.request.DjPlaylistListBaseReq.Params();
        djPlaylistListBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        djPlaylistListBaseReq$Params0.plylstTypeCode = s;
        djPlaylistListBaseReq$Params0.startIndex = 1;
        djPlaylistListBaseReq$Params0.pageSize = 100;
        djPlaylistListBaseReq$Params0.mode = "all";
        try {
            MyMusicDjPlaylistListRes myMusicDjPlaylistListRes0 = (MyMusicDjPlaylistListRes)RequestBuilder.newInstance(new MyMusicDjPlaylistListReq(context0, djPlaylistListBaseReq$Params0)).tag("MelonWebView").listener(requestFuture1).errorListener(requestFuture1).requestSync(requestFuture1);
            ArrayList arrayList3 = new ArrayList();
            if(myMusicDjPlaylistListRes0 != null && myMusicDjPlaylistListRes0.isSuccessful()) {
                ArrayList arrayList4 = myMusicDjPlaylistListRes0.response == null ? null : myMusicDjPlaylistListRes0.response.playlistlist;
                if(arrayList4 != null) {
                    for(Object object1: arrayList4) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(((com.iloen.melon.net.v4x.response.MyMusicDjPlaylistListRes.RESPONSE.PLAYLISTLIST)object1).plylsttitle);
                        arrayList5.add(((com.iloen.melon.net.v4x.response.MyMusicDjPlaylistListRes.RESPONSE.PLAYLISTLIST)object1).plylstseq);
                        arrayList3.add(arrayList5);
                    }
                }
            }
            return arrayList3;
        }
        catch(Exception exception1) {
        }
        Z.v(exception1, new StringBuilder("fetchPersonalPlaylist() "), "MelonWebView");
        return null;
    }

    public final void b() {
        this.addJavascriptInterface(new MelonJavaScriptInterface(this), "melonapp");
    }

    public final void c() {
        if(this.e) {
            this.getContext().unregisterReceiver(this.E);
            this.e = false;
            ToastManager.debug("SMS receiver detached");
        }
        this.f = null;
        this.g = null;
    }

    public static HashMap d(String s) {
        String[] arr_s = s.split("&");
        HashMap hashMap0 = new HashMap();
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = arr_s[v];
            if(s1.split("=").length > 1) {
                hashMap0.put(s1.split("=")[0], s1.split("=")[1]);
            }
        }
        return hashMap0;
    }

    @Override  // android.webkit.WebView
    public final void destroy() {
        LogU.d("MelonWebView", "destroy()");
        this.c();
        this.j = null;
        super.destroy();
    }

    public final boolean e() {
        StringBuilder stringBuilder0 = new StringBuilder("handleReturnUrl - returnUrl: ");
        stringBuilder0.append(this.o);
        stringBuilder0.append(", changeUrl:");
        Z.x(stringBuilder0, this.r, "MelonWebView");
        String s = this.o;
        boolean z = false;
        if(!TextUtils.isEmpty(s)) {
            this.o = null;
            WebBackForwardList webBackForwardList0 = this.copyBackForwardList();
            int v = webBackForwardList0.getCurrentIndex();
            if(v > 0) {
                for(int v1 = 0; v1 < v; ++v1) {
                    WebHistoryItem webHistoryItem0 = webBackForwardList0.getItemAtIndex(v1);
                    StringBuilder stringBuilder1 = x.n(v1, "  historyUrl[", "]: ");
                    stringBuilder1.append(webHistoryItem0.getUrl());
                    LogU.v("MelonWebView", stringBuilder1.toString());
                    if(webHistoryItem0.getUrl().equals(s)) {
                        int v2 = v1 - v;
                        LogU.d("MelonWebView", "goBackOrForward(" + v2 + ")");
                        this.goBackOrForward(v2);
                        if(!TextUtils.isEmpty(this.r)) {
                            if(URLUtil.isNetworkUrl(this.r)) {
                                Z.x(new StringBuilder("load changeUrl: "), this.r, "MelonWebView");
                                this.loadUrl(this.r);
                            }
                            else if(URLUtil.isJavaScriptUrl(this.r)) {
                                Z.x(new StringBuilder("load changeUrl: "), this.r, "MelonWebView");
                                this.loadUrl(this.r);
                            }
                            else {
                                LogU.w("MelonWebView", "invalid changeUrl: " + this.r);
                            }
                            this.r = null;
                        }
                        z = true;
                        break;
                    }
                    if(v1 == v - 1) {
                        break;
                    }
                }
            }
        }
        LogU.d("MelonWebView", "handleReturnUrl - handled:" + z);
        return z;
    }

    public final void f() {
        MelonWebChromeClient melonWebView$MelonWebChromeClient0 = this.i;
        if(melonWebView$MelonWebChromeClient0 != null) {
            melonWebView$MelonWebChromeClient0.onHideCustomView();
        }
    }

    public final void g(MelonWebViewInterface melonWebViewInterface0, boolean z, Activity activity0) {
        this.l = ((k8.o)(((e)E9.w.s(this.getContext().getApplicationContext(), e.class)))).e();
        this.a = melonWebViewInterface0;
        this.i = new MelonWebChromeClient(this, activity0);
        boolean z1 = false;
        this.setScrollBarStyle(0);
        this.setWebViewClient(new w0(this));
        this.setWebChromeClient(this.i);
        this.setInitialScale(100);
        this.setSaveEnabled(true);
        this.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
        WebSettings webSettings0 = this.getSettings();
        webSettings0.setJavaScriptEnabled(true);
        webSettings0.setDomStorageEnabled(true);
        webSettings0.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings0.setSupportMultipleWindows(false);
        webSettings0.setSaveFormData(true);
        webSettings0.setSupportZoom(false);
        webSettings0.setNeedInitialFocus(false);
        int v = -1;
        webSettings0.setCacheMode((z ? 2 : -1));
        webSettings0.setUseWideViewPort(true);
        webSettings0.setTextZoom(100);
        webSettings0.setMixedContentMode(0);
        try {
            if(a.G("FORCE_DARK_STRATEGY")) {
                if(!T4.k.f.b()) {
                    throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
                }
                S4.a.a(webSettings0).Q();
            }
            if(a.G("FORCE_DARK")) {
                if(ScreenUtils.isDarkMode(this.getContext())) {
                    T4.b b0 = T4.k.e;
                    if(b0.a()) {
                        Qc.l.y(webSettings0, 2);
                    }
                    else {
                        if(!b0.b()) {
                            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
                        }
                        S4.a.a(webSettings0).P(2);
                    }
                }
                else {
                    T4.b b1 = T4.k.e;
                    if(b1.a()) {
                        Qc.l.y(webSettings0, 0);
                    }
                    else {
                        if(!b1.b()) {
                            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
                        }
                        S4.a.a(webSettings0).P(0);
                    }
                }
            }
        }
        catch(Exception exception0) {
            LogU.w("MelonWebView", "initialize() " + exception0);
        }
        String s = webSettings0.getUserAgentString();
        if(!TextUtils.isEmpty(s)) {
            String[] arr_s = s.trim().split("\\s+");
            if(arr_s != null) {
                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                    String s1 = arr_s[v1];
                    if(s1.toLowerCase().startsWith("chrome/")) {
                        try {
                            v = (int)Integer.valueOf(s1.substring(7).substring(0, 2));
                            break;
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                }
            }
        }
        LogU.v("MelonWebView", "hasChromeSslCertIssue() chrome version: " + v);
        this.h = v == 53 || v == 54;
        if(!TextUtils.isEmpty(MelonAppBase.instance.getMelonWebViewUserAgent())) {
            String s2 = webSettings0.getUserAgentString() + MelonAppBase.instance.getMelonWebViewUserAgent();
            LogU.v("MelonWebView", "initialize() UserAgent for Webkit : " + s2);
            webSettings0.setUserAgentString(s2);
        }
        this.b();
        if(!A8.b.e() && MelonSettingInfo.getWebViewContentsDebugging()) {
            z1 = true;
        }
        WebView.setWebContentsDebuggingEnabled(z1);
        Airbridge.setWebInterface(this, "42050fd2577d4c20ae084eee94019e8a");
    }

    public static JsResult getJsResult() {
        return MelonWebView.G;
    }

    public final boolean h(String s) {
        if(TextUtils.isEmpty(s)) {
            return true;
        }
        return !this.h || !s.trim().startsWith("https://") ? false : !MelonPrefs.getInstance().getBoolean("DO_NOT_LOOK_AGAIN_CHROME_SSL_CERT_ISSUE_ALERT", false);
    }

    public static void i(MelonWebViewInterface melonWebViewInterface0, int v) {
        LogU.i("MelonWebView", "processAction " + v);
        MelonWebView melonWebView0 = melonWebViewInterface0.getWebView();
        if(melonWebView0 != null) {
            switch(v) {
                case 0: {
                    melonWebView0.loadUrl("javascript:__appSongDown()");
                    return;
                }
                case 1: {
                    melonWebView0.loadUrl("javascript:__appSongPlay()");
                    return;
                }
                case 2: {
                    melonWebView0.loadUrl("javascript:__appSongNowplayAdd()");
                    return;
                }
                case 3: {
                    melonWebView0.loadUrl("javascript:__appSongAdd()");
                    return;
                }
                case 4: {
                    melonWebView0.loadUrl("javascript:__appSongDelete()");
                    return;
                }
                case 5: {
                    melonWebView0.loadUrl("javascript:__appAllSongDelete()");
                    return;
                }
                case 6: {
                    melonWebView0.loadUrl("javascript:__appMvDown()");
                    return;
                }
                case 7: {
                    melonWebView0.loadUrl("javascript:__appMvPlay()");
                    return;
                }
                case 8: {
                    melonWebView0.loadUrl("javascript:__appEduPlay()");
                    return;
                }
                case 9: {
                    melonWebView0.loadUrl("javascript:__appEduDown()");
                    return;
                }
                case 10: {
                    melonWebView0.loadUrl("javascript:__appPresent()");
                    return;
                }
                case 11: {
                    melonWebView0.loadUrl("javascript:__appSongAddForDj()");
                    return;
                }
                case 12: {
                    melonWebView0.loadUrl("javascript:__appSongPlayMix()");
                }
            }
        }
    }

    public final void j(String s, String s1) {
        LogU.d("MelonWebView", "saveReturnUrl() url:" + s + " ,caller: " + s1);
        this.o = s;
    }

    @Override  // android.webkit.WebView
    public final void loadUrl(String s) {
        if(TextUtils.isEmpty(s)) {
            EventBusHelper.post(new Error());
            return;
        }
        if(this.h(s)) {
            EventBusHelper.post(new WebViewChromeSslCertIssueAlert());
        }
        Z.w("loadUrl() ", s, "MelonWebView");
        super.loadUrl(s);
    }

    @Override  // android.webkit.WebView
    public final boolean onKeyDown(int v, KeyEvent keyEvent0) {
        Z.r(v, "MelonWebView OnKeyDown = ", "MelonWebView");
        if(v == 4 && this.canGoBack()) {
            this.goBack();
            return true;
        }
        return super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.webkit.WebView
    public final void onOverScrolled(int v, int v1, boolean z, boolean z1) {
        this.setViewPagerPaging(true);
        super.onOverScrolled(v, v1, z, z1);
    }

    @Override  // android.webkit.WebView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.c) {
            LogU.i("MelonWebView", "onTouchEvent bShowProgress ing.. return false");
            return false;
        }
        boolean z = super.onTouchEvent(motionEvent0);
        if(motionEvent0.getAction() == 0) {
            this.setViewPagerPaging(false);
            return true;
        }
        return z;
    }

    @Override  // android.webkit.WebView
    public final void postUrl(String s, byte[] arr_b) {
        LogU.d("MelonWebView", "postUrl - url:" + s + ", data:" + arr_b);
        if(TextUtils.isEmpty(s)) {
            EventBusHelper.post(new Error());
            return;
        }
        if(this.h(s)) {
            EventBusHelper.post(new WebViewChromeSslCertIssueAlert());
        }
        super.postUrl(s, arr_b);
    }

    @Override  // android.webkit.WebView
    public final void reload() {
        try {
            super.reload();
        }
        catch(NullPointerException nullPointerException0) {
            LogU.e("MelonWebView", nullPointerException0.toString());
        }
        catch(Exception exception0) {
            LogU.e("MelonWebView", exception0.toString());
        }
        EventBusHelper.post(new Load());
    }

    public void setCustomErrorView(boolean z) {
        this.D = z;
    }

    public void setViewPagerPaging(boolean z) {
        PagerPagingEnabled eventWebView$PagerPagingEnabled0 = new PagerPagingEnabled();
        eventWebView$PagerPagingEnabled0.isEnabled = z;
        EventBusHelper.post(eventWebView$PagerPagingEnabled0);
    }

    public void setWebViewJSConnect(I1 i10) {
        this.B = i10;
    }

    public void setWebViewListener(MelonWebViewListener melonWebViewListener0) {
        this.w = melonWebViewListener0;
    }
}

