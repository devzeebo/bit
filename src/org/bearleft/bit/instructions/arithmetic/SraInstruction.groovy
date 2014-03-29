package org.bearleft.bit.instructions.arithmetic
import org.bearleft.bit.BitCPU
import org.bearleft.bit.instructions.immediate.ImmediateInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class SraInstruction extends ImmediateInstruction {

	SraInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
		cpu.registers[s].value = cpu.registers[t].value >> u
	}
}
