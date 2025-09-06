package vd;

import Ad.n;
import De.I;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.color.ColorUtils;
import java.util.List;
import kotlin.jvm.internal.q;
import td.L;

public final class x extends j0 {
    public final List a;
    public final boolean b;
    public final int c;
    public final L d;

    public x(List list0, boolean z, int v, L l0) {
        q.g(list0, "listItems");
        super();
        this.a = list0;
        this.b = z;
        this.c = v;
        this.d = l0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        return this.a.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        q.g(((y)o00), "holder");
        String s = (String)this.a.get(v);
        q.g(s, "text");
        MelonTextView melonTextView0 = (MelonTextView)((y)o00).a.d;
        ImageView imageView0 = (ImageView)((y)o00).a.c;
        melonTextView0.setText(s);
        ConstraintLayout constraintLayout0 = (ConstraintLayout)((y)o00).a.b;
        constraintLayout0.setOnClickListener(new n(this.d, v, ((y)o00), 18));
        if(this.b) {
            if(v == this.c) {
                imageView0.setVisibility(0);
                melonTextView0.setTextColor(ColorUtils.getColor(constraintLayout0.getContext(), 0x7F06017C));  // color:green500s_support_high_contrast
                return;
            }
            imageView0.setVisibility(8);
            melonTextView0.setTextColor(ColorUtils.getColor(constraintLayout0.getContext(), 0x7F060169));  // color:gray850s
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        View view0 = o.e(viewGroup0, 0x7F0D0194, viewGroup0, false);  // layout:common_text_popup_listitem
        int v1 = 0x7F0A0610;  // id:iv_check
        ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0610);  // id:iv_check
        if(imageView0 != null) {
            v1 = 0x7F0A0B49;  // id:text
            MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0B49);  // id:text
            if(melonTextView0 != null) {
                return new y(new J8.x(((ConstraintLayout)view0), imageView0, melonTextView0, 0));
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }
}

