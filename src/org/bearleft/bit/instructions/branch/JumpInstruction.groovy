package org.bearleft.bit.instructions.branch
import org.bearleft.bit.BitCPU
/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class JumpInstruction extends BranchInstruction {

	JumpInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, def u) {
		branch(true, cpu, u)
	}
}