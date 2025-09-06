package com.iloen.melon.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.fragment.app.I;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import i6.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u00002\u00020\u0001:\u00017B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0017\u00A2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b \u0010\u001FJ\u000F\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020!H\u0016\u00A2\u0006\u0004\b$\u0010#J\u000F\u0010%\u001A\u00020!H\u0016\u00A2\u0006\u0004\b%\u0010#J\u0011\u0010\'\u001A\u0004\u0018\u00010&H&\u00A2\u0006\u0004\b\'\u0010(R(\u0010*\u001A\b\u0012\u0002\b\u0003\u0018\u00010)8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001A\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u00102\u001A\u0004\b3\u00104\"\u0004\b5\u00106\u00A8\u00068"}, d2 = {"Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "Li6/d;", "<init>", "()V", "Lie/H;", "addFragment", "hideStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "it", "onDialogShow", "(Landroid/content/DialogInterface;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "", "getPeekHeight", "()I", "getTitleBarHeight", "", "useTransparentBackground", "()Z", "useDirectExpand", "isHideStatusBar", "Landroidx/fragment/app/I;", "newFragment", "()Landroidx/fragment/app/I;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment$OnDismissListener;", "dismissListener", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment$OnDismissListener;", "getDismissListener", "()Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment$OnDismissListener;", "setDismissListener", "(Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment$OnDismissListener;)V", "OnDismissListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MelonBottomSheetBaseFragment extends d {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment$OnDismissListener;", "", "Lie/H;", "dismiss", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnDismissListener {
        void dismiss();
    }

    public static final int $stable = 8;
    @Nullable
    private BottomSheetBehavior behavior;
    @Nullable
    private OnDismissListener dismissListener;

    private final void addFragment() {
        I i0 = this.newFragment();
        if(i0 != null) {
            l0 l00 = this.getChildFragmentManager();
            a a0 = o.f(l00, l00);
            a0.e(0x7F0A04DD, i0, this.getTag(), 1);  // id:fragment_container
            if(a0.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            a0.h = false;
            a0.r.A(a0, true);
        }
    }

    @Nullable
    public final BottomSheetBehavior getBehavior() {
        return this.behavior;
    }

    @Nullable
    public final OnDismissListener getDismissListener() {
        return this.dismissListener;
    }

    public int getPeekHeight() {
        return 0;
    }

    public int getTitleBarHeight() {
        return 0;
    }

    private final void hideStatusBar() {
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.setFlags(0x400, 0x400);
            }
        }
    }

    public boolean isHideStatusBar() {
        return false;
    }

    @Nullable
    public abstract I newFragment();

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setStyle(0, 0x7F140188);  // style:MelonBottomSheetDialog
    }

    @Override  // i6.d
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle0) {
        Dialog dialog0 = super.onCreateDialog(bundle0);
        q.e(dialog0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        ((BottomSheetDialog)dialog0).setOnShowListener(new v(this));
        return (BottomSheetDialog)dialog0;
    }

    private static final void onCreateDialog$lambda$0(MelonBottomSheetBaseFragment melonBottomSheetBaseFragment0, DialogInterface dialogInterface0) {
        q.d(dialogInterface0);
        melonBottomSheetBaseFragment0.onDialogShow(dialogInterface0);
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0299, viewGroup0, false);  // layout:fragment_bottom_sheet_base
        int v = this.getTitleBarHeight();
        if(v > 0) {
            RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(0x7F0A031D);  // id:container_bottom_sheet
            RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-1, -2);
            relativeLayout$LayoutParams0.topMargin = v;
            relativeLayout0.setLayoutParams(relativeLayout$LayoutParams0);
        }
        if(view0 != null) {
            view0.setOnClickListener(new u(this, 0));
        }
        if(this.isHideStatusBar()) {
            this.hideStatusBar();
        }
        return view0;
    }

    private static final void onCreateView$lambda$1(MelonBottomSheetBaseFragment melonBottomSheetBaseFragment0, View view0) {
        melonBottomSheetBaseFragment0.dismiss();
    }

    public void onDialogShow(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "it");
        View view0 = null;
        BottomSheetDialog bottomSheetDialog0 = dialogInterface0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialogInterface0) : null;
        if(bottomSheetDialog0 != null) {
            view0 = bottomSheetDialog0.findViewById(0x7F0A03B3);  // id:design_bottom_sheet
        }
        q.e(view0, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.behavior = BottomSheetBehavior.D(((FrameLayout)view0));
        if(this.useDirectExpand()) {
            BottomSheetBehavior bottomSheetBehavior0 = this.behavior;
            if(bottomSheetBehavior0 != null) {
                bottomSheetBehavior0.M(3);
            }
            BottomSheetBehavior bottomSheetBehavior1 = this.behavior;
            if(bottomSheetBehavior1 != null) {
                bottomSheetBehavior1.f0 = true;
            }
            if(bottomSheetBehavior1 != null) {
                bottomSheetBehavior1.K(true);
            }
        }
        int v = this.getPeekHeight();
        if(v > 0) {
            BottomSheetBehavior bottomSheetBehavior2 = this.behavior;
            if(bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.L(v);
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        super.onPause();
        OnDismissListener melonBottomSheetBaseFragment$OnDismissListener0 = this.dismissListener;
        if(melonBottomSheetBaseFragment$OnDismissListener0 != null) {
            melonBottomSheetBaseFragment$OnDismissListener0.dismiss();
        }
        this.dismiss();
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.addFragment();
    }

    public final void setBehavior(@Nullable BottomSheetBehavior bottomSheetBehavior0) {
        this.behavior = bottomSheetBehavior0;
    }

    public final void setDismissListener(@Nullable OnDismissListener melonBottomSheetBaseFragment$OnDismissListener0) {
        this.dismissListener = melonBottomSheetBaseFragment$OnDismissListener0;
    }

    public boolean useDirectExpand() {
        return false;
    }

    public boolean useTransparentBackground() {
        return false;
    }
}

