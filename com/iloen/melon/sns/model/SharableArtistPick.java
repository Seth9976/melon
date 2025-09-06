package com.iloen.melon.sns.model;

import R3.e;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableArtistPick extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    private static final long serialVersionUID = 0x38F0267DF4C8AF55L;

    static {
        SharableArtistPick.CREATOR = new e(12);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.d;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.ARTIST_PICK;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDefaultShareLinkPageUrl(SnsTarget snsTarget0) {
        StringBuilder stringBuilder0 = x.p(super.getDefaultShareLinkPageUrl(snsTarget0), "&artId=");
        stringBuilder0.append(this.a);
        return stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.f;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e(SharableBase.TAG, "getDisplayMessage() context is NULL!");
            return null;
        }
        return this.makeMessage(snsTarget0, this.g);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return new String[]{this.g, this.b};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "apick";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.getTextLimitForLength(this.b, 27);
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
    }
}

