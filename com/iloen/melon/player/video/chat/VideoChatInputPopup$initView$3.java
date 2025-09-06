package com.iloen.melon.player.video.chat;

import Tf.n;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.iloen.melon.custom.KeyEventEditText;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00072\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\rR\u0017\u0010\u0018\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"com/iloen/melon/player/video/chat/VideoChatInputPopup$initView$3", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "p0", "Lie/H;", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "p1", "p2", "p3", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "text", "start", "before", "count", "onTextChanged", "LTf/n;", "a", "LTf/n;", "getNewLine", "()LTf/n;", "newLine", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatInputPopup.initView.3 implements TextWatcher {
    public final n a;
    public final VideoChatInputPopup b;

    public VideoChatInputPopup.initView.3(VideoChatInputPopup videoChatInputPopup0) {
        this.b = videoChatInputPopup0;
        this.a = new n("\\n");
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    public final n getNewLine() {
        return this.a;
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        VideoChatInputPopup videoChatInputPopup0 = this.b;
        videoChatInputPopup0.getOnEventListener().onChangedText(String.valueOf(charSequence0));
        boolean z = true;
        if(charSequence0 != null) {
            n n0 = this.a;
            if(n0.a.matcher(charSequence0).find()) {
                String s = n0.c(charSequence0, "");
                KeyEventEditText keyEventEditText0 = videoChatInputPopup0.f;
                if(keyEventEditText0 != null) {
                    keyEventEditText0.setText(s);
                    KeyEventEditText keyEventEditText1 = videoChatInputPopup0.f;
                    if(keyEventEditText1 != null) {
                        keyEventEditText1.setSelection(s.length());
                        goto label_18;
                    }
                    q.m("edMessage");
                    throw null;
                }
                q.m("edMessage");
                throw null;
            }
        }
    label_18:
        TextView textView0 = videoChatInputPopup0.g;
        if(textView0 != null) {
            if(charSequence0 == null || charSequence0.length() <= 0) {
                z = false;
            }
            ViewUtils.showWhen(textView0, z);
            return;
        }
        q.m("textSend");
        throw null;
    }
}

