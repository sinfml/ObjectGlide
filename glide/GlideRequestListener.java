
import android.util.Log;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by sin on 2018/8/24.
 */

public class GlideRequestListener implements RequestListener<Object, GlideDrawable> {
    private final static String TAG = GlideRequestListener.class.getSimpleName();


    @Override
    public boolean onException(Exception e, Object model, Target<GlideDrawable> target, boolean
            isFirstResource) {
        return false;
    }

    @Override
    public boolean onResourceReady(GlideDrawable resource, Object model, Target<GlideDrawable>
            target, boolean isFromMemoryCache, boolean isFirstResource) {
        return false;
    }
}
