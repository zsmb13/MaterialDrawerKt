package co.zsmb.materialdrawerkt.draweritems

import android.graphics.Typeface
import co.zsmb.materialdrawerkt.builders.Builder
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
fun Builder.sectionItem(name: String = "", setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    val item = SectionDrawerItemKt()
    item.name = name
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
fun Builder.sectionHeader(name: String = "", setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    val item = SectionDrawerItemKt()
    item.name = name
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new SectionDrawerItem.
 *
 * See [sectionHeader] as an alternative.
 *
 * @return The created SectionDrawerItem instance
 */
fun Builder.sectionItem(nameRes: Int, setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    val item = SectionDrawerItemKt()
    item.nameRes = nameRes
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
fun Builder.sectionHeader(nameRes: Int, setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    val item = SectionDrawerItemKt()
    item.nameRes = nameRes
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SectionDrawerItemKt : AbstractDrawerItemKt() {

    /* Builder basics */

    private val item = SectionDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

    /* SectionDrawerItem methods */

    /**
     * Whether the section header should have a divider displayed above it.
     *
     * Wraps the [SectionDrawerItem.withDivider] and [SectionDrawerItem.hasDivider] methods.
     */
    var divider: Boolean
        get() = item.hasDivider()
        set(value) {
            item.withDivider(value)
        }

    /**
     * The title/name of the section header.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withName] method.
     */
    var name: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The title/name of the section header, as a String resource.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withName] method.
     */
    var nameRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The color of the section header's text, as an argb Long.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withTextColor] method.
     */
    var textColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the section header's text, as a color resource.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withTextColorRes] method.
     */
    var textColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the section header's text.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withTypeface] method.
     */
    var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
