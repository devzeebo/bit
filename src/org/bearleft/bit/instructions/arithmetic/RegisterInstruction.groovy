package org.bearleft.bit.instructions.arithmetic

import org.bearleft.bit.BitInstruction

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
abstract class RegisterInstruction extends BitInstruction {

	RegisterInstruction(int cycles) {
		super(cycles)
	}

	@Override
	protected def extractArguments(long instruction) {
		int s, t, u

		s = (instruction & REGISTER_1_MASK) >> 21
		t = (instruction & REGISTER_2_MASK) >> 16
		u = (instruction & REGISTER_3_MASK) >> 11

		return [s, t, u]
	}
}
