noise
=======
Java noise library


```java
SimplexNoise base = new SimplexNoise();
base.setSeed(seed);

Ridged2D ridged = new Ridged2D(base);
// or ridged.setSource(base);

Turbulence2D turbulence = new Turbulence(ridged);

Fbm2D fbm = new Fbm2D(turbulence);
fbm.setOctaves(6);
fbm.setLacunarity(2.2);
fbm.setFrequency(1);
fbm.setGain(0.5);
double value = fbm.get(x, y);

value = Value.clamp(
			Value.scale(
				Value.abs(value), 
				255
			), 
			0, 
			255
		);


```