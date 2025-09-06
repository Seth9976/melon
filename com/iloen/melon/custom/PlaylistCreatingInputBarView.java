package com.iloen.melon.custom;

import E8.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PlaylistCreatingInputBarView extends RelativeLayout implements Y {
    public J0 a;
    public K0 b;
    public final View c;
    public final InputBarView d;
    public String e;
    public String f;
    public long g;
    public static final int h;

    public PlaylistCreatingInputBarView(Context context0) {
        this(context0, null);
    }

    public PlaylistCreatingInputBarView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.g = 0L;
        if(this.isInEditMode()) {
            return;
        }
        LayoutInflater.from(this.getContext()).inflate(0x7F0D0597, this, true);  // layout:playlist_creating_input_bar_view
        View view0 = this.findViewById(0x7F0A035D);  // id:creating_bar
        this.c = view0;
        ViewUtils.setOnClickListener(view0, new a(this, 6));
        InputBarView inputBarView0 = (InputBarView)this.findViewById(0x7F0A0582);  // id:input_bar
        this.d = inputBarView0;
        inputBarView0.setOnInputBarListener(this);
        MelonLimits.TextLimit melonLimits$TextLimit0 = this.getTextLimit();
        this.d.setInputTextLimit(melonLimits$TextLimit0);
        EditText editText0 = this.d.getInputTextView();
        editText0.setImeOptions(6);
        editText0.setOnEditorActionListener(new I0(this));
    }

    public boolean a() {
        return false;
    }

    public final void b() {
        K0 k00 = this.b;
        if(k00 != null) {
            k00.onNewListButtonClicked();
            return;
        }
        String s = TextUtils.isEmpty(this.e) ? new SimpleDateFormat("yyyy.MM.dd HH:mm").format(Calendar.getInstance().getTime()) : this.e;
        this.d.setInputText(s);
        this.d.setHint(0x7F130834);  // string:playlist_no_title_msg "제목을 입력해주세요."
        ViewUtils.hideWhen(this.c, true);
        ViewUtils.showWhen(this.d, true);
        InputMethodUtils.showInputMethod(this.d.getContext(), this.d.c);
        J0 j00 = this.a;
        if(j00 != null) {
            j00.onEditStart(this);
        }
    }

    private String getInputText() {
        return this.d.getInputText();
    }

    public MelonLimits.TextLimit getTextLimit() {
        return MelonLimits.TextLimit.c;
    }

    @Override  // com.iloen.melon.custom.Y
    public final void onActionClick(InputBarView inputBarView0) {
        boolean z;
        if(this.a == null) {
            z = false;
        label_8:
            if(!z) {
                this.d.b();
                this.d.a();
                ViewUtils.hideWhen(this.d, true);
                ViewUtils.showWhen(this.c, true);
                J0 j00 = this.a;
                if(j00 != null) {
                    j00.onEditStop(this);
                }
            }
        }
        else {
            long v = System.currentTimeMillis();
            long v1 = v - this.g;
            this.g = v;
            if(v1 >= 600L) {
                z = this.a.onComplete(this, this.getInputText());
                goto label_8;
            }
        }
    }

    public void setDefaultPlayListTitle(String s) {
        this.e = s;
    }

    public void setOnClickListener(J0 j00) {
        this.a = j00;
    }

    public void setOnCreateListListener(K0 k00) {
        this.b = k00;
    }

    public void setPlaylistType(String s) {
        this.f = s;
    }
}

