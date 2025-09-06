package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.sns.target.SnsTarget;

public class SharableMvTheme extends SharableMv {
    public static final Parcelable.Creator CREATOR = null;
    public String j;
    private static final long serialVersionUID = 0x20F290D122D8E1D0L;

    static {
        SharableMvTheme.CREATOR = new e(27);
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getOutPostingLogParam(SnsTarget snsTarget0) {
        return this.getBaseOutPostingLogParam(snsTarget0) + "&sId=" + this.j + "&subContentId=" + this.a;
    }

    @Override  // com.iloen.melon.sns.model.SharableMv
    public final String getPageTypeCode() {
        return "atmtv";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=atmtv&sId=");
        stringBuilder0.append(this.j);
        stringBuilder0.append("&subContentId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append("&ref=");
        stringBuilder0.append(snsTarget0.getId());
        return z ? this.getShortenUrl(stringBuilder0.toString()) : stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.SharableMv
    public final void writeToParcel(Parcel parcel0, int v) {
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.j);
    }
}

