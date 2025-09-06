package d2;

import B6.f;
import P1.b;
import P1.e;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.widget.l;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public final AccessibilityNodeInfo a;
    public int b;
    public int c;

    public d(AccessibilityNodeInfo accessibilityNodeInfo0) {
        this.b = -1;
        this.c = -1;
        this.a = accessibilityNodeInfo0;
    }

    public final void a(int v) {
        this.a.addAction(v);
    }

    public final void b(c c0) {
        this.a.addAction(((AccessibilityNodeInfo.AccessibilityAction)c0.a));
    }

    public final ArrayList c(String s) {
        AccessibilityNodeInfo accessibilityNodeInfo0 = this.a;
        ArrayList arrayList0 = accessibilityNodeInfo0.getExtras().getIntegerArrayList(s);
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
            accessibilityNodeInfo0.getExtras().putIntegerArrayList(s, arrayList0);
        }
        return arrayList0;
    }

    public static String d(int v) {
        switch(v) {
            case 1: {
                return "ACTION_FOCUS";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 0x20: {
                return "ACTION_LONG_CLICK";
            }
            case 0x40: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 0x80: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 0x100: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 0x200: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 0x400: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 0x800: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 0x1000: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 0x2000: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 0x4000: {
                return "ACTION_COPY";
            }
            case 0x8000: {
                return "ACTION_PASTE";
            }
            case 0x10000: {
                return "ACTION_CUT";
            }
            case 0x20000: {
                return "ACTION_SET_SELECTION";
            }
            case 0x40000: {
                return "ACTION_EXPAND";
            }
            case 0x80000: {
                return "ACTION_COLLAPSE";
            }
            case 0x200000: {
                return "ACTION_SET_TEXT";
            }
            case 0x1020036: {
                return "ACTION_SHOW_ON_SCREEN";
            }
            case 0x1020037: {
                return "ACTION_SCROLL_TO_POSITION";
            }
            case 0x1020038: {
                return "ACTION_SCROLL_UP";
            }
            case 0x1020039: {
                return "ACTION_SCROLL_LEFT";
            }
            case 0x102003A: {
                return "ACTION_SCROLL_DOWN";
            }
            case 0x102003B: {
                return "ACTION_SCROLL_RIGHT";
            }
            case 0x102003C: {
                return "ACTION_CONTEXT_CLICK";
            }
            case 0x102003D: {
                return "ACTION_SET_PROGRESS";
            }
            case 0x1020042: {
                return "ACTION_MOVE_WINDOW";
            }
            case 0x1020044: {
                return "ACTION_SHOW_TOOLTIP";
            }
            case 0x1020045: {
                return "ACTION_HIDE_TOOLTIP";
            }
            case 0x1020046: {
                return "ACTION_PAGE_UP";
            }
            case 0x1020047: {
                return "ACTION_PAGE_DOWN";
            }
            case 0x1020048: {
                return "ACTION_PAGE_LEFT";
            }
            case 0x1020049: {
                return "ACTION_PAGE_RIGHT";
            }
            case 0x102004A: {
                return "ACTION_PRESS_AND_HOLD";
            }
            case 0x1020054: {
                return "ACTION_IME_ENTER";
            }
            case 0x1020055: {
                return "ACTION_DRAG_START";
            }
            case 0x1020056: {
                return "ACTION_DRAG_DROP";
            }
            case 0x1020057: {
                return "ACTION_DRAG_CANCEL";
            }
            case 0x102005E: {
                return "ACTION_SCROLL_IN_DIRECTION";
            }
            default: {
                return "ACTION_UNKNOWN";
            }
        }
    }

    public final boolean e(int v) {
        Bundle bundle0 = this.a.getExtras();
        return bundle0 != null && (bundle0.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & v) == v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo0 = ((d)object0).a;
        AccessibilityNodeInfo accessibilityNodeInfo1 = this.a;
        if(accessibilityNodeInfo1 == null) {
            if(accessibilityNodeInfo0 != null) {
                return false;
            }
        }
        else if(!accessibilityNodeInfo1.equals(accessibilityNodeInfo0)) {
            return false;
        }
        return this.c == ((d)object0).c ? this.b == ((d)object0).b : false;
    }

    public final void f(Rect rect0) {
        this.a.getBoundsInParent(rect0);
    }

    public final CharSequence g() {
        boolean z = this.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo0 = this.a;
        if(!z) {
            ArrayList arrayList0 = this.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            ArrayList arrayList1 = this.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            ArrayList arrayList2 = this.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            ArrayList arrayList3 = this.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            CharSequence charSequence0 = new SpannableString(TextUtils.substring(accessibilityNodeInfo0.getText(), 0, accessibilityNodeInfo0.getText().length()));
            for(int v = 0; v < arrayList0.size(); ++v) {
                ((SpannableString)charSequence0).setSpan(new a(((int)(((Integer)arrayList3.get(v)))), this, accessibilityNodeInfo0.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((int)(((Integer)arrayList0.get(v)))), ((int)(((Integer)arrayList1.get(v)))), ((int)(((Integer)arrayList2.get(v)))));
            }
            return charSequence0;
        }
        return accessibilityNodeInfo0.getText();
    }

    public final void h(boolean z) {
        this.a.setAccessibilityFocused(z);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    public final void i(int v, boolean z) {
        Bundle bundle0 = this.a.getExtras();
        if(bundle0 != null) {
            int v1 = bundle0.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & ~v;
            if(!z) {
                v = 0;
            }
            bundle0.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", v | v1);
        }
    }

    public final void j(Rect rect0) {
        this.a.setBoundsInParent(rect0);
    }

    public final void k(Rect rect0) {
        this.a.setBoundsInScreen(rect0);
    }

    public final void l(CharSequence charSequence0) {
        this.a.setClassName(charSequence0);
    }

    public final void m(f f0) {
        this.a.setCollectionInfo((f0 == null ? null : ((AccessibilityNodeInfo.CollectionInfo)f0.a)));
    }

    public final void n(f f0) {
        this.a.setCollectionItemInfo(((AccessibilityNodeInfo.CollectionItemInfo)f0.a));
    }

    public final void o(CharSequence charSequence0) {
        this.a.setContentDescription(charSequence0);
    }

    public final void p(boolean z) {
        this.a.setScrollable(z);
    }

    public final void q(CharSequence charSequence0) {
        this.a.setText(charSequence0);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        Rect rect0 = new Rect();
        this.f(rect0);
        stringBuilder0.append("; boundsInParent: " + rect0);
        AccessibilityNodeInfo accessibilityNodeInfo0 = this.a;
        accessibilityNodeInfo0.getBoundsInScreen(rect0);
        stringBuilder0.append("; boundsInScreen: " + rect0);
        int v = Build.VERSION.SDK_INT;
        if(v >= 34) {
            l.d(accessibilityNodeInfo0, rect0);
        }
        else {
            Rect rect1 = (Rect)accessibilityNodeInfo0.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if(rect1 != null) {
                rect0.set(rect1.left, rect1.top, rect1.right, rect1.bottom);
            }
        }
        stringBuilder0.append("; boundsInWindow: " + rect0);
        stringBuilder0.append("; packageName: ");
        stringBuilder0.append(accessibilityNodeInfo0.getPackageName());
        stringBuilder0.append("; className: ");
        stringBuilder0.append(accessibilityNodeInfo0.getClassName());
        stringBuilder0.append("; text: ");
        stringBuilder0.append(this.g());
        stringBuilder0.append("; error: ");
        stringBuilder0.append(accessibilityNodeInfo0.getError());
        stringBuilder0.append("; maxTextLength: ");
        stringBuilder0.append(accessibilityNodeInfo0.getMaxTextLength());
        stringBuilder0.append("; stateDescription: ");
        stringBuilder0.append((v < 30 ? accessibilityNodeInfo0.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY") : b.g(accessibilityNodeInfo0)));
        stringBuilder0.append("; contentDescription: ");
        stringBuilder0.append(accessibilityNodeInfo0.getContentDescription());
        stringBuilder0.append("; tooltipText: ");
        stringBuilder0.append((v < 28 ? accessibilityNodeInfo0.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY") : com.iloen.melon.utils.system.a.l(accessibilityNodeInfo0)));
        stringBuilder0.append("; viewIdResName: ");
        stringBuilder0.append(accessibilityNodeInfo0.getViewIdResourceName());
        stringBuilder0.append("; uniqueId: ");
        stringBuilder0.append((v < 33 ? accessibilityNodeInfo0.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY") : e.g(accessibilityNodeInfo0)));
        stringBuilder0.append("; checkable: ");
        stringBuilder0.append(accessibilityNodeInfo0.isCheckable());
        stringBuilder0.append("; checked: ");
        stringBuilder0.append(accessibilityNodeInfo0.isChecked());
        stringBuilder0.append("; fieldRequired: ");
        stringBuilder0.append(accessibilityNodeInfo0.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY"));
        stringBuilder0.append("; focusable: ");
        stringBuilder0.append(accessibilityNodeInfo0.isFocusable());
        stringBuilder0.append("; focused: ");
        stringBuilder0.append(accessibilityNodeInfo0.isFocused());
        stringBuilder0.append("; selected: ");
        stringBuilder0.append(accessibilityNodeInfo0.isSelected());
        stringBuilder0.append("; clickable: ");
        stringBuilder0.append(accessibilityNodeInfo0.isClickable());
        stringBuilder0.append("; longClickable: ");
        stringBuilder0.append(accessibilityNodeInfo0.isLongClickable());
        stringBuilder0.append("; contextClickable: ");
        stringBuilder0.append(accessibilityNodeInfo0.isContextClickable());
        stringBuilder0.append("; enabled: ");
        stringBuilder0.append(accessibilityNodeInfo0.isEnabled());
        stringBuilder0.append("; password: ");
        stringBuilder0.append(accessibilityNodeInfo0.isPassword());
        stringBuilder0.append("; scrollable: " + accessibilityNodeInfo0.isScrollable());
        stringBuilder0.append("; containerTitle: ");
        stringBuilder0.append((v < 34 ? accessibilityNodeInfo0.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY") : l.e(accessibilityNodeInfo0)));
        stringBuilder0.append("; granularScrollingSupported: ");
        stringBuilder0.append(this.e(0x4000000));
        stringBuilder0.append("; importantForAccessibility: ");
        stringBuilder0.append(accessibilityNodeInfo0.isImportantForAccessibility());
        stringBuilder0.append("; visible: ");
        stringBuilder0.append(accessibilityNodeInfo0.isVisibleToUser());
        stringBuilder0.append("; isTextSelectable: ");
        stringBuilder0.append((v < 33 ? this.e(0x800000) : e.h(accessibilityNodeInfo0)));
        stringBuilder0.append("; accessibilityDataSensitive: ");
        stringBuilder0.append((v < 34 ? this.e(0x40) : l.j(accessibilityNodeInfo0)));
        stringBuilder0.append("; [");
        List list0 = accessibilityNodeInfo0.getActionList();
        ArrayList arrayList0 = new ArrayList();
        int v1 = list0.size();
        for(int v3 = 0; v3 < v1; ++v3) {
            arrayList0.add(new c(list0.get(v3), 0, null, null, null));
        }
        for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
            c c0 = (c)arrayList0.get(v2);
            int v4 = c0.a();
            Object object0 = c0.a;
            String s = d.d(v4);
            if(s.equals("ACTION_UNKNOWN") && ((AccessibilityNodeInfo.AccessibilityAction)object0).getLabel() != null) {
                s = ((AccessibilityNodeInfo.AccessibilityAction)object0).getLabel().toString();
            }
            stringBuilder0.append(s);
            if(v2 != arrayList0.size() - 1) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }
}

