package ru.olamedia.noise;

public class Turbulence2D implements Noise2D {
	private Noise2D source;
	private double amplitude = 1.0;

	public Turbulence2D() {
	}

	public Turbulence2D(Noise2D source) {
		setSource(source);
	}

	public Noise2D getSource() {
		return source;
	}

	public void setSource(Noise2D source) {
		this.source = source;
	}

	@Override
	public double get(double x, double y) {
		return source.get(x + source.get(x, y) * amplitude, y + source.get(x, y) * amplitude);
	}

	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
}
