package aplications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner tec = new Scanner(System.in);
		try {
			System.out.print("Numero do quarto: ");
			int roomNumber = tec.nextInt();
			System.out.print("Data de check-In (dd/mm/aaaa): ");
			Date in = sdf.parse(tec.next());
			System.out.print("Date de check-Out (dd/mm/aaaa): ");
			Date out = sdf.parse(tec.next());
			Reservation revervation = new Reservation(roomNumber, in, out);
			System.out.println(revervation.toString());
			System.out.println("*** Update de datas ***");
			System.out.print("Data de check-In (dd/mm/aaaa): ");
			in = sdf.parse(tec.next());
			System.out.print("Date de check-Out (dd/mm/aaaa): ");
			out = sdf.parse(tec.next());
			revervation.upDateDates(in, out);
			System.out.println(revervation.toString());
		} catch (InputMismatchException e) {
			System.err.println("Erro: " + "Algo invalido digitado!!!");
		}finally {
			tec.close();
		}
	}
}
