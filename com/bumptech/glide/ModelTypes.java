package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.net.URL;

interface ModelTypes {
    Object load(Bitmap arg1);

    Object load(Drawable arg1);

    Object load(Uri arg1);

    Object load(File arg1);

    Object load(Integer arg1);

    Object load(Object arg1);

    Object load(String arg1);

    @Deprecated
    Object load(URL arg1);

    Object load(byte[] arg1);
}

