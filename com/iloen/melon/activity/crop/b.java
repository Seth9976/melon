package com.iloen.melon.activity.crop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public final class b {
    public Object a;
    public static b b;

    public b(Bitmap bitmap0) {
        this.a = bitmap0;
    }

    public Bitmap a(FileDescriptor fileDescriptor0, BitmapFactory.Options bitmapFactory$Options0) {
        a a1;
        boolean z;
        if(bitmapFactory$Options0.mCancel) {
            return null;
        }
        Thread thread0 = Thread.currentThread();
        synchronized(this) {
            z = true;
            a a0 = (a)((WeakHashMap)this.a).get(thread0);
        }
        if(a0 == null) {
        }
        else if(a0.a == 1) {
            z = false;
        }
        if(!z) {
            Log.d("BitmapManager", "Thread " + thread0 + " is not allowed to decode.");
            return null;
        }
        synchronized(this) {
            synchronized(this) {
                a1 = (a)((WeakHashMap)this.a).get(thread0);
                if(a1 == null) {
                    a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a1.a = 2;
                    ((WeakHashMap)this.a).put(thread0, a1);
                }
            }
            a1.b = bitmapFactory$Options0;
        }
        Bitmap bitmap0 = BitmapFactory.decodeFileDescriptor(fileDescriptor0, null, bitmapFactory$Options0);
        synchronized(this) {
            ((a)((WeakHashMap)this.a).get(thread0)).b = null;
        }
        return bitmap0;
    }

    public static b b() {
        synchronized(b.class) {
            if(b.b == null) {
                b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b0.a = new WeakHashMap();
                b.b = b0;
            }
            return b.b;
        }
    }
}

