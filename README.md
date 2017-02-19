# TinyViewSwitcher
自定义View的内容进入进出动画

# 效果图
![](https://github.com/tinylpc/TinyViewSwitcher/blob/master/%E6%95%88%E6%9E%9C.gif)

# 引入
compile 'com.tinylpc:view-switcher:1.0.0'

# 使用
```
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
```

# Example
