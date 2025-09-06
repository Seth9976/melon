package com.kakao.emoticon.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.interfaces.EmoticonLoginClickListener;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.StringUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"ViewConstructor"})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000ER\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000ER\u0016\u0010\b\u001A\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/kakao/emoticon/ui/LoginView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "message", "buttonText", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "loginClickListener", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;)V", "Lie/H;", "init", "(Landroid/content/Context;)V", "Ljava/lang/String;", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class LoginView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final String buttonText;
    private final EmoticonLoginClickListener loginClickListener;
    private final String message;

    public LoginView(@NotNull Context context0, @Nullable String s, @Nullable String s1, @Nullable EmoticonLoginClickListener emoticonLoginClickListener0) {
        q.g(context0, "context");
        super(context0, null, 0);
        this.message = s;
        this.buttonText = s1;
        this.loginClickListener = emoticonLoginClickListener0;
        this.init(context0);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap0 = this._$_findViewCache;
        if(hashMap0 != null) {
            hashMap0.clear();
        }
    }

    public View _$_findCachedViewById(int v) {
        if(this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view0 = (View)this._$_findViewCache.get(v);
        if(view0 == null) {
            view0 = this.findViewById(v);
            this._$_findViewCache.put(v, view0);
        }
        return view0;
    }

    private final void init(Context context0) {
        this.removeAllViews();
        View.inflate(context0, layout.emoticon_login_item, this);
        if(StringUtils.isNotBlank(this.message)) {
            View view0 = this.findViewById(id.tv_login_msg);
            if(view0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            ((TextView)view0).setText(this.message);
        }
        if(StringUtils.isNotBlank(this.buttonText)) {
            View view1 = this.findViewById(id.com_kakao_login_btn);
            if(view1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            ((TextView)view1).setText(this.buttonText);
        }
        this.findViewById(id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public final void onClick(View view0) {
                ActionTracker.pushLog$default("A001", "08", null, 4, null);
                EmoticonLoginClickListener emoticonLoginClickListener0 = LoginView.this.loginClickListener;
                if(emoticonLoginClickListener0 != null) {
                    emoticonLoginClickListener0.onLoginClick();
                }
            }
        });
    }
}

