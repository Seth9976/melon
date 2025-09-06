package com.iloen.melon.activity;

import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.friend.FriendSelectPagerFragment;
import com.iloen.melon.sns.model.Sharable;
import java.util.ArrayList;

public class FriendSelectActivity extends PopupFragmentActivity {
    public static final String ARG_OPEN_FRIENDLIST = "argIsOpenFriendList";
    public static final String ARG_WHERE_R_U_FROM = "argWhereRUFrom";
    public static final int FROM_MUSIC_MESSAGE = 0;
    public static final int FROM_PRESENT = 1;

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Intent intent0 = this.getIntent();
        if(intent0 != null) {
            String s = intent0.getStringExtra("argTabTitleName");
            ArrayList arrayList0 = intent0.getParcelableArrayListExtra("argAddedFriendList");
            Parcelable parcelable0 = intent0.getParcelableExtra("argAttachedSharable");
            int v = intent0.getIntExtra("argMaxResultCount", 0);
            return intent0.getBooleanExtra("argIsOpenFriendList", true) ? FriendSelectPagerFragment.newInstance(s, arrayList0, ((Sharable)parcelable0), v, 0, intent0.getIntExtra("argWhereRUFrom", 0)) : FriendSelectPagerFragment.newInstance(s, arrayList0, ((Sharable)parcelable0), v, 2, intent0.getIntExtra("argWhereRUFrom", 0));
        }
        return null;
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

