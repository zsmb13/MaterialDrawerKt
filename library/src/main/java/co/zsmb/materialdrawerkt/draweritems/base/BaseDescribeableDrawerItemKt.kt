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
     * Wraps the [BaseDescribeableDrawerItem.withDescription] function. Non readable property.
     */
    var description: String
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The description of the drawer item, as a String resource.
     *
     * Wraps the [BaseDescribeableDrawerItem.withDescription] function. Non readable property.
     */
    var descriptionRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The color of the description text, given as an argb Long.
     *
     * Wraps the [BaseDescribeableDrawerItem.withDescriptionTextColor] function. Non readable property.
     */
    var descriptionTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColor(value.toInt())
        }

    /**
     * The color of the description text, given as a color resource.
     *
     * Wraps the [BaseDescribeableDrawerItem.withDescriptionTextColorRes] function. Non readable property.
     */
    var descriptionTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColorRes(value)
        }

}
