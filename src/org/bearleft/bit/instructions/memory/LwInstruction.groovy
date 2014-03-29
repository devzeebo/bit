package org.bearleft.bit.instructions.memory
import org.bearleft.bit.BitCPU
import org.bearleft.bit.instructions.immediate.ImmediateInstruction
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class LwInstruction extends ImmediateInstruction {

	LwInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
		cpu.registers[s].value = cpu.memory.getWord((int)(cpu.registers[t] + u))
	}
}
