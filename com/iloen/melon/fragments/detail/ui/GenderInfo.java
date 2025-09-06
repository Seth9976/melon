package com.iloen.melon.fragments.detail.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/GenderInfo;", "", "primary", "Lcom/iloen/melon/fragments/detail/ui/Gender;", "secondary", "<init>", "(Lcom/iloen/melon/fragments/detail/ui/Gender;Lcom/iloen/melon/fragments/detail/ui/Gender;)V", "getPrimary", "()Lcom/iloen/melon/fragments/detail/ui/Gender;", "getSecondary", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenderInfo {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/GenderInfo$Companion;", "", "<init>", "()V", "empty", "Lcom/iloen/melon/fragments/detail/ui/GenderInfo;", "getEmpty", "()Lcom/iloen/melon/fragments/detail/ui/GenderInfo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenderInfo getEmpty() {
            return GenderInfo.empty;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final GenderInfo empty;
    @NotNull
    private final Gender primary;
    @NotNull
    private final Gender secondary;

    static {
        GenderInfo.Companion = new Companion(null);
        GenderInfo.empty = new GenderInfo(new Gender("", ""), new Gender("", ""));
    }

    public GenderInfo(@NotNull Gender gender0, @NotNull Gender gender1) {
        q.g(gender0, "primary");
        q.g(gender1, "secondary");
        super();
        this.primary = gender0;
        this.secondary = gender1;
    }

    @NotNull
    public final Gender component1() {
        return this.primary;
    }

    @NotNull
    public final Gender component2() {
        return this.secondary;
    }

    @NotNull
    public final GenderInfo copy(@NotNull Gender gender0, @NotNull Gender gender1) {
        q.g(gender0, "primary");
        q.g(gender1, "secondary");
        return new GenderInfo(gender0, gender1);
    }

    public static GenderInfo copy$default(GenderInfo genderInfo0, Gender gender0, Gender gender1, int v, Object object0) {
        if((v & 1) != 0) {
            gender0 = genderInfo0.primary;
        }
        if((v & 2) != 0) {
            gender1 = genderInfo0.secondary;
        }
        return genderInfo0.copy(gender0, gender1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof GenderInfo)) {
            return false;
        }
        return q.b(this.primary, ((GenderInfo)object0).primary) ? q.b(this.secondary, ((GenderInfo)object0).secondary) : false;
    }

    @NotNull
    public final Gender getPrimary() {
        return this.primary;
    }

    @NotNull
    public final Gender getSecondary() {
        return this.secondary;
    }

    @Override
    public int hashCode() {
        return this.secondary.hashCode() + this.primary.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "GenderInfo(primary=" + this.primary + ", secondary=" + this.secondary + ")";
    }
}

