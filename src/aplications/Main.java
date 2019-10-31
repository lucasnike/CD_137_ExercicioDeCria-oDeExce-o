package aplications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import exceptions.MyWrongArgumentsException;

public class Main {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
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
			System.out.println(revervation);
			System.out.println("*** Update de datas ***");
			System.out.print("Data de check-In (dd/mm/aaaa): ");
			in = sdf.parse(tec.next());
			System.out.print("Date de check-Out (dd/mm/aaaa): ");
			out = sdf.parse(tec.next());
			revervation.upDateDates(in, out);
			System.out.println(revervation);
		}catch (InputMismatchException e) {
			System.err.println("Erro: " + "Algo invalido digitado!!!");
		}catch(ParseException e) {
			System.err.println(e.getMessage());
		}catch(MyWrongArgumentsException e) {
			System.out.println(e.getMessage());
		}catch(RuntimeException e) {
			System.err.println("Um erro inesperado ocorreu!!!");
		}
		finally {
			tec.close();
		}
	}
}
