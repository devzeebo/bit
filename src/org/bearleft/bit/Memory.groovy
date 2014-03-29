package org.bearleft.bit

import org.bearleft.bit.io.BitIOHelper

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class Memory {

	static final int BYTE_MASK = 0x000000FF

	static final int MAX_MEMORY = 32768

	private byte[] bytes
	int size

	Memory(int size) {
		this.size = size
		bytes = new byte[Math.min(size, MAX_MEMORY)]
	}

	int getWord(int address) {
		int ret = BitIOHelper.readInstruction(bytes, address)[0]

		return ret
	}

	int getByte(int address) {
		int ret = bytes[address]

		return ret
	}

	void storeWord(int address, long value) {
		BitIOHelper.writeInstruction(bytes, address, value as int)
	}

	void storeByte(int address, long value) {
		bytes[address] = value & BYTE_MASK
	}
}
