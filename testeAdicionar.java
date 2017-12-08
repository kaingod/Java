/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.DAOTbCliente;
import vo.TbCliente;

/**
 *
 * @author Ademir
 */
public class testeAdicionar {
    public static void main(String [] args){
        //Guardando dados nas variaveis
        String nome = ("Ademir Oliveira");
        String email =("Fromstreetz@gmail.com");
        Long telefone = Long.parseLong("21987729830");
        String datanascimento = ("30/09/1988");
        
        //Formatando data
        String auxDt = datanascimento;
        int ano = Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes = Integer.parseInt(auxDt.substring(3,5)) - 1;
        int dia = Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);
    
        //Montagem Objeto vo
        TbCliente vo = new TbCliente();
        vo.setNome(nome);
        vo.setEmail(email);
        vo.setTelefone(telefone);
        vo.setDatanascimento(dtSQL);
        
        //Grava conexao
        DAOTbCliente dao = new DAOTbCliente();
        if (dao.adicionar(vo)){
            System.out.println("Cliente Cadastrado com Sucesso");
            } else{
                System.out.println("Erro ao tentar gravar cliente");
        }
    }
}
