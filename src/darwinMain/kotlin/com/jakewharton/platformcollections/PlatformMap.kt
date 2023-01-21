@file:Suppress("NOTHING_TO_INLINE")

package com.jakewharton.platformcollections

import kotlinx.cinterop.UnsafeNumber
import platform.Foundation.NSCopyingProtocol
import platform.Foundation.NSMutableDictionary
import platform.Foundation.NSMutableSet
import platform.Foundation.enumerateKeysAndObjectsUsingBlock
import platform.Foundation.removeAllObjects
import platform.darwin.nil

@Suppress("ACTUAL_WITHOUT_EXPECT") // Our use of 'value' fails the matcher.
public actual typealias PlatformMap<K, V> = MutableMap<K, V>

@Suppress("unused") // Type parameters match expect and for extensions.
public value class MutableMap<K, V>
private constructor(
	public val storage: NSMutableDictionary,
) {
	public constructor() : this(NSMutableDictionary())
}

public actual inline fun <K, V> PlatformMap<K, V>.asMutableMap(): MutableMap<K, V> {
	TODO()
}

public actual inline fun <K, V> PlatformMap<K, V>.clear() {
	storage.removeAllObjects()
}

public actual inline operator fun <K, V> PlatformMap<K, V>.contains(key: K): Boolean {
	return storage.objectForKey(key) != nil
}

@OptIn(UnsafeNumber::class)
public actual inline fun <K, V> PlatformMap<K, V>.isEmpty(): Boolean {
	return storage.count.toInt() == 0
}

public actual inline operator fun <K, V> PlatformMap<K, V>.get(key: K): V? {
	@Suppress("UNCHECKED_CAST")
	return storage.objectForKey(key) as V?
}

public actual inline fun <K, V> PlatformMap<K, V>.put(key: K, value: V) {
	storage.setObject(value, key as NSCopyingProtocol)
}

public actual inline fun <K, V> PlatformMap<K, V>.remove(key: K) {
	storage.removeObjectForKey(key)
}

@OptIn(UnsafeNumber::class)
public actual inline val <K, V> PlatformMap<K, V>.size: Int get() = storage.count.toInt()

public actual inline fun <K, V> PlatformMap<K, V>.toMutableMap(): MutableMap<K, V> {
	TODO()
}
