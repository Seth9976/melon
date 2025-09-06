package Fd;

import J8.N2;
import Tf.o;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import p8.g;

public final class j implements View.OnClickListener {
    public final int a;
    public final D b;
    public final MelonEditText c;

    public j(D d0, MelonEditText melonEditText0) {
        this.a = 1;
        super();
        this.b = d0;
        this.c = melonEditText0;
    }

    public j(MelonEditText melonEditText0, D d0) {
        this.a = 0;
        super();
        this.c = melonEditText0;
        this.b = d0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            String s = String.valueOf(this.c.getText());
            D d0 = this.b;
            if(s.length() == 0 || o.H0(s)) {
                d0.sendUserEvent(K.a);
                return;
            }
            LogU.debug$default(d0.b, "performSearch - hide", null, false, 6, null);
            InputMethodManager inputMethodManager0 = (InputMethodManager)d0.d.getValue();
            N2 n20 = (N2)d0.getBinding();
            String s1 = null;
            inputMethodManager0.hideSoftInputFromWindow((n20 == null ? null : n20.e.getWindowToken()), 0);
            N2 n21 = (N2)d0.getBinding();
            if(n21 != null) {
                n21.e.clearFocus();
            }
            d0.sendUserEvent(new L(s, false));
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = d0.getContext() == null ? null : "페이지이동";
            g0.b = d0.getContext() == null ? null : "멜론홈탭";
            Context context0 = d0.getContext();
            g0.c = context0 == null || context0.getResources() == null ? null : "멜론홈탭_탐색";
            g0.d = ActionKind.Search;
            if(d0.getContext() != null) {
                s1 = "검색";
            }
            g0.y = s1;
            g0.X = s;
            g0.Y = "btn";
            g0.a().track();
            return;
        }
        this.c.setText(null);
        this.b.sendUserEvent(J.a);
        this.c.requestFocus();
        ((InputMethodManager)this.b.d.getValue()).showSoftInput(this.c, 0);
    }
}

