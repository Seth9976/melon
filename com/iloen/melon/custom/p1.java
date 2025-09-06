package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.LinkedList;

public final class p1 implements View.OnClickListener {
    public final ToolBar a;

    public p1(ToolBar toolBar0) {
        this.a = toolBar0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ToolBar toolBar0 = this.a;
        if(toolBar0.g != null) {
            LinkedList linkedList0 = toolBar0.i;
            if(linkedList0 != null) {
                int v = linkedList0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    ToolBarItem toolBar$ToolBarItem0 = (ToolBarItem)toolBar0.i.get(v1);
                    if(toolBar$ToolBarItem0 != null && view0 == toolBar$ToolBarItem0.b) {
                        toolBar0.g.onToolBarItemClicked(toolBar$ToolBarItem0, toolBar$ToolBarItem0.c);
                        return;
                    }
                }
            }
        }
    }
}

