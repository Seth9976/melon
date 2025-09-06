package com.iloen.melon.popup;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/popup/MelonSplashPopup;", "Landroid/app/Dialog;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onAttachedToWindow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonSplashPopup extends Dialog {
    public static final int $stable = 8;
    public final MainCoroutineDispatcher a;

    public MelonSplashPopup(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0, 0x7F14000D);  // style:AppPopupThemeTransparent
        this.a = Dispatchers.getMain();
        this.setCancelable(false);
        this.setContentView(0x7F0D0860);  // layout:splash_layout
    }

    @Override  // android.app.Dialog
    public void onAttachedToWindow() {
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setBackgroundDrawableResource(0x7F0604AA);  // color:white000s_support_high_contrast
            window0.setWindowAnimations(0x7F14014F);  // style:FadeOutWhenExit
            ScreenUtils.setAppearanceLightStatusBars(this.getWindow(), !ScreenUtils.isDarkMode(window0.getContext()));
        }
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.a), null, null, new n(null) {
            public int r;
            public final MelonSplashPopup w;

            {
                this.w = melonSplashPopup0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.popup.MelonSplashPopup.onStart.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.popup.MelonSplashPopup.onStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                MelonSplashPopup melonSplashPopup0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        ((ImageView)melonSplashPopup0.findViewById(0x7F0A07AA)).setImageResource(0x7F080472);  // id:logo_image
                        this.r = 1;
                        if(DelayKt.delay(1000L, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                melonSplashPopup0.dismiss();
                return H.a;
            }
        }, 3, null);
    }
}

