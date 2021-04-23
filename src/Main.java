import java.util.Queue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
//import java.util.Queue;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.*;
import java.util.prefs.BackingStoreException;

/**
 *
 * Main class with reading file part
 * @author Anatoly Novikov
 * @version 1.1
 * new lab: 331137
 *
 */
public class Main {
    /**
     * converts string to enum
     * @param s string
     * @return form of education
     */
    public static StudyGroup.FormOfEducation findEnum1(String s) {
        s = s.toUpperCase();
        StudyGroup.FormOfEducation command = null;
        for (int i = 0; i < StudyGroup.FormOfEducation.values().length; i++) {
            if (s.equals(StudyGroup.FormOfEducation.values()[i].toString())) {
                command = StudyGroup.FormOfEducation.values()[i];
            }
        }
        return command;
    }
    /**
     * converts string to enum
     * @param s string
     * @return color
     */
    public static StudyGroup.Color findEnum3(String s) {
        s = s.toUpperCase();
        StudyGroup.Color command = null;
        for (int i = 0; i < StudyGroup.Color.values().length; i++) {
            if (s.equals(StudyGroup.Color.values()[i].toString())) {
                command = StudyGroup.Color.values()[i];
            }
        }
        return command;
    }
    /**
     * converts string to enum
     * @param s string
     * @return semester
     */
    public static StudyGroup.Semester findEnum2(String s) {
        s = s.toUpperCase();
        StudyGroup.Semester command = null;
        for (int i = 0; i < StudyGroup.Semester.values().length; i++) {
            if (s.equals(StudyGroup.Semester.values()[i].toString())) {
                command = StudyGroup.Semester.values()[i];
            }
        }
        return command;
    }
    /**
     * converts string to int
     * @param str
     * @return count of students int
     */
    static Integer toStudentsCount(String str) {
        str = str.trim();
        Integer n;
        try {
            n = Integer.valueOf(str);
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }
    /**
     *converts string to long
     * @param str
     * @return long
     */
    static Long toLocation(String str) {
        str = str.trim();

        try {
            Long x = Long.valueOf(str);
            return x;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * converts string to int
     * @param str
     * @return int
     */
    static int toExpelledStudents(String str) {
        str = str.trim();
        int n = 0;
        try {
            n = Integer.valueOf(str);
        } finally {
            return n;
        }
    }
    /**
     * converts string to float
     * @param str
     * @return float
     */
    static Float toCoordinatesX(String str) {
        str = str.trim();

        try {
            float x = Float.valueOf(str);
            return x;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * converts string to int
     * @param str
     * @return int
     */
    static Integer toCoordinatesY(String str) {
        str = str.trim();
        //String[] words = str.split(" ");
        //System.out.println(str);

        try {
            int y = Integer.valueOf(str);
            //int y = Integer.valueOf(words[1]);
            //System.out.println(x);
            //System.out.println(y);
            //StudyGroup.Coordinates coord = new StudyGroup.Coordinates();
            //coord.setX(x);
            //coord.setY(y);
            //coord.x = x;
            return y;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * check value
     * @param o
     * @return boolean
     */
    static boolean isExpelledStudents(int o) {
        if (o > 0) {
            return true;
        } else return false;
    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalStudentsCount(int o) {
        if (o > 0) {
            return true;
        } else return false;
    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalCoordinates(StudyGroup.Coordinates o) {
        //String s = "";
        try {
            if (o.getY() != null && o.getX() != null) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }

    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalName(String o) {
        try {
            o = o.trim();
            //System.out.println(o);
            if (o != null && o != "" && o.length() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * check value
     * @param o
     * @return
     */
    static boolean isNormalEnum(Object o) {
        if (o != null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * check value
     * @param l
     * @return
     */
    static boolean isNormalLocation(StudyGroup.Location l) {
        if (l.getX() != null && l.getY() != null && l.getZ() != null && l.getName() != null) {
            return true;
        } else return false;
    }
    /**
     * all stuff here
     *
     * @return
     */
    public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException {
        //Queue<StudyGroup> Collection = new PriorityQueue<>();
        Collection collection = new Collection();

        Scanner in = new Scanner(System.in);
        Enter now;


        //String dir = "C:/Users/DELL/Documents/Laba5";
        //String path = "file1.xml";
        //File file = new File(path);
        boolean init = true;

        try {
            now = Enter.ERROR;

            String path;
            String dir = null;
            boolean argCheckStart = false;
            while(now!=Enter.EXIT) {
                try{
                    boolean argCheck = false;
                try{if(!argCheckStart){
                    path = args[0];
                    //dir = null;
                    argCheck = true;
                    argCheckStart = true;
                } else if(now == Enter.FATAL_ERROR){
                    in.close();
                    path = null;
                }
                else throw new IndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e){
                    //System.out.println(args[1]);
                    System.out.print("Enter file name ");
                    path = in.nextLine();
                    System.out.print("Enter file directory ");
                    dir = in.nextLine();}
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = f.newDocumentBuilder();
            NodeList nList;
            if (argCheck) {
                Document doc = builder.parse(new File(path));
                doc.getDocumentElement().normalize();
                nList = doc.getElementsByTagName("StudyGroup");
            }else {
                Document doc = builder.parse(new File(dir,path));
                doc.getDocumentElement().normalize();
                nList = doc.getElementsByTagName("StudyGroup");}

            collection.adress1 = dir;
            collection.adress2 = path;
            System.out.println("File exists!");




            String student;
            //String name;
            StudyGroup.Color color;
            StudyGroup.Coordinates coord = new StudyGroup.Coordinates();
            StudyGroup.Person person = new StudyGroup.Person();
            Integer studentsCount;
            Integer expelledStudents;
            StudyGroup.Location location = new StudyGroup.Location();
            Integer x = 0;
            StudyGroup.Color colorHair;
            StudyGroup.FormOfEducation education;
            StudyGroup.Semester sem;
            //collection.time = collection.time.toOffsetDateTime().toZonedDateTime();
            boolean check = false;
            int i = 0;
            for (i = 0; i < nList.getLength(); i++) {
                try {
                    check = false;

                    StudyGroup Group = new StudyGroup();
                    Node nNode = nList.item(i);
                    Group.setID(i + 1);
                    Element eElement = (Element) nNode;
                    student = eElement.getElementsByTagName("Name").item(0).getTextContent();
                    person.setName(eElement.getElementsByTagName("Name").item(1).getTextContent());
                    location.setLocation(toLocation(eElement.getElementsByTagName("x").item(1).getTextContent()), toLocation(eElement.getElementsByTagName("y").item(1).getTextContent()), toLocation(eElement.getElementsByTagName("z").item(0).getTextContent()), eElement.getElementsByTagName("name").item(0).getTextContent());
                    colorHair = Main.findEnum3(eElement.getElementsByTagName("HairColor").item(0).getTextContent());
                    color = Main.findEnum3(eElement.getElementsByTagName("EyeColor").item(0).getTextContent());
                    education = Main.findEnum1(eElement.getElementsByTagName("FormOfEducation").item(0).getTextContent());
                    sem = Main.findEnum2(eElement.getElementsByTagName("SemesterEnum").item(0).getTextContent());
                    coord.setX(Main.toCoordinatesX(eElement.getElementsByTagName("x").item(0).getTextContent()));
                    coord.setY(Main.toCoordinatesY(eElement.getElementsByTagName("y").item(0).getTextContent()));
                    studentsCount = Main.toStudentsCount(eElement.getElementsByTagName("StudentsCount").item(0).getTextContent());

                    expelledStudents = Main.toExpelledStudents((eElement.getElementsByTagName("ExpelledStudents").item(0).getTextContent()));
                    if (Main.isNormalEnum(sem)) {
                        Group.setSemesterEnum(sem);
                    } else check = true;
                    if (Main.isNormalEnum(education)) {
                        Group.setFormOfEducation(education);
                    } else check = true;
                    if (Main.isNormalEnum(color)) {
                        person.setEyeColor(color);
                    } else check = true;
                    if (Main.isNormalEnum(colorHair)) {
                        person.setHairColor(colorHair);
                    } else check = true;
                    if (Main.isNormalName(student)) {
                        Group.setName(student);
                    } else check = true;
                    if (Main.isNormalCoordinates(coord)) {
                        Group.setCoordinates(coord);
                    } else check = true;
                    if (Main.isNormalStudentsCount(studentsCount)) {
                        Group.setStudentsCount(studentsCount);
                    } else check = true;
                    if (Main.isExpelledStudents(expelledStudents)) {
                        Group.setExpelledStudents(expelledStudents);
                    } else check = true;
                    if (Main.isNormalLocation(location)) {
                        person.setLocation(location);
                    } else check = true;
                    if (person != null) {
                        Group.setGroupAdmin(person);
                    } else check = true;
                    if (check != true) {
                        collection.add(Group);
                        init = true;
                    } else System.out.println("Sorry, part of XML is not readable");
                } catch (NullPointerException e) {
                    //check = true;
                    System.out.println("Sorry, part of XML is not readable");
                }
            }
        } catch (Exception e) {
            init = false;
            System.out.println("No such file");
            throw new Exception("");
        }
        int num = collection.Collection.size();
        if (init) {
            boolean recursionCheck = false;
            while (now != Enter.EXIT && now != Enter.FATAL_ERROR) {
                try {
                    if (!recursionCheck) {
                        System.out.print("Enter your commands here ");

                        String str = in.nextLine();
                        now = Scaner.scan(str);
                        if (now == Enter.ADD) {
                            StudyGroup group = collection.addElement();
                            group.setID(num + 1);
                            num += 1;
                            collection.Collection.add(group);
                        }
                        if (now == Enter.SHOW) {
                            StudyGroup clt[] = new StudyGroup[collection.Collection.size()];
                            int n = collection.Collection.size();
                            for (int i = 0; i < n; i++) {
                                clt[i] = collection.Collection.remove();
                                System.out.println(clt[i]);
                            }
                            for (int i = 0; i < n; i++) {
                                collection.Collection.add(clt[i]);
                            }
                        }

                        if (now == Enter.EXIT) {
                            break;
                        }
                        if (now == Enter.CLEAR) {
                            int n = collection.Collection.size();
                            for (int i = 0; i < n; i++) {
                                collection.Collection.remove();
                            }
                            System.out.println("Collection was cleared successfully");
                        }
                        if (now == Enter.ERROR) {
                            System.out.println("Try help");
                        }
                        if (now == Enter.UPDATE) {
                            System.out.println("Please enter id");
                            Scanner scanner = new Scanner(System.in);
                            try {
                                int id = toStudentsCount(scanner.nextLine());
                                StudyGroup clt[] = new StudyGroup[collection.Collection.size()];
                                int n = collection.Collection.size();
                                for (int i = 0; i < n; i++) {
                                    clt[i] = collection.Collection.remove();
                                    if ((clt[i].get_id() == id)) {
                                        clt[i] = collection.addElement();
                                        clt[i].setID(id);
                                    }
                                }
                                for (int i = 0; i < n; i++) {
                                    collection.Collection.add(clt[i]);
                                }
                            } catch (Exception e) {
                                System.out.println("Something gone wrong");
                            }

                        }
                        if (now == Enter.REMOVE_ID) {
                            System.out.println("Please enter id");
                            Scanner scanner = new Scanner(System.in);
                            try {
                                int id = toStudentsCount(scanner.nextLine());
                                StudyGroup clt[] = new StudyGroup[collection.Collection.size()];
                                int n = collection.Collection.size();
                                for (int i = 0; i < n; i++) {
                                    clt[i] = collection.Collection.remove();
                                }
                                for (int i = 0; i < n; i++) {
                                    if (clt[i].get_id() != id) {
                                        collection.Collection.add(clt[i]);
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Something gone wrong");
                            }

                        }
                        if (now == Enter.EXECUTE) {
                            System.out.print("Enter file name ");
                            String fname = in.nextLine();
                            System.out.print("Enter directory of the file ");
                            String fpath = in.nextLine();
                            FileReader fr = new FileReader(fpath+"/"+fname);
                            Scanner scanner = new Scanner(fr);
                            String string;
                            Enter scan;

                            while (scanner.hasNext()) {
                                string = scanner.nextLine();
                                scan = Scaner.scan(string);
                                //System.out.println(string);
                                if (scan == Enter.SHOW) {
                                    collection.show();
                                }
                                if (scan == Enter.SAVE) {
                                    Collection.dataBasetoXML(collection.collectionToString(), collection.adress1, collection.adress2);
                                }
                                if (scan == Enter.PRINT) {
                                    collection.print_unique();
                                }
                                if (scan == Enter.MIN) {
                                    StudyGroup clt[] = new StudyGroup[collection.Collection.size()];
                                    int n = collection.Collection.size();
                                    int id = 1;
                                    for (int i = 0; i < n; i++) {
                                        clt[i] = collection.Collection.remove();
                                        if (i > 0) {
                                      ///      System.out.println(clt[id].compareTo(clt[i - 1]));
                                            if (clt[id].compareTo(clt[i - 1]) < 0) {
                                                id = i - 1;
                                            }

                                        }

                                    }
                                    //System.out.println(clt[id]);
                                    for (int i = 0; i < n; i++) {
                                        collection.Collection.add(clt[i]);
                                    }
                                } if (scan == Enter.REMOVE_G){
                                    int n = Integer.valueOf(scanner.nextLine());
                                    collection.remove_greater(n);
                                } if (scan == Enter.REMOVE_L){
                                    int n = Integer.valueOf(scanner.nextLine());
                                    collection.remove_lower(n);
                                } if (scan == Enter.REMOVE_ID){
                                    int n = Integer.valueOf(scanner.nextLine());
                                    collection.remove_by_ID(n);
                                } if (scan == Enter.ADD){
                                    collection.add(collection.addFromFile(scanner));
                                } if (scan == Enter.ADD_MIN){
                                    StudyGroup group = collection.addFromFile(scanner);

                                    collection.add_if_lowest(group);
                                } if (scan == Enter.UPDATE){
                                    //int id = Integer.valueOf(scanner.nextLine());
                                    try {
                                        int id = toStudentsCount(scanner.nextLine());
                                        StudyGroup clt[] = new StudyGroup[collection.Collection.size()];
                                        int n = collection.Collection.size();
                                        for (int i = 0; i < n; i++) {
                                            clt[i] = collection.Collection.remove();
                                            if ((clt[i].get_id() == id)) {
                                                clt[i] = collection.addFromFile(scanner);
                                                clt[i].setID(n+1);
                                                n+=1;

                                            }
                                        }
                                        for (int i = 0; i < n; i++) {
                                            collection.Collection.add(clt[i]);
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Something gone wrong");
                                    }
                                } if (scan == Enter.CLEAR){
                                    int lt = collection.Collection.size();
                                    for (int i = 0; i<lt;i++){
                                        collection.Collection.remove();
                                    }
                                }
                            } fr.close();
                        }
                    if (now == Enter.ADD_MIN) {
                        StudyGroup group = collection.addElement();
                        collection.add_if_lowest(group);
                    }
                    if (now == Enter.PRINT) {
                        collection.print_unique();
                    }
                    if (now == Enter.INFO){
                        System.out.println("Collection type: priority queue, " + collection.Collection.size());//+" "+collection.time.toString());
                    }
                    if (now == Enter.MIN) {
                        StudyGroup clt[] = new StudyGroup[collection.Collection.size()];
                        int n = collection.Collection.size();
                        int id = 1;
                        for (int i = 0; i < n; i++) {
                            clt[i] = collection.Collection.remove();
                            if (i > 0) {
                                //System.out.println(clt[id].compareTo(clt[i - 1]));
                                if (clt[id].compareTo(clt[i - 1]) < 0) {
                                    id = i - 1;
                                }

                            }

                        }
                        //System.out.println(clt[id]);
                        for (int i = 0; i < n; i++) {
                            collection.Collection.add(clt[i]);
                        }
                    }
                    if (now == Enter.REMOVE_G) {
                        System.out.print("Enter ID ");
                        Scanner scanner = new Scanner(System.in);
                        try {
                            int id = toStudentsCount(scanner.nextLine());
                            collection.remove_greater(id);
                        } catch (Exception e) {
                            System.out.println("Something is wrong");
                        }
                    }
                    if (now == Enter.REMOVE_L) {
                        System.out.print("Enter ID ");
                        Scanner scanner = new Scanner(System.in);
                        try {
                            int id = toStudentsCount(scanner.nextLine());
                            collection.remove_greater(id);
                        } catch (Exception e) {
                            System.out.println("Something is wrong");
                        }
                    }
                    if (now == Enter.FILTER) {
                        System.out.print("Enter name ");
                        Scanner scanner = new Scanner(System.in);
                        str = scanner.nextLine();
                        collection.contain_name(str);
                    }
                    if (now == Enter.SAVE) {
                        System.out.println("Are you sure? ");
                        String string = in.nextLine();
                        //System.out.println(string);
                        if (string.equals("yes")) {
                            System.out.println("Enter file name");
                            collection.adress2 = in.nextLine();
                            System.out.println("Enter file directory");
                            collection.adress1 = in.nextLine();
                            Collection.dataBasetoXML(collection.collectionToString(), collection.adress1, collection.adress2);
                            System.out.println("Collection saved");
                        }//System.out.println(collection.collectionToString());
                        else{System.out.println("okay, try next time");}

                    }
                } else {
                        recursionCheck = true;

                    }    //} catch (java.util.NoSuchElementException e) { }

            } catch(java.util.NoSuchElementException e){
                now = Enter.FATAL_ERROR;
                System.out.println();
            }
            recursionCheck = false;
        }
    }
    }}catch (Error e){}
catch (Exception e){}}
}


