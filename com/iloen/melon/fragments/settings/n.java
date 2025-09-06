package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import com.iloen.melon.userstore.entity.ExcludedArtistEntity;

public final class n implements View.OnClickListener {
    public final TextView a;
    public final BannedContentsAdapter b;
    public final int c;
    public final ExcludedArtistEntity d;

    public n(TextView textView0, BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0, int v, ExcludedArtistEntity excludedArtistEntity0) {
        this.a = textView0;
        this.b = settingBannedContentsFragment$BannedContentsAdapter0;
        this.c = v;
        this.d = excludedArtistEntity0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        BannedContentsAdapter.onBindViewImpl$lambda$10$lambda$9$lambda$8$lambda$7(this.a, this.b, this.c, this.d, view0);
    }
}

