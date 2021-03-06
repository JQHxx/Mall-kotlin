package com.hjq.mall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.hjq.kotlin.base.common.AppManager
import com.hjq.kotlin.base.ui.activity.BaseActivity
import com.hjq.mall.R
import com.hjq.mall.ui.fragment.HomeFragment
import com.hjq.mall.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*


/**
 * 通过隐藏fragment的方式，达到切换的效果
 */
class MainActivity : BaseActivity() {

    private var pressTime: Long = 0
    //Fragment栈管理
    private val mStack = Stack<Fragment>()

    //主界面Fragment
    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private val mCategoryFragment: HomeFragment by lazy { HomeFragment() }
    //购物车Fragment
    private val mCartFragment: HomeFragment by lazy { HomeFragment() }
    //消息Fragment
    private val mMsgFragment: HomeFragment by lazy { HomeFragment() }
    // 我的
    private val mMineFragment: MineFragment by lazy { MineFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        initBottomNav()
        changeFragment(0)
    }

    /*
初始化栈管理
 */
    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContainer, mHomeFragment)
        manager.add(R.id.mContainer, mCategoryFragment)
        manager.add(R.id.mContainer, mCartFragment)
        manager.add(R.id.mContainer, mMsgFragment)
        manager.add(R.id.mContainer, mMineFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMineFragment)
    }


    /*
     * 初始化底部导航切换事件
     */
    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
        mBottomNavBar.checkMsgBadge(false)
        mBottomNavBar.checkCartBadge(0)
    }

    /*
    切换Tab，切换对应的Fragment
    */
    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }

    /*
     * 重写back事件，双击退出
     */
    override fun onBackPressed() {
        super.onBackPressed()

        if (System.currentTimeMillis() - pressTime > 2000) {
            pressTime = System.currentTimeMillis()
            toast("再按一次退出程序")
        } else {
            AppManager.instance.exitApp(this)
        }

    }
}
