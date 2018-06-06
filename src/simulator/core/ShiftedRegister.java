package simulator.core;

public class ShiftedRegister implements Operand2 {

	private Register register;
	private Operand2 controlRegister;
	private Shift shift;

	public int getValue() {
		int value = this.register.getValue();
		switch(this.shift) {
			case LSL:
				value = value << this.controlRegister.getValue();
				break;
			case LSR:
				value = value >> this.controlRegister.getValue();
				break;
		}
		return value;
	}

	public boolean getCarry() {
		return true;
	}

	public ShiftedRegister(Register register, Shift shift, Operand2 controlRegister) {
		this.register = register;
		this.shift = shift;
		this.controlRegister = controlRegister;
	}

}
