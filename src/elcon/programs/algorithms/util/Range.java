package elcon.programs.algorithms.util;

public class Range {

	public double min;
	public double max;
	
	public Range(double min, double max) {
		this.min = Math.min(min, max);
		this.max = Math.max(min, max);
	}
	
	public boolean includes(double value) {
		return value >= min && value <= max;
	}
	
	public boolean exlucdes(double value) {
		return value < min || value > max;
	}
	
	public Range add(double value) {
		return new Range(min + value, max + value);
	}
	
	public Range subtract(double value) {
		return new Range(min - value, max - value);
	}
	
	public Range multiply(double value) {
		return new Range(min * value, max * value);
	}
	
	public Range divide(double value) {
		return new Range(min / value, max / value);
	}
	
	public void addTo(double value) {
		min += value;
		max += value;
	}
	
	public void subtractFrom(double value) {
		min -= value;
		max -= value;
	}
	
	public void multiplyBy(double value) {
		min *= value;
		max *= value;
	}
	
	public void divideBy(double value) {
		min /= value;
		max /= value;
	}
	
	public Range merge(Range range) {
		if(includes(range.min) || includes(range.max)) {
			return new Range(Math.min(min, range.min), Math.max(max, range.max));
		}
		return null;
	}
	
	public Range split(double value) {
		if(includes(value)) {
			Range range = new Range(value, max);
			max = value;
			return range;
		}
		return null;
	}
}
