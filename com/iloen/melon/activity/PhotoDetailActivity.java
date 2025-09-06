package com.iloen.melon.activity;

import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.utils.system.CompatUtils;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001A\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/iloen/melon/activity/PhotoDetailActivity;", "Lcom/iloen/melon/activity/PopupFragmentActivity;", "<init>", "()V", "Landroidx/fragment/app/I;", "getAddFragment", "()Landroidx/fragment/app/I;", "addFragment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PhotoDetailActivity extends PopupFragmentActivity {
    public static final int $stable = 8;

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    @NotNull
    public I getAddFragment() {
        Serializable serializable0 = CompatUtils.getSerializableExtra(this.getIntent(), "argPhotoInfoList", PhotoInfoList.class);
        if(((PhotoInfoList)serializable0) != null) {
            return Companion.newInstance$default(PhotoDetailViewFragment.Companion, ((PhotoInfoList)serializable0), false, true, 2, null);
        }
        String s = this.getIntent().getStringExtra("argPhotoUrl");
        String s1 = this.getIntent().getStringExtra("argDescription");
        return Companion.newInstance$default(PhotoDetailViewFragment.Companion, s, s1, null, null, false, true, 28, null);
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

