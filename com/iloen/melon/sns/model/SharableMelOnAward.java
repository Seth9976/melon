package com.iloen.melon.sns.model;

import A8.M;
import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableMelOnAward extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    private static final long serialVersionUID = 0x232F624B6CD35961L;

    static {
        SharableMelOnAward.CREATOR = new e(20);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.UNKNOWN;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        return M.a0;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        return this.makeMessage(snsTarget0, "멜론 주간 어워드 투표진행중! 빨리 투표에 참여하세요.");
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "ntz";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        if(snsTarget0 != null && "facebook".equals(snsTarget0.getId())) {
            return "http://www.melon.com/restful/cds/facebook/web/facebook_posting/ntz/0.htm";
        }
        new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=ntz");
        return z ? this.getShortenUrl("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=ntz") : "https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=ntz";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        return M.a0;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return "멜론 주간 어워드";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowKakaoTalk() {
        return false;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
    }
}

