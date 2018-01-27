@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
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
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowColor] method.
     */
    public var arrowColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withArrowColor(value.toInt())
        }

    /**
     * The color of the expand arrow, as a color resource.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowColorRes] method.
     */
    public var arrowColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withArrowColorRes(value)
        }

    /**
     * Convenience for setting both [arrowRotationAngleStart] and [arrowRotationAngleEnd] at the same time. See those
     * properties for details.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowRotationAngleStart] and
     * [ExpandableDrawerItem.withArrowRotationAngleEnd] methods.
     */
    public var arrowRotationAngle: Pair<Int, Int>
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleStart(value.first)
                    .withArrowRotationAngleEnd(value.second)
        }

    /**
     * The rotation of the expand arrow when the item is open, in degrees.
     * Default value is 180, which corresponds to an upward pointing arrow.
     *
     * See [arrowRotationAngle] as an alternative.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowRotationAngleEnd] method.
     */
    public var arrowRotationAngleEnd: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleEnd(value)
        }

    /**
     * The rotation of the expand arrow when the item is closed, in degrees.
     * Default value is 0, which corresponds to a downward pointing arrow.
     *
     * See [arrowRotationAngle] as an alternative.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowRotationAngleStart] method.
     */
    public var arrowRotationAngleStart: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleStart(value)
        }

}
