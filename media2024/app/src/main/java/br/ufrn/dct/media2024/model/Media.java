package br.ufrn.dct.media2024.model;

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

    protected static final String TAG = "MEDIA";
    private double nota_unidade_1;
    private double nota_unidade_2;
    private double nota_unidade_3;

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

    @Override
    public String toString() {
        return "Media{" +
                "nota_unidade_1=" + nota_unidade_1 +
                ", nota_unidade_2=" + nota_unidade_2 +
                ", nota_unidade_3=" + nota_unidade_3 +
                '}';
    }

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
}
