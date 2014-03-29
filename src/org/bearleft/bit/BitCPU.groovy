package org.bearleft.bit

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class BitCPU {

	List<Register> registers

	private static final int PC_REGISTER = 32
	Register getPC() {
		return registers[PC_REGISTER]
	}

	private static final int JUMP_REGISTER = 31
	Register getJR() {
		return registers[JUMP_REGISTER]
	}

	Memory memory

	BitCPU() {

		registers = []

		memory = new Memory(Memory.MAX_MEMORY)

		for(int i = 0; i < 33; i++) {
			registers.add(new Register())
		}
	}
}
