package com.melon.data.database.entity;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001B\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000BJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÆ\u0003J;\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u0005HÆ\u0001J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\u0003HÖ\u0001J\t\u0010$\u001A\u00020\u0005HÖ\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001E\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001E\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001E\u0010\b\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006%"}, d2 = {"Lcom/melon/data/database/entity/BannerPopupEntity;", "", "uid", "", "memberKey", "", "id", "banOn", "popupType", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getUid", "()I", "setUid", "(I)V", "getMemberKey", "()Ljava/lang/String;", "setMemberKey", "(Ljava/lang/String;)V", "getId", "setId", "getBanOn", "setBanOn", "getPopupType", "setPopupType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BannerPopupEntity {
    public static final int $stable = 8;
    @NotNull
    private String banOn;
    @NotNull
    private String id;
    @NotNull
    private String memberKey;
    @NotNull
    private String popupType;
    private int uid;

    public BannerPopupEntity() {
        this(0, "", "", "", "");
    }

    public BannerPopupEntity(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "memberKey");
        q.g(s1, "id");
        q.g(s2, "banOn");
        q.g(s3, "popupType");
        super();
        this.uid = v;
        this.memberKey = s;
        this.id = s1;
        this.banOn = s2;
        this.popupType = s3;
    }

    public final int component1() {
        return this.uid;
    }

    @NotNull
    public final String component2() {
        return this.memberKey;
    }

    @NotNull
    public final String component3() {
        return this.id;
    }

    @NotNull
    public final String component4() {
        return this.banOn;
    }

    @NotNull
    public final String component5() {
        return this.popupType;
    }

    @NotNull
    public final BannerPopupEntity copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "memberKey");
        q.g(s1, "id");
        q.g(s2, "banOn");
        q.g(s3, "popupType");
        return new BannerPopupEntity(v, s, s1, s2, s3);
    }

    public static BannerPopupEntity copy$default(BannerPopupEntity bannerPopupEntity0, int v, String s, String s1, String s2, String s3, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = bannerPopupEntity0.uid;
        }
        if((v1 & 2) != 0) {
            s = bannerPopupEntity0.memberKey;
        }
        if((v1 & 4) != 0) {
            s1 = bannerPopupEntity0.id;
        }
        if((v1 & 8) != 0) {
            s2 = bannerPopupEntity0.banOn;
        }
        if((v1 & 16) != 0) {
            s3 = bannerPopupEntity0.popupType;
        }
        return bannerPopupEntity0.copy(v, s, s1, s2, s3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BannerPopupEntity)) {
            return false;
        }
        if(this.uid != ((BannerPopupEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.memberKey, ((BannerPopupEntity)object0).memberKey)) {
            return false;
        }
        if(!q.b(this.id, ((BannerPopupEntity)object0).id)) {
            return false;
        }
        return q.b(this.banOn, ((BannerPopupEntity)object0).banOn) ? q.b(this.popupType, ((BannerPopupEntity)object0).popupType) : false;
    }

    @NotNull
    public final String getBanOn() [...] // 潜在的解密器

    @NotNull
    public final String getId() [...] // 潜在的解密器

    @NotNull
    public final String getMemberKey() [...] // 潜在的解密器

    @NotNull
    public final String getPopupType() [...] // 潜在的解密器

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return this.popupType.hashCode() + x.b(x.b(x.b(this.uid * 0x1F, 0x1F, this.memberKey), 0x1F, this.id), 0x1F, this.banOn);
    }

    public final void setBanOn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.banOn = s;
    }

    public final void setId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.id = s;
    }

    public final void setMemberKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.memberKey = s;
    }

    public final void setPopupType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.popupType = s;
    }

    public final void setUid(int v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.id;
        String s1 = this.banOn;
        String s2 = this.popupType;
        StringBuilder stringBuilder0 = x.o(this.uid, "BannerPopupEntity(uid=", ", memberKey=", this.memberKey, ", id=");
        d.u(stringBuilder0, s, ", banOn=", s1, ", popupType=");
        return x.m(stringBuilder0, s2, ")");
    }
}

