package com.iloen.melon.fragments;

import android.widget.TextView;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.OnCommentActionListener;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b\b\u0010\u0006J#\u0010\u000B\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000E\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0006J\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0006J\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0015J\u001F\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0015J\u000F\u0010\u001E\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0017J\u000F\u0010\u001F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0015J\u000F\u0010 \u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b \u0010\u0015J-\u0010%\u001A\u00020\u00042\b\u0010!\u001A\u0004\u0018\u00010\u00022\b\u0010\"\u001A\u0004\u0018\u00010\u00022\b\u0010$\u001A\u0004\u0018\u00010#H\u0016\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010)\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b+\u0010\u0006J\u0019\u0010,\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b,\u0010\u0006J\u0019\u0010/\u001A\u00020\u00042\b\u0010.\u001A\u0004\u0018\u00010-H\u0016\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b1\u0010\u0015J\u001F\u00106\u001A\u00020\u00042\u0006\u00103\u001A\u0002022\u0006\u00105\u001A\u000204H\u0016\u00A2\u0006\u0004\b6\u00107J\u0011\u00109\u001A\u0004\u0018\u000108H\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010=\u001A\u00020\u00042\u0006\u0010<\u001A\u00020;H\u0016\u00A2\u0006\u0004\b=\u0010>J\u000F\u0010?\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b?\u0010\u0015J/\u0010D\u001A\u00020\u00042\u0016\u0010B\u001A\u0012\u0012\u0004\u0012\u00020-0@j\b\u0012\u0004\u0012\u00020-`A2\u0006\u0010C\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\bD\u0010EJ/\u0010H\u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u00022\u0006\u0010F\u001A\u00020\u00102\u0006\u0010G\u001A\u00020\'H\u0016\u00A2\u0006\u0004\bH\u0010I\u00A8\u0006J\u00C0\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "Lcom/iloen/melon/fragments/comments/OnCommentActionListener;", "", "songId", "Lie/H;", "onPlaySongListener", "(Ljava/lang/String;)V", "albumId", "onPlayAlbumListener", "plylstSeq", "contsTypeCode", "onPlayDjPlaylistListener", "(Ljava/lang/String;Ljava/lang/String;)V", "castSeq", "onPlayRadioCast", "onAlbumPlayListener", "", "isCheck", "onAllSelectListener", "(Z)V", "onPlayArtistMixUp", "()V", "onCheckLoginListener", "()Z", "onShowNoFanPopupListener", "artistId", "isFan", "onRequestFanListener", "(Ljava/lang/String;Z)V", "onShowSharePopupListener", "onSongListMore", "onSongListViewAll", "onSongListFooterRemoveCheck", "contsId", "songIds", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElementsBase", "onPlayForUSongListener", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "", "position", "onMoveToScoll", "(I)V", "onLyricUpdateMsgListener", "onOpenCastEpisodeDetailView", "Lcom/iloen/melon/playback/Playable;", "playable", "onPlayBtnListener", "(Lcom/iloen/melon/playback/Playable;)V", "onDownloadSong", "Lcom/iloen/melon/custom/CheckableImageView;", "btnLiked", "Landroid/widget/TextView;", "cntLiked", "onLikedListener", "(Lcom/iloen/melon/custom/CheckableImageView;Landroid/widget/TextView;)V", "Lp8/f;", "onTiaraEventBuilder", "()Lp8/f;", "Lcom/iloen/melon/custom/CheckableTextView;", "view", "onSetBtnAll", "(Lcom/iloen/melon/custom/CheckableTextView;)V", "onPerformBackPress", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "playableList", "nowPlay", "onPlaySongsListener", "(Ljava/util/ArrayList;Z)V", "isLike", "itemPosition", "onItemLikeListener", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface OnViewHolderActionBaseListener extends OnCommentActionListener {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        public static void onAlbumPlayListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull String s) {
            q.g(s, "albumId");
            onViewHolderActionBaseListener0.super.onAlbumPlayListener(s);
        }

        @Deprecated
        public static void onAllSelectListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, boolean z) {
            onViewHolderActionBaseListener0.super.onAllSelectListener(z);
        }

        @Deprecated
        public static boolean onCheckLoginListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            return onViewHolderActionBaseListener0.super.onCheckLoginListener();
        }

        @Deprecated
        public static void onCommentRecommendListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1, boolean z, @NotNull TextView textView0, @NotNull RecommenderView recommenderView0) {
            q.g(textView0, "view");
            q.g(recommenderView0, "recommenderView");
            onViewHolderActionBaseListener0.super.onCommentRecommendListener(v, v1, z, textView0, recommenderView0);
        }

        @Deprecated
        public static void onCommentRemoveListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1) {
            onViewHolderActionBaseListener0.super.onCommentRemoveListener(v, v1);
        }

        @Deprecated
        public static void onCommentReportListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1) {
            onViewHolderActionBaseListener0.super.onCommentReportListener(v, v1);
        }

        @Deprecated
        public static void onDownloadSong(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onDownloadSong();
        }

        @Deprecated
        public static void onItemLikeListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull String s, @NotNull String s1, boolean z, int v) {
            q.g(s, "contsId");
            q.g(s1, "contsTypeCode");
            onViewHolderActionBaseListener0.super.onItemLikeListener(s, s1, z, v);
        }

        @Deprecated
        public static void onLikedListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull CheckableImageView checkableImageView0, @NotNull TextView textView0) {
            q.g(checkableImageView0, "btnLiked");
            q.g(textView0, "cntLiked");
            onViewHolderActionBaseListener0.super.onLikedListener(checkableImageView0, textView0);
        }

        @Deprecated
        public static void onLyricUpdateMsgListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull String s) {
            q.g(s, "songId");
            onViewHolderActionBaseListener0.super.onLyricUpdateMsgListener(s);
        }

        @Deprecated
        public static void onMoveToScoll(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v) {
            onViewHolderActionBaseListener0.super.onMoveToScoll(v);
        }

        @Deprecated
        public static void onOpenAdCommentView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1) {
            onViewHolderActionBaseListener0.super.onOpenAdCommentView(v, v1);
        }

        @Deprecated
        public static void onOpenCastEpisodeDetailView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable String s) {
            onViewHolderActionBaseListener0.super.onOpenCastEpisodeDetailView(s);
        }

        @Deprecated
        public static void onOpenCommentEditView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1) {
            onViewHolderActionBaseListener0.super.onOpenCommentEditView(v, v1);
        }

        @Deprecated
        public static void onOpenCommentListView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onOpenCommentListView();
        }

        @Deprecated
        public static void onOpenCommentListView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull Param cmtListFragment$Param0) {
            q.g(cmtListFragment$Param0, "param");
            onViewHolderActionBaseListener0.super.onOpenCommentListView(cmtListFragment$Param0);
        }

        @Deprecated
        public static void onOpenCommentWriteView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onOpenCommentWriteView();
        }

        @Deprecated
        public static void onOpenUserView(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1) {
            onViewHolderActionBaseListener0.super.onOpenUserView(v, v1);
        }

        @Deprecated
        public static void onPerformBackPress(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onPerformBackPress();
        }

        @Deprecated
        public static void onPlayAlbumListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable String s) {
            onViewHolderActionBaseListener0.super.onPlayAlbumListener(s);
        }

        @Deprecated
        public static void onPlayArtistMixUp(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onPlayArtistMixUp();
        }

        @Deprecated
        public static void onPlayBtnListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable Playable playable0) {
            onViewHolderActionBaseListener0.super.onPlayBtnListener(playable0);
        }

        @Deprecated
        public static void onPlayDjPlaylistListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable String s, @Nullable String s1) {
            onViewHolderActionBaseListener0.super.onPlayDjPlaylistListener(s, s1);
        }

        @Deprecated
        public static void onPlayForUSongListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
            onViewHolderActionBaseListener0.super.onPlayForUSongListener(s, s1, statsElementsBase0);
        }

        @Deprecated
        public static void onPlayRadioCast(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable String s) {
            onViewHolderActionBaseListener0.super.onPlayRadioCast(s);
        }

        @Deprecated
        public static void onPlaySongListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @Nullable String s) {
            onViewHolderActionBaseListener0.super.onPlaySongListener(s);
        }

        @Deprecated
        public static void onPlaySongsListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull ArrayList arrayList0, boolean z) {
            q.g(arrayList0, "playableList");
            onViewHolderActionBaseListener0.super.onPlaySongsListener(arrayList0, z);
        }

        @Deprecated
        public static void onRequestFanListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull String s, boolean z) {
            q.g(s, "artistId");
            onViewHolderActionBaseListener0.super.onRequestFanListener(s, z);
        }

        @Deprecated
        public static void onSetBtnAll(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, @NotNull CheckableTextView checkableTextView0) {
            q.g(checkableTextView0, "view");
            onViewHolderActionBaseListener0.super.onSetBtnAll(checkableTextView0);
        }

        @Deprecated
        public static void onShowContextPopupCommentMore(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, int v, int v1, boolean z, boolean z1) {
            onViewHolderActionBaseListener0.super.onShowContextPopupCommentMore(v, v1, z, z1);
        }

        @Deprecated
        public static void onShowNoFanPopupListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onShowNoFanPopupListener();
        }

        @Deprecated
        public static void onShowSharePopupListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onShowSharePopupListener();
        }

        @Deprecated
        public static void onSongListFooterRemoveCheck(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onSongListFooterRemoveCheck();
        }

        @Deprecated
        public static boolean onSongListMore(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            return onViewHolderActionBaseListener0.super.onSongListMore();
        }

        @Deprecated
        public static void onSongListViewAll(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            onViewHolderActionBaseListener0.super.onSongListViewAll();
        }

        @Deprecated
        @Nullable
        public static f onTiaraEventBuilder(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            return onViewHolderActionBaseListener0.super.onTiaraEventBuilder();
        }
    }

    default void onAlbumPlayListener(@NotNull String s) {
        q.g(s, "albumId");
    }

    default void onAllSelectListener(boolean z) {
    }

    default boolean onCheckLoginListener() {
        return false;
    }

    default void onDownloadSong() {
    }

    default void onItemLikeListener(@NotNull String s, @NotNull String s1, boolean z, int v) {
        q.g(s, "contsId");
        q.g(s1, "contsTypeCode");
    }

    default void onLikedListener(@NotNull CheckableImageView checkableImageView0, @NotNull TextView textView0) {
        q.g(checkableImageView0, "btnLiked");
        q.g(textView0, "cntLiked");
    }

    default void onLyricUpdateMsgListener(@NotNull String s) {
        q.g(s, "songId");
    }

    default void onMoveToScoll(int v) {
    }

    default void onOpenCastEpisodeDetailView(@Nullable String s) {
    }

    default void onPerformBackPress() {
    }

    default void onPlayAlbumListener(@Nullable String s) {
    }

    default void onPlayArtistMixUp() {
    }

    default void onPlayBtnListener(@Nullable Playable playable0) {
    }

    default void onPlayDjPlaylistListener(@Nullable String s, @Nullable String s1) {
    }

    default void onPlayForUSongListener(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
    }

    default void onPlayRadioCast(@Nullable String s) {
    }

    default void onPlaySongListener(@Nullable String s) {
    }

    default void onPlaySongsListener(@NotNull ArrayList arrayList0, boolean z) {
        q.g(arrayList0, "playableList");
    }

    default void onRequestFanListener(@NotNull String s, boolean z) {
        q.g(s, "artistId");
    }

    default void onSetBtnAll(@NotNull CheckableTextView checkableTextView0) {
        q.g(checkableTextView0, "view");
    }

    default void onShowNoFanPopupListener() {
    }

    default void onShowSharePopupListener() {
    }

    default void onSongListFooterRemoveCheck() {
    }

    default boolean onSongListMore() {
        return false;
    }

    default void onSongListViewAll() {
    }

    @Nullable
    default f onTiaraEventBuilder() {
        return null;
    }
}

