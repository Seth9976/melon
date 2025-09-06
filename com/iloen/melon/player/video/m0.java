package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.utils.system.ToastManager;

public final class m0 implements View.OnClickListener {
    public final int a;
    public final VideoPlayerLiveFragment b;

    public m0(VideoPlayerLiveFragment videoPlayerLiveFragment0, int v) {
        this.a = v;
        this.b = videoPlayerLiveFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        VideoPlayerLiveFragment videoPlayerLiveFragment0 = this.b;
        switch(this.a) {
            case 0: {
                videoPlayerLiveFragment0.o0();
                return;
            }
            case 1: {
                if(!((Boolean)videoPlayerLiveFragment0.getLiveViewModel().isFullChatEnable().getValue()).booleanValue()) {
                    videoPlayerLiveFragment0.getLiveViewModel().openAndShowFullChat();
                    ToastManager.show(0x7F130625);  // string:melon_tv_live_chat_on "채팅을 켰습니다."
                    videoPlayerLiveFragment0.sendTiaraLogPlayer(0x7F130D6D, TiaraLogType.SHOW_CHAT, true);  // string:tiara_click_copy_player_chat "채팅"
                    return;
                }
                videoPlayerLiveFragment0.getLiveViewModel().closeFullChat();
                ToastManager.show(0x7F130624);  // string:melon_tv_live_chat_off "채팅을 껐습니다."
                videoPlayerLiveFragment0.sendTiaraLogPlayer(0x7F130D6D, TiaraLogType.SHOW_CHAT, false);  // string:tiara_click_copy_player_chat "채팅"
                return;
            }
            case 2: {
                videoPlayerLiveFragment0.getLiveViewModel().clickCheerBtn();
                return;
            }
            default: {
                videoPlayerLiveFragment0.o0();
            }
        }
    }
}

