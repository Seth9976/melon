package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;

public class SharableArtistFriendship extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    private static final long serialVersionUID = 0x47C785409CD67900L;

    static {
        SharableArtistFriendship.CREATOR = new e(11);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.ARTIST;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.k;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        String s = this.e;
        String s1 = this.getTextLimitForLength(this.b, 27);
        String s2 = StringUtils.getCountFormattedString(this.f);
        String s3 = StringUtils.getCountFormattedString(this.g);
        String s4 = this.h;
        if("Y".equalsIgnoreCase(this.d)) {
            return this.makeMessage(snsTarget0, String.format("어제까지 %1$s명이 멜론에서 %2$s님의 음악을 보고 들었습니다. ", s2, s1));
        }
        return "0".equals(s4) || "0".equals(s3) ? this.makeMessage(snsTarget0, String.format("%1$s, %2$s님을 %3$s명이 좋아합니다. ", s, s1, s2)) : this.makeMessage(snsTarget0, String.format("%1$s, %2$s님은 %3$s님을 좋아하는 %4$s명 중 %5$s번째 팬입니다. ", s, "", s1, s2, s3));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return this.getDisplayMessage(snsTarget0);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "afr";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.j;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.getTextLimitForLength(this.b, 0x7F);
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isDisplayTitleWeb() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i);
        parcel0.writeString(this.j);
        parcel0.writeString(this.k);
    }
}

