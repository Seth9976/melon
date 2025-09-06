package com.iloen.melon.popup;

import Q0.t0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iloen.melon.fragments.MelonBaseFragment;
import i6.d;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u0015\u0010\u001B\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u0019¢\u0006\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/popup/CommonFilterPopup;", "Li6/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "onPause", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "fragment", "setDismissFragment", "(Lcom/iloen/melon/fragments/MelonBaseFragment;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommonFilterPopup extends d {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0086\u0003\u0018\u00002\u00020\u0001Jo\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\"\b\u0002\u0010\u000E\u001A\u001C\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u0005\u001A\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u001C\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u0018R\u0016\u0010\u001B\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u0018R\u0016\u0010\u001C\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u0018R0\u0010\u000E\u001A\u001C\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/popup/CommonFilterPopup$Companion;", "", "", "titleResId", "", "listType", "", "Lv9/j;", "filterList", "oneDepthSelectedIndex", "twoDepthSelectedIndex", "threeDepthSelectedIndex", "Lkotlin/Function3;", "Lie/H;", "onFilterSelectionListener", "Lcom/iloen/melon/popup/CommonFilterPopup;", "newInstance", "(ILjava/lang/String;Ljava/util/List;IIILwe/o;)Lcom/iloen/melon/popup/CommonFilterPopup;", "TAG", "Ljava/lang/String;", "LIST_TYPE_DEPTH_ONE_BASIC", "LIST_TYPE_DEPTH_TWO_HORIZONTAL", "LIST_TYPE_DEPTH_TWO_ALYAC", "LIST_TYPE_DEPTH_THREE", "I", "Ljava/util/List;", "prevOneDepthSelectedIndex", "prevTwoDepthSelectedIndex", "prevThreeDepthSelectedIndex", "Lwe/o;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CommonFilterPopup newInstance(int v, @NotNull String s, @NotNull List list0, int v1, int v2, int v3, @Nullable o o0) {
            q.g(s, "listType");
            q.g(list0, "filterList");
            CommonFilterPopup.b = v;
            CommonFilterPopup.c = s;
            CommonFilterPopup.d = list0;
            CommonFilterPopup.e = v1;
            CommonFilterPopup.f = v2;
            CommonFilterPopup.g = v3;
            CommonFilterPopup.h = o0;
            return new CommonFilterPopup();
        }

        public static CommonFilterPopup newInstance$default(Companion commonFilterPopup$Companion0, int v, String s, List list0, int v1, int v2, int v3, o o0, int v4, Object object0) {
            if((v4 & 8) != 0) {
                v1 = 0;
            }
            if((v4 & 16) != 0) {
                v2 = 0;
            }
            if((v4 & 0x20) != 0) {
                v3 = 0;
            }
            if((v4 & 0x40) != 0) {
                o0 = null;
            }
            return commonFilterPopup$Companion0.newInstance(v, s, list0, v1, v2, v3, o0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String LIST_TYPE_DEPTH_ONE_BASIC = "LIST_TYPE_DEPTH_ONE_BASIC";
    @NotNull
    public static final String LIST_TYPE_DEPTH_THREE = "LIST_TYPE_DEPTH_THREE";
    @NotNull
    public static final String LIST_TYPE_DEPTH_TWO_ALYAC = "LIST_TYPE_DEPTH_TWO_ALYAC";
    @NotNull
    public static final String LIST_TYPE_DEPTH_TWO_HORIZONTAL = "LIST_TYPE_DEPTH_TWO_HORIZONTAL";
    @NotNull
    public static final String TAG = "ComposeBottomSheet";
    public WeakReference a;
    public static int b;
    public static String c;
    public static List d;
    public static int e;
    public static int f;
    public static int g;
    public static o h;

    static {
        CommonFilterPopup.Companion = new Companion(null);
        CommonFilterPopup.$stable = 8;
        CommonFilterPopup.b = 0x7F1307D1;  // string:order_by "정렬"
    }

    @NotNull
    public static final CommonFilterPopup newInstance(int v, @NotNull String s, @NotNull List list0, int v1, int v2, int v3, @Nullable o o0) {
        return CommonFilterPopup.Companion.newInstance(v, s, list0, v1, v2, v3, o0);
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setStyle(0, 0x7F14013B);  // style:CommonComposeBottomSheet
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        View view0 = new ComposeView(context0, null, 6, 0);
        ((AbstractComposeView)view0).setViewCompositionStrategy(t0.d);
        ((ComposeView)view0).setContent(new b(-1445025053, new y(this, 1), true));
        return view0;
    }

    @Override  // androidx.fragment.app.w
    public void onDismiss(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onDismiss(dialogInterface0);
        CommonFilterPopup.h = null;
        WeakReference weakReference0 = this.a;
        if(weakReference0 != null) {
            MelonBaseFragment melonBaseFragment0 = (MelonBaseFragment)weakReference0.get();
            if(melonBaseFragment0 != null) {
                melonBaseFragment0.setRetainDialog(null);
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        super.onPause();
        this.dismiss();
    }

    @Override  // androidx.fragment.app.w
    public void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        BottomSheetBehavior bottomSheetBehavior0 = null;
        BottomSheetDialog bottomSheetDialog0 = dialog0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialog0) : null;
        if(bottomSheetDialog0 != null) {
            BottomSheetBehavior bottomSheetBehavior1 = bottomSheetDialog0.e();
            if(bottomSheetBehavior1 != null) {
                bottomSheetBehavior1.f0 = true;
                bottomSheetBehavior1.g0 = false;
                bottomSheetBehavior0 = bottomSheetBehavior1;
            }
        }
        if(bottomSheetBehavior0 != null) {
            bottomSheetBehavior0.M(3);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        WeakReference weakReference0 = this.a;
        if(weakReference0 != null) {
            MelonBaseFragment melonBaseFragment0 = (MelonBaseFragment)weakReference0.get();
            if(melonBaseFragment0 != null) {
                melonBaseFragment0.setRetainDialog(this.getDialog());
            }
        }
    }

    public final void setDismissFragment(@NotNull MelonBaseFragment melonBaseFragment0) {
        q.g(melonBaseFragment0, "fragment");
        this.a = new WeakReference(melonBaseFragment0);
    }
}

