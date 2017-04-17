package co.zsmb.materialdrawerkt

class NonReadablePropertyException : Exception()

fun nonReadable(): Nothing = throw NonReadablePropertyException()
