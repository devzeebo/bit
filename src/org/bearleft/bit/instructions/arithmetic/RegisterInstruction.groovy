package org.bearleft.bit.instructions.arithmetic

import org.bearleft.bit.BitAssembler
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
	protected def decodeArguments(long instruction) {
		int s, t, u

		s = (instruction & REGISTER_1_MASK) >> 21
		t = (instruction & REGISTER_2_MASK) >> 16
		u = (instruction & REGISTER_3_MASK) >> 11

		return [s, t, u]
	}

	@Override
	protected int encodeArguments(String arguments) {

		String[] split = arguments.replaceAll(/\s+/, '').split(',')

		int args = (BitAssembler.encodeRegister(split[0]) << 21) & REGISTER_1_MASK
		args |= (BitAssembler.encodeRegister(split[1]) << 16) & REGISTER_2_MASK
		args |= (BitAssembler.encodeRegister(split[2]) << 11) & REGISTER_3_MASK

		return args
	}
}
