# MaterialDrawerKt 

[![Build Status](https://travis-ci.org/zsmb13/MaterialDrawerKt.svg?branch=master)](https://travis-ci.org/zsmb13/MaterialDrawerKt)
[![Bintray](https://img.shields.io/bintray/v/zsmb13/MaterialDrawerKt/MaterialDrawerKt.svg?maxAge=86400)](https://bintray.com/zsmb13/MaterialDrawerKt/MaterialDrawerKt)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialDrawerKt-orange.svg?style=flat)](https://android-arsenal.com/details/1/5693) 

<img src="https://raw.githubusercontent.com/zsmb13/MaterialDrawerKt/master/docs/github-banner.png">

Create navigation drawers in your Activities and Fragments without having to write any XML, in pure Kotlin code, with access to all the features of the original library: all sorts of menu items, badges, account headers, and more.

This library is a Kotlin DSL wrapper around the [mikepenz/MaterialDrawer](https://github.com/mikepenz/MaterialDrawer) library, and features:

- Access to all of the original library's features with a nice, concise API
- Fixes for the couple of inconsistencies of the original API
- Detailed code comments for conveninent in-IDE documentation lookup (`Ctrl+Q` on Windows,  `⌃J` on Mac)

# Sample app

You can find the sample app [in the Play Store](https://play.google.com/store/apps/details?id=co.zsmb.materialdrawerktexample), and its source code in the [app module](https://github.com/zsmb13/MaterialDrawerKt/tree/master/app) of the project.

<img src="https://raw.githubusercontent.com/zsmb13/MaterialDrawerKt/master/docs/github-screens.png">

# Setup

The library is hosted on jcenter. To use it, add the following to your module level `build.gradle` file's dependencies:
 
```gradle
implementation 'co.zsmb:materialdrawer-kt:1.3.7'

// required support libraries
implementation "com.android.support:appcompat-v7:${versions.supportLib}"
implementation "com.android.support:recyclerview-v7:${versions.supportLib}"
implementation "com.android.support:support-annotations:${versions.supportLib}"
implementation "com.android.support:design:${versions.supportLib}"
```

In general, you don't have to include the original library separately. (See the note in the FAQ.) 

# Basic usage

Just as a general note, try using the in-IDE documentation when you're in doubt about anything. It's much more detailed than the original library's docs, this was one of the design goals of the library. The IntelliJ/Android Studio shortcut for bringing up the docs about a function is `Ctrl+Q` on Windows, and `⌃J` on Mac. 

To add a navigation drawer, you just have to add the following to your Activity's `onCreate` function: 

```kotlin
drawer {}
```

This will give you an empty sheet that you can drag in from the left side of the screen. You can add menu items to it like this:

```kotlin
drawer {
    primaryItem("Home") {}
    divider {}
    primaryItem("Users") {}
    secondaryItem("Settings") {}
}
```

For all the available types of menu items, see the "Drawer item types" in the sample app.

You can modify properties of the drawer inside the `drawer {}` block, and properties of the menu items in their respective blocks:

```kotlin
drawer {
    headerViewRes = R.layout.header
    closeOnClick = false
    
    primaryItem("Home") {
        icon = R.drawable.ic_home
    }
    divider {}
    primaryItem("Users") {
        icon = R.drawable.ic_user
    }
    secondaryItem("Settings") {
        icon = R.drawable.ic_settings
        selectable = false
    }
}
```

Note that most of these properties are non-readable, and can only be used for setting these values. This is why these properties are marked as deprecated, and will cause build errors. The rest should be safe to use to read back any values you've set, if you had to do that for whatever reason.

For a complete reference of the wrapper methods and properties, see the [list in the wiki](https://github.com/zsmb13/MaterialDrawerKt/wiki/Wrappers).

# Advanced features

### Account headers

Creating an account header with profile entries can be done like so:
 
```kotlin
drawer {
    accountHeader { 
        profile("Samantha", "samantha@gmail.com") {
            icon = "http://some.site/samantha.png"
        }
        profile("Laura", "laura@gmail.com") { 
            icon = R.drawable.profile_laura
        }
    }
    
    primaryItem("Home")
}
```

Note that loading images from URLs requires additional setup, see the `DrawerApplication` class in the sample app for guidance.

### Footers

You can add items to an always visible, sticky footer in by nesting them inside a `footer` block:

```kotlin
drawer {
    footer {
        primaryItem("Primary item")
        secondaryItem("Secondary item")
    }
}
```

### Listeners

Listeners can be added to both individual drawer items and the entire drawer. Some examples:

```kotlin
drawer {
    primaryItem("Item 1")
    primaryItem("Item 2") {
        // Called only when this item is clicked
        onClick { _ ->
            Log.d("DRAWER", "Click.")
            false
        }
    }

    // Called when any drawer item is clicked
    onItemClick { _, position, _ ->
        Log.d("DRAWER", "Item $position clicked")
        false
    }
    
    onOpened { 
        Log.d("DRAWER", "Navigation drawer opened")
    }
}
```

More examples in the "Listeners" section of the sample app.

### Badges

Add badges to drawer items, and customize them with this syntax:

```kotlin
drawer {
    primaryItem {
        badge("111") {
            cornersDp = 0
            color = 0xFF0099FF
            colorPressed = 0xFFCC99FF
        }
    }
}
```

You can see more examples in the "Badges" section of the sample app.

# Conversion from original

This is a rough guide to how the original API's features are converted to the DSL, for those who are already familiar with the original library.

### Builders

Builders are replaced by functions that are named without the "Builder" suffix.

```kotlin
DrawerBuilder()
    .withActivity(this)
    .build()
```

... is replaced with ...

```kotlin
drawer { 

}
```

### DrawerItems

Calls to XyzDrawerItem classes are replaced with functions as well. The "Drawer" word is omitted from the function's name. Note that properties like names and descriptions of the drawer items become parameters of these functions. 

For example: 

```kotlin
PrimaryDrawerItem().withName("Item name")
```

... is replaced with ...

```kotlin
primaryItem("Item name") {

}
```

### `with` functions
 
Calls to `.withXyz()` functions are replaced with properties that you can set. For a complete reference of the wrapper methods and properties, see the [list in the wiki](https://github.com/zsmb13/MaterialDrawerKt/wiki/Wrappers). 

Very few of these are readable. If you want to read these at build time for some reason, check the documentation. Non readable properties should be deprecated and not compile, but if they do, they will throw a `NonReadablePropertyException` if you attempt to read their value.

For an example...

```kotlin
AccountHeaderBuilder()
    .withActivity(this)
    .withHeaderBackground(R.color.colorPrimary)
    .build()
```

... is replaced with ...

```
accountHeader {
    headerBackgroundRes = R.color.colorPrimary 
}
```

Note that overloaded functions are replaced with multiple properties, distinguished by suffixes. For example, the above `withHeaderBackground` function's three overloads can be set through the following properties:

|  Parameter type    | Property name                              |
| ------------------ | ------------------------------------------ |
|  Int               | headerBackground <br/> headerBackgroundRes |
|  Drawable          | headerBackgroundDrawable                   |
|  ImageHolder       | headerBackgroundImage                      |

There may be defaults without suffixes for what's assumed to be the most popular use case.

### Listeners

Adding simple listeners to drawers (or individual drawer items) are done with onXyz function calls, which take lambdas as parameters. For example:

```kotlin
DrawerBuilder()
        .withActivity(this)
        .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
            override fun onItemClick(view: View, position: Int, drawerItem: IDrawerItem<out Any?, out RecyclerView.ViewHolder>?): Boolean {
                Log.d("DRAWER", "Clicked!")
                return true
            }
        })
        .build()
```

... is replaced with ...

```kotlin
drawer {
    onItemClick { view, position, drawerItem -> 
        Log.d("DRAWER", "Clicked!")
        true
    }
}
```

### Complex listeners

Listeners that originally have multiple callbacks have been broken up into individual functions:

```kotlin
DrawerBuilder()
        .withActivity(this)
        .withOnDrawerListener(object : Drawer.OnDrawerListener {
            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
                Log.d("DRAWER", "Sliding")
            }

            override fun onDrawerClosed(drawerView: View?) {
                Log.d("DRAWER", "Closed")
            }

            override fun onDrawerOpened(drawerView: View?) {
                Log.d("DRAWER", "Opened")
            }
        })
        .build()
```

... is replaced with ...

```kotlin
drawer { 
    onSlide { _, _ ->
        Log.d("DRAWER", "Sliding")
    }
    onClosed {
        Log.d("DRAWER", "Closed")
    }
    onOpened {
        Log.d("DRAWER", "Opened")
    }
}
```

### Image loading

Since the MaterialDrawer library doesn't include its own image loading solution, you have to set one up yourself. You have to do this before the first time MaterialDrawer has to load an image, for example, in your Application's `onCreate` method. 

With the original library, this setup looks like this (Picasso is just used as an example):

```kotlin
DrawerImageLoader.init(object: AbstractDrawerImageLoader() {
    override fun placeholder(ctx: Context, tag: String?): Drawable {
        return DrawerUIUtils.getPlaceHolder(ctx)
    }

    override fun set(imageView: ImageView, uri: Uri, placeholder: Drawable?, tag: String?) {
        Picasso.with(imageView.context)
                .load(uri)
                .placeholder(placeholder)
                .into(imageView)
    }

    override fun cancel(imageView: ImageView) {
        Picasso.with(imageView.context)
                .cancelRequest(imageView)
    }
})
```

This can be replaced by the following:

```kotlin
drawerImageLoader {
    placeholder { ctx, tag ->
        DrawerUIUtils.getPlaceHolder(ctx)
    }
    set { imageView, uri, placeholder, tag ->
        Picasso.with(imageView.context)
                .load(uri)
                .placeholder(placeholder)
                .into(imageView)
    }
    cancel { imageView ->
        Picasso.with(imageView.context)
                .cancelRequest(imageView)
    }
}
```

# FAQ

#### I want to use features of the base library that haven't made it to this one yet

If the base library gets features and they aren't ported to this wrapper yet, you can include that as a dependency in addition to this one, and use the two together. For these purposes, the internal `DrawerBuilder` that this library uses is exposed through a property, and you can access it like so:
 
```kotlin
drawer {
    builder.withKeepStickyItemsVisible(true)
}
```

The internal `AccountHeaderBuilder` is exposed in the same way:

```kotlin
accountHeader {
    builder.withHeightDp(20)
}
```

As for drawer items, you can just use the original API's calls on the items that are returned:

```kotlin
val item = primaryItem("Hello") {
    icon = R.drawable.profile
}
item.withBadge("10")
```
```kotlin
primaryItem("Hello") {
    icon = R.drawable.profile
}.withBadge("10")
```

# License

    Copyright 2018 Marton Braun

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
