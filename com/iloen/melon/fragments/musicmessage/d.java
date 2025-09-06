package com.iloen.melon.fragments.musicmessage;

import we.a;

public final class d implements a {
    public final int a;
    public final MusicMessageEditorFragment b;

    public d(MusicMessageEditorFragment musicMessageEditorFragment0, int v) {
        this.a = v;
        this.b = musicMessageEditorFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return MusicMessageEditorFragment.blockUser$lambda$43(this.b);
            }
            case 1: {
                return MusicMessageEditorFragment.blockUser$lambda$44(this.b);
            }
            case 2: {
                return MusicMessageEditorFragment.unblockUser$lambda$48(this.b);
            }
            case 3: {
                return MusicMessageEditorFragment.unblockUser$lambda$49(this.b);
            }
            default: {
                return com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.mTextEditorWatcher.1.onTextChanged$lambda$0(this.b);
            }
        }
    }
}

