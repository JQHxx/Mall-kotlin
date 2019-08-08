package com.hjq.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.hjq.kotlin.base.R
import com.hjq.kotlin.base.common.BaseApplication


/**
 * 底部导航
 */
class BottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    //购物车Tab标签
    private val mCartBadge: TextBadgeItem
    //消息Tab标签
    private val mMsgBadge: ShapeBadgeItem

    init {
        //首页
        val homeItem = BottomNavigationItem(
            R.drawable.btn_nav_home_press,
            resources.getString(R.string.nav_bar_home))
            .setInactiveIconResource(R.drawable.btn_nav_home_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //分类
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, resources.getString(R.string.nav_bar_category))
            .setInactiveIconResource(R.drawable.btn_nav_category_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //购物车
        val cartItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, resources.getString(R.string.nav_bar_cart))
            .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)
        mCartBadge = TextBadgeItem()
        cartItem.setBadgeItem(mCartBadge)

        //消息
        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, resources.getString(R.string.nav_bar_msg))
            .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)
        mMsgBadge = ShapeBadgeItem()
        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)
        msgItem.setBadgeItem(mMsgBadge)

        //我的
        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, resources.getString(R.string.nav_bar_user))
            .setInactiveIconResource(R.drawable.btn_nav_user_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //设置底部导航模式及样式
        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor((R.color.common_white))
        //添加tab
        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(cartItem)
            .addItem(msgItem)
            .addItem(userItem)
            .setFirstSelectedPosition(0)
            .initialise()

         // setIconItemMargin(this,10,5,5)
    }


    /**
     * 修改间距及图片文字大小
     *
     * @param bottomNavigationBar
     * @param space               文字与图片的间距
     * @param imgLen              单位：dp，图片大小
     * @param textSize            单位：dp，文字大小
     */
    public fun setIconItemMargin(bottomNavigationBar: BottomNavigationBar, space: Int, imgLen: Int, textSize: Int) {
        val barClass = bottomNavigationBar.javaClass
        val fields = barClass.declaredFields
        for (i in fields.indices) {
            val field = fields[i]
            field.isAccessible = true
            if (field.name == "mTabContainer") {
                try {
                    //反射得到 mTabContainer
                    val mTabContainer = field.get(bottomNavigationBar) as LinearLayout
                    for (j in 0 until mTabContainer.childCount) {
                        //获取到容器内的各个Tab
                        var view = mTabContainer.getChildAt(j)
                        //获取到Tab内的各个显示控件
                        var params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(56F))
                        val container = view.findViewById(R.id.fixed_bottom_navigation_container) as FrameLayout
                        container.layoutParams = params
                        container.setPadding(dip2px(12F), dip2px(0F), dip2px(12F), dip2px(0F))

                        //获取到Tab内的文字控件
                        val labelView = view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title) as TextView
                        //计算文字的高度DP值并设置，setTextSize为设置文字正方形的对角线长度，所以：文字高度（总内容高度减去间距和图片高度）*根号2即为对角线长度，此处用DP值，设置该值即可。
                        labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize.toFloat())
                        labelView.includeFontPadding = false
                        labelView.setPadding(0, 0, 0, dip2px((20 - textSize - space / 2).toFloat()))

                        //获取到Tab内的图像控件
                        val iconView = view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon) as ImageView
                        //设置图片参数，其中，MethodUtils.dip2px()：换算dp值
                        params = FrameLayout.LayoutParams(dip2px(imgLen.toFloat()), dip2px(imgLen.toFloat()))
                        params.setMargins(0, 0, 0, space / 2)
                        params.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                        iconView.layoutParams = params
                    }
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            }
        }
    }

    private fun dip2px(dpValue: Float): Int {
        val scale = BaseApplication.context.getResources().getDisplayMetrics().density
        return (dpValue * scale + 0.5f).toInt()
    }

    /*
        检查购物车Tab是否显示标签
     */
    fun checkCartBadge(count: Int) {
        if (count == 0) {
            mCartBadge.hide()
        } else {
            mCartBadge.show()
            mCartBadge.setText("$count")
        }
    }

    /*
        检查消息Tab是否显示标签
    */
    fun checkMsgBadge(isVisiabile: Boolean) {
        if (isVisiabile) {
            mMsgBadge.show()
        } else {
            mMsgBadge.hide()
        }
    }
}