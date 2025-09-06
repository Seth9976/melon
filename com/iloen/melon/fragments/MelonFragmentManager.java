package com.iloen.melon.fragments;

import androidx.fragment.app.I;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.log.LogU;
import java.lang.ref.WeakReference;

public class MelonFragmentManager {
    public static class FragmentAnimations {
        public int enterAnimation;
        public int exitAnimation;
        public int popEnterAnimation;
        public int popExitAnimation;

        public FragmentAnimations() {
            this.enterAnimation = 0x7F010042;  // anim:nochange
            this.exitAnimation = 0x7F010042;  // anim:nochange
            this.popEnterAnimation = 0x7F010042;  // anim:nochange
            this.popExitAnimation = 0x7F010042;  // anim:nochange
        }
    }

    static final class MelonFragmentManagerHolder {
        private static final MelonFragmentManager sInstance;

        static {
            MelonFragmentManagerHolder.sInstance = new MelonFragmentManager(0);
        }

        public static MelonFragmentManager a() {
            return MelonFragmentManagerHolder.sInstance;
        }
    }

    private static final String TAG = "MelonFragmentManager";
    private volatile short mActivityCount;
    private WeakReference mRootActivityRef;

    private MelonFragmentManager() {
    }

    public MelonFragmentManager(int v) {
    }

    public void decreaseActivityCount() {
        this.mActivityCount = (short)(this.mActivityCount - 1);
    }

    public int getActivityCount() {
        return this.mActivityCount;
    }

    public BaseActivity getCurrentActivity() {
        return this.mRootActivityRef == null ? null : ((BaseActivity)this.mRootActivityRef.get());
    }

    public I getCurrentFragment() {
        BaseActivity baseActivity0 = this.getCurrentActivity();
        return baseActivity0 == null ? null : baseActivity0.getCurrentFragment();
    }

    public I getFragment() {
        BaseActivity baseActivity0 = this.getCurrentActivity();
        return baseActivity0 == null ? null : baseActivity0.getFragment();
    }

    public static MelonFragmentManager getInstance() {
        return MelonFragmentManagerHolder.a();
    }

    public void increaseActivityCount() {
        this.mActivityCount = (short)(this.mActivityCount + 1);
    }

    public void initialize(BaseActivity baseActivity0) {
        this.mRootActivityRef = new WeakReference(baseActivity0);
    }

    public void open(I i0) {
        this.open(i0, null);
    }

    public void open(I i0, FragmentAnimations melonFragmentManager$FragmentAnimations0) {
        LogU.d("MelonFragmentManager", "open() f:" + i0);
        BaseActivity baseActivity0 = this.getCurrentActivity();
        if(baseActivity0 != null && !baseActivity0.isFinishing()) {
            baseActivity0.addFragment(i0, null, melonFragmentManager$FragmentAnimations0);
            return;
        }
        LogU.e("MelonFragmentManager", "activity is null or finishing:" + baseActivity0);
    }

    public void open(MelonBaseFragment melonBaseFragment0) {
        this.open(melonBaseFragment0, null);
    }
}

