package co.zsmb.materialdrawerkt.draweritems

import android.graphics.Typeface
import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.base.AbstractDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.SectionDrawerItem

/**
 * Adds a new SectionDrawerItem.
 *
 * See [sectionHeader] as an alternative.
 *
 * @return The created SectionDrawerItem instance
 */
fun BuilderBase.sectionItem(name: String = "", setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    val item = SectionDrawerItemKt(name)
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new SectionDrawerItem.
 *
 * Convenience for [sectionItem].
 *
 * @return The created SectionDrawerItem instance
 */
fun BuilderBase.sectionHeader(name: String = "", setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    val item = SectionDrawerItemKt(name)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SectionDrawerItemKt(name: String) : AbstractDrawerItemKt() {

    /* Builder basics */

    private val item = SectionDrawerItem().withName(name)

    init {
        super.setItem(item)
    }

    internal fun build() = item

    /* SectionDrawerItem methods */

    /**
     * Whether the section header should have a divider displayed above it.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withDivider] function.
     */
    var divider: Boolean
        get() = nonReadable()
        set(value) {
            item.withDivider(value)
        }

    /**
     * The title/name of the section header.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withName] function.
     */
    var name: String
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The title/name of the section header, as a String resource.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withName] function.
     */
    var nameRes: Int
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The color of the section header's text, as an argb Long.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withTextColor] function.
     */
    var textColor: Long
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the section header's text, as a color resource.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withTextColorRes] function.
     */
    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the section header's text.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withTypeface] function.
     */
    var typeface: Typeface
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
