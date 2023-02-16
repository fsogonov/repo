package lab1;

import java.util.Scanner;


public class MovieDriver {

	
	public static void main(String[] args) {
		Scanner inpt = new Scanner(System.in);
		Movie m = new Movie();
		
		
		System.out.println("Enter the name of the movie: ");
		m.setTitle(inpt.nextLine());
		System.out.println("Enter the rating of the movie: ");
		m.setRating(inpt.nextLine());
		System.out.println("Enter the number of tickets sold for the movie: ");
		m.setSoldTickets(inpt.nextInt());
		
		System.out.println("Title: '" + m.getTitle() + "', rating: " + m.getRating() + ", tickets sold: " + m.getSoldTickets());
		
		inpt.close();
	}
}
