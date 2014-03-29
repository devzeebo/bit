package org.bearleft.bit.instructions.arithmetic
import org.bearleft.bit.BitCPU
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class XorInstruction extends RegisterInstruction {

	XorInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
		cpu.registers[s].value = cpu.registers[s].value ^ cpu.registers[u].value
	}
}
