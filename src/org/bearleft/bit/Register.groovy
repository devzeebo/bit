package org.bearleft.bit

/**
 * User: Eric Siebeneich
 * Date: 3/21/14
 */
class Register {

	private def value

	Register() {
		value = 0
	}

	void setValue(int value) {
		this.value = value
	}

	int getValue() {
		return value
	}

	def plus(def val) {
		value += val
		return value
	}

	boolean equals(def other) {
		return other.class == Register && other.value == value
	}

	String toString() {
		return value
	}
}
