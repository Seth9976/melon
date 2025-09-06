package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import java.util.Arrays;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableMusicDna;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableMusicDna extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR;
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
    public String l;
    public String m;
    public String n;
    public String o;
    public String r;
    public boolean w;

    static {
        SharableMusicDna.CREATOR = new e(24);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        String s = this.a;
        if(s != null) {
            switch(s) {
                case "MONTHLY_LOG_ARTIST": {
                    return "3001";
                }
                case "MONTHLY_LOG_SONG": {
                    return "3002";
                }
                case "MY_DNA": {
                    switch((this.b == null ? "" : this.b)) {
                        case "DNA001": {
                            return "1001";
                        }
                        case "DNA002": {
                            return "1002";
                        }
                        case "DNA003": {
                            return "1003";
                        }
                        case "DNA004": {
                            return "1004";
                        }
                        case "DNA005": {
                            return "1005";
                        }
                        case "DNA006": {
                            return "1006";
                        }
                        case "DNA007": {
                            return "1007";
                        }
                        case "DNA008": {
                            return "1008";
                        }
                        case "DNA009": {
                            return "1009";
                        }
                        case "DNA010": {
                            return "1010";
                        }
                        case "DNA011": {
                            return "1011";
                        }
                        case "DNA012": {
                            return "1012";
                        }
                        case "DNA013": {
                            return "1013";
                        }
                        case "DNA014": {
                            return "1014";
                        }
                        default: {
                            return "";
                        }
                    }
                }
                case "RECENT_LOG_ARTIST": {
                    return "2002";
                }
                case "RECENT_LOG_GENRE": {
                    return "2001";
                }
                case "RECENT_LOG_KEYWORD": {
                    return "2004";
                }
                case "RECENT_LOG_SONG": {
                    return "2003";
                }
                default: {
                    return "";
                }
            }
        }
        return "";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.d(ContsTypeCode.UNKNOWN);
        return ContsTypeCode.UNKNOWN;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.j;
        if(s == null) {
            s = this.getDefaultPostEditImageUrl();
            q.f(s, "getDefaultPostEditImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        String s5;
        String s10;
        String s = this.g;
        String s1 = this.f;
        String s2 = this.a;
        String s3 = this.d;
        String s4 = this.m;
        if(Y.a(MelonAppBase.Companion) != null) {
            if(!q.b(s2, "MY_DNA")) {
                if(q.b(s2, "RECENT_LOG_GENRE") || q.b(s2, "RECENT_LOG_ARTIST") || q.b(s2, "RECENT_LOG_SONG") || q.b(s2, "RECENT_LOG_KEYWORD")) {
                    if(q.b(s2, "RECENT_LOG_GENRE")) {
                        s10 = String.valueOf(this.e);
                    }
                    else if(q.b(s2, "RECENT_LOG_ARTIST")) {
                        s10 = String.valueOf(s1);
                    }
                    else {
                        s10 = q.b(s2, "RECENT_LOG_SONG") ? String.valueOf(s) : "#" + this.i;
                    }
                    if(q.b((snsTarget0 == null ? null : snsTarget0.getId()), "kakao")) {
                        q.f("나는 요즘 %s에 꽂혀 있어요!\n당신의 최근 로그도 확인해 보세요.", "getString(...)");
                        s5 = String.format("나는 요즘 %s에 꽂혀 있어요!\n당신의 최근 로그도 확인해 보세요.", Arrays.copyOf(new Object[]{s10}, 1));
                    }
                    else {
                        q.f("[뮤직 DNA] 나는 요즘 %s에 꽂혀 있어요!\n\n    ", "getString(...)");
                        s5 = String.format("[뮤직 DNA] 나는 요즘 %s에 꽂혀 있어요!\n\n    ", Arrays.copyOf(new Object[]{s10}, 1));
                    }
                }
                else if(q.b(s2, "MONTHLY_LOG_ARTIST")) {
                    String s6 = String.valueOf(s1);
                    if(q.b((snsTarget0 == null ? null : snsTarget0.getId()), "kakao")) {
                        q.f("%1$s 나의 최애는 %2$s!\n당신의 최애 아티스트도 확인해 보세요.", "getString(...)");
                        s5 = String.format("%1$s 나의 최애는 %2$s!\n당신의 최애 아티스트도 확인해 보세요.", Arrays.copyOf(new Object[]{s4, s6}, 2));
                    }
                    else {
                        q.f("[뮤직 DNA] %1$s 나의 최애는 %2$s!\n\n    ", "getString(...)");
                        s5 = String.format("[뮤직 DNA] %1$s 나의 최애는 %2$s!\n\n    ", Arrays.copyOf(new Object[]{s4, s6}, 2));
                    }
                }
                else if(q.b(s2, "MONTHLY_LOG_SONG")) {
                    String s7 = String.valueOf(s);
                    if(q.b((snsTarget0 == null ? null : snsTarget0.getId()), "kakao")) {
                        q.f("%1$s 나의 최애곡은 %2$s!\n당신의 최애 감상곡도 확인해 보세요.", "getString(...)");
                        s5 = String.format("%1$s 나의 최애곡은 %2$s!\n당신의 최애 감상곡도 확인해 보세요.", Arrays.copyOf(new Object[]{s4, s7}, 2));
                    }
                    else {
                        q.f("[뮤직 DNA] %1$s 나의 최애곡은 %2$s!\n\n    ", "getString(...)");
                        s5 = String.format("[뮤직 DNA] %1$s 나의 최애곡은 %2$s!\n\n    ", Arrays.copyOf(new Object[]{s4, s7}, 2));
                    }
                }
                else if(q.b(s2, "MONTHLY_LOG_GRAPH")) {
                    String s8 = String.valueOf(this.h);
                    if(q.b((snsTarget0 == null ? null : snsTarget0.getId()), "kakao")) {
                        q.f("%1$s 나의 감상곡수는 %2$s곡!\n당신의 감상곡수도 확인해 보세요.", "getString(...)");
                        s5 = String.format("%1$s 나의 감상곡수는 %2$s곡!\n당신의 감상곡수도 확인해 보세요.", Arrays.copyOf(new Object[]{s4, s8}, 2));
                    }
                    else {
                        q.f("[뮤직 DNA] %1$s 나의 감상곡수는 %2$s곡!\n\n    ", "getString(...)");
                        s5 = String.format("[뮤직 DNA] %1$s 나의 감상곡수는 %2$s곡!\n\n    ", Arrays.copyOf(new Object[]{s4, s8}, 2));
                    }
                }
                else if(q.b(s2, "MONTHLY_LOG_LIKE")) {
                    String s9 = snsTarget0 == null ? null : snsTarget0.getId();
                    if(q.b(s9, "kakao")) {
                        q.f("%1$s 좋아요한 개수가 궁금하다면,\n지금 바로 월간로그에서 확인해 보세요.", "getString(...)");
                        s5 = String.format("%1$s 좋아요한 개수가 궁금하다면,\n지금 바로 월간로그에서 확인해 보세요.", Arrays.copyOf(new Object[]{s4}, 1));
                    }
                    else if(q.b(s9, "copyurl")) {
                        if(s3 == null) {
                            s3 = "";
                        }
                        s5 = s3 + "\n" + this.l;
                    }
                    else {
                        q.f("나의 월간 로그는? - 뮤직 DNA", "getString(...)");
                        s5 = "나의 월간 로그는? - 뮤직 DNA";
                    }
                }
                else if(q.b((snsTarget0 == null ? null : snsTarget0.getId()), "kakao")) {
                    q.f("내 음악 감상 타입은 %s!\n당신의 음악 감상 타입은?", "getString(...)");
                    s5 = String.format("내 음악 감상 타입은 %s!\n당신의 음악 감상 타입은?", Arrays.copyOf(new Object[]{s3}, 1));
                }
                else {
                    q.f("[뮤직 DNA] 내 음악 감상 타입은 %s!\n\n    ", "getString(...)");
                    s5 = String.format("[뮤직 DNA] 내 음악 감상 타입은 %s!\n\n    ", Arrays.copyOf(new Object[]{s3}, 1));
                }
            }
            else if(q.b((snsTarget0 == null ? null : snsTarget0.getId()), "kakao")) {
                q.f("내 음악 감상 타입은 %s!\n당신의 음악 감상 타입은?", "getString(...)");
                s5 = String.format("내 음악 감상 타입은 %s!\n당신의 음악 감상 타입은?", Arrays.copyOf(new Object[]{s3}, 1));
            }
            else {
                q.f("[뮤직 DNA] 내 음악 감상 타입은 %s!\n\n    ", "getString(...)");
                s5 = String.format("[뮤직 DNA] 내 음악 감상 타입은 %s!\n\n    ", Arrays.copyOf(new Object[]{s3}, 1));
            }
            String s11 = this.makeMessage(snsTarget0, s5);
            q.f(s11, "makeMessage(...)");
            return s11;
        }
        return "";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return Z.m(MelonAppBase.Companion, 0x7F130763, "getString(...)");  // string:musicdna_title "뮤직 DNA"
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "dnacard";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        return this.o == null ? "" : this.o;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        if("kakao".equals(snsTarget0.getId())) {
            String s = this.r == null ? this.getDefaultPostImageUrl() : this.r;
            q.d(s);
            return s;
        }
        String s1 = this.j == null ? this.getDefaultPostImageUrl() : this.j;
        q.d(s1);
        return s1;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return "";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowInstagram() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMore() {
        return false;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
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
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i);
        parcel0.writeString(this.j);
        parcel0.writeString(this.k);
        parcel0.writeString(this.l);
        parcel0.writeString(this.m);
        parcel0.writeString(this.n);
        parcel0.writeString(this.o);
        parcel0.writeString(this.r);
    }
}

