package com.example.aaron.androiddesign_kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.aaron.androiddesign_kotlin.R

/**
 * A simple [Fragment] subclass.
 * Use the [ScreenSlidePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScreenSlidePageFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private lateinit var mArrs: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mArrs = arguments.getIntArray(ARG_PAGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_screen_slide_page, container, false)
        view.apply {
            findViewById<TextView>(R.id.tvPageNumber).apply { text = mArrs[0].toString() }
            findViewById<FrameLayout>(R.id.flBg).apply {
                setBackgroundColor(mArrs[1])
            }
        }
        return view
    }


    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PAGE = "page"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @param array Parameter 1.
         * *
         * *
         * @return A new instance of fragment ScreenSlidePageFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(array: IntArray): ScreenSlidePageFragment {
            val fragment = ScreenSlidePageFragment()
            val args = Bundle()
            args.putIntArray(ARG_PAGE, array)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
