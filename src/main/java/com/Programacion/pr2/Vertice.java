package com.Programacion.pr2;

public class Vertice <W> {
    private W id;
    private boolean isVisited;

    public Vertice (W id, boolean isVisited){
        this.id=id;
        this.isVisited=isVisited;
    }
    
    //Voy a hacer el metodo getter
    public W getid(){
        return id;
    }

    //Voy a hace el metodo setter 
    public void setid(W id){
        this.id=id;
    }

    //Voy a hacer el metodo getter 
    public  boolean getisVisited(){
        return isVisited;
    }

    //Voy a hacer el metodo setter
    public void setisVisited(boolean isVisited){
        this.isVisited=isVisited;
    }


}
