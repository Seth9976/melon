package com.iloen.melon.custom;

import A6.d;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b3.Z;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.color.DrawableColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import java.util.LinkedList;

public class ToolBar extends FrameLayout {
    public static class ToolBarItem {
        public Context a;
        public ViewGroup b;
        public int c;

    }

    public final Context a;
    public RelativeLayout b;
    public ViewGroup c;
    public TextView d;
    public Animation e;
    public Animation f;
    public s1 g;
    public r1 h;
    public final LinkedList i;
    public int j;
    public boolean k;
    public final Handler l;
    public final p1 m;
    public final q1 n;
    public final q1 o;
    public static final int r;

    public ToolBar(Context context0) {
        super(context0);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = new LinkedList();
        this.j = -1;
        this.k = false;
        this.l = new Handler(Looper.getMainLooper());
        this.m = new p1(this);
        this.n = new q1(this, 0);
        this.o = new q1(this, 1);
        this.a = context0;
        this.e();
    }

    public ToolBar(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = new LinkedList();
        this.j = -1;
        this.k = false;
        this.l = new Handler(Looper.getMainLooper());
        this.m = new p1(this);
        this.n = new q1(this, 0);
        this.o = new q1(this, 1);
        this.a = context0;
        this.e();
    }

    public ToolBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = new LinkedList();
        this.j = -1;
        this.k = false;
        this.l = new Handler(Looper.getMainLooper());
        this.m = new p1(this);
        this.n = new q1(this, 0);
        this.o = new q1(this, 1);
        this.a = context0;
        this.e();
    }

    public final ToolBarItem a(t1 t10) {
        LinkedList linkedList0 = this.i;
        if(linkedList0.size() >= 5) {
            LogU.w("ToolBar", "addRemoteDevice() max count limit");
            return null;
        }
        linkedList0.add(t10);
        ViewGroup viewGroup0 = t10.b;
        viewGroup0.setClickable(true);
        this.c.addView(viewGroup0, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.setToolBarItem(t10);
        this.m(t10.c);
        return t10;
    }

    public final void b(int v, int v1, int v2) {
        t1 t10 = new t1(this.a, v, v1);
        t10.c = v2;
        t10.f = ColorUtils.getColor(t10.a, 0x7F0604A1);  // color:white000e
        this.a(t10);
    }

    public static void c(ToolBar toolBar0, int v) {
        if(toolBar0 == null) {
            LogU.w("ToolBar", "changeLayoutType() - invalid parameter");
            return;
        }
        if(toolBar0.getToolBarLayoutType() == v) {
            LogU.d("ToolBar", "changeLayoutType() - same layout type");
            return;
        }
        toolBar0.g();
        ToolBar.f(toolBar0, v);
    }

    public final void d() {
        ViewUtils.hideWhen(this.d, true);
    }

    public final void e() {
        if(this.isInEditMode()) {
            return;
        }
        LogU.d("ToolBar", "initLayout()");
        Context context0 = this.a;
        RelativeLayout relativeLayout0 = (RelativeLayout)((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D089C, null);  // layout:toolbar_item_layout
        this.b = relativeLayout0;
        this.c = (ViewGroup)relativeLayout0.findViewById(0x7F0A05A7);  // id:item_container
        this.d = (TextView)this.b.findViewById(0x7F0A0C50);  // id:tv_count
        Context context1 = this.getContext();
        if(context1 != null) {
            int v = ColorUtils.getColor(context1, 0x7F06017E);  // color:green502e_support_high_contrast
            this.c.setBackgroundColor(v);
            DrawableColorUtils.changeDrawableStrokeColor(this.d, ScreenUtils.dipToPixel(context1, 1.5f), v);
            this.d.setTextColor(v);
        }
        this.addView(this.b, new LinearLayout.LayoutParams(-1, -1));
        LogU.d("ToolBar", "initAnimation()");
        Animation animation0 = AnimationUtils.loadAnimation(context0, 0x7F010045);  // anim:push_bottom_in
        this.e = animation0;
        animation0.setAnimationListener(this.n);
        Animation animation1 = AnimationUtils.loadAnimation(context0, 0x7F010046);  // anim:push_bottom_out
        this.f = animation1;
        animation1.setAnimationListener(this.o);
    }

    public static ToolBar f(ToolBar toolBar0, int v) {
        if(toolBar0 == null) {
            LogU.w("ToolBar", "initLayoutType() - invalid parameter");
            return null;
        }
        LogU.i("ToolBar", "initLayoutType: " + v);
        toolBar0.setToolBarLayoutType(v);
        if(v != 0) {
            switch(v) {
                case 1: {
                    toolBar0.b(0x7F080163, 0x7F131087, 0);  // drawable:btn_common_play_24
                    toolBar0.b(0x7F080136, 0x7F131081, 3);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 2: {
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 3: {
                    toolBar0.b(0x7F0805CD, 0x7F13090C, 19);  // drawable:ic_select_replay
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 5: {
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 100: {
                    toolBar0.b(0x7F08012F, 0x7F13107D, 4);  // drawable:btn_common_delete_24
                    toolBar0.b(0x7F08012F, 0x7F13107A, 5);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 101: {
                    toolBar0.b(0x7F08012D, 0x7F131080, 6);  // drawable:btn_common_dcf_24
                    toolBar0.b(0x7F08012F, 0x7F13107B, 7);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 102: {
                    toolBar0.b(0x7F080163, 0x7F131087, 0);  // drawable:btn_common_play_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 103: {
                    toolBar0.b(0x7F0805B3, 0x7F131092, 10);  // drawable:ic_player_select_list_movie
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    return toolBar0;
                }
                case 104: {
                    toolBar0.b(0x7F080163, 0x7F131087, 0);  // drawable:btn_common_play_24
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    return toolBar0;
                }
                case 105: {
                    toolBar0.b(0x7F080195, 0x7F1304B0, 25);  // drawable:btn_eq_bottom_refresh
                    toolBar0.b(0x7F080194, 0x7F1308D4, 24);  // drawable:btn_eq_bottom_check
                    return toolBar0;
                }
                case 500: {
                    toolBar0.b(0x7F0805B3, 0x7F131092, 10);  // drawable:ic_player_select_list_movie
                    return toolBar0;
                }
                case 501: {
                    toolBar0.b(0x7F080151, 0x7F131084, 11);  // drawable:btn_common_like_cancel_24
                    return toolBar0;
                }
                case 502: {
                    toolBar0.b(0x7F08012F, 0x7F13107C, 12);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 503: {
                    toolBar0.b(0x7F08013B, 0x7F131078, 13);  // drawable:btn_common_except_24
                    return toolBar0;
                }
                case 504: {
                    toolBar0.b(0x7F08011E, 0x7F131077, 9);  // drawable:btn_common_add_circle_24
                    return toolBar0;
                }
                case 505: {
                    toolBar0.b(0x7F080147, 0x7F13108D, 14);  // drawable:btn_common_gift_24
                    return toolBar0;
                }
                case 506: {
                    toolBar0.b(0x7F0804AB, 0x7F13108C, 15);  // drawable:ic_m_message_white
                    return toolBar0;
                }
                case 507: {
                    toolBar0.b(0x7F08012F, 0x7F131079, 16);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 508: {
                    toolBar0.b(0x7F08014C, 0x7F13108B, 21);  // drawable:btn_common_like_24
                    return toolBar0;
                }
                case 509: {
                    toolBar0.b(0x7F0805C6, 0x7F13107E, 22);  // drawable:ic_radio_list_heart_cancel
                    return toolBar0;
                }
                case 510: {
                    toolBar0.b(0x7F08011E, 0x7F131076, 23);  // drawable:btn_common_add_circle_24
                    return toolBar0;
                }
                case 0x1FF: {
                    toolBar0.b(0x7F08013B, 0x7F131082, 26);  // drawable:btn_common_except_24
                    return toolBar0;
                }
                case 0x200: {
                    toolBar0.b(0x7F08013B, 0x7F131091, 27);  // drawable:btn_common_except_24
                    return toolBar0;
                }
                case 0x201: {
                    toolBar0.b(0x7F08011E, 0x7F13108F, 28);  // drawable:btn_common_add_circle_24
                    return toolBar0;
                }
                case 0x202: {
                    toolBar0.b(0x7F08013B, 0x7F13108E, 29);  // drawable:btn_common_except_24
                    return toolBar0;
                }
                case 0x203: {
                    t1 t10 = new t1(toolBar0.a, -1, 0x7F131083);  // string:toolbar_highlight_apply "하이라이팅 적용"
                    t10.c = 30;
                    t10.f = ColorUtils.getColor(t10.a, 0x7F0604A1);  // color:white000e
                    t10.g = 15.0f;
                    toolBar0.a(t10);
                    return toolBar0;
                }
                case 600: {
                    toolBar0.b(0x7F080195, 0x7F1304B0, 25);  // drawable:btn_eq_bottom_refresh
                    toolBar0.b(0x7F080194, 0x7F1308D4, 24);  // drawable:btn_eq_bottom_check
                    return toolBar0;
                }
                case 700: {
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 1000: {
                    toolBar0.b(0x7F080163, 0x7F131087, 0);  // drawable:btn_common_play_24
                    toolBar0.b(0x7F080156, 0x7F131085, 0x1F);  // drawable:btn_common_mixup_24
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F080147, 0x7F131089, 14);  // drawable:btn_common_gift_24
                    return toolBar0;
                }
                case 1001: {
                    toolBar0.b(0x7F080163, 0x7F131087, 0);  // drawable:btn_common_play_24
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F080164, 0x7F131088, 17);  // drawable:btn_common_playlist_24
                    toolBar0.b(0x7F08011D, 0x7F131086, 18);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 1002: {
                    toolBar0.b(0x7F0805CD, 0x7F13090C, 19);  // drawable:ic_select_replay
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 1003: {
                    toolBar0.b(0x7F0805CD, 0x7F13090C, 19);  // drawable:ic_select_replay
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    toolBar0.b(0x7F0805CE, 0x7F131090, 20);  // drawable:ic_select_turn
                    return toolBar0;
                }
                case 1004: {
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    toolBar0.b(0x7F0805CE, 0x7F131090, 20);  // drawable:ic_select_turn
                    return toolBar0;
                }
                case 1005: {
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    toolBar0.b(0x7F0805CE, 0x7F131090, 20);  // drawable:ic_select_turn
                    return toolBar0;
                }
                case 1006: {
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 1007: {
                    toolBar0.b(0x7F08016C, 0x7F13090C, 19);  // drawable:btn_common_repeat_24
                    toolBar0.b(0x7F080156, 0x7F131085, 0x1F);  // drawable:btn_common_mixup_24
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 0x3F0: {
                    toolBar0.b(0x7F080156, 0x7F131085, 0x1F);  // drawable:btn_common_mixup_24
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    return toolBar0;
                }
                case 1009: {
                    toolBar0.b(0x7F08016C, 0x7F13090C, 19);  // drawable:btn_common_repeat_24
                    toolBar0.b(0x7F080156, 0x7F131085, 0x1F);  // drawable:btn_common_mixup_24
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 1010: {
                    toolBar0.b(0x7F080195, 0x7F1304B0, 25);  // drawable:btn_eq_bottom_refresh
                    toolBar0.b(0x7F08011D, 0x7F130393, 8);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 0x3F3: {
                    toolBar0.b(0x7F080195, 0x7F1304B0, 25);  // drawable:btn_eq_bottom_refresh
                    toolBar0.b(0x7F080194, 0x7F1308D3, 24);  // drawable:btn_eq_bottom_check
                    toolBar0.b(0x7F08011D, 0x7F130393, 8);  // drawable:btn_common_add_24
                    return toolBar0;
                }
                case 10000: {
                    toolBar0.b(0x7F0805CD, 0x7F13090C, 19);  // drawable:ic_select_replay
                    toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
                    toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
                    toolBar0.b(0x7F08012F, 0x7F131079, 4);  // drawable:btn_common_delete_24
                    toolBar0.b(0x7F0805CE, 0x7F131090, 20);  // drawable:ic_select_turn
                    return toolBar0;
                }
                default: {
                    return toolBar0;
                }
            }
        }
        toolBar0.b(0x7F080163, 0x7F131087, 0);  // drawable:btn_common_play_24
        toolBar0.b(0x7F080136, 0x7F13107F, 1);  // drawable:btn_common_down_24
        toolBar0.b(0x7F08011D, 0x7F13108A, 2);  // drawable:btn_common_add_24
        return toolBar0;
    }

    public final void g() {
        this.c.removeAllViewsInLayout();
        this.c.removeAllViews();
        LinkedList linkedList0 = this.i;
        if(linkedList0 != null && linkedList0.size() > 0) {
            linkedList0.clear();
        }
    }

    public int getItemCount() {
        return this.i == null ? 0 : this.i.size();
    }

    public r1 getOnToolBarAnimationListener() {
        return this.h;
    }

    public int getToolBarLayoutType() {
        return this.j;
    }

    public final void h(boolean z) {
        LogU.d("ToolBar", "showAnimation() show:" + z);
        if(this.k) {
            LogU.w("ToolBar", "showAnimation() not supported - fixed type");
            return;
        }
        if(this.getAnimation() != null) {
            this.clearAnimation();
        }
        y0 y00 = new y0(this, z);
        this.l.post(y00);
    }

    public final void i(boolean z) {
        this.k = z;
        if(this.b != null && this.b.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)this.b.getLayoutParams();
            frameLayout$LayoutParams0.bottomMargin = 0;
            this.b.setLayoutParams(frameLayout$LayoutParams0);
        }
    }

    public final void j(int v, boolean z) {
        LinkedList linkedList0 = this.i;
        int v1 = linkedList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            ToolBarItem toolBar$ToolBarItem0 = (ToolBarItem)linkedList0.get(v2);
            ViewGroup viewGroup0 = toolBar$ToolBarItem0.b;
            if(toolBar$ToolBarItem0.c == v) {
                ViewUtils.setEnable(viewGroup0, z);
                viewGroup0.setFocusable(z);
                viewGroup0.setClickable(z);
                ViewUtils.setOnClickListener(viewGroup0, (z ? this.m : null));
                return;
            }
        }
    }

    public final void k(int v, int v1) {
        ToolBarItem toolBar$ToolBarItem1;
        if(v1 < 0) {
            LogU.w("ToolBar", "getItem() invalid itemId");
        }
        else {
            for(Object object0: this.i) {
                ToolBarItem toolBar$ToolBarItem0 = (ToolBarItem)object0;
                if(toolBar$ToolBarItem0.c != v1) {
                    continue;
                }
                toolBar$ToolBarItem1 = toolBar$ToolBarItem0;
                goto label_11;
            }
        }
        toolBar$ToolBarItem1 = null;
    label_11:
        if(((t1)toolBar$ToolBarItem1) == null) {
            this.b(0x7F08013B, v, v1);  // drawable:btn_common_except_24
            return;
        }
        Drawable drawable0 = ((t1)toolBar$ToolBarItem1).a.getResources().getDrawable(0x7F08013B);  // drawable:btn_common_except_24
        if(((t1)toolBar$ToolBarItem1).d != null) {
            ((t1)toolBar$ToolBarItem1).d = null;
        }
        ((t1)toolBar$ToolBarItem1).d = drawable0;
        if(v != -1) {
            String s = ((t1)toolBar$ToolBarItem1).a.getResources().getString(v);
            if(((t1)toolBar$ToolBarItem1).e != null) {
                ((t1)toolBar$ToolBarItem1).e = null;
            }
            ((t1)toolBar$ToolBarItem1).e = s;
        }
        this.setToolBarItem(((t1)toolBar$ToolBarItem1));
    }

    public final void l(int v) {
        TextView textView0 = this.d;
        if(textView0 != null) {
            if(textView0.getVisibility() != 0) {
                ViewUtils.showWhen(this.d, true);
            }
            float f = this.d.getTextSize();
            int v1 = this.getResources().getDimensionPixelSize((v < 1000 ? 0x7F070462 : 0x7F070463));  // dimen:toolbar_count_number_large
            LogU.d("ToolBar", "showAndUpdateCountView() textSize:" + f + ", fontSize:" + v1);
            if(f != ((float)v1)) {
                this.d.setTextSize(0, ((float)v1));
            }
            this.d.setText(Integer.toString(v));
            this.c.setContentDescription(String.format("하단 툴바, 총 %1$s 곡 선택됨", this.d.getText().toString()));
            if(AppUtils.isAccessibilityTalkbackOn()) {
                new Handler(Looper.getMainLooper()).postDelayed(new d(this, v, 9), 1000L);
            }
        }
    }

    public final void m(int v) {
        p1 p10 = this.m;
        LinkedList linkedList0 = this.i;
        if(v == -1) {
            for(Object object0: linkedList0) {
                ViewUtils.setOnClickListener(((ToolBarItem)object0).b, p10);
            }
        }
        else {
            for(Object object1: linkedList0) {
                ViewGroup viewGroup0 = ((ToolBarItem)object1).b;
                if(((ToolBarItem)object1).c == v) {
                    ViewUtils.setOnClickListener(viewGroup0, p10);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(v == -1 && this.getVisibility() == 8) {
            this.setVisibility(0);
        }
        this.requestLayout();
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        ViewGroup viewGroup0 = this.c;
        if(viewGroup0 != null) {
            viewGroup0.setBackgroundColor(v);
        }
    }

    public void setFixedView(boolean z) {
        this.i(z);
    }

    public void setOnToolBarAnimationListener(r1 r10) {
        this.h = r10;
    }

    public void setOnToolBarListener(s1 s10) {
        this.g = s10;
    }

    private void setToolBarItem(ToolBarItem toolBar$ToolBarItem0) {
        StringBuilder stringBuilder0 = new StringBuilder("setToolBarItem() itemId:");
        Z.s(toolBar$ToolBarItem0.c, "ToolBar", stringBuilder0);
        TextView textView0 = (TextView)toolBar$ToolBarItem0.b.findViewById(0x7F0A01C0);  // id:btn_toolbar
        Drawable drawable0 = ((t1)toolBar$ToolBarItem0).d;
        String s = ((t1)toolBar$ToolBarItem0).e;
        if(drawable0 == null) {
            textView0.setTextSize(1, ((t1)toolBar$ToolBarItem0).g);
        }
        else {
            Context context0 = this.a;
            if(this.j < 500 || this.j >= 1000) {
                textView0.setCompoundDrawablesWithIntrinsicBounds(null, drawable0, null, null);
                textView0.setPadding(0, 0, 0, ScreenUtils.dipToPixel(context0, 3.0f));
            }
            else {
                textView0.setCompoundDrawablesWithIntrinsicBounds(drawable0, null, null, null);
                textView0.setTextSize(1, 14.0f);
                textView0.setCompoundDrawablePadding(ScreenUtils.dipToPixel(context0, 6.0f));
            }
        }
        if(!TextUtils.isEmpty(s)) {
            textView0.setText(s);
            ViewUtilsKt.setAccessibilityButtonClassName(textView0);
            int v = ((t1)toolBar$ToolBarItem0).f;
            if(v > 0) {
                textView0.setTextColor(v);
            }
        }
    }

    public void setToolBarItemLayoutHeight(int v) {
        ViewGroup viewGroup0 = this.c;
        if(viewGroup0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = viewGroup0.getLayoutParams();
            viewGroup$LayoutParams0.height = v;
            this.c.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    public void setToolBarLayoutType(int v) {
        this.j = v;
        if(v != 3 && v != 1002 && v != 1003 && v != 10000) {
            return;
        }
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
        viewGroup$MarginLayoutParams0.setMargins(ScreenUtils.dipToPixel(this.a, 9.0f), 0, 0, ScreenUtils.dipToPixel(this.a, -12.0f));
        this.d.setLayoutParams(viewGroup$MarginLayoutParams0);
    }
}

