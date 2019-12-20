class GraphUtils {
	//Exc 1-grafico barras normal
	static ColorImage graph2DVerticalBars(int[] vec,int width,int space,Color c){
		int max = max(vec);
		ColorImage backgrd=new ColorImage((vec.length*width)+(vec.length*space)+space,max);
		int inic=space;
		for (int i = 0; i < vec.length; i++) {			
			backgrd.paste(column(width,vec[i],c),inic,backgrd.getHeight()-vec[i]);
			inic=inic+width+space;
		}
	return backgrd;	
	}
	//Exc 2 grafico de barras suaves
	static ColorImage graph2DVerticalBarsSoft(int[] vec,int width,int space,Color c,int gradient){
		int max = max(vec);
		ColorImage backgrd=new ColorImage((vec.length*width)+(vec.length*space)+space,max);
		int inic=space;
		for (int i = 0; i < vec.length; i++) {			
			backgrd.paste(softColumn(width,vec[i],c,gradient),inic,backgrd.getHeight()-vec[i]);
			inic=inic+width+space;
		}
		return backgrd;	
	}
	//Exc 3 grafico de dispersao 
	static ColorImage graph2DDispersion(int[] vec,int r,int space,Color c){
		int max = max(vec);
		ColorImage backgrd=new ColorImage((vec.length*(2*r))+(vec.length*space)+space,max);
		int inic=space;
		for (int i = 0; i < vec.length; i++) {			
			backgrd.paste(circle(r,c),inic,backgrd.getHeight()-vec[i]);
			inic=inic+(2*r)+space;
		}
	return backgrd;		
	}		
	//rotacao de grafico 90 graus	
	static ColorImage rotate90Degrees(ColorImage img){
		ColorImage img2=new ColorImage(img.getHeight(),img.getWidth());
		for (int i = 0; i < img.getHeight() ; i++) {
			for (int j = 0; j <img.getWidth() ; j++) {
				img2.setColor(img.getHeight()-i-1,j,img.getColor(j,i));
			}
		}
	return img2;				
	}	
	//Criar ColorImage de um circulo
	static ColorImage circle(int r,Color c){
		ColorImage img = new ColorImage(2*r,2*r);
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				if(((i-r)*(i-r))+((j-r)*(j-r))<=(r*r)){
					img.setColor(i,j,c);
				}
			}
		}
	return img;	
	}
	//Coluna com degradê
	static ColorImage softColumn(int width,int height,Color c,int s){
		ColorImage img=new ColorImage(width,height);
		img.paintAllColor(c);
		int gradFactor=(Math.max(Math.max(c.getR(),c.getG()),c.getB()))/s;
		for (int i = s,f=gradFactor; i >=0; i--,f+=gradFactor) {
			for (int j = i; j < img.getHeight(); j++) {
				img.setColor(i,j,c.brightness(-f));
				img.setColor(img.getWidth()-1-i,j,c.brightness(-f));
			}
			for (int h = i; h < img.getWidth()-i; h++) {
				img.setColor(h,i,c.brightness(-f));
			}
		}
	return img;
	}
	//Cria ColorUmage de uma coluna
	static ColorImage column(int width,int height,Color c){
		ColorImage img=new ColorImage(width,height);
		img.paintAllColor(c);
	return img;
	}
	//Procura max num vector
	static int max(int[] v){
		int i=0;
		int max=0;
		while(i!=v.length){
			if(v[i]>max) max=v[i];
			i++;
		}
	return max;
	}
	static ColorImage test(){
		Color c=new Color(255,0,0);
		int[] vec={100,100,125,150};
		ColorImage img=graph2DVerticalBarsSoft(vec,40,40,c,10);
		return img;		
	}
		
	
	
	
}
	
	
	
	
	
	
