@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem

/**
 * Adds a new ExpandableDrawerItem with the given [name] and [description].
 * @return The created ExpandableDrawerItem instance
 */
public fun Builder.expandableItem(name: String = "",
                                  description: String? = null,
                                  setup: ExpandableDrawerItemKt.() -> Unit = {}): ExpandableDrawerItem {
    return createItem(ExpandableDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new ExpandableDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ExpandableDrawerItem instance
 */
public fun Builder.expandableItem(nameRes: Int,
                                  descriptionRes: Int? = null,
                                  setup: ExpandableDrawerItemKt.() -> Unit = {}): ExpandableDrawerItem {
    return createItem(ExpandableDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class ExpandableDrawerItemKt :
        BaseDescribeableDrawerItemKt<ExpandableDrawerItem>(ExpandableDrawerItem()) {

    /**
     * The color of the expand arrow, as an argb Long.
     *
     * Non-readable property. Wraps the [ExpandableDrawerItem.arrowColor] property.
     */
    public var arrowColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.arrowColor = ColorHolder.fromColor(value.toInt())
        }

    /**
     * The color of the expand arrow, as a color resource.
     *
     * Non-readable property. Wraps the [ExpandableDrawerItem.arrowColor] property.
     */
    public var arrowColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.arrowColor = ColorHolder.fromColorRes(value)
        }

    /**
     * Convenience for setting both [arrowRotationAngleStart] and [arrowRotationAngleEnd] at the same time. See those
     * properties for details.
     *
     * Default values are 0 and 180.
     *
     * Non-readable property. Wraps the [ExpandableDrawerItem.arrowRotationAngleStart] and
     * [ExpandableDrawerItem.arrowRotationAngleEnd] properties.
     */
    public var arrowRotationAngle: Pair<Int, Int>
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.apply {
                arrowRotationAngleStart = value.first
                arrowRotationAngleEnd = value.second
            }
        }

    /**
     * The rotation of the expand arrow when the item is open, in degrees.
     * Default value is 180, which corresponds to an upward pointing arrow.
     *
     * See [arrowRotationAngle] as an alternative.
     *
     * Default value is 180.
     *
     * Wraps the [ExpandableDrawerItem.arrowRotationAngleEnd] property.
     */
    public var arrowRotationAngleEnd: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = item.arrowRotationAngleEnd
        set(value) {
            item.arrowRotationAngleEnd = value
        }

    /**
     * The rotation of the expand arrow when the item is closed, in degrees.
     * Default value is 0, which corresponds to a downward pointing arrow.
     *
     * See [arrowRotationAngle] as an alternative.
     *
     * Default value is 0.
     *
     * Wraps the [ExpandableDrawerItem.arrowRotationAngleStart] property.
     */
    public var arrowRotationAngleStart: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = item.arrowRotationAngleStart
        set(value) {
            item.arrowRotationAngleStart = value
        }

}
