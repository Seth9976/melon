package com.iloen.melon.player.video;

import J8.w3;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.player.video.chat.VideoChatInputPopup.OnEventListener;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/iloen/melon/player/video/VideoChatFragment$showInputPopup$1", "Lcom/iloen/melon/player/video/chat/VideoChatInputPopup$OnEventListener;", "", "message", "Lie/H;", "onChangedText", "(Ljava/lang/String;)V", "onSendEvent", "onDismissEvent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatFragment.showInputPopup.1 implements OnEventListener {
    public final VideoChatFragment a;

    public VideoChatFragment.showInputPopup.1(VideoChatFragment videoChatFragment0) {
        this.a = videoChatFragment0;
    }

    @Override  // com.iloen.melon.player.video.chat.VideoChatInputPopup$OnEventListener
    public void onChangedText(String s) {
        q.g(s, "message");
        VideoChatFragment.access$getChatViewModel(this.a).setInputMessage(s);
    }

    @Override  // com.iloen.melon.player.video.chat.VideoChatInputPopup$OnEventListener
    public void onDismissEvent(String s) {
        q.g(s, "message");
        VideoChatFragment videoChatFragment0 = this.a;
        VideoChatFragment.access$getChatViewModel(videoChatFragment0).setInputMessage(s);
        w3 w30 = VideoChatFragment.access$get_binding$p(videoChatFragment0);
        if(w30 != null) {
            MelonTextView melonTextView0 = w30.r;
            if(melonTextView0 != null) {
                melonTextView0.setText(s);
            }
        }
        w3 w31 = VideoChatFragment.access$get_binding$p(videoChatFragment0);
        ViewUtils.showWhen((w31 == null ? null : w31.p), s.length() > 0);
    }

    @Override  // com.iloen.melon.player.video.chat.VideoChatInputPopup$OnEventListener
    public void onSendEvent(String s) {
        q.g(s, "message");
        VideoChatFragment.access$sendMessage(this.a);
    }
}

