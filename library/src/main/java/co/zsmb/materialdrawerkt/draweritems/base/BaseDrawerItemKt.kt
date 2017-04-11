package co.zsmb.materialdrawerkt.draweritems.base

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.holder.ImageHolder
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.BaseDrawerItem

abstract class BaseDrawerItemKt : AbstractDrawerItemKt() {

    private lateinit var item: BaseDrawerItem<*, *>

    protected fun setItem(item: BaseDrawerItem<*, *>) {
        super.setItem(item)
        this.item = item
    }

    var disabledIconColor: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColor(value)
        }

    var disabledIconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColorRes(value)
        }

    var disabledTextColor: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColor(value)
        }

    var disabledTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColorRes(value)
        }

    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    var iconRes: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    var iconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    var iicon: IIcon
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    var iconImage: ImageHolder
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    var iconColor: Int
        get() = nonReadable()
        set(value) {
            item.withIconColor(value)
        }

    var iconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withIconColorRes(value)
        }

    var iconTintingEnabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withIconTintingEnabled(value)
        }

    var level: Int
        get() = nonReadable()
        set(value) {
            item.withLevel(value)
        }

    var name: String
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    var nameRes: Int
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    var nameString: StringHolder
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    var selectedColor: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value)
        }

    var selectedColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    var selectedIcon: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    var selectedIconRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    var selectedIconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    var selectedIconColor: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColor(value)
        }

    var selectedIconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColorRes(value)
        }

    var selectedTextColor: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColor(value)
        }

    var selectedTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColorRes(value)
        }

    var textColor: Int
        get() = nonReadable()
        set(value) {
            item.withTextColor(value)
        }

    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    var typeface: Typeface
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
