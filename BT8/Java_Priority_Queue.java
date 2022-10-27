package BT8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
     
    Student() {
         
    }
    Student(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
     
    public int getID() {
         return id;
    }
    public String getName() {
         return name;
     }
    public double getCGPA() {
        return cgpa;
    }
    
    @Override
    public int compareTo(Student other) {
        if (cgpa > other.cgpa) return -1;
        if (cgpa < other.cgpa) return 1;
        if (name.compareTo(other.name) > 0) return 1;
        if (name.compareTo(other.name) < 0) return -1;
        return Integer.compare(id, other.id);
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>();
        for (String eachEvent : events) {
            String[] s = eachEvent.split(" ");
            if (s.length > 1) {
                Student student = new Student(s[1], Double.valueOf(s[2]), Integer.valueOf(s[3]));
                pq.add(student);
            }
            else {
                pq.poll();
            }
        }
        while (pq.size() > 1) {
            System.out.println(pq.poll().getName());
        }
        List<Student> result = new ArrayList<>(pq);
        return result;
    }
}


public class Java_Priority_Queue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}