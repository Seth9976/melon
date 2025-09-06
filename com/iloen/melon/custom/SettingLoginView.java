package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;

public class SettingLoginView extends FrameLayout {
    public View.OnClickListener a;
    public c1 b;
    public View c;
    public View d;
    public View e;
    public View f;

    public SettingLoginView(Context context0) {
        super(context0);
        this.b = c1.a;
        if(this.isInEditMode()) {
            return;
        }
        this.a();
    }

    public SettingLoginView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = c1.a;
        if(this.isInEditMode()) {
            return;
        }
        this.a();
    }

    public SettingLoginView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.b = c1.a;
        if(this.isInEditMode()) {
            return;
        }
        this.a();
    }

    public final void a() {
        View.inflate(this.getContext(), 0x7F0D0833, this);  // layout:setting_login_item
        this.c = this.findViewById(0x7F0A07AE);  // id:logout
        this.d = this.findViewById(0x7F0A0BC0);  // id:token_login
        this.e = this.findViewById(0x7F0A0553);  // id:id_pwd_login
        this.f = this.findViewById(0x7F0A06C6);  // id:kakao_login
        this.setViewType(c1.a);
    }

    public c1 getViewType() {
        return this.b;
    }

    @Override  // android.view.View
    public void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.a = view$OnClickListener0;
    }

    public void setUserId(String s) {
        TextView textView0;
        if(c1.b.equals(this.b)) {
            textView0 = (TextView)this.findViewById(0x7F0A0BC3);  // id:token_login_text
        }
        else if(c1.c.equals(this.b)) {
            textView0 = (TextView)this.findViewById(0x7F0A0C8C);  // id:tv_id_pwd_login_text
        }
        else if(c1.d.equals(this.b)) {
            textView0 = (TextView)this.findViewById(0x7F0A06C9);  // id:kakao_login_text
            ViewUtils.hideWhen(this.findViewById(0x7F0A06C7), true);  // id:kakao_login_arrow
            ViewUtils.hideWhen(this.findViewById(0x7F0A06C8), true);  // id:kakao_login_sub_text
            ViewUtils.showWhen(this.findViewById(0x7F0A06CA), true);  // id:kakao_logout_button
        }
        else if(c1.e.equals(this.b)) {
            textView0 = (TextView)this.findViewById(0x7F0A06C9);  // id:kakao_login_text
            ViewUtils.showWhen(this.findViewById(0x7F0A06C7), true);  // id:kakao_login_arrow
            ViewUtils.showWhen(this.findViewById(0x7F0A06C8), true);  // id:kakao_login_sub_text
            ViewUtils.hideWhen(this.findViewById(0x7F0A06CA), true);  // id:kakao_logout_button
        }
        else {
            LogU.w("SettingLoginView", "setUserId() not supported");
            textView0 = null;
        }
        if(textView0 != null) {
            textView0.setText(s);
        }
    }

    public void setViewType(c1 c10) {
        this.b = c10;
        ViewUtils.hideWhen(this.c, true);
        ViewUtils.hideWhen(this.d, true);
        ViewUtils.hideWhen(this.e, true);
        ViewUtils.hideWhen(this.f, true);
        ViewUtils.setOnClickListener(this.c, null);
        ViewUtils.setOnClickListener(this.d, null);
        ViewUtils.setOnClickListener(this.f, null);
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0167), null);  // id:btn_id_pwd_login
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A06CA), null);  // id:kakao_logout_button
        ViewUtils.setContentDescriptionWithButtonClassName(this.findViewById(0x7F0A0167), "로그아웃");  // id:btn_id_pwd_login
        ViewUtils.setContentDescriptionWithButtonClassName(this.findViewById(0x7F0A06CA), "로그아웃");  // id:kakao_logout_button
        if(c1.b.equals(c10)) {
            ViewUtils.showWhen(this.d, true);
            ViewUtils.setOnClickListener(this.d, this.a);
            return;
        }
        if(c1.c.equals(c10)) {
            ViewUtils.showWhen(this.e, true);
            ViewUtils.setOnClickListener(this.findViewById(0x7F0A0167), this.a);  // id:btn_id_pwd_login
            return;
        }
        if(c1.d.equals(c10)) {
            ViewUtils.showWhen(this.f, true);
            ViewUtils.setOnClickListener(this.findViewById(0x7F0A06CA), this.a);  // id:kakao_logout_button
            return;
        }
        if(c1.e.equals(c10)) {
            ViewUtils.showWhen(this.f, true);
            ViewUtils.setOnClickListener(this.f, this.a);
            return;
        }
        ViewUtils.showWhen(this.c, true);
        ViewUtils.setOnClickListener(this.c, this.a);
    }
}

