package com.kakao.emoticon.controller;

import android.content.Context;
import androidx.appcompat.app.o;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.ui.KeyboardEmoticonManager.ShowType;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class KeyboardHeightHelper {
    static final class KeyboardHeightCache implements Externalizable {
        private static final String FILE_NAME = "key_height";
        private final Context context;
        private int landscapeTabHeight;
        private int portraitTabHeight;
        private int version;

        public KeyboardHeightCache(Context context0) {
            this.version = 1;
            this.portraitTabHeight = 0;
            this.landscapeTabHeight = 0;
            this.context = context0;
            this.loadObject();
        }

        // 检测为 Lambda 实现
        public static void a(KeyboardHeightCache keyboardHeightHelper$KeyboardHeightCache0) [...]

        public int getLandscapeTabHeight(int v) {
            return this.landscapeTabHeight == 0 ? v : this.landscapeTabHeight;
        }

        public int getPortraitTabHeight(int v) {
            return this.portraitTabHeight == 0 ? v : this.portraitTabHeight;
        }

        public boolean isValid() {
            return this.portraitTabHeight > 0 && this.landscapeTabHeight > 0;
        }

        private void lambda$setPortraitTabHeight$0() {
            this.saveObject();
        }

        private void loadObject() {
            Throwable throwable1;
            Exception exception1;
            ObjectInputStream objectInputStream0;
            try {
                File file0 = new File(this.context.getCacheDir(), "key_height");
                if(file0.exists()) {
                    objectInputStream0 = new ObjectInputStream(new FileInputStream(file0));
                    goto label_12;
                }
                return;
            }
            catch(Exception exception0) {
                objectInputStream0 = null;
                exception1 = exception0;
                goto label_15;
            }
            catch(Throwable throwable0) {
                objectInputStream0 = null;
                throwable1 = throwable0;
                goto label_20;
            }
            try {
            label_12:
                this.readExternal(objectInputStream0);
                goto label_23;
            }
            catch(Exception exception1) {
                try {
                label_15:
                    exception1.printStackTrace();
                    if(objectInputStream0 != null) {
                        goto label_17;
                    }
                    return;
                }
                catch(Throwable throwable1) {
                    goto label_20;
                }
                try {
                label_17:
                    objectInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
                return;
            }
            catch(Throwable throwable1) {
            }
        label_20:
            if(objectInputStream0 != null) {
                try {
                    objectInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable1;
            try {
            label_23:
                objectInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }

        @Override
        public void readExternal(ObjectInput objectInput0) {
            this.version = objectInput0.readInt();
            this.portraitTabHeight = objectInput0.readInt();
            this.landscapeTabHeight = objectInput0.readInt();
        }

        private void saveObject() {
            Throwable throwable1;
            Exception exception1;
            ObjectOutputStream objectOutputStream0 = null;
            try {
                objectOutputStream0 = new ObjectOutputStream(new FileOutputStream(new File(this.context.getCacheDir(), "key_height")));
            }
            catch(Exception exception0) {
                exception1 = exception0;
                goto label_12;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_17;
            }
            try {
                this.writeExternal(objectOutputStream0);
                goto label_20;
            }
            catch(Exception exception1) {
                try {
                label_12:
                    exception1.printStackTrace();
                    if(objectOutputStream0 != null) {
                        goto label_14;
                    }
                    return;
                }
                catch(Throwable throwable1) {
                    goto label_17;
                }
                try {
                label_14:
                    objectOutputStream0.close();
                }
                catch(IOException unused_ex) {
                }
                return;
            }
            catch(Throwable throwable1) {
            }
        label_17:
            if(objectOutputStream0 != null) {
                try {
                    objectOutputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable1;
            try {
            label_20:
                objectOutputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }

        public void setLandscapeTabHeight(int v) {
            if(this.landscapeTabHeight == v) {
                return;
            }
            this.landscapeTabHeight = v;
            this.saveObject();
        }

        public void setPortraitTabHeight(int v) {
            if(this.portraitTabHeight == v) {
                return;
            }
            this.portraitTabHeight = v;
            KakaoEmoticon.getBackgroundHandler().post(() -> this.lambda$setPortraitTabHeight$0());
        }

        @Override
        public void writeExternal(ObjectOutput objectOutput0) {
            objectOutput0.writeInt(this.version);
            objectOutput0.writeInt(this.portraitTabHeight);
            objectOutput0.writeInt(this.landscapeTabHeight);
        }
    }

    private KeyboardHeightCache cache;
    private Context context;
    private int defaultLandscapeHeight;
    private int defaultPortraitHeight;
    private int maxLandscapeHeight;
    private int minPortraitHeight;
    private ShowType showType;

    public KeyboardHeightHelper(Context context0, int v, int v1, int v2, int v3) {
        this.showType = ShowType.DEFAULT;
        this.minPortraitHeight = v2;
        this.defaultPortraitHeight = v;
        this.defaultLandscapeHeight = v1;
        this.maxLandscapeHeight = v3;
        this.context = context0;
        this.cache = new KeyboardHeightCache(context0);
    }

    // 去混淆评级： 低(20)
    public int getKeyboardHeight() {
        return this.isLandscape() ? this.getLandscapeHeight() : this.getPortraitHeight();
    }

    public int getKeyboardHeight(int v) {
        switch(v) {
            case 1: {
                return this.getPortraitHeight();
            }
            case 2: {
                return this.getLandscapeHeight();
            }
            default: {
                return 0;
            }
        }
    }

    // 去混淆评级： 低(20)
    private int getLandscapeHeight() {
        return this.isHeightTooSmall() ? this.defaultLandscapeHeight : Math.min(this.cache.getLandscapeTabHeight(this.defaultLandscapeHeight), this.maxLandscapeHeight);
    }

    // 去混淆评级： 低(20)
    private int getPortraitHeight() {
        return this.isHeightTooSmall() ? this.defaultPortraitHeight : this.cache.getPortraitTabHeight(this.defaultPortraitHeight);
    }

    public boolean isHeightTooSmall() {
        return !this.isLandscape() && this.showType != ShowType.POPUP && this.cache.getPortraitTabHeight(this.defaultPortraitHeight) < this.minPortraitHeight;
    }

    private boolean isLandscape() {
        return this.context.getResources().getConfiguration().orientation == 2;
    }

    public void setKeyboardHeight(int v, int v1) {
        switch(v1) {
            case 1: {
                this.setPortraitHeight(v);
                return;
            }
            case 2: {
                this.setLandscapeHeight(v);
            }
        }
    }

    private void setLandscapeHeight(int v) {
        int v1 = this.maxLandscapeHeight;
        if(v > v1) {
            v = v1;
        }
        this.cache.setLandscapeTabHeight(v);
    }

    private void setPortraitHeight(int v) {
        this.cache.setPortraitTabHeight(v);
    }

    public void setShowType(ShowType keyboardEmoticonManager$ShowType0) {
        this.showType = keyboardEmoticonManager$ShowType0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("KeyboardHeightHelper{portraitHeight=");
        stringBuilder0.append(this.getPortraitHeight());
        stringBuilder0.append(", landscapeHeight=");
        stringBuilder0.append(this.getLandscapeHeight());
        stringBuilder0.append(", minPortraitHeight=");
        stringBuilder0.append(this.minPortraitHeight);
        stringBuilder0.append(", defaultPortraitHeight=");
        stringBuilder0.append(this.defaultPortraitHeight);
        stringBuilder0.append(", defaultLandscapeHeight=");
        stringBuilder0.append(this.defaultLandscapeHeight);
        stringBuilder0.append(", cachedPortraitHeight=");
        return o.q(stringBuilder0, this.cache.getPortraitTabHeight(this.defaultPortraitHeight), '}');
    }
}

