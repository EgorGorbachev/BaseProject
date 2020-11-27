package com.alesh.domain.util

import android.os.SystemClock
import android.util.Log

fun log(tag: String = "", msg: Any) = Log.v("Alesh! $tag", msg.toString())

inline fun <T> measureDuration(tag: String = "", block: () -> T): T {
    val start = SystemClock.uptimeMillis()
    val result = block()
    val time = SystemClock.uptimeMillis() - start
    log(tag, "$time millis")
    return result
}