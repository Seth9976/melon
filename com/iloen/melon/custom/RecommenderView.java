package com.iloen.melon.custom;

import De.I;
import J8.x;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u000E¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/custom/RecommenderView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "imageUrl", "Lie/H;", "setProfileImage", "(Ljava/lang/String;)V", "desc", "setDescription", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RecommenderView extends LinearLayoutCompat {
    public final x r;

    public RecommenderView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public RecommenderView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public RecommenderView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D0625, this, false);  // layout:recommender_view
        this.addView(view0);
        int v1 = 0x7F0A03A2;  // id:desc
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A03A2);  // id:desc
        if(melonTextView0 != null) {
            v1 = 0x7F0A09C6;  // id:recom_thumb_layout
            View view1 = I.C(view0, 0x7F0A09C6);  // id:recom_thumb_layout
            if(view1 != null) {
                x x0 = x.b(view1);
                this.r = new x(((LinearLayoutCompat)view0), melonTextView0, x0, 5);
                ((ImageView)x0.c).setImageResource(0x7F08079E);  // drawable:noimage_person_19
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }

    public RecommenderView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    public final void setDescription(@Nullable String s) {
        ((MelonTextView)this.r.d).setText(s);
    }

    public final void setProfileImage(@Nullable String s) {
        ((RequestBuilder)Glide.with(this).load(s).circleCrop()).into(((BorderImageView)((x)this.r.c).d));
    }
}

