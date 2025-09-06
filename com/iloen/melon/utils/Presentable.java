package com.iloen.melon.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.c;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.response.GiftInformProdGiftBoxRes.RESPONSE;
import com.iloen.melon.net.v4x.response.GiftListSongGiftBoxRes.RESPONSE.SONGLIST;
import e1.u;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import va.e0;
import va.o;

public class Presentable {
    public static class Builder {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public final String k;
        public String l;
        public String m;

        public Builder(int v, String s) {
            this.d = "0";
            this.c = String.valueOf(v);
            this.k = s;
        }

        public Presentable build() {
            return new Presentable(this);
        }

        public Builder contsIds(String s) {
            this.e = s;
            return this;
        }

        public Builder eventEnterAuthKey(String s) {
            this.m = s;
            return this;
        }

        public Builder giftProdGubun(int v) {
            this.c = String.valueOf(v);
            return this;
        }

        public Builder prodAmts(String s) {
            this.h = s;
            return this;
        }

        public Builder prodIds(String s) {
            this.g = s;
            return this;
        }

        public Builder prodSclasCodes(String s) {
            this.f = s;
            return this;
        }

        public Builder recvUsers(String s) {
            this.j = s;
            return this;
        }

        public Builder repContName(String s) {
            this.l = s;
            return this;
        }

        public Builder reptCnt(int v) {
            this.i = String.valueOf(v);
            return this;
        }

        public Builder sendContsCnt(int v) {
            this.d = String.valueOf(v);
            return this;
        }

        public Builder sendMsgCont(String s) {
            this.b = s;
            return this;
        }

        public Builder sendMsgTitle(String s) {
            this.a = s;
            return this;
        }

        public Builder setReceiver(ArrayList arrayList0) {
            this.i = String.valueOf(arrayList0.size());
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: arrayList0) {
                Receiver toReceiverView$Receiver0 = (Receiver)object0;
                if(!TextUtils.isEmpty(toReceiverView$Receiver0.a)) {
                    stringBuilder0.append("0|");
                    stringBuilder0.append(toReceiverView$Receiver0.a);
                }
                else if(!TextUtils.isEmpty(toReceiverView$Receiver0.b)) {
                    stringBuilder0.append("1|");
                    stringBuilder0.append(toReceiverView$Receiver0.b);
                }
                stringBuilder0.append(",");
            }
            if(stringBuilder0.length() > 0) {
                stringBuilder0.deleteCharAt(stringBuilder0.length() - 1);
            }
            this.j = stringBuilder0.toString();
            return this;
        }
    }

    public static final int TYPE_PRODUCT = 0;
    public static final int TYPE_SONG = 1;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;

    public Presentable(Builder presentable$Builder0) {
        this.a = u.v(((e0)o.a()).j());
        this.b = presentable$Builder0.a;
        this.c = presentable$Builder0.b;
        this.d = MelonAppBase.instance.getMelonCpId();
        this.e = presentable$Builder0.c;
        this.f = presentable$Builder0.d;
        this.g = presentable$Builder0.e;
        this.h = presentable$Builder0.f;
        this.i = presentable$Builder0.g;
        this.j = presentable$Builder0.h;
        this.k = presentable$Builder0.i;
        this.l = presentable$Builder0.j;
        this.m = "211.100.020.022";
        this.n = "";
        this.o = presentable$Builder0.k;
        this.p = presentable$Builder0.l;
        this.q = presentable$Builder0.m;
    }

    public static Builder newBuilder(int v, String s) {
        return new Builder(v, s);
    }

    public static Builder newBuilder(RESPONSE giftInformProdGiftBoxRes$RESPONSE0, String s) {
        return Presentable.newBuilder(0, s).prodIds(giftInformProdGiftBoxRes$RESPONSE0.prodId).prodAmts(giftInformProdGiftBoxRes$RESPONSE0.prodAmts);
    }

    public static Builder newBuilder(List list0, String s) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: list0) {
            stringBuilder0.append(((SONGLIST)object0).songId);
            stringBuilder0.append(",");
        }
        String s1 = l1.q(stringBuilder0, 1, 0);
        StringBuilder stringBuilder1 = new StringBuilder();
        for(Object object1: list0) {
            stringBuilder1.append(((SONGLIST)object1).prodSclasCode);
            stringBuilder1.append(",");
        }
        String s2 = l1.q(stringBuilder1, 1, 0);
        StringBuilder stringBuilder2 = new StringBuilder();
        for(Object object2: list0) {
            stringBuilder2.append(((SONGLIST)object2).prodId);
            stringBuilder2.append(",");
        }
        String s3 = l1.q(stringBuilder2, 1, 0);
        StringBuilder stringBuilder3 = new StringBuilder();
        for(Object object3: list0) {
            stringBuilder3.append(((SONGLIST)object3).prodAmts);
            stringBuilder3.append(",");
        }
        String s4 = l1.q(stringBuilder3, 1, 0);
        return Presentable.newBuilder(1, s).sendContsCnt(list0.size()).contsIds(s1).prodSclasCodes(s2).prodIds(s3).prodAmts(s4).repContName(((SONGLIST)list0.get(0)).songName);
    }

    public void openPaymentPage() {
        String s = this.q;
        String s1 = this.h;
        String s2 = this.g;
        NameValuePairList nameValuePairList0 = new NameValuePairList();
        try {
            nameValuePairList0.add("sendMemberKey", this.a);
            nameValuePairList0.add("sendMsgTitle", this.b);
            nameValuePairList0.add("sendMsgCont", this.c);
            nameValuePairList0.add("pocId", this.d);
            nameValuePairList0.add("giftProdGubun", this.e);
            nameValuePairList0.add("sendContsCnt", this.f);
            if(!TextUtils.isEmpty(s2)) {
                nameValuePairList0.add("contsIds", s2);
            }
            if(!TextUtils.isEmpty(s1)) {
                nameValuePairList0.add("prodSclasCodes", s1);
            }
            nameValuePairList0.add("prodIds", this.i);
            nameValuePairList0.add("prodamts", this.j);
            nameValuePairList0.add("reptCnt", this.k);
            nameValuePairList0.add("recvUsers", this.l);
            nameValuePairList0.add("sendIp", this.m);
            nameValuePairList0.add("sendDeviceId", this.n);
            nameValuePairList0.add("menuId", this.o);
            nameValuePairList0.add("repContName", this.p);
            if(!TextUtils.isEmpty(s)) {
                nameValuePairList0.add("eventEnterAuthKey", s);
            }
        }
        catch(UnsupportedEncodingException unused_ex) {
        }
        new Handler(Looper.getMainLooper()).post(new c(nameValuePairList0, 21));
    }
}

