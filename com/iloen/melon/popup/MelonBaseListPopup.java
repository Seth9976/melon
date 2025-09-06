package com.iloen.melon.popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.VolumeUtils;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\b\'\u0018\u0000 D2\u00020\u0001:\u0001DB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH&\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u001B\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010 \u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u0018\u00A2\u0006\u0004\b \u0010!J\u001F\u0010%\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u00122\u0006\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\u00122\u0006\u0010\'\u001A\u00020\u0012H\u0004\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001A\u00020\u00122\u0006\u0010\'\u001A\u00020\u0012H\u0004\u00A2\u0006\u0004\b*\u0010)J\u0017\u0010,\u001A\u00020\b2\u0006\u0010+\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020\u00128\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u0010/R\u0016\u00101\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00102\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010/R\u0016\u00103\u001A\u00020\u00158\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b3\u00104R$\u00105\u001A\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b5\u00104\u001A\u0004\b6\u0010\u0017\"\u0004\b7\u00108R$\u00109\u001A\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b9\u00104\u001A\u0004\b:\u0010\u0017\"\u0004\b;\u00108R$\u0010=\u001A\u0004\u0018\u00010<8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020\u00128\u0004@\u0004X\u0085\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010/\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/popup/MelonBaseListPopup;", "Landroid/app/Dialog;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onViewCreated", "()V", "onWindowAttributesSet", "Landroid/view/WindowManager$LayoutParams;", "wlp", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "", "getLayoutView", "()I", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "", "setPopupHeight", "()Z", "", "popupHeightPerScreen", "getMaxPopupHeight", "(F)I", "enabled", "setDim", "(Z)V", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "listCount", "getPopupHeightPort", "(I)I", "getPopupHeightLand", "orientation", "setConfigurationChanged", "(I)V", "mNumberOfListView", "I", "mMaxWidth", "mMaxHeightPort", "mMaxHeightLand", "rootView", "Landroid/view/View;", "container", "getContainer", "setContainer", "(Landroid/view/View;)V", "listContainer", "getListContainer", "setListContainer", "Landroid/widget/ImageView;", "bottomShadow", "Landroid/widget/ImageView;", "getBottomShadow", "()Landroid/widget/ImageView;", "setBottomShadow", "(Landroid/widget/ImageView;)V", "mPopupHeight", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MelonBaseListPopup extends Dialog {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0004X\u0084T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iloen/melon/popup/MelonBaseListPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "DEFAULT_PORT_ROW_COUNT", "I", "DEFAULT_LAND_ROW_COUNT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_LAND_ROW_COUNT = 4;
    private static final int DEFAULT_PORT_ROW_COUNT = 5;
    @NotNull
    protected static final String TAG = "MelonBaseListPopup";
    @Nullable
    private ImageView bottomShadow;
    @Nullable
    private View container;
    @Nullable
    private View listContainer;
    private int mMaxHeightLand;
    private int mMaxHeightPort;
    private int mMaxWidth;
    private final int mNumberOfListView;
    protected int mPopupHeight;
    private View rootView;

    static {
        MelonBaseListPopup.Companion = new Companion(null);
        MelonBaseListPopup.$stable = 8;
    }

    public MelonBaseListPopup(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0);
        this.mNumberOfListView = 1;
        this.mPopupHeight = -1;
    }

    @Nullable
    public final ImageView getBottomShadow() {
        return this.bottomShadow;
    }

    @Nullable
    public final View getContainer() {
        return this.container;
    }

    public int getLayoutView() {
        return 0x7F0D0454;  // layout:list_popup_layout
    }

    @Nullable
    public final View getListContainer() {
        return this.listContainer;
    }

    public final int getMaxPopupHeight(float f) {
        return (int)(((float)ScreenUtils.getScreenHeight(this.getContext())) * f);
    }

    public final int getPopupHeightLand(int v) {
        int v2;
        int v1 = this.mNumberOfListView;
        if(v1 != 1 || v <= 4) {
            v2 = v1 != 2 || v <= 4 ? -2 : this.getContext().getResources().getDimensionPixelSize(0x7F0702F8);  // dimen:melon_popup_2depth_list_height_land
        }
        else {
            v2 = this.getContext().getResources().getDimensionPixelSize(0x7F070301);  // dimen:melon_popup_height_land
        }
        LogU.Companion.d("MelonBaseListPopup", "getPopupHeightLand(" + v + ") : " + v2);
        return v2;
    }

    public final int getPopupHeightPort(int v) {
        int v2;
        int v1 = this.mNumberOfListView;
        if(v1 != 1 || v <= 5) {
            v2 = v1 != 2 || v <= 6 ? -2 : this.getContext().getResources().getDimensionPixelSize(0x7F0702F9);  // dimen:melon_popup_2depth_list_height_port
        }
        else {
            v2 = this.getContext().getResources().getDimensionPixelSize(0x7F070302);  // dimen:melon_popup_height_port
        }
        LogU.Companion.d("MelonBaseListPopup", "getPopupHeightPort(" + v + ") : " + v2);
        return v2;
    }

    @NotNull
    public final View getRootView() {
        View view0 = this.rootView;
        if(view0 != null) {
            return view0;
        }
        q.m("rootView");
        throw null;
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.requestWindowFeature(1);
        View view0 = LayoutInflater.from(this.getContext()).inflate(this.getLayoutView(), null);
        q.f(view0, "inflate(...)");
        this.rootView = view0;
        this.setContentView(view0);
        View view1 = this.rootView;
        if(view1 != null) {
            this.container = view1.findViewById(0x7F0A0950);  // id:popup_container
            View view2 = this.rootView;
            if(view2 != null) {
                this.bottomShadow = (ImageView)view2.findViewById(0x7F0A0606);  // id:iv_bottom_shadow
                View view3 = this.rootView;
                if(view3 != null) {
                    this.listContainer = view3.findViewById(0x7F0A0783);  // id:list_title_container
                    this.onViewCreated();
                    Window window0 = this.getWindow();
                    if(window0 != null) {
                        WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                        if(this.setPopupHeight()) {
                            windowManager$LayoutParams0.height = this.mPopupHeight;
                        }
                        q.d(windowManager$LayoutParams0);
                        WindowManager.LayoutParams windowManager$LayoutParams1 = this.setWindowLayoutParams(windowManager$LayoutParams0);
                        window0.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
                        window0.setAttributes(windowManager$LayoutParams1);
                    }
                    this.onWindowAttributesSet();
                    return;
                }
                q.m("rootView");
                throw null;
            }
            q.m("rootView");
            throw null;
        }
        q.m("rootView");
        throw null;
    }

    @Override  // android.app.Dialog
    public boolean onKeyDown(int v, @NotNull KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        return VolumeUtils.Companion.onVolumeKeyDown(context0, v) ? true : super.onKeyDown(v, keyEvent0);
    }

    public void onViewCreated() {
    }

    public void onWindowAttributesSet() {
    }

    public final void setBottomShadow(@Nullable ImageView imageView0) {
        this.bottomShadow = imageView0;
    }

    public void setConfigurationChanged(int v) {
        int v1 = this.mMaxWidth;
        if(v1 == 0) {
            v1 = this.getContext().getResources().getDimensionPixelSize(0x7F07030A);  // dimen:melon_popup_width
            this.mMaxWidth = v1;
        }
        Window window0 = this.getWindow();
        if(window0 != null) {
            switch(v) {
                case 1: {
                    int v3 = this.mMaxHeightPort;
                    if(v3 == 0) {
                        v3 = this.getPopupHeightPort(5);
                        this.mMaxHeightPort = v3;
                    }
                    Y.t("setConfigurationChanged() portrait height:", v3, LogU.Companion, "MelonBaseListPopup");
                    window0.setLayout(v1, this.mMaxHeightPort);
                    break;
                }
                case 2: {
                    int v2 = this.mMaxHeightLand;
                    if(v2 == 0) {
                        v2 = this.getPopupHeightLand(4);
                        this.mMaxHeightLand = v2;
                    }
                    Y.t("setConfigurationChanged() landscape height:", v2, LogU.Companion, "MelonBaseListPopup");
                    window0.setLayout(v1, this.mMaxHeightLand);
                }
            }
        }
    }

    public final void setContainer(@Nullable View view0) {
        this.container = view0;
    }

    public final void setDim(boolean z) {
        Window window0 = this.getWindow();
        if(window0 == null) {
            return;
        }
        if(z) {
            window0.addFlags(2);
            return;
        }
        window0.clearFlags(2);
    }

    public final void setListContainer(@Nullable View view0) {
        this.listContainer = view0;
    }

    public boolean setPopupHeight() {
        return false;
    }

    @NotNull
    public abstract WindowManager.LayoutParams setWindowLayoutParams(@NotNull WindowManager.LayoutParams arg1);
}

