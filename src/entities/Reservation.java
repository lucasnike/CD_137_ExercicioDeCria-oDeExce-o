package entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import exceptions.*;
public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date chackOut;
	public Reservation() {}
	public Reservation(Integer roomNumber, Date checkIn, Date chackOut) throws MyWrongArgumentsException {
		if (this.checkIn.after(chackOut)) {
			throw new MyWrongArgumentsException("Erro na reserva: A data de Check-Out deve ser depois da de check-In");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.chackOut = chackOut;	
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
	public Date getChackOut() {
		return chackOut;
	}
	public Integer duration() {
		long diff = chackOut.getTime() - checkIn.getTime();
		Integer ultimo = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return ultimo;
	}
	public void upDateDates(Date in, Date out) throws MyWrongArgumentsException{
		if (in.before(new Date())) {
			throw new MyWrongArgumentsException("Erro na reserva: A alteração só pode ser para datas futuras");
		}
		if (in.after(out)) {
			throw new MyWrongArgumentsException("Erro na reserva: A data de Check-Out deve ser depois da de check in");
		}
		this.checkIn = in;
		this.chackOut = out;
	}
	@Override
	public String toString() {
		return "Reservation: Room " + getRoomNumber() + ", Check-In " + sdf.format(checkIn) + ", "
				+ "Check-Out " + sdf.format(chackOut) + ", Duration " + duration() + " noites";
	}
}