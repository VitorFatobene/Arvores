
public class Exec {
    static void main(String [] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(11);
        arvoreBinaria.inserir(10);
        arvoreBinaria.exibir("pre");
        System.out.println("pos remoção");
        arvoreBinaria.removerElemento(7);
        arvoreBinaria.exibir("pre");
    }
}
