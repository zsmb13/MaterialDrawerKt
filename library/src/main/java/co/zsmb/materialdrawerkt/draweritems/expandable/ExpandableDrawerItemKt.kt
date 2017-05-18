package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem

/**
 * Adds a new ExpandableDrawerItem with the given [name] and [description].
 * @return The created ExpandableDrawerItem instance
 */
fun Builder.expandableItem(name: String = "",
                           description: String? = null,
                           setup: ExpandableDrawerItemKt.() -> Unit = {}): ExpandableDrawerItem {
    val item = ExpandableDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new ExpandableDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ExpandableDrawerItem instance
 */
fun Builder.expandableItem(nameRes: Int,
                           descriptionRes: Int? = null,
                           setup: ExpandableDrawerItemKt.() -> Unit = {}): ExpandableDrawerItem {
    val item = ExpandableDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class ExpandableDrawerItemKt : BaseDescribeableDrawerItemKt() {

    /* Builder basics */

    private val item = ExpandableDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

    /* ExpandableDrawerItem methods */

    /**
     * The color of the expand arrow, as an argb Long.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowColor] method.
     */
    var arrowColor: Long
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
    var arrowColorRes: Int
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
    var arrowRotationAngle: Pair<Int, Int>
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
    var arrowRotationAngleEnd: Int
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
    var arrowRotationAngleStart: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleStart(value)
        }

}
