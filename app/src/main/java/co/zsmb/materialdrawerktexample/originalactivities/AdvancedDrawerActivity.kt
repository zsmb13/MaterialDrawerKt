package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.builders.footer
import co.zsmb.materialdrawerkt.draweritems.badge
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.profile.profileSetting
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerktexample.R
import co.zsmb.materialdrawerktexample.customitems.customprimary.CustomPrimaryDrawerItem
import co.zsmb.materialdrawerktexample.customitems.customurl.CustomUrlPrimaryDrawerItem
import co.zsmb.materialdrawerktexample.customitems.overflow.overflowMenuItem
import co.zsmb.materialdrawerktexample.utils.toast
import com.mikepenz.fontawesome_typeface_library.FontAwesome.Icon.*
import com.mikepenz.google_material_typeface_library.GoogleMaterial.Icon
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import kotlinx.android.synthetic.main.activity_sample.*

class AdvancedDrawerActivity : AppCompatActivity() {

    private lateinit var result: Drawer
    private lateinit var headerResult: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            toolbar = this@AdvancedDrawerActivity.toolbar
            savedInstance = savedInstanceState
            actionBarDrawerToggleEnabled = true

            headerResult = accountHeader {
                savedInstance = savedInstanceState
                background = R.drawable.header

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
                    iicon = Icon.gmd_add
                    onClick { _ ->
                        val newProfile = ProfileDrawerItem()
                                .withNameShown(true)
                                .withName("Batman")
                                .withEmail("batman@gmaill.com")
                                .withIcon(R.drawable.profile6)
                        headerResult.profiles?.let {
                            headerResult.addProfile(newProfile, it.size - 2)
                        }
                        false
                    }
                }
                profileSetting("Manage Account") {
                    iicon = Icon.gmd_settings
                }
            }

            primaryItem(R.string.drawer_item_home) { iicon = faw_home }

            overflowMenuItem(R.string.drawer_item_menu_drawer_item, R.string.drawer_item_menu_drawer_item_desc) {
                iicon = Icon.gmd_filter_center_focus
                menu = R.menu.fragment_menu
                onMenuItemClick {
                    toast(it.title)
                    false
                }
            }

            attachItem(
                    CustomPrimaryDrawerItem()
                            .withBackgroundRes(R.color.accent)
                            .withName(R.string.drawer_item_free_play)
                            .withIcon(faw_gamepad)
            )

            primaryItem(R.string.drawer_item_custom) {
                iicon = faw_gamepad
                description = "This is a description"
            }

            attachItem(
                    CustomUrlPrimaryDrawerItem().apply {
                        withName(R.string.drawer_item_contact)
                        withDescription(R.string.drawer_item_fragment_drawer_desc)
                        withIcon("https://avatars3.githubusercontent.com/u/1476232?v=3&s=460")
                    }
            )

            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_settings) { iicon = faw_cog }
            secondaryItem(R.string.drawer_item_help) { iicon = faw_question }
            secondaryItem(R.string.drawer_item_open_source) {
                iicon = faw_github
                badge("12")
            }
            secondaryItem(R.string.drawer_item_contact) { iicon = faw_bullhorn }

            footer {
                secondaryItem(R.string.drawer_item_settings) {
                    iicon = faw_cog
                }
                secondaryItem(R.string.drawer_item_open_source) {
                    iicon = faw_github
                }
            }

            onNavigation {
                finish()
                true
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        result.saveInstanceState(outState)
        headerResult.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.menu_1 -> {
                    val profile2 = headerResult.profiles[1]
                    profile2.withIcon(Icon.gmd_android)
                    headerResult.updateProfile(profile2)
                    true
                }
                R.id.menu_2 -> {
                    result.actionBarDrawerToggle.isDrawerIndicatorEnabled = false
                    true
                }
                R.id.menu_3 -> {
                    result.actionBarDrawerToggle.isDrawerIndicatorEnabled = true
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

}
