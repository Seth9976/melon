package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class y implements View.OnClickListener {
    public final int a;
    public final PhotoDetailViewFragment b;

    public y(PhotoDetailViewFragment photoDetailViewFragment0, int v) {
        this.a = v;
        this.b = photoDetailViewFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PhotoDetailViewFragment.setArtistInfo$lambda$44(this.b, view0);
                return;
            }
            case 1: {
                PhotoDetailViewFragment.reviewedOnClickListener$lambda$66(this.b, view0);
                return;
            }
            case 2: {
                PhotoDetailViewFragment.sharedOnClickListener$lambda$67(this.b, view0);
                return;
            }
            case 3: {
                PhotoDetailViewFragment.infoViewGroupOnClickListener$lambda$68(this.b, view0);
                return;
            }
            case 4: {
                PhotoDetailViewFragment.onClickListener$lambda$69(this.b, view0);
                return;
            }
            case 5: {
                PhotoDetailViewFragment.onViewCreated$lambda$9$lambda$7$lambda$6(this.b, view0);
                return;
            }
            default: {
                PhotoDetailViewFragment.likedOnClickListener$lambda$65(this.b, view0);
            }
        }
    }
}

