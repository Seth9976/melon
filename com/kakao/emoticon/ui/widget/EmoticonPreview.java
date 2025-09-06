package com.kakao.emoticon.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.interfaces.EmoticonViewLoadListener;
import com.kakao.emoticon.model.EmoticonViewParam;

public class EmoticonPreview extends RelativeLayout implements View.OnClickListener {
    public interface VisibilityChangeListener {
        void hidePreview();

        void showPreview();
    }

    private ImageButton btnPreviewClose;
    private EmoticonView emoticonView;
    private VisibilityChangeListener visibilityChangeListener;

    public EmoticonPreview(Context context0) {
        super(context0);
        this.init();
    }

    public EmoticonPreview(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.init();
    }

    public EmoticonPreview(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.init();
    }

    public void hidePreview() {
        this.emoticonView.stopAnimation();
        this.emoticonView.clearView();
        this.emoticonView.setImageResource(0x106000D);
        this.setVisibility(8);
        VisibilityChangeListener emoticonPreview$VisibilityChangeListener0 = this.visibilityChangeListener;
        if(emoticonPreview$VisibilityChangeListener0 != null) {
            emoticonPreview$VisibilityChangeListener0.hidePreview();
        }
    }

    private void init() {
        View view0 = View.inflate(this.getContext(), layout.layout_emoticon_preview, this);
        this.btnPreviewClose = (ImageButton)view0.findViewById(id.btn_preview_close);
        this.emoticonView = (EmoticonView)view0.findViewById(id.emoticon_view);
        this.btnPreviewClose.setOnClickListener(this);
        this.emoticonView.setOnClickListener(this);
        this.setVisibility(8);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 != this.emoticonView && view0 == this.btnPreviewClose) {
            this.hidePreview();
        }
    }

    @Override  // android.view.View
    public void onVisibilityChanged(View view0, int v) {
        super.onVisibilityChanged(view0, v);
    }

    public void setVisibilityChangeListener(VisibilityChangeListener emoticonPreview$VisibilityChangeListener0) {
        this.visibilityChangeListener = emoticonPreview$VisibilityChangeListener0;
    }

    public void showPreview(EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.emoticonView.enableAutoSoundPlay(true);
        this.emoticonView.loadEmoticon(emoticonViewParam0, emoticonViewLoadListener0);
        this.setVisibility(0);
        VisibilityChangeListener emoticonPreview$VisibilityChangeListener0 = this.visibilityChangeListener;
        if(emoticonPreview$VisibilityChangeListener0 != null) {
            emoticonPreview$VisibilityChangeListener0.showPreview();
        }
    }

    public void showThumbPreview(EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.emoticonView.loadThumbnail(emoticonViewParam0, emoticonViewLoadListener0);
        this.setVisibility(0);
        VisibilityChangeListener emoticonPreview$VisibilityChangeListener0 = this.visibilityChangeListener;
        if(emoticonPreview$VisibilityChangeListener0 != null) {
            emoticonPreview$VisibilityChangeListener0.showPreview();
        }
    }
}

