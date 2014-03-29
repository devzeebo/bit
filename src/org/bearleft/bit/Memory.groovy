package org.bearleft.bit

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class Memory {

	static final int INT_MASK =  0x00000000_FFFFFFFF
	static final int BYTE_MASK = 0x00000000_000000FF

	static final int MAX_MEMORY = 32768

	private byte[] bytes

	Memory(int size) {
		bytes = new byte[Math.min(size, MAX_MEMORY)]
	}

	long getWord(int address) {
		long ret = bytes[address++] << 24
		ret |= bytes[address++] << 16
		ret |= bytes[address++] << 8
		ret |= bytes[address]

		return ret & INT_MASK
	}

	long getByte(int address) {
		long ret = bytes[address]

		return ret & BYTE_MASK
	}

	void storeWord(int address, long value) {
		bytes[address++] = value >> 24
		bytes[address++] = (value >> 16) & BYTE_MASK
		bytes[address++] = (value >> 8) & BYTE_MASK
		bytes[address] = (value) & BYTE_MASK
	}

	void storeByte(int address, long value) {
		bytes[address] = value & BYTE_MASK
	}
}
