package com.example.aaron.androiddesign_kotlin.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.activity_zoom.*

class ZoomActivity : BaseActivity() {

    private var mCurrentAnimator: Animator? = null
    private var mShortAnimationDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom)

        thumb_button_1.setOnClickListener {
            thumb1View ->
            zoomImageFromThumb(thumb1View, R.mipmap.temp_img)
        }
        thumb_button_2.setOnClickListener {
            thumb1View ->
            zoomImageFromThumb(thumb1View, R.mipmap.temp_img)
        }
        // Retrieve and cache the system's default "short" animation time.
        mShortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
    }


    /**
     * "Zooms" in a thumbnail view by assigning the high resolution image to a hidden "zoomed-in"
     * image view and animating its bounds to fit the entire activity content area. More
     * specifically:
     *
     *
     *
     *  1. Assign the high-res image to the hidden "zoomed-in" (expanded) image view.
     *  1. Calculate the starting and ending bounds for the expanded view.
     *  1. Animate each of four positioning/sizing properties (X, Y, SCALE_X, SCALE_Y)
     * simultaneously, from the starting bounds to the ending bounds.
     *  1. Zoom back out by running the reverse animation on click.
     *

     * @param thumbView  The thumbnail view to zoom in.
     * *
     * @param imageResId The high-resolution version of the image represented by the thumbnail.
     */
    fun zoomImageFromThumb(thumbView: View, imageResId: Int) {
        // If there's an animation in progress, cancel it immediately and proceed with this one.
        if (mCurrentAnimator != null) {
            mCurrentAnimator!!.cancel()
        }

        // Load the high-resolution "zoomed-in" image.
        val expandedImageView = findViewById(R.id.expanded_image) as ImageView
        expandedImageView.setImageResource(imageResId)

        // Calculate the starting and ending bounds for the zoomed-in image. This step
        // involves lots of math. Yay, math.
        val startBounds = Rect()
        val finalBounds = Rect()
        val globalOffset = Point()

        // The start bounds are the global visible rectangle of the thumbnail, and the
        // final bounds are the global visible rectangle of the container view. Also
        // set the container view's offset as the origin for the bounds, since that's
        // the origin for the positioning animation properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds)
        findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset)
        startBounds.offset(-globalOffset.x, -globalOffset.y)
        finalBounds.offset(-globalOffset.x, -globalOffset.y)

        // Adjust the start bounds to be the same aspect ratio as the final bounds using the
        // "center crop" technique. This prevents undesirable stretching during the animation.
        // Also calculate the start scaling factor (the end scaling factor is always 1.0).
        val startScale: Float
        if (finalBounds.width().toFloat() / finalBounds.height() > startBounds.width().toFloat() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = startBounds.height().toFloat() / finalBounds.height()
            val startWidth = startScale * finalBounds.width()
            val deltaWidth = (startWidth - startBounds.width()) / 2
            startBounds.left -= deltaWidth.toInt()
            startBounds.right += deltaWidth.toInt()
        } else {
            // Extend start bounds vertically
            startScale = startBounds.width().toFloat() / finalBounds.width()
            val startHeight = startScale * finalBounds.height()
            val deltaHeight = (startHeight - startBounds.height()) / 2
            startBounds.top -= deltaHeight.toInt()
            startBounds.bottom += deltaHeight.toInt()
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation begins,
        // it will position the zoomed-in view in the place of the thumbnail.
        thumbView.alpha = 0f
        expandedImageView.visibility = View.VISIBLE

        // Set the pivot point for SCALE_X and SCALE_Y transformations to the top-left corner of
        // the zoomed-in view (the default is the center of the view).
        expandedImageView.pivotX = 0f
        expandedImageView.pivotY = 0f

        // Construct and run the parallel animation of the four translation and scale properties
        // (X, Y, SCALE_X, and SCALE_Y).
        val set = AnimatorSet()
        set
                .play(ObjectAnimator.ofFloat<View>(expandedImageView, View.X, startBounds.left.toFloat(),
                        finalBounds.left.toFloat()))
                .with(ObjectAnimator.ofFloat<View>(expandedImageView, View.Y, startBounds.top.toFloat(),
                        finalBounds.top.toFloat()))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale, 1f))
                .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale, 1f))
        set.duration = mShortAnimationDuration.toLong()
        set.interpolator = DecelerateInterpolator()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                mCurrentAnimator = null
            }

            override fun onAnimationCancel(animation: Animator) {
                mCurrentAnimator = null
            }
        })
        set.start()
        mCurrentAnimator = set

        // Upon clicking the zoomed-in image, it should zoom back down to the original bounds
        // and show the thumbnail instead of the expanded image.
        val startScaleFinal = startScale
        expandedImageView.setOnClickListener {
            if (mCurrentAnimator != null) {
                mCurrentAnimator!!.cancel()
            }

            // Animate the four positioning/sizing properties in parallel, back to their
            // original values.
            val set = AnimatorSet()
            set
                    .play(ObjectAnimator.ofFloat<View>(expandedImageView, View.X, startBounds.left.toFloat()))
                    .with(ObjectAnimator.ofFloat<View>(expandedImageView, View.Y, startBounds.top.toFloat()))
                    .with(ObjectAnimator
                            .ofFloat(expandedImageView, View.SCALE_X, startScaleFinal))
                    .with(ObjectAnimator
                            .ofFloat(expandedImageView, View.SCALE_Y, startScaleFinal))
            set.duration = mShortAnimationDuration.toLong()
            set.interpolator = DecelerateInterpolator()
            set.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    thumbView.alpha = 1f
                    expandedImageView.visibility = View.GONE
                    mCurrentAnimator = null
                }

                override fun onAnimationCancel(animation: Animator) {
                    thumbView.alpha = 1f
                    expandedImageView.visibility = View.GONE
                    mCurrentAnimator = null
                }
            })
            set.start()
            mCurrentAnimator = set
        }
    }
}
