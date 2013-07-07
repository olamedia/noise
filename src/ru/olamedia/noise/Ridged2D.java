package ru.olamedia.noise;

public class Ridged2D implements Noise2D {
	private Noise2D source;
	private double offset = 1.0;

	public Ridged2D() {
	}

	public Ridged2D(Noise2D source) {
		setSource(source);
	}

	@Override
	public double get(double x, double y) {
		return Value.ridge(source.get(x, y), offset) * 2 - 1;
	}

	public Noise2D getSource() {
		return source;
	}

	public void setSource(Noise2D source) {
		this.source = source;
	}
}
