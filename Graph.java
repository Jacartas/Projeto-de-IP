class Graph {
	ColorImage graph;
	String title;
	String xAxisTitle;
	String yAxisTitle;
	boolean isTransparent;
	
	Graph(ColorImage graph){
		this.graph=graph;	
		this.title="";
		this.xAxisTitle="";
		this.yAxisTitle="";
	}
	Graph(ColorImage graph,String title,String xAxisTitle,String yAxisTitle){
		this.graph=graph;
		this.title= title;
		this.xAxisTitle= xAxisTitle;
		this.yAxisTitle=yAxisTitle;	
	}
	void changetitle(String title){
		this.title = title;	
	}
	void changexAxisTitle(String title){
		this.xAxisTitle= title;
	}
	void changeyAxisTitle(String title){
		this.yAxisTitle=title;
	}
	void settransparent(){
		graph.transparentBlack();
		isTransparent=true;
	}
	String getTitle(){
		return this.title;
	}
	String getXAxisTitle(){
		return this.xAxisTitle;	
	}
	String getYAxisTitle(){
		return this.yAxisTitle;
	}
	boolean getIsTransparent(){
		return isTransparent;
	}
	ColorImage getImage(){
		return graph;		
	}
	String getAllInfo(){
		return "Title="+title+";\n"+"x Axis title="+xAxisTitle+";\n"+"y Axis title="+yAxisTitle;
		
		
	}
	
	static Graph test(){
		Color c=new Color(255,0,0);
		int[] vec={200,200,250,300};
		ColorImage img=GraphUtils.graph2DVerticalBarsSoft(vec,40,40,c,5);
		Graph gr1 = new Graph(img,"ola","x","y");
		return gr1;		
	}
}