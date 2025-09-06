package B9;

import J8.u;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.system.ScreenUtils;

public final class e extends O0 {
    public final MelonTextView a;
    public final MelonTextView b;
    public static final int c;

    static {
    }

    public e(u u0, float f) {
        super(((FrameLayout)u0.d));
        this.a = (MelonTextView)u0.e;
        this.b = (MelonTextView)u0.b;
        LinearLayout linearLayout0 = (LinearLayout)u0.c;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = linearLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            Context context0 = this.itemView.getContext();
            int v = ScreenUtils.dipToPixel(context0, 0.0f);
            int v1 = ScreenUtils.dipToPixel(context0, f);
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin, v, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin, v1);
        }
        linearLayout0.setLayoutParams(viewGroup$LayoutParams0);
    }
}

