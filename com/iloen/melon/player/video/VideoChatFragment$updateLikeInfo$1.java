package com.iloen.melon.player.video;

import android.view.View;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"com/iloen/melon/player/video/VideoChatFragment$updateLikeInfo$1", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "Lie/H;", "onStartAsyncTask", "()V", "", "errorMsg", "", "sumCount", "", "isLike", "onJobComplete", "(Ljava/lang/String;IZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatFragment.updateLikeInfo.1 implements OnJobFinishListener {
    public final View a;
    public final VideoChatFragment b;

    public VideoChatFragment.updateLikeInfo.1(View view0, VideoChatFragment videoChatFragment0) {
        this.a = view0;
        this.b = videoChatFragment0;
    }

    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
    public void onJobComplete(String s, int v, boolean z) {
        q.g(s, "errorMsg");
        this.a.setEnabled(true);
        this.a.setClickable(true);
        VideoChatFragment videoChatFragment0 = this.b;
        if(!videoChatFragment0.isFragmentValid() || s.length() > 0) {
            return;
        }
        VideoChatFragment.access$getLiveViewModel(videoChatFragment0).updateLiked(z);
    }

    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
    public void onStartAsyncTask() {
        this.a.setEnabled(false);
        this.a.setClickable(false);
    }
}

