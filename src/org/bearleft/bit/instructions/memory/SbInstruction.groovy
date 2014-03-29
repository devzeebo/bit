package org.bearleft.bit.instructions.memory

import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class SbInstruction extends BitInstruction {

	SbInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, def u) {
		cpu.memory.storeByte((int)(cpu.registers[t] + u), cpu.registers[s].value)
	}
}
