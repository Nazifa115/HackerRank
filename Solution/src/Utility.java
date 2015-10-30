import java.math.BigDecimal;
import java.math.RoundingMode;


public class Utility {

	public Utility() {
		
	}
	public static BigDecimal round(double d, int pos) {
		BigDecimal bd = new BigDecimal(d).setScale(pos, RoundingMode.HALF_UP);
		return bd;
	}

}
