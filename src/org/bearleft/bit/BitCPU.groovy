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

	private static final int SP_REGISTER = 29
	Register getSP() {
		return registers[SP_REGISTER]
	}

	private static final int FP_REGISTER = 30
	Register getFP() {
		return registers[FP_REGISTER]
	}

	Memory memory

	BitCPU() {

		registers = []

		memory = new Memory(Memory.MAX_MEMORY)

		for(int i = 0; i < 33; i++) {
			registers.add(new Register())
		}

		// Set the stack and frame pointer to the end of memory space
		FP.value = memory.size - 4
		SP.value = FP.value
	}

	int cyclesRemaining
	int instructionBytes
	BitInstruction currentInstruction

	void step() {
		if (!cyclesRemaining) {

//			long millis = System.currentTimeMillis()
			instructionBytes = memory.getWord(PC.value)
//			println "Instruction load: ${System.currentTimeMillis() - millis}"

//			millis = System.currentTimeMillis()
			currentInstruction = BitInstruction.decodeInstruction(instructionBytes)
//			println "Decode: ${System.currentTimeMillis() - millis}"

			cyclesRemaining = currentInstruction.cycles
		}
		cyclesRemaining--

		if (!cyclesRemaining) {
			int s, t, u
			(s, t, u) = currentInstruction.decodeArguments(instructionBytes)

//			println currentInstruction.class

			currentInstruction.onExecute(this, s, t, u)

			PC.value = PC + 4
		}
	}
}
