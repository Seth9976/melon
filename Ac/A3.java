package Ac;

import J8.u;
import J8.v;
import android.text.Editable;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.comments.CommentInputPopup.OnEventListener;
import kotlin.jvm.internal.q;

public final class a3 implements OnEventListener {
    public final j3 a;

    public a3(j3 j30) {
        this.a = j30;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
    public final void onDismissEvent(Editable editable0) {
        q.g(editable0, "message");
        j3 j30 = this.a;
        v v0 = (v)j30.getBinding();
        if(v0 != null) {
            u u0 = v0.b;
            if(u0 != null) {
                MelonEditText melonEditText0 = (MelonEditText)u0.d;
                if(melonEditText0 != null) {
                    melonEditText0.setText(editable0);
                }
            }
        }
        v v1 = (v)j30.getBinding();
        if(v1 != null) {
            u u1 = v1.b;
            if(u1 != null) {
                MelonTextView melonTextView0 = (MelonTextView)u1.b;
                if(melonTextView0 != null) {
                    melonTextView0.setEnabled(editable0.length() > 0);
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
    public final void onSendEvent(String s) {
        q.g(s, "message");
        this.a.performRegister(s);
    }
}

