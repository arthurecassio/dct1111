package br.ufrn.dct.media2024.model;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Esta classe representa um Objeto MédiaParcial
 * conforme descrito no Regulamento de Graduação UFRN
 * * */
public class MediaParcial extends Media {

    private double media_parcial;
    private double nota_recuperacao;

    public double getMedia_parcial() {
        return media_parcial;
    }

    public void setMedia_parcial(double media_parcial) {
        this.media_parcial = media_parcial;
    }

    public double getNota_recuperacao() {
        return nota_recuperacao;
    }

    public void setNota_recuperacao(double nota_recuperacao) {
        this.nota_recuperacao = nota_recuperacao;
    }

    /**
     * Calcula o valor da média
     * dividindo a soma das notas das unidades por 3
     * */
    public void calcule(){
        Log.v(TAG,"Calculando a média parcial de: "+toString());
        media_parcial = (getNota_unidade_1()+getNota_unidade_2()+getNota_unidade_3())/3;
        Log.v(TAG,"Retornando média parcial: "+media_parcial);
    }

    /*
    * Verifica quando o aluno precisa tirar na Recuperacao
    * */
    public void calculeRecuperacao(){
        double somaNotas = getNota_unidade_1()+getNota_unidade_2()+getNota_unidade_3();
        this.nota_recuperacao = 18 - somaNotas;
        this.nota_recuperacao = nota_recuperacao < 4.0 ? 4.0 : nota_recuperacao;
    }

    /**
     * Verifica a aprovação por média e retorna uma mensagem explicativa
     * */
    public String verificarAprovacao(){
        calcule();
        DecimalFormat casasDescimais = new DecimalFormat("#,##0.00");
        String mensagem = "Sua média foi: "+casasDescimais.format(media_parcial)+".\n";

        Log.v(TAG,"Verificando aprovação: "+toString()+"\n"+mensagem);
        calculeRecuperacao();

        if(media_parcial >= 6.0){
            if(getNota_unidade_3() >= 4.0 && getNota_unidade_2() >= 4.0 && getNota_unidade_1() >= 4.0){
                mensagem += "Você foi aprovado!!\n";
            }else{
                mensagem += "Você está em recuperação pois não tirou 4.0 ou mais em alguma unidade!\nPrecisa tirar: "+nota_recuperacao+ " na recuperação.";
            }
        }else if(media_parcial >= 3.0){
            mensagem += "Você está em recuperação a sua média parcial ficou entre 3.0 e 5.99!\nPrecisa tirar: "+nota_recuperacao+ " na Recuperação";
        }else{
            mensagem += "Você está reprovado pois sua média parcial ficou abaixo de 3.0.";
        }
        Log.v(TAG,"Retornando aprovação: "+toString()+"\n"+mensagem);
        return mensagem;
    }
}
