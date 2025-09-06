package com.kakaoent.trevi.ad.domain;

import A7.d;
import H0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0002\u0010\tJ\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0007HÆ\u0003J3\u0010\u0015\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00072\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001A"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TreviAdReward;", "", "rewardUnit", "", "rewardAmount", "", "rewardJoin", "", "duplicateParticipation", "(Ljava/lang/String;IZZ)V", "getDuplicateParticipation", "()Z", "getRewardAmount", "()I", "getRewardJoin", "getRewardUnit", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviAdReward {
    private final boolean duplicateParticipation;
    private final int rewardAmount;
    private final boolean rewardJoin;
    @Nullable
    private final String rewardUnit;

    public TreviAdReward() {
        this(null, 0, false, false, 15, null);
    }

    public TreviAdReward(@Nullable String s, int v, boolean z, boolean z1) {
        this.rewardUnit = s;
        this.rewardAmount = v;
        this.rewardJoin = z;
        this.duplicateParticipation = z1;
    }

    public TreviAdReward(String s, int v, boolean z, boolean z1, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s = null;
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        if((v1 & 8) != 0) {
            z1 = false;
        }
        this(s, v, z, z1);
    }

    @Nullable
    public final String component1() {
        return this.rewardUnit;
    }

    public final int component2() {
        return this.rewardAmount;
    }

    public final boolean component3() {
        return this.rewardJoin;
    }

    public final boolean component4() {
        return this.duplicateParticipation;
    }

    @NotNull
    public final TreviAdReward copy(@Nullable String s, int v, boolean z, boolean z1) {
        return new TreviAdReward(s, v, z, z1);
    }

    public static TreviAdReward copy$default(TreviAdReward treviAdReward0, String s, int v, boolean z, boolean z1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = treviAdReward0.rewardUnit;
        }
        if((v1 & 2) != 0) {
            v = treviAdReward0.rewardAmount;
        }
        if((v1 & 4) != 0) {
            z = treviAdReward0.rewardJoin;
        }
        if((v1 & 8) != 0) {
            z1 = treviAdReward0.duplicateParticipation;
        }
        return treviAdReward0.copy(s, v, z, z1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TreviAdReward)) {
            return false;
        }
        if(!q.b(this.rewardUnit, ((TreviAdReward)object0).rewardUnit)) {
            return false;
        }
        if(this.rewardAmount != ((TreviAdReward)object0).rewardAmount) {
            return false;
        }
        return this.rewardJoin == ((TreviAdReward)object0).rewardJoin ? this.duplicateParticipation == ((TreviAdReward)object0).duplicateParticipation : false;
    }

    public final boolean getDuplicateParticipation() {
        return this.duplicateParticipation;
    }

    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    public final boolean getRewardJoin() {
        return this.rewardJoin;
    }

    @Nullable
    public final String getRewardUnit() {
        return this.rewardUnit;
    }

    @Override
    public int hashCode() {
        return this.rewardUnit == null ? Boolean.hashCode(this.duplicateParticipation) + d.e(d.b(this.rewardAmount, 0, 0x1F), 0x1F, this.rewardJoin) : Boolean.hashCode(this.duplicateParticipation) + d.e(d.b(this.rewardAmount, this.rewardUnit.hashCode() * 0x1F, 0x1F), 0x1F, this.rewardJoin);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TreviAdReward(rewardUnit=");
        stringBuilder0.append(this.rewardUnit);
        stringBuilder0.append(", rewardAmount=");
        stringBuilder0.append(this.rewardAmount);
        stringBuilder0.append(", rewardJoin=");
        stringBuilder0.append(this.rewardJoin);
        stringBuilder0.append(", duplicateParticipation=");
        return b.k(stringBuilder0, this.duplicateParticipation, ')');
    }
}

