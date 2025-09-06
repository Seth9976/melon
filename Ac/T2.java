package Ac;

import a9.a;
import android.text.Editable;
import com.iloen.melon.fragments.comments.CommentInputPopup.OnEventListener;
import kotlin.jvm.internal.q;

public final class t2 implements OnEventListener {
    public final v2 a;

    public t2(v2 v20) {
        this.a = v20;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
    public final void onDismissEvent(Editable editable0) {
        q.g(editable0, "message");
        N2 n20 = (N2)this.a.getViewModel();
        String s = editable0.toString();
        n20.getClass();
        q.g(s, "text");
        n20.i.setValue(s);
        n20.c.b(s, "key_cmt_reply_input_text");
    }

    @Override  // com.iloen.melon.fragments.comments.CommentInputPopup$OnEventListener
    public final void onSendEvent(String s) {
        q.g(s, "message");
        R1 r10 = new R1(s, this.a.getParentFragment() instanceof a);
        this.a.sendUserEvent(r10);
    }
}

