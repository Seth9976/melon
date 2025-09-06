package com.iloen.melon.popup;

import Qc.s;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.TextView;
import com.iloen.melon.custom.MelonWebView;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.Sheet;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion;
import com.iloen.melon.player.playlist.mixup.composables.c;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent;
import e1.m;
import e1.n;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001jB!\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u00A2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\f2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\f2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\f2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001E\u001A\u00020\f2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\fH\u0017\u00A2\u0006\u0004\b \u0010!R$\u0010)\u001A\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R$\u0010-\u001A\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010$\u001A\u0004\b+\u0010&\"\u0004\b,\u0010(R$\u00101\u001A\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010$\u001A\u0004\b/\u0010&\"\u0004\b0\u0010(R$\u00105\u001A\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b2\u0010$\u001A\u0004\b3\u0010&\"\u0004\b4\u0010(R$\u0010;\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010\u0012R$\u0010C\u001A\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010I\u001A\u00020\u00198\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bD\u0010E\u001A\u0004\bF\u0010\u001B\"\u0004\bG\u0010HR\"\u0010M\u001A\u00020\u00198\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bJ\u0010E\u001A\u0004\bK\u0010\u001B\"\u0004\bL\u0010HR$\u0010S\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bN\u0010O\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010\u0016R$\u0010W\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bT\u0010O\u001A\u0004\bU\u0010Q\"\u0004\bV\u0010\u0016R$\u0010[\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bX\u0010O\u001A\u0004\bY\u0010Q\"\u0004\bZ\u0010\u0016R$\u0010c\u001A\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b]\u0010^\u001A\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010i\u001A\u0004\u0018\u00010\u001C8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bd\u0010e\u001A\u0004\bf\u0010g\"\u0004\bh\u0010\u001F\u00A8\u0006k"}, d2 = {"Lcom/iloen/melon/popup/MelonTMPPopup;", "Lcom/iloen/melon/popup/MelonBasePopup;", "Landroid/view/View$OnClickListener;", "Landroid/app/Activity;", "activity", "", "resId", "themeResId", "<init>", "(Landroid/app/Activity;II)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "", "msg", "setGoLinkMsg", "(Ljava/lang/String;)V", "setGoLinkUrl", "setMessageId", "", "isCheckState", "()Z", "Lcom/iloen/melon/net/v4x/response/NotificationLoginRes$Response$Promotion;", "promotion", "setPromotionRes", "(Lcom/iloen/melon/net/v4x/response/NotificationLoginRes$Response$Promotion;)V", "onBackPressed", "()V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTvTitleMsg", "()Landroid/widget/TextView;", "setTvTitleMsg", "(Landroid/widget/TextView;)V", "tvTitleMsg", "b", "getTvBodyMsg", "setTvBodyMsg", "tvBodyMsg", "c", "getTvCheckMsg", "setTvCheckMsg", "tvCheckMsg", "d", "getTvGoLink", "setTvGoLink", "tvGoLink", "e", "Landroid/view/View;", "getIvClose", "()Landroid/view/View;", "setIvClose", "ivClose", "Landroid/widget/CheckBox;", "f", "Landroid/widget/CheckBox;", "getCbCheckBox", "()Landroid/widget/CheckBox;", "setCbCheckBox", "(Landroid/widget/CheckBox;)V", "cbCheckBox", "g", "Z", "getCentFlag", "setCentFlag", "(Z)V", "centFlag", "h", "getCheckState", "setCheckState", "checkState", "j", "Ljava/lang/String;", "getCheckMsg", "()Ljava/lang/String;", "setCheckMsg", "checkMsg", "k", "getMGoLinkMsg", "setMGoLinkMsg", "mGoLinkMsg", "l", "getMGoLinkUrl", "setMGoLinkUrl", "mGoLinkUrl", "Lcom/iloen/melon/custom/MelonWebView;", "n", "Lcom/iloen/melon/custom/MelonWebView;", "getWebView", "()Lcom/iloen/melon/custom/MelonWebView;", "setWebView", "(Lcom/iloen/melon/custom/MelonWebView;)V", "webView", "o", "Lcom/iloen/melon/net/v4x/response/NotificationLoginRes$Response$Promotion;", "getMPromotion", "()Lcom/iloen/melon/net/v4x/response/NotificationLoginRes$Response$Promotion;", "setMPromotion", "mPromotion", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTMPPopup extends MelonBasePopup implements View.OnClickListener {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/MelonTMPPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public CheckBox f;
    public boolean g;
    public boolean h;
    public View i;
    public String j;
    public String k;
    public String l;
    public String m;
    public MelonWebView n;
    public Promotion o;

    static {
        MelonTMPPopup.Companion = new Companion(null);
        MelonTMPPopup.$stable = 8;
    }

    public MelonTMPPopup(@Nullable Activity activity0, int v, int v1) {
        super(activity0, v, v1);
    }

    public static void a(MelonTMPPopup melonTMPPopup0, String s) {
        m.F(new c(s, "", melonTMPPopup0, 2)).track();
    }

    @Nullable
    public final CheckBox getCbCheckBox() {
        return this.f;
    }

    public final boolean getCentFlag() {
        return this.g;
    }

    @Nullable
    public final String getCheckMsg() {
        return this.j;
    }

    public final boolean getCheckState() {
        return this.h;
    }

    @Nullable
    public final View getIvClose() {
        return this.e;
    }

    @Nullable
    public final String getMGoLinkMsg() {
        return this.k;
    }

    @Nullable
    public final String getMGoLinkUrl() {
        return this.l;
    }

    @Nullable
    public final Promotion getMPromotion() {
        return this.o;
    }

    @Nullable
    public final TextView getTvBodyMsg() {
        return this.b;
    }

    @Nullable
    public final TextView getTvCheckMsg() {
        return this.c;
    }

    @Nullable
    public final TextView getTvGoLink() {
        return this.d;
    }

    @Nullable
    public final TextView getTvTitleMsg() {
        return this.a;
    }

    @Nullable
    public final MelonWebView getWebView() {
        return this.n;
    }

    public final boolean isCheckState() {
        return this.h;
    }

    @Override  // android.app.Dialog
    @d
    public void onBackPressed() {
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(@NotNull View view0) {
        q.g(view0, "v");
        if(view0 == this.mRightButton) {
            DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
            if(dialogInterface$OnClickListener0 != null) {
                dialogInterface$OnClickListener0.onClick(this, -1);
            }
            MelonTMPPopup.a(this, "");
            this.dismiss();
        }
    }

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void onCreate(@Nullable Bundle bundle0) {
        String s;
        super.onCreate(bundle0);
        TextView textView0 = (TextView)this.findViewById(0x7F0A0CEA);  // id:tv_popup_title
        this.a = textView0;
        if(textView0 != null) {
            textView0.setText(this.getTitleName());
        }
        TextView textView1 = (TextView)this.findViewById(0x7F0A0CE6);  // id:tv_popup_body
        this.b = textView1;
        if(textView1 != null) {
            textView1.setText(this.getBodyMsg());
        }
        TextView textView2 = (TextView)this.findViewById(0x7F0A0CE7);  // id:tv_popup_checkbox
        this.c = textView2;
        if(textView2 != null) {
            textView2.setText(this.j);
        }
        this.e = this.findViewById(0x7F0A0613);  // id:iv_close
        this.d = (TextView)this.findViewById(0x7F0A0C87);  // id:tv_go_link
        if(!TextUtils.isEmpty(this.k)) {
            ViewUtils.showWhen(this.d, true);
            TextView textView3 = this.d;
            if(textView3 != null) {
                textView3.setText(this.k);
            }
            ViewUtils.setOnClickListener(this.d, new I(this, 1));
        }
        if(this.g) {
            TextView textView4 = this.b;
            if(textView4 != null) {
                textView4.setGravity(17);
            }
            TextView textView5 = this.c;
            if(textView5 != null) {
                textView5.setGravity(17);
            }
        }
        View view0 = this.findViewById(0x7F0A0192);  // id:btn_popup_close
        if(view0 != null) {
            this.mRightButton = (TextView)view0;
            ((TextView)view0).setOnClickListener(this);
        }
        View view1 = this.findViewById(0x7F0A0191);  // id:btn_popup_check
        this.i = view1;
        Sheet notificationLoginRes$Response$Promotion$Sheet0 = null;
        this.f = (CheckBox)(view1 == null ? null : view1.findViewById(0x7F0A094C));  // id:popup_checkbox
        View view2 = this.i;
        if(view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() {
                public final MelonTMPPopup a;

                {
                    this.a = melonTMPPopup0;
                }

                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    q.g(view0, "v");
                    MelonTMPPopup melonTMPPopup0 = this.a;
                    melonTMPPopup0.setCheckState(!melonTMPPopup0.getCheckState());
                    CheckBox checkBox0 = melonTMPPopup0.getCbCheckBox();
                    if(checkBox0 != null) {
                        checkBox0.setChecked(melonTMPPopup0.getCheckState());
                    }
                    if(melonTMPPopup0.getCheckState()) {
                        MelonTMPPopup.a(melonTMPPopup0, "");
                    }
                }
            });
        }
        Promotion notificationLoginRes$Response$Promotion0 = this.o;
        if(notificationLoginRes$Response$Promotion0 != null) {
            notificationLoginRes$Response$Promotion$Sheet0 = notificationLoginRes$Response$Promotion0.sheet;
        }
        if(notificationLoginRes$Response$Promotion$Sheet0 != null) {
            ViewGroup viewGroup0 = (ViewGroup)this.findViewById(0x7F0A0DE7);  // id:webview_container
            MelonWebView melonWebView0 = new MelonWebView(this.getContext());
            this.n = melonWebView0;
            melonWebView0.setOutlineProvider(new RoundRectOutlineProvider(((float)ViewUtilsKt.dpToPx(12))));
            MelonWebView melonWebView1 = this.n;
            if(melonWebView1 != null) {
                melonWebView1.setClipToOutline(true);
            }
            MelonWebView melonWebView2 = this.n;
            if(melonWebView2 != null) {
                melonWebView2.setOverScrollMode(2);
            }
            MelonWebView melonWebView3 = this.n;
            if(melonWebView3 != null) {
                melonWebView3.setHorizontalScrollBarEnabled(false);
            }
            MelonWebView melonWebView4 = this.n;
            if(melonWebView4 != null) {
                melonWebView4.setVerticalScrollBarEnabled(false);
            }
            MelonWebView melonWebView5 = this.n;
            if(melonWebView5 != null) {
                MelonTMPPopup.addTMPWebView.1 melonTMPPopup$addTMPWebView$10 = new MelonTMPPopup.addTMPWebView.1(this);
                Context context0 = this.getContext();
                q.f(context0, "getContext(...)");
                melonWebView5.g(melonTMPPopup$addTMPWebView$10, true, ViewUtils.INSTANCE.getActivity(context0));
            }
            MelonWebView melonWebView6 = this.n;
            if(melonWebView6 != null) {
                melonWebView6.setWebViewListener(new MelonTMPPopup.addTMPWebView.2(this));
            }
            if(viewGroup0 != null) {
                viewGroup0.addView(this.n);
            }
            MelonWebView melonWebView7 = this.n;
            if(melonWebView7 != null) {
                Promotion notificationLoginRes$Response$Promotion1 = this.o;
                if(notificationLoginRes$Response$Promotion1 == null) {
                    s = "";
                }
                else {
                    Sheet notificationLoginRes$Response$Promotion$Sheet1 = notificationLoginRes$Response$Promotion1.sheet;
                    if(notificationLoginRes$Response$Promotion$Sheet1 == null) {
                        s = "";
                    }
                    else {
                        s = notificationLoginRes$Response$Promotion$Sheet1.webViewUri;
                        if(s == null) {
                            s = "";
                        }
                    }
                }
                melonWebView7.loadUrl(s);
            }
            View view3 = this.findViewById(0x7F0A094E);  // id:popup_checkbox_line
            TextView textView6 = this.c;
            if(textView6 != null) {
                ViewTreeObserver viewTreeObserver0 = textView6.getViewTreeObserver();
                if(viewTreeObserver0 != null) {
                    viewTreeObserver0.addOnGlobalLayoutListener(new MelonTMPPopup.addTMPWebView.3(view3, this));
                }
            }
            TextView textView7 = this.c;
            if(textView7 != null) {
                textView7.setOnClickListener(new I(this, 0));
            }
            View view4 = this.e;
            if(view4 != null) {
                view4.setOnClickListener(new I(this, 2));
            }
        }
        ViewImpContent viewImpContent0 = n.F(new s(notificationLoginRes$Response$Promotion$Sheet0 != null, this, 4));
        ContentList contentList0 = new ContentList();
        contentList0.addContent(viewImpContent0);
        n.D(new p(contentList0, 3)).track();
    }

    public final void setCbCheckBox(@Nullable CheckBox checkBox0) {
        this.f = checkBox0;
    }

    public final void setCentFlag(boolean z) {
        this.g = z;
    }

    public final void setCheckMsg(@Nullable String s) {
        this.j = s;
    }

    public final void setCheckState(boolean z) {
        this.h = z;
    }

    public final void setGoLinkMsg(@Nullable String s) {
        this.k = s;
    }

    public final void setGoLinkUrl(@Nullable String s) {
        this.l = s;
    }

    public final void setIvClose(@Nullable View view0) {
        this.e = view0;
    }

    public final void setMGoLinkMsg(@Nullable String s) {
        this.k = s;
    }

    public final void setMGoLinkUrl(@Nullable String s) {
        this.l = s;
    }

    public final void setMPromotion(@Nullable Promotion notificationLoginRes$Response$Promotion0) {
        this.o = notificationLoginRes$Response$Promotion0;
    }

    public final void setMessageId(@Nullable String s) {
        this.m = s;
    }

    public final void setPromotionRes(@Nullable Promotion notificationLoginRes$Response$Promotion0) {
        this.o = notificationLoginRes$Response$Promotion0;
    }

    public final void setTvBodyMsg(@Nullable TextView textView0) {
        this.b = textView0;
    }

    public final void setTvCheckMsg(@Nullable TextView textView0) {
        this.c = textView0;
    }

    public final void setTvGoLink(@Nullable TextView textView0) {
        this.d = textView0;
    }

    public final void setTvTitleMsg(@Nullable TextView textView0) {
        this.a = textView0;
    }

    public final void setWebView(@Nullable MelonWebView melonWebView0) {
        this.n = melonWebView0;
    }
}

