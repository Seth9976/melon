package com.iloen.melon.custom;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.lifecycle.b;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import v9.c;

public class MediaAttachmentLayout extends LinearLayout {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public List a;

        static {
            SavedState.CREATOR = new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeSerializable(((Serializable)this.a));
        }
    }

    public c0 a;

    static {
    }

    public MediaAttachmentLayout(Context context0) {
        this(context0, null);
    }

    public MediaAttachmentLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = null;
        if(this.isInEditMode()) {
            return;
        }
        this.setOrientation(1);
    }

    public final void a(MediaAttachInfo mediaAttachInfo0) {
        Context context0 = this.getContext();
        MediaAttachmentView mediaAttachmentView0 = null;
        if(context0 == null || mediaAttachInfo0 == null) {
            LogU.e("MediaAttachmentViewFactory", "build(context,info) invalid paramter");
        }
        else {
            MediaAttachType mediaAttachType0 = mediaAttachInfo0.a;
            c c0 = mediaAttachInfo0.W;
            if(mediaAttachType0 == null) {
                LogU.e("MediaAttachmentViewFactory", "build(context,type) invalid paramter");
            }
            else {
                if(MediaAttachType.c.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentSongView(context0);
                }
                else if(MediaAttachType.d.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentAlbumView(context0);
                }
                else if(MediaAttachType.e.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentArtistView(context0);
                }
                else if(MediaAttachType.f.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentPhotoSmallView(context0);
                }
                else if(MediaAttachType.g.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentPhotoLargeView(context0);
                }
                else if(MediaAttachType.h.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentVideoView(context0);
                }
                else if(MediaAttachType.i.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentLinkVideoView(context0);
                }
                else if(MediaAttachType.j.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentKakaoEmoticonView(context0);
                }
                else if(MediaAttachType.k.equals(mediaAttachType0)) {
                    mediaAttachmentView0 = new MediaAttachmentLinkGenrlView(context0);
                }
                else {
                    LogU.e("MediaAttachmentViewFactory", "build() - invalid type: " + mediaAttachType0);
                }
                if(mediaAttachmentView0 != null) {
                    mediaAttachmentView0.setTheme(c0);
                    mediaAttachmentView0.setAttachType(mediaAttachType0);
                }
            }
            if(mediaAttachmentView0 != null) {
                mediaAttachmentView0.c(mediaAttachInfo0);
            }
        }
        if(mediaAttachmentView0 != null) {
            mediaAttachmentView0.setOnAttachmentClickListener(new b(this, 28));
            if(this.getCount() > 0) {
                LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-1, -2);
                linearLayout$LayoutParams0.topMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                this.addView(mediaAttachmentView0, linearLayout$LayoutParams0);
                return;
            }
            this.addView(mediaAttachmentView0);
        }
    }

    public List getAttachInfos() {
        List list0 = new ArrayList();
        int v = this.getCount();
        if(v > 0) {
            for(int v1 = 0; v1 < v; ++v1) {
                View view0 = this.getChildAt(v1);
                ((ArrayList)list0).add((view0 == null || !(view0 instanceof MediaAttachmentView) ? null : ((MediaAttachmentView)view0).getAttachInfo()));
            }
        }
        return list0;
    }

    public int getCount() {
        return this.getChildCount();
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        List list0 = ((SavedState)parcelable0).a;
        if(list0 == null || list0.size() == 0) {
            LogU.w("MediaAttachmentLayout", "add() invalid parameter (LIST)");
        }
        else {
            for(Object object0: list0) {
                this.a(((MediaAttachInfo)object0));
            }
        }
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.getAttachInfos();
        return parcelable0;
    }

    public void setExpand(boolean z) {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(v1 > 0) {
                ViewUtils.showWhen(this.getChildAt(v1), z);
            }
        }
    }

    public void setOnAttachmentClickListener(c0 c00) {
        this.a = c00;
    }
}

