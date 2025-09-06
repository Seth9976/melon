package com.iloen.melon.fragments.detail.ui;

import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "", "genderInfo", "Lcom/iloen/melon/fragments/detail/ui/GenderInfo;", "listeningAges", "", "Lcom/iloen/melon/fragments/detail/ui/ListeningAge;", "<init>", "(Lcom/iloen/melon/fragments/detail/ui/GenderInfo;Ljava/util/List;)V", "getGenderInfo", "()Lcom/iloen/melon/fragments/detail/ui/GenderInfo;", "getListeningAges", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListeningUiState {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/ListeningUiState$Companion;", "", "<init>", "()V", "sample", "Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "getSample", "()Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "empty", "getEmpty", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ListeningUiState getEmpty() {
            return ListeningUiState.empty;
        }

        @NotNull
        public final ListeningUiState getSample() {
            return ListeningUiState.sample;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final ListeningUiState empty;
    @NotNull
    private final GenderInfo genderInfo;
    @NotNull
    private final List listeningAges;
    @NotNull
    private static final ListeningUiState sample;

    static {
        ListeningUiState.Companion = new Companion(null);
        ListeningUiState.$stable = 8;
        ListeningUiState.sample = new ListeningUiState(new GenderInfo(new Gender("여성", "66"), new Gender("남성", "34")), ListeningAge.Companion.getSampleList());
        ListeningUiState.empty = new ListeningUiState(GenderInfo.Companion.getEmpty(), w.a);
    }

    public ListeningUiState(@NotNull GenderInfo genderInfo0, @NotNull List list0) {
        q.g(genderInfo0, "genderInfo");
        q.g(list0, "listeningAges");
        super();
        this.genderInfo = genderInfo0;
        this.listeningAges = list0;
    }

    @NotNull
    public final GenderInfo component1() {
        return this.genderInfo;
    }

    @NotNull
    public final List component2() {
        return this.listeningAges;
    }

    @NotNull
    public final ListeningUiState copy(@NotNull GenderInfo genderInfo0, @NotNull List list0) {
        q.g(genderInfo0, "genderInfo");
        q.g(list0, "listeningAges");
        return new ListeningUiState(genderInfo0, list0);
    }

    public static ListeningUiState copy$default(ListeningUiState listeningUiState0, GenderInfo genderInfo0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            genderInfo0 = listeningUiState0.genderInfo;
        }
        if((v & 2) != 0) {
            list0 = listeningUiState0.listeningAges;
        }
        return listeningUiState0.copy(genderInfo0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ListeningUiState)) {
            return false;
        }
        return q.b(this.genderInfo, ((ListeningUiState)object0).genderInfo) ? q.b(this.listeningAges, ((ListeningUiState)object0).listeningAges) : false;
    }

    @NotNull
    public final GenderInfo getGenderInfo() {
        return this.genderInfo;
    }

    @NotNull
    public final List getListeningAges() {
        return this.listeningAges;
    }

    @Override
    public int hashCode() {
        return this.listeningAges.hashCode() + this.genderInfo.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "ListeningUiState(genderInfo=" + this.genderInfo + ", listeningAges=" + this.listeningAges + ")";
    }
}

