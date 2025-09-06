package e2;

import android.content.ClipData.Item;
import android.content.ClipData;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.appcompat.widget.AppCompatEditText;
import c2.W;
import c2.e;
import com.iloen.melon.custom.S0;
import com.iloen.melon.fragments.radio.a;

public final class b extends InputConnectionWrapper {
    public final a a;

    public b(InputConnection inputConnection0, a a0) {
        this.a = a0;
        super(inputConnection0, false);
    }

    @Override  // android.view.inputmethod.InputConnectionWrapper
    public final boolean commitContent(InputContentInfo inputContentInfo0, int v, Bundle bundle0) {
        androidx.lifecycle.b b0;
        Bundle bundle1;
        S0 s00 = inputContentInfo0 == null ? null : new S0(new S0(inputContentInfo0, 3), 4);
        AppCompatEditText appCompatEditText0 = (AppCompatEditText)this.a.b;
        if((v & 1) == 0) {
            bundle1 = bundle0;
        }
        else {
            try {
                ((InputContentInfo)((S0)s00.b).b).requestPermission();
            }
            catch(Exception exception0) {
                Log.w("InputConnectionCompat", "Can\'t insert content from IME; requestPermission() failed", exception0);
                return super.commitContent(inputContentInfo0, v, bundle0);
            }
            InputContentInfo inputContentInfo1 = (InputContentInfo)((S0)s00.b).b;
            bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
            bundle1.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo1);
        }
        InputContentInfo inputContentInfo2 = (InputContentInfo)((S0)s00.b).b;
        ClipData clipData0 = new ClipData(inputContentInfo2.getDescription(), new ClipData.Item(inputContentInfo2.getContentUri()));
        if(Build.VERSION.SDK_INT >= 0x1F) {
            b0 = new androidx.lifecycle.b(clipData0, 2);
        }
        else {
            b0 = new e();
            b0.b = clipData0;
            b0.c = 2;
        }
        b0.b(inputContentInfo2.getLinkUri());
        b0.setExtras(bundle1);
        return W.k(appCompatEditText0, b0.build()) == null ? true : super.commitContent(inputContentInfo0, v, bundle0);
    }
}

