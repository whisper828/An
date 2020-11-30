package com.sans.an.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mooc.libnavannotation.FragmentDestination
import com.sans.an.databinding.FragmentMessageBinding

/*
 * @author YeYun Chen
 * @date 2020/10/22  11:44 
 * @E-mail : 617485685@qq.com
*/
@FragmentDestination(pageUrl = "main/tabs/message", asStarter = true, needLogin = false)
class MessageFragment : Fragment() {

    private lateinit var mBinding : FragmentMessageBinding

    fun newInstance(feedType: String): MessageFragment {
        val args = Bundle()
        args.putString("feedType", feedType)
        val fragment: MessageFragment = MessageFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMessageBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvName.text = "消息"
    }

}