package com.iloen.melon.popup;

import Q0.t0;
import U4.x;
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
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0002\u001D\u001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0018¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/popup/DjSelectionPopup;", "Li6/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "fragment", "setDismissFragment", "(Lcom/iloen/melon/fragments/MelonBaseFragment;)V", "Companion", "DjSelectionPopupData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjSelectionPopup extends d {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J5\u0010\t\u001A\u00020\b2\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0016\b\u0002\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0004\u0010\u000ER$\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/popup/DjSelectionPopup$Companion;", "", "", "Lcom/iloen/melon/popup/DjSelectionPopup$DjSelectionPopupData;", "djList", "Lkotlin/Function1;", "Lie/H;", "onSelectionListener", "Lcom/iloen/melon/popup/DjSelectionPopup;", "newInstance", "(Ljava/util/List;Lwe/k;)Lcom/iloen/melon/popup/DjSelectionPopup;", "", "TAG", "Ljava/lang/String;", "Ljava/util/List;", "Lwe/k;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DjSelectionPopup newInstance(@NotNull List list0, @Nullable k k0) {
            q.g(list0, "djList");
            DjSelectionPopup.b = list0;
            DjSelectionPopup.c = k0;
            return new DjSelectionPopup();
        }

        public static DjSelectionPopup newInstance$default(Companion djSelectionPopup$Companion0, List list0, k k0, int v, Object object0) {
            if((v & 2) != 0) {
                k0 = null;
            }
            return djSelectionPopup$Companion0.newInstance(list0, k0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\tJ.\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001A\u0004\b\u001A\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0017\u001A\u0004\b\u001C\u0010\t¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/popup/DjSelectionPopup$DjSelectionPopupData;", "", "", "thumbImgUrl", "nickName", "memberKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/popup/DjSelectionPopup$DjSelectionPopupData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getThumbImgUrl", "b", "getNickName", "c", "getMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DjSelectionPopupData {
        public static final int $stable;
        public final String a;
        public final String b;
        public final String c;

        public DjSelectionPopupData() {
            this(null, null, null, 7, null);
        }

        public DjSelectionPopupData(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "thumbImgUrl");
            q.g(s1, "nickName");
            q.g(s2, "memberKey");
            super();
            this.a = s;
            this.b = s1;
            this.c = s2;
        }

        public DjSelectionPopupData(String s, String s1, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            this(s, s1, s2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final DjSelectionPopupData copy(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "thumbImgUrl");
            q.g(s1, "nickName");
            q.g(s2, "memberKey");
            return new DjSelectionPopupData(s, s1, s2);
        }

        public static DjSelectionPopupData copy$default(DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0, String s, String s1, String s2, int v, Object object0) {
            if((v & 1) != 0) {
                s = djSelectionPopup$DjSelectionPopupData0.a;
            }
            if((v & 2) != 0) {
                s1 = djSelectionPopup$DjSelectionPopupData0.b;
            }
            if((v & 4) != 0) {
                s2 = djSelectionPopup$DjSelectionPopupData0.c;
            }
            return djSelectionPopup$DjSelectionPopupData0.copy(s, s1, s2);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DjSelectionPopupData)) {
                return false;
            }
            if(!q.b(this.a, ((DjSelectionPopupData)object0).a)) {
                return false;
            }
            return q.b(this.b, ((DjSelectionPopupData)object0).b) ? q.b(this.c, ((DjSelectionPopupData)object0).c) : false;
        }

        @NotNull
        public final String getMemberKey() [...] // 潜在的解密器

        @NotNull
        public final String getNickName() [...] // 潜在的解密器

        @NotNull
        public final String getThumbImgUrl() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        }

        @Override
        @NotNull
        public String toString() {
            return x.m(A7.d.o("DjSelectionPopupData(thumbImgUrl=", this.a, ", nickName=", this.b, ", memberKey="), this.c, ")");
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "DjSelectionPopup";
    public WeakReference a;
    public static List b;
    public static k c;

    static {
        DjSelectionPopup.Companion = new Companion(null);
        DjSelectionPopup.$stable = 8;
        DjSelectionPopup.b = w.a;
    }

    @NotNull
    public static final DjSelectionPopup newInstance(@NotNull List list0, @Nullable k k0) {
        return DjSelectionPopup.Companion.newInstance(list0, k0);
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
        ((ComposeView)view0).setContent(new b(0x9EE01A1D, new y(this, 2), true));
        return view0;
    }

    @Override  // androidx.fragment.app.w
    public void onDismiss(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onDismiss(dialogInterface0);
        WeakReference weakReference0 = this.a;
        if(weakReference0 != null) {
            MelonBaseFragment melonBaseFragment0 = (MelonBaseFragment)weakReference0.get();
            if(melonBaseFragment0 != null) {
                melonBaseFragment0.setRetainDialog(null);
            }
        }
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

