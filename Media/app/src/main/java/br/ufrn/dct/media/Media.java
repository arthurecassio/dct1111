package br.ufrn.dct.media;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * Esta classe representa um Objeto Média
 * conforme descrito no Regulamento de Graduação UFRN
 * * */
public class Media {

    Logger log = Logger.getAnonymousLogger();

    private double nota_unidade_1;
    private double nota_unidade_2;
    private double nota_unidade_3;

    public double getNota_unidade_1() {
        return nota_unidade_1;
    }

    public void setNota_unidade_1(double nota_unidade_1) {
        this.nota_unidade_1 = nota_unidade_1;
    }

    public double getNota_unidade_2() {
        return nota_unidade_2;
    }

    public void setNota_unidade_2(double nota_unidade_2) {
        this.nota_unidade_2 = nota_unidade_2;
    }

    public double getNota_unidade_3() {
        return nota_unidade_3;
    }

    public void setNota_unidade_3(double nota_unidade_3) {
        this.nota_unidade_3 = nota_unidade_3;
    }

    /**
     * Cria uma Média Vazia
     * */
    public Media(){
        this.nota_unidade_1 = 0;
        this.nota_unidade_2 = 0;
        this.nota_unidade_3 = 0;
    }

    public Media(double unidade_1, double unidade_2, double unidade_3){
        this.nota_unidade_1 = unidade_1;
        this.nota_unidade_2 = unidade_2;
        this.nota_unidade_3 = unidade_3;
    }

    /**
     * Calcula o valor da média
     * dividindo a soma das notas das unidades por 3
     * */
    public double calcule(){
        log.info("Calculando a média de: "+toString());
        double media = (this.nota_unidade_1+this.nota_unidade_2+this.nota_unidade_3)/3;
        log.info("Retornando média: "+media);
        return media;
    }

    /**
     * Verifica a aprovação por média e retorna uma mensagem explicativa
     * */
    public String verificarAprovacao(){
        double media = calcule();
        DecimalFormat casasDescimais = new DecimalFormat("#,##0.00");
        String mensagem = "Sua média foi: "+casasDescimais.format(media);

        log.info("Verificando aprovação: "+toString()+"\n"+mensagem);

        if(media >= 6.0){
            if(this.nota_unidade_1 >= 4.0 && this.nota_unidade_2 >= 4.0 && this.nota_unidade_3 >= 4.0){
                mensagem += " , você foi aprovado!!";
            }else{
                mensagem += " , você está em recuperação pois não tirou 4.0 ou mais em alguma unidade!";
            }
        }else if(media >= 3.0){
            mensagem += " , você está em recuperação a sua média parcial ficou entre 3.0 e 5.99!";
        }else{
            mensagem += " , você está reprovado pois sua média parcial ficou abaixo de 3.0";
        }
        log.info("Retornando aprovação: "+toString()+"\n"+mensagem);
        return mensagem;
    }

    /**
     * Verifica a aprovação por Recuperação e retorna uma mensagem explicativa
     * */
    public String verificarAprovacaoRecuperacao(double notaRecuperacao){
        log.info("Verificando Recuperação: "+toString()+"\n");
        //Selecione a menor nota das unidades
        double[] notas = {this.nota_unidade_1,this.nota_unidade_2,this.nota_unidade_3};
        double menorNota = 11; int menorUnidade = 0;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i] < menorNota){
                menorNota = notas[i];
                menorUnidade = i;
            }
        }
        switch (menorUnidade){
            case 0: this.nota_unidade_1 = notaRecuperacao; break;
            case 1: this.nota_unidade_2 = notaRecuperacao; break;
            case 2: this.nota_unidade_3 = notaRecuperacao; break;
        }
        log.info("Substituiu a nota da unidade: "+menorUnidade+ " de "+ notas[menorUnidade] + " para "+ notaRecuperacao);
        double media = calcule();
        DecimalFormat casasDescimais = new DecimalFormat("#,##0.00");
        String mensagem = "Sua média foi: "+casasDescimais.format(media);
        log.info("Verificando Recuperação: "+mensagem);
        if(media >= 5.0){
            if(notaRecuperacao >= 4.0){
                mensagem += " , você foi aprovado!!";
            }else{
                mensagem += " , você foi reprovado pois sua nota na recuperação foi abaixo de 4.0!";
            }
        }else
            mensagem += " , você foi reprovado pois sua média final foi abaixo de 5.0!";
        log.info("Retornando recuperação: "+toString()+"\n"+mensagem);
        return mensagem;
    }

    @Override
    public String toString() {
        return "Media{" +
                "nota_unidade_1=" + nota_unidade_1 +
                ", nota_unidade_2=" + nota_unidade_2 +
                ", nota_unidade_3=" + nota_unidade_3 +
                '}';
    }
}
