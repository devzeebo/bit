package org.bearleft.bit.instructions.branch

import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
abstract class BranchInstruction extends BitInstruction {

	BranchInstruction(int cycles) {
		super(cycles)
	}

	protected static final void branch(boolean cond, BitCPU cpu, def u) {
		if (cond) {
			cpu.JR.value = cpu.PC + 4
			cpu.PC.value = u
		}
	}
}
