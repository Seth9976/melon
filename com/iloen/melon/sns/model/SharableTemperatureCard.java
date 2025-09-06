package com.iloen.melon.sns.model;

import A7.d;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import java.util.Arrays;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableTemperatureCard;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableTemperatureCard extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;

    static {
        SharableTemperatureCard.CREATOR = new e(8);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.f(ContsTypeCode.ARTIST, "ARTIST");
        return ContsTypeCode.ARTIST;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDefaultShareLinkPageUrl(SnsTarget snsTarget0) {
        q.g(snsTarget0, "target");
        String s = snsTarget0.getId();
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/m6/artist/temperature/share.htm?artistId=");
        d.u(stringBuilder0, this.a, "&shareType=TEMPERATURE_CARD&ref=", s, "&kageAccessKey=");
        stringBuilder0.append(this.e);
        if(TextUtils.equals("facebook", s)) {
            stringBuilder0.append("&timestamp=");
            stringBuilder0.append(System.currentTimeMillis());
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        if(s == null) {
            s = this.getDefaultPostRadioImageUrl();
            q.f(s, "getDefaultPostRadioImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        Context context0 = Y.a(MelonAppBase.Companion);
        if(context0 != null) {
            String s = this.getTextLimitForLength(this.d, 57);
            return this.makeMessage(snsTarget0, String.format(l1.m(s, "getTextLimitForLength(...)", context0, 0x7F130A5E, "getString(...)"), Arrays.copyOf(new Object[]{s}, 1)));  // string:sns_share_type_temperature_card "%1$s님과 나의 친밀도는?"
        }
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return this.d == null || this.d.length() == 0 ? null : new String[]{(this.d == null ? "" : this.d)};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "tcard";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        if(s == null) {
            s = this.getDefaultPostRadioImageUrl();
            q.f(s, "getDefaultPostRadioImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.d == null ? "" : this.d;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowInstagram() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowUrlCopy() {
        return false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
    }
}

