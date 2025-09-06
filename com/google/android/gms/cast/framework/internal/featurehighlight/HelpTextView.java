package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R.id;

@Keep
public class HelpTextView extends LinearLayout {
    TextView bodyTextView;
    TextView headerTextView;

    @Keep
    public HelpTextView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Keep
    public View asView() [...] // Inlined contents

    @Override  // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        TextView textView0 = (TextView)this.findViewById(id.cast_featurehighlight_help_text_header_view);
        textView0.getClass();
        this.headerTextView = textView0;
        TextView textView1 = (TextView)this.findViewById(id.cast_featurehighlight_help_text_body_view);
        textView1.getClass();
        this.bodyTextView = textView1;
    }

    @Keep
    public void setText(CharSequence charSequence0, CharSequence charSequence1) {
        this.setTextAndVisibility(this.headerTextView, charSequence0);
        this.setTextAndVisibility(this.bodyTextView, charSequence1);
    }

    private void setTextAndVisibility(TextView textView0, CharSequence charSequence0) {
        textView0.setText(charSequence0);
        textView0.setVisibility((TextUtils.isEmpty(charSequence0) ? 8 : 0));
    }
}

