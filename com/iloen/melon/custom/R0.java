package com.iloen.melon.custom;

import Ba.L;
import Bb.c;
import Ma.l;
import O8.d;
import android.text.TextUtils;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.eventbus.EventAlertDialog;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.UncheckAll;
import com.iloen.melon.net.v4x.response.DownloadInfoRes.Response.ContentsInfo;
import com.iloen.melon.net.v4x.response.DownloadInfoRes;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import k8.Y;
import k8.o;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import tg.Q;
import x8.f;

public final class r0 extends f {
    public DownloadInfoRes a;
    public HashMap b;
    public String c;
    public String d;
    public final MelonWebView e;

    public r0(MelonWebView melonWebView0) {
        this.e = melonWebView0;
        super();
        this.a = null;
        this.c = "";
        this.d = "";
    }

    public final String a(String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(!TextUtils.isEmpty(s)) {
            stringBuilder0.append("Extra message : ");
            stringBuilder0.append(s);
        }
        if(this.b != null) {
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append("\n");
            }
            stringBuilder0.append(":: queryInfo ::");
            stringBuilder0.append("\n");
            for(Object object0: this.b.keySet()) {
                stringBuilder0.append(((String)object0));
                stringBuilder0.append(" : ");
                stringBuilder0.append(((String)this.b.get(((String)object0))));
                stringBuilder0.append("\n");
            }
        }
        return stringBuilder0.toString();
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        DownloadInfoRes downloadInfoRes0;
        Void void0 = (Void)object0;
        HashMap hashMap0 = this.b;
        LogU.d("MelonWebView", "doGetPathRequest html " + this.d);
        CType cType0 = CType.get(((String)hashMap0.get("ctype")));
        String s = (String)hashMap0.get("cid");
        String s1 = (String)hashMap0.get("bitrate");
        String s2 = (String)hashMap0.get("drm");
        String s3 = (String)hashMap0.get("product");
        if(TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2)) {
            d.g(this.a("AsyncDownloadTask$doGetPathRequest() - Invalid params."));
        }
        else {
            if(!CType.MV.equals(cType0) && !CType.EDU.equals(cType0)) {
                String[] arr_s = s1.split(",");
                if(arr_s != null) {
                    s1 = "";
                    int v = 0;
                    while(v < arr_s.length) {
                        StringBuilder stringBuilder0 = Y.p(s1);
                        stringBuilder0.append(MelonSettingInfo.getDownloadBitrate());
                        s1 = stringBuilder0.toString();
                        ++v;
                        if(v < arr_s.length) {
                            s1 = s1 + ",";
                        }
                    }
                }
            }
            L l0 = ((o)(((l)b.B(MelonAppBase.instance.getContext(), l.class)))).n();
            try {
                Q q0 = l0.h(String.valueOf(cType0), s, s1, s2, s3).execute();
                Object object1 = q0.b;
                if(!q0.a.isSuccessful() || object1 == null || ((DownloadInfoRes)object1).response == null || !((DownloadInfoRes)object1).response.result.equals("0")) {
                    LogU.e("MelonWebView", "doGetPathRequest() - Response error");
                    d.h(this.a("AsyncDownloadTask$doGetPathRequest() - Response error"), null);
                    downloadInfoRes0 = null;
                    this.a = downloadInfoRes0;
                    return null;
                }
                else {
                    downloadInfoRes0 = (DownloadInfoRes)object1;
                }
                this.a = downloadInfoRes0;
                return null;
            }
            catch(Exception exception0) {
                LogU.e("MelonWebView", "doGetPathRequest() " + exception0);
                EventBusHelper.post(EventAlertDialog.fromException(exception0));
                d.h(this.a("AsyncDownloadTask$doGetPathRequest() - Exception occurs."), null);
            }
        }
        downloadInfoRes0 = null;
        this.a = downloadInfoRes0;
        return null;
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        Void void0 = (Void)object0;
        MelonWebView melonWebView0 = this.e;
        melonWebView0.a.showBlockedProgress(false);
        EventBusHelper.post(new UncheckAll());
        if(this.a != null) {
            CType cType0 = CType.get(((String)this.b.get("ctype")));
            String s = (String)this.b.get("cid");
            String s1 = (String)this.b.get("drm");
            String s2 = (String)this.b.get("bitrate");
            String s3 = (String)this.b.get("prodCd");
            String s4 = (String)this.b.get("product");
            String s5 = (String)this.b.get("giftid");
            String s6 = (String)this.b.get("menuid");
            String[] arr_s = s.split(",");
            String[] arr_s1 = s1.split(",");
            String[] arr_s2 = s2.split(",");
            String s7 = (String)this.b.get("changeurl");
            String s8 = (String)this.b.get("returl");
            if(!TextUtils.isEmpty(s7)) {
                try {
                    melonWebView0.r = URLDecoder.decode(s7, "UTF-8");
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    LogU.e("MelonWebView", unsupportedEncodingException0.toString());
                }
            }
            if(TextUtils.isEmpty(melonWebView0.o) && !TextUtils.isEmpty(s8)) {
                try {
                    melonWebView0.j(URLDecoder.decode(s8, "UTF-8"), "DownloadPathRes");
                }
                catch(UnsupportedEncodingException unsupportedEncodingException1) {
                    LogU.e("MelonWebView", unsupportedEncodingException1.toString());
                }
            }
            if(!melonWebView0.e()) {
                MelonWebViewInterface melonWebViewInterface0 = melonWebView0.a;
                if(melonWebViewInterface0 != null) {
                    melonWebViewInterface0.navigateBack();
                }
            }
            ArrayList arrayList0 = this.a.response.contentsInfo;
            if(arrayList0 != null && arrayList0.size() > 0) {
                int v1 = arrayList0.size();
                ArrayList arrayList1 = new ArrayList();
                for(int v = 0; v < v1; ++v) {
                    ContentsInfo downloadInfoRes$Response$ContentsInfo0 = (ContentsInfo)arrayList0.get(v);
                    String s9 = CType.MV.equals(cType0) || CType.EDU.equals(cType0) ? arr_s2[v] : MelonSettingInfo.getDownloadBitrate();
                    c c0 = new c();
                    String s10 = arr_s[v];
                    q.g(s10, "<set-?>");
                    c0.b = s10;
                    c0.c = cType0;
                    String s11 = arr_s1[v];
                    q.g(s11, "<set-?>");
                    c0.d = s11;
                    q.g(s9, "<set-?>");
                    c0.e = s9;
                    c0.f = s4;
                    c0.g = s5;
                    c0.h = s6;
                    c0.i = "";
                    String s12 = downloadInfoRes$Response$ContentsInfo0.filename;
                    q.g(s12, "<set-?>");
                    c0.j = s12;
                    c0.k = "";
                    c0.l = downloadInfoRes$Response$ContentsInfo0.filename;
                    c0.m = "";
                    c0.n = downloadInfoRes$Response$ContentsInfo0.solTypeCode;
                    c0.p = downloadInfoRes$Response$ContentsInfo0.solFileUpdtDate;
                    c0.o = downloadInfoRes$Response$ContentsInfo0.sol;
                    arrayList1.add(c0);
                }
                Bb.b.d(arrayList1);
                return;
            }
            d.g(this.a("AsyncDownloadTask$onPostExecute() - Empty downloadList."));
        }
    }

    @Override  // x8.f
    public final void preTask() {
        this.e.a.showBlockedProgress(true);
        try {
            String s = URLDecoder.decode(this.c, "UTF-8");
            this.d = s;
            this.b = MelonWebView.d(s);
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
        }
    }
}

