import java.util.ArrayList;
import java.util.Random;

public enum Unit {

	// null Unit
	NULL_UNIT(-1, Double.NaN),

	// 1 : length
	MILLIMETER(Unit.LENGTH, pow(10, -3)), CENTIMETER(Unit.LENGTH, pow(10, -2)), DECIMETER(Unit.LENGTH, pow(10, -1)),
	METER(Unit.LENGTH, 1), DEKAMETER(Unit.LENGTH, pow(10, 1)), HECTOMETER(Unit.LENGTH, pow(10, 2)),
	KILOMETER(Unit.LENGTH, pow(10, 3)), INCH(Unit.LENGTH, CENTIMETER.value * 2.54), FOOT(Unit.LENGTH, INCH.value * 12),
	YARD(Unit.LENGTH, FOOT.value * 3), MILE(Unit.LENGTH, FOOT.value * 5280),
	NAUTICAL_MILE(Unit.LENGTH, METER.value * 1852), ROD(Unit.LENGTH, FOOT.value * 16.5),

	// 2 : time
	MILLISECOND(Unit.TIME, pow(10, -3)), SECOND(Unit.TIME, 1), MINUTE(Unit.TIME, 60), HOUR(Unit.TIME, 3600),
	DAY(Unit.TIME, 3600 * 24), WEEK(Unit.TIME, 3600 * 24 * 7),

	// 3 : weight
	MILLIGRAM(Unit.WEIGHT, pow(10, -3)), CENTIGRAM(Unit.WEIGHT, pow(10, -2)), DECIGRAM(Unit.WEIGHT, pow(10, -1)),
	GRAM(Unit.WEIGHT, 1), DEKAGRAM(Unit.WEIGHT, pow(10, 1)), HECTOGRAM(Unit.WEIGHT, pow(10, 2)),
	KILOGRAM(Unit.WEIGHT, pow(10, 3)), METRIC_TON(Unit.WEIGHT, KILOGRAM.value * 1000), POUND(Unit.WEIGHT, 453.59237),
	STONE(Unit.WEIGHT, POUND.value * 14), OUNCE(Unit.WEIGHT, POUND.value / 16), TON(Unit.WEIGHT, POUND.value * 2000),
	LONG_TON(Unit.WEIGHT, POUND.value * 2240),

	// 4 : area
	SQUARE_METER(Unit.AREA, 1), SQUARE_DECIMETER(Unit.AREA, pow(10, -2)), SQUARE_CENTIMETER(Unit.AREA, pow(10, -4)),
	SQUARE_MILLIMETER(Unit.AREA, pow(10, -6)), SQUARE_DEKAMETER(Unit.AREA, pow(10, 2)),
	SQUARE_HECTOMETER(Unit.AREA, pow(10, 4)), SQUARE_KILOMETER(Unit.AREA, pow(10, 6)),
	SQUARE_INCH(Unit.AREA, pow(INCH.value, 2) / 10000), SQUARE_FOOT(Unit.AREA, SQUARE_INCH.value * 144),
	SQUARE_YARD(Unit.AREA, SQUARE_FOOT.value * 9), ACRE(Unit.AREA, 6272646 * SQUARE_INCH.value),
	SQUARE_MILE(Unit.AREA, 640 * ACRE.value),

	// 5 : volume
	CUBIC_METER(Unit.VOLUME, 1), CUBIC_DECIMETER(Unit.VOLUME, pow(10, -3)), CUBIC_CENTIMETER(Unit.VOLUME, pow(10, -6)),
	CUBIC_MILLIMETER(Unit.VOLUME, pow(10, -9)), CUBIC_DEKAMETER(Unit.VOLUME, pow(10, 3)),
	CUBIC_HECTOMETER(Unit.VOLUME, pow(10, 6)), CUBIC_KILOMETER(Unit.VOLUME, pow(10, 9)),
	CUBIC_INCH(Unit.VOLUME, pow(INCH.value, 3) / 1000000), CUBIC_FOOT(Unit.VOLUME, CUBIC_INCH.value * 1728),
	CUBIC_YARD(Unit.VOLUME, CUBIC_FOOT.value * 27), LITER(Unit.VOLUME, 1), PECK(Unit.VOLUME, 0.0088097676),
	BUSHEL(Unit.VOLUME, 4 * PECK.value), GALLON(Unit.VOLUME, CUBIC_INCH.value * 231),
	QUART(Unit.VOLUME, GALLON.value / 4), PINT(Unit.VOLUME, QUART.value / 2), CUP(Unit.VOLUME, PINT.value / 2),
	FLUID_OUNCE(Unit.VOLUME, CUP.value / 8),

