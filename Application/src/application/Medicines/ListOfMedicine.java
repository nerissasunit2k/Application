/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.Medicines;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author 2ndyrGroupB
 */

public class ListOfMedicine {
private ArrayList<Medicine> ListOfMedicine = new ArrayList();

    public ListOfMedicine() {
    }

    public ArrayList< Medicine> getMedicineList() {
        return ListOfMedicine;
    }

    public void setMedicineList(ArrayList< Medicine> medicineList) {
        this.ListOfMedicine = medicineList;
    }

    @Override
    public String toString() {
        return ListOfMedicine.toString();
    }

    public void addMedicineList(Medicine medicine) {
        this.ListOfMedicine.add(medicine);
    }

    public boolean isMedicinePresent(String med) {
        boolean ans = false;
        for (Medicine elem : ListOfMedicine) {
            if (med.equals(elem.getProduct().getName())) {
                ans = true;
                System.out.println("AVAILABLE!");
                break;
            }
        }
        return ans;
    }

    public void itemList() {
        Iterator itr = ListOfMedicine.iterator();
        if (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public void viewAlergiesMed() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tALLERGY MEDICINES");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Medicine med : ListOfMedicine) {
            if (med instanceof Allergies) {
                System.out.println(med);
            }
        }
        System.out.println("\n\n");
    }

    public void viewBodyPainMed() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tBODY PAIN MEDICINES");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Medicine med : ListOfMedicine) {
            if (med instanceof BodyPain) {
                System.out.println(med);
            }
        }
        System.out.println("\n\n");
    }

    public void viewCoughMed() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tCOUGH MEDICINES");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Medicine med : ListOfMedicine) {
            if (med instanceof Cough) {
                System.out.println(med);
            }
        }
        System.out.println("\n\n");
    }

    public void viewHeadAcheMed() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tHEADACHE MEDICINES");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Medicine med : ListOfMedicine) {
            if (med instanceof Headache) {
                System.out.println(med);
            }
        }
        System.out.println("\n\n");
    }

    public void viewList() {
        System.out.println("==========================================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\tMEDICINES IN THE PHARMACY");
        System.out.println("==========================================================================================================================================================================");
        viewAlergiesMed();
        viewBodyPainMed();
        viewCoughMed();
        viewHeadAcheMed();
        System.out.println("==========================================================================================================================================================================\n\n\n\n");

    }

    public void removeMed(String string) {

        for (Medicine med : ListOfMedicine) {

            if (string.equals(med.getProduct().getName())) {
                ListOfMedicine.remove(med);
                System.out.println("You have removed a medicine in a pharmacy!");
                break;
            }
        }
    }

    public void updateName(String med, String name) {

        for (Medicine elem : ListOfMedicine) {
            if (med.equals(elem.getProduct().getName())) {
                elem.getProduct().setName(name);
                System.out.println("AVAILABLE!");
                break;
            }
        }

    }

    public void updateBrand(String med, String name) {

        for (Medicine elem : ListOfMedicine) {
            if (med.equals(elem.getProduct().getName())) {
                elem.setBrandName(name);
                System.out.println("AVAILABLE!");
                break;
            }
        }

    }

    public void updateGeneric(String med, String name) {

        for (Medicine elem : ListOfMedicine) {
            if (med.equals(elem.getProduct().getName())) {
                elem.setGenericName(name);
                System.out.println("AVAILABLE!");
                break;
            }
        }

    }

    public void updatePrice(String med, double price) {

        for (Medicine elem : ListOfMedicine) {
            if (med.equals(elem.getProduct().getName())) {
                elem.getProduct().setPrice(price);
                System.out.println("AVAILABLE!");
                break;
            }
        }

    }

    public void updateQuantity(String med, int quan) {

        for (Medicine elem : ListOfMedicine) {
            if (med.equals(elem.getProduct().getName())) {
                elem.getProduct().setQuantity(quan);
                System.out.println("AVAILABLE!");
                break;
            }
        }

    }

}
