package com.iloen.melon.fragments.comments;

import android.app.Activity;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.player.video.VideoInfoAdapter;
import com.iloen.melon.player.video.VideoInfoFragment;
import com.iloen.melon.player.video.VideoInfoViewModel.WrappedData;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/comments/VideoCommentActionImpl;", "Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "activity", "Landroid/app/Activity;", "fragment", "Lcom/iloen/melon/player/video/VideoInfoFragment;", "<init>", "(Landroid/app/Activity;Lcom/iloen/melon/player/video/VideoInfoFragment;)V", "getValidCommentInfoAdapterItem", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "adapterPos", "", "dataPos", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoCommentActionImpl extends CommentActionImpl {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/comments/VideoCommentActionImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "VideoCommentActionImpl";
    @NotNull
    private final VideoInfoFragment fragment;

    static {
        VideoCommentActionImpl.Companion = new Companion(null);
        VideoCommentActionImpl.$stable = 8;
    }

    public VideoCommentActionImpl(@NotNull Activity activity0, @NotNull VideoInfoFragment videoInfoFragment0) {
        q.g(activity0, "activity");
        q.g(videoInfoFragment0, "fragment");
        super(activity0, videoInfoFragment0);
        this.fragment = videoInfoFragment0;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentActionImpl
    @Nullable
    public cmtList getValidCommentInfoAdapterItem(int v, int v1) {
        LogU.Companion.d("VideoCommentActionImpl", "getValidCommentInfoAdapterItem adapterPos : " + v + ", dataPos : " + v1);
        j0 j00 = this.fragment.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
        WrappedData videoInfoViewModel$WrappedData0 = (WrappedData)((VideoInfoAdapter)j00).getItem(v);
        if((videoInfoViewModel$WrappedData0 == null ? null : videoInfoViewModel$WrappedData0.getCmtRes()) != null) {
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = videoInfoViewModel$WrappedData0.getCmtRes();
            CmtResViewModel cmtResViewModel0 = adapterInViewHolder$Row0 == null ? null : ((CmtResViewModel)adapterInViewHolder$Row0.getItem());
            q.e(cmtResViewModel0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.CmtResViewModel");
            ArrayList arrayList0 = cmtResViewModel0.result.cmtlist;
            q.e(arrayList0, "null cannot be cast to non-null type java.util.ArrayList<*>");
            Object object0 = p.n0(v1, arrayList0);
            return !(object0 instanceof cmtList) || ((cmtList)object0).cmtinfo == null || ((cmtList)object0).memberinfo == null ? null : ((cmtList)object0);
        }
        return null;
    }
}

