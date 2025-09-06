package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension;
    private FontAssetDelegate delegate;
    private final Map fontFamilies;
    private final Map fontMap;
    private final MutablePair tempPair;

    public FontAssetManager(Drawable.Callback drawable$Callback0, FontAssetDelegate fontAssetDelegate0) {
        this.tempPair = new MutablePair();
        this.fontMap = new HashMap();
        this.fontFamilies = new HashMap();
        this.defaultFontFileExtension = ".ttf";
        this.delegate = fontAssetDelegate0;
        if(!(drawable$Callback0 instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View)drawable$Callback0).getContext().getAssets();
    }

    private Typeface getFontFamily(Font font0) {
        String s = font0.getFamily();
        Typeface typeface0 = (Typeface)this.fontFamilies.get(s);
        if(typeface0 != null) {
            return typeface0;
        }
        if(font0.getTypeface() != null) {
            return font0.getTypeface();
        }
        Typeface typeface1 = Typeface.createFromAsset(this.assetManager, "fonts/" + s + this.defaultFontFileExtension);
        this.fontFamilies.put(s, typeface1);
        return typeface1;
    }

    public Typeface getTypeface(Font font0) {
        this.tempPair.set(font0.getFamily(), font0.getStyle());
        Typeface typeface0 = (Typeface)this.fontMap.get(this.tempPair);
        if(typeface0 != null) {
            return typeface0;
        }
        Typeface typeface1 = this.typefaceForStyle(this.getFontFamily(font0), font0.getStyle());
        this.fontMap.put(this.tempPair, typeface1);
        return typeface1;
    }

    public void setDefaultFontFileExtension(String s) {
        this.defaultFontFileExtension = s;
    }

    public void setDelegate(FontAssetDelegate fontAssetDelegate0) {
        this.delegate = fontAssetDelegate0;
    }

    private Typeface typefaceForStyle(Typeface typeface0, String s) {
        boolean z = s.contains("Italic");
        boolean z1 = s.contains("Bold");
        if(z && z1) {
            return typeface0.getStyle() == 3 ? typeface0 : Typeface.create(typeface0, 3);
        }
        if(z) {
            return typeface0.getStyle() == 2 ? typeface0 : Typeface.create(typeface0, 2);
        }
        int v = z1 ? 1 : 0;
        return typeface0.getStyle() == v ? typeface0 : Typeface.create(typeface0, v);
    }
}

