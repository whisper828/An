package com.sans.an.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mooc.libnavannotation.FragmentDestination
import com.sans.an.databinding.FragmentContactBinding
import com.sans.an.databinding.FragmentMessageBinding
import com.sans.an.ui.message.MessageFragment

/*
 * @author YeYun Chen
 * @date 2020/10/22  14:38 
 * @E-mail : 617485685@qq.com
*/
@FragmentDestination(pageUrl = "main/tabs/contact")
class ContactFragment : Fragment() {

    private lateinit var mBinding : FragmentContactBinding

    fun newInstance(feedType: String): ContactFragment {
        val args = Bundle()
        args.putString("feedType", feedType)
        val fragment: ContactFragment = ContactFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentContactBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvName.text = "联系人"
    }
}