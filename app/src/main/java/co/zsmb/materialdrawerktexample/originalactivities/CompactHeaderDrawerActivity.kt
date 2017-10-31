package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.profile.profileSetting
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.Nameable
import kotlinx.android.synthetic.main.activity_sample.*

class CompactHeaderDrawerActivity : AppCompatActivity() {

    private lateinit var result: Drawer
    private lateinit var headerResult: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        result = drawer {
            savedInstance = savedInstanceState

            headerResult = accountHeader {
                background = R.drawable.header
                compactStyle = true
                savedInstance = savedInstanceState

                profile("Mike Penz", "mikepenz@gmail.com") {
                    icon = R.drawable.profile
                }
                profile("Max Muster", "max.mustermann@gmail.com") {
                    icon = R.drawable.profile2
                }
                profile("Felix House", "felix.house@gmail.com") {
                    icon = R.drawable.profile3
                }
                profile("Mr. X", "mister.x.super@gmail.com") {
                    icon = R.drawable.profile4
                }
                profile("Batman", "batman@gmail.com") {
                    icon = R.drawable.profile5
                }

                profileSetting("Add account", "Add new GitHub Account") {
                    iicon = GoogleMaterial.Icon.gmd_add
                    identifier = 100_000
                }
                profileSetting("Manage Account") {
                    iicon = GoogleMaterial.Icon.gmd_settings
                    identifier = 100_001
                }
            }

            primaryItem(R.string.drawer_item_home) {
                iicon = FontAwesome.Icon.faw_home
                identifier = 1
            }
            primaryItem(R.string.drawer_item_free_play) {
                iicon = FontAwesome.Icon.faw_gamepad
            }
            primaryItem(R.string.drawer_item_custom) {
                iicon = FontAwesome.Icon.faw_eye
                identifier = 5
            }
            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_settings) {
                iicon = FontAwesome.Icon.faw_cog
            }
            secondaryItem(R.string.drawer_item_help) {
                iicon = FontAwesome.Icon.faw_question; enabled = false
            }
            secondaryItem(R.string.drawer_item_open_source) {
                iicon = FontAwesome.Icon.faw_github
            }
            secondaryItem(R.string.drawer_item_contact) {
                iicon = FontAwesome.Icon.faw_bullhorn
            }

            /* Alternative formatting for the previous section */
            /*
            primaryItem(R.string.drawer_item_home) { iicon = FontAwesome.Icon.faw_home; identifier = 1 }
            primaryItem(R.string.drawer_item_free_play) { iicon = FontAwesome.Icon.faw_gamepad }
            primaryItem(R.string.drawer_item_custom) { iicon = FontAwesome.Icon.faw_eye; identifier = 5 }
            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_settings) { iicon = FontAwesome.Icon.faw_cog }
            secondaryItem(R.string.drawer_item_help) { iicon = FontAwesome.Icon.faw_question; enabled = false }
            secondaryItem(R.string.drawer_item_open_source) { iicon = FontAwesome.Icon.faw_github }
            secondaryItem(R.string.drawer_item_contact) { iicon = FontAwesome.Icon.faw_bullhorn }
            */

            onItemClick { _, _, drawerItem ->
                if (drawerItem is Nameable<*>) {
                    supportActionBar?.title = drawerItem.name.getText(this@CompactHeaderDrawerActivity)
                }
                false
            }

            if (savedInstanceState == null) {
                selectedItem = 5
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        result.saveInstanceState(outState)
        headerResult.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

}
