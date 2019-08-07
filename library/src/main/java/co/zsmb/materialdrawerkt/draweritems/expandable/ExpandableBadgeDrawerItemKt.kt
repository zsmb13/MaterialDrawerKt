@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.BadgeableKt
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [name] and [description].
 * @return The created ExpandableBadgeDrawerItem instance
 */
public fun Builder.expandableBadgeItem(name: String = "",
                                       description: String? = null,
                                       setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    return createItem(ExpandableBadgeDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ExpandableBadgeDrawerItem instance
 */
public fun Builder.expandableBadgeItem(nameRes: Int,
                                       descriptionRes: Int? = null,
                                       setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    return createItem(ExpandableBadgeDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class ExpandableBadgeDrawerItemKt :
        BaseDescribeableDrawerItemKt<ExpandableBadgeDrawerItem>(ExpandableBadgeDrawerItem()),
        BadgeableKt {

    /**
     * The color of the expand arrow, as an argb Long.
     *
     * Non-readable property. Wraps the [ExpandableBadgeDrawerItem.arrowColor] property.
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
     * Non-readable property. Wraps the [ExpandableBadgeDrawerItem.arrowColor] property.
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
     * Non-readable property. Wraps the [ExpandableBadgeDrawerItem.arrowRotationAngleStart] and
     * [ExpandableBadgeDrawerItem.arrowRotationAngleEnd] properties.
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
     * Wraps the [ExpandableBadgeDrawerItem.arrowRotationAngleEnd] property.
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
     * Wraps the [ExpandableBadgeDrawerItem.arrowRotationAngleStart] property.
     */
    public var arrowRotationAngleStart: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = item.arrowRotationAngleStart
        set(value) {
            item.arrowRotationAngleStart = value
        }

    // Documentation inherited
    override var badgeHolder: StringHolder
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeStyle: BadgeStyle
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.withBadgeStyle(value)
        }

}
