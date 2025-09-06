package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class AndroidResourceSignature implements Key {
    private final Key applicationVersion;
    private final int nightMode;

    private AndroidResourceSignature(int v, Key key0) {
        this.nightMode = v;
        this.applicationVersion = key0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof AndroidResourceSignature && this.nightMode == ((AndroidResourceSignature)object0).nightMode && this.applicationVersion.equals(((AndroidResourceSignature)object0).applicationVersion);
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.applicationVersion, this.nightMode);
    }

    public static Key obtain(Context context0) {
        Key key0 = ApplicationVersionSignature.obtain(context0);
        return new AndroidResourceSignature(context0.getResources().getConfiguration().uiMode & 0x30, key0);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        this.applicationVersion.updateDiskCacheKey(messageDigest0);
        messageDigest0.update(ByteBuffer.allocate(4).putInt(this.nightMode).array());
    }
}

