package com.desafio.dominio;

import java.util.*;

public class Dev {
  private String nome;
  private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
  private Set<Conteudo> conteudosRealizados = new LinkedHashSet<>();

  public void inscreverBootcamp(Bootcamp bootcamp) {
    this.conteudosInscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsInscritos().add(this);
  }

  public void progredir(){
    // se for null
    Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();

    if(conteudo.isPresent()){
      conteudosRealizados.add(conteudo.get());
      conteudosInscritos.remove(conteudo.get());
    } else {
      System.err.println("Você não está matriculado em nenhum conteúdo!");
    }
  }

  public double calcularTotalXp() {
    Iterator<Conteudo> iterator = this.conteudosRealizados.iterator();
    double soma = 0;
    while(iterator.hasNext()){
      double next = iterator.next().calcularXp();
      soma += next;
    }
    return soma;
  }

  public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
    this.conteudosInscritos = conteudosInscritos;
  }

  public Set<Conteudo> getConteudosInscritos() {
    return conteudosInscritos;
  }

  public Set<Conteudo> getConteudosRealizados() {
    return conteudosRealizados;
  }

  public void setConteudosRealizados(Set<Conteudo> conteudosRealizados) {
    this.conteudosRealizados = conteudosRealizados;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Dev dev = (Dev) o;
    return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosRealizados, dev.conteudosRealizados);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, conteudosInscritos, conteudosRealizados);
  }
}
