package tiny.switcher;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewSwitcher;

/**
 * Created by tiny on 17/2/19.
 */
public class TinySwitcher<T> extends ViewSwitcher {

    Render render;

    public TinySwitcher(Context context) {
        super(context);
    }

    public TinySwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setRender(Render render) {
        this.render = render;
    }

    public void setResource(T t) {
        if (this.render == null) {
            throw new IllegalArgumentException("must set render first");
        }
        View view = getNextView();
        render.render(view, t);
        showNext();
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return TinySwitcher.class.getName();
    }

    public interface Render<T> {
        void render(View view, T t);
    }
}
