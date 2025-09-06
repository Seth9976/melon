package com.iloen.melon.player.video.chat;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import com.iloen.melon.custom.KeyEventEditText;
import kotlin.jvm.internal.q;

public final class c implements TextView.OnEditorActionListener {
    public final VideoChatInputPopup a;

    public c(VideoChatInputPopup videoChatInputPopup0) {
        this.a = videoChatInputPopup0;
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public final boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        if(v == 4) {
            VideoChatInputPopup videoChatInputPopup0 = this.a;
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
                    return true;
                }
                q.m("edMessage");
                throw null;
            }
            q.m("edMessage");
            throw null;
        }
        return true;
    }
}

