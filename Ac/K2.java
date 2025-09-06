package Ac;

import J8.t;
import J8.u;
import J8.v;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.I;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import i6.b;
import kotlin.jvm.internal.q;
import vd.S;
import vd.T;
import zd.h;

public final class k2 implements DialogInterface.OnShowListener {
    public final int a;
    public final I b;

    public k2(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface0) {
        switch(this.a) {
            case 0: {
                t t0 = (t)((v2)this.b).getBinding();
                if(t0 != null) {
                    u u0 = t0.b;
                    if(u0 != null) {
                        LinearLayout linearLayout0 = (LinearLayout)u0.c;
                        if(linearLayout0 != null) {
                            linearLayout0.setVisibility(8);
                        }
                    }
                }
                return;
            }
            case 1: {
                v v0 = (v)((j3)this.b).getBinding();
                if(v0 != null) {
                    u u1 = v0.b;
                    if(u1 != null) {
                        LinearLayout linearLayout1 = (LinearLayout)u1.c;
                        if(linearLayout1 != null) {
                            linearLayout1.setVisibility(8);
                        }
                    }
                }
                return;
            }
            case 2: {
                T t1 = (T)this.b;
                q.d(dialogInterface0);
                t1.getClass();
                View view1 = null;
                BottomSheetDialog bottomSheetDialog1 = dialogInterface0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialogInterface0) : null;
                if(bottomSheetDialog1 != null) {
                    view1 = bottomSheetDialog1.findViewById(0x7F0A03B3);  // id:design_bottom_sheet
                }
                q.e(view1, "null cannot be cast to non-null type android.widget.FrameLayout");
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.D(((FrameLayout)view1));
                t1.g = bottomSheetBehavior2;
                if(bottomSheetBehavior2 != null) {
                    bottomSheetBehavior2.w(new S());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                BottomSheetBehavior bottomSheetBehavior3 = t1.g;
                if(bottomSheetBehavior3 != null) {
                    bottomSheetBehavior3.M(4);
                }
                BottomSheetBehavior bottomSheetBehavior4 = t1.g;
                if(bottomSheetBehavior4 != null) {
                    bottomSheetBehavior4.f0 = t1.f;
                }
                if(bottomSheetBehavior4 != null) {
                    bottomSheetBehavior4.K(true);
                }
                BottomSheetBehavior bottomSheetBehavior5 = t1.g;
                if(bottomSheetBehavior5 != null) {
                    bottomSheetBehavior5.g0 = true;
                }
                if(bottomSheetBehavior5 != null) {
                    bottomSheetBehavior5.J(true);
                }
                BottomSheetBehavior bottomSheetBehavior6 = t1.g;
                if(bottomSheetBehavior6 != null) {
                    bottomSheetBehavior6.L(t1.d);
                }
                return;
            }
            default: {
                h h0 = (h)this.b;
                q.d(dialogInterface0);
                FrameLayout frameLayout0 = null;
                BottomSheetDialog bottomSheetDialog0 = dialogInterface0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialogInterface0) : null;
                View view0 = bottomSheetDialog0 == null ? null : bottomSheetDialog0.findViewById(0x7F0A03B3);  // id:design_bottom_sheet
                if(view0 instanceof FrameLayout) {
                    frameLayout0 = (FrameLayout)view0;
                }
                if(frameLayout0 != null) {
                    BottomSheetBehavior bottomSheetBehavior0 = BottomSheetBehavior.D(frameLayout0);
                    h0.e = bottomSheetBehavior0;
                    if(bottomSheetBehavior0 != null) {
                        bottomSheetBehavior0.w(new b(h0, 2));
                    }
                    BottomSheetBehavior bottomSheetBehavior1 = h0.e;
                    if(bottomSheetBehavior1 != null) {
                        bottomSheetBehavior1.M(4);
                        bottomSheetBehavior1.f0 = h0.h;
                        bottomSheetBehavior1.K(true);
                        bottomSheetBehavior1.g0 = true;
                        bottomSheetBehavior1.L(h0.d);
                        bottomSheetBehavior1.J(true);
                    }
                }
            }
        }
    }
}

