package org.bearleft.bit

import org.bearleft.bit.instructions.NoopInstruction
import org.bearleft.bit.instructions.arithmetic.*
import org.bearleft.bit.instructions.branch.*
import org.bearleft.bit.instructions.immediate.*
import org.bearleft.bit.instructions.memory.LbInstruction
import org.bearleft.bit.instructions.memory.LwInstruction
import org.bearleft.bit.instructions.memory.SbInstruction
import org.bearleft.bit.instructions.memory.SwInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/20/14
 */
abstract class BitInstruction {

	protected static final int INSTRUCTION_MASK = 0b111111_00000_00000_00000_00000000000
	protected static final int REGISTER_1_MASK = 0b000000_11111_00000_00000_00000000000
	protected static final int REGISTER_2_MASK = 0b000000_00000_11111_00000_00000000000
	protected static final int REGISTER_3_MASK = 0b000000_00000_00000_11111_00000000000
	protected static final int IMMEDIATE_MASK = 0b000000_00000_00000_1111_1111_1111_1111

	private static final def INSTRUCTION_MAP = [
			0b000000: new NoopInstruction(),
			0b000001: new AddInstruction(),
			0b000010: new SubInstruction(),
			0b000011: new DivInstruction(),
			0b000100: new MultInstruction(),
			0b000101: new AndInstruction(),
			0b000110: new OrInstruction(),
			0b000111: new XorInstruction(),

			0b001000: new AddiInstruction(),
			0b001001: new SubiInstruction(),
			0b001010: new DiviInstruction(),
			0b001011: new MultiInstruction(),
			0b001100: new AndiInstruction(),
			0b001101: new OriInstruction(),
			0b001110: new XoriInstruction(),
			0b001111: new BeqInstruction(),
			0b010000: new BneInstruction(),
			0b010001: new BltInstruction(),
			0b010010: new BlteInstruction(),
			0b010011: new BgtInstruction(),
			0b010100: new BgteInstruction(),
			0b010101: new ElseInstruction(),
			0b010110: new LwInstruction(),
			0b010111: new SwInstruction(),
			0b011000: new LbInstruction(),
			0b011001: new SbInstruction(),
			0b011010: new SllInstruction(),
			0b011011: new SrlInstruction(),
			0b011100: new SraInstruction(),
			0b011101: new JumpInstruction(),
//			0b111111: SyscallInstruction
	]

	static BitInstruction decodeInstruction(int instructionInt) {
		return INSTRUCTION_MAP[(instructionInt & INSTRUCTION_MASK) >>> 26]
	}

	int cycles

	BitInstruction(int cycles) {
		this.cycles = cycles
	}

	abstract void onExecute(BitCPU cpu, int s, int t, int u)

	protected abstract def extractArguments(long instruction)
}
