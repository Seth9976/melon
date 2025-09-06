package d2;

import E9.w;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.widget.AutoCompleteTextView;
import androidx.media3.session.a0;
import com.google.android.material.search.SearchBar;
import com.google.android.material.textfield.h;

public final class b implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final a0 a;

    public b(a0 a00) {
        this.a = a00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? this.a.equals(((b)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        Object object0 = this.a.b;
        if(this.a.a == 23) {
            ((SearchBar)object0).setFocusableInTouchMode(z);
        }
        else {
            AutoCompleteTextView autoCompleteTextView0 = ((h)object0).h;
            if(autoCompleteTextView0 != null && !w.D(autoCompleteTextView0)) {
                ((h)object0).d.setImportantForAccessibility((z ? 2 : 1));
            }
        }
    }
}

