package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.b;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.ui.widget.EmoticonView;
import k8.t1;
import v9.c;

public abstract class MediaAttachmentView extends LinearLayout implements View.OnClickListener {
    public static class MediaAttachmentAlbumView extends MediaAttachmentView {
        public MediaAttachmentAlbumView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentAlbumView", "Layout theme = " + this.d);
            return this.b() ? layoutInflater0.inflate(0x7F0D0464, this, false) : layoutInflater0.inflate(0x7F0D0461, this, false);  // layout:listitem_attached_renewal
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069E)), ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 48.0f), false);  // id:iv_thumb_default
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069A);  // id:iv_thumb
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(mediaAttachInfo0.g).into(imageView0);
                }
            }
            ViewUtils.showWhen(this.findViewById(0x7F0A0775), true);  // id:linear_text_layout
            if(!TextUtils.isEmpty(mediaAttachInfo0.i)) {
                TextView textView0 = (TextView)this.findViewById(0x7F0A0D34);  // id:tv_title
                ViewUtils.showWhen(textView0, true);
                textView0.setText(mediaAttachInfo0.i);
            }
            if(!TextUtils.isEmpty(mediaAttachInfo0.k)) {
                TextView textView1 = (TextView)this.findViewById(0x7F0A0C12);  // id:tv_artist
                ViewUtils.showWhen(textView1, true);
                textView1.setText(mediaAttachInfo0.k);
            }
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.d;
        }
    }

    public static class MediaAttachmentArtistView extends MediaAttachmentView {
        public MediaAttachmentArtistView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentArtistView", "Layout theme = " + this.d);
            return this.b() ? layoutInflater0.inflate(0x7F0D0469, this, false) : layoutInflater0.inflate(0x7F0D0467, this, false);  // layout:listitem_attached_with_renewal_circle_thumbnail
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(this.getContext(), 48.0f), true);  // id:iv_thumb_circle_default
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(mediaAttachInfo0.g).apply(RequestOptions.circleCropTransform()).into(imageView0);
                }
            }
            ViewUtils.showWhen(this.findViewById(0x7F0A0C14), true);  // id:tv_artist_container
            if(!TextUtils.isEmpty(mediaAttachInfo0.k)) {
                ((TextView)this.findViewById(0x7F0A0C12)).setText(mediaAttachInfo0.k);  // id:tv_artist
            }
            ((TextView)this.findViewById(0x7F0A0C83)).setText(mediaAttachInfo0.r);  // id:tv_genre
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.e;
        }
    }

    public static class MediaAttachmentKakaoEmoticonView extends MediaAttachmentView {
        public MediaAttachmentKakaoEmoticonView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentKakaoEmoticonView", "Layout theme = " + this.d);
            return layoutInflater0.inflate(0x7F0D0462, this, false);  // layout:listitem_attached_kakao_emoticon
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            if(mediaAttachInfo0.X != null) {
                EmoticonView emoticonView0 = (EmoticonView)this.findViewById(0x7F0A0629);  // id:iv_emoticon
                int v = ScreenUtils.dipToPixel(this.getContext(), (this.b() ? 90.0f : 100.0f));
                LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)emoticonView0.getLayoutParams();
                linearLayout$LayoutParams0.width = v;
                linearLayout$LayoutParams0.height = v;
                emoticonView0.setLayoutParams(linearLayout$LayoutParams0);
                emoticonView0.loadEmoticon(EmoticonViewParam.get(mediaAttachInfo0.X), null);
                emoticonView0.setOnClickListener(new e0(emoticonView0));
            }
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.j;
        }
    }

    public static class MediaAttachmentLinkGenrlView extends MediaAttachmentView {
        public MediaAttachmentLinkGenrlView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentLinkGenrlView", "Layout theme = " + this.d);
            return layoutInflater0.inflate(0x7F0D0463, this, false);  // layout:listitem_attached_link_genrl
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ViewUtils.setText(((TextView)this.findViewById(0x7F0A0C9B)), mediaAttachInfo0.h);  // id:tv_link
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.k;
        }
    }

    public static class MediaAttachmentLinkVideoView extends MediaAttachmentView {
        public MediaAttachmentLinkVideoView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentLinkVideoView", "Layout theme = " + this.d);
            return this.b() ? layoutInflater0.inflate(0x7F0D0466, this, false) : layoutInflater0.inflate(0x7F0D0468, this, false);  // layout:listitem_attached_renewal_with_rect_thumbnail
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069E)), -1, false);  // id:iv_thumb_default
            this.getContext();
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069A);  // id:iv_thumb
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(mediaAttachInfo0.g).into(imageView0);
                }
            }
            ViewUtils.showWhen(((ImageView)this.findViewById(0x7F0A0B6F)), true);  // id:thumb_btn_play
            if(!TextUtils.isEmpty(mediaAttachInfo0.E)) {
                ViewUtils.showWhen(this.findViewById(0x7F0A0775), true);  // id:linear_text_layout
                ((TextView)this.findViewById(0x7F0A0D34)).setText(mediaAttachInfo0.E);  // id:tv_title
            }
            ((TextView)this.findViewById(0x7F0A0C12)).setText(0x7F1301E5);  // id:tv_artist
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.i;
        }
    }

    public static class MediaAttachmentPhotoLargeView extends MediaAttachmentView {
        public MediaAttachmentPhotoLargeView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentPhotoLargeView", "Layout theme = " + this.d);
            return this.b() ? layoutInflater0.inflate(0x7F0D0465, this, false) : layoutInflater0.inflate(0x7F0D0468, this, false);  // layout:listitem_attached_renewal_with_16_9_thumbnail
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ViewUtils.hideWhen(this.findViewById(0x7F0A011C), true);  // id:bottom_gradation
            ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069E)), ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), (this.b() ? 320.0f : 48.0f)), false);  // id:iv_thumb_default
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069A);  // id:iv_thumb
                if(imageView0 != null) {
                    imageView0.setContentDescription("이미지");
                    Glide.with(imageView0.getContext()).load(mediaAttachInfo0.g).into(imageView0);
                }
            }
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.g;
        }
    }

    public static class MediaAttachmentPhotoSmallView extends MediaAttachmentView {
        public MediaAttachmentPhotoSmallView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentPhotoSmallView", "Layout theme = " + this.d);
            return layoutInflater0.inflate(0x7F0D0468, this, false);  // layout:listitem_attached_with_rect_thumbnail
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ViewUtils.setDefaultImage(((ImageView)this.findViewById(0x7F0A069E)), ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 48.0f), false);  // id:iv_thumb_default
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069A);  // id:iv_thumb
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(mediaAttachInfo0.g).into(imageView0);
                }
            }
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.f;
        }
    }

    public static class MediaAttachmentSongView extends MediaAttachmentView {
        public MediaAttachmentSongView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentSongView", "Layout theme = " + this.d);
            return this.b() ? layoutInflater0.inflate(0x7F0D0464, this, false) : layoutInflater0.inflate(0x7F0D0461, this, false);  // layout:listitem_attached_renewal
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069E);  // id:iv_thumb_default
            if(this.getContext() != null) {
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(this.getContext(), 48.0f));
            }
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView1 = (ImageView)this.findViewById(0x7F0A069A);  // id:iv_thumb
                if(imageView1 != null) {
                    Glide.with(imageView1.getContext()).load(mediaAttachInfo0.g).into(imageView1);
                }
            }
            ImageView imageView2 = (ImageView)this.findViewById(0x7F0A0B6F);  // id:thumb_btn_play
            imageView2.setOnClickListener(this);
            imageView2.setVisibility((mediaAttachInfo0.b == 3 ? 8 : 0));
            imageView2.setContentDescription("곡 재생");
            this.findViewById(0x7F0A0775).setVisibility(0);  // id:linear_text_layout
            if(!TextUtils.isEmpty(mediaAttachInfo0.j)) {
                TextView textView0 = (TextView)this.findViewById(0x7F0A0D34);  // id:tv_title
                textView0.setVisibility(0);
                textView0.setText(mediaAttachInfo0.j);
                int v = ResourceUtils.getMvAdultGradeSmallIcon((ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.I)) ? "19" : ""));
                if(v == -1) {
                    textView0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
                else {
                    textView0.setCompoundDrawablesWithIntrinsicBounds(v, 0, 0, 0);
                }
            }
            if(!TextUtils.isEmpty(mediaAttachInfo0.k)) {
                TextView textView1 = (TextView)this.findViewById(0x7F0A0C12);  // id:tv_artist
                textView1.setVisibility(0);
                textView1.setText(mediaAttachInfo0.k);
            }
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.c;
        }
    }

    public static class MediaAttachmentVideoView extends MediaAttachmentView {
        public MediaAttachmentVideoView(Context context0) {
            super(context0);
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final View a(LayoutInflater layoutInflater0) {
            LogU.d("MediaAttachmentVideoView", "Layout theme = " + this.d);
            return this.b() ? layoutInflater0.inflate(0x7F0D0466, this, false) : layoutInflater0.inflate(0x7F0D0468, this, false);  // layout:listitem_attached_renewal_with_rect_thumbnail
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public final void d(MediaAttachInfo mediaAttachInfo0) {
            ImageView imageView0 = (ImageView)this.findViewById(0x7F0A069E);  // id:iv_thumb_default
            if(this.getContext() != null) {
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(this.getContext(), 48.0f));
            }
            if(!TextUtils.isEmpty(mediaAttachInfo0.g)) {
                ImageView imageView1 = (ImageView)this.findViewById(0x7F0A069A);  // id:iv_thumb
                if(imageView1 != null) {
                    Glide.with(imageView1.getContext()).load(mediaAttachInfo0.g).into(imageView1);
                }
            }
            if(!TextUtils.isEmpty(mediaAttachInfo0.D)) {
                TextView textView0 = (TextView)this.findViewById(0x7F0A0921);  // id:play_time
                ViewUtils.showWhen(textView0, true);
                ViewUtils.setText(textView0, mediaAttachInfo0.D);
            }
            ViewUtils.showWhen(((ImageView)this.findViewById(0x7F0A0B6F)), true);  // id:thumb_btn_play
            if(!TextUtils.isEmpty(mediaAttachInfo0.E)) {
                ViewUtils.showWhen(this.findViewById(0x7F0A0775), true);  // id:linear_text_layout
                TextView textView1 = (TextView)this.findViewById(0x7F0A0D34);  // id:tv_title
                textView1.setText(mediaAttachInfo0.E);
                int v = ResourceUtils.getMvAdultGradeSmallIcon((ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.I)) ? "19" : ""));
                if(v == -1) {
                    textView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
                else {
                    textView1.setCompoundDrawablesWithIntrinsicBounds(v, 0, 0, 0);
                }
            }
            if(!TextUtils.isEmpty(mediaAttachInfo0.k)) {
                ((TextView)this.findViewById(0x7F0A0C12)).setText(mediaAttachInfo0.k);  // id:tv_artist
            }
        }

        @Override  // com.iloen.melon.custom.MediaAttachmentView
        public MediaAttachType getAttachType() {
            return MediaAttachType.h;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public MediaAttachInfo a;

        static {
            SavedState.CREATOR = new g0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        // 去混淆评级： 低(20)
        @Override
        public final String toString() {
            return "MediaAttachmentView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " ,attachInfo=" + " albumId:0, artistId:0, songId:0, mvId:0, thumbnail:null, originalUrl:null, album:null, song:null, artist:null, artistType:null, nationality:null, actType:null, sex:null, genre:null, fanCount:0, issueDate:null, playtime:null, mvTitle:null, issueDate:null, viewCount:0, isAdult:0 isHoldback:0 isFree:0 videoAgeLevel:null videoWidth:0 videoHeight:0 userInfo:null theme:null kakaoEmoticonParam:null unavailableService:false" + "}";
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeSerializable(this.a);
        }
    }

    public MediaAttachType a;
    public MediaAttachInfo b;
    public f0 c;
    public c d;

    static {
    }

    public MediaAttachmentView(Context context0) {
        this(context0, null);
    }

    public MediaAttachmentView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        MediaAttachType mediaAttachType0 = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = c.a;
        if(!this.isInEditMode()) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.p);
            if(typedArray0 != null) {
                String s = typedArray0.getString(0);
                if(!TextUtils.isEmpty(s)) {
                    MediaAttachType mediaAttachType1 = MediaAttachType.c;
                    if("song".equals(s)) {
                        mediaAttachType0 = mediaAttachType1;
                    }
                    else {
                        mediaAttachType1 = MediaAttachType.d;
                        if("album".equals(s)) {
                            mediaAttachType0 = mediaAttachType1;
                        }
                        else {
                            mediaAttachType1 = MediaAttachType.e;
                            if("artist".equals(s)) {
                                mediaAttachType0 = mediaAttachType1;
                            }
                            else {
                                mediaAttachType1 = MediaAttachType.f;
                                if("photo_small".equals(s)) {
                                    mediaAttachType0 = mediaAttachType1;
                                }
                                else {
                                    mediaAttachType1 = MediaAttachType.g;
                                    if("photo_large".equals(s)) {
                                        mediaAttachType0 = mediaAttachType1;
                                    }
                                    else {
                                        mediaAttachType1 = MediaAttachType.h;
                                        if("video".equals(s)) {
                                            mediaAttachType0 = mediaAttachType1;
                                        }
                                        else {
                                            mediaAttachType1 = MediaAttachType.i;
                                            if("link_video".equals(s)) {
                                                mediaAttachType0 = mediaAttachType1;
                                            }
                                            else {
                                                mediaAttachType1 = MediaAttachType.j;
                                                if("kakao_emoticon".equals(s)) {
                                                    mediaAttachType0 = mediaAttachType1;
                                                }
                                                else {
                                                    mediaAttachType1 = MediaAttachType.k;
                                                    if("link_genrl".equals(s)) {
                                                        mediaAttachType0 = mediaAttachType1;
                                                    }
                                                    else {
                                                        LogU.e("MediaAttachmentView", "setAttachType() - invalid type name: " + s);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.setAttachType(mediaAttachType0);
                }
                typedArray0.recycle();
            }
        }
    }

    public abstract View a(LayoutInflater arg1);

    public final boolean b() {
        return c.c == this.d;
    }

    public final void c(MediaAttachInfo mediaAttachInfo0) {
        if(mediaAttachInfo0 == null) {
            LogU.e("MediaAttachmentView", "updateAttachInfo() invalid parameter");
            return;
        }
        MediaAttachType mediaAttachType0 = this.a;
        if(mediaAttachType0 == null && mediaAttachInfo0.a == null) {
            LogU.e("MediaAttachmentView", "updateAttachInfo() required type empty");
            return;
        }
        MediaAttachType mediaAttachType1 = mediaAttachInfo0.a;
        if(mediaAttachType1 != null) {
            mediaAttachType0 = mediaAttachType1;
        }
        this.setAttachType(mediaAttachType0);
        this.b = mediaAttachInfo0;
        if(!MediaAttachType.f.equals(mediaAttachInfo0.a) && !MediaAttachType.g.equals(mediaAttachInfo0.a) && mediaAttachInfo0.b == 3) {
            this.findViewById(0x7F0A05B8).setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // id:item_layout_container
        }
        this.d(mediaAttachInfo0);
        this.setContainerViewClick(mediaAttachInfo0);
        this.setImageViewClick(mediaAttachInfo0);
        this.setRightIconClick(mediaAttachInfo0);
    }

    public abstract void d(MediaAttachInfo arg1);

    public MediaAttachInfo getAttachInfo() {
        return this.b;
    }

    public abstract MediaAttachType getAttachType();

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        int v = view0.getId();
        if(v == 0x7F0A05B8) {  // id:item_layout_container
            f0 f00 = this.c;
            if(f00 != null) {
                MediaAttachmentLayout mediaAttachmentLayout0 = (MediaAttachmentLayout)((b)f00).b;
                c0 c00 = mediaAttachmentLayout0.a;
                if(c00 != null) {
                    c00.onAttachmentClick(mediaAttachmentLayout0, this);
                }
            }
        }
        else if(v == 0x7F0A0B6D) {  // id:thumb_attached_container
            f0 f01 = this.c;
            if(f01 != null) {
                MediaAttachmentLayout mediaAttachmentLayout1 = (MediaAttachmentLayout)((b)f01).b;
                c0 c01 = mediaAttachmentLayout1.a;
                if(c01 != null) {
                    c01.onAttachmentImageClick(mediaAttachmentLayout1, this);
                }
            }
        }
        else {
            f0 f02 = this.c;
            if(f02 != null) {
                MediaAttachmentLayout mediaAttachmentLayout2 = (MediaAttachmentLayout)((b)f02).b;
                c0 c02 = mediaAttachmentLayout2.a;
                if(c02 != null) {
                    c02.onAttachmentBtnClick(mediaAttachmentLayout2, this);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.c(((SavedState)parcelable0).a);
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.getAttachInfo();
        return parcelable0;
    }

    public void setAttachType(MediaAttachType mediaAttachType0) {
        if(mediaAttachType0 == null) {
            LogU.w("MediaAttachmentView", "setAttachType() invalid paramter");
            return;
        }
        if(this.a != null && this.a.equals(mediaAttachType0)) {
            LogU.w("MediaAttachmentView", "setAttachType() same type - " + mediaAttachType0);
            return;
        }
        this.a = mediaAttachType0;
        this.removeAllViews();
        View view0 = this.a(LayoutInflater.from(this.getContext()));
        if(view0 != null) {
            this.addView(view0);
            return;
        }
        LogU.e("MediaAttachmentView", "setAttachType() - invalid type:" + mediaAttachType0);
    }

    private void setContainerViewClick(MediaAttachInfo mediaAttachInfo0) {
        if(mediaAttachInfo0 == null) {
            LogU.w("MediaAttachmentView", "setContainerViewClick() invalid paramter");
            return;
        }
        if(mediaAttachInfo0.b != 2 && mediaAttachInfo0.b != 3) {
            if(MediaAttachType.c.equals(mediaAttachInfo0.a) || MediaAttachType.d.equals(mediaAttachInfo0.a) || MediaAttachType.e.equals(mediaAttachInfo0.a) || MediaAttachType.h.equals(mediaAttachInfo0.a) || MediaAttachType.i.equals(mediaAttachInfo0.a) || MediaAttachType.j.equals(mediaAttachInfo0.a) || MediaAttachType.k.equals(mediaAttachInfo0.a)) {
                View view0 = this.findViewById(0x7F0A05B8);  // id:item_layout_container
                if(view0 != null) {
                    view0.setOnClickListener(this);
                }
            }
            return;
        }
        LogU.w("MediaAttachmentView", "setContainerViewClick() ignore container view click");
    }

    private void setImageViewClick(MediaAttachInfo mediaAttachInfo0) {
        if(mediaAttachInfo0 == null) {
            LogU.w("MediaAttachmentView", "setImageViewClick() invalid paramter");
            return;
        }
        if(mediaAttachInfo0.b == 3 && !MediaAttachType.g.equals(mediaAttachInfo0.a) && !MediaAttachType.f.equals(mediaAttachInfo0.a)) {
            LogU.w("MediaAttachmentView", "setImageViewClick() ignore image view click");
            return;
        }
        View view0 = this.findViewById(0x7F0A0B6D);  // id:thumb_attached_container
        if(view0 != null) {
            if(mediaAttachInfo0.b == 1 && (MediaAttachType.c.equals(mediaAttachInfo0.a) || MediaAttachType.d.equals(mediaAttachInfo0.a) || MediaAttachType.e.equals(mediaAttachInfo0.a) || MediaAttachType.h.equals(mediaAttachInfo0.a) || MediaAttachType.i.equals(mediaAttachInfo0.a) || MediaAttachType.j.equals(mediaAttachInfo0.a))) {
                view0.setClickable(false);
                return;
            }
            view0.setOnClickListener(this);
        }
    }

    public void setOnAttachmentClickListener(f0 f00) {
        this.c = f00;
    }

    private void setRightIconClick(MediaAttachInfo mediaAttachInfo0) {
        View view0;
        if(mediaAttachInfo0 == null) {
            LogU.w("MediaAttachmentView", "setRightIconClick() invalid parameter");
            return;
        }
        int v = mediaAttachInfo0.b;
        if(v == 1) {
            view0 = this.findViewById(0x7F0A0182);  // id:btn_play
        }
        else {
            switch(v) {
                case 2: {
                    view0 = this.findViewById(0x7F0A013B);  // id:btn_add
                    break;
                }
                case 3: {
                    view0 = this.findViewById(0x7F0A0157);  // id:btn_delete
                    break;
                }
                default: {
                    view0 = null;
                }
            }
        }
        if(view0 != null) {
            ViewUtils.showWhen(view0, true);
            if(mediaAttachInfo0.b == 1) {
                view0.setClickable(false);
                return;
            }
            view0.setOnClickListener(this);
        }
    }

    public void setTheme(c c0) {
        this.d = c0;
    }
}

