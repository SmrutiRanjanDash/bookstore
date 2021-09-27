package dubai.digital.utils;

public enum BookTypeEnum {

	FICTION(10), COMIC(0), OTHERS(5), SCIENCE(3), DEFAULT(0);

	private final double discountRate;

	BookTypeEnum(final double discountRate) {
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public static BookTypeEnum lookup(String name) {
		try {
			return BookTypeEnum.valueOf(name);
		} catch (Exception ex) {
			return DEFAULT;
		}
	}
}