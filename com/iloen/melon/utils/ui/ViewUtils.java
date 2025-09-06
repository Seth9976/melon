package com.iloen.melon.utils.ui;

import Cb.k;
import P1.c;
import Tf.o;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import c2.W;
import c2.b;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import d2.d;
import d5.f;
import ie.m;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001C\b\u00C7\u0002\u0018\u00002\u00020\u0001J%\u0010\u0007\u001A\u00020\u0006*\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0011J#\u0010\u0017\u001A\u00020\u00062\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001B\u001A\u00020\u00062\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ#\u0010 \u001A\u00020\u00062\b\u0010\u001D\u001A\u0004\u0018\u00010\u00032\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0007\u00A2\u0006\u0004\b \u0010!J!\u0010$\u001A\u00020\u00062\b\u0010\u001D\u001A\u0004\u0018\u00010\u00032\u0006\u0010#\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b$\u0010%J!\u0010\'\u001A\u00020\u00062\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010&\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010)\u001A\u00020\u00042\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0007\u00A2\u0006\u0004\b)\u0010*J\u0019\u0010+\u001A\u00020\u00042\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0007\u00A2\u0006\u0004\b+\u0010,J!\u0010/\u001A\u00020\u00062\b\u0010-\u001A\u0004\u0018\u00010\u000B2\u0006\u0010.\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b/\u00100J#\u00103\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\b\u00102\u001A\u0004\u0018\u000101H\u0007\u00A2\u0006\u0004\b3\u00104J#\u00107\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\b\u00106\u001A\u0004\u0018\u000105H\u0007\u00A2\u0006\u0004\b7\u00108J\u0019\u00109\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0004\b9\u0010:J!\u0010<\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010;\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b<\u0010\u0011J)\u0010<\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010;\u001A\u00020\u00042\u0006\u0010=\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b<\u0010>J3\u0010<\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\u0006\u0010;\u001A\u00020\u00042\u0006\u0010=\u001A\u00020\u00042\b\b\u0001\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0004\b<\u0010AJ\u001B\u0010C\u001A\u0004\u0018\u00010B2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0004\bC\u0010DJ!\u0010H\u001A\u00020\u00062\b\u0010F\u001A\u0004\u0018\u00010E2\u0006\u0010G\u001A\u00020\"H\u0007\u00A2\u0006\u0004\bH\u0010IJ)\u0010H\u001A\u00020\u00062\b\u0010F\u001A\u0004\u0018\u00010E2\u0006\u0010G\u001A\u00020\"2\u0006\u0010J\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\bH\u0010KJ+\u0010M\u001A\u0004\u0018\u00010\u001E2\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010G\u001A\u00020\"2\u0006\u0010L\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\bM\u0010NJ3\u0010R\u001A\u00020\u00062\b\u0010F\u001A\u0004\u0018\u00010E2\b\u0010O\u001A\u0004\u0018\u00010B2\u0006\u0010P\u001A\u00020\"2\u0006\u0010Q\u001A\u00020\"H\u0007\u00A2\u0006\u0004\bR\u0010SJ#\u0010U\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00132\b\b\u0002\u0010T\u001A\u00020\"H\u0007\u00A2\u0006\u0004\bU\u0010VJ-\u0010U\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00132\b\b\u0002\u0010T\u001A\u00020\"2\b\b\u0002\u0010W\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\bU\u0010XJ1\u0010^\u001A\u00020]2\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010Z\u001A\u00020Y2\u0006\u0010[\u001A\u00020Y2\u0006\u0010\\\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b^\u0010_J!\u0010a\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00132\u0006\u0010`\u001A\u00020?H\u0007\u00A2\u0006\u0004\ba\u0010bJ!\u0010d\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00132\u0006\u0010c\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\bd\u0010(J#\u0010f\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\b\u0010e\u001A\u0004\u0018\u00010\u0015H\u0007\u00A2\u0006\u0004\bf\u0010gJ-\u0010f\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\b\u0010e\u001A\u0004\u0018\u00010\u00152\b\u0010h\u001A\u0004\u0018\u00010\u0015H\u0007\u00A2\u0006\u0004\bf\u0010iJ;\u0010k\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u00032\b\u0010e\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010j\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010h\u001A\u0004\u0018\u00010\u0015H\u0007\u00A2\u0006\u0004\bk\u0010lJ9\u0010p\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010e\u001A\u00020Y2\u0006\u0010m\u001A\u00020\"2\u0006\u0010n\u001A\u00020\"2\b\b\u0002\u0010o\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\bp\u0010qJ#\u0010s\u001A\u00020\u00062\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010r\u001A\u0004\u0018\u00010YH\u0007\u00A2\u0006\u0004\bs\u0010tR\u0014\u0010u\u001A\u00020Y8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010w\u001A\u00020?8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bw\u0010x\u00A8\u0006y"}, d2 = {"Lcom/iloen/melon/utils/ui/ViewUtils;", "", "Lie/m;", "Landroid/view/View;", "", "onOff", "Lie/H;", "switchShowAndHide", "(Lie/m;Z)V", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "getActivity", "(Landroid/content/Context;)Landroid/app/Activity;", "view", "condition", "showWhen", "(Landroid/view/View;Z)V", "hideWhen", "Landroid/widget/TextView;", "textView", "", "text", "setText", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "Landroid/widget/EditText;", "editText", "setSelection", "(Landroid/widget/EditText;)V", "v", "Landroid/graphics/drawable/Drawable;", "d", "setBackground", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "", "color", "setBackgroundColor", "(Landroid/view/View;I)V", "marquee", "setTextViewMarquee", "(Landroid/widget/TextView;Z)V", "isTextViewEllipsis", "(Landroid/widget/TextView;)Z", "hasStringEditText", "(Landroid/widget/EditText;)Z", "a", "requestOrientation", "setOrientation", "(Landroid/app/Activity;I)V", "Landroid/view/View$OnClickListener;", "listener", "setOnClickListener", "(Landroid/view/View;Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnLongClickListener;", "longClickListener", "setOnLongClickListener", "(Landroid/view/View;Landroid/view/View$OnLongClickListener;)V", "hasClickableChild", "(Landroid/view/View;)Z", "isEnable", "setEnable", "isRecursion", "(Landroid/view/View;ZZ)V", "", "disableAlpha", "(Landroid/view/View;ZZF)V", "Landroid/graphics/Bitmap;", "getViewCapture", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "Landroid/widget/ImageView;", "imageView", "pxShorterLength", "setDefaultImage", "(Landroid/widget/ImageView;I)V", "isManType", "(Landroid/widget/ImageView;IZ)V", "isUserType", "getDefaultImage", "(Landroid/content/Context;IZ)Landroid/graphics/drawable/Drawable;", "resourceBitmap", "pxWidth", "pxHeight", "setSqauredCircleImage", "(Landroid/widget/ImageView;Landroid/graphics/Bitmap;II)V", "fontType", "setTypeface", "(Landroid/widget/TextView;I)V", "useIncludeFontPadding", "(Landroid/widget/TextView;IZ)V", "", "original", "target", "colorRes", "Landroid/text/SpannableString;", "replaceTextColor", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Landroid/text/SpannableString;", "letterSpacing", "setLetterSpacing", "(Landroid/widget/TextView;F)V", "isUseFallbackLineSpacing", "setFallbackLineSpacing", "contentDescription", "setContentDescriptionWithButtonClassName", "(Landroid/view/View;Ljava/lang/CharSequence;)V", "hint", "(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "className", "setContentDescriptionWithClassName", "(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "position", "totalTabCount", "isSelected", "setTabContentDescription", "(Landroid/view/View;Ljava/lang/String;IIZ)V", "playTime", "setTimeForSecText", "(Landroid/widget/TextView;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "DEFAULT_DISABLE_ALPHA", "F", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ViewUtils {
    public static final int $stable = 0;
    public static final float DEFAULT_DISABLE_ALPHA = 0.3f;
    @NotNull
    public static final ViewUtils INSTANCE = null;
    @NotNull
    public static final String TAG = "ViewUtils";

    static {
        ViewUtils.INSTANCE = new ViewUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final void a(View view0, boolean z) {
        if(view0 instanceof ViewGroup) {
            int v = ((ViewGroup)view0).getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                View view1 = ((ViewGroup)view0).getChildAt(v1);
                q.f(view1, "getChildAt(...)");
                ViewUtils.a(view1, z);
            }
        }
        view0.setEnabled(z);
    }

    @Nullable
    public final Activity getActivity(@NotNull Context context0) {
        q.g(context0, "context");
        if(context0 instanceof ContextWrapper) {
            if(context0 instanceof Activity) {
                return (Activity)context0;
            }
            Context context1 = ((ContextWrapper)context0).getBaseContext();
            q.f(context1, "getBaseContext(...)");
            return this.getActivity(context1);
        }
        return null;
    }

    @Nullable
    public static final Drawable getDefaultImage(@Nullable Context context0, int v, boolean z) {
        int v1;
        if(v >= 0) {
            v = ScreenUtils.pixelToDip(context0, v);
        }
        if(!z) {
            if(v < 0) {
                v1 = 0x7F08093C;  // drawable:transparent
            }
            else if(v <= 40) {
                v1 = 0x7F080794;  // drawable:noimage_logo_xmini
            }
            else if(v <= 89) {
                v1 = 0x7F08078B;  // drawable:noimage_logo_mini
            }
            else if(v <= 0x75) {
                v1 = 0x7F08078D;  // drawable:noimage_logo_small
            }
            else {
                v1 = v > 0xB8 ? 0x7F080786 : 0x7F080788;  // drawable:noimage_logo_large
            }
        }
        else if(v <= 28) {
            v1 = 0x7F0807A2;  // drawable:noimage_person_xmini
        }
        else if(v <= 0x2F) {
            v1 = 0x7F08079A;  // drawable:noimage_man_mini
        }
        else if(v <= 0x40) {
            v1 = 0x7F08079C;  // drawable:noimage_man_small
        }
        else if(v <= 0x70) {
            v1 = 0x7F080799;  // drawable:noimage_man_medium
        }
        else {
            v1 = 0x7F080798;  // drawable:noimage_man_big
        }
        q.d(context0);
        return c.getDrawable(context0, v1);
    }

    @Nullable
    public static final Bitmap getViewCapture(@Nullable View view0) {
        if(view0 == null) {
            return null;
        }
        Bitmap bitmap0 = Bitmap.createBitmap(view0.getWidth(), view0.getHeight(), Bitmap.Config.ARGB_8888);
        q.f(bitmap0, "createBitmap(...)");
        Canvas canvas0 = new Canvas(bitmap0);
        Drawable drawable0 = view0.getBackground();
        if(drawable0 == null) {
            canvas0.drawColor(-1);
        }
        else {
            drawable0.draw(canvas0);
        }
        view0.draw(canvas0);
        return bitmap0;
    }

    public static final boolean hasClickableChild(@Nullable View view0) {
        if(view0 instanceof ViewGroup) {
            int v = ((ViewGroup)view0).getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                Object object0 = ((ViewGroup)view0).getChildAt(v1).getTag(0x7F1310F7);  // string:view_pressed_status "view pressed status"
                if(object0 instanceof String && Boolean.parseBoolean(((String)object0))) {
                    return true;
                }
                if(ViewUtils.hasClickableChild(((ViewGroup)view0).getChildAt(v1))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean hasStringEditText(@Nullable EditText editText0) {
        if(editText0 != null) {
            String s = editText0.getText().toString();
            if(TextUtils.isEmpty(s)) {
                return false;
            }
            int v = s.length() - 1;
            int v1 = 0;
            boolean z = false;
            while(v1 <= v) {
                boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
                if(z) {
                    if(!z1) {
                        break;
                    }
                    --v;
                }
                else if(z1) {
                    ++v1;
                }
                else {
                    z = true;
                }
            }
            return s.subSequence(v1, v + 1).toString().length() != 0;
        }
        return false;
    }

    public static final void hideWhen(@Nullable View view0, boolean z) {
        if(view0 != null) {
            view0.setVisibility((z ? 8 : 0));
        }
    }

    public static final boolean isTextViewEllipsis(@Nullable TextView textView0) {
        if(textView0 == null) {
            return false;
        }
        Layout layout0 = textView0.getLayout();
        if(layout0 != null) {
            int v = layout0.getLineCount();
            if(v > 0) {
                for(int v1 = 1; v1 < v; ++v1) {
                    if(layout0.getEllipsisCount(v - v1) > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public static final SpannableString replaceTextColor(@Nullable Context context0, @NotNull String s, @NotNull String s1, int v) {
        q.g(s, "original");
        q.g(s1, "target");
        int v1 = ColorUtils.getColor(context0, v);
        int v2 = o.F0(s, s1, 0, false, 6);
        SpannableString spannableString0 = new SpannableString(s);
        try {
            spannableString0.setSpan(new ForegroundColorSpan(v1), v2, s1.length() + v2, 33);
        }
        catch(Exception exception0) {
            Y.w("replaceTextColor() - ", exception0.getMessage(), LogU.Companion, "ViewUtils");
        }
        return spannableString0;
    }

    public static final void setBackground(@Nullable View view0, @Nullable Drawable drawable0) {
        if(view0 == null) {
            return;
        }
        view0.setBackground(drawable0);
    }

    public static final void setBackgroundColor(@Nullable View view0, int v) {
        if(view0 == null) {
            return;
        }
        view0.setBackgroundColor(v);
    }

    public static final void setContentDescriptionWithButtonClassName(@Nullable View view0, @Nullable CharSequence charSequence0) {
        ViewUtils.setContentDescriptionWithButtonClassName(view0, charSequence0, null);
    }

    public static final void setContentDescriptionWithButtonClassName(@Nullable View view0, @Nullable CharSequence charSequence0, @Nullable CharSequence charSequence1) {
        ViewUtils.setContentDescriptionWithClassName(view0, charSequence0, "android.widget.Button", charSequence1);
    }

    public static final void setContentDescriptionWithClassName(@Nullable View view0, @Nullable CharSequence charSequence0) {
        ViewUtils.setContentDescriptionWithClassName$default(view0, charSequence0, null, null, 12, null);
    }

    public static final void setContentDescriptionWithClassName(@Nullable View view0, @Nullable CharSequence charSequence0, @Nullable CharSequence charSequence1) {
        ViewUtils.setContentDescriptionWithClassName$default(view0, charSequence0, charSequence1, null, 8, null);
    }

    public static final void setContentDescriptionWithClassName(@Nullable View view0, @Nullable CharSequence charSequence0, @Nullable CharSequence charSequence1, @Nullable CharSequence charSequence2) {
        if(view0 == null || charSequence0 == null) {
            return;
        }
        W.o(view0, new b() {
            @Override  // c2.b
            public void onInitializeAccessibilityNodeInfo(View view0, d d0) {
                q.g(view0, "host");
                q.g(d0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.o(charSequence0);
                d0.l(charSequence1);
                CharSequence charSequence0 = charSequence2;
                if(charSequence0 != null) {
                    d0.a.setHintText(charSequence0);
                }
            }
        });
    }

    public static void setContentDescriptionWithClassName$default(View view0, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, int v, Object object0) {
        if((v & 4) != 0) {
            charSequence1 = null;
        }
        if((v & 8) != 0) {
            charSequence2 = null;
        }
        ViewUtils.setContentDescriptionWithClassName(view0, charSequence0, charSequence1, charSequence2);
    }

    public static final void setDefaultImage(@Nullable ImageView imageView0, int v) {
        ViewUtils.setDefaultImage(imageView0, v, false);
    }

    public static final void setDefaultImage(@Nullable ImageView imageView0, int v, boolean z) {
        if(imageView0 == null) {
            return;
        }
        imageView0.setImageDrawable(ViewUtils.getDefaultImage(imageView0.getContext(), v, z));
    }

    public static final void setEnable(@Nullable View view0, boolean z) {
        ViewUtils.setEnable(view0, z, false);
    }

    public static final void setEnable(@Nullable View view0, boolean z, boolean z1) {
        ViewUtils.setEnable(view0, z, z1, 0.3f);
    }

    public static final void setEnable(@Nullable View view0, boolean z, boolean z1, float f) {
        float f2;
        if(view0 == null || view0.isEnabled() == z) {
            return;
        }
        if(z1) {
            ViewUtils.a(view0, z);
        }
        else {
            view0.setEnabled(z);
        }
        float f1 = 1.0f;
        if(z) {
            Object object0 = view0.getTag(0x7F1310F5);  // string:view_current_alpha "current alpha"
            f2 = object0 instanceof Float ? ((Number)object0).floatValue() : 1.0f;
        }
        else {
            float f3 = view0.getAlpha();
            view0.setTag(0x7F1310F5, f3);  // string:view_current_alpha "current alpha"
            f2 = f3;
        }
        if(!z) {
            f2 *= f;
        }
        if(f2 <= 1.0f) {
            f1 = 0.0f;
            if(f2 >= 0.0f) {
                f1 = f2;
            }
        }
        view0.setAlpha(f1);
        view0.requestLayout();
    }

    public static final void setFallbackLineSpacing(@Nullable TextView textView0, boolean z) {
        if(textView0 != null) {
            textView0.setFallbackLineSpacing(z);
        }
    }

    public static final void setLetterSpacing(@Nullable TextView textView0, float f) {
        if(textView0 == null) {
            return;
        }
        textView0.setLetterSpacing(f);
    }

    public static final void setOnClickListener(@Nullable View view0, @Nullable View.OnClickListener view$OnClickListener0) {
        if(view0 == null) {
            return;
        }
        view0.setOnClickListener(view$OnClickListener0);
    }

    public static final void setOnLongClickListener(@Nullable View view0, @Nullable View.OnLongClickListener view$OnLongClickListener0) {
        if(view0 == null) {
            return;
        }
        view0.setOnLongClickListener(view$OnLongClickListener0);
    }

    public static final void setOrientation(@Nullable Activity activity0, int v) {
        if(activity0 == null) {
            return;
        }
        try {
            activity0.setRequestedOrientation(v);
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void setSelection(@Nullable EditText editText0) {
        if(editText0 != null) {
            int v = editText0.length();
            if(v > 0) {
                Selection.setSelection(editText0.getText(), v);
            }
        }
    }

    public static final void setSqauredCircleImage(@Nullable ImageView imageView0, @Nullable Bitmap bitmap0, int v, int v1) {
        if(imageView0 != null) {
            int v2 = Math.min(v, v1);
            Bitmap bitmap1 = ImageUtils.getCircledBitmap(bitmap0, v2, v2);
            if(bitmap1 != null) {
                imageView0.setImageBitmap(bitmap1);
            }
        }
    }

    public static final void setTabContentDescription(@NotNull View view0, @NotNull String s, int v, int v1, boolean z) {
        q.g(view0, "view");
        q.g(s, "contentDescription");
        StringBuilder stringBuilder0 = new StringBuilder();
        if(z) {
            stringBuilder0.append("선택됨,");
        }
        stringBuilder0.append(s);
        stringBuilder0.append(",");
        stringBuilder0.append("탭");
        stringBuilder0.append(",");
        stringBuilder0.append(view0.getContext().getString(0x7F130C66, new Object[]{v1, v}));  // string:talkback_tab_index "%1$d개 중 %2$d번째"
        view0.setContentDescription(stringBuilder0);
    }

    public static void setTabContentDescription$default(View view0, String s, int v, int v1, boolean z, int v2, Object object0) {
        if((v2 & 16) != 0) {
            z = false;
        }
        ViewUtils.setTabContentDescription(view0, s, v, v1, z);
    }

    public static final void setText(@Nullable TextView textView0, @Nullable CharSequence charSequence0) {
        if(textView0 != null) {
            textView0.setText(charSequence0);
        }
    }

    public static final void setTextViewMarquee(@Nullable TextView textView0, boolean z) {
        if(textView0 == null) {
            return;
        }
        TextUtils.TruncateAt textUtils$TruncateAt0 = textView0.getEllipsize();
        if(z) {
            TextUtils.TruncateAt textUtils$TruncateAt1 = TextUtils.TruncateAt.MARQUEE;
            if(textUtils$TruncateAt1 != textUtils$TruncateAt0) {
                textView0.setEllipsize(textUtils$TruncateAt1);
            }
            textView0.setSelected(true);
            textView0.setHorizontallyScrolling(true);
            return;
        }
        TextUtils.TruncateAt textUtils$TruncateAt2 = TextUtils.TruncateAt.END;
        if(textUtils$TruncateAt2 != textUtils$TruncateAt0) {
            textView0.setEllipsize(textUtils$TruncateAt2);
        }
        textView0.setSelected(false);
        textView0.setHorizontallyScrolling(false);
    }

    public static final void setTimeForSecText(@Nullable TextView textView0, @Nullable String s) {
        if(textView0 != null && s != null && s.length() != 0) {
            ViewUtils.setText(textView0, k.f(s));
        }
    }

    public static final void setTypeface(@Nullable TextView textView0, int v) {
        ViewUtils.setTypeface(textView0, v, false);
    }

    public static final void setTypeface(@Nullable TextView textView0, int v, boolean z) {
        Typeface typeface0;
        if(textView0 != null) {
            Context context0 = textView0.getContext();
            try {
                typeface0 = v == 0 ? f.G(context0) : f.F(context0);
            }
            catch(Exception unused_ex) {
                typeface0 = null;
            }
            if(typeface0 != null) {
                textView0.setTypeface(typeface0);
                textView0.setIncludeFontPadding(z);
                textView0.setCursorVisible(true);
            }
        }
    }

    public static void setTypeface$default(TextView textView0, int v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        ViewUtils.setTypeface(textView0, v);
    }

    public static void setTypeface$default(TextView textView0, int v, boolean z, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        ViewUtils.setTypeface(textView0, v, z);
    }

    public static final void showWhen(@Nullable View view0, boolean z) {
        if(view0 != null) {
            view0.setVisibility((z ? 0 : 8));
        }
    }

    public final void switchShowAndHide(@NotNull m m0, boolean z) {
        q.g(m0, "<this>");
        int v = 8;
        ((View)m0.a).setVisibility((z ? 0 : 8));
        View view0 = (View)m0.b;
        if(!z) {
            v = 0;
        }
        view0.setVisibility(v);
    }
}

