public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria(){
        this.raiz = new No(null);
        System.out.println("Arvore binaria criada com sucesso");
    }

    public void inserir(Integer conteudo){
        if(raiz.getConteudo() == null){
            raiz.setConteudo(conteudo);
        } else {
            recursivo(raiz, conteudo);
        }
    }

    public void recursivo(No atual, Integer conteudo){
        if(conteudo < atual.getConteudo()){
            if(atual.getEsquerda() == null){
                No novoNo = new No(conteudo);
                atual.setEsquerda(novoNo);
            } else {
                recursivo(atual.getEsquerda(), conteudo);
            }
        } else if(conteudo > atual.getConteudo()){
            if(atual.getDireita() == null){
                No novoNo = new No(conteudo);
                atual.setDireita(novoNo);
            } else{
                recursivo(atual.getDireita(), conteudo);
            }
        }
    }

    public void preOrdem(No atual){
        if(raiz.getConteudo() == null){
            System.out.println("Raiz é nula");
        } else {
            System.out.println(atual.getConteudo());
            if(atual.getEsquerda() != null){
                preOrdem(atual.getEsquerda());
            }
            if(atual.getDireita() != null){
                preOrdem(atual.getDireita());
            }
        }
    }


    public void emOrdem(No atual){
        if(raiz.getConteudo() == null){
            System.out.println("Raiz é nula");
            return;
        } else{
            if(atual.esquerda != null){
                emOrdem(atual.getEsquerda());
            }
            if(atual.getConteudo() != null){
                System.out.println(atual.getConteudo());
            }
            if(atual.direita != null){
                emOrdem(atual.getDireita());
            }
        }
    }

    public void posOrdem(No atual){
        if(raiz.getConteudo() == null){
            System.out.println("Raiz é nula");
            return;
        } else {
            if(atual.getEsquerda() != null){
                posOrdem(atual.getEsquerda());
            }

            if(atual.getDireita() != null){
                posOrdem(atual.getDireita());
            }

            if(atual.getConteudo() != null){
                System.out.println(atual.getConteudo());
            }
        }
    }

    public void exibir(String percurso){
        if(percurso.equals("pre")){
            preOrdem(raiz);
        }
        if(percurso.equals("ordem")){
            emOrdem(raiz);
        }
        if(percurso.equals("pos")){
            posOrdem(raiz);
        }
    }

    public No procurarElemento(Integer conteudo, No atual) {
        if (atual == null) {
            return null;
        }
        if(conteudo.equals(atual.getConteudo())) {
            return atual;
        }
        if(conteudo < atual.getConteudo()) {
            return procurarElemento(conteudo, atual.getEsquerda());
        }else {
            return procurarElemento(conteudo, atual.getDireita());
        }
    }

    public void removerElemento(Integer conteudo) {
        if (raiz == null || raiz.getConteudo() == null) {
            System.out.println("Árvore vazia");
            return;
        }
        removerElemento(conteudo, raiz);
    }

    private void removerElemento(Integer conteudo, No atual){
        if(eFolha(conteudo)){
            removerFolha(conteudo, atual);
        }
        if(temUmFilho(conteudo)){
            removerUmFilho(conteudo, atual);
        }
        if(temDoisFilhos(conteudo)){
            removerDoisFilhos(conteudo, atual);
        }

    }

    public void removerFolha(Integer conteudo, No atual){
        if(raiz.getDireita() == null && raiz.getEsquerda() == null){
            raiz.setConteudo(null);
            return;
        }
        if(atual.getEsquerda() != null && conteudo.equals(atual.getEsquerda().getConteudo())){
            No nofilho = atual.getEsquerda();
            if(nofilho.getEsquerda() == null && nofilho.getDireita() == null){
                atual.setEsquerda(null);
            }
        }
        if(atual.getDireita() != null && conteudo.equals(atual.getDireita().getConteudo())){
            No nofilho = atual.getDireita();
            if(nofilho.getEsquerda() == null && nofilho.getDireita() == null){
                atual.setDireita(null);
            }
        }
        if(conteudo < atual.getConteudo() && atual.getEsquerda() != null){
            removerFolha(conteudo, atual.getEsquerda());
        }
        if(conteudo > atual.getConteudo() && atual.getDireita() != null){
            removerFolha(conteudo, atual.getDireita());
        }
    }

    public void removerUmFilho(Integer conteudo, No atual){
        if(atual == null){
            return;
        }
        if(atual.getEsquerda() != null && conteudo.equals(atual.getEsquerda().getConteudo())){
            No noFilho = atual.getEsquerda();
            if(noFilho.getEsquerda() != null){
                atual.setEsquerda(noFilho.getEsquerda());
            }
            if(noFilho.getDireita() != null){
                atual.setEsquerda(noFilho.getDireita());
            }
        }
        if(atual.getDireita() != null && conteudo.equals(atual.getDireita().getConteudo())){
            No noFilho = atual.getDireita();
            if(noFilho.getEsquerda() != null){
                atual.setDireita(noFilho.getEsquerda());
            }
            if(noFilho.getDireita() != null){
                atual.setDireita(noFilho.getDireita());
            }
        }
        if(conteudo < atual.getConteudo()){
            removerUmFilho(conteudo, atual.getEsquerda());
        }
        if(conteudo > atual.getConteudo()){
            removerUmFilho(conteudo, atual.getDireita());
        }
    }

    public void removerDoisFilhos(Integer conteudo, No atual) {
        No no = procurarElemento(conteudo, raiz);
        if (no == null) {
            return;
        }
        if (no.getEsquerda() == null || no.getDireita() == null) {
            return;
        }
        No sucessor = menorDosMaiores(no.getDireita());
        Integer conteudoSucessor = sucessor.getConteudo();
        removerElemento(conteudoSucessor, raiz);
        no.setConteudo(conteudoSucessor);
    }

    public boolean eFolha(Integer conteudo){
        No no = procurarElemento(conteudo, raiz);
        if(no == null){
            return false;
        }
        if(no.getEsquerda() == null && no.getDireita() == null){
            return true;
        }
        return false;
    }

    public boolean temUmFilho(Integer conteudo){
        No no = procurarElemento(conteudo, raiz);
        if(no == null){
            return false;
        }
        if(no.getEsquerda() != null ^ no.getDireita() != null){
            return true;
        }
        return false;
    }

    public boolean temDoisFilhos(Integer conteudo){
        No no = procurarElemento(conteudo, raiz);
        if(no == null){
            return false;
        }
        if(no.getEsquerda() != null && no.getDireita() != null){
            return true;
        }
        return false;
    }

    public No menorDosMaiores(No atual) {
        if (atual == null) {
            return null;
        }

        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }

        return atual;
    }
}
