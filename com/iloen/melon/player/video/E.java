package com.iloen.melon.player.video;

import J8.w3;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.USER;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response;
import com.iloen.melon.player.video.chat.ChatUi.ErrorView;
import com.iloen.melon.player.video.chat.VideoChatInputPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.jvm.internal.q;

public final class e implements View.OnClickListener {
    public final int a;
    public final VideoChatFragment b;

    public e(VideoChatFragment videoChatFragment0, int v) {
        this.a = v;
        this.b = videoChatFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        VideoChatFragment videoChatFragment0 = this.b;
        switch(this.a) {
            case 0: {
                videoChatFragment0.i0();
                w3 w31 = videoChatFragment0.f;
                q.d(w31);
                ViewUtils.hideWhen(w31.p, true);
                return;
            }
            case 1: {
                videoChatFragment0.f0().clickCheerBtn();
                return;
            }
            case 2: {
                w3 w32 = this.b.f;
                q.d(w32);
                int v = this.b.getAdapter().getItemCount();
                w32.o.scrollToPosition(v - 1);
                VideoChatFragment.j0(this.b, null, "갱신", null, null, null, null, 61);
                return;
            }
            case 3: {
                videoChatFragment0.f0().closeFullChat();
                ToastManager.show(0x7F130624);  // string:melon_tv_live_chat_off "채팅을 껐습니다."
                return;
            }
            default: {
                VideoChatFragment videoChatFragment1 = this.b;
                String s = null;
                if(videoChatFragment1.e0().isEnableSendMessage()) {
                    videoChatFragment1.getRecyclerView().scrollToPosition(videoChatFragment1.getAdapter().getItemCount() - 1);
                    w3 w30 = videoChatFragment1.f;
                    q.d(w30);
                    String s1 = w30.r.getText().toString();
                    Context context0 = videoChatFragment1.requireContext();
                    q.f(context0, "requireContext(...)");
                    Response liveChatRes$Response0 = (Response)videoChatFragment1.e0().getResponse().getValue();
                    if(liveChatRes$Response0 != null) {
                        CHATSDKINFO liveChatRes$Response$CHATSDKINFO0 = liveChatRes$Response0.chatSdkInfo;
                        if(liveChatRes$Response$CHATSDKINFO0 != null) {
                            USER liveChatRes$Response$CHATSDKINFO$USER0 = liveChatRes$Response$CHATSDKINFO0.user;
                            if(liveChatRes$Response$CHATSDKINFO$USER0 != null) {
                                s = liveChatRes$Response$CHATSDKINFO$USER0.imgUrl;
                            }
                        }
                    }
                    VideoChatInputPopup videoChatInputPopup0 = new VideoChatInputPopup(context0, s1, s, videoChatFragment1.d, new VideoChatFragment.showInputPopup.1(videoChatFragment1));
                    videoChatInputPopup0.setOnShowListener(new o(videoChatFragment1));
                    videoChatInputPopup0.setOnDismissListener(new p(videoChatFragment1));
                    videoChatInputPopup0.show();
                    videoChatFragment1.e = videoChatInputPopup0;
                }
                else {
                    ErrorView chatUi$ErrorView0 = videoChatFragment1.g instanceof ErrorView ? ((ErrorView)videoChatFragment1.g) : null;
                    if(chatUi$ErrorView0 != null) {
                        s = chatUi$ErrorView0.getInputPopupMessage();
                    }
                    MelonTextPopup melonTextPopup0 = new MelonTextPopup(videoChatFragment1.getActivity(), 1);
                    melonTextPopup0.setTitleName(videoChatFragment1.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                    if(s == null) {
                        s = "채팅 권한이 없어 \n채팅 입력이 불가합니다.";
                        q.f("채팅 권한이 없어 \n채팅 입력이 불가합니다.", "getString(...)");
                    }
                    melonTextPopup0.setBodyMsg(s);
                    melonTextPopup0.setPopupOnClickListener(new h(melonTextPopup0, 1));
                    melonTextPopup0.show();
                }
                VideoChatFragment.j0(videoChatFragment1, null, "입력", null, null, null, null, 61);
            }
        }
    }
}

