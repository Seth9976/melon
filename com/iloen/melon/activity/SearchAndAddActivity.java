package com.iloen.melon.activity;

import android.content.Intent;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.searchandadd.SearchAndAddTabFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/iloen/melon/activity/SearchAndAddActivity;", "Lcom/iloen/melon/activity/PopupFragmentActivity;", "<init>", "()V", "Landroidx/fragment/app/I;", "getAddFragment", "()Landroidx/fragment/app/I;", "addFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SearchAndAddActivity extends PopupFragmentActivity {
    public static final int $stable = 8;

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    @Nullable
    public I getAddFragment() {
        Intent intent0 = this.getIntent();
        return intent0 != null ? SearchAndAddTabFragment.newInstance(intent0.getIntExtra("argSearchViewType", -1), intent0.getIntExtra("argCallerType", -1), intent0.getIntExtra("argMaxContentCount", -1)) : null;
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

