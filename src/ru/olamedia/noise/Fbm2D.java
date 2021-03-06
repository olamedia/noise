package ru.olamedia.noise;

public class Fbm2D implements Noise2D {
	public static final double DEFAULT_LACUNARITY = 2.0;
	public static final double DEFAULT_GAIN = 0.5;
	private Noise2D source;

	private int octaves = 1;
	private double lacunarity = DEFAULT_LACUNARITY;
	private double gain = DEFAULT_GAIN;
	private double frequency = 1; // base freq
	private double[] freq;
	private double[] ampl;
	@SuppressWarnings("unused")
	private double maxAmpl;

	public Fbm2D() {
	}

	public Fbm2D(Noise2D source) {
		setSource(source);
	}

	public double getLacunarity() {
		return lacunarity;
	}

	public void setLacunarity(double lacunarity) {
		this.lacunarity = lacunarity;
		init();
	}

	public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
		init();
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
		init();
	}

	public int getOctaves() {
		return octaves;
	}

	public void setOctaves(int octaves) {
		this.octaves = octaves;
		init();
	}

	private void init() {
		freq = new double[octaves];
		ampl = new double[octaves];
		freq[0] = frequency;
		ampl[0] = gain;
		maxAmpl = gain;
		if (octaves > 1) {
			for (int i = 1; i < octaves; ++i) {
				freq[i] = freq[i - 1] * lacunarity;
				ampl[i] = ampl[i - 1] * gain;
				maxAmpl += ampl[i];
			}
		}
	}

	public double get(double x, double y) {
		double total = 0;
		for (int i = 0; i < octaves; ++i) {
			total += source.get(x * freq[i], y * freq[i]) * ampl[i];
		}
		return total;
	}

	public Noise2D getSource() {
		return source;
	}

	public void setSource(Noise2D source) {
		this.source = source;
	}

}
