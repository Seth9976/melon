package com.iloen.melon.popup;

import De.I;
import J8.C2;
import Pc.d;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.Z;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.interfaces.StringProviderImpl;
import d3.g;
import ie.r;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u001F2\u00020\u00012\u00020\u0002:\u0004\u001F !\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000F\u0010\u0017\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\u0019\u001A\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006#"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopup;", "Lcom/melon/ui/a0;", "Lcom/iloen/melon/popup/ForegroundPopup;", "<init>", "()V", "Lcom/iloen/melon/popup/RemoteConnectPopup$OnDismissListener;", "listener", "Lie/H;", "setDismissListener", "(Lcom/iloen/melon/popup/RemoteConnectPopup$OnDismissListener;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "dismiss", "LPc/d;", "stringProvider", "LPc/d;", "getStringProvider", "()LPc/d;", "setStringProvider", "(LPc/d;)V", "Companion", "OnDismissListener", "DeviceAdapter", "ScrollListenerForBottomShadow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RemoteConnectPopup extends Hilt_RemoteConnectPopup implements ForegroundPopup {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopup$Companion;", "", "Lcom/iloen/melon/popup/RemoteConnectPopup;", "newInstance", "()Lcom/iloen/melon/popup/RemoteConnectPopup;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RemoteConnectPopup newInstance() {
            return new RemoteConnectPopup();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u00132\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001B\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopup$DeviceAdapter;", "Landroidx/recyclerview/widget/Z;", "Lcom/iloen/melon/popup/DeviceInfoWrapper;", "Lcom/iloen/melon/popup/DeviceHolder;", "Lkotlin/Function1;", "Lie/H;", "deviceClickListener", "<init>", "(Lwe/k;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/popup/DeviceHolder;", "holder", "position", "onBindViewHolder", "(Lcom/iloen/melon/popup/DeviceHolder;I)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DeviceAdapter extends Z {
        @Metadata(d1 = {"\u0000\u000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopup$DeviceAdapter$Companion;", "", "com/iloen/melon/popup/RemoteConnectPopup$DeviceAdapter$Companion$diffUtilCallback$1", "diffUtilCallback", "Lcom/iloen/melon/popup/RemoteConnectPopup$DeviceAdapter$Companion$diffUtilCallback$1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.popup.RemoteConnectPopup.DeviceAdapter.Companion {
            public com.iloen.melon.popup.RemoteConnectPopup.DeviceAdapter.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.iloen.melon.popup.RemoteConnectPopup.DeviceAdapter.Companion Companion;
        public final k b;
        public static final RemoteConnectPopup.DeviceAdapter.Companion.diffUtilCallback.1 c;

        static {
            DeviceAdapter.Companion = new com.iloen.melon.popup.RemoteConnectPopup.DeviceAdapter.Companion(null);
            DeviceAdapter.$stable = 8;
            DeviceAdapter.c = new RemoteConnectPopup.DeviceAdapter.Companion.diffUtilCallback.1();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public DeviceAdapter(@NotNull k k0) {
            q.g(k0, "deviceClickListener");
            super(DeviceAdapter.c);
            this.b = k0;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(O0 o00, int v) {
            this.onBindViewHolder(((DeviceHolder)o00), v);
        }

        public void onBindViewHolder(@NotNull DeviceHolder deviceHolder0, int v) {
            q.g(deviceHolder0, "holder");
            deviceHolder0.bind(((DeviceInfoWrapper)this.getItem(v)));
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public DeviceHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return DeviceHolder.Companion.newInstance(viewGroup0, this.b);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopup$OnDismissListener;", "", "Lie/H;", "onDialogDismissed", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnDismissListener {
        void onDialogDismissed();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopup$ScrollListenerForBottomShadow;", "Landroidx/recyclerview/widget/A0;", "Landroid/view/View;", "bottomShadowView", "<init>", "(Landroid/view/View;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Lie/H;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ScrollListenerForBottomShadow extends A0 {
        public static final int $stable = 8;
        public final View a;

        public ScrollListenerForBottomShadow(@NotNull View view0) {
            q.g(view0, "bottomShadowView");
            super();
            this.a = view0;
        }

        @Override  // androidx.recyclerview.widget.A0
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView0, int v) {
            boolean z = false;
            q.g(recyclerView0, "recyclerView");
            super.onScrollStateChanged(recyclerView0, v);
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 instanceof LinearLayoutManager) {
                if(recyclerView0.computeVerticalScrollRange() > recyclerView0.getHeight()) {
                    j0 j00 = recyclerView0.getAdapter();
                    if(((LinearLayoutManager)w00).findLastCompletelyVisibleItemPosition() < (j00 == null ? 0 : j00.getItemCount() - 1)) {
                        z = true;
                    }
                }
                ViewUtils.showWhen(this.a, z);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Status.values().length];
            try {
                arr_v[Status.INIT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Status.CONNECTED.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Status.SEARCH.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Status.IDLE.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final LogU j;
    public C2 k;
    public final r l;
    public OnDismissListener m;
    public final L n;
    public final r o;
    public final M r;
    @Inject
    public d stringProvider;

    static {
        RemoteConnectPopup.Companion = new Companion(null);
        RemoteConnectPopup.$stable = 8;
    }

    public RemoteConnectPopup() {
        LogU logU0 = new LogU("RemoteConnectPopup");
        logU0.setCategory(Category.UI);
        this.j = logU0;
        this.l = g.Q(new K(this, 0));
        this.n = new L(this);
        this.o = g.Q(new K(this, 1));
        this.r = new M(this, 0);
    }

    public static final DeviceAdapter access$getDeviceAdapter(RemoteConnectPopup remoteConnectPopup0) {
        return (DeviceAdapter)remoteConnectPopup0.o.getValue();
    }

    public static final RemoteConnectPopupViewModel access$getViewModel(RemoteConnectPopup remoteConnectPopup0) {
        return remoteConnectPopup0.n();
    }

    // 检测为 Lambda 实现
    @Override  // androidx.fragment.app.w
    public void dismiss() [...]

    @NotNull
    public final d getStringProvider() {
        d d0 = this.stringProvider;
        if(d0 != null) {
            return d0;
        }
        q.m("stringProvider");
        throw null;
    }

    public final RemoteConnectPopupViewModel n() {
        return (RemoteConnectPopupViewModel)this.l.getValue();
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            dialog0.setOnKeyListener(this.n);
        }
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0594, viewGroup0, false);  // layout:player_remote_connect_popup_layout
        int v = 0x7F0A0337;  // id:content_container
        if(((ConstraintLayout)I.C(view0, 0x7F0A0337)) != null && ((ImageView)I.C(view0, 0x7F0A0576)) != null) {  // id:content_container
            v = 0x7F0A0606;  // id:iv_bottom_shadow
            View view1 = I.C(view0, 0x7F0A0606);  // id:iv_bottom_shadow
            if(((ImageView)view1) != null) {
                v = 0x7F0A070A;  // id:layout_close
                View view2 = I.C(view0, 0x7F0A070A);  // id:layout_close
                if(((LinearLayout)view2) != null && ((LinearLayout)I.C(view0, 0x7F0A0754)) != null) {  // id:layout_volume
                    v = 0x7F0A0779;  // id:list
                    View view3 = I.C(view0, 0x7F0A0779);  // id:list
                    if(((RecyclerView)view3) != null) {
                        v = 0x7F0A0782;  // id:list_title
                        View view4 = I.C(view0, 0x7F0A0782);  // id:list_title
                        if(((MelonTextView)view4) != null && ((Guideline)I.C(view0, 0x7F0A07C7)) != null) {  // id:main_area_top_guideline
                            v = 0x7F0A094F;  // id:popup_close
                            View view5 = I.C(view0, 0x7F0A094F);  // id:popup_close
                            if(((MelonTextView)view5) != null) {
                                v = 0x7F0A0A39;  // id:search_btn
                                View view6 = I.C(view0, 0x7F0A0A39);  // id:search_btn
                                if(((MelonTextView)view6) != null) {
                                    v = 0x7F0A0A44;  // id:search_motion
                                    View view7 = I.C(view0, 0x7F0A0A44);  // id:search_motion
                                    if(((LottieAnimationView)view7) != null) {
                                        v = 0x7F0A0A56;  // id:seekbar_volume
                                        View view8 = I.C(view0, 0x7F0A0A56);  // id:seekbar_volume
                                        if(((SeekBar)view8) != null) {
                                            v = 0x7F0A0C9E;  // id:tv_list_empty
                                            View view9 = I.C(view0, 0x7F0A0C9E);  // id:tv_list_empty
                                            if(((MelonTextView)view9) != null) {
                                                v = 0x7F0A0D6B;  // id:underline
                                                View view10 = I.C(view0, 0x7F0A0D6B);  // id:underline
                                                if(view10 != null) {
                                                    this.k = new C2(((ConstraintLayout)view0), ((ImageView)view1), ((LinearLayout)view2), ((RecyclerView)view3), ((MelonTextView)view4), ((MelonTextView)view5), ((MelonTextView)view6), ((LottieAnimationView)view7), ((SeekBar)view8), ((MelonTextView)view9), view10);
                                                    q.f(((ConstraintLayout)view0), "getRoot(...)");
                                                    return (ConstraintLayout)view0;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.a0
    public void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.width = -1;
                windowManager$LayoutParams0.height = -2;
                windowManager$LayoutParams0.gravity = 80;
                window0.setBackgroundDrawableResource(0x7F08091C);  // drawable:shape_white001s_top_round8
            }
        }
    }

    @Override  // com.melon.ui.a0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        int v = this.n().isRemoteConnected() ? 0x7F1300CB : 0x7F1300D9;  // string:alert_dlg_title_connected_remotedevice "재생할 기기 선택"
        C2 c20 = this.k;
        if(c20 != null) {
            String s = ((StringProviderImpl)this.getStringProvider()).a(v);
            c20.e.setText(s);
            C2 c21 = this.k;
            if(c21 != null) {
                ViewUtilsKt.setAccessibilityButtonClassName(c21.g);
                C2 c22 = this.k;
                if(c22 != null) {
                    N n0 = new N(this, 0);
                    c22.g.setOnClickListener(n0);
                    C2 c23 = this.k;
                    if(c23 != null) {
                        RecyclerView recyclerView0 = c23.d;
                        recyclerView0.setAdapter(((DeviceAdapter)this.o.getValue()));
                        recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
                        C2 c24 = this.k;
                        if(c24 != null) {
                            recyclerView0.addOnScrollListener(new ScrollListenerForBottomShadow(c24.b));
                            C2 c25 = this.k;
                            if(c25 != null) {
                                com.iloen.melon.popup.RemoteConnectPopup.onViewCreated.3 remoteConnectPopup$onViewCreated$30 = new SeekBar.OnSeekBarChangeListener() {
                                    public final RemoteConnectPopup a;

                                    {
                                        this.a = remoteConnectPopup0;
                                    }

                                    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
                                    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
                                        if(z) {
                                            Context context0 = this.a.getContext();
                                            VolumeUtils.Companion.setVolumeFromProgress(context0, v);
                                        }
                                    }

                                    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
                                    public void onStartTrackingTouch(SeekBar seekBar0) {
                                    }

                                    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
                                    public void onStopTrackingTouch(SeekBar seekBar0) {
                                    }
                                };
                                c25.i.setOnSeekBarChangeListener(remoteConnectPopup$onViewCreated$30);
                                C2 c26 = this.k;
                                if(c26 != null) {
                                    N n1 = new N(this, 1);
                                    c26.c.setOnClickListener(n1);
                                    C2 c27 = this.k;
                                    if(c27 != null) {
                                        ViewUtilsKt.setAccessibilityButtonClassName(c27.f);
                                        this.n().getRemoteDevices().observe(this, new RemoteConnectPopup.sam.androidx_lifecycle_Observer.0(new M(this, 1)));
                                        this.n().getStatus().observe(this, new RemoteConnectPopup.sam.androidx_lifecycle_Observer.0(new M(this, 2)));
                                        this.n().getVolumeInfo().observe(this, new RemoteConnectPopup.sam.androidx_lifecycle_Observer.0(new M(this, 3)));
                                        this.n().getDismissEvent().observe(this, (/* 缺少LAMBDA参数 */) -> {
                                            super.dismiss();
                                            OnDismissListener remoteConnectPopup$OnDismissListener0 = this.m;
                                            if(remoteConnectPopup$OnDismissListener0 != null) {
                                                remoteConnectPopup$OnDismissListener0.onDialogDismissed();
                                            }
                                            this.n().onDismissPopup();
                                        });
                                        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new RemoteConnectPopup.setObservers.5(this, null), 3, null);
                                        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new RemoteConnectPopup.setObservers.6(this, null), 3, null);
                                        return;
                                    }
                                    q.m("binding");
                                    throw null;
                                }
                                q.m("binding");
                                throw null;
                            }
                            q.m("binding");
                            throw null;
                        }
                        q.m("binding");
                        throw null;
                    }
                    q.m("binding");
                    throw null;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }

    public final void setDismissListener(@NotNull OnDismissListener remoteConnectPopup$OnDismissListener0) {
        q.g(remoteConnectPopup$OnDismissListener0, "listener");
        this.m = remoteConnectPopup$OnDismissListener0;
    }

    public final void setStringProvider(@NotNull d d0) {
        q.g(d0, "<set-?>");
        this.stringProvider = d0;
    }
}

