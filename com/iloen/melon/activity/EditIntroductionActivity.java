package com.iloen.melon.activity;

import android.content.Intent;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.EditIntroductionFragment;

public class EditIntroductionActivity extends PopupFragmentActivity {
    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Intent intent0 = this.getIntent();
        return intent0 != null ? EditIntroductionFragment.newInstance(intent0.getStringExtra("arg_text_value")) : null;
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
}

