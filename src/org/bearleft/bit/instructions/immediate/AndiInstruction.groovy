package org.bearleft.bit.instructions.immediate
import org.bearleft.bit.BitCPU
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class AndiInstruction extends ImmediateInstruction {

	AndiInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
		cpu.registers[s].value = cpu.registers[t].value & u
	}
}
