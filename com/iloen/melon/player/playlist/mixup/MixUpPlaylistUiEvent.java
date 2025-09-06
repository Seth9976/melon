package com.iloen.melon.player.playlist.mixup;

import android.net.Uri;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.I4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistUiEvent;", "Lcom/melon/ui/I4;", "OpenOtherRecommendDialog", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistUiEvent$OpenOtherRecommendDialog;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MixUpPlaylistUiEvent implements I4 {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001A\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ&\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\tR\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u000B¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistUiEvent$OpenOtherRecommendDialog;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistUiEvent;", "Lcom/melon/playlist/mixup/DjMalrangInfo;", "currentDjMalrangInfo", "Landroid/net/Uri;", "thumbUriForBg", "<init>", "(Lcom/melon/playlist/mixup/DjMalrangInfo;Landroid/net/Uri;)V", "component1", "()Lcom/melon/playlist/mixup/DjMalrangInfo;", "component2", "()Landroid/net/Uri;", "copy", "(Lcom/melon/playlist/mixup/DjMalrangInfo;Landroid/net/Uri;)Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistUiEvent$OpenOtherRecommendDialog;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/playlist/mixup/DjMalrangInfo;", "getCurrentDjMalrangInfo", "b", "Landroid/net/Uri;", "getThumbUriForBg", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OpenOtherRecommendDialog extends MixUpPlaylistUiEvent {
        public static final int $stable = 8;
        public final DjMalrangInfo a;
        public final Uri b;

        public OpenOtherRecommendDialog(@NotNull DjMalrangInfo djMalrangInfo0, @Nullable Uri uri0) {
            q.g(djMalrangInfo0, "currentDjMalrangInfo");
            super(null);
            this.a = djMalrangInfo0;
            this.b = uri0;
        }

        public OpenOtherRecommendDialog(DjMalrangInfo djMalrangInfo0, Uri uri0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                uri0 = null;
            }
            this(djMalrangInfo0, uri0);
        }

        @NotNull
        public final DjMalrangInfo component1() {
            return this.a;
        }

        @Nullable
        public final Uri component2() {
            return this.b;
        }

        @NotNull
        public final OpenOtherRecommendDialog copy(@NotNull DjMalrangInfo djMalrangInfo0, @Nullable Uri uri0) {
            q.g(djMalrangInfo0, "currentDjMalrangInfo");
            return new OpenOtherRecommendDialog(djMalrangInfo0, uri0);
        }

        public static OpenOtherRecommendDialog copy$default(OpenOtherRecommendDialog mixUpPlaylistUiEvent$OpenOtherRecommendDialog0, DjMalrangInfo djMalrangInfo0, Uri uri0, int v, Object object0) {
            if((v & 1) != 0) {
                djMalrangInfo0 = mixUpPlaylistUiEvent$OpenOtherRecommendDialog0.a;
            }
            if((v & 2) != 0) {
                uri0 = mixUpPlaylistUiEvent$OpenOtherRecommendDialog0.b;
            }
            return mixUpPlaylistUiEvent$OpenOtherRecommendDialog0.copy(djMalrangInfo0, uri0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof OpenOtherRecommendDialog)) {
                return false;
            }
            return q.b(this.a, ((OpenOtherRecommendDialog)object0).a) ? q.b(this.b, ((OpenOtherRecommendDialog)object0).b) : false;
        }

        @NotNull
        public final DjMalrangInfo getCurrentDjMalrangInfo() {
            return this.a;
        }

        @Nullable
        public final Uri getThumbUriForBg() {
            return this.b;
        }

        @Override
        public int hashCode() {
            int v = this.a.hashCode();
            return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OpenOtherRecommendDialog(currentDjMalrangInfo=" + this.a + ", thumbUriForBg=" + this.b + ")";
        }
    }

    public static final int $stable;

    public MixUpPlaylistUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

