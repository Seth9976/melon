package com.iloen.melon.custom;

import P1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class ContentsView extends FrameLayout {
    public final ImageView a;
    public final MelonTextView b;

    public ContentsView(Context context0) {
        this(context0, null);
    }

    public ContentsView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ContentsView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        if(this.isInEditMode()) {
            return;
        }
        View view0 = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(0x7F0D08FE, this, false);  // layout:view_contents_type
        this.a = (ImageView)view0.findViewById(0x7F0A0546);  // id:icon
        this.b = (MelonTextView)view0.findViewById(0x7F0A0C8D);  // id:tv_info
        this.addView(view0);
        this.setTypedArray(context0.obtainStyledAttributes(attributeSet0, t1.h));
    }

    public void setContentsType(ContsTypeCode contsTypeCode0) {
        Drawable drawable0;
        TextView textView0 = (TextView)this.findViewById(0x7F0A0D25);  // id:tv_text
        this.b.setBackgroundResource(0);
        this.b.setText("");
        ViewUtils.showWhen(this.a, true);
        if(ContsTypeCode.SONG.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F0805B4);  // drawable:ic_player_select_list_music
        }
        else if(ContsTypeCode.ALBUM.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F080489);  // drawable:ic_list_album
        }
        else if(ContsTypeCode.PLAYLIST.equals(contsTypeCode0) || ContsTypeCode.DJ_PLAYLIST.equals(contsTypeCode0) || ContsTypeCode.ARTIST_PLAYLIST.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F080493);  // drawable:ic_list_playlist02
        }
        else if(ContsTypeCode.VIDEO.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F08049E);  // drawable:ic_list_video
            this.b.setTextSize(1, 14.0f);
        }
        else if(ContsTypeCode.PHOTO.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F080492);  // drawable:ic_list_photo
        }
        else if(ContsTypeCode.MELON_MAGAZINE.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F08064B);  // drawable:img_magazine_logo_01
            this.setText(null);
        }
        else if(ContsTypeCode.COMING_SOON.equals(contsTypeCode0)) {
            ViewUtils.hideWhen(this.a, true);
            this.setText("Coming Soon");
            this.b.setBackgroundResource(0x7F080901);  // drawable:shape_rectangle_white000e_0_5dp_stroke_round100
            drawable0 = null;
        }
        else if(ContsTypeCode.CONCERT.equals(contsTypeCode0) || ContsTypeCode.TICKET.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F08048A);  // drawable:ic_list_concert
        }
        else if(ContsTypeCode.MELON_RADIO.equals(contsTypeCode0)) {
            drawable0 = c.getDrawable(this.getContext(), 0x7F08048F);  // drawable:ic_list_melon_radio
            this.setText(null);
        }
        else {
            if(ContsTypeCode.THANKS_MESSAGE.equals(contsTypeCode0)) {
                ViewUtils.hideWhen(this.a, true);
                this.setText("THANK YOU");
                this.b.setBackgroundResource(0x7F080901);  // drawable:shape_rectangle_white000e_0_5dp_stroke_round100
            }
            else if(ContsTypeCode.NOW_PLAYING.equals(contsTypeCode0)) {
                ViewUtils.hideWhen(this.a, true);
                this.setText("#NOW PLAYING");
            }
            else {
                ViewUtils.hideWhen(this.a, true);
                ViewUtils.hideWhen(textView0, true);
            }
            drawable0 = null;
        }
        this.a.setImageDrawable(drawable0);
        this.requestLayout();
    }

    public void setIconImage(int v) {
        Drawable drawable0 = c.getDrawable(this.getContext(), v);
        this.a.setImageDrawable(drawable0);
    }

    public void setText(String s) {
        boolean z = TextUtils.isEmpty(s);
        ViewUtils.showWhen(this.b, !z);
        ViewUtils.setText(this.b, s);
    }

    private void setTypedArray(TypedArray typedArray0) {
        this.setContentsType(ContsTypeCode.valueOf(typedArray0.getInt(0, -1)));
        this.setText(typedArray0.getString(1));
        typedArray0.recycle();
    }

    public void setVisibilityIconImage(boolean z) {
        this.a.setVisibility((z ? 0 : 8));
    }
}