	// 6 : speed
	INCH_SEC(Unit.SPEED, 1), INCH_MIN(Unit.SPEED, INCH_SEC.value / 60), FT_SEC(Unit.SPEED, INCH_SEC.value * 12),
	FT_MIN(Unit.SPEED, FT_SEC.value / 60), FT_HR(Unit.SPEED, FT_MIN.value / 60), MI_HR(Unit.SPEED, FT_HR.value * 5280),

	;

	public static final int LENGTH = 1, TIME = 2, WEIGHT = 3, AREA = 4, VOLUME = 5, SPEED = 6;

	private final int type; // 1 is length, 2 is time, 3 is weight, 4 is area, 5 is volume, 6 is speed
	private final double value;

	private Unit(int type, double value) {
		this.type = type;
		this.value = value;
	}

	private static double pow(double base, double exp) {
		return Math.pow(base, exp);
	}

	// NOTE: precision won't be completely accurate when using very large or small
	// numbers, but I don't think that a number sense test will call for something
	// of the order 10^-15 or 10^15
	public static double convert(double input, Unit inputUnit, Unit outputUnit) {
		if (inputUnit.type != outputUnit.type) {
			System.out.println(inputUnit.toString() + " is not of the same type as " + outputUnit.toString());
			return Double.NaN;
		} else {
			return (input * inputUnit.value) / (outputUnit.value);
		}
	}

	private final static ArrayList<Unit> LENGTH_UNITS = new ArrayList<>();
	private final static ArrayList<Unit> TIME_UNITS = new ArrayList<>();
	private final static ArrayList<Unit> WEIGHT_UNITS = new ArrayList<>();
	private final static ArrayList<Unit> AREA_UNITS = new ArrayList<>();
	private final static ArrayList<Unit> VOLUME_UNITS = new ArrayList<>();
	private final static ArrayList<Unit> SPEED_UNITS = new ArrayList<>();

	public static void init() {
		LENGTH_UNITS.clear();
		TIME_UNITS.clear();
		WEIGHT_UNITS.clear();
		AREA_UNITS.clear();
		VOLUME_UNITS.clear();
		SPEED_UNITS.clear();
		for (Unit unit : values()) {
			switch (unit.type) {
			case 1:
				LENGTH_UNITS.add(unit);
				break;
			case 2:
				TIME_UNITS.add(unit);
				break;
			case 3:
				WEIGHT_UNITS.add(unit);
				break;
			case 4:
				AREA_UNITS.add(unit);
				break;
			case 5:
				VOLUME_UNITS.add(unit);
				break;
			case 6:
				SPEED_UNITS.add(unit);
				break;
			}
		}
	}

	public static Unit getRandomUnit(int type) {
		switch (type) {
		case 1:
			return getRandomUnitFromList(LENGTH_UNITS);
		case 2:
			return getRandomUnitFromList(TIME_UNITS);
		case 3:
			return getRandomUnitFromList(WEIGHT_UNITS);
		case 4:
			return getRandomUnitFromList(AREA_UNITS);
		case 5:
			return getRandomUnitFromList(VOLUME_UNITS);
		case 6:
			return getRandomUnitFromList(SPEED_UNITS);
		default:
			System.out.println("Invalid type value: " + type);
			return NULL_UNIT;
		}
	}

	private static final Random random = new Random();

	private static Unit getRandomUnitFromList(ArrayList<Unit> list) {
		return list.get(random.nextInt(list.size()));
	}

	public static Object[] getProblem() {
		int type = getRandomType();
		String ans = "";
		double dAns = 0;
		Unit from;
		Unit to;
		int input = random.nextInt(5) * random.nextInt(4) + 1 + random.nextInt(10);
		do {
			from = getRandomUnit(type);
			do {
				to = getRandomUnit(type);
			} while (to == from);
			dAns = convert(input, from, to);
			ans = dAns + "";
		} while (ans.length() > 6 || ans.indexOf('E') > -1);
		Object[] problem = new Object[] { input, from, to };
		return problem;
	}

	private static int getRandomType() {
		return random.nextInt(6) + 1;
	}

	public String getName() {
		return toString().toLowerCase().replace("_", (type == SPEED) ? "/" : " ");
	}
}
