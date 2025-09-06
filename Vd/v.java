package vd;

import Nc.f;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.iloen.melon.custom.BottomDetectableScrollView;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.a0;
import i.n.i.b.a.s.e.u9;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import pc.t;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lvd/v;", "Lcom/melon/ui/a0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class v extends a0 {
    public int e;
    public String f;
    public TextView g;
    public BottomDetectableScrollView h;
    public ImageView i;
    public boolean j;
    public f k;
    public boolean l;
    public boolean m;
    public View n;
    public final u o;

    public v() {
        this.e = 0x7F0D0192;  // layout:common_popup_layout
        this.j = true;
        this.l = true;
        this.m = true;
        this.o = new u(this);
    }

    public final void m(boolean z, boolean z1) {
        float f;
        Context context0;
        BottomDetectableScrollView bottomDetectableScrollView0 = this.n == null ? null : ((BottomDetectableScrollView)this.n.findViewById(0x7F0A0110));  // id:body_text_container
        if(bottomDetectableScrollView0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = bottomDetectableScrollView0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            if(z) {
                context0 = this.getContext();
                f = 290.0f;
            }
            else {
                context0 = this.getContext();
                f = 140.0f;
            }
            ((LayoutParams)viewGroup$LayoutParams0).Q = ScreenUtils.dipToPixel(context0, f);
            bottomDetectableScrollView0.setLayoutParams(((LayoutParams)viewGroup$LayoutParams0));
            if(z1) {
                bottomDetectableScrollView0.requestLayout();
            }
        }
    }

    @Override  // androidx.fragment.app.w
    public final void onCancel(DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onCancel(dialogInterface0);
    }

    @Override  // com.melon.ui.a0
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.m(ScreenUtils.isPortrait(this.getContext()), true);
    }

    @Override  // com.melon.ui.a0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setCancelable(this.j);
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            dialog0.setOnKeyListener(this.o);
        }
        View view0 = layoutInflater0.inflate(this.e, viewGroup0, false);
        this.n = view0;
        return view0;
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                if(window0.getAttributes() != null) {
                    WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                    windowManager$LayoutParams0.width = ViewUtilsKt.dpToPx(270);
                }
                window0.setAttributes(window0.getAttributes());
            }
        }
    }

    @Override  // com.melon.ui.a0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        String s = this.f;
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
        this.m(ScreenUtils.isPortrait(this.getContext()), false);
        FrameLayout frameLayout0 = null;
        TextView textView0 = this.n == null ? null : ((TextView)this.n.findViewById(0x7F0A0CEA));  // id:tv_popup_title
        if(textView0 != null) {
            if(s == null || s.length() == 0) {
                textView0.setVisibility(8);
            }
            else {
                textView0.setText(s);
            }
        }
        this.i = this.n == null ? null : ((ImageView)this.n.findViewById(0x7F0A066E));  // id:iv_popup_bottom_shadow
        BottomDetectableScrollView bottomDetectableScrollView0 = this.n == null ? null : ((BottomDetectableScrollView)this.n.findViewById(0x7F0A0110));  // id:body_text_container
        this.h = bottomDetectableScrollView0;
        if(bottomDetectableScrollView0 != null) {
            bottomDetectableScrollView0.setOnScrollListener(new t(this, 28));
            bottomDetectableScrollView0.postDelayed(new u9(this, 21), 50L);
        }
        TextView textView1 = this.n == null ? null : ((TextView)this.n.findViewById(0x7F0A0CE6));  // id:tv_popup_body
        this.g = textView1;
        if(textView1 != null) {
            textView1.setVisibility(8);
        }
        TextView textView2 = this.n == null ? null : ((TextView)this.n.findViewById(0x7F0A0193));  // id:btn_popup_left
        if(textView2 != null) {
            if(this.l) {
                textView2.setVisibility(8);
            }
            else {
                textView2.setText(textView2.getText());
                textView2.setOnClickListener(new vd.t(this, 0));
                ViewUtils.setContentDescriptionWithButtonClassName(textView2, textView2.getText());
            }
        }
        TextView textView3 = this.n == null ? null : ((TextView)this.n.findViewById(0x7F0A0190));  // id:btn_popup_center
        if(textView3 != null) {
            if(this.m) {
                textView3.setVisibility(8);
            }
            else {
                textView3.setText(textView3.getText());
                textView3.setOnClickListener(new vd.t(this, 1));
                ViewUtils.setContentDescriptionWithButtonClassName(textView3, textView3.getText());
            }
        }
        TextView textView4 = this.n == null ? null : ((TextView)this.n.findViewById(0x7F0A0196));  // id:btn_popup_right
        if(textView4 != null) {
            textView4.setText(textView4.getText());
            textView4.setOnClickListener(new vd.t(this, 2));
            ViewUtils.setContentDescriptionWithButtonClassName(textView4, textView4.getText());
        }
        View view1 = this.n;
        if(view1 != null) {
            frameLayout0 = (FrameLayout)view1.findViewById(0x7F0A010F);  // id:body_frame_layout
        }
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(8);
        }
    }
}

