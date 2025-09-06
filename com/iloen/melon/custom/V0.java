package com.iloen.melon.custom;

import A7.d;
import A8.M;
import Fd.Y;
import Q1.c;
import U4.x;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.CloseAndGoAppHome;
import com.iloen.melon.eventbus.EventWebView.DialogClose;
import com.iloen.melon.eventbus.EventWebView.OpenUrl;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.cipher.Rijndael_Algorithm;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import java.net.URLEncoder;
import kotlin.jvm.internal.q;
import org.json.JSONException;
import org.json.JSONObject;

public final class v0 implements Runnable {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final MelonJavaScriptInterface e;

    public v0(MelonJavaScriptInterface melonWebView$MelonJavaScriptInterface0, String s, String s1, String s2, String s3) {
        this.e = melonWebView$MelonJavaScriptInterface0;
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
    }

    @Override
    public final void run() {
        String s9;
        String s7;
        int v3;
        int v2;
        boolean z1;
        int v1;
        MelonJavaScriptInterface melonWebView$MelonJavaScriptInterface0 = this.e;
        MelonWebView melonWebView0 = melonWebView$MelonJavaScriptInterface0.a;
        String s = this.a;
        boolean z = true;
        String s1 = this.d;
        int v = 0;
        String s2 = this.c;
        String s3 = this.b;
        if(s.equals("toolbar")) {
            try {
                melonWebView0.n = false;
                v1 = Integer.parseInt(s3);
            }
            catch(Exception unused_ex) {
                LogU.w("MelonWebView", "requestCommand() toolbar - invalid count param");
                v1 = 0;
            }
            try {
                z1 = Boolean.parseBoolean(s2);
                if(s1.equals("myalbum")) {
                    v2 = 0;
                }
                else if(s1.equals("mv")) {
                    melonWebView0.n = true;
                    v2 = 1;
                    goto label_22;
                }
                else if(s1.equals("edu")) {
                    v2 = 2;
                label_22:
                    z = false;
                }
                else if(s1.equals("flac")) {
                    z = false;
                    v2 = 3;
                }
                else {
                    v2 = 0;
                    z = false;
                }
            }
            catch(Exception unused_ex) {
                z = false;
                goto label_36;
            }
            v = v2;
        label_36:
            if(melonWebView0.d) {
                melonWebView0.b = z1;
                MelonWebViewInterface melonWebViewInterface0 = melonWebView0.a;
                if(melonWebViewInterface0 == null) {
                    return;
                }
                melonWebViewInterface0.showToolbar(z1, v, v1, z);
                return;
            }
            if(!melonWebView0.b || z1) {
                return;
            }
            melonWebView0.b = false;
            MelonWebViewInterface melonWebViewInterface1 = melonWebView0.a;
            if(melonWebViewInterface1 == null) {
                return;
            }
            melonWebViewInterface1.showToolbar(false, v, v1, z);
            return;
        }
        if("Streaming".equals(s)) {
            v3 = 0;
        }
        else {
            if("StreamingMix".equals(s)) {
                v3 = 0;
                goto label_255;
            }
            if("NowplayingAdd".equals(s)) {
                melonWebView0.loadUrl(d.n(d.o("javascript:var pvalue = \'\'; for (var _i=0; _i < document.", s3, ".length; _i++) { pvalue += (document.", s3, "[_i].name + \'=\' + document."), s3, "[_i].value); if (_i != document.", s3, ".length-1) pvalue += \'&\'; } pvalue; window.melonapp.showHTML(1, pvalue);"));
                return;
            }
            if(s.equals("Download")) {
                StringBuilder stringBuilder0 = d.o("javascript:var pvalue = \'\'; for (var _i=0; _i < document.", s3, ".length; _i++) { pvalue += (document.", s3, "[_i].name + \'=\' + document.");
                d.u(stringBuilder0, s3, "[_i].value); if (_i != document.", s3, ".length-1) pvalue += \'&\'; } pvalue; pvalue += \'&action=\' + document.");
                String s4 = x.m(stringBuilder0, s3, ".action; window.melonapp.showHTML(2, pvalue);");
                String s5 = Uri.decode(Uri.decode(s2));
                if(TextUtils.equals(M.C, s5) || TextUtils.equals(M.B, s5)) {
                    melonWebView0.j(s5, "requestCommand");
                }
                melonWebView0.loadUrl(s4);
                return;
            }
            if(s.equals("LoginNeed")) {
                melonWebView0.a.doLoginNeedDlg();
                return;
            }
            if(!s.equals("GoMypage")) {
                if(s.equals("toast")) {
                    if("short".equals(s2)) {
                        ToastManager.showShort(s3);
                        return;
                    }
                    ToastManager.show(s3);
                    return;
                }
                if(s.equals("Move")) {
                    String s6 = "small";
                    OpenUrl eventWebView$OpenUrl0 = new OpenUrl();
                    if(s3 == null || !s3.equals("PopWebkit")) {
                        eventWebView$OpenUrl0.webMode = 0;
                    }
                    else {
                        if(s1 == null || !s1.equals("small")) {
                            s6 = "large";
                        }
                        eventWebView$OpenUrl0.screenMode = s6;
                        eventWebView$OpenUrl0.webMode = 1;
                    }
                    eventWebView$OpenUrl0.url = s2;
                    EventBusHelper.post(eventWebView$OpenUrl0);
                    return;
                }
                if(s.equals("MoveTab")) {
                    LogU.i("MoveTab", "------------------------------------");
                    LogU.d("MoveTab", "PARAM1 : " + s3);
                    LogU.d("MoveTab", "PARAM2 : " + s2);
                    LogU.i("MoveTab", "------------------------------------");
                    Intent intent0 = new Intent();
                    c.Y(intent0, "com.iloen.melon.movetab.action", true);
                    intent0.putExtra("param1", s3);
                    intent0.putExtra("param2", s2);
                    melonWebView0.getContext().sendBroadcast(intent0);
                    return;
                }
                if(s.equals("InvokeWeb")) {
                    Intent intent1 = new Intent();
                    c.Y(intent1, "android.intent.action.VIEW", false);
                    intent1.setData(Uri.parse(s3));
                    intent1.setFlags(0x10000000);
                    melonWebView0.getContext().startActivity(intent1);
                    return;
                }
                if(!s.equals("ReloadWeb") && !s.equals("GoProductJoin") && !s.equals("Smart")) {
                    if(s.equals("cateTabPop")) {
                        try {
                            JSONObject jSONObject0 = new JSONObject(s3);
                            melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject0, null, null, "cate", this.c);
                            LogU.d("MelonWebView", jSONObject0.toString());
                        }
                        catch(Exception exception0) {
                            exception0.printStackTrace();
                        }
                        return;
                    }
                    if(s.equals("genreTabPop")) {
                        try {
                            JSONObject jSONObject1 = new JSONObject(s3);
                            melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject1, null, null, "genre", this.c);
                            LogU.d("MelonWebView", jSONObject1.toString());
                        }
                        catch(JSONException jSONException0) {
                            jSONException0.printStackTrace();
                        }
                        return;
                    }
                    if(s.equals("longTabPop")) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(s2);
                            if(s3 != null && s3.equals("song")) {
                                s7 = "songLongTap";
                                melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject2, null, null, s7, this.c);
                                LogU.d("MelonWebView", jSONObject2.toString());
                                return;
                            }
                            if(s3 != null && s3.equals("album")) {
                                s7 = "albumLongTap";
                                melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject2, null, null, s7, this.c);
                                LogU.d("MelonWebView", jSONObject2.toString());
                                return;
                            }
                            if(s3 != null && s3.equals("mv")) {
                                s7 = "mvLongTap";
                                melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject2, null, null, s7, this.c);
                                LogU.d("MelonWebView", jSONObject2.toString());
                                return;
                            }
                            boolean z2 = false;
                            if(s3 != null && s3.equals("flac")) {
                                z2 = true;
                                s7 = "flacLongTap";
                            }
                            else if(s3 != null && s3.equals("djplylst")) {
                                z2 = true;
                                s7 = "djplylstLongTap";
                            }
                            if(z2) {
                                melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject2, null, null, s7, this.c);
                                LogU.d("MelonWebView", jSONObject2.toString());
                                return;
                            }
                        }
                        catch(JSONException jSONException1) {
                            jSONException1.printStackTrace();
                            return;
                        }
                    }
                    else {
                        if(s.equals("djplylstTabPop")) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(s3);
                                melonWebView$MelonJavaScriptInterface0.showPopup(jSONObject3, null, null, "djplylst", this.c);
                                LogU.d("MelonWebView", jSONObject3.toString());
                            }
                            catch(JSONException jSONException2) {
                                jSONException2.printStackTrace();
                            }
                            return;
                        }
                        if(s.equals("closePop")) {
                            EventBusHelper.post(new DialogClose());
                            return;
                        }
                        if(s.equals("grade")) {
                            Intent intent2 = new Intent();
                            c.Y(intent2, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                            intent2.putExtra("alertdialogtype", 7);
                            intent2.putExtra("albumid", s2);
                            melonWebView0.getContext().sendBroadcast(intent2);
                            return;
                        }
                        if(s.equals("adultBox")) {
                            Intent intent3 = new Intent();
                            c.Y(intent3, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
                            intent3.putExtra("alertdialogtype", 8);
                            intent3.putExtra("typekey", s3);
                            intent3.putExtra("messagekey", s2);
                            melonWebView0.getContext().sendBroadcast(intent3);
                            return;
                        }
                        if(s.equals("myalbum")) {
                            if(s3.equals("addSong")) {
                                try {
                                    JSONObject jSONObject4 = new JSONObject(s2);
                                    LogU.d("MelonWebView", jSONObject4.toString());
                                    new t0(this, jSONObject4).execute(jSONObject4);
                                }
                                catch(JSONException jSONException3) {
                                    jSONException3.printStackTrace();
                                }
                                return;
                            }
                        }
                        else if(!s.equals("djlist")) {
                            if(s.equals("AlbumSNS") || s.equals("ArtistSNS") || s.equals("SongSNS")) {
                                goto label_235;
                            }
                            if(s.equals("InvokeWebWithUserInfo")) {
                                if(TextUtils.isEmpty(s3)) {
                                    LogU.e("MelonWebView", "URL(param1) is Empty!");
                                    return;
                                }
                                StringBuilder stringBuilder1 = new StringBuilder();
                                try {
                                    String s8 = new String(Rijndael_Algorithm.Encrypt_String(s2.getBytes(), s2.getBytes().length));
                                    stringBuilder1.append(s3);
                                    stringBuilder1.append("&p_dimelon=");
                                    stringBuilder1.append("GtmTlYU5FHGJGyjcr73zrg%3D%3D");
                                    stringBuilder1.append("&p_tkn=");
                                    stringBuilder1.append("");
                                    stringBuilder1.append("&p_checkTime=");
                                    stringBuilder1.append(URLEncoder.encode(s8, "utf-8"));
                                }
                                catch(Exception exception1) {
                                    LogU.d("MelonWebView", exception1.getMessage());
                                }
                                LogU.d("MelonWebView", "> URL : " + stringBuilder1.toString());
                                Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder1.toString()));
                                intent4.setFlags(0x10000000);
                                try {
                                    melonWebView0.getContext().startActivity(intent4);
                                }
                                catch(ActivityNotFoundException activityNotFoundException0) {
                                    LogU.w("MelonWebView", "InvokeWebWithUserInfo() " + activityNotFoundException0.toString());
                                }
                                return;
                            }
                            if(s.equals("drmKey")) {
                                MelonJavaScriptInterface.a(melonWebView$MelonJavaScriptInterface0, s3);
                                return;
                            }
                            if(s.equals("drmKeyEnc")) {
                                try {
                                    MelonJavaScriptInterface.a(melonWebView$MelonJavaScriptInterface0, MelonCryptoManager.melonCrypto(0, s3));
                                }
                                catch(Exception unused_ex) {
                                }
                                return;
                            }
                            if(s.equals("closeAndGoAppHome")) {
                                CloseAndGoAppHome eventWebView$CloseAndGoAppHome0 = new CloseAndGoAppHome();
                                eventWebView$CloseAndGoAppHome0.targetUrl = s3;
                                EventBusHelper.post(eventWebView$CloseAndGoAppHome0);
                                return;
                            }
                            I1 i10 = melonWebView0.B;
                            if(i10 != null) {
                                q.g(s3, "param1");
                                q.g(s2, "param2");
                                q.g(s1, "param3");
                                if(s.equals("searchResult")) {
                                    Y y0 = (Y)((A0.c)i10).b;
                                    y0.f(s3, false);
                                    y0.g(s3, false);
                                    return;
                                }
                            }
                            MelonWebViewListener melonWebViewListener0 = melonWebView0.w;
                            if(melonWebViewListener0 != null) {
                                melonWebViewListener0.requestCommand(s, s3, s2, s1);
                                return;
                            label_235:
                                if(s.equals("ArtistSNS")) {
                                    s9 = "ArtistSNS";
                                }
                                else if(s.equals("AlbumSNS")) {
                                    s9 = "AlbumSNS";
                                }
                                else if(s.equals("SongSNS")) {
                                    s9 = "SongSNS";
                                }
                                else {
                                    s9 = null;
                                }
                                Z.w("snsMode_", s9, "MelonWebView");
                                try {
                                    melonWebView$MelonJavaScriptInterface0.showPopup(null, null, new String[]{s3, s2, s1}, s9, this.c);
                                    return;
                                }
                                catch(JSONException jSONException5) {
                                    jSONException5.printStackTrace();
                                }
                            }
                        }
                        else if(s3.equals("addSong")) {
                            try {
                                JSONObject jSONObject5 = new JSONObject(s2);
                                LogU.d("MelonWebView", jSONObject5.toString());
                                new u0(this, jSONObject5).execute(jSONObject5);
                            }
                            catch(JSONException jSONException4) {
                                jSONException4.printStackTrace();
                            }
                            return;
                        }
                    }
                }
            }
            try {
                return;
            }
            catch(JSONException jSONException1) {
            }
            jSONException1.printStackTrace();
            return;
        }
    label_255:
        if(!"Streaming".equals(s)) {
            v3 = 3;
        }
        StringBuilder stringBuilder2 = d.o("javascript:var pvalue = \'\'; for (var _i=0; _i < document.", s3, ".length; _i++) { pvalue += (document.", s3, "[_i].name + \'=\' + document.");
        d.u(stringBuilder2, s3, "[_i].value); if (_i != document.", s3, ".length-1) pvalue += \'&\'; } pvalue; window.melonapp.showHTML(");
        melonWebView0.loadUrl(x.g(v3, ", pvalue);", stringBuilder2));
    }
}

