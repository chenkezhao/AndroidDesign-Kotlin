package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.Window
import android.view.WindowManager
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.fragment.ScreenSlidePageFragment
import com.example.aaron.androiddesign_kotlin.utils.DepthPageTransformer
import kotlinx.android.synthetic.main.activity_view_pager_slides.*


class ViewPagerSlidesActivity : BaseActivity() {

    private val arrs = arrayOf(
            intArrayOf(1, 0xff31AAE7.toInt()),
            intArrayOf(2, 0xffA156CE.toInt()),
            intArrayOf(3, 0xff8FC641.toInt())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_view_pager_slides)


        vpPager.apply {
            adapter = ScreenSlidePagerAdapter(supportFragmentManager)
            //page 切换动画
//            setPageTransformer(true, ZoomOutPageTransformer())
            setPageTransformer(true, DepthPageTransformer())
        }
    }


    /**
     * A simple pager adapter that represents 5 [ScreenSlidePageFragment] objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return ScreenSlidePageFragment.newInstance(arrs[position])
        }

        override fun getCount(): Int {
            return arrs.size
        }
    }
}
