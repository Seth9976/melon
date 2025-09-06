package com.iloen.melon.activity;

import android.content.Intent;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.searchandadd.PresentHistoryAddFragment;

public class PresentSendedHistoryAddActivity extends PopupFragmentActivity {
    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Intent intent0 = this.getIntent();
        return intent0 != null ? PresentHistoryAddFragment.newInstance(intent0.getParcelableArrayListExtra("argAddedFriendList"), intent0.getIntExtra("argMaxResultCount", 0)) : null;
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

