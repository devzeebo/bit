package org.bearleft.bit

import org.bearleft.bit.io.BitIOHelper

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class Emulator {

	BitCPU cpu

	Emulator() {
		cpu = new BitCPU()
	}

	Emulator loadFile(String file) {

		byte[] buffer = new byte[10000]

		FileInputStream fis = new FileInputStream(new File(file))

		int offset = 0
		int count

		while ((count = fis.read(buffer)) != -1) {

			println count
			println BitIOHelper.getInstructionBits(BitIOHelper.readInstruction(buffer, 0)[0])

			System.arraycopy(buffer, 0, cpu.memory.bytes, offset, count)
			offset += count
		}
		return this
	}

	Emulator saveFile(String file) {

		return this
	}

	public static void main(String[] args) {

		Emulator emu = new Emulator().loadFile('sample.bit')

		emu.cpu.step()

		println emu.cpu.registers
	}
}
