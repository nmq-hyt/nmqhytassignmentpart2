package org.nmqhyt2;
import org.nmqhyt.Student;
import org.nmqhyt.Module;
import org.nmqhyt.Lecturer;
import org.nmqhyt.Programme;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Lecturer drSmith = new Lecturer("John Smith",new DateTime(1978,5,4,12,30),123, new ArrayList<Module>(),44);
        Lecturer drSalmonella = new Lecturer("Meryl Salmonella",new DateTime(1986,5,4,12,30),215, new ArrayList<Module>(),44);
        Student studentOne = new Student("Armitage Pilgrimage",new DateTime(),1,19,"Chemistry","2",null);
        Student studentTwo = new Student("Jovanius Dirge",new DateTime(),1,21,"Accounting","2",null);

        ArrayList<Module> studOneModules = new ArrayList<>();
        ArrayList<Module> studTwoModules = new ArrayList<>();
        studentOne.setRegisteredModules(studOneModules);
        studentTwo.setRegisteredModules(studTwoModules);

        ArrayList<Module> chemModules = new ArrayList<Module>();
        ArrayList<Student> chemStudents = new ArrayList<Student>();
        ArrayList<Module> accModules = new ArrayList<Module>();
        ArrayList<Student> accStudents = new ArrayList<Student>();

        ArrayList<Lecturer> chemLect = new ArrayList<Lecturer>();
        ArrayList<Lecturer> accLect = new ArrayList<Lecturer>();
        chemLect.add(drSmith);
        accLect.add(drSalmonella);

        chemStudents.add(studentOne);
        accStudents.add(studentTwo);

        Module organicChemistry = new Module("Organic Chemistry",chemStudents,null,chemLect);
        Module businessLaw = new Module("Business Law",accStudents,null,accLect);
        Module labHours = new Module("Laboratory Hours",chemStudents,null,chemLect);
        Module financialAccounting = new Module("Financial Accounting",accStudents,null,accLect);

        studentOne.getRegisteredModules().add(organicChemistry);
        studentOne.getRegisteredModules().add(labHours);
        studentTwo.getRegisteredModules().add(financialAccounting);
        studentTwo.getRegisteredModules().add(businessLaw);

        accModules.add(businessLaw);
        accModules.add(financialAccounting);
        chemModules.add(organicChemistry);
        chemModules.add(labHours);
        
        Programme firstSemChem = new Programme("First Semester Chemistry",chemStudents,new DateTime(2020,1,10,9,0),new DateTime(2020,5,20,9,0));
        Programme secondSemAcc = new Programme("First Semester Accounting",accStudents,firstSemChem.getStartDate(), firstSemChem.getEndDate());

        ArrayList<Programme> chemProgramme = new ArrayList<>();
        chemProgramme.add(firstSemChem);
        ArrayList<Programme> accProgramme = new ArrayList<>();
        accProgramme.add(secondSemAcc);

        for (Module e : chemModules) {
            System.out.print(e.getModuleName());
            System.out.print(e.getListOfLecturers());
            System.out.print(e.getListOfAssociatedCourses());
            System.out.print(e.getListOfStudents());
        }
        for (Module e : accModules) {
            System.out.print(e.getModuleName());
            System.out.print(e.getListOfLecturers());
            System.out.print(e.getListOfAssociatedCourses());
            System.out.print(e.getListOfStudents());
        }
        for (Student e : chemStudents) {
            System.out.println(e.getUsername());
            System.out.println(e.getCourse());
            System.out.println(e.getRegisteredModules());
        }
        for (Student e : accStudents) {
            System.out.println(e.getUsername());
            System.out.println(e.getCourse());
            System.out.println(e.getRegisteredModules());
        }
    }
}