package com.romullogirardi.huntshark.model;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser{ 
	
	//CONSTANTS
	private static final String HTML_FILE_PATH = "assets/D_LOTFAC.HTM";
	private static final String HTML_CHAR_CODE = "UTF-8";
	
	private static final int CONTEST_ID_INDEX = 0;
	private static final int CONTEST_DATE_INDEX = 1;
	private static final int CONTEST_SELECTED_NUMBER_1_INDEX = 2;	
	private static final int CONTEST_SELECTED_NUMBER_2_INDEX = 3;	
	private static final int CONTEST_SELECTED_NUMBER_3_INDEX = 4;	
	private static final int CONTEST_SELECTED_NUMBER_4_INDEX = 5;	
	private static final int CONTEST_SELECTED_NUMBER_5_INDEX = 6;	
	private static final int CONTEST_SELECTED_NUMBER_6_INDEX = 7;	
	private static final int CONTEST_SELECTED_NUMBER_7_INDEX = 8;	
	private static final int CONTEST_SELECTED_NUMBER_8_INDEX = 9;	
	private static final int CONTEST_SELECTED_NUMBER_9_INDEX = 10;	
	private static final int CONTEST_SELECTED_NUMBER_10_INDEX = 11;	
	private static final int CONTEST_SELECTED_NUMBER_11_INDEX = 12;	
	private static final int CONTEST_SELECTED_NUMBER_12_INDEX = 13;	
	private static final int CONTEST_SELECTED_NUMBER_13_INDEX = 14;	
	private static final int CONTEST_SELECTED_NUMBER_14_INDEX = 15;	
	private static final int CONTEST_SELECTED_NUMBER_15_INDEX = 16;	
	private static final int CONTEST_CITY_INDEX = 19;	
	private static final int CONTEST_STATE_INDEX = 20;	
	private static final int CONTEST_REWARD_15_POINTS_INDEX = 25;	
	private static final int CONTEST_REWARD_14_POINTS_INDEX = 26;	
	private static final int CONTEST_REWARD_13_POINTS_INDEX = 27;	
	private static final int CONTEST_REWARD_12_POINTS_INDEX = 28;	
	private static final int CONTEST_REWARD_11_POINTS_INDEX = 29;	
	
	public static final float DEFAULT_REWARD_15_POINTS = 1000000;
	public static final float DEFAULT_REWARD_14_POINTS = 1500;
	public static final float DEFAULT_REWARD_13_POINTS = 20;
	public static final float DEFAULT_REWARD_12_POINTS = 8;
	public static final float DEFAULT_REWARD_11_POINTS = 4;

	//ATTRIBUTES
	private static Document htmlFile;
	private static boolean isHtmlEnough = true;
	
	//METHODS
	private static void parseHtmlFile() {
		try { 
			htmlFile = Jsoup.parse(new File(HTML_FILE_PATH), HTML_CHAR_CODE); 
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	public static void readContestsFromHTMLFile() {
		
		//Parsing HTML file
		parseHtmlFile();

		//Reading contests from HTML file		
		Element table = htmlFile.select("table").get(0);
		Elements tableRows = table.select("tr");
		for(int rowIndex = 0; rowIndex < tableRows.size(); rowIndex++) {
			
			//Setting contest variables with default values
			int id = -1;
			Calendar date = Calendar.getInstance();
			String place = new String();
			int[] numbers = new int[20];
			float reward15points = DEFAULT_REWARD_15_POINTS;
			float reward14points = DEFAULT_REWARD_14_POINTS;
			float reward13points = DEFAULT_REWARD_13_POINTS;
			float reward12points = DEFAULT_REWARD_12_POINTS;
			float reward11points = DEFAULT_REWARD_11_POINTS;
			
			//Creating a contest by a table row
			Elements rowElements = tableRows.get(rowIndex).select("td");
			for(int columnIndex = 0; columnIndex < rowElements.size(); columnIndex++) {
				if(!rowElements.get(columnIndex).text().isEmpty()) {
					switch(columnIndex) {
						case CONTEST_ID_INDEX:
							try {
								id = Integer.parseInt(rowElements.get(columnIndex).text());
							} catch (Exception e) {
//								System.out.println("ID inválido");
							}
							break;
						case CONTEST_DATE_INDEX:
							String readDate = rowElements.get(columnIndex).text();
							if(readDate.length() == 10) {
								String dayStr = readDate.substring(0, 2);
								String monthStr = readDate.substring(3, 5);
								String yearStr = readDate.substring(6);
								try {
									int day = Integer.parseInt(dayStr);
									int month = Integer.parseInt(monthStr);
									int year = Integer.parseInt(yearStr);
									date = new GregorianCalendar(year, month - 1, day);
								} catch (Exception e) {
//									System.out.println("Data inválida");
								}
							}
							break;
						case CONTEST_SELECTED_NUMBER_1_INDEX:
							numbers[0] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_2_INDEX:
							numbers[1] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_3_INDEX:
							numbers[2] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_4_INDEX:
							numbers[3] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_5_INDEX:
							numbers[4] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_6_INDEX:
							numbers[5] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_7_INDEX:
							numbers[6] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_8_INDEX:
							numbers[7] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_9_INDEX:
							numbers[8] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_10_INDEX:
							numbers[9] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_11_INDEX:
							numbers[10] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_12_INDEX:
							numbers[11] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_13_INDEX:
							numbers[12] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_14_INDEX:
							numbers[13] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_SELECTED_NUMBER_15_INDEX:
							numbers[14] = Integer.parseInt(rowElements.get(columnIndex).text());
							break;
						case CONTEST_CITY_INDEX:
							place = rowElements.get(columnIndex).text();
							break;
						case CONTEST_STATE_INDEX:
							place += "/" + rowElements.get(columnIndex).text();
							break;
						case CONTEST_REWARD_15_POINTS_INDEX:
							String readReward15PointsStr = toFloatStringFormat(rowElements.get(columnIndex).text());
							float readReward15Points = Float.parseFloat(readReward15PointsStr);
							if(readReward15Points != 0) {
								reward15points = readReward15Points;
							}
							break;
						case CONTEST_REWARD_14_POINTS_INDEX:
							String readReward14PointsStr = toFloatStringFormat(rowElements.get(columnIndex).text());
							float readReward14Points = Float.parseFloat(readReward14PointsStr);
							if(readReward14Points != 0) {
								reward14points = readReward14Points;
							}
							break;
						case CONTEST_REWARD_13_POINTS_INDEX:
							String readReward13PointsStr = toFloatStringFormat(rowElements.get(columnIndex).text());
							float readReward13Points = Float.parseFloat(readReward13PointsStr);
							if(readReward13Points != 0) {
								reward13points = readReward13Points;
							}
							break;
						case CONTEST_REWARD_12_POINTS_INDEX:
							String readReward12PointsStr = toFloatStringFormat(rowElements.get(columnIndex).text());
							float readReward12Points = Float.parseFloat(readReward12PointsStr);
							if(readReward12Points != 0) {
								reward12points = readReward12Points;
							}
							break;
						case CONTEST_REWARD_11_POINTS_INDEX:
							String readReward111PointsStr = toFloatStringFormat(rowElements.get(columnIndex).text());
							float readReward11Points = Float.parseFloat(readReward111PointsStr);
							if(readReward11Points != 0) {
								reward11points = readReward11Points;
							}
							break;
					}
				}
			}
			
			//Adding a contest, if it´s valid
			boolean isLastContest = ((rowIndex == (tableRows.size() - 1)) && isHtmlEnough) ? true : false;
			if(id != -1) {
				ContestManager.getInstance().computeLastContest(new Contest(id, date, place, numbers, reward15points, reward14points, reward13points, reward12points, reward11points, false), isLastContest);
			}
		}
		
		//Reading additional contests, if necessary
		if(!isHtmlEnough) {
			readAdditionalContests();
		}
	}
	
	private static String toFloatStringFormat(String notFloatStringFormat) {
		String temp = notFloatStringFormat.replace(".", "");
		String floatStringFormat = temp.replace(",", ".");
		return floatStringFormat;
	}
	
	private static void readAdditionalContests() {
		int[] numbers1 = {1, 2, 3, 4, 5, 7, 8, 9, 13, 14, 18, 19, 20, 21, 23};
		ContestManager.getInstance().computeLastContest(new Contest(1214, new GregorianCalendar(2015, 4, 27), "JAPERI/RJ", numbers1, (float) 775596.57, (float) 1435.45, (float) 20, (float) 8, (float) 4, false), false);
		int[] numbers2 = {3, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 24};
		ContestManager.getInstance().computeLastContest(new Contest(1215, new GregorianCalendar(2015, 4, 29), "OSASCO/SP", numbers2, (float) 925164.99, (float) 1441.35, (float) 20, (float) 8, (float) 4, true), true);
	}
}