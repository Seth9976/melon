package com.iloen.melon.fragments.local;

import android.view.View.OnClickListener;
import android.view.View;

public final class u implements View.OnClickListener {
    public final int a;
    public final LocalFolderListFragment b;

    public u(LocalFolderListFragment localFolderListFragment0, int v) {
        this.a = v;
        this.b = localFolderListFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            LocalFolderListAdapter.onBindViewImpl$lambda$1(this.b, view0);
            return;
        }
        LocalFolderListAdapter.onBindViewImpl$lambda$0(this.b, view0);
    }
}

