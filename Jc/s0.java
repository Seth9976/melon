package Jc;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.fragments.detail.viewholder.LyricHolder.InnerLyricAdapter;
import com.kakao.emoticon.ui.widget.EmoticonView;
import we.a;

public final class s0 implements View.OnLongClickListener {
    public final int a;
    public final Object b;

    public s0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        switch(this.a) {
            case 0: {
                a a0 = ((X)this.b).D;
                if(a0 != null) {
                    a0.invoke();
                }
                return true;
            }
            case 1: {
                return InnerLyricAdapter.onBindViewHolder$lambda$6$lambda$4(((InnerLyricAdapter)this.b), view0);
            }
            default: {
                return ((EmoticonView)this.b).lambda$init$0(view0);
            }
        }
    }
}

