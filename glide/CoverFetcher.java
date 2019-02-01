import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sin on 2018/8/24.
 */

public class CoverFetcher implements DataFetcher<InputStream>{

    private final static String TAG = CoverFetcher.class.getSimpleName();
    private boolean isCancel = false;
    private Object object ;
    private InputStream in;

    public CoverFetcher(Object object) {
        this.object = object;
    }

    @Override
    public InputStream loadData(Priority priority) throws Exception {
        if (isCancel || object == null){
            return null;
        }
        //从ObjectCoverUtil中处理获取图片的方法
        String url = ObjectCoverUtil.get(object);
        if (url != null) {
            Log.i(TAG, "loadData: success : " + url);
            in = new FileInputStream(new File(url));
        }else{
            return null;
        }
        if (isCancel){
            Log.i(TAG, "loadData: return null");
            return  null;
        }else {
            Log.i(TAG, "loadData: return in>>");
            return in;
        }
    }

    @Override
    public void cleanup() {
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                in = null;
            }
        }
    }

    @Override
    public String getId() {
        if(this.object != null){
            return 0;//看Object对象是否持有响应ID或者HASH 
        }
        return null;
    }

    @Override
    public void cancel() {
        this.isCancel = true;
    }
}
