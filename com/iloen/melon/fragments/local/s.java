package com.iloen.melon.fragments.local;

import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.View;

public final class s implements View.OnKeyListener {
    public final LocalFolderListFragment a;

    public s(LocalFolderListFragment localFolderListFragment0) {
        this.a = localFolderListFragment0;
    }

    @Override  // android.view.View$OnKeyListener
    public final boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        return LocalFolderListFragment.onViewCreated$lambda$0(this.a, view0, v, keyEvent0);
    }
}

