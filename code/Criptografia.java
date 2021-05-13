
package criptografia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Criptografia {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        
        System.out.println("Digite a senha: ");
        String senha = entrada.nextLine();
        
        System.out.println("Digite o código do usuário: ");
        int codigo = entrada.nextInt();
        
        int tamanhoSenha = senha.length();
        
        int chave = codigo+tamanhoSenha;
        
        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789*@&#$%-+";
        String alfabetoEmbaralhado1 = embaralhar(alfabeto);
        String alfabetoEmbaralhado2 = embaralhar(alfabeto);
        String alfabetoEmbaralhado3 = embaralhar(alfabeto);
        
        String senhaCriptografada = criptografa(alfabetoEmbaralhado1, senha, chave);
        System.out.println(senhaCriptografada);
    }
    
    
    public static String criptografa(String alfabeto, String senha, int chave){
        char[] vetorLetrasSenha = senha.toCharArray();
        char[] vetorLetrasAlfabeto = alfabeto.toCharArray();
        
        char[] senhaCriptografada;
        
        for(int x = 0; x < senha.length(); x++){
            char caractere = vetorLetrasSenha[x]; // T
            int posicaoLetra;
            
            for(int y = 0; y < alfabeto.length(); y++){ /* percorre o vetor do alfabeto
                                                        procurando a posição do primeiro 
                                                                glacractere da senha*/
                if(vetorLetrasAlfabeto[y] == caractere){
                    posicaoLetra = y;
                }
            }
            
            
        }
        
        String retorno = "";
        return retorno;
    }
    
    public static String embaralhar(String alfabeto){
        char[] letras = alfabeto.toCharArray(); // transforma o alfabeto (String) em um vetor de caracteres
        
        List<Character> listaLetras  = new ArrayList<Character>(letras.length); // cria uma lista que vai receber cada caracter do vetor, um por um
        
        for (char c:  letras){ /* adiciona os caracteres do vetor dentro da lista */
            listaLetras.add(c); 
        }
        
        Collections.shuffle(listaLetras); // embaralha a lista de caracteres
        
        for ( int i =0; i < letras.length ; i++ ){
            letras[i] = listaLetras.get(i);        /* adiciona os caracteres embaralhados
                                                      da lista para o vetor*/
        }
        
        String alfabetoEmbaralhado = new String(letras); // coloca todos os caracteres do vetor dentro de uma String
        return alfabetoEmbaralhado; // retorna a String
    }
}
