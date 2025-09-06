package com.iloen.melon.sns.model;

import R3.e;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableMyMusic extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    private static final long serialVersionUID = 0x46BF19B86422C36DL;

    static {
        SharableMyMusic.CREATOR = new e(28);
    }

    public final String a() {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getMessage() context is NULL!");
            return "";
        }
        return String.format("%1$s님의 프로필 ", this.getTextLimitForLength(this.a, 27));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.b;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.UNKNOWN;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditArtistImageUrl() : s;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        return "facebook".equals(snsTarget0.getId()) ? "" : this.makeMessage(snsTarget0, this.a());
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        if("twitter".equals(snsTarget0.getId())) {
            Context context0 = MelonAppBase.instance.getContext();
            return context0 == null ? null : new String[]{context0.getString(0x7F1310D5, new Object[]{this.a})};  // string:twitter_shared_nickname "%s님의 프로필"
        }
        return null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return this.a();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "myprofile";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.d;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.a();
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

