package com.kakao.emoticon.ui;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.w;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.R.style;
import com.kakao.emoticon.controller.EmoticonSectionViewController;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.interfaces.EmoticonLoginClickListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.ScreenUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\f\u001A\u00020\u000B2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0013\u001A\u00020\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u0019\u0010\"\u001A\u00020!2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b$\u0010\u0004J\u0017\u0010\'\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020%H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020%H\u0016\u00A2\u0006\u0004\b)\u0010(J\u0017\u0010,\u001A\u00020\u000B2\b\u0010+\u001A\u0004\u0018\u00010*\u00A2\u0006\u0004\b,\u0010-R\u0018\u0010/\u001A\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001A\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u000E\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000E\u00103R\u0018\u00104\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\t\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\t\u00106R\u0016\u0010\n\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\n\u00106\u00A8\u00068"}, d2 = {"Lcom/kakao/emoticon/ui/PopupEmoticonFragment;", "Landroidx/fragment/app/w;", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "<init>", "()V", "Lcom/kakao/emoticon/controller/EmoticonSectionViewController;", "getEmoticonSectionViewController", "()Lcom/kakao/emoticon/controller/EmoticonSectionViewController;", "", "portraitHeight", "landscapeHeight", "Lie/H;", "setEmoticonKeyboardHeight", "(II)V", "listener", "setIEmoticonSectionViewListener", "(Lcom/kakao/emoticon/interfaces/EmoticonClickListener;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroy", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "param", "onEmoticonClick", "(Lcom/kakao/emoticon/model/EmoticonViewParam;)V", "onEmoticonDoubleClick", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "loginClickListener", "setLoginClickListener", "(Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;)V", "Landroid/widget/FrameLayout;", "emoticonLayout", "Landroid/widget/FrameLayout;", "emoticonSectionViewController", "Lcom/kakao/emoticon/controller/EmoticonSectionViewController;", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "emoticonLoginClickListener", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "I", "Companion", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class PopupEmoticonFragment extends w implements EmoticonClickListener {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/kakao/emoticon/ui/PopupEmoticonFragment$Companion;", "", "()V", "newInstance", "Lcom/kakao/emoticon/ui/PopupEmoticonFragment;", "emoticonSectionViewListener", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "emoticonLoginClickListener", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PopupEmoticonFragment newInstance(@NotNull EmoticonClickListener emoticonClickListener0, @NotNull EmoticonLoginClickListener emoticonLoginClickListener0) {
            q.g(emoticonClickListener0, "emoticonSectionViewListener");
            q.g(emoticonLoginClickListener0, "emoticonLoginClickListener");
            PopupEmoticonFragment popupEmoticonFragment0 = new PopupEmoticonFragment();
            popupEmoticonFragment0.setLoginClickListener(emoticonLoginClickListener0);
            popupEmoticonFragment0.setIEmoticonSectionViewListener(emoticonClickListener0);
            return popupEmoticonFragment0;
        }
    }

    public static final Companion Companion;
    private HashMap _$_findViewCache;
    private FrameLayout emoticonLayout;
    private EmoticonLoginClickListener emoticonLoginClickListener;
    private EmoticonSectionViewController emoticonSectionViewController;
    private int landscapeHeight;
    private EmoticonClickListener listener;
    private int portraitHeight;

    static {
        PopupEmoticonFragment.Companion = new Companion(null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap0 = this._$_findViewCache;
        if(hashMap0 != null) {
            hashMap0.clear();
        }
    }

    public View _$_findCachedViewById(int v) {
        if(this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view0 = (View)this._$_findViewCache.get(v);
        if(view0 == null) {
            View view1 = this.getView();
            if(view1 == null) {
                return null;
            }
            view0 = view1.findViewById(v);
            this._$_findViewCache.put(v, view0);
        }
        return view0;
    }

    private final EmoticonSectionViewController getEmoticonSectionViewController() {
        if(this.emoticonSectionViewController == null) {
            this.emoticonSectionViewController = new EmoticonSectionViewController(this.getActivity(), this);
        }
        EmoticonSectionViewController emoticonSectionViewController0 = this.emoticonSectionViewController;
        q.d(emoticonSectionViewController0);
        return emoticonSectionViewController0;
    }

    @NotNull
    public static final PopupEmoticonFragment newInstance(@NotNull EmoticonClickListener emoticonClickListener0, @NotNull EmoticonLoginClickListener emoticonLoginClickListener0) {
        return PopupEmoticonFragment.Companion.newInstance(emoticonClickListener0, emoticonLoginClickListener0);
    }

    @Override  // androidx.fragment.app.I
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        int v = ScreenUtils.INSTANCE.getOrientation() == 2 ? this.landscapeHeight : this.portraitHeight;
        FrameLayout frameLayout0 = this.emoticonLayout;
        if(frameLayout0 != null && frameLayout0.getLayoutParams().height != v) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
            if(v <= this.getResources().getDimensionPixelSize(dimen.emoticon_keyboard_popup_min_height)) {
                v = this.getResources().getDimensionPixelSize(dimen.emoticon_keyboard_min_height);
            }
            viewGroup$LayoutParams0.height = v;
            frameLayout0.setLayoutParams(viewGroup$LayoutParams0);
        }
        EmoticonSectionViewController emoticonSectionViewController0 = this.emoticonSectionViewController;
        if(emoticonSectionViewController0 != null) {
            emoticonSectionViewController0.onConfigurationChanged();
        }
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setStyle(1, style.Popup_Dialog);
    }

    @Override  // androidx.fragment.app.w
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle0) {
        Dialog dialog0 = super.onCreateDialog(bundle0);
        q.f(dialog0, "super.onCreateDialog(savedInstanceState)");
        dialog0.requestWindowFeature(0);
        Window window0 = dialog0.getWindow();
        q.d(window0);
        window0.setLayout(-1, -2);
        window0.setGravity(80);
        return dialog0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(layout.emoticon_dialog, viewGroup0, false);
        FrameLayout frameLayout0 = (FrameLayout)view0.findViewById(id.emoticon_layout);
        this.emoticonLayout = frameLayout0;
        if(frameLayout0 != null) {
            View view1 = this.getEmoticonSectionViewController().getContentView();
            this.getEmoticonSectionViewController().onViewAppear();
            this.getEmoticonSectionViewController().setLoginClickListener(this.emoticonLoginClickListener);
            frameLayout0.addView(view1, -1, -1);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
            int v = ScreenUtils.INSTANCE.getOrientation() == 2 ? this.landscapeHeight : this.portraitHeight;
            viewGroup$LayoutParams0.height = v <= this.getResources().getDimensionPixelSize(dimen.emoticon_keyboard_popup_min_height) ? this.getResources().getDimensionPixelSize(dimen.emoticon_keyboard_min_height) : v;
            frameLayout0.setLayoutParams(viewGroup$LayoutParams0);
            frameLayout0.setVisibility(0);
            ActionTracker.pushLog("A001", "01", null);
        }
        return view0;
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        super.onDestroy();
        this.getEmoticonSectionViewController().onDestroy();
    }

    @Override  // androidx.fragment.app.w
    public void onDestroyView() {
        super.onDestroyView();
        this._$_clearFindViewByIdCache();
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
    public void onEmoticonClick(@NotNull EmoticonViewParam emoticonViewParam0) {
        q.g(emoticonViewParam0, "param");
        EmoticonClickListener emoticonClickListener0 = this.listener;
        if(emoticonClickListener0 != null) {
            emoticonClickListener0.onEmoticonClick(emoticonViewParam0);
        }
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonClickListener
    public void onEmoticonDoubleClick(@NotNull EmoticonViewParam emoticonViewParam0) {
        q.g(emoticonViewParam0, "param");
        EmoticonClickListener emoticonClickListener0 = this.listener;
        if(emoticonClickListener0 != null) {
            emoticonClickListener0.onEmoticonDoubleClick(emoticonViewParam0);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
    }

    public final void setEmoticonKeyboardHeight(int v, int v1) {
        this.portraitHeight = v;
        this.landscapeHeight = v1;
    }

    public final void setIEmoticonSectionViewListener(@Nullable EmoticonClickListener emoticonClickListener0) {
        this.listener = emoticonClickListener0;
    }

    public final void setLoginClickListener(@Nullable EmoticonLoginClickListener emoticonLoginClickListener0) {
        this.emoticonLoginClickListener = emoticonLoginClickListener0;
    }
}

