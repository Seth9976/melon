package com.iloen.melon.player.playlist;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/iloen/melon/player/playlist/VideoPlaylistFragment$handlePlaylistState$1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lie/H;", "onGlobalLayout", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlaylistFragment.handlePlaylistState.1.1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final RecyclerView a;
    public final VideoPlaylistFragment b;
    public final int c;
    public final LinearLayoutManager d;

    public VideoPlaylistFragment.handlePlaylistState.1.1(RecyclerView recyclerView0, VideoPlaylistFragment videoPlaylistFragment0, int v, LinearLayoutManager linearLayoutManager0) {
        this.a = recyclerView0;
        this.b = videoPlaylistFragment0;
        this.c = v;
        this.d = linearLayoutManager0;
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int v = ViewUtilsKt.dpToPx(96.0f);
        int v1 = this.a.getHeight() / 2 - v / 2;
        LogConstantsKt.debugOnlyDebugMode(VideoPlaylistFragment.access$getLog$p(this.b), "scrollToPositionWithOffset() position: " + this.c + ", offset: " + v1);
        this.d.scrollToPositionWithOffset(this.c, v1);
        VideoPlaylistFragment.access$getMAdapter$p$s-1344198467(this.b).notifyDataSetChanged();
    }
}

