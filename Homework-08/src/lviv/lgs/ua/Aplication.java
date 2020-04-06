package lviv.lgs.ua;

import java.util.Scanner;

public class Aplication {

	public enum Seasons {
		WINTER, SPRING, SUMMER, AUTUMN
	}

	public enum Months {
		JANUARY(Seasons.WINTER, 31), FEBRUARY(Seasons.WINTER, 28), MARCH(Seasons.SPRING, 31), APRIL(Seasons.SPRING, 30),
		MAY(Seasons.SPRING, 31), JUNE(Seasons.SUMMER, 30), JULY(Seasons.SUMMER, 31), AUGUST(Seasons.SUMMER, 31),
		SEPTEMBER(Seasons.AUTUMN, 30), OCTOBER(Seasons.AUTUMN, 31), NOVEMBER(Seasons.AUTUMN, 30),
		DECEMBER(Seasons.WINTER, 31);

		private Seasons season;
		private int day;

		Months(Seasons season, int day) {
			this.season = season;
			this.day = day;
		}

		public Seasons getSeason() {
			return season;
		}

		public int getDay() {
			return day;
		}

	}

	static void menu() {
		System.out.println("¬вед≥ть 1, щоб перев≥рити чи Ї такий м≥с€ць");
		System.out.println("¬вед≥ть 2, щоб вивести вс≥ м≥с€ц≥ з такою ж порою року");
		System.out.println("¬вед≥ть 3, щоб вивести вс≥ м≥с€ц≥ €к≥ мають таку саму к≥льк≥сть дн≥в");
		System.out.println("¬вед≥ть 4, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають меншу к≥льк≥сть дн≥в");
		System.out.println("¬вед≥ть 5, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають б≥льшу к≥льк≥сть дн≥в");
		System.out.println("¬вед≥ть 6, щоб вивести на екран наступну пору року");
		System.out.println("¬вед≥ть 7, щоб вивести на екран попередню пору року");
		System.out.println("¬вед≥ть 8, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають парну к≥льк≥сть дн≥в");
		System.out.println("¬вед≥ть 9, щоб вивести на екран вс≥ м≥с€ц≥ €к≥ мають непарну к≥льк≥сть дн≥в");
		System.out.println("¬вед≥ть 10, щоб вивести на екран чи введений з консол≥ м≥с€ць маЇ парну к≥льк≥сть дн≥в");

	}

	static boolean isMonth(String str) {
		boolean isMonth = false;
		for (Months month : Months.values()) {
			if (str.equalsIgnoreCase(month.name())) {
				isMonth = true;
				break;
			}
		}
		return isMonth;

	}

	static boolean isSeason(String str) {
		boolean isSeason = false;
		for (Seasons seasons : Seasons.values()) {
			if (str.equalsIgnoreCase(seasons.name())) {
				isSeason = true;
				break;
			}
		}
		return isSeason;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;

		Months[] months = Months.values();

		while (true) {
			menu();
			str = scanner.nextLine();
			switch (str) {
			case "1": {
				System.out.println("Please enter a month: ");
				str = scanner.nextLine();

				if (isMonth(str))
					System.out.println("Such a month exists");
				else
					System.out.println("There isn't such a month");

				System.out.println(" ");
				break;
			}
			case "2": {
				System.out.println("Please enter a season: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					for (Months month : Months.values()) {
						if (month.getSeason().name().equalsIgnoreCase(str))
							System.out.println(month);
					}
				} else
					System.out.println("There isn't such a season");
				System.out.println(" ");
				break;
			}
			case "3": {
				System.out.println("Please enter a month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Month with equals days: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() == month.getDay())
							System.out.println(m);
					}
				} else
					System.out.println("There isn't such a month");
				System.out.println(" ");
				break;
			}
			case "4": {
				System.out.println("Please enter a month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Months that have fewer days: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() < month.getDay())
							System.out.println(m);
					}
				} else
					System.out.println("There isn't such month");
				System.out.println(" ");
				break;
			}
			case "5": {
				System.out.println("Please enter a month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					System.out.println("Months that have more days: ");
					Months month = Months.valueOf(str.toUpperCase());
					for (Months m : Months.values()) {
						if (m.getDay() > month.getDay())
							System.out.println(m);
					}
				} else
					System.out.println("There isn't such a month");
				System.out.println(" ");
				break;
			}
			case "6": {
				System.out.println("Please enter a month: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					System.out.println(Seasons.values()[(Seasons.valueOf(str.toUpperCase()).ordinal() + 1) % 4]);
				} else
					System.out.println("There isn't such a season");
				System.out.println(" ");
				break;
			}
			case "7": {
				System.out.println("Please enter a season: ");
				str = scanner.nextLine();

				if (isSeason(str)) {
					int ord = Seasons.valueOf(str.toUpperCase()).ordinal() - 1;
					System.out.println(Seasons.values()[ord < 0 ? 3 : ord]);
				} else
					System.out.println("There isn't such a season");
				System.out.println(" ");
				break;
			}
			case "8": {
				for (Months month : months) {
					if (month.getDay() % 2 == 0)
						System.out.println(month);

				}
				System.out.println(" ");
				break;
			}
			case "9": {
				for (Months month : months) {
					if (month.getDay() % 2 != 0)
						System.out.println(month);

				}
				System.out.println(" ");
				break;
			}
			case "10": {
				System.out.println("Please enter a month: ");
				str = scanner.nextLine();

				if (isMonth(str)) {
					Months month = Months.valueOf(str.toUpperCase());
					if (month.getDay() % 2 == 0)
						System.out.println("Your month has an even number of days");
					else
						System.out.println("Your month has an odd number of days");

				} else
					System.out.println("There isn't such a month");
				System.out.println(" ");
				break;
			}
			}

		}

	}
}
