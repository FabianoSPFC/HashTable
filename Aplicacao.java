package atividade_pesquisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Aplicacao {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int table_size = 100;
        
        File arquivo = new File("C:/Users/Fabiano Filho/Desktop/aaa.csv");

        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        String linha;
        String Matricula[] = new String[table_size];
        String nome[] = new String[table_size];
        Aluno alunos[] = new Aluno[table_size];
        Separate_Hash_Table table = new Separate_Hash_Table(100);
        Separate_Hash_Table table_100 = new Separate_Hash_Table(100);
        Separate_Hash_Table table_50 = new Separate_Hash_Table(50);
        Separate_Hash_Table table_20 = new Separate_Hash_Table(20);
        Separate_Hash_Table table_10 = new Separate_Hash_Table(10);

        for (int i = 0; (linha = br.readLine()) != null; i++) {
            for (int j = 0; j < linha.indexOf(';'); j++) {
                if (j == 0) {
                    Matricula[i] = "" + linha.charAt(j);
                } else {
                    Matricula[i] = Matricula[i] + linha.charAt(j);
                }
            }
            for (int j = linha.indexOf(';') + 1; j < linha.length(); j++) {
                if (j == linha.indexOf(';') + 1) {
                    nome[i] = "" + linha.charAt(j);
                } else {
                    nome[i] = nome[i] + linha.charAt(j);
                }
            }
            alunos[i] = new Aluno(nome[i], Matricula[i]);            
            table.insert(alunos[i]);
            table_100.insert(alunos[i]);
            table_50.insert(alunos[i]);
            table_20.insert(alunos[i]);
            table_10.insert(alunos[i]);
        }
        
        System.out.println("----Antes da Remoção dos Alunos---------\n");
        table.printColision();
        
        table.remove(alunos[0]);        
        System.out.println("\n----Depois da Remoção dos Alunos---------\n");
        table.printColision();  
        
        System.out.println("\n----Fator de Carga 1---------\n");
        table_100.printColision();
        
        System.out.println("\n----Fator de Carga 2---------\n");
        table_50.printColision();
        
        System.out.println("\n----Fator de Carga 5---------\n");
        table_20.printColision();
        
        System.out.println("\n----Fator de Carga 10---------\n");
        table_10.printColision();
    }
}