package com.iloen.melon.fragments.comments;

import android.widget.TextView;
import com.iloen.melon.custom.RecommenderView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\u0007J7\u0010\u0011\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u001F\u0010\u0016\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001F\u0010\u0017\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u001F\u0010\u0019\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0014J/\u0010\u001C\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001C\u0010\u001D¨\u0006\u001EÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/comments/OnCommentActionListener;", "", "Lie/H;", "onOpenCommentListView", "()V", "Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;", "param", "(Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;)V", "", "adapterPos", "dataPos", "", "recom", "Landroid/widget/TextView;", "view", "Lcom/iloen/melon/custom/RecommenderView;", "recommenderView", "onCommentRecommendListener", "(IIZLandroid/widget/TextView;Lcom/iloen/melon/custom/RecommenderView;)V", "onOpenUserView", "(II)V", "onOpenCommentWriteView", "onOpenAdCommentView", "onOpenCommentEditView", "onCommentRemoveListener", "onCommentReportListener", "isEditable", "isFanTalk", "onShowContextPopupCommentMore", "(IIZZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface OnCommentActionListener {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        public static void onCommentRecommendListener(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1, boolean z, @NotNull TextView textView0, @NotNull RecommenderView recommenderView0) {
            q.g(textView0, "view");
            q.g(recommenderView0, "recommenderView");
            onCommentActionListener0.super.onCommentRecommendListener(v, v1, z, textView0, recommenderView0);
        }

        @Deprecated
        public static void onCommentRemoveListener(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1) {
            onCommentActionListener0.super.onCommentRemoveListener(v, v1);
        }

        @Deprecated
        public static void onCommentReportListener(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1) {
            onCommentActionListener0.super.onCommentReportListener(v, v1);
        }

        @Deprecated
        public static void onOpenAdCommentView(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1) {
            onCommentActionListener0.super.onOpenAdCommentView(v, v1);
        }

        @Deprecated
        public static void onOpenCommentEditView(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1) {
            onCommentActionListener0.super.onOpenCommentEditView(v, v1);
        }

        @Deprecated
        public static void onOpenCommentListView(@NotNull OnCommentActionListener onCommentActionListener0) {
            onCommentActionListener0.super.onOpenCommentListView();
        }

        @Deprecated
        public static void onOpenCommentListView(@NotNull OnCommentActionListener onCommentActionListener0, @NotNull Param cmtListFragment$Param0) {
            q.g(cmtListFragment$Param0, "param");
            onCommentActionListener0.super.onOpenCommentListView(cmtListFragment$Param0);
        }

        @Deprecated
        public static void onOpenCommentWriteView(@NotNull OnCommentActionListener onCommentActionListener0) {
            onCommentActionListener0.super.onOpenCommentWriteView();
        }

        @Deprecated
        public static void onOpenUserView(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1) {
            onCommentActionListener0.super.onOpenUserView(v, v1);
        }

        @Deprecated
        public static void onShowContextPopupCommentMore(@NotNull OnCommentActionListener onCommentActionListener0, int v, int v1, boolean z, boolean z1) {
            onCommentActionListener0.super.onShowContextPopupCommentMore(v, v1, z, z1);
        }
    }

    default void onCommentRecommendListener(int v, int v1, boolean z, @NotNull TextView textView0, @NotNull RecommenderView recommenderView0) {
        q.g(textView0, "view");
        q.g(recommenderView0, "recommenderView");
    }

    default void onCommentRemoveListener(int v, int v1) {
    }

    default void onCommentReportListener(int v, int v1) {
    }

    default void onOpenAdCommentView(int v, int v1) {
    }

    default void onOpenCommentEditView(int v, int v1) {
    }

    default void onOpenCommentListView() {
    }

    default void onOpenCommentListView(@NotNull Param cmtListFragment$Param0) {
        q.g(cmtListFragment$Param0, "param");
    }

    default void onOpenCommentWriteView() {
    }

    default void onOpenUserView(int v, int v1) {
    }

    default void onShowContextPopupCommentMore(int v, int v1, boolean z, boolean z1) {
    }
}

