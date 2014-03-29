package org.bearleft.bit.instructions.arithmetic
import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class XorInstruction extends BitInstruction {

	XorInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, def u) {
		cpu.registers[s].value = cpu.registers[s].value ^ cpu.registers[u].value
	}
}
