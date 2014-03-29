package org.bearleft.bit.instructions

import org.bearleft.bit.BitCPU
import org.bearleft.bit.BitInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class NoopInstruction extends BitInstruction {

	NoopInstruction() {
		super(1)
	}

	@Override
	void onExecute(BitCPU cpu, int s, int t, int u) {
	}

	def extractArguments(long instruction) {
		return [0, 0, 0]
	}
}
