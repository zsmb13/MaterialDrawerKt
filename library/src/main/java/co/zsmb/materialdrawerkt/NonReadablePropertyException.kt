@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt

class NonReadablePropertyException : UnsupportedOperationException()

fun nonReadable(): Nothing = throw NonReadablePropertyException()
