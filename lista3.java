class Livro {

    private long ISBN;
    private String titulo;
    private String autor_principal;
    private String segundo_autor;
    private String categoria;
    private String descricao;
    private int ano_publicacao;
    private int quantidade_paginas;
    private float nota_avaliacao;
    private int quantidade_avaliacoes;

    void setISBN(long x) {
        this.ISBN = x;
    }

    void setTitulo(String x) {
        this.titulo = x;
    }

    void setAutor_principal(String x) {
        this.autor_principal = x; // Corrected here
    }

    void setSegundo_autor(String x) {
        this.segundo_autor = x;
    }

    void setCategoria(String x) {
        this.categoria = x;
    }

    void setDescricao(String x) {
        this.descricao = x;
    }

    void setAno_publicacao(int x) {
        this.ano_publicacao = x;
    }

    void setQuantidade_paginas(int x) {
        this.quantidade_paginas = x;
    }

    void setNota_avaliacao(float x) {
        this.nota_avaliacao = x;
    }

    void setQuantidade_avaliacoes(int x) {
        this.quantidade_avaliacoes = x;
    }

    long getISBN() {
        return this.ISBN;
    }

    String getTitulo() {
        return this.titulo;
    }

    String getAutor_principal() {
        return this.autor_principal;
    }

    String getSegundo_autor() {
        return this.segundo_autor;
    }

    String getCategoria() {
        return this.categoria;
    }

    String getDescricao() {
        return this.descricao;
    }

    int getAno_publicacao() {
        return this.ano_publicacao;
    }

    int getQuantidade_paginas() {
        return this.quantidade_paginas;
    }

    float getNota_avaliacao() {
        return this.nota_avaliacao;
    }

    int getQuantidade_avaliacoes() {
        return this.quantidade_avaliacoes;
    }

    @Override
    public String toString() {
        if(this.getSegundo_autor().equals("")){
        return this.getAutor_principal() +". " + this.getTitulo() + ". " + this.getAno_publicacao() + ". ISBN: " + this.getISBN() + ". ";
        }
        else{
        return this.getAutor_principal() + ", " + this.getSegundo_autor() +". " + this.getTitulo() + ". " + this.getAno_publicacao() + ". ISBN: " + this.getISBN() + ". ";
        }
    }

    public void imprimir() {
        System.out.println("ISBN: " + this.ISBN);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor Principal: " + this.autor_principal);
        System.out.println("Segundo Autor: " + this.segundo_autor);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Ano de Publicação: " + this.ano_publicacao);
        System.out.println("Quantidade de Páginas: " + this.quantidade_paginas);
        System.out.println("Nota de Avaliação: " + this.nota_avaliacao);
        System.out.println("Quantidade de Avaliações: " + this.quantidade_avaliacoes);
    }
    

     public Livro clone() {
        return new Livro(this.ISBN, this.titulo, this.autor_principal, this.segundo_autor, this.categoria, this.descricao, this.ano_publicacao,
              this.quantidade_paginas, this.nota_avaliacao, this.quantidade_avaliacoes);
     }

     
    Livro() {
    }

    Livro(long isbn, String titulo, String autor_principal, String segundo_autor, String categoria,
          String descricao, int ano_publicacao, int quantidade_paginas, float nota_avaliacao,
          int quantidade_avaliacoes) {
        this.ISBN = isbn;
        this.titulo = titulo;
        this.autor_principal = autor_principal;
        this.segundo_autor = segundo_autor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.ano_publicacao = ano_publicacao;
        this.quantidade_paginas = quantidade_paginas;
        this.nota_avaliacao = nota_avaliacao;
        this.quantidade_avaliacoes = quantidade_avaliacoes;
    }
}

public class lista3 {

    public static void main(String[] args) {

        // qtd do vetor
        int qtd = MyIO.readInt();
        // vetor livro
        Livro[] livros = new Livro[qtd];

        String linha = MyIO.readLine();
        int i = 0;
        while (!linha.equals("FIM")) {

            String[] info = linha.split("\\|");

            long isbn = Long.parseLong(info[0]);
            String titulo = info[1];
            String autor_principal = info[2];
            String segundo_autor = info[3];
            String categoria = info[4];
            String descricao = info[5];
            int ano_publicacao = Integer.parseInt(info[6]);
            int quantidade_paginas = Integer.parseInt(info[7]);
            float nota_avaliacao = Float.parseFloat(info[8]);
            int quantidade_avaliacoes = Integer.parseInt(info[9]);

            livros[i] = new Livro(isbn, titulo, autor_principal, segundo_autor, categoria, descricao, ano_publicacao, quantidade_paginas, nota_avaliacao, quantidade_avaliacoes);
            i++;

            linha = MyIO.readLine();
        }

        linha = MyIO.readLine();

        while (!linha.equals("FIM")) {
            String[] info = linha.split(";");

            String titulo = info[0];
            int ano_publicacao = Integer.parseInt(info[1]);
            String autor_principal = info[2];

            for (Livro livro : livros) {
                if (livro.getTitulo().equals(titulo) && livro.getAno_publicacao() == ano_publicacao
                        && livro.getAutor_principal().equals(autor_principal)) {
                    System.out.println(livro.toString()); // Corrected here
                }
            }

            linha = MyIO.readLine();
        }
    }
}
