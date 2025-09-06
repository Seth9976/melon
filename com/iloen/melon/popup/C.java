package com.iloen.melon.popup;

import De.I;
import J8.B2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;
import ie.H;
import we.a;

public final class c implements a {
    public final int a;
    public final Object b;

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((CommonFilterPopup)object0).dismiss();
                return h0;
            }
            case 1: {
                ((DjSelectionPopup)object0).dismiss();
                return h0;
            }
            default: {
                View view0 = LayoutInflater.from(((Context)object0)).inflate(0x7F0D0573, null, false);  // layout:new_melon_base_popup_layout
                int v = 0x7F0A0335;  // id:content
                View view1 = I.C(view0, 0x7F0A0335);  // id:content
                if(((FrameLayout)view1) != null) {
                    v = 0x7F0A070A;  // id:layout_close
                    View view2 = I.C(view0, 0x7F0A070A);  // id:layout_close
                    if(((LinearLayout)view2) != null) {
                        v = 0x7F0A094F;  // id:popup_close
                        View view3 = I.C(view0, 0x7F0A094F);  // id:popup_close
                        if(((MelonTextView)view3) != null) {
                            v = 0x7F0A0950;  // id:popup_container
                            View view4 = I.C(view0, 0x7F0A0950);  // id:popup_container
                            if(((ConstraintLayout)view4) != null) {
                                v = 0x7F0A0D6B;  // id:underline
                                View view5 = I.C(view0, 0x7F0A0D6B);  // id:underline
                                if(view5 != null) {
                                    return new B2(((ConstraintLayout)view0), ((FrameLayout)view1), ((LinearLayout)view2), ((MelonTextView)view3), ((ConstraintLayout)view4), ((ConstraintLayout)view0), view5);
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
            }
        }
    }
}

