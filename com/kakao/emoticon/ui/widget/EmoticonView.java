package com.kakao.emoticon.ui.widget;

import Jc.s0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.app.AppCompatActivity;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.kakao.digitalitem.image.lib.AnimatedItemImageView;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.interfaces.EmoticonViewLoadListener;
import com.kakao.emoticon.model.DrawType;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.response.ItemSubType;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.SoftInputHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class EmoticonView extends AnimatedItemImageView implements EmoticonViewLoadListener {
    private EmoticonViewLoadListener emoticonViewLoadListener;
    private EmoticonViewParam emoticonViewParam;
    boolean isAutoSoundPlay;
    private boolean isChildOfRecyclerView;
    private boolean isLoadComplete;
    private DrawType loadType;

    public EmoticonView(Context context0) {
        super(context0);
        this.isLoadComplete = false;
        this.init();
    }

    public EmoticonView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
        this.init();
    }

    public EmoticonView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.isLoadComplete = false;
        this.init();
    }

    public static void a(EmoticonView emoticonView0, EmoticonViewParam emoticonViewParam0, View.OnClickListener view$OnClickListener0, View view0) {
        emoticonView0.lambda$loadEmoticon$1(emoticonViewParam0, view$OnClickListener0, view0);
    }

    public void enableAutoSoundPlay(boolean z) {
        this.isAutoSoundPlay = z;
    }

    private void init() {
        this.setOnLongClickListener(new s0(this, 2));
    }

    public boolean isAutoSoundPlay() {
        return this.isAutoSoundPlay;
    }

    private boolean lambda$init$0(View view0) {
        if(this.emoticonViewParam == null) {
            return false;
        }
        SoftInputHelper.hideSoftInput(this.getContext(), this);
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("id", String.format(Locale.US, "%s_%03d", this.emoticonViewParam.getEmoticonId(), this.emoticonViewParam.getResourceId()));
            jSONObject0.put("t", this.emoticonViewParam.getEmoticonType().getType());
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        ActionTracker.pushLog("A003", "02", jSONObject0);
        if(this.getContext() instanceof AppCompatActivity) {
            EmoticonInfoDialogFragment emoticonInfoDialogFragment0 = (EmoticonInfoDialogFragment)EmoticonInfoDialogFragment.getInstance(this.emoticonViewParam);
            if(emoticonInfoDialogFragment0 != null) {
                emoticonInfoDialogFragment0.show(((AppCompatActivity)this.getContext()).getSupportFragmentManager(), "EmoticonInfoDialogFragment");
            }
        }
        return true;
    }

    private void lambda$loadEmoticon$1(EmoticonViewParam emoticonViewParam0, View.OnClickListener view$OnClickListener0, View view0) {
        if(emoticonViewParam0 != null) {
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put("id", String.format(Locale.US, "%s_%03d", emoticonViewParam0.getEmoticonId(), emoticonViewParam0.getResourceId()));
                jSONObject0.put("t", emoticonViewParam0.getEmoticonType().getType());
            }
            catch(JSONException jSONException0) {
                jSONException0.printStackTrace();
            }
            ActionTracker.pushLog("A003", "01", jSONObject0);
            super.startAnimation();
            if(emoticonViewParam0.getEmoticonType() == ItemSubType.SOUND_STICKER || emoticonViewParam0.getEmoticonType() == ItemSubType.SOUND_EMOTICON) {
                this.playSoundIfSoundEmoticon();
            }
            if(view$OnClickListener0 != null) {
                view$OnClickListener0.onClick(this);
            }
        }
    }

    public void loadEmoticon(EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.loadEmoticon(emoticonViewParam0, emoticonViewLoadListener0, null);
    }

    public void loadEmoticon(EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0, View.OnClickListener view$OnClickListener0) {
        this.setLongClickable(true);
        this.setOnClickListener(new s(this, emoticonViewParam0, view$OnClickListener0, 8));
        if(this.emoticonViewParam != null && !this.emoticonViewParam.equals(emoticonViewParam0)) {
            this.setImageBitmap(null);
            this.clearView();
        }
        this.loadType = DrawType.EMOTICON;
        this.isLoadComplete = false;
        this.emoticonViewParam = emoticonViewParam0;
        this.emoticonViewLoadListener = emoticonViewLoadListener0;
        EmoticonResourceLoader.INSTANCE.loadEmoticon(this, emoticonViewParam0, this);
    }

    public void loadThumbnail(EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.loadType = DrawType.THUMB;
        this.setLongClickable(false);
        this.clearView();
        this.isLoadComplete = false;
        this.emoticonViewParam = emoticonViewParam0;
        this.emoticonViewLoadListener = emoticonViewLoadListener0;
        EmoticonResourceLoader.INSTANCE.loadThumbnail(this, emoticonViewParam0, this);
    }

    @Override  // android.widget.ImageView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.isChildOfRecyclerView) {
            EmoticonViewParam emoticonViewParam0 = this.emoticonViewParam;
            if(emoticonViewParam0 != null) {
                EmoticonView emoticonView0 = null;
                DrawType drawType0 = this.loadType;
                if(drawType0 != null) {
                    if(drawType0 == DrawType.EMOTICON) {
                        EmoticonResourceLoader emoticonResourceLoader0 = EmoticonResourceLoader.INSTANCE;
                        if(!this.isLoadComplete) {
                            emoticonView0 = this;
                        }
                        emoticonResourceLoader0.loadEmoticon(this, emoticonViewParam0, emoticonView0);
                        return;
                    }
                    EmoticonResourceLoader emoticonResourceLoader1 = EmoticonResourceLoader.INSTANCE;
                    if(!this.isLoadComplete) {
                        emoticonView0 = this;
                    }
                    emoticonResourceLoader1.loadThumbnail(this, emoticonViewParam0, emoticonView0);
                }
            }
        }
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonViewLoadListener
    public void onLoadComplete() {
        this.isLoadComplete = true;
        EmoticonViewLoadListener emoticonViewLoadListener0 = this.emoticonViewLoadListener;
        if(emoticonViewLoadListener0 != null) {
            emoticonViewLoadListener0.onLoadComplete();
        }
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonViewLoadListener
    public void onLoadFailed() {
        this.isLoadComplete = true;
        EmoticonViewLoadListener emoticonViewLoadListener0 = this.emoticonViewLoadListener;
        if(emoticonViewLoadListener0 != null) {
            emoticonViewLoadListener0.onLoadFailed();
        }
    }

    public void setChildOfRecyclerView(boolean z) {
        this.isChildOfRecyclerView = z;
    }

    @Override  // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType imageView$ScaleType0) {
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageView
    public void setVisibility(int v) {
        super.setVisibility(v);
        if(v != 0) {
            this.stopAnimation();
        }
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageView
    public void stopAnimation() {
        super.stopAnimation();
        this.stopSoundEmoticon();
    }
}

