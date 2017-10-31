package co.zsmb.materialdrawerktexample

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badge
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
import co.zsmb.materialdrawerktexample.newactivities.*
import co.zsmb.materialdrawerktexample.originalactivities.*
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.octicons_typeface_library.Octicons
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class DrawerActivity : AppCompatActivity() {

    private lateinit var result: Drawer
    private lateinit var headerResult: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        result = drawer {
            toolbar = this@DrawerActivity.toolbar
            hasStableIds = true
            savedInstance = savedInstanceState
            showOnFirstLaunch = true

            headerResult = accountHeader {
                background = R.drawable.header
                savedInstance = savedInstanceState
                translucentStatusBar = true

                profile("Mike Penz", "mikepenz@gmail.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/1476232?v=3&s=460"
                    identifier = 100
                }
                profile("Bernat Borras", "alorma@github.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/887462?v=3&s=460"
                    identifier = 101
                }
                profile("Max Muster", "max.mustermann@gmail.com") {
                    icon = R.drawable.profile2
                    identifier = 102
                }
                profile("Felix House", "felix.house@gmail.com") {
                    icon = R.drawable.profile3
                    identifier = 103
                }
                profile("Mr. X", "mister.x.super@gmail.com") {
                    icon = R.drawable.profile4
                    identifier = 104
                }
                profile("Batman", "batman@gmail.com") {
                    icon = R.drawable.profile5
                    identifier = 105
                }
                profileSetting("Add account", "Add new GitHub Account") {
                    iicon = GoogleMaterial.Icon.gmd_add
                    identifier = 100_000
                }
                profileSetting("Manage Account") {
                    iicon = GoogleMaterial.Icon.gmd_settings
                    identifier = 100_001
                }

                onProfileChanged { _, profile, _ ->
                    if (profile.identifier == 100_000L) {
                        val size = headerResult.profiles.size
                        val newProfile = ProfileDrawerItem()
                                .withName("New Batman ${size - 1}")
                                .withNameShown(true)
                                .withEmail("batman${size - 1}@gmail.com")
                                .withIcon(R.drawable.profile5)
                                .withIdentifier(100L + size + 1L)
                        headerResult.addProfile(newProfile, size - 2)
                    }
                    false
                }
            }

            sectionHeader("MaterialDrawerKt demos") {
                divider = false
            }

            primaryItem("Drawer item types") {
                iicon = GoogleMaterial.Icon.gmd_cloud
                onClick(openActivity(DrawerItemTypesActivity::class))
            }
            primaryItem("Account header options") {
                iicon = MaterialDesignIconic.Icon.gmi_account
                onClick(openActivity(AccountHeaderActivity::class))
            }
            primaryItem("Header and footer") {
                iicon = GoogleMaterial.Icon.gmd_menu
                onClick(openActivity(HeaderFooterActivity::class))
            }
            primaryItem("Listeners") {
                iicon = MaterialDesignIconic.Icon.gmi_audio
                onClick(openActivity(ListenersActivity::class))
            }
            primaryItem("Badges") {
                iicon = MaterialDesignIconic.Icon.gmi_tag
                onClick(openActivity(BadgesActivity::class))
            }

            sectionHeader("Original demo activities")

            primaryItem(R.string.drawer_item_compact_header, R.string.drawer_item_compact_header_desc) {
                iicon = GoogleMaterial.Icon.gmd_brightness_5
                identifier = 1
                selectable = false
                onClick { _ ->
                    startActivity(Intent(this@DrawerActivity, CompactHeaderDrawerActivity::class.java))
                    false
                }
            }
            primaryItem(R.string.drawer_item_action_bar_drawer, R.string.drawer_item_action_bar_drawer_desc) {
                iicon = FontAwesome.Icon.faw_home
                identifier = 2
                selectable = false
                onClick(openActivity(ActionBarActivity::class))
            }
            primaryItem(R.string.drawer_item_multi_drawer, R.string.drawer_item_multi_drawer_desc) {
                iicon = FontAwesome.Icon.faw_gamepad
                identifier = 3
                selectable = false
                onClick(openActivity(MultiDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_non_translucent_status_drawer, R.string.drawer_item_non_translucent_status_drawer_desc) {
                iicon = FontAwesome.Icon.faw_eye
                identifier = 4
                selectable = false
                onClick(openActivity(NonTranslucentDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_advanced_drawer, R.string.drawer_item_advanced_drawer_desc) {
                iicon = GoogleMaterial.Icon.gmd_adb
                identifier = 5
                selectable = false
                onClick(openActivity(AdvancedDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_embedded_drawer, R.string.drawer_item_embedded_drawer_desc) {
                iicon = MaterialDesignIconic.Icon.gmi_battery
                identifier = 7
                selectable = false
                onClick(openActivity(EmbeddedDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_fullscreen_drawer, R.string.drawer_item_fullscreen_drawer_desc) {
                iicon = MaterialDesignIconic.Icon.gmi_labels
                identifier = 8
                selectable = false
                onClick(openActivity(FullscreenDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_custom_container_drawer, R.string.drawer_item_custom_container_drawer_desc) {
                iicon = GoogleMaterial.Icon.gmd_my_location
                identifier = 9
                selectable = false
                onClick(openActivity(CustomContainerActivity::class))
            }
            primaryItem(R.string.drawer_item_menu_drawer, R.string.drawer_item_menu_drawer_desc) {
                iicon = GoogleMaterial.Icon.gmd_filter_list
                identifier = 10
                selectable = false
                onClick(openActivity(MenuDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_mini_drawer, R.string.drawer_item_mini_drawer_desc) {
                iicon = MaterialDesignIconic.Icon.gmi_battery_charging
                identifier = 11
                selectable = false
                onClick(openActivity(MiniDrawerActivity::class))
            }
            primaryItem(R.string.drawer_item_fragment_drawer, R.string.drawer_item_fragment_drawer_desc) {
                iicon = GoogleMaterial.Icon.gmd_disc_full
                identifier = 12
                selectable = false
                onClick(openActivity(FragmentDrawerActivity::class))
            }

            sectionHeader("More original demo material")

            expandableBadgeItem("Collapsable Badge") {
                iicon = MaterialDesignIconic.Icon.gmi_collection_case_play
                identifier = 18
                selectable = false
                badge("100") {
                    textColor = Color.WHITE.toLong()
                    colorRes = R.color.md_red_700
                }
                secondaryItem("CollapsableItem") {
                    level = 2
                    iicon = MaterialDesignIconic.Icon.gmi_8tracks
                    identifier = 2000
                }
                secondaryItem("CollapsableItem 2") {
                    level = 2
                    iicon = MaterialDesignIconic.Icon.gmi_8tracks
                    identifier = 2001
                }
            }

            expandableItem("Collapsable Badge") {
                iicon = MaterialDesignIconic.Icon.gmi_collection_case_play
                identifier = 19
                selectable = false
                secondaryItem("CollapsableItem") {
                    level = 2
                    iicon = MaterialDesignIconic.Icon.gmi_8tracks
                    identifier = 2002
                }
                secondaryItem("CollapsableItem 2") {
                    level = 2
                    iicon = MaterialDesignIconic.Icon.gmi_8tracks
                    identifier = 2003
                }
            }

            secondaryItem(R.string.drawer_item_open_source) {
                iicon = FontAwesome.Icon.faw_github
                identifier = 20
                selectable = false
            }
            secondaryItem(R.string.drawer_item_contact) {
                iicon = GoogleMaterial.Icon.gmd_format_color_fill
                identifier = 21
                selectable = false
            }

            divider()

            switchItem("Switch") {
                iicon = Octicons.Icon.oct_tools
                checked = true
            }
            switchItem("Switch2") {
                iicon = Octicons.Icon.oct_tools
                checked = true
                selectable = false
            }
            toggleItem("Toggle") {
                iicon = Octicons.Icon.oct_tools
                checked = true
            }

            divider()

            secondarySwitchItem("Secondary Switch") {
                iicon = Octicons.Icon.oct_tools
                checked = true
            }
            secondarySwitchItem("Secondary Switch2") {
                iicon = Octicons.Icon.oct_tools
                checked = true
                selectable = true
            }
            secondaryToggleItem("Secondary Toggle") {
                iicon = Octicons.Icon.oct_tools
                checked = true
            }
        }
    }

    private fun <T : Activity> openActivity(activity: KClass<T>): (View?) -> Boolean = {
        startActivity(Intent(this@DrawerActivity, activity.java))
        false
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

}
