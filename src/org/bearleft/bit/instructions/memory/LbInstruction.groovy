package org.bearleft.bit.instructions.memory

import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class LbInstruction extends BitInstruction {

	LbInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, def u) {
		cpu.registers[s].value = cpu.memory.getByte((int)(cpu.registers[t] + u))
	}
}
