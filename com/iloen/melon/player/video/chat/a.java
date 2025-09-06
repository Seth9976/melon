package com.iloen.melon.player.video.chat;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.USER;
import com.kakaoent.leonchat.data.messages.InputMessage;
import com.kakaoent.leonchat.data.messages.MessageEntity;
import kotlin.jvm.internal.H;

public final class a implements View.OnLongClickListener {
    public final int a;
    public final H b;
    public final boolean c;
    public final boolean d;
    public final ChatAdapter e;
    public final MessageEntity f;

    public a(H h0, boolean z, boolean z1, ChatAdapter chatAdapter0, InputMessage inputMessage0, int v) {
        this.a = v;
        this.b = h0;
        this.c = z;
        this.d = z1;
        this.e = chatAdapter0;
        this.f = inputMessage0;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        MessageEntity messageEntity0 = this.f;
        ChatAdapter chatAdapter0 = this.e;
        boolean z = this.d;
        boolean z1 = this.c;
        H h0 = this.b;
        if(this.a != 0) {
            USER liveChatRes$Response$CHATSDKINFO$USER0 = (USER)h0.a;
            if(liveChatRes$Response$CHATSDKINFO$USER0 != null && !z1 && !z) {
                OnItemLongClickListener chatAdapter$OnItemLongClickListener0 = chatAdapter0.d;
                if(chatAdapter$OnItemLongClickListener0 != null) {
                    chatAdapter$OnItemLongClickListener0.onItemLongClick(((InputMessage)messageEntity0), liveChatRes$Response$CHATSDKINFO$USER0);
                }
            }
            return true;
        }
        USER liveChatRes$Response$CHATSDKINFO$USER1 = (USER)h0.a;
        if(liveChatRes$Response$CHATSDKINFO$USER1 != null && !z1 && !z) {
            OnItemLongClickListener chatAdapter$OnItemLongClickListener1 = chatAdapter0.d;
            if(chatAdapter$OnItemLongClickListener1 != null) {
                chatAdapter$OnItemLongClickListener1.onItemLongClick(((InputMessage)messageEntity0), liveChatRes$Response$CHATSDKINFO$USER1);
            }
        }
        return true;
    }
}

