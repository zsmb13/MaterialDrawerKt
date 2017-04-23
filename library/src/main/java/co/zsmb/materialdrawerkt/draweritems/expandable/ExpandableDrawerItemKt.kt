package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem

/**
 * Adds a new ExpandableDrawerItem with the given [name] and [description].
 * @return The created ExpandableDrawerItem instance
 */
fun BuilderBase.expandableItem(name: String = "",
                               description: String = "",
                               setup: ExpandableDrawerItemKt.() -> Unit = {}): ExpandableDrawerItem {
    val item = ExpandableDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class ExpandableDrawerItemKt(name: String, description: String) : BaseDescribeableDrawerItemKt() {

    /* Builder basics */

    private val item = ExpandableDrawerItem()
            .withName(name)
            .withDescription(description)

    init {
        super.setItem(item)
    }

    internal fun build() = item

    /* ExpandableDrawerItem methods */

    /**
     * The color of the expand arrow given as an argb Long.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowColor] method.
     */
    var arrowColor: Long
        get() = nonReadable()
        set(value) {
            item.withArrowColor(value.toInt())
        }

    /**
     * The color of the expand arrow, given as a color resource.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowColorRes] method.
     */
    var arrowColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withArrowColorRes(value)
        }

    /**
     * The rotation of the expand arrow when the item is closed, in degrees. The default value is 0, which corresponds
     * to a downward pointing arrow.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowRotationAngleStart] method.
     */
    var arrowRotationAngleStart: Int
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleStart(value)
        }

    /**
     * The rotation of the expand arrow when the item is open, in degrees. The default value is 180, which corresponds
     * to an upward pointing arrow.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowRotationAngleEnd] method.
     */
    var arrowRotationAngleEnd: Int
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleEnd(value)
        }

    /**
     * Convenience for setting both `arrowRotationAngleStart` and `arrowRotationAngleEnd` at the same time. See those
     * properties for details.
     *
     * Non readable property. Wraps the [ExpandableDrawerItem.withArrowRotationAngleStart] and
     * [ExpandableDrawerItem.withArrowRotationAngleEnd] methods.
     */
    var arrowRotationAngle: Pair<Int, Int>
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleStart(value.first)
                    .withArrowRotationAngleEnd(value.second)
        }

}
