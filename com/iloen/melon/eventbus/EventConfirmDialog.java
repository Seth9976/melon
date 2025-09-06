package com.iloen.melon.eventbus;

import android.content.DialogInterface.OnClickListener;

public class EventConfirmDialog {
    public final DialogInterface.OnClickListener clickListener;
    public final String message;
    public final String title;

    public EventConfirmDialog(String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.title = s;
        this.message = s1;
        this.clickListener = dialogInterface$OnClickListener0;
    }
}

