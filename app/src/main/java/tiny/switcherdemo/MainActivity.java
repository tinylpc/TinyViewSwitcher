package tiny.switcherdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.nostra13.universalimageloader.core.ImageLoader;

import tiny.switcher.TinySwitcher;

public class MainActivity extends AppCompatActivity {

    TinySwitcher<Scenery> ts;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            Scenery scenery = new Scenery();
            scenery.setUrl("http://uploads.cnfla.com/allimg/151013/7-15101316043AL.jpg");
            scenery.setContent("哈哈哈啊哈啊");
            ts.setResource(scenery);
            mHandler.sendEmptyMessageDelayed(0, 2000);
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ts = (TinySwitcher<Scenery>) findViewById(R.id.ts);

        //设置视图样式
        ts.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item, null);
                ViewHolder holder = new ViewHolder(view);
                view.setTag(holder);
                return view;
            }
        });

        //设置具体数据渲染
        ts.setRender(new TinySwitcher.Render<Scenery>() {
            @Override
            public void render(View view, Scenery scenery) {
                ImageView iv;
                TextView tv;
                if (view.getTag() != null) {
                    ViewHolder holder = (ViewHolder) view.getTag();
                    iv = holder.iv;
                    tv = holder.tv;
                } else {
                    iv = (ImageView) view.findViewById(R.id.iv);
                    tv = (TextView) view.findViewById(R.id.tv);
                }

                ImageLoader.getInstance().displayImage(scenery.getUrl(), iv);
                tv.setText(scenery.getContent());
            }
        });

        //设置进入进出动画
        ts.setInAnimation(this, R.anim.slide_in_down);
        ts.setOutAnimation(this, R.anim.slide_out_down);

        Scenery scenery = new Scenery();
        scenery.setUrl("http://www.58game.com/resource/uploads/remoteImg/20150315/156341426383395.png");
        scenery.setContent("测试测试测试");
        //开始展示数据
        ts.setResource(scenery);

        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    public static class ViewHolder {
        private ImageView iv;
        private TextView tv;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.iv);
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }
}
