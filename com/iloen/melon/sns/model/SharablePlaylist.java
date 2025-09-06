package com.iloen.melon.sns.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharablePlaylist extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public final String a;
    public final String b;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    private static final long serialVersionUID = 0x59138F152A4E801L;

    static {
        SharablePlaylist.CREATOR = new e(2);
    }

    public SharablePlaylist(Parcel parcel0) {
        this.j = "Y";
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        this.d = parcel0.readString();
        this.e = parcel0.readString();
        this.f = parcel0.readString();
        this.g = parcel0.readString();
        this.h = parcel0.readString();
        this.i = parcel0.readString();
        this.j = parcel0.readString();
    }

    public SharablePlaylist(c c0) {
        String s = "Y";
        this.j = "Y";
        this.a = c0.a;
        this.b = c0.b;
        this.d = c0.c;
        this.e = c0.d;
        this.f = c0.e;
        this.g = c0.f;
        this.h = c0.g;
        this.i = c0.h;
        if(!TextUtils.isEmpty(c0.i)) {
            s = c0.i;
        }
        this.j = s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.PLAYLIST;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        return TextUtils.isEmpty(this.d) ? this.getDefaultPostEditImageUrl() : this.d;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        return this.makeMessage(snsTarget0, String.format("%1$s by %2$s ", this.f, this.g));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return new String[]{this.f, "by " + this.g};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getPageTypeCode() [...] // 潜在的解密器

    @Override  // com.iloen.melon.sns.model.SharableBase
    public String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=");
        stringBuilder0.append("ply");
        stringBuilder0.append("&uId=");
        stringBuilder0.append(this.e);
        stringBuilder0.append("&sId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append("&ref=");
        stringBuilder0.append(snsTarget0.getId());
        return z ? this.getShortenUrl(stringBuilder0.toString()) : stringBuilder0.toString();
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        return TextUtils.isEmpty(this.b) ? this.getDefaultPostImageUrl() : this.b;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public String getShareTitle(SnsTarget snsTarget0) {
        return TextUtils.isEmpty(this.g) ? this.getTextLimitForLength(this.f, 0x7F) : this.getTextLimitForLength(this.f, 87) + " by " + this.getTextLimitForLength(this.g, 27);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i);
        parcel0.writeString(this.j);
    }
}

