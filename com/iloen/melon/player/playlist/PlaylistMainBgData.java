package com.iloen.melon.player.playlist;

import android.net.Uri;
import com.melon.playlist.mixup.DjMalrangInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainBgData;", "", "Default", "DjMalrang", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData$Default;", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData$DjMalrang;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface PlaylistMainBgData {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001C\u0010\b\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainBgData$Default;", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData;", "Landroid/net/Uri;", "thumbnailUri", "<init>", "(Landroid/net/Uri;)V", "component1", "()Landroid/net/Uri;", "copy", "(Landroid/net/Uri;)Lcom/iloen/melon/player/playlist/PlaylistMainBgData$Default;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/net/Uri;", "getThumbnailUri", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Default implements PlaylistMainBgData {
        public static final int $stable = 8;
        public final Uri a;

        public Default(@Nullable Uri uri0) {
            this.a = uri0;
        }

        @Nullable
        public final Uri component1() {
            return this.a;
        }

        @NotNull
        public final Default copy(@Nullable Uri uri0) {
            return new Default(uri0);
        }

        public static Default copy$default(Default playlistMainBgData$Default0, Uri uri0, int v, Object object0) {
            if((v & 1) != 0) {
                uri0 = playlistMainBgData$Default0.a;
            }
            return playlistMainBgData$Default0.copy(uri0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Default ? q.b(this.a, ((Default)object0).a) : false;
        }

        @Nullable
        public final Uri getThumbnailUri() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Default(thumbnailUri=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainBgData$DjMalrang;", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData;", "Lcom/melon/playlist/mixup/DjMalrangInfo;", "djMalrangInfo", "<init>", "(Lcom/melon/playlist/mixup/DjMalrangInfo;)V", "component1", "()Lcom/melon/playlist/mixup/DjMalrangInfo;", "copy", "(Lcom/melon/playlist/mixup/DjMalrangInfo;)Lcom/iloen/melon/player/playlist/PlaylistMainBgData$DjMalrang;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/playlist/mixup/DjMalrangInfo;", "getDjMalrangInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DjMalrang implements PlaylistMainBgData {
        public static final int $stable;
        public final DjMalrangInfo a;

        public DjMalrang(@NotNull DjMalrangInfo djMalrangInfo0) {
            q.g(djMalrangInfo0, "djMalrangInfo");
            super();
            this.a = djMalrangInfo0;
        }

        @NotNull
        public final DjMalrangInfo component1() {
            return this.a;
        }

        @NotNull
        public final DjMalrang copy(@NotNull DjMalrangInfo djMalrangInfo0) {
            q.g(djMalrangInfo0, "djMalrangInfo");
            return new DjMalrang(djMalrangInfo0);
        }

        public static DjMalrang copy$default(DjMalrang playlistMainBgData$DjMalrang0, DjMalrangInfo djMalrangInfo0, int v, Object object0) {
            if((v & 1) != 0) {
                djMalrangInfo0 = playlistMainBgData$DjMalrang0.a;
            }
            return playlistMainBgData$DjMalrang0.copy(djMalrangInfo0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof DjMalrang ? q.b(this.a, ((DjMalrang)object0).a) : false;
        }

        @NotNull
        public final DjMalrangInfo getDjMalrangInfo() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "DjMalrang(djMalrangInfo=" + this.a + ")";
        }
    }

}

