package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.model.interfaces.IProfile

fun DrawerBuilderKt.accountHeader(setup: AccountHeaderBuilderKt.() -> Unit = {}): AccountHeader {
    val header = AccountHeaderBuilderKt(activity)
    header.setup()
    return header.build().apply { attachHeader(this) }
}

@DrawerMarker
class AccountHeaderBuilderKt(activity: Activity) {

    private val builder = AccountHeaderBuilder()

    init {
        builder.withActivity(activity)
    }

    var background: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackground(value)
        }

    internal fun addItem(profile: IProfile<*>) = builder.addProfiles(profile)

    internal fun build(): AccountHeader = builder.build()

}
