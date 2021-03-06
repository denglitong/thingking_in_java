package test.java.com.dlt;

import main.java.com.dlt.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2020/2/8
 */
public class DynamicStringInverterTests {
	Stream<DynamicTest> testVersions(String id, Function<StringInverter, String> test) {
		List<StringInverter> versions = Arrays.asList(
				new Inverter1(), new Inverter2(), new Inverter3(), new Inverter4()
		);
		return DynamicTest.stream(
				versions.iterator(),
				inverter -> inverter.getClass().getSimpleName(),
				inverter -> {
					System.out.println(inverter.getClass().getSimpleName() + ": " + id);
					try {
						if (test.apply(inverter) != "fail") {
							System.out.println("Success");
						}
					} catch (Exception | Error e) {
						System.out.println("Exception: " + e.getMessage());
					}
				}
		);
	}

	String isEqual(String lval, String rval) {
		if (lval.equals(rval)) {
			return "success";
		}
		System.out.println("FAIL: " + lval + " != " + rval);
		return "fail";
	}

	@BeforeAll
	static void startMsg() {
		System.out.println(">>> Starting com.dlt.DynamicStringInverterTests <<<");
	}

	@AfterAll
	static void endMsg() {
		System.out.println(">>> Finished com.dlt.DynamicStringInverterTests <<<");
	}

	@TestFactory
	Stream<DynamicTest> basicInversion1() {
		String in = "Exit, Pursued by a Bear.";
		String out = "eXIT, pURSUED BY A bEAR.";
		return testVersions(
				"Basic inversion (should succeed)",
				inverter -> isEqual(inverter.invert(in), out));
	}

	@TestFactory
	Stream<DynamicTest> basicInversion2() {
		return testVersions(
				"Basic inversion (should fail)",
				inverter -> isEqual(inverter.invert("X"), "X")
		);
	}
}
