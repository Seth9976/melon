package com.iloen.melon.custom;

import android.view.ViewGroup;

public final class y0 implements Runnable {
    public final int a;
    public boolean b;
    public final ViewGroup c;

    public y0(NumberPicker numberPicker0) {
        this.a = 0;
        super();
        this.c = numberPicker0;
    }

    public y0(ToolBar toolBar0, boolean z) {
        this.a = 1;
        super();
        this.c = toolBar0;
        this.b = z;
    }

    @Override
    public final void run() {
        ViewGroup viewGroup0 = this.c;
        if(this.a != 0) {
            int v = ((ToolBar)viewGroup0).getVisibility();
            if(this.b) {
                if(v == 8) {
                    ((ToolBar)viewGroup0).m(-1);
                    ((ToolBar)viewGroup0).startAnimation(((ToolBar)viewGroup0).e);
                    return;
                }
            }
            else if(v == 0) {
                ((ToolBar)viewGroup0).startAnimation(((ToolBar)viewGroup0).f);
            }
            return;
        }
        ((NumberPicker)viewGroup0).a(this.b);
        ((NumberPicker)viewGroup0).postDelayed(this, ((NumberPicker)viewGroup0).N);
    }
}

