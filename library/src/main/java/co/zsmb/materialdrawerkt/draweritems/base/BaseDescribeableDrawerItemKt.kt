@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.base

import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.BaseDescribeableDrawerItem

public abstract class BaseDescribeableDrawerItemKt<out T : BaseDescribeableDrawerItem<*, *>>(item: T) :
        BaseDrawerItemKt<T>(item) {

    /**
     * The description of the drawer item.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescription] method.
     */
    public var description: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The description of the drawer item, as a String resource.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescription] method.
     */
    public var descriptionRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The color of the description text, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescriptionTextColor] method.
     */
    public var descriptionTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColor(value.toInt())
        }

    /**
     * The color of the description text, as a color resource.
     *
     * Non readable property. Wraps the [BaseDescribeableDrawerItem.withDescriptionTextColorRes] method.
     */
    public var descriptionTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColorRes(value)
        }

}
