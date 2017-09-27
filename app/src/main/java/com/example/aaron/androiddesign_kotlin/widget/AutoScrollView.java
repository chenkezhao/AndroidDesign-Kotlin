package com.example.aaron.androiddesign_kotlin.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.utils.AutoLayoutHelper;

/**
 * 
 * Created by Administrator on 2017/4/12.
 */

public class AutoScrollView extends ScrollView {
	private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);

	public AutoScrollView(Context context){
		super(context);
	}

	public AutoScrollView(Context context, AttributeSet attrs){
		super(context, attrs);
	}

	public AutoScrollView(Context context, AttributeSet attrs, int defStyleAttr){
		super(context, attrs, defStyleAttr);
	}

	@TargetApi(21)
	public AutoScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
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

	public static class LayoutParams extends ScrollView.LayoutParams implements AutoLayoutHelper.AutoLayoutParams {
		private AutoLayoutInfo mAutoLayoutInfo;

		public LayoutParams(Context c, AttributeSet attrs){
			super(c, attrs);

			mAutoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(c, attrs);
		}

		public LayoutParams(int width, int height){
			super(width, height);
		}

		public LayoutParams(int width, int height, int gravity){
			super(width, height, gravity);
		}

		public LayoutParams(ViewGroup.LayoutParams source){
			super(source);
		}

		public LayoutParams(MarginLayoutParams source){
			super(source);
		}

		public LayoutParams(ScrollView.LayoutParams source){
			super((MarginLayoutParams) source);
			gravity = source.gravity;
		}

		public LayoutParams(LayoutParams source){
			this((ScrollView.LayoutParams) source);
			mAutoLayoutInfo = source.mAutoLayoutInfo;
		}

		@Override
		public AutoLayoutInfo getAutoLayoutInfo() {
			return mAutoLayoutInfo;
		}

	}
}
