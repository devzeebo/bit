package org.bearleft.bit.instructions.memory
import org.bearleft.bit.BitCPU
import org.bearleft.bit.instructions.immediate.ImmediateInstruction
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class LbInstruction extends ImmediateInstruction {

	LbInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
		cpu.registers[s].value = cpu.memory.getByte((int)(cpu.registers[t] + u))
	}
}
