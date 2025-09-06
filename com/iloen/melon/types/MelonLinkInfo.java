package com.iloen.melon.types;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.o;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.LinkInfoBase;
import java.io.Serializable;
import v9.n;

public class MelonLinkInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String[] i;
    public String j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public boolean r;
    private static final long serialVersionUID = 1L;

    static {
        MelonLinkInfo.CREATOR = new n(0);
    }

    public static MelonLinkInfo a(BannerBase bannerBase0, String s) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        if(bannerBase0 != null) {
            melonLinkInfo0.m = s;
            melonLinkInfo0.a = bannerBase0.linktype;
            melonLinkInfo0.b = bannerBase0.linkurl;
            melonLinkInfo0.c = bannerBase0.scheme;
            melonLinkInfo0.d = bannerBase0.imgurl;
            melonLinkInfo0.e = bannerBase0.text;
            melonLinkInfo0.f = bannerBase0.title;
            melonLinkInfo0.j = bannerBase0.banerseq;
            melonLinkInfo0.k = bannerBase0.isfullimg;
            melonLinkInfo0.n = bannerBase0.contsid;
            melonLinkInfo0.o = bannerBase0.contstypecode;
            String s1 = bannerBase0.bgcolor;
            if(!TextUtils.isEmpty(s1) && s1.length() == 6) {
                melonLinkInfo0.l = ColorUtils.getColorFromHexStr(("#" + s1));
                return melonLinkInfo0;
            }
            LogU.e("MelonLinkInfo", "valueOf() invalid color length: " + s1);
        }
        return melonLinkInfo0;
    }

    public static MelonLinkInfo b(LinkInfoBase linkInfoBase0) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        if(linkInfoBase0 != null) {
            melonLinkInfo0.a = linkInfoBase0.linktype;
            melonLinkInfo0.b = linkInfoBase0.linkurl;
            melonLinkInfo0.c = linkInfoBase0.scheme;
        }
        return melonLinkInfo0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("{linkType:");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", linkUrl:");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", scheme:");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", imgUrl:");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", text:");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", titleName:");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", targetView:");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", contentId:");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", contentIds:");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", banerSeq:");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", isfullimg:");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", bgColor:");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", menuId:");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", contsId:");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", contsTypeCode:");
        stringBuilder0.append(this.o);
        stringBuilder0.append(", fromInfoPush:");
        return o.s(stringBuilder0, this.r, "}");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeStringArray(this.i);
        parcel0.writeString(this.j);
        parcel0.writeString(this.k);
        parcel0.writeInt(this.l);
        parcel0.writeString(this.m);
        parcel0.writeString(this.n);
        parcel0.writeString(this.o);
        parcel0.writeBoolean(this.r);
    }
}

