package com.example.aaron.androiddesign_kotlin.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridLayout;
import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.utils.AutoLayoutHelper;

/**
 * 
 * Created by Administrator on 2017/4/12.
 */

public class AutoGridLayout extends GridLayout {
	private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);

	public AutoGridLayout(Context context){
		super(context);
	}

	public AutoGridLayout(Context context, AttributeSet attrs){
		super(context, attrs);
	}

	public AutoGridLayout(Context context, AttributeSet attrs, int defStyleAttr){
		super(context, attrs, defStyleAttr);
	}

	@TargetApi(21)
	public AutoGridLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new LayoutParams(getContext(), attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (!isInEditMode()) {
			mHelper.adjustChildren();
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	public static class LayoutParams extends GridLayout.LayoutParams implements AutoLayoutHelper.AutoLayoutParams {
		private AutoLayoutInfo mAutoLayoutInfo;

		// AttributeSet constructors

		public LayoutParams(Context context, AttributeSet attrs){
			super(context, attrs);
			mAutoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(context, attrs);
		}

		public LayoutParams(Spec rowSpec, Spec columnSpec){
			super(rowSpec, columnSpec);
		}

		public LayoutParams(){
			super();
		}

		// Copying constructors

		public LayoutParams(ViewGroup.LayoutParams params){
			super(params);
		}

		public LayoutParams(MarginLayoutParams params){
			super(params);
		}

		public LayoutParams(GridLayout.LayoutParams source){
			super(source);
			this.rowSpec = source.rowSpec;
			this.columnSpec = source.columnSpec;
		}

		@Override
		public AutoLayoutInfo getAutoLayoutInfo() {
			return mAutoLayoutInfo;
		}
	}
}
