package com.facebook.login.widget;

import A6.b;
import Q0.h;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.appevents.c;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R.drawable;
import com.facebook.login.R.id;
import com.facebook.login.R.layout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\f\u001A\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000F\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001A\u00020\b¢\u0006\u0004\b\u0016\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u001C\u0010\u001F\u001A\b\u0018\u00010\u001ER\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0018\u0010\"\u001A\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u000E\u001A\u00020\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010$R\u0016\u0010%\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup;", "", "", "text", "Landroid/view/View;", "anchor", "<init>", "(Ljava/lang/String;Landroid/view/View;)V", "Lie/H;", "updateArrows", "()V", "registerObserver", "unregisterObserver", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "style", "setStyle", "(Lcom/facebook/login/widget/ToolTipPopup$Style;)V", "show", "", "displayTime", "setNuxDisplayTime", "(J)V", "dismiss", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "anchorViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "popupContent", "Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "Landroid/widget/PopupWindow;", "popupWindow", "Landroid/widget/PopupWindow;", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "nuxDisplayTime", "J", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Companion", "PopupContentView", "Style", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ToolTipPopup {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$Companion;", "", "()V", "DEFAULT_POPUP_DISPLAY_TIME", "", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\f\u001A\u0004\b\u0017\u0010\u000E¨\u0006\u0018"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Lcom/facebook/login/widget/ToolTipPopup;Landroid/content/Context;)V", "Lie/H;", "showTopArrow", "()V", "showBottomArrow", "Landroid/widget/ImageView;", "topArrow", "Landroid/widget/ImageView;", "getTopArrow", "()Landroid/widget/ImageView;", "bottomArrow", "getBottomArrow", "Landroid/view/View;", "bodyFrame", "Landroid/view/View;", "getBodyFrame", "()Landroid/view/View;", "xOut", "getXOut", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class PopupContentView extends FrameLayout {
        @NotNull
        private final View bodyFrame;
        @NotNull
        private final ImageView bottomArrow;
        @NotNull
        private final ImageView topArrow;
        @NotNull
        private final ImageView xOut;

        public PopupContentView(@NotNull Context context0) {
            q.g(context0, "context");
            ToolTipPopup.this = toolTipPopup0;
            super(context0);
            LayoutInflater.from(context0).inflate(layout.com_facebook_tooltip_bubble, this);
            View view0 = this.findViewById(id.com_facebook_tooltip_bubble_view_top_pointer);
            q.e(view0, "null cannot be cast to non-null type android.widget.ImageView");
            this.topArrow = (ImageView)view0;
            View view1 = this.findViewById(id.com_facebook_tooltip_bubble_view_bottom_pointer);
            q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
            this.bottomArrow = (ImageView)view1;
            View view2 = this.findViewById(id.com_facebook_body_frame);
            q.f(view2, "findViewById(R.id.com_facebook_body_frame)");
            this.bodyFrame = view2;
            View view3 = this.findViewById(id.com_facebook_button_xout);
            q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
            this.xOut = (ImageView)view3;
        }

        @NotNull
        public final View getBodyFrame() {
            return this.bodyFrame;
        }

        @NotNull
        public final ImageView getBottomArrow() {
            return this.bottomArrow;
        }

        @NotNull
        public final ImageView getTopArrow() {
            return this.topArrow;
        }

        @NotNull
        public final ImageView getXOut() {
            return this.xOut;
        }

        public final void showBottomArrow() {
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
        }

        public final void showTopArrow() {
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$Style;", "", "(Ljava/lang/String;I)V", "BLUE", "BLACK", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Style {
        BLUE,
        BLACK;

        private static final Style[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final Companion Companion = null;
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000L;
    @NotNull
    private final WeakReference anchorViewRef;
    @NotNull
    private final Context context;
    private long nuxDisplayTime;
    @Nullable
    private PopupContentView popupContent;
    @Nullable
    private PopupWindow popupWindow;
    @NotNull
    private final ViewTreeObserver.OnScrollChangedListener scrollListener;
    @NotNull
    private Style style;
    @NotNull
    private final String text;

    static {
        ToolTipPopup.Companion = new Companion(null);
    }

    public ToolTipPopup(@NotNull String s, @NotNull View view0) {
        q.g(s, "text");
        q.g(view0, "anchor");
        super();
        this.text = s;
        this.anchorViewRef = new WeakReference(view0);
        Context context0 = view0.getContext();
        q.f(context0, "anchor.context");
        this.context = context0;
        this.style = Style.BLUE;
        this.nuxDisplayTime = 6000L;
        this.scrollListener = new h(this, 1);
    }

    public static void a(ToolTipPopup toolTipPopup0) {
        ToolTipPopup.show$lambda$2(toolTipPopup0);
    }

    public static void b(ToolTipPopup toolTipPopup0, View view0) {
        ToolTipPopup.show$lambda$3(toolTipPopup0, view0);
    }

    public final void dismiss() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                this.unregisterObserver();
                PopupWindow popupWindow0 = this.popupWindow;
                if(popupWindow0 != null) {
                    popupWindow0.dismiss();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void registerObserver() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                this.unregisterObserver();
                View view0 = (View)this.anchorViewRef.get();
                if(view0 != null) {
                    ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
                    if(viewTreeObserver0 != null) {
                        viewTreeObserver0.addOnScrollChangedListener(this.scrollListener);
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void scrollListener$lambda$1(ToolTipPopup toolTipPopup0) {
        Class class0 = ToolTipPopup.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(toolTipPopup0, "this$0");
                if(toolTipPopup0.anchorViewRef.get() != null) {
                    PopupWindow popupWindow0 = toolTipPopup0.popupWindow;
                    if(popupWindow0 != null && popupWindow0.isShowing()) {
                        if(popupWindow0.isAboveAnchor()) {
                            PopupContentView toolTipPopup$PopupContentView0 = toolTipPopup0.popupContent;
                            if(toolTipPopup$PopupContentView0 != null) {
                                toolTipPopup$PopupContentView0.showBottomArrow();
                                return;
                            }
                        }
                        else {
                            PopupContentView toolTipPopup$PopupContentView1 = toolTipPopup0.popupContent;
                            if(toolTipPopup$PopupContentView1 != null) {
                                toolTipPopup$PopupContentView1.showTopArrow();
                            }
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public final void setNuxDisplayTime(long v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.nuxDisplayTime = v;
    }

    public final void setStyle(@NotNull Style toolTipPopup$Style0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(toolTipPopup$Style0, "style");
            this.style = toolTipPopup$Style0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void show() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(this.anchorViewRef.get() != null) {
                    PopupContentView toolTipPopup$PopupContentView0 = new PopupContentView(this, this.context);
                    this.popupContent = toolTipPopup$PopupContentView0;
                    View view0 = toolTipPopup$PopupContentView0.findViewById(id.com_facebook_tooltip_bubble_view_text_body);
                    q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView)view0).setText(this.text);
                    if(this.style == Style.BLUE) {
                        toolTipPopup$PopupContentView0.getBodyFrame().setBackgroundResource(drawable.com_facebook_tooltip_blue_background);
                        toolTipPopup$PopupContentView0.getBottomArrow().setImageResource(drawable.com_facebook_tooltip_blue_bottomnub);
                        toolTipPopup$PopupContentView0.getTopArrow().setImageResource(drawable.com_facebook_tooltip_blue_topnub);
                        toolTipPopup$PopupContentView0.getXOut().setImageResource(drawable.com_facebook_tooltip_blue_xout);
                    }
                    else {
                        toolTipPopup$PopupContentView0.getBodyFrame().setBackgroundResource(drawable.com_facebook_tooltip_black_background);
                        toolTipPopup$PopupContentView0.getBottomArrow().setImageResource(drawable.com_facebook_tooltip_black_bottomnub);
                        toolTipPopup$PopupContentView0.getTopArrow().setImageResource(drawable.com_facebook_tooltip_black_topnub);
                        toolTipPopup$PopupContentView0.getXOut().setImageResource(drawable.com_facebook_tooltip_black_xout);
                    }
                    q.e(this.context, "null cannot be cast to non-null type android.app.Activity");
                    View view1 = ((Activity)this.context).getWindow().getDecorView();
                    q.f(view1, "window.decorView");
                    int v = view1.getWidth();
                    int v1 = view1.getHeight();
                    this.registerObserver();
                    toolTipPopup$PopupContentView0.measure(View.MeasureSpec.makeMeasureSpec(v, 0x80000000), View.MeasureSpec.makeMeasureSpec(v1, 0x80000000));
                    PopupWindow popupWindow0 = new PopupWindow(toolTipPopup$PopupContentView0, toolTipPopup$PopupContentView0.getMeasuredWidth(), toolTipPopup$PopupContentView0.getMeasuredHeight());
                    this.popupWindow = popupWindow0;
                    popupWindow0.showAsDropDown(((View)this.anchorViewRef.get()));
                    this.updateArrows();
                    long v2 = this.nuxDisplayTime;
                    if(v2 > 0L) {
                        toolTipPopup$PopupContentView0.postDelayed(new c(this, 11), v2);
                    }
                    popupWindow0.setTouchable(true);
                    toolTipPopup$PopupContentView0.setOnClickListener(new b(this, 21));
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void show$lambda$2(ToolTipPopup toolTipPopup0) {
        Class class0 = ToolTipPopup.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(toolTipPopup0, "this$0");
            toolTipPopup0.dismiss();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void show$lambda$3(ToolTipPopup toolTipPopup0, View view0) {
        Class class0 = ToolTipPopup.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(toolTipPopup0, "this$0");
            toolTipPopup0.dismiss();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void unregisterObserver() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                View view0 = (View)this.anchorViewRef.get();
                if(view0 != null) {
                    ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
                    if(viewTreeObserver0 != null) {
                        viewTreeObserver0.removeOnScrollChangedListener(this.scrollListener);
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void updateArrows() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                PopupWindow popupWindow0 = this.popupWindow;
                if(popupWindow0 != null && popupWindow0.isShowing()) {
                    if(popupWindow0.isAboveAnchor()) {
                        PopupContentView toolTipPopup$PopupContentView0 = this.popupContent;
                        if(toolTipPopup$PopupContentView0 != null) {
                            toolTipPopup$PopupContentView0.showBottomArrow();
                            return;
                        }
                    }
                    else {
                        PopupContentView toolTipPopup$PopupContentView1 = this.popupContent;
                        if(toolTipPopup$PopupContentView1 != null) {
                            toolTipPopup$PopupContentView1.showTopArrow();
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

