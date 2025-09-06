package A6;

import B6.f;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import c2.b;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.datepicker.p;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.sidesheet.SideSheetDialog;
import d2.d;

public final class c extends b {
    public final int a;
    public final Object b;

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // c2.b
    public void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        if(this.a != 3) {
            super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
            return;
        }
        super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
        accessibilityEvent0.setChecked(((CheckableImageButton)this.b).d);
    }

    @Override  // c2.b
    public void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                if(((SideSheetDialog)object0).i) {
                    d0.a(0x100000);
                    accessibilityNodeInfo0.setDismissable(true);
                    return;
                }
                accessibilityNodeInfo0.setDismissable(false);
                return;
            }
            case 1: {
                int v1 = -1;
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                if(view0 instanceof MaterialButton) {
                    int v2 = 0;
                    for(int v = 0; v < ((MaterialButtonToggleGroup)object0).getChildCount(); ++v) {
                        if(((MaterialButtonToggleGroup)object0).getChildAt(v) == view0) {
                            v1 = v2;
                            break;
                        }
                        if(((MaterialButtonToggleGroup)object0).getChildAt(v) instanceof MaterialButton && ((MaterialButtonToggleGroup)object0).c(v)) {
                            ++v2;
                        }
                    }
                }
                d0.n(f.c(0, 1, v1, 1, false, ((MaterialButton)view0).o));
                return;
            }
            case 2: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                String s = ((p)object0).n.getVisibility() == 0 ? ((p)object0).getString(0x7F130709) : ((p)object0).getString(0x7F130707);  // string:mtrl_picker_toggle_to_year_selection "Tap to switch to year view"
                d0.a.setHintText(s);
                return;
            }
            case 3: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.a.setCheckable(((CheckableImageButton)object0).e);
                d0.a.setChecked(((CheckableImageButton)object0).d);
                return;
            }
            case 4: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.a.setCheckable(((NavigationMenuItemView)object0).N);
                return;
            }
            case 5: {
                AccessibilityNodeInfo accessibilityNodeInfo1 = d0.a;
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                if(((BottomSheetDialog)object0).j) {
                    d0.a(0x100000);
                    accessibilityNodeInfo1.setDismissable(true);
                    return;
                }
                accessibilityNodeInfo1.setDismissable(false);
                return;
            }
            default: {
                super.onInitializeAccessibilityNodeInfo(view0, d0);
            }
        }
    }

    @Override  // c2.b
    public void onPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        if(this.a != 6) {
            super.onPopulateAccessibilityEvent(view0, accessibilityEvent0);
            return;
        }
        super.onPopulateAccessibilityEvent(view0, accessibilityEvent0);
        if(accessibilityEvent0.getEventType() == 1) {
            ((BottomSheetDragHandleView)this.b).c();
        }
    }

    @Override  // c2.b
    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        switch(this.a) {
            case 0: {
                if(v == 0x100000) {
                    SideSheetDialog sideSheetDialog0 = (SideSheetDialog)this.b;
                    if(sideSheetDialog0.i) {
                        sideSheetDialog0.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view0, v, bundle0);
            }
            case 5: {
                if(v == 0x100000) {
                    BottomSheetDialog bottomSheetDialog0 = (BottomSheetDialog)this.b;
                    if(bottomSheetDialog0.j) {
                        bottomSheetDialog0.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view0, v, bundle0);
            }
            default: {
                return super.performAccessibilityAction(view0, v, bundle0);
            }
        }
    }
}

