package com.iloen.melon.popup;

import De.I;
import J8.J2;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.O0;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import i.n.i.b.a.s.e.M3;
import ic.b;
import ic.c;
import ic.d;
import ic.e;
import ie.m;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00062\b\u0010\n\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/popup/DeviceHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/J2;", "binding", "Lkotlin/Function1;", "Lcom/iloen/melon/popup/DeviceInfoWrapper;", "Lie/H;", "clickListener", "<init>", "(LJ8/J2;Lwe/k;)V", "deviceWrapper", "bind", "(Lcom/iloen/melon/popup/DeviceInfoWrapper;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DeviceHolder extends O0 {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J)\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/popup/DeviceHolder$Companion;", "", "Landroid/view/ViewGroup;", "parent", "Lkotlin/Function1;", "Lcom/iloen/melon/popup/DeviceInfoWrapper;", "Lie/H;", "clickListener", "Lcom/iloen/melon/popup/DeviceHolder;", "newInstance", "(Landroid/view/ViewGroup;Lwe/k;)Lcom/iloen/melon/popup/DeviceHolder;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DeviceHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull k k0) {
            q.g(viewGroup0, "parent");
            q.g(k0, "clickListener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D05AD, viewGroup0, false);  // layout:popup_listitem_remote_connect_item
            int v = 0x7F0A0314;  // id:connected_motion
            LottieAnimationView lottieAnimationView0 = (LottieAnimationView)I.C(view0, 0x7F0A0314);  // id:connected_motion
            if(lottieAnimationView0 != null) {
                v = 0x7F0A0546;  // id:icon
                ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0546);  // id:icon
                if(imageView0 != null) {
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0B8D);  // id:title
                    if(melonTextView0 != null) {
                        return new DeviceHolder(new J2(((LinearLayout)view0), lottieAnimationView0, imageView0, melonTextView0), k0);
                    }
                    v = 0x7F0A0B8D;  // id:title
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final J2 a;
    public final k b;

    static {
        DeviceHolder.Companion = new Companion(null);
        DeviceHolder.$stable = 8;
    }

    public DeviceHolder(@NotNull J2 j20, @NotNull k k0) {
        q.g(j20, "binding");
        q.g(k0, "clickListener");
        super(j20.a);
        this.a = j20;
        this.b = k0;
        LogU logU0 = new LogU("RemotePopup-DeviceHolder");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
    }

    public final void bind(@Nullable DeviceInfoWrapper deviceInfoWrapper0) {
        m m0;
        J2 j20 = this.a;
        if(deviceInfoWrapper0 == null) {
            LogU.Companion.w("RemotePopup-DeviceHolder", "bind() null");
            AnimationDrawable animationDrawable0 = null;
            j20.d.setText(null);
            j20.c.setImageResource(0);
            j20.a.setOnClickListener(null);
            LottieAnimationView lottieAnimationView0 = j20.b;
            Drawable drawable0 = lottieAnimationView0.getDrawable();
            if(drawable0 instanceof AnimationDrawable) {
                animationDrawable0 = (AnimationDrawable)drawable0;
            }
            if(animationDrawable0 != null) {
                animationDrawable0.stop();
            }
            lottieAnimationView0.setVisibility(8);
            return;
        }
        String s = deviceInfoWrapper0.getDeviceInfo().getDisplayName();
        e e0 = deviceInfoWrapper0.getDeviceInfo().getDevice();
        if(e0 instanceof d) {
            m0 = new m(((int)(deviceInfoWrapper0.isConnected() ? 0x7F080447 : 0x7F080446)), 0x7F130B86);  // drawable:ic_fullplayer_phone_on
        }
        else if(e0 instanceof b) {
            m0 = new m(((int)(deviceInfoWrapper0.isConnected() ? 0x7F080443 : 0x7F080442)), 0x7F130AE6);  // drawable:ic_fullplayer_chromecast_on
        }
        else if(e0 instanceof c) {
            m0 = new m(((int)(deviceInfoWrapper0.isConnected() ? 0x7F080445 : 0x7F080444)), 0x7F130B17);  // drawable:ic_fullplayer_dlna_on
        }
        else {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        int v = ((Number)m0.b).intValue();
        LinearLayout linearLayout0 = j20.a;
        j20.d.setSelected(deviceInfoWrapper0.isConnected());
        j20.d.setText(s);
        Context context0 = linearLayout0.getContext();
        j20.d.setTextColor(ColorUtils.getColor(context0, (deviceInfoWrapper0.isConnected() ? 0x7F06017C : 0x7F060165)));  // color:green500s_support_high_contrast
        j20.c.setImageResource(((Number)m0.a).intValue());
        j20.c.setColorFilter(ColorUtils.getColor(j20.a.getContext(), (deviceInfoWrapper0.isConnected() ? 0x7F06017A : 0x7F060160)));  // color:green500e_support_high_contrast
        LottieAnimationView lottieAnimationView1 = j20.b;
        if(deviceInfoWrapper0.isConnected()) {
            if(!lottieAnimationView1.isAnimating() && deviceInfoWrapper0.isPlaying()) {
                lottieAnimationView1.playAnimation();
            }
            lottieAnimationView1.setVisibility(0);
        }
        else {
            if(lottieAnimationView1.isAnimating()) {
                lottieAnimationView1.cancelAnimation();
            }
            lottieAnimationView1.setVisibility(8);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append((deviceInfoWrapper0.isConnected() ? "연결됨" : ""));
        stringBuilder0.append(" ");
        stringBuilder0.append(j20.a.getContext().getString(v));
        stringBuilder0.append(" ");
        stringBuilder0.append(s);
        ViewUtils.setContentDescriptionWithButtonClassName(linearLayout0, stringBuilder0);
        linearLayout0.setOnClickListener(new F(1, this, deviceInfoWrapper0));
    }
}

