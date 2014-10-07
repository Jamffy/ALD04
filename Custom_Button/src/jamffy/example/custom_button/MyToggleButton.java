package jamffy.example.custom_button;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

/*
 * view 对象显示的屏幕上，有几个重要步骤：
 * 1、构造方法 创建 对象。
 * 2、测量view的大小。     onMeasure(int,int);
 * 3、确定view的位置 ，view自身有一些建议权，决定权在 父view手中。  onLayout();
 * 4、绘制 view 的内容 。 onDraw(Canvas)
 */

public class MyToggleButton extends View implements OnClickListener {

	private Bitmap bgBitmap;
	private Bitmap slideBtn;
	private Paint paint;

	/**
	 * 在代码里面创建对象的时候，使用此构造方法
	 */
	public MyToggleButton(Context context) {
		super(context);
	}

	/**
	 * 在布局文件中声名的view，创建时由系统自动调用。
	 * 
	 * @param context
	 *            上下文对象
	 * @param attrs
	 *            属性集
	 */
	public MyToggleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	private void initView() {
		/*
		 * 需要一个写着开关字样的背景、一个按钮图片
		 */
		bgBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.switch_background);

		slideBtn = BitmapFactory.decodeResource(getResources(),
				R.drawable.slide_button);

		// 初始化画笔
		paint = new Paint();
		paint.setAntiAlias(true); // 打开抗锯齿

		// 设置当前view的点击事件
		setOnClickListener(this);

	}

	@Override
	/*
	 * 测量view的大小
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 看到父类用的就是下面的方法。直接给此方法传值，不再调用父类。
		setMeasuredDimension(bgBitmap.getWidth(), bgBitmap.getWidth());

		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	/*
	 * 绘制当前view的内容,只有调用了这个方法，view才会被画到屏幕上
	 */
	protected void onDraw(Canvas canvas) {
		// 绘制背景

		canvas.drawBitmap(bgBitmap, 0, 0, paint);

		// 绘制按钮
		canvas.drawBitmap(slideBtn, 0, 0, paint);
		super.onDraw(canvas);
	}

	@Override
	/*
	 * 确定view的位置 自定义view的时候作用不大
	 */
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
