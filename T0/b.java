package t0;

import android.graphics.RenderEffect;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;

public abstract class b {
    public static RenderEffect a() {
        return RenderEffect.createOffsetEffect(0.0f, 0.0f);
    }

    public static TranslationResponseValue e(ViewTranslationResponse viewTranslationResponse0) {
        return viewTranslationResponse0.getValue("android:text");
    }

    public static CharSequence f(TranslationResponseValue translationResponseValue0) {
        return translationResponseValue0.getText();
    }
}

