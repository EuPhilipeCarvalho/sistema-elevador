package exercicioelevador.ui;

import exercicioelevador.domain.Elevador;
import exercicioelevador.service.ElevadorService;
import javax.swing.JOptionPane;

public class Ui {
    public static void main(String[] args) {
        while(true){
            String recepcao = JOptionPane.showInputDialog(null, """
                    Bem-vindo ao elevador Phil's High!
                    Escolha:
                    
                    1. Entrar
                    0. Sair""", "Ola!", JOptionPane.QUESTION_MESSAGE);
            if (recepcao==null || recepcao.equals("0")) {
                JOptionPane.showMessageDialog(null, "Finalizando o sistema!", "Tchau!", JOptionPane.WARNING_MESSAGE);
                break;
            }
            if (!recepcao.equals("1")) {
                JOptionPane.showMessageDialog(null, "Escolha uma das alternativas!", "Ops!", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            //Entrou
            while(true){
                //Inserir a capacidade maxima do elevador
                String capacidade = JOptionPane.showInputDialog(null, """
                        Insira o total de passageiros permitidos:
                        (Clique em "cancelar: ou deixe vazio
                        para retornar.)""", "Capacidade", JOptionPane.QUESTION_MESSAGE);
                if (capacidade==null || capacidade.isEmpty()) break;

                String totalAndares = JOptionPane.showInputDialog(null, """
                        Insira o total de andares no prédio:
                        (Clique em "cancelar: ou deixe vazio
                        para retornar.)""", "Total de Andares", JOptionPane.QUESTION_MESSAGE);
                if (totalAndares==null || totalAndares.isEmpty()) break;

                int capacidadeTotal;
                int andaresTotal;
                try {
                    capacidadeTotal = Integer.parseInt(capacidade);
                    if (capacidadeTotal <= 0) throw new NumberFormatException("Valor da capacidade deve ser maior que zero!");

                    andaresTotal = Integer.parseInt(totalAndares);
                    if (andaresTotal <= 0) throw new NumberFormatException("Valor do total de andares deve ser maior que zero!");

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Ops!", JOptionPane.WARNING_MESSAGE);
                    continue;
                }

                //Tudo certo
                Elevador elevador = new Elevador(capacidadeTotal, andaresTotal);
                ElevadorService service = new ElevadorService(elevador);

                while(true){
                    String menu = JOptionPane.showInputDialog(null, """
                            Escolha uma das ações do elevador:
                            
                            1. Subir um andar
                            2. Descer um andar
                            3. Entrar uma pessoa
                            4. Sair uma pessoa
                            0. Sair desse menu""", "Menu", JOptionPane.QUESTION_MESSAGE);
                    if (menu==null || menu.equals("0")) break;
                    if (!menu.matches("[1-4]")) {
                        JOptionPane.showMessageDialog(null, "Escolha uma das opções fornecidas.", "Ops!", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    switch (menu) {
                        case "1" -> {
                            try {
                                service.subir();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Elevador subindo!
                                    Andar atual: %d""", service.andarAtual()), "Subindo", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        case "2" -> {
                            try {
                                service.descer();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Elevador descendo!
                                    Andar atual: %d""", service.andarAtual()), "Descendo", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        case "3" -> {
                            try {
                                service.entrar();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Entrando um passageiro.
                                    Cuidado com o vao do elevador e o andar!
                                    Total de passageiros: %d""", service.passageirosPresentes()), "Entrando", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        case "4" -> {
                            try {
                                service.sair();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Saindo um passageiro.
                                    Cuidado com o vao do elevador e o andar!
                                    Total de passageiros: %d""", service.passageirosPresentes()), "Saindo", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }

            }
        }
    }
}
