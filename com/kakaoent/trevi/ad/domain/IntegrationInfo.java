package com.kakaoent.trevi.ad.domain;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001D\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000B\u0010\t\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\n\u001A\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000B\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/IntegrationInfo;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class IntegrationInfo {
    @Nullable
    private final String key;
    @Nullable
    private final String value;

    public IntegrationInfo() {
        this(null, null, 3, null);
    }

    public IntegrationInfo(@Nullable String s, @Nullable String s1) {
        this.key = s;
        this.value = s1;
    }

    public IntegrationInfo(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        this(s, s1);
    }

    @Nullable
    public final String component1() {
        return this.key;
    }

    @Nullable
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final IntegrationInfo copy(@Nullable String s, @Nullable String s1) {
        return new IntegrationInfo(s, s1);
    }

    public static IntegrationInfo copy$default(IntegrationInfo integrationInfo0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = integrationInfo0.key;
        }
        if((v & 2) != 0) {
            s1 = integrationInfo0.value;
        }
        return integrationInfo0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof IntegrationInfo)) {
            return false;
        }
        return q.b(this.key, ((IntegrationInfo)object0).key) ? q.b(this.value, ((IntegrationInfo)object0).value) : false;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.key == null ? 0 : this.key.hashCode();
        String s = this.value;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("IntegrationInfo(key=");
        stringBuilder0.append(this.key);
        stringBuilder0.append(", value=");
        return o.r(stringBuilder0, this.value, ')');
    }
}

