package com.coding.exercise;

import java.io.IOException;
import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.coding.exercise.component.WinningNumberGenerator;
import com.coding.exercise.component.UtilityGenerator;
import com.coding.exercise.domain.Bet;
import com.coding.exercise.domain.Draw;
import com.coding.exercise.domain.Person;
import com.coding.exercise.domain.Prize;
import com.coding.exercise.domain.Ticket;
import com.coding.exercise.repository.BetRepository;
import com.coding.exercise.repository.DrawRepository;
import com.coding.exercise.repository.PersonRepository;
import com.coding.exercise.repository.TicketRepository;
import com.coding.exercise.service.DrawMethods;
import com.coding.exercise.service.PrizeMethods;

@Configuration
@EnableAutoConfiguration
@ComponentScan(
	basePackages = "com.coding.exercise.service")
@EntityScan(basePackages = "com.coding.exercise.domain")
public class Sweepstakes {
	
	public static void main(String... args) throws IOException, InterruptedException {
		SpringApplication.run(Sweepstakes.class, args);
		
//		Calendar calendar = Calendar.getInstance();
//		
//		calendar.setWeekDate(2009, 12, Calendar.SATURDAY);
//		System.out.println(calendar.getTime());
//		System.out.println(calendar.getFirstDayOfWeek());
//		System.out.println(calendar.getWeekYear());
//		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
		
	}

	@Bean
	public CommandLineRunner run(
		DrawMethods drawMethods,
		PrizeMethods prizeMethods,
		BetRepository betRepo,
		PersonRepository personRepo,
		TicketRepository ticketRepo) {
		return args -> {
				System.out.println("Generate sample....");
				System.out.println("Generate bettors....");
				
				Person p1 = new Person();
				p1.setId(1);
				p1.setfName("Charlie");
				p1.setmInitial("V");
				p1.setlName("Rose");
				p1.setRegisteredAddress("Mercury");
				p1.setBirthDate(Date.valueOf("1985-04-01"));
				
				Person p2 = new Person();
				p2.setId(2);
				p2.setfName("Agatha");
				p2.setmInitial("D");
				p2.setlName("Flemming");
				p2.setRegisteredAddress("Venus");
				p2.setBirthDate(Date.valueOf("1990-12-09"));
				
				Person p3 = new Person();
				p3.setId(3);
				p3.setfName("Kerwin");
				p3.setmInitial("P");
				p3.setlName("Woorlak");
				p3.setRegisteredAddress("Earth");
				p3.setBirthDate(Date.valueOf("1979-05-03"));
				
				Ticket t1 = new Ticket();
				t1.setId(1);
				t1.setRegisteredDate(Date.valueOf("2021-03-20"));
				
				Ticket t2 = new Ticket();
				t2.setId(2);
				t2.setRegisteredDate(Date.valueOf("2021-03-20"));
				
				Ticket t3 = new Ticket();
				t3.setId(3);
				t3.setRegisteredDate(Date.valueOf("2021-03-20"));
				
				Prize pz1 = prizeMethods.createNonPersistingPrize(1, "PHP 100,000,000", "Money sample!!");
				Prize pz2 = prizeMethods.createNonPersistingPrize(2, "PHP 50,000,000", "Money sample!!");
				
				Bet b1 = new Bet();
				b1.setId(1);
				b1.setPerson(p1);
				b1.setRegisteredNumberCombination(UtilityGenerator.generateNumberCombination(50));
				b1.setTicket(t1);
				b1.setBetDate(Date.valueOf("2020-11-01"));
				
				Bet b2 = new Bet();
				b2.setId(2);
				b2.setPerson(p2);
				b2.setRegisteredNumberCombination(UtilityGenerator.generateNumberCombination(50));
				b2.setTicket(t2);
				b2.setBetDate(Date.valueOf("2020-11-01"));
				
				Bet b3 = new Bet();
				b3.setId(3);
				b3.setPerson(p3);
				b3.setRegisteredNumberCombination(UtilityGenerator.generateNumberCombination(50));
				b3.setTicket(t3);
				b3.setBetDate(Date.valueOf("2020-11-01"));
				
				System.out.println("2 Draws for the 2 prizes");
				Draw d1 = drawMethods.generateNonPersistentWinner(1, b1, pz1);
				Draw d2 = drawMethods.generatePersistentWinner(2, b3, pz2);
				
				System.out.println("Only 1 has grab his/her prize");
				drawMethods.grabPrize(d1);
		};
	}
}
