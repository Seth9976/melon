package com.kakao.emoticon.ui.widget;

import P1.c;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.fragments.radio.a;
import com.kakao.digitalitem.image.lib.AnimatedItemImageContainer;
import com.kakao.digitalitem.image.lib.AnimatedItemImageSpan;
import com.kakao.digitalitem.image.lib.OnPreparedListener;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.cache.signature.EmoticonVersionSignature;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.model.DrawType;
import com.kakao.emoticon.model.EmoticonLoadParam;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.response.ItemSubType;
import com.kakao.emoticon.ui.LongClickLinkMovementMethod;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.ScreenUtils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonSpan extends AnimatedItemImageSpan {
    public static class Options {
        private int height;
        private boolean isAutoSoundPlay;
        private ViewGroup scrollContainer;

        public Options(int v, boolean z, ViewGroup viewGroup0) {
            this.height = v;
            this.isAutoSoundPlay = z;
            this.scrollContainer = viewGroup0;
        }

        public static ViewGroup access$000(Options emoticonSpan$Options0) {
            return emoticonSpan$Options0.scrollContainer;
        }

        public static boolean access$100(Options emoticonSpan$Options0) {
            return emoticonSpan$Options0.isAutoSoundPlay;
        }

        public static int access$200(Options emoticonSpan$Options0) {
            return emoticonSpan$Options0.height;
        }

        public void setAutoSoundPlay(boolean z) {
            this.isAutoSoundPlay = z;
        }

        public void setScrollContainer(ViewGroup viewGroup0) {
            this.scrollContainer = viewGroup0;
        }

        public void setSize(int v) {
            this.height = v;
        }
    }

    private Rect emoticonBound;
    private EmoticonViewParam emoticonViewParam;
    private boolean isAutoSoundPlay;
    private OnPreparedListener onPreparedListener;
    private ViewGroup scrollableContainerView;
    private TextView textView;

    public EmoticonSpan(TextView textView0, EmoticonViewParam emoticonViewParam0, Options emoticonSpan$Options0, OnPreparedListener onPreparedListener0) {
        this.isAutoSoundPlay = true;
        this.context = textView0.getContext();
        this.emoticonViewParam = emoticonViewParam0;
        this.textView = textView0;
        this.onPreparedListener = onPreparedListener0;
        try {
            EmoticonLoadParam emoticonLoadParam0 = new EmoticonLoadParam(emoticonViewParam0, DrawType.EMOTICON);
            EmoticonVersionSignature emoticonVersionSignature0 = emoticonLoadParam0.getSignature();
            if(EmoticonResourceLoader.INSTANCE.isCachedItem(emoticonVersionSignature0, emoticonLoadParam0.getEmoticonId())) {
                this.setImageDrawable(c.getDrawable(this.context, drawable.icon_emoticon_transparent));
            }
            else {
                this.setImageDrawable(c.getDrawable(this.context, drawable.emoticon_not_found_padding));
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            this.setImageDrawable(c.getDrawable(this.context, drawable.emoticon_not_found_padding));
        }
        if(emoticonSpan$Options0 == null) {
            this.setAnimatedImageSize(ScreenUtils.INSTANCE.dp2px(100.0f), ScreenUtils.INSTANCE.dp2px(100.0f));
        }
        else {
            this.scrollableContainerView = Options.access$000(emoticonSpan$Options0);
            this.isAutoSoundPlay = Options.access$100(emoticonSpan$Options0);
            this.setAnimatedImageSize(Options.access$200(emoticonSpan$Options0), Options.access$200(emoticonSpan$Options0));
        }
        textView0.setMovementMethod(LongClickLinkMovementMethod.getInstance());
        this.addIndexChangeListener(textView0);
        this.addViewDetachListener(textView0);
        this.setStartAnimationWhenImageLoaded(false);
        EmoticonSpanManager.getInstance().add(this);
        this.execLoad(textView0, emoticonViewParam0);
    }

    private void addIndexChangeListener(View view0) {
        this.setOnIndexChangeListener(new b(view0, 0));
    }

    private void addViewDetachListener(View view0) {
        view0.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view0) {
                EmoticonSpan.this.stopAnimation();
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view0) {
                EmoticonSpan.this.clearView();
            }
        });
    }

    public static void b(TextView textView0) {
        EmoticonSpan.lambda$execLoad$1(textView0);
    }

    public boolean contains(int v, int v1) {
        return this.emoticonBound == null ? false : this.emoticonBound.contains(v, v1);
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageSpan
    public void draw(Canvas canvas0, CharSequence charSequence0, int v, int v1, float f, int v2, int v3, int v4, Paint paint0) {
        Rect rect0 = new Rect();
        ViewGroup viewGroup0 = this.scrollableContainerView;
        if(viewGroup0 == null) {
            this.getDrawingTextViewRect(this.textView, rect0);
        }
        else {
            this.getDrawingScrollRect(viewGroup0, rect0);
        }
        Drawable drawable0 = this.getDrawable();
        if(drawable0 == null) {
            return;
        }
        int v5 = v4 - drawable0.getBounds().bottom;
        if(this.mVerticalAlignment == 1) {
            v5 -= paint0.getFontMetricsInt().descent;
        }
        Rect rect1 = new Rect(((int)f), v5, drawable0.getBounds().right + ((int)f), drawable0.getBounds().bottom + v5);
        this.emoticonBound = rect1;
        if(!rect0.intersect(rect1)) {
            if(this.emoticonViewParam.getEmoticonType() != ItemSubType.STICKER && this.isAnimating()) {
                this.stopAnimation();
                this.clearFrames();
            }
        }
        else if(this.emoticonViewParam.getEmoticonType() != ItemSubType.STICKER) {
            this.startAnimation();
        }
        super.draw(canvas0, charSequence0, v, v1, f, v2, v3, v4, paint0);
    }

    private void execLoad(TextView textView0, EmoticonViewParam emoticonViewParam0) {
        EmoticonResourceLoader.INSTANCE.loadEmoticon(this, emoticonViewParam0, null);
        OnPreparedListener onPreparedListener0 = this.onPreparedListener;
        if(onPreparedListener0 != null) {
            this.setOnPreparedListener(onPreparedListener0);
            return;
        }
        this.setOnPreparedListener(new a(textView0, 3));
    }

    public View getAttachedView() {
        return this.textView;
    }

    private void getDrawingScrollRect(ViewGroup viewGroup0, Rect rect0) {
        int v = viewGroup0.getScrollY();
        int v1 = viewGroup0.getScrollX();
        if(!(viewGroup0 instanceof ListView)) {
            if(viewGroup0 instanceof RecyclerView) {
                v1 = Math.abs(((RecyclerView)viewGroup0).computeHorizontalScrollOffset());
                v = Math.abs(((RecyclerView)viewGroup0).computeVerticalScrollOffset());
            }
        }
        else if(viewGroup0.getChildAt(0) != null) {
            v = Math.abs(viewGroup0.getChildAt(0).getTop());
        }
        rect0.left = v1 - this.textView.getPaddingLeft();
        rect0.top = v - this.textView.getPaddingTop();
        int v2 = rect0.left;
        rect0.right = viewGroup0.getRight() - viewGroup0.getLeft() + v2;
        int v3 = rect0.top;
        rect0.bottom = viewGroup0.getBottom() - viewGroup0.getTop() + v3;
    }

    private void getDrawingTextViewRect(TextView textView0, Rect rect0) {
        rect0.left = textView0.getScrollX();
        rect0.top = textView0.getScrollY();
        int v = rect0.left;
        rect0.right = textView0.getRight() - textView0.getLeft() + v;
        int v1 = rect0.top;
        rect0.bottom = textView0.getBottom() - textView0.getTop() + v1;
    }

    public EmoticonViewParam getEmoticonViewParam() {
        return this.emoticonViewParam;
    }

    public boolean isAutoSoundPlay() {
        return this.isAutoSoundPlay;
    }

    private static void lambda$addIndexChangeListener$0(View view0, AnimatedItemImageContainer animatedItemImageContainer0, int v) {
        if(view0 != null && view0.isShown()) {
            view0.postInvalidate();
        }
    }

    private static void lambda$execLoad$1(TextView textView0) {
        if(textView0 != null) {
            if(textView0.getLayerType() != 1) {
                textView0.setTextKeepState(textView0.getText());
            }
            textView0.postInvalidate();
        }
    }

    public void onClick(View view0) {
        this.startAnimation();
        this.playSoundIfSoundEmoticon();
    }

    public void onLongClick(View view0, int v, int v1) {
        if(view0 instanceof EditText) {
            return;
        }
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("id", String.format(Locale.US, "%s_%03d", this.emoticonViewParam.getEmoticonId(), this.emoticonViewParam.getResourceId()));
            jSONObject0.put("t", this.emoticonViewParam.getEmoticonType().getType());
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        ActionTracker.pushLog("A003", "02", jSONObject0);
        EmoticonInfoDialogFragment emoticonInfoDialogFragment0 = (EmoticonInfoDialogFragment)EmoticonInfoDialogFragment.getInstance(this.emoticonViewParam);
        if(emoticonInfoDialogFragment0 != null) {
            emoticonInfoDialogFragment0.show(((AppCompatActivity)view0.getContext()).getSupportFragmentManager(), "EmoticonInfoDialogFragment");
        }
    }

    public void stopEmoticonSpan() {
        this.cancelAnimation();
        this.clearFrames();
    }
}

