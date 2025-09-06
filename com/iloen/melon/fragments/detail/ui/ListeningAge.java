package com.iloen.melon.fragments.detail.ui;

import e.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/ListeningAge;", "", "title", "", "percentage", "", "<init>", "(Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getPercentage", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListeningAge {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/ListeningAge$Companion;", "", "<init>", "()V", "sampleList", "", "Lcom/iloen/melon/fragments/detail/ui/ListeningAge;", "getSampleList", "()Ljava/util/List;", "sampleList2", "getSampleList2", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final List getSampleList() {
            return ListeningAge.sampleList;
        }

        @NotNull
        public final List getSampleList2() {
            return ListeningAge.sampleList2;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final int percentage;
    @NotNull
    private static final List sampleList;
    @NotNull
    private static final List sampleList2;
    @NotNull
    private final String title;

    static {
        ListeningAge.Companion = new Companion(null);
        ListeningAge.sampleList = k.A(new ListeningAge[]{new ListeningAge("10대", 10), new ListeningAge("20대", 0x30), new ListeningAge("30대", 19), new ListeningAge("40대", 12), new ListeningAge("50대", 8), new ListeningAge("60대", 4)});
        ListeningAge.sampleList2 = k.A(new ListeningAge[]{new ListeningAge("10대", 0), new ListeningAge("20대", 0), new ListeningAge("30대", 100), new ListeningAge("40대", 0), new ListeningAge("50대", 0), new ListeningAge("60대", 0)});
    }

    public ListeningAge(@NotNull String s, int v) {
        q.g(s, "title");
        super();
        this.title = s;
        this.percentage = v;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.percentage;
    }

    @NotNull
    public final ListeningAge copy(@NotNull String s, int v) {
        q.g(s, "title");
        return new ListeningAge(s, v);
    }

    public static ListeningAge copy$default(ListeningAge listeningAge0, String s, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = listeningAge0.title;
        }
        if((v1 & 2) != 0) {
            v = listeningAge0.percentage;
        }
        return listeningAge0.copy(s, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ListeningAge)) {
            return false;
        }
        return q.b(this.title, ((ListeningAge)object0).title) ? this.percentage == ((ListeningAge)object0).percentage : false;
    }

    public final int getPercentage() {
        return this.percentage;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        return this.percentage + this.title.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "ListeningAge(title=" + this.title + ", percentage=" + this.percentage + ")";
    }
}

