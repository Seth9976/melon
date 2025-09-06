package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableMelgun extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    private static final long serialVersionUID = 0x46BF19B86422C36DL;

    static {
        SharableMelgun.CREATOR = new e(21);
    }

    public static String a() {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getMessage() context is NULL!");
            return "";
        }
        return "멜군의 컬렉션";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return "-1";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.UNKNOWN;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditArtistImageUrl() : s;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        return "facebook".equals(snsTarget0.getId()) ? "" : this.makeMessage(snsTarget0, SharableMelgun.a());
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return SharableMelgun.a();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "djmgn";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.a;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return SharableMelgun.a();
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
    }
}

