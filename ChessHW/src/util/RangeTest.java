package util;

import junit.framework.TestCase;


public class RangeTest extends TestCase {
		public void testDigits() {
			Range range = new Range('1', '3');
			assertFalse(range.includes('0'));
			assertTrue(range.includes('1'));
			assertTrue(range.includes('2'));
			assertTrue(range.includes('3'));
			assertFalse(range.includes('4'));
		}
		public void testAlphabetics() {
			Range range = new Range('a', 'c');
			assertFalse(range.includes('A'));
			assertTrue(range.includes('a'));
			assertTrue(range.includes('b'));
			assertTrue(range.includes('c'));
			assertFalse(range.includes('d'));
		}
	}

