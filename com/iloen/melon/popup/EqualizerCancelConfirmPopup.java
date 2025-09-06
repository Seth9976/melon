package com.iloen.melon.popup;

import E9.w;
import Tf.o;
import U8.K;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.google.gson.n;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.interfaces.UiRefreshListener;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.melon.ui.popup.b;
import ie.m;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w9.a;
import y8.k;
import y8.l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001E2\u00020\u00012\u00020\u0002:\u0002\u001F\u001EB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0007\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001A\u00020\u00102\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u001D\u0010\u001C¨\u0006 "}, d2 = {"Lcom/iloen/melon/popup/EqualizerCancelConfirmPopup;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "", "levels", "<init>", "(Landroid/content/Context;[F)V", "LU8/K;", "unit", "", "type", "(Landroid/content/Context;LU8/K;I)V", "Lcom/iloen/melon/interfaces/UiRefreshListener;", "listener", "Lie/H;", "setOnRefreshListener", "(Lcom/iloen/melon/interfaces/UiRefreshListener;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onStart", "()V", "onStop", "Companion", "Type", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EqualizerCancelConfirmPopup extends Dialog implements View.OnClickListener {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/popup/EqualizerCancelConfirmPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "EQ_NAME_MAX_LENGTH", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/popup/EqualizerCancelConfirmPopup$Type;", "", "", "ADD", "I", "EDIT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Type {
        public static final int $stable = 0;
        public static final int ADD = 0;
        public static final int EDIT = 1;
        @NotNull
        public static final Type INSTANCE;

        static {
            Type.INSTANCE = new Type();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public MelonEditText a;
    public final K b;
    public MelonDb c;
    public UiRefreshListener d;
    public final int e;
    public ImageView f;

    static {
        EqualizerCancelConfirmPopup.Companion = new Companion(null);
        EqualizerCancelConfirmPopup.$stable = 8;
    }

    public EqualizerCancelConfirmPopup(@NotNull Context context0, @NotNull K k0, int v) {
        q.g(context0, "context");
        q.g(k0, "unit");
        super(context0);
        this.b = k0;
        this.e = v;
    }

    public EqualizerCancelConfirmPopup(@NotNull Context context0, @NotNull float[] arr_f) {
        q.g(context0, "context");
        q.g(arr_f, "levels");
        super(context0);
        K k0 = new K();
        this.b = k0;
        k0.e = arr_f;
        k0.c = 6;
        this.e = 0;
    }

    public static final MelonEditText access$getMEditText$p(EqualizerCancelConfirmPopup equalizerCancelConfirmPopup0) {
        return equalizerCancelConfirmPopup0.a;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(@NotNull View view0) {
        long v1;
        String s;
        q.g(view0, "v");
        if(view0.getId() == 0x7F0A043C) {  // id:eq_btn_confirm
            MelonEditText melonEditText0 = this.a;
            q.d(melonEditText0);
            Editable editable0 = melonEditText0.getText();
            if(editable0 == null) {
                s = "";
            }
            else {
                s = editable0.toString();
                if(s == null) {
                    s = "";
                }
            }
            if(s.length() == 0) {
                BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
                if(baseActivity0 != null && !baseActivity0.isFinishing()) {
                    b.d(b.a, baseActivity0.getSupportFragmentManager(), "안내", "적용된 EQ명이 없습니다.\nEQ저장을 위한 이름을 입력해주세요.", false, false, false, null, null, null, null, null, 2040);
                    return;
                }
            }
            else {
                MelonDb melonDb0 = this.c;
                if(melonDb0 != null) {
                    int v = this.e;
                    K k0 = this.b;
                    if(v == 1) {
                        melonDb0.updateOrAddUserEqualizer(k0.b, s, k0.e);
                        v1 = -1L;
                    }
                    else {
                        v1 = melonDb0.addUserEqualizer(s, k0.e);
                    }
                    if(v == 0) {
                        k0.b = (int)v1;
                    }
                    k0.getClass();
                    k0.d = s;
                    l.i(k0);
                    k k1 = new k(2, 6, k0.b, k0.d, k0.e);
                    MelonPrefs.getInstance().setString("g_eq_status", new n().k(k1));
                    UiRefreshListener uiRefreshListener0 = this.d;
                    if(uiRefreshListener0 != null) {
                        uiRefreshListener0.a();
                    }
                    this.dismiss();
                }
            }
            return;
        }
        InputMethodUtils.hideInputMethod(this.getContext(), this.a);
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setCanceledOnTouchOutside(false);
        this.requestWindowFeature(1);
        Window window0 = this.getWindow();
        q.d(window0);
        window0.setBackgroundDrawable(new ColorDrawable(0));
        this.setContentView(0x7F0D0257);  // layout:eq_cancel_confirm_popup
        View view0 = this.findViewById(0x7F0A0444);  // id:eq_title
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view0).setText((this.e == 1 ? 0x7F1303A7 : 0x7F130393));  // string:eq_save_user_set "마이 EQ 저장"
        View view1 = this.findViewById(0x7F0A0451);  // id:et_eq_name
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonEditText");
        this.a = (MelonEditText)view1;
        View view2 = this.findViewById(0x7F0A014A);  // id:btn_clear
        q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
        this.f = (ImageView)view2;
        ((ImageView)view2).setOnClickListener(new t(this, 0));
        MelonEditText melonEditText0 = this.a;
        q.d(melonEditText0);
        melonEditText0.setTextLimitUpdate(true);
        MelonEditText melonEditText1 = this.a;
        q.d(melonEditText1);
        melonEditText1.addTextChangedListener(new TextWatcher() {
            public final EqualizerCancelConfirmPopup a;

            {
                this.a = equalizerCancelConfirmPopup0;
            }

            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
                m m0;
                boolean z;
                EqualizerCancelConfirmPopup equalizerCancelConfirmPopup0 = this.a;
                View view0 = equalizerCancelConfirmPopup0.findViewById(0x7F0A043C);  // id:eq_btn_confirm
                MelonEditText melonEditText0 = EqualizerCancelConfirmPopup.access$getMEditText$p(equalizerCancelConfirmPopup0);
                int v = 0;
                if(melonEditText0 == null) {
                    z = false;
                    m0 = new m(Boolean.TRUE, 1.0f);
                }
                else {
                    z = true;
                    Editable editable1 = melonEditText0.getText();
                    if(editable1 != null && o.H0(editable1)) {
                        m0 = new m(Boolean.FALSE, 0.3f);
                    }
                    else {
                        z = false;
                        m0 = new m(Boolean.TRUE, 1.0f);
                    }
                }
                boolean z1 = ((Boolean)m0.a).booleanValue();
                float f = ((Number)m0.b).floatValue();
                if(view0 != null) {
                    view0.setAlpha(f);
                    view0.setEnabled(z1);
                }
                ImageView imageView0 = equalizerCancelConfirmPopup0.f;
                if(imageView0 != null) {
                    if(z) {
                        v = 8;
                    }
                    imageView0.setVisibility(v);
                }
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }
        });
        MelonEditText melonEditText2 = this.a;
        q.d(melonEditText2);
        melonEditText2.setTextLimit(w.I(20));
        MelonEditText melonEditText3 = this.a;
        q.d(melonEditText3);
        melonEditText3.setText(this.b.d);
        View view3 = this.findViewById(0x7F0A0440);  // id:eq_result_message
        q.e(view3, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view3).setText((this.e == 1 ? 0x7F13039F : 0x7F1303A0));  // string:eq_edit_my_setting_message "선택한 마이 EQ를 수정합니다."
        this.findViewById(0x7F0A0950).setOnClickListener(this);  // id:popup_container
        this.findViewById(0x7F0A043C).setOnClickListener(this);  // id:eq_btn_confirm
        this.findViewById(0x7F0A043B).setOnClickListener(new t(this, 1));  // id:eq_btn_cancel
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.c = a.a.h();
        LogU.Companion.d("EqualizerConfirmPopup", "initEqConfirmPopupView : " + this.b);
        MelonEditText melonEditText0 = this.a;
        q.d(melonEditText0);
        melonEditText0.setText(this.b.d);
    }

    @Override  // android.app.Dialog
    public void onStop() {
        super.onStop();
        InputMethodUtils.hideInputMethod(this.getContext(), this.a);
        if(this.c != null) {
            a.a.d();
            this.c = null;
        }
    }

    public final void setOnRefreshListener(@Nullable UiRefreshListener uiRefreshListener0) {
        this.d = uiRefreshListener0;
    }
}

