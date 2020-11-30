package com.sans.an.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mooc.libnavannotation.FragmentDestination
import com.sans.an.databinding.FragmentDiscoverBinding
import com.sans.an.databinding.FragmentMessageBinding
import com.sans.an.ui.message.MessageFragment

/*
 * @author YeYun Chen
 * @date 2020/10/22  14:39 
 * @E-mail : 617485685@qq.com
*/
@FragmentDestination(pageUrl = "main/tabs/discover")
class DiscoverFragment : Fragment() {

    private lateinit var mBinding : FragmentDiscoverBinding

    fun newInstance(feedType: String): DiscoverFragment {
        val args = Bundle()
        args.putString("feedType", feedType)
        val fragment: DiscoverFragment = DiscoverFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDiscoverBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvName.text = "发现"
    }
}