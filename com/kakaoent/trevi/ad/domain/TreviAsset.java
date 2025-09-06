package com.kakaoent.trevi.ad.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u000B\u0010\u0014\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0015\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000EJ\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000EJ\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000EJV\u0010\u001A\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001BJ\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020\u0007HÖ\u0001J\t\u0010 \u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0015\u0010\t\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER\u0015\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0010\u0010\u000ER\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\fR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\fR\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0013\u0010\u000E¨\u0006!"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviAsset;", "", "assetType", "", "type", "value", "width", "", "height", "exposureOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAssetType", "()Ljava/lang/String;", "getExposureOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getType", "getValue", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakaoent/trevi/ad/domain/TreviAsset;", "equals", "", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAsset {
    @Nullable
    private final String assetType;
    @Nullable
    private final Integer exposureOrder;
    @Nullable
    private final Integer height;
    @Nullable
    private final String type;
    @Nullable
    private final String value;
    @Nullable
    private final Integer width;

    public TreviAsset() {
        this(null, null, null, null, null, null, 0x3F, null);
    }

    public TreviAsset(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        this.assetType = s;
        this.type = s1;
        this.value = s2;
        this.width = integer0;
        this.height = integer1;
        this.exposureOrder = integer2;
    }

    public TreviAsset(String s, String s1, String s2, Integer integer0, Integer integer1, Integer integer2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            integer0 = null;
        }
        if((v & 16) != 0) {
            integer1 = null;
        }
        this(s, s1, s2, integer0, integer1, ((v & 0x20) == 0 ? integer2 : null));
    }

    @Nullable
    public final String component1() {
        return this.assetType;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.value;
    }

    @Nullable
    public final Integer component4() {
        return this.width;
    }

    @Nullable
    public final Integer component5() {
        return this.height;
    }

    @Nullable
    public final Integer component6() {
        return this.exposureOrder;
    }

    @NotNull
    public final TreviAsset copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        return new TreviAsset(s, s1, s2, integer0, integer1, integer2);
    }

    public static TreviAsset copy$default(TreviAsset treviAsset0, String s, String s1, String s2, Integer integer0, Integer integer1, Integer integer2, int v, Object object0) {
        if((v & 1) != 0) {
            s = treviAsset0.assetType;
        }
        if((v & 2) != 0) {
            s1 = treviAsset0.type;
        }
        if((v & 4) != 0) {
            s2 = treviAsset0.value;
        }
        if((v & 8) != 0) {
            integer0 = treviAsset0.width;
        }
        if((v & 16) != 0) {
            integer1 = treviAsset0.height;
        }
        if((v & 0x20) != 0) {
            integer2 = treviAsset0.exposureOrder;
        }
        return treviAsset0.copy(s, s1, s2, integer0, integer1, integer2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviAsset)) {
            return false;
        }
        if(!q.b(this.assetType, ((TreviAsset)object0).assetType)) {
            return false;
        }
        if(!q.b(this.type, ((TreviAsset)object0).type)) {
            return false;
        }
        if(!q.b(this.value, ((TreviAsset)object0).value)) {
            return false;
        }
        if(!q.b(this.width, ((TreviAsset)object0).width)) {
            return false;
        }
        return q.b(this.height, ((TreviAsset)object0).height) ? q.b(this.exposureOrder, ((TreviAsset)object0).exposureOrder) : false;
    }

    @Nullable
    public final String getAssetType() {
        return this.assetType;
    }

    @Nullable
    public final Integer getExposureOrder() {
        return this.exposureOrder;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.assetType == null ? 0 : this.assetType.hashCode();
        int v2 = this.type == null ? 0 : this.type.hashCode();
        int v3 = this.value == null ? 0 : this.value.hashCode();
        int v4 = this.width == null ? 0 : this.width.hashCode();
        int v5 = this.height == null ? 0 : this.height.hashCode();
        Integer integer0 = this.exposureOrder;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "TreviAsset(assetType=" + this.assetType + ", type=" + this.type + ", value=" + this.value + ", width=" + this.width + ", height=" + this.height + ", exposureOrder=" + this.exposureOrder + ')';
    }
}

