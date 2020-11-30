package com.sans.an.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mooc.libnavannotation.FragmentDestination
import com.sans.an.databinding.FragmentAuthBinding
import com.sans.an.databinding.FragmentMessageBinding
import com.sans.an.ui.message.MessageFragment

/*
 * @author YeYun Chen
 * @date 2020/10/22  14:35 
 * @E-mail : 617485685@qq.com
*/
@FragmentDestination(pageUrl = "main/tabs/auth", needLogin = false)
class AuthFragment : Fragment() {

    private lateinit var mBinding : FragmentAuthBinding

    fun newInstance(feedType: String): AuthFragment {
        val args = Bundle()
        args.putString("feedType", feedType)
        val fragment: AuthFragment = AuthFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAuthBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvName.text = "组织"
    }
}