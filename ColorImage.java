/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */
class ColorImage {

	private int[][] data; // @colorimage

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}
	//Colar uma imagem noutra ignorando pixeis a preto
	void paste(ColorImage img,int x,int y){
	for (int i = x,o=0; o<img.getWidth(); i++,o++) {
		for (int j = y,p=0;p<img.getHeight(); j++,p++) {
			if(img.getColor(o,p).getR()!=0 || img.getColor(o,p).getG()!=0 || img.getColor(o,p).getB()!=0)	
				setColor(i,j,img.getColor(o,p));				
		}
	}
	}
	//pintar imagem toda numa cor
	void paintAllColor(Color c){
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
					setColor(i,j,c);			
			}
		}
	}
	//Colocar imagem a "transparent"(pixeis transparentes sao pretos)
	void transparentBlack(){
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0))
					setColor(i,j,Color.BLACK);
			}
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
}