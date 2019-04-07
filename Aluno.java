package atividade_pesquisa;

public class Aluno implements Hashable{
    private String nome;
    private String matricula;
    
    public void setnome(String nome){
        this.nome = nome;
    }
    
    public Aluno(){
        String[] nome = null;
        String[] matricula = null;
    }
    
    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public String getome(String nome){
        return this.nome;
    }
    
    public String getmatricula(String matricula){
        return this.matricula;
    }
    
    public void setmatricula(String matricula){
        this.nome = matricula;
    }
    
    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public int hash(int tablesize){
        int hashvalue = 0; 
        hashvalue = matricula.hashCode()%tablesize;
        if(hashvalue<0){
            hashvalue+=tablesize;
        }
        return hashvalue;
    }
}
