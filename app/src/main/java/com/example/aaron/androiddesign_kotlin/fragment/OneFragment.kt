package com.example.aaron.androiddesign_kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.fragment_one.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OneFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OneFragment : BaseFragment() {

    //定义接收参数变量
    private var mParam1: String? = null
    private var mParam2: String? = null

    //fragment数据交互监听接口
    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_one, container, false)
    }

    override fun onStart() {
        super.onStart()
        tvParam1.text = mParam1
        tvParam2.text = mParam2
        btnChange.setOnClickListener { onButtonPressed("go go ...") }
    }

    // TODO: Rename method, update argument and hook method into UI event
    /**
     * 改变activity的UI
     */
    fun onButtonPressed(temp: String) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(temp)
        }
    }

    //当Fragment与Activity发生关联时调用
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    //与onAttach相对应，当Fragment与Activity关联被取消时调用
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(temp: String)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @param param1 Parameter 1.
         * *
         * @param param2 Parameter 2.
         * *
         * @return A new instance of fragment OneFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): OneFragment {
            val fragment = OneFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
