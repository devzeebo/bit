package org.bearleft.bit

/**
 * User: Eric Siebeneich
 * Date: 3/20/14
 */
class BitAssembler {

	BitAssembler() {

	}

	static int[] assembleProgram(int instructionCount, Reader reader) {

		int[] program = new int[instructionCount]
		int instructionBits
		BitInstruction instruction
		for (int idx = 0; idx < instructionCount; idx++) {
			String it = reader.readLine()
			(instructionBits, instruction) = BitInstruction.encodeInstruction(it.replaceAll(/\s+.*/, ''))
			program[idx] =
				(instructionBits << 26 & BitInstruction.INSTRUCTION_MASK) |
				(instruction.encodeArguments(it.replaceAll(/\w*\s*/, '')) & ~BitInstruction.INSTRUCTION_MASK)
		}

		return program
	}

	static int encodeRegister(String register) {
		// remove the $
		return register.replace('$', '') as int
	}

	public static void main(String[] args) {
		assembleProgram(3, new InputStreamReader(System.in)).each {
			println "${Integer.toBinaryString(it)}".padLeft(32, '0')
		}
	}
}
