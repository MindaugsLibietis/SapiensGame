package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class theGame {

	public static void main(String[] args) {
		SpringApplication.run(theGame.class, args);
		Scanner sc = new Scanner(System.in);
		List<Integer> secretNum = new ArrayList<>();
		List<Integer> inputs = new ArrayList<>();
		System.out.println("Enter your Name: ");
		String playerName = sc.nextLine();
		System.out.println(playerName);
		//izveidoju listi ar 10 skaitliem
		for (int i = 0; i < 10; i++) {
			secretNum.add(i);
		}
		//skaitlus mainam ar vietam un izdzesam liekos
		Collections.shuffle(secretNum);
		secretNum.remove(9);
		secretNum.remove(8);
		secretNum.remove(7);
		secretNum.remove(6);
		secretNum.remove(5);
		secretNum.remove(4);
		System.out.println("random skaitli.." + secretNum);
		System.out.println("Ievadiet cetru ciparu skaitli: ");
		int x = 0;
		boolean won = false;
		List<Attempt> attempts = new ArrayList<>();
		do {
			int guess = sc.nextInt();
			//izveido vardus no lietotaja skaitliem !!0 nereģistrējas, kā pirmais skaitlis
			String numberString = Integer.toString(guess);
			for (int i = 0; i < numberString.length(); i++) {
				char c = numberString.charAt(i);
				inputs.add(Character.getNumericValue(c));
			}

			int m = 0, p = 0;
			//pārbaudam vai skaitļi ir vienādi un atrodas konkrētajā pozīcijā
			for (int i = 0; i < secretNum.size(); i++) {
				if (secretNum.get(i).equals(inputs.get(i))) {
					p++;
					if (p == 4) {
						System.out.println("Congrats, you won");
						won = true;
						break;
					}
				}
			}

			for (int i = 0; i < secretNum.size(); i++) {
				for (int j = 0; j < inputs.size(); j++) {
					if (i == j) {
						continue;
					} else if (secretNum.get(i).equals(inputs.get(j))) {
						m++;
					}
				}
			}
			System.out.println("p = " + p + " m = " + m);
			x++;
			Attempt attempt = new Attempt(m,p,inputs);
			attempts.add(attempt);
			m=0;
			p=0;
			inputs.removeAll(inputs);
		}
		while (x < 8 || won);
		System.out.println("ievades skaitli" + inputs);
		System.out.println("random skaitli.." + secretNum);
	}
}
