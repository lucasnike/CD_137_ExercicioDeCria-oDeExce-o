package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reservation {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date chackOut;
	
	public Reservation() {}
	
	public Reservation(Integer roomNumber, Date checkIn, Date chackOut) {
		super();
		this.roomNumber = roomNumber;
		
		this.checkIn = checkIn;
		this.chackOut = chackOut;
		
		if (this.checkIn.after(chackOut)) {
			System.err.println("Erro na reserva: A data de Check-Out deve ser depois da de check in");
			System.exit(0);
		}
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getChackOut() {
		return chackOut;
	}

	public void setChackOut(Date chackOut) {
		this.chackOut = chackOut;
	}
	
	public int duration(Date checkIn, Date CheckOut) {
		int in, out;
		Calendar cal = Calendar.getInstance();
		cal.setTime(checkIn);
		in = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(CheckOut);
		out = cal.get(Calendar.DAY_OF_MONTH);
		int day = out - in;
		return day;
	}
	
	public void upDateDates(Date in, Date out) {
		if (in.before(checkIn)) {
			System.err.println("Erro na reserva: A alteração só pode ser para datas futuras");
			System.exit(0);
		}else if (in.after(checkIn)){
			if (in.after(out)) {
				System.err.println("Erro na reserva: A data de Check-Out deve ser depois da de check in");
				System.exit(0);
			}else if(in.before(out)){
				setCheckIn(in);
				setChackOut(out);
				toString();
			}
		}
	}

	@Override
	public String toString() {
		return "Reservation: Room " + getRoomNumber() + ", Check-In " + sdf.format(checkIn) + ", "
				+ "Check-Out " + sdf.format(chackOut) + ", Duration " + duration(checkIn, chackOut);
	}
	
}
