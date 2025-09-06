package com.iloen.melon.sns.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharablePhoto extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    private static final long serialVersionUID = 0x3A387396BF4AB1BDL;

    static {
        SharablePhoto.CREATOR = new e(0);
    }

    public SharablePhoto(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        this.d = parcel0.readString();
        this.e = parcel0.readString();
        this.f = parcel0.readString();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.PHOTO;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        return this.d;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        return this.makeMessage(snsTarget0, String.format("%1$s의 포토를 좋아합니다. ", this.getTextLimitForLength(this.f, 27)));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getPageTypeCode() [...] // 潜在的解密器

    @Override  // com.iloen.melon.sns.model.SharableBase
    public String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=");
        stringBuilder0.append("pht");
        stringBuilder0.append("&sId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append("&ref=");
        stringBuilder0.append(snsTarget0.getId());
        stringBuilder0.append("&artId=");
        stringBuilder0.append(this.e);
        return z ? this.getShortenUrl(stringBuilder0.toString()) : stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        return TextUtils.isEmpty(s) ? this.d : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.getTextLimitForLength(this.f, 27);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
    }
}

