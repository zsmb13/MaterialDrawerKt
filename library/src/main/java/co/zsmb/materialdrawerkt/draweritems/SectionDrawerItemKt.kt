@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.base.AbstractDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.SectionDrawerItem

/**
 * Adds a new SectionDrawerItem.
 *
 * See [sectionHeader] as an alternative.
 *
 * @return The created SectionDrawerItem instance
 */
public fun Builder.sectionItem(name: String = "", setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
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
public fun Builder.sectionHeader(name: String = "", setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    return sectionItem(name, setup)
}

/**
 * Adds a new SectionDrawerItem.
 *
 * See [sectionHeader] as an alternative.
 *
 * @return The created SectionDrawerItem instance
 */
public fun Builder.sectionItem(nameRes: Int, setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
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
public fun Builder.sectionHeader(nameRes: Int, setup: SectionDrawerItemKt.() -> Unit = {}): SectionDrawerItem {
    return sectionItem(nameRes, setup)
}

public class SectionDrawerItemKt : AbstractDrawerItemKt<SectionDrawerItem>(SectionDrawerItem()) {

    /**
     * Whether the section header should have a divider displayed above it.
     *
     * Wraps the [SectionDrawerItem.divider] property.
     */
    public var divider: Boolean
        get() = item.divider
        set(value) {
            item.divider = value
        }

    /**
     * The title/name of the section header.
     *
     * Non readable property. Wraps the [SectionDrawerItem.name] property.
     */
    public var name: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.name = StringHolder(value)
        }

    /**
     * The title/name of the section header, as a String resource.
     *
     * Non readable property. Wraps the [SectionDrawerItem.withName] method.
     */
    public var nameRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.name = StringHolder(value)
        }

}
