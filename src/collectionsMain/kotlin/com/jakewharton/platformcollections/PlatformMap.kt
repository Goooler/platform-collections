@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.jakewharton.platformcollections

public actual typealias PlatformMap<K, V> = HashMap<K, V>

public actual inline fun <K, V> PlatformMap<K, V>.asMutableMap(): MutableMap<K, V> {
	return this
}

public actual inline fun <K, V> PlatformMap<K, V>.clear() {
	clear()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.contains(key: K): Boolean {
	return containsKey(key)
}

public actual inline fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean {
	return isEmpty()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.get(key: K): V? {
	return this[key]
}

public actual inline fun <K, V> PlatformMap<K, V>.put(key: K, value: V) {
	this[key] = value
}

public actual inline fun <K, V> PlatformMap<K, V>.remove(key: K) {
	remove(key)
}

public actual inline val <K, V> PlatformMap<K, V>.size: Int get() = size

public actual inline fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V> {
	return LinkedHashMap(this)
}
