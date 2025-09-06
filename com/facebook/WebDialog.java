package com.facebook;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/WebDialog;", "", "<init>", "()V", "", "getWebDialogTheme", "()I", "theme", "Lie/H;", "setWebDialogTheme", "(I)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WebDialog {
    @NotNull
    public static final WebDialog INSTANCE;

    static {
        WebDialog.INSTANCE = new WebDialog();
    }

    public static final int getWebDialogTheme() {
        return com.facebook.internal.WebDialog.Companion.getWebDialogTheme();
    }

    public static final void setWebDialogTheme(int v) {
        com.facebook.internal.WebDialog.Companion.setWebDialogTheme(v);
    }
}

