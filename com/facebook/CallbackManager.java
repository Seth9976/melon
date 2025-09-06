package com.facebook;

import A7.d;
import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0002\t\nJ\"\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\bH&¨\u0006\u000B"}, d2 = {"Lcom/facebook/CallbackManager;", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "ActivityResultParameters", "Factory", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface CallbackManager {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u000F\u001A\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\u0017"}, d2 = {"Lcom/facebook/CallbackManager$ActivityResultParameters;", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "(IILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getRequestCode", "()I", "getResultCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class ActivityResultParameters {
        @Nullable
        private final Intent data;
        private final int requestCode;
        private final int resultCode;

        public ActivityResultParameters(int v, int v1, @Nullable Intent intent0) {
            this.requestCode = v;
            this.resultCode = v1;
            this.data = intent0;
        }

        public final int component1() {
            return this.requestCode;
        }

        public final int component2() {
            return this.resultCode;
        }

        @Nullable
        public final Intent component3() {
            return this.data;
        }

        @NotNull
        public final ActivityResultParameters copy(int v, int v1, @Nullable Intent intent0) {
            return new ActivityResultParameters(v, v1, intent0);
        }

        public static ActivityResultParameters copy$default(ActivityResultParameters callbackManager$ActivityResultParameters0, int v, int v1, Intent intent0, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = callbackManager$ActivityResultParameters0.requestCode;
            }
            if((v2 & 2) != 0) {
                v1 = callbackManager$ActivityResultParameters0.resultCode;
            }
            if((v2 & 4) != 0) {
                intent0 = callbackManager$ActivityResultParameters0.data;
            }
            return callbackManager$ActivityResultParameters0.copy(v, v1, intent0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ActivityResultParameters)) {
                return false;
            }
            if(this.requestCode != ((ActivityResultParameters)object0).requestCode) {
                return false;
            }
            return this.resultCode == ((ActivityResultParameters)object0).resultCode ? q.b(this.data, ((ActivityResultParameters)object0).data) : false;
        }

        @Nullable
        public final Intent getData() {
            return this.data;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        @Override
        public int hashCode() {
            int v = d.b(this.resultCode, this.requestCode * 0x1F, 0x1F);
            return this.data == null ? v : v + this.data.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "ActivityResultParameters(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/CallbackManager$Factory;", "", "()V", "create", "Lcom/facebook/CallbackManager;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Factory {
        @NotNull
        public static final Factory INSTANCE;

        static {
            Factory.INSTANCE = new Factory();
        }

        @NotNull
        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int arg1, int arg2, @Nullable Intent arg3);
}

