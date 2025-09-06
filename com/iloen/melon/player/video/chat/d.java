package com.iloen.melon.player.video.chat;

import android.text.Editable;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.KeyEventEditText;
import kotlin.jvm.internal.q;

public final class d implements View.OnClickListener {
    public final int a;
    public final VideoChatInputPopup b;

    public d(VideoChatInputPopup videoChatInputPopup0, int v) {
        this.a = v;
        this.b = videoChatInputPopup0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        VideoChatInputPopup videoChatInputPopup0 = this.b;
        if(this.a != 0) {
            videoChatInputPopup0.dismiss();
            return;
        }
        OnEventListener videoChatInputPopup$OnEventListener0 = videoChatInputPopup0.d;
        KeyEventEditText keyEventEditText0 = videoChatInputPopup0.f;
        if(keyEventEditText0 != null) {
            videoChatInputPopup$OnEventListener0.onSendEvent(keyEventEditText0.getText().toString());
            KeyEventEditText keyEventEditText1 = videoChatInputPopup0.f;
            if(keyEventEditText1 != null) {
                Editable editable0 = keyEventEditText1.getText();
                if(editable0 != null) {
                    editable0.clear();
                }
                videoChatInputPopup0.dismiss();
                return;
            }
            q.m("edMessage");
            throw null;
        }
        q.m("edMessage");
        throw null;
    }
}

