package com.iloen.melon.utils.ui;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import v9.e;
import v9.o;

public class EmptyOrErrorViewHelper {
    public static final View a(View view0) {
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "getEmptyOrErrorViewLayout() invalid view");
            return null;
        }
        return view0.findViewById(0x7F0A042C);  // id:empty_or_error_layout
    }

    public static void b(View view0, int v) {
        if(view0 != null && v > 0) {
            View view1 = view0.findViewById(v);
            if(view1 == null) {
                LogU.w("EmptyOrErrorViewHelper", "updateLayoutHeight() failed to find layout");
                return;
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            if(viewGroup$LayoutParams0 == null) {
                LogU.w("EmptyOrErrorViewHelper", "updateLayoutHeight() invalid layout params");
                return;
            }
            if(view0.getParent() == null) {
                viewGroup$LayoutParams0.height = view0.getContext().getResources().getDimensionPixelSize(0x7F070110);  // dimen:empty_or_network_error_layout_min_height
                return;
            }
            if(viewGroup$LayoutParams0 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = view0.getContext().getResources().getDimensionPixelSize(0x7F070055) * 2;  // dimen:bottom_container_height
            }
            return;
        }
        LogU.w("EmptyOrErrorViewHelper", "updateLayoutHeight() invalid view or resId");
    }

    public static void hideEmptyView(View view0) {
        View view1;
        LogU.v("EmptyOrErrorViewHelper", "hideEmptyView()");
        ViewUtils.hideWhen(EmptyOrErrorViewHelper.a(view0), true);
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "getEmptyViewLayout() invalid view");
            view1 = null;
        }
        else {
            view1 = view0.findViewById(0x7F0A042B);  // id:empty_layout
        }
        ViewUtils.hideWhen(view1, true);
    }

    public static void hideNetworkErrorView(View view0) {
        View view1;
        LogU.v("EmptyOrErrorViewHelper", "hideNetworkErrorView()");
        ViewUtils.hideWhen(EmptyOrErrorViewHelper.a(view0), true);
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "getNetworkErrorViewLayout() invalid view");
            view1 = null;
        }
        else {
            view1 = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
        }
        ViewUtils.hideWhen(view1, true);
    }

    public static void setEmptyViewInfo(View view0, e e0) {
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "setEmptyViewInfo() invalid view");
            return;
        }
        if(e0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "setEmptyViewInfo() invalid info");
            return;
        }
        if(e0.b) {
            LogU.v("EmptyOrErrorViewHelper", "resetEmptyView()");
            View view1 = view0.findViewById(0x7F0A042A);  // id:empty_image
            ViewUtils.showWhen(view1, true);
            if(view1 instanceof ImageView) {
                ((ImageView)view1).setImageResource(0x7F080786);  // drawable:noimage_logo_large
            }
            View view2 = view0.findViewById(0x7F0A042F);  // id:empty_text
            if(view2 instanceof TextView) {
                ((TextView)view2).setText(0x7F130389);  // string:empty_content_list "목록이 없습니다."
                ((TextView)view2).setTextColor(ColorUtils.getColor(view0.getContext(), 0x7F06010D));  // color:empty_or_network_error_layout_desc_text_color
            }
            View view3 = view0.findViewById(0x7F0A042E);  // id:empty_sub_text
            ViewUtils.hideWhen(view3, true);
            if(view3 instanceof TextView) {
                ((TextView)view3).setText("");
                ((TextView)view3).setTextColor(ColorUtils.getColor(view0.getContext(), 0x7F06010C));  // color:empty_or_network_error_layout_desc_sub_text_color
            }
            View view4 = view0.findViewById(0x7F0A0426);  // id:empty_button
            ViewUtils.setOnClickListener(view4, null);
            ViewUtils.hideWhen(view4, true);
            if(view4 instanceof TextView) {
                ((TextView)view4).setText("");
                ((TextView)view4).setTextColor(ColorUtils.getColor(view0.getContext(), 0x7F06010B));  // color:empty_or_network_error_layout_button_text_color
            }
        }
        else {
            Object object0 = view0.getTag();
            if(object0 instanceof e) {
                e0 = e.a(((e)object0), e0);
            }
            view0.setTag(e0);
            if(e0.d != -1) {
                view0.findViewById(0x7F0A042B).setBackgroundResource(e0.d);  // id:empty_layout
            }
            int v = e0.e;
            View view5 = view0.findViewById(0x7F0A042A);  // id:empty_image
            if(v != -1 && view5 instanceof ImageView) {
                ((ImageView)view5).setImageResource(e0.e);
            }
            String s = e0.f;
            int v1 = e0.g;
            if(!TextUtils.isEmpty(s)) {
                View view6 = view0.findViewById(0x7F0A042F);  // id:empty_text
                if(view6 instanceof TextView) {
                    ((TextView)view6).setText(s);
                    if(v1 != -1) {
                        ((TextView)view6).setTextColor(ColorUtils.getColor(view0.getContext(), v1));
                    }
                }
            }
            String s1 = e0.h;
            int v2 = e0.i;
            View view7 = view0.findViewById(0x7F0A042E);  // id:empty_sub_text
            if(!TextUtils.isEmpty(s1)) {
                ViewUtils.showWhen(view7, true);
                if(view7 instanceof TextView) {
                    ((TextView)view7).setText(s1);
                    if(v2 != -1) {
                        ((TextView)view7).setTextColor(ColorUtils.getColor(view0.getContext(), v2));
                    }
                }
            }
            String s2 = e0.j;
            int v3 = e0.k;
            int v4 = e0.l;
            View.OnClickListener view$OnClickListener0 = e0.m;
            View view8 = view0.findViewById(0x7F0A0426);  // id:empty_button
            if(!TextUtils.isEmpty(s2)) {
                ViewUtils.showWhen(view8, true);
                if(view8 instanceof TextView) {
                    ((TextView)view8).setText(s2);
                    if(v3 != -1) {
                        ((TextView)view8).setTextColor(ColorUtils.getColor(view0.getContext(), v3));
                    }
                    if(v4 != -1) {
                        ((TextView)view8).setBackgroundResource(v4);
                    }
                }
                if(view$OnClickListener0 != null) {
                    ViewUtils.setOnClickListener(view8, view$OnClickListener0);
                }
                if(v == -1) {
                    ViewUtils.hideWhen(view5, true);
                }
            }
        }
    }

    public static void setNetworkErrorViewInfo(View view0, o o0) {
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "setNetworkErrorViewInfo() invalid view");
            return;
        }
        if(o0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "setNetworkErrorViewInfo() invalid info");
            return;
        }
        Object object0 = view0.getTag();
        if(object0 instanceof o) {
            o0 = o.a(((o)object0), o0);
        }
        view0.setTag(o0);
        int v = o0.b;
        if(v != -1) {
            view0.findViewById(0x7F0A08A5).setBackgroundResource(v);  // id:network_error_layout
        }
        int v1 = o0.c;
        if(v1 != -1) {
            View view1 = view0.findViewById(0x7F0A08A4);  // id:network_error_info_icon
            if(view1 instanceof ImageView) {
                ((ImageView)view1).setImageResource(v1);
            }
        }
        String s = o0.d;
        int v2 = o0.e;
        if(!TextUtils.isEmpty(s)) {
            View view2 = view0.findViewById(0x7F0A08A3);  // id:network_error_desc_text
            if(view2 instanceof TextView) {
                ((TextView)view2).setText(s);
                if(v2 != -1) {
                    ((TextView)view2).setTextColor(ColorUtils.getColor(view0.getContext(), v2));
                }
            }
        }
        int v3 = o0.h;
        int v4 = o0.i;
        boolean z = false;
        boolean z1 = o0.f != null;
        View view3 = view0.findViewById(0x7F0A08A2);  // id:network_error_confirm_button
        ViewUtils.showWhen(view3, z1);
        if(view3 != null && z1) {
            ViewUtils.setOnClickListener(view3, o0.f);
            if(view3 instanceof TextView) {
                if(v3 != -1) {
                    ((TextView)view3).setTextColor(ColorUtils.getColor(view0.getContext(), v3));
                }
                if(v4 != -1) {
                    ((TextView)view3).setBackgroundResource(v4);
                }
            }
        }
        boolean z2 = o0.g != null;
        View view4 = view0.findViewById(0x7F0A08A6);  // id:network_error_retry_button
        ViewUtils.showWhen(view4, z2);
        if(view4 != null) {
            z = true;
        }
        if(z2 && z) {
            ViewUtils.setOnClickListener(view4, o0.g);
            if(view3 instanceof TextView) {
                if(v3 != -1) {
                    ((TextView)view4).setTextColor(ColorUtils.getColor(view0.getContext(), v3));
                }
                if(v4 != -1) {
                    ((TextView)view4).setBackgroundResource(v4);
                }
            }
        }
    }

    public static void showEmptyView(View view0) {
        EmptyOrErrorViewHelper.showEmptyView(view0, null);
    }

    public static void showEmptyView(View view0, e e0) {
        View view1;
        LogU.v("EmptyOrErrorViewHelper", "showEmptyView()");
        EmptyOrErrorViewHelper.setEmptyViewInfo(view0, e0);
        ViewUtils.showWhen(EmptyOrErrorViewHelper.a(view0), true);
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "getEmptyViewLayout() invalid view");
            view1 = null;
        }
        else {
            view1 = view0.findViewById(0x7F0A042B);  // id:empty_layout
        }
        ViewUtils.showWhen(view1, true);
        EmptyOrErrorViewHelper.b(view0, 0x7F0A042B);  // id:empty_layout
    }

    public static void showNetworkErrorView(View view0) {
        EmptyOrErrorViewHelper.showNetworkErrorView(view0, null);
    }

    public static void showNetworkErrorView(View view0, o o0) {
        View view1;
        LogU.v("EmptyOrErrorViewHelper", "showNetworkErrorView()");
        EmptyOrErrorViewHelper.setNetworkErrorViewInfo(view0, o0);
        ViewUtils.showWhen(EmptyOrErrorViewHelper.a(view0), true);
        if(view0 == null) {
            LogU.w("EmptyOrErrorViewHelper", "getNetworkErrorViewLayout() invalid view");
            view1 = null;
        }
        else {
            view1 = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
        }
        ViewUtils.showWhen(view1, true);
        EmptyOrErrorViewHelper.b(view0, 0x7F0A08A5);  // id:network_error_layout
    }
}

