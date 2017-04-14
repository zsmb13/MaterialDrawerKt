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

    private val item = ExpandableDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

    /**
     * The color of the expand arrow given as an Int in argb format.
     *
     * Wraps the withArrowColor function. Non readable property.
     */
    var arrowColor: Int
        get() = nonReadable()
        set(value) {
            item.withArrowColor(value)
        }

    /**
     * The color of the expand arrow, given with a color resource.
     *
     * Wraps the withArrowColorRes function. Non readable property.
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
     * Wraps the withArrowRotationAngleStart function. Non readable property.
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
     * Wraps the withArrowRotationAngleEnd function. Non readable property.
     */
    var arrowRotationAngleEnd: Int
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleEnd(value)
        }

    /**
     * Convenience for setting both arrowRotationAngleStart and arrowRotationAngleEnd at the same time. See those
     * properties for details.
     *
     * Non readable property.
     */
    var arrowRotationAngle: Pair<Int, Int>
        get() = nonReadable()
        set(value) {
            item.withArrowRotationAngleStart(value.first)
                    .withArrowRotationAngleEnd(value.second)
        }

}
