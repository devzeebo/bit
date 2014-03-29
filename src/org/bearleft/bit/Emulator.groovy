package org.bearleft.bit

import org.bearleft.bit.file.BitIOHelper

/**
 * User: Eric Siebeneich
 * Date: 3/29/14
 */
class Emulator {

	BitCPU cpu

	Emulator() {
		cpu = new BitCPU()
	}

	void loadFile(String file) {

		FileInputStream fis = new FileInputStream(new File(file))
		byte[] bytes = new byte[4]

		fis.read(bytes)
		fis.close()
	}

	void saveFile(String file) {

		FileOutputStream fos = new FileOutputStream(new File(file))
		byte[] bytes = new byte[4]

		int instruction = 0b001000_00000_00001_0000_0000_1000_0000
		bytes[0] = (instruction >> 24) & 0x000000FF
		bytes[1] = (instruction >> 16) & 0x000000FF
		bytes[2] = (instruction >>  8) & 0x000000FF
		bytes[3] = instruction & 0x000000FF

		fos.write(bytes)
		fos.close()
	}

	public static void main(String[] args) {

		println BitIOHelper.getInstructionBits(0b001000_00000_00001_0000_0000_1000_0000)
	}
}
