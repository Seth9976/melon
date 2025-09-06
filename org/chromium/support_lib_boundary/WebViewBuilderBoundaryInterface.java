package org.chromium.support_lib_boundary;

import android.content.Context;
import android.webkit.WebView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface WebViewBuilderBoundaryInterface {
    @Retention(RetentionPolicy.SOURCE)
    public @interface Baseline {
        public static final int DEFAULT;

    }

    public static class Config implements Consumer {
        public int baseline;
        List mJavascriptInterfaceNames;
        List mJavascriptInterfaceObjects;
        List mJavascriptInterfaceSitePatterns;

        public Config() {
            this.baseline = 0;
            this.mJavascriptInterfaceObjects = new ArrayList();
            this.mJavascriptInterfaceNames = new ArrayList();
            this.mJavascriptInterfaceSitePatterns = new ArrayList();
        }

        @Override
        public void accept(Object object0) {
            this.accept(((BiConsumer)object0));
        }

        public void accept(BiConsumer biConsumer0) {
            biConsumer0.accept(0, this.baseline);
            biConsumer0.accept(1, new Object[]{this.mJavascriptInterfaceObjects, this.mJavascriptInterfaceNames, this.mJavascriptInterfaceSitePatterns});
        }

        public void addJavascriptInterface(Object object0, String s, List list0) {
            this.mJavascriptInterfaceObjects.add(object0);
            this.mJavascriptInterfaceNames.add(s);
            this.mJavascriptInterfaceSitePatterns.add(list0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE_USE})
    public @interface ConfigField {
        public static final int BASELINE = 0;
        public static final int JAVASCRIPT_INTERFACE = 1;

    }

    WebView build(Context arg1, Consumer arg2);
}

