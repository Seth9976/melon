package com.iloen.melon.fragments.mymusic.dna;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001D\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0001HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaLogItemModel;", "", "viewType", "", "data", "<init>", "(ILjava/lang/Object;)V", "getViewType", "()I", "getData", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DnaLogItemModel {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaLogItemModel$Companion;", "", "<init>", "()V", "TYPE_UNKNOWN", "", "TYPE_MONTHLY_LOG", "TYPE_MOST_LISTENED_ARTIST", "TYPE_REPRESENT_TAG", "TYPE_MOST_LISTENED_GENRE", "TYPE_LAST_LOG", "TYPE_SHORTCUTS", "ViewType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        @Retention(RetentionPolicy.SOURCE)
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaLogItemModel$Companion$ViewType;", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public @interface ViewType {
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int TYPE_LAST_LOG = 5;
    public static final int TYPE_MONTHLY_LOG = 1;
    public static final int TYPE_MOST_LISTENED_ARTIST = 2;
    public static final int TYPE_MOST_LISTENED_GENRE = 4;
    public static final int TYPE_REPRESENT_TAG = 3;
    public static final int TYPE_SHORTCUTS = 6;
    public static final int TYPE_UNKNOWN;
    @Nullable
    private final Object data;
    private final int viewType;

    static {
        DnaLogItemModel.Companion = new Companion(null);
        DnaLogItemModel.$stable = 8;
    }

    public DnaLogItemModel() {
        this(0, null, 3, null);
    }

    public DnaLogItemModel(int v, @Nullable Object object0) {
        this.viewType = v;
        this.data = object0;
    }

    public DnaLogItemModel(int v, Object object0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        if((v1 & 2) != 0) {
            object0 = null;
        }
        this(v, object0);
    }

    public final int component1() {
        return this.viewType;
    }

    @Nullable
    public final Object component2() {
        return this.data;
    }

    @NotNull
    public final DnaLogItemModel copy(int v, @Nullable Object object0) {
        return new DnaLogItemModel(v, object0);
    }

    public static DnaLogItemModel copy$default(DnaLogItemModel dnaLogItemModel0, int v, Object object0, int v1, Object object1) {
        if((v1 & 1) != 0) {
            v = dnaLogItemModel0.viewType;
        }
        if((v1 & 2) != 0) {
            object0 = dnaLogItemModel0.data;
        }
        return dnaLogItemModel0.copy(v, object0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DnaLogItemModel)) {
            return false;
        }
        return this.viewType == ((DnaLogItemModel)object0).viewType ? q.b(this.data, ((DnaLogItemModel)object0).data) : false;
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    public final int getViewType() {
        return this.viewType;
    }

    @Override
    public int hashCode() {
        return this.data == null ? this.viewType * 0x1F : this.viewType * 0x1F + this.data.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "DnaLogItemModel(viewType=" + this.viewType + ", data=" + this.data + ")";
    }
}

