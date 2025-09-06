package com.kakao.emoticon.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.tab.ExpiredItem.OnItemRemoveListener;
import com.kakao.emoticon.ui.widget.EmoticonView;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.IntentUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"ViewConstructor"})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/kakao/emoticon/ui/EmoticonExpireView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Lcom/kakao/emoticon/net/response/Emoticon;", "emoticon", "Lcom/kakao/emoticon/ui/tab/ExpiredItem$OnItemRemoveListener;", "onItemRemoveListener", "<init>", "(Landroid/content/Context;Lcom/kakao/emoticon/net/response/Emoticon;Lcom/kakao/emoticon/ui/tab/ExpiredItem$OnItemRemoveListener;)V", "Lie/H;", "init", "(Landroid/content/Context;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Landroid/widget/Button;", "btnPurchase", "Landroid/widget/Button;", "btnRemove", "Lcom/kakao/emoticon/net/response/Emoticon;", "Lcom/kakao/emoticon/ui/tab/ExpiredItem$OnItemRemoveListener;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonExpireView extends FrameLayout implements View.OnClickListener {
    private HashMap _$_findViewCache;
    private Button btnPurchase;
    private Button btnRemove;
    private final Emoticon emoticon;
    private final OnItemRemoveListener onItemRemoveListener;

    public EmoticonExpireView(@NotNull Context context0, @NotNull Emoticon emoticon0, @NotNull OnItemRemoveListener expiredItem$OnItemRemoveListener0) {
        q.g(context0, "context");
        q.g(emoticon0, "emoticon");
        q.g(expiredItem$OnItemRemoveListener0, "onItemRemoveListener");
        super(context0, null, 0);
        this.emoticon = emoticon0;
        this.onItemRemoveListener = expiredItem$OnItemRemoveListener0;
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
        View.inflate(context0, layout.emoticon_expire_item, this);
        View view0 = this.findViewById(id.emoticon_view);
        q.f(view0, "findViewById(R.id.emoticon_view)");
        TextView textView0 = (TextView)this.findViewById(id.tv_title);
        Button button0 = (Button)this.findViewById(id.btn_purchase);
        this.btnPurchase = button0;
        if(button0 != null) {
            button0.setOnClickListener(this);
        }
        Button button1 = (Button)this.findViewById(id.btn_tab_remove);
        this.btnRemove = button1;
        if(button1 != null) {
            button1.setOnClickListener(this);
        }
        q.f(textView0, "tvTitle");
        textView0.setText(this.emoticon.getTitle());
        EmoticonResourceLoader.INSTANCE.loadTitle(((EmoticonView)view0), this.emoticon);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(@NotNull View view0) {
        q.g(view0, "v");
        if(this.btnPurchase == view0) {
            ActionTracker.pushLog$default("A001", "16", null, 4, null);
            q.f(this.getContext(), "context");
            IntentUtils.goToEmoticonStoreAndShowItem(this.emoticon.getId(), "com.iloen.melon", "expired");
            return;
        }
        if(this.btnRemove == view0) {
            ActionTracker.pushLog$default("A001", "15", null, 4, null);
            this.onItemRemoveListener.onRemove(this.emoticon.getId());
        }
    }
}

