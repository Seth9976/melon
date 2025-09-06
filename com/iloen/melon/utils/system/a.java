package com.iloen.melon.utils.system;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.graphics.Typeface;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaDrm;
import android.net.NetworkRequest;
import android.net.Uri;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.File;
import java.nio.ByteBuffer;

public abstract class a {
    public static void B(ImageDecoder imageDecoder0, int v) {
        imageDecoder0.setMemorySizePolicy(v);
    }

    public static boolean D(NetworkRequest networkRequest0, int v) {
        return networkRequest0.hasCapability(v);
    }

    public static int b(MediaDrm mediaDrm0, byte[] arr_b) {
        return mediaDrm0.getSecurityLevel(arr_b);
    }

    public static ImageDecoder.Source c(ContentResolver contentResolver0, Uri uri0) {
        return ImageDecoder.createSource(contentResolver0, uri0);
    }

    public static ImageDecoder.Source d(AssetManager assetManager0, String s) {
        return ImageDecoder.createSource(assetManager0, s);
    }

    public static ImageDecoder.Source e(File file0) {
        return ImageDecoder.createSource(file0);
    }

    public static ImageDecoder.Source f(ByteBuffer byteBuffer0) {
        return ImageDecoder.createSource(byteBuffer0);
    }

    public static ImageDecoder g(Object object0) [...] // Inlined contents

    public static Typeface h(Typeface typeface0, int v, boolean z) {
        return Typeface.create(typeface0, v, z);
    }

    public static AnimatedImageDrawable i(Drawable drawable0) [...] // Inlined contents

    public static AccessibilityNodeInfo.AccessibilityAction k() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
    }

    public static CharSequence l(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return accessibilityNodeInfo0.getTooltipText();
    }

    public static void n(ImageDecoder imageDecoder0) {
        imageDecoder0.setPostProcessor(null);
    }

    public static void o(ImageDecoder imageDecoder0, int v) {
        imageDecoder0.setAllocator(v);
    }

    public static void p(ImageDecoder imageDecoder0, ColorSpace colorSpace0) {
        imageDecoder0.setTargetColorSpace(colorSpace0);
    }

    public static void q(ImageDecoder imageDecoder0, boolean z) {
        imageDecoder0.setUnpremultipliedRequired(z);
    }

    public static void r(AnimatedImageDrawable animatedImageDrawable0, int v) {
        animatedImageDrawable0.setRepeatCount(v);
    }

    public static boolean v(ActivityManager activityManager0) {
        return activityManager0.isBackgroundRestricted();
    }

    public static boolean w(Drawable drawable0) {
        return drawable0 instanceof AnimatedImageDrawable;
    }

    public static boolean x(NetworkRequest networkRequest0, int v) {
        return networkRequest0.hasTransport(v);
    }

    public static AccessibilityNodeInfo.AccessibilityAction z() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
    }
}

