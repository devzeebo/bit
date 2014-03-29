package org.bearleft.bit.instructions.arithmetic

import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction
import org.bearleft.bit.Register

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class OrInstruction extends BitInstruction {

	OrInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, def u) {
		cpu.registers[s].value = cpu.registers[s].value | cpu.registers[u].value
	}
}
