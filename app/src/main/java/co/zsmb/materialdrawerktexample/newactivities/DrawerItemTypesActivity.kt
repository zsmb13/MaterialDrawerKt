package co.zsmb.materialdrawerktexample.newactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import co.zsmb.materialdrawerkt.draweritems.expandable.expandableBadgeItem
import co.zsmb.materialdrawerkt.draweritems.expandable.expandableItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.profile.profileSetting
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerkt.draweritems.switchable.secondarySwitchItem
import co.zsmb.materialdrawerkt.draweritems.switchable.switchItem
import co.zsmb.materialdrawerkt.draweritems.toggleable.secondaryToggleItem
import co.zsmb.materialdrawerkt.draweritems.toggleable.toggleItem
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import kotlinx.android.synthetic.main.activity_sample.*

class DrawerItemTypesActivity : AppCompatActivity() {

    private lateinit var result: Drawer
    private lateinit var headerResult: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            savedInstance = savedInstanceState
            toolbar = this@DrawerItemTypesActivity.toolbar

            headerResult = accountHeader {
                savedInstance = savedInstanceState
                background = R.drawable.header

                profile("Pam", "pam@gmail.com") {
                    icon = R.drawable.profile4
                }
                profile("Samantha", "samantha@gmail.com") {
                    icon = R.drawable.profile4
                }
                profile("Laura", "laura@gmail.com") {
                    icon = R.drawable.profile4
                }
                profileSetting("Refresh", "Not a real button") {
                    iicon = GoogleMaterial.Icon.gmd_refresh
                }
            }

            sectionHeader("Simple items") { divider = false }
            primaryItem("Primary drawer item", "Primary drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
            }
            secondaryItem("Secondary drawer item", "Secondary drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
            }

            sectionHeader("Expandables") { }
            expandableItem("Expandable drawer item", "Expandable drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
                primaryItem("Expanded item 1") {
                    iicon = FontAwesome.Icon.faw_magic
                    level = 2
                }
                primaryItem("Expanded item 2") {
                    iicon = FontAwesome.Icon.faw_magic
                    level = 2
                }
            }
            expandableBadgeItem("Expandable badge drawer item", "Expandable badge drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
                primaryItem("Expanded item 1") {
                    iicon = FontAwesome.Icon.faw_magic
                    level = 2
                }
                primaryItem("Expanded item 2") {
                    iicon = FontAwesome.Icon.faw_magic
                    level = 2
                }
            }

            sectionHeader("Switches") { }
            switchItem("Switch drawer item", "Switch drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
            }
            secondarySwitchItem("Secondary switch drawer item", "Secondary switch drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
            }

            sectionHeader("Toggles header") { }
            toggleItem("Toggle drawer item", "Toggle drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
            }
            secondaryToggleItem("Secondary toggle drawer item", "Secondary toggle drawer item description") {
                iicon = FontAwesome.Icon.faw_heart
            }

            divider()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed(); true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onSaveInstanceState(outState: Bundle?) {
        headerResult.saveInstanceState(outState)
        result.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

}
