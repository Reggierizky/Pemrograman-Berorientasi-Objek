class Mahasiswa<A,B,C> {

    private A nim;
    private B name;
    private C clas;

    public void setNim(A nim){
        this.nim = nim;
    }

    public void setName(B name){
        this.name = name;
    }

    public void setClas(C clas){
        this.clas = clas;
    }

    public A getNim(){
        return nim;
    }

    public B getName(){
        return name;
    }

    public C getClas(){
        return clas;
    }
}