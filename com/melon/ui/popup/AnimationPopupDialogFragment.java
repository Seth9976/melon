package com.melon.ui.popup;

import De.I;
import J8.b;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.z1;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import vd.c;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/melon/ui/popup/AnimationPopupDialogFragment;", "Lcom/melon/ui/a0;", "<init>", "()V", "DisplayPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AnimationPopupDialogFragment extends a0 {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/AnimationPopupDialogFragment$DisplayPosition;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DisplayPosition implements Parcelable {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final int a;
        public final int b;

        static {
            DisplayPosition.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public DisplayPosition(int v, int v1) {
            this.a = v;
            this.b = v1;
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
        }
    }

    public String e;
    public Integer f;
    public int g;
    public DisplayPosition h;
    public b i;

    @Override  // com.melon.ui.a0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            this.e = bundle1.getString("KEY_ANIMATION_RESOURCE");
            this.f = bundle1.getInt("KEY_ALTERNATIVE_IMAGE_RESOURCE");
            this.g = bundle1.getInt("KEY_REPEAT_COUNT");
            this.h = (DisplayPosition)com.kakao.sdk.common.util.a.i(bundle1);
        }
    }

    @Override  // com.melon.ui.a0
    public final Dialog onCreateDialog(Bundle bundle0) {
        return new Dialog(this.requireActivity(), 0x7F14000B);  // style:AppAnimationPopupThemeTransparent
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D059E, viewGroup0, false);  // layout:popup_animation
        int v = 0x7F0A00A2;  // id:animation_image
        if(((ImageView)I.C(view0, 0x7F0A00A2)) != null) {  // id:animation_image
            v = 0x7F0A07B1;  // id:lottie_animation_image
            LottieAnimationView lottieAnimationView0 = (LottieAnimationView)I.C(view0, 0x7F0A07B1);  // id:lottie_animation_image
            if(lottieAnimationView0 != null) {
                this.i = new b(((FrameLayout)view0), lottieAnimationView0, 6);
                return (FrameLayout)view0;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                DisplayPosition animationPopupDialogFragment$DisplayPosition0 = this.h;
                if(animationPopupDialogFragment$DisplayPosition0 != null) {
                    windowManager$LayoutParams0.gravity = 0x30;
                    windowManager$LayoutParams0.y = ScreenUtils.isOrientationPortrait(window0.getContext()) ? animationPopupDialogFragment$DisplayPosition0.a : animationPopupDialogFragment$DisplayPosition0.b;
                }
                windowManager$LayoutParams0.width = -1;
                window0.setBackgroundDrawableResource(0x106000D);
            }
        }
        b b0 = this.i;
        if(b0 != null) {
            Context context0 = this.getContext();
            if(context0 != null) {
                LottieAnimationView lottieAnimationView0 = (LottieAnimationView)b0.c;
                if(AndroidSettings.isAnimationDisabled(context0)) {
                    Integer integer0 = this.f;
                    if(integer0 != null) {
                        lottieAnimationView0.setImageResource(integer0.intValue());
                        D d0 = this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new c(this, null), 3, null);
                    }
                }
                else {
                    String s = this.e;
                    if(s != null) {
                        lottieAnimationView0.setAnimation(s);
                        lottieAnimationView0.setRepeatCount(this.g);
                        lottieAnimationView0.addAnimatorListener(new z1(this, 2));
                        lottieAnimationView0.playAnimation();
                    }
                }
            }
        }
    }
}

