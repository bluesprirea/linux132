package util;

import junit.framework.TestCase;
import util.StringUtil;
public class StringUtilTest extends TestCase{
	public void testAppendLineEnd() {
		String input = "abc";
		assertEquals(input + StringUtil.NEWLINE, StringUtil.appendNewLine(input));
	}
}
