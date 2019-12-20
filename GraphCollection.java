class GraphCollection {
	final int max=5;
	Graph[] graph=new Graph[max];
	int next =0;
	//metodo construtor dado um grafico
	GraphCollection(Graph graph){
		if(next==max)
			throw new IllegalStateException("No space for more graphs");
		this.graph[next]=graph;
		next++;
	}
	//metodo construtor dado varios grafico/vetor de graficos
	GraphCollection(Graph[] graph){
		if(next==max)
			throw new IllegalStateException("No space for more graphs");
		for (int i = 0; i < graph.length; i++) {
			this.graph[next]=graph[i];
			next++;
			if(next==max)
				throw new IllegalStateException("No space for more graphs");
		}		
	}
	//adicionar grafico
	void addGraphLast(Graph graph){
		if(next==max)
			throw new IllegalStateException("No space for more graphs");
		this.graph[next]=graph;
		next++;
	}
	//remover ultimo grafico
	void removeGraphLast(){
		this.graph[next-1]=null;
		next--;
	}
	//obter ultimo grafico
	Graph getLastGraph(){
		return graph[next-1];		
	}
	//adicionar grafico em posiçao desejada
	void addGraphToPosition(Graph graph,int p){
		if(next==max)
			throw new IllegalStateException("No space for more graphs");
		for (int i = 0; i < next-p; i++) {
			Graph gr=this.graph[p+i];
			this.graph[p+i+1]=gr;
		}
		this.graph[p]=graph;
		next++;
	}
	//trocar posiçoes
	void changePosition(int p1,int p2){
		Graph gr = graph[p2];
		graph[p2]=graph[p1];
		graph[p1]=gr;	
	}
	//devolver vetor com graficos sem titulo
	Graph[] graphWithoutTitle(){
		int n =0;
		for (int i = 0; i < next; i++) {
			if(graph[i].getTitle().equals(""))
				n++;
		}
		Graph[] gr=new Graph[n];
		for (int i = 0,j=0; i < next; i++) {
			if(graph[i].getTitle().equals("")){
				gr[j]=graph[i];
				j++;
			}
		}
		return gr;
	}
	//Colocar por ordem alfabetica
	Graph[] alphabeticalOrder(){
		int n=next;
		for (int i = 0; i < n; i++) {
			if(graph[i].getTitle().equals("")){
				changePosition(i,n-1);
				n--;
			}
		}
		for(int j=0;j!=n-1;j++){
			for (int j2 = 0; j2 < Math.min(graph[j].getTitle().length(),graph[j+1].getTitle().length()); j2++){
				if(graph[j].getTitle().charAt(j2)>graph[j+1].getTitle().charAt(j2))
					changePosition(j,j+1);
				if((j2==Math.min(graph[j].getTitle().length(),graph[j+1].getTitle().length())-1) && (graph[j].getTitle().length()!= graph[j+1].getTitle().length())){
					if(graph[j].getTitle().length()>graph[j+1].getTitle().length())
						changePosition(j,j+1);
				}
			}
		}
		
		return this.graph;
	}
	//colar graficos em cima uns dos outros
	ColorImage mergeAll(){
		int maxX=0;
		int maxY=0;
		for (int i = 0; i < next; i++) {
			if(graph[i].getImage().getWidth()>maxX)
				maxX=graph[i].getImage().getWidth();
			if(graph[i].getImage().getHeight()>maxY)
				maxY=graph[i].getImage().getHeight();
		}
		ColorImage backgr=new ColorImage(maxX,maxY);
		for (int i = 0; i < next; i++) {
			backgr.paste(graph[i].getImage(),0,maxY-graph[i].getImage().getHeight());
		}
	return backgr;	
	}
	//Colar e rodar 90º horarios
	ColorImage margeAllAndRotate(){
		return GraphUtils.rotate90Degrees(mergeAll());
		
	}
	
		
	static GraphCollection testgraphCollection(){
		Color c=new Color(255,0,0);
		int[] vec={200,200,250,300,100};
		ColorImage img=GraphUtils.graph2DVerticalBarsSoft(vec,40,40,c,10);
		Graph gr1 = new Graph(img,"ab","x","y");
		Color c2=new Color(0,255,0);
		int[] vec2={100,150,250,50};
		ColorImage img2=GraphUtils.graph2DVerticalBars(vec2,40,40,c2);
		Graph gr2 = new Graph(img2,"","xx","yy");
		Color c3=new Color(0,0,255);
		int[] vec3={200,50,100,250};
		ColorImage img3=GraphUtils.graph2DDispersion(vec3,20,40,c3);
		Graph gr3 = new Graph(img3,"ac","xxx","yyy");
		Graph[] gv=new Graph[2];
		gv[0]=gr1;
		gv[1]=gr2;
		//gv[2]=gr3;
		GraphCollection gc=new GraphCollection(gv);
		gc.addGraphToPosition(gr3,1);
		return gc;
	}
		
}