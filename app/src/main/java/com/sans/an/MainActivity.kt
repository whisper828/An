package com.sans.an

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mooc.libcommon.utils.StatusBar
import com.sans.an.model.Destination
import com.sans.an.utils.AppConfig
import com.sans.an.utils.NavGraphBuilder
import com.sans.an.view.AppBottomBar
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private var navController: NavController? = null
    private var navView: AppBottomBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //启用沉浸式布局，白底黑字
        StatusBar.fitSystemBar(this)

        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)

        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = NavHostFragment.findNavController(fragment!!)
        NavGraphBuilder.build(this, fragment.childFragmentManager, navController, fragment.id)

        navView?.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val destConfig: HashMap<String, Destination> = AppConfig.getDestConfig()
        val iterator: Iterator<Map.Entry<String, Destination>> = destConfig.entries.iterator()
        //遍历 target destination 是否需要登录拦截
//        while (iterator.hasNext()) {
//            val entry = iterator.next()
//            val value = entry.value
//        }
        navController?.navigate(item.itemId)
        return !TextUtils.isEmpty(item.title)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onBackPressed() {

        //当前正在显示的页面destinationId
        val currentPageId = navController?.currentDestination?.id

        //APP页面路导航结构图  首页的destinationId
        val homeDestId = navController?.graph?.startDestination

        //如果当前正在显示的页面不是首页，而我们点击了返回键，则拦截。
        if (currentPageId != homeDestId) {
            navView?.selectedItemId = homeDestId!!
            return
        }

        //否则 finish，此处不宜调用onBackPressed。因为navigation会操作回退栈,切换到之前显示的页面。
        finish()
    }

    /**
     * bugfix:
     * 当MainActivity因为内存不足或系统原因 被回收时 会执行该方法。
     *
     *
     * 此时会触发 FragmentManangerImpl#saveAllState的方法把所有已添加的fragment基本信息给存储起来(view没有存储)，以便于在恢复重建时能够自动创建fragment
     *
     *
     * 但是在fragment嵌套fragment的情况下，被内嵌的fragment在被恢复时，生命周期被重新调度，出现了错误。没有重新走onCreateView 方法
     * 从而会触发throw new IllegalStateException("Fragment " + fname did not create a view.");的异常
     *
     *
     * 但是在没有内嵌fragment的情况，没有问题、
     *
     *
     *
     *
     * 那我们为了解决这个问题，网络上也有许多方案，但都不尽善尽美。
     *
     *
     * 此时我们复写onSaveInstanceState，不让 FragmentManangerImpl 保存fragment的基本数据，恢复重建时，再重新创建即可
     *
     * @param outState
     */
    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        //super.onSaveInstanceState(outState);
    }
}