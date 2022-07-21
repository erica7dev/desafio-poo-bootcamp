package com.desafio;

import java.time.*;

import com.desafio.dominio.Bootcamp;
import com.desafio.dominio.Conteudo;
import com.desafio.dominio.Curso;
import com.desafio.dominio.Mentoria;

public class App 
{
    public static void main( String[] args )
    {
        Mentoria mentoria = new Mentoria( );
        mentoria.setTitulo( "Mentoria" );
        mentoria.setDescricao( "Mentoria" );
        mentoria.setData(LocalDate.now());

        Curso curso = new Curso();
        curso.setTitulo("Java");
        curso.setDescricao("Java Curso Bão!");
        curso.setCargaHoraria(100);
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java");
        bootcamp.setDescricao("Curso de Java");
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(curso);
    }
}
