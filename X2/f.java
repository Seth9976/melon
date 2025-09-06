package x2;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import e1.u;

public final class f extends u {
    public final TextView e;
    public final d f;
    public boolean g;

    public f(TextView textView0) {
        this.e = textView0;
        this.g = true;
        this.f = new d(textView0);
    }

    @Override  // e1.u
    public final boolean G() {
        return this.g;
    }

    @Override  // e1.u
    public final void S(boolean z) {
        if(z) {
            TransformationMethod transformationMethod0 = this.W(this.e.getTransformationMethod());
            this.e.setTransformationMethod(transformationMethod0);
        }
    }

    @Override  // e1.u
    public final void T(boolean z) {
        this.g = z;
        TransformationMethod transformationMethod0 = this.W(this.e.getTransformationMethod());
        this.e.setTransformationMethod(transformationMethod0);
        InputFilter[] arr_inputFilter = this.t(this.e.getFilters());
        this.e.setFilters(arr_inputFilter);
    }

    @Override  // e1.u
    public final TransformationMethod W(TransformationMethod transformationMethod0) {
        if(this.g) {
            if(transformationMethod0 instanceof j) {
                return transformationMethod0;
            }
            return transformationMethod0 instanceof PasswordTransformationMethod ? transformationMethod0 : new j(transformationMethod0);
        }
        return transformationMethod0 instanceof j ? ((j)transformationMethod0).a : transformationMethod0;
    }

    @Override  // e1.u
    public final InputFilter[] t(InputFilter[] arr_inputFilter) {
        d d0;
        if(!this.g) {
            SparseArray sparseArray0 = new SparseArray(1);
            for(int v1 = 0; v1 < arr_inputFilter.length; ++v1) {
                InputFilter inputFilter0 = arr_inputFilter[v1];
                if(inputFilter0 instanceof d) {
                    sparseArray0.put(v1, inputFilter0);
                }
            }
            if(sparseArray0.size() == 0) {
                return arr_inputFilter;
            }
            InputFilter[] arr_inputFilter1 = new InputFilter[arr_inputFilter.length - sparseArray0.size()];
            int v2 = 0;
            for(int v = 0; v < arr_inputFilter.length; ++v) {
                if(sparseArray0.indexOfKey(v) < 0) {
                    arr_inputFilter1[v2] = arr_inputFilter[v];
                    ++v2;
                }
            }
            return arr_inputFilter1;
        }
        for(int v3 = 0; true; ++v3) {
            d0 = this.f;
            if(v3 >= arr_inputFilter.length) {
                break;
            }
            if(arr_inputFilter[v3] == d0) {
                return arr_inputFilter;
            }
        }
        InputFilter[] arr_inputFilter2 = new InputFilter[arr_inputFilter.length + 1];
        System.arraycopy(arr_inputFilter, 0, arr_inputFilter2, 0, arr_inputFilter.length);
        arr_inputFilter2[arr_inputFilter.length] = d0;
        return arr_inputFilter2;
    }
}

