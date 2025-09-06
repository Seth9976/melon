package com.iloen.melon.fragments.comments;

import Ad.s;
import Cb.i;
import Tf.n;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import c2.h0;
import com.iloen.melon.custom.KeyEventEditText;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import ie.H;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00015\b\u0007\u0018\u00002\u00020\u0001:\u0001>B+\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0013\u001A\u00020\f2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\f2\b\b\u0001\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\f2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u000ER\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010 \u001A\u0004\b!\u0010\"R\u0017\u0010\t\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\t\u0010#\u001A\u0004\b\t\u0010\u0010R\u0016\u0010%\u001A\u00020$8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001A\u00020\'8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b(\u0010)R\"\u0010*\u001A\u00020\u00158\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010\u0018R\"\u0010/\u001A\u00020\u00158\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b/\u0010+\u001A\u0004\b0\u0010-\"\u0004\b1\u0010\u0018R\"\u00102\u001A\u00020\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b2\u0010+\u001A\u0004\b3\u0010-\"\u0004\b4\u0010\u0018R\u0014\u00106\u001A\u0002058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001A\u0002088\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001A\u00020;8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b<\u0010=\u00A8\u0006?"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentInputPopup;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "Landroid/text/Editable;", "initText", "Lcom/iloen/melon/fragments/comments/CommentInputPopup$OnEventListener;", "onEventListener", "", "isClearAtDone", "<init>", "(Landroid/content/Context;Landroid/text/Editable;Lcom/iloen/melon/fragments/comments/CommentInputPopup$OnEventListener;Z)V", "Lie/H;", "initView", "()V", "checkAtLeastCharacters", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "hint", "setHint", "(I)V", "message", "setInputText", "(Landroid/text/Editable;)V", "dismiss", "Landroid/text/Editable;", "getInitText", "()Landroid/text/Editable;", "Lcom/iloen/melon/fragments/comments/CommentInputPopup$OnEventListener;", "getOnEventListener", "()Lcom/iloen/melon/fragments/comments/CommentInputPopup$OnEventListener;", "Z", "Lcom/iloen/melon/custom/KeyEventEditText;", "edMessage", "Lcom/iloen/melon/custom/KeyEventEditText;", "Lcom/iloen/melon/custom/MelonTextView;", "writeButton", "Lcom/iloen/melon/custom/MelonTextView;", "maxLength", "I", "getMaxLength", "()I", "setMaxLength", "minLength", "getMinLength", "setMinLength", "hintRes", "getHintRes", "setHintRes", "com/iloen/melon/fragments/comments/CommentInputPopup$defaultTextWatcher$1", "defaultTextWatcher", "Lcom/iloen/melon/fragments/comments/CommentInputPopup$defaultTextWatcher$1;", "Landroid/widget/TextView$OnEditorActionListener;", "defaultEditorActionListener", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/view/View$OnClickListener;", "defaultSendClickListener", "Landroid/view/View$OnClickListener;", "OnEventListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentInputPopup extends Dialog {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentInputPopup$OnEventListener;", "", "", "message", "Lie/H;", "onSendEvent", "(Ljava/lang/String;)V", "Landroid/text/Editable;", "onDismissEvent", "(Landroid/text/Editable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnEventListener {
        void onDismissEvent(@NotNull Editable arg1);

        void onSendEvent(@NotNull String arg1);
    }

    public static final int $stable = 8;
    @NotNull
    private final TextView.OnEditorActionListener defaultEditorActionListener;
    @NotNull
    private final View.OnClickListener defaultSendClickListener;
    @NotNull
    private final com.iloen.melon.fragments.comments.CommentInputPopup.defaultTextWatcher.1 defaultTextWatcher;
    private KeyEventEditText edMessage;
    private int hintRes;
    @Nullable
    private final Editable initText;
    private final boolean isClearAtDone;
    private int maxLength;
    private int minLength;
    @NotNull
    private final OnEventListener onEventListener;
    private MelonTextView writeButton;

    public CommentInputPopup(@NotNull Context context0, @Nullable Editable editable0, @NotNull OnEventListener commentInputPopup$OnEventListener0, boolean z) {
        q.g(context0, "context");
        q.g(commentInputPopup$OnEventListener0, "onEventListener");
        super(context0);
        this.initText = editable0;
        this.onEventListener = commentInputPopup$OnEventListener0;
        this.isClearAtDone = z;
        this.maxLength = 200;
        this.minLength = 3;
        this.hintRes = -1;
        this.defaultTextWatcher = new TextWatcher() {
            private final n newLine;

            {
                this.newLine = new n("\\n");
            }

            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }

            public final n getNewLine() {
                return this.newLine;
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                boolean z = true;
                if(charSequence0 != null && this.newLine.a.matcher(charSequence0).find()) {
                    String s = this.newLine.c(charSequence0, "");
                    KeyEventEditText keyEventEditText0 = CommentInputPopup.access$getEdMessage$p(CommentInputPopup.this);
                    if(keyEventEditText0 != null) {
                        keyEventEditText0.setText(s);
                        KeyEventEditText keyEventEditText1 = CommentInputPopup.access$getEdMessage$p(CommentInputPopup.this);
                        if(keyEventEditText1 != null) {
                            keyEventEditText1.setSelection(s.length());
                            goto label_14;
                        }
                        q.m("edMessage");
                        throw null;
                    }
                    q.m("edMessage");
                    throw null;
                }
            label_14:
                MelonTextView melonTextView0 = CommentInputPopup.access$getWriteButton$p(CommentInputPopup.this);
                if(melonTextView0 != null) {
                    KeyEventEditText keyEventEditText2 = CommentInputPopup.access$getEdMessage$p(CommentInputPopup.this);
                    if(keyEventEditText2 != null) {
                        Editable editable0 = keyEventEditText2.getText();
                        q.f(editable0, "getText(...)");
                        if(editable0.length() <= 0) {
                            z = false;
                        }
                        melonTextView0.setEnabled(z);
                        KeyEventEditText keyEventEditText3 = CommentInputPopup.access$getEdMessage$p(CommentInputPopup.this);
                        if(keyEventEditText3 != null) {
                            if(keyEventEditText3.getText().toString().length() >= CommentInputPopup.this.getMaxLength() && v2 - v1 == 0) {
                                ToastManager.show(0x7F13084B);  // string:popup_cmt_write_max_limit "입력하신 글자 수가 초과되었습니다."
                            }
                            return;
                        }
                        q.m("edMessage");
                        throw null;
                    }
                    q.m("edMessage");
                    throw null;
                }
                q.m("writeButton");
                throw null;
            }
        };
        this.defaultEditorActionListener = new k(this, context0);
        this.defaultSendClickListener = new s(20, this, context0);
    }

    public CommentInputPopup(Context context0, Editable editable0, OnEventListener commentInputPopup$OnEventListener0, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            z = true;
        }
        this(context0, editable0, commentInputPopup$OnEventListener0, z);
    }

    public static final KeyEventEditText access$getEdMessage$p(CommentInputPopup commentInputPopup0) {
        return commentInputPopup0.edMessage;
    }

    public static final MelonTextView access$getWriteButton$p(CommentInputPopup commentInputPopup0) {
        return commentInputPopup0.writeButton;
    }

    private final boolean checkAtLeastCharacters() {
        KeyEventEditText keyEventEditText0 = this.edMessage;
        if(keyEventEditText0 != null) {
            return keyEventEditText0.getText().toString().length() >= this.minLength;
        }
        q.m("edMessage");
        throw null;
    }

    private static final boolean defaultEditorActionListener$lambda$5(CommentInputPopup commentInputPopup0, Context context0, TextView textView0, int v, KeyEvent keyEvent0) {
        if(v == 4) {
            if(commentInputPopup0.checkAtLeastCharacters()) {
                OnEventListener commentInputPopup$OnEventListener0 = commentInputPopup0.onEventListener;
                KeyEventEditText keyEventEditText0 = commentInputPopup0.edMessage;
                if(keyEventEditText0 != null) {
                    commentInputPopup$OnEventListener0.onSendEvent(keyEventEditText0.getText().toString());
                    if(commentInputPopup0.isClearAtDone) {
                        KeyEventEditText keyEventEditText1 = commentInputPopup0.edMessage;
                        if(keyEventEditText1 == null) {
                            q.m("edMessage");
                            throw null;
                        }
                        Editable editable0 = keyEventEditText1.getText();
                        if(editable0 != null) {
                            editable0.clear();
                            commentInputPopup0.dismiss();
                            return false;
                        }
                    }
                    commentInputPopup0.dismiss();
                    return false;
                }
                q.m("edMessage");
                throw null;
            }
            q.f("%d자 이상의 글을 작성해주세요.", "getString(...)");
            ToastManager.show(String.format("%d자 이상의 글을 작성해주세요.", Arrays.copyOf(new Object[]{commentInputPopup0.minLength}, 1)));
            return true;
        }
        return false;
    }

    private static final void defaultSendClickListener$lambda$6(CommentInputPopup commentInputPopup0, Context context0, View view0) {
        if(commentInputPopup0.checkAtLeastCharacters()) {
            OnEventListener commentInputPopup$OnEventListener0 = commentInputPopup0.onEventListener;
            KeyEventEditText keyEventEditText0 = commentInputPopup0.edMessage;
            if(keyEventEditText0 != null) {
                commentInputPopup$OnEventListener0.onSendEvent(keyEventEditText0.getText().toString());
                if(commentInputPopup0.isClearAtDone) {
                    KeyEventEditText keyEventEditText1 = commentInputPopup0.edMessage;
                    if(keyEventEditText1 == null) {
                        q.m("edMessage");
                        throw null;
                    }
                    Editable editable0 = keyEventEditText1.getText();
                    if(editable0 != null) {
                        editable0.clear();
                        commentInputPopup0.dismiss();
                        return;
                    }
                }
                commentInputPopup0.dismiss();
                return;
            }
            q.m("edMessage");
            throw null;
        }
        q.f("%d자 이상의 글을 작성해주세요.", "getString(...)");
        ToastManager.show(String.format("%d자 이상의 글을 작성해주세요.", Arrays.copyOf(new Object[]{commentInputPopup0.minLength}, 1)));
    }

    @Override  // android.app.Dialog
    public void dismiss() {
        KeyEventEditText keyEventEditText0 = this.edMessage;
        if(keyEventEditText0 != null) {
            OnEventListener commentInputPopup$OnEventListener0 = this.onEventListener;
            if(keyEventEditText0 != null) {
                Editable editable0 = keyEventEditText0.getText();
                q.f(editable0, "getText(...)");
                commentInputPopup$OnEventListener0.onDismissEvent(editable0);
                super.dismiss();
                return;
            }
            q.m("edMessage");
            throw null;
        }
        super.dismiss();
    }

    public final int getHintRes() {
        return this.hintRes;
    }

    @Nullable
    public final Editable getInitText() {
        return this.initText;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final int getMinLength() {
        return this.minLength;
    }

    @NotNull
    public final OnEventListener getOnEventListener() {
        return this.onEventListener;
    }

    private final void initView() {
        WindowManager.LayoutParams windowManager$LayoutParams0;
        boolean z = true;
        this.requestWindowFeature(1);
        this.setContentView(0x7F0D018E);  // layout:comment_input_popup_layout
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
        view0.setOnApplyWindowInsetsListener(new l(view0));
        View view1 = this.findViewById(0x7F0A0408);  // id:ed_message
        q.f(view1, "findViewById(...)");
        this.edMessage = (KeyEventEditText)view1;
        int v = this.hintRes;
        if(v > -1) {
            ((KeyEventEditText)view1).setHint(v);
        }
        View view2 = this.findViewById(0x7F0A0B5F);  // id:text_send
        q.f(view2, "findViewById(...)");
        this.writeButton = (MelonTextView)view2;
        KeyEventEditText keyEventEditText0 = this.edMessage;
        if(keyEventEditText0 != null) {
            keyEventEditText0.setRawInputType(1);
            Editable editable0 = this.initText;
            if(editable0 != null) {
                KeyEventEditText keyEventEditText1 = this.edMessage;
                if(keyEventEditText1 != null) {
                    keyEventEditText1.setText(editable0);
                    MelonTextView melonTextView0 = this.writeButton;
                    if(melonTextView0 != null) {
                        if(editable0.length() <= 0) {
                            z = false;
                        }
                        melonTextView0.setEnabled(z);
                        goto label_56;
                    }
                    q.m("writeButton");
                    throw null;
                }
                q.m("edMessage");
                throw null;
            }
        label_56:
            KeyEventEditText keyEventEditText2 = this.edMessage;
            if(keyEventEditText2 != null) {
                keyEventEditText2.addTextChangedListener(this.defaultTextWatcher);
                KeyEventEditText keyEventEditText3 = this.edMessage;
                if(keyEventEditText3 != null) {
                    keyEventEditText3.setOnEditorActionListener(this.defaultEditorActionListener);
                    KeyEventEditText keyEventEditText4 = this.edMessage;
                    if(keyEventEditText4 != null) {
                        keyEventEditText4.setOnKeyEventListener(new m(this, 0));
                        KeyEventEditText keyEventEditText5 = this.edMessage;
                        if(keyEventEditText5 != null) {
                            keyEventEditText5.requestFocus();
                            MelonTextView melonTextView1 = this.writeButton;
                            if(melonTextView1 != null) {
                                ViewUtils.setOnClickListener(melonTextView1, this.defaultSendClickListener);
                                ViewUtils.setOnClickListener(this.findViewById(0x7F0A073C), new b(this, 1));  // id:layout_root
                                MelonTextView melonTextView2 = this.writeButton;
                                if(melonTextView2 != null) {
                                    ViewUtils.setContentDescriptionWithButtonClassName(melonTextView2, melonTextView2.getText());
                                    return;
                                }
                                q.m("writeButton");
                                throw null;
                            }
                            q.m("writeButton");
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

    private static final WindowInsets initView$lambda$1(View view0, View view1, WindowInsets windowInsets0) {
        q.g(view1, "<unused var>");
        q.g(windowInsets0, "windowInsets");
        view0.setPadding(0, windowInsets0.getInsets(h0.b()).top, 0, windowInsets0.getInsets(B0.s.B()).bottom);
        return windowInsets0;
    }

    private static final H initView$lambda$3(CommentInputPopup commentInputPopup0, int v, KeyEvent keyEvent0) {
        q.g(keyEvent0, "keyEvent");
        if(keyEvent0.getAction() == 0 && v == 4) {
            commentInputPopup0.dismiss();
        }
        return H.a;
    }

    private static final void initView$lambda$4(CommentInputPopup commentInputPopup0, View view0) {
        commentInputPopup0.dismiss();
    }

    public final boolean isClearAtDone() {
        return this.isClearAtDone;
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.initView();
    }

    public final void setHint(int v) {
        this.hintRes = v;
    }

    public final void setHintRes(int v) {
        this.hintRes = v;
    }

    public final void setInputText(@Nullable Editable editable0) {
        if(i.l(editable0)) {
            KeyEventEditText keyEventEditText0 = this.edMessage;
            if(keyEventEditText0 != null) {
                keyEventEditText0.setText(editable0);
                KeyEventEditText keyEventEditText1 = this.edMessage;
                if(keyEventEditText1 != null) {
                    keyEventEditText1.setSelection(keyEventEditText1.length());
                    return;
                }
                q.m("edMessage");
                throw null;
            }
        }
    }

    public final void setMaxLength(int v) {
        this.maxLength = v;
    }

    public final void setMinLength(int v) {
        this.minLength = v;
    }
}

