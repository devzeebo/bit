package org.bearleft.bit.file

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
abstract class BitIOHelper {

	static int writeInstruction(byte[] bytes, int offset, int instruction) {
		bytes[offset++] = (instruction >> 24) & 0x000000FF
		bytes[offset++] = (instruction >> 16) & 0x000000FF
		bytes[offset++] = (instruction >>  8) & 0x000000FF
		bytes[offset++] = instruction & 0x000000FF

		return offset
	}

	static def readInstruction(byte[] bytes, int offset) {

		int instruction = ((bytes[offset++] & 0x000000FF) << 24)
		instruction |=    ((bytes[offset++] & 0x000000FF) << 16)
		instruction |=    ((bytes[offset++] & 0x000000FF) << 8)
		instruction |=      bytes[offset++] & 0x000000FF

		return [instruction, offset]
	}

	static String getInstructionBits(int instruction) {
		"${Integer.toBinaryString(instruction)}".padLeft(32, '0')
	}
}
