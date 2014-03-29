package org.bearleft.bit

/**
 * User: Eric Siebeneich
 * Date: 3/20/14
 */
abstract class BitInstruction {

	private static final int INSTRUCTION_MASK = 0b111111_00000_00000_00000_00000000000
	private static final int REGISTER_1_MASK = 0b000000_11111_00000_00000_00000000000
	private static final int REGISTER_2_MASK = 0b000000_00000_11111_00000_00000000000
	private static final int REGISTER_3_MASK = 0b000000_00000_00000_11111_00000000000
	private static final int IMMEDIATE_MASK = 0b000000_00000_00000_1111_1111_1111_1111

//	@Newify(BitInstruction)
//	private static final def INSTRUCTION_MAP = [
//			0b000000: BitInstruction('NOOP', 1, null),
//			0b000001: BitInstruction('ADD', 2) { s, t, u ->
//				registers[s] = registers[t] + registers[u]
//			},
//			0b000010: BitInstruction('SUB', 2) { s, t, u ->
//				registers[s] = registers[t] - registers[u]
//			},
//			0b000011: BitInstruction('DIV', 2) { s, t, u ->
//				registers[s] = registers[t] / registers[u]
//			},
//			0b000100: BitInstruction('MULT', 2) { s, t, u ->
//				registers[s] = registers[t] * registers[u]
//			},
//			0b000101: BitInstruction('AND', 2) { s, t, u ->
//				registers[s] = registers[t] & registers[u]
//			},
//			0b000110: BitInstruction('OR', 2) { s, t, u ->
//				registers[s] = registers[t] | registers[u]
//			},
//			0b000111: BitInstruction('XOR', 2) { s, t, u ->
//				registers[s] = registers[t] ^ registers[u]
//			},
//
//			0b001000: BitInstruction('ADDI', 2) { s, t, immediate ->
//				registers[s] = registers[t] + immediate
//			},
//			0b001001: BitInstruction('SUBI', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b001010: BitInstruction('DIVI', 2) { s, t, immediate ->
//				registers[s] = registers[t] / immediate
//			},
//			0b001011: BitInstruction('MULTI', 2) { s, t, immediate ->
//				registers[s] = registers[t] * immediate
//			},
//			0b001100: BitInstruction('ANDI', 2) { s, t, immediate ->
//				registers[s] = registers[t] & immediate
//			},
//			0b001101: BitInstruction('ORI', 2) { s, t, immediate ->
//				registers[s] = registers[t] | immediate
//			},
//			0b001110: BitInstruction('XORI', 2) { s, t, immediate ->
//				registers[s] = registers[t] ^ immediate
//			},
//			0b001111: BitInstruction('BEQ', 2) { s, t, immediate ->
//				if (registers[s] == registers[t]) {
//					registers[BitCPU.JUMP_REGISTER] = registers[BitCPU.INSTRUCTION_POINTER] + 4
//					registers[BitCPU.INSTRUCTION_POINTER] = immediate
//				}
//			},
//			0b010000: BitInstruction('BNE', 2) { s, t, immediate ->
//				if (registers[s] != registers[t]) {
//					registers[BitCPU.JUMP_REGISTER] = registers[BitCPU.INSTRUCTION_POINTER] + 4
//					registers[BitCPU.INSTRUCTION_POINTER] = immediate
//				}
//			},
//			0b010001: BitInstruction('BLT', 2) { s, t, immediate ->
//				if (registers[s] < registers[t]) {
//					registers[BitCPU.JUMP_REGISTER] = registers[BitCPU.INSTRUCTION_POINTER] + 4
//					registers[BitCPU.INSTRUCTION_POINTER] = immediate
//				}
//			},
//			0b010010: BitInstruction('BLTE', 2) { s, t, immediate ->
//				if (registers[s] <= registers[t]) {
//					jumpAndLink(immediate)
//				}
//			},
//			0b010011: BitInstruction('BGT', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b010100: BitInstruction('BGTE', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b010101: BitInstruction('ELSE', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b010110: BitInstruction('LW', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b010111: BitInstruction('SW', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b011000: BitInstruction('LB', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b011001: BitInstruction('SB', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b011010: BitInstruction('SLL', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b011011: BitInstruction('SRL', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b011100: BitInstruction('SRA', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b011101: BitInstruction('JUMP', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			},
//			0b111111: BitInstruction('SYSCALL', 2) { s, t, immediate ->
//				registers[s] = registers[t] - immediate
//			}
//	]

	def extractInstruction(int instructionInt) {
//		String instruction = INSTRUCTION_MAP[(instructionInt & INSTRUCTION_MASK) >>> 26]
	}

	BitInstruction(int cycles) {

	}

	abstract void onExecute(BitCPU cpu, int s, int t, def u);

	public static void main(String[] args) {
		extractInstruction(0b010110_00101_00001_00100_00000000000)
	}
}
