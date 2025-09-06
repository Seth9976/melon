package com.iloen.melon.sns.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.sns.target.SnsTarget;

public class SharablePhotoTheme extends SharablePhoto {
    public static final Parcelable.Creator CREATOR = null;
    public String g;
    private static final long serialVersionUID = 0x4363155C4FD8250EL;

    static {
        SharablePhotoTheme.CREATOR = new e(1);
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getOutPostingLogParam(SnsTarget snsTarget0) {
        return this.getBaseOutPostingLogParam(snsTarget0) + "&sId=" + this.g + "&subContentId=" + this.a;
    }

    @Override  // com.iloen.melon.sns.model.SharablePhoto
    public final String getPageTypeCode() {
        return "atmpt";
    }

    @Override  // com.iloen.melon.sns.model.SharablePhoto
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=atmpt&sId=");
        stringBuilder0.append(this.g);
        stringBuilder0.append("&subContentId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append("&ref=");
        stringBuilder0.append(snsTarget0.getId());
        return z ? this.getShortenUrl(stringBuilder0.toString()) : stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.SharablePhoto
    public final void writeToParcel(Parcel parcel0, int v) {
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.g);
    }
}

