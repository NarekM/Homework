package com.epam.homework.maps.studentcounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {
    public Map<Student, Integer> count(List<Student> students) {
        HashMap<Student, Integer> studentMap = new HashMap<>();
        for (Student student : students) {
            Integer count = studentMap.get(student);
            if (count == null) {
                studentMap.put(student, 1);
            } else {
                studentMap.put(student, ++count);
            }
        }
        return studentMap;
    }

    public Map<Faculty, Integer> countStudentsInFaculties(List<Student> students) {
        Map<Faculty, Integer> facultyMap = new HashMap<>();
        for (Student student : students) {
            Faculty faculty = student.getFaculty();
            Integer count = facultyMap.get(faculty);
            if (count == null) {
                facultyMap.put(faculty, 1);
            } else {
                facultyMap.put(faculty, ++count);
            }
        }
        return facultyMap;
    }
}
