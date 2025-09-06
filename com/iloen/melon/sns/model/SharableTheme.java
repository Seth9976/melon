package com.iloen.melon.sns.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;

public class SharableTheme extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    private static final long serialVersionUID = 0xDE7EBDA134B7DFEBL;

    static {
        SharableTheme.CREATOR = new e(9);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.THEME;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.d;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        return this.makeMessage(snsTarget0, this.getShareTitle(snsTarget0));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "atm";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.getTextLimitForLength(this.e, 27);
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
    }
}

