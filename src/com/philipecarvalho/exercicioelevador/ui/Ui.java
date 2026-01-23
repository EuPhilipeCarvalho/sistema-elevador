package com.philipecarvalho.exercicioelevador.ui;

import com.philipecarvalho.exercicioelevador.domain.Elevator;
import com.philipecarvalho.exercicioelevador.service.ElevatorService;
import javax.swing.JOptionPane;

/** Essa classe serve para entrada de dados;
 * Experiencia do usuario;
 * E interfaces.
 */
public class Ui {
    public static void main(String[] args) {
        while (true) {
            String reception = JOptionPane.showInputDialog(null, """
                    Bem-vindo ao elevador Phil's High!
                    Escolha:
                    
                    1. Entrar
                    0. Sair""", "Ola!", JOptionPane.QUESTION_MESSAGE);
            if (reception==null || reception.equals("0")) {
                JOptionPane.showMessageDialog(null, "Finalizando o sistema!", "Tchau!", JOptionPane.WARNING_MESSAGE);
                break;
            }
            if (!reception.equals("1")) {
                JOptionPane.showMessageDialog(null, "Escolha uma das alternativas!", "Ops!", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            //Entrou
            while(true){
                //Inserir a capacidade maxima do elevador
                String capacity = JOptionPane.showInputDialog(null, """
                        Insira o total de passageiros permitidos:
                        (Clique em "cancelar: ou deixe vazio
                        para retornar.)""", "Capacidade", JOptionPane.QUESTION_MESSAGE);
                if (capacity==null || capacity.isEmpty()) break;

                int totalCapacity;
                try {
                    totalCapacity = Integer.parseInt(capacity);
                    if (totalCapacity <= 0) {
                        throw new NumberFormatException("Capacidade deve ser maior que zero!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Ops!", JOptionPane.WARNING_MESSAGE);
                    continue;
                }

                String maxFloors = JOptionPane.showInputDialog(null, """
                        Insira o total de andares no prédio:
                        (Clique em "cancelar: ou deixe vazio
                        para retornar.)""", "Total de Andares", JOptionPane.QUESTION_MESSAGE);
                if (maxFloors==null || maxFloors.isEmpty()) break;

                int totalFloors;
                try {
                    totalFloors = Integer.parseInt(maxFloors);
                    if (totalFloors <= 0) {
                        throw new NumberFormatException("O total de andares deve ser maior que zero!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Ops!", JOptionPane.WARNING_MESSAGE);
                    continue;
                }



                //Tudo certo
                Elevator elevator = new Elevator(totalCapacity, totalFloors);
                ElevatorService service = new ElevatorService(elevator);

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
                                service.up();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Elevador subindo!
                                    Andar atual: %d""", service.floors()), "Subindo", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        case "2" -> {
                            try {
                                service.down();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Elevador descendo!
                                    Andar atual: %d""", service.floors()), "Descendo", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        case "3" -> {
                            try {
                                service.enter();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Entrando um passageiro.
                                    Cuidado com o vao do elevador e o andar!
                                    Total de passageiros: %d""", service.passengers()), "Entrando", JOptionPane.INFORMATION_MESSAGE);
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                        case "4" -> {
                            try {
                                service.leave();
                                JOptionPane.showMessageDialog(null, String.format("""
                                    Saindo um passageiro.
                                    Cuidado com o vao do elevador e o andar!
                                    Total de passageiros: %d""", service.passengers()), "Saindo", JOptionPane.INFORMATION_MESSAGE);
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