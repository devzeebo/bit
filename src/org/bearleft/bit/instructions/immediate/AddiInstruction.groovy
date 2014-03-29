package org.bearleft.bit.instructions.immediate

import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class AddiInstruction extends BitInstruction {

	AddiInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, def u) {
		cpu.registers[s].value = cpu.registers[t].value + u
	}
}
