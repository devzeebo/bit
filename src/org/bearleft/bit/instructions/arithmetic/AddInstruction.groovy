package org.bearleft.bit.instructions.arithmetic
import org.bearleft.bit.BitCPU
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class AddInstruction extends RegisterInstruction {

	AddInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
		[s, t, u].each {
			println "$it: ${cpu.registers[it]}"
		}
		cpu.registers[s].value = cpu.registers[t].value + cpu.registers[u].value
	}
}
