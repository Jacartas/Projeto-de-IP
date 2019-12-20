/**
 * Represents RGB colors.
 * RGB values are stored in a 3-position array, with values in the interval [0, 255].
 * rgb[0] - Red
 * rgb[1] - Green
 * rgb[2] - Blue
 */
class Color {

	private final int[] rgb; // @color

	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		
		this.rgb = new int[] {r, g, b};
	}
	static final Color RED = new Color(255,0,0);
	static final Color GREEN = new Color(0,255,0);
	static final Color BLUE = new Color(0,0,255);
	static final Color BLACK =new Color(0,0,0);
	static final Color WHITE = new Color(255,255,255);

	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}
	Color brightness(int factor){
		int r=0;
		int g=0;
		int b=0;		
		if(getR()+factor<= 255 && getR()+factor>=0)
			r = getR()+factor;
		else{
			if(getR()+factor>255)
				r = 255;
			else
				r = 0;
		}	
		if(getG()+factor<= 255 && getG()+factor>=0)
			g = getG()+factor;
		else{
			if(getG()+factor>255)
				g = 255;
			else
				g = 0;						
		}
		if(getB()+factor<= 255 && getB()+factor>=0)
			b = getB()+factor;
		else{
			if(getB()+factor>255)
				b = 255;
			else
				b = 0;						
		}
		Color c=new Color(r,g,b);
		return c;
	}

}