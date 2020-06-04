package org.springframework.samples.oculusdb.administrator;

import java.io.*;
import java.util.*;

public class ReviewRating {

	public static void main(String[] args) {

		getPositiveAdjetivesOfText(
				"A really fun and probably overlooked rhythm-action game! It's more challenging than Beat Saber, Audica and Pistol Whip, especially in the sense that you need to move around quite a bit more, but the easy difficulty will ease anyone into the play style efficiently enough. I kinda love the campaign storyline; it gives you a little bit more of a reason to play than just working your way through a track list and perfecting your scores on indvidual songs.\n"
						+ "\n"
						+ "There aren't any licensed songs but the composer (or composers?) has done a really good job of creating great-sounding original tracks that span multiple EDM genres. I also really like the idea of each in-game character you compete against loosely representing a genre/style. Oh, and there's an option to add custom songs, which I haven't tried yet but will no doubt cater to anyone who'd like to use tracks from their own library.");

		getNegativeAdjetivesOfText(
				"A really fun and probably overlooked rhythm-action game! It's more challenging than Beat Saber, Audica and Pistol Whip, especially in the sense that you need to move around quite a bit more, but the easy difficulty will ease anyone into the play style efficiently enough. I kinda love the campaign storyline; it gives you a little bit more of a reason to play than just working your way through a track list and perfecting your scores on indvidual songs.\n"
						+ "\n"
						+ "There aren't any licensed songs but the composer (or composers?) has done a really good job of creating great-sounding original tracks that span multiple EDM genres. I also really like the idea of each in-game character you compete against loosely representing a genre/style. Oh, and there's an option to add custom songs, which I haven't tried yet but will no doubt cater to anyone who'd like to use tracks from their own library.");

	}

	private static Map<String, Integer> getPositiveAdjetivesOfText(String paragraph) {

		File positiveFile = new File("src/main/resources/tempFiles/positiveWords.txt");

		ArrayList<String> positiveWordList = new ArrayList<>();
		try {

			BufferedReader br = new BufferedReader(new FileReader(positiveFile));
			String st;
			while (br.readLine() != null) {
				st = br.readLine();
				positiveWordList.add(st);
			}

		}
		catch (FileNotFoundException e) {
		}
		catch (IOException e) {
		}

		Map<String, Integer> positiveOccurrences = new HashMap<>();

		String[] splittedWords = paragraph.split(" ");

		for (String word : splittedWords) {
			if (positiveWordList.contains(word)) {
				Integer poldCount = positiveOccurrences.get(word);
				if (poldCount == null) {
					poldCount = 0;
				}
				positiveOccurrences.put(word, poldCount + 1);
			}
		}
		return positiveOccurrences;
	}

	private static Map<String, Integer> getNegativeAdjetivesOfText(String paragraph) {

		File negativeFile = new File("src/main/resources/tempFiles/negativeWords.txt");

		ArrayList<String> negativeWordList = new ArrayList<>();

		try {
			BufferedReader br2 = new BufferedReader(new FileReader(negativeFile));
			String st2;
			while (br2.readLine() != null) {
				st2 = br2.readLine();
				negativeWordList.add(st2);
			}
		}
		catch (IOException e) {
		}

		Map<String, Integer> negativeOccurrences = new HashMap<>();

		String[] splittedWords = paragraph.split(" ");

		for (String word : splittedWords) {
			if (negativeWordList.contains(word)) {
				Integer noldCount = negativeOccurrences.get(word);
				if (noldCount == null) {
					noldCount = 0;
				}
				negativeOccurrences.put(word, noldCount + 1);
			}
		}
		return negativeOccurrences;
	}

}
