package Ac;

import J8.t;
import J8.u;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.comments.CommentInputPopup;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class q2 extends i implements n {
    public Object r;
    public final v2 w;

    public q2(v2 v20, Continuation continuation0) {
        this.w = v20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q2(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((q2)this.create(((String)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s = (String)this.r;
        d5.n.D(object0);
        v2 v20 = this.w;
        t t0 = (t)v20.getBinding();
        if(t0 != null) {
            u u0 = t0.b;
            if(u0 != null) {
                MelonEditText melonEditText0 = (MelonEditText)u0.d;
                melonEditText0.setText(s);
                boolean z = s.length() > 0;
                ((MelonTextView)u0.b).setEnabled(z);
                CommentInputPopup commentInputPopup0 = v20.j;
                if(commentInputPopup0 != null) {
                    commentInputPopup0.setInputText(melonEditText0.getText());
                }
            }
        }
        return H.a;
    }
}

