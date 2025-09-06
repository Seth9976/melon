package com.iloen.melon.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.MelonWidgetMoreViewFragment;
import com.iloen.melon.fragments.MelonWidgetSettingFragment;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.utils.system.CompatUtils;

public class WidgetMoreViewActivity extends PopupFragmentActivity {
    private static final String TAG = "WidgetMoreViewActivity";

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Intent intent0 = this.getIntent();
        if(intent0 == null) {
            return null;
        }
        String s = intent0.getAction();
        Actor actor0 = (Actor)CompatUtils.getSerializableExtra(intent0, "com.iloen.melon.intent.extra.actor", Actor.class);
        if("com.iloen.melon.intent.action.widget.more".equals(s)) {
            return MelonWidgetMoreViewFragment.newInstance(actor0);
        }
        return "com.iloen.melon.intent.action.widget.setting".equals(s) ? MelonWidgetSettingFragment.newInstance(actor0) : null;
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackPressedCallback() {
        this.destroyActivity();
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public boolean shouldIgnoreForeground() {
        return true;
    }
}

