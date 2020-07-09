package de.uulm.sp.pvs.pnbk.main;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Interval {
	final private int start;
	final private int end;
	final private int stepSize;
	private Integer iterator;

	/**
	 * (10,20,0) invalid
	 * 
	 * (20,20,0) valid
	 * 
	 * (10,20,-1) invalid
	 * 
	 * (20,10,-1) invalid
	 * 
	 * @param intervalString string with the pattern (#,#,#)
	 * @throws IllegalArgumentException string does not match the pattern or has bad
	 *                                  numbers
	 */
	public Interval(String intervalString) throws IllegalArgumentException {
		final var pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+\\))");
		final var matcher = pattern.matcher(intervalString);
		if (!matcher.find()) {
			throw new IllegalArgumentException("Interval doesnt match (#,#,#)");
		}

		this.start = Integer.parseInt(matcher.group(1));
		this.end = Integer.parseInt(matcher.group(2));
		this.stepSize = Integer.parseInt(matcher.group(3));

		if (0 > stepSize) {
			throw new IllegalArgumentException("Step size must not be smaller than 0");
		}
		if ((0 == stepSize) && (start != end)) {
			throw new IllegalArgumentException("Step size must not be 0");
		}

		resetIterator();
	}

	/**
	 * Initiates or resets the Iterator. iterateNext() will then return the first
	 * value.
	 */
	final public void resetIterator() {
		iterator = start - stepSize;
	}

	/**
	 * 
	 * @return Next found integer or Null
	 */
	final public Integer iterateNext() {
		if (null == iterator) {
			return null;
		}
		iterator += stepSize;
		if (end < iterator) {
			iterator = null;
		}
		return iterator;
	}

	final public SortedSet<Integer> getAllSteps() {
		final var out = new TreeSet<Integer>();
		out.add(this.start);
		for (int i = this.start + this.stepSize; i < this.end; i += this.stepSize) {
			out.add(i);
		}
		return out;
	}

	@Override
	final public String toString() {
		return String.format("(%d,%d,%d)", start, end, stepSize);
	}

}
