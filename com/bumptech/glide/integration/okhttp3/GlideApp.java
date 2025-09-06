package com.bumptech.glide.integration.okhttp3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import java.io.File;

public final class GlideApp {
    @SuppressLint({"VisibleForTests"})
    public static void enableHardwareBitmaps() {
        Glide.enableHardwareBitmaps();
    }

    public static Glide get(Context context0) {
        return Glide.get(context0);
    }

    public static File getPhotoCacheDir(Context context0) {
        return Glide.getPhotoCacheDir(context0);
    }

    public static File getPhotoCacheDir(Context context0, String s) {
        return Glide.getPhotoCacheDir(context0, s);
    }

    @SuppressLint({"VisibleForTests"})
    public static void init(Context context0, GlideBuilder glideBuilder0) {
        Glide.init(context0, glideBuilder0);
    }

    @SuppressLint({"VisibleForTests"})
    @Deprecated
    public static void init(Glide glide0) {
        Glide.init(glide0);
    }

    @SuppressLint({"VisibleForTests"})
    public static void isInitialized() {
        Glide.isInitialized();
    }

    @SuppressLint({"VisibleForTests"})
    public static void tearDown() {
        Glide.tearDown();
    }

    @Deprecated
    public static GlideRequests with(Activity activity0) {
        return (GlideRequests)Glide.with(activity0);
    }

    @Deprecated
    public static GlideRequests with(Fragment fragment0) {
        return (GlideRequests)Glide.with(fragment0);
    }

    public static GlideRequests with(Context context0) {
        return (GlideRequests)Glide.with(context0);
    }

    public static GlideRequests with(View view0) {
        return (GlideRequests)Glide.with(view0);
    }

    public static GlideRequests with(FragmentActivity fragmentActivity0) {
        return (GlideRequests)Glide.with(fragmentActivity0);
    }

    public static GlideRequests with(I i0) {
        return (GlideRequests)Glide.with(i0);
    }
}

