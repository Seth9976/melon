package com.iloen.melon.player.video.chat;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import cd.V2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.imageview.ShapeableImageView;
import com.iloen.melon.custom.KeyEventEditText;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u0001!B7\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001A\u0004\b\u0019\u0010\u0017R\u0017\u0010\b\u001A\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\b\u0010\u001CR\u0017\u0010\n\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 ¨\u0006\""}, d2 = {"Lcom/iloen/melon/player/video/chat/VideoChatInputPopup;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "initText", "imgUrl", "", "isFullMode", "Lcom/iloen/melon/player/video/chat/VideoChatInputPopup$OnEventListener;", "onEventListener", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/iloen/melon/player/video/chat/VideoChatInputPopup$OnEventListener;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "dismiss", "()V", "a", "Ljava/lang/String;", "getInitText", "()Ljava/lang/String;", "b", "getImgUrl", "c", "Z", "()Z", "d", "Lcom/iloen/melon/player/video/chat/VideoChatInputPopup$OnEventListener;", "getOnEventListener", "()Lcom/iloen/melon/player/video/chat/VideoChatInputPopup$OnEventListener;", "OnEventListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatInputPopup extends Dialog {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/chat/VideoChatInputPopup$OnEventListener;", "", "", "message", "Lie/H;", "onChangedText", "(Ljava/lang/String;)V", "onSendEvent", "onDismissEvent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnEventListener {
        void onChangedText(@NotNull String arg1);

        void onDismissEvent(@NotNull String arg1);

        void onSendEvent(@NotNull String arg1);
    }

    public static final int $stable = 8;
    public final String a;
    public final String b;
    public final boolean c;
    public final OnEventListener d;
    public View e;
    public KeyEventEditText f;
    public TextView g;

    public VideoChatInputPopup(@NotNull Context context0, @Nullable String s, @Nullable String s1, boolean z, @NotNull OnEventListener videoChatInputPopup$OnEventListener0) {
        q.g(context0, "context");
        q.g(videoChatInputPopup$OnEventListener0, "onEventListener");
        super(context0);
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = videoChatInputPopup$OnEventListener0;
    }

    public VideoChatInputPopup(Context context0, String s, String s1, boolean z, OnEventListener videoChatInputPopup$OnEventListener0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s1 = "";
        }
        if((v & 8) != 0) {
            z = false;
        }
        this(context0, s, s1, z, videoChatInputPopup$OnEventListener0);
    }

    @Override  // android.app.Dialog
    public void dismiss() {
        String s = ((EditText)this.findViewById(0x7F0A0408)).getText().toString();  // id:ed_message
        this.d.onDismissEvent(s);
        super.dismiss();
    }

    @Nullable
    public final String getImgUrl() {
        return this.b;
    }

    @Nullable
    public final String getInitText() {
        return this.a;
    }

    @NotNull
    public final OnEventListener getOnEventListener() {
        return this.d;
    }

    public final boolean isFullMode() {
        return this.c;
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        WindowManager.LayoutParams windowManager$LayoutParams0;
        super.onCreate(bundle0);
        boolean z = true;
        this.requestWindowFeature(1);
        this.setContentView(0x7F0D08D5);  // layout:video_chat_input_layout
        Window window0 = this.getWindow();
        if(window0 == null) {
            windowManager$LayoutParams0 = null;
        }
        else {
            windowManager$LayoutParams0 = window0.getAttributes();
            if(windowManager$LayoutParams0 == null) {
                windowManager$LayoutParams0 = null;
            }
            else {
                windowManager$LayoutParams0.gravity = 80;
                windowManager$LayoutParams0.width = -1;
                windowManager$LayoutParams0.height = -1;
                windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
            }
        }
        Window window1 = this.getWindow();
        if(window1 != null) {
            window1.clearFlags(2);
        }
        Window window2 = this.getWindow();
        if(window2 != null) {
            window2.setAttributes(windowManager$LayoutParams0);
        }
        Window window3 = this.getWindow();
        if(window3 != null) {
            window3.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
        }
        Window window4 = this.getWindow();
        if(window4 != null) {
            window4.setSoftInputMode(5);
        }
        View view0 = this.findViewById(0x7F0A073C).getRootView();  // id:layout_root
        view0.setOnApplyWindowInsetsListener(new b(view0));
        View view1 = this.findViewById(0x7F0A032F);  // id:container_message
        q.f(view1, "findViewById(...)");
        this.e = view1;
        View view2 = this.findViewById(0x7F0A0408);  // id:ed_message
        q.f(view2, "findViewById(...)");
        this.f = (KeyEventEditText)view2;
        View view3 = this.findViewById(0x7F0A0B5F);  // id:text_send
        q.f(view3, "findViewById(...)");
        this.g = (TextView)view3;
        ShapeableImageView shapeableImageView0 = (ShapeableImageView)this.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        boolean z1 = this.c;
        if(z1) {
            View view4 = this.e;
            if(view4 != null) {
                view4.setBackgroundResource(0x7F0808AD);  // drawable:shape_rectangle_gray050e_round20
                KeyEventEditText keyEventEditText0 = this.f;
                if(keyEventEditText0 != null) {
                    keyEventEditText0.setHintTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604B4));  // color:white500e_support_high_contrast
                    KeyEventEditText keyEventEditText1 = this.f;
                    if(keyEventEditText1 != null) {
                        keyEventEditText1.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
                        shapeableImageView0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060144));  // color:gray050e
                        shapeableImageView0.setStrokeColorResource(0x7F0604AE);  // color:white120e
                        goto label_60;
                    }
                    q.m("edMessage");
                    throw null;
                }
                q.m("edMessage");
                throw null;
            }
            q.m("containerMessage");
            throw null;
        }
    label_60:
        KeyEventEditText keyEventEditText2 = this.f;
        if(keyEventEditText2 != null) {
            keyEventEditText2.setRawInputType(1);
            String s = this.a;
            if(s != null) {
                KeyEventEditText keyEventEditText3 = this.f;
                if(keyEventEditText3 != null) {
                    keyEventEditText3.setText(s);
                    TextView textView0 = this.g;
                    if(textView0 != null) {
                        if(s.length() <= 0) {
                            z = false;
                        }
                        ViewUtils.showWhen(textView0, z);
                        goto label_78;
                    }
                    q.m("textSend");
                    throw null;
                }
                q.m("edMessage");
                throw null;
            }
        label_78:
            KeyEventEditText keyEventEditText4 = this.f;
            if(keyEventEditText4 != null) {
                keyEventEditText4.addTextChangedListener(new VideoChatInputPopup.initView.3(this));
                KeyEventEditText keyEventEditText5 = this.f;
                if(keyEventEditText5 != null) {
                    keyEventEditText5.setOnEditorActionListener(new c(this));
                    KeyEventEditText keyEventEditText6 = this.f;
                    if(keyEventEditText6 != null) {
                        keyEventEditText6.setOnKeyEventListener(new V2(this, 2));
                        KeyEventEditText keyEventEditText7 = this.f;
                        if(keyEventEditText7 != null) {
                            keyEventEditText7.requestFocus();
                            Drawable drawable0 = P1.c.getDrawable(this.getContext(), (z1 ? 0x7F0807A4 : 0x7F0807A3));  // drawable:noimage_person_xxmini_w
                            ((RequestBuilder)Glide.with(this.getContext()).load(this.b).error(drawable0)).into(shapeableImageView0);
                            TextView textView1 = this.g;
                            if(textView1 != null) {
                                textView1.setOnClickListener(new d(this, 0));
                                this.findViewById(0x7F0A073C).setOnClickListener(new d(this, 1));  // id:layout_root
                                ViewUtils.setOnClickListener(this.findViewById(0x7F0A072C), null);  // id:layout_message
                                return;
                            }
                            q.m("textSend");
                            throw null;
                        }
                        q.m("edMessage");
                        throw null;
                    }
                    q.m("edMessage");
                    throw null;
                }
                q.m("edMessage");
                throw null;
            }
            q.m("edMessage");
            throw null;
        }
        q.m("edMessage");
        throw null;
    }
}

