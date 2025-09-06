package com.iloen.melon.fragments.mymusic.playlist;

import Pc.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent;", "LPc/e;", "<init>", "()V", "ToggleSelectAll", "StartFetch", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent$StartFetch;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent$ToggleSelectAll;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ImageToPlaylistUserEvent implements e {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent$StartFetch;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent;", "list", "", "Landroid/net/Uri;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class StartFetch extends ImageToPlaylistUserEvent {
        public static final int $stable = 8;
        @NotNull
        private final List list;

        public StartFetch(@NotNull List list0) {
            q.g(list0, "list");
            super(null);
            this.list = list0;
        }

        @NotNull
        public final List component1() {
            return this.list;
        }

        @NotNull
        public final StartFetch copy(@NotNull List list0) {
            q.g(list0, "list");
            return new StartFetch(list0);
        }

        public static StartFetch copy$default(StartFetch imageToPlaylistUserEvent$StartFetch0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = imageToPlaylistUserEvent$StartFetch0.list;
            }
            return imageToPlaylistUserEvent$StartFetch0.copy(list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof StartFetch ? q.b(this.list, ((StartFetch)object0).list) : false;
        }

        @NotNull
        public final List getList() {
            return this.list;
        }

        @Override
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "StartFetch(list=" + this.list + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent$ToggleSelectAll;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUserEvent;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToggleSelectAll extends ImageToPlaylistUserEvent {
        public static final int $stable;
        @NotNull
        public static final ToggleSelectAll INSTANCE;

        static {
            ToggleSelectAll.INSTANCE = new ToggleSelectAll();
        }

        private ToggleSelectAll() {
            super(null);
        }
    }

    public static final int $stable;

    private ImageToPlaylistUserEvent() {
    }

    public ImageToPlaylistUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

