package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Ac.Z1;
import J8.h2;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.fragment.app.I;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.main.common.OnImpLogListener;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolderForMelonBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.b;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0003\u001E\u001F B7\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u0003\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u0003\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\b\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolderForMelonBase;", "LJ8/h2;", "bind", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "actionListener", "", "showHotAndTitleBadge", "isRankWithoutGap", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "onImpLogListener", "<init>", "(LJ8/h2;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;ZZLcom/iloen/melon/fragments/main/common/OnImpLogListener;)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$DetailContentsSong;", "song", "Lie/H;", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$DetailContentsSong;)V", "", "size", "setTotal", "(I)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "Z", "binding", "LJ8/h2;", "total", "I", "Companion", "SongActionListener", "DetailContentsSong", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsSongHolder extends ViewableCheckViewHolderForMelonBase {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00112\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$Companion;", "", "<init>", "()V", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_SELECT_SONG", "TALKBACK_ACTION_PLAYBACK", "TALKBACK_ACTION_ALBUM_DETAIL", "TALKBACK_ACTION_MENU_MORE", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "showHotAndTitleBadge", "", "isRankWithoutGap", "onImpLogListener", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
            return Companion.newInstance$default(this, viewGroup0, detailContentsSongHolder$SongActionListener0, false, false, null, 28, null);
        }

        @NotNull
        public final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
            return Companion.newInstance$default(this, viewGroup0, detailContentsSongHolder$SongActionListener0, z, false, null, 24, null);
        }

        @NotNull
        public final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
            return Companion.newInstance$default(this, viewGroup0, detailContentsSongHolder$SongActionListener0, z, z1, null, 16, null);
        }

        @NotNull
        public final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, @Nullable OnImpLogListener onImpLogListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
            return new DetailContentsSongHolder(h2.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), detailContentsSongHolder$SongActionListener0, z, z1, onImpLogListener0, null);
        }

        public static DetailContentsSongHolder newInstance$default(Companion detailContentsSongHolder$Companion0, ViewGroup viewGroup0, SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, OnImpLogListener onImpLogListener0, int v, Object object0) {
            if((v & 4) != 0) {
                z = true;
            }
            if((v & 8) != 0) {
                z1 = false;
            }
            if((v & 16) != 0) {
                onImpLogListener0 = null;
            }
            return detailContentsSongHolder$Companion0.newInstance(viewGroup0, detailContentsSongHolder$SongActionListener0, z, z1, onImpLogListener0);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\bHÆ\u0003J\t\u0010\u0017\u001A\u00020\bHÆ\u0003J\t\u0010\u0018\u001A\u00020\bHÆ\u0003JG\u0010\u0019\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001A\u001A\u00020\b2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0012R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0012R\u0011\u0010\n\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0012¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$DetailContentsSong;", "", "item", "Lcom/melon/net/res/common/SongInfoBase;", "rawPosition", "", "position", "isMarked", "", "isMarqueeNeeded", "isOriginSong", "<init>", "(Lcom/melon/net/res/common/SongInfoBase;IIZZZ)V", "getItem", "()Lcom/melon/net/res/common/SongInfoBase;", "getRawPosition", "()I", "getPosition", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DetailContentsSong {
        public static final int $stable = 8;
        private final boolean isMarked;
        private final boolean isMarqueeNeeded;
        private final boolean isOriginSong;
        @Nullable
        private final SongInfoBase item;
        private final int position;
        private final int rawPosition;

        public DetailContentsSong(@Nullable SongInfoBase songInfoBase0, int v, int v1, boolean z, boolean z1, boolean z2) {
            this.item = songInfoBase0;
            this.rawPosition = v;
            this.position = v1;
            this.isMarked = z;
            this.isMarqueeNeeded = z1;
            this.isOriginSong = z2;
        }

        public DetailContentsSong(SongInfoBase songInfoBase0, int v, int v1, boolean z, boolean z1, boolean z2, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 0x20) != 0) {
                z2 = false;
            }
            this(songInfoBase0, v, v1, z, z1, z2);
        }

        @Nullable
        public final SongInfoBase component1() {
            return this.item;
        }

        public final int component2() {
            return this.rawPosition;
        }

        public final int component3() {
            return this.position;
        }

        public final boolean component4() {
            return this.isMarked;
        }

        public final boolean component5() {
            return this.isMarqueeNeeded;
        }

        public final boolean component6() {
            return this.isOriginSong;
        }

        @NotNull
        public final DetailContentsSong copy(@Nullable SongInfoBase songInfoBase0, int v, int v1, boolean z, boolean z1, boolean z2) {
            return new DetailContentsSong(songInfoBase0, v, v1, z, z1, z2);
        }

        public static DetailContentsSong copy$default(DetailContentsSong detailContentsSongHolder$DetailContentsSong0, SongInfoBase songInfoBase0, int v, int v1, boolean z, boolean z1, boolean z2, int v2, Object object0) {
            if((v2 & 1) != 0) {
                songInfoBase0 = detailContentsSongHolder$DetailContentsSong0.item;
            }
            if((v2 & 2) != 0) {
                v = detailContentsSongHolder$DetailContentsSong0.rawPosition;
            }
            if((v2 & 4) != 0) {
                v1 = detailContentsSongHolder$DetailContentsSong0.position;
            }
            if((v2 & 8) != 0) {
                z = detailContentsSongHolder$DetailContentsSong0.isMarked;
            }
            if((v2 & 16) != 0) {
                z1 = detailContentsSongHolder$DetailContentsSong0.isMarqueeNeeded;
            }
            if((v2 & 0x20) != 0) {
                z2 = detailContentsSongHolder$DetailContentsSong0.isOriginSong;
            }
            return detailContentsSongHolder$DetailContentsSong0.copy(songInfoBase0, v, v1, z, z1, z2);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DetailContentsSong)) {
                return false;
            }
            if(!q.b(this.item, ((DetailContentsSong)object0).item)) {
                return false;
            }
            if(this.rawPosition != ((DetailContentsSong)object0).rawPosition) {
                return false;
            }
            if(this.position != ((DetailContentsSong)object0).position) {
                return false;
            }
            if(this.isMarked != ((DetailContentsSong)object0).isMarked) {
                return false;
            }
            return this.isMarqueeNeeded == ((DetailContentsSong)object0).isMarqueeNeeded ? this.isOriginSong == ((DetailContentsSong)object0).isOriginSong : false;
        }

        @Nullable
        public final SongInfoBase getItem() {
            return this.item;
        }

        public final int getPosition() {
            return this.position;
        }

        public final int getRawPosition() {
            return this.rawPosition;
        }

        @Override
        public int hashCode() {
            return this.item == null ? Boolean.hashCode(this.isOriginSong) + d.e(d.e(d.b(this.position, d.b(this.rawPosition, 0, 0x1F), 0x1F), 0x1F, this.isMarked), 0x1F, this.isMarqueeNeeded) : Boolean.hashCode(this.isOriginSong) + d.e(d.e(d.b(this.position, d.b(this.rawPosition, this.item.hashCode() * 0x1F, 0x1F), 0x1F), 0x1F, this.isMarked), 0x1F, this.isMarqueeNeeded);
        }

        public final boolean isMarked() {
            return this.isMarked;
        }

        public final boolean isMarqueeNeeded() {
            return this.isMarqueeNeeded;
        }

        public final boolean isOriginSong() {
            return this.isOriginSong;
        }

        @Override
        @NotNull
        public String toString() {
            return "DetailContentsSong(item=" + this.item + ", rawPosition=" + this.rawPosition + ", position=" + this.position + ", isMarked=" + this.isMarked + ", isMarqueeNeeded=" + this.isMarqueeNeeded + ", isOriginSong=" + this.isOriginSong + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J7\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\'\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0006H&¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u000FJ\'\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u000FJ\'\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u000F¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "", "Landroid/view/View;", "view", "Lcom/melon/net/res/common/SongInfoBase;", "item", "", "rawPosition", "position", "", "isMarked", "Lie/H;", "onSongClick", "(Landroid/view/View;Lcom/melon/net/res/common/SongInfoBase;IIZ)V", "onSongLongClick", "(Landroid/view/View;Lcom/melon/net/res/common/SongInfoBase;I)V", "onPlaySongClick", "onInfoClick", "onThumbClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface SongActionListener {
        void onInfoClick(@NotNull View arg1, @NotNull SongInfoBase arg2, int arg3);

        void onPlaySongClick(@NotNull View arg1, @NotNull SongInfoBase arg2, int arg3);

        void onSongClick(@NotNull View arg1, @NotNull SongInfoBase arg2, int arg3, int arg4, boolean arg5);

        void onSongLongClick(@NotNull View arg1, @NotNull SongInfoBase arg2, int arg3);

        void onThumbClick(@NotNull View arg1, @NotNull SongInfoBase arg2, int arg3);
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int TALKBACK_ACTION_ALBUM_DETAIL = 100000003;
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_MENU_MORE = 100000004;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    private static final int TALKBACK_ACTION_SELECT_SONG = 100000001;
    @NotNull
    private final SongActionListener actionListener;
    @NotNull
    private h2 binding;
    private final boolean isRankWithoutGap;
    private final boolean showHotAndTitleBadge;
    private int total;

    static {
        DetailContentsSongHolder.Companion = new Companion(null);
        DetailContentsSongHolder.$stable = 8;
    }

    private DetailContentsSongHolder(h2 h20, SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, OnImpLogListener onImpLogListener0) {
        q.f(h20.a, "getRoot(...)");
        super(h20.a);
        this.actionListener = detailContentsSongHolder$SongActionListener0;
        this.showHotAndTitleBadge = z;
        this.isRankWithoutGap = z1;
        this.binding = h20;
        h20.a.addOnAttachStateChangeListener(this);
        this.setOnImpLogListener(onImpLogListener0);
    }

    public DetailContentsSongHolder(h2 h20, SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, OnImpLogListener onImpLogListener0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            z1 = false;
        }
        if((v & 16) != 0) {
            onImpLogListener0 = null;
        }
        this(h20, detailContentsSongHolder$SongActionListener0, z, z1, onImpLogListener0);
    }

    public DetailContentsSongHolder(h2 h20, SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, OnImpLogListener onImpLogListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(h20, detailContentsSongHolder$SongActionListener0, z, z1, onImpLogListener0);
    }

    public final void bind(@NotNull DetailContentsSong detailContentsSongHolder$DetailContentsSong0) {
        q.g(detailContentsSongHolder$DetailContentsSong0, "song");
        Context context0 = this.itemView.getContext();
        SongInfoBase songInfoBase0 = detailContentsSongHolder$DetailContentsSong0.getItem();
        boolean z = songInfoBase0 == null ? false : songInfoBase0.canService;
        ViewUtils.setEnable(this.binding.q, z);
        ViewUtils.showWhen(this.binding.c, z);
        ViewUtils.setDefaultImage(this.binding.h.c, ScreenUtils.dipToPixel(context0, 44.0f));
        MelonImageView melonImageView0 = this.binding.h.b;
        SongInfoBase songInfoBase1 = detailContentsSongHolder$DetailContentsSong0.getItem();
        ArrayList arrayList0 = null;
        Glide.with(context0).load((songInfoBase1 == null ? null : songInfoBase1.albumImg)).into(melonImageView0);
        if(!z || detailContentsSongHolder$DetailContentsSong0.getItem() == null) {
            this.itemView.setOnClickListener(null);
            int v2 = ColorUtils.getColor(context0, 0x7F06048A);  // color:transparent
            this.itemView.setBackgroundColor(v2);
            ViewUtils.setOnClickListener(this.binding.c, null);
        }
        else {
            m m0 = new m(this, detailContentsSongHolder$DetailContentsSong0, 0);
            this.itemView.setOnClickListener(m0);
            if(detailContentsSongHolder$DetailContentsSong0.isMarked()) {
                int v = ColorUtils.getColor(context0, 0x7F060199);  // color:list_item_marked
                this.itemView.setBackgroundColor(v);
            }
            else {
                int v1 = ColorUtils.getColor(context0, 0x7F06048A);  // color:transparent
                this.itemView.setBackgroundColor(v1);
            }
            ViewUtils.setOnClickListener(this.binding.c, new m(this, detailContentsSongHolder$DetailContentsSong0, 1));
        }
        if(detailContentsSongHolder$DetailContentsSong0.getItem() == null) {
            this.itemView.setOnLongClickListener(null);
            ViewUtils.setOnClickListener(this.binding.b, null);
            ViewUtils.setOnClickListener(this.binding.h.a, null);
        }
        else {
            n n0 = new n(0, this, detailContentsSongHolder$DetailContentsSong0);
            this.itemView.setOnLongClickListener(n0);
            ViewUtils.setOnClickListener(this.binding.b, new m(this, detailContentsSongHolder$DetailContentsSong0, 2));
            ViewUtils.setOnClickListener(this.binding.h.a, new m(this, detailContentsSongHolder$DetailContentsSong0, 3));
        }
        if(this.isRankWithoutGap) {
            this.binding.p.setVisibility(0);
            this.binding.k.setVisibility(8);
            this.binding.l.setText(String.valueOf(detailContentsSongHolder$DetailContentsSong0.getPosition() + 1));
        }
        else {
            this.binding.p.setVisibility(8);
        }
        ViewUtils.setTextViewMarquee(this.binding.n, detailContentsSongHolder$DetailContentsSong0.isMarqueeNeeded());
        SongInfoBase songInfoBase2 = detailContentsSongHolder$DetailContentsSong0.getItem();
        this.binding.n.setText((songInfoBase2 == null ? null : songInfoBase2.songName));
        MelonTextView melonTextView0 = this.binding.j;
        SongInfoBase songInfoBase3 = detailContentsSongHolder$DetailContentsSong0.getItem();
        if(songInfoBase3 != null) {
            arrayList0 = songInfoBase3.artistList;
        }
        melonTextView0.setText(ProtocolUtils.getArtistNames(arrayList0));
        ImageView imageView0 = (ImageView)this.binding.i.findViewById(0x7F0A0646);  // id:iv_list_title
        ImageView imageView1 = (ImageView)this.binding.i.findViewById(0x7F0A063B);  // id:iv_list_19
        ImageView imageView2 = (ImageView)this.binding.i.findViewById(0x7F0A0642);  // id:iv_list_hot
        ImageView imageView3 = (ImageView)this.binding.i.findViewById(0x7F0A0640);  // id:iv_list_free
        ImageView imageView4 = (ImageView)this.binding.i.findViewById(0x7F0A0641);  // id:iv_list_holdback
        if(detailContentsSongHolder$DetailContentsSong0.getItem() == null) {
            ViewUtils.showWhen(imageView0, false);
            ViewUtils.showWhen(imageView1, false);
            ViewUtils.showWhen(imageView2, false);
            ViewUtils.showWhen(imageView3, false);
            ViewUtils.showWhen(imageView4, false);
        }
        else {
            ViewUtils.showWhen(imageView0, detailContentsSongHolder$DetailContentsSong0.getItem().isTitleSong);
            ViewUtils.showWhen(imageView1, detailContentsSongHolder$DetailContentsSong0.getItem().isAdult);
            ViewUtils.showWhen(imageView2, detailContentsSongHolder$DetailContentsSong0.getItem().isHitSong);
            ViewUtils.showWhen(imageView3, detailContentsSongHolder$DetailContentsSong0.getItem().isFree);
            ViewUtils.showWhen(imageView4, detailContentsSongHolder$DetailContentsSong0.getItem().isHoldback);
            ViewUtils.showWhen(this.binding.g, detailContentsSongHolder$DetailContentsSong0.isOriginSong());
        }
        if(!this.showHotAndTitleBadge) {
            ViewUtils.showWhen(imageView0, false);
            ViewUtils.showWhen(imageView2, false);
        }
        Z1 z10 = new Z1(this, detailContentsSongHolder$DetailContentsSong0, context0, 16);
        this.addAndStartViewableCheck(this.itemView, detailContentsSongHolder$DetailContentsSong0.getPosition(), z10);
        this.binding.h.a.setImportantForAccessibility(2);
        this.binding.c.setImportantForAccessibility(2);
        this.binding.b.setImportantForAccessibility(2);
        this.binding.a.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                if(z != null) {
                    if(detailContentsSongHolder$DetailContentsSong0) {
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, z.getString((this.isMarked() ? 0x7F130C5A : 0x7F130C58))));  // string:talkback_songlist_unselect "선택 해제하기"
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, "재생"));
                    }
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000003, "앨범 정보"));
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000004, "더보기"));
                    StringBuilder stringBuilder0 = new StringBuilder();
                    if(this.isMarked()) {
                        stringBuilder0.append("선택됨, ");
                    }
                    SongInfoBase songInfoBase0 = this.getItem();
                    if(songInfoBase0 != null && songInfoBase0.isAdult) {
                        stringBuilder0.append("19세 미만 청소년 이용불가 콘텐츠, ");
                    }
                    SongInfoBase songInfoBase1 = this.getItem();
                    if(songInfoBase1 != null && songInfoBase1.isTitleSong) {
                        stringBuilder0.append("타이틀, ");
                    }
                    SongInfoBase songInfoBase2 = this.getItem();
                    if(songInfoBase2 != null && songInfoBase2.isHitSong) {
                        stringBuilder0.append("hot, ");
                    }
                    SongInfoBase songInfoBase3 = this.getItem();
                    if(songInfoBase3 != null && songInfoBase3.isFree) {
                        stringBuilder0.append("free, ");
                    }
                    SongInfoBase songInfoBase4 = this.getItem();
                    if(songInfoBase4 != null && songInfoBase4.isHoldback) {
                        stringBuilder0.append("holdback, ");
                    }
                    if(this.isOriginSong()) {
                        stringBuilder0.append("원곡, ");
                    }
                    stringBuilder0.append(DetailContentsSongHolder.this.binding.n.getText() + ", " + "아티스트" + " : " + DetailContentsSongHolder.this.binding.j.getText());
                    accessibilityNodeInfo0.setContentDescription(stringBuilder0);
                    accessibilityNodeInfo0.setClassName("android.widget.Button");
                    StringBuilder stringBuilder1 = new StringBuilder(z.getString(0x7F130BA8, new Object[]{DetailContentsSongHolder.this.total, ((int)(this.getPosition() + 1))}));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
                    String s = detailContentsSongHolder$DetailContentsSong0 ? "두 번 탭하여 선택하거나 해제할 수 있습니다." : "음원 서비스 불가인 곡으로 선택할 수 없습니다.";
                    q.d(s);
                    stringBuilder1.append(", ");
                    stringBuilder1.append(s);
                    accessibilityNodeInfo0.setHintText(stringBuilder1);
                    if(!detailContentsSongHolder$DetailContentsSong0) {
                        accessibilityNodeInfo0.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
                        accessibilityNodeInfo0.setClickable(false);
                    }
                }
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        DetailContentsSongHolder.this.itemView.performClick();
                        return true;
                    }
                    case 100000002: {
                        DetailContentsSongHolder.this.binding.c.performClick();
                        return true;
                    }
                    case 100000003: {
                        DetailContentsSongHolder.this.binding.h.a.performClick();
                        return true;
                    }
                    case 100000004: {
                        DetailContentsSongHolder.this.binding.b.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        });
    }

    private static final void bind$lambda$7$lambda$1(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, View view0) {
        q.d(view0);
        detailContentsSongHolder0.actionListener.onSongClick(view0, detailContentsSongHolder$DetailContentsSong0.getItem(), detailContentsSongHolder$DetailContentsSong0.getRawPosition(), detailContentsSongHolder$DetailContentsSong0.getPosition(), !detailContentsSongHolder$DetailContentsSong0.isMarked());
    }

    private static final void bind$lambda$7$lambda$2(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, View view0) {
        q.d(view0);
        detailContentsSongHolder0.actionListener.onPlaySongClick(view0, detailContentsSongHolder$DetailContentsSong0.getItem(), detailContentsSongHolder$DetailContentsSong0.getPosition());
    }

    private static final boolean bind$lambda$7$lambda$3(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, View view0) {
        q.d(view0);
        detailContentsSongHolder0.actionListener.onSongLongClick(view0, detailContentsSongHolder$DetailContentsSong0.getItem(), detailContentsSongHolder$DetailContentsSong0.getPosition());
        return true;
    }

    private static final void bind$lambda$7$lambda$4(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, View view0) {
        q.d(view0);
        detailContentsSongHolder0.actionListener.onInfoClick(view0, detailContentsSongHolder$DetailContentsSong0.getItem(), detailContentsSongHolder$DetailContentsSong0.getPosition());
    }

    private static final void bind$lambda$7$lambda$5(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, View view0) {
        q.d(view0);
        detailContentsSongHolder0.actionListener.onThumbClick(view0, detailContentsSongHolder$DetailContentsSong0.getItem(), detailContentsSongHolder$DetailContentsSong0.getPosition());
    }

    private static final H bind$lambda$7$lambda$6(DetailContentsSongHolder detailContentsSongHolder0, DetailContentsSong detailContentsSongHolder$DetailContentsSong0, Context context0) {
        String s;
        OnImpLogListener onImpLogListener0 = detailContentsSongHolder0.getOnImpLogListener();
        if(onImpLogListener0 != null) {
            SongInfoBase songInfoBase0 = detailContentsSongHolder$DetailContentsSong0.getItem();
            if(songInfoBase0 == null) {
                s = "";
            }
            else {
                s = songInfoBase0.songId;
                if(s == null) {
                    s = "";
                }
            }
            String s1 = null;
            SongInfoBase songInfoBase1 = detailContentsSongHolder$DetailContentsSong0.getItem();
            Builder viewImpContent$Builder0 = new Builder().impId("melon_song_similar_base").impProvider("toros").impType((context0 == null ? null : "vimp")).impOrdNum(String.valueOf(detailContentsSongHolder$DetailContentsSong0.getPosition() + 1)).layer1((context0 == null ? null : "곡리스트")).id((songInfoBase1 == null ? null : songInfoBase1.songId));
            q.f("N10001", "code(...)");
            Builder viewImpContent$Builder1 = viewImpContent$Builder0.type(b.a("N10001"));
            SongInfoBase songInfoBase2 = detailContentsSongHolder$DetailContentsSong0.getItem();
            if(songInfoBase2 != null) {
                s1 = songInfoBase2.songName;
            }
            ViewImpContent viewImpContent0 = viewImpContent$Builder1.name(s1).build();
            q.f(viewImpContent0, "build(...)");
            onImpLogListener0.onImpLogListener(s, viewImpContent0);
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    @Nullable
    public I getCurrentFragment() {
        return null;
    }

    @NotNull
    public static final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0) {
        return DetailContentsSongHolder.Companion.newInstance(viewGroup0, detailContentsSongHolder$SongActionListener0);
    }

    @NotNull
    public static final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z) {
        return DetailContentsSongHolder.Companion.newInstance(viewGroup0, detailContentsSongHolder$SongActionListener0, z);
    }

    @NotNull
    public static final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1) {
        return DetailContentsSongHolder.Companion.newInstance(viewGroup0, detailContentsSongHolder$SongActionListener0, z, z1);
    }

    @NotNull
    public static final DetailContentsSongHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, @Nullable OnImpLogListener onImpLogListener0) {
        return DetailContentsSongHolder.Companion.newInstance(viewGroup0, detailContentsSongHolder$SongActionListener0, z, z1, onImpLogListener0);
    }

    public final void setTotal(int v) {
        this.total = v;
    }
}

