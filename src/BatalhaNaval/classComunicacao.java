/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatalhaNaval;

import Interface.telaPrincipal;
import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class classComunicacao {
    /*Conexão*/
    public void conectarServidor() {
        try {    Thread.sleep(300);} catch (InterruptedException ex) {}
        System.out.println("Conectado");
    }
    
    /*Envios*/
    
    //Conectando
    public void enviaPronto() {
        //Envia ao Coordenado que está pronto para começar a jogar
        System.out.println("Estou Pronto");
    }
    
    //Em ataque
    public String enviaAtaque(String ataque, telaPrincipal telaPrincipal) {
        //Envia a string "ataque-" e a posição atacada separada por hífen para todos e espera suas respostas
        //Retorna uma das opções de acordo com o que receber de resposta.
        try {    Thread.sleep(300);} catch (InterruptedException ex) {}
        return "morri-2";
        //ou
        //return "meAcertou-2";
        //ou
        //return "errou-2";
    }
    
    //Envio de aviso
    public void enviaMorreu(int idMorto) {
        //Envia a todo que a pessoa do idMorto morreu
        
    }

    public void enviaPassarVez(int idPlayer) {
        //Envia a todos a mensagem "passarVez"
        System.out.println("passarVez");
    }

    

    /*Recebimento*/
    //Conectando
    public String esperaLimites() {
        //Espera limites do Coordenador
        try {    Thread.sleep(300);} catch (InterruptedException ex) {}
        return "1-5-A4-J13";
    }

    public ArrayList<Integer> esperaOrdem() {
        //Espera ordem de jogada do Coordenador
        ArrayList<Integer> listOrdem = new ArrayList<>();
        try {    Thread.sleep(300);} catch (InterruptedException ex) {}
        listOrdem.add(1);
        listOrdem.add(2);
        listOrdem.add(0);
        return listOrdem;
    }

    //sendo atacado
    public String recebeAcao(int idJogando) {
        //Espera do jogador atual sua ação
        try {    Thread.sleep(300);} catch (InterruptedException ex) {}
        
        return "passarVez";
    }

    
    //Respondendo a ataques
    public void enviaMeAcertou(int ID) {
        //Envia ao atacante a mensagem informando que ele acertou o ataque
        System.out.println("acertou-" + ID);
    }
    
    public void enviaMorri(int ID) {
        //Envia ao atacante a mensagem informando que eu morri
        System.out.println("morri-" + ID);
    }

    public void enviaErrou(int ID) {
        //Envia ao atacante a mensagem informando que ele errou o ataque
        System.out.println("errou-" + ID);
    }
    
    
    
}
