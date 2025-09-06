package com.iloen.melon.utils.viewable;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewIntersectionFinder {
    public interface Callback {
        boolean isTransparentView(View arg1);

        boolean isTransparentViewGroup(ViewGroup arg1);

        void onFound(View arg1, Rect arg2);
    }

    public static void a(Rect rect0, View view0, Callback viewIntersectionFinder$Callback0, Rect rect1) {
        if(!viewIntersectionFinder$Callback0.isTransparentView(view0)) {
            Rect rect2 = ViewIntersectionFinder.getVisibleRect(view0, rect1);
            if(rect2.isEmpty() || !rect2.intersect(rect0)) {
                rect2.setEmpty();
            }
            if(!rect2.isEmpty()) {
                if(view0 instanceof ViewGroup && viewIntersectionFinder$Callback0.isTransparentViewGroup(((ViewGroup)view0))) {
                    int v = ((ViewGroup)view0).getChildCount();
                    for(int v1 = 0; v1 < v; ++v1) {
                        ViewIntersectionFinder.a(rect0, ((ViewGroup)view0).getChildAt(v1), viewIntersectionFinder$Callback0, rect1);
                    }
                    return;
                }
                viewIntersectionFinder$Callback0.onFound(view0, rect2);
            }
        }
    }

    public static void find(View view0, Rect rect0, Callback viewIntersectionFinder$Callback0) {
        ViewParent viewParent0 = view0.getParent();
        Rect rect1 = new Rect();
        while(viewParent0 != null && viewParent0 instanceof ViewGroup) {
            ViewGroup viewGroup0 = (ViewGroup)viewParent0;
            int v = viewGroup0.getChildCount();
            boolean z = false;
            for(int v1 = 0; v1 < v; ++v1) {
                View view1 = viewGroup0.getChildAt(v1);
                if(view1 == view0) {
                    z = true;
                }
                else if(z) {
                    ViewIntersectionFinder.a(rect0, view1, viewIntersectionFinder$Callback0, rect1);
                }
            }
            viewParent0 = viewGroup0.getParent();
            view0 = viewGroup0;
        }
    }

    public static Rect getVisibleRect(View view0, Rect rect0) {
        if(view0.isShown() && view0.getGlobalVisibleRect(rect0, null)) {
            return rect0;
        }
        rect0.setEmpty();
        return rect0;
    }
}

