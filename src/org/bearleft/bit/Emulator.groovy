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

	int[] program = [
		0b001000_00001_00000_0000000010000000,
		0b000001_00001_00001_00001_00000000000,
		0b011101_00000_00000_0000_0000_0000_0000,
	]

	Emulator saveFile(String file) {

		FileOutputStream fos = new FileOutputStream(new File(file))
		byte[] bytes = new byte[program.length * 4]

		int idx = 0
		int offset = 0

		while(idx < program.length) {
			offset = BitIOHelper.writeInstruction(bytes, offset, program[idx++])
		}

		fos.write(bytes)
		fos.close()

		return this
	}

	public static void main(String[] args) {

		Emulator emu = new Emulator().saveFile('sample.bit')
		emu.loadFile('sample.bit')

		for (int x = 0; x < 9; x++) {
			emu.cpu.step()
		}

		long startTime = System.currentTimeMillis()
		float steps = 0

		while(steps < 10000) {
			emu.cpu.step()
			steps += 1
		}

		println ((System.currentTimeMillis() - startTime) / steps)
	}
}
