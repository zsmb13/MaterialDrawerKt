package co.zsmb.materialdrawerkt.draweritems.base

import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.BaseDescribeableDrawerItem

abstract class BaseDescribeableDrawerItemKt : BaseDrawerItemKt() {

    private lateinit var item: BaseDescribeableDrawerItem<*, *>

    protected fun setItem(item: BaseDescribeableDrawerItem<*, *>) {
        super.setItem(item)
        this.item = item
    }

    var description: String
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    var descriptionRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    var descriptionTextColor: Int
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColor(value)
        }

    var descriptionTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColorRes(value)
        }

}
