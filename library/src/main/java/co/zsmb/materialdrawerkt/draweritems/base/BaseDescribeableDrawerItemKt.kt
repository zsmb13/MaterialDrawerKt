package co.zsmb.materialdrawerkt.draweritems.base

import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.BaseDescribeableDrawerItem

abstract class BaseDescribeableDrawerItemKt : BaseDrawerItemKt() {

    /* Builder basics */

    private lateinit var item: BaseDescribeableDrawerItem<*, *>

    protected fun setItem(item: BaseDescribeableDrawerItem<*, *>) {
        super.setItem(item)
        this.item = item
    }

    /* BaseDescribeableDrawerItem methods */

    /**
     * The description of the drawer item.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescription] method.
     */
    var description: String
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The description of the drawer item, as a String resource.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescription] method.
     */
    var descriptionRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The color of the description text, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescriptionTextColor] method.
     */
    var descriptionTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColor(value.toInt())
        }

    /**
     * The color of the description text, as a color resource.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescriptionTextColorRes] method.
     */
    var descriptionTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColorRes(value)
        }

}
