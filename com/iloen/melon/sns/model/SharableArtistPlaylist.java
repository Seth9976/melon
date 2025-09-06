package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableArtistPlaylist extends SharablePlaylist {
    public static final Parcelable.Creator CREATOR = null;
    public String k;
    public String l;
    private static final long serialVersionUID = 0xC3DEF1B843ECE51BL;

    static {
        SharableArtistPlaylist.CREATOR = new e(13);
    }

    public SharableArtistPlaylist(b b0) {
        super(b0);
        this.k = b0.j;
        this.l = b0.k;
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.ARTIST_PLAYLIST;
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        String s = String.format("%1$s by %2$s ", this.f, this.l);
        StringBuilder stringBuilder0 = new StringBuilder();
        if(snsTarget0 != null && ("twitter".equals(snsTarget0.getId()) || "kakao".equals(snsTarget0.getId()))) {
            stringBuilder0.append("아티스트 플레이리스트");
            stringBuilder0.append(" - ");
        }
        stringBuilder0.append(s);
        return this.makeMessage(snsTarget0, stringBuilder0.toString());
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return new String[]{this.f, "by " + this.l};
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return this.getShareTitle(snsTarget0);
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final String getPageTypeCode() {
        return "apl";
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        String s = this.getDefaultShareLinkPageUrl(snsTarget0);
        return z ? this.getShortenUrl(s) : s;
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final String getShareTitle(SnsTarget snsTarget0) {
        String s = this.l;
        return TextUtils.isEmpty(s) ? this.getTextLimitForLength(this.f, 0x7F) : this.getTextLimitForLength(this.f, 87) + " by " + this.getTextLimitForLength(s, 27);
    }

    @Override  // com.iloen.melon.sns.model.SharablePlaylist
    public final void writeToParcel(Parcel parcel0, int v) {
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.k);
        parcel0.writeString(this.l);
    }
}

