package com.kakaoent.trevi.ad.ui.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;
import b.n;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005*\u0001\u0017\b \u0018\u00002\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000F\u0010\u000B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\u0003J\u0017\u0010\u000E\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001A\u00020\f8\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u000FR\u0014\u0010\u0018\u001A\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment;", "Landroidx/fragment/app/I;", "<init>", "()V", "Lie/H;", "useBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "onBackPressed", "", "isVisible", "visibleToUser", "(Z)V", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment$FragmentEventObserver;", "lifecycleEvent", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment$FragmentEventObserver;", "isVisibleToUser", "Z", "()Z", "setVisibleToUser", "com/kakaoent/trevi/ad/ui/fragment/BaseFragment$onBackPressedCallback$1", "onBackPressedCallback", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment$onBackPressedCallback$1;", "FragmentEventObserver", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class BaseFragment extends I {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR%\u0010\u000F\u001A\u0010\u0012\f\u0012\n \u000E*\u0004\u0018\u00010\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment$FragmentEventObserver;", "Landroidx/lifecycle/B;", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment;", "fragment", "<init>", "(Lcom/kakaoent/trevi/ad/ui/fragment/BaseFragment;)V", "Landroidx/lifecycle/D;", "source", "Landroidx/lifecycle/r;", "event", "Lie/H;", "onStateChanged", "(Landroidx/lifecycle/D;Landroidx/lifecycle/r;)V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "fragmentRef", "Ljava/lang/ref/WeakReference;", "getFragmentRef", "()Ljava/lang/ref/WeakReference;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class FragmentEventObserver implements B {
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
        public abstract class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[r.values().length];
                try {
                    arr_v[r.ON_RESUME.ordinal()] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[r.ON_PAUSE.ordinal()] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        @NotNull
        private final WeakReference fragmentRef;

        public FragmentEventObserver(@NotNull BaseFragment baseFragment0) {
            q.g(baseFragment0, "fragment");
            super();
            this.fragmentRef = new WeakReference(baseFragment0);
        }

        @Override  // androidx.lifecycle.B
        public void onStateChanged(@NotNull D d0, @NotNull r r0) {
            q.g(d0, "source");
            q.g(r0, "event");
            BaseFragment baseFragment0 = (BaseFragment)this.fragmentRef.get();
            switch(WhenMappings.$EnumSwitchMapping$0[r0.ordinal()]) {
                case 1: {
                    if(baseFragment0 != null) {
                        baseFragment0.visibleToUser(true);
                        return;
                    }
                    break;
                }
                case 2: {
                    if(baseFragment0 != null) {
                        baseFragment0.visibleToUser(false);
                        return;
                    }
                    break;
                }
            }
        }
    }

    private boolean isVisibleToUser;
    @Nullable
    private FragmentEventObserver lifecycleEvent;
    @NotNull
    private final com.kakaoent.trevi.ad.ui.fragment.BaseFragment.onBackPressedCallback.1 onBackPressedCallback;

    public BaseFragment() {
        this.onBackPressedCallback = new n() {
            {
                BaseFragment.this = baseFragment0;
                super(false);
            }

            @Override  // b.n
            public void handleOnBackPressed() {
                BaseFragment.this.onBackPressed();
            }
        };
    }

    public void onBackPressed() {
        this.onBackPressedCallback.setEnabled(false);
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.onBackPressed();
        }
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(@Nullable Bundle bundle0) {
        FragmentEventObserver baseFragment$FragmentEventObserver0 = new FragmentEventObserver(this);
        this.getLifecycle().a(baseFragment$FragmentEventObserver0);
        this.lifecycleEvent = baseFragment$FragmentEventObserver0;
        super.onCreate(bundle0);
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        super.onDestroy();
        FragmentEventObserver baseFragment$FragmentEventObserver0 = this.lifecycleEvent;
        if(baseFragment$FragmentEventObserver0 != null) {
            this.getLifecycle().c(baseFragment$FragmentEventObserver0);
        }
    }

    public final void useBackPressed() {
        this.onBackPressedCallback.setEnabled(true);
        this.requireActivity().getOnBackPressedDispatcher().a(this, this.onBackPressedCallback);
    }

    public void visibleToUser(boolean z) {
        this.isVisibleToUser = z;
    }
}

