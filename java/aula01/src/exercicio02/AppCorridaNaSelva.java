package exercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppCorridaNaSelva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int optionMenu = 0;

        List<Participant> listOfParticipants = new ArrayList<>();
        List<Categories> listOfCircuits = new ArrayList<>();

        listOfCircuits.add(new Categories(1, "Short circuit"));
        listOfCircuits.add(new Categories(2, "Medium circuit"));
        listOfCircuits.add(new Categories(3, "Advanced circuit"));

        do {
            //menu
            System.out.println("----------- JUNGLE'S RUNNING -----------");
            System.out.println("Choose an option:");
            System.out.println("1 - Register a participant;");
            System.out.println("2 - Show all participants;");
            System.out.println("3 - Unsubscribe a participant;");
            System.out.println("4 - Cancel operation;");

            System.out.println("Insert a desired option: ");
            optionMenu = Integer.parseInt(sc.nextLine());

            switch (optionMenu) {
                case 1:
                    int id = listOfParticipants.size() + 1;
                    listOfParticipants.add(newParticipant(id, listOfCircuits));
                    break;
                case 2:
                    for (Participant p : listOfParticipants) { // para cada p (participante) da lista de participante, faça...
                        System.out.println(p);
                    }
                    break;
                case 3:
                    int idToRemove;
                    System.out.println("Insert id of participant you wish to unsubscribe");
                    idToRemove = Integer.parseInt(sc.nextLine());

                    listOfParticipants.remove(idToRemove - 1);

                    System.out.println("Participant unsubscribed.");
                    break;
            }
        } while (optionMenu != 4);
    }

    public static Participant newParticipant(int id, List<Categories> circuits) {
        Participant participant = new Participant();
        Categories circuit = new Categories();
        Scanner sc = new Scanner(System.in);

        participant.setIdParticipant(id);
        System.out.print("Insert the participant's RG: ");
        participant.setRG(sc.nextLine());
        System.out.print("Insert the participant's name: ");
        participant.setName(sc.nextLine());
        System.out.print("Insert the participant's surname: ");
        participant.setSurname(sc.nextLine());
        System.out.print("Insert the participant's age: ");
        participant.setAge(Integer.parseInt(sc.nextLine()));
        System.out.print("Insert the participant's cellphone number: ");
        participant.setCelNumber(sc.nextLine());
        System.out.print("Insert the participant's emercengy number: ");
        participant.setEmergencyNumber(sc.nextLine());
        System.out.print("Insert the participant's blood group: ");
        participant.setBloodGroup(sc.nextLine());

        System.out.print("Insert the participant's category: ");
        System.out.println("------- CATEGORIES -------");
        System.out.println("1 - Short circuit;");
        System.out.println("2 - Medium circuit;");
        System.out.println("3 - Advanced circuit;");
        System.out.println("--------------------------");
        System.out.println("Choose a category: ");

        int optionCategory = Integer.parseInt(sc.nextLine());
        participant.setCircuit(circuits.get(optionCategory - 1));
        participant.calculate();

        return participant;
    }
}
