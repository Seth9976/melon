package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.custom.RatingView;

public class MelonRatingPopup extends MelonBaseButtonPopup implements View.OnClickListener {
    public RatingView a;
    public String b;

    public MelonRatingPopup(Activity activity0) {
        super(activity0);
        this.b = "";
    }

    public float getRating() {
        return this.a == null ? 0.0f : this.a.getRating();
    }

    @Override  // com.iloen.melon.popup.MelonBaseButtonPopup
    public void initLayout() {
        super.initLayout();
        Context context0 = this.getContext();
        this.a = TextUtils.isEmpty(this.b) ? new RatingView(context0) : new RatingView(context0, this.b);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new ViewGroup.LayoutParams(-1, -2);
        this.a.setLayoutParams(viewGroup$LayoutParams0);
        this.a.setGravity(17);
        this.addBodyView(this.a);
        View view0 = this.a.getRatingLayout();
        if(view0 != null) {
            ViewUtils.setContentDescriptionWithClassName(view0, String.format("총 %1$s점 중 %2$s 점", "5", Float.toString(this.a.getRating())) + "," + "스와이프 동작으로 조정하세요.", null, null);
        }
    }

    @Override  // com.iloen.melon.popup.MelonBaseButtonPopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setTitle((TextUtils.isEmpty(this.getTitleName()) ? "평점 주기" : this.getTitleName()));
    }

    public void setPartInCnt(String s) {
        this.b = s;
    }
}

